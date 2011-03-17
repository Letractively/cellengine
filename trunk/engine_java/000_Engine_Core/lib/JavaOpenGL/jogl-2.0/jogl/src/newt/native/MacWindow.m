/*
 * Copyright (c) 2009 Sun Microsystems, Inc. All Rights Reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 * 
 * - Redistribution of source code must retain the above copyright
 *   notice, this list of conditions and the following disclaimer.
 * 
 * - Redistribution in binary form must reproduce the above copyright
 *   notice, this list of conditions and the following disclaimer in the
 *   documentation and/or other materials provided with the distribution.
 * 
 * Neither the name of Sun Microsystems, Inc. or the names of
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 * 
 * This software is provided "AS IS," without a warranty of any kind. ALL
 * EXPRESS OR IMPLIED CONDITIONS, REPRESENTATIONS AND WARRANTIES,
 * INCLUDING ANY IMPLIED WARRANTY OF MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE OR NON-INFRINGEMENT, ARE HEREBY EXCLUDED. SUN
 * MICROSYSTEMS, INC. ("SUN") AND ITS LICENSORS SHALL NOT BE LIABLE FOR
 * ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR
 * DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES. IN NO EVENT WILL SUN OR
 * ITS LICENSORS BE LIABLE FOR ANY LOST REVENUE, PROFIT OR DATA, OR FOR
 * DIRECT, INDIRECT, SPECIAL, CONSEQUENTIAL, INCIDENTAL OR PUNITIVE
 * DAMAGES, HOWEVER CAUSED AND REGARDLESS OF THE THEORY OF LIABILITY,
 * ARISING OUT OF THE USE OF OR INABILITY TO USE THIS SOFTWARE, EVEN IF
 * SUN HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGES.
 * 
 */

#import <inttypes.h>

#import "com_sun_javafx_newt_macosx_MacWindow.h"
#import "NewtMacWindow.h"

#import "EventListener.h"
#import "MouseEvent.h"
#import "KeyEvent.h"

#import <ApplicationServices/ApplicationServices.h>

#import <stdio.h>

@implementation ScreenChangeObserver

- (id) initWithEnv: (JNIEnv*) theEnv
{
    self = [super init];
    if (self) {
        env = theEnv;
        NSNotificationCenter *center = [NSNotificationCenter defaultCenter];
        [center addObserver:self
                   selector:@selector(screenParametersDidChange:)
                       name:NSApplicationDidChangeScreenParametersNotification
                     object:nil];
    }
    return self;
}

- (void) screenParametersDidChange: (NSNotification*) notification
{
    jclass clazz = 
        (*env)->FindClass(env,
                          "com/sun/javafx/newt/macosx/MacScreensInfo");
    if (clazz != NULL) {
        jmethodID getInstanceMID =
            (*env)->GetStaticMethodID(env, clazz, "getInstance", 
                                      "()Lcom/sun/javafx/newt/ScreensInfo;");
        jmethodID initDataMID =
            (*env)->GetMethodID(env, clazz, "initScreens", "()V");
        if (initDataMID != NULL && getInstanceMID != NULL) {
            jobject wsi = (*env)->CallStaticObjectMethod(env, clazz, 
                                                         getInstanceMID);
            if (wsi != NULL) {
                (*env)->CallVoidMethod(env, wsi, initDataMID);
            }
        }
    }
}

@end

NSString* jstringToNSString(JNIEnv* env, jstring jstr)
{
    const jchar* jstrChars = (*env)->GetStringChars(env, jstr, NULL);
    NSString* str = [[NSString alloc] initWithCharacters: jstrChars length: (*env)->GetStringLength(env, jstr)];
    (*env)->ReleaseStringChars(env, jstr, jstrChars);
    return str;
}

void setFrameTopLeftPoint(NSWindow* pwin, NSWindow* win, jint x, jint y)
{
    NSScreen *screen = (NSScreen *) [ [NSScreen screens] objectAtIndex: 0];

    // this allows for better compatibility with awt behavior
    NSRect visibleRect; // either screen or parent-window 
    NSPoint pt;
    int d_pty=0; // parent titlebar height
    
    if(NULL==pwin) {
        visibleRect = [screen frame];
    } else {
        visibleRect = [pwin frame];

        NSView* pview = [pwin contentView];
        NSRect viewRect = [pview frame];
        d_pty = visibleRect.size.height - viewRect.size.height;
    }

    pt = NSMakePoint(visibleRect.origin.x + x, visibleRect.origin.y + visibleRect.size.height - y - d_pty);

    [win setFrameTopLeftPoint: pt];
}

static CGFloat getMinWidth(NSWindow *window) {
    CGFloat w = 0;
    if ([window styleMask] != NSBorderlessWindowMask) {
        NSString * str = @"";
        w = [NSWindow minFrameWidthWithTitle : str
                             styleMask : [window styleMask]];
    }
    if (w <= 0) {
        w = 1.0f;
    }
    return w;
}

static NewtView * changeContentView(JNIEnv *env, jobject javaWindowObject, NSWindow *pWin, NSWindow *win, NewtView *newView) {
    NSView* oldNSView = [win contentView];
    NewtView* oldView = NULL;

    if(NULL!=oldNSView) {
NS_DURING
        // Available >= 10.5 - Makes the menubar disapear
        if([oldNSView isInFullScreenMode]) {
            [oldNSView exitFullScreenModeWithOptions: NULL];
        }
NS_HANDLER
NS_ENDHANDLER
        if( [oldNSView isMemberOfClass:[NewtView class]] ) {
            oldView = (NewtView *) oldNSView;

            jobject globJavaWindowObject = [oldView getJavaWindowObject];
            (*env)->DeleteGlobalRef(env, globJavaWindowObject);
            [oldView setJavaWindowObject: NULL];
        }
        /** FIXME: Tried child window: auto clip or message reception ..
        if(NULL!=pwin) {
            [oldView removeFromSuperview];
        } */
    }
    if(NULL!=newView) {
        jobject globJavaWindowObject = (*env)->NewGlobalRef(env, javaWindowObject);
        [newView setJavaWindowObject: globJavaWindowObject];
        [newView setJNIEnv: env];

        /** FIXME: Tried child window: auto clip or message reception ..
        if(NULL!=pwin) {
            NSView* pview = [pwin contentView];
            [pview addSubview: newView];
        } */
    }
    [win setContentView: newView];

    // make sure the insets are updated in the java object
    NewtMacWindow* newtw = (NewtMacWindow*)win;
    [newtw updateInsets: env];

    return oldView;
}

/*
 * Class:     com_sun_javafx_newt_macosx_MacDisplay
 * Method:    initIDs
 * Signature: ()Z
 */
static ScreenChangeObserver *screenObserver = NULL;

JNIEXPORT jboolean JNICALL Java_com_sun_javafx_newt_macosx_MacDisplay_initNSApplication
  (JNIEnv *env, jclass clazz)
{
    static int initialized = 0;

    if(initialized) return JNI_TRUE;
    initialized = 1;

    // This little bit of magic is needed in order to receive mouse
    // motion events and allow key focus to be properly transferred.
    // FIXME: are these Carbon APIs? They come from the
    // ApplicationServices.framework.
    ProcessSerialNumber psn;
    if (GetCurrentProcess(&psn) == noErr) {
        TransformProcessType(&psn, kProcessTransformToForegroundApplication);
        SetFrontProcess(&psn);
    }

    // Initialize the shared NSApplication instance
    [NSApplication sharedApplication];

    // TODO: need to release this when the app exits
    screenObserver = [[ScreenChangeObserver alloc] initWithEnv: env];

    // Need this when debugging, as it is necessary to attach gdb to
    // the running java process -- "gdb java" doesn't work
    //    printf("Going to sleep for 10 seconds\n");
    //    sleep(10);

    return (jboolean) JNI_TRUE;
}

/*
 * Class:     com_sun_javafx_newt_macosx_MacDisplay
 * Method:    dispatchMessages0
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_sun_javafx_newt_macosx_MacDisplay_dispatchMessages0
  (JNIEnv *env, jobject unused, jlong window, jint eventMask)
{
    NSEvent* event = NULL;
    NSAutoreleasePool* pool = [[NSAutoreleasePool alloc] init];

NS_DURING

    int num_events = 0;

    // Periodically take a break
    do {
        // FIXME: ignoring event mask for the time being
        event = [NSApp nextEventMatchingMask: NSAnyEventMask
                       untilDate: [NSDate distantPast]
                       inMode: NSDefaultRunLoopMode
                       dequeue: YES];
        if (event != NULL) {
            [NSApp sendEvent: event];

            num_events++;
        }
    } while (num_events<100 && event != NULL);

NS_HANDLER
    
    // just ignore it ..

NS_ENDHANDLER

    [pool release];
}


static void InitScreensInfo(JNIEnv *env, jobject screensDataObj) {
    int i;
    jclass clazz = (*env)->FindClass(env, "com/sun/javafx/newt/macosx/MacScreensInfo");
    if (clazz == NULL) {
        return;
    }

    jmethodID addScreenMID = (*env)->GetMethodID(env, clazz, "addScreen", "(IJZIIIIIIIIFF)V");
    if (addScreenMID == NULL) {
        return;
    }

    NSArray *screens = [NSScreen screens];
    int numScreens =  [screens count];
    jint primaryHeight = [ [screens objectAtIndex: 0] frame ].size.height;

    for (i = 0; i < numScreens; ++i) {
        NSScreen *screen = (NSScreen *) [screens objectAtIndex: i];
        NSRect rect = [screen frame];
        NSRect vrect = [screen visibleFrame];

        jint x  = (jint)rect.origin.x;
        jint y  = (jint)(primaryHeight - (rect.origin.y + rect.size.height));
        jint w  = (jint)rect.size.width;
        jint h  = (jint)rect.size.height;
        jint wx = (jint)vrect.origin.x;
        jint wy = (jint)(primaryHeight - (vrect.origin.y + vrect.size.height));
        jint ww = (jint)vrect.size.width;
        jint wh = (jint)vrect.size.height;
        jfloat dpiX, dpiY;
        CGDirectDisplayID displayID = (CGDirectDisplayID)
            [[[screen deviceDescription] objectForKey:@"NSScreenNumber"] pointerValue];
        CGSize physicalSize = CGDisplayScreenSize(displayID);
        if (physicalSize.width == 0 || physicalSize.height == 0) {
            dpiX = dpiY = (jfloat)([screen userSpaceScaleFactor] * 72.0f);
        } else {
            // /25.4 convers millimeters to inches
            dpiX = CGDisplayPixelsWide(displayID) / (physicalSize.width / 25.4f);
            dpiY = CGDisplayPixelsHigh(displayID) / (physicalSize.height / 25.4f);
        }

        (*env)->CallVoidMethod(env, screensDataObj, addScreenMID,
                               i, (jlong)(intptr_t)displayID, (jboolean)(i == 0),
                               x, y, w, h,
                               wx, wy, ww, wh,
                               dpiX, dpiY);
    }
}

/*
 * Class:     com_sun_javafx_newt_mac_MacScreensInfo
 * Method:    nInitData
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_sun_javafx_newt_macosx_MacScreensInfo_nInitData
  (JNIEnv *env, jobject screensDataObj) 
{
    NSAutoreleasePool* pool = [[NSAutoreleasePool alloc] init];

    InitScreensInfo(env, screensDataObj);

    [pool release];
}

/*
 * Class:     com_sun_javafx_newt_macosx_MacWindow
 * Method:    initIDs
 * Signature: ()Z
 */
JNIEXPORT jboolean JNICALL Java_com_sun_javafx_newt_macosx_MacWindow_initIDs
  (JNIEnv *env, jclass clazz)
{
    static int initialized = 0;

    if(initialized) return JNI_TRUE;
    initialized = 1;

    // Need this when debugging, as it is necessary to attach gdb to
    // the running java process -- "gdb java" doesn't work
    //    printf("Going to sleep for 10 seconds\n");
    //    sleep(10);

    return (jboolean) [NewtMacWindow initNatives: env forClass: clazz];
}

/*
 * Class:     com_sun_javafx_newt_macosx_MacWindow
 * Method:    createWindow0
 * Signature: (JIIIIZIIIJ)J
 */
JNIEXPORT jlong JNICALL Java_com_sun_javafx_newt_macosx_MacWindow_createWindow0
  (JNIEnv *env, jobject jthis, jlong parent, jint x, jint y, jint w, jint h, jboolean fullscreen, jboolean opaque, jint styleMask,
   jint bufferingType, jint screen_idx, jlong jview)
{
    NSAutoreleasePool* pool = [[NSAutoreleasePool alloc] init];
    NSRect rect = NSMakeRect(x, y, w, h);

    NSArray *screens = [NSScreen screens];
    if(screen_idx<0) screen_idx=0;
    if(screen_idx>=[screens count]) screen_idx=0;
    NSScreen *screen = (NSScreen *) [screens objectAtIndex: screen_idx];

    if (fullscreen) {
        styleMask = NSBorderlessWindowMask;
        NSRect rect = [screen frame];
        w = (jint) (rect.size.width);
        h = (jint) (rect.size.height);
    } else {
        if (((NSUInteger)styleMask) != NSBorderlessWindowMask) {
            NSString * str = @"";
            CGFloat minWidth =
                [NSWindow minFrameWidthWithTitle : str
                          styleMask : (NSUInteger) styleMask];
            if (w < minWidth) {
                w = ceil(minWidth);
            }
        }
        if (w <= 0) {
            w = 1;
        }
        if (h <= 0) {
            h = 1;
        }
    }

    // Allocate the window
    NSWindow* window = [[[NewtMacWindow alloc] initWithContentRect: rect
                                               styleMask: (NSUInteger) styleMask
                                               backing: (NSBackingStoreType) bufferingType
                                               screen: screen] retain];

    NSWindow* parentWindow = (NSWindow*) ((intptr_t) parent);
    if(NULL!=parentWindow) {
        [parentWindow addChildWindow: window ordered: NSWindowAbove];
        [window setParentWindow: parentWindow];
    }

    if (fullscreen) {
        [window setOpaque: YES];
        [window setBackgroundColor: [NSColor blackColor]];
    } else {
        if (opaque) {
            [window setBackgroundColor: [NSColor blackColor]];
        } else {
            [window setOpaque: NO];
            [window setBackgroundColor: [NSColor clearColor]];
            [window setHasShadow:NO];
            [window setMovableByWindowBackground:NO];
        }
    }

    // Immediately re-position the window based on an upper-left coordinate system
    setFrameTopLeftPoint(parentWindow, window, x, y);

    // specify we want mouse-moved events
    [window setAcceptsMouseMovedEvents:YES];

    // Use given NewtView or allocate an NewtView if NULL
    NewtView* view = (0==jview)? [[NewtView alloc] initWithFrame: rect] : (NewtView*) ((intptr_t) jview) ;
    [view updateTrackingRect];

    // Set the content view
    (void) changeContentView(env, jthis, parentWindow, window, view);

NS_DURING
    // Available >= 10.5 - Makes the menubar disapear
    if(fullscreen) {
         [view enterFullScreenMode: screen withOptions:NULL];
    }
NS_HANDLER
NS_ENDHANDLER

    // Set the next responder to be the window so that we can forward
    // right mouse button down events
    [view setNextResponder: window];

    [pool release];

    return (jlong) ((intptr_t) window);
}

/*
 * Class:     com_sun_javafx_newt_macosx_MacWindow
 * Method:    makeKeyAndOrderFront
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_com_sun_javafx_newt_macosx_MacWindow_makeKeyAndOrderFront
  (JNIEnv *env, jobject unused, jlong window)
{
    NSAutoreleasePool* pool = [[NSAutoreleasePool alloc] init];
    NSWindow* win = (NSWindow*) ((intptr_t) window);
    [win makeKeyAndOrderFront: win];
    [pool release];
}

/*
 * Class:     com_sun_javafx_newt_macosx_MacWindow
 * Method:    makeKey
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_com_sun_javafx_newt_macosx_MacWindow_makeKey
  (JNIEnv *env, jobject unused, jlong window)
{
    NSAutoreleasePool* pool = [[NSAutoreleasePool alloc] init];
    NSWindow* win = (NSWindow*) ((intptr_t) window);
    [win makeKeyWindow];
    [pool release];
}

/*
 * Class:     com_sun_javafx_newt_macosx_MacWindow
 * Method:    orderOut
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_com_sun_javafx_newt_macosx_MacWindow_orderOut
  (JNIEnv *env, jobject unused, jlong window)
{
    NSAutoreleasePool* pool = [[NSAutoreleasePool alloc] init];
    NSWindow* win = (NSWindow*) ((intptr_t) window);
    [win orderOut: win];
    [pool release];
}

/*
 * Class:     com_sun_javafx_newt_macosx_MacWindow
 * Method:    close0
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_com_sun_javafx_newt_macosx_MacWindow_close0
  (JNIEnv *env, jobject unused, jlong window)
{
    NSAutoreleasePool* pool = [[NSAutoreleasePool alloc] init];
    NSWindow* win = (NSWindow*) ((intptr_t) window);
    NSView* view = [win contentView];
    [win orderOut: win];
NS_DURING
    if(NULL!=view) {
        // Available >= 10.5 - Makes the menubar disapear
        if([view isInFullScreenMode]) {
            [view exitFullScreenModeWithOptions: NULL];
        }
    }
NS_HANDLER
NS_ENDHANDLER
    [win close];
    [pool release];
}

/*
 * Class:     com_sun_javafx_newt_macosx_MacWindow
 * Method:    setTitle0
 * Signature: (JLjava/lang/String;)V
 */
JNIEXPORT void JNICALL Java_com_sun_javafx_newt_macosx_MacWindow_setTitle0
  (JNIEnv *env, jobject unused, jlong window, jstring title)
{
    NSAutoreleasePool* pool = [[NSAutoreleasePool alloc] init];
    NSWindow* win = (NSWindow*) ((intptr_t) window);
    NSString* str = jstringToNSString(env, title);
    [str autorelease];
    [win setTitle: str];
    [pool release];
}

/*
 * Class:     com_sun_javafx_newt_macosx_MacWindow
 * Method:    contentView
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_com_sun_javafx_newt_macosx_MacWindow_contentView
  (JNIEnv *env, jobject unused, jlong window)
{
    NSAutoreleasePool* pool = [[NSAutoreleasePool alloc] init];
    NSWindow* win = (NSWindow*) ((intptr_t) window);
    jlong res = (jlong) ((intptr_t) [win contentView]);
    [pool release];
    return res;
}

/*
 * Class:     com_sun_javafx_newt_macosx_MacWindow
 * Method:    changeContentView
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_com_sun_javafx_newt_macosx_MacWindow_changeContentView
  (JNIEnv *env, jobject jthis, jlong parent, jlong window, jlong jview)
{
    NSAutoreleasePool* pool = [[NSAutoreleasePool alloc] init];
    NSWindow* pwin = (NewtMacWindow*) ((intptr_t) parent);
    NSWindow* win = (NewtMacWindow*) ((intptr_t) window);
    NewtView* newView = (NewtView *) ((intptr_t) jview);

    NewtView* oldView = changeContentView(env, jthis, pwin, win, newView);

    [pool release];

    return (jlong)(intptr_t)oldView;
}

/*
 * Class:     com_sun_javafx_newt_macosx_MacWindow
 * Method:    setContentSize
 * Signature: (JII)V
 */
JNIEXPORT void JNICALL Java_com_sun_javafx_newt_macosx_MacWindow_setContentSize
    (JNIEnv *env, jobject unused, jlong window, jboolean resizable, jint w, jint h)
{
    NSAutoreleasePool* pool = [[NSAutoreleasePool alloc] init];
    NSWindow* win = (NSWindow*) ((intptr_t) window);
    CGFloat minWidth = getMinWidth(win);

    if (w < minWidth) {
        w = ceil(minWidth);
    }
    if (w <= 0) {
        w = 1;
    }
    if (h <= 0) {
        h = 1;
    }

    NSSize sz = NSMakeSize(w, h);

    if (!resizable) {
        NSRect contentRect = NSMakeRect(0, 0, sz.width, sz.height);
        NSRect rect = [win frameRectForContentRect: contentRect ];
        [win setMaxSize: rect.size];
        [win setMinSize: rect.size];
    }

    [win setContentSize: sz];
    [pool release];
}

/*
 * Class:     com_sun_javafx_newt_macosx_MacWindow
 * Method:    setFrameTopLeftPoint
 * Signature: (JII)V
 */
JNIEXPORT void JNICALL Java_com_sun_javafx_newt_macosx_MacWindow_setFrameTopLeftPoint
  (JNIEnv *env, jobject unused, jlong parent, jlong window, jint x, jint y)
{
    NSAutoreleasePool* pool = [[NSAutoreleasePool alloc] init];
    NSWindow* pwin = (NSWindow*) ((intptr_t) parent);
    NSWindow* win = (NSWindow*) ((intptr_t) window);
    setFrameTopLeftPoint(pwin, win, x, y);
    [pool release];
}

JNIEXPORT void JNICALL Java_com_sun_javafx_newt_macosx_MacWindow_setResizable
  (JNIEnv *env, jobject unused, jlong window, jboolean resizable)
{
    NSAutoreleasePool* pool = [[NSAutoreleasePool alloc] init];
    NSWindow* win = (NSWindow*) ((intptr_t) window);

    // [NSWidnow setStyleMask: style] is snow leopard only so we have to fake
    // non-resizability by setting min/max size
    if (resizable) {
        NSSize defaultMaxSize = NSMakeSize(FLT_MAX, FLT_MAX);
        [win setMaxSize: defaultMaxSize];
       
        // calculate the  of the decorations and set them as min size
        NSRect frameRect = [win frame];
        NSRect contentRect = [win contentRectForFrameRect: frameRect];
        CGFloat top = frameRect.size.height - contentRect.size.height;
        CGFloat bottom = contentRect.origin.y - frameRect.origin.y;
        NSSize minSize = NSMakeSize(getMinWidth(win), top + bottom + 1.0);
        [win setMinSize: minSize];
    } else {
        NSRect currentFrame = [win frame];
        [win setMaxSize: currentFrame.size];
        [win setMinSize: currentFrame.size];
    }
  
    NSButton *zoomButton = [win standardWindowButton:NSWindowZoomButton];
    [zoomButton setEnabled: resizable];
    // we may want to disable this since the indicator gets over drawn by opengl anyway
    [win setShowsResizeIndicator: resizable];

    [pool release];
}

/*
 * Class:     com_sun_javafx_newt_macosx_MacWindow
 * Method:    nativeSetAlpha
 * Signature: (JF)V
 */
JNIEXPORT void JNICALL Java_com_sun_javafx_newt_macosx_MacWindow_nativeSetAlpha
(JNIEnv *env, jobject self, jlong window, jfloat alpha){
  NSAutoreleasePool* pool = [[NSAutoreleasePool alloc] init];
  NSWindow* win = (NSWindow*) ((intptr_t) window);
  
  [win setAlphaValue:alpha];

  [pool release];
}

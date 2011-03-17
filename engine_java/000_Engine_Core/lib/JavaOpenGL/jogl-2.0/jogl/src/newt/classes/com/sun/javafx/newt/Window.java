/*
 * Copyright (c) 2008 Sun Microsystems, Inc. All Rights Reserved.
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

package com.sun.javafx.newt;

import com.sun.javafx.newt.impl.Debug;
import com.sun.javafx.newt.util.EventDispatchThread;

import javax.media.nativewindow.*;
import com.sun.nativewindow.impl.NWReflection;

import java.util.ArrayList;
import java.util.Iterator;
import java.lang.reflect.Method;

public abstract class Window implements NativeWindow
{
    public static final boolean DEBUG_MOUSE_EVENT = Debug.debug("Window.MouseEvent");
    public static final boolean DEBUG_KEY_EVENT = Debug.debug("Window.KeyEvent");
    public static final boolean DEBUG_WINDOW_EVENT = Debug.debug("Window.WindowEvent");
    public static final boolean DEBUG_IMPLEMENTATION = Debug.debug("Window");
    
    // Workaround for initialization order problems on Mac OS X
    // between native Newt and (apparently) Fmod -- if Fmod is
    // initialized first then the connection to the window server
    // breaks, leading to errors from deep within the AppKit
    static void init(String type) {
        if (NativeWindowFactory.TYPE_MACOSX.equals(type)) {
            try {
                getWindowClass(type);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static Class getWindowClass(String type) 
        throws ClassNotFoundException 
    {
        Class windowClass = NewtFactory.getCustomClass(type, "Window");
        if(null==windowClass) {
            if (NativeWindowFactory.TYPE_EGL.equals(type)) {
                windowClass = Class.forName("com.sun.javafx.newt.opengl.kd.KDWindow");
            } else if (NativeWindowFactory.TYPE_WINDOWS.equals(type)) {
                windowClass = Class.forName("com.sun.javafx.newt.windows.WindowsWindow");
            } else if (NativeWindowFactory.TYPE_MACOSX.equals(type)) {
                windowClass = Class.forName("com.sun.javafx.newt.macosx.MacWindow");
            } else if (NativeWindowFactory.TYPE_X11.equals(type)) {
                windowClass = Class.forName("com.sun.javafx.newt.x11.X11Window");
            } else if (NativeWindowFactory.TYPE_AWT.equals(type)) {
                windowClass = Class.forName("com.sun.javafx.newt.awt.AWTWindow");
            } else {
                throw new NativeWindowException("Unknown window type \"" + type + "\"");
            }
        }
        return windowClass;
    }

    protected static Window create(String type, final long parentWindowHandle, Screen screen, final Capabilities caps,
    				 boolean undecorated, boolean opaque) {
        try {
            Class windowClass;
            if(caps.isOnscreen()) {
                windowClass = getWindowClass(type);
            } else {
                windowClass = OffscreenWindow.class;
            }
            Window window = (Window) windowClass.newInstance();
            window.invalidate();
            window.screen = screen;
            window.setOpaque(opaque);
            window.setUndecorated(undecorated||0!=parentWindowHandle);
            EventDispatchThread edt = screen.getDisplay().getEDT();
            if(null!=edt) {
                final Window f_win = window;
                edt.invokeAndWait(new Runnable() {
                    public void run() {
                        f_win.createNative(parentWindowHandle, caps);
                    }
                } );
            } else {
                window.createNative(parentWindowHandle, caps);
            }
            return window;
        } catch (Throwable t) {
            t.printStackTrace();
            throw new NativeWindowException(t);
        }
    }

    protected static Window create(String type, Object[] cstrArguments, Screen screen, final Capabilities caps, boolean undecorated, boolean opaque) {

        try {
            Class windowClass = getWindowClass(type);
            Class[] cstrArgumentTypes = getCustomConstructorArgumentTypes(windowClass);
            if(null==cstrArgumentTypes) {
                throw new NativeWindowException("WindowClass "+windowClass+" doesn't support custom arguments in constructor");
            }
            int argsChecked = verifyConstructorArgumentTypes(cstrArgumentTypes, cstrArguments);
            if ( argsChecked < cstrArguments.length ) {
                throw new NativeWindowException("WindowClass "+windowClass+" constructor mismatch at argument #"+argsChecked+"; Constructor: "+getTypeStrList(cstrArgumentTypes)+", arguments: "+getArgsStrList(cstrArguments));
            }
            Window window = (Window) NWReflection.createInstance( windowClass, cstrArgumentTypes, cstrArguments ) ;
            window.invalidate();
            window.screen   = screen;
            window.setUndecorated(undecorated);
            window.setOpaque(opaque);
            EventDispatchThread edt = screen.getDisplay().getEDT();
            if(null!=edt) {
                final Window f_win = window;
                edt.invokeAndWait(new Runnable() {
                    public void run() {
                        f_win.createNative(0, caps);
                    }
                } );
            } else {
                window.createNative(0, caps);
            }
            return window;
        } catch (Throwable t) {
            t.printStackTrace();
            throw new NativeWindowException(t);
        }
    }

    protected static Window wrapHandle(String type, Screen screen, AbstractGraphicsConfiguration config, 
                                 long windowHandle, boolean fullscreen, boolean visible, 
                                 int x, int y, int width, int height) 
    {
        try {
            Class windowClass = getWindowClass(type);
            Window window = (Window) windowClass.newInstance();
            window.invalidate();
            window.screen   = screen;
            window.config = config;
            window.windowHandle = windowHandle;
            window.fullscreen=fullscreen;
            window.visible=visible;
            window.x=x;
            window.y=y;
            window.width=width;
            window.height=height;
            return window;
        } catch (Throwable t) {
            t.printStackTrace();
            throw new NativeWindowException(t);
        }
    }

    public static String toHexString(int hex) {
        return "0x" + Integer.toHexString(hex);
    }

    public static String toHexString(long hex) {
        return "0x" + Long.toHexString(hex);
    }

    protected Screen screen;

    protected AbstractGraphicsConfiguration config;
    protected long   windowHandle;
    protected boolean fullscreen, visible;
    protected int width, height, x, y;
    protected int     eventMask;

    protected String title = "Newt Window";
    protected boolean undecorated = false;

    /**
     * Create native windowHandle, ie creates a new native invisible window.
     *
     * The parentWindowHandle may be null, in which case no window parenting 
     * is requested.
     *
     * Shall use the capabilities to determine the graphics configuration
     * and shall set the chosen capabilities.
     */
    protected abstract void createNative(long parentWindowHandle, Capabilities caps);

    protected abstract void closeNative();

    public Screen getScreen() {
        return screen;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();

        sb.append(getClass().getName()+"[config "+config+
                    ", windowHandle "+toHexString(getWindowHandle())+
                    ", surfaceHandle "+toHexString(getSurfaceHandle())+
                    ", pos "+getX()+"/"+getY()+", size "+getWidth()+"x"+getHeight()+
                    ", visible "+isVisible()+
                    ", undecorated "+undecorated+
                    ", fullscreen "+fullscreen+
                    ", "+screen+
                    ", wrappedWindow "+getWrappedWindow());

        sb.append(", SurfaceUpdatedListeners num "+surfaceUpdatedListeners.size()+" [");
        for (Iterator iter = surfaceUpdatedListeners.iterator(); iter.hasNext(); ) {
          sb.append(iter.next()+", ");
        }
        sb.append("], WindowListeners num "+windowListeners.size()+" [");
        for (Iterator iter = windowListeners.iterator(); iter.hasNext(); ) {
          sb.append(iter.next()+", ");
        }
        sb.append("], MouseListeners num "+mouseListeners.size()+" [");
        for (Iterator iter = mouseListeners.iterator(); iter.hasNext(); ) {
          sb.append(iter.next()+", ");
        }
        sb.append("], KeyListeners num "+keyListeners.size()+" [");
        for (Iterator iter = keyListeners.iterator(); iter.hasNext(); ) {
          sb.append(iter.next()+", ");
        }
        sb.append("] ]");
        return sb.toString();
    }

    protected float opacity = 1.0f;
    protected boolean resizable = true;
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUndecorated(boolean value) {
        undecorated = value;
    }

    public boolean isUndecorated() {
        return undecorated;
    }


    /**
     * Set opacity of this window
     * @param opacity a number between 0.0 and 1.0, otherwise it is clamped to
     * this interval
     */
    public void setOpacity(float opacity) {
        if (opacity < 0) {
            opacity = 0.0f;
        }
        if (opacity > 1.0) {
            opacity = 1.0f;
        }
    	this.opacity  = opacity;
    }

    /**
     *
     * @return opacity value of this window [0.0-1.0]
     */
    public float getOpacity() {
        return opacity;
    }

    /**
     *
     * @return true if this window is opaque and doesn't support per-pixel
     * transparency, false otherwise
     */
    public boolean isOpaque() {
        return true;
    }

    /**
     * Sets this window opaque-ness. Note that particular implementations may
     * choose to ignore this setting in which case isOpaque will return false.
     *
     * Subclasses which support non-opaque windows are expected to override this
     * method and implement
     *
     * @param opaque hint to make the window opaque or non-opaque
     */
    protected void setOpaque(boolean opaque) {}

    /**
     * Sets whether this window is resizable by the user or not.
     * @param indicates whether the window is resizable by the user
     */
    public void setResizable(boolean value) {
        this.resizable = value;
    }

    /**
     * @return true if the window is resizable by the user, false otherwise
     */
    public boolean isResizable() {
        return resizable;
    }

    public void requestFocus() {
    }

    //
    // NativeWindow impl
    //
    private Thread owner;
    private int recursionCount;
    protected Exception lockedStack = null;

    /** Recursive and blocking lockSurface() implementation */
    public synchronized int lockSurface() {
        // We leave the ToolkitLock lock to the specializtion's discretion, 
        // ie the implicit JAWTWindow in case of AWTWindow
        Thread cur = Thread.currentThread();
        if (owner == cur) {
            ++recursionCount;
            return LOCK_SUCCESS;
        }
        while (owner != null) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        owner = cur;
        lockedStack = new Exception("NEWT Surface previously locked by "+Thread.currentThread());
        screen.getDisplay().lockDisplay();
        return LOCK_SUCCESS;
    }

    /** Recursive and unblocking unlockSurface() implementation */
    public synchronized void unlockSurface() throws NativeWindowException {
        Thread cur = Thread.currentThread();
        if (owner != cur) {
            lockedStack.printStackTrace();
            throw new NativeWindowException(cur+": Not owner, owner is "+owner);
        }
        if (recursionCount > 0) {
            --recursionCount;
            return;
        }
        owner = null;
        lockedStack = null;
        screen.getDisplay().unlockDisplay();
        notifyAll();
        // We leave the ToolkitLock unlock to the specializtion's discretion, 
        // ie the implicit JAWTWindow in case of AWTWindow
    }

    public synchronized boolean isSurfaceLocked() {
        return null!=owner;
    }

    public synchronized Thread getSurfaceLockOwner() {
        return owner;
    }

    public synchronized Exception getLockedStack() {
        return lockedStack;
    }

    public synchronized void destroy() {
        destroy(false);
    }

    /** @param deep If true, the linked Screen and Display will be destroyed as well. */
    public synchronized void destroy(boolean deep) {
        if(DEBUG_WINDOW_EVENT) {
            System.out.println("Window.destroy() start (deep "+deep+" - "+Thread.currentThread());
        }
        synchronized(surfaceUpdatedListeners) {
            surfaceUpdatedListeners = new ArrayList();
        }
        synchronized(windowListeners) {
            windowListeners = new ArrayList();
        }
        synchronized(mouseListeners) {
            mouseListeners = new ArrayList();
        }
        synchronized(keyListeners) {
            keyListeners = new ArrayList();
        }
        Screen scr = screen;
        Display dpy = (null!=screen) ? screen.getDisplay() : null;
        EventDispatchThread edt = (null!=dpy) ? dpy.getEDT() : null;
        if(null!=edt) {
            final Window f_win = this;
            edt.invokeAndWait(new Runnable() {
                public void run() {
                    f_win.closeNative();
                }
            } );
        } else {
            closeNative();
        }
        invalidate();
        if(deep) {
            if(null!=scr) {
                scr.destroy();
            }
            if(null!=dpy) {
                dpy.destroy();
            }
        }
        if(DEBUG_WINDOW_EVENT) {
            System.out.println("Window.destroy() end "+Thread.currentThread());
        }
    }

    public void invalidate() {
        if(DEBUG_IMPLEMENTATION || DEBUG_WINDOW_EVENT) {
            Exception e = new Exception("!!! Window Invalidate "+Thread.currentThread());
            e.printStackTrace();
        }
        screen   = null;
        windowHandle = 0;
        fullscreen=false;
        visible=false;
        eventMask = 0;

        // Default position and dimension will be re-set immediately by user
        width  = 100;
        height = 100;
        x=0;
        y=0;
    }

    public boolean surfaceSwap() { 
        return false;
    }

    protected void clearEventMask() {
        eventMask=0;
    }

    public long getDisplayHandle() {
        return screen.getDisplay().getHandle();
    }

    public int  getScreenIndex() {
        return screen.getIndex();
    }

    public long getWindowHandle() {
        return windowHandle;
    }

    public long getSurfaceHandle() {
        return windowHandle; // default: return window handle
    }

    public AbstractGraphicsConfiguration getGraphicsConfiguration() {
        return config;
    }

    /**
     * Returns the width of the client area of this window
     * @return width of the client area
     */
    public int getWidth() {
        return width;
    }

    /**
     * Returns the height of the client area of this window
     * @return height of the client area
     */
    public int getHeight() {
        return height;
    }

    /**
     * Returns the insets for this native window (the difference between the
     * size of the toplevel window with the decorations and the client area).
     * 
     * @return insets for this platform window
     */
    // this probably belongs to NativeWindow interface
    public Insets getInsets() {
        return new Insets(0,0,0,0);
    }

    /** If this Window actually wraps one from another toolkit such as
        the AWT, this will return a non-null value. */
    public Object getWrappedWindow() {
        return null;
    }

    //
    // Additional methods
    //

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isVisible() {
        return visible;
    }

    public boolean isFullscreen() {
        return fullscreen;
    }

    private boolean autoDrawableMember = false;

    /** If the implementation is capable of detecting a device change
        return true and clear the status/reason of the change. */
    public boolean hasDeviceChanged() {
        return false;
    }

    /**
     * If set to true, 
     * certain action will be performed by the owning
     * AutoDrawable, ie the destroy() call within windowDestroyNotify()
     */
    public void setAutoDrawableClient(boolean b) {
        autoDrawableMember = b;
    }

    protected void windowDestroyNotify() {
        if(DEBUG_WINDOW_EVENT) {
            System.out.println("Window.windowDestroyeNotify start "+Thread.currentThread());
        }

        sendWindowEvent(WindowEvent.EVENT_WINDOW_DESTROY_NOTIFY);

        if(!autoDrawableMember) {
            destroy();
        }

        if(DEBUG_WINDOW_EVENT) {
            System.out.println("Window.windowDestroyeNotify end "+Thread.currentThread());
        }
    }

    protected void windowDestroyed() {
        if(DEBUG_WINDOW_EVENT) {
            System.out.println("Window.windowDestroyed "+Thread.currentThread());
        }
        invalidate();
    }

    public abstract void    setVisible(boolean visible);
    /**
     * Sets the size of the client area of the window, excluding decorations
     * Total size of the window will be
     * {@code width+insets.left+insets.right, height+insets.top+insets.bottom}
     * @param width of the client area of the window
     * @param height of the client area of the window
     */
    public abstract void    setSize(int width, int height);
    /**
     * Sets the location of the top left corner of the window, including
     * decorations (so the client area will be placed at
     * {@code x+insets.left,y+insets.top}.
     * @param x coord of the top left corner
     * @param y coord of the top left corner
     */
    public abstract void    setPosition(int x, int y);
    public abstract boolean setFullscreen(boolean fullscreen);

    //
    // SurfaceUpdatedListener Support
    //
    private ArrayList surfaceUpdatedListeners = new ArrayList();

    public void addSurfaceUpdatedListener(SurfaceUpdatedListener l) {
        if(l == null) {
            return;
        }
        synchronized(surfaceUpdatedListeners) {
            ArrayList newSurfaceUpdatedListeners = (ArrayList) surfaceUpdatedListeners.clone();
            newSurfaceUpdatedListeners.add(l);
            surfaceUpdatedListeners = newSurfaceUpdatedListeners;
        }
    }

    public void removeSurfaceUpdatedListener(SurfaceUpdatedListener l) {
        if (l == null) {
            return;
        }
        synchronized(surfaceUpdatedListeners) {
            ArrayList newSurfaceUpdatedListeners = (ArrayList) surfaceUpdatedListeners.clone();
            newSurfaceUpdatedListeners.remove(l);
            surfaceUpdatedListeners = newSurfaceUpdatedListeners;
        }
    }

    public SurfaceUpdatedListener[] getSurfaceUpdatedListener() {
        synchronized(surfaceUpdatedListeners) {
            return (SurfaceUpdatedListener[]) surfaceUpdatedListeners.toArray();
        }
    }

    public void surfaceUpdated(Object updater, NativeWindow window, long when) { 
        ArrayList listeners = null;
        synchronized(surfaceUpdatedListeners) {
            listeners = surfaceUpdatedListeners;
        }
        for(Iterator i = listeners.iterator(); i.hasNext(); ) {
            SurfaceUpdatedListener l = (SurfaceUpdatedListener) i.next();
            l.surfaceUpdated(updater, window, when);
        }
    }

    //
    // MouseListener Support
    //

    public void addMouseListener(MouseListener l) {
        if(l == null) {
            return;
        }
        synchronized(mouseListeners) {
            ArrayList newMouseListeners = (ArrayList) mouseListeners.clone();
            newMouseListeners.add(l);
            mouseListeners = newMouseListeners;
        }
    }

    public void removeMouseListener(MouseListener l) {
        if (l == null) {
            return;
        }
        synchronized(mouseListeners) {
            ArrayList newMouseListeners = (ArrayList) mouseListeners.clone();
            newMouseListeners.remove(l);
            mouseListeners = newMouseListeners;
        }
    }

    public MouseListener[] getMouseListeners() {
        synchronized(mouseListeners) {
            return (MouseListener[]) mouseListeners.toArray();
        }
    }

    private ArrayList mouseListeners = new ArrayList();
    private int  mouseButtonPressed = 0; // current pressed mouse button number
    private long lastMousePressed = 0; // last time when a mouse button was pressed
    private int  lastMouseClickCount = 0; // last mouse button click count
    public  static final int ClickTimeout = 300;

    protected void sendMouseEvent(int eventType, int modifiers,
                                  int x, int y, int button, int rotation) {
        if(x<0||y<0||x>=width||y>=height) {
            return; // .. invalid ..
        }
        if(DEBUG_MOUSE_EVENT) {
            System.out.println("sendMouseEvent: "+MouseEvent.getEventTypeString(eventType)+
                               ", mod "+modifiers+", pos "+x+"/"+y+", button "+button);
        }
        if(button<0||button>MouseEvent.BUTTON_NUMBER) {
            throw new NativeWindowException("Invalid mouse button number" + button);
        }
        long when = System.currentTimeMillis();
        MouseEvent eClicked = null;
        MouseEvent e = null;

        if(MouseEvent.EVENT_MOUSE_PRESSED==eventType) {
            if(when-lastMousePressed<ClickTimeout) {
                lastMouseClickCount++;
            } else {
                lastMouseClickCount=1;
            }
            lastMousePressed=when;
            mouseButtonPressed=button;
            e = new MouseEvent(true, eventType, this, when,
                               modifiers, x, y, lastMouseClickCount, button, 0);
        } else if(MouseEvent.EVENT_MOUSE_RELEASED==eventType) {
            e = new MouseEvent(true, eventType, this, when,
                               modifiers, x, y, lastMouseClickCount, button, 0);
            if(when-lastMousePressed<ClickTimeout) {
                eClicked = new MouseEvent(true, MouseEvent.EVENT_MOUSE_CLICKED, this, when,
                                          modifiers, x, y, lastMouseClickCount, button, 0);
            } else {
                lastMouseClickCount=0;
                lastMousePressed=0;
            }
            mouseButtonPressed=0;
        } else if(MouseEvent.EVENT_MOUSE_MOVED==eventType) {
            if (mouseButtonPressed>0) {
                e = new MouseEvent(true, MouseEvent.EVENT_MOUSE_DRAGGED, this, when,
                                   modifiers, x, y, 1, mouseButtonPressed, 0);
            } else {
                e = new MouseEvent(true, eventType, this, when,
                                   modifiers, x, y, 0, button, 0);
            }
        } else if(MouseEvent.EVENT_MOUSE_WHEEL_MOVED==eventType) {
            e = new MouseEvent(true, eventType, this, when, modifiers, x, y, 0, button, rotation);
        } else {
            e = new MouseEvent(true, eventType, this, when, modifiers, x, y, 0, button, 0);
        }

        if(DEBUG_MOUSE_EVENT) {
            System.out.println("sendMouseEvent: event:         "+e);
            if(null!=eClicked) {
                System.out.println("sendMouseEvent: event Clicked: "+eClicked);
            }
        }

        ArrayList listeners = null;
        synchronized(mouseListeners) {
            listeners = mouseListeners;
        }
        for(Iterator i = listeners.iterator(); i.hasNext(); ) {
            MouseListener l = (MouseListener) i.next();
            switch(e.getEventType()) {
                case MouseEvent.EVENT_MOUSE_CLICKED:
                    l.mouseClicked(e);
                    break;
                case MouseEvent.EVENT_MOUSE_ENTERED:
                    l.mouseEntered(e);
                    break;
                case MouseEvent.EVENT_MOUSE_EXITED:
                    l.mouseExited(e);
                    break;
                case MouseEvent.EVENT_MOUSE_PRESSED:
                    l.mousePressed(e);
                    break;
                case MouseEvent.EVENT_MOUSE_RELEASED:
                    l.mouseReleased(e);
                    if(null!=eClicked) {
                        l.mouseClicked(eClicked);
                    }
                    break;
                case MouseEvent.EVENT_MOUSE_MOVED:
                    l.mouseMoved(e);
                    break;
                case MouseEvent.EVENT_MOUSE_DRAGGED:
                    l.mouseDragged(e);
                    break;
                case MouseEvent.EVENT_MOUSE_WHEEL_MOVED:
                    l.mouseWheelMoved(e);
                    break;
                default:
                    throw new NativeWindowException("Unexpected mouse event type " + e.getEventType());
            }
        }
    }

    //
    // KeyListener Support
    //

    public void addKeyListener(KeyListener l) {
        if(l == null) {
            return;
        }
        synchronized(keyListeners) {
            ArrayList newKeyListeners = (ArrayList) keyListeners.clone();
            newKeyListeners.add(l);
            keyListeners = newKeyListeners;
        }
    }

    public void removeKeyListener(KeyListener l) {
        if (l == null) {
            return;
        }
        synchronized(keyListeners) {
            ArrayList newKeyListeners = (ArrayList) keyListeners.clone();
            newKeyListeners.remove(l);
            keyListeners = newKeyListeners;
        }
    }

    public KeyListener[] getKeyListeners() {
        synchronized(keyListeners) {
            return (KeyListener[]) keyListeners.toArray();
        }
    }

    private ArrayList keyListeners = new ArrayList();

    protected void sendKeyEvent(int eventType, int modifiers, int keyCode, char keyChar) {
        KeyEvent e = new KeyEvent(true, eventType, this, System.currentTimeMillis(),
                                      modifiers, keyCode, keyChar);
        if(DEBUG_KEY_EVENT) {
            System.out.println("sendKeyEvent: "+e);
        }
        ArrayList listeners = null;
        synchronized(keyListeners) {
            listeners = keyListeners;
        }
        for(Iterator i = listeners.iterator(); i.hasNext(); ) {
            KeyListener l = (KeyListener) i.next();
            switch(eventType) {
                case KeyEvent.EVENT_KEY_PRESSED:
                    l.keyPressed(e);
                    break;
                case KeyEvent.EVENT_KEY_RELEASED:
                    l.keyReleased(e);
                    break;
                case KeyEvent.EVENT_KEY_TYPED:
                    l.keyTyped(e);
                    break;
                default:
                    throw new NativeWindowException("Unexpected key event type " + e.getEventType());
            }
        }
    }

    //
    // WindowListener Support
    //

    private ArrayList windowListeners = new ArrayList();

    public void addWindowListener(WindowListener l) {
        if(l == null) {
            return;
        }
        synchronized(windowListeners) {
            ArrayList newWindowListeners = (ArrayList) windowListeners.clone();
            newWindowListeners.add(l);
            windowListeners = newWindowListeners;
        }
    }

    public void removeWindowListener(WindowListener l) {
        if (l == null) {
            return;
        }
        synchronized(windowListeners) {
            ArrayList newWindowListeners = (ArrayList) windowListeners.clone();
            newWindowListeners.remove(l);
            windowListeners = newWindowListeners;
        }
    }

    public WindowListener[] getWindowListeners() {
        synchronized(windowListeners) {
            return (WindowListener[]) windowListeners.toArray();
        }
    }

    protected void sendWindowEvent(int eventType) {
        WindowEvent e = new WindowEvent(true, eventType, this, System.currentTimeMillis());
        if(DEBUG_WINDOW_EVENT) {
            System.out.println("sendWindowEvent: "+e);
        }
        ArrayList listeners = null;
        synchronized(windowListeners) {
            listeners = windowListeners;
        }
        for(Iterator i = listeners.iterator(); i.hasNext(); ) {
            WindowListener l = (WindowListener) i.next();
            switch(eventType) {
                case WindowEvent.EVENT_WINDOW_RESIZED:
                    l.windowResized(e);
                    break;
                case WindowEvent.EVENT_WINDOW_RESIZING:
                    l.windowResizing(e);
                    break;
                case WindowEvent.EVENT_WINDOW_MOVED:
                    l.windowMoved(e);
                    break;
                case WindowEvent.EVENT_WINDOW_DESTROY_NOTIFY:
                    l.windowDestroyNotify(e);
                    break;
                case WindowEvent.EVENT_WINDOW_GAINED_FOCUS:
                    l.windowGainedFocus(e);
                    break;
                case WindowEvent.EVENT_WINDOW_LOST_FOCUS:
                    l.windowLostFocus(e);
                    break;
                default:
                    throw 
                        new NativeWindowException("Unexpected window event type "
                                                  + e.getEventType());
            }
        }
    }


    //
    // WindowListener Support
    //

    private ArrayList paintListeners = new ArrayList();

    public void addPaintListener(PaintListener l) {
        if(l == null) {
            return;
        }
        synchronized(paintListeners) {
            ArrayList newPaintListeners = (ArrayList) paintListeners.clone();
            newPaintListeners.add(l);
            paintListeners = newPaintListeners;
        }
    }

    public void removePaintListener(PaintListener l) {
        if (l == null) {
            return;
        }
        synchronized(paintListeners) {
            ArrayList newPaintListeners = (ArrayList) paintListeners.clone();
            newPaintListeners.remove(l);
            paintListeners = newPaintListeners;
        }
    }

    protected void sendPaintEvent(int eventType, int x, int y, int w, int h) {
        PaintEvent e =
            new PaintEvent(eventType, this, System.currentTimeMillis(), x, y, w, h);
        ArrayList listeners = null;
        synchronized(paintListeners) {
            listeners = paintListeners;
        }
        for(Iterator i = listeners.iterator(); i.hasNext(); ) {
            PaintListener l = (PaintListener) i.next();
            l.exposed(e);
        }
    }

    //
    // Reflection helper ..
    //

    private static Class[] getCustomConstructorArgumentTypes(Class windowClass) {
        Class[] argTypes = null;
        try {
            Method m = windowClass.getDeclaredMethod("getCustomConstructorArgumentTypes", new Class[] {});
            argTypes = (Class[]) m.invoke(null, null);
        } catch (Throwable t) {}
        return argTypes;
    }

    private static int verifyConstructorArgumentTypes(Class[] types, Object[] args) {
        if(types.length != args.length) {
            return -1;
        }
        for(int i=0; i<args.length; i++) {
            if(!types[i].isInstance(args[i])) {
                return i;
            }
        }
        return args.length;
    }

    private static String getArgsStrList(Object[] args) {
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<args.length; i++) {
            sb.append(args[i].getClass());
            if(i<args.length) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    private static String getTypeStrList(Class[] types) {
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<types.length; i++) {
            sb.append(types[i]);
            if(i<types.length) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}

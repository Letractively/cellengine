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

package com.sun.javafx.newt.windows;

import javax.media.nativewindow.*;
import com.sun.javafx.newt.*;

public class WindowsWindow extends Window {

    private long hmon;
    private long hdc;
    private long windowHandleClose;
    private long parentWindowHandle;
    // non fullscreen dimensions ..
    private int nfs_width, nfs_height, nfs_x, nfs_y;
    private final Insets insets = new Insets(0, 0, 0, 0);

    static {
        WindowsDisplay.initSingleton();
    }

    public WindowsWindow() {
    }

    Thread hdcOwner = null;

    public synchronized int lockSurface() throws NativeWindowException {
        int res = super.lockSurface(); 
        if(LOCK_SUCCESS==res && 0!=windowHandle) {
            if(hdc!=0) {
                throw new NativeWindowException("NEWT Surface handle set HDC "+toHexString(hdc)+" - "+Thread.currentThread().getName()+" ; "+this);
            }
            hdc = GetDC(windowHandle);
            hmon = MonitorFromWindow(windowHandle);
            hdcOwner = Thread.currentThread();
        }
        return res;
    }

    public synchronized void unlockSurface() {
        // prevalidate, before we change data ..
        Thread cur = Thread.currentThread();
        if ( getSurfaceLockOwner() != cur ) {
            getLockedStack().printStackTrace();
            throw new NativeWindowException(cur+": Not owner, owner is "+getSurfaceLockOwner());
        }
        if (0!=hdc && 0!=windowHandle) {
            if(hdcOwner != cur) {
                throw new NativeWindowException("NEWT Surface handle set HDC "+toHexString(hdc)+" by other thread "+hdcOwner+", this "+cur+" ; "+this);
            }
            ReleaseDC(windowHandle, hdc);
            hdc=0;
            hdcOwner=null;
        }
        super.unlockSurface();
    }

    public long getSurfaceHandle() {
        return hdc;
    }

    public boolean hasDeviceChanged() {
        if(0!=windowHandle) {
            long _hmon = MonitorFromWindow(windowHandle);
            if (hmon != _hmon) {
                if(DEBUG_IMPLEMENTATION || DEBUG_WINDOW_EVENT) {
                    Exception e = new Exception("!!! Window Device Changed "+Thread.currentThread().getName()+
                                                ", HMON "+toHexString(hmon)+" -> "+toHexString(_hmon));
                    e.printStackTrace();
                }
                hmon = _hmon;
                return true;
            }
        }
        return false;
    }

    protected void createNative(long parentWindowHandle, Capabilities caps) {
        WindowsScreen  screen = (WindowsScreen) getScreen();
        WindowsDisplay display = (WindowsDisplay) screen.getDisplay();
        config = GraphicsConfigurationFactory.getFactory(display.getGraphicsDevice()).chooseGraphicsConfiguration(caps, null, screen.getGraphicsScreen());
        if (config == null) {
            throw new NativeWindowException("Error choosing GraphicsConfiguration creating window: "+this);
        }
        windowHandle = CreateWindow(parentWindowHandle, 
                                    display.getWindowClassAtom(), display.WINDOW_CLASS_NAME, display.getHInstance(), 
                                    0, undecorated, x, y, width, height);
        if (windowHandle == 0) {
            throw new NativeWindowException("Error creating window");
        }
        this.parentWindowHandle = parentWindowHandle;
        windowHandleClose = windowHandle;
        if(DEBUG_IMPLEMENTATION || DEBUG_WINDOW_EVENT) {
            Exception e = new Exception("!!! Window new window handle "+Thread.currentThread().getName()+
                                        " (Parent HWND "+toHexString(parentWindowHandle)+
                                        ") : HWND "+toHexString(windowHandle)+", "+Thread.currentThread());
            e.printStackTrace();
        }
    }

    protected void closeNative() {
        if (hdc != 0) {
            if(windowHandleClose != 0) {
                ReleaseDC(windowHandleClose, hdc);
            }
            hdc = 0;
        }
        if(windowHandleClose != 0) {
            DestroyWindow(windowHandleClose);
            windowHandleClose = 0;
        }
    }

    protected void windowDestroyed() {
        windowHandleClose = 0;
        super.windowDestroyed();
    }

    public void setVisible(boolean visible) {
        if(this.visible!=visible && 0!=windowHandle) {
            this.visible=visible;
            setVisible0(windowHandle, visible);
        }
    }

    // @Override
    public void setResizable(boolean resizable) {
        super.setResizable(resizable);
        if(0!=windowHandle) {
            setResizable(windowHandle, undecorated, resizable);
        }
    }

    // @Override
    public void setSize(int width, int height) {
        if (0!=windowHandle && (width != this.width || this.height != height)) {
            if(!fullscreen) {
                nfs_width=width;
                nfs_height=height;
            }
            this.width = width;
            this.height = height;
            setSize0(parentWindowHandle, windowHandle, x, y, width, height);
        }
    }

    //@Override
    public void setPosition(int x, int y) {
        if (0!=windowHandle && (this.x != x || this.y != y)) {
            if(!fullscreen) {
                nfs_x=x;
                nfs_y=y;
            }
            this.x = x;
            this.y = y;
            setPosition(parentWindowHandle, windowHandle, x , y);
        }
    }

    public boolean setFullscreen(boolean fullscreen) {
        if(0!=windowHandle && (this.fullscreen!=fullscreen)) {
            int x,y,w,h;
            this.fullscreen=fullscreen;
            if(fullscreen) {
                x = 0; y = 0;
                w = screen.getWidth();
                h = screen.getHeight();
            } else {
                x = nfs_x;
                y = nfs_y;
                w = nfs_width;
                h = nfs_height;
            }
            if(DEBUG_IMPLEMENTATION || DEBUG_WINDOW_EVENT) {
                System.err.println("WindowsWindow fs: "+fullscreen+" "+x+"/"+y+" "+w+"x"+h);
            }
            setFullscreen0(parentWindowHandle, windowHandle, x, y, w, h, undecorated, fullscreen);
        }
        return fullscreen;
    }

    // @Override
    public void requestFocus() {
        super.requestFocus();
        if (windowHandle != 0L) {
            requestFocus(windowHandle);
        }
    }

    // @Override
    public void setTitle(String title) {
        if (title == null) {
            title = "";
        }
        if (0!=windowHandle && !title.equals(getTitle())) {
            super.setTitle(title);
            setTitle(windowHandle, title);
        }
    }

    public Insets getInsets() {
        return (Insets)insets.clone();
    }

    //----------------------------------------------------------------------
    // Internals only
    //
    protected static native boolean initIDs();
    private        native long CreateWindow(long parentWindowHandle, 
                                            int wndClassAtom, String wndName, 
                                            long hInstance, long visualID,
                                            boolean isUndecorated,
                                            int x, int y, int width, int height);
    private        native void DestroyWindow(long windowHandle);
    private        native long GetDC(long windowHandle);
    private        native void ReleaseDC(long windowHandle, long hdc);
    private        native long MonitorFromWindow(long windowHandle);
    private static native void setResizable(long windowHandle, boolean isUndecorated, boolean resizable);
    private static native void setVisible0(long windowHandle, boolean visible);
    private        native void setSize0(long parentWindowHandle, long windowHandle, int x, int y, int width, int height);
    private        native void setPosition(long parentWindowHandle, long windowHandle, int x, int y);
    private        native void setFullscreen0(long parentWindowHandle, long windowHandle, int x, int y, int width, int height, boolean isUndecorated, boolean on);
    private static native void setTitle(long windowHandle, String title);
    private static native void requestFocus(long windowHandle);

    private void insetsChanged(int left, int top, int right, int bottom) {
        if (left != -1 && top != -1 && right != -1 && bottom != -1) {
            insets.left = left;
            insets.top = top;
            insets.right = right;
            insets.bottom = bottom;
        }
    }
    private void sizeChanged(int newWidth, int newHeight) {
        width = newWidth;
        height = newHeight;
        if(!fullscreen) {
            nfs_width=width;
            nfs_height=height;
        }
        sendWindowEvent(WindowEvent.EVENT_WINDOW_RESIZED);
    }

    private void windowSizing() {
        sendWindowEvent(WindowEvent.EVENT_WINDOW_RESIZING);
    }

    private void positionChanged(int newX, int newY) {
        x = newX;
        y = newY;
        if(!fullscreen) {
            nfs_x=x;
            nfs_y=y;
        }
        sendWindowEvent(WindowEvent.EVENT_WINDOW_MOVED);
    }

    /**
     *
     * @param focusOwner if focusGained is true, focusOwner is the previous
     * focus owner, if focusGained is false, focusOwner is the new focus owner
     * @param focusGained
     */
    private void focusChanged(long focusOwner, boolean focusGained) {
        if (focusGained) {
            sendWindowEvent(WindowEvent.EVENT_WINDOW_GAINED_FOCUS);
        } else {
            sendWindowEvent(WindowEvent.EVENT_WINDOW_LOST_FOCUS);
        }
    }
}

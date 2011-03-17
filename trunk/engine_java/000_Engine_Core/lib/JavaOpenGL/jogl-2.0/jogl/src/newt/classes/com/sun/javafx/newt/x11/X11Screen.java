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

package com.sun.javafx.newt.x11;

import com.sun.javafx.newt.*;
import com.sun.javafx.newt.impl.*;
import javax.media.nativewindow.*;
import javax.media.nativewindow.x11.*;

public class X11Screen extends Screen {

    static {
        X11Display.initSingleton();
    }


    public X11Screen() {
    }

    protected void createNative(int index) {
        long handle = GetScreen(display.getHandle(), index);
        if (handle == 0 ) {
            throw new RuntimeException("Error creating screen: "+index);
        }
        aScreen = new X11GraphicsScreen((X11GraphicsDevice)getDisplay().getGraphicsDevice(), index);
        setScreenSize(getWidth0(display.getHandle(), index),
                      getHeight0(display.getHandle(), index));
    }

    protected void closeNative() { }

    //----------------------------------------------------------------------
    // Internals only
    //

    private native long GetScreen(long dpy, int scrn_idx);
    private native int  getWidth0(long display, int scrn_idx);
    private native int  getHeight0(long display, int scrn_idx);
}


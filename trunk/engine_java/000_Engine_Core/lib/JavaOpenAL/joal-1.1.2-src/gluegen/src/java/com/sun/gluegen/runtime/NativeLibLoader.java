/*
 * Copyright (c) 2006 Sun Microsystems, Inc. All Rights Reserved.
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
 * You acknowledge that this software is not designed or intended for use
 * in the design, construction, operation or maintenance of any nuclear
 * facility.
 * 
 * Sun gratefully acknowledges that this software was originally authored
 * and developed by Kenneth Bradley Russell and Christopher John Kline.
 */

package com.sun.gluegen.runtime;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.*;

/** Class providing control over whether GlueGen loads the native code
    associated with the NativeLibrary implementation. Alternative app
    launchers such as those running within applets may want to disable
    this default loading behavior and load the native code via another
    (manual) mechanism. */
public class NativeLibLoader {
  private static volatile boolean loadingEnabled = true;
  private static volatile boolean didLoading;

  public static void disableLoading() {
    loadingEnabled = false;
  }

  public static void enableLoading() {
    loadingEnabled = true;
  }
  
  public static void loadGlueGenRT() {
    if (!didLoading && loadingEnabled) {
      synchronized (NativeLibLoader.class) {
        if (!didLoading && loadingEnabled) {
          didLoading = true;
          AccessController.doPrivileged(new PrivilegedAction() {
              public Object run() {
                loadLibraryInternal("gluegen-rt");
                return null;
              }
            });
        }
      }
    }
  }

  private static void loadLibraryInternal(String libraryName) {
    String sunAppletLauncher = System.getProperty("sun.jnlp.applet.launcher");
    boolean usingJNLPAppletLauncher = Boolean.valueOf(sunAppletLauncher).booleanValue();

    if (usingJNLPAppletLauncher) {
        try {
          Class jnlpAppletLauncherClass = Class.forName("org.jdesktop.applet.util.JNLPAppletLauncher");
          Method jnlpLoadLibraryMethod = jnlpAppletLauncherClass.getDeclaredMethod("loadLibrary", new Class[] { String.class });
          jnlpLoadLibraryMethod.invoke(null, new Object[] { libraryName });
        } catch (Exception e) {
          Throwable t = e;
          if (t instanceof InvocationTargetException) {
            t = ((InvocationTargetException) t).getTargetException();
          }
          if (t instanceof Error)
            throw (Error) t;
          if (t instanceof RuntimeException) {
            throw (RuntimeException) t;
          }
          // Throw UnsatisfiedLinkError for best compatibility with System.loadLibrary()
          throw (UnsatisfiedLinkError) new UnsatisfiedLinkError().initCause(e);
        }
    } else {
      System.loadLibrary(libraryName);
    }
  }
}

/*
 * %W% %E%
 *
 * Copyright (c) 2007, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package sun.java2d.pipe.hw;

import java.awt.image.VolatileImage;

/**
 * Implementors of this interface provida a way to create a
 * {@code VolatileImage} whose destination surface is an
 * {@link AccelSurface} of specified type.
 *
 * @see AccelSurface
 */
public interface AccelGraphicsConfig extends BufferedContextProvider {
    /**
     * Returns a VolatileImage with specified width, height, transparency
     * and guaranteed accelerated surface type. If such image can not be created
     * (out of vram error, specific surface type is not supported) null
     * is returned.
     *
     * Note: if {@link AccelSurface#TEXTURE} type is requested, rendering
     * to the image will be denied by throwing
     * {@code UnsupportedOperationException }
     * from {@link java.awt.image.VolatileImage#getGraphics} and
     * {@link java.awt.image.VolatileImage#createGraphics}
     *
     * @param width the width of the returned {@code VolatileImage}
     * @param height the height of the returned {@code VolatileImage}
     * @param transparency the specified transparency mode
     * @param type requested accelerated surface type as specified by constants
     * in AccelSurface interface
     * @return a {@code VolatileImage} backed up by requested accelerated
     * surface type or null
     * @throws IllegalArgumentException if the transparency is not a valid value
     * @see AccelSurface#TEXTURE
     * @see AccelSurface#RT_PLAIN
     * @see AccelSurface#RT_TEXTURE
     */
    public VolatileImage createCompatibleVolatileImage(int width, int height,
                                                       int transparency,
                                                       int type);
    /**
     * Returns object representing capabilities of the context associated
     * with this {@code AccelGraphicsConfig}.
     *
     * @return ContextCapabilities object representing caps
     * @see ContextCapabilities
     */
    public ContextCapabilities getContextCapabilities();

    /**
     * Adds an {@code AccelDeviceEventListener} to listen to accelerated
     * device's (which is associated with this {@code AccelGraphicsConfig})
     * events.
     *
     * Note: a hard link to the listener may be kept so it must be explicitly
     * removed via {@link #removeDeviceEventListener()}.
     *
     * @param l the listener
     * @see AccelDeviceEventListener
     */
    public void addDeviceEventListener(AccelDeviceEventListener l);

    /**
     * Removes an {@code AccelDeviceEventListener} from the list of listeners
     * for this device's events.
     *
     * @param l the listener
     * @see AccelDeviceEventListener
     */
    public void removeDeviceEventListener(AccelDeviceEventListener l);
}

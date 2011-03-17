/*
 * BMPLoader.
 * 
 * JavaZOOM : jlgui@javazoom.net
 *            http://www.javazoom.net 
 *
 *-----------------------------------------------------------------------
 *   This program is free software; you can redistribute it and/or modify
 *   it under the terms of the GNU Library General Public License as published
 *   by the Free Software Foundation; either version 2 of the License, or
 *   (at your option) any later version.
 *
 *   This program is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU Library General Public License for more details.
 *
 *   You should have received a copy of the GNU Library General Public
 *   License along with this program; if not, write to the Free Software
 *   Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 *----------------------------------------------------------------------
 */
package javazoom.jlgui.player.amp.util;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ColorModel;
import java.awt.image.IndexColorModel;
import java.awt.image.MemoryImageSource;
import java.io.IOException;
import java.io.InputStream;

/**
 * A decoder for Windows bitmap (.BMP) files.
 * Compression not supported.
 */
public class BMPLoader
{
    private InputStream is;
    private int curPos = 0;
    private int bitmapOffset; // starting position of image data
    private int width; // image width in pixels
    private int height; // image height in pixels
    private short bitsPerPixel; // 1, 4, 8, or 24 (no color map)
    private int compression; // 0 (none), 1 (8-bit RLE), or 2 (4-bit RLE)
    private int actualSizeOfBitmap;
    private int scanLineSize;
    private int actualColorsUsed;
    private byte r[], g[], b[]; // color palette
    private int noOfEntries;
    private byte[] byteData; // Unpacked data
    private int[] intData; // Unpacked data

    public BMPLoader()
    {
    }

    public Image getBMPImage(InputStream stream) throws Exception
    {
        read(stream);
        return Toolkit.getDefaultToolkit().createImage(getImageSource());
    }

    protected int readInt() throws IOException
    {
        int b1 = is.read();
        int b2 = is.read();
        int b3 = is.read();
        int b4 = is.read();
        curPos += 4;
        return ((b4 << 24) + (b3 << 16) + (b2 << 8) + (b1 << 0));
    }

    protected short readShort() throws IOException
    {
        int b1 = is.read();
        int b2 = is.read();
        curPos += 4;
        return (short) ((b2 << 8) + b1);
    }

    protected void getFileHeader() throws IOException, Exception
    {
        // Actual contents (14 bytes):
        short fileType = 0x4d42;// always "BM"
        int fileSize; // size of file in bytes
        short reserved1 = 0; // always 0
        short reserved2 = 0; // always 0
        fileType = readShort();
        if (fileType != 0x4d42) throw new Exception("Not a BMP file"); // wrong file type
        fileSize = readInt();
        reserved1 = readShort();
        reserved2 = readShort();
        bitmapOffset = readInt();
    }

    protected void getBitmapHeader() throws IOException
    {
        // Actual contents (40 bytes):
        int size; // size of this header in bytes
        short planes; // no. of color planes: always 1
        int sizeOfBitmap; // size of bitmap in bytes (may be 0: if so, calculate)
        int horzResolution; // horizontal resolution, pixels/meter (may be 0)
        int vertResolution; // vertical resolution, pixels/meter (may be 0)
        int colorsUsed; // no. of colors in palette (if 0, calculate)
        int colorsImportant; // no. of important colors (appear first in palette) (0 means all are important)
        boolean topDown;
        int noOfPixels;
        size = readInt();
        width = readInt();
        height = readInt();
        planes = readShort();
        bitsPerPixel = readShort();
        compression = readInt();
        sizeOfBitmap = readInt();
        horzResolution = readInt();
        vertResolution = readInt();
        colorsUsed = readInt();
        colorsImportant = readInt();
        topDown = (height < 0);
        noOfPixels = width * height;
        // Scan line is padded with zeroes to be a multiple of four bytes
        scanLineSize = ((width * bitsPerPixel + 31) / 32) * 4;
        if (sizeOfBitmap != 0) actualSizeOfBitmap = sizeOfBitmap;
        else
        // a value of 0 doesn't mean zero - it means we have to calculate it
        actualSizeOfBitmap = scanLineSize * height;
        if (colorsUsed != 0) actualColorsUsed = colorsUsed;
        else
        // a value of 0 means we determine this based on the bits per pixel
        if (bitsPerPixel < 16) actualColorsUsed = 1 << bitsPerPixel;
        else actualColorsUsed = 0; // no palette
    }

    protected void getPalette() throws IOException
    {
        noOfEntries = actualColorsUsed;
        //IJ.write("noOfEntries: " + noOfEntries);
        if (noOfEntries > 0)
        {
            r = new byte[noOfEntries];
            g = new byte[noOfEntries];
            b = new byte[noOfEntries];
            int reserved;
            for (int i = 0; i < noOfEntries; i++)
            {
                b[i] = (byte) is.read();
                g[i] = (byte) is.read();
                r[i] = (byte) is.read();
                reserved = is.read();
                curPos += 4;
            }
        }
    }

    protected void unpack(byte[] rawData, int rawOffset, int[] intData, int intOffset, int w)
    {
        int j = intOffset;
        int k = rawOffset;
        int mask = 0xff;
        for (int i = 0; i < w; i++)
        {
            int b0 = (((int) (rawData[k++])) & mask);
            int b1 = (((int) (rawData[k++])) & mask) << 8;
            int b2 = (((int) (rawData[k++])) & mask) << 16;
            intData[j] = 0xff000000 | b0 | b1 | b2;
            j++;
        }
    }

    protected void unpack(byte[] rawData, int rawOffset, int bpp, byte[] byteData, int byteOffset, int w) throws Exception
    {
        int j = byteOffset;
        int k = rawOffset;
        byte mask;
        int pixPerByte;
        switch (bpp)
        {
        case 1:
            mask = (byte) 0x01;
            pixPerByte = 8;
            break;
        case 4:
            mask = (byte) 0x0f;
            pixPerByte = 2;
            break;
        case 8:
            mask = (byte) 0xff;
            pixPerByte = 1;
            break;
        default:
            throw new Exception("Unsupported bits-per-pixel value");
        }
        for (int i = 0;;)
        {
            int shift = 8 - bpp;
            for (int ii = 0; ii < pixPerByte; ii++)
            {
                byte br = rawData[k];
                br >>= shift;
                byteData[j] = (byte) (br & mask);
                //System.out.println("Setting byteData[" + j + "]=" + Test.byteToHex(byteData[j]));
                j++;
                i++;
                if (i == w) return;
                shift -= bpp;
            }
            k++;
        }
    }

    protected int readScanLine(byte[] b, int off, int len) throws IOException
    {
        int bytesRead = 0;
        int l = len;
        int r = 0;
        while (len > 0)
        {
            bytesRead = is.read(b, off, len);
            if (bytesRead == -1) return r == 0 ? -1 : r;
            if (bytesRead == len) return l;
            len -= bytesRead;
            off += bytesRead;
            r += bytesRead;
        }
        return l;
    }

    protected void getPixelData() throws IOException, Exception
    {
        byte[] rawData; // the raw unpacked data
        // Skip to the start of the bitmap data (if we are not already there)
        long skip = bitmapOffset - curPos;
        if (skip > 0)
        {
            is.skip(skip);
            curPos += skip;
        }
        int len = scanLineSize;
        if (bitsPerPixel > 8) intData = new int[width * height];
        else byteData = new byte[width * height];
        rawData = new byte[actualSizeOfBitmap];
        int rawOffset = 0;
        int offset = (height - 1) * width;
        for (int i = height - 1; i >= 0; i--)
        {
            int n = readScanLine(rawData, rawOffset, len);
            if (n < len) throw new Exception("Scan line ended prematurely after " + n + " bytes");
            if (bitsPerPixel > 8)
            {
                // Unpack and create one int per pixel
                unpack(rawData, rawOffset, intData, offset, width);
            }
            else
            {
                // Unpack and create one byte per pixel
                unpack(rawData, rawOffset, bitsPerPixel, byteData, offset, width);
            }
            rawOffset += len;
            offset -= width;
        }
    }

    public void read(InputStream is) throws IOException, Exception
    {
        this.is = is;
        getFileHeader();
        getBitmapHeader();
        if (compression != 0) throw new Exception("BMP Compression not supported");
        getPalette();
        getPixelData();
    }

    public MemoryImageSource getImageSource()
    {
        ColorModel cm;
        MemoryImageSource mis;
        if (noOfEntries > 0)
        {
            // There is a color palette; create an IndexColorModel
            cm = new IndexColorModel(bitsPerPixel, noOfEntries, r, g, b);
        }
        else
        {
            // There is no palette; use the default RGB color model
            cm = ColorModel.getRGBdefault();
        }
        // Create MemoryImageSource
        if (bitsPerPixel > 8)
        {
            // use one int per pixel
            mis = new MemoryImageSource(width, height, cm, intData, 0, width);
        }
        else
        {
            // use one byte per pixel
            mis = new MemoryImageSource(width, height, cm, byteData, 0, width);
        }
        return mis; // this can be used by JComponent.createImage()
    }
}

#include <stdlib.h>

#include <assert.h>

#include </usr/include/machine/types.h>
#include "macosx-window-system.h"

void CGLQueryPixelFormat(void* pixelFormat, int* iattrs, int niattrs, int* ivalues) {
  CGLPixelFormatObj pix = (CGLPixelFormatObj) pixelFormat;
  // FIXME: think about how specifying this might affect the API
  int virtualScreen = 0;

  int i;
  GLint value;
  for (i = 0; i < niattrs && iattrs[i]>0; i++) {
    CGLPixelFormatAttribute attr = (CGLPixelFormatAttribute) iattrs[i];
    if ( kCGLNoError == CGLDescribePixelFormat(pix, virtualScreen, attr, &value) ) {
        ivalues[i] = value;
    } else {
        ivalues[i] = 0;
    }
  }
}


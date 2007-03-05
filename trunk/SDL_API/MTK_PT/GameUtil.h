#ifndef GAME_UTIL_H_
#define GAME_UTIL_H_

#include "MTK.h"

/* Set up for C function definitions, even when using C++ */
#ifdef __cplusplus
extern "C" {
#endif

extern bool CdRect(int sx1, int sy1, int sx2, int sy2, int dx1, int dy1, int dx2, int dy2) ;
extern bool CdRectPoint(int sx1, int sy1, int sx2, int sy2, int dx, int dy) ;
extern bool CdRect2(int sx, int sy, int sw, int sh, int dx, int dy, int dw, int dh) ;
extern bool CdRectPoint2(int sx, int sy, int sw, int sh, int dx, int dy) ;

/* Ends C function definitions when using C++ */
#ifdef __cplusplus
}
#endif

#endif /*GAME_UTIL_H_*/
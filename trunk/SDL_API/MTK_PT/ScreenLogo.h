

#ifndef SCREEN_LOGO_H_
#define SCREEN_LOGO_H_

#include "GameHeader.h"

/* Set up for C function definitions, even when using C++ */
#ifdef __cplusplus
extern "C" {
#endif

extern tScreen ScreenLogo;

extern void Logo_Init();
extern void Logo_Destory();
extern void Logo_Logic();
extern void Logo_Render(tGraphics *g);
extern void Logo_Pause();
extern void Logo_Resume();

/* Ends C function definitions when using C++ */
#ifdef __cplusplus
}
#endif

#endif /*SCREEN_LOGO_H_*/



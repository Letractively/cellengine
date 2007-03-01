

#ifndef SCREEN_MAIN_H_
#define SCREEN_MAIN_H_

#include "GameHeader.h"

/* Set up for C function definitions, even when using C++ */
#ifdef __cplusplus
extern "C" {
#endif

extern tScreen ScreenMain;

extern void Main_Init();
extern void Main_Destory();
extern void Main_Logic();
extern void Main_Render(tGraphics *g);
extern void Main_Pause();
extern void Main_Resume();

/* Ends C function definitions when using C++ */
#ifdef __cplusplus
}
#endif

#endif /*SCREEN_LOGO_H_*/



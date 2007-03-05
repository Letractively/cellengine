#ifndef GAME_SPRITE_H_
#define GAME_SPRITE_H_

#include "GameHeader.h"

/* Set up for C function definitions, even when using C++ */
#ifdef __cplusplus
extern "C" {
#endif

#define SPR_TILE_COUNT	1
#define SPR_ANIM_COUNT	32
#define SPR_FRAM_COUNT	32

#define SPR_WIDTH		20
#define SPR_HEIGHT		20

///*精灵结构*/
//typedef struct tSprite 
//{
//	tImage*	tiles[SPR_TILE_COUNT];
//
//	s16		x;
//	s16		y;
//	u16		w;
//	u16		h;
//
//	u16		frames[SPR_ANIM_COUNT][SPR_FRAM_COUNT];
//
//	u16		curFrame;
//	u16		curAnimate;
//
//	
//
//}tSprite;
//
///*创建精灵*/
//extern tSprite*	SPR_CreateSprite();
//
///*销毁精灵*/
//extern void		SPR_Destory(tSprite *pSpr);
//
///*渲染精灵*/
//extern void		SPR_Render(tGraphics *pG, tSprite *pSpr);
//
///*设置当前帧*/
//extern void		SPR_SetCurFrame(tSprite *pSpr, u16 curAinmate, u16 curFrame);
//
///*循环播放动画*/
//extern void		SPR_NextCycFrame(tSprite *pSpr);
//
///*播放动画*/
//extern bool		SPR_NextFrame(tSprite *pSpr);
//


/* Ends C function definitions when using C++ */
#ifdef __cplusplus
}
#endif

#endif /*GAME_SPRITE_H_*/
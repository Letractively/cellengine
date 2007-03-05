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

///*����ṹ*/
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
///*��������*/
//extern tSprite*	SPR_CreateSprite();
//
///*���پ���*/
//extern void		SPR_Destory(tSprite *pSpr);
//
///*��Ⱦ����*/
//extern void		SPR_Render(tGraphics *pG, tSprite *pSpr);
//
///*���õ�ǰ֡*/
//extern void		SPR_SetCurFrame(tSprite *pSpr, u16 curAinmate, u16 curFrame);
//
///*ѭ�����Ŷ���*/
//extern void		SPR_NextCycFrame(tSprite *pSpr);
//
///*���Ŷ���*/
//extern bool		SPR_NextFrame(tSprite *pSpr);
//


/* Ends C function definitions when using C++ */
#ifdef __cplusplus
}
#endif

#endif /*GAME_SPRITE_H_*/


#include "GameSprite.h"



///*创建精灵*/
//tSprite*	SPR_CreateSprite()
//{
//	tSprite *ret = (tSprite *)malloc(sizeof(tSprite));
//	if(ret != NULL)
//	{
//		u32 hashcode = (u32)(ret);
//		ret->x				= 0;
//		ret->y				= 0;
//		ret->w				= SPR_WIDTH;
//		ret->h				= SPR_HEIGHT;
//		ret->curAnimate		= 0;
//		ret->curFrame		= 0;
//		DEBUG_Printf("New  Spr   : 0x%08X\n",hashcode);
//	}
//	return ret;
//}
//
///*销毁精灵*/
//void		SPR_Destory(tSprite *pSpr)
//{
//	//Free the surface
//	if( pSpr != NULL )
//	{
//		u32 hashcode = (u32)(pSpr);
//		free(pSpr);
//		DEBUG_Printf("Kill Spr   : 0x%08X\n",hashcode);
//	}
//	pSpr = NULL;
//}
//
//
///*渲染精灵*/
//void SPR_Render(tGraphics *pG, tSprite *pSpr)
//{
//	if( pG != NULL && pSpr != NULL )
//	{
//		GFX_DrawImage(
//			pG, 
//			pSpr->tiles[pSpr->frames[pSpr->curAnimate][pSpr->curFrame]],
//			pSpr->x,
//			pSpr->y,
//			0);
//	}
//}
//
///*设置当前帧*/
//void SPR_SetCurFrame(tSprite *pSpr, u16 curAnimate, u16 curFrame)
//{
//	if(pSpr != NULL)
//	{
//		if(curAnimate < SPR_ANIM_COUNT ){
//			pSpr->curAnimate = curAnimate;
//		}else{
//			pSpr->curAnimate = 0;
//		}
//
//		if(curFrame < SPR_FRAM_COUNT ){
//			pSpr->curFrame = curFrame;
//		}else{
//			pSpr->curFrame = 0;
//		}
//	}
//}
//
///*循环播放动画*/
//void SPR_NextCycFrame(tSprite *pSpr)
//{
//	pSpr->curFrame++;
//	pSpr->curFrame%=SPR_FRAM_COUNT;
//}
//
///*播放动画*/
//bool SPR_NextFrame(tSprite *pSpr)
//{
//	if( pSpr->curFrame<SPR_FRAM_COUNT ){
//		pSpr->curFrame++;
//		return false;
//	}else{
//		return true;
//	}
//}
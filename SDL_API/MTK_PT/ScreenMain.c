
#include "Screen.h"

#include "ResesScript.h"


extern void Main_Init();
extern void Main_Destory();
extern void Main_Logic();
extern void Main_Render(tGraphics *g);
extern void Main_Pause();
extern void Main_Resume();

tScreen ScreenMain =
{
	Main_Init,
	Main_Destory,
	Main_Logic,
	Main_Render,
	Main_Pause,
	Main_Resume
};


/***************************************************************************************************/
// spr res
typedef struct tBlock 
{
	u8		type;
	u8		anim;
	u8		frame;
	s16		x;
	s16		y;
	u16		w;
	u16		h;
}tBlock;

bool TouchBlock(tBlock *b1, tBlock *b2)
{	
	if (b2->x+b2->w <= b1->x)		return false;
	if (b1->x >= b2->x+b2->w)		return false;
	if (b2->y+b2->h <= b1->y)		return false;
	if (b1->y >= b2->y+b2->h)		return false;
	return true;
}
/***************************************************************************************************/
// dynamic
tImage* back ;

u16 curWorld ;

u16 curMap ;

s16 curSpr = -1;
s16 curPX = 0;
s16 curPY = 0;

/***************************************************************************************************/
void Main_Init()
{
	back = IMG_CreateImageFormFile("bg.png");
	TILE_Init();

	//curWorld	= WORLD_L01;
	curMap		= WORLD_GetMAP(curWorld);
	curSpr		= 0;

	FrameDelay = 40;
}

void Main_Destory()
{
	IMG_Destory(back);
	TILE_Kill();

}

void Main_Logic()
{
	int i;

	//按任意键将跳转到ScreenMain
	if(SCREEN_IsKeyDown(KEY_ANY))
	{
		SCREEN_ChangeScreen(&ScreenMenu);
	}

	curPX = SCREEN_GetPointerX() - SCREEN_GetPointerX()%MAP_GetCellW(curMap);
	curPY = SCREEN_GetPointerY() - SCREEN_GetPointerY()%MAP_GetCellH(curMap);

	for(i=0;i<WORLD_GetSprCount(curWorld);i++)
	{
		if(WORLD_GetSprANIM(curWorld,i)>=0){
			WORLD_TryMoveSpr(curWorld,i,0,1);
		}
	}
	if(SCREEN_IsPointerDown())
	{
		curSpr = WORLD_SelectSPR(curWorld,curPX,curPY);
		printf("spr=%d x=%d y=%d\n",curSpr,WORLD_GetSprX(curWorld,curSpr),WORLD_GetSprY(curWorld,curSpr));
	}
	if(SCREEN_IsPointerHold())
	{
		s16 dx = curPX - WORLD_GetSprX(curWorld,curSpr);
		s16 dy = curPY - WORLD_GetSprY(curWorld,curSpr);
		bool block = WORLD_TryMoveSpr(curWorld,curSpr,dx,0);
		if(block) curSpr = -1;
		//printf("dx=%d dy=%d %d \n",dx,dy,block);
	}
	
}


void Main_Render(tGraphics *g)
{
	//clear screen
	//绘制背景图片
	GFX_DrawImage(g,back,0,0,0);

	WORLD_Render(g,curWorld,0,0);

	SPR_Render(g,SPR_POINT,0,0,curPX,curPY);

	//显示FPS
	SCREEN_ShowFPS(g);
}

void Main_Pause()
{
}

void Main_Resume()
{
}

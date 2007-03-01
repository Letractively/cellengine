
#include "Screen.h"

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

#define BLOCK_COUNT 8
tImage* blocks[BLOCK_COUNT] ;
tImage* back ;

void Main_Init()
{
	int i;
	char id[32] ;
	
	FrameDelay = 1;
	back = IMG_CreateImageFormFile("img\\back.png");

	for(i=0;i<BLOCK_COUNT;i++)
	{
		sprintf_s(id,sizeof(id),"img\\B%d.png",i);
		blocks[i] = IMG_CreateImageFormFile(id);
	}

}

void Main_Destory()
{
	int i;
	for(i=0;i<BLOCK_COUNT;i++)
	{
		IMG_Destory(blocks[i]);
	}
	IMG_Destory(back);
}

void Main_Logic()
{
	FrameDelay = 1;

	//按任意键将跳转到ScreenLogo
	if(SCREEN_IsKeyDown(KEY_ANY))
	{
		SCREEN_ChangeScreen(&ScreenLogo);
	}

}


void Main_Render(tGraphics *g)
{
	int i;

	//clear screen
	//GFX_CleanRect(g,0,0,SCREEN_WIDTH,SCREEN_HEIGHT);
	//GFX_FillRect(g,0,0,SCREEN_WIDTH,SCREEN_HEIGHT,GFX_ToRGB(0,0xff,0));

	//绘制背景图片
	GFX_DrawImage(g,back,0,0,0);

	//绘制图片在指定位置
	for(i=0;i<BLOCK_COUNT;i++)
	{
		GFX_DrawImage(g,blocks[i],0,20*i,0);
	}

	//绘制图片在笔触点上
	GFX_DrawImage(g,blocks[0],SCREEN_GetPointerX(),SCREEN_GetPointerY(),0);


	//显示字符串
	GFX_DrawString(
		g,
		"Press Any Key !",
		SCREEN_WIDTH /2-GFX_GetStringWidth("Press Any Key !")/2,
		SCREEN_HEIGHT/2-GFX_GetStringHeight("Press Any Key !")/2,
		GFX_ToRGB(0,0xff,0)
		);

	//显示FPS
	SCREEN_ShowFPS(g);
}

void Main_Pause()
{
}

void Main_Resume()
{
}

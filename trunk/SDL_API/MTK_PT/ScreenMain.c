
#include "ScreenMain.h"


tScreen ScreenMain =
{
	Main_Init,
	Main_Destory,
	Main_Logic,
	Main_Render,
	Main_Pause,
	Main_Resume
};


tImage *ball ;
tImage *back ;

void Main_Init()
{
	
	ball = IMG_CreateImageFormFile("foo.png");
	back = IMG_CreateImageFormFile("background.png");
}

void Main_Destory()
{
	IMG_Destory(ball);
	IMG_Destory(back);
}

void Main_Logic()
{
	FrameDelay = 1;
}


void Main_Render(tGraphics *g)
{
	//clear screen
	//GFX_CleanRect(g,0,0,SCREEN_WIDTH,SCREEN_HEIGHT);
	//GFX_FillRect(g,0,0,SCREEN_WIDTH,SCREEN_HEIGHT,GFX_ToRGB(0,0xff,0));

	//���Ʊ���ͼƬ
	GFX_DrawImage(g,back,0,0,0);

	//����С���ڱʴ�����
	GFX_DrawImage(g,ball,SCREEN_GetPointerX(),SCREEN_GetPointerY(),0);

	//����С����ָ��λ��
	GFX_DrawImage(g,ball,SCREEN_WIDTH/2,SCREEN_HEIGHT/4,0);

	//��ʾFPS
	SCREEN_ShowFPS(g);
}

void Main_Pause()
{
}

void Main_Resume()
{
}

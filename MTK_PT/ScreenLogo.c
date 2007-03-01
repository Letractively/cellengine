
#include "ScreenLogo.h"

tScreen ScreenLogo =
{
	Logo_Init,
	Logo_Destory,
	Logo_Logic,
	Logo_Render,
	Logo_Pause,
	Logo_Resume
};


tImage *back ;

/*当前屏幕初始化*/
void Logo_Init()
{
	back = IMG_CreateImageFormFile("img\\back.png");
}
/*当前屏幕销毁*/
void Logo_Destory()
{
	IMG_Destory(back);
}

/*每周期执行一次的逻辑*/
void Logo_Logic()
{
	FrameDelay = 1;

	//按任意键将跳转到ScreenMain
	if(SCREEN_IsKeyDown(KEY_ANY))
	{
		SCREEN_ChangeScreen(&ScreenTable[1]);
	}
}

/*每周期执行一次的渲染*/
void Logo_Render(tGraphics *g)
{
	//clear screen
	//GFX_CleanRect(g,0,0,SCREEN_WIDTH,SCREEN_HEIGHT);
	//GFX_FillRect(g,0,0,SCREEN_WIDTH,SCREEN_HEIGHT,GFX_ToRGB(0,0xff,0));

	// 绘制背景图片
	GFX_DrawImage(g,back,0,0,0);

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

/*系统暂停事件*/
void Logo_Pause()
{
	printf("pause\n");
}

/*系统恢复事件*/
void Logo_Resume()
{
	printf("resume\n");
}

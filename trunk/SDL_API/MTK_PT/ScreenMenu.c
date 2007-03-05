
#include "Screen.h"

#include "MenuScript.h"

extern void Menu_Init();
extern void Menu_Destory();
extern void Menu_Logic();
extern void Menu_Render(tGraphics *g);
extern void Menu_Pause();
extern void Menu_Resume();

tScreen ScreenMenu =
{
	Menu_Init,
	Menu_Destory,
	Menu_Logic,
	Menu_Render,
	Menu_Pause,
	Menu_Resume
};

u16 Index = 1;


/*当前屏幕初始化*/
void Menu_Init()
{
	FrameDelay = 1;
}
/*当前屏幕销毁*/
void Menu_Destory()
{
}

/*每周期执行一次的逻辑*/
void Menu_Logic()
{
	//按任意键将跳转到ScreenMain
	if(SCREEN_IsKeyDown(KEY_C))
	{
		curWorld = Index;
		SCREEN_ChangeScreen(&ScreenMain);
	}
	if(SCREEN_IsKeyDown(KEY_DOWN))
	{
		if(WORLD_GetWorldText(Index+1)!=NULL){
			Index++;
		}
	}
	if(SCREEN_IsKeyDown(KEY_UP))
	{
		if(WORLD_GetWorldText(Index-1)!=NULL){
			Index--;
		}
	}
}

/*每周期执行一次的渲染*/
void Menu_Render(tGraphics *g)
{
	int i = 1;

	GFX_FillRect(g,0,0,SCREEN_WIDTH,SCREEN_HEIGHT,GFX_ToRGB(0,0,0));

	while(true){
		char* text = WORLD_GetWorldText(i);
		if(text==NULL)break;
		GFX_DrawString(g,text,4,i*GFX_GetStringHeight(text),Index==i?GFX_ToRGB(0xff,0xff,0xff):GFX_ToRGB(0,0xff,0));
		i++;
	}


	//显示FPS
	SCREEN_ShowFPS(g);
}

/*系统暂停事件*/
void Menu_Pause()
{
}

/*系统恢复事件*/
void Menu_Resume()
{
}

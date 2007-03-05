
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


/*��ǰ��Ļ��ʼ��*/
void Menu_Init()
{
	FrameDelay = 1;
}
/*��ǰ��Ļ����*/
void Menu_Destory()
{
}

/*ÿ����ִ��һ�ε��߼�*/
void Menu_Logic()
{
	//�����������ת��ScreenMain
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

/*ÿ����ִ��һ�ε���Ⱦ*/
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


	//��ʾFPS
	SCREEN_ShowFPS(g);
}

/*ϵͳ��ͣ�¼�*/
void Menu_Pause()
{
}

/*ϵͳ�ָ��¼�*/
void Menu_Resume()
{
}

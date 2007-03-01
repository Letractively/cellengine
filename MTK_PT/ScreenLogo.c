
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

/*��ǰ��Ļ��ʼ��*/
void Logo_Init()
{
	back = IMG_CreateImageFormFile("img\\back.png");
}
/*��ǰ��Ļ����*/
void Logo_Destory()
{
	IMG_Destory(back);
}

/*ÿ����ִ��һ�ε��߼�*/
void Logo_Logic()
{
	FrameDelay = 1;

	//�����������ת��ScreenMain
	if(SCREEN_IsKeyDown(KEY_ANY))
	{
		SCREEN_ChangeScreen(&ScreenTable[1]);
	}
}

/*ÿ����ִ��һ�ε���Ⱦ*/
void Logo_Render(tGraphics *g)
{
	//clear screen
	//GFX_CleanRect(g,0,0,SCREEN_WIDTH,SCREEN_HEIGHT);
	//GFX_FillRect(g,0,0,SCREEN_WIDTH,SCREEN_HEIGHT,GFX_ToRGB(0,0xff,0));

	// ���Ʊ���ͼƬ
	GFX_DrawImage(g,back,0,0,0);

	//��ʾ�ַ���
	GFX_DrawString(
		g,
		"Press Any Key !",
		SCREEN_WIDTH /2-GFX_GetStringWidth("Press Any Key !")/2,
		SCREEN_HEIGHT/2-GFX_GetStringHeight("Press Any Key !")/2,
		GFX_ToRGB(0,0xff,0)
		);

	//��ʾFPS
	SCREEN_ShowFPS(g);
}

/*ϵͳ��ͣ�¼�*/
void Logo_Pause()
{
	printf("pause\n");
}

/*ϵͳ�ָ��¼�*/
void Logo_Resume()
{
	printf("resume\n");
}

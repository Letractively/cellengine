
#include "Screen.h"

extern void Logo_Init();
extern void Logo_Destory();
extern void Logo_Logic();
extern void Logo_Render(tGraphics *g);
extern void Logo_Pause();
extern void Logo_Resume();

tScreen ScreenLogo =
{
	Logo_Init,
	Logo_Destory,
	Logo_Logic,
	Logo_Render,
	Logo_Pause,
	Logo_Resume
};

tImage *ball;
tImage *back ;

/*��ǰ��Ļ��ʼ��*/
void Logo_Init()
{
	FrameDelay = 1;
	back = IMG_CreateImageFormFile("back.png");
	ball = IMG_CreateImageFormFile("foo.png");
}
/*��ǰ��Ļ����*/
void Logo_Destory()
{
	IMG_Destory(back);
	IMG_Destory(ball);
}

/*ÿ����ִ��һ�ε��߼�*/
void Logo_Logic()
{
	

	//�����������ת��ScreenMain
	if(SCREEN_IsKeyDown(KEY_ANY))
	{
		SCREEN_ChangeScreen(&ScreenMain);
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

	//����ͼƬ��ָ��λ����
	GFX_DrawImage(g,ball,32,24,0);

	//����ͼƬ�ڱʴ�����
	GFX_DrawImage(g,ball,SCREEN_GetPointerX(),SCREEN_GetPointerY(),0);

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

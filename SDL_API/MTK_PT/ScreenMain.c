
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

// img res
#define BLOCK_COUNT 8

tImage* blocks[BLOCK_COUNT] ;
tImage* back ;
tImage* wall ;

// map res
#define MAP_W 8
#define MAP_H 8

u16	MapW;
u16 MapH;
u8 **MapData;

// spr res
typedef struct tBlock 
{
	u8		type;
	s16		x;
	s16		y;
	u16		w;
	u16		h;
}tBlock;


void Main_Init()
{
	int i;
	char id[32] ;
	
	FrameDelay = 1;
	back = IMG_CreateImageFormFile("img\\back.png");
	wall = IMG_CreateImageFormFile("img\\wall.png");
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
	IMG_Destory(wall);
}

void Main_Logic()
{
	FrameDelay = 1;

	//�����������ת��ScreenLogo
	if(SCREEN_IsKeyDown(KEY_ANY))
	{
		SCREEN_ChangeScreen(&ScreenLogo);
	}

}


void Main_Render(tGraphics *g)
{
	//int i;
	int x,y;
	//clear screen
	//GFX_CleanRect(g,0,0,SCREEN_WIDTH,SCREEN_HEIGHT);
	//GFX_FillRect(g,0,0,SCREEN_WIDTH,SCREEN_HEIGHT,GFX_ToRGB(0,0xff,0));

	//���Ʊ���ͼƬ
	GFX_DrawImage(g,back,0,0,0);

	////����ͼƬ��ָ��λ��
	//for(i=0;i<BLOCK_COUNT;i++)
	//{
	//	GFX_DrawImage(g,blocks[i],0,20*i,0);
	//}

	//����ͼƬ�ڱʴ�����
	GFX_DrawImage(g,blocks[0],SCREEN_GetPointerX(),SCREEN_GetPointerY(),0);

	for(y=0;y<MAP_H;y++){
		for(x=0;x<MAP_W;x++){
			if(MapData[y][x]>0)
			GFX_DrawImage(g,wall,x*20,y*20,0);
		}
	}
	

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

void Main_Pause()
{
}

void Main_Resume()
{
}

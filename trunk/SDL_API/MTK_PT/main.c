/*
* This source code copyrighted by 
* morefuntek' Productions (2006-2007) 
* author zhangyifei
*/

/*
˵����
����һ����Ϸ��ܣ�
����PCƽ̨ʵ�ֵ�MTK����include������API����û�������ļ�include����API��
��ּ�����κ�ƽ̨ʵ��֮�䣬ֻ��Ҫ�޸�
MTK_Header.h MTK.c
2���ļ����Ϳ���ƽ̨�޷���롣
�����ڿ�ʼ�����߼�����ת��ScreenLogo.c��
ScreenLogo.c������һЩ�ص���������������ʾ��ͼƬ����Ļ����ʾ�ķ����Լ�������ʾ�ķ���
ScreenMain.c��ʾ��ͼƬ��ʾ��ϸ�ڣ�����͸��ɫ���ڻ����Ͻ��л��ơ�

����ʾ��Microsoft Visual Studio 2005 VC IDE ����ͨ��
Include Lib ���ڡ�\dependence\Ŀ¼
*/
//The headers
#include "GameHeader.h"
#include "ScreenLogo.h"
#include "ScreenMain.h"

//
int main( int argc, char* args[] )
{
	//set Screen Change Table
	tScreen table[2] ;
	table[0] = ScreenLogo;
	table[1] = ScreenMain;
	ScreenTable = table;

	// init SubSystem
	SCREEN_WIDTH	= 176;
	SCREEN_HEIGHT	= 220;
	TEXT_SIZE		= 16;
	if( SCREEN_Init() == false )return 1;    
	printf("Screen W = %d\n",SCREEN_WIDTH);
	printf("Screen H = %d\n",SCREEN_HEIGHT);

	// frame delay FPS = 1000/40
	FrameDelay = 40;

	// change to ScreenLogo sub screen
	SCREEN_ChangeScreen(&ScreenTable[0]);

	// main Game Framework Run
	SCREEN_Run();

    // free SubSystem and quit 
	SCREEN_Quit();

    return 0;    
}

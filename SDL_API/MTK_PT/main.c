/*
* This source code copyrighted by 
* morefuntek' Productions (2006-2007) 
* author zhangyifei
*/

/*
˵����
����һ����Ϸ��ܣ�
����PCƽ̨ʵ�ֵ�MTK����include������API����û�������ļ�include����API��

�������õ���C��׼���API
printf
sprintf_s
malloc
free

��ּ�����κ�ƽ̨ʵ��֮�䣬ֻ��Ҫ�޸�

MTK_Header.h MTK.c
2���ļ����Ϳ���ƽ̨�޷���롣
����MTK_Header.h MTK.cΪ�˿�����ɵ�ǰ��Ϸ��Ҫ�Ѿ�ʵ���˲��ַ�����
ʵ�ֻ�������SDL lib
�����Ҫ�ο�PCʵ�ַ���������..\dependence\doc�� http://www.libsdl.org �����ĵ���

�����ڿ�ʼ�����߼�����ת��ScreenLogo.c��
ScreenLogo.c
������һЩ�ص���������������ʾ��ͼƬ����Ļ����ʾ�ķ���
�Լ�������ʾ�ķ���,ͼƬ��ʾ��ϸ�ڣ�����͸��ɫ���ڻ����Ͻ��л��ơ�


PC��ӳ��

KEY_LEFT		�������
KEY_RIGHT		�����Ҽ�
KEY_UP			�����ϼ�
KEY_DOWN;		�����¼�

KEY_0 ~ KEY_9	С��������

KEY_C			�м�
KEY_A			�����
KEY_B			�����
KEY_STAR		* ��
KEY_SHARE		# ��

�������Ͻ�����֮��ļ��̰���ȫ������

�ʴ����ģ��֧��

����ʾ��Microsoft Visual Studio 2005 VC IDE ����ͨ��
Include Lib Doc���ڡ�..\dependence\Ŀ¼
������Ŀ¼��  ..\debug\
*/


//The headers
#include "GameHeader.h"
#include "Screen.h"


//
int main( int argc, char* args[] )
{
	//set Screen Change Table
	//tScreen table[2] ;
	//table[0] = ScreenLogo;
	//table[1] = ScreenMain;
	//ScreenTable = table;

	// init SubSystem
	SCREEN_WIDTH	= 240;
	SCREEN_HEIGHT	= 320;
	TEXT_SIZE		= 16;
	if( SCREEN_Init() == false )return 1;    
	printf("Screen W = %d\n",SCREEN_WIDTH);
	printf("Screen H = %d\n",SCREEN_HEIGHT);

	// frame delay FPS = 1000/40
	FrameDelay = 40;

	// change to ScreenLogo sub screen
	SCREEN_ChangeScreen(&ScreenLogo);

	// main Game Framework Run
	SCREEN_Run();

    // free SubSystem and quit 
	SCREEN_Quit();

    return 0;    
}

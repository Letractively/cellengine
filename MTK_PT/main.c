/*
* This source code copyrighted by 
* morefuntek' Productions (2006-2007) 
* author zhangyifei
*/

/*
说明：
这是一个游戏框架，
除了PC平台实现的MTK方法include了其他API，并没有其他文件include其他API，
宗旨在于任何平台实现之间，只需要修改
MTK_Header.h MTK.c
2个文件，就可以平台无缝编译。
程序在开始，主逻辑将跳转到ScreenLogo.c，
ScreenLogo.c里面有一些回掉方法，本例子演示了图片在屏幕上显示的方法以及文字显示的方法
ScreenMain.c演示了图片显示的细节，包括透明色，在缓冲上进行绘制。

本演示在Microsoft Visual Studio 2005 VC IDE 编译通过
Include Lib 皆在　\dependence\目录
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

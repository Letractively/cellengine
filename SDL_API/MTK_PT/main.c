/*
* This source code copyrighted by 
* morefuntek' Productions (2006-2007) 
* author zhangyifei
*/

/*
说明：
这是一个游戏框架，
除了PC平台实现的MTK方法include了其他API，并没有其他文件include其他API，

程序中用到的C标准库的API
printf
sprintf_s
malloc
free

宗旨在于任何平台实现之间，只需要修改

MTK_Header.h MTK.c
2个文件，就可以平台无缝编译。
对于MTK_Header.h MTK.c为了快速完成当前游戏需要已经实现了部分方法。
实现基于是用SDL lib
如果需要参考PC实现方法，请在..\dependence\doc或 http://www.libsdl.org 查阅文挡：

程序在开始，主逻辑将跳转到ScreenLogo.c，
ScreenLogo.c
里面有一些回掉方法，本例子演示了图片在屏幕上显示的方法
以及文字显示的方法,图片显示的细节，包括透明色，在缓冲上进行绘制。


PC键映射

KEY_LEFT		键盘左键
KEY_RIGHT		键盘右键
KEY_UP			键盘上键
KEY_DOWN;		键盘下键

KEY_0 ~ KEY_9	小键盘数字

KEY_C			中键
KEY_A			左软键
KEY_B			右软键
KEY_STAR		* 键
KEY_SHARE		# 键

除了以上健定义之外的键盘按健全部忽略

笔触鼠标模拟支持

本演示在Microsoft Visual Studio 2005 VC IDE 编译通过
Include Lib Doc皆在　..\dependence\目录
程序工作目录在  ..\debug\
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

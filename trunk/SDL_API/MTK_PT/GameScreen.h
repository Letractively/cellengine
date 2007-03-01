/********************************************************************************************************************************
 * 平台无关游戏框架
 * 
 *********************************************************************************************************************************/
#ifndef GAME_SCREEN_H_
#define GAME_SCREEN_H_

#include "MTK.h"

/* Set up for C function definitions, even when using C++ */
#ifdef __cplusplus
extern "C" {
#endif

typedef struct tScreen
{
	void	(*NotifyInit)();				//回掉初始化
	void	(*NotifyDestory)();				//回掉退出
	void	(*NotifyLogic)();				//回掉逻辑函数(每周期执行一次)
	void	(*NotifyRender)(tGraphics *g);	//回掉渲染函数(每周期执行一次)
	void	(*NotifyPause)();				//暂停事件回掉
	void	(*NotifyResume)();				//恢复事件回掉
}tScreen;


/**游戏中的帧延迟，单位ms，比如预计游戏FPS=30，FrameDelay = 1000/30 = 33*/
u32	FrameDelay ;//default fps = 50
/**是否允许按键*/
bool KeyEnable ;
/**是否允许逻辑*/
bool LogicEnable ;
/**是否允许渲染*/
bool RenderEnable ;
/**是否允许切屏特效*/
bool TransitionEnable ;

/*帧计数器*/
u32	Timer;

/*Game Util Functions*/

extern void SCREEN_ChangeScreen(tScreen* next);


/**
* 启动
*/
extern bool SCREEN_Init();

/**
* 运行
*/
extern void SCREEN_Run();

/**
* 退出
*/
extern void SCREEN_Quit();


/**
* 检测指定的键是否被按下
* @param TheKey 键常量
* @return 
*/
extern bool SCREEN_IsKeyDown(int TheKey) ;

/**
* 检测指定的键是否松开
* @param TheKey
* @return 
*/
extern bool SCREEN_IsKeyUp(int TheKey) ;

/**
* 检测指定的键是否被按住
* @param TheKey
* @return 
*/
extern bool SCREEN_IsKeyHold(int TheKey) ;

/**
* 检测触摸屏是否点住
* @return 
*/
extern bool SCREEN_IsPointerHold() ;

/**
* 检测触摸屏是否被点下
* @return 
*/
extern bool SCREEN_IsPointerDown() ;

/**
* 检测触摸屏是否松开
* @return 
*/
extern bool SCREEN_IsPointerUp() ;

/**
* 检测触摸屏是否拖动
* @return 
*/
extern bool SCREEN_IsPointerDrag() ;

/**
* 得到触摸点位置
* @return 
*/
extern s16 SCREEN_GetPointerX();

/**
* 得到触摸点位置
* @return 
*/
extern s16 SCREEN_GetPointerY();


/*
* 得到FPS
*/
extern u32 SCREEN_GetFPS();

/*
* 显示FPS
*/
extern void SCREEN_ShowFPS(tGraphics *g);



/* Ends C function definitions when using C++ */
#ifdef __cplusplus
}
#endif

#endif/*GAME_SCREEN_H_*/
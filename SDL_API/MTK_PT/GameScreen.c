/*
* This source code copyrighted by 
* morefuntek' Productions (2006-2007) 
* author zhangyifei
*/


#include "GameScreen.h"

/********************************************************************************************************************
* Game Screen Util Functions
*
********************************************************************************************************************/


u32 KeyState = 0;//按键即时状态
u32 KeyDownState = 0;//按键按下状态
u32 KeyUpState = 0;//按键弹起状态

bool PointerState = false;//触摸屏状态
bool PointerDragState = false;
bool PointerDownState = false;
bool PointerUpState = false;

u32 CurKeyState = 0;//按键即时状态快照
u32 CurKeyDownState = 0;//按键按下状态快照
u32 CurKeyUpState = 0;//按键弹起状态快照
	
bool CurPointerState = false;//触摸屏状态快照
bool CurPointerDragState = false;
bool CurPointerDownState = false;
bool CurPointerUpState = false;


s16 PointerX;
s16 PointerY;



/*Input Key State Call Back*/

void KeyPressed(u32 keyCode) 
{
	KeyDownState |= keyCode;
	KeyState |= keyCode;
}

void KeyReleased(u32 keyCode) 
{
	KeyUpState   |= keyCode;
	KeyState &= (~keyCode);
}

void PointerPressed(s16 x, s16 y) {
	PointerState = true;
	PointerDownState = true;
	PointerDragState = false;
	PointerX = x;
	PointerY = y;
}

void PointerReleased(s16 x, s16 y) {
	PointerState = false;
	PointerUpState = true;
	PointerDragState = false;
	PointerX = x;
	PointerY = y;
}

void PointerDragged(s16 x, s16 y) {
	PointerDragState = true;
	PointerX = x;
	PointerY = y;
}


/*
* 查询按键并更新键状态 
*/
bool QueryKey(){

	if(KEY_QueryEvent()==false)return false;

	CurKeyState			= KeyState;
	CurKeyDownState		= KeyDownState;
	CurKeyUpState		= KeyUpState;

	CurPointerState		= PointerState;
	CurPointerDragState = PointerDragState;
	CurPointerDownState = PointerDownState;
	CurPointerUpState	= PointerUpState;

	KeyDownState		= 0;
	KeyUpState			= 0;

	PointerDownState	= false;
	PointerUpState		= false;
	PointerDragState	= false;

	return true;
}

void ClearKey()
{
	CurKeyState			= 0;
	CurKeyDownState		= 0;
	CurKeyUpState		= 0;

	CurPointerState		= false;
	CurPointerDragState = false;
	CurPointerDownState = false;
	CurPointerUpState	= false;

	KeyDownState		= 0;
	KeyUpState			= 0;

	PointerDownState	= false;
	PointerUpState		= false;
	PointerDragState	= false;
}


/********************************************************************************************************************/
// screen manage 


//sub screen
tScreen		*CurSubScreen = NULL;

tScreen		*NextSubScreen = NULL;


void TryChangeSubScreen()
{
	if(NextSubScreen != NULL)
	{
		if(CurSubScreen!=NULL)
		{
			// destory prew screen
			CurSubScreen->NotifyDestory();
		}
		
		CurSubScreen = NextSubScreen;
		// init new screen
		CurSubScreen->NotifyInit();

		NextSubScreen = NULL;

		Timer = 0;
	}
}







/********************************************************************************************************************/
// game frameworks
void SCREEN_ChangeScreen(tScreen* next)
{
	NextSubScreen = next;
}


/*Screen lost Call Back*/
void Pause()
{
	if( CurSubScreen != NULL )
	{
		CurSubScreen->NotifyPause();
	}
}
/*Screen Active Call Back*/
void Resume()
{
	if( CurSubScreen != NULL )
	{
		CurSubScreen->NotifyResume();
	}
}

/**
* 启动
*/
bool SCREEN_Init()
{
	//MTK System init
	if(MTK_Init()==false)return false;

	//Set System Call back function
	KEY_KeyPressed		= KeyPressed;
	KEY_KeyReleased		= KeyReleased;
	KEY_PointerPressed	= PointerPressed;
	KEY_PointerDragged	= PointerDragged;
	KEY_PointerReleased	= PointerReleased;
	MTK_Pause			= Pause;
	MTK_Resume			= Resume;

	FrameDelay			= 10;
	KeyEnable			= true;
	LogicEnable			= true;
	RenderEnable		= true;
	TransitionEnable	= true;

	return true;
}

/**
* 运行
*/
void SCREEN_Run()
{
	u32 UsedTime = 0;

	//While the user hasn't quit
    while( QueryKey() )
    {
		//得到当前时间
		UsedTime = TIME_GetTicks();

		TryChangeSubScreen();

		if( CurSubScreen != NULL )
		{
			if(!KeyEnable)
			{
				ClearKey();
			}

			if(LogicEnable)
			{
				// main screen logic call
				CurSubScreen->NotifyLogic();
			}

			if(RenderEnable)
			{
				// main screen render call
				CurSubScreen->NotifyRender(pScreen);
				//flush screen 
				GFX_Update(pScreen);
			}
		}
		
		//保持帧数维持在 1000/FrameDelay FPS
		UsedTime = TIME_GetTicks() - UsedTime;
		if (UsedTime < FrameDelay) {
			TIME_Delay(FrameDelay - UsedTime);
		}

		Timer ++;
	}

}





void SCREEN_Quit()
{
	//MTK System quit
	MTK_Quit();
}



/********************************************************************************************************************
* 外部函数
*
********************************************************************************************************************/


/********************************************************************************************************************/
// input 

bool SCREEN_IsKeyDown(int TheKey) {
	return (CurKeyDownState & TheKey) != 0;
}


bool SCREEN_IsKeyUp(int TheKey) {
	return (CurKeyUpState & TheKey) != 0;
}


bool SCREEN_IsKeyHold(int TheKey) {
	return (CurKeyState & TheKey) != 0;
}


bool SCREEN_IsPointerHold() {
	return (CurPointerState);
}


bool SCREEN_IsPointerDown() {
	return (CurPointerDownState);
}


bool SCREEN_IsPointerUp() {
	return (CurPointerUpState);
}


bool SCREEN_IsPointerDrag() {
	return (CurPointerDragState);
}


s16 SCREEN_GetPointerX(){
	return PointerX;
}


s16 SCREEN_GetPointerY(){
	return PointerY;
}


/********************************************************************************************************************/
// util 

// get fps
u32 CurRealTime = 0;
u32 SCREEN_GetFPS()
{
	u32 FPS ;
	FPS = (1000 / ((TIME_GetTicks() - CurRealTime) == 0 ? 1 : (TIME_GetTicks() - CurRealTime)));
	CurRealTime = TIME_GetTicks();

	return FPS;
}

//show fps
char		fps[10];
void SCREEN_ShowFPS(tGraphics *g)
{
	//show fps
	sprintf_s(fps,sizeof(fps),"FPS=%d",SCREEN_GetFPS());
	GFX_DrawString(g,fps,1,1,GFX_ToRGB(0xff,0xff,0xff));
}
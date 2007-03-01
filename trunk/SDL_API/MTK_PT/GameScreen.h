/********************************************************************************************************************************
 * ƽ̨�޹���Ϸ���
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
	void	(*NotifyInit)();				//�ص���ʼ��
	void	(*NotifyDestory)();				//�ص��˳�
	void	(*NotifyLogic)();				//�ص��߼�����(ÿ����ִ��һ��)
	void	(*NotifyRender)(tGraphics *g);	//�ص���Ⱦ����(ÿ����ִ��һ��)
	void	(*NotifyPause)();				//��ͣ�¼��ص�
	void	(*NotifyResume)();				//�ָ��¼��ص�
}tScreen;


/**��Ϸ�е�֡�ӳ٣���λms������Ԥ����ϷFPS=30��FrameDelay = 1000/30 = 33*/
u32	FrameDelay ;//default fps = 50
/**�Ƿ�������*/
bool KeyEnable ;
/**�Ƿ������߼�*/
bool LogicEnable ;
/**�Ƿ�������Ⱦ*/
bool RenderEnable ;
/**�Ƿ�����������Ч*/
bool TransitionEnable ;

/*֡������*/
u32	Timer;

/*Game Util Functions*/

extern void SCREEN_ChangeScreen(tScreen* next);


/**
* ����
*/
extern bool SCREEN_Init();

/**
* ����
*/
extern void SCREEN_Run();

/**
* �˳�
*/
extern void SCREEN_Quit();


/**
* ���ָ���ļ��Ƿ񱻰���
* @param TheKey ������
* @return 
*/
extern bool SCREEN_IsKeyDown(int TheKey) ;

/**
* ���ָ���ļ��Ƿ��ɿ�
* @param TheKey
* @return 
*/
extern bool SCREEN_IsKeyUp(int TheKey) ;

/**
* ���ָ���ļ��Ƿ񱻰�ס
* @param TheKey
* @return 
*/
extern bool SCREEN_IsKeyHold(int TheKey) ;

/**
* ��ⴥ�����Ƿ��ס
* @return 
*/
extern bool SCREEN_IsPointerHold() ;

/**
* ��ⴥ�����Ƿ񱻵���
* @return 
*/
extern bool SCREEN_IsPointerDown() ;

/**
* ��ⴥ�����Ƿ��ɿ�
* @return 
*/
extern bool SCREEN_IsPointerUp() ;

/**
* ��ⴥ�����Ƿ��϶�
* @return 
*/
extern bool SCREEN_IsPointerDrag() ;

/**
* �õ�������λ��
* @return 
*/
extern s16 SCREEN_GetPointerX();

/**
* �õ�������λ��
* @return 
*/
extern s16 SCREEN_GetPointerY();


/*
* �õ�FPS
*/
extern u32 SCREEN_GetFPS();

/*
* ��ʾFPS
*/
extern void SCREEN_ShowFPS(tGraphics *g);



/* Ends C function definitions when using C++ */
#ifdef __cplusplus
}
#endif

#endif/*GAME_SCREEN_H_*/
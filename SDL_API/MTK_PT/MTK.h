/********************************************************************************************************************************
 * MTK Game API
 * 
 * 该API规则定义了一系列游戏开发常用函数库，包括
 * 
 * 1、图象功能
 *    图片		
 *    绘图单元 
 * 2、键盘输入功能 
 * 3、声音功能 
 * 4、资源管理功能
 * 5、控制台输出(Debug)
 *  
 * 贵方可修改定义其中不合理的地方，以及添加新的功能模块
 *
 * 为了第一阶段项目的快速启动，以下是需要最高优先级需要实现的功能。
 *
 * IMG_CreateImageFormData
 * IMG_GetWidth
 * IMG_GetHeight
 * IMG_Destory
 *
 * GFX_GetLCDGraphics
 * GFX_DrawImage
 * GFX_CleanRect
 * GFX_Destory
 *
 * KEY_QueryEvent
 *
 * SND_PlaySound
 * SND_Stop
 * SND_Destory
 *
 *
 *********************************************************************************************************************************/

#ifndef MTK_H_
#define MTK_H_

#include "MTK_Header.h"

/* Set up for C function definitions, even when using C++ */
#ifdef __cplusplus
extern "C" {
#endif


/*******************************************************************************************************************
 * 公共         					
 * 	                            
 ********************************************************************************************************************/

//gobal var
//Screen attributes
int			SCREEN_WIDTH;/*屏幕宽*/
int			SCREEN_HEIGHT;/*屏幕高*/
int			TEXT_SIZE;/*字符大小*/
tGraphics	*pScreen;/*全局Screen指针*/


/*****************************************************************************
* FUNCTION
*	MTK_Init
* DESCRIPTION
*   初始化系统
* PARAMETERS
* RETURNS
* GLOBALS AFFECTED
*	NIL
****************************************************************************/ 
extern bool		MTK_Init();

/*****************************************************************************
* FUNCTION
*	MTK_Quit
* DESCRIPTION
*   结束系统
* PARAMETERS
* RETURNS
* GLOBALS AFFECTED
*	NIL
****************************************************************************/ 
extern void		MTK_Quit();

/*****************************************************************************
* CALL BACK FUNCTION
*	MTK_Pause
* DESCRIPTION
*   回掉函数
*   当来电或其他需要程序暂停的事件产生
* PARAMETERS
* RETURNS
* GLOBALS AFFECTED
*	NIL
****************************************************************************/ 
void	(*MTK_Pause)() ;

/*****************************************************************************
* CALL BACK FUNCTION
*	MTK_Resume
* DESCRIPTION
*   回掉函数
*   当从来电或其他需要程序暂停恢复后的事件产生
* PARAMETERS
* RETURNS
* GLOBALS AFFECTED
*	NIL
****************************************************************************/ 
void	(*MTK_Resume)() ;

/*******************************************************************************************************************
 * 图片 Image         					
 * 	                            
 * 绘制图片的基本单元，每个图片的表面又可以被重新绘制，也就是说Image相当于一个表面，表面的内容可以被修改。
 * 
 * 如果硬件支持DMA控制器把Flash里的图片复制到VRAM来高速绘图，那么可以定义一个静态Image的标志，
 * 相应的对Image表面的操作被屏蔽，如果调用修改绘制静态图片的操作，即输出异常信息。
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 ********************************************************************************************************************/

/*****************************************************************************
* FUNCTION
*	IMG_CreateImageFormData
* DESCRIPTION
*	从文件系统创建一个图片
* PARAMETERS
*	file 可以是支持的文件格式数据(比如GIF)
* RETURNS
*	tImage* 创建的图片
* GLOBALS AFFECTED
*	NIL
****************************************************************************/
extern tImage* 	IMG_CreateImageFormFile(const char * file);


/*****************************************************************************
* FUNCTION
*	IMG_CreateImageFormData
* DESCRIPTION
*	从Data创建一个图片
* PARAMETERS
*	Data 可以是支持的文件格式数据(比如GIF)
* RETURNS
*	tImage* 创建的图片
* GLOBALS AFFECTED
*	NIL
****************************************************************************/
extern tImage* 	IMG_CreateImageFormData(const u8 Data[]);


/*****************************************************************************
* FUNCTION
*	IMG_CreateImageFormPixel
* DESCRIPTION
*	从tRGB数组创建一个图元并指定宽高，(width*height <= PixelData.Length)
* PARAMETERS
*	PixelData tRGB数组
*   width     图片宽度
*   height    图片高度
* RETURNS
*	tImage* 创建的图片
* GLOBALS AFFECTED
*	NIL
****************************************************************************/
extern tImage* 	IMG_CreateImageFormPixel(const tRGB PixelData[], u16 width, u16 height);


/*****************************************************************************
* FUNCTION
*	IMG_CreateImageFormClip
* DESCRIPTION
*	把pSrcImage原图上的一个切片区域复制成一个新的图片
* PARAMETERS
*	pSrcImage 被切的原图
*   x         原图上的x开始点
*   y         原图上的y开始点
*   width     目的图片宽度
*   height    目的图片高度
* RETURNS
*	tImage* 创建的图片
* GLOBALS AFFECTED
*	NIL
****************************************************************************/
extern tImage* 	IMG_CreateImageFormClip(tImage *pSrcImage, u16 x, u16 y, u16 width, u16 height);



/*****************************************************************************
* FUNCTION
*	IMG_CreateImageFormSize
* DESCRIPTION
*	创建一个指定宽高和颜色的图片
* PARAMETERS
*   width     目的图片宽度
*   height    目的图片高度
*   color     填充的颜色
* RETURNS
*	tImage* 创建的图片
* GLOBALS AFFECTED
*	NIL
****************************************************************************/
extern tImage* 	IMG_CreateImageFormSize(u16 width, u16 height, tRGB color);


/*****************************************************************************
* FUNCTION
*	IMG_GetGraphics
* DESCRIPTION
*	从一个图片上得到该图片的绘图单元，可以用该绘图单元往指定图片上再次绘图
* PARAMETERS
*   *pImage 指定的图片
* RETURNS
*	tGraphics* 创建的绘图单元
* GLOBALS AFFECTED
*	NIL
****************************************************************************/
extern tGraphics*  IMG_GetGraphics(tImage *pImage);




/*****************************************************************************
* FUNCTION
*	IMG_GetHeight
* DESCRIPTION
*	得到图片的象素高度
* PARAMETERS
*   *pImage 指定的图片
* RETURNS
*	u16      图片高度
* GLOBALS AFFECTED
*	NIL
****************************************************************************/           
extern u16 	IMG_GetHeight(tImage *pImage);


/*****************************************************************************
* FUNCTION
*	IMG_GetWidth
* DESCRIPTION
*	得到图片的象素宽度
* PARAMETERS
*   *pImage 指定的图片
* RETURNS
*	u16      图片宽度
* GLOBALS AFFECTED
*	NIL
****************************************************************************/         
extern u16 	IMG_GetWidth(tImage *pImage);


/*****************************************************************************
* FUNCTION
*	IMG_Destory
* DESCRIPTION
*	把图片从内存中销毁
* PARAMETERS
*   *pImage 指定的图片
* RETURNS
*   void
* GLOBALS AFFECTED
*	NIL
****************************************************************************/ 
extern void IMG_Destory(tImage* pImage);

          
          
          
          
          
          
/******************************************************************************************************************
 * 绘图单元 Graphics       
 * 
 * Graphics 相当于一个画笔，把内容画到和Graphics对应的表面。
 * Graphics可以从系统的LCD得到，也可以从Image得到。
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 *  						                        
 ****************************************************************************************************************/


/*****************************************************************************
* FUNCTION
*	GFX_GetLCDGraphics
* DESCRIPTION
*	得到当前LCD屏幕的Graphics
* PARAMETERS
*   void
* RETURNS
*   tGraphics* 当前LCD屏幕的绘图单元
* GLOBALS AFFECTED
*	NIL
****************************************************************************/ 
extern tGraphics* 	GFX_GetLCDGraphics(void);


/*****************************************************************************
* FUNCTION
*	GFX_ToRGB
* DESCRIPTION
*	建立颜色
* PARAMETERS
*   r
*   g
*   b
* RETURNS
*   tRGB
* GLOBALS AFFECTED
*	NIL
****************************************************************************/ 
extern tRGB		GFX_ToRGB(u8 r, u8 g, u8 b);

/*****************************************************************************
* FUNCTION
*	GFX_ToRGB2
* DESCRIPTION
*	建立颜色
* PARAMETERS
*   rgb
* RETURNS
*   tRGB
* GLOBALS AFFECTED
*	NIL
****************************************************************************/ 
extern tRGB		GFX_ToRGB2(u32 rgb);


/*****************************************************************************
* FUNCTION
*	GFX_GetRGB
* DESCRIPTION
*	得到指定位置的象素
* PARAMETERS
*   *pG		指定的G
*   x       x坐标
*   y       y坐标
* RETURNS
*	tRGB    象素
* GLOBALS AFFECTED
*	NIL
****************************************************************************/
extern tRGB		GFX_GetRGB(tGraphics *pG, u16 x, u16 y);

/*****************************************************************************
* FUNCTION
*	GFX_SetRGB
* DESCRIPTION
*	设置指定位置的象素
* PARAMETERS
*   *pG		指定的G
*   x       x坐标
*   y       y坐标
*   rgb		颜色
* RETURNS
*	void
* GLOBALS AFFECTED
*	NIL
****************************************************************************/
extern void		GFX_SetRGB(tGraphics *pG, u16 x, u16 y, tRGB rgb);

/*****************************************************************************
* FUNCTION
*	GFX_DrawArc
* DESCRIPTION
*   画一个正圆或椭圆的圆圈从指定角度和一个指定的矩形，该圆刚好包含在该矩形内，
*   比如在屏幕3,4点画一个宽为16高为8的椭圆：GFX_DrawArc(pG, 3, 4, 16, 8, 0, 360 , color);
*   比如在屏幕3,4点画一个宽高为8的 "C" 样的圆弧：GFX_DrawArc(pG, 3, 4, 8, 8, 45, 360 - 90, color);
* PARAMETERS
*   pG			当前绘图单元
*   x			将要绘制到的x位置
*   y			将要绘制到的y位置
*   width		包含整个圆的宽度
*   height		包含整个圆的高度
*   startAngle  开始的角度
*   arcAngle    角度的距离
*   color       颜色
* RETURNS
*   void
* GLOBALS AFFECTED
*	NIL
****************************************************************************/ 
extern void GFX_DrawArc(tGraphics* pG, s16 x, s16 y, u16 width, u16 height, s16 startAngle, s16 arcAngle, tRGB color);

         
/*****************************************************************************
* FUNCTION
*	GFX_DrawLine
* DESCRIPTION
*   画一个直线段
* PARAMETERS
*   pG			当前绘图单元
*   x1			线段开始x位置
*   y1			线段开始y位置
*   x2			线段结束x位置
*   y2			线段结束x位置
*   color       颜色
* RETURNS
*   void
* GLOBALS AFFECTED
*	NIL
****************************************************************************/ 
extern void GFX_DrawLine(tGraphics* pG, s16 x1, s16 y1, s16 x2, s16 y2, tRGB color);


/*****************************************************************************
* FUNCTION
*	GFX_DrawRect
* DESCRIPTION
*   画一个矩形框
* PARAMETERS
*   pG			当前绘图单元
*   x 			矩形Left位置
*   y 			矩形Top位置
*   width		矩形宽
*   height		矩形高
*   color       颜色
* RETURNS
*   void
* GLOBALS AFFECTED
*	NIL
****************************************************************************/ 
extern void GFX_DrawRect(tGraphics* pG, s16 x, s16 y, s16 width, s16 height, tRGB color);


/*****************************************************************************
* FUNCTION
*	GFX_DrawString
* DESCRIPTION
*   画一个字符串
* PARAMETERS
*   pG			当前绘图单元
*   str			字符串
*   x 			矩形Left位置
*   y 			矩形Top位置
*   color       颜色
* RETURNS
*   void
* GLOBALS AFFECTED
*	NIL
****************************************************************************/ 
extern void GFX_DrawString(tGraphics* pG, const char* str, s16 x, s16 y, tRGB color );

/*****************************************************************************
* FUNCTION
*	GFX_GetStringWidth
* DESCRIPTION
*   得到一个字符串的象素宽度
* PARAMETERS
*   str			字符串
* RETURNS
*   u16			字符串宽度
* GLOBALS AFFECTED
*	NIL
****************************************************************************/ 
extern u16 GFX_GetStringWidth(char* str);

/*****************************************************************************
* FUNCTION
*	GFX_GetStringHeight
* DESCRIPTION
*   得到一个字符串的象素高度
* PARAMETERS
*   str			字符串
* RETURNS
*   u16			字符串高度
* GLOBALS AFFECTED
*	NIL
****************************************************************************/ 
extern u16 GFX_GetStringHeight(char* str);




/*****************************************************************************
* FUNCTION
*	GFX_FillArc
* DESCRIPTION
*   填充个正圆或椭圆从指定角度和一个指定的矩形，该圆刚好包含在该矩形内，
*   比如在屏幕3,4点画一个宽为16高为8的椭圆：GFX_DrawArc(pG, 3, 4, 16, 8, 0, 360 , color);
*   比如在屏幕3,4点画一个宽高为8的 "C" 样的圆弧：GFX_DrawArc(pG, 3, 4, 8, 8, 45, 360 - 90, color);
* PARAMETERS
*   pG			当前绘图单元
*   x			将要绘制到的x位置
*   y			将要绘制到的y位置
*   width		包含整个圆的宽度
*   height		包含整个圆的高度
*   startAngle  开始的角度
*   arcAngle    角度的距离
*   color       颜色
* RETURNS
*   void
* GLOBALS AFFECTED
*	NIL
****************************************************************************/ 
extern void GFX_FillArc(tGraphics* pG, s16 x, s16 y, u16 width, u16 height, s16 startAngle, s16 arcAngle, tRGB color);

 

/*****************************************************************************
* FUNCTION
*	GFX_FillRect
* DESCRIPTION
*   填充一个矩形框
* PARAMETERS
*   pG			当前绘图单元
*   x 			矩形Left位置
*   y 			矩形Top位置
*   width		矩形宽
*   height		矩形高
*   color       颜色
* RETURNS
*   void
* GLOBALS AFFECTED
*	NIL
****************************************************************************/ 
extern void GFX_FillRect(tGraphics* pG, s16 x, s16 y, u16 width, u16 height, tRGB color);


/* 画图片时的翻转参数 */
#define 	TRANS_NONE   	0	/* 不翻转 */
#define 	TRANS_H  		2	/* 水平翻转 */
#define 	TRANS_V   		1	/* 垂直翻转 */
#define 	TRANS_HV   		3	/* 180度翻转 */
#define 	TRANS_180   	3	/* 180 = HV */
#define 	TRANS_90   		6	/* 逆时针90度翻转 */
#define 	TRANS_270   	5	/* 逆时针270度翻转 */
#define 	TRANS_H90   	4	/* 先逆时针90度翻转，然后在水平翻转 */
#define 	TRANS_V90   	7	/* 先逆时针90度翻转，然后在垂直翻转 */


/*****************************************************************************
* FUNCTION
*	GFX_DrawRect
* DESCRIPTION
*   画一张图片，按照左上角对齐
* PARAMETERS
*   pG			当前绘图单元
*   pImage*		要画的图片		
*   x 			图片x位置
*   y 			图片y位置
*   transform   图片翻转参数
* RETURNS
*   void
* GLOBALS AFFECTED
*	NIL
****************************************************************************/ 
extern void GFX_DrawImage(tGraphics* pG, tImage* pImage, s16 x, s16 y, u8 transform);


/*****************************************************************************
* FUNCTION
*	GFX_DrawRect
* DESCRIPTION
*   只画一张图片上的一个区域，按照左上角对齐
* PARAMETERS
*   pG			当前绘图单元
*   pSrcImage*	要画的图片		
*   x_src		原图的x位置
*   y_src 		原图的y位置
*   width		原图里区域的宽
*   height		原图里区域的高
*   transform  	图片翻转参数
*   x_dest		图片绘制的目的x位置
*   y_dest		图片绘制的目的y位置
* RETURNS
*   void
* GLOBALS AFFECTED
*	NIL
****************************************************************************/ 
extern void GFX_DrawRegion(
						   tGraphics* pG, 
						   tImage *pSrcImage, 
						   s16 x_src, 
						   s16 y_src, 
						   u16 width, 
						   u16 height, 
						   u8 transform, 
						   s16 x_dest, 
						   s16 y_dest);

 
/*****************************************************************************
* FUNCTION
*	GFX_CleanRect
* DESCRIPTION
*   把指定的tGraphics对应的表面的一个区域清空成透明色
* PARAMETERS
*   pG			当前绘图单元	
*   x			清空区域的x位置
*   y			清空区域的y位置
*   width		清空区域的宽
*   height		清空区域的高
* RETURNS
*   void
* GLOBALS AFFECTED
*	NIL
****************************************************************************/ 
extern void GFX_CleanRect(tGraphics* pG, s16 x, s16 y, s16 width, s16 height);


/*****************************************************************************
* FUNCTION
*	GFX_CleanRect
* DESCRIPTION
*   把指定的tGraphics对应的表面的一个区域清空成透明色
* PARAMETERS
*   pG			当前绘图单元	
*   x			清空区域的x位置
*   y			清空区域的y位置
*   width		清空区域的宽
*   height		清空区域的高
* RETURNS
*   void
* GLOBALS AFFECTED
*	NIL
****************************************************************************/ 
extern void GFX_Update(tGraphics* pG);


/*****************************************************************************
* FUNCTION
*	GFX_Destory
* DESCRIPTION
*   把绘图单元从内存中销毁
* PARAMETERS
*   pG			当前绘图单元	
* RETURNS
*   void
* GLOBALS AFFECTED
*	NIL
****************************************************************************/ 
extern void GFX_Destory(tGraphics* pG);





/***************************************************************************************************************************************************
* 键盘响应	Key Input        
* 
* 
* 
* 
* 
* 
* 
* 
* 
* 			    	                        
****************************************************************************************************************************************************/

/* 按键值 */
#define		KEY_0		(0x00000001)			//数字键 0
#define		KEY_1 		(0x00000002)			//数字键 1
#define		KEY_2		(0x00000004)			//数字键 2
#define		KEY_3		(0x00000008)			//数字键 3
#define		KEY_4		(0x00000010)			//数字键 4
#define		KEY_5		(0x00000020)			//数字键 5
#define		KEY_6		(0x00000040)			//数字键 6
#define		KEY_7		(0x00000080)			//数字键 7
#define		KEY_8		(0x00000100)			//数字键 8
#define		KEY_9		(0x00000200)			//数字键 9

#define		KEY_SHARE	(0x00000400)			//# 键
#define		KEY_STAR	(0x00000800) 			//* 键
#define		KEY_A		(0x00001000)			//左软键
#define		KEY_B		(0x00002000)			//右软键
#define		KEY_C		(0x00004000)			//中键

#define		KEY_LEFT	(0x00008000)			//方向左键
#define		KEY_RIGHT	(0x00010000)			//方向右键
#define		KEY_UP		(0x00020000)			//方向上键
#define		KEY_DOWN	(0x00040000)			//方向下键

#define		KEY_ANY		(0xffffffff)

/*****************************************************************************
* FUNCTION
*	KEY_QueryEvent
* DESCRIPTION
*   每游戏周期执行一次查询键盘,
*   while(!exit)
*   {
*       exit = !KEY_QueryEvent();
*       ...
*       gameloop
*       ... 
*   }
*
*   在该函数里要对以下事件进行回掉
*		KEY_KeyPressed
*		KEY_KeyReleased
*		KEY_PointerPressed
*		KEY_PointerDragged
*		KEY_PointerReleased
*		MTK_Pause
*		MTK_Resume
*   
* PARAMETERS
*   void
* RETURNS
*   bool false=如果系统退出事件 true=正常
* GLOBALS AFFECTED
*	NIL
****************************************************************************/            	
extern bool KEY_QueryEvent(void);          	
          	
          	
/*****************************************************************************
* CALL BACK FUNCTION
*	KEY_keyPressed
* DESCRIPTION
*   回掉函数
*   当键盘有键按下的时候发生，并传入参数 keyCode 表示哪个键被按下
* PARAMETERS
*   keyCode			哪个键被按下
* RETURNS
*   void
* GLOBALS AFFECTED
*	NIL
****************************************************************************/  	
void	(*KEY_KeyPressed)(u32 keyCode);

/*****************************************************************************
* CALL BACK FUNCTION
*	KEY_keyReleased
* DESCRIPTION
*   回掉函数
*   当键盘有键松开的时候发生，并传入参数 keyCode 表示哪个键被松开
* PARAMETERS
*   keyCode			哪个键被松开
* RETURNS
*   void
* GLOBALS AFFECTED
*	NIL
****************************************************************************/  	
void	(*KEY_KeyReleased)(u32 keyCode) ;

/*****************************************************************************
* CALL BACK FUNCTION
*	KEY_pointerPressed
* DESCRIPTION
*   回掉函数
*   当触摸屏被点击后发生
* PARAMETERS
*   x		触摸屏x坐标
* 	y		触摸屏y坐标
* RETURNS
*   void
* GLOBALS AFFECTED
*	NIL
****************************************************************************/ 
void	(*KEY_PointerPressed)(s16 x, s16 y) ;

/*****************************************************************************
* CALL BACK FUNCTION
*	KEY_pointerReleased
* DESCRIPTION
*   回掉函数
*   当触摸屏被松开后发生
* PARAMETERS
*   x		触摸屏x坐标
* 	y		触摸屏y坐标
* RETURNS
*   void
* GLOBALS AFFECTED
*	NIL
****************************************************************************/ 
void	(*KEY_PointerReleased)(s16 x, s16 y) ;

/*****************************************************************************
* CALL BACK FUNCTION
*	KEY_pointerDragged
* DESCRIPTION
*   回掉函数
*   当触摸屏被拖动后发生
* PARAMETERS
*   x		触摸屏拖动后x坐标
* 	y		触摸屏拖动后y坐标
* RETURNS
*   void
* GLOBALS AFFECTED
*	NIL
****************************************************************************/ 
void	(*KEY_PointerDragged)(s16 x, s16 y) ;
	
	
	
	
	
/****************************************************************************************************************************************************/
/* 时间 Timer        			    	                        
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
/****************************************************************************************************************************************************/

/*****************************************************************************
* FUNCTION
*	TIME_GetTicks
* DESCRIPTION
*   得到从MTK_Init后，程序运行的毫秒时间
* PARAMETERS
* RETURNS
*   u32 毫秒
* GLOBALS AFFECTED
*	NIL
****************************************************************************/ 
extern u32 TIME_GetTicks();

	
/*****************************************************************************
* FUNCTION
*	TIME_Delay
* DESCRIPTION
*   让当前线程Sleep
* PARAMETERS
*   ms	线程Sleep的时间，单位毫秒
* RETURNS
*   void
* GLOBALS AFFECTED
*	NIL
****************************************************************************/ 
extern void TIME_Delay(u32 ms);


/****************************************************************************************************************************************************/
/* 声音	Sound  		        			    	                        
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
/****************************************************************************************************************************************************/



/*****************************************************************************
* FUNCTION
*	SND_PlaySound
* DESCRIPTION
*   播放声音
* PARAMETERS
*   *pSound		要播放的资源
* 	loopCount	循环次数，负为无限循环
* RETURNS
*   void
* GLOBALS AFFECTED
*	NIL
****************************************************************************/  	
extern void SND_PlaySound(tSound *pSound, s8 loopCount);

/*****************************************************************************
* FUNCTION
*	SND_Stop
* DESCRIPTION
*   停止播放声音
* PARAMETERS
*   *pSound		要停止播放的资源
* RETURNS
*   void
* GLOBALS AFFECTED
*	NIL
****************************************************************************/ 
extern void SND_Stop(tSound *pSound);

/*****************************************************************************
* FUNCTION
*	SND_Destory
* DESCRIPTION
*   声音资源从内存中销毁
* PARAMETERS
*   *pSound		要销毁的资源
* RETURNS
*   void
* GLOBALS AFFECTED
*	NIL
****************************************************************************/ 
extern void SND_Destory(tSound *pSound);


/****************************************************************************************************************************************************/
/* 文件或资源管理  		
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
/****************************************************************************************************************************************************/
          

//null or extends


















/****************************************************************************************************************************************************/
/* 控制台输出 Console  	    		
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
/****************************************************************************************************************************************************/


/*****************************************************************************
* FUNCTION
*	DEBUG_Printf
* DESCRIPTION
*   把字符信息打印到设备以方便调试
* PARAMETERS
*   *msg		信息
* RETURNS
*   void
* GLOBALS AFFECTED
*	NIL
****************************************************************************/
//extern void DEBUG_Printf(char* msg,...);

#define DEBUG_Printf printf









/* Ends C function definitions when using C++ */
#ifdef __cplusplus
}
#endif

#endif /*MTK_H_*/









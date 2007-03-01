/********************************************************************************************************************************
 * MTK Game API
 * 
 * ��API��������һϵ����Ϸ�������ú����⣬����
 * 
 * 1��ͼ����
 *    ͼƬ		
 *    ��ͼ��Ԫ 
 * 2���������빦�� 
 * 3���������� 
 * 4����Դ������
 * 5������̨���(Debug)
 *  
 * �󷽿��޸Ķ������в�����ĵط����Լ�����µĹ���ģ��
 *
 * Ϊ�˵�һ�׶���Ŀ�Ŀ�����������������Ҫ������ȼ���Ҫʵ�ֵĹ��ܡ�
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
 * ����         					
 * 	                            
 ********************************************************************************************************************/

//gobal var
//Screen attributes
int			SCREEN_WIDTH;/*��Ļ��*/
int			SCREEN_HEIGHT;/*��Ļ��*/
int			TEXT_SIZE;/*�ַ���С*/
tGraphics	*pScreen;/*ȫ��Screenָ��*/


/*****************************************************************************
* FUNCTION
*	MTK_Init
* DESCRIPTION
*   ��ʼ��ϵͳ
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
*   ����ϵͳ
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
*   �ص�����
*   �������������Ҫ������ͣ���¼�����
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
*   �ص�����
*   ���������������Ҫ������ͣ�ָ�����¼�����
* PARAMETERS
* RETURNS
* GLOBALS AFFECTED
*	NIL
****************************************************************************/ 
void	(*MTK_Resume)() ;

/*******************************************************************************************************************
 * ͼƬ Image         					
 * 	                            
 * ����ͼƬ�Ļ�����Ԫ��ÿ��ͼƬ�ı����ֿ��Ա����»��ƣ�Ҳ����˵Image�൱��һ�����棬��������ݿ��Ա��޸ġ�
 * 
 * ���Ӳ��֧��DMA��������Flash���ͼƬ���Ƶ�VRAM�����ٻ�ͼ����ô���Զ���һ����̬Image�ı�־��
 * ��Ӧ�Ķ�Image����Ĳ��������Σ���������޸Ļ��ƾ�̬ͼƬ�Ĳ�����������쳣��Ϣ��
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
*	���ļ�ϵͳ����һ��ͼƬ
* PARAMETERS
*	file ������֧�ֵ��ļ���ʽ����(����GIF)
* RETURNS
*	tImage* ������ͼƬ
* GLOBALS AFFECTED
*	NIL
****************************************************************************/
extern tImage* 	IMG_CreateImageFormFile(const char * file);


/*****************************************************************************
* FUNCTION
*	IMG_CreateImageFormData
* DESCRIPTION
*	��Data����һ��ͼƬ
* PARAMETERS
*	Data ������֧�ֵ��ļ���ʽ����(����GIF)
* RETURNS
*	tImage* ������ͼƬ
* GLOBALS AFFECTED
*	NIL
****************************************************************************/
extern tImage* 	IMG_CreateImageFormData(const u8 Data[]);


/*****************************************************************************
* FUNCTION
*	IMG_CreateImageFormPixel
* DESCRIPTION
*	��tRGB���鴴��һ��ͼԪ��ָ����ߣ�(width*height <= PixelData.Length)
* PARAMETERS
*	PixelData tRGB����
*   width     ͼƬ���
*   height    ͼƬ�߶�
* RETURNS
*	tImage* ������ͼƬ
* GLOBALS AFFECTED
*	NIL
****************************************************************************/
extern tImage* 	IMG_CreateImageFormPixel(const tRGB PixelData[], u16 width, u16 height);


/*****************************************************************************
* FUNCTION
*	IMG_CreateImageFormClip
* DESCRIPTION
*	��pSrcImageԭͼ�ϵ�һ����Ƭ�����Ƴ�һ���µ�ͼƬ
* PARAMETERS
*	pSrcImage ���е�ԭͼ
*   x         ԭͼ�ϵ�x��ʼ��
*   y         ԭͼ�ϵ�y��ʼ��
*   width     Ŀ��ͼƬ���
*   height    Ŀ��ͼƬ�߶�
* RETURNS
*	tImage* ������ͼƬ
* GLOBALS AFFECTED
*	NIL
****************************************************************************/
extern tImage* 	IMG_CreateImageFormClip(tImage *pSrcImage, u16 x, u16 y, u16 width, u16 height);



/*****************************************************************************
* FUNCTION
*	IMG_CreateImageFormSize
* DESCRIPTION
*	����һ��ָ����ߺ���ɫ��ͼƬ
* PARAMETERS
*   width     Ŀ��ͼƬ���
*   height    Ŀ��ͼƬ�߶�
*   color     ������ɫ
* RETURNS
*	tImage* ������ͼƬ
* GLOBALS AFFECTED
*	NIL
****************************************************************************/
extern tImage* 	IMG_CreateImageFormSize(u16 width, u16 height, tRGB color);


/*****************************************************************************
* FUNCTION
*	IMG_GetGraphics
* DESCRIPTION
*	��һ��ͼƬ�ϵõ���ͼƬ�Ļ�ͼ��Ԫ�������øû�ͼ��Ԫ��ָ��ͼƬ���ٴλ�ͼ
* PARAMETERS
*   *pImage ָ����ͼƬ
* RETURNS
*	tGraphics* �����Ļ�ͼ��Ԫ
* GLOBALS AFFECTED
*	NIL
****************************************************************************/
extern tGraphics*  IMG_GetGraphics(tImage *pImage);




/*****************************************************************************
* FUNCTION
*	IMG_GetHeight
* DESCRIPTION
*	�õ�ͼƬ�����ظ߶�
* PARAMETERS
*   *pImage ָ����ͼƬ
* RETURNS
*	u16      ͼƬ�߶�
* GLOBALS AFFECTED
*	NIL
****************************************************************************/           
extern u16 	IMG_GetHeight(tImage *pImage);


/*****************************************************************************
* FUNCTION
*	IMG_GetWidth
* DESCRIPTION
*	�õ�ͼƬ�����ؿ��
* PARAMETERS
*   *pImage ָ����ͼƬ
* RETURNS
*	u16      ͼƬ���
* GLOBALS AFFECTED
*	NIL
****************************************************************************/         
extern u16 	IMG_GetWidth(tImage *pImage);


/*****************************************************************************
* FUNCTION
*	IMG_Destory
* DESCRIPTION
*	��ͼƬ���ڴ�������
* PARAMETERS
*   *pImage ָ����ͼƬ
* RETURNS
*   void
* GLOBALS AFFECTED
*	NIL
****************************************************************************/ 
extern void IMG_Destory(tImage* pImage);

          
          
          
          
          
          
/******************************************************************************************************************
 * ��ͼ��Ԫ Graphics       
 * 
 * Graphics �൱��һ�����ʣ������ݻ�����Graphics��Ӧ�ı��档
 * Graphics���Դ�ϵͳ��LCD�õ���Ҳ���Դ�Image�õ���
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
*	�õ���ǰLCD��Ļ��Graphics
* PARAMETERS
*   void
* RETURNS
*   tGraphics* ��ǰLCD��Ļ�Ļ�ͼ��Ԫ
* GLOBALS AFFECTED
*	NIL
****************************************************************************/ 
extern tGraphics* 	GFX_GetLCDGraphics(void);


/*****************************************************************************
* FUNCTION
*	GFX_ToRGB
* DESCRIPTION
*	������ɫ
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
*	������ɫ
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
*	�õ�ָ��λ�õ�����
* PARAMETERS
*   *pG		ָ����G
*   x       x����
*   y       y����
* RETURNS
*	tRGB    ����
* GLOBALS AFFECTED
*	NIL
****************************************************************************/
extern tRGB		GFX_GetRGB(tGraphics *pG, u16 x, u16 y);

/*****************************************************************************
* FUNCTION
*	GFX_SetRGB
* DESCRIPTION
*	����ָ��λ�õ�����
* PARAMETERS
*   *pG		ָ����G
*   x       x����
*   y       y����
*   rgb		��ɫ
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
*   ��һ����Բ����Բ��ԲȦ��ָ���ǶȺ�һ��ָ���ľ��Σ���Բ�պð����ڸþ����ڣ�
*   ��������Ļ3,4�㻭һ����Ϊ16��Ϊ8����Բ��GFX_DrawArc(pG, 3, 4, 16, 8, 0, 360 , color);
*   ��������Ļ3,4�㻭һ�����Ϊ8�� "C" ����Բ����GFX_DrawArc(pG, 3, 4, 8, 8, 45, 360 - 90, color);
* PARAMETERS
*   pG			��ǰ��ͼ��Ԫ
*   x			��Ҫ���Ƶ���xλ��
*   y			��Ҫ���Ƶ���yλ��
*   width		��������Բ�Ŀ��
*   height		��������Բ�ĸ߶�
*   startAngle  ��ʼ�ĽǶ�
*   arcAngle    �Ƕȵľ���
*   color       ��ɫ
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
*   ��һ��ֱ�߶�
* PARAMETERS
*   pG			��ǰ��ͼ��Ԫ
*   x1			�߶ο�ʼxλ��
*   y1			�߶ο�ʼyλ��
*   x2			�߶ν���xλ��
*   y2			�߶ν���xλ��
*   color       ��ɫ
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
*   ��һ�����ο�
* PARAMETERS
*   pG			��ǰ��ͼ��Ԫ
*   x 			����Leftλ��
*   y 			����Topλ��
*   width		���ο�
*   height		���θ�
*   color       ��ɫ
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
*   ��һ���ַ���
* PARAMETERS
*   pG			��ǰ��ͼ��Ԫ
*   str			�ַ���
*   x 			����Leftλ��
*   y 			����Topλ��
*   color       ��ɫ
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
*   �õ�һ���ַ��������ؿ��
* PARAMETERS
*   str			�ַ���
* RETURNS
*   u16			�ַ������
* GLOBALS AFFECTED
*	NIL
****************************************************************************/ 
extern u16 GFX_GetStringWidth(char* str);

/*****************************************************************************
* FUNCTION
*	GFX_GetStringHeight
* DESCRIPTION
*   �õ�һ���ַ��������ظ߶�
* PARAMETERS
*   str			�ַ���
* RETURNS
*   u16			�ַ����߶�
* GLOBALS AFFECTED
*	NIL
****************************************************************************/ 
extern u16 GFX_GetStringHeight(char* str);




/*****************************************************************************
* FUNCTION
*	GFX_FillArc
* DESCRIPTION
*   ������Բ����Բ��ָ���ǶȺ�һ��ָ���ľ��Σ���Բ�պð����ڸþ����ڣ�
*   ��������Ļ3,4�㻭һ����Ϊ16��Ϊ8����Բ��GFX_DrawArc(pG, 3, 4, 16, 8, 0, 360 , color);
*   ��������Ļ3,4�㻭һ�����Ϊ8�� "C" ����Բ����GFX_DrawArc(pG, 3, 4, 8, 8, 45, 360 - 90, color);
* PARAMETERS
*   pG			��ǰ��ͼ��Ԫ
*   x			��Ҫ���Ƶ���xλ��
*   y			��Ҫ���Ƶ���yλ��
*   width		��������Բ�Ŀ��
*   height		��������Բ�ĸ߶�
*   startAngle  ��ʼ�ĽǶ�
*   arcAngle    �Ƕȵľ���
*   color       ��ɫ
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
*   ���һ�����ο�
* PARAMETERS
*   pG			��ǰ��ͼ��Ԫ
*   x 			����Leftλ��
*   y 			����Topλ��
*   width		���ο�
*   height		���θ�
*   color       ��ɫ
* RETURNS
*   void
* GLOBALS AFFECTED
*	NIL
****************************************************************************/ 
extern void GFX_FillRect(tGraphics* pG, s16 x, s16 y, u16 width, u16 height, tRGB color);


/* ��ͼƬʱ�ķ�ת���� */
#define 	TRANS_NONE   	0	/* ����ת */
#define 	TRANS_H  		2	/* ˮƽ��ת */
#define 	TRANS_V   		1	/* ��ֱ��ת */
#define 	TRANS_HV   		3	/* 180�ȷ�ת */
#define 	TRANS_180   	3	/* 180 = HV */
#define 	TRANS_90   		6	/* ��ʱ��90�ȷ�ת */
#define 	TRANS_270   	5	/* ��ʱ��270�ȷ�ת */
#define 	TRANS_H90   	4	/* ����ʱ��90�ȷ�ת��Ȼ����ˮƽ��ת */
#define 	TRANS_V90   	7	/* ����ʱ��90�ȷ�ת��Ȼ���ڴ�ֱ��ת */


/*****************************************************************************
* FUNCTION
*	GFX_DrawRect
* DESCRIPTION
*   ��һ��ͼƬ���������ϽǶ���
* PARAMETERS
*   pG			��ǰ��ͼ��Ԫ
*   pImage*		Ҫ����ͼƬ		
*   x 			ͼƬxλ��
*   y 			ͼƬyλ��
*   transform   ͼƬ��ת����
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
*   ֻ��һ��ͼƬ�ϵ�һ�����򣬰������ϽǶ���
* PARAMETERS
*   pG			��ǰ��ͼ��Ԫ
*   pSrcImage*	Ҫ����ͼƬ		
*   x_src		ԭͼ��xλ��
*   y_src 		ԭͼ��yλ��
*   width		ԭͼ������Ŀ�
*   height		ԭͼ������ĸ�
*   transform  	ͼƬ��ת����
*   x_dest		ͼƬ���Ƶ�Ŀ��xλ��
*   y_dest		ͼƬ���Ƶ�Ŀ��yλ��
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
*   ��ָ����tGraphics��Ӧ�ı����һ��������ճ�͸��ɫ
* PARAMETERS
*   pG			��ǰ��ͼ��Ԫ	
*   x			��������xλ��
*   y			��������yλ��
*   width		�������Ŀ�
*   height		�������ĸ�
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
*   ��ָ����tGraphics��Ӧ�ı����һ��������ճ�͸��ɫ
* PARAMETERS
*   pG			��ǰ��ͼ��Ԫ	
*   x			��������xλ��
*   y			��������yλ��
*   width		�������Ŀ�
*   height		�������ĸ�
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
*   �ѻ�ͼ��Ԫ���ڴ�������
* PARAMETERS
*   pG			��ǰ��ͼ��Ԫ	
* RETURNS
*   void
* GLOBALS AFFECTED
*	NIL
****************************************************************************/ 
extern void GFX_Destory(tGraphics* pG);





/***************************************************************************************************************************************************
* ������Ӧ	Key Input        
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

/* ����ֵ */
#define		KEY_0		(0x00000001)			//���ּ� 0
#define		KEY_1 		(0x00000002)			//���ּ� 1
#define		KEY_2		(0x00000004)			//���ּ� 2
#define		KEY_3		(0x00000008)			//���ּ� 3
#define		KEY_4		(0x00000010)			//���ּ� 4
#define		KEY_5		(0x00000020)			//���ּ� 5
#define		KEY_6		(0x00000040)			//���ּ� 6
#define		KEY_7		(0x00000080)			//���ּ� 7
#define		KEY_8		(0x00000100)			//���ּ� 8
#define		KEY_9		(0x00000200)			//���ּ� 9

#define		KEY_SHARE	(0x00000400)			//# ��
#define		KEY_STAR	(0x00000800) 			//* ��
#define		KEY_A		(0x00001000)			//�����
#define		KEY_B		(0x00002000)			//�����
#define		KEY_C		(0x00004000)			//�м�

#define		KEY_LEFT	(0x00008000)			//�������
#define		KEY_RIGHT	(0x00010000)			//�����Ҽ�
#define		KEY_UP		(0x00020000)			//�����ϼ�
#define		KEY_DOWN	(0x00040000)			//�����¼�

#define		KEY_ANY		(0xffffffff)

/*****************************************************************************
* FUNCTION
*	KEY_QueryEvent
* DESCRIPTION
*   ÿ��Ϸ����ִ��һ�β�ѯ����,
*   while(!exit)
*   {
*       exit = !KEY_QueryEvent();
*       ...
*       gameloop
*       ... 
*   }
*
*   �ڸú�����Ҫ�������¼����лص�
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
*   bool false=���ϵͳ�˳��¼� true=����
* GLOBALS AFFECTED
*	NIL
****************************************************************************/            	
extern bool KEY_QueryEvent(void);          	
          	
          	
/*****************************************************************************
* CALL BACK FUNCTION
*	KEY_keyPressed
* DESCRIPTION
*   �ص�����
*   �������м����µ�ʱ��������������� keyCode ��ʾ�ĸ���������
* PARAMETERS
*   keyCode			�ĸ���������
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
*   �ص�����
*   �������м��ɿ���ʱ��������������� keyCode ��ʾ�ĸ������ɿ�
* PARAMETERS
*   keyCode			�ĸ������ɿ�
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
*   �ص�����
*   �����������������
* PARAMETERS
*   x		������x����
* 	y		������y����
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
*   �ص�����
*   �����������ɿ�����
* PARAMETERS
*   x		������x����
* 	y		������y����
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
*   �ص�����
*   �����������϶�����
* PARAMETERS
*   x		�������϶���x����
* 	y		�������϶���y����
* RETURNS
*   void
* GLOBALS AFFECTED
*	NIL
****************************************************************************/ 
void	(*KEY_PointerDragged)(s16 x, s16 y) ;
	
	
	
	
	
/****************************************************************************************************************************************************/
/* ʱ�� Timer        			    	                        
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
*   �õ���MTK_Init�󣬳������еĺ���ʱ��
* PARAMETERS
* RETURNS
*   u32 ����
* GLOBALS AFFECTED
*	NIL
****************************************************************************/ 
extern u32 TIME_GetTicks();

	
/*****************************************************************************
* FUNCTION
*	TIME_Delay
* DESCRIPTION
*   �õ�ǰ�߳�Sleep
* PARAMETERS
*   ms	�߳�Sleep��ʱ�䣬��λ����
* RETURNS
*   void
* GLOBALS AFFECTED
*	NIL
****************************************************************************/ 
extern void TIME_Delay(u32 ms);


/****************************************************************************************************************************************************/
/* ����	Sound  		        			    	                        
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
*   ��������
* PARAMETERS
*   *pSound		Ҫ���ŵ���Դ
* 	loopCount	ѭ����������Ϊ����ѭ��
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
*   ֹͣ��������
* PARAMETERS
*   *pSound		Ҫֹͣ���ŵ���Դ
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
*   ������Դ���ڴ�������
* PARAMETERS
*   *pSound		Ҫ���ٵ���Դ
* RETURNS
*   void
* GLOBALS AFFECTED
*	NIL
****************************************************************************/ 
extern void SND_Destory(tSound *pSound);


/****************************************************************************************************************************************************/
/* �ļ�����Դ����  		
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
/* ����̨��� Console  	    		
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
*   ���ַ���Ϣ��ӡ���豸�Է������
* PARAMETERS
*   *msg		��Ϣ
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









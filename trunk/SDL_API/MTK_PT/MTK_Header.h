
/********************************************************************************************************************************
 * ���õ��ⲿAPI �Լ���ͬ�����ݽṹʵ��
 * 
 *********************************************************************************************************************************/

#ifndef MTK_HEADER_H_
#define MTK_HEADER_H_


#include <SDL.h>
#include <SDL_image.h>
#include <SDL_ttf.h>

////////////////////////////////////////////////////////////////////////////////////////////////
/* ------------------------------------------------------------
  Typedef below
  �������ͳ��ȿ��ɹ��޸Ķ���
  ----------------------------------------------------------- */
#define FALSE           0
#define TRUE            1

#ifndef NULL
    #define NULL 		((void *)0)
#endif

#define false          	FALSE
#define true           	TRUE

typedef unsigned char               u8;
typedef unsigned short              u16;
typedef unsigned long               u32;
typedef unsigned long long          u64;

typedef signed char                 s8;
typedef signed short                s16;
typedef signed long                 s32;
typedef signed long long            s64;

#ifndef BOOL
   typedef s8 BOOL;
   #ifndef __cplusplus
      typedef BOOL bool;
   #endif
#endif  

typedef void (*PFunction)();

/* ���ظ�ʽ���ɹ��޸Ķ��� */
typedef struct tRGB
{
	u8 dummy;
	u8 r;
	u8 g;
	u8 b;
}tRGB;

/* �ṹ tGraphics �ýṹ���ɹ�������� */
typedef struct tGraphics
{
	SDL_Surface *graphics;

}tGraphics;

/* �ṹ tImage �ýṹ���ɹ�������� */
typedef struct tImage
{
	SDL_Surface		*image;
	tGraphics		*graphics;
}tImage;


#define		SND_TYPE_MIDI		1
#define		SND_TYPE_WAVE		2
//#define		SND_TYPE_MP3		3
//#define		SND_TYPE_OGG		4
/* �ṹ tSound �ýṹ���ɹ�������� */
typedef struct tSound
{
	u8 type;//type������ʾ��ʽ

}tSound;



#endif /*MTK_HEADER_H_*/









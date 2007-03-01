
/********************************************************************************************************************************
 * 引用的外部API 以及不同的数据结构实现
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
  数据类型长度可由贵方修改定义
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

/* 象素格式可由贵方修改定义 */
typedef struct tRGB
{
	u8 dummy;
	u8 r;
	u8 g;
	u8 b;
}tRGB;

/* 结构 tGraphics 该结构体由贵方自由设计 */
typedef struct tGraphics
{
	SDL_Surface *graphics;

}tGraphics;

/* 结构 tImage 该结构体由贵方自由设计 */
typedef struct tImage
{
	SDL_Surface		*image;
	tGraphics		*graphics;
}tImage;


#define		SND_TYPE_MIDI		1
#define		SND_TYPE_WAVE		2
//#define		SND_TYPE_MP3		3
//#define		SND_TYPE_OGG		4
/* 结构 tSound 该结构体由贵方自由设计 */
typedef struct tSound
{
	u8 type;//type用来表示格式

}tSound;



#endif /*MTK_HEADER_H_*/









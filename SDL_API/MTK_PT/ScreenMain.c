
#include "Screen.h"

#include "ResesScript.h"


extern void Main_Init();
extern void Main_Destory();
extern void Main_Logic();
extern void Main_Render(tGraphics *g);
extern void Main_Pause();
extern void Main_Resume();

tScreen ScreenMain =
{
	Main_Init,
	Main_Destory,
	Main_Logic,
	Main_Render,
	Main_Pause,
	Main_Resume
};

// img res
tImage* back ;



// spr res
typedef struct tBlock 
{
	u8		type;
	s16		x;
	s16		y;
	u16		w;
	u16		h;
}tBlock;

bool TouchBlock(tBlock *b1, tBlock *b2)
{	
	if (b2->x+b2->w <= b1->x)		return false;
	if (b1->x >= b2->x+b2->w)		return false;
	if (b2->y+b2->h <= b1->y)		return false;
	if (b1->y >= b2->y+b2->h)		return false;
	return true;
}



/***************************************************************************************************/
void Main_Init()
{
	FrameDelay = 1;
	back = IMG_CreateImageFormFile("img\\back.png");
	

}

void Main_Destory()
{
	IMG_Destory(back);
}

void Main_Logic()
{
	FrameDelay = 1;
}


void Main_Render(tGraphics *g)
{
	//clear screen
	//ªÊ÷∆±≥æ∞Õº∆¨
	GFX_DrawImage(g,back,0,0,0);

	//œ‘ æFPS
	SCREEN_ShowFPS(g);
}

void Main_Pause()
{
}

void Main_Resume()
{
}

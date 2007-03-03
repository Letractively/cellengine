
#include "MTK.h"

// gobal

TTF_Font *font ;
SDL_Event event;


/********************************************************************************************************************/


bool		MTK_Init()
{
	MTK_Resume			= NULL;
	MTK_Pause			= NULL;
	KEY_KeyPressed		= NULL;
	KEY_KeyReleased		= NULL;
	KEY_PointerPressed	= NULL;
	KEY_PointerReleased	= NULL;
	KEY_PointerDragged	= NULL;

	//Initialize all SDL subsystems
    if( SDL_Init( SDL_INIT_EVERYTHING ) == -1 )
    {
        return false;    
    }

	//Init Video System
	#define SCREEN_BPP   16
	if( SCREEN_WIDTH  < 1)	SCREEN_WIDTH	= 640;
	if( SCREEN_HEIGHT < 1)	SCREEN_HEIGHT	= 480;
	SDL_SetVideoMode( SCREEN_WIDTH, SCREEN_HEIGHT, SCREEN_BPP, SDL_HWSURFACE );

	pScreen = GFX_GetLCDGraphics();

    //Set the window caption
    SDL_WM_SetCaption( "MTK", NULL );

	//Initialize SDL_ttf
    if( TTF_Init() == -1 )
    {
        return false;    
    }

	//Open the font
	if( TEXT_SIZE     < 1)	TEXT_SIZE		= 16;
    font = TTF_OpenFont( "font.ttf", TEXT_SIZE );

	return true;
}



void		MTK_Quit()
{
	//Close the font
	if( font != NULL ) TTF_CloseFont( font );
    //Quit SDL_ttf
    TTF_Quit();
	//Close the pScreen
	GFX_Destory(pScreen);
	//Quit SDL
    SDL_Quit();    
}





/********************************************************************************************************************/

tImage* 	IMG_CreateImageFormFile(const char * file)
{
	tImage *ret	= (tImage *)malloc(sizeof(tImage));
	ret->graphics = NULL;
	ret->image    = NULL;

	if( ret != NULL )
	{
		//The image that's loaded
		SDL_Surface* loadedImage = NULL;
	    
		//The optimized image that will be used
		SDL_Surface* optimizedImage = NULL;
	    
		//Load the image
		loadedImage = IMG_Load( file );
	    
		//If the image loaded
		if( loadedImage != NULL )
		{
			//Create an optimized image
			optimizedImage = SDL_DisplayFormat( loadedImage );
	        
			//Free the old image
			SDL_FreeSurface( loadedImage );

			//If the image was optimized just fine
			if( optimizedImage != NULL )
			{
				//Map the color key
				Uint32 colorkey = SDL_MapRGB( optimizedImage->format, 0xff, 0, 0xff );
	            
				//Set all pixels of color R 0, G 0xFF, B 0xFF to be transparent
				SDL_SetColorKey( optimizedImage, SDL_RLEACCEL | SDL_SRCCOLORKEY, colorkey );
			}

			//new tImage form optimized image
			ret->image = optimizedImage;

			ret->graphics = (tGraphics *)malloc(sizeof(tGraphics));
			ret->graphics->graphics = ret->image;
		}
		
	}

	if(ret == NULL || ret->image == NULL || ret->graphics == NULL || ret->graphics->graphics == NULL){
		DEBUG_Printf("Error Load Image : ");
		DEBUG_Printf(file);
		DEBUG_Printf(" -_-!\n");

		IMG_Destory(ret);
		ret = NULL;
	}
	else
	{
		u32 hashcode = (u32)(ret);
		DEBUG_Printf("Load Image : ");
		DEBUG_Printf("0x%08X",hashcode);
		DEBUG_Printf(" : ");
		DEBUG_Printf(file);
		DEBUG_Printf(" ^_^v\n");
	}

    //Return the ret
    return ret;
}


tImage* 	IMG_CreateImageFormData(const u8 Data[])
{
	return NULL;
}


tImage* 	IMG_CreateImageFormPixel(tRGB PixelData[], u16 width, u16 height)
{
	return NULL;
}


tImage* 	IMG_CreateImageFormClip(tImage *pSrcImage, u16 x, u16 y, u16 width, u16 height)
{
	return NULL;
}



tImage* 	IMG_CreateImageFormSize(u16 width, u16 height, tRGB color)
{
	return NULL;
}

void		IMG_Destory(tImage* pImage)
{
	//Free the surface
	if( pImage != NULL )
	{
		u32 hashcode = (u32)(pImage);
		if(pImage->image!=NULL)
		{
			SDL_FreeSurface( pImage->image );
		}
		free(pImage->graphics);
		free(pImage);
		DEBUG_Printf("Kill Image : 0x%08X\n",hashcode);
	}
	pImage = NULL;
}

tGraphics*  IMG_GetGraphics(tImage *pImage)
{
	if(pImage != NULL)
	{
		return pImage->graphics;
	}
	return NULL;
}

u16 		IMG_GetHeight(tImage *pImage)
{
	if( pImage != NULL )
	{
		return pImage->image->w;
	}
	else
	{
		return -1;
	}
	
}

u16 		IMG_GetWidth(tImage *pImage)
{
	if( pImage != NULL )
	{
		return pImage->image->h;
	}
	else
	{
		return -1;
	}
	
}



          
          
          
/****************************************************************************************************************/


tGraphics* 	GFX_GetLCDGraphics(void)
{
	tGraphics *g = (tGraphics *)malloc(sizeof(tGraphics));

	if( g != NULL )
	{
		u32 colorkey;

		g->graphics = SDL_GetVideoSurface();

		//Map the color key
		colorkey = SDL_MapRGB( g->graphics->format, 0xff, 0, 0xff );
	            
		//Set all pixels of color R 0, G 0xFF, B 0xFF to be transparent
		SDL_SetColorKey( g->graphics, SDL_RLEACCEL | SDL_SRCCOLORKEY, colorkey );
			

	}

	if(g == NULL || g->graphics == NULL)
	{
		GFX_Destory(g);
		g = NULL;
	}
	
	return g;
}

void		GFX_Destory(tGraphics* pG)
{
	if(pG != NULL)
	{
		//Free the surface
		if(pG->graphics!=NULL)
		{
			SDL_FreeSurface( pG->graphics );
		}
		free(pG);
	}
	

	pG = NULL;
}




tRGB		GFX_ToRGB(u8 r, u8 g, u8 b)
{
	tRGB color = {0,r,g,b};
	return color;
}
tRGB		GFX_ToRGB2(u32 rgb)
{
	tRGB color = GFX_ToRGB((u8)(rgb>>16)&0xff, (u8)(rgb>>8 )&0xff, (u8)(rgb>>0 )&0xff);
	return color;
}

Uint32		getpixel(SDL_Surface *surface, int x, int y)
{
    int bpp = surface->format->BytesPerPixel;
    /* Here p is the address to the pixel we want to retrieve */
    Uint8 *p = (Uint8 *)surface->pixels + y * surface->pitch + x * bpp;

    switch(bpp) {
    case 1:
        return *p;

    case 2:
        return *(Uint16 *)p;

    case 3:
        if(SDL_BYTEORDER == SDL_BIG_ENDIAN)
            return p[0] << 16 | p[1] << 8 | p[2];
        else
            return p[0] | p[1] << 8 | p[2] << 16;

    case 4:
        return *(Uint32 *)p;

    default:
        return 0;       /* shouldn't happen, but avoids warnings */
    }
}
void		putpixel(SDL_Surface *surface, int x, int y, Uint32 pixel)
{
    int bpp = surface->format->BytesPerPixel;
    /* Here p is the address to the pixel we want to set */
    Uint8 *p = (Uint8 *)surface->pixels + y * surface->pitch + x * bpp;

    switch(bpp) {
    case 1:
        *p = pixel;
        break;

    case 2:
        *(Uint16 *)p = pixel;
        break;

    case 3:
        if(SDL_BYTEORDER == SDL_BIG_ENDIAN) {
            p[0] = (pixel >> 16) & 0xff;
            p[1] = (pixel >> 8) & 0xff;
            p[2] = pixel & 0xff;
        } else {
            p[0] = pixel & 0xff;
            p[1] = (pixel >> 8) & 0xff;
            p[2] = (pixel >> 16) & 0xff;
        }
        break;

    case 4:
        *(Uint32 *)p = pixel;
        break;
    }
}

tRGB		GFX_GetRGB(tGraphics* pG, u16 x, u16 y)
{
	tRGB rgb = {0,0,0,0};
	
	if( pG != NULL )
	{
		u32 pixcel;

		if(x<0||y<0||x>=pG->graphics->w||y>=pG->graphics->h)return rgb;

		/* Lock the screen for direct access to the pixels */
		if ( SDL_MUSTLOCK(pG->graphics) ) {
			if ( SDL_LockSurface(pG->graphics) < 0 ) {
				printf("Can't lock screen: %s\n", SDL_GetError());
				return rgb;
			}
		}

		pixcel = getpixel(pG->graphics, x, y);
		rgb = GFX_ToRGB((u8)(pixcel>>16)&0xff, (u8)(pixcel>>8 )&0xff, (u8)(pixcel>>0 )&0xff);

		if ( SDL_MUSTLOCK(pG->graphics) ) {
			SDL_UnlockSurface(pG->graphics);
		}
    
	}
	return rgb;
}

void		GFX_SetRGB(tGraphics* pG, u16 x, u16 y, tRGB rgb)
{
	if( pG != NULL )
	{
		Uint32 pixcel ;

		if(x<0||y<0||x>=pG->graphics->w||y>=pG->graphics->h)return;

		/* Lock the screen for direct access to the pixels */
		if ( SDL_MUSTLOCK(pG->graphics) ) {
			if ( SDL_LockSurface(pG->graphics) < 0 ) {
				printf("Can't lock screen: %s\n", SDL_GetError());
				return;
			}
		}

		pixcel = SDL_MapRGB(pG->graphics->format, rgb.r, rgb.g, rgb.b);
		putpixel(pG->graphics, x, y, pixcel);

		if ( SDL_MUSTLOCK(pG->graphics) ) {
			SDL_UnlockSurface(pG->graphics);
		}

		return;

	}
}

void		GFX_DrawArc(tGraphics* pG, s16 x, s16 y, u16 width, u16 height, s16 startAngle, s16 arcAngle, tRGB color)
{
}


void		GFX_DrawLine(tGraphics* pG, s16 x1, s16 y1, s16 x2, s16 y2, tRGB color)
{
}


void		GFX_DrawRect(tGraphics* pG, s16 x, s16 y, s16 width, s16 height, tRGB color)
{
}



void		GFX_DrawString(tGraphics* pG, const char* str, s16 x, s16 y, tRGB color )
{
    //Generate the message surface
	if(pG != NULL && font != NULL)
	{
		SDL_Color		c = {color.r, color.g, color.b, color.dummy};
		SDL_Rect		rect = {x, y, 0, 0};
		SDL_Surface		*text = TTF_RenderText_Solid( font, str, c );
		SDL_BlitSurface(text, NULL, pG->graphics, &rect);
		SDL_FreeSurface(text);
	}
}


u16			GFX_GetStringWidth(char* str)
{
	//Generate the message surface
	if(font != NULL)
	{
		u16 w;
		SDL_Color		c = {0,0,0,0};
		SDL_Surface		*text = TTF_RenderText_Solid( font, str, c );
		w = text->w;
		SDL_FreeSurface(text);
		return w;
	}else
	{
		return -1;
	}
}


u16			GFX_GetStringHeight(char* str)
{
	//Generate the message surface
	if(font != NULL)
	{
		u16 h;
		SDL_Color		c = {0,0,0,0};
		SDL_Surface		*text = TTF_RenderText_Solid( font, str, c );
		h = text->h;
		SDL_FreeSurface(text);
		return h;
	}else
	{
		return -1;
	}
}



void		GFX_FillArc(tGraphics* pG, s16 x, s16 y, u16 width, u16 height, s16 startAngle, s16 arcAngle, tRGB color)
{
}

void		GFX_FillRect(tGraphics* pG, s16 x, s16 y, u16 width, u16 height, tRGB color)
{
	if(pG != NULL)
	{
		SDL_Rect rect = {x, y, width, height};
		u32 c = (color.r<<16) | (color.g<<8) | (color.b<<0) ;

		SDL_FillRect(pG->graphics, &rect, c);
	}
	
}


void		GFX_DrawImage(tGraphics* pG, tImage* pImage, s16 x, s16 y, u8 transform)
{
	if(pG != NULL && pImage != NULL)
	{
		SDL_Rect s_rect = {0,0,pImage->image->w,pImage->image->h};
		SDL_Rect d_rect = {x,y,pImage->image->w,pImage->image->h};

		SDL_BlitSurface(pImage->image, &s_rect, pG->graphics, &d_rect);
	}
}


void		GFX_DrawRegion(tGraphics* pG, tImage *pSrcImage, s16 x_src, s16 y_src, u16 width, u16 height, u8 transform, s16 x_dest, s16 y_dest)
{
	if(pG != NULL && pSrcImage != NULL)
	{
		SDL_Rect s_rect = {x_src,y_src,width,height} ;
		SDL_Rect d_rect = {x_dest,y_dest,width,height};

		SDL_BlitSurface(pSrcImage->image, &s_rect, pG->graphics, &d_rect);
	}
}


void		GFX_CleanRect(tGraphics* pG, s16 x, s16 y, s16 width, s16 height)
{
	SDL_Rect rect = {x, y, width, height} ;

	if(pG != NULL)
	{
		int i,j;
		for(i=x; i<x+width; i++)
		{
			for(j=y; j<y+height; j++)
			{
				GFX_SetRGB(pG, i, j, GFX_ToRGB(0xff,0,0xff));
			}
		}
	}
	
	//SDL_FillRect(pG->graphics, &rect, 0xff00ff);
	//SDL_UpdateRect(pG->graphics, rect.x, rect.y, rect.w, rect.h);
}

void		GFX_Update(tGraphics* pG)
{
	if(pG != NULL)
	{
		SDL_Flip(pG->graphics);
	}
}





/****************************************************************************************************************************************************/


u32			getKeyCode(u32 key)
{
	u32 CurKeyDown = 0;

	switch( key ){

	case SDLK_LEFT:		CurKeyDown |= KEY_LEFT;		break;
	case SDLK_RIGHT:	CurKeyDown |= KEY_RIGHT;	break;
	case SDLK_UP:		CurKeyDown |= KEY_UP;		break;
	case SDLK_DOWN:		CurKeyDown |= KEY_DOWN;		break;

	case SDLK_KP0:		CurKeyDown |= KEY_0;		break;
	case SDLK_KP1:		CurKeyDown |= KEY_1;		break;
	case SDLK_KP2:		CurKeyDown |= KEY_2;		break;
	case SDLK_KP3:		CurKeyDown |= KEY_3;		break;
	case SDLK_KP4:		CurKeyDown |= KEY_4;		break;
	case SDLK_KP5:		CurKeyDown |= KEY_5;		break;
	case SDLK_KP6:		CurKeyDown |= KEY_6;		break;
	case SDLK_KP7:		CurKeyDown |= KEY_7;		break;
	case SDLK_KP8:		CurKeyDown |= KEY_8;		break;
	case SDLK_KP9:		CurKeyDown |= KEY_9;		break;

	case SDLK_RETURN:	CurKeyDown |= KEY_C;		break;
	case SDLK_F1:		CurKeyDown |= KEY_A;		break;
	case SDLK_F2:		CurKeyDown |= KEY_B;		break;
	case SDLK_F3:		CurKeyDown |= KEY_STAR;		break;
	case SDLK_F4:		CurKeyDown |= KEY_SHARE;	break;

	//case SDLK_ESCAPE:	CurKeyDown |= KEY_EXIT;		break;

	default:
		break;
	}
	return CurKeyDown;
}

bool		KEY_QueryEvent(void)
{
    /* Check for events */
    while( SDL_PollEvent( &event ) ){
        switch( event.type ){
            case SDL_KEYDOWN:
				if( KEY_KeyPressed != NULL )
				{
					KEY_KeyPressed(getKeyCode(event.key.keysym.sym));
				}
                break;
            case SDL_KEYUP:
				if( KEY_KeyReleased != NULL )
				{
					KEY_KeyReleased(getKeyCode(event.key.keysym.sym));
				}
                break;
			case SDL_MOUSEBUTTONDOWN:
				if( KEY_PointerPressed != NULL )
				{
					KEY_PointerPressed(event.motion.x, event.motion.y);
				}
				break;
			case SDL_MOUSEMOTION:
				if( event.motion.state )
				if( KEY_PointerDragged != NULL )
				{
					KEY_PointerDragged(event.motion.x, event.motion.y);
				}
				break;
			case SDL_MOUSEBUTTONUP:
				if( KEY_PointerReleased != NULL )
				{
					KEY_PointerReleased(event.motion.x, event.motion.y);
				}
				break;

			case SDL_ACTIVEEVENT: 
				//printf("App type=%d state=%d gain=%d \n",event.active.type,event.active.state,event.active.gain);
				if(event.active.gain)
				{
					if(event.active.state & (0xff - 1))
					{
						if(MTK_Resume != NULL)
						{
							//screen resume call
							MTK_Resume();
						}
					}
				}else
				{
					if(event.active.state & (0xff - 1))
					{
						if(MTK_Pause != NULL)
						{
							//screen lost call
							MTK_Pause();
						}
					}
				}
				break;

			case SDL_QUIT:
				return false;
				break;
			default:
                break;
        }
    }
	return true;
  
}


/****************************************************************************************************************************************************/

void		SND_PlaySound(tSound *pSound, s8 loopCount)
{
}


void		SND_Stop(tSound *pSound)
{
}

void		SND_Destory(tSound *pSound)
{
}

/****************************************************************************************************************************************************/


u32			TIME_GetTicks()
{
	return SDL_GetTicks();
}


void		TIME_Delay(u32 ms)
{
	SDL_Delay(ms);
}


/****************************************************************************************************************************************************/

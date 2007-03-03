
//
// MTK Script v0.0.0
// Editor Auto Generated Code
// 编辑器自动产生的代码
// 
// 指定文件输出
// <OUTPUT>    .\[out]\ResesScript.h
// 
#ifndef RESES_SCRIPT_H_
#define RESES_SCRIPT_H_

#include "MTK.h"

/* Set up for C function definitions, even when using C++ */
#ifdef __cplusplus
extern "C" {
#endif



#<RESOURCE>

/**************************************************************************************************/
/* tile                                                                                           */
/**************************************************************************************************/

// tile 
#<IMAGES>
	const char* TILE_<NAME>_Files[<COUNT>] = {#<CLIP>"Tile\\tile_<INDEX>.png",#<END CLIP>};
	tImage*		TILE_<NAME>_Tiles[<COUNT>];

	void		TILE_<NAME>_Init(){
		int i;
		for(i=0;i<<COUNT>;i++){
			<NAME>_Tiles[i] = IMG_CreateImageFormFile(<NAME>_Files);
		}
	}
	void		TILE_<NAME>_Kill(){
		int i;
		for(i=0;i<<COUNT>;i++){
			IMG_Destory(<NAME>_Tiles[i]);
		}
	}
	s16 		TILE_<NAME>_GetCount(){
		return <COUNT>;
	}
	void		TILE_<NAME>_Render(tGraphics *g, u16 index, s16 x, s16 y){
		if(index<<COUNT>){
			GFX_DrawImage(g,TILE_<NAME>_Tiles[index],x,y,0);
		}
	}
#<END IMAGES>

// public 
enum{
	#<IMAGES> <NAME>, #<END IMAGES>
};
void TILE_Init(){
	#<IMAGES> TILE_<NAME>_Init(); #<END IMAGES>
}
void TILE_Kill(){
	#<IMAGES> TILE_<NAME>_Kill(); #<END IMAGES>
}
void TILE_GetCount(u16 name){
	switch(name){
	#<IMAGES> case <NAME>: return TILE_<NAME>_GetCount(); #<END IMAGES>
	}
	return -1;
}
void TILE_Render(tGraphics *g, u16 name, u16 index, s16 x, s16 y){
	switch(name){
	#<IMAGES> case <NAME>: TILE_<NAME>_Render(g,index,x,y); break; #<END IMAGES>
	}
}

/**************************************************************************************************/
/* map                                                                                            */
/**************************************************************************************************/


// map 
#<MAP> 
	const u8	MAP_<NAME>_Parts[<SCENE PART COUNT>] = {#<SCENE PART><TILE>,#<END SCENE PART>};
	const u8	MAP_<NAME>_Frames[<SCENE FRAME COUNT>][1] = {#<SCENE FRAME>{<DATA>/*<DATA SIZE>*/},#<END SCENE FRAME>};
	const u8	MAP_<NAME>_Matrix[<Y COUNT>][<X COUNT>] = {<TILE MATRIX>};
	
	u16			MAP_<NAME>_GetW(){
		return <X COUNT>;
	}
	u16			MAP_<NAME>_GetH(){
		return <Y COUNT>;
	}
	u16			MAP_<NAME>_GetCellW(){
		return <CELL W>;
	}
	u16			MAP_<NAME>_GetCellH(){
		return <CELL H>;
	}
	void		MAP_<NAME>_Render(tGraphics *g, s16 px, s16 py){
		int x,y;
		for(y=0;y<<Y COUNT>;y++){
			for(x=0;x<<X COUNT>;x++){
				TILE_Render(g,<IMAGES NAME>,MAP_<NAME>_Parts[MAP_<NAME>_Frames[MAP_<NAME>_Matrix[y][x]][0]],px+x*<CELL W>,py+y*<CELL H>);
			}
		}
	}
#<END MAP> 

// public 
enum {	
	#<MAP> <NAME>, #<END MAP> 
};
u16 MAP_GetW(u16 name){
	switch(name){
	#<MAP> case <NAME>: MAP_<NAME>_GetW(); break; #<END MAP> 
	}
	return -1;
}
u16 MAP_GetH(u16 name){
	switch(name){
	#<MAP> case <NAME>: MAP_<NAME>_GetH(); break; #<END MAP> 
	}
	return -1;
}
u16 MAP_GetCellW(u16 name){
	switch(name){
	#<MAP> case <NAME>: MAP_<NAME>_GetCellW(); break; #<END MAP> 
	}
	return -1;
}
u16 MAP_GetCellH(u16 name){
	switch(name){
	#<MAP> case <NAME>: MAP_<NAME>_GetCellH(); break; #<END MAP> 
	}
	return -1;
}
void MAP_Render(tGraphics *g, u16 name, s16 px, s16 py){
	switch(name){
	#<MAP> case <NAME>: MAP_<NAME>_Render(g, px, py); break; #<END MAP> 
	}
}


/**************************************************************************************************/
/* spr                                                                                            */
/**************************************************************************************************/
#<SPRITE> 
	const s16	SPR_<NAME>_Parts[<SCENE PART COUNT>][4]	= {#<SCENE PART>{<TILE>,<X>,<Y>},#<END SCENE PART>};
	const u8	SPR_<NAME>_Frames[<SCENE FRAME COUNT>][1] = {#<SCENE FRAME> {<DATA>/*<DATA SIZE>*/}, #<END SCENE FRAME>};
	const u8	SPR_<NAME>_Animate[32][32] = {<FRAME ANIMATE>};

	u16			SPR_<NAME>_GetAnimateCount(){
	
	}
	u16			SPR_<NAME>_GetFrameCount(u16 anim){
	
	}
	void		SPR_<NAME>_Render(tGraphics *g, u16 anim, u16 frame, s16 px, s16 py){
		u16 index = SPR_<NAME>_Parts[SPR_<NAME>_Frames[SPR_<NAME>_Animate[anim][frame]][0]][0];
		s16 x = SPR_<NAME>_Parts[SPR_<NAME>_Frames[SPR_<NAME>_Animate[anim][frame]][0]][1] + px;
		s16 y = SPR_<NAME>_Parts[SPR_<NAME>_Frames[SPR_<NAME>_Animate[anim][frame]][0]][2] + py;
		TILE_Render(g,<IMAGES NAME>,index,x,y);
	}
#<END SPRITE> 

#<SPRITE> 
         <NAME> 
         <IMAGES NAME>
		
		<ANIMATE COUNT>
		<FRAME COUNTS>

	   <FRAME NAME>
	   
	   <FRAME CD MAP>
	   <FRAME CD ATK>
	   <FRAME CD DEF>
       <FRAME CD EXT>
        
#<END SPRITE> 

#<END RESOURCE>




#<LEVEL> 
/**************************************************************************************************/
/* level                                                                                            */
/**************************************************************************************************/


#<END LEVEL>

/* Ends C function definitions when using C++ */
#ifdef __cplusplus
}
#endif

#endif/*#ifndef RESES_SCRIPT_H_*/


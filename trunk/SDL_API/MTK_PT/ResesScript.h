/* Encoding : 简体中文(GB2312) */
/* Cell Game Editor by WAZA Zhang */
/* Email : wazazhang@gmail.com */

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





/**************************************************************************************************/
/* tile                                                                                           */
/**************************************************************************************************/

// tile 

	const char* TILE_LEVEL_Files[44] = {"LEVEL\\tile_0.png","LEVEL\\tile_1.png","LEVEL\\tile_2.png","LEVEL\\tile_3.png","LEVEL\\tile_4.png","LEVEL\\tile_5.png","LEVEL\\tile_6.png","LEVEL\\tile_7.png","LEVEL\\tile_8.png","LEVEL\\tile_9.png","LEVEL\\tile_10.png","LEVEL\\tile_11.png","LEVEL\\tile_12.png","LEVEL\\tile_13.png","LEVEL\\tile_14.png","LEVEL\\tile_15.png","LEVEL\\tile_16.png","LEVEL\\tile_17.png","LEVEL\\tile_18.png","LEVEL\\tile_19.png","LEVEL\\tile_20.png","LEVEL\\tile_21.png","LEVEL\\tile_22.png","LEVEL\\tile_23.png","LEVEL\\tile_24.png","LEVEL\\tile_25.png","LEVEL\\tile_26.png","LEVEL\\tile_27.png","LEVEL\\tile_28.png","LEVEL\\tile_29.png","LEVEL\\tile_30.png","LEVEL\\tile_31.png","LEVEL\\tile_32.png","LEVEL\\tile_33.png","LEVEL\\tile_34.png","LEVEL\\tile_35.png","LEVEL\\tile_36.png","LEVEL\\tile_37.png","LEVEL\\tile_38.png","LEVEL\\tile_39.png","LEVEL\\tile_40.png","LEVEL\\tile_41.png","LEVEL\\tile_42.png","LEVEL\\tile_43.png",};
	tImage*		TILE_LEVEL_Tiles[44];

	void		TILE_LEVEL_Init(){
		int i;
		for(i=0;i<44;i++){
			TILE_LEVEL_Tiles[i] = IMG_CreateImageFormFile(TILE_LEVEL_Files[i]);
		}
	}
	void		TILE_LEVEL_Kill(){
		int i;
		for(i=0;i<44;i++){
			IMG_Destory(TILE_LEVEL_Tiles[i]);
		}
	}
	u16 		TILE_LEVEL_GetCount(){
		return 44;
	}
	void		TILE_LEVEL_Render(tGraphics *g, u16 index, s16 x, s16 y){
		if(index<44){
			GFX_DrawImage(g,TILE_LEVEL_Tiles[index],x,y,0);
		}
	}


	const char* TILE_MAP_Files[17] = {"MAP\\tile_0.png","MAP\\tile_1.png","MAP\\tile_2.png","MAP\\tile_3.png","MAP\\tile_4.png","MAP\\tile_5.png","MAP\\tile_6.png","MAP\\tile_7.png","MAP\\tile_8.png","MAP\\tile_9.png","MAP\\tile_10.png","MAP\\tile_11.png","MAP\\tile_12.png","MAP\\tile_13.png","MAP\\tile_14.png","MAP\\tile_15.png","MAP\\tile_16.png",};
	tImage*		TILE_MAP_Tiles[17];

	void		TILE_MAP_Init(){
		int i;
		for(i=0;i<17;i++){
			TILE_MAP_Tiles[i] = IMG_CreateImageFormFile(TILE_MAP_Files[i]);
		}
	}
	void		TILE_MAP_Kill(){
		int i;
		for(i=0;i<17;i++){
			IMG_Destory(TILE_MAP_Tiles[i]);
		}
	}
	u16 		TILE_MAP_GetCount(){
		return 17;
	}
	void		TILE_MAP_Render(tGraphics *g, u16 index, s16 x, s16 y){
		if(index<17){
			GFX_DrawImage(g,TILE_MAP_Tiles[index],x,y,0);
		}
	}



// public 
enum{
	TILE_null,
	 TILE_LEVEL, 
 TILE_MAP, 

};
void TILE_Init(){
	 TILE_LEVEL_Init(); 
 TILE_MAP_Init(); 

}
void TILE_Kill(){
	 TILE_LEVEL_Kill(); 
 TILE_MAP_Kill(); 

}
u16 TILE_GetCount(u16 name){
	switch(name){
	 case TILE_LEVEL: return TILE_LEVEL_GetCount(); 
 case TILE_MAP: return TILE_MAP_GetCount(); 

	}
	return 0;
}
void TILE_Render(tGraphics *g, u16 name, u16 index, s16 x, s16 y){
	switch(name){
	 case TILE_LEVEL: TILE_LEVEL_Render(g,index,x,y); break; 
 case TILE_MAP: TILE_MAP_Render(g,index,x,y); break; 

	}
}

/**************************************************************************************************/
/* map                                                                                            */
/**************************************************************************************************/


// map 
 
	const u8	MAP_M01_Parts[11] = {0,7,3,6,9,10,1,8,4,11,5,};
	const u8	MAP_M01_Frames[11][1] = {{0,/*1*/},{1,/*1*/},{2,/*1*/},{3,/*1*/},{4,/*1*/},{5,/*1*/},{6,/*1*/},{7,/*1*/},{8,/*1*/},{9,/*1*/},{10,/*1*/},};
	const u8	MAP_M01_Matrix[11][9] = {{0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,},
{1,2,2,2,2,2,2,3,0,},
{4,0,0,0,0,0,0,5,3,},
{4,0,0,0,0,0,0,0,6,},
{7,8,9,0,0,0,0,0,6,},
{0,0,7,8,8,8,8,8,10,},
{0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,},
};
	
	u16			MAP_M01_GetW(){
		return 9;
	}
	u16			MAP_M01_GetH(){
		return 11;
	}
	u16			MAP_M01_GetCellW(){
		return 20;
	}
	u16			MAP_M01_GetCellH(){
		return 20;
	}
	s16			MAP_M01_GetTileIndex(u16 bx, u16 by){
		if(bx<0 || bx>=9 || by<0 || by>=11)return -1;
		return MAP_M01_Parts[MAP_M01_Frames[MAP_M01_Matrix[by][bx]][0]];
	}
	void		MAP_M01_Render(tGraphics *g, s16 px, s16 py){
		int x,y;
		for(y=0;y<11;y++){
			for(x=0;x<9;x++){
				TILE_Render(g,TILE_MAP,MAP_M01_Parts[MAP_M01_Frames[MAP_M01_Matrix[y][x]][0]],px+x*20,py+y*20);
			}
		}
	}

 
	const u8	MAP_M02_Parts[14] = {0,7,3,6,9,1,12,13,5,2,8,11,10,4,};
	const u8	MAP_M02_Frames[14][1] = {{0,/*1*/},{1,/*1*/},{2,/*1*/},{3,/*1*/},{4,/*1*/},{5,/*1*/},{6,/*1*/},{7,/*1*/},{8,/*1*/},{9,/*1*/},{10,/*1*/},{11,/*1*/},{12,/*1*/},{13,/*1*/},};
	const u8	MAP_M02_Matrix[11][9] = {{0,0,0,0,1,2,3,0,0,},
{0,0,0,0,4,0,5,0,0,},
{0,0,0,1,6,0,5,0,0,},
{0,0,1,6,0,0,5,0,0,},
{0,1,6,0,0,7,8,0,0,},
{0,4,0,0,9,5,0,0,0,},
{0,10,11,0,0,12,3,0,0,},
{0,0,10,11,0,0,5,0,0,},
{0,0,0,10,11,0,5,0,0,},
{0,0,0,0,4,0,5,0,0,},
{0,0,0,0,10,13,8,0,0,},
};
	
	u16			MAP_M02_GetW(){
		return 9;
	}
	u16			MAP_M02_GetH(){
		return 11;
	}
	u16			MAP_M02_GetCellW(){
		return 20;
	}
	u16			MAP_M02_GetCellH(){
		return 20;
	}
	s16			MAP_M02_GetTileIndex(u16 bx, u16 by){
		if(bx<0 || bx>=9 || by<0 || by>=11)return -1;
		return MAP_M02_Parts[MAP_M02_Frames[MAP_M02_Matrix[by][bx]][0]];
	}
	void		MAP_M02_Render(tGraphics *g, s16 px, s16 py){
		int x,y;
		for(y=0;y<11;y++){
			for(x=0;x<9;x++){
				TILE_Render(g,TILE_MAP,MAP_M02_Parts[MAP_M02_Frames[MAP_M02_Matrix[y][x]][0]],px+x*20,py+y*20);
			}
		}
	}

 
	const u8	MAP_M04_Parts[14] = {0,7,3,6,9,1,8,11,2,13,4,5,12,10,};
	const u8	MAP_M04_Frames[14][1] = {{0,/*1*/},{1,/*1*/},{2,/*1*/},{3,/*1*/},{4,/*1*/},{5,/*1*/},{6,/*1*/},{7,/*1*/},{8,/*1*/},{9,/*1*/},{10,/*1*/},{11,/*1*/},{12,/*1*/},{13,/*1*/},};
	const u8	MAP_M04_Matrix[11][9] = {{0,0,0,0,0,0,0,0,0,},
{1,2,2,2,2,2,2,2,3,},
{4,0,0,0,0,0,0,0,5,},
{6,7,8,0,9,10,10,10,11,},
{0,4,0,0,5,0,0,0,0,},
{1,12,0,8,13,3,0,0,0,},
{4,0,0,0,0,5,0,0,0,},
{6,10,7,0,0,5,0,0,0,},
{0,0,4,0,9,11,0,0,0,},
{0,0,6,10,11,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,},
};
	
	u16			MAP_M04_GetW(){
		return 9;
	}
	u16			MAP_M04_GetH(){
		return 11;
	}
	u16			MAP_M04_GetCellW(){
		return 20;
	}
	u16			MAP_M04_GetCellH(){
		return 20;
	}
	s16			MAP_M04_GetTileIndex(u16 bx, u16 by){
		if(bx<0 || bx>=9 || by<0 || by>=11)return -1;
		return MAP_M04_Parts[MAP_M04_Frames[MAP_M04_Matrix[by][bx]][0]];
	}
	void		MAP_M04_Render(tGraphics *g, s16 px, s16 py){
		int x,y;
		for(y=0;y<11;y++){
			for(x=0;x<9;x++){
				TILE_Render(g,TILE_MAP,MAP_M04_Parts[MAP_M04_Frames[MAP_M04_Matrix[y][x]][0]],px+x*20,py+y*20);
			}
		}
	}

 
	const u8	MAP_M05_Parts[14] = {0,7,3,6,9,1,15,2,13,5,10,8,11,4,};
	const u8	MAP_M05_Frames[14][1] = {{0,/*1*/},{1,/*1*/},{2,/*1*/},{3,/*1*/},{4,/*1*/},{5,/*1*/},{6,/*1*/},{7,/*1*/},{8,/*1*/},{9,/*1*/},{10,/*1*/},{11,/*1*/},{12,/*1*/},{13,/*1*/},};
	const u8	MAP_M05_Matrix[11][9] = {{0,0,0,0,0,0,0,0,0,},
{1,2,2,2,2,2,2,2,3,},
{4,0,0,0,0,0,0,0,5,},
{4,0,0,0,6,7,0,8,9,},
{4,0,0,0,6,0,0,5,0,},
{4,0,0,0,6,7,0,10,3,},
{11,12,0,0,6,0,0,0,5,},
{0,11,12,0,8,13,13,13,9,},
{0,0,11,13,9,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,},
};
	
	u16			MAP_M05_GetW(){
		return 9;
	}
	u16			MAP_M05_GetH(){
		return 11;
	}
	u16			MAP_M05_GetCellW(){
		return 20;
	}
	u16			MAP_M05_GetCellH(){
		return 20;
	}
	s16			MAP_M05_GetTileIndex(u16 bx, u16 by){
		if(bx<0 || bx>=9 || by<0 || by>=11)return -1;
		return MAP_M05_Parts[MAP_M05_Frames[MAP_M05_Matrix[by][bx]][0]];
	}
	void		MAP_M05_Render(tGraphics *g, s16 px, s16 py){
		int x,y;
		for(y=0;y<11;y++){
			for(x=0;x<9;x++){
				TILE_Render(g,TILE_MAP,MAP_M05_Parts[MAP_M05_Frames[MAP_M05_Matrix[y][x]][0]],px+x*20,py+y*20);
			}
		}
	}

 
	const u8	MAP_M06_Parts[10] = {0,7,3,6,9,1,2,8,4,5,};
	const u8	MAP_M06_Frames[10][1] = {{0,/*1*/},{1,/*1*/},{2,/*1*/},{3,/*1*/},{4,/*1*/},{5,/*1*/},{6,/*1*/},{7,/*1*/},{8,/*1*/},{9,/*1*/},};
	const u8	MAP_M06_Matrix[11][9] = {{0,0,0,0,0,0,0,0,0,},
{1,2,2,2,2,2,2,2,3,},
{4,0,0,0,0,0,0,0,5,},
{4,0,6,0,0,0,6,0,5,},
{4,0,0,0,0,0,0,0,5,},
{4,0,6,0,0,0,6,0,5,},
{4,0,0,0,0,0,0,0,5,},
{4,0,6,0,0,0,6,0,5,},
{4,0,0,0,0,0,0,0,5,},
{4,0,0,0,0,0,0,0,5,},
{7,8,8,8,8,8,8,8,9,},
};
	
	u16			MAP_M06_GetW(){
		return 9;
	}
	u16			MAP_M06_GetH(){
		return 11;
	}
	u16			MAP_M06_GetCellW(){
		return 20;
	}
	u16			MAP_M06_GetCellH(){
		return 20;
	}
	s16			MAP_M06_GetTileIndex(u16 bx, u16 by){
		if(bx<0 || bx>=9 || by<0 || by>=11)return -1;
		return MAP_M06_Parts[MAP_M06_Frames[MAP_M06_Matrix[by][bx]][0]];
	}
	void		MAP_M06_Render(tGraphics *g, s16 px, s16 py){
		int x,y;
		for(y=0;y<11;y++){
			for(x=0;x<9;x++){
				TILE_Render(g,TILE_MAP,MAP_M06_Parts[MAP_M06_Frames[MAP_M06_Matrix[y][x]][0]],px+x*20,py+y*20);
			}
		}
	}

 
	const u8	MAP_M07_Parts[14] = {0,7,3,6,9,1,8,4,11,2,15,13,5,12,};
	const u8	MAP_M07_Frames[14][1] = {{0,/*1*/},{1,/*1*/},{2,/*1*/},{3,/*1*/},{4,/*1*/},{5,/*1*/},{6,/*1*/},{7,/*1*/},{8,/*1*/},{9,/*1*/},{10,/*1*/},{11,/*1*/},{12,/*1*/},{13,/*1*/},};
	const u8	MAP_M07_Matrix[11][9] = {{0,0,0,0,0,0,0,0,0,},
{1,2,2,2,2,2,2,2,3,},
{4,0,0,0,0,0,0,0,5,},
{6,7,7,8,0,9,9,0,5,},
{0,0,0,4,0,0,0,0,5,},
{0,0,0,4,0,10,0,11,12,},
{1,2,2,13,9,9,0,5,0,},
{4,0,0,0,0,0,0,5,0,},
{6,7,7,7,7,8,0,5,0,},
{0,0,0,0,0,6,7,12,0,},
{0,0,0,0,0,0,0,0,0,},
};
	
	u16			MAP_M07_GetW(){
		return 9;
	}
	u16			MAP_M07_GetH(){
		return 11;
	}
	u16			MAP_M07_GetCellW(){
		return 20;
	}
	u16			MAP_M07_GetCellH(){
		return 20;
	}
	s16			MAP_M07_GetTileIndex(u16 bx, u16 by){
		if(bx<0 || bx>=9 || by<0 || by>=11)return -1;
		return MAP_M07_Parts[MAP_M07_Frames[MAP_M07_Matrix[by][bx]][0]];
	}
	void		MAP_M07_Render(tGraphics *g, s16 px, s16 py){
		int x,y;
		for(y=0;y<11;y++){
			for(x=0;x<9;x++){
				TILE_Render(g,TILE_MAP,MAP_M07_Parts[MAP_M07_Frames[MAP_M07_Matrix[y][x]][0]],px+x*20,py+y*20);
			}
		}
	}

 
	const u8	MAP_M08_Parts[11] = {0,7,3,6,9,1,10,8,4,11,5,};
	const u8	MAP_M08_Frames[11][1] = {{0,/*1*/},{1,/*1*/},{2,/*1*/},{3,/*1*/},{4,/*1*/},{5,/*1*/},{6,/*1*/},{7,/*1*/},{8,/*1*/},{9,/*1*/},{10,/*1*/},};
	const u8	MAP_M08_Matrix[11][9] = {{0,0,0,0,0,0,0,0,0,},
{1,2,2,2,2,2,3,0,0,},
{4,0,0,0,0,0,5,0,0,},
{4,0,0,0,0,0,6,2,3,},
{4,0,0,0,0,0,0,0,5,},
{4,0,0,0,0,0,0,0,5,},
{7,8,8,8,8,9,0,0,5,},
{0,0,0,0,0,7,9,0,5,},
{0,0,0,0,0,0,7,8,10,},
{0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,},
};
	
	u16			MAP_M08_GetW(){
		return 9;
	}
	u16			MAP_M08_GetH(){
		return 11;
	}
	u16			MAP_M08_GetCellW(){
		return 20;
	}
	u16			MAP_M08_GetCellH(){
		return 20;
	}
	s16			MAP_M08_GetTileIndex(u16 bx, u16 by){
		if(bx<0 || bx>=9 || by<0 || by>=11)return -1;
		return MAP_M08_Parts[MAP_M08_Frames[MAP_M08_Matrix[by][bx]][0]];
	}
	void		MAP_M08_Render(tGraphics *g, s16 px, s16 py){
		int x,y;
		for(y=0;y<11;y++){
			for(x=0;x<9;x++){
				TILE_Render(g,TILE_MAP,MAP_M08_Parts[MAP_M08_Frames[MAP_M08_Matrix[y][x]][0]],px+x*20,py+y*20);
			}
		}
	}

 
	const u8	MAP_M09_Parts[12] = {0,7,3,6,9,10,12,1,2,8,4,5,};
	const u8	MAP_M09_Frames[12][1] = {{0,/*1*/},{1,/*1*/},{2,/*1*/},{3,/*1*/},{4,/*1*/},{5,/*1*/},{6,/*1*/},{7,/*1*/},{8,/*1*/},{9,/*1*/},{10,/*1*/},{11,/*1*/},};
	const u8	MAP_M09_Matrix[11][9] = {{0,0,0,0,0,0,0,0,0,},
{0,1,2,2,3,0,1,2,3,},
{0,4,0,0,5,2,6,0,7,},
{1,6,8,0,0,0,0,0,7,},
{4,0,0,0,0,0,0,0,7,},
{4,0,0,0,0,0,0,0,7,},
{4,0,0,0,0,0,0,8,7,},
{4,0,0,0,0,0,0,0,7,},
{4,0,0,0,0,0,0,0,7,},
{9,10,10,10,10,10,10,10,11,},
{0,0,0,0,0,0,0,0,0,},
};
	
	u16			MAP_M09_GetW(){
		return 9;
	}
	u16			MAP_M09_GetH(){
		return 11;
	}
	u16			MAP_M09_GetCellW(){
		return 20;
	}
	u16			MAP_M09_GetCellH(){
		return 20;
	}
	s16			MAP_M09_GetTileIndex(u16 bx, u16 by){
		if(bx<0 || bx>=9 || by<0 || by>=11)return -1;
		return MAP_M09_Parts[MAP_M09_Frames[MAP_M09_Matrix[by][bx]][0]];
	}
	void		MAP_M09_Render(tGraphics *g, s16 px, s16 py){
		int x,y;
		for(y=0;y<11;y++){
			for(x=0;x<9;x++){
				TILE_Render(g,TILE_MAP,MAP_M09_Parts[MAP_M09_Frames[MAP_M09_Matrix[y][x]][0]],px+x*20,py+y*20);
			}
		}
	}

 
	const u8	MAP_M10_Parts[11] = {0,7,3,6,9,1,8,4,11,13,5,};
	const u8	MAP_M10_Frames[11][1] = {{0,/*1*/},{1,/*1*/},{2,/*1*/},{3,/*1*/},{4,/*1*/},{5,/*1*/},{6,/*1*/},{7,/*1*/},{8,/*1*/},{9,/*1*/},{10,/*1*/},};
	const u8	MAP_M10_Matrix[11][9] = {{0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,},
{1,2,2,2,2,2,2,2,3,},
{4,0,0,0,0,0,0,0,5,},
{4,0,0,0,0,0,0,0,5,},
{4,0,0,0,0,0,0,0,5,},
{6,7,7,8,0,9,7,7,10,},
{0,0,0,6,7,10,0,0,0,},
{0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,},
};
	
	u16			MAP_M10_GetW(){
		return 9;
	}
	u16			MAP_M10_GetH(){
		return 11;
	}
	u16			MAP_M10_GetCellW(){
		return 20;
	}
	u16			MAP_M10_GetCellH(){
		return 20;
	}
	s16			MAP_M10_GetTileIndex(u16 bx, u16 by){
		if(bx<0 || bx>=9 || by<0 || by>=11)return -1;
		return MAP_M10_Parts[MAP_M10_Frames[MAP_M10_Matrix[by][bx]][0]];
	}
	void		MAP_M10_Render(tGraphics *g, s16 px, s16 py){
		int x,y;
		for(y=0;y<11;y++){
			for(x=0;x<9;x++){
				TILE_Render(g,TILE_MAP,MAP_M10_Parts[MAP_M10_Frames[MAP_M10_Matrix[y][x]][0]],px+x*20,py+y*20);
			}
		}
	}

 
	const u8	MAP_M11_Parts[11] = {7,3,6,0,9,10,1,8,4,11,5,};
	const u8	MAP_M11_Frames[11][1] = {{0,/*1*/},{1,/*1*/},{2,/*1*/},{3,/*1*/},{4,/*1*/},{5,/*1*/},{6,/*1*/},{7,/*1*/},{8,/*1*/},{9,/*1*/},{10,/*1*/},};
	const u8	MAP_M11_Matrix[11][9] = {{0,1,2,3,3,3,3,3,3,},
{4,3,5,1,1,1,1,1,2,},
{4,3,3,3,3,3,3,3,6,},
{7,8,9,3,3,3,3,3,6,},
{3,3,4,3,3,3,3,3,6,},
{3,3,7,8,9,3,3,3,6,},
{3,3,3,3,4,3,3,3,6,},
{3,3,3,3,7,8,9,3,6,},
{3,3,3,3,3,3,4,3,6,},
{3,3,3,3,3,3,7,8,10,},
{3,3,3,3,3,3,3,3,3,},
};
	
	u16			MAP_M11_GetW(){
		return 9;
	}
	u16			MAP_M11_GetH(){
		return 11;
	}
	u16			MAP_M11_GetCellW(){
		return 20;
	}
	u16			MAP_M11_GetCellH(){
		return 20;
	}
	s16			MAP_M11_GetTileIndex(u16 bx, u16 by){
		if(bx<0 || bx>=9 || by<0 || by>=11)return -1;
		return MAP_M11_Parts[MAP_M11_Frames[MAP_M11_Matrix[by][bx]][0]];
	}
	void		MAP_M11_Render(tGraphics *g, s16 px, s16 py){
		int x,y;
		for(y=0;y<11;y++){
			for(x=0;x<9;x++){
				TILE_Render(g,TILE_MAP,MAP_M11_Parts[MAP_M11_Frames[MAP_M11_Matrix[y][x]][0]],px+x*20,py+y*20);
			}
		}
	}

 
	const u8	MAP_M12_Parts[12] = {0,7,3,6,9,1,10,8,4,11,13,5,};
	const u8	MAP_M12_Frames[12][1] = {{0,/*1*/},{1,/*1*/},{2,/*1*/},{3,/*1*/},{4,/*1*/},{5,/*1*/},{6,/*1*/},{7,/*1*/},{8,/*1*/},{9,/*1*/},{10,/*1*/},{11,/*1*/},};
	const u8	MAP_M12_Matrix[11][9] = {{0,0,0,0,0,0,0,0,0,},
{1,2,2,2,2,3,0,0,0,},
{4,0,0,0,0,5,0,0,0,},
{4,0,0,0,0,5,0,0,0,},
{4,0,0,0,0,6,2,2,3,},
{4,0,0,0,0,0,0,0,5,},
{7,8,8,9,0,0,0,0,5,},
{0,0,0,4,0,0,0,10,11,},
{0,0,0,7,9,0,0,5,0,},
{0,0,0,0,7,8,8,11,0,},
{0,0,0,0,0,0,0,0,0,},
};
	
	u16			MAP_M12_GetW(){
		return 9;
	}
	u16			MAP_M12_GetH(){
		return 11;
	}
	u16			MAP_M12_GetCellW(){
		return 20;
	}
	u16			MAP_M12_GetCellH(){
		return 20;
	}
	s16			MAP_M12_GetTileIndex(u16 bx, u16 by){
		if(bx<0 || bx>=9 || by<0 || by>=11)return -1;
		return MAP_M12_Parts[MAP_M12_Frames[MAP_M12_Matrix[by][bx]][0]];
	}
	void		MAP_M12_Render(tGraphics *g, s16 px, s16 py){
		int x,y;
		for(y=0;y<11;y++){
			for(x=0;x<9;x++){
				TILE_Render(g,TILE_MAP,MAP_M12_Parts[MAP_M12_Frames[MAP_M12_Matrix[y][x]][0]],px+x*20,py+y*20);
			}
		}
	}

 
	const u8	MAP_M13_Parts[14] = {0,7,3,6,12,10,9,1,2,8,11,13,5,4,};
	const u8	MAP_M13_Frames[14][1] = {{0,/*1*/},{1,/*1*/},{2,/*1*/},{3,/*1*/},{4,/*1*/},{5,/*1*/},{6,/*1*/},{7,/*1*/},{8,/*1*/},{9,/*1*/},{10,/*1*/},{11,/*1*/},{12,/*1*/},{13,/*1*/},};
	const u8	MAP_M13_Matrix[11][9] = {{0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,},
{0,0,1,2,2,2,3,0,0,},
{0,1,4,0,0,0,5,3,0,},
{1,4,0,0,0,0,0,5,3,},
{6,0,0,0,0,0,0,0,7,},
{6,0,0,0,8,0,0,0,7,},
{9,10,0,0,0,0,0,11,12,},
{0,9,10,0,0,0,11,12,0,},
{0,0,9,13,13,13,12,0,0,},
{0,0,0,0,0,0,0,0,0,},
};
	
	u16			MAP_M13_GetW(){
		return 9;
	}
	u16			MAP_M13_GetH(){
		return 11;
	}
	u16			MAP_M13_GetCellW(){
		return 20;
	}
	u16			MAP_M13_GetCellH(){
		return 20;
	}
	s16			MAP_M13_GetTileIndex(u16 bx, u16 by){
		if(bx<0 || bx>=9 || by<0 || by>=11)return -1;
		return MAP_M13_Parts[MAP_M13_Frames[MAP_M13_Matrix[by][bx]][0]];
	}
	void		MAP_M13_Render(tGraphics *g, s16 px, s16 py){
		int x,y;
		for(y=0;y<11;y++){
			for(x=0;x<9;x++){
				TILE_Render(g,TILE_MAP,MAP_M13_Parts[MAP_M13_Frames[MAP_M13_Matrix[y][x]][0]],px+x*20,py+y*20);
			}
		}
	}

 
	const u8	MAP_M14_Parts[13] = {0,7,3,6,9,1,10,12,13,5,8,4,11,};
	const u8	MAP_M14_Frames[13][1] = {{0,/*1*/},{1,/*1*/},{2,/*1*/},{3,/*1*/},{4,/*1*/},{5,/*1*/},{6,/*1*/},{7,/*1*/},{8,/*1*/},{9,/*1*/},{10,/*1*/},{11,/*1*/},{12,/*1*/},};
	const u8	MAP_M14_Matrix[11][9] = {{0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,1,2,3,},
{1,2,2,2,3,0,4,0,5,},
{4,0,0,0,6,2,7,0,5,},
{4,0,0,0,0,0,0,0,5,},
{4,0,0,0,0,0,0,0,5,},
{4,0,0,0,0,0,0,8,9,},
{10,11,11,12,0,0,0,5,0,},
{0,0,0,10,11,11,11,9,0,},
{0,0,0,0,0,0,0,0,0,},
};
	
	u16			MAP_M14_GetW(){
		return 9;
	}
	u16			MAP_M14_GetH(){
		return 11;
	}
	u16			MAP_M14_GetCellW(){
		return 20;
	}
	u16			MAP_M14_GetCellH(){
		return 20;
	}
	s16			MAP_M14_GetTileIndex(u16 bx, u16 by){
		if(bx<0 || bx>=9 || by<0 || by>=11)return -1;
		return MAP_M14_Parts[MAP_M14_Frames[MAP_M14_Matrix[by][bx]][0]];
	}
	void		MAP_M14_Render(tGraphics *g, s16 px, s16 py){
		int x,y;
		for(y=0;y<11;y++){
			for(x=0;x<9;x++){
				TILE_Render(g,TILE_MAP,MAP_M14_Parts[MAP_M14_Frames[MAP_M14_Matrix[y][x]][0]],px+x*20,py+y*20);
			}
		}
	}

 
	const u8	MAP_M03_Parts[13] = {0,7,3,6,9,1,10,12,13,5,8,4,11,};
	const u8	MAP_M03_Frames[13][1] = {{0,/*1*/},{1,/*1*/},{2,/*1*/},{3,/*1*/},{4,/*1*/},{5,/*1*/},{6,/*1*/},{7,/*1*/},{8,/*1*/},{9,/*1*/},{10,/*1*/},{11,/*1*/},{12,/*1*/},};
	const u8	MAP_M03_Matrix[11][9] = {{0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,1,2,3,},
{1,2,2,2,3,0,4,0,5,},
{4,0,0,0,6,2,7,0,5,},
{4,0,0,0,0,0,0,0,5,},
{4,0,0,0,0,0,0,0,5,},
{4,0,0,0,0,0,0,8,9,},
{10,11,11,12,0,0,0,5,0,},
{0,0,0,10,11,11,11,9,0,},
{0,0,0,0,0,0,0,0,0,},
};
	
	u16			MAP_M03_GetW(){
		return 9;
	}
	u16			MAP_M03_GetH(){
		return 11;
	}
	u16			MAP_M03_GetCellW(){
		return 20;
	}
	u16			MAP_M03_GetCellH(){
		return 20;
	}
	s16			MAP_M03_GetTileIndex(u16 bx, u16 by){
		if(bx<0 || bx>=9 || by<0 || by>=11)return -1;
		return MAP_M03_Parts[MAP_M03_Frames[MAP_M03_Matrix[by][bx]][0]];
	}
	void		MAP_M03_Render(tGraphics *g, s16 px, s16 py){
		int x,y;
		for(y=0;y<11;y++){
			for(x=0;x<9;x++){
				TILE_Render(g,TILE_MAP,MAP_M03_Parts[MAP_M03_Frames[MAP_M03_Matrix[y][x]][0]],px+x*20,py+y*20);
			}
		}
	}

 
	const u8	MAP_M15_Parts[14] = {0,7,3,16,6,9,15,1,8,11,2,4,13,5,};
	const u8	MAP_M15_Frames[14][1] = {{0,/*1*/},{1,/*1*/},{2,/*1*/},{3,/*1*/},{4,/*1*/},{5,/*1*/},{6,/*1*/},{7,/*1*/},{8,/*1*/},{9,/*1*/},{10,/*1*/},{11,/*1*/},{12,/*1*/},{13,/*1*/},};
	const u8	MAP_M15_Matrix[11][9] = {{0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,},
{1,2,2,2,2,3,2,2,4,},
{5,0,0,0,0,6,0,0,7,},
{5,0,0,0,0,6,0,0,7,},
{5,0,0,6,0,6,0,0,7,},
{8,9,0,6,0,10,10,0,7,},
{0,8,11,9,0,0,0,0,7,},
{0,0,0,8,9,0,0,12,13,},
{0,0,0,0,8,11,11,13,0,},
{0,0,0,0,0,0,0,0,0,},
};
	
	u16			MAP_M15_GetW(){
		return 9;
	}
	u16			MAP_M15_GetH(){
		return 11;
	}
	u16			MAP_M15_GetCellW(){
		return 20;
	}
	u16			MAP_M15_GetCellH(){
		return 20;
	}
	s16			MAP_M15_GetTileIndex(u16 bx, u16 by){
		if(bx<0 || bx>=9 || by<0 || by>=11)return -1;
		return MAP_M15_Parts[MAP_M15_Frames[MAP_M15_Matrix[by][bx]][0]];
	}
	void		MAP_M15_Render(tGraphics *g, s16 px, s16 py){
		int x,y;
		for(y=0;y<11;y++){
			for(x=0;x<9;x++){
				TILE_Render(g,TILE_MAP,MAP_M15_Parts[MAP_M15_Frames[MAP_M15_Matrix[y][x]][0]],px+x*20,py+y*20);
			}
		}
	}

 
	const u8	MAP_M16_Parts[12] = {0,7,3,6,9,1,12,13,4,5,8,11,};
	const u8	MAP_M16_Frames[12][1] = {{0,/*1*/},{1,/*1*/},{2,/*1*/},{3,/*1*/},{4,/*1*/},{5,/*1*/},{6,/*1*/},{7,/*1*/},{8,/*1*/},{9,/*1*/},{10,/*1*/},{11,/*1*/},};
	const u8	MAP_M16_Matrix[11][9] = {{0,0,0,0,0,0,0,0,0,},
{0,0,1,2,2,2,2,2,3,},
{0,0,4,0,0,0,0,0,5,},
{0,1,6,0,0,0,0,0,5,},
{1,6,0,0,0,0,0,0,5,},
{4,0,0,0,0,0,0,0,5,},
{4,0,0,7,8,8,8,8,9,},
{4,0,0,5,0,0,0,0,0,},
{4,0,0,5,0,0,0,0,0,},
{10,11,0,5,0,0,0,0,0,},
{0,10,8,9,0,0,0,0,0,},
};
	
	u16			MAP_M16_GetW(){
		return 9;
	}
	u16			MAP_M16_GetH(){
		return 11;
	}
	u16			MAP_M16_GetCellW(){
		return 20;
	}
	u16			MAP_M16_GetCellH(){
		return 20;
	}
	s16			MAP_M16_GetTileIndex(u16 bx, u16 by){
		if(bx<0 || bx>=9 || by<0 || by>=11)return -1;
		return MAP_M16_Parts[MAP_M16_Frames[MAP_M16_Matrix[by][bx]][0]];
	}
	void		MAP_M16_Render(tGraphics *g, s16 px, s16 py){
		int x,y;
		for(y=0;y<11;y++){
			for(x=0;x<9;x++){
				TILE_Render(g,TILE_MAP,MAP_M16_Parts[MAP_M16_Frames[MAP_M16_Matrix[y][x]][0]],px+x*20,py+y*20);
			}
		}
	}

 
	const u8	MAP_M17_Parts[14] = {0,7,3,6,9,10,1,2,15,13,5,8,11,4,};
	const u8	MAP_M17_Frames[14][1] = {{0,/*1*/},{1,/*1*/},{2,/*1*/},{3,/*1*/},{4,/*1*/},{5,/*1*/},{6,/*1*/},{7,/*1*/},{8,/*1*/},{9,/*1*/},{10,/*1*/},{11,/*1*/},{12,/*1*/},{13,/*1*/},};
	const u8	MAP_M17_Matrix[11][9] = {{0,0,0,0,0,0,0,0,0,},
{1,2,3,0,0,0,0,0,0,},
{4,0,5,2,2,2,2,2,3,},
{4,0,0,0,0,0,0,0,6,},
{4,7,0,0,0,8,0,9,10,},
{4,0,0,8,0,8,0,6,0,},
{4,0,0,8,7,7,0,6,0,},
{11,12,0,8,0,0,0,6,0,},
{0,11,13,13,13,12,0,6,0,},
{0,0,0,0,0,11,13,10,0,},
{0,0,0,0,0,0,0,0,0,},
};
	
	u16			MAP_M17_GetW(){
		return 9;
	}
	u16			MAP_M17_GetH(){
		return 11;
	}
	u16			MAP_M17_GetCellW(){
		return 20;
	}
	u16			MAP_M17_GetCellH(){
		return 20;
	}
	s16			MAP_M17_GetTileIndex(u16 bx, u16 by){
		if(bx<0 || bx>=9 || by<0 || by>=11)return -1;
		return MAP_M17_Parts[MAP_M17_Frames[MAP_M17_Matrix[by][bx]][0]];
	}
	void		MAP_M17_Render(tGraphics *g, s16 px, s16 py){
		int x,y;
		for(y=0;y<11;y++){
			for(x=0;x<9;x++){
				TILE_Render(g,TILE_MAP,MAP_M17_Parts[MAP_M17_Frames[MAP_M17_Matrix[y][x]][0]],px+x*20,py+y*20);
			}
		}
	}

 
	const u8	MAP_M18_Parts[12] = {0,7,3,6,9,1,8,11,15,13,5,4,};
	const u8	MAP_M18_Frames[12][1] = {{0,/*1*/},{1,/*1*/},{2,/*1*/},{3,/*1*/},{4,/*1*/},{5,/*1*/},{6,/*1*/},{7,/*1*/},{8,/*1*/},{9,/*1*/},{10,/*1*/},{11,/*1*/},};
	const u8	MAP_M18_Matrix[11][9] = {{0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,},
{1,2,2,2,2,2,2,2,3,},
{4,0,0,0,0,0,0,0,5,},
{4,0,0,0,0,0,0,0,5,},
{4,0,0,0,0,0,0,0,5,},
{6,7,0,0,8,0,0,9,10,},
{0,4,0,9,11,7,0,5,0,},
{0,6,11,10,0,6,11,10,0,},
{0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,},
};
	
	u16			MAP_M18_GetW(){
		return 9;
	}
	u16			MAP_M18_GetH(){
		return 11;
	}
	u16			MAP_M18_GetCellW(){
		return 20;
	}
	u16			MAP_M18_GetCellH(){
		return 20;
	}
	s16			MAP_M18_GetTileIndex(u16 bx, u16 by){
		if(bx<0 || bx>=9 || by<0 || by>=11)return -1;
		return MAP_M18_Parts[MAP_M18_Frames[MAP_M18_Matrix[by][bx]][0]];
	}
	void		MAP_M18_Render(tGraphics *g, s16 px, s16 py){
		int x,y;
		for(y=0;y<11;y++){
			for(x=0;x<9;x++){
				TILE_Render(g,TILE_MAP,MAP_M18_Parts[MAP_M18_Frames[MAP_M18_Matrix[y][x]][0]],px+x*20,py+y*20);
			}
		}
	}

 

// public 
enum {	
	MAP_null,
	 MAP_M01, 
 MAP_M02, 
 MAP_M04, 
 MAP_M05, 
 MAP_M06, 
 MAP_M07, 
 MAP_M08, 
 MAP_M09, 
 MAP_M10, 
 MAP_M11, 
 MAP_M12, 
 MAP_M13, 
 MAP_M14, 
 MAP_M03, 
 MAP_M15, 
 MAP_M16, 
 MAP_M17, 
 MAP_M18, 
 
};
u16 MAP_GetW(u16 name){
	switch(name){
	 case MAP_M01: return MAP_M01_GetW(); 
 case MAP_M02: return MAP_M02_GetW(); 
 case MAP_M04: return MAP_M04_GetW(); 
 case MAP_M05: return MAP_M05_GetW(); 
 case MAP_M06: return MAP_M06_GetW(); 
 case MAP_M07: return MAP_M07_GetW(); 
 case MAP_M08: return MAP_M08_GetW(); 
 case MAP_M09: return MAP_M09_GetW(); 
 case MAP_M10: return MAP_M10_GetW(); 
 case MAP_M11: return MAP_M11_GetW(); 
 case MAP_M12: return MAP_M12_GetW(); 
 case MAP_M13: return MAP_M13_GetW(); 
 case MAP_M14: return MAP_M14_GetW(); 
 case MAP_M03: return MAP_M03_GetW(); 
 case MAP_M15: return MAP_M15_GetW(); 
 case MAP_M16: return MAP_M16_GetW(); 
 case MAP_M17: return MAP_M17_GetW(); 
 case MAP_M18: return MAP_M18_GetW(); 
 
	}
	return 0;
}
u16 MAP_GetH(u16 name){
	switch(name){
	 case MAP_M01: return MAP_M01_GetH(); 
 case MAP_M02: return MAP_M02_GetH(); 
 case MAP_M04: return MAP_M04_GetH(); 
 case MAP_M05: return MAP_M05_GetH(); 
 case MAP_M06: return MAP_M06_GetH(); 
 case MAP_M07: return MAP_M07_GetH(); 
 case MAP_M08: return MAP_M08_GetH(); 
 case MAP_M09: return MAP_M09_GetH(); 
 case MAP_M10: return MAP_M10_GetH(); 
 case MAP_M11: return MAP_M11_GetH(); 
 case MAP_M12: return MAP_M12_GetH(); 
 case MAP_M13: return MAP_M13_GetH(); 
 case MAP_M14: return MAP_M14_GetH(); 
 case MAP_M03: return MAP_M03_GetH(); 
 case MAP_M15: return MAP_M15_GetH(); 
 case MAP_M16: return MAP_M16_GetH(); 
 case MAP_M17: return MAP_M17_GetH(); 
 case MAP_M18: return MAP_M18_GetH(); 
 
	}
	return 0;
}
u16 MAP_GetCellW(u16 name){
	switch(name){
	 case MAP_M01: return MAP_M01_GetCellW(); 
 case MAP_M02: return MAP_M02_GetCellW(); 
 case MAP_M04: return MAP_M04_GetCellW(); 
 case MAP_M05: return MAP_M05_GetCellW(); 
 case MAP_M06: return MAP_M06_GetCellW(); 
 case MAP_M07: return MAP_M07_GetCellW(); 
 case MAP_M08: return MAP_M08_GetCellW(); 
 case MAP_M09: return MAP_M09_GetCellW(); 
 case MAP_M10: return MAP_M10_GetCellW(); 
 case MAP_M11: return MAP_M11_GetCellW(); 
 case MAP_M12: return MAP_M12_GetCellW(); 
 case MAP_M13: return MAP_M13_GetCellW(); 
 case MAP_M14: return MAP_M14_GetCellW(); 
 case MAP_M03: return MAP_M03_GetCellW(); 
 case MAP_M15: return MAP_M15_GetCellW(); 
 case MAP_M16: return MAP_M16_GetCellW(); 
 case MAP_M17: return MAP_M17_GetCellW(); 
 case MAP_M18: return MAP_M18_GetCellW(); 
 
	}
	return 0;
}
u16 MAP_GetCellH(u16 name){
	switch(name){
	 case MAP_M01: return MAP_M01_GetCellH(); 
 case MAP_M02: return MAP_M02_GetCellH(); 
 case MAP_M04: return MAP_M04_GetCellH(); 
 case MAP_M05: return MAP_M05_GetCellH(); 
 case MAP_M06: return MAP_M06_GetCellH(); 
 case MAP_M07: return MAP_M07_GetCellH(); 
 case MAP_M08: return MAP_M08_GetCellH(); 
 case MAP_M09: return MAP_M09_GetCellH(); 
 case MAP_M10: return MAP_M10_GetCellH(); 
 case MAP_M11: return MAP_M11_GetCellH(); 
 case MAP_M12: return MAP_M12_GetCellH(); 
 case MAP_M13: return MAP_M13_GetCellH(); 
 case MAP_M14: return MAP_M14_GetCellH(); 
 case MAP_M03: return MAP_M03_GetCellH(); 
 case MAP_M15: return MAP_M15_GetCellH(); 
 case MAP_M16: return MAP_M16_GetCellH(); 
 case MAP_M17: return MAP_M17_GetCellH(); 
 case MAP_M18: return MAP_M18_GetCellH(); 
 
	}
	return 0;
}
s16 MAP_GetTileIndex(u16 name, u16 bx, u16 by){
	switch(name){
	 case MAP_M01: return MAP_M01_GetTileIndex(bx,by); 
 case MAP_M02: return MAP_M02_GetTileIndex(bx,by); 
 case MAP_M04: return MAP_M04_GetTileIndex(bx,by); 
 case MAP_M05: return MAP_M05_GetTileIndex(bx,by); 
 case MAP_M06: return MAP_M06_GetTileIndex(bx,by); 
 case MAP_M07: return MAP_M07_GetTileIndex(bx,by); 
 case MAP_M08: return MAP_M08_GetTileIndex(bx,by); 
 case MAP_M09: return MAP_M09_GetTileIndex(bx,by); 
 case MAP_M10: return MAP_M10_GetTileIndex(bx,by); 
 case MAP_M11: return MAP_M11_GetTileIndex(bx,by); 
 case MAP_M12: return MAP_M12_GetTileIndex(bx,by); 
 case MAP_M13: return MAP_M13_GetTileIndex(bx,by); 
 case MAP_M14: return MAP_M14_GetTileIndex(bx,by); 
 case MAP_M03: return MAP_M03_GetTileIndex(bx,by); 
 case MAP_M15: return MAP_M15_GetTileIndex(bx,by); 
 case MAP_M16: return MAP_M16_GetTileIndex(bx,by); 
 case MAP_M17: return MAP_M17_GetTileIndex(bx,by); 
 case MAP_M18: return MAP_M18_GetTileIndex(bx,by); 
 
	}
	return -1;
}
void MAP_Render(tGraphics *g, u16 name, s16 px, s16 py){
	switch(name){
	 case MAP_M01: MAP_M01_Render(g, px, py); break; 
 case MAP_M02: MAP_M02_Render(g, px, py); break; 
 case MAP_M04: MAP_M04_Render(g, px, py); break; 
 case MAP_M05: MAP_M05_Render(g, px, py); break; 
 case MAP_M06: MAP_M06_Render(g, px, py); break; 
 case MAP_M07: MAP_M07_Render(g, px, py); break; 
 case MAP_M08: MAP_M08_Render(g, px, py); break; 
 case MAP_M09: MAP_M09_Render(g, px, py); break; 
 case MAP_M10: MAP_M10_Render(g, px, py); break; 
 case MAP_M11: MAP_M11_Render(g, px, py); break; 
 case MAP_M12: MAP_M12_Render(g, px, py); break; 
 case MAP_M13: MAP_M13_Render(g, px, py); break; 
 case MAP_M14: MAP_M14_Render(g, px, py); break; 
 case MAP_M03: MAP_M03_Render(g, px, py); break; 
 case MAP_M15: MAP_M15_Render(g, px, py); break; 
 case MAP_M16: MAP_M16_Render(g, px, py); break; 
 case MAP_M17: MAP_M17_Render(g, px, py); break; 
 case MAP_M18: MAP_M18_Render(g, px, py); break; 
 
	}
}


/**************************************************************************************************/
/* spr                                                                                            */
/**************************************************************************************************/
 
	const s16	SPR_DYNAMIC_Parts[8][4]	= {{27,0,0},{23,0,0},{25,0,0},{19,0,0},{31,0,0},{29,0,0},{33,0,0},{21,0,0},};
	const u8	SPR_DYNAMIC_Frames[8][1] = { {0,/*1*/},  {1,/*1*/},  {2,/*1*/},  {3,/*1*/},  {4,/*1*/},  {5,/*1*/},  {6,/*1*/},  {7,/*1*/}, };
	const u8	SPR_DYNAMIC_Animate[8][32] = {{0,},
{1,},
{2,},
{3,},
{4,},
{5,},
{6,},
{7,},
};
	const u8	SPR_DYNAMIC_FrameCounts[8] = {1,1,1,1,1,1,1,1,};

	u16			SPR_DYNAMIC_GetAnimateCount(){
		return 8;
	}
	u16			SPR_DYNAMIC_GetFrameCount(u16 anim){
		if(anim < 8)
			return SPR_DYNAMIC_FrameCounts[anim];
		else 
			return 0;
	}
	void		SPR_DYNAMIC_Render(tGraphics *g, u16 anim, u16 frame, s16 px, s16 py){
		if(anim < SPR_DYNAMIC_GetAnimateCount() && frame < SPR_DYNAMIC_GetFrameCount(anim)){
			u16 index = SPR_DYNAMIC_Parts[SPR_DYNAMIC_Frames[SPR_DYNAMIC_Animate[anim][frame]][0]][0];
			s16 x = SPR_DYNAMIC_Parts[SPR_DYNAMIC_Frames[SPR_DYNAMIC_Animate[anim][frame]][0]][1] + px;
			s16 y = SPR_DYNAMIC_Parts[SPR_DYNAMIC_Frames[SPR_DYNAMIC_Animate[anim][frame]][0]][2] + py;
			TILE_Render(g,TILE_LEVEL,index,x,y);
		}
	}

 
	const s16	SPR_POINT_Parts[5][4]	= {{39,-1,-1},{40,-1,-1},{41,-1,-1},{42,-1,-1},{43,-1,-1},};
	const u8	SPR_POINT_Frames[5][1] = { {0,/*1*/},  {1,/*1*/},  {2,/*1*/},  {3,/*1*/},  {4,/*1*/}, };
	const u8	SPR_POINT_Animate[1][32] = {{0,1,2,3,4,},
};
	const u8	SPR_POINT_FrameCounts[1] = {5,};

	u16			SPR_POINT_GetAnimateCount(){
		return 1;
	}
	u16			SPR_POINT_GetFrameCount(u16 anim){
		if(anim < 1)
			return SPR_POINT_FrameCounts[anim];
		else 
			return 0;
	}
	void		SPR_POINT_Render(tGraphics *g, u16 anim, u16 frame, s16 px, s16 py){
		if(anim < SPR_POINT_GetAnimateCount() && frame < SPR_POINT_GetFrameCount(anim)){
			u16 index = SPR_POINT_Parts[SPR_POINT_Frames[SPR_POINT_Animate[anim][frame]][0]][0];
			s16 x = SPR_POINT_Parts[SPR_POINT_Frames[SPR_POINT_Animate[anim][frame]][0]][1] + px;
			s16 y = SPR_POINT_Parts[SPR_POINT_Frames[SPR_POINT_Animate[anim][frame]][0]][2] + py;
			TILE_Render(g,TILE_LEVEL,index,x,y);
		}
	}

 
	const s16	SPR_EFFECT_Parts[8][4]	= {{35,-4,-4},{35,7,6},{36,3,2},{37,-1,0},{38,-4,-3},{6,-2,-4},{7,-7,-8},{8,-8,-7},};
	const u8	SPR_EFFECT_Frames[8][1] = { {0,/*1*/},  {1,/*1*/},  {2,/*1*/},  {3,/*1*/},  {4,/*1*/},  {5,/*1*/},  {6,/*1*/},  {7,/*1*/}, };
	const u8	SPR_EFFECT_Animate[3][32] = {{0,},
{1,2,3,4,4,},
{5,5,6,6,6,7,7,7,7,},
};
	const u8	SPR_EFFECT_FrameCounts[3] = {1,5,9,};

	u16			SPR_EFFECT_GetAnimateCount(){
		return 3;
	}
	u16			SPR_EFFECT_GetFrameCount(u16 anim){
		if(anim < 3)
			return SPR_EFFECT_FrameCounts[anim];
		else 
			return 0;
	}
	void		SPR_EFFECT_Render(tGraphics *g, u16 anim, u16 frame, s16 px, s16 py){
		if(anim < SPR_EFFECT_GetAnimateCount() && frame < SPR_EFFECT_GetFrameCount(anim)){
			u16 index = SPR_EFFECT_Parts[SPR_EFFECT_Frames[SPR_EFFECT_Animate[anim][frame]][0]][0];
			s16 x = SPR_EFFECT_Parts[SPR_EFFECT_Frames[SPR_EFFECT_Animate[anim][frame]][0]][1] + px;
			s16 y = SPR_EFFECT_Parts[SPR_EFFECT_Frames[SPR_EFFECT_Animate[anim][frame]][0]][2] + py;
			TILE_Render(g,TILE_LEVEL,index,x,y);
		}
	}

 
	const s16	SPR_OBJECT_Parts[7][4]	= {{16,0,0},{17,0,0},{18,0,0},{10,0,0},{2,0,0},{15,0,0},{5,0,0},};
	const u8	SPR_OBJECT_Frames[7][1] = { {0,/*1*/},  {1,/*1*/},  {2,/*1*/},  {3,/*1*/},  {4,/*1*/},  {5,/*1*/},  {6,/*1*/}, };
	const u8	SPR_OBJECT_Animate[5][32] = {{0,0,0,1,1,1,2,2,2,},
{3,},
{4,},
{5,},
{6,},
};
	const u8	SPR_OBJECT_FrameCounts[5] = {9,1,1,1,1,};

	u16			SPR_OBJECT_GetAnimateCount(){
		return 5;
	}
	u16			SPR_OBJECT_GetFrameCount(u16 anim){
		if(anim < 5)
			return SPR_OBJECT_FrameCounts[anim];
		else 
			return 0;
	}
	void		SPR_OBJECT_Render(tGraphics *g, u16 anim, u16 frame, s16 px, s16 py){
		if(anim < SPR_OBJECT_GetAnimateCount() && frame < SPR_OBJECT_GetFrameCount(anim)){
			u16 index = SPR_OBJECT_Parts[SPR_OBJECT_Frames[SPR_OBJECT_Animate[anim][frame]][0]][0];
			s16 x = SPR_OBJECT_Parts[SPR_OBJECT_Frames[SPR_OBJECT_Animate[anim][frame]][0]][1] + px;
			s16 y = SPR_OBJECT_Parts[SPR_OBJECT_Frames[SPR_OBJECT_Animate[anim][frame]][0]][2] + py;
			TILE_Render(g,TILE_LEVEL,index,x,y);
		}
	}

 

// public 
enum {	
	SPR_null,
	 SPR_DYNAMIC, 
 SPR_POINT, 
 SPR_EFFECT, 
 SPR_OBJECT, 
 
};
u16 SPR_GetAnimateCount(u16 name){
	switch(name){
	 case SPR_DYNAMIC: return SPR_DYNAMIC_GetAnimateCount(); 
 case SPR_POINT: return SPR_POINT_GetAnimateCount(); 
 case SPR_EFFECT: return SPR_EFFECT_GetAnimateCount(); 
 case SPR_OBJECT: return SPR_OBJECT_GetAnimateCount(); 
 
	}
	return 0;
}
u16 SPR_GetFrameCount(u16 name, u16 anim){
	switch(name){
	 case SPR_DYNAMIC: return SPR_DYNAMIC_GetFrameCount(anim); 
 case SPR_POINT: return SPR_POINT_GetFrameCount(anim); 
 case SPR_EFFECT: return SPR_EFFECT_GetFrameCount(anim); 
 case SPR_OBJECT: return SPR_OBJECT_GetFrameCount(anim); 
 
	}
	return 0;
}
void SPR_Render(tGraphics *g, u16 name, u16 anim, u16 frame, s16 px, s16 py){
	switch(name){
	 case SPR_DYNAMIC: SPR_DYNAMIC_Render(g, anim, frame, px, py); break; 
 case SPR_POINT: SPR_POINT_Render(g, anim, frame, px, py); break; 
 case SPR_EFFECT: SPR_EFFECT_Render(g, anim, frame, px, py); break; 
 case SPR_OBJECT: SPR_OBJECT_Render(g, anim, frame, px, py); break; 
 
	}
}






/**************************************************************************************************/
/* level                                                                                            */
/**************************************************************************************************/

 


// world data
 
	const u16	WORLD_L01_MAP_ID = MAP_M01;
	// spr dynamic
	u8			WORLD_L01_SPR_ID[8] = {SPR_DYNAMIC,SPR_DYNAMIC,SPR_DYNAMIC,SPR_DYNAMIC,SPR_DYNAMIC,SPR_DYNAMIC,SPR_DYNAMIC,SPR_DYNAMIC,};
	u8			WORLD_L01_SPR_ANIM_ID[8] = {0,0,1,1,2,2,3,3,};
    s16			WORLD_L01_SPR_X[8] = {20,100,40,120,60,140,80,60,};    
	s16			WORLD_L01_SPR_Y[8] = {100,120,100,120,120,120,120,100,};
	
	// map functions
	u16			WORLD_L01_GetMAP(){
		return WORLD_L01_MAP_ID;
	}

	// spr functions
	u16			WORLD_L01_GetSprCount(){
		return 8;
	}
	u16			WORLD_L01_GetSprID(u16 index){
		if(index>=8)return 0;
		return WORLD_L01_SPR_ID[index];
	}
	s16			WORLD_L01_GetSprX(u16 index){
		if(index>=8)return 0;
		return WORLD_L01_SPR_X[index];
	}
	s16			WORLD_L01_GetSprY(u16 index){
		if(index>=8)return 0;
		return WORLD_L01_SPR_Y[index];
	}
	s16			WORLD_L01_GetSprANIM(u16 index){
		if(index>=8)return -1;
		return WORLD_L01_SPR_ANIM_ID[index];
	}
	void		WORLD_L01_SetSpr(u16 index, u8 id, u8 anim, s16 x, s16 y){
		if(index>=8)return;
		WORLD_L01_SPR_ID[index] = id;
		WORLD_L01_SPR_ANIM_ID[index] = anim;
		WORLD_L01_SPR_X[index] = x;
		WORLD_L01_SPR_Y[index] = y;
	}

	s16			WORLD_L01_SelectSPR(s16 x, s16 y){
		int i;
		for(i=0;i<8;i++){
			if(CdRectPoint2(
				WORLD_L01_SPR_X[i],
				WORLD_L01_SPR_Y[i],
				MAP_GetCellW(WORLD_L01_MAP_ID),
				MAP_GetCellH(WORLD_L01_MAP_ID),
				x,y))return i;
		}
		return -1;
	}
	bool		WORLD_L01_TryMoveSpr(u16 index, s16 px, s16 py){
		int i,bx,by;
		if(index>=8)return false;
		bx = WORLD_L01_SPR_X[index]/MAP_GetCellW(WORLD_L01_MAP_ID) + (px==0?0:(px>0?1:-1));
		by = WORLD_L01_SPR_Y[index]/MAP_GetCellH(WORLD_L01_MAP_ID) + (py==0?0:(py>0?1:-1));
		if( MAP_GetTileIndex(WORLD_L01_MAP_ID,bx,by)!=0 ){
			return true;
		}
		for(i=0;i<8;i++){
			if(index==i)continue;
			if(CdRect2(
				WORLD_L01_SPR_X[index] + px,
				WORLD_L01_SPR_Y[index] + py,
				MAP_GetCellW(WORLD_L01_MAP_ID),
				MAP_GetCellH(WORLD_L01_MAP_ID),
				WORLD_L01_SPR_X[i],
				WORLD_L01_SPR_Y[i],
				MAP_GetCellW(WORLD_L01_MAP_ID),
				MAP_GetCellH(WORLD_L01_MAP_ID)
				)){
				return true;
			}
		}
		WORLD_L01_SPR_X[index] += px;
		WORLD_L01_SPR_Y[index] += py;
		return false;
	}
	bool		WORLD_L01_TryPushSpr(u16 index, s16 px, s16 py){
		int i,bx,by;
		if(index>=8)return false;
		bx = WORLD_L01_SPR_X[index]/MAP_GetCellW(WORLD_L01_MAP_ID) + (px==0?0:(px>0?1:-1));
		by = WORLD_L01_SPR_Y[index]/MAP_GetCellH(WORLD_L01_MAP_ID) + (py==0?0:(py>0?1:-1));
		if( MAP_GetTileIndex(WORLD_L01_MAP_ID,bx,by)!=0 ){
			return true;
		}
		for(i=0;i<8;i++){
			if(index==i)continue;
			if(CdRect2(
				WORLD_L01_SPR_X[index] + px,
				WORLD_L01_SPR_Y[index] + py,
				MAP_GetCellW(WORLD_L01_MAP_ID),
				MAP_GetCellH(WORLD_L01_MAP_ID),
				WORLD_L01_SPR_X[i],
				WORLD_L01_SPR_Y[i],
				MAP_GetCellW(WORLD_L01_MAP_ID),
				MAP_GetCellH(WORLD_L01_MAP_ID)
				)){
				if(WORLD_L01_TryPushSpr(i,px,py)){
					return true;
				}
			}
		}
		WORLD_L01_SPR_X[index] += px;
		WORLD_L01_SPR_Y[index] += py;
		return false;
	}

	void		WORLD_L01_Render(tGraphics *g, s16 x, s16 y){
		int i;
		MAP_Render(g,WORLD_L01_MAP_ID,x,y);
		for(i=0;i<8;i++){
			SPR_Render(g,WORLD_L01_SPR_ID[i],WORLD_L01_SPR_ANIM_ID[i],0,WORLD_L01_SPR_X[i]+x,WORLD_L01_SPR_Y[i]+y);
		}
	}

 
	const u16	WORLD_L02_MAP_ID = MAP_M02;
	// spr dynamic
	u8			WORLD_L02_SPR_ID[10] = {SPR_DYNAMIC,SPR_DYNAMIC,SPR_DYNAMIC,SPR_DYNAMIC,SPR_DYNAMIC,SPR_DYNAMIC,SPR_DYNAMIC,SPR_DYNAMIC,SPR_DYNAMIC,SPR_DYNAMIC,};
	u8			WORLD_L02_SPR_ANIM_ID[10] = {0,1,2,0,3,0,2,3,0,1,};
    s16			WORLD_L02_SPR_X[10] = {100,100,100,80,80,60,80,80,100,100,};    
	s16			WORLD_L02_SPR_Y[10] = {20,40,60,60,80,120,120,140,160,180,};
	
	// map functions
	u16			WORLD_L02_GetMAP(){
		return WORLD_L02_MAP_ID;
	}

	// spr functions
	u16			WORLD_L02_GetSprCount(){
		return 10;
	}
	u16			WORLD_L02_GetSprID(u16 index){
		if(index>=10)return 0;
		return WORLD_L02_SPR_ID[index];
	}
	s16			WORLD_L02_GetSprX(u16 index){
		if(index>=10)return 0;
		return WORLD_L02_SPR_X[index];
	}
	s16			WORLD_L02_GetSprY(u16 index){
		if(index>=10)return 0;
		return WORLD_L02_SPR_Y[index];
	}
	s16			WORLD_L02_GetSprANIM(u16 index){
		if(index>=10)return -1;
		return WORLD_L02_SPR_ANIM_ID[index];
	}
	void		WORLD_L02_SetSpr(u16 index, u8 id, u8 anim, s16 x, s16 y){
		if(index>=10)return;
		WORLD_L02_SPR_ID[index] = id;
		WORLD_L02_SPR_ANIM_ID[index] = anim;
		WORLD_L02_SPR_X[index] = x;
		WORLD_L02_SPR_Y[index] = y;
	}

	s16			WORLD_L02_SelectSPR(s16 x, s16 y){
		int i;
		for(i=0;i<10;i++){
			if(CdRectPoint2(
				WORLD_L02_SPR_X[i],
				WORLD_L02_SPR_Y[i],
				MAP_GetCellW(WORLD_L02_MAP_ID),
				MAP_GetCellH(WORLD_L02_MAP_ID),
				x,y))return i;
		}
		return -1;
	}
	bool		WORLD_L02_TryMoveSpr(u16 index, s16 px, s16 py){
		int i,bx,by;
		if(index>=10)return false;
		bx = WORLD_L02_SPR_X[index]/MAP_GetCellW(WORLD_L02_MAP_ID) + (px==0?0:(px>0?1:-1));
		by = WORLD_L02_SPR_Y[index]/MAP_GetCellH(WORLD_L02_MAP_ID) + (py==0?0:(py>0?1:-1));
		if( MAP_GetTileIndex(WORLD_L02_MAP_ID,bx,by)!=0 ){
			return true;
		}
		for(i=0;i<10;i++){
			if(index==i)continue;
			if(CdRect2(
				WORLD_L02_SPR_X[index] + px,
				WORLD_L02_SPR_Y[index] + py,
				MAP_GetCellW(WORLD_L02_MAP_ID),
				MAP_GetCellH(WORLD_L02_MAP_ID),
				WORLD_L02_SPR_X[i],
				WORLD_L02_SPR_Y[i],
				MAP_GetCellW(WORLD_L02_MAP_ID),
				MAP_GetCellH(WORLD_L02_MAP_ID)
				)){
				return true;
			}
		}
		WORLD_L02_SPR_X[index] += px;
		WORLD_L02_SPR_Y[index] += py;
		return false;
	}
	bool		WORLD_L02_TryPushSpr(u16 index, s16 px, s16 py){
		int i,bx,by;
		if(index>=10)return false;
		bx = WORLD_L02_SPR_X[index]/MAP_GetCellW(WORLD_L02_MAP_ID) + (px==0?0:(px>0?1:-1));
		by = WORLD_L02_SPR_Y[index]/MAP_GetCellH(WORLD_L02_MAP_ID) + (py==0?0:(py>0?1:-1));
		if( MAP_GetTileIndex(WORLD_L02_MAP_ID,bx,by)!=0 ){
			return true;
		}
		for(i=0;i<10;i++){
			if(index==i)continue;
			if(CdRect2(
				WORLD_L02_SPR_X[index] + px,
				WORLD_L02_SPR_Y[index] + py,
				MAP_GetCellW(WORLD_L02_MAP_ID),
				MAP_GetCellH(WORLD_L02_MAP_ID),
				WORLD_L02_SPR_X[i],
				WORLD_L02_SPR_Y[i],
				MAP_GetCellW(WORLD_L02_MAP_ID),
				MAP_GetCellH(WORLD_L02_MAP_ID)
				)){
				if(WORLD_L02_TryPushSpr(i,px,py)){
					return true;
				}
			}
		}
		WORLD_L02_SPR_X[index] += px;
		WORLD_L02_SPR_Y[index] += py;
		return false;
	}

	void		WORLD_L02_Render(tGraphics *g, s16 x, s16 y){
		int i;
		MAP_Render(g,WORLD_L02_MAP_ID,x,y);
		for(i=0;i<10;i++){
			SPR_Render(g,WORLD_L02_SPR_ID[i],WORLD_L02_SPR_ANIM_ID[i],0,WORLD_L02_SPR_X[i]+x,WORLD_L02_SPR_Y[i]+y);
		}
	}

 
	const u16	WORLD_L03_MAP_ID = MAP_M08;
	// spr dynamic
	u8			WORLD_L03_SPR_ID[13] = {SPR_DYNAMIC,SPR_DYNAMIC,SPR_DYNAMIC,SPR_DYNAMIC,SPR_DYNAMIC,SPR_DYNAMIC,SPR_DYNAMIC,SPR_DYNAMIC,SPR_DYNAMIC,SPR_DYNAMIC,SPR_DYNAMIC,SPR_DYNAMIC,SPR_DYNAMIC,};
	u8			WORLD_L03_SPR_ANIM_ID[13] = {6,0,2,3,6,4,5,3,4,2,6,5,0,};
    s16			WORLD_L03_SPR_X[13] = {60,80,40,60,80,40,60,80,100,40,60,80,100,};    
	s16			WORLD_L03_SPR_Y[13] = {40,40,60,60,60,80,80,80,80,100,100,100,100,};
	
	// map functions
	u16			WORLD_L03_GetMAP(){
		return WORLD_L03_MAP_ID;
	}

	// spr functions
	u16			WORLD_L03_GetSprCount(){
		return 13;
	}
	u16			WORLD_L03_GetSprID(u16 index){
		if(index>=13)return 0;
		return WORLD_L03_SPR_ID[index];
	}
	s16			WORLD_L03_GetSprX(u16 index){
		if(index>=13)return 0;
		return WORLD_L03_SPR_X[index];
	}
	s16			WORLD_L03_GetSprY(u16 index){
		if(index>=13)return 0;
		return WORLD_L03_SPR_Y[index];
	}
	s16			WORLD_L03_GetSprANIM(u16 index){
		if(index>=13)return -1;
		return WORLD_L03_SPR_ANIM_ID[index];
	}
	void		WORLD_L03_SetSpr(u16 index, u8 id, u8 anim, s16 x, s16 y){
		if(index>=13)return;
		WORLD_L03_SPR_ID[index] = id;
		WORLD_L03_SPR_ANIM_ID[index] = anim;
		WORLD_L03_SPR_X[index] = x;
		WORLD_L03_SPR_Y[index] = y;
	}

	s16			WORLD_L03_SelectSPR(s16 x, s16 y){
		int i;
		for(i=0;i<13;i++){
			if(CdRectPoint2(
				WORLD_L03_SPR_X[i],
				WORLD_L03_SPR_Y[i],
				MAP_GetCellW(WORLD_L03_MAP_ID),
				MAP_GetCellH(WORLD_L03_MAP_ID),
				x,y))return i;
		}
		return -1;
	}
	bool		WORLD_L03_TryMoveSpr(u16 index, s16 px, s16 py){
		int i,bx,by;
		if(index>=13)return false;
		bx = WORLD_L03_SPR_X[index]/MAP_GetCellW(WORLD_L03_MAP_ID) + (px==0?0:(px>0?1:-1));
		by = WORLD_L03_SPR_Y[index]/MAP_GetCellH(WORLD_L03_MAP_ID) + (py==0?0:(py>0?1:-1));
		if( MAP_GetTileIndex(WORLD_L03_MAP_ID,bx,by)!=0 ){
			return true;
		}
		for(i=0;i<13;i++){
			if(index==i)continue;
			if(CdRect2(
				WORLD_L03_SPR_X[index] + px,
				WORLD_L03_SPR_Y[index] + py,
				MAP_GetCellW(WORLD_L03_MAP_ID),
				MAP_GetCellH(WORLD_L03_MAP_ID),
				WORLD_L03_SPR_X[i],
				WORLD_L03_SPR_Y[i],
				MAP_GetCellW(WORLD_L03_MAP_ID),
				MAP_GetCellH(WORLD_L03_MAP_ID)
				)){
				return true;
			}
		}
		WORLD_L03_SPR_X[index] += px;
		WORLD_L03_SPR_Y[index] += py;
		return false;
	}
	bool		WORLD_L03_TryPushSpr(u16 index, s16 px, s16 py){
		int i,bx,by;
		if(index>=13)return false;
		bx = WORLD_L03_SPR_X[index]/MAP_GetCellW(WORLD_L03_MAP_ID) + (px==0?0:(px>0?1:-1));
		by = WORLD_L03_SPR_Y[index]/MAP_GetCellH(WORLD_L03_MAP_ID) + (py==0?0:(py>0?1:-1));
		if( MAP_GetTileIndex(WORLD_L03_MAP_ID,bx,by)!=0 ){
			return true;
		}
		for(i=0;i<13;i++){
			if(index==i)continue;
			if(CdRect2(
				WORLD_L03_SPR_X[index] + px,
				WORLD_L03_SPR_Y[index] + py,
				MAP_GetCellW(WORLD_L03_MAP_ID),
				MAP_GetCellH(WORLD_L03_MAP_ID),
				WORLD_L03_SPR_X[i],
				WORLD_L03_SPR_Y[i],
				MAP_GetCellW(WORLD_L03_MAP_ID),
				MAP_GetCellH(WORLD_L03_MAP_ID)
				)){
				if(WORLD_L03_TryPushSpr(i,px,py)){
					return true;
				}
			}
		}
		WORLD_L03_SPR_X[index] += px;
		WORLD_L03_SPR_Y[index] += py;
		return false;
	}

	void		WORLD_L03_Render(tGraphics *g, s16 x, s16 y){
		int i;
		MAP_Render(g,WORLD_L03_MAP_ID,x,y);
		for(i=0;i<13;i++){
			SPR_Render(g,WORLD_L03_SPR_ID[i],WORLD_L03_SPR_ANIM_ID[i],0,WORLD_L03_SPR_X[i]+x,WORLD_L03_SPR_Y[i]+y);
		}
	}

 
	const u16	WORLD_L04_MAP_ID = MAP_M03;
	// spr dynamic
	u8			WORLD_L04_SPR_ID[16] = {SPR_OBJECT,SPR_DYNAMIC,SPR_DYNAMIC,SPR_DYNAMIC,SPR_DYNAMIC,SPR_DYNAMIC,SPR_DYNAMIC,SPR_DYNAMIC,SPR_DYNAMIC,SPR_DYNAMIC,SPR_DYNAMIC,SPR_DYNAMIC,SPR_DYNAMIC,SPR_DYNAMIC,SPR_DYNAMIC,SPR_DYNAMIC,};
	u8			WORLD_L04_SPR_ANIM_ID[16] = {1,0,0,1,1,2,2,2,3,3,4,4,5,5,6,6,};
    s16			WORLD_L04_SPR_X[16] = {40,20,140,60,140,20,40,140,60,40,60,20,20,60,40,140,};    
	s16			WORLD_L04_SPR_Y[16] = {80,80,100,80,80,100,140,60,120,100,100,140,120,140,120,120,};
	
	// map functions
	u16			WORLD_L04_GetMAP(){
		return WORLD_L04_MAP_ID;
	}

	// spr functions
	u16			WORLD_L04_GetSprCount(){
		return 16;
	}
	u16			WORLD_L04_GetSprID(u16 index){
		if(index>=16)return 0;
		return WORLD_L04_SPR_ID[index];
	}
	s16			WORLD_L04_GetSprX(u16 index){
		if(index>=16)return 0;
		return WORLD_L04_SPR_X[index];
	}
	s16			WORLD_L04_GetSprY(u16 index){
		if(index>=16)return 0;
		return WORLD_L04_SPR_Y[index];
	}
	s16			WORLD_L04_GetSprANIM(u16 index){
		if(index>=16)return -1;
		return WORLD_L04_SPR_ANIM_ID[index];
	}
	void		WORLD_L04_SetSpr(u16 index, u8 id, u8 anim, s16 x, s16 y){
		if(index>=16)return;
		WORLD_L04_SPR_ID[index] = id;
		WORLD_L04_SPR_ANIM_ID[index] = anim;
		WORLD_L04_SPR_X[index] = x;
		WORLD_L04_SPR_Y[index] = y;
	}

	s16			WORLD_L04_SelectSPR(s16 x, s16 y){
		int i;
		for(i=0;i<16;i++){
			if(CdRectPoint2(
				WORLD_L04_SPR_X[i],
				WORLD_L04_SPR_Y[i],
				MAP_GetCellW(WORLD_L04_MAP_ID),
				MAP_GetCellH(WORLD_L04_MAP_ID),
				x,y))return i;
		}
		return -1;
	}
	bool		WORLD_L04_TryMoveSpr(u16 index, s16 px, s16 py){
		int i,bx,by;
		if(index>=16)return false;
		bx = WORLD_L04_SPR_X[index]/MAP_GetCellW(WORLD_L04_MAP_ID) + (px==0?0:(px>0?1:-1));
		by = WORLD_L04_SPR_Y[index]/MAP_GetCellH(WORLD_L04_MAP_ID) + (py==0?0:(py>0?1:-1));
		if( MAP_GetTileIndex(WORLD_L04_MAP_ID,bx,by)!=0 ){
			return true;
		}
		for(i=0;i<16;i++){
			if(index==i)continue;
			if(CdRect2(
				WORLD_L04_SPR_X[index] + px,
				WORLD_L04_SPR_Y[index] + py,
				MAP_GetCellW(WORLD_L04_MAP_ID),
				MAP_GetCellH(WORLD_L04_MAP_ID),
				WORLD_L04_SPR_X[i],
				WORLD_L04_SPR_Y[i],
				MAP_GetCellW(WORLD_L04_MAP_ID),
				MAP_GetCellH(WORLD_L04_MAP_ID)
				)){
				return true;
			}
		}
		WORLD_L04_SPR_X[index] += px;
		WORLD_L04_SPR_Y[index] += py;
		return false;
	}
	bool		WORLD_L04_TryPushSpr(u16 index, s16 px, s16 py){
		int i,bx,by;
		if(index>=16)return false;
		bx = WORLD_L04_SPR_X[index]/MAP_GetCellW(WORLD_L04_MAP_ID) + (px==0?0:(px>0?1:-1));
		by = WORLD_L04_SPR_Y[index]/MAP_GetCellH(WORLD_L04_MAP_ID) + (py==0?0:(py>0?1:-1));
		if( MAP_GetTileIndex(WORLD_L04_MAP_ID,bx,by)!=0 ){
			return true;
		}
		for(i=0;i<16;i++){
			if(index==i)continue;
			if(CdRect2(
				WORLD_L04_SPR_X[index] + px,
				WORLD_L04_SPR_Y[index] + py,
				MAP_GetCellW(WORLD_L04_MAP_ID),
				MAP_GetCellH(WORLD_L04_MAP_ID),
				WORLD_L04_SPR_X[i],
				WORLD_L04_SPR_Y[i],
				MAP_GetCellW(WORLD_L04_MAP_ID),
				MAP_GetCellH(WORLD_L04_MAP_ID)
				)){
				if(WORLD_L04_TryPushSpr(i,px,py)){
					return true;
				}
			}
		}
		WORLD_L04_SPR_X[index] += px;
		WORLD_L04_SPR_Y[index] += py;
		return false;
	}

	void		WORLD_L04_Render(tGraphics *g, s16 x, s16 y){
		int i;
		MAP_Render(g,WORLD_L04_MAP_ID,x,y);
		for(i=0;i<16;i++){
			SPR_Render(g,WORLD_L04_SPR_ID[i],WORLD_L04_SPR_ANIM_ID[i],0,WORLD_L04_SPR_X[i]+x,WORLD_L04_SPR_Y[i]+y);
		}
	}

 
     
//public 
enum{
	WORLD_null,
	WORLD_L01,
WORLD_L02,
WORLD_L03,
WORLD_L04,

};

// map functions
u16 WORLD_GetMAP(u16 name){
	switch(name){
	 case WORLD_L01: return WORLD_L01_GetMAP(); 
 case WORLD_L02: return WORLD_L02_GetMAP(); 
 case WORLD_L03: return WORLD_L03_GetMAP(); 
 case WORLD_L04: return WORLD_L04_GetMAP(); 

	}
	return 0;
}
// spr functions
u16 WORLD_GetSprCount(u16 name){
	switch(name){
	 case WORLD_L01: return WORLD_L01_GetSprCount(); 
 case WORLD_L02: return WORLD_L02_GetSprCount(); 
 case WORLD_L03: return WORLD_L03_GetSprCount(); 
 case WORLD_L04: return WORLD_L04_GetSprCount(); 

	}
	return 0;
}
u16 WORLD_GetSprID(u16 name, u16 index){
	switch(name){
	 case WORLD_L01: return WORLD_L01_GetSprID(index); 
 case WORLD_L02: return WORLD_L02_GetSprID(index); 
 case WORLD_L03: return WORLD_L03_GetSprID(index); 
 case WORLD_L04: return WORLD_L04_GetSprID(index); 

	}
	return 0;
}
s16 WORLD_GetSprX(u16 name, u16 index){
	switch(name){
	 case WORLD_L01: return WORLD_L01_GetSprX(index); 
 case WORLD_L02: return WORLD_L02_GetSprX(index); 
 case WORLD_L03: return WORLD_L03_GetSprX(index); 
 case WORLD_L04: return WORLD_L04_GetSprX(index); 

	}
	return 0;
}
s16 WORLD_GetSprY(u16 name, u16 index){
	switch(name){
	 case WORLD_L01: return WORLD_L01_GetSprY(index); 
 case WORLD_L02: return WORLD_L02_GetSprY(index); 
 case WORLD_L03: return WORLD_L03_GetSprY(index); 
 case WORLD_L04: return WORLD_L04_GetSprY(index); 

	}
	return 0;
}
s16 WORLD_GetSprANIM(u16 name, u16 index){
	switch(name){
	 case WORLD_L01: return WORLD_L01_GetSprANIM(index); 
 case WORLD_L02: return WORLD_L02_GetSprANIM(index); 
 case WORLD_L03: return WORLD_L03_GetSprANIM(index); 
 case WORLD_L04: return WORLD_L04_GetSprANIM(index); 

	}
	return -1;
}
void WORLD_SetSpr(u16 name, u16 index, u8 id, u8 anim, s16 x, s16 y){
	switch(name){
	 case WORLD_L01: WORLD_L01_SetSpr(index,id,anim,x,y); break; 
 case WORLD_L02: WORLD_L02_SetSpr(index,id,anim,x,y); break; 
 case WORLD_L03: WORLD_L03_SetSpr(index,id,anim,x,y); break; 
 case WORLD_L04: WORLD_L04_SetSpr(index,id,anim,x,y); break; 

	}
}
bool WORLD_TryMoveSpr(u16 name, u16 index, s16 px, s16 py){
	switch(name){
	 case WORLD_L01: return WORLD_L01_TryMoveSpr(index,px,py); 
 case WORLD_L02: return WORLD_L02_TryMoveSpr(index,px,py); 
 case WORLD_L03: return WORLD_L03_TryMoveSpr(index,px,py); 
 case WORLD_L04: return WORLD_L04_TryMoveSpr(index,px,py); 

	}
	return false;
}
bool WORLD_TryPushSpr(u16 name, u16 index, s16 px, s16 py){
	switch(name){
	 case WORLD_L01: return WORLD_L01_TryPushSpr(index,px,py); 
 case WORLD_L02: return WORLD_L02_TryPushSpr(index,px,py); 
 case WORLD_L03: return WORLD_L03_TryPushSpr(index,px,py); 
 case WORLD_L04: return WORLD_L04_TryPushSpr(index,px,py); 

	}
	return false;
}
s16 WORLD_SelectSPR(u16 name,s16 x,s16 y){
	switch(name){
	 case WORLD_L01: return WORLD_L01_SelectSPR(x,y); 
 case WORLD_L02: return WORLD_L02_SelectSPR(x,y); 
 case WORLD_L03: return WORLD_L03_SelectSPR(x,y); 
 case WORLD_L04: return WORLD_L04_SelectSPR(x,y); 

	}
	return -1;
}

void WORLD_Render(tGraphics *g, u16 name, s16 x, s16 y){
	switch(name){
	 case WORLD_L01: WORLD_L01_Render(g,x,y); break; 
 case WORLD_L02: WORLD_L02_Render(g,x,y); break; 
 case WORLD_L03: WORLD_L03_Render(g,x,y); break; 
 case WORLD_L04: WORLD_L04_Render(g,x,y); break; 

	}
}

 

/* Ends C function definitions when using C++ */
#ifdef __cplusplus
}
#endif

#endif/*#ifndef RESES_SCRIPT_H_*/


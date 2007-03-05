/* Encoding : 简体中文(GB2312) */
/* Cell Game Editor by WAZA Zhang */
/* Email : wazazhang@gmail.com */

//
// MTK Script v0.0.0
// Editor Auto Generated Code
// 编辑器自动产生的代码
// 
// 指定文件输出
// <OUTPUT>    .\[out]\MenuScript.h
// 
#ifndef MENU_SCRIPT_H_
#define MENU_SCRIPT_H_

#include "MTK.h"

/* Set up for C function definitions, even when using C++ */
#ifdef __cplusplus
extern "C" {
#endif

/**************************************************************************************************/
/* level                                                                                            */
/**************************************************************************************************/

 

//public 
enum{
	WORLD_null,
	WORLD_L01,
WORLD_L02,
WORLD_L03,
WORLD_L04,

};

// map functions
char* WORLD_GetWorldText(u16 name){
	switch(name){
	 case WORLD_L01: return "WORLD_L01"; 
 case WORLD_L02: return "WORLD_L02"; 
 case WORLD_L03: return "WORLD_L03"; 
 case WORLD_L04: return "WORLD_L04"; 

	}
	return NULL;
}

 

/* Ends C function definitions when using C++ */
#ifdef __cplusplus
}
#endif

#endif/*#ifndef MENU_SCRIPT_H_*/


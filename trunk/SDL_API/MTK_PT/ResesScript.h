/* Encoding : 简体中文(GB2312) */
/* Cell Game Editor by WAZA Zhang */
/* Email : wazazhang@gmail.com */

//
// MTK Script v0.0.0
// 
// 指定文件输出
// <OUTPUT>    .\[out]\ResesScript.h
// 
#ifndef RESES_SCRIPT_H_
#define RESES_SCRIPT_H_

// map data output 
enum 
{
	Map
};
const u8 MapData_Map[11][9] = 
{
	{0,1,1,1,1,1,1,1,2,},
	{3,4,4,5,4,6,4,4,3,},
	{3,4,4,1,4,1,4,4,3,},
	{3,4,4,4,4,4,4,4,3,},
	{3,4,4,4,4,4,4,4,3,},
	{3,4,4,4,4,4,4,4,3,},
	{3,4,7,5,4,6,7,4,3,},
	{3,8,1,1,9,1,1,4,3,},
	{3,4,4,4,4,4,4,4,3,},
	{3,4,4,10,4,10,4,4,3,},
	{11,12,1,1,1,1,1,12,13,},
};
// 
void InitMap(u16 index, u8* data[], u16 *w, u16 *h)
{
	switch(index)
	{
	case Map:
		*w = 9;
		*h = 11;
		data = MapData_Map;
		break;
	}
}

#endif/*#ifndef RESES_SCRIPT_H_*/


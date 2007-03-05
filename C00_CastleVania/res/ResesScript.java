/* Encoding : 简体中文(GB2312) */
/* Cell Game Editor by WAZA Zhang */
/* Email : wazazhang@gmail.com */

//
// CastleVania Script v0.0.0
// 
// 指定文件输出
// <OUTPUT>     ..\..\res\ResesScript.java
// 
import com.cell.*;
import com.cell.game.*;

import cv.LevelManager;

public class ResesScript {

//--------------------------------------------------------------------------------------------------------------
// resource trunk
//--------------------------------------------------------------------------------------------------------------


	//--------------------------------------------------------------------------------------------------------------
	 
	// Images : Actor00 
	final static public IImages createClipImages_Actor00(){
		IImages stuff = new CImages20();
		stuff.buildImages(CIO.loadImage("/Actor00.png"),136);
		
		 stuff.addTile(0,0,40,40);//0 
		 stuff.addTile(40,0,40,40);//1 
		 stuff.addTile(80,0,40,40);//2 
		 stuff.addTile(120,0,40,40);//3 
		 stuff.addTile(160,0,40,40);//4 
		 stuff.addTile(200,0,40,40);//5 
		 stuff.addTile(240,0,40,40);//6 
		 stuff.addTile(280,0,40,40);//7 
		 stuff.addTile(0,40,40,40);//8 
		 stuff.addTile(40,40,40,40);//9 
		 stuff.addTile(80,40,40,40);//10 
		 stuff.addTile(120,40,40,40);//11 
		 stuff.addTile(160,40,40,40);//12 
		 stuff.addTile(200,40,40,40);//13 
		 stuff.addTile(240,40,40,40);//14 
		 stuff.addTile(280,40,40,40);//15 
		 stuff.addTile(0,80,40,40);//16 
		 stuff.addTile(200,120,40,40);//17 
		 stuff.addTile(0,120,40,40);//18 
		 stuff.addTile(40,80,40,40);//19 
		 stuff.addTile(120,80,40,40);//20 
		 stuff.addTile(80,120,40,40);//21 
		 stuff.addTile(270,80,40,40);//22 
		 stuff.addTile(230,80,40,40);//23 
		 stuff.addTile(160,120,40,40);//24 
		 stuff.addTile(240,120,40,40);//25 
		 stuff.addTile(40,120,40,40);//26 
		 stuff.addTile(120,120,40,40);//27 
		 stuff.addTile(80,80,40,40);//28 
		 stuff.addTile(312,80,40,40);//29 
		 stuff.addTile(160,80,40,40);//30 
		 stuff.addTile(280,160,40,40);//31 
		 stuff.addTile(200,80,30,40);//32 
		 stuff.addTile(0,160,40,40);//33 
		 stuff.addTile(40,160,80,40);//34 
		 stuff.addTile(120,160,80,40);//35 
		 stuff.addTile(200,160,80,40);//36 
		 stuff.addTile(0,200,40,40);//37 
		 stuff.addTile(40,200,40,40);//38 
		 stuff.addTile(80,200,40,40);//39 
		 stuff.addTile(120,200,40,40);//40 
		 stuff.addTile(160,200,32,40);//41 
		 stuff.addTile(192,200,40,40);//42 
		 stuff.addTile(232,200,40,40);//43 
		 stuff.addTile(272,200,40,40);//44 
		 stuff.addTile(0,239,40,40);//45 
		 stuff.addTile(40,239,40,40);//46 
		 stuff.addTile(80,239,40,40);//47 
		 stuff.addTile(120,239,40,40);//48 
		 stuff.addTile(160,239,40,40);//49 
		 stuff.addTile(200,240,60,40);//50 
		 stuff.addTile(260,240,60,40);//51 
		 stuff.addTile(0,279,40,40);//52 
		 stuff.addTile(40,279,40,40);//53 
		 stuff.addTile(80,279,40,40);//54 
		 stuff.addTile(120,279,40,40);//55 
		 stuff.addTile(160,279,40,40);//56 
		 stuff.addTile(200,280,40,40);//57 
		 stuff.addTile(240,280,40,40);//58 
		 stuff.addTile(280,280,40,40);//59 
		 stuff.addTile(0,319,36,40);//60 
		 stuff.addTile(36,320,36,40);//61 
		 stuff.addTile(72,319,40,40);//62 
		 stuff.addTile(112,319,40,40);//63 
		 stuff.addTile(152,319,40,40);//64 
		 stuff.addTile(192,320,40,40);//65 
		 stuff.addTile(247,320,40,60);//66 
		 stuff.addTile(287,320,40,60);//67 
		 stuff.addTile(0,359,35,40);//68 
		 stuff.addTile(35,360,35,40);//69 
		 stuff.addTile(72,359,35,40);//70 
		 stuff.addTile(107,359,35,40);//71 
		 stuff.addTile(142,360,35,40);//72 
		 stuff.addTile(177,360,35,40);//73 
		 stuff.addTile(212,360,35,40);//74 
		 stuff.addTile(0,399,40,40);//75 
		 stuff.addTile(40,399,40,40);//76 
		 stuff.addTile(80,399,40,40);//77 
		 stuff.addTile(120,399,40,40);//78 
		 stuff.addTile(160,399,40,40);//79 
		 stuff.addTile(200,399,40,40);//80 
		 stuff.addTile(240,399,40,40);//81 
		 stuff.addTile(280,399,40,40);//82 
		 stuff.addTile(0,439,40,40);//83 
		 stuff.addTile(40,439,40,40);//84 
		 stuff.addTile(80,439,40,40);//85 
		 stuff.addTile(120,439,40,40);//86 
		 stuff.addTile(160,439,40,40);//87 
		 stuff.addTile(200,439,40,40);//88 
		 stuff.addTile(240,439,40,40);//89 
		 stuff.addTile(280,439,40,40);//90 
		 stuff.addTile(0,479,40,40);//91 
		 stuff.addTile(40,479,40,40);//92 
		 stuff.addTile(80,479,40,40);//93 
		 stuff.addTile(120,479,40,40);//94 
		 stuff.addTile(160,479,40,40);//95 
		 stuff.addTile(200,479,40,40);//96 
		 stuff.addTile(240,479,40,40);//97 
		 stuff.addTile(280,479,40,40);//98 
		 stuff.addTile(0,519,40,40);//99 
		 stuff.addTile(40,519,40,40);//100 
		 stuff.addTile(80,519,40,40);//101 
		 stuff.addTile(120,519,40,40);//102 
		 stuff.addTile(160,519,40,40);//103 
		 stuff.addTile(200,519,40,40);//104 
		 stuff.addTile(240,519,40,40);//105 
		 stuff.addTile(280,519,40,40);//106 
		 stuff.addTile(0,559,40,40);//107 
		 stuff.addTile(40,559,40,40);//108 
		 stuff.addTile(80,559,40,40);//109 
		 stuff.addTile(120,559,40,40);//110 
		 stuff.addTile(160,559,40,40);//111 
		 stuff.addTile(200,559,40,42);//112 
		 stuff.addTile(240,559,40,42);//113 
		 stuff.addTile(0,599,40,40);//114 
		 stuff.addTile(40,599,40,40);//115 
		 stuff.addTile(80,599,40,40);//116 
		 stuff.addTile(120,599,40,40);//117 
		 stuff.addTile(160,599,40,40);//118 
		 stuff.addTile(200,601,40,40);//119 
		 stuff.addTile(240,601,40,40);//120 
		 stuff.addTile(280,600,40,40);//121 
		 stuff.addTile(0,639,40,40);//122 
		 stuff.addTile(40,639,40,40);//123 
		 stuff.addTile(80,639,40,40);//124 
		 stuff.addTile(120,639,40,40);//125 
		 stuff.addTile(160,639,40,40);//126 
		 stuff.addTile(200,641,40,40);//127 
		 stuff.addTile(240,641,40,40);//128 
		 stuff.addTile(280,640,40,40);//129 
		 stuff.addTile(0,679,40,30);//130 
		 stuff.addTile(40,679,40,30);//131 
		 stuff.addTile(80,679,40,30);//132 
		 stuff.addTile(120,679,40,30);//133 
		 stuff.addTile(160,679,40,30);//134 
		 stuff.addTile(0,709,64,64);//135 
		
		
		return stuff;
	}
	
 
	// Images : MapTile00 
	final static public IImages createClipImages_MapTile00(){
		IImages stuff = new CImages20();
		stuff.buildImages(CIO.loadImage("/MapTile00.png"),33);
		
		 stuff.addTile(0,0,16,16);//0 
		 stuff.addTile(16,0,16,16);//1 
		 stuff.addTile(32,0,16,16);//2 
		 stuff.addTile(48,0,16,16);//3 
		 stuff.addTile(0,16,16,16);//4 
		 stuff.addTile(16,16,16,16);//5 
		 stuff.addTile(32,16,16,16);//6 
		 stuff.addTile(48,16,16,16);//7 
		 stuff.addTile(0,32,16,16);//8 
		 stuff.addTile(16,32,16,16);//9 
		 stuff.addTile(32,32,16,16);//10 
		 stuff.addTile(48,32,16,16);//11 
		 stuff.addTile(0,48,16,16);//12 
		 stuff.addTile(16,48,16,16);//13 
		 stuff.addTile(32,48,16,16);//14 
		 stuff.addTile(64,0,16,16);//15 
		 stuff.addTile(64,64,16,16);//16 
		 stuff.addTile(64,48,16,16);//17 
		 stuff.addTile(0,64,16,16);//18 
		 stuff.addTile(16,64,16,16);//19 
		 stuff.addTile(32,64,16,16);//20 
		 stuff.addTile(64,16,16,16);//21 
		 stuff.addTile(48,64,16,16);//22 
		 stuff.addTile(64,32,16,16);//23 
		 stuff.addTile(0,80,16,16);//24 
		 stuff.addTile(0,96,16,16);//25 
		 stuff.addTile(16,80,16,16);//26 
		 stuff.addTile(16,96,16,16);//27 
		 stuff.addTile(32,80,16,16);//28 
		 stuff.addTile(32,96,16,16);//29 
		 stuff.addTile(48,80,16,16);//30 
		 stuff.addTile(48,96,16,16);//31 
		 stuff.addTile(48,48,16,16);//32 
		
		
		return stuff;
	}
	
 
	// Images : E00_Zombi 
	final static public IImages createClipImages_E00_Zombi(){
		IImages stuff = new CImages20();
		stuff.buildImages(CIO.loadImage("/E00_Zombi.png"),11);
		
		 stuff.addTile(0,0,16,2);//0 
		 stuff.addTile(0,2,16,2);//1 
		 stuff.addTile(0,4,18,8);//2 
		 stuff.addTile(0,12,20,10);//3 
		 stuff.addTile(0,22,20,16);//4 
		 stuff.addTile(0,38,19,19);//5 
		 stuff.addTile(0,57,22,26);//6 
		 stuff.addTile(0,83,21,36);//7 
		 stuff.addTile(0,119,20,34);//8 
		 stuff.addTile(0,153,21,33);//9 
		 stuff.addTile(0,186,20,34);//10 
		
		
		return stuff;
	}
	
 
	// Images : Event 
	final static public IImages createClipImages_Event(){
		IImages stuff = new CImages20();
		stuff.buildImages(CIO.loadImage("/Event.png"),1);
		
		 stuff.addTile(0,0,16,32);//0 
		
		
		return stuff;
	}
	


	//--------------------------------------------------------------------------------------------------------------
	
	// Map : Level_00 //MapTile00
	final static public CMap createMap_Level_00(IImages tiles,boolean isAnimate,boolean isCyc){
		
		//40 x 20
		
		// tiles
	    CAnimates animates = new CAnimates(24,tiles);
	     animates.addPart(0,0,14,0);//0
		 animates.addPart(0,0,20,0);//1
		 animates.addPart(0,0,32,5);//2
		 animates.addPart(0,0,1,0);//3
		 animates.addPart(0,0,0,0);//4
		 animates.addPart(0,0,12,0);//5
		 animates.addPart(0,0,19,0);//6
		 animates.addPart(0,0,32,3);//7
		 animates.addPart(0,0,13,0);//8
		 animates.addPart(0,0,5,0);//9
		 animates.addPart(0,0,18,0);//10
		 animates.addPart(0,0,2,0);//11
		 animates.addPart(0,0,6,0);//12
		 animates.addPart(0,0,7,0);//13
		 animates.addPart(0,0,0,2);//14
		 animates.addPart(0,0,32,2);//15
		 animates.addPart(0,0,26,0);//16
		 animates.addPart(0,0,28,0);//17
		 animates.addPart(0,0,30,0);//18
		 animates.addPart(0,0,24,0);//19
		 animates.addPart(0,0,27,0);//20
		 animates.addPart(0,0,29,0);//21
		 animates.addPart(0,0,31,0);//22
		 animates.addPart(0,0,25,0);//23
		
		
	    animates.setFrames(new int[24][]);
	     animates.setComboFrame(new int[]{0,},0);//0
		 animates.setComboFrame(new int[]{1,},1);//1
		 animates.setComboFrame(new int[]{2,},2);//2
		 animates.setComboFrame(new int[]{3,},3);//3
		 animates.setComboFrame(new int[]{4,},4);//4
		 animates.setComboFrame(new int[]{5,},5);//5
		 animates.setComboFrame(new int[]{6,},6);//6
		 animates.setComboFrame(new int[]{7,},7);//7
		 animates.setComboFrame(new int[]{8,},8);//8
		 animates.setComboFrame(new int[]{9,},9);//9
		 animates.setComboFrame(new int[]{10,},10);//10
		 animates.setComboFrame(new int[]{11,},11);//11
		 animates.setComboFrame(new int[]{12,},12);//12
		 animates.setComboFrame(new int[]{13,},13);//13
		 animates.setComboFrame(new int[]{14,},14);//14
		 animates.setComboFrame(new int[]{15,},15);//15
		 animates.setComboFrame(new int[]{16,17,18,19,},16);//16
		 animates.setComboFrame(new int[]{17,18,19,16,},17);//17
		 animates.setComboFrame(new int[]{18,19,16,17,},18);//18
		 animates.setComboFrame(new int[]{19,16,17,18,},19);//19
		 animates.setComboFrame(new int[]{20,21,22,23,},20);//20
		 animates.setComboFrame(new int[]{21,22,23,20,},21);//21
		 animates.setComboFrame(new int[]{22,23,20,21,},22);//22
		 animates.setComboFrame(new int[]{23,20,21,22,},23);//23
		
		
		short[][] tileMatrix = new short[][]{
			{0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,},
{0,2,3,3,3,3,3,3,3,4,3,4,3,3,4,4,3,3,4,5,0,6,3,4,3,4,4,3,3,3,3,3,3,3,3,3,3,3,7,0,},
{8,3,9,3,3,3,3,3,3,3,3,3,3,3,3,3,4,3,3,5,0,6,3,3,4,3,3,3,3,9,3,3,9,9,3,3,4,4,3,5,},
{8,3,9,3,3,3,9,3,3,3,3,9,3,3,9,9,9,3,3,5,0,6,4,3,3,4,4,9,3,3,3,9,3,3,4,3,3,4,3,5,},
{8,3,9,4,3,-16,3,3,-17,4,3,-18,3,4,-19,3,3,3,4,5,0,6,3,-17,4,9,-18,9,3,3,5,0,0,8,3,3,3,10,0,0,},
{1,1,6,3,3,-20,3,3,-21,4,4,-22,3,3,-23,3,4,3,3,5,0,6,3,-21,9,3,-22,3,9,3,3,10,6,3,3,3,3,3,3,5,},
{8,3,3,3,3,4,3,3,3,4,3,4,3,4,4,3,3,3,4,5,0,6,3,4,3,3,9,3,4,3,3,10,6,4,3,9,4,3,4,5,},
{8,4,9,9,3,3,3,3,3,3,3,3,3,4,3,4,3,3,3,5,0,6,3,3,4,3,4,3,4,3,3,10,6,4,3,3,3,4,3,5,},
{8,3,3,3,3,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8,3,3,9,10,0,0,0,0,8,4,3,5,},
{8,3,3,3,3,3,4,3,3,3,3,3,3,4,3,3,3,3,3,5,0,6,3,4,3,3,3,4,3,3,3,10,6,3,3,3,3,3,3,5,},
{8,4,3,3,3,3,3,3,9,3,3,3,3,4,4,3,3,4,3,5,0,6,3,4,4,3,3,3,3,4,3,10,6,3,3,3,9,3,3,5,},
{8,3,3,12,13,3,3,3,3,12,13,4,3,3,3,12,13,3,3,5,0,6,3,3,4,9,4,3,12,13,3,10,6,3,9,4,3,3,3,5,},
{8,3,4,3,3,3,3,3,4,4,3,4,9,9,4,3,4,3,3,5,0,6,4,3,4,4,3,3,4,9,3,10,6,3,4,10,0,0,0,0,},
{8,3,3,4,4,3,9,9,3,3,4,3,3,3,3,3,3,3,3,5,0,6,3,3,3,3,3,4,3,3,4,10,6,3,4,3,3,3,4,5,},
{8,4,4,3,4,3,9,3,3,3,3,3,9,4,3,3,3,9,3,5,0,6,3,3,3,3,9,3,3,3,3,10,6,3,4,4,9,9,3,5,},
{3,3,4,12,13,3,9,3,3,12,13,3,3,9,3,12,13,4,3,5,0,6,3,4,4,10,0,0,0,0,0,0,6,12,13,4,3,4,4,5,},
{4,3,3,3,3,3,3,4,3,3,3,3,4,9,3,4,4,3,3,4,4,4,3,3,9,3,3,3,3,4,3,10,6,4,3,3,3,4,3,4,},
{4,3,3,3,3,3,3,3,4,3,3,9,9,3,3,4,3,4,3,3,3,3,3,3,3,3,4,4,3,4,3,10,6,3,3,3,9,4,3,3,},
{0,0,0,0,0,0,0,8,3,4,4,3,3,3,3,3,3,4,3,3,3,4,4,4,4,4,4,4,4,14,15,0,6,3,4,4,3,3,4,3,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},

		};
		
		// cds
		CCollides collides = new CCollides(8);
	    
	    if("rect"=="rect") collides.addCDRect(0, 0, 0, 16 , 16 );//rect//0
		if("rect"=="line") collides.addCDLine(0, 0, 0, 16, 16);//rect//0
		
	    if("rect"=="rect") collides.addCDRect(1, 0, 0, 16 , 16 );//rect//1
		if("rect"=="line") collides.addCDLine(1, 0, 0, 16, 16);//rect//1
		
	    if("rect"=="rect") collides.addCDRect(2, 0, 0, 16 , 1 );//rect//2
		if("rect"=="line") collides.addCDLine(2, 0, 0, 16, 16);//rect//2
		
	    if("rect"=="rect") collides.addCDRect(4, 0, 15, 16 , 1 );//rect//3
		if("rect"=="line") collides.addCDLine(4, 0, 15, 16, 16);//rect//3
		
	    if("rect"=="rect") collides.addCDRect(8, 0, 0, 1 , 16 );//rect//4
		if("rect"=="line") collides.addCDLine(8, 0, 0, 16, 16);//rect//4
		
	    if("rect"=="rect") collides.addCDRect(16, 15, 0, 1 , 16 );//rect//5
		if("rect"=="line") collides.addCDLine(16, 15, 0, 16, 16);//rect//5
		
	    if("line"=="rect") collides.addCDRect(32, 0, 0, 16 , 16 );//line//6
		if("line"=="line") collides.addCDLine(32, 0, 0, 15, 15);//line//6
		
	    if("line"=="rect") collides.addCDRect(64, 15, 0, 16 , 16 );//line//7
		if("line"=="line") collides.addCDLine(64, 15, 0, 0, 15);//line//7
		

		short[][] flagMatrix = new short[][]{
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,},
{1,7,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,6,1,},
{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,},
{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,},
{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,1,1,1,1,0,0,0,1,1,1,},
{1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,1,},
{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,1,},
{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,1,},
{1,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1,1,1,0,0,1,},
{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,1,},
{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,1,},
{1,0,0,2,2,0,0,0,0,2,2,0,0,0,0,2,2,0,0,1,1,1,0,0,0,0,0,0,2,2,0,1,1,0,0,0,0,0,0,1,},
{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,1,1,0,0,1,1,1,1,1,},
{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,1,},
{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,1,},
{0,0,0,2,2,0,0,0,0,2,2,0,0,0,0,2,2,0,0,1,1,1,0,0,0,1,1,1,1,1,1,1,1,2,2,0,0,0,0,1,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,},
{1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,7,1,1,0,0,0,0,0,0,0,},
{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,},

		};
		
	    CMap ret = new CMap(
	            animates, 
	            collides, 
	            16, 16, 
	            tileMatrix, 
	            flagMatrix, 
	            isAnimate,isCyc 
	            );
	
	    return ret;
	}
	

	// Map : Level_01 //MapTile00
	final static public CMap createMap_Level_01(IImages tiles,boolean isAnimate,boolean isCyc){
		
		//40 x 20
		
		// tiles
	    CAnimates animates = new CAnimates(17,tiles);
	     animates.addPart(0,0,14,2);//0
		 animates.addPart(0,0,13,0);//1
		 animates.addPart(0,0,0,2);//2
		 animates.addPart(0,0,12,0);//3
		 animates.addPart(0,0,14,0);//4
		 animates.addPart(0,0,0,0);//5
		 animates.addPart(0,0,4,0);//6
		 animates.addPart(0,0,1,0);//7
		 animates.addPart(0,0,5,0);//8
		 animates.addPart(0,0,6,0);//9
		 animates.addPart(0,0,7,0);//10
		 animates.addPart(0,0,32,0);//11
		 animates.addPart(0,0,32,2);//12
		 animates.addPart(0,0,32,4);//13
		 animates.addPart(0,0,5,2);//14
		 animates.addPart(0,0,4,2);//15
		 animates.addPart(0,0,18,0);//16
		
		
	    animates.setFrames(new int[17][]);
	     animates.setComboFrame(new int[]{0,},0);//0
		 animates.setComboFrame(new int[]{1,},1);//1
		 animates.setComboFrame(new int[]{2,},2);//2
		 animates.setComboFrame(new int[]{3,},3);//3
		 animates.setComboFrame(new int[]{4,},4);//4
		 animates.setComboFrame(new int[]{5,},5);//5
		 animates.setComboFrame(new int[]{6,},6);//6
		 animates.setComboFrame(new int[]{7,},7);//7
		 animates.setComboFrame(new int[]{8,},8);//8
		 animates.setComboFrame(new int[]{9,},9);//9
		 animates.setComboFrame(new int[]{10,},10);//10
		 animates.setComboFrame(new int[]{11,},11);//11
		 animates.setComboFrame(new int[]{12,},12);//12
		 animates.setComboFrame(new int[]{13,},13);//13
		 animates.setComboFrame(new int[]{14,},14);//14
		 animates.setComboFrame(new int[]{15,},15);//15
		 animates.setComboFrame(new int[]{16,},16);//16
		
		
		short[][] tileMatrix = new short[][]{
			{0,0,1,2,2,2,3,0,0,0,0,0,0,0,0,0,0,0,0,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,},
{1,5,5,6,5,7,7,5,5,6,5,8,5,5,5,7,7,6,8,3,1,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,4,},
{1,5,5,9,10,6,5,5,5,8,8,7,5,8,6,6,5,5,5,3,1,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,4,},
{1,5,6,5,5,8,5,6,7,5,5,7,6,5,8,5,5,5,5,3,1,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,8,4,},
{1,6,5,5,7,7,8,8,5,5,6,5,6,6,6,5,6,6,6,3,1,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,8,8,4,},
{4,11,7,5,5,7,5,6,5,6,8,5,5,5,6,5,5,6,5,3,4,4,4,4,11,5,5,5,5,5,5,5,5,5,5,5,12,0,8,4,},
{4,4,4,4,4,4,4,1,5,5,6,6,3,4,4,4,4,4,4,4,4,4,4,4,4,11,5,5,5,5,5,5,5,5,5,12,0,8,8,4,},
{1,5,6,8,7,8,7,6,8,7,8,8,8,8,8,6,5,8,13,4,4,4,4,4,4,4,11,5,5,5,5,5,5,5,7,0,0,8,8,4,},
{1,6,8,7,6,8,6,5,6,8,7,8,8,8,5,5,8,5,8,3,4,4,4,4,4,4,4,11,5,5,5,5,5,5,5,5,4,5,4,4,},
{1,5,6,5,7,5,7,6,8,7,5,6,5,8,5,6,6,8,7,3,1,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,4,5,7,4,},
{1,8,7,7,8,6,6,8,3,4,4,4,0,0,0,0,0,0,0,4,1,5,5,5,5,5,8,8,5,5,5,5,12,11,5,5,4,5,5,4,},
{1,8,5,7,8,8,5,8,5,5,5,6,8,8,5,5,5,5,5,3,1,5,5,5,5,5,5,5,5,5,5,12,4,4,11,5,4,4,5,4,},
{1,8,6,5,8,8,5,6,5,5,5,8,6,7,5,5,5,6,5,3,1,5,5,5,5,5,5,5,5,5,12,4,4,4,4,11,4,7,5,4,},
{1,8,12,11,6,5,5,8,5,8,5,7,8,8,8,5,8,5,12,4,1,5,5,5,5,5,5,5,5,12,4,4,4,4,4,4,4,7,5,4,},
{4,4,4,4,4,4,4,1,5,8,8,8,3,4,4,4,4,4,4,4,1,5,5,5,5,14,12,0,0,0,4,0,0,4,4,0,0,8,4,4,},
{1,6,8,6,7,7,7,5,5,6,5,5,7,5,6,5,5,5,5,3,1,5,5,5,5,12,0,0,0,0,0,0,0,0,0,0,0,8,7,7,},
{15,5,7,8,6,5,5,5,8,6,5,5,5,5,5,5,8,7,5,15,5,5,5,5,12,0,0,0,0,0,0,0,0,0,0,0,0,8,8,7,},
{8,5,5,5,6,5,5,5,12,4,4,11,5,5,6,5,6,5,8,8,5,5,5,12,0,0,0,0,0,0,0,0,0,0,0,0,0,8,8,7,},
{8,6,5,5,5,8,12,4,4,4,4,4,4,1,8,8,5,5,5,6,5,5,16,0,0,0,0,0,0,0,0,0,0,0,0,0,0,4,4,4,},
{4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,},

		};
		
		// cds
		CCollides collides = new CCollides(8);
	    
	    if("rect"=="rect") collides.addCDRect(0, 0, 0, 16 , 16 );//rect//0
		if("rect"=="line") collides.addCDLine(0, 0, 0, 16, 16);//rect//0
		
	    if("rect"=="rect") collides.addCDRect(1, 0, 0, 16 , 16 );//rect//1
		if("rect"=="line") collides.addCDLine(1, 0, 0, 16, 16);//rect//1
		
	    if("rect"=="rect") collides.addCDRect(2, 0, 0, 16 , 1 );//rect//2
		if("rect"=="line") collides.addCDLine(2, 0, 0, 16, 16);//rect//2
		
	    if("rect"=="rect") collides.addCDRect(4, 0, 15, 16 , 1 );//rect//3
		if("rect"=="line") collides.addCDLine(4, 0, 15, 16, 16);//rect//3
		
	    if("rect"=="rect") collides.addCDRect(8, 0, 0, 1 , 16 );//rect//4
		if("rect"=="line") collides.addCDLine(8, 0, 0, 16, 16);//rect//4
		
	    if("rect"=="rect") collides.addCDRect(16, 15, 0, 1 , 16 );//rect//5
		if("rect"=="line") collides.addCDLine(16, 15, 0, 16, 16);//rect//5
		
	    if("line"=="rect") collides.addCDRect(32, 0, 0, 16 , 16 );//line//6
		if("line"=="line") collides.addCDLine(32, 0, 0, 15, 15);//line//6
		
	    if("line"=="rect") collides.addCDRect(64, 15, 0, 16 , 16 );//line//7
		if("line"=="line") collides.addCDLine(64, 15, 0, 0, 15);//line//7
		

		short[][] flagMatrix = new short[][]{
			{1,1,1,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,},
{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,},
{1,0,0,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,},
{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,},
{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,},
{1,6,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,6,0,0,0,0,0,0,0,0,0,0,0,7,1,0,1,},
{1,1,1,1,1,1,1,1,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,6,0,0,0,0,0,0,0,0,0,7,1,0,0,1,},
{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,6,1,1,1,1,1,1,1,6,0,0,0,0,0,0,0,0,1,1,0,0,1,},
{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,6,0,0,0,0,0,0,0,0,1,0,1,1,},
{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,},
{1,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,7,6,0,0,1,0,0,1,},
{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,7,1,1,6,0,1,1,0,1,},
{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,7,1,1,1,1,6,1,0,0,1,},
{1,0,7,6,0,0,0,0,0,0,0,0,0,0,0,0,0,0,7,1,1,0,0,0,0,0,0,0,0,7,1,1,1,1,1,1,1,0,0,1,},
{1,1,1,1,1,1,1,1,0,0,0,0,1,1,1,1,1,1,1,1,1,0,0,0,0,0,7,1,1,1,1,1,1,1,1,1,1,0,1,1,},
{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,7,1,1,1,1,1,1,1,1,1,1,1,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,7,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,},
{0,0,0,0,0,0,0,0,7,1,1,6,0,0,0,0,0,0,0,0,0,0,0,7,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,},
{0,0,0,0,0,0,7,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,},
{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,},

		};
		
	    CMap ret = new CMap(
	            animates, 
	            collides, 
	            16, 16, 
	            tileMatrix, 
	            flagMatrix, 
	            isAnimate,isCyc 
	            );
	
	    return ret;
	}
	

	// Map : Entry //MapTile00
	final static public CMap createMap_Entry(IImages tiles,boolean isAnimate,boolean isCyc){
		
		//20 x 20
		
		// tiles
	    CAnimates animates = new CAnimates(4,tiles);
	     animates.addPart(0,0,14,0);//0
		 animates.addPart(0,0,0,0);//1
		 animates.addPart(0,0,20,0);//2
		 animates.addPart(0,0,5,0);//3
		
		
	    animates.setFrames(new int[4][]);
	     animates.setComboFrame(new int[]{0,},0);//0
		 animates.setComboFrame(new int[]{1,},1);//1
		 animates.setComboFrame(new int[]{2,},2);//2
		 animates.setComboFrame(new int[]{3,},3);//3
		
		
		short[][] tileMatrix = new short[][]{
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,},
{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,},
{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,},
{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,},
{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,},
{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,},
{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,},
{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,},
{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,},
{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,},
{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,},
{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,},
{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,},
{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,},
{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3,3,},
{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,},
{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,},
{0,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},

		};
		
		// cds
		CCollides collides = new CCollides(8);
	    
	    if("rect"=="rect") collides.addCDRect(0, 0, 0, 16 , 16 );//rect//0
		if("rect"=="line") collides.addCDLine(0, 0, 0, 16, 16);//rect//0
		
	    if("rect"=="rect") collides.addCDRect(1, 0, 0, 16 , 16 );//rect//1
		if("rect"=="line") collides.addCDLine(1, 0, 0, 16, 16);//rect//1
		
	    if("rect"=="rect") collides.addCDRect(2, 0, 0, 16 , 1 );//rect//2
		if("rect"=="line") collides.addCDLine(2, 0, 0, 16, 16);//rect//2
		
	    if("rect"=="rect") collides.addCDRect(4, 0, 15, 16 , 1 );//rect//3
		if("rect"=="line") collides.addCDLine(4, 0, 15, 16, 16);//rect//3
		
	    if("rect"=="rect") collides.addCDRect(8, 0, 0, 1 , 16 );//rect//4
		if("rect"=="line") collides.addCDLine(8, 0, 0, 16, 16);//rect//4
		
	    if("rect"=="rect") collides.addCDRect(16, 15, 0, 1 , 16 );//rect//5
		if("rect"=="line") collides.addCDLine(16, 15, 0, 16, 16);//rect//5
		
	    if("line"=="rect") collides.addCDRect(32, 0, 0, 16 , 16 );//line//6
		if("line"=="line") collides.addCDLine(32, 0, 0, 15, 15);//line//6
		
	    if("line"=="rect") collides.addCDRect(64, 15, 0, 16 , 16 );//line//7
		if("line"=="line") collides.addCDLine(64, 15, 0, 0, 15);//line//7
		

		short[][] flagMatrix = new short[][]{
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,},
{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,},
{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,},
{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,},
{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,},
{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,},
{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,},
{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,},
{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,},
{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,},
{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,},
{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,},
{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,},
{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,},
{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,},
{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{1,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,},
{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,},

		};
		
	    CMap ret = new CMap(
	            animates, 
	            collides, 
	            16, 16, 
	            tileMatrix, 
	            flagMatrix, 
	            isAnimate,isCyc 
	            );
	
	    return ret;
	}
	

	
	//--------------------------------------------------------------------------------------------------------------
	
	// Sprite : Actor00 //Actor00
	
	final static public CSprite createSprite_Actor00(IImages tiles){

	    // tiles
	    CAnimates animates = new CAnimates(75,tiles);
	     animates.addPart(-17,-36,3,0);//0
		 animates.addPart(-17,-36,0,0);//1
		 animates.addPart(-17,-36,1,0);//2
		 animates.addPart(-17,-36,2,0);//3
		 animates.addPart(-18,-36,83,0);//4
		 animates.addPart(-18,-36,84,0);//5
		 animates.addPart(-21,-35,68,0);//6
		 animates.addPart(-22,-35,69,0);//7
		 animates.addPart(-21,-35,71,0);//8
		 animates.addPart(-21,-36,74,0);//9
		 animates.addPart(-22,-35,73,0);//10
		 animates.addPart(-21,-36,72,0);//11
		 animates.addPart(-22,-36,75,0);//12
		 animates.addPart(-21,-36,76,0);//13
		 animates.addPart(-22,-34,77,0);//14
		 animates.addPart(-20,-35,78,0);//15
		 animates.addPart(-19,-35,79,0);//16
		 animates.addPart(-18,-36,80,0);//17
		 animates.addPart(-22,-35,16,0);//18
		 animates.addPart(-23,-36,19,0);//19
		 animates.addPart(-22,-35,26,0);//20
		 animates.addPart(-19,-35,20,0);//21
		 animates.addPart(-20,-35,21,0);//22
		 animates.addPart(-20,-35,28,0);//23
		 animates.addPart(-20,-35,22,0);//24
		 animates.addPart(-20,-35,29,0);//25
		 animates.addPart(-21,-36,23,0);//26
		 animates.addPart(-21,-35,30,0);//27
		 animates.addPart(-20,-35,32,0);//28
		 animates.addPart(-20,-35,17,0);//29
		 animates.addPart(-21,-35,24,0);//30
		 animates.addPart(-16,-36,9,0);//31
		 animates.addPart(-16,-35,14,0);//32
		 animates.addPart(-17,-35,15,0);//33
		 animates.addPart(-15,-36,10,0);//34
		 animates.addPart(-13,-34,101,0);//35
		 animates.addPart(-10,-34,102,0);//36
		 animates.addPart(-13,-35,103,0);//37
		 animates.addPart(-17,-36,8,0);//38
		 animates.addPart(-25,-35,124,2);//39
		 animates.addPart(-18,-35,125,0);//40
		 animates.addPart(-22,-35,18,0);//41
		 animates.addPart(-23,-35,25,0);//42
		 animates.addPart(-17,-35,4,0);//43
		 animates.addPart(-17,-35,5,0);//44
		 animates.addPart(-18,-35,6,0);//45
		 animates.addPart(-17,-35,7,0);//46
		 animates.addPart(-21,-31,45,0);//47
		 animates.addPart(-17,-29,46,0);//48
		 animates.addPart(-18,-28,47,0);//49
		 animates.addPart(-17,-29,37,0);//50
		 animates.addPart(-16,-29,38,0);//51
		 animates.addPart(-18,-31,48,0);//52
		 animates.addPart(-20,-35,91,0);//53
		 animates.addPart(-20,-35,92,0);//54
		 animates.addPart(-20,-35,93,0);//55
		 animates.addPart(-18,-35,109,0);//56
		 animates.addPart(-17,-35,94,0);//57
		 animates.addPart(-15,-35,12,0);//58
		 animates.addPart(-15,-35,11,0);//59
		 animates.addPart(-16,-36,10,0);//60
		 animates.addPart(-17,-36,9,0);//61
		 animates.addPart(-21,-37,88,0);//62
		 animates.addPart(-20,-37,89,0);//63
		 animates.addPart(-20,-37,90,0);//64
		 animates.addPart(-17,-29,41,0);//65
		 animates.addPart(-22,-28,42,0);//66
		 animates.addPart(-24,-28,43,0);//67
		 animates.addPart(-22,-29,44,0);//68
		 animates.addPart(-17,-29,40,0);//69
		 animates.addPart(-16,-29,39,0);//70
		 animates.addPart(-17,-35,124,0);//71
		 animates.addPart(-17,-35,114,0);//72
		 animates.addPart(-19,-35,115,0);//73
		 animates.addPart(-18,-28,120,0);//74
		
		
	    animates.setFrames(new int[75][]);
	     animates.setComboFrame(new int[]{0,},0);//0
		 animates.setComboFrame(new int[]{1,},1);//1
		 animates.setComboFrame(new int[]{2,},2);//2
		 animates.setComboFrame(new int[]{3,},3);//3
		 animates.setComboFrame(new int[]{4,},4);//4
		 animates.setComboFrame(new int[]{5,},5);//5
		 animates.setComboFrame(new int[]{6,},6);//6
		 animates.setComboFrame(new int[]{7,},7);//7
		 animates.setComboFrame(new int[]{8,},8);//8
		 animates.setComboFrame(new int[]{9,},9);//9
		 animates.setComboFrame(new int[]{10,},10);//10
		 animates.setComboFrame(new int[]{11,},11);//11
		 animates.setComboFrame(new int[]{12,},12);//12
		 animates.setComboFrame(new int[]{13,},13);//13
		 animates.setComboFrame(new int[]{14,},14);//14
		 animates.setComboFrame(new int[]{15,},15);//15
		 animates.setComboFrame(new int[]{16,},16);//16
		 animates.setComboFrame(new int[]{17,},17);//17
		 animates.setComboFrame(new int[]{18,},18);//18
		 animates.setComboFrame(new int[]{19,},19);//19
		 animates.setComboFrame(new int[]{20,},20);//20
		 animates.setComboFrame(new int[]{21,},21);//21
		 animates.setComboFrame(new int[]{22,},22);//22
		 animates.setComboFrame(new int[]{23,},23);//23
		 animates.setComboFrame(new int[]{24,},24);//24
		 animates.setComboFrame(new int[]{25,},25);//25
		 animates.setComboFrame(new int[]{26,},26);//26
		 animates.setComboFrame(new int[]{27,},27);//27
		 animates.setComboFrame(new int[]{28,},28);//28
		 animates.setComboFrame(new int[]{29,},29);//29
		 animates.setComboFrame(new int[]{30,},30);//30
		 animates.setComboFrame(new int[]{31,},31);//31
		 animates.setComboFrame(new int[]{32,},32);//32
		 animates.setComboFrame(new int[]{33,},33);//33
		 animates.setComboFrame(new int[]{34,},34);//34
		 animates.setComboFrame(new int[]{35,},35);//35
		 animates.setComboFrame(new int[]{36,},36);//36
		 animates.setComboFrame(new int[]{37,},37);//37
		 animates.setComboFrame(new int[]{38,},38);//38
		 animates.setComboFrame(new int[]{39,},39);//39
		 animates.setComboFrame(new int[]{40,},40);//40
		 animates.setComboFrame(new int[]{41,},41);//41
		 animates.setComboFrame(new int[]{42,},42);//42
		 animates.setComboFrame(new int[]{43,},43);//43
		 animates.setComboFrame(new int[]{44,},44);//44
		 animates.setComboFrame(new int[]{45,},45);//45
		 animates.setComboFrame(new int[]{46,},46);//46
		 animates.setComboFrame(new int[]{47,},47);//47
		 animates.setComboFrame(new int[]{48,},48);//48
		 animates.setComboFrame(new int[]{49,},49);//49
		 animates.setComboFrame(new int[]{50,},50);//50
		 animates.setComboFrame(new int[]{51,},51);//51
		 animates.setComboFrame(new int[]{52,},52);//52
		 animates.setComboFrame(new int[]{53,},53);//53
		 animates.setComboFrame(new int[]{54,},54);//54
		 animates.setComboFrame(new int[]{55,},55);//55
		 animates.setComboFrame(new int[]{56,},56);//56
		 animates.setComboFrame(new int[]{57,},57);//57
		 animates.setComboFrame(new int[]{58,},58);//58
		 animates.setComboFrame(new int[]{59,},59);//59
		 animates.setComboFrame(new int[]{60,},60);//60
		 animates.setComboFrame(new int[]{61,},61);//61
		 animates.setComboFrame(new int[]{62,},62);//62
		 animates.setComboFrame(new int[]{63,},63);//63
		 animates.setComboFrame(new int[]{64,},64);//64
		 animates.setComboFrame(new int[]{65,},65);//65
		 animates.setComboFrame(new int[]{66,},66);//66
		 animates.setComboFrame(new int[]{67,},67);//67
		 animates.setComboFrame(new int[]{68,},68);//68
		 animates.setComboFrame(new int[]{69,},69);//69
		 animates.setComboFrame(new int[]{70,},70);//70
		 animates.setComboFrame(new int[]{71,},71);//71
		 animates.setComboFrame(new int[]{72,},72);//72
		 animates.setComboFrame(new int[]{73,},73);//73
		 animates.setComboFrame(new int[]{74,},74);//74
		
		
		// cds
	    CCollides collides = new CCollides(8);
		 collides.addCDRect(65535, -2, -32, 4 , 32 );//rect//0
	     collides.addCDRect(65535, -2, -1, 4 , 1 );//rect//1
	     collides.addCDRect(65535, -2, 0, 4 , 1 );//rect//2
	     collides.addCDRect(65535, -5, -33, 10 , 33 );//rect//3
	     collides.addCDRect(65535, -5, -18, 10 , 18 );//rect//4
	     collides.addCDRect(65535, 5, -29, 30 , 6 );//rect//5
	     collides.addCDRect(65535, 5, -31, 30 , 6 );//rect//6
	     collides.addCDRect(65535, 5, -16, 30 , 6 );//rect//7
	    
	    
	    collides.setFrames(new int[10][]);
	     collides.setComboFrame(new int[]{0,1,},0);//0
	     collides.setComboFrame(new int[]{},1);//1
	     collides.setComboFrame(new int[]{3,3,},2);//2
	     collides.setComboFrame(new int[]{2,},3);//3
	     collides.setComboFrame(new int[]{3,},4);//4
	     collides.setComboFrame(new int[]{4,},5);//5
	     collides.setComboFrame(new int[]{4,4,},6);//6
	     collides.setComboFrame(new int[]{5,},7);//7
	     collides.setComboFrame(new int[]{6,},8);//8
	     collides.setComboFrame(new int[]{7,},9);//9
	    
	    
	    
		// sprite frame
		
		/*
		String[] frameName = new String[]{
			"00 standing",
"01 stand jump",
"02 stand jump2",
"03 jump down",
"04 jump stand",
"05 walking",
"06 stand walk",
"07 walk stand",
"08 walk change",
"09 stand upon",
"10 uponing",
"11 upon stand",
"12 stand duck",
"13 ducking",
"14 duck stand",
"15 attack land",
"16 attack air",
"17 attack duck",
"18 damage land",
"19 damage air",
"20 danage duck",

		};
		
		for(int i=0;i<frameName.length;i++){
			System.out.println(frameName[i]);
		}
		*/
		
	    int[][] frameAnimate = new int[][]{
	        {0,1,2,3,2,1,},
{4,5,},
{6,7,},
{8,8,9,9,10,10,11,11,12,13,},
{14,15,16,17,},
{18,19,20,21,22,23,24,25,26,27,28,29,30,},
{31,32,33,},
{34,34,35,35,36,36,37,37,34,38,},
{39,39,39,39,40,40,29,30,41,42,},
{1,43,44,45,46,},
{46,},
{46,45,44,43,1,},
{1,47,48,49,50,51,},
{51,},
{51,52,3,},
{53,54,54,55,56,57,58,59,60,38,61,},
{62,63,63,64,64,64,64,64,64,64,64,},
{65,66,66,67,68,69,69,70,70,51,51,},
{71,72,71,72,71,72,71,72,},
{73,73,73,73,73,73,73,73,},
{74,74,74,74,74,74,74,74,},

	    };
	    int[][] frameCDMap = new int[][]{
	        {0,1,1,1,1,1,},
{1,1,},
{1,1,},
{1,1,1,1,1,1,1,1,1,1,},
{1,1,1,1,},
{1,1,1,1,1,1,1,1,1,1,1,1,1,},
{1,1,1,},
{1,1,1,1,1,1,1,1,1,1,},
{1,1,1,1,1,1,1,1,1,1,},
{1,1,1,1,1,},
{1,},
{1,1,1,1,1,},
{1,1,1,1,1,1,},
{1,},
{1,1,1,},
{1,1,1,1,1,1,1,1,1,1,1,},
{1,1,1,1,1,1,1,1,1,1,1,},
{1,1,1,1,1,1,1,1,1,1,1,},
{1,1,1,1,1,1,1,1,},
{1,1,1,1,1,1,1,1,},
{1,1,1,1,1,1,1,1,},

	    };
	    int[][] frameCDAtk = new int[][]{
	        {1,1,1,1,1,1,},
{1,1,},
{1,1,},
{1,1,1,1,1,1,1,1,1,1,},
{1,1,1,1,},
{1,1,1,1,1,1,1,1,1,1,1,1,1,},
{1,1,1,},
{1,1,1,1,1,1,1,1,1,1,},
{1,1,1,1,1,1,1,1,1,1,},
{1,1,1,1,1,},
{1,},
{1,1,1,1,1,},
{1,1,1,1,1,1,},
{1,},
{1,1,1,},
{1,7,1,1,1,1,1,1,1,1,1,},
{1,8,1,1,1,1,1,1,1,1,1,},
{1,9,1,1,1,1,1,1,1,1,1,},
{1,1,1,1,1,1,1,1,},
{1,1,1,1,1,1,1,1,},
{1,1,1,1,1,1,1,1,},

	    };
	    int[][] frameCDDef = new int[][]{
	        {2,4,4,4,4,4,},
{4,4,},
{4,4,},
{4,4,4,4,4,4,4,4,4,4,},
{4,4,4,4,},
{4,4,4,4,4,4,4,4,4,4,4,4,4,},
{4,4,4,},
{4,4,4,4,4,4,4,4,4,4,},
{4,4,4,4,4,4,4,4,4,4,},
{4,4,4,4,4,},
{4,},
{4,4,4,4,4,},
{5,5,5,5,5,6,},
{5,},
{5,5,5,},
{4,4,4,4,4,4,4,4,4,4,4,},
{4,4,4,4,4,4,4,4,4,4,4,},
{5,5,5,5,5,5,5,5,5,5,5,},
{1,1,1,1,1,1,1,1,},
{1,1,1,1,1,1,1,1,},
{1,1,1,1,1,1,1,1,},

	    };
	    int[][] frameCDExt = new int[][]{
	        {3,1,1,1,1,1,},
{1,1,},
{1,1,},
{1,1,1,1,1,1,1,1,1,1,},
{1,1,1,1,},
{1,1,1,1,1,1,1,1,1,1,1,1,1,},
{1,1,1,},
{1,1,1,1,1,1,1,1,1,1,},
{1,1,1,1,1,1,1,1,1,1,},
{1,1,1,1,1,},
{1,},
{1,1,1,1,1,},
{1,1,1,1,1,1,},
{1,},
{1,1,1,},
{1,1,1,1,1,1,1,1,1,1,1,},
{1,1,1,1,1,1,1,1,1,1,1,},
{1,1,1,1,1,1,1,1,1,1,1,},
{1,1,1,1,1,1,1,1,},
{1,1,1,1,1,1,1,1,},
{1,1,1,1,1,1,1,1,},

	    };
	
	    CSprite ret = new CSprite(
	            animates, 
	            collides, 
	            frameAnimate, 
	            frameCDMap, 
	            frameCDAtk, 
	            frameCDDef, 
	            frameCDExt 
	            );
	
	    return ret;
	
	}
	

	// Sprite : e00_zombi //E00_Zombi
	
	final static public CSprite createSprite_e00_zombi(IImages tiles){

	    // tiles
	    CAnimates animates = new CAnimates(8,tiles);
	     animates.addPart(-8,0,0,0);//0
		 animates.addPart(-9,-7,2,0);//1
		 animates.addPart(-10,-9,3,0);//2
		 animates.addPart(-10,-15,4,0);//3
		 animates.addPart(-10,-18,5,0);//4
		 animates.addPart(-11,-25,6,0);//5
		 animates.addPart(-10,-35,7,0);//6
		 animates.addPart(-10,-33,8,0);//7
		
		
	    animates.setFrames(new int[8][]);
	     animates.setComboFrame(new int[]{0,},0);//0
		 animates.setComboFrame(new int[]{1,},1);//1
		 animates.setComboFrame(new int[]{2,},2);//2
		 animates.setComboFrame(new int[]{3,},3);//3
		 animates.setComboFrame(new int[]{4,},4);//4
		 animates.setComboFrame(new int[]{5,},5);//5
		 animates.setComboFrame(new int[]{6,},6);//6
		 animates.setComboFrame(new int[]{7,},7);//7
		
		
		// cds
	    CCollides collides = new CCollides(4);
		 collides.addCDRect(65535, -5, -8, 10 , 8 );//rect//0
	     collides.addCDRect(2, -5, -1, 10 , 1 );//rect//1
	     collides.addCDRect(65535, -5, 0, 10 , 1 );//rect//2
	     collides.addCDRect(65535, -5, -34, 13 , 34 );//rect//3
	    
	    
	    collides.setFrames(new int[4][]);
	     collides.setComboFrame(new int[]{0,1,},0);//0
	     collides.setComboFrame(new int[]{},1);//1
	     collides.setComboFrame(new int[]{2,},2);//2
	     collides.setComboFrame(new int[]{3,},3);//3
	    
	    
	    
		// sprite frame
		
		/*
		String[] frameName = new String[]{
			"0000",
"0001",
"0003",
"0004",

		};
		
		for(int i=0;i<frameName.length;i++){
			System.out.println(frameName[i]);
		}
		*/
		
	    int[][] frameAnimate = new int[][]{
	        {0,1,2,3,4,5,6,},
{6,6,6,6,7,7,7,7,},
{6,5,4,3,2,1,0,},
{6,6,6,6,6,6,6,6,},

	    };
	    int[][] frameCDMap = new int[][]{
	        {0,1,1,1,1,1,1,},
{1,1,1,1,1,1,1,1,},
{1,1,1,1,1,1,1,},
{1,1,1,1,1,1,1,1,},

	    };
	    int[][] frameCDAtk = new int[][]{
	        {1,1,1,1,1,1,1,},
{3,3,3,3,3,3,3,3,},
{1,1,1,1,1,1,1,},
{1,1,1,1,1,1,1,1,},

	    };
	    int[][] frameCDDef = new int[][]{
	        {1,1,1,1,1,1,1,},
{3,3,3,3,3,3,3,3,},
{1,1,1,1,1,1,1,},
{1,1,1,1,1,1,1,1,},

	    };
	    int[][] frameCDExt = new int[][]{
	        {2,1,1,1,1,1,1,},
{1,1,1,1,1,1,1,1,},
{1,1,1,1,1,1,1,},
{1,1,1,1,1,1,1,1,},

	    };
	
	    CSprite ret = new CSprite(
	            animates, 
	            collides, 
	            frameAnimate, 
	            frameCDMap, 
	            frameCDAtk, 
	            frameCDDef, 
	            frameCDExt 
	            );
	
	    return ret;
	
	}
	

	// Sprite : Door //Event
	
	final static public CSprite createSprite_Door(IImages tiles){

	    // tiles
	    CAnimates animates = new CAnimates(0,tiles);
	    
		
	    animates.setFrames(new int[1][]);
	     animates.setComboFrame(new int[]{},0);//0
		
		
		// cds
	    CCollides collides = new CCollides(4);
		 collides.addCDRect(65535, -8, 0, 8 , 48 );//rect//0
	     collides.addCDRect(65535, 0, 0, 8 , 48 );//rect//1
	     collides.addCDRect(65535, 0, -8, 48 , 8 );//rect//2
	     collides.addCDRect(65535, 0, 0, 48 , 8 );//rect//3
	    
	    
	    collides.setFrames(new int[5][]);
	     collides.setComboFrame(new int[]{0,},0);//0
	     collides.setComboFrame(new int[]{},1);//1
	     collides.setComboFrame(new int[]{1,},2);//2
	     collides.setComboFrame(new int[]{2,},3);//3
	     collides.setComboFrame(new int[]{3,},4);//4
	    
	    
	    
		// sprite frame
		
		/*
		String[] frameName = new String[]{
			"Left",
"Right",
"Up",
"Down",

		};
		
		for(int i=0;i<frameName.length;i++){
			System.out.println(frameName[i]);
		}
		*/
		
	    int[][] frameAnimate = new int[][]{
	        {0,},
{0,},
{0,},
{0,},

	    };
	    int[][] frameCDMap = new int[][]{
	        {0,},
{2,},
{3,},
{4,},

	    };
	    int[][] frameCDAtk = new int[][]{
	        {1,},
{1,},
{1,},
{1,},

	    };
	    int[][] frameCDDef = new int[][]{
	        {1,},
{1,},
{1,},
{1,},

	    };
	    int[][] frameCDExt = new int[][]{
	        {1,},
{1,},
{1,},
{1,},

	    };
	
	    CSprite ret = new CSprite(
	            animates, 
	            collides, 
	            frameAnimate, 
	            frameCDMap, 
	            frameCDAtk, 
	            frameCDDef, 
	            frameCDExt 
	            );
	
	    return ret;
	
	}
	

	

	//--------------------------------------------------------------------------------------------------------------
	
	 
	final public static String images_Actor00 = "Actor00";
	
 
	final public static String images_MapTile00 = "MapTile00";
	
 
	final public static String images_E00_Zombi = "E00_Zombi";
	
 
	final public static String images_Event = "Event";
	


	
	final public static String map_Level_00 = "Level_00";
	

	final public static String map_Level_01 = "Level_01";
	

	final public static String map_Entry = "Entry";
	

	
	
	final public static String spr_Actor00 = "Actor00";
	

	final public static String spr_e00_zombi = "e00_zombi";
	

	final public static String spr_Door = "Door";
	



	//--------------------------------------------------------------------------------------------------------------
	final public static IImages createImages(String key){
	 
		if(key=="Actor00"){
			return createClipImages_Actor00();
		}
	
 
		if(key=="MapTile00"){
			return createClipImages_MapTile00();
		}
	
 
		if(key=="E00_Zombi"){
			return createClipImages_E00_Zombi();
		}
	
 
		if(key=="Event"){
			return createClipImages_Event();
		}
	

		return null;
	}
	
	final public static CMap createMap(String key, IImages tiles, boolean isAnimate, boolean isCyc){
	
		if(key=="Level_00"){
			return createMap_Level_00(tiles,isAnimate,isCyc);
		}
	

		if(key=="Level_01"){
			return createMap_Level_01(tiles,isAnimate,isCyc);
		}
	

		if(key=="Entry"){
			return createMap_Entry(tiles,isAnimate,isCyc);
		}
	

		return null;
	}
	
	final public static CSprite createSprite(String key, IImages tiles){
	
		if(key=="Actor00"){
			return createSprite_Actor00(tiles);
		}
	

		if(key=="e00_zombi"){
			return createSprite_e00_zombi(tiles);
		}
	

		if(key=="Door"){
			return createSprite_Door(tiles);
		}
	

		return null;
	}
	

//--------------------------------------------------------------------------------------------------------------
// level trunk
//--------------------------------------------------------------------------------------------------------------



	// name const
	
	final public static String world_Level_00 = "Level_00"; 

	final public static String world_Level_01 = "Level_01"; 

	final public static String world_Entry = "Entry"; 

	
	// room scopes
	final static public CCD[] WorldRooms = new CCD[]{
	 
		CCD.createCDRect(0xffffffff, 
			CUtil.stringKeyValue( "x320y0" , "x"), 
			CUtil.stringKeyValue( "x320y0" , "y"),
			640, 
			320),
	
 
		CCD.createCDRect(0xffffffff, 
			CUtil.stringKeyValue( "x960y0" , "x"), 
			CUtil.stringKeyValue( "x960y0" , "y"),
			640, 
			320),
	
 
		CCD.createCDRect(0xffffffff, 
			CUtil.stringKeyValue( "x0y0" , "x"), 
			CUtil.stringKeyValue( "x0y0" , "y"),
			320, 
			320),
	

	};

	// world names
	final static public String[] WorldNames = new String[]{
	 
	"Level_00", 
 
	"Level_01", 
 
	"Entry", 

	};


	
	// create world
	final static public LevelManager createWorld(){
		LevelManager level = new LevelManager();
		
		// screen size
		level.WindowX = 0;
		level.WindowY = 0;
		level.WindowW = 176;
		level.WindowH = 208;
		
	
		// World : Level_00
		if(level.WorldName=="Level_00"){
		
			// World Size
			level.Width  = 640 ;
			level.Height = 320;
			
			// Map
			 
			level.MapTile = "MapTile00";    // map tile name
			level.MapType = "Level_00"; // map type 
			level.MapInfo = "x320y0";     // map info form editor
			level.X       = CUtil.stringKeyValue("x320y0","x"); // level x pos
			level.Y       = CUtil.stringKeyValue("x320y0","y"); // level y pos
			CObject.println("x320y0");
			CObject.println("Level X = " + level.X );
			CObject.println("Level Y = " + level.Y );
			CObject.println("Level W = " + level.Width ); 
			CObject.println("Level H = " + level.Height);
			
			
			
			// WayPoint
			// waypoint count : 0
			CWayPoint[] WayPoints = new CWayPoint[0];
			
			// waypoint link 
			
			level.WayPoints = WayPoints;
			
			// Sprite
			// sprite count : 9
			level.SprsTile = new String[9];
			level.SprsType = new String[9];
			level.SprsInfo = new String[9];
			level.SprsX    = new int[9];
			level.SprsY    = new int[9];
			 
			level.SprsTile[0] = "E00_Zombi";    // sprite tile name
			level.SprsType[0] = "e00_zombi"; // sprite type
			level.SprsInfo[0] = "e00_zombi";     // sprite info form editor
			level.SprsX[0]    = 368;          // sprite xpos form editor
			level.SprsY[0]    = 304;          // sprite ypos form editor
			 
			level.SprsTile[1] = "E00_Zombi";    // sprite tile name
			level.SprsType[1] = "e00_zombi"; // sprite type
			level.SprsInfo[1] = "e00_zombi";     // sprite info form editor
			level.SprsX[1]    = 320;          // sprite xpos form editor
			level.SprsY[1]    = 304;          // sprite ypos form editor
			 
			level.SprsTile[2] = "E00_Zombi";    // sprite tile name
			level.SprsType[2] = "e00_zombi"; // sprite type
			level.SprsInfo[2] = "e00_zombi";     // sprite info form editor
			level.SprsX[2]    = 272;          // sprite xpos form editor
			level.SprsY[2]    = 304;          // sprite ypos form editor
			 
			level.SprsTile[3] = "E00_Zombi";    // sprite tile name
			level.SprsType[3] = "e00_zombi"; // sprite type
			level.SprsInfo[3] = "e00_zombi";     // sprite info form editor
			level.SprsX[3]    = 176;          // sprite xpos form editor
			level.SprsY[3]    = 304;          // sprite ypos form editor
			 
			level.SprsTile[4] = "E00_Zombi";    // sprite tile name
			level.SprsType[4] = "e00_zombi"; // sprite type
			level.SprsInfo[4] = "e00_zombi";     // sprite info form editor
			level.SprsX[4]    = 464;          // sprite xpos form editor
			level.SprsY[4]    = 304;          // sprite ypos form editor
			 
			level.SprsTile[5] = "E00_Zombi";    // sprite tile name
			level.SprsType[5] = "e00_zombi"; // sprite type
			level.SprsInfo[5] = "e00_zombi";     // sprite info form editor
			level.SprsX[5]    = 416;          // sprite xpos form editor
			level.SprsY[5]    = 304;          // sprite ypos form editor
			 
			level.SprsTile[6] = "E00_Zombi";    // sprite tile name
			level.SprsType[6] = "e00_zombi"; // sprite type
			level.SprsInfo[6] = "e00_zombi";     // sprite info form editor
			level.SprsX[6]    = 224;          // sprite xpos form editor
			level.SprsY[6]    = 304;          // sprite ypos form editor
			 
			level.SprsTile[7] = "Event";    // sprite tile name
			level.SprsType[7] = "Door"; // sprite type
			level.SprsInfo[7] = "Door";     // sprite info form editor
			level.SprsX[7]    = 640;          // sprite xpos form editor
			level.SprsY[7]    = 256;          // sprite ypos form editor
			 
			level.SprsTile[8] = "Event";    // sprite tile name
			level.SprsType[8] = "Door"; // sprite type
			level.SprsInfo[8] = "Door";     // sprite info form editor
			level.SprsX[8]    = 0;          // sprite xpos form editor
			level.SprsY[8]    = 240;          // sprite ypos form editor
			
			
		}
	

		// World : Level_01
		if(level.WorldName=="Level_01"){
		
			// World Size
			level.Width  = 640 ;
			level.Height = 320;
			
			// Map
			 
			level.MapTile = "MapTile00";    // map tile name
			level.MapType = "Level_01"; // map type 
			level.MapInfo = "x960y0";     // map info form editor
			level.X       = CUtil.stringKeyValue("x960y0","x"); // level x pos
			level.Y       = CUtil.stringKeyValue("x960y0","y"); // level y pos
			CObject.println("x960y0");
			CObject.println("Level X = " + level.X );
			CObject.println("Level Y = " + level.Y );
			CObject.println("Level W = " + level.Width ); 
			CObject.println("Level H = " + level.Height);
			
			
			
			// WayPoint
			// waypoint count : 0
			CWayPoint[] WayPoints = new CWayPoint[0];
			
			// waypoint link 
			
			level.WayPoints = WayPoints;
			
			// Sprite
			// sprite count : 8
			level.SprsTile = new String[8];
			level.SprsType = new String[8];
			level.SprsInfo = new String[8];
			level.SprsX    = new int[8];
			level.SprsY    = new int[8];
			 
			level.SprsTile[0] = "E00_Zombi";    // sprite tile name
			level.SprsType[0] = "e00_zombi"; // sprite type
			level.SprsInfo[0] = "S001_e00_zombi";     // sprite info form editor
			level.SprsX[0]    = 292;          // sprite xpos form editor
			level.SprsY[0]    = 303;          // sprite ypos form editor
			 
			level.SprsTile[1] = "E00_Zombi";    // sprite tile name
			level.SprsType[1] = "e00_zombi"; // sprite type
			level.SprsInfo[1] = "S003_e00_zombi";     // sprite info form editor
			level.SprsX[1]    = 267;          // sprite xpos form editor
			level.SprsY[1]    = 303;          // sprite ypos form editor
			 
			level.SprsTile[2] = "E00_Zombi";    // sprite tile name
			level.SprsType[2] = "e00_zombi"; // sprite type
			level.SprsInfo[2] = "S004_e00_zombi";     // sprite info form editor
			level.SprsX[2]    = 242;          // sprite xpos form editor
			level.SprsY[2]    = 303;          // sprite ypos form editor
			 
			level.SprsTile[3] = "E00_Zombi";    // sprite tile name
			level.SprsType[3] = "e00_zombi"; // sprite type
			level.SprsInfo[3] = "S005_e00_zombi";     // sprite info form editor
			level.SprsX[3]    = 316;          // sprite xpos form editor
			level.SprsY[3]    = 303;          // sprite ypos form editor
			 
			level.SprsTile[4] = "E00_Zombi";    // sprite tile name
			level.SprsType[4] = "e00_zombi"; // sprite type
			level.SprsInfo[4] = "S006_e00_zombi";     // sprite info form editor
			level.SprsX[4]    = 344;          // sprite xpos form editor
			level.SprsY[4]    = 303;          // sprite ypos form editor
			 
			level.SprsTile[5] = "Event";    // sprite tile name
			level.SprsType[5] = "Door"; // sprite type
			level.SprsInfo[5] = "S007_Door";     // sprite info form editor
			level.SprsX[5]    = 48;          // sprite xpos form editor
			level.SprsY[5]    = 0;          // sprite ypos form editor
			 
			level.SprsTile[6] = "Event";    // sprite tile name
			level.SprsType[6] = "Door"; // sprite type
			level.SprsInfo[6] = "S008_Door";     // sprite info form editor
			level.SprsX[6]    = 0;          // sprite xpos form editor
			level.SprsY[6]    = 256;          // sprite ypos form editor
			 
			level.SprsTile[7] = "Event";    // sprite tile name
			level.SprsType[7] = "Door"; // sprite type
			level.SprsInfo[7] = "S009_Door";     // sprite info form editor
			level.SprsX[7]    = 640;          // sprite xpos form editor
			level.SprsY[7]    = 240;          // sprite ypos form editor
			
			
		}
	

		// World : Entry
		if(level.WorldName=="Entry"){
		
			// World Size
			level.Width  = 320 ;
			level.Height = 320;
			
			// Map
			 
			level.MapTile = "MapTile00";    // map tile name
			level.MapType = "Entry"; // map type 
			level.MapInfo = "x0y0";     // map info form editor
			level.X       = CUtil.stringKeyValue("x0y0","x"); // level x pos
			level.Y       = CUtil.stringKeyValue("x0y0","y"); // level y pos
			CObject.println("x0y0");
			CObject.println("Level X = " + level.X );
			CObject.println("Level Y = " + level.Y );
			CObject.println("Level W = " + level.Width ); 
			CObject.println("Level H = " + level.Height);
			
			
			
			// WayPoint
			// waypoint count : 0
			CWayPoint[] WayPoints = new CWayPoint[0];
			
			// waypoint link 
			
			level.WayPoints = WayPoints;
			
			// Sprite
			// sprite count : 1
			level.SprsTile = new String[1];
			level.SprsType = new String[1];
			level.SprsInfo = new String[1];
			level.SprsX    = new int[1];
			level.SprsY    = new int[1];
			 
			level.SprsTile[0] = "Actor00";    // sprite tile name
			level.SprsType[0] = "Actor00"; // sprite type
			level.SprsInfo[0] = "S001_Actor00";     // sprite info form editor
			level.SprsX[0]    = 35;          // sprite xpos form editor
			level.SprsY[0]    = 303;          // sprite ypos form editor
			
			
		}
	

	
		return level;
	}
	
	

	
}




/* Encoding : 简体中文(GB2312) */
/* Cell Game Editor by WAZA Zhang */
/* Email : wazazhang@gmail.com */

//
// SkyCity Script v0.0.0
// 
// 指定文件输出
// <OUTPUT>     ..\res\ResesScript.java
// 

import com.morefuntek.cell.*;
import com.morefuntek.cell.Game.*;

public class ResesScript {

//--------------------------------------------------------------------------------------------------------------
// resource trunk
//--------------------------------------------------------------------------------------------------------------


	//--------------------------------------------------------------------------------------------------------------
	 
	// Images : Actor00 
	final static public void buildClipImages_Actor00(IImages stuff){
	
		stuff.buildImages(CIO.loadImage("/Actor00.png"),135);
		
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
		
		
		stuff.gc();
	}
	
 
	// Images : MapTile00 
	final static public void buildClipImages_MapTile00(IImages stuff){
	
		stuff.buildImages(CIO.loadImage("/MapTile00.png"),24);
		
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
		 stuff.addTile(48,48,16,16);//15 
		 stuff.addTile(64,48,16,16);//16 
		 stuff.addTile(80,48,16,16);//17 
		 stuff.addTile(0,64,16,16);//18 
		 stuff.addTile(16,64,16,16);//19 
		 stuff.addTile(32,64,16,16);//20 
		 stuff.addTile(48,64,16,16);//21 
		 stuff.addTile(64,64,16,16);//22 
		 stuff.addTile(80,64,16,16);//23 
		
		
		stuff.gc();
	}
	


	//--------------------------------------------------------------------------------------------------------------
	
	// Map : Level_00
	final static public CMap createMap_Level_00(IImages tiles,boolean isAnimate,boolean isCyc){
		
		//20 x 20
		
		// tiles
	    CAnimates animates = new CAnimates(9,tiles);
	     animates.addPart(0,0,20,0);//0
		 animates.addPart(0,0,13,0);//1
		 animates.addPart(0,0,1,0);//2
		 animates.addPart(0,0,0,0);//3
		 animates.addPart(0,0,12,0);//4
		 animates.addPart(0,0,2,0);//5
		 animates.addPart(0,0,14,0);//6
		 animates.addPart(0,0,6,0);//7
		 animates.addPart(0,0,7,0);//8
		
		
	    animates.setFrame(new int[9][]);
	     animates.setComboFrame(new int[]{0,},0);//0
		 animates.setComboFrame(new int[]{1,},1);//1
		 animates.setComboFrame(new int[]{2,},2);//2
		 animates.setComboFrame(new int[]{3,},3);//3
		 animates.setComboFrame(new int[]{4,},4);//4
		 animates.setComboFrame(new int[]{5,},5);//5
		 animates.setComboFrame(new int[]{6,},6);//6
		 animates.setComboFrame(new int[]{7,},7);//7
		 animates.setComboFrame(new int[]{8,},8);//8
		
		
		short[][] tileMatrix = new short[][]{
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{1,2,2,2,2,2,2,2,2,3,2,3,2,2,3,3,2,2,3,4,},
{1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3,2,2,4,},
{1,2,2,2,2,2,2,2,2,2,2,3,2,2,2,2,2,2,2,4,},
{1,2,2,3,2,2,2,2,3,3,2,2,2,3,2,2,2,2,3,4,},
{1,2,2,2,2,5,2,2,5,3,3,5,2,2,5,2,3,5,2,4,},
{1,2,2,2,2,3,2,2,2,3,2,3,2,3,3,2,2,2,3,4,},
{1,3,2,2,2,2,2,2,2,2,2,2,2,3,2,3,2,2,2,4,},
{1,2,2,2,2,4,6,6,6,6,6,6,6,6,6,6,6,6,6,6,},
{1,2,2,2,2,2,3,2,2,2,2,2,2,3,2,2,2,2,2,4,},
{1,3,2,2,2,2,2,2,2,2,2,2,2,3,3,2,2,3,2,4,},
{1,2,2,7,8,2,2,2,2,2,2,3,2,2,2,2,2,2,2,4,},
{1,2,3,2,2,2,2,2,3,3,2,3,2,3,3,2,3,2,2,4,},
{1,2,2,3,3,2,7,8,2,2,3,2,2,2,2,2,2,2,2,4,},
{1,3,3,2,3,2,2,2,2,2,2,2,2,3,2,2,2,2,2,4,},
{2,2,3,7,8,2,2,2,2,7,8,2,2,2,2,3,3,3,2,4,},
{3,2,2,2,2,2,2,3,2,2,2,2,3,2,2,7,8,2,2,3,},
{3,2,2,2,2,2,2,2,3,2,2,2,2,2,2,3,2,3,3,3,},
{6,6,6,6,6,6,6,6,1,3,3,2,2,2,2,2,2,3,3,3,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,6,0,},

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
		
	    if("line"=="rect") collides.addCDRect(32, 1, 1, 16 , 16 );//line//6
		if("line"=="line") collides.addCDLine(32, 1, 1, 15, 15);//line//6
		
	    if("line"=="rect") collides.addCDRect(64, 15, 1, 16 , 16 );//line//7
		if("line"=="line") collides.addCDLine(64, 15, 1, 1, 15);//line//7
		

		short[][] flagMatrix = new short[][]{
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,},
{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,},
{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,},
{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,},
{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,},
{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,},
{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,},
{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,},
{1,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,},
{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,},
{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,},
{1,0,0,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,},
{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,},
{1,0,0,0,0,0,2,2,0,0,0,0,0,0,0,0,0,0,0,1,},
{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,},
{4,0,0,2,2,0,0,0,0,2,2,0,0,0,0,0,0,0,0,1,},
{4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,0,0,5,},
{4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,5,},
{1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,5,},
{0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,},

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
	
	// Sprite : Actor00
	final static public CSprite createSprite_Actor00(IImages tiles){

	    // tiles
	    CAnimates animates = new CAnimates(88,tiles);
	     animates.addPart(-17,-36,3,0);//0
		 animates.addPart(-17,-36,0,0);//1
		 animates.addPart(-17,-36,1,0);//2
		 animates.addPart(-17,-36,2,0);//3
		 animates.addPart(-18,-36,83,0);//4
		 animates.addPart(-18,-36,84,0);//5
		 animates.addPart(-21,-35,68,0);//6
		 animates.addPart(-22,-35,69,0);//7
		 animates.addPart(-21,-35,70,0);//8
		 animates.addPart(-21,-36,74,0);//9
		 animates.addPart(-21,-35,71,0);//10
		 animates.addPart(-22,-35,73,0);//11
		 animates.addPart(-21,-36,72,0);//12
		 animates.addPart(-22,-36,75,0);//13
		 animates.addPart(-21,-36,76,0);//14
		 animates.addPart(-22,-34,77,0);//15
		 animates.addPart(-20,-35,78,0);//16
		 animates.addPart(-19,-35,79,0);//17
		 animates.addPart(-18,-36,80,0);//18
		 animates.addPart(-22,-35,16,0);//19
		 animates.addPart(-23,-36,19,0);//20
		 animates.addPart(-22,-35,26,0);//21
		 animates.addPart(-19,-35,20,0);//22
		 animates.addPart(-20,-35,21,0);//23
		 animates.addPart(-20,-35,28,0);//24
		 animates.addPart(-20,-35,22,0);//25
		 animates.addPart(-20,-35,29,0);//26
		 animates.addPart(-21,-36,23,0);//27
		 animates.addPart(-21,-35,30,0);//28
		 animates.addPart(-20,-35,32,0);//29
		 animates.addPart(-20,-35,17,0);//30
		 animates.addPart(-21,-35,24,0);//31
		 animates.addPart(-16,-36,9,0);//32
		 animates.addPart(-16,-35,14,0);//33
		 animates.addPart(-17,-35,15,0);//34
		 animates.addPart(-15,-36,10,0);//35
		 animates.addPart(-13,-34,101,0);//36
		 animates.addPart(-10,-34,102,0);//37
		 animates.addPart(-13,-35,103,0);//38
		 animates.addPart(-17,-36,8,0);//39
		 animates.addPart(-25,-35,124,2);//40
		 animates.addPart(-18,-35,125,0);//41
		 animates.addPart(-22,-35,18,0);//42
		 animates.addPart(-23,-35,25,0);//43
		 animates.addPart(-17,-35,4,0);//44
		 animates.addPart(-17,-35,5,0);//45
		 animates.addPart(-18,-35,6,0);//46
		 animates.addPart(-17,-35,7,0);//47
		 animates.addPart(-21,-31,45,0);//48
		 animates.addPart(-17,-29,46,0);//49
		 animates.addPart(-18,-28,47,0);//50
		 animates.addPart(-17,-29,37,0);//51
		 animates.addPart(-16,-29,38,0);//52
		 animates.addPart(-18,-31,48,0);//53
		 animates.addPart(-20,-31,45,0);//54
		 animates.addPart(-20,-30,46,0);//55
		 animates.addPart(-20,-29,47,0);//56
		 animates.addPart(-20,-30,37,0);//57
		 animates.addPart(-18,-31,38,0);//58
		 animates.addPart(-16,-29,39,0);//59
		 animates.addPart(-16,-29,41,0);//60
		 animates.addPart(-20,-28,42,0);//61
		 animates.addPart(-22,-28,43,0);//62
		 animates.addPart(-20,-29,44,0);//63
		 animates.addPart(-15,-29,40,0);//64
		 animates.addPart(-20,-29,42,0);//65
		 animates.addPart(-20,-29,43,0);//66
		 animates.addPart(-20,-35,4,0);//67
		 animates.addPart(-20,-35,5,0);//68
		 animates.addPart(-20,-35,6,0);//69
		 animates.addPart(-20,-35,7,0);//70
		 animates.addPart(-20,-35,92,0);//71
		 animates.addPart(-20,-35,93,0);//72
		 animates.addPart(-20,-35,109,0);//73
		 animates.addPart(-20,-35,94,0);//74
		 animates.addPart(-20,-35,11,0);//75
		 animates.addPart(-20,-35,88,0);//76
		 animates.addPart(-20,-35,89,0);//77
		 animates.addPart(-20,-35,90,0);//78
		 animates.addPart(-17,-35,72,0);//79
		 animates.addPart(-17,-35,73,0);//80
		 animates.addPart(-17,-35,74,0);//81
		 animates.addPart(-17,-35,124,0);//82
		 animates.addPart(-17,-35,114,0);//83
		 animates.addPart(-20,-35,115,0);//84
		 animates.addPart(-20,-29,119,0);//85
		 animates.addPart(-20,-28,120,0);//86
		 animates.addPart(-20,-29,38,0);//87
		
		
	    animates.setFrame(new int[88][]);
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
		 animates.setComboFrame(new int[]{75,},75);//75
		 animates.setComboFrame(new int[]{76,},76);//76
		 animates.setComboFrame(new int[]{77,},77);//77
		 animates.setComboFrame(new int[]{78,},78);//78
		 animates.setComboFrame(new int[]{79,},79);//79
		 animates.setComboFrame(new int[]{80,},80);//80
		 animates.setComboFrame(new int[]{81,},81);//81
		 animates.setComboFrame(new int[]{82,},82);//82
		 animates.setComboFrame(new int[]{83,},83);//83
		 animates.setComboFrame(new int[]{84,},84);//84
		 animates.setComboFrame(new int[]{85,},85);//85
		 animates.setComboFrame(new int[]{86,},86);//86
		 animates.setComboFrame(new int[]{87,},87);//87
		
		
		// cds
	    CCollides collides = new CCollides(3);
		 collides.addCDRect(65535, -2, -32, 4 , 32 );//rect//0
	     collides.addCDRect(65535, -2, -1, 4 , 1 );//rect//1
	     collides.addCDRect(65535, -2, 0, 4 , 1 );//rect//2
	    
	    
	    collides.setFrame(new int[3][]);
	     collides.setComboFrame(new int[]{0,1,},0);//0
	     collides.setComboFrame(new int[]{},1);//1
	     collides.setComboFrame(new int[]{2,},2);//2
	    
	    
	    
		// sprite frame
	    int[][] frameAnimate = new int[][]{
	        {0,1,2,3,2,1,},
{4,5,},
{6,7,},
{8,9,10,11,12,13,14,},
{15,16,17,18,},
{19,20,21,22,23,24,25,26,27,28,29,30,31,},
{32,33,34,},
{35,36,37,38,35,39,},
{40,40,40,40,41,41,30,31,42,43,},
{1,44,45,46,47,},
{47,},
{47,46,45,44,1,},
{1,48,49,50,51,52,},
{52,},
{52,53,3,},
{54,55,56,57,58,},
{59,60,61,62,63,64,},
{60,65,66,},
{67,68,69,70,71,71,72,73,74,75,},
{76,77,77,78,79,80,81,},
{82,83,},
{84,},
{85,86,87,},
{69,70,},

	    };
	    int[][] frameCDMap = new int[][]{
	        {0,1,1,1,1,1,},
{1,1,},
{1,1,},
{1,1,1,1,1,1,1,},
{1,1,1,1,},
{1,1,1,1,1,1,1,1,1,1,1,1,1,},
{1,1,1,},
{1,1,1,1,1,1,},
{1,1,1,1,1,1,1,1,1,1,},
{1,1,1,1,1,},
{1,},
{1,1,1,1,1,},
{1,1,1,1,1,1,},
{1,},
{1,1,1,},
{1,1,1,1,1,},
{1,1,1,1,1,1,},
{1,1,1,},
{1,1,1,1,1,1,1,1,1,1,},
{1,1,1,1,1,1,1,},
{1,1,},
{1,},
{1,1,1,},
{1,1,},

	    };
	    int[][] frameCDAtk = new int[][]{
	        {1,1,1,1,1,1,},
{1,1,},
{1,1,},
{1,1,1,1,1,1,1,},
{1,1,1,1,},
{1,1,1,1,1,1,1,1,1,1,1,1,1,},
{1,1,1,},
{1,1,1,1,1,1,},
{1,1,1,1,1,1,1,1,1,1,},
{1,1,1,1,1,},
{1,},
{1,1,1,1,1,},
{1,1,1,1,1,1,},
{1,},
{1,1,1,},
{1,1,1,1,1,},
{1,1,1,1,1,1,},
{1,1,1,},
{1,1,1,1,1,1,1,1,1,1,},
{1,1,1,1,1,1,1,},
{1,1,},
{1,},
{1,1,1,},
{1,1,},

	    };
	    int[][] frameCDDef = new int[][]{
	        {1,1,1,1,1,1,},
{1,1,},
{1,1,},
{1,1,1,1,1,1,1,},
{1,1,1,1,},
{1,1,1,1,1,1,1,1,1,1,1,1,1,},
{1,1,1,},
{1,1,1,1,1,1,},
{1,1,1,1,1,1,1,1,1,1,},
{1,1,1,1,1,},
{1,},
{1,1,1,1,1,},
{1,1,1,1,1,1,},
{1,},
{1,1,1,},
{1,1,1,1,1,},
{1,1,1,1,1,1,},
{1,1,1,},
{1,1,1,1,1,1,1,1,1,1,},
{1,1,1,1,1,1,1,},
{1,1,},
{1,},
{1,1,1,},
{1,1,},

	    };
	    int[][] frameCDExt = new int[][]{
	        {2,1,1,1,1,1,},
{1,1,},
{1,1,},
{1,1,1,1,1,1,1,},
{1,1,1,1,},
{1,1,1,1,1,1,1,1,1,1,1,1,1,},
{1,1,1,},
{1,1,1,1,1,1,},
{1,1,1,1,1,1,1,1,1,1,},
{1,1,1,1,1,},
{1,},
{1,1,1,1,1,},
{1,1,1,1,1,1,},
{1,},
{1,1,1,},
{1,1,1,1,1,},
{1,1,1,1,1,1,},
{1,1,1,},
{1,1,1,1,1,1,1,1,1,1,},
{1,1,1,1,1,1,1,},
{1,1,},
{1,},
{1,1,1,},
{1,1,},

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
// level trunk
//--------------------------------------------------------------------------------------------------------------

	
	
	
	// world : Level_00
	final static public String getWorld_Level_00(){
		return "Level_00";
	}
	// world width : Level_00
	final static public int getWorldW_Level_00(){
		return 320;
	}
	// world height : Level_00
	final static public int getWorldH_Level_00(){
		return 320;
	}
	

	
	
	final static public CWayPoint[] getWorldWayPoints(String Name){
	
		// World : Level_00
		if(Name=="Level_00"){
			// waypoint count : 0
			CWayPoint[] WayPoints = new CWayPoint[0];
			
			
			// waypoint link 
			
			
			return WayPoints;
		}
	

		return null;
	}

	final static public String getWorldMapType(String Name){
	
		// World : Level_00
		if(Name=="Level_00"){
			String[] MapType = new String[1];
			 MapType[0] = "Level_00";// 0 0
			
			
			return MapType[0];
		}
	

		return null;
	}

	final static public String getWorldMapName(String Name){
	
		// World : Level_00
		if(Name=="Level_00"){
			String[] MapName = new String[1];
			 MapName[0] = "M000_Level_00";// 0 0
			
			
			return MapName[0];
		}
	

		return null;
	}
	
	final static public String[] getWorldSprName(String Name){
	
		// World : Level_00
		if(Name=="Level_00"){
			String[] SprName = new String[1];
			// sprite count : 1
			 SprName[0] = "S001_Actor00";
			
			
			return SprName;
		}
	

		return null;
	}
	
	final static public String[] getWorldSprType(String Name){
	
		// World : Level_00
		if(Name=="Level_00"){
			String[] SprID = new String[1];
			// sprite count : 1
			 SprID[0] = "Actor00";
			
			
			return SprID;
		}
	

		return null;
	}
	
	final static public int[] getWorldSprAnim(String Name){
	
		// World : Level_00
		if(Name=="Level_00"){
			int[] SprAnim = new int[1];
			// sprite count : 1
			 SprAnim[0] = 0 ;
			
			
			return SprAnim;
		}
	

		return null;
	}
	
	final static public int[] getWorldSprX(String Name){
	
		// World : Level_00
		if(Name=="Level_00"){
			int[] SprX = new int[1];
			// sprite count : 1
			 SprX[0] = 15 ;
			
			
			return SprX;
		}
	

		return null;
	}
	
	final static public int[] getWorldSprY(String Name){
	
		// World : Level_00
		if(Name=="Level_00"){
			int[] SprY = new int[1];
			// sprite count : 1
			 SprY[0] = 287 ;
			
			
			return SprY;
		}
	

		return null;
	}
	



	
}




/* Encoding : 简体中文(GB2312) */
/* Cell Game Editor by WAZA Zhang */
/* Email : wazazhang@gmail.com */

//
// Cell game edit 导出脚本范例
// 
// <OUTPUT>     ResesScript.java
// 


import com.morefuntek.cell.*;
import com.morefuntek.cell.Game.*;

//--------------------------------------------------------------------------------------------------------------
// resource trunk
//--------------------------------------------------------------------------------------------------------------
public class ResesScript {

	//--------------------------------------------------------------------------------------------------------------
	// Images : SprTile
	final static public void buildClipImages_SprTile(IImages stuff){
	
		stuff.buildImages(CIO.loadImage("/SprTile.png"),96);
		
		 
		stuff.addTile(0,0,24,32);//0
		 
		stuff.addTile(24,0,24,32);//1
		 
		stuff.addTile(48,0,24,32);//2
		 
		stuff.addTile(72,0,24,32);//3
		 
		stuff.addTile(96,0,24,32);//4
		 
		stuff.addTile(120,0,24,32);//5
		 
		stuff.addTile(144,0,24,32);//6
		 
		stuff.addTile(168,0,24,32);//7
		 
		stuff.addTile(192,0,24,32);//8
		 
		stuff.addTile(216,0,24,32);//9
		 
		stuff.addTile(240,0,24,32);//10
		 
		stuff.addTile(264,0,24,32);//11
		 
		stuff.addTile(0,32,24,32);//12
		 
		stuff.addTile(24,32,24,32);//13
		 
		stuff.addTile(48,32,24,32);//14
		 
		stuff.addTile(72,32,24,32);//15
		 
		stuff.addTile(96,32,24,32);//16
		 
		stuff.addTile(120,32,24,32);//17
		 
		stuff.addTile(144,32,24,32);//18
		 
		stuff.addTile(168,32,24,32);//19
		 
		stuff.addTile(192,32,24,32);//20
		 
		stuff.addTile(216,32,24,32);//21
		 
		stuff.addTile(240,32,24,32);//22
		 
		stuff.addTile(264,32,24,32);//23
		 
		stuff.addTile(0,64,24,32);//24
		 
		stuff.addTile(24,64,24,32);//25
		 
		stuff.addTile(48,64,24,32);//26
		 
		stuff.addTile(72,64,24,32);//27
		 
		stuff.addTile(96,64,24,32);//28
		 
		stuff.addTile(120,64,24,32);//29
		 
		stuff.addTile(144,64,24,32);//30
		 
		stuff.addTile(168,64,24,32);//31
		 
		stuff.addTile(192,64,24,32);//32
		 
		stuff.addTile(216,64,24,32);//33
		 
		stuff.addTile(240,64,24,32);//34
		 
		stuff.addTile(264,64,24,32);//35
		 
		stuff.addTile(0,96,24,32);//36
		 
		stuff.addTile(24,96,24,32);//37
		 
		stuff.addTile(48,96,24,32);//38
		 
		stuff.addTile(72,96,24,32);//39
		 
		stuff.addTile(96,96,24,32);//40
		 
		stuff.addTile(120,96,24,32);//41
		 
		stuff.addTile(144,96,24,32);//42
		 
		stuff.addTile(168,96,24,32);//43
		 
		stuff.addTile(192,96,24,32);//44
		 
		stuff.addTile(216,96,24,32);//45
		 
		stuff.addTile(240,96,24,32);//46
		 
		stuff.addTile(264,96,24,32);//47
		 
		stuff.addTile(0,128,24,32);//48
		 
		stuff.addTile(24,128,24,32);//49
		 
		stuff.addTile(48,128,24,32);//50
		 
		stuff.addTile(72,128,24,32);//51
		 
		stuff.addTile(96,128,24,32);//52
		 
		stuff.addTile(120,128,24,32);//53
		 
		stuff.addTile(144,128,24,32);//54
		 
		stuff.addTile(168,128,24,32);//55
		 
		stuff.addTile(192,128,24,32);//56
		 
		stuff.addTile(216,128,24,32);//57
		 
		stuff.addTile(240,128,24,32);//58
		 
		stuff.addTile(264,128,24,32);//59
		 
		stuff.addTile(0,160,24,32);//60
		 
		stuff.addTile(24,160,24,32);//61
		 
		stuff.addTile(48,160,24,32);//62
		 
		stuff.addTile(72,160,24,32);//63
		 
		stuff.addTile(96,160,24,32);//64
		 
		stuff.addTile(120,160,24,32);//65
		 
		stuff.addTile(144,160,24,32);//66
		 
		stuff.addTile(168,160,24,32);//67
		 
		stuff.addTile(192,160,24,32);//68
		 
		stuff.addTile(216,160,24,32);//69
		 
		stuff.addTile(240,160,24,32);//70
		 
		stuff.addTile(264,160,24,32);//71
		 
		stuff.addTile(0,192,24,32);//72
		 
		stuff.addTile(24,192,24,32);//73
		 
		stuff.addTile(48,192,24,32);//74
		 
		stuff.addTile(72,192,24,32);//75
		 
		stuff.addTile(96,192,24,32);//76
		 
		stuff.addTile(120,192,24,32);//77
		 
		stuff.addTile(144,192,24,32);//78
		 
		stuff.addTile(168,192,24,32);//79
		 
		stuff.addTile(192,192,24,32);//80
		 
		stuff.addTile(216,192,24,32);//81
		 
		stuff.addTile(240,192,24,32);//82
		 
		stuff.addTile(264,192,24,32);//83
		 
		stuff.addTile(0,224,24,32);//84
		 
		stuff.addTile(24,224,24,32);//85
		 
		stuff.addTile(48,224,24,32);//86
		 
		stuff.addTile(72,224,24,32);//87
		 
		stuff.addTile(96,224,24,32);//88
		 
		stuff.addTile(120,224,24,32);//89
		 
		stuff.addTile(144,224,24,32);//90
		 
		stuff.addTile(168,224,24,32);//91
		 
		stuff.addTile(192,224,24,32);//92
		 
		stuff.addTile(216,224,24,32);//93
		 
		stuff.addTile(240,224,24,32);//94
		 
		stuff.addTile(264,224,24,32);//95
		
		
		stuff.gc();
	}
	

	//--------------------------------------------------------------------------------------------------------------
	// Sprite : Enemy00
	final static public CSprite createSprite_Enemy00(IImages tiles){

	    // tiles
	    CAnimates animates = new CAnimates(12,tiles);
	    
		animates.addPart(-12,-28,0,0);//0
		
		animates.addPart(-12,-28,1,0);//1
		
		animates.addPart(-12,-28,2,0);//2
		
		animates.addPart(-12,-28,12,0);//3
		
		animates.addPart(-12,-28,13,0);//4
		
		animates.addPart(-12,-28,14,0);//5
		
		animates.addPart(-12,-28,24,0);//6
		
		animates.addPart(-12,-28,25,0);//7
		
		animates.addPart(-12,-28,26,0);//8
		
		animates.addPart(-12,-28,36,0);//9
		
		animates.addPart(-12,-28,37,0);//10
		
		animates.addPart(-12,-28,38,0);//11
		
		
	    animates.setFrame(new int[12][]);
	    
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
		
		
		
		// cds
	    CCollides collides = new CCollides(1);
		
	    if("rect"=="rect")
	    collides.addCDRect(65535, -5, -15, 10 , 15 );//rect//0
	    if("rect"=="line")
	    collides.addCDLine(65535, -5, -15, 5, 0);//rect//0
	    
	    
	    collides.setFrame(new int[2][]);
	    
	    collides.setComboFrame(new int[]{0,},0);//0
	    
	    collides.setComboFrame(new int[]{},1);//1
	    
	    
	    
		// sprite frame
	    int[][] frameAnimate = new int[][]{
	        {0,0,1,1,2,2,1,1,},{3,3,4,4,5,5,4,4,},{6,6,7,7,8,8,7,7,},{9,9,10,10,11,11,10,10,},
	    };
	    int[][] frameCDMap = new int[][]{
	        {0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,},
	    };
	    int[][] frameCDAtk = new int[][]{
	        {1,1,1,1,1,1,1,1,},{1,1,1,1,1,1,1,1,},{1,1,1,1,1,1,1,1,},{1,1,1,1,1,1,1,1,},
	    };
	    int[][] frameCDDef = new int[][]{
	        {1,1,1,1,1,1,1,1,},{1,1,1,1,1,1,1,1,},{1,1,1,1,1,1,1,1,},{1,1,1,1,1,1,1,1,},
	    };
	    int[][] frameCDExt = new int[][]{
	        {1,1,1,1,1,1,1,1,},{1,1,1,1,1,1,1,1,},{1,1,1,1,1,1,1,1,},{1,1,1,1,1,1,1,1,},
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
	// Images : MapTile
	final static public void buildClipImages_MapTile(IImages stuff){
	
		stuff.buildImages(CIO.loadImage("/MapTile.png"),48);
		
		 
		stuff.addTile(0,0,16,16);//0
		 
		stuff.addTile(16,0,16,16);//1
		 
		stuff.addTile(32,0,16,16);//2
		 
		stuff.addTile(48,0,16,16);//3
		 
		stuff.addTile(64,0,16,16);//4
		 
		stuff.addTile(80,0,16,16);//5
		 
		stuff.addTile(0,16,16,16);//6
		 
		stuff.addTile(16,16,16,16);//7
		 
		stuff.addTile(32,16,16,16);//8
		 
		stuff.addTile(48,16,16,16);//9
		 
		stuff.addTile(64,16,16,16);//10
		 
		stuff.addTile(80,16,16,16);//11
		 
		stuff.addTile(0,32,16,16);//12
		 
		stuff.addTile(16,32,16,16);//13
		 
		stuff.addTile(32,32,16,16);//14
		 
		stuff.addTile(48,32,16,16);//15
		 
		stuff.addTile(64,32,16,16);//16
		 
		stuff.addTile(80,32,16,16);//17
		 
		stuff.addTile(0,48,16,16);//18
		 
		stuff.addTile(16,48,16,16);//19
		 
		stuff.addTile(32,48,16,16);//20
		 
		stuff.addTile(48,48,16,16);//21
		 
		stuff.addTile(64,48,16,16);//22
		 
		stuff.addTile(80,48,16,16);//23
		 
		stuff.addTile(0,64,16,16);//24
		 
		stuff.addTile(16,64,16,16);//25
		 
		stuff.addTile(32,64,16,16);//26
		 
		stuff.addTile(48,64,16,16);//27
		 
		stuff.addTile(64,64,16,16);//28
		 
		stuff.addTile(80,64,16,16);//29
		 
		stuff.addTile(0,80,16,16);//30
		 
		stuff.addTile(16,80,16,16);//31
		 
		stuff.addTile(32,80,16,16);//32
		 
		stuff.addTile(48,80,16,16);//33
		 
		stuff.addTile(64,80,16,16);//34
		 
		stuff.addTile(80,80,16,16);//35
		 
		stuff.addTile(0,96,16,16);//36
		 
		stuff.addTile(16,96,16,16);//37
		 
		stuff.addTile(32,96,16,16);//38
		 
		stuff.addTile(48,96,16,16);//39
		 
		stuff.addTile(64,96,16,16);//40
		 
		stuff.addTile(80,96,16,16);//41
		 
		stuff.addTile(0,112,16,16);//42
		 
		stuff.addTile(16,112,16,16);//43
		 
		stuff.addTile(32,112,16,16);//44
		 
		stuff.addTile(48,112,16,16);//45
		 
		stuff.addTile(64,112,16,16);//46
		 
		stuff.addTile(80,112,16,16);//47
		
		
		stuff.gc();
	}
	

	//--------------------------------------------------------------------------------------------------------------
	// Map : Map00
	final static public CMap createMap_Map00(IImages tiles,boolean isAnimate,boolean isCyc){
		
		//32 x 32
		
		// tiles
	    CAnimates animates = new CAnimates(3,tiles);
	    
		animates.addPart(0,0,2,0);//0
		
		animates.addPart(0,0,9,0);//1
		
		animates.addPart(0,0,26,0);//2
		
		
	    animates.setFrame(new int[3][]);
	    
	    animates.setComboFrame(new int[]{0,},0);//0
		
	    animates.setComboFrame(new int[]{1,},1);//1
		
	    animates.setComboFrame(new int[]{2,},2);//2
		
		
		short[][] tileMatrix = new short[][]{
			{0,1,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,2,0,0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,0,0,},{0,0,2,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,0,0,},{0,0,2,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,0,0,},{0,0,2,0,0,2,0,0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,0,0,2,0,0,},{0,0,2,0,0,2,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,0,0,2,0,0,},{0,0,2,0,0,2,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,0,0,2,0,0,},{0,0,2,0,0,2,0,0,2,0,0,2,2,2,2,2,2,2,2,2,2,2,2,2,0,0,2,0,0,2,0,0,},{0,0,2,0,0,2,0,0,2,0,0,2,0,0,0,0,0,0,0,0,0,0,0,2,0,0,2,0,0,2,0,0,},{0,0,2,0,0,2,0,0,2,0,0,2,0,0,0,0,0,0,0,0,0,0,0,2,0,0,2,0,0,2,0,0,},{0,0,2,0,0,2,0,0,2,0,0,2,0,0,2,2,2,2,2,2,2,0,0,2,0,0,2,0,0,2,0,0,},{0,0,2,0,0,2,0,0,2,0,0,2,0,0,2,0,0,0,0,0,2,0,0,2,0,0,2,0,0,2,0,0,},{0,0,2,0,0,2,0,0,2,0,0,2,0,0,2,0,0,0,0,0,2,0,0,2,0,0,2,0,0,2,0,0,},{0,0,2,0,0,2,0,0,2,0,0,2,0,0,2,0,0,2,0,0,2,0,0,2,0,0,2,0,0,2,0,0,},{0,0,2,0,0,2,0,0,2,0,0,2,0,0,2,0,0,2,0,0,2,0,0,2,0,0,2,0,0,2,0,0,},{0,0,2,0,0,2,0,0,2,0,0,2,0,0,2,0,0,2,0,0,2,0,0,2,0,0,2,0,0,2,0,0,},{0,0,2,0,0,2,0,0,2,0,0,2,0,0,2,2,2,2,0,0,2,0,0,2,0,0,2,0,0,2,0,0,},{0,0,2,0,0,2,0,0,2,0,0,2,0,0,0,0,0,0,0,0,2,0,0,2,0,0,2,0,0,2,0,0,},{0,0,2,0,0,2,0,0,2,0,0,2,0,0,0,0,0,0,0,0,2,0,0,2,0,0,2,0,0,2,0,0,},{0,0,2,0,0,2,0,0,2,0,0,2,2,2,2,2,2,2,2,2,2,0,0,2,0,0,2,0,0,2,0,0,},{0,0,2,0,0,2,0,0,2,0,0,1,0,0,0,0,0,0,0,0,0,0,0,2,0,0,2,0,0,2,0,0,},{0,0,2,0,0,2,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,0,0,2,0,0,2,0,0,},{0,0,2,0,0,2,0,0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,0,0,2,0,0,2,0,0,},{0,0,2,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,0,0,2,0,0,},{0,0,2,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,0,0,2,0,0,},{0,0,2,0,0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,0,0,2,0,0,},{0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,0,0,},{0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,0,0,},{0,0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
		};
		
		// cds
		CCollides collides = new CCollides(8);
	    
	    if("rect"=="rect")
	    collides.addCDRect(0, 0, 0, 16 , 16 );//rect//0
		if("rect"=="line")
		collides.addCDLine(0, 0, 0, 16, 16);//rect//0
		
	    if("rect"=="rect")
	    collides.addCDRect(1, 0, 0, 16 , 16 );//rect//1
		if("rect"=="line")
		collides.addCDLine(1, 0, 0, 16, 16);//rect//1
		
	    if("rect"=="rect")
	    collides.addCDRect(2, 0, 0, 16 , 1 );//rect//2
		if("rect"=="line")
		collides.addCDLine(2, 0, 0, 16, 16);//rect//2
		
	    if("rect"=="rect")
	    collides.addCDRect(4, 0, 15, 16 , 1 );//rect//3
		if("rect"=="line")
		collides.addCDLine(4, 0, 15, 16, 16);//rect//3
		
	    if("rect"=="rect")
	    collides.addCDRect(8, 0, 0, 1 , 16 );//rect//4
		if("rect"=="line")
		collides.addCDLine(8, 0, 0, 16, 16);//rect//4
		
	    if("rect"=="rect")
	    collides.addCDRect(16, 15, 0, 1 , 16 );//rect//5
		if("rect"=="line")
		collides.addCDLine(16, 15, 0, 16, 16);//rect//5
		
	    if("line"=="rect")
	    collides.addCDRect(32, 1, 1, 16 , 16 );//line//6
		if("line"=="line")
		collides.addCDLine(32, 1, 1, 15, 15);//line//6
		
	    if("line"=="rect")
	    collides.addCDRect(64, 15, 1, 16 , 16 );//line//7
		if("line"=="line")
		collides.addCDLine(64, 15, 1, 1, 15);//line//7
		

		short[][] flagMatrix = new short[][]{
			{0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,1,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,},{0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,},{0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,},{0,0,1,0,0,1,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,1,0,0,},{0,0,1,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,},{0,0,1,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,},{0,0,1,0,0,1,0,0,1,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,1,0,0,1,0,0,},{0,0,1,0,0,1,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,1,0,0,},{0,0,1,0,0,1,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,1,0,0,},{0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,1,1,1,1,1,1,0,0,1,0,0,1,0,0,1,0,0,},{0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,0,0,0,1,0,0,1,0,0,1,0,0,1,0,0,},{0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,0,0,0,1,0,0,1,0,0,1,0,0,1,0,0,},{0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,},{0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,},{0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,},{0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,1,1,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,},{0,0,1,0,0,1,0,0,1,0,0,1,0,0,0,0,0,0,0,0,1,0,0,1,0,0,1,0,0,1,0,0,},{0,0,1,0,0,1,0,0,1,0,0,1,0,0,0,0,0,0,0,0,1,0,0,1,0,0,1,0,0,1,0,0,},{0,0,1,0,0,1,0,0,1,0,0,1,1,1,1,1,1,1,1,1,1,0,0,1,0,0,1,0,0,1,0,0,},{0,0,1,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,1,0,0,},{0,0,1,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,1,0,0,},{0,0,1,0,0,1,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,1,0,0,1,0,0,},{0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,},{0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,},{0,0,1,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,1,0,0,},{0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,},{0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,},{0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
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
	// Map : unamed_Map
	final static public CMap createMap_unamed_Map(IImages tiles,boolean isAnimate,boolean isCyc){
		
		//8 x 8
		
		// tiles
	    CAnimates animates = new CAnimates(3,tiles);
	    
		animates.addPart(0,0,9,0);//0
		
		animates.addPart(0,0,26,0);//1
		
		animates.addPart(0,0,0,0);//2
		
		
	    animates.setFrame(new int[3][]);
	    
	    animates.setComboFrame(new int[]{0,},0);//0
		
	    animates.setComboFrame(new int[]{1,},1);//1
		
	    animates.setComboFrame(new int[]{2,},2);//2
		
		
		short[][] tileMatrix = new short[][]{
			{0,0,0,0,0,0,0,0,},{0,1,1,1,1,1,1,0,},{0,1,2,2,2,2,1,0,},{0,1,2,2,2,2,1,0,},{0,1,2,2,2,2,1,0,},{0,1,2,2,2,2,1,0,},{0,1,1,1,1,1,1,0,},{0,0,0,0,0,0,0,0,},
		};
		
		// cds
		CCollides collides = new CCollides(8);
	    
	    if("rect"=="rect")
	    collides.addCDRect(0, 0, 0, 16 , 16 );//rect//0
		if("rect"=="line")
		collides.addCDLine(0, 0, 0, 16, 16);//rect//0
		
	    if("rect"=="rect")
	    collides.addCDRect(1, 0, 0, 16 , 16 );//rect//1
		if("rect"=="line")
		collides.addCDLine(1, 0, 0, 16, 16);//rect//1
		
	    if("rect"=="rect")
	    collides.addCDRect(2, 0, 0, 16 , 1 );//rect//2
		if("rect"=="line")
		collides.addCDLine(2, 0, 0, 16, 16);//rect//2
		
	    if("rect"=="rect")
	    collides.addCDRect(4, 0, 15, 16 , 1 );//rect//3
		if("rect"=="line")
		collides.addCDLine(4, 0, 15, 16, 16);//rect//3
		
	    if("rect"=="rect")
	    collides.addCDRect(8, 0, 0, 1 , 16 );//rect//4
		if("rect"=="line")
		collides.addCDLine(8, 0, 0, 16, 16);//rect//4
		
	    if("rect"=="rect")
	    collides.addCDRect(16, 15, 0, 1 , 16 );//rect//5
		if("rect"=="line")
		collides.addCDLine(16, 15, 0, 16, 16);//rect//5
		
	    if("line"=="rect")
	    collides.addCDRect(32, 1, 1, 16 , 16 );//line//6
		if("line"=="line")
		collides.addCDLine(32, 1, 1, 15, 15);//line//6
		
	    if("line"=="rect")
	    collides.addCDRect(64, 15, 1, 16 , 16 );//line//7
		if("line"=="line")
		collides.addCDLine(64, 15, 1, 1, 15);//line//7
		

		short[][] flagMatrix = new short[][]{
			{0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,},
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
	// Images : GUITile
	final static public void buildClipImages_GUITile(IImages stuff){
	
		stuff.buildImages(CIO.loadImage("/GUITile.png"),2);
		
		 
		stuff.addTile(0,0,18,18);//0
		 
		stuff.addTile(0,18,18,18);//1
		
		
		stuff.gc();
	}
	

	//--------------------------------------------------------------------------------------------------------------
	// Sprite : Point
	final static public CSprite createSprite_Point(IImages tiles){

	    // tiles
	    CAnimates animates = new CAnimates(2,tiles);
	    
		animates.addPart(-9,-9,1,0);//0
		
		animates.addPart(-9,-9,0,0);//1
		
		
	    animates.setFrame(new int[3][]);
	    
	    animates.setComboFrame(new int[]{0,0,},0);//0
		
	    animates.setComboFrame(new int[]{0,},1);//1
		
	    animates.setComboFrame(new int[]{1,},2);//2
		
		
		
		// cds
	    CCollides collides = new CCollides(0);
		
	    
	    collides.setFrame(new int[1][]);
	    
	    collides.setComboFrame(new int[]{},0);//0
	    
	    
	    
		// sprite frame
	    int[][] frameAnimate = new int[][]{
	        {0,1,1,1,2,2,},
	    };
	    int[][] frameCDMap = new int[][]{
	        {0,0,0,0,0,0,},
	    };
	    int[][] frameCDAtk = new int[][]{
	        {0,0,0,0,0,0,},
	    };
	    int[][] frameCDDef = new int[][]{
	        {0,0,0,0,0,0,},
	    };
	    int[][] frameCDExt = new int[][]{
	        {0,0,0,0,0,0,},
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
	// Images : TowerTile
	final static public void buildClipImages_TowerTile(IImages stuff){
	
		stuff.buildImages(CIO.loadImage("/TowerTile.png"),1);
		
		 
		stuff.addTile(0,0,16,32);//0
		
		
		stuff.gc();
	}
	

	//--------------------------------------------------------------------------------------------------------------
	// Sprite : Tower
	final static public CSprite createSprite_Tower(IImages tiles){

	    // tiles
	    CAnimates animates = new CAnimates(1,tiles);
	    
		animates.addPart(-8,-24,0,0);//0
		
		
	    animates.setFrame(new int[1][]);
	    
	    animates.setComboFrame(new int[]{0,},0);//0
		
		
		
		// cds
	    CCollides collides = new CCollides(1);
		
	    if("rect"=="rect")
	    collides.addCDRect(65535, 0, -20, 1 , 1 );//rect//0
	    if("rect"=="line")
	    collides.addCDLine(65535, 0, -20, 1, -19);//rect//0
	    
	    
	    collides.setFrame(new int[2][]);
	    
	    collides.setComboFrame(new int[]{0,},0);//0
	    
	    collides.setComboFrame(new int[]{},1);//1
	    
	    
	    
		// sprite frame
	    int[][] frameAnimate = new int[][]{
	        {0,},
	    };
	    int[][] frameCDMap = new int[][]{
	        {0,},
	    };
	    int[][] frameCDAtk = new int[][]{
	        {1,},
	    };
	    int[][] frameCDDef = new int[][]{
	        {1,},
	    };
	    int[][] frameCDExt = new int[][]{
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
	// Images : ShootTile
	final static public void buildClipImages_ShootTile(IImages stuff){
	
		stuff.buildImages(CIO.loadImage("/ShootTile.png"),6);
		
		 
		stuff.addTile(0,0,13,13);//0
		 
		stuff.addTile(0,13,11,11);//1
		 
		stuff.addTile(0,24,17,17);//2
		 
		stuff.addTile(17,23,8,8);//3
		 
		stuff.addTile(11,13,10,10);//4
		 
		stuff.addTile(13,0,13,13);//5
		
		
		stuff.gc();
	}
	

	//--------------------------------------------------------------------------------------------------------------
	// Sprite : Shoot
	final static public CSprite createSprite_Shoot(IImages tiles){

	    // tiles
	    CAnimates animates = new CAnimates(6,tiles);
	    
		animates.addPart(-6,-6,0,0);//0
		
		animates.addPart(-5,-5,1,0);//1
		
		animates.addPart(-8,-8,2,0);//2
		
		animates.addPart(-6,-6,5,0);//3
		
		animates.addPart(-5,-5,4,0);//4
		
		animates.addPart(-4,-4,3,0);//5
		
		
	    animates.setFrame(new int[6][]);
	    
	    animates.setComboFrame(new int[]{0,},0);//0
		
	    animates.setComboFrame(new int[]{1,},1);//1
		
	    animates.setComboFrame(new int[]{2,},2);//2
		
	    animates.setComboFrame(new int[]{3,},3);//3
		
	    animates.setComboFrame(new int[]{4,},4);//4
		
	    animates.setComboFrame(new int[]{5,},5);//5
		
		
		
		// cds
	    CCollides collides = new CCollides(1);
		
	    if("rect"=="rect")
	    collides.addCDRect(65535, -5, -5, 11 , 11 );//rect//0
	    if("rect"=="line")
	    collides.addCDLine(65535, -5, -5, 6, 6);//rect//0
	    
	    
	    collides.setFrame(new int[2][]);
	    
	    collides.setComboFrame(new int[]{0,},0);//0
	    
	    collides.setComboFrame(new int[]{},1);//1
	    
	    
	    
		// sprite frame
	    int[][] frameAnimate = new int[][]{
	        {0,1,},{2,3,4,5,},
	    };
	    int[][] frameCDMap = new int[][]{
	        {0,0,},{1,1,1,1,},
	    };
	    int[][] frameCDAtk = new int[][]{
	        {1,1,},{1,1,1,1,},
	    };
	    int[][] frameCDDef = new int[][]{
	        {1,1,},{1,1,1,1,},
	    };
	    int[][] frameCDExt = new int[][]{
	        {1,1,},{1,1,1,1,},
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
	

}

//--------------------------------------------------------------------------------------------------------------
// level trunk
//--------------------------------------------------------------------------------------------------------------

	//--------------------------------------------------------------------------------------------------------------
	// World : Level00
	class world_Level00 extends CWorld{
	
		// map count : 1
		 
		public CMap Map0000_Map00;//0 0 0
		
		
		// sprite count : 0
		
		
		public void initPath()
		{
			WayPoints = new CWayPoint[21];
			
			 
			 WayPoints[0] = new CWayPoint(40,8);
			 
			 WayPoints[1] = new CWayPoint(40,472);
			 
			 WayPoints[2] = new CWayPoint(472,472);
			 
			 WayPoints[3] = new CWayPoint(472,40);
			 
			 WayPoints[4] = new CWayPoint(88,40);
			 
			 WayPoints[5] = new CWayPoint(88,424);
			 
			 WayPoints[6] = new CWayPoint(424,424);
			 
			 WayPoints[7] = new CWayPoint(424,88);
			 
			 WayPoints[8] = new CWayPoint(136,88);
			 
			 WayPoints[9] = new CWayPoint(136,376);
			 
			 WayPoints[10] = new CWayPoint(376,376);
			 
			 WayPoints[11] = new CWayPoint(376,136);
			 
			 WayPoints[12] = new CWayPoint(184,136);
			 
			 WayPoints[13] = new CWayPoint(184,328);
			 
			 WayPoints[14] = new CWayPoint(328,328);
			 
			 WayPoints[15] = new CWayPoint(328,184);
			 
			 WayPoints[16] = new CWayPoint(232,184);
			 
			 WayPoints[17] = new CWayPoint(232,280);
			 
			 WayPoints[18] = new CWayPoint(280,280);
			 
			 WayPoints[19] = new CWayPoint(280,232);
			 
			 WayPoints[20] = new CWayPoint(264,232);
			
		
			
			 WayPoints[0].link(WayPoints[1]);//0
			
			 WayPoints[1].link(WayPoints[0]);//1
			
			 WayPoints[1].link(WayPoints[2]);//2
			
			 WayPoints[2].link(WayPoints[1]);//3
			
			 WayPoints[2].link(WayPoints[3]);//4
			
			 WayPoints[3].link(WayPoints[2]);//5
			
			 WayPoints[3].link(WayPoints[4]);//6
			
			 WayPoints[4].link(WayPoints[3]);//7
			
			 WayPoints[4].link(WayPoints[5]);//8
			
			 WayPoints[5].link(WayPoints[4]);//9
			
			 WayPoints[5].link(WayPoints[6]);//10
			
			 WayPoints[6].link(WayPoints[5]);//11
			
			 WayPoints[6].link(WayPoints[7]);//12
			
			 WayPoints[7].link(WayPoints[6]);//13
			
			 WayPoints[7].link(WayPoints[8]);//14
			
			 WayPoints[8].link(WayPoints[7]);//15
			
			 WayPoints[8].link(WayPoints[9]);//16
			
			 WayPoints[9].link(WayPoints[8]);//17
			
			 WayPoints[9].link(WayPoints[10]);//18
			
			 WayPoints[10].link(WayPoints[9]);//19
			
			 WayPoints[10].link(WayPoints[11]);//20
			
			 WayPoints[11].link(WayPoints[10]);//21
			
			 WayPoints[11].link(WayPoints[12]);//22
			
			 WayPoints[12].link(WayPoints[11]);//23
			
			 WayPoints[12].link(WayPoints[13]);//24
			
			 WayPoints[13].link(WayPoints[14]);//25
			
			 WayPoints[13].link(WayPoints[12]);//26
			
			 WayPoints[14].link(WayPoints[13]);//27
			
			 WayPoints[14].link(WayPoints[15]);//28
			
			 WayPoints[15].link(WayPoints[14]);//29
			
			 WayPoints[15].link(WayPoints[16]);//30
			
			 WayPoints[16].link(WayPoints[15]);//31
			
			 WayPoints[16].link(WayPoints[17]);//32
			
			 WayPoints[17].link(WayPoints[16]);//33
			
			 WayPoints[17].link(WayPoints[18]);//34
			
			 WayPoints[18].link(WayPoints[17]);//35
			
			 WayPoints[18].link(WayPoints[19]);//36
			
			 WayPoints[19].link(WayPoints[18]);//37
			
			 WayPoints[19].link(WayPoints[20]);//38
			
			 WayPoints[20].link(WayPoints[19]);//39
			
		}
		public void initUnit()
		{
			 
			addMap(Map0000_Map00);
			

			
		}

	
	
	}
	

	//--------------------------------------------------------------------------------------------------------------
	// World : unamed_Level
	class world_unamed_Level extends CWorld{
	
		// map count : 1
		 
		public CMap Map0000_unamed_Map;//0 0 0
		
		
		// sprite count : 0
		
		
		public void initPath()
		{
			WayPoints = new CWayPoint[3];
			
			 
			 WayPoints[0] = new CWayPoint(216,200);
			 
			 WayPoints[1] = new CWayPoint(72,248);
			 
			 WayPoints[2] = new CWayPoint(216,248);
			
		
			
			 WayPoints[0].link(WayPoints[1]);//0
			
			 WayPoints[0].link(WayPoints[2]);//1
			
			 WayPoints[1].link(WayPoints[0]);//2
			
			 WayPoints[2].link(WayPoints[0]);//3
			
		}
		public void initUnit()
		{
			 
			addMap(Map0000_unamed_Map);
			

			
		}

	
	
	}
	






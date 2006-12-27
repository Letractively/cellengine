/* Encoding : 简体中文(GB2312) */
/* Cell Game Editor by WAZA Zhang */

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
	// Images : unamed_Tile
	final static public void buildClipImages_unamed_Tile(IImages stuff){
	
		stuff.buildImages(CIO.loadImage("/unamed_Tile.png"),64);
		
		 
		stuff.addTile(0,0,16,16);//0
		 
		stuff.addTile(16,0,16,16);//1
		 
		stuff.addTile(32,0,16,16);//2
		 
		stuff.addTile(48,0,16,16);//3
		 
		stuff.addTile(64,0,16,16);//4
		 
		stuff.addTile(80,0,16,16);//5
		 
		stuff.addTile(96,0,16,16);//6
		 
		stuff.addTile(112,0,16,16);//7
		 
		stuff.addTile(0,16,16,16);//8
		 
		stuff.addTile(16,16,16,16);//9
		 
		stuff.addTile(32,16,16,16);//10
		 
		stuff.addTile(48,16,16,16);//11
		 
		stuff.addTile(64,16,16,16);//12
		 
		stuff.addTile(80,16,16,16);//13
		 
		stuff.addTile(96,16,16,16);//14
		 
		stuff.addTile(112,16,16,16);//15
		 
		stuff.addTile(0,32,16,16);//16
		 
		stuff.addTile(16,32,16,16);//17
		 
		stuff.addTile(32,32,16,16);//18
		 
		stuff.addTile(48,32,16,16);//19
		 
		stuff.addTile(64,32,16,16);//20
		 
		stuff.addTile(80,32,16,16);//21
		 
		stuff.addTile(96,32,16,16);//22
		 
		stuff.addTile(112,32,16,16);//23
		 
		stuff.addTile(0,48,16,16);//24
		 
		stuff.addTile(16,48,16,16);//25
		 
		stuff.addTile(32,48,16,16);//26
		 
		stuff.addTile(48,48,16,16);//27
		 
		stuff.addTile(64,48,16,16);//28
		 
		stuff.addTile(80,48,16,16);//29
		 
		stuff.addTile(96,48,16,16);//30
		 
		stuff.addTile(112,48,16,16);//31
		 
		stuff.addTile(0,64,16,16);//32
		 
		stuff.addTile(16,64,16,16);//33
		 
		stuff.addTile(32,64,16,16);//34
		 
		stuff.addTile(48,64,16,16);//35
		 
		stuff.addTile(64,64,16,16);//36
		 
		stuff.addTile(80,64,16,16);//37
		 
		stuff.addTile(96,64,16,16);//38
		 
		stuff.addTile(112,64,16,16);//39
		 
		stuff.addTile(0,80,16,16);//40
		 
		stuff.addTile(16,80,16,16);//41
		 
		stuff.addTile(32,80,16,16);//42
		 
		stuff.addTile(48,80,16,16);//43
		 
		stuff.addTile(64,80,16,16);//44
		 
		stuff.addTile(80,80,16,16);//45
		 
		stuff.addTile(96,80,16,16);//46
		 
		stuff.addTile(112,80,16,16);//47
		 
		stuff.addTile(0,96,16,16);//48
		 
		stuff.addTile(16,96,16,16);//49
		 
		stuff.addTile(32,96,16,16);//50
		 
		stuff.addTile(48,96,16,16);//51
		 
		stuff.addTile(64,96,16,16);//52
		 
		stuff.addTile(80,96,16,16);//53
		 
		stuff.addTile(96,96,16,16);//54
		 
		stuff.addTile(112,96,16,16);//55
		 
		stuff.addTile(0,112,16,16);//56
		 
		stuff.addTile(16,112,16,16);//57
		 
		stuff.addTile(32,112,16,16);//58
		 
		stuff.addTile(48,112,16,16);//59
		 
		stuff.addTile(64,112,16,16);//60
		 
		stuff.addTile(80,112,16,16);//61
		 
		stuff.addTile(96,112,16,16);//62
		 
		stuff.addTile(112,112,16,16);//63
		
		
		stuff.gc();
	}
	

	//--------------------------------------------------------------------------------------------------------------
	// Map : m1
	final static public CMap createMap_m1(IImages tiles,boolean isAnimate,boolean isCyc){
		
		//32 x 32
		
		// tiles
	    CAnimates animates = new CAnimates(5,tiles);
	    
		animates.addPart(0,0,0,2);//0
		
		animates.addPart(0,0,0,0);//1
		
		animates.addPart(0,0,50,2);//2
		
		animates.addPart(0,0,16,2);//3
		
		animates.addPart(0,0,48,2);//4
		
		
	    animates.setFrame(new int[5][]);
	    
	    animates.setComboFrame(new int[]{0,},0);//0
		
	    animates.setComboFrame(new int[]{1,},1);//1
		
	    animates.setComboFrame(new int[]{2,},2);//2
		
	    animates.setComboFrame(new int[]{3,},3);//3
		
	    animates.setComboFrame(new int[]{4,},4);//4
		
		
		short[][] tileMatrix = new short[][]{
			{0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,},{0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,0,0,},{0,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3,0,0,},{0,0,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,0,0,3,0,0,},{0,0,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3,0,0,3,0,0,},{0,0,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,4,0,0,0,3,0,0,3,0,0,},{0,0,3,0,0,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,0,0,3,0,0,3,0,0,},{0,0,3,0,0,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3,0,0,3,0,0,3,0,0,},{0,0,3,0,0,3,0,0,0,4,0,0,0,0,0,0,0,0,0,0,0,0,0,3,0,0,3,0,0,3,0,0,},{0,0,3,0,0,3,0,0,3,3,3,3,3,3,3,3,3,3,3,3,3,0,0,3,0,0,3,0,0,3,0,0,},{0,0,3,0,0,3,0,0,3,0,0,0,0,0,0,0,0,0,0,0,3,0,0,3,0,0,3,0,0,3,0,0,},{0,0,3,0,0,3,0,0,3,0,0,0,0,0,0,0,0,0,0,0,3,0,0,3,0,0,3,0,0,3,0,0,},{0,0,3,0,0,3,0,0,3,0,0,3,3,3,3,3,3,3,0,0,3,0,0,3,0,0,3,0,0,3,0,0,},{0,0,3,4,0,3,0,0,3,0,0,3,0,0,0,0,0,3,0,0,3,0,0,3,0,0,3,0,0,3,0,2,},{0,0,3,0,0,3,0,0,3,0,0,3,0,0,2,0,0,3,0,0,3,0,0,3,0,0,3,0,0,3,0,0,},{0,0,3,0,0,3,0,0,3,0,0,3,0,0,3,3,3,3,0,0,3,0,0,3,0,0,3,0,0,3,0,0,},{0,0,3,0,0,3,0,0,3,0,0,3,0,0,0,0,0,0,0,0,3,4,0,3,0,0,3,0,0,3,0,0,},{0,0,3,0,0,3,0,0,3,0,0,3,0,0,0,0,0,0,0,0,3,0,0,3,0,0,3,0,0,3,0,0,},{1,1,3,0,0,3,0,0,3,4,0,3,3,3,3,3,3,3,3,3,3,0,0,3,0,0,3,0,0,3,0,0,},{1,1,3,0,0,3,0,0,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3,0,0,3,0,0,3,0,0,},{1,1,3,0,0,3,0,0,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3,0,0,3,0,0,3,1,1,},{1,1,3,0,0,3,0,0,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,0,0,3,0,0,3,1,1,},{1,1,3,0,0,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3,0,0,3,1,1,},{1,1,3,0,0,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3,0,0,3,1,1,},{1,1,3,0,0,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,0,0,3,1,1,},{1,1,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,4,0,0,0,0,3,1,1,},{1,1,3,1,1,1,1,1,4,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3,1,1,},{1,1,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,1,1,},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,4,1,1,1,1,1,1,1,1,1,1,},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,},
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
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
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
	// Images : unamed_Tile2
	final static public void buildClipImages_unamed_Tile2(IImages stuff){
	
		stuff.buildImages(CIO.loadImage("/unamed_Tile2.png"),16);
		
		 
		stuff.addTile(32,0,32,48);//0
		 
		stuff.addTile(0,0,32,48);//1
		 
		stuff.addTile(64,0,32,48);//2
		 
		stuff.addTile(96,0,32,48);//3
		 
		stuff.addTile(0,48,32,48);//4
		 
		stuff.addTile(32,48,32,48);//5
		 
		stuff.addTile(64,48,32,48);//6
		 
		stuff.addTile(96,48,32,48);//7
		 
		stuff.addTile(0,96,32,48);//8
		 
		stuff.addTile(32,96,32,48);//9
		 
		stuff.addTile(64,96,32,48);//10
		 
		stuff.addTile(96,96,32,48);//11
		 
		stuff.addTile(0,144,32,48);//12
		 
		stuff.addTile(32,144,32,48);//13
		 
		stuff.addTile(64,144,32,48);//14
		 
		stuff.addTile(96,144,32,48);//15
		
		
		stuff.gc();
	}
	

	//--------------------------------------------------------------------------------------------------------------
	// Sprite : unamed_Sprite
	final static public CSprite createSprite_unamed_Sprite(IImages tiles){

	    // tiles
	    CAnimates animates = new CAnimates(2,tiles);
	    
		animates.addPart(-16,-24,0,0);//0
		
		animates.addPart(-16,-24,1,0);//1
		
		
	    animates.setFrame(new int[2][]);
	    
	    animates.setComboFrame(new int[]{0,},0);//0
		
	    animates.setComboFrame(new int[]{1,},1);//1
		
		
		
		// cds
	    CCollides collides = new CCollides(0);
		
	    
	    collides.setFrame(new int[1][]);
	    
	    collides.setComboFrame(new int[]{},0);//0
	    
	    
	    
		// sprite frame
	    int[][] frameAnimate = new int[][]{
	        {0,1,},
	    };
	    int[][] frameCDMap = new int[][]{
	        {0,0,},
	    };
	    int[][] frameCDAtk = new int[][]{
	        {0,0,},
	    };
	    int[][] frameCDDef = new int[][]{
	        {0,0,},
	    };
	    int[][] frameCDExt = new int[][]{
	        {0,0,},
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
	// Sprite : unamed_Sprite2
	final static public CSprite createSprite_unamed_Sprite2(IImages tiles){

	    // tiles
	    CAnimates animates = new CAnimates(22,tiles);
	    
		animates.addPart(-16,-24,0,0);//0
		
		animates.addPart(-16,-24,1,0);//1
		
		animates.addPart(-16,-24,2,0);//2
		
		animates.addPart(-16,-24,3,0);//3
		
		animates.addPart(-16,-24,4,0);//4
		
		animates.addPart(-16,-24,5,0);//5
		
		animates.addPart(-16,-24,6,0);//6
		
		animates.addPart(-16,-24,7,0);//7
		
		animates.addPart(-16,-24,8,0);//8
		
		animates.addPart(-16,-24,9,0);//9
		
		animates.addPart(-16,-24,10,0);//10
		
		animates.addPart(-16,-24,11,0);//11
		
		animates.addPart(-16,-24,12,0);//12
		
		animates.addPart(-16,-24,13,0);//13
		
		animates.addPart(-16,-24,14,0);//14
		
		animates.addPart(-16,-24,15,0);//15
		
		animates.addPart(10,-24,0,0);//16
		
		animates.addPart(-40,-24,0,0);//17
		
		animates.addPart(-10,-24,0,3);//18
		
		animates.addPart(10,-24,0,6);//19
		
		animates.addPart(10,-24,0,7);//20
		
		animates.addPart(-40,-24,0,6);//21
		
		
	    animates.setFrame(new int[19][]);
	    
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
		
	    animates.setComboFrame(new int[]{20,21,},17);//17
		
	    animates.setComboFrame(new int[]{},18);//18
		
		
		
		// cds
	    CCollides collides = new CCollides(5);
		
	    if("rect"=="rect")
	    collides.addCDRect(65535, -7, 13, 14 , 10 );//rect//0
	    if("rect"=="line")
	    collides.addCDLine(65535, -7, 13, 7, 23);//rect//0
	    
	    if("rect"=="rect")
	    collides.addCDRect(65535, -16, 1, 32 , 48 );//rect//1
	    if("rect"=="line")
	    collides.addCDLine(65535, -16, 1, 16, 49);//rect//1
	    
	    if("rect"=="rect")
	    collides.addCDRect(65535, -16, -64, 32 , 48 );//rect//2
	    if("rect"=="line")
	    collides.addCDLine(65535, -16, -64, 16, -16);//rect//2
	    
	    if("rect"=="rect")
	    collides.addCDRect(65535, -37, 1, 32 , 48 );//rect//3
	    if("rect"=="line")
	    collides.addCDLine(65535, -37, 1, -5, 49);//rect//3
	    
	    if("rect"=="rect")
	    collides.addCDRect(65535, 10, -58, 32 , 48 );//rect//4
	    if("rect"=="line")
	    collides.addCDLine(65535, 10, -58, 42, -10);//rect//4
	    
	    
	    collides.setFrame(new int[6][]);
	    
	    collides.setComboFrame(new int[]{0,},0);//0
	    
	    collides.setComboFrame(new int[]{},1);//1
	    
	    collides.setComboFrame(new int[]{2,},2);//2
	    
	    collides.setComboFrame(new int[]{1,},3);//3
	    
	    collides.setComboFrame(new int[]{4,},4);//4
	    
	    collides.setComboFrame(new int[]{3,},5);//5
	    
	    
	    
		// sprite frame
	    int[][] frameAnimate = new int[][]{
	        {0,1,2,3,},{4,5,6,7,},{8,9,10,11,},{12,13,14,15,},{16,17,18,},
	    };
	    int[][] frameCDMap = new int[][]{
	        {0,0,0,0,},{0,0,0,0,},{0,0,0,0,},{0,0,0,0,},{2,4,1,},
	    };
	    int[][] frameCDAtk = new int[][]{
	        {1,1,1,1,},{1,1,1,1,},{1,1,1,1,},{1,1,1,1,},{3,5,1,},
	    };
	    int[][] frameCDDef = new int[][]{
	        {1,1,1,1,},{1,1,1,1,},{1,1,1,1,},{1,1,1,1,},{1,1,1,},
	    };
	    int[][] frameCDExt = new int[][]{
	        {1,1,1,1,},{1,1,1,1,},{1,1,1,1,},{1,1,1,1,},{1,1,1,},
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
	// Sprite : unamed_Sprite3
	final static public CSprite createSprite_unamed_Sprite3(IImages tiles){

	    // tiles
	    CAnimates animates = new CAnimates(1,tiles);
	    
		animates.addPart(-16,-42,0,0);//0
		
		
	    animates.setFrame(new int[1][]);
	    
	    animates.setComboFrame(new int[]{0,},0);//0
		
		
		
		// cds
	    CCollides collides = new CCollides(1);
		
	    if("rect"=="rect")
	    collides.addCDRect(65535, -18, -24, 35 , 36 );//rect//0
	    if("rect"=="line")
	    collides.addCDLine(65535, -18, -24, 17, 12);//rect//0
	    
	    
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
	// Images : PapaBeanTile
	final static public void buildClipImages_PapaBeanTile(IImages stuff){
	
		stuff.buildImages(CIO.loadImage("/PapaBeanTile.png"),14);
		
		 
		stuff.addTile(0,0,30,28);//0
		 
		stuff.addTile(0,28,30,28);//1
		 
		stuff.addTile(0,56,30,28);//2
		 
		stuff.addTile(0,84,30,28);//3
		 
		stuff.addTile(0,112,30,28);//4
		 
		stuff.addTile(0,140,30,28);//5
		 
		stuff.addTile(0,168,30,28);//6
		 
		stuff.addTile(0,196,30,28);//7
		 
		stuff.addTile(0,224,18,25);//8
		 
		stuff.addTile(0,249,19,31);//9
		 
		stuff.addTile(0,280,19,32);//10
		 
		stuff.addTile(0,312,21,30);//11
		 
		stuff.addTile(0,342,28,28);//12
		 
		stuff.addTile(0,370,28,28);//13
		
		
		stuff.gc();
	}
	

	//--------------------------------------------------------------------------------------------------------------
	// Sprite : baby
	final static public CSprite createSprite_baby(IImages tiles){

	    // tiles
	    CAnimates animates = new CAnimates(16,tiles);
	    
		animates.addPart(-15,-14,0,0);//0
		
		animates.addPart(-15,-14,1,0);//1
		
		animates.addPart(-15,-14,2,0);//2
		
		animates.addPart(-15,-14,3,0);//3
		
		animates.addPart(-15,-14,4,0);//4
		
		animates.addPart(-15,-14,5,0);//5
		
		animates.addPart(-15,-14,6,0);//6
		
		animates.addPart(-15,-14,7,0);//7
		
		animates.addPart(-14,-14,12,0);//8
		
		animates.addPart(-14,-14,13,0);//9
		
		animates.addPart(-14,-14,12,6);//10
		
		animates.addPart(-14,-14,13,6);//11
		
		animates.addPart(-14,-14,12,3);//12
		
		animates.addPart(-14,-14,13,3);//13
		
		animates.addPart(-14,-14,12,5);//14
		
		animates.addPart(-14,-14,13,5);//15
		
		
	    animates.setFrame(new int[16][]);
	    
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
		
		
		
		// cds
	    CCollides collides = new CCollides(1);
		
	    if("rect"=="rect")
	    collides.addCDRect(65535, -8, -10, 12 , 23 );//rect//0
	    if("rect"=="line")
	    collides.addCDLine(65535, -8, -10, 4, 13);//rect//0
	    
	    
	    collides.setFrame(new int[2][]);
	    
	    collides.setComboFrame(new int[]{0,},0);//0
	    
	    collides.setComboFrame(new int[]{},1);//1
	    
	    
	    
		// sprite frame
	    int[][] frameAnimate = new int[][]{
	        {0,1,2,3,4,5,6,7,},{8,9,10,11,12,13,14,15,},
	    };
	    int[][] frameCDMap = new int[][]{
	        {0,0,0,0,0,0,0,0,},{1,1,1,1,1,1,1,1,},
	    };
	    int[][] frameCDAtk = new int[][]{
	        {1,1,1,1,1,1,1,1,},{1,1,1,1,1,1,1,1,},
	    };
	    int[][] frameCDDef = new int[][]{
	        {1,1,1,1,1,1,1,1,},{1,1,1,1,1,1,1,1,},
	    };
	    int[][] frameCDExt = new int[][]{
	        {1,1,1,1,1,1,1,1,},{1,1,1,1,1,1,1,1,},
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
	// Images : BabyMap
	final static public void buildClipImages_BabyMap(IImages stuff){
	
		stuff.buildImages(CIO.loadImage("/BabyMap.png"),29);
		
		 
		stuff.addTile(0,160,16,16);//0
		 
		stuff.addTile(0,0,16,16);//1
		 
		stuff.addTile(16,0,16,16);//2
		 
		stuff.addTile(0,16,16,16);//3
		 
		stuff.addTile(16,16,16,16);//4
		 
		stuff.addTile(0,48,16,16);//5
		 
		stuff.addTile(16,48,16,16);//6
		 
		stuff.addTile(0,32,16,16);//7
		 
		stuff.addTile(16,32,16,16);//8
		 
		stuff.addTile(16,80,16,16);//9
		 
		stuff.addTile(0,80,16,16);//10
		 
		stuff.addTile(0,64,16,16);//11
		 
		stuff.addTile(16,64,16,16);//12
		 
		stuff.addTile(0,112,16,16);//13
		 
		stuff.addTile(16,112,16,16);//14
		 
		stuff.addTile(0,96,16,16);//15
		 
		stuff.addTile(16,96,16,16);//16
		 
		stuff.addTile(0,144,16,16);//17
		 
		stuff.addTile(16,144,16,16);//18
		 
		stuff.addTile(0,128,16,16);//19
		 
		stuff.addTile(16,128,16,16);//20
		 
		stuff.addTile(16,208,16,16);//21
		 
		stuff.addTile(0,208,16,16);//22
		 
		stuff.addTile(16,224,16,16);//23
		 
		stuff.addTile(0,224,16,16);//24
		 
		stuff.addTile(0,176,16,16);//25
		 
		stuff.addTile(16,176,16,16);//26
		 
		stuff.addTile(0,192,16,16);//27
		 
		stuff.addTile(16,192,16,16);//28
		
		
		stuff.gc();
	}
	

	//--------------------------------------------------------------------------------------------------------------
	// Map : unamed_Map
	final static public CMap createMap_unamed_Map(IImages tiles,boolean isAnimate,boolean isCyc){
		
		//32 x 16
		
		// tiles
	    CAnimates animates = new CAnimates(5,tiles);
	    
		animates.addPart(0,0,0,0);//0
		
		animates.addPart(0,0,1,0);//1
		
		animates.addPart(0,0,2,0);//2
		
		animates.addPart(0,0,3,0);//3
		
		animates.addPart(0,0,4,0);//4
		
		
	    animates.setFrame(new int[5][]);
	    
	    animates.setComboFrame(new int[]{0,},0);//0
		
	    animates.setComboFrame(new int[]{1,},1);//1
		
	    animates.setComboFrame(new int[]{2,},2);//2
		
	    animates.setComboFrame(new int[]{3,},3);//3
		
	    animates.setComboFrame(new int[]{4,},4);//4
		
		
		short[][] tileMatrix = new short[][]{
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,1,2,0,0,0,0,0,0,0,0,0,0,1,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,3,4,0,0,0,0,0,0,0,0,0,0,3,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3,4,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,0,0,0,},{0,0,0,0,0,0,0,1,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3,4,0,0,0,},{0,0,0,0,0,0,0,3,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
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
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
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
	// Images : boss
	final static public void buildClipImages_boss(IImages stuff){
	
		stuff.buildImages(CIO.loadImage("/boss.png"),143);
		
		 
		stuff.addTile(0,0,16,16);//0
		 
		stuff.addTile(16,0,16,16);//1
		 
		stuff.addTile(32,0,16,16);//2
		 
		stuff.addTile(48,0,16,16);//3
		 
		stuff.addTile(64,0,16,16);//4
		 
		stuff.addTile(80,0,16,16);//5
		 
		stuff.addTile(96,0,16,16);//6
		 
		stuff.addTile(112,0,16,16);//7
		 
		stuff.addTile(128,0,16,16);//8
		 
		stuff.addTile(144,0,16,16);//9
		 
		stuff.addTile(160,0,16,16);//10
		 
		stuff.addTile(0,16,16,16);//11
		 
		stuff.addTile(16,16,16,16);//12
		 
		stuff.addTile(32,16,16,16);//13
		 
		stuff.addTile(48,16,16,16);//14
		 
		stuff.addTile(64,16,16,16);//15
		 
		stuff.addTile(80,16,16,16);//16
		 
		stuff.addTile(96,16,16,16);//17
		 
		stuff.addTile(112,16,16,16);//18
		 
		stuff.addTile(128,16,16,16);//19
		 
		stuff.addTile(144,16,16,16);//20
		 
		stuff.addTile(160,16,16,16);//21
		 
		stuff.addTile(0,32,16,16);//22
		 
		stuff.addTile(16,32,16,16);//23
		 
		stuff.addTile(32,32,16,16);//24
		 
		stuff.addTile(48,32,16,16);//25
		 
		stuff.addTile(64,32,16,16);//26
		 
		stuff.addTile(80,32,16,16);//27
		 
		stuff.addTile(96,32,16,16);//28
		 
		stuff.addTile(112,32,16,16);//29
		 
		stuff.addTile(128,32,16,16);//30
		 
		stuff.addTile(144,32,16,16);//31
		 
		stuff.addTile(160,32,16,16);//32
		 
		stuff.addTile(0,48,16,16);//33
		 
		stuff.addTile(16,48,16,16);//34
		 
		stuff.addTile(32,48,16,16);//35
		 
		stuff.addTile(48,48,16,16);//36
		 
		stuff.addTile(64,48,16,16);//37
		 
		stuff.addTile(80,48,16,16);//38
		 
		stuff.addTile(96,48,16,16);//39
		 
		stuff.addTile(112,48,16,16);//40
		 
		stuff.addTile(128,48,16,16);//41
		 
		stuff.addTile(144,48,16,16);//42
		 
		stuff.addTile(160,48,16,16);//43
		 
		stuff.addTile(0,64,16,16);//44
		 
		stuff.addTile(16,64,16,16);//45
		 
		stuff.addTile(32,64,16,16);//46
		 
		stuff.addTile(48,64,16,16);//47
		 
		stuff.addTile(64,64,16,16);//48
		 
		stuff.addTile(80,64,16,16);//49
		 
		stuff.addTile(96,64,16,16);//50
		 
		stuff.addTile(112,64,16,16);//51
		 
		stuff.addTile(128,64,16,16);//52
		 
		stuff.addTile(144,64,16,16);//53
		 
		stuff.addTile(160,64,16,16);//54
		 
		stuff.addTile(0,80,16,16);//55
		 
		stuff.addTile(16,80,16,16);//56
		 
		stuff.addTile(32,80,16,16);//57
		 
		stuff.addTile(48,80,16,16);//58
		 
		stuff.addTile(64,80,16,16);//59
		 
		stuff.addTile(80,80,16,16);//60
		 
		stuff.addTile(96,80,16,16);//61
		 
		stuff.addTile(112,80,16,16);//62
		 
		stuff.addTile(128,80,16,16);//63
		 
		stuff.addTile(144,80,16,16);//64
		 
		stuff.addTile(160,80,16,16);//65
		 
		stuff.addTile(0,96,16,16);//66
		 
		stuff.addTile(16,96,16,16);//67
		 
		stuff.addTile(32,96,16,16);//68
		 
		stuff.addTile(48,96,16,16);//69
		 
		stuff.addTile(64,96,16,16);//70
		 
		stuff.addTile(80,96,16,16);//71
		 
		stuff.addTile(96,96,16,16);//72
		 
		stuff.addTile(112,96,16,16);//73
		 
		stuff.addTile(128,96,16,16);//74
		 
		stuff.addTile(144,96,16,16);//75
		 
		stuff.addTile(160,96,16,16);//76
		 
		stuff.addTile(0,112,16,16);//77
		 
		stuff.addTile(16,112,16,16);//78
		 
		stuff.addTile(32,112,16,16);//79
		 
		stuff.addTile(48,112,16,16);//80
		 
		stuff.addTile(64,112,16,16);//81
		 
		stuff.addTile(80,112,16,16);//82
		 
		stuff.addTile(96,112,16,16);//83
		 
		stuff.addTile(112,112,16,16);//84
		 
		stuff.addTile(128,112,16,16);//85
		 
		stuff.addTile(144,112,16,16);//86
		 
		stuff.addTile(160,112,16,16);//87
		 
		stuff.addTile(0,128,16,16);//88
		 
		stuff.addTile(16,128,16,16);//89
		 
		stuff.addTile(32,128,16,16);//90
		 
		stuff.addTile(48,128,16,16);//91
		 
		stuff.addTile(64,128,16,16);//92
		 
		stuff.addTile(80,128,16,16);//93
		 
		stuff.addTile(96,128,16,16);//94
		 
		stuff.addTile(112,128,16,16);//95
		 
		stuff.addTile(128,128,16,16);//96
		 
		stuff.addTile(144,128,16,16);//97
		 
		stuff.addTile(160,128,16,16);//98
		 
		stuff.addTile(0,144,16,16);//99
		 
		stuff.addTile(16,144,16,16);//100
		 
		stuff.addTile(32,144,16,16);//101
		 
		stuff.addTile(48,144,16,16);//102
		 
		stuff.addTile(64,144,16,16);//103
		 
		stuff.addTile(80,144,16,16);//104
		 
		stuff.addTile(96,144,16,16);//105
		 
		stuff.addTile(112,144,16,16);//106
		 
		stuff.addTile(128,144,16,16);//107
		 
		stuff.addTile(144,144,16,16);//108
		 
		stuff.addTile(160,144,16,16);//109
		 
		stuff.addTile(0,160,16,16);//110
		 
		stuff.addTile(16,160,16,16);//111
		 
		stuff.addTile(32,160,16,16);//112
		 
		stuff.addTile(48,160,16,16);//113
		 
		stuff.addTile(64,160,16,16);//114
		 
		stuff.addTile(80,160,16,16);//115
		 
		stuff.addTile(96,160,16,16);//116
		 
		stuff.addTile(112,160,16,16);//117
		 
		stuff.addTile(128,160,16,16);//118
		 
		stuff.addTile(144,160,16,16);//119
		 
		stuff.addTile(160,160,16,16);//120
		 
		stuff.addTile(0,176,16,16);//121
		 
		stuff.addTile(16,176,16,16);//122
		 
		stuff.addTile(32,176,16,16);//123
		 
		stuff.addTile(48,176,16,16);//124
		 
		stuff.addTile(64,176,16,16);//125
		 
		stuff.addTile(80,176,16,16);//126
		 
		stuff.addTile(96,176,16,16);//127
		 
		stuff.addTile(112,176,16,16);//128
		 
		stuff.addTile(128,176,16,16);//129
		 
		stuff.addTile(144,176,16,16);//130
		 
		stuff.addTile(160,176,16,16);//131
		 
		stuff.addTile(0,192,16,16);//132
		 
		stuff.addTile(16,192,16,16);//133
		 
		stuff.addTile(32,192,16,16);//134
		 
		stuff.addTile(48,192,16,16);//135
		 
		stuff.addTile(64,192,16,16);//136
		 
		stuff.addTile(80,192,16,16);//137
		 
		stuff.addTile(96,192,16,16);//138
		 
		stuff.addTile(112,192,16,16);//139
		 
		stuff.addTile(128,192,16,16);//140
		 
		stuff.addTile(144,192,16,16);//141
		 
		stuff.addTile(160,192,16,16);//142
		
		
		stuff.gc();
	}
	

}

//--------------------------------------------------------------------------------------------------------------
// level trunk
//--------------------------------------------------------------------------------------------------------------

	//--------------------------------------------------------------------------------------------------------------
	// World : unamed_Level
	class world_unamed_Level extends CWorld{
	
		// map count : 1
		 
		public CMap Map0000_unamed_Map;//0 0 0
		
		
		// sprite count : 4
		
		public CSprite Spr0001_unamed_Sprite;//0 59 231
		
		public CSprite Spr0002_unamed_Sprite;//1 422 300
		
		public CSprite Spr0003_unamed_Sprite3;//2 392 248
		
		public CSprite Spr0004_unamed_Sprite2;//3 321 45
		
		
		public void initPath()
		{
			WayPoints = new CWayPoint[24];
			
			 
			 WayPoints[0] = new CWayPoint(261,29);
			 
			 WayPoints[1] = new CWayPoint(150,10);
			 
			 WayPoints[2] = new CWayPoint(33,55);
			 
			 WayPoints[3] = new CWayPoint(264,220);
			 
			 WayPoints[4] = new CWayPoint(212,87);
			 
			 WayPoints[5] = new CWayPoint(123,267);
			 
			 WayPoints[6] = new CWayPoint(19,181);
			 
			 WayPoints[7] = new CWayPoint(210,191);
			 
			 WayPoints[8] = new CWayPoint(344,352);
			 
			 WayPoints[9] = new CWayPoint(46,292);
			 
			 WayPoints[10] = new CWayPoint(410,58);
			 
			 WayPoints[11] = new CWayPoint(186,358);
			 
			 WayPoints[12] = new CWayPoint(625,164);
			 
			 WayPoints[13] = new CWayPoint(519,78);
			 
			 WayPoints[14] = new CWayPoint(470,162);
			 
			 WayPoints[15] = new CWayPoint(549,168);
			 
			 WayPoints[16] = new CWayPoint(450,338);
			 
			 WayPoints[17] = new CWayPoint(597,281);
			 
			 WayPoints[18] = new CWayPoint(141,133);
			 
			 WayPoints[19] = new CWayPoint(296,283);
			 
			 WayPoints[20] = new CWayPoint(323,117);
			 
			 WayPoints[21] = new CWayPoint(38,356);
			 
			 WayPoints[22] = new CWayPoint(25,21);
			 
			 WayPoints[23] = new CWayPoint(425,18);
			
		
			
			 WayPoints[0].link(WayPoints[1]);//0
			
			 WayPoints[0].link(WayPoints[3]);//1
			
			 WayPoints[0].link(WayPoints[10]);//2
			
			 WayPoints[0].link(WayPoints[20]);//3
			
			 WayPoints[1].link(WayPoints[2]);//4
			
			 WayPoints[1].link(WayPoints[0]);//5
			
			 WayPoints[1].link(WayPoints[4]);//6
			
			 WayPoints[1].link(WayPoints[18]);//7
			
			 WayPoints[2].link(WayPoints[1]);//8
			
			 WayPoints[2].link(WayPoints[6]);//9
			
			 WayPoints[2].link(WayPoints[18]);//10
			
			 WayPoints[2].link(WayPoints[22]);//11
			
			 WayPoints[3].link(WayPoints[0]);//12
			
			 WayPoints[3].link(WayPoints[5]);//13
			
			 WayPoints[3].link(WayPoints[19]);//14
			
			 WayPoints[3].link(WayPoints[20]);//15
			
			 WayPoints[3].link(WayPoints[7]);//16
			
			 WayPoints[4].link(WayPoints[1]);//17
			
			 WayPoints[4].link(WayPoints[7]);//18
			
			 WayPoints[4].link(WayPoints[18]);//19
			
			 WayPoints[5].link(WayPoints[6]);//20
			
			 WayPoints[5].link(WayPoints[3]);//21
			
			 WayPoints[5].link(WayPoints[7]);//22
			
			 WayPoints[5].link(WayPoints[18]);//23
			
			 WayPoints[5].link(WayPoints[19]);//24
			
			 WayPoints[5].link(WayPoints[11]);//25
			
			 WayPoints[6].link(WayPoints[2]);//26
			
			 WayPoints[6].link(WayPoints[5]);//27
			
			 WayPoints[6].link(WayPoints[9]);//28
			
			 WayPoints[6].link(WayPoints[18]);//29
			
			 WayPoints[7].link(WayPoints[4]);//30
			
			 WayPoints[7].link(WayPoints[5]);//31
			
			 WayPoints[7].link(WayPoints[18]);//32
			
			 WayPoints[7].link(WayPoints[3]);//33
			
			 WayPoints[8].link(WayPoints[11]);//34
			
			 WayPoints[8].link(WayPoints[10]);//35
			
			 WayPoints[8].link(WayPoints[16]);//36
			
			 WayPoints[8].link(WayPoints[19]);//37
			
			 WayPoints[8].link(WayPoints[14]);//38
			
			 WayPoints[9].link(WayPoints[6]);//39
			
			 WayPoints[9].link(WayPoints[11]);//40
			
			 WayPoints[9].link(WayPoints[21]);//41
			
			 WayPoints[10].link(WayPoints[8]);//42
			
			 WayPoints[10].link(WayPoints[0]);//43
			
			 WayPoints[10].link(WayPoints[13]);//44
			
			 WayPoints[10].link(WayPoints[14]);//45
			
			 WayPoints[10].link(WayPoints[19]);//46
			
			 WayPoints[10].link(WayPoints[20]);//47
			
			 WayPoints[11].link(WayPoints[9]);//48
			
			 WayPoints[11].link(WayPoints[8]);//49
			
			 WayPoints[11].link(WayPoints[5]);//50
			
			 WayPoints[12].link(WayPoints[13]);//51
			
			 WayPoints[12].link(WayPoints[15]);//52
			
			 WayPoints[12].link(WayPoints[17]);//53
			
			 WayPoints[13].link(WayPoints[12]);//54
			
			 WayPoints[13].link(WayPoints[10]);//55
			
			 WayPoints[13].link(WayPoints[23]);//56
			
			 WayPoints[14].link(WayPoints[15]);//57
			
			 WayPoints[14].link(WayPoints[10]);//58
			
			 WayPoints[14].link(WayPoints[16]);//59
			
			 WayPoints[14].link(WayPoints[8]);//60
			
			 WayPoints[15].link(WayPoints[14]);//61
			
			 WayPoints[15].link(WayPoints[17]);//62
			
			 WayPoints[15].link(WayPoints[12]);//63
			
			 WayPoints[16].link(WayPoints[8]);//64
			
			 WayPoints[16].link(WayPoints[17]);//65
			
			 WayPoints[16].link(WayPoints[14]);//66
			
			 WayPoints[17].link(WayPoints[16]);//67
			
			 WayPoints[17].link(WayPoints[15]);//68
			
			 WayPoints[17].link(WayPoints[12]);//69
			
			 WayPoints[18].link(WayPoints[4]);//70
			
			 WayPoints[18].link(WayPoints[1]);//71
			
			 WayPoints[18].link(WayPoints[2]);//72
			
			 WayPoints[18].link(WayPoints[6]);//73
			
			 WayPoints[18].link(WayPoints[5]);//74
			
			 WayPoints[18].link(WayPoints[7]);//75
			
			 WayPoints[19].link(WayPoints[10]);//76
			
			 WayPoints[19].link(WayPoints[3]);//77
			
			 WayPoints[19].link(WayPoints[5]);//78
			
			 WayPoints[19].link(WayPoints[8]);//79
			
			 WayPoints[20].link(WayPoints[10]);//80
			
			 WayPoints[20].link(WayPoints[3]);//81
			
			 WayPoints[20].link(WayPoints[0]);//82
			
			 WayPoints[21].link(WayPoints[9]);//83
			
			 WayPoints[22].link(WayPoints[2]);//84
			
			 WayPoints[23].link(WayPoints[13]);//85
			
		}
		public void initUnit()
		{
			 
			addMap(Map0000_unamed_Map);
			

			
			addSprite(Spr0001_unamed_Sprite);//0
			Spr0001_unamed_Sprite.X = 59;
			Spr0001_unamed_Sprite.Y = 231;
			
			addSprite(Spr0002_unamed_Sprite);//1
			Spr0002_unamed_Sprite.X = 422;
			Spr0002_unamed_Sprite.Y = 300;
			
			addSprite(Spr0003_unamed_Sprite3);//2
			Spr0003_unamed_Sprite3.X = 392;
			Spr0003_unamed_Sprite3.Y = 248;
			
			addSprite(Spr0004_unamed_Sprite2);//3
			Spr0004_unamed_Sprite2.X = 321;
			Spr0004_unamed_Sprite2.Y = 45;
			
		}

	
	
	}
	

	//--------------------------------------------------------------------------------------------------------------
	// World : TD_Level
	class world_TD_Level extends CWorld{
	
		// map count : 1
		 
		public CMap Map0000_unamed_Map;//0 0 0
		
		
		// sprite count : 0
		
		
		public void initPath()
		{
			WayPoints = new CWayPoint[21];
			
			 
			 WayPoints[0] = new CWayPoint(3,40);
			 
			 WayPoints[1] = new CWayPoint(469,40);
			 
			 WayPoints[2] = new CWayPoint(471,471);
			 
			 WayPoints[3] = new CWayPoint(41,470);
			 
			 WayPoints[4] = new CWayPoint(41,88);
			 
			 WayPoints[5] = new CWayPoint(424,90);
			 
			 WayPoints[6] = new CWayPoint(423,420);
			 
			 WayPoints[7] = new CWayPoint(86,421);
			 
			 WayPoints[8] = new CWayPoint(86,136);
			 
			 WayPoints[9] = new CWayPoint(371,134);
			 
			 WayPoints[10] = new CWayPoint(374,375);
			 
			 WayPoints[11] = new CWayPoint(136,373);
			 
			 WayPoints[12] = new CWayPoint(136,185);
			 
			 WayPoints[13] = new CWayPoint(324,184);
			 
			 WayPoints[14] = new CWayPoint(326,328);
			 
			 WayPoints[15] = new CWayPoint(184,324);
			 
			 WayPoints[16] = new CWayPoint(185,233);
			 
			 WayPoints[17] = new CWayPoint(277,232);
			 
			 WayPoints[18] = new CWayPoint(276,278);
			 
			 WayPoints[19] = new CWayPoint(229,279);
			 
			 WayPoints[20] = new CWayPoint(229,255);
			
		
			
			 WayPoints[0].link(WayPoints[1]);//0
			
			 WayPoints[1].link(WayPoints[2]);//1
			
			 WayPoints[1].link(WayPoints[0]);//2
			
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
			
			 WayPoints[13].link(WayPoints[12]);//25
			
			 WayPoints[13].link(WayPoints[14]);//26
			
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
			 
			addMap(Map0000_unamed_Map);
			

			
		}

	
	
	}
	






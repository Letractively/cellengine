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
	// Images : BattleMapTile
	final static public void buildClipImages_BattleMapTile(IImages stuff){
	
		stuff.buildImages(CIO.loadImage("/BattleMapTile.png"),81);
		
		 
		stuff.addTile(0,0,16,16);//0
		 
		stuff.addTile(16,0,16,16);//1
		 
		stuff.addTile(32,0,16,16);//2
		 
		stuff.addTile(48,0,16,16);//3
		 
		stuff.addTile(64,0,16,16);//4
		 
		stuff.addTile(80,0,16,16);//5
		 
		stuff.addTile(96,0,16,16);//6
		 
		stuff.addTile(112,0,16,16);//7
		 
		stuff.addTile(128,0,16,16);//8
		 
		stuff.addTile(0,16,16,16);//9
		 
		stuff.addTile(16,16,16,16);//10
		 
		stuff.addTile(32,16,16,16);//11
		 
		stuff.addTile(48,16,16,16);//12
		 
		stuff.addTile(64,16,16,16);//13
		 
		stuff.addTile(80,16,16,16);//14
		 
		stuff.addTile(96,16,16,16);//15
		 
		stuff.addTile(112,16,16,16);//16
		 
		stuff.addTile(128,16,16,16);//17
		 
		stuff.addTile(0,32,16,16);//18
		 
		stuff.addTile(16,32,16,16);//19
		 
		stuff.addTile(32,32,16,16);//20
		 
		stuff.addTile(48,32,16,16);//21
		 
		stuff.addTile(64,32,16,16);//22
		 
		stuff.addTile(80,32,16,16);//23
		 
		stuff.addTile(96,32,16,16);//24
		 
		stuff.addTile(112,32,16,16);//25
		 
		stuff.addTile(128,32,16,16);//26
		 
		stuff.addTile(0,48,16,16);//27
		 
		stuff.addTile(16,48,16,16);//28
		 
		stuff.addTile(32,48,16,16);//29
		 
		stuff.addTile(48,48,16,16);//30
		 
		stuff.addTile(64,48,16,16);//31
		 
		stuff.addTile(80,48,16,16);//32
		 
		stuff.addTile(96,48,16,16);//33
		 
		stuff.addTile(112,48,16,16);//34
		 
		stuff.addTile(128,48,16,16);//35
		 
		stuff.addTile(0,64,16,16);//36
		 
		stuff.addTile(16,64,16,16);//37
		 
		stuff.addTile(32,64,16,16);//38
		 
		stuff.addTile(48,64,16,16);//39
		 
		stuff.addTile(64,64,16,16);//40
		 
		stuff.addTile(80,64,16,16);//41
		 
		stuff.addTile(96,64,16,16);//42
		 
		stuff.addTile(112,64,16,16);//43
		 
		stuff.addTile(128,64,16,16);//44
		 
		stuff.addTile(0,80,16,16);//45
		 
		stuff.addTile(16,80,16,16);//46
		 
		stuff.addTile(32,80,16,16);//47
		 
		stuff.addTile(48,80,16,16);//48
		 
		stuff.addTile(64,80,16,16);//49
		 
		stuff.addTile(80,80,16,16);//50
		 
		stuff.addTile(96,80,16,16);//51
		 
		stuff.addTile(112,80,16,16);//52
		 
		stuff.addTile(128,80,16,16);//53
		 
		stuff.addTile(0,96,16,16);//54
		 
		stuff.addTile(16,96,16,16);//55
		 
		stuff.addTile(32,96,16,16);//56
		 
		stuff.addTile(48,96,16,16);//57
		 
		stuff.addTile(64,96,16,16);//58
		 
		stuff.addTile(80,96,16,16);//59
		 
		stuff.addTile(96,96,16,16);//60
		 
		stuff.addTile(112,96,16,16);//61
		 
		stuff.addTile(128,96,16,16);//62
		 
		stuff.addTile(0,112,16,16);//63
		 
		stuff.addTile(16,112,16,16);//64
		 
		stuff.addTile(32,112,16,16);//65
		 
		stuff.addTile(48,112,16,16);//66
		 
		stuff.addTile(64,112,16,16);//67
		 
		stuff.addTile(80,112,16,16);//68
		 
		stuff.addTile(96,112,16,16);//69
		 
		stuff.addTile(112,112,16,16);//70
		 
		stuff.addTile(128,112,16,16);//71
		 
		stuff.addTile(0,128,16,16);//72
		 
		stuff.addTile(16,128,16,16);//73
		 
		stuff.addTile(32,128,16,16);//74
		 
		stuff.addTile(48,128,16,16);//75
		 
		stuff.addTile(64,128,16,16);//76
		 
		stuff.addTile(80,128,16,16);//77
		 
		stuff.addTile(96,128,16,16);//78
		 
		stuff.addTile(112,128,16,16);//79
		 
		stuff.addTile(128,128,16,16);//80
		
		
		stuff.gc();
	}
	

	//--------------------------------------------------------------------------------------------------------------
	// Map : BattleMap
	final static public CMap createMap_BattleMap(IImages tiles,boolean isAnimate,boolean isCyc){
		
		//64 x 32
		
		// tiles
	    CAnimates animates = new CAnimates(4,tiles);
	    
		animates.addPart(0,0,27,0);//0
		
		animates.addPart(0,0,72,0);//1
		
		animates.addPart(0,0,73,0);//2
		
		animates.addPart(0,0,74,0);//3
		
		
	    animates.setFrame(new int[4][]);
	    
	    animates.setComboFrame(new int[]{0,},0);//0
		
	    animates.setComboFrame(new int[]{1,},1);//1
		
	    animates.setComboFrame(new int[]{2,},2);//2
		
	    animates.setComboFrame(new int[]{3,},3);//3
		
		
		short[][] tileMatrix = new short[][]{
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,1,2,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,1,2,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,1,2,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,0,0,0,0,0,0,0,0,1,2,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,1,2,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,1,2,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,1,2,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,1,2,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,0,0,0,0,0,0,0,0,1,2,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,1,2,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
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
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
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
	// Images : BattleSprTile
	final static public void buildClipImages_BattleSprTile(IImages stuff){
	
		stuff.buildImages(CIO.loadImage("/BattleSprTile.png"),5);
		
		 
		stuff.addTile(0,0,25,20);//0
		 
		stuff.addTile(0,20,25,20);//1
		 
		stuff.addTile(0,40,16,13);//2
		 
		stuff.addTile(0,53,16,16);//3
		 
		stuff.addTile(0,69,17,16);//4
		
		
		stuff.gc();
	}
	

	//--------------------------------------------------------------------------------------------------------------
	// Sprite : BattleAct
	final static public CSprite createSprite_BattleAct(IImages tiles){

	    // tiles
	    CAnimates animates = new CAnimates(3,tiles);
	    
		animates.addPart(-12,-10,0,0);//0
		
		animates.addPart(-12,-10,1,0);//1
		
		animates.addPart(-8,-8,4,0);//2
		
		
	    animates.setFrame(new int[3][]);
	    
	    animates.setComboFrame(new int[]{0,},0);//0
		
	    animates.setComboFrame(new int[]{1,},1);//1
		
	    animates.setComboFrame(new int[]{2,},2);//2
		
		
		
		// cds
	    CCollides collides = new CCollides(2);
		
	    if("rect"=="rect")
	    collides.addCDRect(65535, -10, -8, 20 , 10 );//rect//0
	    if("rect"=="line")
	    collides.addCDLine(65535, -10, -8, 10, 2);//rect//0
	    
	    if("rect"=="rect")
	    collides.addCDRect(65535, -6, -6, 13 , 12 );//rect//1
	    if("rect"=="line")
	    collides.addCDLine(65535, -6, -6, 7, 6);//rect//1
	    
	    
	    collides.setFrame(new int[3][]);
	    
	    collides.setComboFrame(new int[]{0,},0);//0
	    
	    collides.setComboFrame(new int[]{},1);//1
	    
	    collides.setComboFrame(new int[]{1,},2);//2
	    
	    
	    
		// sprite frame
	    int[][] frameAnimate = new int[][]{
	        {0,1,},{2,},
	    };
	    int[][] frameCDMap = new int[][]{
	        {0,0,},{2,},
	    };
	    int[][] frameCDAtk = new int[][]{
	        {1,1,},{1,},
	    };
	    int[][] frameCDDef = new int[][]{
	        {1,1,},{1,},
	    };
	    int[][] frameCDExt = new int[][]{
	        {1,1,},{1,},
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
	// Sprite : BattleEnemy00
	final static public CSprite createSprite_BattleEnemy00(IImages tiles){

	    // tiles
	    CAnimates animates = new CAnimates(2,tiles);
	    
		animates.addPart(-8,-6,2,2);//0
		
		animates.addPart(-8,-8,3,2);//1
		
		
	    animates.setFrame(new int[2][]);
	    
	    animates.setComboFrame(new int[]{0,},0);//0
		
	    animates.setComboFrame(new int[]{1,},1);//1
		
		
		
		// cds
	    CCollides collides = new CCollides(1);
		
	    if("rect"=="rect")
	    collides.addCDRect(65535, -8, -5, 16 , 10 );//rect//0
	    if("rect"=="line")
	    collides.addCDLine(65535, -8, -5, 8, 5);//rect//0
	    
	    
	    collides.setFrame(new int[2][]);
	    
	    collides.setComboFrame(new int[]{0,},0);//0
	    
	    collides.setComboFrame(new int[]{},1);//1
	    
	    
	    
		// sprite frame
	    int[][] frameAnimate = new int[][]{
	        {0,0,0,0,1,1,1,1,},
	    };
	    int[][] frameCDMap = new int[][]{
	        {0,0,0,0,0,0,0,0,},
	    };
	    int[][] frameCDAtk = new int[][]{
	        {1,1,1,1,1,1,1,1,},
	    };
	    int[][] frameCDDef = new int[][]{
	        {1,1,1,1,1,1,1,1,},
	    };
	    int[][] frameCDExt = new int[][]{
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
	

	//--------------------------------------------------------------------------------------------------------------
	// Images : BattleBulletTile
	final static public void buildClipImages_BattleBulletTile(IImages stuff){
	
		stuff.buildImages(CIO.loadImage("/BattleBulletTile.png"),50);
		
		 
		stuff.addTile(0,0,8,8);//0
		 
		stuff.addTile(0,8,9,9);//1
		 
		stuff.addTile(0,17,9,9);//2
		 
		stuff.addTile(0,26,9,9);//3
		 
		stuff.addTile(0,35,9,9);//4
		 
		stuff.addTile(0,44,9,9);//5
		 
		stuff.addTile(0,53,9,9);//6
		 
		stuff.addTile(0,62,9,9);//7
		 
		stuff.addTile(0,71,9,9);//8
		 
		stuff.addTile(0,80,9,9);//9
		 
		stuff.addTile(0,89,9,9);//10
		 
		stuff.addTile(0,98,9,9);//11
		 
		stuff.addTile(0,107,9,9);//12
		 
		stuff.addTile(0,116,9,9);//13
		 
		stuff.addTile(0,125,9,9);//14
		 
		stuff.addTile(0,134,9,9);//15
		 
		stuff.addTile(0,143,27,7);//16
		 
		stuff.addTile(0,150,24,5);//17
		 
		stuff.addTile(0,155,18,14);//18
		 
		stuff.addTile(0,169,12,10);//19
		 
		stuff.addTile(0,179,9,8);//20
		 
		stuff.addTile(0,187,6,6);//21
		 
		stuff.addTile(0,193,17,17);//22
		 
		stuff.addTile(0,210,13,13);//23
		 
		stuff.addTile(0,223,10,10);//24
		 
		stuff.addTile(0,233,13,13);//25
		 
		stuff.addTile(0,246,13,13);//26
		 
		stuff.addTile(0,259,13,22);//27
		 
		stuff.addTile(0,281,13,22);//28
		 
		stuff.addTile(0,303,10,16);//29
		 
		stuff.addTile(0,319,10,16);//30
		 
		stuff.addTile(0,335,14,24);//31
		 
		stuff.addTile(0,359,14,24);//32
		 
		stuff.addTile(0,383,14,24);//33
		 
		stuff.addTile(0,407,14,24);//34
		 
		stuff.addTile(0,431,15,18);//35
		 
		stuff.addTile(0,449,17,30);//36
		 
		stuff.addTile(0,479,13,13);//37
		 
		stuff.addTile(0,492,11,11);//38
		 
		stuff.addTile(0,503,24,13);//39
		 
		stuff.addTile(0,516,36,5);//40
		 
		stuff.addTile(0,521,26,176);//41
		 
		stuff.addTile(0,697,42,42);//42
		 
		stuff.addTile(0,739,42,42);//43
		 
		stuff.addTile(0,781,42,42);//44
		 
		stuff.addTile(0,823,42,42);//45
		 
		stuff.addTile(0,865,42,42);//46
		 
		stuff.addTile(0,907,42,42);//47
		 
		stuff.addTile(0,949,42,42);//48
		 
		stuff.addTile(0,991,42,42);//49
		
		
		stuff.gc();
	}
	

	//--------------------------------------------------------------------------------------------------------------
	// Sprite : BattleBullet
	final static public CSprite createSprite_BattleBullet(IImages tiles){

	    // tiles
	    CAnimates animates = new CAnimates(28,tiles);
	    
		animates.addPart(-6,-6,25,0);//0
		
		animates.addPart(-6,-6,26,0);//1
		
		animates.addPart(-8,-8,22,0);//2
		
		animates.addPart(-6,-6,23,0);//3
		
		animates.addPart(-5,-5,24,0);//4
		
		animates.addPart(-4,-4,0,0);//5
		
		animates.addPart(0,-6,39,0);//6
		
		animates.addPart(0,-2,40,0);//7
		
		animates.addPart(0,-13,41,6);//8
		
		animates.addPart(0,-13,41,5);//9
		
		animates.addPart(0,-13,41,4);//10
		
		animates.addPart(0,-13,41,7);//11
		
		animates.addPart(-7,-23,31,0);//12
		
		animates.addPart(-7,-23,32,0);//13
		
		animates.addPart(-7,-23,33,0);//14
		
		animates.addPart(-7,-23,34,0);//15
		
		animates.addPart(-7,-17,35,0);//16
		
		animates.addPart(-8,-29,36,0);//17
		
		animates.addPart(-6,-6,37,0);//18
		
		animates.addPart(-5,-5,38,0);//19
		
		animates.addPart(-21,-21,43,0);//20
		
		animates.addPart(-21,-21,44,0);//21
		
		animates.addPart(-21,-21,45,0);//22
		
		animates.addPart(-21,-21,46,0);//23
		
		animates.addPart(-21,-21,47,0);//24
		
		animates.addPart(-21,-21,48,0);//25
		
		animates.addPart(-21,-21,49,0);//26
		
		animates.addPart(-21,-21,42,0);//27
		
		
	    animates.setFrame(new int[28][]);
	    
	    animates.setComboFrame(new int[]{0,},0);//0
		
	    animates.setComboFrame(new int[]{1,},1);//1
		
	    animates.setComboFrame(new int[]{2,},2);//2
		
	    animates.setComboFrame(new int[]{3,},3);//3
		
	    animates.setComboFrame(new int[]{4,},4);//4
		
	    animates.setComboFrame(new int[]{5,},5);//5
		
	    animates.setComboFrame(new int[]{6,7,},6);//6
		
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
		
		
		
		// cds
	    CCollides collides = new CCollides(6);
		
	    if("rect"=="rect")
	    collides.addCDRect(65535, -6, -6, 13 , 13 );//rect//0
	    if("rect"=="line")
	    collides.addCDLine(65535, -6, -6, 7, 7);//rect//0
	    
	    if("rect"=="rect")
	    collides.addCDRect(65535, 0, -2, 36 , 5 );//rect//1
	    if("rect"=="line")
	    collides.addCDLine(65535, 0, -2, 36, 3);//rect//1
	    
	    if("rect"=="rect")
	    collides.addCDRect(65535, 0, -10, 176 , 20 );//rect//2
	    if("rect"=="line")
	    collides.addCDLine(65535, 0, -10, 176, 10);//rect//2
	    
	    if("rect"=="rect")
	    collides.addCDRect(65535, -5, -17, 10 , 16 );//rect//3
	    if("rect"=="line")
	    collides.addCDLine(65535, -5, -17, 5, -1);//rect//3
	    
	    if("rect"=="rect")
	    collides.addCDRect(65535, -5, -5, 11 , 11 );//rect//4
	    if("rect"=="line")
	    collides.addCDLine(65535, -5, -5, 6, 6);//rect//4
	    
	    if("rect"=="rect")
	    collides.addCDRect(65535, -128, -128, 256 , 256 );//rect//5
	    if("rect"=="line")
	    collides.addCDLine(65535, -128, -128, 128, 128);//rect//5
	    
	    
	    collides.setFrame(new int[7][]);
	    
	    collides.setComboFrame(new int[]{0,},0);//0
	    
	    collides.setComboFrame(new int[]{},1);//1
	    
	    collides.setComboFrame(new int[]{1,},2);//2
	    
	    collides.setComboFrame(new int[]{2,},3);//3
	    
	    collides.setComboFrame(new int[]{3,},4);//4
	    
	    collides.setComboFrame(new int[]{4,},5);//5
	    
	    collides.setComboFrame(new int[]{5,},6);//6
	    
	    
	    
		// sprite frame
	    int[][] frameAnimate = new int[][]{
	        {0,1,},{2,2,3,3,4,4,5,5,},{6,7,},{8,9,10,11,},{12,13,14,15,},{16,17,17,16,},{18,18,19,19,},{20,21,22,23,24,25,26,27,},
	    };
	    int[][] frameCDMap = new int[][]{
	        {0,0,},{1,1,1,1,1,1,1,1,},{2,2,},{3,3,3,3,},{4,4,4,4,},{1,1,1,1,},{5,5,5,5,},{6,6,6,6,6,6,6,6,},
	    };
	    int[][] frameCDAtk = new int[][]{
	        {1,1,},{1,1,1,1,1,1,1,1,},{1,1,},{1,1,1,1,},{1,1,1,1,},{1,1,1,1,},{1,1,1,1,},{1,1,1,1,1,1,1,1,},
	    };
	    int[][] frameCDDef = new int[][]{
	        {1,1,},{1,1,1,1,1,1,1,1,},{1,1,},{1,1,1,1,},{1,1,1,1,},{1,1,1,1,},{1,1,1,1,},{1,1,1,1,1,1,1,1,},
	    };
	    int[][] frameCDExt = new int[][]{
	        {1,1,},{1,1,1,1,1,1,1,1,},{1,1,},{1,1,1,1,},{1,1,1,1,},{1,1,1,1,},{1,1,1,1,},{1,1,1,1,1,1,1,1,},
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
	// World : BattleLevel00
	class world_BattleLevel00 extends CWorld{
	
		// map count : 1
		 
		public CMap Map0000_BattleMap;//0 0 0
		
		
		// sprite count : 0
		
		
		public void initPath()
		{
			WayPoints = new CWayPoint[17];
			
			 
			 WayPoints[0] = new CWayPoint(398,104);
			 
			 WayPoints[1] = new CWayPoint(226,190);
			 
			 WayPoints[2] = new CWayPoint(394,310);
			 
			 WayPoints[3] = new CWayPoint(565,195);
			 
			 WayPoints[4] = new CWayPoint(563,105);
			 
			 WayPoints[5] = new CWayPoint(228,110);
			 
			 WayPoints[6] = new CWayPoint(222,291);
			 
			 WayPoints[7] = new CWayPoint(571,308);
			 
			 WayPoints[8] = new CWayPoint(121,53);
			 
			 WayPoints[9] = new CWayPoint(114,199);
			 
			 WayPoints[10] = new CWayPoint(116,419);
			 
			 WayPoints[11] = new CWayPoint(376,411);
			 
			 WayPoints[12] = new CWayPoint(405,37);
			 
			 WayPoints[13] = new CWayPoint(398,197);
			 
			 WayPoints[14] = new CWayPoint(745,35);
			 
			 WayPoints[15] = new CWayPoint(749,441);
			 
			 WayPoints[16] = new CWayPoint(737,210);
			
		
			
			 WayPoints[0].link(WayPoints[4]);//0
			
			 WayPoints[0].link(WayPoints[5]);//1
			
			 WayPoints[0].link(WayPoints[13]);//2
			
			 WayPoints[0].link(WayPoints[12]);//3
			
			 WayPoints[1].link(WayPoints[6]);//4
			
			 WayPoints[1].link(WayPoints[5]);//5
			
			 WayPoints[1].link(WayPoints[13]);//6
			
			 WayPoints[1].link(WayPoints[9]);//7
			
			 WayPoints[2].link(WayPoints[7]);//8
			
			 WayPoints[2].link(WayPoints[6]);//9
			
			 WayPoints[2].link(WayPoints[13]);//10
			
			 WayPoints[2].link(WayPoints[11]);//11
			
			 WayPoints[3].link(WayPoints[4]);//12
			
			 WayPoints[3].link(WayPoints[7]);//13
			
			 WayPoints[3].link(WayPoints[13]);//14
			
			 WayPoints[3].link(WayPoints[16]);//15
			
			 WayPoints[4].link(WayPoints[0]);//16
			
			 WayPoints[4].link(WayPoints[3]);//17
			
			 WayPoints[4].link(WayPoints[14]);//18
			
			 WayPoints[5].link(WayPoints[1]);//19
			
			 WayPoints[5].link(WayPoints[0]);//20
			
			 WayPoints[5].link(WayPoints[8]);//21
			
			 WayPoints[6].link(WayPoints[2]);//22
			
			 WayPoints[6].link(WayPoints[1]);//23
			
			 WayPoints[6].link(WayPoints[10]);//24
			
			 WayPoints[7].link(WayPoints[3]);//25
			
			 WayPoints[7].link(WayPoints[2]);//26
			
			 WayPoints[7].link(WayPoints[15]);//27
			
			 WayPoints[8].link(WayPoints[9]);//28
			
			 WayPoints[8].link(WayPoints[12]);//29
			
			 WayPoints[8].link(WayPoints[5]);//30
			
			 WayPoints[9].link(WayPoints[8]);//31
			
			 WayPoints[9].link(WayPoints[10]);//32
			
			 WayPoints[9].link(WayPoints[1]);//33
			
			 WayPoints[10].link(WayPoints[11]);//34
			
			 WayPoints[10].link(WayPoints[9]);//35
			
			 WayPoints[10].link(WayPoints[6]);//36
			
			 WayPoints[11].link(WayPoints[15]);//37
			
			 WayPoints[11].link(WayPoints[10]);//38
			
			 WayPoints[11].link(WayPoints[2]);//39
			
			 WayPoints[12].link(WayPoints[8]);//40
			
			 WayPoints[12].link(WayPoints[14]);//41
			
			 WayPoints[12].link(WayPoints[0]);//42
			
			 WayPoints[13].link(WayPoints[2]);//43
			
			 WayPoints[13].link(WayPoints[3]);//44
			
			 WayPoints[13].link(WayPoints[0]);//45
			
			 WayPoints[13].link(WayPoints[1]);//46
			
			 WayPoints[14].link(WayPoints[12]);//47
			
			 WayPoints[14].link(WayPoints[16]);//48
			
			 WayPoints[14].link(WayPoints[4]);//49
			
			 WayPoints[15].link(WayPoints[16]);//50
			
			 WayPoints[15].link(WayPoints[11]);//51
			
			 WayPoints[15].link(WayPoints[7]);//52
			
			 WayPoints[16].link(WayPoints[15]);//53
			
			 WayPoints[16].link(WayPoints[14]);//54
			
			 WayPoints[16].link(WayPoints[3]);//55
			
		}
		public void initUnit()
		{
			 
			addMap(Map0000_BattleMap);
			

			
		}

	
	
	}
	






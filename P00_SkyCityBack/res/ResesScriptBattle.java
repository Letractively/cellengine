/* Encoding : 简体中文(GB2312) */
/* Cell Game Editor by WAZA Zhang */
/* Email : wazazhang@gmail.com */

//
// SkyCity Script v0.0.0
// 
// 指定文件输出
// <OUTPUT>     ..\[out]\ResesScriptBattle.java
// 

import com.morefuntek.cell.*;
import com.morefuntek.cell.Game.*;

public class ResesScriptBattle {

//--------------------------------------------------------------------------------------------------------------
// resource trunk
//--------------------------------------------------------------------------------------------------------------


	//--------------------------------------------------------------------------------------------------------------
	 
	// Images : battleWeaopnTile 
	final static public IImages createClipImages_battleWeaopnTile(){
		IImages stuff = new CImages20();
		stuff.buildImages(CIO.loadImage("/battleWeaopnTile.png"),67);
		
		 stuff.addTile(0,0,18,3);//0 
		 stuff.addTile(0,3,18,12);//1 
		 stuff.addTile(18,0,5,4);//2 
		 stuff.addTile(18,4,5,4);//3 
		 stuff.addTile(23,0,14,8);//4 
		 stuff.addTile(37,0,11,11);//5 
		 stuff.addTile(90,41,1,1);//6 
		 stuff.addTile(88,40,1,1);//7 
		 stuff.addTile(89,41,1,1);//8 
		 stuff.addTile(90,40,1,1);//9 
		 stuff.addTile(89,40,1,1);//10 
		 stuff.addTile(88,41,1,1);//11 
		 stuff.addTile(18,8,14,9);//12 
		 stuff.addTile(67,24,13,13);//13 
		 stuff.addTile(66,38,22,5);//14 
		 stuff.addTile(35,11,11,21);//15 
		 stuff.addTile(11,17,11,21);//16 
		 stuff.addTile(63,0,11,21);//17 
		 stuff.addTile(74,0,11,21);//18 
		 stuff.addTile(22,26,11,15);//19 
		 stuff.addTile(0,24,11,15);//20 
		 stuff.addTile(0,15,11,9);//21 
		 stuff.addTile(80,29,11,9);//22 
		 stuff.addTile(23,17,11,3);//23 
		 stuff.addTile(23,20,11,3);//24 
		 stuff.addTile(89,26,1,1);//25 
		 stuff.addTile(90,38,1,1);//26 
		 stuff.addTile(89,38,1,1);//27 
		 stuff.addTile(90,28,1,1);//28 
		 stuff.addTile(89,28,1,1);//29 
		 stuff.addTile(46,21,18,12);//30 
		 stuff.addTile(33,33,15,6);//31 
		 stuff.addTile(85,16,6,8);//32 
		 stuff.addTile(85,0,6,8);//33 
		 stuff.addTile(85,8,6,8);//34 
		 stuff.addTile(88,38,1,1);//35 
		 stuff.addTile(88,39,1,1);//36 
		 stuff.addTile(90,25,1,1);//37 
		 stuff.addTile(90,24,1,1);//38 
		 stuff.addTile(89,39,1,1);//39 
		 stuff.addTile(89,25,1,1);//40 
		 stuff.addTile(89,24,1,1);//41 
		 stuff.addTile(89,27,1,1);//42 
		 stuff.addTile(46,17,9,4);//43 
		 stuff.addTile(48,0,13,8);//44 
		 stuff.addTile(48,37,18,4);//45 
		 stuff.addTile(23,23,6,3);//46 
		 stuff.addTile(67,21,3,3);//47 
		 stuff.addTile(84,24,5,5);//48 
		 stuff.addTile(55,17,4,4);//49 
		 stuff.addTile(64,27,3,6);//50 
		 stuff.addTile(73,21,3,3);//51 
		 stuff.addTile(16,38,5,5);//52 
		 stuff.addTile(80,25,4,4);//53 
		 stuff.addTile(29,23,6,3);//54 
		 stuff.addTile(70,21,3,3);//55 
		 stuff.addTile(11,38,5,5);//56 
		 stuff.addTile(59,17,4,4);//57 
		 stuff.addTile(64,21,3,6);//58 
		 stuff.addTile(76,21,3,3);//59 
		 stuff.addTile(33,39,5,5);//60 
		 stuff.addTile(80,21,4,4);//61 
		 stuff.addTile(48,8,14,9);//62 
		 stuff.addTile(48,33,18,4);//63 
		 stuff.addTile(90,26,1,1);//64 
		 stuff.addTile(90,39,1,1);//65 
		 stuff.addTile(90,27,1,1);//66 
		
		stuff.gc();
		
		return stuff;
	}
	
 
	// Images : battleEffectTile 
	final static public IImages createClipImages_battleEffectTile(){
		IImages stuff = new CImages20();
		stuff.buildImages(CIO.loadImage("/battleEffectTile.png"),24);
		
		 stuff.addTile(165,27,25,25);//0 
		 stuff.addTile(125,0,40,43);//1 
		 stuff.addTile(0,0,46,52);//2 
		 stuff.addTile(49,43,56,54);//3 
		 stuff.addTile(207,82,7,7);//4 
		 stuff.addTile(373,58,15,15);//5 
		 stuff.addTile(142,43,22,22);//6 
		 stuff.addTile(105,43,37,37);//7 
		 stuff.addTile(198,82,9,9);//8 
		 stuff.addTile(164,52,15,15);//9 
		 stuff.addTile(165,2,25,25);//10 
		 stuff.addTile(46,0,47,43);//11 
		 stuff.addTile(0,52,49,49);//12 
		 stuff.addTile(189,82,9,9);//13 
		 stuff.addTile(179,52,15,15);//14 
		 stuff.addTile(142,67,24,23);//15 
		 stuff.addTile(93,0,32,34);//16 
		 stuff.addTile(191,67,3,3);//17 
		 stuff.addTile(214,82,9,9);//18 
		 stuff.addTile(356,58,17,17);//19 
		 stuff.addTile(166,67,23,23);//20 
		 stuff.addTile(284,3,72,76);//21 
		 stuff.addTile(194,0,90,82);//22 
		 stuff.addTile(356,3,64,55);//23 
		
		stuff.gc();
		
		return stuff;
	}
	
 
	// Images : battleSprTile 
	final static public IImages createClipImages_battleSprTile(){
		IImages stuff = new CImages20();
		stuff.buildImages(CIO.loadImage("/battleSprTile.png"),57);
		
		 stuff.addTile(0,0,27,25);//0 
		 stuff.addTile(73,89,10,7);//1 
		 stuff.addTile(45,18,8,5);//2 
		 stuff.addTile(53,18,5,5);//3 
		 stuff.addTile(73,80,12,9);//4 
		 stuff.addTile(45,9,12,9);//5 
		 stuff.addTile(43,0,12,9);//6 
		 stuff.addTile(58,13,16,13);//7 
		 stuff.addTile(57,0,16,13);//8 
		 stuff.addTile(27,0,16,13);//9 
		 stuff.addTile(36,25,16,13);//10 
		 stuff.addTile(52,26,16,13);//11 
		 stuff.addTile(73,0,12,11);//12 
		 stuff.addTile(61,82,12,11);//13 
		 stuff.addTile(74,11,12,11);//14 
		 stuff.addTile(18,25,18,12);//15 
		 stuff.addTile(0,25,18,12);//16 
		 stuff.addTile(27,13,18,12);//17 
		 stuff.addTile(68,26,18,12);//18 
		 stuff.addTile(0,85,18,10);//19 
		 stuff.addTile(74,50,11,10);//20 
		 stuff.addTile(61,61,21,19);//21 
		 stuff.addTile(18,85,25,8);//22 
		 stuff.addTile(27,61,34,23);//23 
		 stuff.addTile(0,38,37,22);//24 
		 stuff.addTile(43,84,18,12);//25 
		 stuff.addTile(74,38,13,12);//26 
		 stuff.addTile(61,80,9,2);//27 
		 stuff.addTile(37,39,37,22);//28 
		 stuff.addTile(0,60,27,25);//29 
		 stuff.addTile(0,95,19,15);//30 
		 stuff.addTile(39,96,22,16);//31 
		 stuff.addTile(19,93,20,20);//32 
		 stuff.addTile(76,96,6,8);//33 
		 stuff.addTile(61,96,15,6);//34 
		 stuff.addTile(61,102,6,8);//35 
		 stuff.addTile(67,102,6,8);//36 
		 stuff.addTile(0,112,24,16);//37 
		 stuff.addTile(24,113,24,16);//38 
		 stuff.addTile(48,112,24,16);//39 
		 stuff.addTile(0,129,26,32);//40 
		 stuff.addTile(73,104,5,5);//41 
		 stuff.addTile(82,75,5,5);//42 
		 stuff.addTile(78,104,5,5);//43 
		 stuff.addTile(26,129,28,17);//44 
		 stuff.addTile(56,141,14,9);//45 
		 stuff.addTile(54,128,18,13);//46 
		 stuff.addTile(56,150,16,8);//47 
		 stuff.addTile(26,146,30,12);//48 
		 stuff.addTile(72,110,12,13);//49 
		 stuff.addTile(72,123,13,8);//50 
		 stuff.addTile(0,161,21,21);//51 
		 stuff.addTile(21,161,21,21);//52 
		 stuff.addTile(42,158,21,21);//53 
		 stuff.addTile(72,131,10,15);//54 
		 stuff.addTile(72,146,10,12);//55 
		 stuff.addTile(63,158,10,7);//56 
		
		stuff.gc();
		
		return stuff;
	}
	
 
	// Images : battleMapTile1 
	final static public IImages createClipImages_battleMapTile1(){
		IImages stuff = new CImages20();
		stuff.buildImages(CIO.loadImage("/battleMapTile1.png"),34);
		
		 stuff.addTile(176,0,16,16);//0 
		 stuff.addTile(0,32,16,16);//1 
		 stuff.addTile(16,32,16,16);//2 
		 stuff.addTile(32,32,16,16);//3 
		 stuff.addTile(48,32,16,16);//4 
		 stuff.addTile(64,32,16,16);//5 
		 stuff.addTile(0,0,16,16);//6 
		 stuff.addTile(16,0,16,16);//7 
		 stuff.addTile(32,0,16,16);//8 
		 stuff.addTile(48,0,16,16);//9 
		 stuff.addTile(64,0,16,16);//10 
		 stuff.addTile(80,0,16,16);//11 
		 stuff.addTile(96,0,16,16);//12 
		 stuff.addTile(112,0,16,16);//13 
		 stuff.addTile(128,0,16,16);//14 
		 stuff.addTile(144,0,16,16);//15 
		 stuff.addTile(160,0,16,16);//16 
		 stuff.addTile(0,16,16,16);//17 
		 stuff.addTile(16,16,16,16);//18 
		 stuff.addTile(32,16,16,16);//19 
		 stuff.addTile(48,16,16,16);//20 
		 stuff.addTile(64,16,16,16);//21 
		 stuff.addTile(80,16,16,16);//22 
		 stuff.addTile(96,16,16,16);//23 
		 stuff.addTile(112,16,16,16);//24 
		 stuff.addTile(128,16,16,16);//25 
		 stuff.addTile(144,16,16,16);//26 
		 stuff.addTile(160,16,16,16);//27 
		 stuff.addTile(80,32,16,16);//28 
		 stuff.addTile(96,32,16,16);//29 
		 stuff.addTile(112,32,16,16);//30 
		 stuff.addTile(128,32,16,16);//31 
		 stuff.addTile(144,32,16,16);//32 
		 stuff.addTile(160,32,16,16);//33 
		
		stuff.gc();
		
		return stuff;
	}
	
 
	// Images : battleMapTile2 
	final static public IImages createClipImages_battleMapTile2(){
		IImages stuff = new CImages20();
		stuff.buildImages(CIO.loadImage("/battleMapTile2.png"),13);
		
		 stuff.addTile(0,0,16,16);//0 
		 stuff.addTile(0,16,16,16);//1 
		 stuff.addTile(0,32,16,16);//2 
		 stuff.addTile(0,48,16,16);//3 
		 stuff.addTile(0,64,16,16);//4 
		 stuff.addTile(16,0,16,16);//5 
		 stuff.addTile(16,16,16,16);//6 
		 stuff.addTile(16,32,16,16);//7 
		 stuff.addTile(16,48,16,16);//8 
		 stuff.addTile(0,80,16,16);//9 
		 stuff.addTile(16,64,16,16);//10 
		 stuff.addTile(16,80,16,16);//11 
		 stuff.addTile(0,96,16,16);//12 
		
		stuff.gc();
		
		return stuff;
	}
	
 
	// Images : battleBGTile 
	final static public IImages createClipImages_battleBGTile(){
		IImages stuff = new CImages20();
		stuff.buildImages(CIO.loadImage("/battleBGTile.png"),2);
		
		 stuff.addTile(0,0,176,23);//0 
		 stuff.addTile(0,23,176,22);//1 
		
		stuff.gc();
		
		return stuff;
	}
	
 
	// Images : boss1Tile 
	final static public IImages createClipImages_boss1Tile(){
		IImages stuff = new CImages20();
		stuff.buildImages(CIO.loadImage("/boss1Tile.png"),7);
		
		 stuff.addTile(0,0,46,25);//0 
		 stuff.addTile(0,25,43,23);//1 
		 stuff.addTile(0,48,10,7);//2 
		 stuff.addTile(10,48,8,5);//3 
		 stuff.addTile(18,48,5,5);//4 
		 stuff.addTile(0,55,46,25);//5 
		 stuff.addTile(23,48,1,1);//6 
		
		stuff.gc();
		
		return stuff;
	}
	
 
	// Images : boss2Tile 
	final static public IImages createClipImages_boss2Tile(){
		IImages stuff = new CImages20();
		stuff.buildImages(CIO.loadImage("/boss2Tile.png"),6);
		
		 stuff.addTile(0,0,99,103);//0 
		 stuff.addTile(0,103,23,19);//1 
		 stuff.addTile(81,103,17,16);//2 
		 stuff.addTile(47,103,17,16);//3 
		 stuff.addTile(64,103,17,16);//4 
		 stuff.addTile(23,103,24,23);//5 
		
		stuff.gc();
		
		return stuff;
	}
	
 
	// Images : boss3Tile 
	final static public IImages createClipImages_boss3Tile(){
		IImages stuff = new CImages20();
		stuff.buildImages(CIO.loadImage("/boss3Tile.png"),8);
		
		 stuff.addTile(0,0,10,13);//0 
		 stuff.addTile(0,14,20,16);//1 
		 stuff.addTile(0,30,20,17);//2 
		 stuff.addTile(10,0,10,14);//3 
		 stuff.addTile(0,61,14,6);//4 
		 stuff.addTile(0,67,14,3);//5 
		 stuff.addTile(10,47,10,14);//6 
		 stuff.addTile(0,47,10,13);//7 
		
		stuff.gc();
		
		return stuff;
	}
	
 
	// Images : battleMapTile3 
	final static public IImages createClipImages_battleMapTile3(){
		IImages stuff = new CImages20();
		stuff.buildImages(CIO.loadImage("/battleMapTile3.png"),22);
		
		 stuff.addTile(0,0,16,16);//0 
		 stuff.addTile(0,16,16,16);//1 
		 stuff.addTile(0,32,16,16);//2 
		 stuff.addTile(0,48,16,16);//3 
		 stuff.addTile(0,64,16,16);//4 
		 stuff.addTile(0,80,16,16);//5 
		 stuff.addTile(0,96,16,16);//6 
		 stuff.addTile(0,112,16,16);//7 
		 stuff.addTile(0,128,16,16);//8 
		 stuff.addTile(0,144,16,16);//9 
		 stuff.addTile(0,160,16,16);//10 
		 stuff.addTile(16,160,16,16);//11 
		 stuff.addTile(16,80,16,16);//12 
		 stuff.addTile(16,0,16,16);//13 
		 stuff.addTile(16,96,16,16);//14 
		 stuff.addTile(16,16,16,16);//15 
		 stuff.addTile(16,112,16,16);//16 
		 stuff.addTile(16,32,16,16);//17 
		 stuff.addTile(16,128,16,16);//18 
		 stuff.addTile(16,48,16,16);//19 
		 stuff.addTile(16,144,16,16);//20 
		 stuff.addTile(16,64,16,16);//21 
		
		stuff.gc();
		
		return stuff;
	}
	
 
	// Images : boss4Tile 
	final static public IImages createClipImages_boss4Tile(){
		IImages stuff = new CImages20();
		stuff.buildImages(CIO.loadImage("/boss4Tile.png"),2);
		
		 stuff.addTile(0,0,78,58);//0 
		 stuff.addTile(0,58,78,58);//1 
		
		stuff.gc();
		
		return stuff;
	}
	
 
	// Images : boss5Tile 
	final static public IImages createClipImages_boss5Tile(){
		IImages stuff = new CImages20();
		stuff.buildImages(CIO.loadImage("/boss5Tile.png"),9);
		
		 stuff.addTile(17,17,17,8);//0 
		 stuff.addTile(7,17,5,6);//1 
		 stuff.addTile(0,0,39,17);//2 
		 stuff.addTile(7,26,17,7);//3 
		 stuff.addTile(0,17,7,10);//4 
		 stuff.addTile(12,17,5,8);//5 
		 stuff.addTile(7,23,5,2);//6 
		 stuff.addTile(7,25,14,1);//7 
		 stuff.addTile(24,25,5,5);//8 
		
		stuff.gc();
		
		return stuff;
	}
	
 
	// Images : battleUITile 
	final static public IImages createClipImages_battleUITile(){
		IImages stuff = new CImages20();
		stuff.buildImages(CIO.loadImage("/battleUITile.png"),28);
		
		 stuff.addTile(76,9,1,9);//0 
		 stuff.addTile(77,9,27,27);//1 
		 stuff.addTile(0,9,73,10);//2 
		 stuff.addTile(73,9,1,1);//3 
		 stuff.addTile(0,0,104,9);//4 
		 stuff.addTile(61,19,16,17);//5 
		 stuff.addTile(0,19,10,13);//6 
		 stuff.addTile(10,19,10,13);//7 
		 stuff.addTile(20,19,10,13);//8 
		 stuff.addTile(30,19,10,13);//9 
		 stuff.addTile(40,19,10,13);//10 
		 stuff.addTile(50,19,10,13);//11 
		 stuff.addTile(0,32,10,13);//12 
		 stuff.addTile(20,32,10,13);//13 
		 stuff.addTile(10,32,10,13);//14 
		 stuff.addTile(30,32,10,13);//15 
		 stuff.addTile(40,32,7,7);//16 
		 stuff.addTile(47,32,7,7);//17 
		 stuff.addTile(54,32,7,7);//18 
		 stuff.addTile(40,39,7,7);//19 
		 stuff.addTile(47,39,7,7);//20 
		 stuff.addTile(54,39,7,7);//21 
		 stuff.addTile(61,39,7,7);//22 
		 stuff.addTile(68,36,7,7);//23 
		 stuff.addTile(75,36,7,7);//24 
		 stuff.addTile(82,36,7,7);//25 
		 stuff.addTile(104,0,9,32);//26 
		 stuff.addTile(68,43,30,4);//27 
		
		stuff.gc();
		
		return stuff;
	}
	


	//--------------------------------------------------------------------------------------------------------------
	
	// Map : 01_Map
	final static public CMap createMap_01_Map(IImages tiles,boolean isAnimate,boolean isCyc){
		
		//22 x 20
		
		// tiles
	    CAnimates animates = new CAnimates(32,tiles);
	     animates.addPart(0,0,0,0);//0
		 animates.addPart(0,0,28,0);//1
		 animates.addPart(0,0,29,0);//2
		 animates.addPart(0,0,30,0);//3
		 animates.addPart(0,0,31,0);//4
		 animates.addPart(0,0,32,0);//5
		 animates.addPart(0,0,33,0);//6
		 animates.addPart(0,0,3,0);//7
		 animates.addPart(0,0,4,0);//8
		 animates.addPart(0,0,5,0);//9
		 animates.addPart(0,0,6,0);//10
		 animates.addPart(0,0,7,0);//11
		 animates.addPart(0,0,8,0);//12
		 animates.addPart(0,0,9,0);//13
		 animates.addPart(0,0,10,0);//14
		 animates.addPart(0,0,11,0);//15
		 animates.addPart(0,0,12,0);//16
		 animates.addPart(0,0,13,0);//17
		 animates.addPart(0,0,14,0);//18
		 animates.addPart(0,0,15,0);//19
		 animates.addPart(0,0,16,0);//20
		 animates.addPart(0,0,17,0);//21
		 animates.addPart(0,0,18,0);//22
		 animates.addPart(0,0,19,0);//23
		 animates.addPart(0,0,20,0);//24
		 animates.addPart(0,0,21,0);//25
		 animates.addPart(0,0,22,0);//26
		 animates.addPart(0,0,23,0);//27
		 animates.addPart(0,0,24,0);//28
		 animates.addPart(0,0,25,0);//29
		 animates.addPart(0,0,26,0);//30
		 animates.addPart(0,0,27,0);//31
		
		
	    animates.setFrame(new int[32][]);
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
		
		
		short[][] tileMatrix = new short[][]{
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{1,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,3,4,5,6,1,2,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,3,4,5,6,0,0,0,0,0,0,0,0,1,2,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,3,4,5,6,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,1,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,3,4,5,6,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,},
{8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,},
{9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,},
{10,11,12,13,14,15,16,17,18,19,20,10,11,12,13,14,15,16,17,18,19,20,},
{21,22,23,24,25,26,27,28,29,30,31,21,22,23,24,25,26,27,28,29,30,31,},

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
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},

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
	

	// Map : 02_Map
	final static public CMap createMap_02_Map(IImages tiles,boolean isAnimate,boolean isCyc){
		
		//22 x 20
		
		// tiles
	    CAnimates animates = new CAnimates(12,tiles);
	     animates.addPart(0,0,0,0);//0
		 animates.addPart(0,0,9,0);//1
		 animates.addPart(0,0,10,0);//2
		 animates.addPart(0,0,12,0);//3
		 animates.addPart(0,0,7,0);//4
		 animates.addPart(0,0,8,0);//5
		 animates.addPart(0,0,1,0);//6
		 animates.addPart(0,0,2,0);//7
		 animates.addPart(0,0,3,0);//8
		 animates.addPart(0,0,4,0);//9
		 animates.addPart(0,0,5,0);//10
		 animates.addPart(0,0,6,0);//11
		
		
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
		
		
		short[][] tileMatrix = new short[][]{
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,1,2,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,4,5,0,0,0,0,},
{0,0,0,0,0,0,4,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,1,2,3,0,0,0,0,1,2,3,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,4,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,1,2,3,0,0,0,0,0,0,4,5,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,},
{7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,},
{8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,},
{9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,},
{10,11,10,11,10,11,10,11,10,11,10,11,10,11,10,11,10,11,10,11,10,11,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},

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
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},

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
	

	// Map : 03_Map
	final static public CMap createMap_03_Map(IImages tiles,boolean isAnimate,boolean isCyc){
		
		//22 x 20
		
		// tiles
	    CAnimates animates = new CAnimates(18,tiles);
	     animates.addPart(0,0,0,0);//0
		 animates.addPart(0,0,6,0);//1
		 animates.addPart(0,0,7,0);//2
		 animates.addPart(0,0,8,0);//3
		 animates.addPart(0,0,9,0);//4
		 animates.addPart(0,0,10,0);//5
		 animates.addPart(0,0,11,0);//6
		 animates.addPart(0,0,3,0);//7
		 animates.addPart(0,0,12,0);//8
		 animates.addPart(0,0,13,0);//9
		 animates.addPart(0,0,20,0);//10
		 animates.addPart(0,0,21,0);//11
		 animates.addPart(0,0,16,0);//12
		 animates.addPart(0,0,17,0);//13
		 animates.addPart(0,0,18,0);//14
		 animates.addPart(0,0,19,0);//15
		 animates.addPart(0,0,14,0);//16
		 animates.addPart(0,0,15,0);//17
		
		
	    animates.setFrame(new int[18][]);
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
		 animates.setComboFrame(new int[]{16,16,16,16,10,10,10,10,},16);//16
		 animates.setComboFrame(new int[]{17,17,17,17,11,11,11,11,},17);//17
		
		
		short[][] tileMatrix = new short[][]{
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,3,4,5,6,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,1,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3,4,5,6,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,},
{8,9,8,9,8,9,8,9,8,9,8,9,8,9,8,9,8,9,8,9,8,9,},
{-16,-17,-16,-17,-16,-17,-16,-17,-16,-17,-16,-17,-16,-17,-16,-17,-16,-17,-16,-17,-16,-17,},
{12,13,12,13,12,13,12,13,12,13,12,13,12,13,12,13,12,13,12,13,12,13,},
{14,15,14,15,14,15,14,15,14,15,14,15,14,15,14,15,14,15,14,15,14,15,},

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
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},

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
	
	// Sprite : wpMissile1
	final static public CSprite createSprite_wpMissile1(IImages tiles){

	    // tiles
	    CAnimates animates = new CAnimates(24,tiles);
	     animates.addPart(-7,-4,12,0);//0
		 animates.addPart(-12,-1,46,0);//1
		 animates.addPart(-9,-1,47,0);//2
		 animates.addPart(-7,-7,13,0);//3
		 animates.addPart(-8,-8,48,0);//4
		 animates.addPart(-7,-7,49,0);//5
		 animates.addPart(-4,-7,12,5);//6
		 animates.addPart(-1,-12,58,0);//7
		 animates.addPart(-1,-9,59,0);//8
		 animates.addPart(-5,-7,13,5);//9
		 animates.addPart(4,-8,52,0);//10
		 animates.addPart(4,-7,53,0);//11
		 animates.addPart(-6,-4,12,3);//12
		 animates.addPart(7,-1,54,0);//13
		 animates.addPart(8,-1,55,0);//14
		 animates.addPart(-5,-5,13,3);//15
		 animates.addPart(4,4,56,0);//16
		 animates.addPart(4,4,57,0);//17
		 animates.addPart(-4,-6,12,6);//18
		 animates.addPart(-1,7,50,0);//19
		 animates.addPart(-1,8,51,0);//20
		 animates.addPart(-7,-5,13,6);//21
		 animates.addPart(-8,4,60,0);//22
		 animates.addPart(-7,4,61,0);//23
		
		
	    animates.setFrame(new int[16][]);
	     animates.setComboFrame(new int[]{0,1,},0);//0
		 animates.setComboFrame(new int[]{0,2,},1);//1
		 animates.setComboFrame(new int[]{3,4,},2);//2
		 animates.setComboFrame(new int[]{3,5,},3);//3
		 animates.setComboFrame(new int[]{6,7,},4);//4
		 animates.setComboFrame(new int[]{6,8,},5);//5
		 animates.setComboFrame(new int[]{9,10,},6);//6
		 animates.setComboFrame(new int[]{9,11,},7);//7
		 animates.setComboFrame(new int[]{12,13,},8);//8
		 animates.setComboFrame(new int[]{12,14,},9);//9
		 animates.setComboFrame(new int[]{15,16,},10);//10
		 animates.setComboFrame(new int[]{15,17,},11);//11
		 animates.setComboFrame(new int[]{18,19,},12);//12
		 animates.setComboFrame(new int[]{18,20,},13);//13
		 animates.setComboFrame(new int[]{21,22,},14);//14
		 animates.setComboFrame(new int[]{21,23,},15);//15
		
		
		// cds
	    CCollides collides = new CCollides(5);
		 collides.addCDRect(65535, -3, -2, 4 , 4 );//rect//0
	     collides.addCDRect(65535, -2, -2, 4 , 4 );//rect//1
	     collides.addCDRect(65535, -2, -3, 4 , 4 );//rect//2
	     collides.addCDRect(65535, 0, -2, 4 , 4 );//rect//3
	     collides.addCDRect(65535, -2, -1, 4 , 4 );//rect//4
	    
	    
	    collides.setFrame(new int[6][]);
	     collides.setComboFrame(new int[]{0,},0);//0
	     collides.setComboFrame(new int[]{},1);//1
	     collides.setComboFrame(new int[]{1,},2);//2
	     collides.setComboFrame(new int[]{2,},3);//3
	     collides.setComboFrame(new int[]{3,},4);//4
	     collides.setComboFrame(new int[]{4,},5);//5
	    
	    
	    
		// sprite frame
/*
		String[] frameName = new String[]{
			"0000",
"0001",
"0002",
"0003",
"0004",
"0005",
"0006",
"0007",

		};
		
		for(int i=0;i<frameName.length;i++){
			System.out.println(frameName[i]);
		}
*/
	    int[][] frameAnimate = new int[][]{
	        {0,1,},
{2,3,},
{4,5,},
{6,7,},
{8,9,},
{10,11,},
{12,13,},
{14,15,},

	    };
	    int[][] frameCDMap = new int[][]{
	        {0,0,},
{2,2,},
{3,3,},
{2,2,},
{4,4,},
{2,2,},
{5,5,},
{2,2,},

	    };
	    int[][] frameCDAtk = new int[][]{
	        {1,1,},
{1,1,},
{1,1,},
{1,1,},
{1,1,},
{1,1,},
{1,1,},
{1,1,},

	    };
	    int[][] frameCDDef = new int[][]{
	        {1,1,},
{1,1,},
{1,1,},
{1,1,},
{1,1,},
{1,1,},
{1,1,},
{1,1,},

	    };
	    int[][] frameCDExt = new int[][]{
	        {1,1,},
{1,1,},
{1,1,},
{1,1,},
{1,1,},
{1,1,},
{1,1,},
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
	

	// Sprite : wpMissile2
	final static public CSprite createSprite_wpMissile2(IImages tiles){

	    // tiles
	    CAnimates animates = new CAnimates(24,tiles);
	     animates.addPart(-6,-4,4,0);//0
		 animates.addPart(-11,-2,46,0);//1
		 animates.addPart(-8,-2,47,0);//2
		 animates.addPart(-5,-5,5,0);//3
		 animates.addPart(-7,-7,48,0);//4
		 animates.addPart(-6,-6,49,0);//5
		 animates.addPart(-3,-6,4,5);//6
		 animates.addPart(-1,-11,58,0);//7
		 animates.addPart(-1,-8,59,0);//8
		 animates.addPart(-5,-5,5,5);//9
		 animates.addPart(3,-7,52,0);//10
		 animates.addPart(3,-6,53,0);//11
		 animates.addPart(-7,-3,4,3);//12
		 animates.addPart(6,-1,54,0);//13
		 animates.addPart(6,-1,55,0);//14
		 animates.addPart(-5,-5,5,3);//15
		 animates.addPart(3,3,56,0);//16
		 animates.addPart(3,3,57,0);//17
		 animates.addPart(-4,-7,4,6);//18
		 animates.addPart(-2,6,50,0);//19
		 animates.addPart(-2,6,51,0);//20
		 animates.addPart(-5,-5,5,6);//21
		 animates.addPart(-7,3,60,0);//22
		 animates.addPart(-6,3,61,0);//23
		
		
	    animates.setFrame(new int[16][]);
	     animates.setComboFrame(new int[]{0,1,},0);//0
		 animates.setComboFrame(new int[]{0,2,},1);//1
		 animates.setComboFrame(new int[]{3,4,},2);//2
		 animates.setComboFrame(new int[]{3,5,},3);//3
		 animates.setComboFrame(new int[]{6,7,},4);//4
		 animates.setComboFrame(new int[]{6,8,},5);//5
		 animates.setComboFrame(new int[]{9,10,},6);//6
		 animates.setComboFrame(new int[]{9,11,},7);//7
		 animates.setComboFrame(new int[]{12,13,},8);//8
		 animates.setComboFrame(new int[]{12,14,},9);//9
		 animates.setComboFrame(new int[]{15,16,},10);//10
		 animates.setComboFrame(new int[]{15,17,},11);//11
		 animates.setComboFrame(new int[]{18,19,},12);//12
		 animates.setComboFrame(new int[]{18,20,},13);//13
		 animates.setComboFrame(new int[]{21,22,},14);//14
		 animates.setComboFrame(new int[]{21,23,},15);//15
		
		
		// cds
	    CCollides collides = new CCollides(5);
		 collides.addCDRect(65535, -2, -2, 4 , 3 );//rect//0
	     collides.addCDRect(65535, -2, -1, 4 , 3 );//rect//1
	     collides.addCDRect(65535, -1, -1, 3 , 3 );//rect//2
	     collides.addCDRect(65535, -2, -1, 3 , 4 );//rect//3
	     collides.addCDRect(65535, -2, -1, 3 , 3 );//rect//4
	    
	    
	    collides.setFrame(new int[6][]);
	     collides.setComboFrame(new int[]{0,},0);//0
	     collides.setComboFrame(new int[]{},1);//1
	     collides.setComboFrame(new int[]{1,},2);//2
	     collides.setComboFrame(new int[]{2,},3);//3
	     collides.setComboFrame(new int[]{3,},4);//4
	     collides.setComboFrame(new int[]{4,},5);//5
	    
	    
	    
		// sprite frame
/*
		String[] frameName = new String[]{
			"0000",
"0001",
"0002",
"0003",
"0004",
"0005",
"0006",
"0007",

		};
		
		for(int i=0;i<frameName.length;i++){
			System.out.println(frameName[i]);
		}
*/
	    int[][] frameAnimate = new int[][]{
	        {0,1,},
{2,3,},
{4,5,},
{6,7,},
{8,9,},
{10,11,},
{12,13,},
{14,15,},

	    };
	    int[][] frameCDMap = new int[][]{
	        {0,0,},
{2,2,},
{3,3,},
{2,2,},
{2,2,},
{2,2,},
{4,5,},
{2,2,},

	    };
	    int[][] frameCDAtk = new int[][]{
	        {1,1,},
{1,1,},
{1,1,},
{1,1,},
{1,1,},
{1,1,},
{1,1,},
{1,1,},

	    };
	    int[][] frameCDDef = new int[][]{
	        {1,1,},
{1,1,},
{1,1,},
{1,1,},
{1,1,},
{1,1,},
{1,1,},
{1,1,},

	    };
	    int[][] frameCDExt = new int[][]{
	        {1,1,},
{1,1,},
{1,1,},
{1,1,},
{1,1,},
{1,1,},
{1,1,},
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
	

	// Sprite : wpLaser
	final static public CSprite createSprite_wpLaser(IImages tiles){

	    // tiles
	    CAnimates animates = new CAnimates(61,tiles);
	     animates.addPart(-10,-10,15,0);//0
		 animates.addPart(0,-10,15,2);//1
		 animates.addPart(100,-10,15,2);//2
		 animates.addPart(0,-10,16,0);//3
		 animates.addPart(10,-10,16,0);//4
		 animates.addPart(20,-10,16,0);//5
		 animates.addPart(30,-10,16,0);//6
		 animates.addPart(40,-10,16,0);//7
		 animates.addPart(50,-10,16,0);//8
		 animates.addPart(60,-10,16,0);//9
		 animates.addPart(70,-10,16,0);//10
		 animates.addPart(80,-10,16,0);//11
		 animates.addPart(90,-10,16,0);//12
		 animates.addPart(99,-10,17,3);//13
		 animates.addPart(0,-10,18,0);//14
		 animates.addPart(10,-10,18,0);//15
		 animates.addPart(20,-10,18,0);//16
		 animates.addPart(30,-10,18,0);//17
		 animates.addPart(40,-10,18,0);//18
		 animates.addPart(50,-10,18,0);//19
		 animates.addPart(60,-10,18,0);//20
		 animates.addPart(70,-10,18,0);//21
		 animates.addPart(79,-10,18,0);//22
		 animates.addPart(89,-10,18,0);//23
		 animates.addPart(-10,-10,17,0);//24
		 animates.addPart(100,-7,19,3);//25
		 animates.addPart(10,-7,20,0);//26
		 animates.addPart(20,-7,20,0);//27
		 animates.addPart(30,-7,20,0);//28
		 animates.addPart(40,-7,20,0);//29
		 animates.addPart(50,-7,20,0);//30
		 animates.addPart(60,-7,20,0);//31
		 animates.addPart(70,-7,20,0);//32
		 animates.addPart(80,-7,20,0);//33
		 animates.addPart(90,-7,20,0);//34
		 animates.addPart(0,-7,20,0);//35
		 animates.addPart(-10,-7,19,0);//36
		 animates.addPart(100,-4,21,3);//37
		 animates.addPart(30,-4,22,0);//38
		 animates.addPart(10,-4,22,0);//39
		 animates.addPart(0,-4,22,0);//40
		 animates.addPart(40,-4,22,0);//41
		 animates.addPart(50,-4,22,0);//42
		 animates.addPart(20,-4,22,0);//43
		 animates.addPart(60,-4,22,0);//44
		 animates.addPart(70,-4,22,0);//45
		 animates.addPart(80,-4,22,0);//46
		 animates.addPart(90,-4,22,0);//47
		 animates.addPart(-10,-4,21,0);//48
		 animates.addPart(-10,-1,23,0);//49
		 animates.addPart(10,-1,24,0);//50
		 animates.addPart(0,-1,24,0);//51
		 animates.addPart(90,-1,24,0);//52
		 animates.addPart(40,-1,24,0);//53
		 animates.addPart(20,-1,24,0);//54
		 animates.addPart(70,-1,24,0);//55
		 animates.addPart(30,-1,24,0);//56
		 animates.addPart(50,-1,24,0);//57
		 animates.addPart(60,-1,24,0);//58
		 animates.addPart(80,-1,24,0);//59
		 animates.addPart(100,-1,23,3);//60
		
		
	    animates.setFrame(new int[6][]);
	     animates.setComboFrame(new int[]{0,1,},0);//0
		 animates.setComboFrame(new int[]{0,2,3,4,5,6,7,8,9,10,11,12,},1);//1
		 animates.setComboFrame(new int[]{13,14,15,16,17,18,19,20,21,22,23,24,},2);//2
		 animates.setComboFrame(new int[]{25,26,27,28,29,30,31,32,33,34,35,36,},3);//3
		 animates.setComboFrame(new int[]{37,38,39,40,41,42,43,44,45,46,47,48,},4);//4
		 animates.setComboFrame(new int[]{49,50,51,52,53,54,55,56,57,58,59,60,},5);//5
		
		
		// cds
	    CCollides collides = new CCollides(4);
		 collides.addCDRect(65535, -9, -6, 18 , 12 );//rect//0
	     collides.addCDRect(65535, -9, -9, 119 , 19 );//rect//1
	     collides.addCDRect(65535, -9, -3, 119 , 7 );//rect//2
	     collides.addCDRect(65535, -9, 0, 119 , 1 );//rect//3
	    
	    
	    collides.setFrame(new int[5][]);
	     collides.setComboFrame(new int[]{0,},0);//0
	     collides.setComboFrame(new int[]{},1);//1
	     collides.setComboFrame(new int[]{1,},2);//2
	     collides.setComboFrame(new int[]{2,},3);//3
	     collides.setComboFrame(new int[]{3,},4);//4
	    
	    
	    
		// sprite frame
/*
		String[] frameName = new String[]{
			"0000",

		};
		
		for(int i=0;i<frameName.length;i++){
			System.out.println(frameName[i]);
		}
*/
	    int[][] frameAnimate = new int[][]{
	        {0,1,1,2,1,2,1,2,1,2,1,2,3,4,5,},

	    };
	    int[][] frameCDMap = new int[][]{
	        {0,2,2,2,2,2,2,2,2,2,2,2,2,3,4,},

	    };
	    int[][] frameCDAtk = new int[][]{
	        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,},

	    };
	    int[][] frameCDDef = new int[][]{
	        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,},

	    };
	    int[][] frameCDExt = new int[][]{
	        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,},

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
	

	// Sprite : wpBomb
	final static public CSprite createSprite_wpBomb(IImages tiles){

	    // tiles
	    CAnimates animates = new CAnimates(4,tiles);
	     animates.addPart(-12,-4,32,0);//0
		 animates.addPart(-7,-3,31,0);//1
		 animates.addPart(-12,-4,33,0);//2
		 animates.addPart(-12,-4,34,0);//3
		
		
	    animates.setFrame(new int[3][]);
	     animates.setComboFrame(new int[]{0,1,},0);//0
		 animates.setComboFrame(new int[]{2,1,},1);//1
		 animates.setComboFrame(new int[]{3,1,},2);//2
		
		
		// cds
	    CCollides collides = new CCollides(1);
		 collides.addCDRect(65535, -9, -3, 15 , 5 );//rect//0
	    
	    
	    collides.setFrame(new int[2][]);
	     collides.setComboFrame(new int[]{0,},0);//0
	     collides.setComboFrame(new int[]{},1);//1
	    
	    
	    
		// sprite frame
/*
		String[] frameName = new String[]{
			"0000",

		};
		
		for(int i=0;i<frameName.length;i++){
			System.out.println(frameName[i]);
		}
*/
	    int[][] frameAnimate = new int[][]{
	        {0,1,2,},

	    };
	    int[][] frameCDMap = new int[][]{
	        {0,0,0,},

	    };
	    int[][] frameCDAtk = new int[][]{
	        {1,1,1,},

	    };
	    int[][] frameCDDef = new int[][]{
	        {1,1,1,},

	    };
	    int[][] frameCDExt = new int[][]{
	        {1,1,1,},

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
	

	// Sprite : wpShortSlug1
	final static public CSprite createSprite_wpShortSlug1(IImages tiles){

	    // tiles
	    CAnimates animates = new CAnimates(1,tiles);
	     animates.addPart(-4,-2,43,0);//0
		
		
	    animates.setFrame(new int[1][]);
	     animates.setComboFrame(new int[]{0,},0);//0
		
		
		// cds
	    CCollides collides = new CCollides(1);
		 collides.addCDRect(65535, -2, -2, 5 , 4 );//rect//0
	    
	    
	    collides.setFrame(new int[2][]);
	     collides.setComboFrame(new int[]{0,},0);//0
	     collides.setComboFrame(new int[]{},1);//1
	    
	    
	    
		// sprite frame
/*
		String[] frameName = new String[]{
			"0000",

		};
		
		for(int i=0;i<frameName.length;i++){
			System.out.println(frameName[i]);
		}
*/
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
	

	// Sprite : wpLight1
	final static public CSprite createSprite_wpLight1(IImages tiles){

	    // tiles
	    CAnimates animates = new CAnimates(1,tiles);
	     animates.addPart(-11,-2,14,0);//0
		
		
	    animates.setFrame(new int[1][]);
	     animates.setComboFrame(new int[]{0,},0);//0
		
		
		// cds
	    CCollides collides = new CCollides(1);
		 collides.addCDRect(65535, -6, -1, 15 , 2 );//rect//0
	    
	    
	    collides.setFrame(new int[2][]);
	     collides.setComboFrame(new int[]{0,},0);//0
	     collides.setComboFrame(new int[]{},1);//1
	    
	    
	    
		// sprite frame
/*
		String[] frameName = new String[]{
			"0000",

		};
		
		for(int i=0;i<frameName.length;i++){
			System.out.println(frameName[i]);
		}
*/
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
	

	// Sprite : wpBombExp
	final static public CSprite createSprite_wpBombExp(IImages tiles){

	    // tiles
	    CAnimates animates = new CAnimates(3,tiles);
	     animates.addPart(-9,-6,1,0);//0
		 animates.addPart(-22,-4,44,0);//1
		 animates.addPart(-27,-2,45,0);//2
		
		
	    animates.setFrame(new int[3][]);
	     animates.setComboFrame(new int[]{0,1,},0);//0
		 animates.setComboFrame(new int[]{0,2,},1);//1
		 animates.setComboFrame(new int[]{},2);//2
		
		
		// cds
	    CCollides collides = new CCollides(2);
		 collides.addCDRect(65535, -9, -3, 18 , 5 );//rect//0
	     collides.addCDRect(65535, -18, -19, 36 , 36 );//rect//1
	    
	    
	    collides.setFrame(new int[3][]);
	     collides.setComboFrame(new int[]{0,},0);//0
	     collides.setComboFrame(new int[]{},1);//1
	     collides.setComboFrame(new int[]{1,},2);//2
	    
	    
	    
		// sprite frame
/*
		String[] frameName = new String[]{
			"0000",
"0001",

		};
		
		for(int i=0;i<frameName.length;i++){
			System.out.println(frameName[i]);
		}
*/
	    int[][] frameAnimate = new int[][]{
	        {0,0,1,},
{2,},

	    };
	    int[][] frameCDMap = new int[][]{
	        {0,0,0,},
{2,},

	    };
	    int[][] frameCDAtk = new int[][]{
	        {1,1,1,},
{1,},

	    };
	    int[][] frameCDDef = new int[][]{
	        {1,1,1,},
{1,},

	    };
	    int[][] frameCDExt = new int[][]{
	        {1,1,1,},
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
	

	// Sprite : wpShortSlug2
	final static public CSprite createSprite_wpShortSlug2(IImages tiles){

	    // tiles
	    CAnimates animates = new CAnimates(2,tiles);
	     animates.addPart(-2,-2,2,0);//0
		 animates.addPart(-2,-2,3,0);//1
		
		
	    animates.setFrame(new int[2][]);
	     animates.setComboFrame(new int[]{0,},0);//0
		 animates.setComboFrame(new int[]{1,},1);//1
		
		
		// cds
	    CCollides collides = new CCollides(1);
		 collides.addCDRect(65535, -1, -2, 3 , 3 );//rect//0
	    
	    
	    collides.setFrame(new int[2][]);
	     collides.setComboFrame(new int[]{0,},0);//0
	     collides.setComboFrame(new int[]{},1);//1
	    
	    
	    
		// sprite frame
/*
		String[] frameName = new String[]{
			"0000",

		};
		
		for(int i=0;i<frameName.length;i++){
			System.out.println(frameName[i]);
		}
*/
	    int[][] frameAnimate = new int[][]{
	        {0,0,1,},

	    };
	    int[][] frameCDMap = new int[][]{
	        {0,0,0,},

	    };
	    int[][] frameCDAtk = new int[][]{
	        {1,1,1,},

	    };
	    int[][] frameCDDef = new int[][]{
	        {1,1,1,},

	    };
	    int[][] frameCDExt = new int[][]{
	        {1,1,1,},

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
	

	// Sprite : wpLight2
	final static public CSprite createSprite_wpLight2(IImages tiles){

	    // tiles
	    CAnimates animates = new CAnimates(1,tiles);
	     animates.addPart(-9,-1,0,0);//0
		
		
	    animates.setFrame(new int[1][]);
	     animates.setComboFrame(new int[]{0,},0);//0
		
		
		// cds
	    CCollides collides = new CCollides(1);
		 collides.addCDRect(65535, -9, -1, 12 , 2 );//rect//0
	    
	    
	    collides.setFrame(new int[2][]);
	     collides.setComboFrame(new int[]{0,},0);//0
	     collides.setComboFrame(new int[]{},1);//1
	    
	    
	    
		// sprite frame
/*
		String[] frameName = new String[]{
			"0000",

		};
		
		for(int i=0;i<frameName.length;i++){
			System.out.println(frameName[i]);
		}
*/
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
	

	// Sprite : wpRocket
	final static public CSprite createSprite_wpRocket(IImages tiles){

	    // tiles
	    CAnimates animates = new CAnimates(3,tiles);
	     animates.addPart(-9,-6,30,0);//0
		 animates.addPart(-23,-4,62,0);//1
		 animates.addPart(-27,-2,63,0);//2
		
		
	    animates.setFrame(new int[2][]);
	     animates.setComboFrame(new int[]{0,1,},0);//0
		 animates.setComboFrame(new int[]{0,2,},1);//1
		
		
		// cds
	    CCollides collides = new CCollides(1);
		 collides.addCDRect(65535, -8, -2, 16 , 3 );//rect//0
	    
	    
	    collides.setFrame(new int[2][]);
	     collides.setComboFrame(new int[]{0,},0);//0
	     collides.setComboFrame(new int[]{},1);//1
	    
	    
	    
		// sprite frame
/*
		String[] frameName = new String[]{
			"0000",

		};
		
		for(int i=0;i<frameName.length;i++){
			System.out.println(frameName[i]);
		}
*/
	    int[][] frameAnimate = new int[][]{
	        {0,1,},

	    };
	    int[][] frameCDMap = new int[][]{
	        {0,0,},

	    };
	    int[][] frameCDAtk = new int[][]{
	        {1,1,},

	    };
	    int[][] frameCDDef = new int[][]{
	        {1,1,},

	    };
	    int[][] frameCDExt = new int[][]{
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
	

	// Sprite : weaopnSprite
	final static public CSprite createSprite_weaopnSprite(IImages tiles){

	    // tiles
	    CAnimates animates = new CAnimates(124,tiles);
	     animates.addPart(-7,-4,12,0);//0
		 animates.addPart(-12,-1,46,0);//1
		 animates.addPart(-9,-1,47,0);//2
		 animates.addPart(-7,-7,13,0);//3
		 animates.addPart(-8,-8,48,0);//4
		 animates.addPart(-7,-7,49,0);//5
		 animates.addPart(-4,-7,12,5);//6
		 animates.addPart(-1,-12,58,0);//7
		 animates.addPart(-1,-9,59,0);//8
		 animates.addPart(-5,-7,13,5);//9
		 animates.addPart(4,-8,52,0);//10
		 animates.addPart(4,-7,53,0);//11
		 animates.addPart(-6,-4,12,3);//12
		 animates.addPart(7,-1,54,0);//13
		 animates.addPart(8,-1,55,0);//14
		 animates.addPart(-5,-5,13,3);//15
		 animates.addPart(4,4,56,0);//16
		 animates.addPart(4,4,57,0);//17
		 animates.addPart(-4,-6,12,6);//18
		 animates.addPart(-1,7,50,0);//19
		 animates.addPart(-1,8,51,0);//20
		 animates.addPart(-7,-5,13,6);//21
		 animates.addPart(-8,4,60,0);//22
		 animates.addPart(-7,4,61,0);//23
		 animates.addPart(-6,-4,4,0);//24
		 animates.addPart(-11,-2,46,0);//25
		 animates.addPart(-8,-2,47,0);//26
		 animates.addPart(-5,-5,5,0);//27
		 animates.addPart(-7,-7,48,0);//28
		 animates.addPart(-6,-6,49,0);//29
		 animates.addPart(-3,-6,4,5);//30
		 animates.addPart(-1,-11,58,0);//31
		 animates.addPart(-1,-8,59,0);//32
		 animates.addPart(-5,-5,5,5);//33
		 animates.addPart(3,-7,52,0);//34
		 animates.addPart(3,-6,53,0);//35
		 animates.addPart(-7,-3,4,3);//36
		 animates.addPart(6,-1,54,0);//37
		 animates.addPart(6,-1,55,0);//38
		 animates.addPart(-5,-5,5,3);//39
		 animates.addPart(3,3,56,0);//40
		 animates.addPart(3,3,57,0);//41
		 animates.addPart(-4,-7,4,6);//42
		 animates.addPart(-2,6,50,0);//43
		 animates.addPart(-2,6,51,0);//44
		 animates.addPart(-5,-5,5,6);//45
		 animates.addPart(-7,3,60,0);//46
		 animates.addPart(-6,3,61,0);//47
		 animates.addPart(-10,-10,15,0);//48
		 animates.addPart(0,-10,15,2);//49
		 animates.addPart(100,-10,15,2);//50
		 animates.addPart(0,-10,16,0);//51
		 animates.addPart(10,-10,16,0);//52
		 animates.addPart(20,-10,16,0);//53
		 animates.addPart(30,-10,16,0);//54
		 animates.addPart(40,-10,16,0);//55
		 animates.addPart(50,-10,16,0);//56
		 animates.addPart(60,-10,16,0);//57
		 animates.addPart(70,-10,16,0);//58
		 animates.addPart(80,-10,16,0);//59
		 animates.addPart(90,-10,16,0);//60
		 animates.addPart(99,-10,17,3);//61
		 animates.addPart(0,-10,18,0);//62
		 animates.addPart(10,-10,18,0);//63
		 animates.addPart(20,-10,18,0);//64
		 animates.addPart(30,-10,18,0);//65
		 animates.addPart(40,-10,18,0);//66
		 animates.addPart(50,-10,18,0);//67
		 animates.addPart(60,-10,18,0);//68
		 animates.addPart(70,-10,18,0);//69
		 animates.addPart(79,-10,18,0);//70
		 animates.addPart(89,-10,18,0);//71
		 animates.addPart(-10,-10,17,0);//72
		 animates.addPart(100,-7,19,3);//73
		 animates.addPart(10,-7,20,0);//74
		 animates.addPart(20,-7,20,0);//75
		 animates.addPart(30,-7,20,0);//76
		 animates.addPart(40,-7,20,0);//77
		 animates.addPart(50,-7,20,0);//78
		 animates.addPart(60,-7,20,0);//79
		 animates.addPart(70,-7,20,0);//80
		 animates.addPart(80,-7,20,0);//81
		 animates.addPart(90,-7,20,0);//82
		 animates.addPart(0,-7,20,0);//83
		 animates.addPart(-10,-7,19,0);//84
		 animates.addPart(100,-4,21,3);//85
		 animates.addPart(30,-4,22,0);//86
		 animates.addPart(10,-4,22,0);//87
		 animates.addPart(0,-4,22,0);//88
		 animates.addPart(40,-4,22,0);//89
		 animates.addPart(50,-4,22,0);//90
		 animates.addPart(20,-4,22,0);//91
		 animates.addPart(60,-4,22,0);//92
		 animates.addPart(70,-4,22,0);//93
		 animates.addPart(80,-4,22,0);//94
		 animates.addPart(90,-4,22,0);//95
		 animates.addPart(-10,-4,21,0);//96
		 animates.addPart(-10,-1,23,0);//97
		 animates.addPart(10,-1,24,0);//98
		 animates.addPart(0,-1,24,0);//99
		 animates.addPart(90,-1,24,0);//100
		 animates.addPart(40,-1,24,0);//101
		 animates.addPart(20,-1,24,0);//102
		 animates.addPart(70,-1,24,0);//103
		 animates.addPart(30,-1,24,0);//104
		 animates.addPart(50,-1,24,0);//105
		 animates.addPart(60,-1,24,0);//106
		 animates.addPart(80,-1,24,0);//107
		 animates.addPart(100,-1,23,3);//108
		 animates.addPart(-12,-4,32,0);//109
		 animates.addPart(-7,-3,31,0);//110
		 animates.addPart(-12,-4,33,0);//111
		 animates.addPart(-12,-4,34,0);//112
		 animates.addPart(-4,-2,43,0);//113
		 animates.addPart(-11,-2,14,0);//114
		 animates.addPart(-9,-6,1,0);//115
		 animates.addPart(-22,-4,44,0);//116
		 animates.addPart(-27,-2,45,0);//117
		 animates.addPart(-2,-2,2,0);//118
		 animates.addPart(-2,-2,3,0);//119
		 animates.addPart(-9,-1,0,0);//120
		 animates.addPart(-9,-6,30,0);//121
		 animates.addPart(-23,-4,62,0);//122
		 animates.addPart(-27,-2,63,0);//123
		
		
	    animates.setFrame(new int[51][]);
	     animates.setComboFrame(new int[]{0,1,},0);//0
		 animates.setComboFrame(new int[]{0,2,},1);//1
		 animates.setComboFrame(new int[]{3,4,},2);//2
		 animates.setComboFrame(new int[]{3,5,},3);//3
		 animates.setComboFrame(new int[]{6,7,},4);//4
		 animates.setComboFrame(new int[]{6,8,},5);//5
		 animates.setComboFrame(new int[]{9,10,},6);//6
		 animates.setComboFrame(new int[]{9,11,},7);//7
		 animates.setComboFrame(new int[]{12,13,},8);//8
		 animates.setComboFrame(new int[]{12,14,},9);//9
		 animates.setComboFrame(new int[]{15,16,},10);//10
		 animates.setComboFrame(new int[]{15,17,},11);//11
		 animates.setComboFrame(new int[]{18,19,},12);//12
		 animates.setComboFrame(new int[]{18,20,},13);//13
		 animates.setComboFrame(new int[]{21,22,},14);//14
		 animates.setComboFrame(new int[]{21,23,},15);//15
		 animates.setComboFrame(new int[]{24,25,},16);//16
		 animates.setComboFrame(new int[]{24,26,},17);//17
		 animates.setComboFrame(new int[]{27,28,},18);//18
		 animates.setComboFrame(new int[]{27,29,},19);//19
		 animates.setComboFrame(new int[]{30,31,},20);//20
		 animates.setComboFrame(new int[]{30,32,},21);//21
		 animates.setComboFrame(new int[]{33,34,},22);//22
		 animates.setComboFrame(new int[]{33,35,},23);//23
		 animates.setComboFrame(new int[]{36,37,},24);//24
		 animates.setComboFrame(new int[]{36,38,},25);//25
		 animates.setComboFrame(new int[]{39,40,},26);//26
		 animates.setComboFrame(new int[]{39,41,},27);//27
		 animates.setComboFrame(new int[]{42,43,},28);//28
		 animates.setComboFrame(new int[]{42,44,},29);//29
		 animates.setComboFrame(new int[]{45,46,},30);//30
		 animates.setComboFrame(new int[]{45,47,},31);//31
		 animates.setComboFrame(new int[]{48,49,},32);//32
		 animates.setComboFrame(new int[]{48,50,51,52,53,54,55,56,57,58,59,60,},33);//33
		 animates.setComboFrame(new int[]{61,62,63,64,65,66,67,68,69,70,71,72,},34);//34
		 animates.setComboFrame(new int[]{73,74,75,76,77,78,79,80,81,82,83,84,},35);//35
		 animates.setComboFrame(new int[]{85,86,87,88,89,90,91,92,93,94,95,96,},36);//36
		 animates.setComboFrame(new int[]{97,98,99,100,101,102,103,104,105,106,107,108,},37);//37
		 animates.setComboFrame(new int[]{109,110,},38);//38
		 animates.setComboFrame(new int[]{111,110,},39);//39
		 animates.setComboFrame(new int[]{112,110,},40);//40
		 animates.setComboFrame(new int[]{113,},41);//41
		 animates.setComboFrame(new int[]{114,},42);//42
		 animates.setComboFrame(new int[]{115,116,},43);//43
		 animates.setComboFrame(new int[]{115,117,},44);//44
		 animates.setComboFrame(new int[]{},45);//45
		 animates.setComboFrame(new int[]{118,},46);//46
		 animates.setComboFrame(new int[]{119,},47);//47
		 animates.setComboFrame(new int[]{120,},48);//48
		 animates.setComboFrame(new int[]{121,122,},49);//49
		 animates.setComboFrame(new int[]{121,123,},50);//50
		
		
		// cds
	    CCollides collides = new CCollides(22);
		 collides.addCDRect(65535, -3, -2, 4 , 4 );//rect//0
	     collides.addCDRect(65535, -2, -2, 4 , 4 );//rect//1
	     collides.addCDRect(65535, -2, -3, 4 , 4 );//rect//2
	     collides.addCDRect(65535, 0, -2, 4 , 4 );//rect//3
	     collides.addCDRect(65535, -2, -1, 4 , 4 );//rect//4
	     collides.addCDRect(65535, -2, -2, 4 , 3 );//rect//5
	     collides.addCDRect(65535, -2, -1, 4 , 3 );//rect//6
	     collides.addCDRect(65535, -1, -1, 3 , 3 );//rect//7
	     collides.addCDRect(65535, -2, -1, 3 , 4 );//rect//8
	     collides.addCDRect(65535, -2, -1, 3 , 3 );//rect//9
	     collides.addCDRect(65535, -9, -6, 18 , 12 );//rect//10
	     collides.addCDRect(65535, -9, -9, 119 , 19 );//rect//11
	     collides.addCDRect(65535, -9, -3, 119 , 7 );//rect//12
	     collides.addCDRect(65535, -9, 0, 119 , 1 );//rect//13
	     collides.addCDRect(65535, -9, -3, 15 , 5 );//rect//14
	     collides.addCDRect(65535, -2, -2, 5 , 4 );//rect//15
	     collides.addCDRect(65535, -6, -1, 15 , 2 );//rect//16
	     collides.addCDRect(65535, -9, -3, 18 , 5 );//rect//17
	     collides.addCDRect(65535, -18, -19, 36 , 36 );//rect//18
	     collides.addCDRect(65535, -1, -2, 3 , 3 );//rect//19
	     collides.addCDRect(65535, -9, -1, 12 , 2 );//rect//20
	     collides.addCDRect(65535, -8, -2, 16 , 3 );//rect//21
	    
	    
	    collides.setFrame(new int[23][]);
	     collides.setComboFrame(new int[]{0,},0);//0
	     collides.setComboFrame(new int[]{},1);//1
	     collides.setComboFrame(new int[]{1,},2);//2
	     collides.setComboFrame(new int[]{2,},3);//3
	     collides.setComboFrame(new int[]{3,},4);//4
	     collides.setComboFrame(new int[]{4,},5);//5
	     collides.setComboFrame(new int[]{5,},6);//6
	     collides.setComboFrame(new int[]{6,},7);//7
	     collides.setComboFrame(new int[]{7,},8);//8
	     collides.setComboFrame(new int[]{8,},9);//9
	     collides.setComboFrame(new int[]{9,},10);//10
	     collides.setComboFrame(new int[]{10,},11);//11
	     collides.setComboFrame(new int[]{11,},12);//12
	     collides.setComboFrame(new int[]{12,},13);//13
	     collides.setComboFrame(new int[]{13,},14);//14
	     collides.setComboFrame(new int[]{14,},15);//15
	     collides.setComboFrame(new int[]{15,},16);//16
	     collides.setComboFrame(new int[]{16,},17);//17
	     collides.setComboFrame(new int[]{17,},18);//18
	     collides.setComboFrame(new int[]{18,},19);//19
	     collides.setComboFrame(new int[]{19,},20);//20
	     collides.setComboFrame(new int[]{20,},21);//21
	     collides.setComboFrame(new int[]{21,},22);//22
	    
	    
	    
		// sprite frame
/*
		String[] frameName = new String[]{
			"0000",
"0001",
"0002",
"0003",
"0004",
"0005",
"0006",
"0007",
"0000",
"0001",
"0002",
"0003",
"0004",
"0005",
"0006",
"0007",
"0000",
"0000",
"0000",
"0000",
"0000",
"0001",
"0000",
"0000",
"0000",

		};
		
		for(int i=0;i<frameName.length;i++){
			System.out.println(frameName[i]);
		}
*/
	    int[][] frameAnimate = new int[][]{
	        {0,1,},
{2,3,},
{4,5,},
{6,7,},
{8,9,},
{10,11,},
{12,13,},
{14,15,},
{16,17,},
{18,19,},
{20,21,},
{22,23,},
{24,25,},
{26,27,},
{28,29,},
{30,31,},
{32,33,33,34,33,34,33,34,33,34,33,34,35,36,37,},
{38,39,40,},
{41,},
{42,},
{43,43,44,},
{45,},
{46,47,},
{48,},
{49,50,},

	    };
	    int[][] frameCDMap = new int[][]{
	        {0,0,},
{2,2,},
{3,3,},
{2,2,},
{4,4,},
{2,2,},
{5,5,},
{2,2,},
{6,6,},
{7,7,},
{8,8,},
{7,7,},
{7,7,},
{7,7,},
{9,10,},
{7,7,},
{11,12,12,12,12,12,12,12,12,12,12,12,12,13,14,},
{15,15,15,},
{16,},
{17,},
{18,18,18,},
{19,},
{20,20,},
{21,},
{22,22,},

	    };
	    int[][] frameCDAtk = new int[][]{
	        {1,1,},
{1,1,},
{1,1,},
{1,1,},
{1,1,},
{1,1,},
{1,1,},
{1,1,},
{1,1,},
{1,1,},
{1,1,},
{1,1,},
{1,1,},
{1,1,},
{1,1,},
{1,1,},
{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,},
{1,1,1,},
{1,},
{1,},
{1,1,1,},
{1,},
{1,1,},
{1,},
{1,1,},

	    };
	    int[][] frameCDDef = new int[][]{
	        {1,1,},
{1,1,},
{1,1,},
{1,1,},
{1,1,},
{1,1,},
{1,1,},
{1,1,},
{1,1,},
{1,1,},
{1,1,},
{1,1,},
{1,1,},
{1,1,},
{1,1,},
{1,1,},
{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,},
{1,1,1,},
{1,},
{1,},
{1,1,1,},
{1,},
{1,1,},
{1,},
{1,1,},

	    };
	    int[][] frameCDExt = new int[][]{
	        {1,1,},
{1,1,},
{1,1,},
{1,1,},
{1,1,},
{1,1,},
{1,1,},
{1,1,},
{1,1,},
{1,1,},
{1,1,},
{1,1,},
{1,1,},
{1,1,},
{1,1,},
{1,1,},
{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,},
{1,1,1,},
{1,},
{1,},
{1,1,1,},
{1,},
{1,1,},
{1,},
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
	

	// Sprite : effect
	final static public CSprite createSprite_effect(IImages tiles){

	    // tiles
	    CAnimates animates = new CAnimates(24,tiles);
	     animates.addPart(-4,-4,8,0);//0
		 animates.addPart(-7,-7,9,0);//1
		 animates.addPart(-12,-12,10,0);//2
		 animates.addPart(-23,-21,11,0);//3
		 animates.addPart(-24,-24,12,0);//4
		 animates.addPart(-4,-4,13,0);//5
		 animates.addPart(-7,-7,14,0);//6
		 animates.addPart(-12,-11,15,0);//7
		 animates.addPart(-16,-17,16,0);//8
		 animates.addPart(-1,-1,17,0);//9
		 animates.addPart(-4,-4,18,0);//10
		 animates.addPart(-8,-8,19,0);//11
		 animates.addPart(-11,-11,20,0);//12
		 animates.addPart(-3,-3,4,0);//13
		 animates.addPart(-7,-7,5,0);//14
		 animates.addPart(-11,-11,6,0);//15
		 animates.addPart(-18,-18,7,0);//16
		 animates.addPart(-12,-12,0,0);//17
		 animates.addPart(-20,-21,1,0);//18
		 animates.addPart(-23,-26,2,0);//19
		 animates.addPart(-28,-27,3,0);//20
		 animates.addPart(-32,-27,23,0);//21
		 animates.addPart(-36,-38,21,0);//22
		 animates.addPart(-45,-41,22,0);//23
		
		
	    animates.setFrame(new int[24][]);
	     animates.setComboFrame(new int[]{0,},0);//0
		 animates.setComboFrame(new int[]{0,1,},1);//1
		 animates.setComboFrame(new int[]{2,1,},2);//2
		 animates.setComboFrame(new int[]{3,},3);//3
		 animates.setComboFrame(new int[]{4,1,},4);//4
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
		
		
		// cds
	    CCollides collides = new CCollides(0);
		
	    
	    collides.setFrame(new int[1][]);
	     collides.setComboFrame(new int[]{},0);//0
	    
	    
	    
		// sprite frame
/*
		String[] frameName = new String[]{
			"0000",
"0001",
"0002",
"0003",
"0004",
"0005",

		};
		
		for(int i=0;i<frameName.length;i++){
			System.out.println(frameName[i]);
		}
*/
	    int[][] frameAnimate = new int[][]{
	        {0,1,2,3,4,},
{5,6,7,8,},
{9,10,11,12,},
{13,14,15,16,},
{17,18,19,20,},
{21,22,22,23,23,23,},

	    };
	    int[][] frameCDMap = new int[][]{
	        {0,0,0,0,0,},
{0,0,0,0,},
{0,0,0,0,},
{0,0,0,0,},
{0,0,0,0,},
{0,0,0,0,0,0,},

	    };
	    int[][] frameCDAtk = new int[][]{
	        {0,0,0,0,0,},
{0,0,0,0,},
{0,0,0,0,},
{0,0,0,0,},
{0,0,0,0,},
{0,0,0,0,0,0,},

	    };
	    int[][] frameCDDef = new int[][]{
	        {0,0,0,0,0,},
{0,0,0,0,},
{0,0,0,0,},
{0,0,0,0,},
{0,0,0,0,},
{0,0,0,0,0,0,},

	    };
	    int[][] frameCDExt = new int[][]{
	        {0,0,0,0,0,},
{0,0,0,0,},
{0,0,0,0,},
{0,0,0,0,},
{0,0,0,0,},
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
	

	// Sprite : btSpr
	final static public CSprite createSprite_btSpr(IImages tiles){

	    // tiles
	    CAnimates animates = new CAnimates(30,tiles);
	     animates.addPart(-19,0,1,0);//0
		 animates.addPart(-13,-19,0,0);//1
		 animates.addPart(-17,1,2,0);//2
		 animates.addPart(-14,1,3,0);//3
		 animates.addPart(-13,-19,29,0);//4
		 animates.addPart(-29,-20,23,0);//5
		 animates.addPart(-8,-6,19,0);//6
		 animates.addPart(4,-6,19,0);//7
		 animates.addPart(20,-6,20,0);//8
		 animates.addPart(20,-10,21,0);//9
		 animates.addPart(20,-5,22,0);//10
		 animates.addPart(-5,-14,25,0);//11
		 animates.addPart(3,-14,25,0);//12
		 animates.addPart(19,-18,32,0);//13
		 animates.addPart(19,-16,31,0);//14
		 animates.addPart(19,-16,30,0);//15
		 animates.addPart(-11,-11,28,0);//16
		 animates.addPart(-15,1,3,0);//17
		 animates.addPart(24,-9,32,0);//18
		 animates.addPart(-11,-11,24,0);//19
		 animates.addPart(24,-7,31,0);//20
		 animates.addPart(-18,1,2,0);//21
		 animates.addPart(24,-6,30,0);//22
		 animates.addPart(-6,-10,26,0);//23
		 animates.addPart(-4,5,27,0);//24
		 animates.addPart(-6,-8,26,0);//25
		 animates.addPart(-11,5,33,0);//26
		 animates.addPart(-6,6,34,0);//27
		 animates.addPart(-11,5,36,0);//28
		 animates.addPart(-11,5,35,0);//29
		
		
	    animates.setFrame(new int[34][]);
	     animates.setComboFrame(new int[]{0,1,},0);//0
		 animates.setComboFrame(new int[]{2,1,},1);//1
		 animates.setComboFrame(new int[]{3,1,},2);//2
		 animates.setComboFrame(new int[]{4,},3);//3
		 animates.setComboFrame(new int[]{1,0,},4);//4
		 animates.setComboFrame(new int[]{4,2,},5);//5
		 animates.setComboFrame(new int[]{5,1,3,},6);//6
		 animates.setComboFrame(new int[]{5,6,1,0,},7);//7
		 animates.setComboFrame(new int[]{5,7,1,2,},8);//8
		 animates.setComboFrame(new int[]{5,7,1,3,},9);//9
		 animates.setComboFrame(new int[]{5,8,7,1,0,},10);//10
		 animates.setComboFrame(new int[]{5,9,7,1,2,},11);//11
		 animates.setComboFrame(new int[]{5,10,7,1,3,},12);//12
		 animates.setComboFrame(new int[]{5,7,1,0,},13);//13
		 animates.setComboFrame(new int[]{5,6,1,2,},14);//14
		 animates.setComboFrame(new int[]{5,11,1,0,},15);//15
		 animates.setComboFrame(new int[]{5,12,1,2,},16);//16
		 animates.setComboFrame(new int[]{5,13,12,1,3,},17);//17
		 animates.setComboFrame(new int[]{5,14,12,1,0,},18);//18
		 animates.setComboFrame(new int[]{15,5,12,1,2,},19);//19
		 animates.setComboFrame(new int[]{5,12,1,3,},20);//20
		 animates.setComboFrame(new int[]{5,1,2,},21);//21
		 animates.setComboFrame(new int[]{16,17,4,},22);//22
		 animates.setComboFrame(new int[]{18,19,0,1,},23);//23
		 animates.setComboFrame(new int[]{20,19,21,1,},24);//24
		 animates.setComboFrame(new int[]{22,19,17,1,},25);//25
		 animates.setComboFrame(new int[]{1,3,},26);//26
		 animates.setComboFrame(new int[]{23,1,0,},27);//27
		 animates.setComboFrame(new int[]{24,25,1,2,},28);//28
		 animates.setComboFrame(new int[]{24,25,1,26,27,3,},29);//29
		 animates.setComboFrame(new int[]{24,25,1,28,27,0,},30);//30
		 animates.setComboFrame(new int[]{24,25,1,29,27,2,},31);//31
		 animates.setComboFrame(new int[]{24,25,1,0,},32);//32
		 animates.setComboFrame(new int[]{23,1,2,},33);//33
		
		
		// cds
	    CCollides collides = new CCollides(1);
		 collides.addCDRect(65535, -8, -4, 17 , 8 );//rect//0
	    
	    
	    collides.setFrame(new int[2][]);
	     collides.setComboFrame(new int[]{0,},0);//0
	     collides.setComboFrame(new int[]{},1);//1
	    
	    
	    
		// sprite frame
/*
		String[] frameName = new String[]{
			"0000",
"0005",
"0001",
"0002",
"0003",
"0004",

		};
		
		for(int i=0;i<frameName.length;i++){
			System.out.println(frameName[i]);
		}
*/
	    int[][] frameAnimate = new int[][]{
	        {0,1,2,},
{3,},
{4,5,6,7,8,9,10,11,12,13,14,6,},
{4,5,6,15,16,17,18,19,17,18,19,17,18,19,20,15,21,},
{4,5,22,23,24,25,23,24,25,23,24,25,23,24,25,23,24,25,},
{4,5,26,27,28,29,30,31,29,30,31,29,32,33,},

	    };
	    int[][] frameCDMap = new int[][]{
	        {0,0,0,},
{1,},
{0,1,1,1,1,1,1,1,1,1,1,1,},
{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,},
{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,},
{0,1,1,1,1,1,1,1,1,1,1,1,1,1,},

	    };
	    int[][] frameCDAtk = new int[][]{
	        {1,1,1,},
{1,},
{1,1,1,1,1,1,1,1,1,1,1,1,},
{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,},
{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,},
{1,1,1,1,1,1,1,1,1,1,1,1,1,1,},

	    };
	    int[][] frameCDDef = new int[][]{
	        {1,1,1,},
{1,},
{1,1,1,1,1,1,1,1,1,1,1,1,},
{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,},
{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,},
{1,1,1,1,1,1,1,1,1,1,1,1,1,1,},

	    };
	    int[][] frameCDExt = new int[][]{
	        {1,1,1,},
{1,},
{1,1,1,1,1,1,1,1,1,1,1,1,},
{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,},
{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,},
{1,1,1,1,1,1,1,1,1,1,1,1,1,1,},

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
	

	// Sprite : btSub
	final static public CSprite createSprite_btSub(IImages tiles){

	    // tiles
	    CAnimates animates = new CAnimates(20,tiles);
	     animates.addPart(-9,-6,15,0);//0
		 animates.addPart(-9,-7,16,0);//1
		 animates.addPart(-9,-6,17,0);//2
		 animates.addPart(-9,-6,18,0);//3
		 animates.addPart(-8,-6,10,0);//4
		 animates.addPart(-8,-6,11,0);//5
		 animates.addPart(-8,-6,9,0);//6
		 animates.addPart(-8,-6,7,0);//7
		 animates.addPart(-8,-6,8,0);//8
		 animates.addPart(-6,-5,13,0);//9
		 animates.addPart(-6,-5,12,0);//10
		 animates.addPart(-6,-5,14,0);//11
		 animates.addPart(-6,-4,6,0);//12
		 animates.addPart(-6,-4,5,0);//13
		 animates.addPart(-5,-4,4,0);//14
		 animates.addPart(7,-7,49,0);//15
		 animates.addPart(7,-4,50,0);//16
		 animates.addPart(3,-10,32,0);//17
		 animates.addPart(3,-8,31,0);//18
		 animates.addPart(3,-7,30,0);//19
		
		
	    animates.setFrame(new int[22][]);
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
		 animates.setComboFrame(new int[]{15,0,},15);//15
		 animates.setComboFrame(new int[]{16,1,},16);//16
		 animates.setComboFrame(new int[]{15,2,},17);//17
		 animates.setComboFrame(new int[]{16,3,},18);//18
		 animates.setComboFrame(new int[]{17,9,},19);//19
		 animates.setComboFrame(new int[]{18,10,},20);//20
		 animates.setComboFrame(new int[]{19,11,},21);//21
		
		
		// cds
	    CCollides collides = new CCollides(0);
		
	    
	    collides.setFrame(new int[1][]);
	     collides.setComboFrame(new int[]{},0);//0
	    
	    
	    
		// sprite frame
/*
		String[] frameName = new String[]{
			"0000",
"0001",
"0002",
"0003",
"0004",
"0005",

		};
		
		for(int i=0;i<frameName.length;i++){
			System.out.println(frameName[i]);
		}
*/
	    int[][] frameAnimate = new int[][]{
	        {0,0,1,1,2,2,3,3,},
{4,4,5,5,6,6,7,7,8,8,6,6,},
{9,10,11,},
{12,12,13,13,14,14,13,13,},
{15,15,16,16,17,17,18,18,},
{19,20,21,},

	    };
	    int[][] frameCDMap = new int[][]{
	        {0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,},
{0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,},
{0,0,0,},

	    };
	    int[][] frameCDAtk = new int[][]{
	        {0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,},
{0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,},
{0,0,0,},

	    };
	    int[][] frameCDDef = new int[][]{
	        {0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,},
{0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,},
{0,0,0,},

	    };
	    int[][] frameCDExt = new int[][]{
	        {0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,},
{0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,},
{0,0,0,},

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
	

	// Sprite : btEnemy001
	final static public CSprite createSprite_btEnemy001(IImages tiles){

	    // tiles
	    CAnimates animates = new CAnimates(4,tiles);
	     animates.addPart(-6,-13,45,0);//0
		 animates.addPart(-15,-6,48,0);//1
		 animates.addPart(-7,-11,46,0);//2
		 animates.addPart(-6,-6,47,0);//3
		
		
	    animates.setFrame(new int[3][]);
	     animates.setComboFrame(new int[]{0,1,},0);//0
		 animates.setComboFrame(new int[]{2,1,},1);//1
		 animates.setComboFrame(new int[]{3,1,},2);//2
		
		
		// cds
	    CCollides collides = new CCollides(1);
		 collides.addCDRect(65535, -15, -10, 30 , 19 );//rect//0
	    
	    
	    collides.setFrame(new int[3][]);
	     collides.setComboFrame(new int[]{0,0,},0);//0
	     collides.setComboFrame(new int[]{},1);//1
	     collides.setComboFrame(new int[]{0,},2);//2
	    
	    
	    
		// sprite frame
/*
		String[] frameName = new String[]{
			"0000",

		};
		
		for(int i=0;i<frameName.length;i++){
			System.out.println(frameName[i]);
		}
*/
	    int[][] frameAnimate = new int[][]{
	        {0,1,2,},

	    };
	    int[][] frameCDMap = new int[][]{
	        {0,2,2,},

	    };
	    int[][] frameCDAtk = new int[][]{
	        {1,1,1,},

	    };
	    int[][] frameCDDef = new int[][]{
	        {1,1,1,},

	    };
	    int[][] frameCDExt = new int[][]{
	        {1,1,1,},

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
	

	// Sprite : btEnemy002
	final static public CSprite createSprite_btEnemy002(IImages tiles){

	    // tiles
	    CAnimates animates = new CAnimates(3,tiles);
	     animates.addPart(-12,-8,37,0);//0
		 animates.addPart(-12,-8,38,0);//1
		 animates.addPart(-12,-8,39,0);//2
		
		
	    animates.setFrame(new int[3][]);
	     animates.setComboFrame(new int[]{0,},0);//0
		 animates.setComboFrame(new int[]{1,},1);//1
		 animates.setComboFrame(new int[]{2,},2);//2
		
		
		// cds
	    CCollides collides = new CCollides(1);
		 collides.addCDRect(65535, -12, -8, 24 , 16 );//rect//0
	    
	    
	    collides.setFrame(new int[3][]);
	     collides.setComboFrame(new int[]{0,0,},0);//0
	     collides.setComboFrame(new int[]{},1);//1
	     collides.setComboFrame(new int[]{0,},2);//2
	    
	    
	    
		// sprite frame
/*
		String[] frameName = new String[]{
			"0000",

		};
		
		for(int i=0;i<frameName.length;i++){
			System.out.println(frameName[i]);
		}
*/
	    int[][] frameAnimate = new int[][]{
	        {0,1,2,},

	    };
	    int[][] frameCDMap = new int[][]{
	        {0,2,2,},

	    };
	    int[][] frameCDAtk = new int[][]{
	        {1,1,1,},

	    };
	    int[][] frameCDDef = new int[][]{
	        {1,1,1,},

	    };
	    int[][] frameCDExt = new int[][]{
	        {1,1,1,},

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
	

	// Sprite : btEnemy003
	final static public CSprite createSprite_btEnemy003(IImages tiles){

	    // tiles
	    CAnimates animates = new CAnimates(4,tiles);
	     animates.addPart(-14,-8,44,0);//0
		 animates.addPart(-4,-12,42,0);//1
		 animates.addPart(-2,-12,41,0);//2
		 animates.addPart(-2,-12,43,0);//3
		
		
	    animates.setFrame(new int[3][]);
	     animates.setComboFrame(new int[]{0,1,},0);//0
		 animates.setComboFrame(new int[]{0,2,},1);//1
		 animates.setComboFrame(new int[]{0,3,},2);//2
		
		
		// cds
	    CCollides collides = new CCollides(1);
		 collides.addCDRect(65535, -14, -8, 28 , 17 );//rect//0
	    
	    
	    collides.setFrame(new int[3][]);
	     collides.setComboFrame(new int[]{0,0,},0);//0
	     collides.setComboFrame(new int[]{},1);//1
	     collides.setComboFrame(new int[]{0,},2);//2
	    
	    
	    
		// sprite frame
/*
		String[] frameName = new String[]{
			"0000",

		};
		
		for(int i=0;i<frameName.length;i++){
			System.out.println(frameName[i]);
		}
*/
	    int[][] frameAnimate = new int[][]{
	        {0,1,2,},

	    };
	    int[][] frameCDMap = new int[][]{
	        {0,2,2,},

	    };
	    int[][] frameCDAtk = new int[][]{
	        {1,1,1,},

	    };
	    int[][] frameCDDef = new int[][]{
	        {1,1,1,},

	    };
	    int[][] frameCDExt = new int[][]{
	        {1,1,1,},

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
	

	// Sprite : btEnemy004
	final static public CSprite createSprite_btEnemy004(IImages tiles){

	    // tiles
	    CAnimates animates = new CAnimates(2,tiles);
	     animates.addPart(-13,-16,40,0);//0
		 animates.addPart(-13,-17,40,0);//1
		
		
	    animates.setFrame(new int[2][]);
	     animates.setComboFrame(new int[]{0,},0);//0
		 animates.setComboFrame(new int[]{1,},1);//1
		
		
		// cds
	    CCollides collides = new CCollides(1);
		 collides.addCDRect(65535, -13, -14, 24 , 29 );//rect//0
	    
	    
	    collides.setFrame(new int[3][]);
	     collides.setComboFrame(new int[]{0,0,},0);//0
	     collides.setComboFrame(new int[]{},1);//1
	     collides.setComboFrame(new int[]{0,},2);//2
	    
	    
	    
		// sprite frame
/*
		String[] frameName = new String[]{
			"0000",

		};
		
		for(int i=0;i<frameName.length;i++){
			System.out.println(frameName[i]);
		}
*/
	    int[][] frameAnimate = new int[][]{
	        {0,0,0,1,1,1,},

	    };
	    int[][] frameCDMap = new int[][]{
	        {0,2,2,2,2,2,},

	    };
	    int[][] frameCDAtk = new int[][]{
	        {1,1,1,1,1,1,},

	    };
	    int[][] frameCDDef = new int[][]{
	        {1,1,1,1,1,1,},

	    };
	    int[][] frameCDExt = new int[][]{
	        {1,1,1,1,1,1,},

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
	

	// Sprite : btEnemy005
	final static public CSprite createSprite_btEnemy005(IImages tiles){

	    // tiles
	    CAnimates animates = new CAnimates(3,tiles);
	     animates.addPart(-10,-10,51,0);//0
		 animates.addPart(-10,-10,52,0);//1
		 animates.addPart(-10,-10,53,0);//2
		
		
	    animates.setFrame(new int[3][]);
	     animates.setComboFrame(new int[]{0,},0);//0
		 animates.setComboFrame(new int[]{1,},1);//1
		 animates.setComboFrame(new int[]{2,},2);//2
		
		
		// cds
	    CCollides collides = new CCollides(1);
		 collides.addCDRect(65535, -9, -10, 19 , 19 );//rect//0
	    
	    
	    collides.setFrame(new int[3][]);
	     collides.setComboFrame(new int[]{0,0,},0);//0
	     collides.setComboFrame(new int[]{},1);//1
	     collides.setComboFrame(new int[]{0,},2);//2
	    
	    
	    
		// sprite frame
/*
		String[] frameName = new String[]{
			"0000",

		};
		
		for(int i=0;i<frameName.length;i++){
			System.out.println(frameName[i]);
		}
*/
	    int[][] frameAnimate = new int[][]{
	        {0,0,1,1,2,2,},

	    };
	    int[][] frameCDMap = new int[][]{
	        {0,2,2,2,2,2,},

	    };
	    int[][] frameCDAtk = new int[][]{
	        {1,1,1,1,1,1,},

	    };
	    int[][] frameCDDef = new int[][]{
	        {1,1,1,1,1,1,},

	    };
	    int[][] frameCDExt = new int[][]{
	        {1,1,1,1,1,1,},

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
	

	// Sprite : btEnemy006
	final static public CSprite createSprite_btEnemy006(IImages tiles){

	    // tiles
	    CAnimates animates = new CAnimates(3,tiles);
	     animates.addPart(-5,-7,54,0);//0
		 animates.addPart(-5,-6,55,0);//1
		 animates.addPart(-5,-3,56,0);//2
		
		
	    animates.setFrame(new int[3][]);
	     animates.setComboFrame(new int[]{0,},0);//0
		 animates.setComboFrame(new int[]{1,},1);//1
		 animates.setComboFrame(new int[]{2,},2);//2
		
		
		// cds
	    CCollides collides = new CCollides(3);
		 collides.addCDRect(65535, -5, -7, 10 , 15 );//rect//0
	     collides.addCDRect(65535, -5, -6, 10 , 12 );//rect//1
	     collides.addCDRect(65535, -5, -3, 10 , 7 );//rect//2
	    
	    
	    collides.setFrame(new int[4][]);
	     collides.setComboFrame(new int[]{0,},0);//0
	     collides.setComboFrame(new int[]{},1);//1
	     collides.setComboFrame(new int[]{1,},2);//2
	     collides.setComboFrame(new int[]{2,},3);//3
	    
	    
	    
		// sprite frame
/*
		String[] frameName = new String[]{
			"0000",

		};
		
		for(int i=0;i<frameName.length;i++){
			System.out.println(frameName[i]);
		}
*/
	    int[][] frameAnimate = new int[][]{
	        {0,0,1,1,2,2,1,1,},

	    };
	    int[][] frameCDMap = new int[][]{
	        {0,0,2,2,3,3,2,2,},

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
	

	// Sprite : layer
	final static public CSprite createSprite_layer(IImages tiles){

	    // tiles
	    CAnimates animates = new CAnimates(2,tiles);
	     animates.addPart(0,-22,0,0);//0
		 animates.addPart(0,-21,1,0);//1
		
		
	    animates.setFrame(new int[2][]);
	     animates.setComboFrame(new int[]{0,},0);//0
		 animates.setComboFrame(new int[]{1,},1);//1
		
		
		// cds
	    CCollides collides = new CCollides(0);
		
	    
	    collides.setFrame(new int[1][]);
	     collides.setComboFrame(new int[]{},0);//0
	    
	    
	    
		// sprite frame
/*
		String[] frameName = new String[]{
			"0000",
"0001",

		};
		
		for(int i=0;i<frameName.length;i++){
			System.out.println(frameName[i]);
		}
*/
	    int[][] frameAnimate = new int[][]{
	        {0,},
{1,},

	    };
	    int[][] frameCDMap = new int[][]{
	        {0,},
{0,},

	    };
	    int[][] frameCDAtk = new int[][]{
	        {0,},
{0,},

	    };
	    int[][] frameCDDef = new int[][]{
	        {0,},
{0,},

	    };
	    int[][] frameCDExt = new int[][]{
	        {0,},
{0,},

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
	

	// Sprite : boss1
	final static public CSprite createSprite_boss1(IImages tiles){

	    // tiles
	    CAnimates animates = new CAnimates(6,tiles);
	     animates.addPart(-23,-12,0,2);//0
		 animates.addPart(-10,7,2,2);//1
		 animates.addPart(-20,-10,1,2);//2
		 animates.addPart(-8,8,3,2);//3
		 animates.addPart(-5,8,4,2);//4
		 animates.addPart(-23,-12,5,2);//5
		
		
	    animates.setFrame(new int[7][]);
	     animates.setComboFrame(new int[]{0,1,},0);//0
		 animates.setComboFrame(new int[]{2,3,},1);//1
		 animates.setComboFrame(new int[]{0,4,},2);//2
		 animates.setComboFrame(new int[]{2,1,},3);//3
		 animates.setComboFrame(new int[]{0,3,},4);//4
		 animates.setComboFrame(new int[]{2,4,},5);//5
		 animates.setComboFrame(new int[]{5,},6);//6
		
		
		// cds
	    CCollides collides = new CCollides(2);
		 collides.addCDRect(65535, -6, -3, 29 , 16 );//rect//0
	     collides.addCDRect(65535, -10, 10, 1 , 1 );//rect//1
	    
	    
	    collides.setFrame(new int[4][]);
	     collides.setComboFrame(new int[]{0,0,},0);//0
	     collides.setComboFrame(new int[]{},1);//1
	     collides.setComboFrame(new int[]{1,},2);//2
	     collides.setComboFrame(new int[]{0,},3);//3
	    
	    
	    
		// sprite frame
/*
		String[] frameName = new String[]{
			"0000",
"0001",

		};
		
		for(int i=0;i<frameName.length;i++){
			System.out.println(frameName[i]);
		}
*/
	    int[][] frameAnimate = new int[][]{
	        {0,0,1,1,2,2,3,3,4,4,5,5,},
{6,},

	    };
	    int[][] frameCDMap = new int[][]{
	        {0,3,3,3,3,3,3,3,3,3,3,3,},
{1,},

	    };
	    int[][] frameCDAtk = new int[][]{
	        {1,1,1,1,1,1,1,1,1,1,1,1,},
{1,},

	    };
	    int[][] frameCDDef = new int[][]{
	        {1,1,1,1,1,1,1,1,1,1,1,1,},
{1,},

	    };
	    int[][] frameCDExt = new int[][]{
	        {2,1,1,1,1,1,1,1,1,1,1,1,},
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
	

	// Sprite : boss2
	final static public CSprite createSprite_boss2(IImages tiles){

	    // tiles
	    CAnimates animates = new CAnimates(19,tiles);
	     animates.addPart(-24,42,2,0);//0
		 animates.addPart(-48,-39,2,0);//1
		 animates.addPart(-62,-7,2,0);//2
		 animates.addPart(-49,26,2,0);//3
		 animates.addPart(-23,-55,2,0);//4
		 animates.addPart(-22,0,1,1);//5
		 animates.addPart(-22,-18,1,0);//6
		 animates.addPart(-98,-102,0,0);//7
		 animates.addPart(-98,1,0,1);//8
		 animates.addPart(-24,42,3,0);//9
		 animates.addPart(-48,-39,3,0);//10
		 animates.addPart(-62,-7,3,0);//11
		 animates.addPart(-49,26,3,0);//12
		 animates.addPart(-23,-55,3,0);//13
		 animates.addPart(-23,-55,4,0);//14
		 animates.addPart(-48,-39,4,0);//15
		 animates.addPart(-62,-7,4,0);//16
		 animates.addPart(-49,26,4,0);//17
		 animates.addPart(-24,42,4,0);//18
		
		
	    animates.setFrame(new int[3][]);
	     animates.setComboFrame(new int[]{0,1,2,3,4,5,6,7,8,},0);//0
		 animates.setComboFrame(new int[]{9,10,11,12,13,5,6,7,8,},1);//1
		 animates.setComboFrame(new int[]{14,15,16,17,18,5,6,7,8,},2);//2
		
		
		// cds
	    CCollides collides = new CCollides(16);
		 collides.addCDRect(65535, -23, -35, 22 , 71 );//rect//0
	     collides.addCDRect(65535, -17, -49, 17 , 16 );//rect//1
	     collides.addCDRect(65535, -41, -31, 17 , 16 );//rect//2
	     collides.addCDRect(65535, -55, 1, 17 , 16 );//rect//3
	     collides.addCDRect(65535, -42, 34, 17 , 16 );//rect//4
	     collides.addCDRect(65535, -17, 50, 17 , 16 );//rect//5
	     collides.addCDRect(65535, -36, -35, 36 , 71 );//rect//6
	     collides.addCDRect(65535, -73, -73, 17 , 16 );//rect//7
	     collides.addCDRect(65535, -99, 33, 17 , 16 );//rect//8
	     collides.addCDRect(65535, -97, -32, 17 , 16 );//rect//9
	     collides.addCDRect(65535, -74, 74, 17 , 16 );//rect//10
	     collides.addCDRect(65535, -18, -51, 1 , 1 );//rect//11
	     collides.addCDRect(65535, -44, -34, 1 , 1 );//rect//12
	     collides.addCDRect(65535, -57, 0, 1 , 1 );//rect//13
	     collides.addCDRect(65535, -39, 32, 1 , 1 );//rect//14
	     collides.addCDRect(65535, -18, 48, 1 , 1 );//rect//15
	    
	    
	    collides.setFrame(new int[11][]);
	     collides.setComboFrame(new int[]{0,},0);//0
	     collides.setComboFrame(new int[]{},1);//1
	     collides.setComboFrame(new int[]{1,2,3,4,5,},2);//2
	     collides.setComboFrame(new int[]{5,},3);//3
	     collides.setComboFrame(new int[]{4,},4);//4
	     collides.setComboFrame(new int[]{3,},5);//5
	     collides.setComboFrame(new int[]{2,},6);//6
	     collides.setComboFrame(new int[]{1,},7);//7
	     collides.setComboFrame(new int[]{6,},8);//8
	     collides.setComboFrame(new int[]{7,8,9,10,},9);//9
	     collides.setComboFrame(new int[]{11,12,13,14,15,},10);//10
	    
	    
	    
		// sprite frame
/*
		String[] frameName = new String[]{
			"0000",
"0000",

		};
		
		for(int i=0;i<frameName.length;i++){
			System.out.println(frameName[i]);
		}
*/
	    int[][] frameAnimate = new int[][]{
	        {0,1,0,0,0,0,1,0,1,0,0,0,0,},
{2,2,},

	    };
	    int[][] frameCDMap = new int[][]{
	        {0,0,0,0,0,0,8,0,0,0,0,0,0,},
{1,1,},

	    };
	    int[][] frameCDAtk = new int[][]{
	        {1,1,1,1,1,1,1,1,1,1,1,1,1,},
{1,1,},

	    };
	    int[][] frameCDDef = new int[][]{
	        {1,1,1,1,1,1,1,1,1,1,1,1,1,},
{1,1,},

	    };
	    int[][] frameCDExt = new int[][]{
	        {2,3,4,5,6,7,9,1,3,4,5,6,7,},
{10,10,},

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
	

	// Sprite : boos2Sub
	final static public CSprite createSprite_boos2Sub(IImages tiles){

	    // tiles
	    CAnimates animates = new CAnimates(4,tiles);
	     animates.addPart(-12,-11,5,0);//0
		 animates.addPart(-8,-8,4,0);//1
		 animates.addPart(-8,-8,3,0);//2
		 animates.addPart(-8,-8,2,0);//3
		
		
	    animates.setFrame(new int[4][]);
	     animates.setComboFrame(new int[]{0,},0);//0
		 animates.setComboFrame(new int[]{1,},1);//1
		 animates.setComboFrame(new int[]{2,},2);//2
		 animates.setComboFrame(new int[]{3,},3);//3
		
		
		// cds
	    CCollides collides = new CCollides(0);
		
	    
	    collides.setFrame(new int[1][]);
	     collides.setComboFrame(new int[]{},0);//0
	    
	    
	    
		// sprite frame
/*
		String[] frameName = new String[]{
			"0000",
"0001",
"0002",
"0003",

		};
		
		for(int i=0;i<frameName.length;i++){
			System.out.println(frameName[i]);
		}
*/
	    int[][] frameAnimate = new int[][]{
	        {0,},
{1,},
{0,},
{2,2,3,3,},

	    };
	    int[][] frameCDMap = new int[][]{
	        {0,},
{0,},
{0,},
{0,0,0,0,},

	    };
	    int[][] frameCDAtk = new int[][]{
	        {0,},
{0,},
{0,},
{0,0,0,0,},

	    };
	    int[][] frameCDDef = new int[][]{
	        {0,},
{0,},
{0,},
{0,0,0,0,},

	    };
	    int[][] frameCDExt = new int[][]{
	        {0,},
{0,},
{0,},
{0,0,0,0,},

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
	

	// Sprite : boss3
	final static public CSprite createSprite_boss3(IImages tiles){

	    // tiles
	    CAnimates animates = new CAnimates(47,tiles);
	     animates.addPart(2,-3,4,0);//0
		 animates.addPart(-27,-3,4,0);//1
		 animates.addPart(-12,-3,4,0);//2
		 animates.addPart(-32,-6,0,0);//3
		 animates.addPart(-23,-7,3,0);//4
		 animates.addPart(-14,-7,3,0);//5
		 animates.addPart(-5,-7,3,0);//6
		 animates.addPart(4,-7,3,0);//7
		 animates.addPart(13,-7,3,0);//8
		 animates.addPart(22,-7,3,0);//9
		 animates.addPart(31,-7,3,0);//10
		 animates.addPart(40,-7,3,0);//11
		 animates.addPart(-13,-2,5,0);//12
		 animates.addPart(1,-2,5,0);//13
		 animates.addPart(-27,-2,5,0);//14
		 animates.addPart(-22,-2,5,0);//15
		 animates.addPart(-7,-3,4,0);//16
		 animates.addPart(10,-3,4,0);//17
		 animates.addPart(-25,-6,0,0);//18
		 animates.addPart(-16,-7,3,0);//19
		 animates.addPart(-7,-7,3,0);//20
		 animates.addPart(2,-7,3,0);//21
		 animates.addPart(11,-7,3,0);//22
		 animates.addPart(20,-7,3,0);//23
		 animates.addPart(29,-7,1,0);//24
		 animates.addPart(10,-4,4,0);//25
		 animates.addPart(-14,-2,4,0);//26
		 animates.addPart(-3,1,4,0);//27
		 animates.addPart(-17,-5,0,0);//28
		 animates.addPart(-8,-5,1,0);//29
		 animates.addPart(10,-10,2,0);//30
		 animates.addPart(9,2,4,0);//31
		 animates.addPart(-15,0,4,0);//32
		 animates.addPart(-4,-3,4,0);//33
		 animates.addPart(-18,-1,0,0);//34
		 animates.addPart(10,-3,1,0);//35
		 animates.addPart(-9,-6,2,0);//36
		 animates.addPart(29,-9,2,0);//37
		 animates.addPart(-32,-7,7,0);//38
		 animates.addPart(-14,-7,6,0);//39
		 animates.addPart(22,-7,6,0);//40
		 animates.addPart(-5,-7,6,0);//41
		 animates.addPart(13,-7,6,0);//42
		 animates.addPart(4,-7,6,0);//43
		 animates.addPart(31,-7,6,0);//44
		 animates.addPart(40,-7,6,0);//45
		 animates.addPart(-23,-7,6,0);//46
		
		
	    animates.setFrame(new int[8][]);
	     animates.setComboFrame(new int[]{0,1,2,3,4,5,6,7,8,9,10,11,},0);//0
		 animates.setComboFrame(new int[]{12,0,1,3,4,5,6,7,8,9,10,11,},1);//1
		 animates.setComboFrame(new int[]{13,2,1,3,4,5,6,7,8,9,10,11,},2);//2
		 animates.setComboFrame(new int[]{14,2,0,3,4,5,6,7,8,9,10,11,},3);//3
		 animates.setComboFrame(new int[]{15,16,17,18,19,20,21,22,23,24,},4);//4
		 animates.setComboFrame(new int[]{25,26,27,28,29,30,24,},5);//5
		 animates.setComboFrame(new int[]{31,32,33,34,35,36,37,},6);//6
		 animates.setComboFrame(new int[]{38,39,40,41,42,43,44,45,46,},7);//7
		
		
		// cds
	    CCollides collides = new CCollides(7);
		 collides.addCDRect(65535, -32, -7, 81 , 14 );//rect//0
	     collides.addCDRect(65535, -10, 0, 1 , 1 );//rect//1
	     collides.addCDRect(65535, 0, 4, 1 , 1 );//rect//2
	     collides.addCDRect(65535, 13, -2, 1 , 1 );//rect//3
	     collides.addCDRect(65535, -12, 3, 1 , 1 );//rect//4
	     collides.addCDRect(65535, -1, 0, 1 , 1 );//rect//5
	     collides.addCDRect(65535, 12, 4, 1 , 1 );//rect//6
	    
	    
	    collides.setFrame(new int[5][]);
	     collides.setComboFrame(new int[]{0,},0);//0
	     collides.setComboFrame(new int[]{},1);//1
	     collides.setComboFrame(new int[]{1,2,3,},2);//2
	     collides.setComboFrame(new int[]{4,5,6,},3);//3
	     collides.setComboFrame(new int[]{2,1,3,},4);//4
	    
	    
	    
		// sprite frame
/*
		String[] frameName = new String[]{
			"0000",
"0001",

		};
		
		for(int i=0;i<frameName.length;i++){
			System.out.println(frameName[i]);
		}
*/
	    int[][] frameAnimate = new int[][]{
	        {0,1,0,0,0,0,2,0,0,0,0,0,3,0,0,0,0,0,4,5,5,6,6,5,5,6,6,5,5,6,6,5,5,6,6,4,0,0,},
{7,},

	    };
	    int[][] frameCDMap = new int[][]{
	        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,},
{1,},

	    };
	    int[][] frameCDAtk = new int[][]{
	        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,},
{1,},

	    };
	    int[][] frameCDDef = new int[][]{
	        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,},
{1,},

	    };
	    int[][] frameCDExt = new int[][]{
	        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,3,3,4,4,3,3,2,2,3,3,4,4,3,3,1,1,1,},
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
	

	// Sprite : boss4
	final static public CSprite createSprite_boss4(IImages tiles){

	    // tiles
	    CAnimates animates = new CAnimates(2,tiles);
	     animates.addPart(-39,-29,0,0);//0
		 animates.addPart(-39,-29,1,0);//1
		
		
	    animates.setFrame(new int[2][]);
	     animates.setComboFrame(new int[]{0,},0);//0
		 animates.setComboFrame(new int[]{1,},1);//1
		
		
		// cds
	    CCollides collides = new CCollides(5);
		 collides.addCDRect(65535, -39, -13, 78 , 37 );//rect//0
	     collides.addCDRect(65535, -36, -5, 1 , 1 );//rect//1
	     collides.addCDRect(65535, 7, -16, 1 , 1 );//rect//2
	     collides.addCDRect(65535, 17, -5, 1 , 1 );//rect//3
	     collides.addCDRect(65535, 16, 10, 1 , 1 );//rect//4
	    
	    
	    collides.setFrame(new int[3][]);
	     collides.setComboFrame(new int[]{0,},0);//0
	     collides.setComboFrame(new int[]{},1);//1
	     collides.setComboFrame(new int[]{1,2,3,4,},2);//2
	    
	    
	    
		// sprite frame
/*
		String[] frameName = new String[]{
			"0000",
"0001",

		};
		
		for(int i=0;i<frameName.length;i++){
			System.out.println(frameName[i]);
		}
*/
	    int[][] frameAnimate = new int[][]{
	        {0,},
{1,},

	    };
	    int[][] frameCDMap = new int[][]{
	        {0,},
{1,},

	    };
	    int[][] frameCDAtk = new int[][]{
	        {1,},
{1,},

	    };
	    int[][] frameCDDef = new int[][]{
	        {1,},
{1,},

	    };
	    int[][] frameCDExt = new int[][]{
	        {2,},
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
	

	// Sprite : boss5
	final static public CSprite createSprite_boss5(IImages tiles){

	    // tiles
	    CAnimates animates = new CAnimates(34,tiles);
	     animates.addPart(-5,9,8,1);//0
		 animates.addPart(-8,-4,7,0);//1
		 animates.addPart(-19,-9,2,0);//2
		 animates.addPart(-5,4,1,0);//3
		 animates.addPart(7,5,1,0);//4
		 animates.addPart(-8,4,3,0);//5
		 animates.addPart(-14,5,1,0);//6
		 animates.addPart(-14,10,8,1);//7
		 animates.addPart(1,10,8,1);//8
		 animates.addPart(7,10,8,1);//9
		 animates.addPart(-7,-4,7,0);//10
		 animates.addPart(-2,7,5,1);//11
		 animates.addPart(-2,3,1,0);//12
		 animates.addPart(-11,4,1,0);//13
		 animates.addPart(9,4,1,0);//14
		 animates.addPart(-11,9,5,1);//15
		 animates.addPart(9,9,5,1);//16
		 animates.addPart(-1,9,5,1);//17
		 animates.addPart(-1,7,4,1);//18
		 animates.addPart(-10,8,4,1);//19
		 animates.addPart(-6,-4,7,0);//20
		 animates.addPart(-9,3,1,0);//21
		 animates.addPart(0,2,1,0);//22
		 animates.addPart(7,3,1,0);//23
		 animates.addPart(6,8,4,1);//24
		 animates.addPart(-6,7,4,1);//25
		 animates.addPart(3,8,5,1);//26
		 animates.addPart(6,7,5,1);//27
		 animates.addPart(-6,8,5,1);//28
		 animates.addPart(-10,8,5,1);//29
		 animates.addPart(-6,3,1,0);//30
		 animates.addPart(3,3,1,0);//31
		 animates.addPart(4,3,1,0);//32
		 animates.addPart(-8,-8,0,0);//33
		
		
	    animates.setFrame(new int[5][]);
	     animates.setComboFrame(new int[]{0,1,2,3,4,5,6,7,8,9,},0);//0
		 animates.setComboFrame(new int[]{10,2,11,12,13,14,5,15,16,17,},1);//1
		 animates.setComboFrame(new int[]{18,19,20,2,21,22,5,23,24,25,},2);//2
		 animates.setComboFrame(new int[]{26,27,28,29,20,2,30,31,5,32,21,},3);//3
		 animates.setComboFrame(new int[]{33,1,2,3,4,5,6,},4);//4
		
		
		// cds
	    CCollides collides = new CCollides(3);
		 collides.addCDRect(65535, -8, -8, 16 , 8 );//rect//0
	     collides.addCDRect(65535, 0, 10, 1 , 1 );//rect//1
	     collides.addCDRect(65535, 0, -3, 1 , 1 );//rect//2
	    
	    
	    collides.setFrame(new int[3][]);
	     collides.setComboFrame(new int[]{0,},0);//0
	     collides.setComboFrame(new int[]{},1);//1
	     collides.setComboFrame(new int[]{1,2,},2);//2
	    
	    
	    
		// sprite frame
/*
		String[] frameName = new String[]{
			"0000",
"0000",

		};
		
		for(int i=0;i<frameName.length;i++){
			System.out.println(frameName[i]);
		}
*/
	    int[][] frameAnimate = new int[][]{
	        {0,1,2,3,},
{4,},

	    };
	    int[][] frameCDMap = new int[][]{
	        {0,1,1,1,},
{0,},

	    };
	    int[][] frameCDAtk = new int[][]{
	        {1,1,1,1,},
{1,},

	    };
	    int[][] frameCDDef = new int[][]{
	        {1,1,1,1,},
{1,},

	    };
	    int[][] frameCDExt = new int[][]{
	        {2,1,1,1,},
{2,},

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
	

	// Sprite : fightUISprite
	final static public CSprite createSprite_fightUISprite(IImages tiles){

	    // tiles
	    CAnimates animates = new CAnimates(28,tiles);
	     animates.addPart(3,2,1,0);//0
		 animates.addPart(147,0,5,0);//1
		 animates.addPart(30,0,26,0);//2
		 animates.addPart(37,28,27,0);//3
		 animates.addPart(134,0,26,2);//4
		 animates.addPart(105,28,27,2);//5
		 animates.addPart(34,16,4,0);//6
		 animates.addPart(49,7,2,0);//7
		 animates.addPart(0,0,6,0);//8
		 animates.addPart(0,0,7,0);//9
		 animates.addPart(0,0,8,0);//10
		 animates.addPart(0,0,9,0);//11
		 animates.addPart(0,0,10,0);//12
		 animates.addPart(0,0,11,0);//13
		 animates.addPart(0,0,12,0);//14
		 animates.addPart(0,0,13,0);//15
		 animates.addPart(0,0,14,0);//16
		 animates.addPart(0,0,15,0);//17
		 animates.addPart(0,0,16,0);//18
		 animates.addPart(0,0,17,0);//19
		 animates.addPart(0,0,18,0);//20
		 animates.addPart(0,0,19,0);//21
		 animates.addPart(0,0,20,0);//22
		 animates.addPart(0,0,21,0);//23
		 animates.addPart(0,0,22,0);//24
		 animates.addPart(0,0,23,0);//25
		 animates.addPart(0,0,24,0);//26
		 animates.addPart(0,0,25,0);//27
		
		
	    animates.setFrame(new int[21][]);
	     animates.setComboFrame(new int[]{0,1,2,3,4,5,6,7,},0);//0
		 animates.setComboFrame(new int[]{8,},1);//1
		 animates.setComboFrame(new int[]{9,},2);//2
		 animates.setComboFrame(new int[]{10,},3);//3
		 animates.setComboFrame(new int[]{11,},4);//4
		 animates.setComboFrame(new int[]{12,},5);//5
		 animates.setComboFrame(new int[]{13,},6);//6
		 animates.setComboFrame(new int[]{14,},7);//7
		 animates.setComboFrame(new int[]{15,},8);//8
		 animates.setComboFrame(new int[]{16,},9);//9
		 animates.setComboFrame(new int[]{17,},10);//10
		 animates.setComboFrame(new int[]{18,},11);//11
		 animates.setComboFrame(new int[]{19,},12);//12
		 animates.setComboFrame(new int[]{20,},13);//13
		 animates.setComboFrame(new int[]{21,},14);//14
		 animates.setComboFrame(new int[]{22,},15);//15
		 animates.setComboFrame(new int[]{23,},16);//16
		 animates.setComboFrame(new int[]{24,},17);//17
		 animates.setComboFrame(new int[]{25,},18);//18
		 animates.setComboFrame(new int[]{26,},19);//19
		 animates.setComboFrame(new int[]{27,},20);//20
		
		
		// cds
	    CCollides collides = new CCollides(10);
		 collides.addCDRect(65535, 154, 19, 1 , 1 );//rect//0
	     collides.addCDRect(65535, 143, 19, 1 , 1 );//rect//1
	     collides.addCDRect(65535, 96, 28, 1 , 1 );//rect//2
	     collides.addCDRect(65535, 89, 28, 1 , 1 );//rect//3
	     collides.addCDRect(65535, 82, 28, 1 , 1 );//rect//4
	     collides.addCDRect(65535, 75, 28, 1 , 1 );//rect//5
	     collides.addCDRect(65535, 68, 28, 1 , 1 );//rect//6
	     collides.addCDRect(65535, 135, 16, 1 , 1 );//rect//7
	     collides.addCDRect(65535, 51, 9, 68 , 5 );//rect//8
	     collides.addCDRect(65535, 36, 16, 1 , 1 );//rect//9
	    
	    
	    collides.setFrame(new int[2][]);
	     collides.setComboFrame(new int[]{},0);//0
	     collides.setComboFrame(new int[]{0,1,2,3,4,5,6,7,8,9,},1);//1
	    
	    
	    
		// sprite frame
/*
		String[] frameName = new String[]{
			"0000",
"0001",
"0002",

		};
		
		for(int i=0;i<frameName.length;i++){
			System.out.println(frameName[i]);
		}
*/
	    int[][] frameAnimate = new int[][]{
	        {0,},
{1,2,3,4,5,6,7,8,9,10,},
{11,12,13,14,15,16,17,18,19,20,},

	    };
	    int[][] frameCDMap = new int[][]{
	        {0,},
{0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,},

	    };
	    int[][] frameCDAtk = new int[][]{
	        {0,},
{0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,},

	    };
	    int[][] frameCDDef = new int[][]{
	        {0,},
{0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,},

	    };
	    int[][] frameCDExt = new int[][]{
	        {1,},
{0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,},

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
	
	 
	final public static String images_battleWeaopnTile = "battleWeaopnTile";
	
 
	final public static String images_battleEffectTile = "battleEffectTile";
	
 
	final public static String images_battleSprTile = "battleSprTile";
	
 
	final public static String images_battleMapTile1 = "battleMapTile1";
	
 
	final public static String images_battleMapTile2 = "battleMapTile2";
	
 
	final public static String images_battleBGTile = "battleBGTile";
	
 
	final public static String images_boss1Tile = "boss1Tile";
	
 
	final public static String images_boss2Tile = "boss2Tile";
	
 
	final public static String images_boss3Tile = "boss3Tile";
	
 
	final public static String images_battleMapTile3 = "battleMapTile3";
	
 
	final public static String images_boss4Tile = "boss4Tile";
	
 
	final public static String images_boss5Tile = "boss5Tile";
	
 
	final public static String images_battleUITile = "battleUITile";
	


	
	final public static String map_01_Map = "01_Map";
	

	final public static String map_02_Map = "02_Map";
	

	final public static String map_03_Map = "03_Map";
	

	
	
	final public static String spr_wpMissile1 = "wpMissile1";
	

	final public static String spr_wpMissile2 = "wpMissile2";
	

	final public static String spr_wpLaser = "wpLaser";
	

	final public static String spr_wpBomb = "wpBomb";
	

	final public static String spr_wpShortSlug1 = "wpShortSlug1";
	

	final public static String spr_wpLight1 = "wpLight1";
	

	final public static String spr_wpBombExp = "wpBombExp";
	

	final public static String spr_wpShortSlug2 = "wpShortSlug2";
	

	final public static String spr_wpLight2 = "wpLight2";
	

	final public static String spr_wpRocket = "wpRocket";
	

	final public static String spr_weaopnSprite = "weaopnSprite";
	

	final public static String spr_effect = "effect";
	

	final public static String spr_btSpr = "btSpr";
	

	final public static String spr_btSub = "btSub";
	

	final public static String spr_btEnemy001 = "btEnemy001";
	

	final public static String spr_btEnemy002 = "btEnemy002";
	

	final public static String spr_btEnemy003 = "btEnemy003";
	

	final public static String spr_btEnemy004 = "btEnemy004";
	

	final public static String spr_btEnemy005 = "btEnemy005";
	

	final public static String spr_btEnemy006 = "btEnemy006";
	

	final public static String spr_layer = "layer";
	

	final public static String spr_boss1 = "boss1";
	

	final public static String spr_boss2 = "boss2";
	

	final public static String spr_boos2Sub = "boos2Sub";
	

	final public static String spr_boss3 = "boss3";
	

	final public static String spr_boss4 = "boss4";
	

	final public static String spr_boss5 = "boss5";
	

	final public static String spr_fightUISprite = "fightUISprite";
	



	//--------------------------------------------------------------------------------------------------------------
	final public static IImages createImages(String key){
	 
		if(key.indexOf("battleWeaopnTile")>=0){
			return createClipImages_battleWeaopnTile();
		}
	
 
		if(key.indexOf("battleEffectTile")>=0){
			return createClipImages_battleEffectTile();
		}
	
 
		if(key.indexOf("battleSprTile")>=0){
			return createClipImages_battleSprTile();
		}
	
 
		if(key.indexOf("battleMapTile1")>=0){
			return createClipImages_battleMapTile1();
		}
	
 
		if(key.indexOf("battleMapTile2")>=0){
			return createClipImages_battleMapTile2();
		}
	
 
		if(key.indexOf("battleBGTile")>=0){
			return createClipImages_battleBGTile();
		}
	
 
		if(key.indexOf("boss1Tile")>=0){
			return createClipImages_boss1Tile();
		}
	
 
		if(key.indexOf("boss2Tile")>=0){
			return createClipImages_boss2Tile();
		}
	
 
		if(key.indexOf("boss3Tile")>=0){
			return createClipImages_boss3Tile();
		}
	
 
		if(key.indexOf("battleMapTile3")>=0){
			return createClipImages_battleMapTile3();
		}
	
 
		if(key.indexOf("boss4Tile")>=0){
			return createClipImages_boss4Tile();
		}
	
 
		if(key.indexOf("boss5Tile")>=0){
			return createClipImages_boss5Tile();
		}
	
 
		if(key.indexOf("battleUITile")>=0){
			return createClipImages_battleUITile();
		}
	

		return null;
	}
	
	final public static CMap createMap(String key, IImages tiles, boolean isAnimate, boolean isCyc){
	
		if(key.indexOf("01_Map")>=0){
			return createMap_01_Map(tiles,isAnimate,isCyc);
		}
	

		if(key.indexOf("02_Map")>=0){
			return createMap_02_Map(tiles,isAnimate,isCyc);
		}
	

		if(key.indexOf("03_Map")>=0){
			return createMap_03_Map(tiles,isAnimate,isCyc);
		}
	

		return null;
	}
	
	final public static CSprite createSprite(String key, IImages tiles){
	
		if(key.indexOf("wpMissile1")>=0){
			return createSprite_wpMissile1(tiles);
		}
	

		if(key.indexOf("wpMissile2")>=0){
			return createSprite_wpMissile2(tiles);
		}
	

		if(key.indexOf("wpLaser")>=0){
			return createSprite_wpLaser(tiles);
		}
	

		if(key.indexOf("wpBomb")>=0){
			return createSprite_wpBomb(tiles);
		}
	

		if(key.indexOf("wpShortSlug1")>=0){
			return createSprite_wpShortSlug1(tiles);
		}
	

		if(key.indexOf("wpLight1")>=0){
			return createSprite_wpLight1(tiles);
		}
	

		if(key.indexOf("wpBombExp")>=0){
			return createSprite_wpBombExp(tiles);
		}
	

		if(key.indexOf("wpShortSlug2")>=0){
			return createSprite_wpShortSlug2(tiles);
		}
	

		if(key.indexOf("wpLight2")>=0){
			return createSprite_wpLight2(tiles);
		}
	

		if(key.indexOf("wpRocket")>=0){
			return createSprite_wpRocket(tiles);
		}
	

		if(key.indexOf("weaopnSprite")>=0){
			return createSprite_weaopnSprite(tiles);
		}
	

		if(key.indexOf("effect")>=0){
			return createSprite_effect(tiles);
		}
	

		if(key.indexOf("btSpr")>=0){
			return createSprite_btSpr(tiles);
		}
	

		if(key.indexOf("btSub")>=0){
			return createSprite_btSub(tiles);
		}
	

		if(key.indexOf("btEnemy001")>=0){
			return createSprite_btEnemy001(tiles);
		}
	

		if(key.indexOf("btEnemy002")>=0){
			return createSprite_btEnemy002(tiles);
		}
	

		if(key.indexOf("btEnemy003")>=0){
			return createSprite_btEnemy003(tiles);
		}
	

		if(key.indexOf("btEnemy004")>=0){
			return createSprite_btEnemy004(tiles);
		}
	

		if(key.indexOf("btEnemy005")>=0){
			return createSprite_btEnemy005(tiles);
		}
	

		if(key.indexOf("btEnemy006")>=0){
			return createSprite_btEnemy006(tiles);
		}
	

		if(key.indexOf("layer")>=0){
			return createSprite_layer(tiles);
		}
	

		if(key.indexOf("boss1")>=0){
			return createSprite_boss1(tiles);
		}
	

		if(key.indexOf("boss2")>=0){
			return createSprite_boss2(tiles);
		}
	

		if(key.indexOf("boos2Sub")>=0){
			return createSprite_boos2Sub(tiles);
		}
	

		if(key.indexOf("boss3")>=0){
			return createSprite_boss3(tiles);
		}
	

		if(key.indexOf("boss4")>=0){
			return createSprite_boss4(tiles);
		}
	

		if(key.indexOf("boss5")>=0){
			return createSprite_boss5(tiles);
		}
	

		if(key.indexOf("fightUISprite")>=0){
			return createSprite_fightUISprite(tiles);
		}
	

		return null;
	}




//--------------------------------------------------------------------------------------------------------------
// level trunk
//--------------------------------------------------------------------------------------------------------------

	

	 
	final public static String world_battleLevel_00 = "battleLevel_00";
	
 
	final public static String world_battleLevel_01 = "battleLevel_01";
	
 
	final public static String world_battleLevel_02 = "battleLevel_02";
	
 
	final public static String world_battleLevel_03 = "battleLevel_03";
	
 
	final public static String world_battleLevel_04 = "battleLevel_04";
	
 
	final public static String world_battleLevel_05 = "battleLevel_05";
	
 
	final public static String world_battleLevel_06 = "battleLevel_06";
	
 
	final public static String world_bossLevel_01 = "bossLevel_01";
	
 
	final public static String world_bossLevel_02 = "bossLevel_02";
	
 
	final public static String world_bossLevel_03 = "bossLevel_03";
	
 
	final public static String world_bossLevel_04 = "bossLevel_04";
	
 
	final public static String world_bossLevel_05 = "bossLevel_05";
	




	final static public String[] WorldNames = new String[]{
	 "battleLevel_00",
	
 "battleLevel_01",
	
 "battleLevel_02",
	
 "battleLevel_03",
	
 "battleLevel_04",
	
 "battleLevel_05",
	
 "battleLevel_06",
	
 "bossLevel_01",
	
 "bossLevel_02",
	
 "bossLevel_03",
	
 "bossLevel_04",
	
 "bossLevel_05",
	

	};


	final static public int getWorldWidth(String Name){
	
		// World : battleLevel_00
		if(Name.indexOf("battleLevel_00")>=0){
			return 1760;
		}
	

		// World : battleLevel_01
		if(Name.indexOf("battleLevel_01")>=0){
			return 1760;
		}
	

		// World : battleLevel_02
		if(Name.indexOf("battleLevel_02")>=0){
			return 1760;
		}
	

		// World : battleLevel_03
		if(Name.indexOf("battleLevel_03")>=0){
			return 1760;
		}
	

		// World : battleLevel_04
		if(Name.indexOf("battleLevel_04")>=0){
			return 1760;
		}
	

		// World : battleLevel_05
		if(Name.indexOf("battleLevel_05")>=0){
			return 1760;
		}
	

		// World : battleLevel_06
		if(Name.indexOf("battleLevel_06")>=0){
			return 1760;
		}
	

		// World : bossLevel_01
		if(Name.indexOf("bossLevel_01")>=0){
			return 1744;
		}
	

		// World : bossLevel_02
		if(Name.indexOf("bossLevel_02")>=0){
			return 1763;
		}
	

		// World : bossLevel_03
		if(Name.indexOf("bossLevel_03")>=0){
			return 1760;
		}
	

		// World : bossLevel_04
		if(Name.indexOf("bossLevel_04")>=0){
			return 1760;
		}
	

		// World : bossLevel_05
		if(Name.indexOf("bossLevel_05")>=0){
			return 1760;
		}
	

		return -1;
	}

	final static public int getWorldHeight(String Name){
	
		// World : battleLevel_00
		if(Name.indexOf("battleLevel_00")>=0){
			return 320;
		}
	

		// World : battleLevel_01
		if(Name.indexOf("battleLevel_01")>=0){
			return 320;
		}
	

		// World : battleLevel_02
		if(Name.indexOf("battleLevel_02")>=0){
			return 320;
		}
	

		// World : battleLevel_03
		if(Name.indexOf("battleLevel_03")>=0){
			return 320;
		}
	

		// World : battleLevel_04
		if(Name.indexOf("battleLevel_04")>=0){
			return 320;
		}
	

		// World : battleLevel_05
		if(Name.indexOf("battleLevel_05")>=0){
			return 320;
		}
	

		// World : battleLevel_06
		if(Name.indexOf("battleLevel_06")>=0){
			return 320;
		}
	

		// World : bossLevel_01
		if(Name.indexOf("bossLevel_01")>=0){
			return 320;
		}
	

		// World : bossLevel_02
		if(Name.indexOf("bossLevel_02")>=0){
			return 323;
		}
	

		// World : bossLevel_03
		if(Name.indexOf("bossLevel_03")>=0){
			return 300;
		}
	

		// World : bossLevel_04
		if(Name.indexOf("bossLevel_04")>=0){
			return 300;
		}
	

		// World : bossLevel_05
		if(Name.indexOf("bossLevel_05")>=0){
			return 320;
		}
	

		return -1;
	}

	
	final static public CWayPoint[] getWorldWayPoints(String Name){
	
		// World : battleLevel_00
		if(Name.indexOf("battleLevel_00")>=0){
			// waypoint count : 25
			CWayPoint[] WayPoints = new CWayPoint[25];
			 WayPoints[0] = new CWayPoint(290,66);
			 WayPoints[1] = new CWayPoint(242,98);
			 WayPoints[2] = new CWayPoint(242,178);
			 WayPoints[3] = new CWayPoint(290,210);
			 WayPoints[4] = new CWayPoint(354,146);
			 WayPoints[5] = new CWayPoint(562,146);
			 WayPoints[6] = new CWayPoint(370,98);
			 WayPoints[7] = new CWayPoint(418,194);
			 WayPoints[8] = new CWayPoint(466,98);
			 WayPoints[9] = new CWayPoint(514,194);
			 WayPoints[10] = new CWayPoint(562,98);
			 WayPoints[11] = new CWayPoint(626,146);
			 WayPoints[12] = new CWayPoint(722,146);
			 WayPoints[13] = new CWayPoint(754,226);
			 WayPoints[14] = new CWayPoint(946,50);
			 WayPoints[15] = new CWayPoint(754,82);
			 WayPoints[16] = new CWayPoint(946,258);
			 WayPoints[17] = new CWayPoint(1394,114);
			 WayPoints[18] = new CWayPoint(1394,82);
			 WayPoints[19] = new CWayPoint(1506,82);
			 WayPoints[20] = new CWayPoint(1650,258);
			 WayPoints[21] = new CWayPoint(1394,194);
			 WayPoints[22] = new CWayPoint(1394,226);
			 WayPoints[23] = new CWayPoint(1506,226);
			 WayPoints[24] = new CWayPoint(1650,34);
			
			
			// waypoint link 
			 WayPoints[0].linkTo(WayPoints[1]);//0
			 WayPoints[1].linkTo(WayPoints[2]);//1
			 WayPoints[2].linkTo(WayPoints[3]);//2
			 WayPoints[3].linkTo(WayPoints[4]);//3
			 WayPoints[4].linkTo(WayPoints[5]);//4
			 WayPoints[6].linkTo(WayPoints[7]);//5
			 WayPoints[7].linkTo(WayPoints[8]);//6
			 WayPoints[8].linkTo(WayPoints[9]);//7
			 WayPoints[9].linkTo(WayPoints[10]);//8
			 WayPoints[10].linkTo(WayPoints[11]);//9
			 WayPoints[11].linkTo(WayPoints[12]);//10
			 WayPoints[12].linkTo(WayPoints[11]);//11
			 WayPoints[13].linkTo(WayPoints[14]);//12
			 WayPoints[15].linkTo(WayPoints[16]);//13
			 WayPoints[17].linkTo(WayPoints[18]);//14
			 WayPoints[18].linkTo(WayPoints[19]);//15
			 WayPoints[19].linkTo(WayPoints[20]);//16
			 WayPoints[21].linkTo(WayPoints[22]);//17
			 WayPoints[22].linkTo(WayPoints[23]);//18
			 WayPoints[23].linkTo(WayPoints[24]);//19
			
			
			return WayPoints;
		}
	

		// World : battleLevel_01
		if(Name.indexOf("battleLevel_01")>=0){
			// waypoint count : 30
			CWayPoint[] WayPoints = new CWayPoint[30];
			 WayPoints[0] = new CWayPoint(144,112);
			 WayPoints[1] = new CWayPoint(112,144);
			 WayPoints[2] = new CWayPoint(192,208);
			 WayPoints[3] = new CWayPoint(256,128);
			 WayPoints[4] = new CWayPoint(336,112);
			 WayPoints[5] = new CWayPoint(384,160);
			 WayPoints[6] = new CWayPoint(496,160);
			 WayPoints[7] = new CWayPoint(208,160);
			 WayPoints[8] = new CWayPoint(272,288);
			 WayPoints[9] = new CWayPoint(448,80);
			 WayPoints[10] = new CWayPoint(272,32);
			 WayPoints[11] = new CWayPoint(448,208);
			 WayPoints[12] = new CWayPoint(560,144);
			 WayPoints[13] = new CWayPoint(832,160);
			 WayPoints[14] = new CWayPoint(1104,160);
			 WayPoints[15] = new CWayPoint(1168,97);
			 WayPoints[16] = new CWayPoint(1168,240);
			 WayPoints[17] = new CWayPoint(1328,160);
			 WayPoints[18] = new CWayPoint(1264,96);
			 WayPoints[19] = new CWayPoint(1264,224);
			 WayPoints[20] = new CWayPoint(1296,96);
			 WayPoints[21] = new CWayPoint(1328,96);
			 WayPoints[22] = new CWayPoint(1360,96);
			 WayPoints[23] = new CWayPoint(1392,96);
			 WayPoints[24] = new CWayPoint(1552,288);
			 WayPoints[25] = new CWayPoint(1296,224);
			 WayPoints[26] = new CWayPoint(1328,224);
			 WayPoints[27] = new CWayPoint(1360,224);
			 WayPoints[28] = new CWayPoint(1392,224);
			 WayPoints[29] = new CWayPoint(1552,32);
			
			
			// waypoint link 
			 WayPoints[0].linkTo(WayPoints[1]);//0
			 WayPoints[1].linkTo(WayPoints[2]);//1
			 WayPoints[2].linkTo(WayPoints[3]);//2
			 WayPoints[3].linkTo(WayPoints[4]);//3
			 WayPoints[4].linkTo(WayPoints[5]);//4
			 WayPoints[5].linkTo(WayPoints[6]);//5
			 WayPoints[6].linkTo(WayPoints[5]);//6
			 WayPoints[9].linkTo(WayPoints[8]);//7
			 WayPoints[11].linkTo(WayPoints[10]);//8
			 WayPoints[14].linkTo(WayPoints[15]);//9
			 WayPoints[15].linkTo(WayPoints[16]);//10
			 WayPoints[16].linkTo(WayPoints[14]);//11
			 WayPoints[17].linkTo(WayPoints[18]);//12
			 WayPoints[17].linkTo(WayPoints[20]);//13
			 WayPoints[17].linkTo(WayPoints[21]);//14
			 WayPoints[17].linkTo(WayPoints[22]);//15
			 WayPoints[17].linkTo(WayPoints[23]);//16
			 WayPoints[17].linkTo(WayPoints[19]);//17
			 WayPoints[17].linkTo(WayPoints[25]);//18
			 WayPoints[17].linkTo(WayPoints[26]);//19
			 WayPoints[17].linkTo(WayPoints[27]);//20
			 WayPoints[17].linkTo(WayPoints[28]);//21
			 WayPoints[24].linkTo(WayPoints[29]);//22
			 WayPoints[29].linkTo(WayPoints[24]);//23
			
			
			return WayPoints;
		}
	

		// World : battleLevel_02
		if(Name.indexOf("battleLevel_02")>=0){
			// waypoint count : 20
			CWayPoint[] WayPoints = new CWayPoint[20];
			 WayPoints[0] = new CWayPoint(272,160);
			 WayPoints[1] = new CWayPoint(240,128);
			 WayPoints[2] = new CWayPoint(240,192);
			 WayPoints[3] = new CWayPoint(400,160);
			 WayPoints[4] = new CWayPoint(384,64);
			 WayPoints[5] = new CWayPoint(464,64);
			 WayPoints[6] = new CWayPoint(464,144);
			 WayPoints[7] = new CWayPoint(384,144);
			 WayPoints[8] = new CWayPoint(384,176);
			 WayPoints[9] = new CWayPoint(464,176);
			 WayPoints[10] = new CWayPoint(464,256);
			 WayPoints[11] = new CWayPoint(384,256);
			 WayPoints[12] = new CWayPoint(541,207);
			 WayPoints[13] = new CWayPoint(540,115);
			 WayPoints[14] = new CWayPoint(816,160);
			 WayPoints[15] = new CWayPoint(848,160);
			 WayPoints[16] = new CWayPoint(848,96);
			 WayPoints[17] = new CWayPoint(848,224);
			 WayPoints[18] = new CWayPoint(736,224);
			 WayPoints[19] = new CWayPoint(736,96);
			
			
			// waypoint link 
			 WayPoints[0].linkTo(WayPoints[3]);//0
			 WayPoints[1].linkTo(WayPoints[0]);//1
			 WayPoints[2].linkTo(WayPoints[0]);//2
			 WayPoints[4].linkTo(WayPoints[5]);//3
			 WayPoints[5].linkTo(WayPoints[6]);//4
			 WayPoints[6].linkTo(WayPoints[7]);//5
			 WayPoints[7].linkTo(WayPoints[4]);//6
			 WayPoints[8].linkTo(WayPoints[9]);//7
			 WayPoints[9].linkTo(WayPoints[10]);//8
			 WayPoints[10].linkTo(WayPoints[11]);//9
			 WayPoints[11].linkTo(WayPoints[8]);//10
			 WayPoints[14].linkTo(WayPoints[15]);//11
			 WayPoints[15].linkTo(WayPoints[16]);//12
			 WayPoints[15].linkTo(WayPoints[17]);//13
			 WayPoints[16].linkTo(WayPoints[19]);//14
			 WayPoints[17].linkTo(WayPoints[18]);//15
			
			
			return WayPoints;
		}
	

		// World : battleLevel_03
		if(Name.indexOf("battleLevel_03")>=0){
			// waypoint count : 18
			CWayPoint[] WayPoints = new CWayPoint[18];
			 WayPoints[0] = new CWayPoint(240,80);
			 WayPoints[1] = new CWayPoint(240,224);
			 WayPoints[2] = new CWayPoint(160,240);
			 WayPoints[3] = new CWayPoint(160,64);
			 WayPoints[4] = new CWayPoint(272,144);
			 WayPoints[5] = new CWayPoint(896,128);
			 WayPoints[6] = new CWayPoint(1056,208);
			 WayPoints[7] = new CWayPoint(896,224);
			 WayPoints[8] = new CWayPoint(1056,64);
			 WayPoints[9] = new CWayPoint(1280,192);
			 WayPoints[10] = new CWayPoint(1440,64);
			 WayPoints[11] = new CWayPoint(1520,144);
			 WayPoints[12] = new CWayPoint(1472,144);
			 WayPoints[13] = new CWayPoint(1280,96);
			 WayPoints[14] = new CWayPoint(1440,240);
			 WayPoints[15] = new CWayPoint(1280,16);
			 WayPoints[16] = new CWayPoint(1232,144);
			 WayPoints[17] = new CWayPoint(1280,304);
			
			
			// waypoint link 
			 WayPoints[0].linkTo(WayPoints[1]);//0
			 WayPoints[1].linkTo(WayPoints[0]);//1
			 WayPoints[5].linkTo(WayPoints[6]);//2
			 WayPoints[7].linkTo(WayPoints[8]);//3
			 WayPoints[9].linkTo(WayPoints[10]);//4
			 WayPoints[10].linkTo(WayPoints[11]);//5
			 WayPoints[11].linkTo(WayPoints[12]);//6
			 WayPoints[12].linkTo(WayPoints[17]);//7
			 WayPoints[12].linkTo(WayPoints[16]);//8
			 WayPoints[12].linkTo(WayPoints[15]);//9
			 WayPoints[13].linkTo(WayPoints[14]);//10
			 WayPoints[14].linkTo(WayPoints[11]);//11
			
			
			return WayPoints;
		}
	

		// World : battleLevel_04
		if(Name.indexOf("battleLevel_04")>=0){
			// waypoint count : 27
			CWayPoint[] WayPoints = new CWayPoint[27];
			 WayPoints[0] = new CWayPoint(576,48);
			 WayPoints[1] = new CWayPoint(576,112);
			 WayPoints[2] = new CWayPoint(576,192);
			 WayPoints[3] = new CWayPoint(576,256);
			 WayPoints[4] = new CWayPoint(656,112);
			 WayPoints[5] = new CWayPoint(656,176);
			 WayPoints[6] = new CWayPoint(752,96);
			 WayPoints[7] = new CWayPoint(752,208);
			 WayPoints[8] = new CWayPoint(960,160);
			 WayPoints[9] = new CWayPoint(992,128);
			 WayPoints[10] = new CWayPoint(1024,160);
			 WayPoints[11] = new CWayPoint(992,192);
			 WayPoints[12] = new CWayPoint(1008,160);
			 WayPoints[13] = new CWayPoint(1040,128);
			 WayPoints[14] = new CWayPoint(1072,160);
			 WayPoints[15] = new CWayPoint(1040,192);
			 WayPoints[16] = new CWayPoint(1056,160);
			 WayPoints[17] = new CWayPoint(1088,128);
			 WayPoints[18] = new CWayPoint(1120,160);
			 WayPoints[19] = new CWayPoint(1088,192);
			 WayPoints[20] = new CWayPoint(1104,160);
			 WayPoints[21] = new CWayPoint(1136,128);
			 WayPoints[22] = new CWayPoint(1167,160);
			 WayPoints[23] = new CWayPoint(1136,192);
			 WayPoints[24] = new CWayPoint(1152,160);
			 WayPoints[25] = new CWayPoint(1184,128);
			 WayPoints[26] = new CWayPoint(1216,160);
			
			
			// waypoint link 
			 WayPoints[0].linkTo(WayPoints[1]);//0
			 WayPoints[1].linkTo(WayPoints[0]);//1
			 WayPoints[2].linkTo(WayPoints[3]);//2
			 WayPoints[3].linkTo(WayPoints[2]);//3
			 WayPoints[4].linkTo(WayPoints[5]);//4
			 WayPoints[5].linkTo(WayPoints[4]);//5
			 WayPoints[8].linkTo(WayPoints[9]);//6
			 WayPoints[9].linkTo(WayPoints[10]);//7
			 WayPoints[10].linkTo(WayPoints[11]);//8
			 WayPoints[11].linkTo(WayPoints[12]);//9
			 WayPoints[12].linkTo(WayPoints[13]);//10
			 WayPoints[13].linkTo(WayPoints[14]);//11
			 WayPoints[14].linkTo(WayPoints[15]);//12
			 WayPoints[15].linkTo(WayPoints[16]);//13
			 WayPoints[16].linkTo(WayPoints[17]);//14
			 WayPoints[17].linkTo(WayPoints[18]);//15
			 WayPoints[18].linkTo(WayPoints[19]);//16
			 WayPoints[19].linkTo(WayPoints[20]);//17
			 WayPoints[20].linkTo(WayPoints[21]);//18
			 WayPoints[21].linkTo(WayPoints[22]);//19
			 WayPoints[22].linkTo(WayPoints[23]);//20
			 WayPoints[23].linkTo(WayPoints[24]);//21
			 WayPoints[24].linkTo(WayPoints[25]);//22
			 WayPoints[25].linkTo(WayPoints[26]);//23
			
			
			return WayPoints;
		}
	

		// World : battleLevel_05
		if(Name.indexOf("battleLevel_05")>=0){
			// waypoint count : 34
			CWayPoint[] WayPoints = new CWayPoint[34];
			 WayPoints[0] = new CWayPoint(176,80);
			 WayPoints[1] = new CWayPoint(176,144);
			 WayPoints[2] = new CWayPoint(176,160);
			 WayPoints[3] = new CWayPoint(176,224);
			 WayPoints[4] = new CWayPoint(288,224);
			 WayPoints[5] = new CWayPoint(528,224);
			 WayPoints[6] = new CWayPoint(288,80);
			 WayPoints[7] = new CWayPoint(528,80);
			 WayPoints[8] = new CWayPoint(592,224);
			 WayPoints[9] = new CWayPoint(672,80);
			 WayPoints[10] = new CWayPoint(736,224);
			 WayPoints[11] = new CWayPoint(800,80);
			 WayPoints[12] = new CWayPoint(880,224);
			 WayPoints[13] = new CWayPoint(960,80);
			 WayPoints[14] = new CWayPoint(1024,224);
			 WayPoints[15] = new CWayPoint(1248,144);
			 WayPoints[16] = new CWayPoint(1328,144);
			 WayPoints[17] = new CWayPoint(1296,112);
			 WayPoints[18] = new CWayPoint(1280,128);
			 WayPoints[19] = new CWayPoint(1312,96);
			 WayPoints[20] = new CWayPoint(1328,80);
			 WayPoints[21] = new CWayPoint(1344,64);
			 WayPoints[22] = new CWayPoint(1280,160);
			 WayPoints[23] = new CWayPoint(1296,176);
			 WayPoints[24] = new CWayPoint(1312,192);
			 WayPoints[25] = new CWayPoint(1328,208);
			 WayPoints[26] = new CWayPoint(1344,224);
			 WayPoints[27] = new CWayPoint(1632,144);
			 WayPoints[28] = new CWayPoint(1632,64);
			 WayPoints[29] = new CWayPoint(1488,64);
			 WayPoints[30] = new CWayPoint(1712,224);
			 WayPoints[31] = new CWayPoint(1632,224);
			 WayPoints[32] = new CWayPoint(1488,224);
			 WayPoints[33] = new CWayPoint(1712,64);
			
			
			// waypoint link 
			 WayPoints[0].linkTo(WayPoints[1]);//0
			 WayPoints[1].linkTo(WayPoints[0]);//1
			 WayPoints[2].linkTo(WayPoints[3]);//2
			 WayPoints[3].linkTo(WayPoints[2]);//3
			 WayPoints[4].linkTo(WayPoints[5]);//4
			 WayPoints[5].linkTo(WayPoints[4]);//5
			 WayPoints[6].linkTo(WayPoints[7]);//6
			 WayPoints[7].linkTo(WayPoints[6]);//7
			 WayPoints[8].linkTo(WayPoints[9]);//8
			 WayPoints[9].linkTo(WayPoints[10]);//9
			 WayPoints[10].linkTo(WayPoints[11]);//10
			 WayPoints[11].linkTo(WayPoints[12]);//11
			 WayPoints[12].linkTo(WayPoints[13]);//12
			 WayPoints[13].linkTo(WayPoints[14]);//13
			 WayPoints[15].linkTo(WayPoints[16]);//14
			 WayPoints[16].linkTo(WayPoints[18]);//15
			 WayPoints[16].linkTo(WayPoints[17]);//16
			 WayPoints[16].linkTo(WayPoints[19]);//17
			 WayPoints[16].linkTo(WayPoints[20]);//18
			 WayPoints[16].linkTo(WayPoints[21]);//19
			 WayPoints[16].linkTo(WayPoints[22]);//20
			 WayPoints[16].linkTo(WayPoints[23]);//21
			 WayPoints[16].linkTo(WayPoints[24]);//22
			 WayPoints[16].linkTo(WayPoints[25]);//23
			 WayPoints[16].linkTo(WayPoints[26]);//24
			 WayPoints[27].linkTo(WayPoints[28]);//25
			 WayPoints[27].linkTo(WayPoints[31]);//26
			 WayPoints[28].linkTo(WayPoints[29]);//27
			 WayPoints[29].linkTo(WayPoints[30]);//28
			 WayPoints[31].linkTo(WayPoints[32]);//29
			 WayPoints[32].linkTo(WayPoints[33]);//30
			
			
			return WayPoints;
		}
	

		// World : battleLevel_06
		if(Name.indexOf("battleLevel_06")>=0){
			// waypoint count : 73
			CWayPoint[] WayPoints = new CWayPoint[73];
			 WayPoints[0] = new CWayPoint(144,96);
			 WayPoints[1] = new CWayPoint(192,176);
			 WayPoints[2] = new CWayPoint(240,96);
			 WayPoints[3] = new CWayPoint(288,176);
			 WayPoints[4] = new CWayPoint(336,96);
			 WayPoints[5] = new CWayPoint(384,176);
			 WayPoints[6] = new CWayPoint(432,96);
			 WayPoints[7] = new CWayPoint(480,176);
			 WayPoints[8] = new CWayPoint(528,96);
			 WayPoints[9] = new CWayPoint(576,176);
			 WayPoints[10] = new CWayPoint(624,96);
			 WayPoints[11] = new CWayPoint(672,160);
			 WayPoints[12] = new CWayPoint(144,208);
			 WayPoints[13] = new CWayPoint(192,128);
			 WayPoints[14] = new CWayPoint(240,208);
			 WayPoints[15] = new CWayPoint(288,128);
			 WayPoints[16] = new CWayPoint(336,208);
			 WayPoints[17] = new CWayPoint(384,128);
			 WayPoints[18] = new CWayPoint(432,208);
			 WayPoints[19] = new CWayPoint(480,128);
			 WayPoints[20] = new CWayPoint(528,208);
			 WayPoints[21] = new CWayPoint(576,128);
			 WayPoints[22] = new CWayPoint(624,208);
			 WayPoints[23] = new CWayPoint(672,144);
			 WayPoints[24] = new CWayPoint(720,96);
			 WayPoints[25] = new CWayPoint(736,112);
			 WayPoints[26] = new CWayPoint(752,128);
			 WayPoints[27] = new CWayPoint(752,144);
			 WayPoints[28] = new CWayPoint(752,160);
			 WayPoints[29] = new CWayPoint(752,176);
			 WayPoints[30] = new CWayPoint(736,192);
			 WayPoints[31] = new CWayPoint(720,208);
			 WayPoints[32] = new CWayPoint(864,96);
			 WayPoints[33] = new CWayPoint(864,112);
			 WayPoints[34] = new CWayPoint(864,128);
			 WayPoints[35] = new CWayPoint(864,144);
			 WayPoints[36] = new CWayPoint(864,160);
			 WayPoints[37] = new CWayPoint(864,176);
			 WayPoints[38] = new CWayPoint(864,80);
			 WayPoints[39] = new CWayPoint(864,192);
			 WayPoints[40] = new CWayPoint(864,208);
			 WayPoints[41] = new CWayPoint(864,224);
			 WayPoints[42] = new CWayPoint(864,240);
			 WayPoints[43] = new CWayPoint(864,256);
			 WayPoints[44] = new CWayPoint(864,64);
			 WayPoints[45] = new CWayPoint(1248,64);
			 WayPoints[46] = new CWayPoint(1248,80);
			 WayPoints[47] = new CWayPoint(1248,96);
			 WayPoints[48] = new CWayPoint(1248,112);
			 WayPoints[49] = new CWayPoint(1248,128);
			 WayPoints[50] = new CWayPoint(1248,144);
			 WayPoints[51] = new CWayPoint(1248,160);
			 WayPoints[52] = new CWayPoint(1248,176);
			 WayPoints[53] = new CWayPoint(1248,192);
			 WayPoints[54] = new CWayPoint(1248,208);
			 WayPoints[55] = new CWayPoint(1248,224);
			 WayPoints[56] = new CWayPoint(1248,256);
			 WayPoints[57] = new CWayPoint(1248,240);
			 WayPoints[58] = new CWayPoint(1472,64);
			 WayPoints[59] = new CWayPoint(1440,96);
			 WayPoints[60] = new CWayPoint(1472,128);
			 WayPoints[61] = new CWayPoint(1504,96);
			 WayPoints[62] = new CWayPoint(1520,128);
			 WayPoints[63] = new CWayPoint(1488,160);
			 WayPoints[64] = new CWayPoint(1520,192);
			 WayPoints[65] = new CWayPoint(1552,160);
			 WayPoints[66] = new CWayPoint(1472,192);
			 WayPoints[67] = new CWayPoint(1440,224);
			 WayPoints[68] = new CWayPoint(1472,256);
			 WayPoints[69] = new CWayPoint(1504,224);
			 WayPoints[70] = new CWayPoint(1472,96);
			 WayPoints[71] = new CWayPoint(1520,160);
			 WayPoints[72] = new CWayPoint(1472,224);
			
			
			// waypoint link 
			 WayPoints[0].linkTo(WayPoints[1]);//0
			 WayPoints[1].linkTo(WayPoints[2]);//1
			 WayPoints[2].linkTo(WayPoints[3]);//2
			 WayPoints[3].linkTo(WayPoints[4]);//3
			 WayPoints[4].linkTo(WayPoints[5]);//4
			 WayPoints[5].linkTo(WayPoints[6]);//5
			 WayPoints[6].linkTo(WayPoints[7]);//6
			 WayPoints[7].linkTo(WayPoints[8]);//7
			 WayPoints[8].linkTo(WayPoints[9]);//8
			 WayPoints[9].linkTo(WayPoints[10]);//9
			 WayPoints[10].linkTo(WayPoints[11]);//10
			 WayPoints[11].linkTo(WayPoints[31]);//11
			 WayPoints[11].linkTo(WayPoints[30]);//12
			 WayPoints[11].linkTo(WayPoints[29]);//13
			 WayPoints[11].linkTo(WayPoints[28]);//14
			 WayPoints[11].linkTo(WayPoints[27]);//15
			 WayPoints[11].linkTo(WayPoints[26]);//16
			 WayPoints[11].linkTo(WayPoints[25]);//17
			 WayPoints[11].linkTo(WayPoints[24]);//18
			 WayPoints[12].linkTo(WayPoints[13]);//19
			 WayPoints[13].linkTo(WayPoints[14]);//20
			 WayPoints[14].linkTo(WayPoints[15]);//21
			 WayPoints[15].linkTo(WayPoints[16]);//22
			 WayPoints[16].linkTo(WayPoints[17]);//23
			 WayPoints[17].linkTo(WayPoints[18]);//24
			 WayPoints[18].linkTo(WayPoints[19]);//25
			 WayPoints[19].linkTo(WayPoints[20]);//26
			 WayPoints[20].linkTo(WayPoints[21]);//27
			 WayPoints[21].linkTo(WayPoints[22]);//28
			 WayPoints[22].linkTo(WayPoints[23]);//29
			 WayPoints[23].linkTo(WayPoints[24]);//30
			 WayPoints[23].linkTo(WayPoints[25]);//31
			 WayPoints[23].linkTo(WayPoints[26]);//32
			 WayPoints[23].linkTo(WayPoints[27]);//33
			 WayPoints[23].linkTo(WayPoints[28]);//34
			 WayPoints[23].linkTo(WayPoints[29]);//35
			 WayPoints[23].linkTo(WayPoints[30]);//36
			 WayPoints[23].linkTo(WayPoints[31]);//37
			 WayPoints[32].linkTo(WayPoints[47]);//38
			 WayPoints[33].linkTo(WayPoints[48]);//39
			 WayPoints[34].linkTo(WayPoints[49]);//40
			 WayPoints[35].linkTo(WayPoints[50]);//41
			 WayPoints[36].linkTo(WayPoints[51]);//42
			 WayPoints[37].linkTo(WayPoints[52]);//43
			 WayPoints[38].linkTo(WayPoints[46]);//44
			 WayPoints[39].linkTo(WayPoints[53]);//45
			 WayPoints[40].linkTo(WayPoints[54]);//46
			 WayPoints[41].linkTo(WayPoints[55]);//47
			 WayPoints[42].linkTo(WayPoints[57]);//48
			 WayPoints[43].linkTo(WayPoints[56]);//49
			 WayPoints[44].linkTo(WayPoints[45]);//50
			 WayPoints[45].linkTo(WayPoints[44]);//51
			 WayPoints[46].linkTo(WayPoints[38]);//52
			 WayPoints[47].linkTo(WayPoints[32]);//53
			 WayPoints[48].linkTo(WayPoints[33]);//54
			 WayPoints[49].linkTo(WayPoints[34]);//55
			 WayPoints[50].linkTo(WayPoints[35]);//56
			 WayPoints[51].linkTo(WayPoints[36]);//57
			 WayPoints[52].linkTo(WayPoints[37]);//58
			 WayPoints[53].linkTo(WayPoints[39]);//59
			 WayPoints[54].linkTo(WayPoints[40]);//60
			 WayPoints[55].linkTo(WayPoints[41]);//61
			 WayPoints[56].linkTo(WayPoints[43]);//62
			 WayPoints[57].linkTo(WayPoints[42]);//63
			 WayPoints[58].linkTo(WayPoints[59]);//64
			 WayPoints[59].linkTo(WayPoints[60]);//65
			 WayPoints[60].linkTo(WayPoints[61]);//66
			 WayPoints[61].linkTo(WayPoints[58]);//67
			 WayPoints[62].linkTo(WayPoints[63]);//68
			 WayPoints[63].linkTo(WayPoints[64]);//69
			 WayPoints[64].linkTo(WayPoints[65]);//70
			 WayPoints[65].linkTo(WayPoints[62]);//71
			 WayPoints[66].linkTo(WayPoints[67]);//72
			 WayPoints[67].linkTo(WayPoints[68]);//73
			 WayPoints[68].linkTo(WayPoints[69]);//74
			 WayPoints[69].linkTo(WayPoints[66]);//75
			 WayPoints[70].linkTo(WayPoints[58]);//76
			 WayPoints[70].linkTo(WayPoints[59]);//77
			 WayPoints[70].linkTo(WayPoints[60]);//78
			 WayPoints[70].linkTo(WayPoints[61]);//79
			 WayPoints[71].linkTo(WayPoints[62]);//80
			 WayPoints[71].linkTo(WayPoints[65]);//81
			 WayPoints[71].linkTo(WayPoints[63]);//82
			 WayPoints[71].linkTo(WayPoints[64]);//83
			 WayPoints[72].linkTo(WayPoints[66]);//84
			 WayPoints[72].linkTo(WayPoints[67]);//85
			 WayPoints[72].linkTo(WayPoints[68]);//86
			 WayPoints[72].linkTo(WayPoints[69]);//87
			
			
			return WayPoints;
		}
	

		// World : bossLevel_01
		if(Name.indexOf("bossLevel_01")>=0){
			// waypoint count : 10
			CWayPoint[] WayPoints = new CWayPoint[10];
			 WayPoints[0] = new CWayPoint(736,160);
			 WayPoints[1] = new CWayPoint(824,279);
			 WayPoints[2] = new CWayPoint(920,17);
			 WayPoints[3] = new CWayPoint(1022,281);
			 WayPoints[4] = new CWayPoint(1154,19);
			 WayPoints[5] = new CWayPoint(1271,296);
			 WayPoints[6] = new CWayPoint(1412,22);
			 WayPoints[7] = new CWayPoint(1744,160);
			 WayPoints[8] = new CWayPoint(1744,16);
			 WayPoints[9] = new CWayPoint(1744,304);
			
			
			// waypoint link 
			 WayPoints[0].linkTo(WayPoints[1]);//0
			 WayPoints[1].linkTo(WayPoints[2]);//1
			 WayPoints[2].linkTo(WayPoints[3]);//2
			 WayPoints[3].linkTo(WayPoints[4]);//3
			 WayPoints[4].linkTo(WayPoints[5]);//4
			 WayPoints[5].linkTo(WayPoints[6]);//5
			 WayPoints[6].linkTo(WayPoints[7]);//6
			 WayPoints[7].linkTo(WayPoints[9]);//7
			 WayPoints[7].linkTo(WayPoints[8]);//8
			 WayPoints[8].linkTo(WayPoints[7]);//9
			 WayPoints[9].linkTo(WayPoints[7]);//10
			
			
			return WayPoints;
		}
	

		// World : bossLevel_02
		if(Name.indexOf("bossLevel_02")>=0){
			// waypoint count : 28
			CWayPoint[] WayPoints = new CWayPoint[28];
			 WayPoints[0] = new CWayPoint(176,0);
			 WayPoints[1] = new CWayPoint(272,320);
			 WayPoints[2] = new CWayPoint(272,160);
			 WayPoints[3] = new CWayPoint(432,160);
			 WayPoints[4] = new CWayPoint(512,0);
			 WayPoints[5] = new CWayPoint(560,64);
			 WayPoints[6] = new CWayPoint(448,160);
			 WayPoints[7] = new CWayPoint(656,160);
			 WayPoints[8] = new CWayPoint(720,112);
			 WayPoints[9] = new CWayPoint(848,208);
			 WayPoints[10] = new CWayPoint(928,208);
			 WayPoints[11] = new CWayPoint(1056,112);
			 WayPoints[12] = new CWayPoint(1136,288);
			 WayPoints[13] = new CWayPoint(1280,32);
			 WayPoints[14] = new CWayPoint(1440,288);
			 WayPoints[15] = new CWayPoint(1600,32);
			 WayPoints[16] = new CWayPoint(1744,48);
			 WayPoints[17] = new CWayPoint(1760,80);
			 WayPoints[18] = new CWayPoint(1744,112);
			 WayPoints[19] = new CWayPoint(1728,80);
			 WayPoints[20] = new CWayPoint(1760,144);
			 WayPoints[21] = new CWayPoint(1744,176);
			 WayPoints[22] = new CWayPoint(1728,144);
			 WayPoints[23] = new CWayPoint(1760,208);
			 WayPoints[24] = new CWayPoint(1744,240);
			 WayPoints[25] = new CWayPoint(1728,208);
			 WayPoints[26] = new CWayPoint(1760,272);
			 WayPoints[27] = new CWayPoint(1744,272);
			
			
			// waypoint link 
			 WayPoints[0].linkTo(WayPoints[1]);//0
			 WayPoints[1].linkTo(WayPoints[2]);//1
			 WayPoints[2].linkTo(WayPoints[3]);//2
			 WayPoints[3].linkTo(WayPoints[4]);//3
			 WayPoints[4].linkTo(WayPoints[5]);//4
			 WayPoints[5].linkTo(WayPoints[6]);//5
			 WayPoints[6].linkTo(WayPoints[7]);//6
			 WayPoints[7].linkTo(WayPoints[8]);//7
			 WayPoints[8].linkTo(WayPoints[9]);//8
			 WayPoints[9].linkTo(WayPoints[10]);//9
			 WayPoints[10].linkTo(WayPoints[11]);//10
			 WayPoints[11].linkTo(WayPoints[12]);//11
			 WayPoints[12].linkTo(WayPoints[13]);//12
			 WayPoints[13].linkTo(WayPoints[14]);//13
			 WayPoints[14].linkTo(WayPoints[15]);//14
			 WayPoints[15].linkTo(WayPoints[16]);//15
			 WayPoints[16].linkTo(WayPoints[17]);//16
			 WayPoints[17].linkTo(WayPoints[18]);//17
			 WayPoints[18].linkTo(WayPoints[19]);//18
			 WayPoints[19].linkTo(WayPoints[20]);//19
			 WayPoints[20].linkTo(WayPoints[21]);//20
			 WayPoints[21].linkTo(WayPoints[22]);//21
			 WayPoints[22].linkTo(WayPoints[23]);//22
			 WayPoints[23].linkTo(WayPoints[24]);//23
			 WayPoints[24].linkTo(WayPoints[25]);//24
			 WayPoints[25].linkTo(WayPoints[26]);//25
			 WayPoints[26].linkTo(WayPoints[27]);//26
			 WayPoints[27].linkTo(WayPoints[16]);//27
			
			
			return WayPoints;
		}
	

		// World : bossLevel_03
		if(Name.indexOf("bossLevel_03")>=0){
			// waypoint count : 21
			CWayPoint[] WayPoints = new CWayPoint[21];
			 WayPoints[0] = new CWayPoint(656,32);
			 WayPoints[1] = new CWayPoint(762,304);
			 WayPoints[2] = new CWayPoint(752,32);
			 WayPoints[3] = new CWayPoint(879,289);
			 WayPoints[4] = new CWayPoint(848,32);
			 WayPoints[5] = new CWayPoint(977,274);
			 WayPoints[6] = new CWayPoint(1264,272);
			 WayPoints[7] = new CWayPoint(1264,288);
			 WayPoints[8] = new CWayPoint(1264,304);
			 WayPoints[9] = new CWayPoint(1356,139);
			 WayPoints[10] = new CWayPoint(1357,87);
			 WayPoints[11] = new CWayPoint(1351,36);
			 WayPoints[12] = new CWayPoint(1760,96);
			 WayPoints[13] = new CWayPoint(1760,144);
			 WayPoints[14] = new CWayPoint(1760,192);
			 WayPoints[15] = new CWayPoint(1728,80);
			 WayPoints[16] = new CWayPoint(1728,112);
			 WayPoints[17] = new CWayPoint(1728,128);
			 WayPoints[18] = new CWayPoint(1728,160);
			 WayPoints[19] = new CWayPoint(1728,176);
			 WayPoints[20] = new CWayPoint(1728,208);
			
			
			// waypoint link 
			 WayPoints[0].linkTo(WayPoints[1]);//0
			 WayPoints[1].linkTo(WayPoints[8]);//1
			 WayPoints[2].linkTo(WayPoints[3]);//2
			 WayPoints[3].linkTo(WayPoints[7]);//3
			 WayPoints[4].linkTo(WayPoints[5]);//4
			 WayPoints[5].linkTo(WayPoints[6]);//5
			 WayPoints[6].linkTo(WayPoints[9]);//6
			 WayPoints[7].linkTo(WayPoints[10]);//7
			 WayPoints[8].linkTo(WayPoints[11]);//8
			 WayPoints[9].linkTo(WayPoints[12]);//9
			 WayPoints[10].linkTo(WayPoints[13]);//10
			 WayPoints[11].linkTo(WayPoints[14]);//11
			 WayPoints[12].linkTo(WayPoints[15]);//12
			 WayPoints[12].linkTo(WayPoints[16]);//13
			 WayPoints[13].linkTo(WayPoints[17]);//14
			 WayPoints[13].linkTo(WayPoints[18]);//15
			 WayPoints[14].linkTo(WayPoints[19]);//16
			 WayPoints[14].linkTo(WayPoints[20]);//17
			 WayPoints[15].linkTo(WayPoints[12]);//18
			 WayPoints[15].linkTo(WayPoints[16]);//19
			 WayPoints[16].linkTo(WayPoints[15]);//20
			 WayPoints[16].linkTo(WayPoints[12]);//21
			 WayPoints[17].linkTo(WayPoints[13]);//22
			 WayPoints[17].linkTo(WayPoints[18]);//23
			 WayPoints[18].linkTo(WayPoints[17]);//24
			 WayPoints[18].linkTo(WayPoints[13]);//25
			 WayPoints[19].linkTo(WayPoints[14]);//26
			 WayPoints[19].linkTo(WayPoints[20]);//27
			 WayPoints[20].linkTo(WayPoints[19]);//28
			 WayPoints[20].linkTo(WayPoints[14]);//29
			
			
			return WayPoints;
		}
	

		// World : bossLevel_04
		if(Name.indexOf("bossLevel_04")>=0){
			// waypoint count : 20
			CWayPoint[] WayPoints = new CWayPoint[20];
			 WayPoints[0] = new CWayPoint(176,80);
			 WayPoints[1] = new CWayPoint(176,192);
			 WayPoints[2] = new CWayPoint(304,112);
			 WayPoints[3] = new CWayPoint(272,112);
			 WayPoints[4] = new CWayPoint(272,160);
			 WayPoints[5] = new CWayPoint(304,160);
			 WayPoints[6] = new CWayPoint(368,160);
			 WayPoints[7] = new CWayPoint(400,112);
			 WayPoints[8] = new CWayPoint(448,160);
			 WayPoints[9] = new CWayPoint(496,112);
			 WayPoints[10] = new CWayPoint(528,160);
			 WayPoints[11] = new CWayPoint(1152,0);
			 WayPoints[12] = new CWayPoint(1296,304);
			 WayPoints[13] = new CWayPoint(1360,304);
			 WayPoints[14] = new CWayPoint(1408,352);
			 WayPoints[15] = new CWayPoint(1472,304);
			 WayPoints[16] = new CWayPoint(1536,352);
			 WayPoints[17] = new CWayPoint(1600,304);
			 WayPoints[18] = new CWayPoint(1664,352);
			 WayPoints[19] = new CWayPoint(1728,304);
			
			
			// waypoint link 
			 WayPoints[0].linkTo(WayPoints[1]);//0
			 WayPoints[1].linkTo(WayPoints[0]);//1
			 WayPoints[2].linkTo(WayPoints[3]);//2
			 WayPoints[3].linkTo(WayPoints[4]);//3
			 WayPoints[4].linkTo(WayPoints[5]);//4
			 WayPoints[5].linkTo(WayPoints[2]);//5
			 WayPoints[6].linkTo(WayPoints[8]);//6
			 WayPoints[6].linkTo(WayPoints[7]);//7
			 WayPoints[7].linkTo(WayPoints[8]);//8
			 WayPoints[7].linkTo(WayPoints[6]);//9
			 WayPoints[7].linkTo(WayPoints[9]);//10
			 WayPoints[8].linkTo(WayPoints[9]);//11
			 WayPoints[8].linkTo(WayPoints[7]);//12
			 WayPoints[8].linkTo(WayPoints[6]);//13
			 WayPoints[8].linkTo(WayPoints[10]);//14
			 WayPoints[9].linkTo(WayPoints[10]);//15
			 WayPoints[9].linkTo(WayPoints[8]);//16
			 WayPoints[9].linkTo(WayPoints[7]);//17
			 WayPoints[10].linkTo(WayPoints[9]);//18
			 WayPoints[10].linkTo(WayPoints[8]);//19
			 WayPoints[11].linkTo(WayPoints[12]);//20
			 WayPoints[12].linkTo(WayPoints[13]);//21
			 WayPoints[13].linkTo(WayPoints[14]);//22
			 WayPoints[14].linkTo(WayPoints[15]);//23
			 WayPoints[15].linkTo(WayPoints[16]);//24
			 WayPoints[16].linkTo(WayPoints[17]);//25
			 WayPoints[16].linkTo(WayPoints[19]);//26
			 WayPoints[16].linkTo(WayPoints[18]);//27
			 WayPoints[17].linkTo(WayPoints[18]);//28
			 WayPoints[17].linkTo(WayPoints[19]);//29
			 WayPoints[17].linkTo(WayPoints[16]);//30
			 WayPoints[18].linkTo(WayPoints[19]);//31
			 WayPoints[18].linkTo(WayPoints[17]);//32
			 WayPoints[18].linkTo(WayPoints[16]);//33
			 WayPoints[19].linkTo(WayPoints[18]);//34
			 WayPoints[19].linkTo(WayPoints[17]);//35
			 WayPoints[19].linkTo(WayPoints[16]);//36
			
			
			return WayPoints;
		}
	

		// World : bossLevel_05
		if(Name.indexOf("bossLevel_05")>=0){
			// waypoint count : 33
			CWayPoint[] WayPoints = new CWayPoint[33];
			 WayPoints[0] = new CWayPoint(176,80);
			 WayPoints[1] = new CWayPoint(240,224);
			 WayPoints[2] = new CWayPoint(304,176);
			 WayPoints[3] = new CWayPoint(240,144);
			 WayPoints[4] = new CWayPoint(352,144);
			 WayPoints[5] = new CWayPoint(384,224);
			 WayPoints[6] = new CWayPoint(384,288);
			 WayPoints[7] = new CWayPoint(512,288);
			 WayPoints[8] = new CWayPoint(384,304);
			 WayPoints[9] = new CWayPoint(528,160);
			 WayPoints[10] = new CWayPoint(577,225);
			 WayPoints[11] = new CWayPoint(608,112);
			 WayPoints[12] = new CWayPoint(640,224);
			 WayPoints[13] = new CWayPoint(672,96);
			 WayPoints[14] = new CWayPoint(704,224);
			 WayPoints[15] = new CWayPoint(1152,224);
			 WayPoints[16] = new CWayPoint(1648,16);
			 WayPoints[17] = new CWayPoint(1648,304);
			 WayPoints[18] = new CWayPoint(1744,288);
			 WayPoints[19] = new CWayPoint(1744,304);
			 WayPoints[20] = new CWayPoint(1728,304);
			 WayPoints[21] = new CWayPoint(1728,288);
			 WayPoints[22] = new CWayPoint(1712,304);
			 WayPoints[23] = new CWayPoint(1712,288);
			 WayPoints[24] = new CWayPoint(1696,304);
			 WayPoints[25] = new CWayPoint(1696,288);
			 WayPoints[26] = new CWayPoint(1680,304);
			 WayPoints[27] = new CWayPoint(1680,288);
			 WayPoints[28] = new CWayPoint(1728,176);
			 WayPoints[29] = new CWayPoint(1744,160);
			 WayPoints[30] = new CWayPoint(1712,192);
			 WayPoints[31] = new CWayPoint(1696,208);
			 WayPoints[32] = new CWayPoint(1680,224);
			
			
			// waypoint link 
			 WayPoints[0].linkTo(WayPoints[1]);//0
			 WayPoints[1].linkTo(WayPoints[2]);//1
			 WayPoints[2].linkTo(WayPoints[3]);//2
			 WayPoints[3].linkTo(WayPoints[4]);//3
			 WayPoints[4].linkTo(WayPoints[5]);//4
			 WayPoints[5].linkTo(WayPoints[6]);//5
			 WayPoints[6].linkTo(WayPoints[7]);//6
			 WayPoints[7].linkTo(WayPoints[8]);//7
			 WayPoints[8].linkTo(WayPoints[9]);//8
			 WayPoints[9].linkTo(WayPoints[10]);//9
			 WayPoints[10].linkTo(WayPoints[11]);//10
			 WayPoints[11].linkTo(WayPoints[12]);//11
			 WayPoints[12].linkTo(WayPoints[13]);//12
			 WayPoints[13].linkTo(WayPoints[14]);//13
			 WayPoints[14].linkTo(WayPoints[15]);//14
			 WayPoints[15].linkTo(WayPoints[16]);//15
			 WayPoints[16].linkTo(WayPoints[17]);//16
			 WayPoints[17].linkTo(WayPoints[26]);//17
			 WayPoints[18].linkTo(WayPoints[21]);//18
			 WayPoints[18].linkTo(WayPoints[19]);//19
			 WayPoints[18].linkTo(WayPoints[29]);//20
			 WayPoints[19].linkTo(WayPoints[18]);//21
			 WayPoints[19].linkTo(WayPoints[20]);//22
			 WayPoints[20].linkTo(WayPoints[19]);//23
			 WayPoints[20].linkTo(WayPoints[22]);//24
			 WayPoints[20].linkTo(WayPoints[21]);//25
			 WayPoints[21].linkTo(WayPoints[23]);//26
			 WayPoints[21].linkTo(WayPoints[18]);//27
			 WayPoints[21].linkTo(WayPoints[20]);//28
			 WayPoints[21].linkTo(WayPoints[28]);//29
			 WayPoints[22].linkTo(WayPoints[20]);//30
			 WayPoints[22].linkTo(WayPoints[24]);//31
			 WayPoints[22].linkTo(WayPoints[23]);//32
			 WayPoints[23].linkTo(WayPoints[25]);//33
			 WayPoints[23].linkTo(WayPoints[21]);//34
			 WayPoints[23].linkTo(WayPoints[22]);//35
			 WayPoints[23].linkTo(WayPoints[30]);//36
			 WayPoints[24].linkTo(WayPoints[22]);//37
			 WayPoints[24].linkTo(WayPoints[26]);//38
			 WayPoints[24].linkTo(WayPoints[25]);//39
			 WayPoints[25].linkTo(WayPoints[27]);//40
			 WayPoints[25].linkTo(WayPoints[23]);//41
			 WayPoints[25].linkTo(WayPoints[24]);//42
			 WayPoints[25].linkTo(WayPoints[31]);//43
			 WayPoints[26].linkTo(WayPoints[27]);//44
			 WayPoints[26].linkTo(WayPoints[24]);//45
			 WayPoints[27].linkTo(WayPoints[26]);//46
			 WayPoints[27].linkTo(WayPoints[25]);//47
			 WayPoints[27].linkTo(WayPoints[32]);//48
			 WayPoints[28].linkTo(WayPoints[21]);//49
			 WayPoints[29].linkTo(WayPoints[18]);//50
			 WayPoints[30].linkTo(WayPoints[23]);//51
			 WayPoints[31].linkTo(WayPoints[25]);//52
			 WayPoints[32].linkTo(WayPoints[27]);//53
			
			
			return WayPoints;
		}
	

		return null;
	}


	final static public String getWorldMapTile(String Name){
	
		// World : battleLevel_00
		if(Name.indexOf("battleLevel_00")>=0){
			 return "battleMapTile1";
			
		}
	

		// World : battleLevel_01
		if(Name.indexOf("battleLevel_01")>=0){
			 return "battleMapTile1";
			
		}
	

		// World : battleLevel_02
		if(Name.indexOf("battleLevel_02")>=0){
			 return "battleMapTile2";
			
		}
	

		// World : battleLevel_03
		if(Name.indexOf("battleLevel_03")>=0){
			 return "battleMapTile1";
			
		}
	

		// World : battleLevel_04
		if(Name.indexOf("battleLevel_04")>=0){
			 return "battleMapTile2";
			
		}
	

		// World : battleLevel_05
		if(Name.indexOf("battleLevel_05")>=0){
			 return "battleMapTile2";
			
		}
	

		// World : battleLevel_06
		if(Name.indexOf("battleLevel_06")>=0){
			 return "battleMapTile1";
			
		}
	

		// World : bossLevel_01
		if(Name.indexOf("bossLevel_01")>=0){
			 return "battleMapTile2";
			
		}
	

		// World : bossLevel_02
		if(Name.indexOf("bossLevel_02")>=0){
			 return "battleMapTile2";
			
		}
	

		// World : bossLevel_03
		if(Name.indexOf("bossLevel_03")>=0){
			 return "battleMapTile2";
			
		}
	

		// World : bossLevel_04
		if(Name.indexOf("bossLevel_04")>=0){
			 return "battleMapTile3";
			
		}
	

		// World : bossLevel_05
		if(Name.indexOf("bossLevel_05")>=0){
			 return "battleMapTile2";
			
		}
	

		return null;
	}

	final static public String getWorldMapType(String Name){
	
		// World : battleLevel_00
		if(Name.indexOf("battleLevel_00")>=0){
			 return "01_Map";
			
		}
	

		// World : battleLevel_01
		if(Name.indexOf("battleLevel_01")>=0){
			 return "01_Map";
			
		}
	

		// World : battleLevel_02
		if(Name.indexOf("battleLevel_02")>=0){
			 return "02_Map";
			
		}
	

		// World : battleLevel_03
		if(Name.indexOf("battleLevel_03")>=0){
			 return "01_Map";
			
		}
	

		// World : battleLevel_04
		if(Name.indexOf("battleLevel_04")>=0){
			 return "02_Map";
			
		}
	

		// World : battleLevel_05
		if(Name.indexOf("battleLevel_05")>=0){
			 return "02_Map";
			
		}
	

		// World : battleLevel_06
		if(Name.indexOf("battleLevel_06")>=0){
			 return "01_Map";
			
		}
	

		// World : bossLevel_01
		if(Name.indexOf("bossLevel_01")>=0){
			 return "02_Map";
			
		}
	

		// World : bossLevel_02
		if(Name.indexOf("bossLevel_02")>=0){
			 return "02_Map";
			
		}
	

		// World : bossLevel_03
		if(Name.indexOf("bossLevel_03")>=0){
			 return "02_Map";
			
		}
	

		// World : bossLevel_04
		if(Name.indexOf("bossLevel_04")>=0){
			 return "03_Map";
			
		}
	

		// World : bossLevel_05
		if(Name.indexOf("bossLevel_05")>=0){
			 return "02_Map";
			
		}
	

		return null;
	}

	final static public String getWorldMapName(String Name){
	
		// World : battleLevel_00
		if(Name.indexOf("battleLevel_00")>=0){
			 return "M050_01_Map";
			
		}
	

		// World : battleLevel_01
		if(Name.indexOf("battleLevel_01")>=0){
			 return "M072_01_Map";
			
		}
	

		// World : battleLevel_02
		if(Name.indexOf("battleLevel_02")>=0){
			 return "M000_02_Map";
			
		}
	

		// World : battleLevel_03
		if(Name.indexOf("battleLevel_03")>=0){
			 return "M000_01_Map";
			
		}
	

		// World : battleLevel_04
		if(Name.indexOf("battleLevel_04")>=0){
			 return "M000_02_Map";
			
		}
	

		// World : battleLevel_05
		if(Name.indexOf("battleLevel_05")>=0){
			 return "M000_02_Map";
			
		}
	

		// World : battleLevel_06
		if(Name.indexOf("battleLevel_06")>=0){
			 return "M000_01_Map";
			
		}
	

		// World : bossLevel_01
		if(Name.indexOf("bossLevel_01")>=0){
			 return "M000_02_Map";
			
		}
	

		// World : bossLevel_02
		if(Name.indexOf("bossLevel_02")>=0){
			 return "M000_02_Map";
			
		}
	

		// World : bossLevel_03
		if(Name.indexOf("bossLevel_03")>=0){
			 return "M000_02_Map";
			
		}
	

		// World : bossLevel_04
		if(Name.indexOf("bossLevel_04")>=0){
			 return "M000_03_Map";
			
		}
	

		// World : bossLevel_05
		if(Name.indexOf("bossLevel_05")>=0){
			 return "M000_02_Map";
			
		}
	

		return null;
	}
	
	final static public String[] getWorldSprTile(String Name){
	
		// World : battleLevel_00
		if(Name.indexOf("battleLevel_00")>=0){
			String[] SprTile = new String[51];
			// sprite count : 51
			 SprTile[0] = "battleSprTile";
			 SprTile[1] = "battleSprTile";
			 SprTile[2] = "battleSprTile";
			 SprTile[3] = "battleSprTile";
			 SprTile[4] = "battleSprTile";
			 SprTile[5] = "battleSprTile";
			 SprTile[6] = "battleSprTile";
			 SprTile[7] = "battleSprTile";
			 SprTile[8] = "battleSprTile";
			 SprTile[9] = "battleSprTile";
			 SprTile[10] = "battleSprTile";
			 SprTile[11] = "battleSprTile";
			 SprTile[12] = "battleSprTile";
			 SprTile[13] = "battleSprTile";
			 SprTile[14] = "battleSprTile";
			 SprTile[15] = "battleSprTile";
			 SprTile[16] = "battleSprTile";
			 SprTile[17] = "battleSprTile";
			 SprTile[18] = "battleSprTile";
			 SprTile[19] = "battleSprTile";
			 SprTile[20] = "battleSprTile";
			 SprTile[21] = "battleSprTile";
			 SprTile[22] = "battleSprTile";
			 SprTile[23] = "battleSprTile";
			 SprTile[24] = "battleSprTile";
			 SprTile[25] = "battleSprTile";
			 SprTile[26] = "battleSprTile";
			 SprTile[27] = "battleSprTile";
			 SprTile[28] = "battleSprTile";
			 SprTile[29] = "battleSprTile";
			 SprTile[30] = "battleSprTile";
			 SprTile[31] = "battleSprTile";
			 SprTile[32] = "battleSprTile";
			 SprTile[33] = "battleSprTile";
			 SprTile[34] = "battleSprTile";
			 SprTile[35] = "battleSprTile";
			 SprTile[36] = "battleSprTile";
			 SprTile[37] = "battleSprTile";
			 SprTile[38] = "battleSprTile";
			 SprTile[39] = "battleSprTile";
			 SprTile[40] = "battleSprTile";
			 SprTile[41] = "battleSprTile";
			 SprTile[42] = "battleSprTile";
			 SprTile[43] = "battleSprTile";
			 SprTile[44] = "battleSprTile";
			 SprTile[45] = "battleSprTile";
			 SprTile[46] = "battleSprTile";
			 SprTile[47] = "battleSprTile";
			 SprTile[48] = "battleSprTile";
			 SprTile[49] = "battleSprTile";
			 SprTile[50] = "battleSprTile";
			
			
			return SprTile;
		}
	

		// World : battleLevel_01
		if(Name.indexOf("battleLevel_01")>=0){
			String[] SprTile = new String[73];
			// sprite count : 73
			 SprTile[0] = "battleSprTile";
			 SprTile[1] = "battleSprTile";
			 SprTile[2] = "battleSprTile";
			 SprTile[3] = "battleSprTile";
			 SprTile[4] = "battleSprTile";
			 SprTile[5] = "battleSprTile";
			 SprTile[6] = "battleSprTile";
			 SprTile[7] = "battleSprTile";
			 SprTile[8] = "battleSprTile";
			 SprTile[9] = "battleSprTile";
			 SprTile[10] = "battleSprTile";
			 SprTile[11] = "battleSprTile";
			 SprTile[12] = "battleSprTile";
			 SprTile[13] = "battleSprTile";
			 SprTile[14] = "battleSprTile";
			 SprTile[15] = "battleSprTile";
			 SprTile[16] = "battleSprTile";
			 SprTile[17] = "battleSprTile";
			 SprTile[18] = "battleSprTile";
			 SprTile[19] = "battleSprTile";
			 SprTile[20] = "battleSprTile";
			 SprTile[21] = "battleSprTile";
			 SprTile[22] = "battleSprTile";
			 SprTile[23] = "battleSprTile";
			 SprTile[24] = "battleSprTile";
			 SprTile[25] = "battleSprTile";
			 SprTile[26] = "battleSprTile";
			 SprTile[27] = "battleSprTile";
			 SprTile[28] = "battleSprTile";
			 SprTile[29] = "battleSprTile";
			 SprTile[30] = "battleSprTile";
			 SprTile[31] = "battleSprTile";
			 SprTile[32] = "battleSprTile";
			 SprTile[33] = "battleSprTile";
			 SprTile[34] = "battleSprTile";
			 SprTile[35] = "battleSprTile";
			 SprTile[36] = "battleSprTile";
			 SprTile[37] = "battleSprTile";
			 SprTile[38] = "battleSprTile";
			 SprTile[39] = "battleSprTile";
			 SprTile[40] = "battleSprTile";
			 SprTile[41] = "battleSprTile";
			 SprTile[42] = "battleSprTile";
			 SprTile[43] = "battleSprTile";
			 SprTile[44] = "battleSprTile";
			 SprTile[45] = "battleSprTile";
			 SprTile[46] = "battleSprTile";
			 SprTile[47] = "battleSprTile";
			 SprTile[48] = "battleSprTile";
			 SprTile[49] = "battleSprTile";
			 SprTile[50] = "battleSprTile";
			 SprTile[51] = "battleSprTile";
			 SprTile[52] = "battleSprTile";
			 SprTile[53] = "battleSprTile";
			 SprTile[54] = "battleSprTile";
			 SprTile[55] = "battleSprTile";
			 SprTile[56] = "battleSprTile";
			 SprTile[57] = "battleSprTile";
			 SprTile[58] = "battleSprTile";
			 SprTile[59] = "battleSprTile";
			 SprTile[60] = "battleSprTile";
			 SprTile[61] = "battleSprTile";
			 SprTile[62] = "battleSprTile";
			 SprTile[63] = "battleSprTile";
			 SprTile[64] = "battleSprTile";
			 SprTile[65] = "battleSprTile";
			 SprTile[66] = "battleSprTile";
			 SprTile[67] = "battleSprTile";
			 SprTile[68] = "battleSprTile";
			 SprTile[69] = "battleSprTile";
			 SprTile[70] = "battleSprTile";
			 SprTile[71] = "battleSprTile";
			 SprTile[72] = "battleSprTile";
			
			
			return SprTile;
		}
	

		// World : battleLevel_02
		if(Name.indexOf("battleLevel_02")>=0){
			String[] SprTile = new String[83];
			// sprite count : 83
			 SprTile[0] = "battleSprTile";
			 SprTile[1] = "battleSprTile";
			 SprTile[2] = "battleSprTile";
			 SprTile[3] = "battleSprTile";
			 SprTile[4] = "battleSprTile";
			 SprTile[5] = "battleSprTile";
			 SprTile[6] = "battleSprTile";
			 SprTile[7] = "battleSprTile";
			 SprTile[8] = "battleSprTile";
			 SprTile[9] = "battleSprTile";
			 SprTile[10] = "battleSprTile";
			 SprTile[11] = "battleSprTile";
			 SprTile[12] = "battleSprTile";
			 SprTile[13] = "battleSprTile";
			 SprTile[14] = "battleSprTile";
			 SprTile[15] = "battleSprTile";
			 SprTile[16] = "battleSprTile";
			 SprTile[17] = "battleSprTile";
			 SprTile[18] = "battleSprTile";
			 SprTile[19] = "battleSprTile";
			 SprTile[20] = "battleSprTile";
			 SprTile[21] = "battleSprTile";
			 SprTile[22] = "battleSprTile";
			 SprTile[23] = "battleSprTile";
			 SprTile[24] = "battleSprTile";
			 SprTile[25] = "battleSprTile";
			 SprTile[26] = "battleSprTile";
			 SprTile[27] = "battleSprTile";
			 SprTile[28] = "battleSprTile";
			 SprTile[29] = "battleSprTile";
			 SprTile[30] = "battleSprTile";
			 SprTile[31] = "battleSprTile";
			 SprTile[32] = "battleSprTile";
			 SprTile[33] = "battleSprTile";
			 SprTile[34] = "battleSprTile";
			 SprTile[35] = "battleSprTile";
			 SprTile[36] = "battleSprTile";
			 SprTile[37] = "battleSprTile";
			 SprTile[38] = "battleSprTile";
			 SprTile[39] = "battleSprTile";
			 SprTile[40] = "battleSprTile";
			 SprTile[41] = "battleSprTile";
			 SprTile[42] = "battleSprTile";
			 SprTile[43] = "battleSprTile";
			 SprTile[44] = "battleSprTile";
			 SprTile[45] = "battleSprTile";
			 SprTile[46] = "battleSprTile";
			 SprTile[47] = "battleSprTile";
			 SprTile[48] = "battleSprTile";
			 SprTile[49] = "battleSprTile";
			 SprTile[50] = "battleSprTile";
			 SprTile[51] = "battleSprTile";
			 SprTile[52] = "battleSprTile";
			 SprTile[53] = "battleSprTile";
			 SprTile[54] = "battleSprTile";
			 SprTile[55] = "battleSprTile";
			 SprTile[56] = "battleSprTile";
			 SprTile[57] = "battleSprTile";
			 SprTile[58] = "battleSprTile";
			 SprTile[59] = "battleSprTile";
			 SprTile[60] = "battleSprTile";
			 SprTile[61] = "battleSprTile";
			 SprTile[62] = "battleSprTile";
			 SprTile[63] = "battleSprTile";
			 SprTile[64] = "battleSprTile";
			 SprTile[65] = "battleSprTile";
			 SprTile[66] = "battleSprTile";
			 SprTile[67] = "battleSprTile";
			 SprTile[68] = "battleSprTile";
			 SprTile[69] = "battleSprTile";
			 SprTile[70] = "battleSprTile";
			 SprTile[71] = "battleSprTile";
			 SprTile[72] = "battleSprTile";
			 SprTile[73] = "battleSprTile";
			 SprTile[74] = "battleSprTile";
			 SprTile[75] = "battleSprTile";
			 SprTile[76] = "battleSprTile";
			 SprTile[77] = "battleSprTile";
			 SprTile[78] = "battleSprTile";
			 SprTile[79] = "battleSprTile";
			 SprTile[80] = "battleSprTile";
			 SprTile[81] = "battleSprTile";
			 SprTile[82] = "battleSprTile";
			
			
			return SprTile;
		}
	

		// World : battleLevel_03
		if(Name.indexOf("battleLevel_03")>=0){
			String[] SprTile = new String[75];
			// sprite count : 75
			 SprTile[0] = "battleSprTile";
			 SprTile[1] = "battleSprTile";
			 SprTile[2] = "battleSprTile";
			 SprTile[3] = "battleSprTile";
			 SprTile[4] = "battleSprTile";
			 SprTile[5] = "battleSprTile";
			 SprTile[6] = "battleSprTile";
			 SprTile[7] = "battleSprTile";
			 SprTile[8] = "battleSprTile";
			 SprTile[9] = "battleSprTile";
			 SprTile[10] = "battleSprTile";
			 SprTile[11] = "battleSprTile";
			 SprTile[12] = "battleSprTile";
			 SprTile[13] = "battleSprTile";
			 SprTile[14] = "battleSprTile";
			 SprTile[15] = "battleSprTile";
			 SprTile[16] = "battleSprTile";
			 SprTile[17] = "battleSprTile";
			 SprTile[18] = "battleSprTile";
			 SprTile[19] = "battleSprTile";
			 SprTile[20] = "battleSprTile";
			 SprTile[21] = "battleSprTile";
			 SprTile[22] = "battleSprTile";
			 SprTile[23] = "battleSprTile";
			 SprTile[24] = "battleSprTile";
			 SprTile[25] = "battleSprTile";
			 SprTile[26] = "battleSprTile";
			 SprTile[27] = "battleSprTile";
			 SprTile[28] = "battleSprTile";
			 SprTile[29] = "battleSprTile";
			 SprTile[30] = "battleSprTile";
			 SprTile[31] = "battleSprTile";
			 SprTile[32] = "battleSprTile";
			 SprTile[33] = "battleSprTile";
			 SprTile[34] = "battleSprTile";
			 SprTile[35] = "battleSprTile";
			 SprTile[36] = "battleSprTile";
			 SprTile[37] = "battleSprTile";
			 SprTile[38] = "battleSprTile";
			 SprTile[39] = "battleSprTile";
			 SprTile[40] = "battleSprTile";
			 SprTile[41] = "battleSprTile";
			 SprTile[42] = "battleSprTile";
			 SprTile[43] = "battleSprTile";
			 SprTile[44] = "battleSprTile";
			 SprTile[45] = "battleSprTile";
			 SprTile[46] = "battleSprTile";
			 SprTile[47] = "battleSprTile";
			 SprTile[48] = "battleSprTile";
			 SprTile[49] = "battleSprTile";
			 SprTile[50] = "battleSprTile";
			 SprTile[51] = "battleSprTile";
			 SprTile[52] = "battleSprTile";
			 SprTile[53] = "battleSprTile";
			 SprTile[54] = "battleSprTile";
			 SprTile[55] = "battleSprTile";
			 SprTile[56] = "battleSprTile";
			 SprTile[57] = "battleSprTile";
			 SprTile[58] = "battleSprTile";
			 SprTile[59] = "battleSprTile";
			 SprTile[60] = "battleSprTile";
			 SprTile[61] = "battleSprTile";
			 SprTile[62] = "battleSprTile";
			 SprTile[63] = "battleSprTile";
			 SprTile[64] = "battleSprTile";
			 SprTile[65] = "battleSprTile";
			 SprTile[66] = "battleSprTile";
			 SprTile[67] = "battleSprTile";
			 SprTile[68] = "battleSprTile";
			 SprTile[69] = "battleSprTile";
			 SprTile[70] = "battleSprTile";
			 SprTile[71] = "battleSprTile";
			 SprTile[72] = "battleSprTile";
			 SprTile[73] = "battleSprTile";
			 SprTile[74] = "battleSprTile";
			
			
			return SprTile;
		}
	

		// World : battleLevel_04
		if(Name.indexOf("battleLevel_04")>=0){
			String[] SprTile = new String[74];
			// sprite count : 74
			 SprTile[0] = "battleSprTile";
			 SprTile[1] = "battleSprTile";
			 SprTile[2] = "battleSprTile";
			 SprTile[3] = "battleSprTile";
			 SprTile[4] = "battleSprTile";
			 SprTile[5] = "battleSprTile";
			 SprTile[6] = "battleSprTile";
			 SprTile[7] = "battleSprTile";
			 SprTile[8] = "battleSprTile";
			 SprTile[9] = "battleSprTile";
			 SprTile[10] = "battleSprTile";
			 SprTile[11] = "battleSprTile";
			 SprTile[12] = "battleSprTile";
			 SprTile[13] = "battleSprTile";
			 SprTile[14] = "battleSprTile";
			 SprTile[15] = "battleSprTile";
			 SprTile[16] = "battleSprTile";
			 SprTile[17] = "battleSprTile";
			 SprTile[18] = "battleSprTile";
			 SprTile[19] = "battleSprTile";
			 SprTile[20] = "battleSprTile";
			 SprTile[21] = "battleSprTile";
			 SprTile[22] = "battleSprTile";
			 SprTile[23] = "battleSprTile";
			 SprTile[24] = "battleSprTile";
			 SprTile[25] = "battleSprTile";
			 SprTile[26] = "battleSprTile";
			 SprTile[27] = "battleSprTile";
			 SprTile[28] = "battleSprTile";
			 SprTile[29] = "battleSprTile";
			 SprTile[30] = "battleSprTile";
			 SprTile[31] = "battleSprTile";
			 SprTile[32] = "battleSprTile";
			 SprTile[33] = "battleSprTile";
			 SprTile[34] = "battleSprTile";
			 SprTile[35] = "battleSprTile";
			 SprTile[36] = "battleSprTile";
			 SprTile[37] = "battleSprTile";
			 SprTile[38] = "battleSprTile";
			 SprTile[39] = "battleSprTile";
			 SprTile[40] = "battleSprTile";
			 SprTile[41] = "battleSprTile";
			 SprTile[42] = "battleSprTile";
			 SprTile[43] = "battleSprTile";
			 SprTile[44] = "battleSprTile";
			 SprTile[45] = "battleSprTile";
			 SprTile[46] = "battleSprTile";
			 SprTile[47] = "battleSprTile";
			 SprTile[48] = "battleSprTile";
			 SprTile[49] = "battleSprTile";
			 SprTile[50] = "battleSprTile";
			 SprTile[51] = "battleSprTile";
			 SprTile[52] = "battleSprTile";
			 SprTile[53] = "battleSprTile";
			 SprTile[54] = "battleSprTile";
			 SprTile[55] = "battleSprTile";
			 SprTile[56] = "battleSprTile";
			 SprTile[57] = "battleSprTile";
			 SprTile[58] = "battleSprTile";
			 SprTile[59] = "battleSprTile";
			 SprTile[60] = "battleSprTile";
			 SprTile[61] = "battleSprTile";
			 SprTile[62] = "battleSprTile";
			 SprTile[63] = "battleSprTile";
			 SprTile[64] = "battleSprTile";
			 SprTile[65] = "battleSprTile";
			 SprTile[66] = "battleSprTile";
			 SprTile[67] = "battleSprTile";
			 SprTile[68] = "battleSprTile";
			 SprTile[69] = "battleSprTile";
			 SprTile[70] = "battleSprTile";
			 SprTile[71] = "battleSprTile";
			 SprTile[72] = "battleSprTile";
			 SprTile[73] = "battleSprTile";
			
			
			return SprTile;
		}
	

		// World : battleLevel_05
		if(Name.indexOf("battleLevel_05")>=0){
			String[] SprTile = new String[59];
			// sprite count : 59
			 SprTile[0] = "battleSprTile";
			 SprTile[1] = "battleSprTile";
			 SprTile[2] = "battleSprTile";
			 SprTile[3] = "battleSprTile";
			 SprTile[4] = "battleSprTile";
			 SprTile[5] = "battleSprTile";
			 SprTile[6] = "battleSprTile";
			 SprTile[7] = "battleSprTile";
			 SprTile[8] = "battleSprTile";
			 SprTile[9] = "battleSprTile";
			 SprTile[10] = "battleSprTile";
			 SprTile[11] = "battleSprTile";
			 SprTile[12] = "battleSprTile";
			 SprTile[13] = "battleSprTile";
			 SprTile[14] = "battleSprTile";
			 SprTile[15] = "battleSprTile";
			 SprTile[16] = "battleSprTile";
			 SprTile[17] = "battleSprTile";
			 SprTile[18] = "battleSprTile";
			 SprTile[19] = "battleSprTile";
			 SprTile[20] = "battleSprTile";
			 SprTile[21] = "battleSprTile";
			 SprTile[22] = "battleSprTile";
			 SprTile[23] = "battleSprTile";
			 SprTile[24] = "battleSprTile";
			 SprTile[25] = "battleSprTile";
			 SprTile[26] = "battleSprTile";
			 SprTile[27] = "battleSprTile";
			 SprTile[28] = "battleSprTile";
			 SprTile[29] = "battleSprTile";
			 SprTile[30] = "battleSprTile";
			 SprTile[31] = "battleSprTile";
			 SprTile[32] = "battleSprTile";
			 SprTile[33] = "battleSprTile";
			 SprTile[34] = "battleSprTile";
			 SprTile[35] = "battleSprTile";
			 SprTile[36] = "battleSprTile";
			 SprTile[37] = "battleSprTile";
			 SprTile[38] = "battleSprTile";
			 SprTile[39] = "battleSprTile";
			 SprTile[40] = "battleSprTile";
			 SprTile[41] = "battleSprTile";
			 SprTile[42] = "battleSprTile";
			 SprTile[43] = "battleSprTile";
			 SprTile[44] = "battleSprTile";
			 SprTile[45] = "battleSprTile";
			 SprTile[46] = "battleSprTile";
			 SprTile[47] = "battleSprTile";
			 SprTile[48] = "battleSprTile";
			 SprTile[49] = "battleSprTile";
			 SprTile[50] = "battleSprTile";
			 SprTile[51] = "battleSprTile";
			 SprTile[52] = "battleSprTile";
			 SprTile[53] = "battleSprTile";
			 SprTile[54] = "battleSprTile";
			 SprTile[55] = "battleSprTile";
			 SprTile[56] = "battleSprTile";
			 SprTile[57] = "battleSprTile";
			 SprTile[58] = "battleSprTile";
			
			
			return SprTile;
		}
	

		// World : battleLevel_06
		if(Name.indexOf("battleLevel_06")>=0){
			String[] SprTile = new String[64];
			// sprite count : 64
			 SprTile[0] = "battleSprTile";
			 SprTile[1] = "battleSprTile";
			 SprTile[2] = "battleSprTile";
			 SprTile[3] = "battleSprTile";
			 SprTile[4] = "battleSprTile";
			 SprTile[5] = "battleSprTile";
			 SprTile[6] = "battleSprTile";
			 SprTile[7] = "battleSprTile";
			 SprTile[8] = "battleSprTile";
			 SprTile[9] = "battleSprTile";
			 SprTile[10] = "battleSprTile";
			 SprTile[11] = "battleSprTile";
			 SprTile[12] = "battleSprTile";
			 SprTile[13] = "battleSprTile";
			 SprTile[14] = "battleSprTile";
			 SprTile[15] = "battleSprTile";
			 SprTile[16] = "battleSprTile";
			 SprTile[17] = "battleSprTile";
			 SprTile[18] = "battleSprTile";
			 SprTile[19] = "battleSprTile";
			 SprTile[20] = "battleSprTile";
			 SprTile[21] = "battleSprTile";
			 SprTile[22] = "battleSprTile";
			 SprTile[23] = "battleSprTile";
			 SprTile[24] = "battleSprTile";
			 SprTile[25] = "battleSprTile";
			 SprTile[26] = "battleSprTile";
			 SprTile[27] = "battleSprTile";
			 SprTile[28] = "battleSprTile";
			 SprTile[29] = "battleSprTile";
			 SprTile[30] = "battleSprTile";
			 SprTile[31] = "battleSprTile";
			 SprTile[32] = "battleSprTile";
			 SprTile[33] = "battleSprTile";
			 SprTile[34] = "battleSprTile";
			 SprTile[35] = "battleSprTile";
			 SprTile[36] = "battleSprTile";
			 SprTile[37] = "battleSprTile";
			 SprTile[38] = "battleSprTile";
			 SprTile[39] = "battleSprTile";
			 SprTile[40] = "battleSprTile";
			 SprTile[41] = "battleSprTile";
			 SprTile[42] = "battleSprTile";
			 SprTile[43] = "battleSprTile";
			 SprTile[44] = "battleSprTile";
			 SprTile[45] = "battleSprTile";
			 SprTile[46] = "battleSprTile";
			 SprTile[47] = "battleSprTile";
			 SprTile[48] = "battleSprTile";
			 SprTile[49] = "battleSprTile";
			 SprTile[50] = "battleSprTile";
			 SprTile[51] = "battleSprTile";
			 SprTile[52] = "battleSprTile";
			 SprTile[53] = "battleSprTile";
			 SprTile[54] = "battleSprTile";
			 SprTile[55] = "battleSprTile";
			 SprTile[56] = "battleSprTile";
			 SprTile[57] = "battleSprTile";
			 SprTile[58] = "battleSprTile";
			 SprTile[59] = "battleSprTile";
			 SprTile[60] = "battleSprTile";
			 SprTile[61] = "battleSprTile";
			 SprTile[62] = "battleSprTile";
			 SprTile[63] = "battleSprTile";
			
			
			return SprTile;
		}
	

		// World : bossLevel_01
		if(Name.indexOf("bossLevel_01")>=0){
			String[] SprTile = new String[22];
			// sprite count : 22
			 SprTile[0] = "boss2Tile";
			 SprTile[1] = "battleSprTile";
			 SprTile[2] = "battleSprTile";
			 SprTile[3] = "battleSprTile";
			 SprTile[4] = "battleSprTile";
			 SprTile[5] = "battleSprTile";
			 SprTile[6] = "battleSprTile";
			 SprTile[7] = "battleSprTile";
			 SprTile[8] = "battleSprTile";
			 SprTile[9] = "battleSprTile";
			 SprTile[10] = "battleSprTile";
			 SprTile[11] = "battleSprTile";
			 SprTile[12] = "battleSprTile";
			 SprTile[13] = "battleSprTile";
			 SprTile[14] = "battleSprTile";
			 SprTile[15] = "battleSprTile";
			 SprTile[16] = "battleSprTile";
			 SprTile[17] = "battleSprTile";
			 SprTile[18] = "battleSprTile";
			 SprTile[19] = "battleSprTile";
			 SprTile[20] = "battleSprTile";
			 SprTile[21] = "battleSprTile";
			
			
			return SprTile;
		}
	

		// World : bossLevel_02
		if(Name.indexOf("bossLevel_02")>=0){
			String[] SprTile = new String[48];
			// sprite count : 48
			 SprTile[0] = "boss1Tile";
			 SprTile[1] = "battleSprTile";
			 SprTile[2] = "battleSprTile";
			 SprTile[3] = "battleSprTile";
			 SprTile[4] = "battleSprTile";
			 SprTile[5] = "battleSprTile";
			 SprTile[6] = "battleSprTile";
			 SprTile[7] = "battleSprTile";
			 SprTile[8] = "battleSprTile";
			 SprTile[9] = "battleSprTile";
			 SprTile[10] = "battleSprTile";
			 SprTile[11] = "battleSprTile";
			 SprTile[12] = "battleSprTile";
			 SprTile[13] = "battleSprTile";
			 SprTile[14] = "battleSprTile";
			 SprTile[15] = "battleSprTile";
			 SprTile[16] = "battleSprTile";
			 SprTile[17] = "battleSprTile";
			 SprTile[18] = "battleSprTile";
			 SprTile[19] = "battleSprTile";
			 SprTile[20] = "battleSprTile";
			 SprTile[21] = "battleSprTile";
			 SprTile[22] = "battleSprTile";
			 SprTile[23] = "battleSprTile";
			 SprTile[24] = "battleSprTile";
			 SprTile[25] = "battleSprTile";
			 SprTile[26] = "battleSprTile";
			 SprTile[27] = "battleSprTile";
			 SprTile[28] = "battleSprTile";
			 SprTile[29] = "battleSprTile";
			 SprTile[30] = "battleSprTile";
			 SprTile[31] = "battleSprTile";
			 SprTile[32] = "battleSprTile";
			 SprTile[33] = "battleSprTile";
			 SprTile[34] = "battleSprTile";
			 SprTile[35] = "battleSprTile";
			 SprTile[36] = "battleSprTile";
			 SprTile[37] = "battleSprTile";
			 SprTile[38] = "battleSprTile";
			 SprTile[39] = "battleSprTile";
			 SprTile[40] = "battleSprTile";
			 SprTile[41] = "battleSprTile";
			 SprTile[42] = "battleSprTile";
			 SprTile[43] = "battleSprTile";
			 SprTile[44] = "battleSprTile";
			 SprTile[45] = "battleSprTile";
			 SprTile[46] = "battleSprTile";
			 SprTile[47] = "battleSprTile";
			
			
			return SprTile;
		}
	

		// World : bossLevel_03
		if(Name.indexOf("bossLevel_03")>=0){
			String[] SprTile = new String[55];
			// sprite count : 55
			 SprTile[0] = "boss3Tile";
			 SprTile[1] = "boss3Tile";
			 SprTile[2] = "boss3Tile";
			 SprTile[3] = "battleSprTile";
			 SprTile[4] = "battleSprTile";
			 SprTile[5] = "battleSprTile";
			 SprTile[6] = "battleSprTile";
			 SprTile[7] = "battleSprTile";
			 SprTile[8] = "battleSprTile";
			 SprTile[9] = "battleSprTile";
			 SprTile[10] = "battleSprTile";
			 SprTile[11] = "battleSprTile";
			 SprTile[12] = "battleSprTile";
			 SprTile[13] = "battleSprTile";
			 SprTile[14] = "battleSprTile";
			 SprTile[15] = "battleSprTile";
			 SprTile[16] = "battleSprTile";
			 SprTile[17] = "battleSprTile";
			 SprTile[18] = "battleSprTile";
			 SprTile[19] = "battleSprTile";
			 SprTile[20] = "battleSprTile";
			 SprTile[21] = "battleSprTile";
			 SprTile[22] = "battleSprTile";
			 SprTile[23] = "battleSprTile";
			 SprTile[24] = "battleSprTile";
			 SprTile[25] = "battleSprTile";
			 SprTile[26] = "battleSprTile";
			 SprTile[27] = "battleSprTile";
			 SprTile[28] = "battleSprTile";
			 SprTile[29] = "battleSprTile";
			 SprTile[30] = "battleSprTile";
			 SprTile[31] = "battleSprTile";
			 SprTile[32] = "battleSprTile";
			 SprTile[33] = "battleSprTile";
			 SprTile[34] = "battleSprTile";
			 SprTile[35] = "battleSprTile";
			 SprTile[36] = "battleSprTile";
			 SprTile[37] = "battleSprTile";
			 SprTile[38] = "battleSprTile";
			 SprTile[39] = "battleSprTile";
			 SprTile[40] = "battleSprTile";
			 SprTile[41] = "battleSprTile";
			 SprTile[42] = "battleSprTile";
			 SprTile[43] = "battleSprTile";
			 SprTile[44] = "battleSprTile";
			 SprTile[45] = "battleSprTile";
			 SprTile[46] = "battleSprTile";
			 SprTile[47] = "battleSprTile";
			 SprTile[48] = "battleSprTile";
			 SprTile[49] = "battleSprTile";
			 SprTile[50] = "battleSprTile";
			 SprTile[51] = "battleSprTile";
			 SprTile[52] = "battleSprTile";
			 SprTile[53] = "battleSprTile";
			 SprTile[54] = "battleSprTile";
			
			
			return SprTile;
		}
	

		// World : bossLevel_04
		if(Name.indexOf("bossLevel_04")>=0){
			String[] SprTile = new String[48];
			// sprite count : 48
			 SprTile[0] = "battleSprTile";
			 SprTile[1] = "battleSprTile";
			 SprTile[2] = "battleSprTile";
			 SprTile[3] = "battleSprTile";
			 SprTile[4] = "battleSprTile";
			 SprTile[5] = "battleSprTile";
			 SprTile[6] = "battleSprTile";
			 SprTile[7] = "battleSprTile";
			 SprTile[8] = "battleSprTile";
			 SprTile[9] = "battleSprTile";
			 SprTile[10] = "battleSprTile";
			 SprTile[11] = "battleSprTile";
			 SprTile[12] = "battleSprTile";
			 SprTile[13] = "battleSprTile";
			 SprTile[14] = "battleSprTile";
			 SprTile[15] = "battleSprTile";
			 SprTile[16] = "battleSprTile";
			 SprTile[17] = "battleSprTile";
			 SprTile[18] = "battleSprTile";
			 SprTile[19] = "battleSprTile";
			 SprTile[20] = "battleSprTile";
			 SprTile[21] = "battleSprTile";
			 SprTile[22] = "battleSprTile";
			 SprTile[23] = "battleSprTile";
			 SprTile[24] = "battleSprTile";
			 SprTile[25] = "battleSprTile";
			 SprTile[26] = "battleSprTile";
			 SprTile[27] = "battleSprTile";
			 SprTile[28] = "battleSprTile";
			 SprTile[29] = "battleSprTile";
			 SprTile[30] = "battleSprTile";
			 SprTile[31] = "battleSprTile";
			 SprTile[32] = "battleSprTile";
			 SprTile[33] = "battleSprTile";
			 SprTile[34] = "battleSprTile";
			 SprTile[35] = "battleSprTile";
			 SprTile[36] = "battleSprTile";
			 SprTile[37] = "battleSprTile";
			 SprTile[38] = "battleSprTile";
			 SprTile[39] = "battleSprTile";
			 SprTile[40] = "battleSprTile";
			 SprTile[41] = "battleSprTile";
			 SprTile[42] = "battleSprTile";
			 SprTile[43] = "battleSprTile";
			 SprTile[44] = "battleSprTile";
			 SprTile[45] = "battleSprTile";
			 SprTile[46] = "boss4Tile";
			 SprTile[47] = "battleSprTile";
			
			
			return SprTile;
		}
	

		// World : bossLevel_05
		if(Name.indexOf("bossLevel_05")>=0){
			String[] SprTile = new String[32];
			// sprite count : 32
			 SprTile[0] = "boss5Tile";
			 SprTile[1] = "battleSprTile";
			 SprTile[2] = "battleSprTile";
			 SprTile[3] = "battleSprTile";
			 SprTile[4] = "battleSprTile";
			 SprTile[5] = "battleSprTile";
			 SprTile[6] = "battleSprTile";
			 SprTile[7] = "battleSprTile";
			 SprTile[8] = "battleSprTile";
			 SprTile[9] = "battleSprTile";
			 SprTile[10] = "battleSprTile";
			 SprTile[11] = "battleSprTile";
			 SprTile[12] = "battleSprTile";
			 SprTile[13] = "battleSprTile";
			 SprTile[14] = "battleSprTile";
			 SprTile[15] = "battleSprTile";
			 SprTile[16] = "battleSprTile";
			 SprTile[17] = "battleSprTile";
			 SprTile[18] = "battleSprTile";
			 SprTile[19] = "battleSprTile";
			 SprTile[20] = "battleSprTile";
			 SprTile[21] = "battleSprTile";
			 SprTile[22] = "battleSprTile";
			 SprTile[23] = "battleSprTile";
			 SprTile[24] = "battleSprTile";
			 SprTile[25] = "battleSprTile";
			 SprTile[26] = "battleSprTile";
			 SprTile[27] = "battleSprTile";
			 SprTile[28] = "battleSprTile";
			 SprTile[29] = "battleSprTile";
			 SprTile[30] = "battleSprTile";
			 SprTile[31] = "battleSprTile";
			
			
			return SprTile;
		}
	

		return null;
	}

	final static public String[] getWorldSprName(String Name){
	
		// World : battleLevel_00
		if(Name.indexOf("battleLevel_00")>=0){
			String[] SprName = new String[51];
			// sprite count : 51
			 SprName[0] = "wp00_ai01";
			 SprName[1] = "wp00_ai01";
			 SprName[2] = "wp00_ai01";
			 SprName[3] = "wp00_ai01";
			 SprName[4] = "wp00_ai01";
			 SprName[5] = "wp00_ai01";
			 SprName[6] = "wp11_ai04";
			 SprName[7] = "wp10_ai04";
			 SprName[8] = "wp09_ai04";
			 SprName[9] = "wp08_ai04";
			 SprName[10] = "wp06_ai04";
			 SprName[11] = "wp07_ai04";
			 SprName[12] = "wp00_ai01";
			 SprName[13] = "wp00_ai01";
			 SprName[14] = "wp00_ai01";
			 SprName[15] = "wp00_ai01";
			 SprName[16] = "wp00_ai01";
			 SprName[17] = "wp00_ai01";
			 SprName[18] = "wpNA_ai13";
			 SprName[19] = "wpNA_ai13";
			 SprName[20] = "wp13_ai02";
			 SprName[21] = "wp13_ai02";
			 SprName[22] = "wp13_ai02";
			 SprName[23] = "wp13_ai02";
			 SprName[24] = "wp15_ai02";
			 SprName[25] = "wp15_ai02";
			 SprName[26] = "wp15_ai02";
			 SprName[27] = "wp15_ai02";
			 SprName[28] = "wpNA_ai03";
			 SprName[29] = "wpNA_ai03";
			 SprName[30] = "wpNA_ai03";
			 SprName[31] = "wpNA_ai03";
			 SprName[32] = "wpNA_ai03";
			 SprName[33] = "wpNA_ai03";
			 SprName[34] = "wpNA_ai02";
			 SprName[35] = "wpNA_ai02";
			 SprName[36] = "wpNA_ai02";
			 SprName[37] = "wpNA_ai02";
			 SprName[38] = "wpNA_ai02";
			 SprName[39] = "wpNA_ai02";
			 SprName[40] = "wpNA_ai02";
			 SprName[41] = "wpNA_ai02";
			 SprName[42] = "wp21_ai05";
			 SprName[43] = "wp17_ai05";
			 SprName[44] = "wp18_ai05";
			 SprName[45] = "wp22_ai05";
			 SprName[46] = "wp19_ai05";
			 SprName[47] = "wp23_ai05";
			 SprName[48] = "wp19_ai05";
			 SprName[49] = "wp23_ai05";
			 SprName[50] = "btSpr";
			
			
			return SprName;
		}
	

		// World : battleLevel_01
		if(Name.indexOf("battleLevel_01")>=0){
			String[] SprName = new String[73];
			// sprite count : 73
			 SprName[0] = "wp00_ai04";
			 SprName[1] = "wp00_ai04";
			 SprName[2] = "wp00_ai04";
			 SprName[3] = "wp00_ai04";
			 SprName[4] = "wp00_ai04";
			 SprName[5] = "wp00_ai04";
			 SprName[6] = "wpNA_ai07";
			 SprName[7] = "wpNA_ai07";
			 SprName[8] = "wpNA_ai07";
			 SprName[9] = "wpNA_ai07";
			 SprName[10] = "wp11_ai05";
			 SprName[11] = "wp11_ai05";
			 SprName[12] = "wp11_ai05";
			 SprName[13] = "wp09_ai05";
			 SprName[14] = "wp09_ai05";
			 SprName[15] = "wp09_ai05";
			 SprName[16] = "wpNA_ai13";
			 SprName[17] = "wpNA_ai13";
			 SprName[18] = "wpNA_ai13";
			 SprName[19] = "wpNA_ai13";
			 SprName[20] = "wp12_ai7";
			 SprName[21] = "wp12_ai7";
			 SprName[22] = "wp12_ai7";
			 SprName[23] = "wp12_ai7";
			 SprName[24] = "wp12_ai7";
			 SprName[25] = "wp12_ai7";
			 SprName[26] = "wpNA_ai02";
			 SprName[27] = "wpNA_ai02";
			 SprName[28] = "wpNA_ai02";
			 SprName[29] = "wpNA_ai02";
			 SprName[30] = "wpNA_ai02";
			 SprName[31] = "wp13_ai04";
			 SprName[32] = "wp13_ai04";
			 SprName[33] = "wp13_ai04";
			 SprName[34] = "wp13_ai04";
			 SprName[35] = "wp13_ai04";
			 SprName[36] = "wp13_ai04";
			 SprName[37] = "wp13_ai04";
			 SprName[38] = "wp13_ai04";
			 SprName[39] = "wpNA_ai14";
			 SprName[40] = "wpNA_ai14";
			 SprName[41] = "wpNA_ai14";
			 SprName[42] = "wp14_ai04";
			 SprName[43] = "wp14_ai04";
			 SprName[44] = "wp14_ai04";
			 SprName[45] = "wp14_ai04";
			 SprName[46] = "wp14_ai04";
			 SprName[47] = "wp14_ai04";
			 SprName[48] = "wpNA_ai14";
			 SprName[49] = "wpNA_ai14";
			 SprName[50] = "wp17_ai04";
			 SprName[51] = "wp17_ai04";
			 SprName[52] = "wp17_ai04";
			 SprName[53] = "wp17_ai04";
			 SprName[54] = "wp17_ai04";
			 SprName[55] = "wp17_ai04";
			 SprName[56] = "wp17_ai04";
			 SprName[57] = "wp17_ai04";
			 SprName[58] = "wp17_ai04";
			 SprName[59] = "wp17_ai04";
			 SprName[60] = "wp24_ai14";
			 SprName[61] = "wp24_ai14";
			 SprName[62] = "wp24_ai14";
			 SprName[63] = "wp24_ai14";
			 SprName[64] = "wp24_ai14";
			 SprName[65] = "wp24_ai14";
			 SprName[66] = "wpNA_ai07";
			 SprName[67] = "wpNA_ai07";
			 SprName[68] = "wpNA_ai07";
			 SprName[69] = "wpNA_ai07";
			 SprName[70] = "wpNA_ai07";
			 SprName[71] = "wpNA_ai07";
			 SprName[72] = "btSpr";
			
			
			return SprName;
		}
	

		// World : battleLevel_02
		if(Name.indexOf("battleLevel_02")>=0){
			String[] SprName = new String[83];
			// sprite count : 83
			 SprName[0] = "wpNA_ai10";
			 SprName[1] = "wpNA_ai10";
			 SprName[2] = "wpNA_ai10";
			 SprName[3] = "wpNA_ai10";
			 SprName[4] = "wp01_ai5";
			 SprName[5] = "wp01_ai5";
			 SprName[6] = "wp02_ai5";
			 SprName[7] = "wp02_ai5";
			 SprName[8] = "wpNA_ai13";
			 SprName[9] = "wpNA_ai13";
			 SprName[10] = "wpNA_ai13";
			 SprName[11] = "wpNA_ai13";
			 SprName[12] = "wp07_ai2";
			 SprName[13] = "wp07_ai2";
			 SprName[14] = "wp07_ai2";
			 SprName[15] = "wp08_ai2";
			 SprName[16] = "wp08_ai2";
			 SprName[17] = "wp08_ai2";
			 SprName[18] = "wp07_ai2";
			 SprName[19] = "wp08_ai2";
			 SprName[20] = "wpNA_ai17";
			 SprName[21] = "wpNA_ai17";
			 SprName[22] = "wpNA_ai17";
			 SprName[23] = "wpNA_ai07";
			 SprName[24] = "wp12_ai07";
			 SprName[25] = "wpNA_ai07";
			 SprName[26] = "wp13_ai07";
			 SprName[27] = "wpNA_ai07";
			 SprName[28] = "wp12_ai07";
			 SprName[29] = "wpNA_ai07";
			 SprName[30] = "wp13_ai07";
			 SprName[31] = "wpNA_ai07";
			 SprName[32] = "wp12_ai07";
			 SprName[33] = "wp14_ai03";
			 SprName[34] = "wp14_ai03";
			 SprName[35] = "wp14_ai03";
			 SprName[36] = "wp14_ai03";
			 SprName[37] = "wpNA_ai10";
			 SprName[38] = "wpNA_ai10";
			 SprName[39] = "wpNA_ai10";
			 SprName[40] = "wpNA_ai10";
			 SprName[41] = "wpNA_ai10";
			 SprName[42] = "wpNA_ai10";
			 SprName[43] = "wpNA_ai10";
			 SprName[44] = "wpNA_ai10";
			 SprName[45] = "wpNA_ai10";
			 SprName[46] = "wpNA_ai10";
			 SprName[47] = "wpNA_ai10";
			 SprName[48] = "wpNA_ai11";
			 SprName[49] = "wpNA_ai11";
			 SprName[50] = "wpNA_ai10";
			 SprName[51] = "wpNA_ai10";
			 SprName[52] = "wpNA_ai10";
			 SprName[53] = "wpNA_ai10";
			 SprName[54] = "wpNA_ai10";
			 SprName[55] = "wpNA_ai10";
			 SprName[56] = "wpNA_ai17";
			 SprName[57] = "wpNA_ai17";
			 SprName[58] = "wpNA_ai17";
			 SprName[59] = "wpNA_ai17";
			 SprName[60] = "wpNA_ai17";
			 SprName[61] = "wpNA_ai17";
			 SprName[62] = "wpNA_ai07";
			 SprName[63] = "wpNA_ai07";
			 SprName[64] = "wpNA_ai07";
			 SprName[65] = "wpNA_ai07";
			 SprName[66] = "wpNA_ai07";
			 SprName[67] = "wpNA_ai07";
			 SprName[68] = "wpNA_ai07";
			 SprName[69] = "wpNA_ai07";
			 SprName[70] = "wpNA_ai07";
			 SprName[71] = "wpNA_ai07";
			 SprName[72] = "wpNA_ai07";
			 SprName[73] = "wpNA_ai12";
			 SprName[74] = "wpNA_ai12";
			 SprName[75] = "wpNA_ai12";
			 SprName[76] = "wpNA_ai12";
			 SprName[77] = "wpNA_ai12";
			 SprName[78] = "wpNA_ai14";
			 SprName[79] = "wpNA_ai14";
			 SprName[80] = "wpNA_ai14";
			 SprName[81] = "wpNA_ai14";
			 SprName[82] = "btSpr";
			
			
			return SprName;
		}
	

		// World : battleLevel_03
		if(Name.indexOf("battleLevel_03")>=0){
			String[] SprName = new String[75];
			// sprite count : 75
			 SprName[0] = "wp01_ai02";
			 SprName[1] = "wp01_ai02";
			 SprName[2] = "wp01_ai02";
			 SprName[3] = "wp01_ai02";
			 SprName[4] = "wp01_ai02";
			 SprName[5] = "wp01_ai02";
			 SprName[6] = "wp02_ai05";
			 SprName[7] = "wp02_ai05";
			 SprName[8] = "wp02_ai05";
			 SprName[9] = "wp02_ai05";
			 SprName[10] = "wp02_ai05";
			 SprName[11] = "wp03_ai05";
			 SprName[12] = "wp03_ai05";
			 SprName[13] = "wp03_ai05";
			 SprName[14] = "wp03_ai05";
			 SprName[15] = "wp03_ai05";
			 SprName[16] = "wp04_ai08";
			 SprName[17] = "wp04_ai08";
			 SprName[18] = "wp04_ai08";
			 SprName[19] = "wp04_ai08";
			 SprName[20] = "wp04_ai08";
			 SprName[21] = "wp04_ai08";
			 SprName[22] = "wp04_ai08";
			 SprName[23] = "wp04_ai08";
			 SprName[24] = "wpNA_ai17";
			 SprName[25] = "wpNA_ai14";
			 SprName[26] = "wpNA_ai17";
			 SprName[27] = "wpNA_ai17";
			 SprName[28] = "wpNA_ai17";
			 SprName[29] = "wpNA_ai17";
			 SprName[30] = "wpNA_ai17";
			 SprName[31] = "wpNA_ai14";
			 SprName[32] = "wpNA_ai08";
			 SprName[33] = "wpNA_ai08";
			 SprName[34] = "wpNA_ai08";
			 SprName[35] = "wpNA_ai08";
			 SprName[36] = "wpNA_ai11";
			 SprName[37] = "wpNA_ai11";
			 SprName[38] = "wpNA_ai11";
			 SprName[39] = "wpNA_ai11";
			 SprName[40] = "wpNA_ai11";
			 SprName[41] = "wpNA_ai11";
			 SprName[42] = "wpNA_ai11";
			 SprName[43] = "wpNA_ai11";
			 SprName[44] = "wpNA_ai11";
			 SprName[45] = "wpNA_ai11";
			 SprName[46] = "wpNA_ai11";
			 SprName[47] = "wpNA_ai11";
			 SprName[48] = "wp05_ai05";
			 SprName[49] = "wp05_ai05";
			 SprName[50] = "wp05_ai05";
			 SprName[51] = "wp07_ai05";
			 SprName[52] = "wp07_ai05";
			 SprName[53] = "wp07_ai05";
			 SprName[54] = "wp17_ai02";
			 SprName[55] = "wp17_ai02";
			 SprName[56] = "wp17_ai02";
			 SprName[57] = "wp17_ai02";
			 SprName[58] = "wp17_ai02";
			 SprName[59] = "wp17_ai02";
			 SprName[60] = "wp17_ai02";
			 SprName[61] = "wp09_ai02";
			 SprName[62] = "wp09_ai02";
			 SprName[63] = "wp09_ai02";
			 SprName[64] = "wp09_ai02";
			 SprName[65] = "wp09_ai02";
			 SprName[66] = "wp09_ai02";
			 SprName[67] = "wp09_ai02";
			 SprName[68] = "wpNA_ai12";
			 SprName[69] = "wpNA_ai12";
			 SprName[70] = "wpNA_ai12";
			 SprName[71] = "wpNA_ai12";
			 SprName[72] = "wpNA_ai12";
			 SprName[73] = "wpNA_ai12";
			 SprName[74] = "btSpr";
			
			
			return SprName;
		}
	

		// World : battleLevel_04
		if(Name.indexOf("battleLevel_04")>=0){
			String[] SprName = new String[74];
			// sprite count : 74
			 SprName[0] = "wpNA_ai08";
			 SprName[1] = "wpNA_ai08";
			 SprName[2] = "wpNA_ai08";
			 SprName[3] = "wpNA_ai08";
			 SprName[4] = "wpNA_ai08";
			 SprName[5] = "wpNA_ai08";
			 SprName[6] = "wpNA_ai17";
			 SprName[7] = "wpNA_ai17";
			 SprName[8] = "wpNA_ai17";
			 SprName[9] = "wpNA_ai03";
			 SprName[10] = "wpNA_ai03";
			 SprName[11] = "wpNA_ai03";
			 SprName[12] = "wpNA_ai03";
			 SprName[13] = "wpNA_ai03";
			 SprName[14] = "wpNA_ai03";
			 SprName[15] = "wpNA_ai03";
			 SprName[16] = "wpNA_ai03";
			 SprName[17] = "wpNA_ai03";
			 SprName[18] = "wpNA_ai03";
			 SprName[19] = "wpNA_ai03";
			 SprName[20] = "wpNA_ai03";
			 SprName[21] = "wpNA_ai12";
			 SprName[22] = "wpNA_ai12";
			 SprName[23] = "wpNA_ai12";
			 SprName[24] = "wpNA_ai12";
			 SprName[25] = "wpNA_ai12";
			 SprName[26] = "wp00_ai02";
			 SprName[27] = "wp00_ai02";
			 SprName[28] = "wp00_ai02";
			 SprName[29] = "wp02_ai02";
			 SprName[30] = "wp02_ai02";
			 SprName[31] = "wp02_ai02";
			 SprName[32] = "wp04_ai02";
			 SprName[33] = "wp04_ai02";
			 SprName[34] = "wp04_ai02";
			 SprName[35] = "wp06_ai02";
			 SprName[36] = "wp06_ai02";
			 SprName[37] = "wp06_ai02";
			 SprName[38] = "wp06_ai02";
			 SprName[39] = "wpNA_ai09";
			 SprName[40] = "wpNA_ai09";
			 SprName[41] = "wpNA_ai09";
			 SprName[42] = "wpNA_ai09";
			 SprName[43] = "wpNA_ai09";
			 SprName[44] = "wpNA_ai09";
			 SprName[45] = "wpNA_ai09";
			 SprName[46] = "wpNA_ai09";
			 SprName[47] = "wpNA_ai09";
			 SprName[48] = "wpNA_ai09";
			 SprName[49] = "wpNA_ai09";
			 SprName[50] = "wpNA_ai09";
			 SprName[51] = "wp08_ai12";
			 SprName[52] = "wp08_ai12";
			 SprName[53] = "wp08_ai12";
			 SprName[54] = "wp08_ai12";
			 SprName[55] = "wpNA_ai10";
			 SprName[56] = "wpNA_ai10";
			 SprName[57] = "wpNA_ai10";
			 SprName[58] = "wpNA_ai10";
			 SprName[59] = "wpNA_ai10";
			 SprName[60] = "wpNA_ai10";
			 SprName[61] = "wpNA_ai10";
			 SprName[62] = "wpNA_ai10";
			 SprName[63] = "wpNA_ai10";
			 SprName[64] = "wpNA_ai10";
			 SprName[65] = "wpNA_ai10";
			 SprName[66] = "wpNA_ai10";
			 SprName[67] = "wpNA_ai10";
			 SprName[68] = "wpNA_ai10";
			 SprName[69] = "wpNA_ai10";
			 SprName[70] = "wp08_ai12";
			 SprName[71] = "wp08_ai12";
			 SprName[72] = "wp08_ai12";
			 SprName[73] = "btSpr";
			
			
			return SprName;
		}
	

		// World : battleLevel_05
		if(Name.indexOf("battleLevel_05")>=0){
			String[] SprName = new String[59];
			// sprite count : 59
			 SprName[0] = "wp00_ai11";
			 SprName[1] = "wp00_ai11";
			 SprName[2] = "wp02_ai11";
			 SprName[3] = "wp02_ai11";
			 SprName[4] = "wpNA_ai10";
			 SprName[5] = "wpNA_ai10";
			 SprName[6] = "wpNA_ai10";
			 SprName[7] = "wpNA_ai10";
			 SprName[8] = "wpNA_ai10";
			 SprName[9] = "wp04_ai12";
			 SprName[10] = "wp04_ai12";
			 SprName[11] = "wp06_ai12";
			 SprName[12] = "wp06_ai12";
			 SprName[13] = "wpNA_ai11";
			 SprName[14] = "wpNA_ai11";
			 SprName[15] = "wpNA_ai11";
			 SprName[16] = "wpNA_ai11";
			 SprName[17] = "wpNA_ai11";
			 SprName[18] = "wpNA_ai11";
			 SprName[19] = "wp08_ai10";
			 SprName[20] = "wp08_ai10";
			 SprName[21] = "wp08_ai10";
			 SprName[22] = "wp08_ai10";
			 SprName[23] = "wp08_ai10";
			 SprName[24] = "wp08_ai10";
			 SprName[25] = "wp08_ai10";
			 SprName[26] = "wp08_ai10";
			 SprName[27] = "wp08_ai10";
			 SprName[28] = "wpNA_ai11";
			 SprName[29] = "wpNA_ai11";
			 SprName[30] = "wpNA_ai11";
			 SprName[31] = "wpNA_ai11";
			 SprName[32] = "wpNA_ai11";
			 SprName[33] = "wp15_ai10";
			 SprName[34] = "wp15_ai10";
			 SprName[35] = "wp15_ai10";
			 SprName[36] = "wp15_ai10";
			 SprName[37] = "wp15_ai10";
			 SprName[38] = "wp15_ai10";
			 SprName[39] = "wp15_ai10";
			 SprName[40] = "wp15_ai10";
			 SprName[41] = "wp15_ai10";
			 SprName[42] = "wp15_ai10";
			 SprName[43] = "wp27_ai11";
			 SprName[44] = "wp27_ai11";
			 SprName[45] = "wp27_ai11";
			 SprName[46] = "wp27_ai11";
			 SprName[47] = "wp27_ai11";
			 SprName[48] = "wp27_ai11";
			 SprName[49] = "wp27_ai11";
			 SprName[50] = "wp27_ai11";
			 SprName[51] = "wp27_ai11";
			 SprName[52] = "wp27_ai11";
			 SprName[53] = "wp27_ai11";
			 SprName[54] = "wp27_ai11";
			 SprName[55] = "wp27_ai11";
			 SprName[56] = "wp27_ai11";
			 SprName[57] = "wp27_ai11";
			 SprName[58] = "btSpr";
			
			
			return SprName;
		}
	

		// World : battleLevel_06
		if(Name.indexOf("battleLevel_06")>=0){
			String[] SprName = new String[64];
			// sprite count : 64
			 SprName[0] = "wp00_ai15";
			 SprName[1] = "wp12_ai15";
			 SprName[2] = "wp01_ai15";
			 SprName[3] = "wp13_ai15";
			 SprName[4] = "wp02_ai15";
			 SprName[5] = "wp14_ai15";
			 SprName[6] = "wp03_ai15";
			 SprName[7] = "wp15_ai15";
			 SprName[8] = "wp04_ai15";
			 SprName[9] = "wp16_ai15";
			 SprName[10] = "wp05_ai15";
			 SprName[11] = "wp17_ai15";
			 SprName[12] = "wp6_ai15";
			 SprName[13] = "wp18_ai15";
			 SprName[14] = "wp07_ai15";
			 SprName[15] = "wp19_ai15";
			 SprName[16] = "wp08_ai15";
			 SprName[17] = "wp20_ai15";
			 SprName[18] = "wp09_ai15";
			 SprName[19] = "wp21_ai15";
			 SprName[20] = "wp10_ai15";
			 SprName[21] = "wp22_ai15";
			 SprName[22] = "wp45_ai15";
			 SprName[23] = "wp46_ai15";
			 SprName[24] = "wp47_ai15";
			 SprName[25] = "wp48_ai15";
			 SprName[26] = "wp49_ai15";
			 SprName[27] = "wp50_ai15";
			 SprName[28] = "wp51_ai15";
			 SprName[29] = "wp52_ai15";
			 SprName[30] = "wp53_ai15";
			 SprName[31] = "wp54_ai15";
			 SprName[32] = "wp55_ai15";
			 SprName[33] = "wp56_ai15";
			 SprName[34] = "wp57_ai15";
			 SprName[35] = "wp70_ai15";
			 SprName[36] = "wp70_ai15";
			 SprName[37] = "wp70_ai15";
			 SprName[38] = "wp70_ai15";
			 SprName[39] = "wp71_ai15";
			 SprName[40] = "wp71_ai15";
			 SprName[41] = "wp71_ai15";
			 SprName[42] = "wp71_ai15";
			 SprName[43] = "wp72_ai15";
			 SprName[44] = "wp72_ai15";
			 SprName[45] = "wp72_ai15";
			 SprName[46] = "wp72_ai15";
			 SprName[47] = "wpNA_ai09";
			 SprName[48] = "wpNA_ai09";
			 SprName[49] = "wpNA_ai09";
			 SprName[50] = "wpNA_ai09";
			 SprName[51] = "wpNA_ai09";
			 SprName[52] = "wpNA_ai09";
			 SprName[53] = "wpNA_ai09";
			 SprName[54] = "wpNA_ai09";
			 SprName[55] = "wpNA_ai09";
			 SprName[56] = "wpNA_ai09";
			 SprName[57] = "wpNA_ai09";
			 SprName[58] = "wpNA_ai09";
			 SprName[59] = "wpNA_ai09";
			 SprName[60] = "wpNA_ai09";
			 SprName[61] = "wpNA_ai09";
			 SprName[62] = "wpNA_ai09";
			 SprName[63] = "btSpr";
			
			
			return SprName;
		}
	

		// World : bossLevel_01
		if(Name.indexOf("bossLevel_01")>=0){
			String[] SprName = new String[22];
			// sprite count : 22
			 SprName[0] = "wp00_ai51";
			 SprName[1] = "wpNA_ai12";
			 SprName[2] = "wpNA_ai12";
			 SprName[3] = "wpNA_ai12";
			 SprName[4] = "wpNA_ai12";
			 SprName[5] = "wpNA_ai12";
			 SprName[6] = "wpNA_ai08";
			 SprName[7] = "wpNA_ai08";
			 SprName[8] = "wpNA_ai08";
			 SprName[9] = "wpNA_ai08";
			 SprName[10] = "wpNA_ai08";
			 SprName[11] = "wpNA_ai08";
			 SprName[12] = "wpNA_ai08";
			 SprName[13] = "wpNA_ai18";
			 SprName[14] = "wpNA_ai18";
			 SprName[15] = "wpNA_ai18";
			 SprName[16] = "wpNA_ai18";
			 SprName[17] = "wpNA_ai18";
			 SprName[18] = "wpNA_ai18";
			 SprName[19] = "wpNA_ai18";
			 SprName[20] = "wpNA_ai18";
			 SprName[21] = "btSpr";
			
			
			return SprName;
		}
	

		// World : bossLevel_02
		if(Name.indexOf("bossLevel_02")>=0){
			String[] SprName = new String[48];
			// sprite count : 48
			 SprName[0] = "wp00_ai50";
			 SprName[1] = "wpNA_ai11";
			 SprName[2] = "wpNA_ai11";
			 SprName[3] = "wpNA_ai11";
			 SprName[4] = "wpNA_ai09";
			 SprName[5] = "wpNA_ai09";
			 SprName[6] = "wpNA_ai09";
			 SprName[7] = "wpNA_ai09";
			 SprName[8] = "wpNA_ai09";
			 SprName[9] = "wpNA_ai09";
			 SprName[10] = "wpNA_ai09";
			 SprName[11] = "wpNA_ai09";
			 SprName[12] = "wpNA_ai09";
			 SprName[13] = "wpNA_ai09";
			 SprName[14] = "wpNA_ai15";
			 SprName[15] = "wpNA_ai15";
			 SprName[16] = "wpNA_ai15";
			 SprName[17] = "wpNA_ai15";
			 SprName[18] = "wpNA_ai15";
			 SprName[19] = "wpNA_ai15";
			 SprName[20] = "wpNA_ai15";
			 SprName[21] = "wpNA_ai09";
			 SprName[22] = "wpNA_ai09";
			 SprName[23] = "wpNA_ai09";
			 SprName[24] = "wpNA_ai09";
			 SprName[25] = "wpNA_ai09";
			 SprName[26] = "wpNA_ai06";
			 SprName[27] = "wpNA_ai06";
			 SprName[28] = "wpNA_ai06";
			 SprName[29] = "wpNA_ai06";
			 SprName[30] = "wpNA_ai06";
			 SprName[31] = "wpNA_ai06";
			 SprName[32] = "wpNA_ai06";
			 SprName[33] = "wpNA_ai06";
			 SprName[34] = "wpNA_ai06";
			 SprName[35] = "wpNA_ai06";
			 SprName[36] = "wpNA_ai11";
			 SprName[37] = "wpNA_ai11";
			 SprName[38] = "wpNA_ai11";
			 SprName[39] = "wpNA_ai11";
			 SprName[40] = "wpNA_ai11";
			 SprName[41] = "wpNA_ai11";
			 SprName[42] = "wpNA_ai11";
			 SprName[43] = "wpNA_ai11";
			 SprName[44] = "wpNA_ai11";
			 SprName[45] = "wpNA_ai11";
			 SprName[46] = "wpNA_ai11";
			 SprName[47] = "btSpr";
			
			
			return SprName;
		}
	

		// World : bossLevel_03
		if(Name.indexOf("bossLevel_03")>=0){
			String[] SprName = new String[55];
			// sprite count : 55
			 SprName[0] = "wp00_ai52";
			 SprName[1] = "wp02_ai52";
			 SprName[2] = "wp04_ai52";
			 SprName[3] = "wpNA_ai09";
			 SprName[4] = "wpNA_ai09";
			 SprName[5] = "wpNA_ai09";
			 SprName[6] = "wpNA_ai09";
			 SprName[7] = "wpNA_ai09";
			 SprName[8] = "wpNA_ai09";
			 SprName[9] = "wpNA_ai09";
			 SprName[10] = "wpNA_ai09";
			 SprName[11] = "wpNA_ai09";
			 SprName[12] = "wpNA_ai09";
			 SprName[13] = "wpNA_ai09";
			 SprName[14] = "wpNA_ai09";
			 SprName[15] = "wpNA_ai09";
			 SprName[16] = "wpNA_ai09";
			 SprName[17] = "wpNA_ai06";
			 SprName[18] = "wpNA_ai06";
			 SprName[19] = "wpNA_ai06";
			 SprName[20] = "wpNA_ai06";
			 SprName[21] = "wpNA_ai06";
			 SprName[22] = "wpNA_ai06";
			 SprName[23] = "wpNA_ai06";
			 SprName[24] = "wpNA_ai06";
			 SprName[25] = "wpNA_ai12";
			 SprName[26] = "wpNA_ai12";
			 SprName[27] = "wpNA_ai12";
			 SprName[28] = "wpNA_ai12";
			 SprName[29] = "wpNA_ai12";
			 SprName[30] = "wpNA_ai12";
			 SprName[31] = "wpNA_ai12";
			 SprName[32] = "wpNA_ai12";
			 SprName[33] = "wpNA_ai12";
			 SprName[34] = "wpNA_ai12";
			 SprName[35] = "wpNA_ai12";
			 SprName[36] = "wpNA_ai12";
			 SprName[37] = "wpNA_ai12";
			 SprName[38] = "wpNA_ai12";
			 SprName[39] = "wpNA_ai12";
			 SprName[40] = "wpNA_ai12";
			 SprName[41] = "wpNA_ai12";
			 SprName[42] = "wpNA_ai12";
			 SprName[43] = "wpNA_ai09";
			 SprName[44] = "wpNA_ai09";
			 SprName[45] = "wpNA_ai09";
			 SprName[46] = "wpNA_ai09";
			 SprName[47] = "wpNA_ai09";
			 SprName[48] = "wpNA_ai09";
			 SprName[49] = "wpNA_ai15";
			 SprName[50] = "wpNA_ai15";
			 SprName[51] = "wpNA_ai15";
			 SprName[52] = "wpNA_ai15";
			 SprName[53] = "wpNA_ai15";
			 SprName[54] = "btSpr";
			
			
			return SprName;
		}
	

		// World : bossLevel_04
		if(Name.indexOf("bossLevel_04")>=0){
			String[] SprName = new String[48];
			// sprite count : 48
			 SprName[0] = "wpNA_ai12";
			 SprName[1] = "wpNA_ai12";
			 SprName[2] = "wpNA_ai12";
			 SprName[3] = "wpNA_ai12";
			 SprName[4] = "wpNA_ai12";
			 SprName[5] = "wpNA_ai12";
			 SprName[6] = "wpNA_ai12";
			 SprName[7] = "wpNA_ai12";
			 SprName[8] = "wpNA_ai12";
			 SprName[9] = "wpNA_ai06";
			 SprName[10] = "wpNA_ai06";
			 SprName[11] = "wpNA_ai06";
			 SprName[12] = "wpNA_ai06";
			 SprName[13] = "wpNA_ai06";
			 SprName[14] = "wpNA_ai06";
			 SprName[15] = "wpNA_ai06";
			 SprName[16] = "wpNA_ai06";
			 SprName[17] = "wpNA_ai06";
			 SprName[18] = "wpNA_ai06";
			 SprName[19] = "wpNA_ai06";
			 SprName[20] = "wpNA_ai06";
			 SprName[21] = "wp00_ai15";
			 SprName[22] = "wp00_ai15";
			 SprName[23] = "wp00_ai15";
			 SprName[24] = "wp02_ai15";
			 SprName[25] = "wp03_ai15";
			 SprName[26] = "wp04_ai15";
			 SprName[27] = "wp05_ai15";
			 SprName[28] = "wp06_ai14";
			 SprName[29] = "wp06_ai14";
			 SprName[30] = "wp06_ai14";
			 SprName[31] = "wp06_ai14";
			 SprName[32] = "wp06_ai14";
			 SprName[33] = "wp06_ai14";
			 SprName[34] = "wp06_ai14";
			 SprName[35] = "wpNA_ai09";
			 SprName[36] = "wpNA_ai09";
			 SprName[37] = "wpNA_ai09";
			 SprName[38] = "wpNA_ai09";
			 SprName[39] = "wpNA_ai09";
			 SprName[40] = "wpNA_ai09";
			 SprName[41] = "wpNA_ai09";
			 SprName[42] = "wpNA_ai09";
			 SprName[43] = "wpNA_ai09";
			 SprName[44] = "wpNA_ai09";
			 SprName[45] = "wpNA_ai09";
			 SprName[46] = "wp11_ai53";
			 SprName[47] = "btSpr";
			
			
			return SprName;
		}
	

		// World : bossLevel_05
		if(Name.indexOf("bossLevel_05")>=0){
			String[] SprName = new String[32];
			// sprite count : 32
			 SprName[0] = "wp00_ai54";
			 SprName[1] = "wpNA_ai03";
			 SprName[2] = "wpNA_ai03";
			 SprName[3] = "wpNA_ai03";
			 SprName[4] = "wpNA_ai03";
			 SprName[5] = "wpNA_ai03";
			 SprName[6] = "wpNA_ai03";
			 SprName[7] = "wpNA_ai03";
			 SprName[8] = "wpNA_ai03";
			 SprName[9] = "wpNA_ai03";
			 SprName[10] = "wpNA_ai03";
			 SprName[11] = "wpNA_ai03";
			 SprName[12] = "wpNA_ai03";
			 SprName[13] = "wpNA_ai03";
			 SprName[14] = "wpNA_ai03";
			 SprName[15] = "wpNA_ai03";
			 SprName[16] = "wpNA_ai03";
			 SprName[17] = "wpNA_ai03";
			 SprName[18] = "wpNA_ai03";
			 SprName[19] = "wpNA_ai03";
			 SprName[20] = "wpNA_ai03";
			 SprName[21] = "wpNA_ai03";
			 SprName[22] = "wpNA_ai03";
			 SprName[23] = "wpNA_ai03";
			 SprName[24] = "wpNA_ai03";
			 SprName[25] = "wpNA_ai03";
			 SprName[26] = "wpNA_ai03";
			 SprName[27] = "wpNA_ai03";
			 SprName[28] = "wpNA_ai03";
			 SprName[29] = "wpNA_ai03";
			 SprName[30] = "wpNA_ai03";
			 SprName[31] = "btSpr";
			
			
			return SprName;
		}
	

		return null;
	}
	
	final static public String[] getWorldSprType(String Name){
	
		// World : battleLevel_00
		if(Name.indexOf("battleLevel_00")>=0){
			String[] SprID = new String[51];
			// sprite count : 51
			 SprID[0] = "btEnemy004";
			 SprID[1] = "btEnemy004";
			 SprID[2] = "btEnemy004";
			 SprID[3] = "btEnemy004";
			 SprID[4] = "btEnemy004";
			 SprID[5] = "btEnemy004";
			 SprID[6] = "btEnemy002";
			 SprID[7] = "btEnemy002";
			 SprID[8] = "btEnemy002";
			 SprID[9] = "btEnemy002";
			 SprID[10] = "btEnemy002";
			 SprID[11] = "btEnemy002";
			 SprID[12] = "btEnemy004";
			 SprID[13] = "btEnemy004";
			 SprID[14] = "btEnemy004";
			 SprID[15] = "btEnemy004";
			 SprID[16] = "btEnemy004";
			 SprID[17] = "btEnemy004";
			 SprID[18] = "btEnemy006";
			 SprID[19] = "btEnemy006";
			 SprID[20] = "btEnemy004";
			 SprID[21] = "btEnemy004";
			 SprID[22] = "btEnemy004";
			 SprID[23] = "btEnemy004";
			 SprID[24] = "btEnemy004";
			 SprID[25] = "btEnemy004";
			 SprID[26] = "btEnemy004";
			 SprID[27] = "btEnemy004";
			 SprID[28] = "btEnemy004";
			 SprID[29] = "btEnemy004";
			 SprID[30] = "btEnemy004";
			 SprID[31] = "btEnemy004";
			 SprID[32] = "btEnemy004";
			 SprID[33] = "btEnemy004";
			 SprID[34] = "btEnemy004";
			 SprID[35] = "btEnemy004";
			 SprID[36] = "btEnemy004";
			 SprID[37] = "btEnemy004";
			 SprID[38] = "btEnemy004";
			 SprID[39] = "btEnemy004";
			 SprID[40] = "btEnemy004";
			 SprID[41] = "btEnemy004";
			 SprID[42] = "btEnemy002";
			 SprID[43] = "btEnemy002";
			 SprID[44] = "btEnemy002";
			 SprID[45] = "btEnemy002";
			 SprID[46] = "btEnemy002";
			 SprID[47] = "btEnemy002";
			 SprID[48] = "btEnemy002";
			 SprID[49] = "btEnemy002";
			 SprID[50] = "btSpr";
			
			
			return SprID;
		}
	

		// World : battleLevel_01
		if(Name.indexOf("battleLevel_01")>=0){
			String[] SprID = new String[73];
			// sprite count : 73
			 SprID[0] = "btEnemy002";
			 SprID[1] = "btEnemy002";
			 SprID[2] = "btEnemy002";
			 SprID[3] = "btEnemy002";
			 SprID[4] = "btEnemy002";
			 SprID[5] = "btEnemy002";
			 SprID[6] = "btEnemy001";
			 SprID[7] = "btEnemy001";
			 SprID[8] = "btEnemy001";
			 SprID[9] = "btEnemy001";
			 SprID[10] = "btEnemy002";
			 SprID[11] = "btEnemy002";
			 SprID[12] = "btEnemy002";
			 SprID[13] = "btEnemy002";
			 SprID[14] = "btEnemy002";
			 SprID[15] = "btEnemy002";
			 SprID[16] = "btEnemy006";
			 SprID[17] = "btEnemy006";
			 SprID[18] = "btEnemy006";
			 SprID[19] = "btEnemy006";
			 SprID[20] = "btEnemy001";
			 SprID[21] = "btEnemy001";
			 SprID[22] = "btEnemy001";
			 SprID[23] = "btEnemy001";
			 SprID[24] = "btEnemy001";
			 SprID[25] = "btEnemy001";
			 SprID[26] = "btEnemy004";
			 SprID[27] = "btEnemy004";
			 SprID[28] = "btEnemy004";
			 SprID[29] = "btEnemy004";
			 SprID[30] = "btEnemy004";
			 SprID[31] = "btEnemy002";
			 SprID[32] = "btEnemy002";
			 SprID[33] = "btEnemy002";
			 SprID[34] = "btEnemy002";
			 SprID[35] = "btEnemy002";
			 SprID[36] = "btEnemy002";
			 SprID[37] = "btEnemy002";
			 SprID[38] = "btEnemy002";
			 SprID[39] = "btEnemy005";
			 SprID[40] = "btEnemy005";
			 SprID[41] = "btEnemy005";
			 SprID[42] = "btEnemy002";
			 SprID[43] = "btEnemy002";
			 SprID[44] = "btEnemy002";
			 SprID[45] = "btEnemy002";
			 SprID[46] = "btEnemy002";
			 SprID[47] = "btEnemy002";
			 SprID[48] = "btEnemy006";
			 SprID[49] = "btEnemy006";
			 SprID[50] = "btEnemy002";
			 SprID[51] = "btEnemy002";
			 SprID[52] = "btEnemy002";
			 SprID[53] = "btEnemy002";
			 SprID[54] = "btEnemy002";
			 SprID[55] = "btEnemy002";
			 SprID[56] = "btEnemy002";
			 SprID[57] = "btEnemy002";
			 SprID[58] = "btEnemy002";
			 SprID[59] = "btEnemy002";
			 SprID[60] = "btEnemy006";
			 SprID[61] = "btEnemy006";
			 SprID[62] = "btEnemy006";
			 SprID[63] = "btEnemy006";
			 SprID[64] = "btEnemy006";
			 SprID[65] = "btEnemy006";
			 SprID[66] = "btEnemy001";
			 SprID[67] = "btEnemy001";
			 SprID[68] = "btEnemy001";
			 SprID[69] = "btEnemy001";
			 SprID[70] = "btEnemy001";
			 SprID[71] = "btEnemy001";
			 SprID[72] = "btSpr";
			
			
			return SprID;
		}
	

		// World : battleLevel_02
		if(Name.indexOf("battleLevel_02")>=0){
			String[] SprID = new String[83];
			// sprite count : 83
			 SprID[0] = "btEnemy003";
			 SprID[1] = "btEnemy003";
			 SprID[2] = "btEnemy003";
			 SprID[3] = "btEnemy003";
			 SprID[4] = "btEnemy002";
			 SprID[5] = "btEnemy002";
			 SprID[6] = "btEnemy002";
			 SprID[7] = "btEnemy002";
			 SprID[8] = "btEnemy006";
			 SprID[9] = "btEnemy006";
			 SprID[10] = "btEnemy006";
			 SprID[11] = "btEnemy006";
			 SprID[12] = "btEnemy004";
			 SprID[13] = "btEnemy004";
			 SprID[14] = "btEnemy004";
			 SprID[15] = "btEnemy004";
			 SprID[16] = "btEnemy004";
			 SprID[17] = "btEnemy004";
			 SprID[18] = "btEnemy004";
			 SprID[19] = "btEnemy004";
			 SprID[20] = "btEnemy005";
			 SprID[21] = "btEnemy005";
			 SprID[22] = "btEnemy005";
			 SprID[23] = "btEnemy001";
			 SprID[24] = "btEnemy001";
			 SprID[25] = "btEnemy001";
			 SprID[26] = "btEnemy001";
			 SprID[27] = "btEnemy001";
			 SprID[28] = "btEnemy001";
			 SprID[29] = "btEnemy001";
			 SprID[30] = "btEnemy001";
			 SprID[31] = "btEnemy001";
			 SprID[32] = "btEnemy001";
			 SprID[33] = "btEnemy004";
			 SprID[34] = "btEnemy004";
			 SprID[35] = "btEnemy004";
			 SprID[36] = "btEnemy004";
			 SprID[37] = "btEnemy003";
			 SprID[38] = "btEnemy003";
			 SprID[39] = "btEnemy003";
			 SprID[40] = "btEnemy003";
			 SprID[41] = "btEnemy003";
			 SprID[42] = "btEnemy003";
			 SprID[43] = "btEnemy003";
			 SprID[44] = "btEnemy003";
			 SprID[45] = "btEnemy003";
			 SprID[46] = "btEnemy003";
			 SprID[47] = "btEnemy003";
			 SprID[48] = "btEnemy003";
			 SprID[49] = "btEnemy003";
			 SprID[50] = "btEnemy003";
			 SprID[51] = "btEnemy003";
			 SprID[52] = "btEnemy003";
			 SprID[53] = "btEnemy003";
			 SprID[54] = "btEnemy003";
			 SprID[55] = "btEnemy003";
			 SprID[56] = "btEnemy005";
			 SprID[57] = "btEnemy005";
			 SprID[58] = "btEnemy005";
			 SprID[59] = "btEnemy005";
			 SprID[60] = "btEnemy005";
			 SprID[61] = "btEnemy005";
			 SprID[62] = "btEnemy001";
			 SprID[63] = "btEnemy001";
			 SprID[64] = "btEnemy001";
			 SprID[65] = "btEnemy001";
			 SprID[66] = "btEnemy001";
			 SprID[67] = "btEnemy001";
			 SprID[68] = "btEnemy001";
			 SprID[69] = "btEnemy001";
			 SprID[70] = "btEnemy001";
			 SprID[71] = "btEnemy001";
			 SprID[72] = "btEnemy001";
			 SprID[73] = "btEnemy003";
			 SprID[74] = "btEnemy003";
			 SprID[75] = "btEnemy003";
			 SprID[76] = "btEnemy003";
			 SprID[77] = "btEnemy003";
			 SprID[78] = "btEnemy006";
			 SprID[79] = "btEnemy006";
			 SprID[80] = "btEnemy006";
			 SprID[81] = "btEnemy006";
			 SprID[82] = "btSpr";
			
			
			return SprID;
		}
	

		// World : battleLevel_03
		if(Name.indexOf("battleLevel_03")>=0){
			String[] SprID = new String[75];
			// sprite count : 75
			 SprID[0] = "btEnemy004";
			 SprID[1] = "btEnemy004";
			 SprID[2] = "btEnemy004";
			 SprID[3] = "btEnemy004";
			 SprID[4] = "btEnemy004";
			 SprID[5] = "btEnemy004";
			 SprID[6] = "btEnemy002";
			 SprID[7] = "btEnemy002";
			 SprID[8] = "btEnemy002";
			 SprID[9] = "btEnemy002";
			 SprID[10] = "btEnemy002";
			 SprID[11] = "btEnemy002";
			 SprID[12] = "btEnemy002";
			 SprID[13] = "btEnemy002";
			 SprID[14] = "btEnemy002";
			 SprID[15] = "btEnemy002";
			 SprID[16] = "btEnemy001";
			 SprID[17] = "btEnemy001";
			 SprID[18] = "btEnemy001";
			 SprID[19] = "btEnemy001";
			 SprID[20] = "btEnemy001";
			 SprID[21] = "btEnemy001";
			 SprID[22] = "btEnemy001";
			 SprID[23] = "btEnemy001";
			 SprID[24] = "btEnemy005";
			 SprID[25] = "btEnemy006";
			 SprID[26] = "btEnemy005";
			 SprID[27] = "btEnemy005";
			 SprID[28] = "btEnemy005";
			 SprID[29] = "btEnemy005";
			 SprID[30] = "btEnemy005";
			 SprID[31] = "btEnemy006";
			 SprID[32] = "btEnemy001";
			 SprID[33] = "btEnemy001";
			 SprID[34] = "btEnemy001";
			 SprID[35] = "btEnemy001";
			 SprID[36] = "btEnemy003";
			 SprID[37] = "btEnemy003";
			 SprID[38] = "btEnemy003";
			 SprID[39] = "btEnemy003";
			 SprID[40] = "btEnemy003";
			 SprID[41] = "btEnemy003";
			 SprID[42] = "btEnemy003";
			 SprID[43] = "btEnemy003";
			 SprID[44] = "btEnemy003";
			 SprID[45] = "btEnemy003";
			 SprID[46] = "btEnemy003";
			 SprID[47] = "btEnemy003";
			 SprID[48] = "btEnemy002";
			 SprID[49] = "btEnemy002";
			 SprID[50] = "btEnemy002";
			 SprID[51] = "btEnemy002";
			 SprID[52] = "btEnemy002";
			 SprID[53] = "btEnemy002";
			 SprID[54] = "btEnemy004";
			 SprID[55] = "btEnemy004";
			 SprID[56] = "btEnemy004";
			 SprID[57] = "btEnemy004";
			 SprID[58] = "btEnemy004";
			 SprID[59] = "btEnemy004";
			 SprID[60] = "btEnemy004";
			 SprID[61] = "btEnemy004";
			 SprID[62] = "btEnemy004";
			 SprID[63] = "btEnemy004";
			 SprID[64] = "btEnemy004";
			 SprID[65] = "btEnemy004";
			 SprID[66] = "btEnemy004";
			 SprID[67] = "btEnemy004";
			 SprID[68] = "btEnemy003";
			 SprID[69] = "btEnemy003";
			 SprID[70] = "btEnemy003";
			 SprID[71] = "btEnemy003";
			 SprID[72] = "btEnemy003";
			 SprID[73] = "btEnemy003";
			 SprID[74] = "btSpr";
			
			
			return SprID;
		}
	

		// World : battleLevel_04
		if(Name.indexOf("battleLevel_04")>=0){
			String[] SprID = new String[74];
			// sprite count : 74
			 SprID[0] = "btEnemy001";
			 SprID[1] = "btEnemy001";
			 SprID[2] = "btEnemy001";
			 SprID[3] = "btEnemy001";
			 SprID[4] = "btEnemy001";
			 SprID[5] = "btEnemy001";
			 SprID[6] = "btEnemy005";
			 SprID[7] = "btEnemy005";
			 SprID[8] = "btEnemy005";
			 SprID[9] = "btEnemy004";
			 SprID[10] = "btEnemy004";
			 SprID[11] = "btEnemy004";
			 SprID[12] = "btEnemy004";
			 SprID[13] = "btEnemy004";
			 SprID[14] = "btEnemy004";
			 SprID[15] = "btEnemy004";
			 SprID[16] = "btEnemy004";
			 SprID[17] = "btEnemy004";
			 SprID[18] = "btEnemy004";
			 SprID[19] = "btEnemy004";
			 SprID[20] = "btEnemy004";
			 SprID[21] = "btEnemy003";
			 SprID[22] = "btEnemy003";
			 SprID[23] = "btEnemy003";
			 SprID[24] = "btEnemy003";
			 SprID[25] = "btEnemy003";
			 SprID[26] = "btEnemy004";
			 SprID[27] = "btEnemy004";
			 SprID[28] = "btEnemy004";
			 SprID[29] = "btEnemy004";
			 SprID[30] = "btEnemy004";
			 SprID[31] = "btEnemy004";
			 SprID[32] = "btEnemy004";
			 SprID[33] = "btEnemy004";
			 SprID[34] = "btEnemy004";
			 SprID[35] = "btEnemy004";
			 SprID[36] = "btEnemy004";
			 SprID[37] = "btEnemy004";
			 SprID[38] = "btEnemy004";
			 SprID[39] = "btEnemy001";
			 SprID[40] = "btEnemy001";
			 SprID[41] = "btEnemy001";
			 SprID[42] = "btEnemy001";
			 SprID[43] = "btEnemy001";
			 SprID[44] = "btEnemy001";
			 SprID[45] = "btEnemy001";
			 SprID[46] = "btEnemy001";
			 SprID[47] = "btEnemy001";
			 SprID[48] = "btEnemy001";
			 SprID[49] = "btEnemy001";
			 SprID[50] = "btEnemy001";
			 SprID[51] = "btEnemy003";
			 SprID[52] = "btEnemy003";
			 SprID[53] = "btEnemy003";
			 SprID[54] = "btEnemy003";
			 SprID[55] = "btEnemy003";
			 SprID[56] = "btEnemy003";
			 SprID[57] = "btEnemy003";
			 SprID[58] = "btEnemy003";
			 SprID[59] = "btEnemy003";
			 SprID[60] = "btEnemy003";
			 SprID[61] = "btEnemy003";
			 SprID[62] = "btEnemy003";
			 SprID[63] = "btEnemy003";
			 SprID[64] = "btEnemy003";
			 SprID[65] = "btEnemy003";
			 SprID[66] = "btEnemy003";
			 SprID[67] = "btEnemy003";
			 SprID[68] = "btEnemy003";
			 SprID[69] = "btEnemy003";
			 SprID[70] = "btEnemy003";
			 SprID[71] = "btEnemy003";
			 SprID[72] = "btEnemy003";
			 SprID[73] = "btSpr";
			
			
			return SprID;
		}
	

		// World : battleLevel_05
		if(Name.indexOf("battleLevel_05")>=0){
			String[] SprID = new String[59];
			// sprite count : 59
			 SprID[0] = "btEnemy003";
			 SprID[1] = "btEnemy003";
			 SprID[2] = "btEnemy003";
			 SprID[3] = "btEnemy003";
			 SprID[4] = "btEnemy003";
			 SprID[5] = "btEnemy003";
			 SprID[6] = "btEnemy003";
			 SprID[7] = "btEnemy003";
			 SprID[8] = "btEnemy003";
			 SprID[9] = "btEnemy003";
			 SprID[10] = "btEnemy003";
			 SprID[11] = "btEnemy003";
			 SprID[12] = "btEnemy003";
			 SprID[13] = "btEnemy003";
			 SprID[14] = "btEnemy003";
			 SprID[15] = "btEnemy003";
			 SprID[16] = "btEnemy003";
			 SprID[17] = "btEnemy003";
			 SprID[18] = "btEnemy003";
			 SprID[19] = "btEnemy003";
			 SprID[20] = "btEnemy003";
			 SprID[21] = "btEnemy003";
			 SprID[22] = "btEnemy003";
			 SprID[23] = "btEnemy003";
			 SprID[24] = "btEnemy003";
			 SprID[25] = "btEnemy003";
			 SprID[26] = "btEnemy003";
			 SprID[27] = "btEnemy003";
			 SprID[28] = "btEnemy003";
			 SprID[29] = "btEnemy003";
			 SprID[30] = "btEnemy003";
			 SprID[31] = "btEnemy003";
			 SprID[32] = "btEnemy003";
			 SprID[33] = "btEnemy003";
			 SprID[34] = "btEnemy003";
			 SprID[35] = "btEnemy003";
			 SprID[36] = "btEnemy003";
			 SprID[37] = "btEnemy003";
			 SprID[38] = "btEnemy003";
			 SprID[39] = "btEnemy003";
			 SprID[40] = "btEnemy003";
			 SprID[41] = "btEnemy003";
			 SprID[42] = "btEnemy003";
			 SprID[43] = "btEnemy003";
			 SprID[44] = "btEnemy003";
			 SprID[45] = "btEnemy003";
			 SprID[46] = "btEnemy003";
			 SprID[47] = "btEnemy003";
			 SprID[48] = "btEnemy003";
			 SprID[49] = "btEnemy003";
			 SprID[50] = "btEnemy003";
			 SprID[51] = "btEnemy003";
			 SprID[52] = "btEnemy003";
			 SprID[53] = "btEnemy003";
			 SprID[54] = "btEnemy003";
			 SprID[55] = "btEnemy003";
			 SprID[56] = "btEnemy003";
			 SprID[57] = "btEnemy003";
			 SprID[58] = "btSpr";
			
			
			return SprID;
		}
	

		// World : battleLevel_06
		if(Name.indexOf("battleLevel_06")>=0){
			String[] SprID = new String[64];
			// sprite count : 64
			 SprID[0] = "btEnemy006";
			 SprID[1] = "btEnemy006";
			 SprID[2] = "btEnemy006";
			 SprID[3] = "btEnemy006";
			 SprID[4] = "btEnemy006";
			 SprID[5] = "btEnemy006";
			 SprID[6] = "btEnemy006";
			 SprID[7] = "btEnemy006";
			 SprID[8] = "btEnemy006";
			 SprID[9] = "btEnemy006";
			 SprID[10] = "btEnemy006";
			 SprID[11] = "btEnemy006";
			 SprID[12] = "btEnemy006";
			 SprID[13] = "btEnemy006";
			 SprID[14] = "btEnemy006";
			 SprID[15] = "btEnemy006";
			 SprID[16] = "btEnemy006";
			 SprID[17] = "btEnemy006";
			 SprID[18] = "btEnemy006";
			 SprID[19] = "btEnemy006";
			 SprID[20] = "btEnemy006";
			 SprID[21] = "btEnemy006";
			 SprID[22] = "btEnemy006";
			 SprID[23] = "btEnemy006";
			 SprID[24] = "btEnemy006";
			 SprID[25] = "btEnemy006";
			 SprID[26] = "btEnemy006";
			 SprID[27] = "btEnemy006";
			 SprID[28] = "btEnemy006";
			 SprID[29] = "btEnemy006";
			 SprID[30] = "btEnemy006";
			 SprID[31] = "btEnemy006";
			 SprID[32] = "btEnemy006";
			 SprID[33] = "btEnemy006";
			 SprID[34] = "btEnemy006";
			 SprID[35] = "btEnemy006";
			 SprID[36] = "btEnemy006";
			 SprID[37] = "btEnemy006";
			 SprID[38] = "btEnemy006";
			 SprID[39] = "btEnemy006";
			 SprID[40] = "btEnemy006";
			 SprID[41] = "btEnemy006";
			 SprID[42] = "btEnemy006";
			 SprID[43] = "btEnemy006";
			 SprID[44] = "btEnemy006";
			 SprID[45] = "btEnemy006";
			 SprID[46] = "btEnemy006";
			 SprID[47] = "btEnemy001";
			 SprID[48] = "btEnemy001";
			 SprID[49] = "btEnemy001";
			 SprID[50] = "btEnemy001";
			 SprID[51] = "btEnemy001";
			 SprID[52] = "btEnemy001";
			 SprID[53] = "btEnemy001";
			 SprID[54] = "btEnemy001";
			 SprID[55] = "btEnemy001";
			 SprID[56] = "btEnemy001";
			 SprID[57] = "btEnemy001";
			 SprID[58] = "btEnemy001";
			 SprID[59] = "btEnemy001";
			 SprID[60] = "btEnemy001";
			 SprID[61] = "btEnemy001";
			 SprID[62] = "btEnemy001";
			 SprID[63] = "btSpr";
			
			
			return SprID;
		}
	

		// World : bossLevel_01
		if(Name.indexOf("bossLevel_01")>=0){
			String[] SprID = new String[22];
			// sprite count : 22
			 SprID[0] = "boss2";
			 SprID[1] = "btEnemy003";
			 SprID[2] = "btEnemy003";
			 SprID[3] = "btEnemy003";
			 SprID[4] = "btEnemy003";
			 SprID[5] = "btEnemy003";
			 SprID[6] = "btEnemy001";
			 SprID[7] = "btEnemy001";
			 SprID[8] = "btEnemy001";
			 SprID[9] = "btEnemy001";
			 SprID[10] = "btEnemy001";
			 SprID[11] = "btEnemy001";
			 SprID[12] = "btEnemy001";
			 SprID[13] = "btEnemy005";
			 SprID[14] = "btEnemy005";
			 SprID[15] = "btEnemy005";
			 SprID[16] = "btEnemy005";
			 SprID[17] = "btEnemy005";
			 SprID[18] = "btEnemy005";
			 SprID[19] = "btEnemy005";
			 SprID[20] = "btEnemy005";
			 SprID[21] = "btSpr";
			
			
			return SprID;
		}
	

		// World : bossLevel_02
		if(Name.indexOf("bossLevel_02")>=0){
			String[] SprID = new String[48];
			// sprite count : 48
			 SprID[0] = "boss1";
			 SprID[1] = "btEnemy003";
			 SprID[2] = "btEnemy003";
			 SprID[3] = "btEnemy003";
			 SprID[4] = "btEnemy001";
			 SprID[5] = "btEnemy001";
			 SprID[6] = "btEnemy001";
			 SprID[7] = "btEnemy001";
			 SprID[8] = "btEnemy001";
			 SprID[9] = "btEnemy001";
			 SprID[10] = "btEnemy001";
			 SprID[11] = "btEnemy001";
			 SprID[12] = "btEnemy001";
			 SprID[13] = "btEnemy001";
			 SprID[14] = "btEnemy006";
			 SprID[15] = "btEnemy006";
			 SprID[16] = "btEnemy006";
			 SprID[17] = "btEnemy006";
			 SprID[18] = "btEnemy006";
			 SprID[19] = "btEnemy006";
			 SprID[20] = "btEnemy006";
			 SprID[21] = "btEnemy001";
			 SprID[22] = "btEnemy001";
			 SprID[23] = "btEnemy001";
			 SprID[24] = "btEnemy001";
			 SprID[25] = "btEnemy001";
			 SprID[26] = "btEnemy002";
			 SprID[27] = "btEnemy002";
			 SprID[28] = "btEnemy002";
			 SprID[29] = "btEnemy002";
			 SprID[30] = "btEnemy002";
			 SprID[31] = "btEnemy002";
			 SprID[32] = "btEnemy002";
			 SprID[33] = "btEnemy002";
			 SprID[34] = "btEnemy002";
			 SprID[35] = "btEnemy002";
			 SprID[36] = "btEnemy003";
			 SprID[37] = "btEnemy003";
			 SprID[38] = "btEnemy003";
			 SprID[39] = "btEnemy003";
			 SprID[40] = "btEnemy003";
			 SprID[41] = "btEnemy003";
			 SprID[42] = "btEnemy003";
			 SprID[43] = "btEnemy003";
			 SprID[44] = "btEnemy003";
			 SprID[45] = "btEnemy003";
			 SprID[46] = "btEnemy003";
			 SprID[47] = "btSpr";
			
			
			return SprID;
		}
	

		// World : bossLevel_03
		if(Name.indexOf("bossLevel_03")>=0){
			String[] SprID = new String[55];
			// sprite count : 55
			 SprID[0] = "boss3";
			 SprID[1] = "boss3";
			 SprID[2] = "boss3";
			 SprID[3] = "btEnemy001";
			 SprID[4] = "btEnemy001";
			 SprID[5] = "btEnemy001";
			 SprID[6] = "btEnemy001";
			 SprID[7] = "btEnemy001";
			 SprID[8] = "btEnemy001";
			 SprID[9] = "btEnemy001";
			 SprID[10] = "btEnemy001";
			 SprID[11] = "btEnemy001";
			 SprID[12] = "btEnemy001";
			 SprID[13] = "btEnemy001";
			 SprID[14] = "btEnemy001";
			 SprID[15] = "btEnemy001";
			 SprID[16] = "btEnemy001";
			 SprID[17] = "btEnemy004";
			 SprID[18] = "btEnemy004";
			 SprID[19] = "btEnemy004";
			 SprID[20] = "btEnemy004";
			 SprID[21] = "btEnemy004";
			 SprID[22] = "btEnemy004";
			 SprID[23] = "btEnemy004";
			 SprID[24] = "btEnemy004";
			 SprID[25] = "btEnemy003";
			 SprID[26] = "btEnemy003";
			 SprID[27] = "btEnemy003";
			 SprID[28] = "btEnemy003";
			 SprID[29] = "btEnemy003";
			 SprID[30] = "btEnemy003";
			 SprID[31] = "btEnemy003";
			 SprID[32] = "btEnemy003";
			 SprID[33] = "btEnemy003";
			 SprID[34] = "btEnemy003";
			 SprID[35] = "btEnemy003";
			 SprID[36] = "btEnemy003";
			 SprID[37] = "btEnemy003";
			 SprID[38] = "btEnemy003";
			 SprID[39] = "btEnemy003";
			 SprID[40] = "btEnemy003";
			 SprID[41] = "btEnemy003";
			 SprID[42] = "btEnemy003";
			 SprID[43] = "btEnemy001";
			 SprID[44] = "btEnemy001";
			 SprID[45] = "btEnemy001";
			 SprID[46] = "btEnemy001";
			 SprID[47] = "btEnemy001";
			 SprID[48] = "btEnemy001";
			 SprID[49] = "btEnemy006";
			 SprID[50] = "btEnemy006";
			 SprID[51] = "btEnemy006";
			 SprID[52] = "btEnemy006";
			 SprID[53] = "btEnemy006";
			 SprID[54] = "btSpr";
			
			
			return SprID;
		}
	

		// World : bossLevel_04
		if(Name.indexOf("bossLevel_04")>=0){
			String[] SprID = new String[48];
			// sprite count : 48
			 SprID[0] = "btEnemy003";
			 SprID[1] = "btEnemy003";
			 SprID[2] = "btEnemy003";
			 SprID[3] = "btEnemy003";
			 SprID[4] = "btEnemy003";
			 SprID[5] = "btEnemy003";
			 SprID[6] = "btEnemy003";
			 SprID[7] = "btEnemy003";
			 SprID[8] = "btEnemy003";
			 SprID[9] = "btEnemy002";
			 SprID[10] = "btEnemy002";
			 SprID[11] = "btEnemy002";
			 SprID[12] = "btEnemy002";
			 SprID[13] = "btEnemy002";
			 SprID[14] = "btEnemy002";
			 SprID[15] = "btEnemy002";
			 SprID[16] = "btEnemy002";
			 SprID[17] = "btEnemy002";
			 SprID[18] = "btEnemy002";
			 SprID[19] = "btEnemy002";
			 SprID[20] = "btEnemy002";
			 SprID[21] = "btEnemy006";
			 SprID[22] = "btEnemy006";
			 SprID[23] = "btEnemy006";
			 SprID[24] = "btEnemy006";
			 SprID[25] = "btEnemy006";
			 SprID[26] = "btEnemy006";
			 SprID[27] = "btEnemy006";
			 SprID[28] = "btEnemy006";
			 SprID[29] = "btEnemy006";
			 SprID[30] = "btEnemy006";
			 SprID[31] = "btEnemy006";
			 SprID[32] = "btEnemy006";
			 SprID[33] = "btEnemy006";
			 SprID[34] = "btEnemy006";
			 SprID[35] = "btEnemy001";
			 SprID[36] = "btEnemy001";
			 SprID[37] = "btEnemy001";
			 SprID[38] = "btEnemy001";
			 SprID[39] = "btEnemy001";
			 SprID[40] = "btEnemy001";
			 SprID[41] = "btEnemy001";
			 SprID[42] = "btEnemy001";
			 SprID[43] = "btEnemy001";
			 SprID[44] = "btEnemy001";
			 SprID[45] = "btEnemy001";
			 SprID[46] = "boss4";
			 SprID[47] = "btSpr";
			
			
			return SprID;
		}
	

		// World : bossLevel_05
		if(Name.indexOf("bossLevel_05")>=0){
			String[] SprID = new String[32];
			// sprite count : 32
			 SprID[0] = "boss5";
			 SprID[1] = "btEnemy004";
			 SprID[2] = "btEnemy004";
			 SprID[3] = "btEnemy004";
			 SprID[4] = "btEnemy004";
			 SprID[5] = "btEnemy004";
			 SprID[6] = "btEnemy004";
			 SprID[7] = "btEnemy004";
			 SprID[8] = "btEnemy004";
			 SprID[9] = "btEnemy004";
			 SprID[10] = "btEnemy004";
			 SprID[11] = "btEnemy004";
			 SprID[12] = "btEnemy004";
			 SprID[13] = "btEnemy004";
			 SprID[14] = "btEnemy004";
			 SprID[15] = "btEnemy004";
			 SprID[16] = "btEnemy004";
			 SprID[17] = "btEnemy004";
			 SprID[18] = "btEnemy004";
			 SprID[19] = "btEnemy004";
			 SprID[20] = "btEnemy004";
			 SprID[21] = "btEnemy004";
			 SprID[22] = "btEnemy004";
			 SprID[23] = "btEnemy004";
			 SprID[24] = "btEnemy004";
			 SprID[25] = "btEnemy004";
			 SprID[26] = "btEnemy004";
			 SprID[27] = "btEnemy004";
			 SprID[28] = "btEnemy004";
			 SprID[29] = "btEnemy004";
			 SprID[30] = "btEnemy004";
			 SprID[31] = "btSpr";
			
			
			return SprID;
		}
	

		return null;
	}
	
	final static public int[] getWorldSprAnim(String Name){
	
		// World : battleLevel_00
		if(Name.indexOf("battleLevel_00")>=0){
			int[] SprAnim = new int[51];
			// sprite count : 51
			 SprAnim[0] = 0 ;
			 SprAnim[1] = 0 ;
			 SprAnim[2] = 0 ;
			 SprAnim[3] = 0 ;
			 SprAnim[4] = 0 ;
			 SprAnim[5] = 0 ;
			 SprAnim[6] = 0 ;
			 SprAnim[7] = 0 ;
			 SprAnim[8] = 0 ;
			 SprAnim[9] = 0 ;
			 SprAnim[10] = 0 ;
			 SprAnim[11] = 0 ;
			 SprAnim[12] = 0 ;
			 SprAnim[13] = 0 ;
			 SprAnim[14] = 0 ;
			 SprAnim[15] = 0 ;
			 SprAnim[16] = 0 ;
			 SprAnim[17] = 0 ;
			 SprAnim[18] = 0 ;
			 SprAnim[19] = 0 ;
			 SprAnim[20] = 0 ;
			 SprAnim[21] = 0 ;
			 SprAnim[22] = 0 ;
			 SprAnim[23] = 0 ;
			 SprAnim[24] = 0 ;
			 SprAnim[25] = 0 ;
			 SprAnim[26] = 0 ;
			 SprAnim[27] = 0 ;
			 SprAnim[28] = 0 ;
			 SprAnim[29] = 0 ;
			 SprAnim[30] = 0 ;
			 SprAnim[31] = 0 ;
			 SprAnim[32] = 0 ;
			 SprAnim[33] = 0 ;
			 SprAnim[34] = 0 ;
			 SprAnim[35] = 0 ;
			 SprAnim[36] = 0 ;
			 SprAnim[37] = 0 ;
			 SprAnim[38] = 0 ;
			 SprAnim[39] = 0 ;
			 SprAnim[40] = 0 ;
			 SprAnim[41] = 0 ;
			 SprAnim[42] = 0 ;
			 SprAnim[43] = 0 ;
			 SprAnim[44] = 0 ;
			 SprAnim[45] = 0 ;
			 SprAnim[46] = 0 ;
			 SprAnim[47] = 0 ;
			 SprAnim[48] = 0 ;
			 SprAnim[49] = 0 ;
			 SprAnim[50] = 0 ;
			
			
			return SprAnim;
		}
	

		// World : battleLevel_01
		if(Name.indexOf("battleLevel_01")>=0){
			int[] SprAnim = new int[73];
			// sprite count : 73
			 SprAnim[0] = 0 ;
			 SprAnim[1] = 0 ;
			 SprAnim[2] = 0 ;
			 SprAnim[3] = 0 ;
			 SprAnim[4] = 0 ;
			 SprAnim[5] = 0 ;
			 SprAnim[6] = 0 ;
			 SprAnim[7] = 0 ;
			 SprAnim[8] = 0 ;
			 SprAnim[9] = 0 ;
			 SprAnim[10] = 0 ;
			 SprAnim[11] = 0 ;
			 SprAnim[12] = 0 ;
			 SprAnim[13] = 0 ;
			 SprAnim[14] = 0 ;
			 SprAnim[15] = 0 ;
			 SprAnim[16] = 0 ;
			 SprAnim[17] = 0 ;
			 SprAnim[18] = 0 ;
			 SprAnim[19] = 0 ;
			 SprAnim[20] = 0 ;
			 SprAnim[21] = 0 ;
			 SprAnim[22] = 0 ;
			 SprAnim[23] = 0 ;
			 SprAnim[24] = 0 ;
			 SprAnim[25] = 0 ;
			 SprAnim[26] = 0 ;
			 SprAnim[27] = 0 ;
			 SprAnim[28] = 0 ;
			 SprAnim[29] = 0 ;
			 SprAnim[30] = 0 ;
			 SprAnim[31] = 0 ;
			 SprAnim[32] = 0 ;
			 SprAnim[33] = 0 ;
			 SprAnim[34] = 0 ;
			 SprAnim[35] = 0 ;
			 SprAnim[36] = 0 ;
			 SprAnim[37] = 0 ;
			 SprAnim[38] = 0 ;
			 SprAnim[39] = 0 ;
			 SprAnim[40] = 0 ;
			 SprAnim[41] = 0 ;
			 SprAnim[42] = 0 ;
			 SprAnim[43] = 0 ;
			 SprAnim[44] = 0 ;
			 SprAnim[45] = 0 ;
			 SprAnim[46] = 0 ;
			 SprAnim[47] = 0 ;
			 SprAnim[48] = 0 ;
			 SprAnim[49] = 0 ;
			 SprAnim[50] = 0 ;
			 SprAnim[51] = 0 ;
			 SprAnim[52] = 0 ;
			 SprAnim[53] = 0 ;
			 SprAnim[54] = 0 ;
			 SprAnim[55] = 0 ;
			 SprAnim[56] = 0 ;
			 SprAnim[57] = 0 ;
			 SprAnim[58] = 0 ;
			 SprAnim[59] = 0 ;
			 SprAnim[60] = 0 ;
			 SprAnim[61] = 0 ;
			 SprAnim[62] = 0 ;
			 SprAnim[63] = 0 ;
			 SprAnim[64] = 0 ;
			 SprAnim[65] = 0 ;
			 SprAnim[66] = 0 ;
			 SprAnim[67] = 0 ;
			 SprAnim[68] = 0 ;
			 SprAnim[69] = 0 ;
			 SprAnim[70] = 0 ;
			 SprAnim[71] = 0 ;
			 SprAnim[72] = 0 ;
			
			
			return SprAnim;
		}
	

		// World : battleLevel_02
		if(Name.indexOf("battleLevel_02")>=0){
			int[] SprAnim = new int[83];
			// sprite count : 83
			 SprAnim[0] = 0 ;
			 SprAnim[1] = 0 ;
			 SprAnim[2] = 0 ;
			 SprAnim[3] = 0 ;
			 SprAnim[4] = 0 ;
			 SprAnim[5] = 0 ;
			 SprAnim[6] = 0 ;
			 SprAnim[7] = 0 ;
			 SprAnim[8] = 0 ;
			 SprAnim[9] = 0 ;
			 SprAnim[10] = 0 ;
			 SprAnim[11] = 0 ;
			 SprAnim[12] = 0 ;
			 SprAnim[13] = 0 ;
			 SprAnim[14] = 0 ;
			 SprAnim[15] = 0 ;
			 SprAnim[16] = 0 ;
			 SprAnim[17] = 0 ;
			 SprAnim[18] = 0 ;
			 SprAnim[19] = 0 ;
			 SprAnim[20] = 0 ;
			 SprAnim[21] = 0 ;
			 SprAnim[22] = 0 ;
			 SprAnim[23] = 0 ;
			 SprAnim[24] = 0 ;
			 SprAnim[25] = 0 ;
			 SprAnim[26] = 0 ;
			 SprAnim[27] = 0 ;
			 SprAnim[28] = 0 ;
			 SprAnim[29] = 0 ;
			 SprAnim[30] = 0 ;
			 SprAnim[31] = 0 ;
			 SprAnim[32] = 0 ;
			 SprAnim[33] = 0 ;
			 SprAnim[34] = 0 ;
			 SprAnim[35] = 0 ;
			 SprAnim[36] = 0 ;
			 SprAnim[37] = 0 ;
			 SprAnim[38] = 0 ;
			 SprAnim[39] = 0 ;
			 SprAnim[40] = 0 ;
			 SprAnim[41] = 0 ;
			 SprAnim[42] = 0 ;
			 SprAnim[43] = 0 ;
			 SprAnim[44] = 0 ;
			 SprAnim[45] = 0 ;
			 SprAnim[46] = 0 ;
			 SprAnim[47] = 0 ;
			 SprAnim[48] = 0 ;
			 SprAnim[49] = 0 ;
			 SprAnim[50] = 0 ;
			 SprAnim[51] = 0 ;
			 SprAnim[52] = 0 ;
			 SprAnim[53] = 0 ;
			 SprAnim[54] = 0 ;
			 SprAnim[55] = 0 ;
			 SprAnim[56] = 0 ;
			 SprAnim[57] = 0 ;
			 SprAnim[58] = 0 ;
			 SprAnim[59] = 0 ;
			 SprAnim[60] = 0 ;
			 SprAnim[61] = 0 ;
			 SprAnim[62] = 0 ;
			 SprAnim[63] = 0 ;
			 SprAnim[64] = 0 ;
			 SprAnim[65] = 0 ;
			 SprAnim[66] = 0 ;
			 SprAnim[67] = 0 ;
			 SprAnim[68] = 0 ;
			 SprAnim[69] = 0 ;
			 SprAnim[70] = 0 ;
			 SprAnim[71] = 0 ;
			 SprAnim[72] = 0 ;
			 SprAnim[73] = 0 ;
			 SprAnim[74] = 0 ;
			 SprAnim[75] = 0 ;
			 SprAnim[76] = 0 ;
			 SprAnim[77] = 0 ;
			 SprAnim[78] = 0 ;
			 SprAnim[79] = 0 ;
			 SprAnim[80] = 0 ;
			 SprAnim[81] = 0 ;
			 SprAnim[82] = 0 ;
			
			
			return SprAnim;
		}
	

		// World : battleLevel_03
		if(Name.indexOf("battleLevel_03")>=0){
			int[] SprAnim = new int[75];
			// sprite count : 75
			 SprAnim[0] = 0 ;
			 SprAnim[1] = 0 ;
			 SprAnim[2] = 0 ;
			 SprAnim[3] = 0 ;
			 SprAnim[4] = 0 ;
			 SprAnim[5] = 0 ;
			 SprAnim[6] = 0 ;
			 SprAnim[7] = 0 ;
			 SprAnim[8] = 0 ;
			 SprAnim[9] = 0 ;
			 SprAnim[10] = 0 ;
			 SprAnim[11] = 0 ;
			 SprAnim[12] = 0 ;
			 SprAnim[13] = 0 ;
			 SprAnim[14] = 0 ;
			 SprAnim[15] = 0 ;
			 SprAnim[16] = 0 ;
			 SprAnim[17] = 0 ;
			 SprAnim[18] = 0 ;
			 SprAnim[19] = 0 ;
			 SprAnim[20] = 0 ;
			 SprAnim[21] = 0 ;
			 SprAnim[22] = 0 ;
			 SprAnim[23] = 0 ;
			 SprAnim[24] = 0 ;
			 SprAnim[25] = 0 ;
			 SprAnim[26] = 0 ;
			 SprAnim[27] = 0 ;
			 SprAnim[28] = 0 ;
			 SprAnim[29] = 0 ;
			 SprAnim[30] = 0 ;
			 SprAnim[31] = 0 ;
			 SprAnim[32] = 0 ;
			 SprAnim[33] = 0 ;
			 SprAnim[34] = 0 ;
			 SprAnim[35] = 0 ;
			 SprAnim[36] = 0 ;
			 SprAnim[37] = 0 ;
			 SprAnim[38] = 0 ;
			 SprAnim[39] = 0 ;
			 SprAnim[40] = 0 ;
			 SprAnim[41] = 0 ;
			 SprAnim[42] = 0 ;
			 SprAnim[43] = 0 ;
			 SprAnim[44] = 0 ;
			 SprAnim[45] = 0 ;
			 SprAnim[46] = 0 ;
			 SprAnim[47] = 0 ;
			 SprAnim[48] = 0 ;
			 SprAnim[49] = 0 ;
			 SprAnim[50] = 0 ;
			 SprAnim[51] = 0 ;
			 SprAnim[52] = 0 ;
			 SprAnim[53] = 0 ;
			 SprAnim[54] = 0 ;
			 SprAnim[55] = 0 ;
			 SprAnim[56] = 0 ;
			 SprAnim[57] = 0 ;
			 SprAnim[58] = 0 ;
			 SprAnim[59] = 0 ;
			 SprAnim[60] = 0 ;
			 SprAnim[61] = 0 ;
			 SprAnim[62] = 0 ;
			 SprAnim[63] = 0 ;
			 SprAnim[64] = 0 ;
			 SprAnim[65] = 0 ;
			 SprAnim[66] = 0 ;
			 SprAnim[67] = 0 ;
			 SprAnim[68] = 0 ;
			 SprAnim[69] = 0 ;
			 SprAnim[70] = 0 ;
			 SprAnim[71] = 0 ;
			 SprAnim[72] = 0 ;
			 SprAnim[73] = 0 ;
			 SprAnim[74] = 0 ;
			
			
			return SprAnim;
		}
	

		// World : battleLevel_04
		if(Name.indexOf("battleLevel_04")>=0){
			int[] SprAnim = new int[74];
			// sprite count : 74
			 SprAnim[0] = 0 ;
			 SprAnim[1] = 0 ;
			 SprAnim[2] = 0 ;
			 SprAnim[3] = 0 ;
			 SprAnim[4] = 0 ;
			 SprAnim[5] = 0 ;
			 SprAnim[6] = 0 ;
			 SprAnim[7] = 0 ;
			 SprAnim[8] = 0 ;
			 SprAnim[9] = 0 ;
			 SprAnim[10] = 0 ;
			 SprAnim[11] = 0 ;
			 SprAnim[12] = 0 ;
			 SprAnim[13] = 0 ;
			 SprAnim[14] = 0 ;
			 SprAnim[15] = 0 ;
			 SprAnim[16] = 0 ;
			 SprAnim[17] = 0 ;
			 SprAnim[18] = 0 ;
			 SprAnim[19] = 0 ;
			 SprAnim[20] = 0 ;
			 SprAnim[21] = 0 ;
			 SprAnim[22] = 0 ;
			 SprAnim[23] = 0 ;
			 SprAnim[24] = 0 ;
			 SprAnim[25] = 0 ;
			 SprAnim[26] = 0 ;
			 SprAnim[27] = 0 ;
			 SprAnim[28] = 0 ;
			 SprAnim[29] = 0 ;
			 SprAnim[30] = 0 ;
			 SprAnim[31] = 0 ;
			 SprAnim[32] = 0 ;
			 SprAnim[33] = 0 ;
			 SprAnim[34] = 0 ;
			 SprAnim[35] = 0 ;
			 SprAnim[36] = 0 ;
			 SprAnim[37] = 0 ;
			 SprAnim[38] = 0 ;
			 SprAnim[39] = 0 ;
			 SprAnim[40] = 0 ;
			 SprAnim[41] = 0 ;
			 SprAnim[42] = 0 ;
			 SprAnim[43] = 0 ;
			 SprAnim[44] = 0 ;
			 SprAnim[45] = 0 ;
			 SprAnim[46] = 0 ;
			 SprAnim[47] = 0 ;
			 SprAnim[48] = 0 ;
			 SprAnim[49] = 0 ;
			 SprAnim[50] = 0 ;
			 SprAnim[51] = 0 ;
			 SprAnim[52] = 0 ;
			 SprAnim[53] = 0 ;
			 SprAnim[54] = 0 ;
			 SprAnim[55] = 0 ;
			 SprAnim[56] = 0 ;
			 SprAnim[57] = 0 ;
			 SprAnim[58] = 0 ;
			 SprAnim[59] = 0 ;
			 SprAnim[60] = 0 ;
			 SprAnim[61] = 0 ;
			 SprAnim[62] = 0 ;
			 SprAnim[63] = 0 ;
			 SprAnim[64] = 0 ;
			 SprAnim[65] = 0 ;
			 SprAnim[66] = 0 ;
			 SprAnim[67] = 0 ;
			 SprAnim[68] = 0 ;
			 SprAnim[69] = 0 ;
			 SprAnim[70] = 0 ;
			 SprAnim[71] = 0 ;
			 SprAnim[72] = 0 ;
			 SprAnim[73] = 0 ;
			
			
			return SprAnim;
		}
	

		// World : battleLevel_05
		if(Name.indexOf("battleLevel_05")>=0){
			int[] SprAnim = new int[59];
			// sprite count : 59
			 SprAnim[0] = 0 ;
			 SprAnim[1] = 0 ;
			 SprAnim[2] = 0 ;
			 SprAnim[3] = 0 ;
			 SprAnim[4] = 0 ;
			 SprAnim[5] = 0 ;
			 SprAnim[6] = 0 ;
			 SprAnim[7] = 0 ;
			 SprAnim[8] = 0 ;
			 SprAnim[9] = 0 ;
			 SprAnim[10] = 0 ;
			 SprAnim[11] = 0 ;
			 SprAnim[12] = 0 ;
			 SprAnim[13] = 0 ;
			 SprAnim[14] = 0 ;
			 SprAnim[15] = 0 ;
			 SprAnim[16] = 0 ;
			 SprAnim[17] = 0 ;
			 SprAnim[18] = 0 ;
			 SprAnim[19] = 0 ;
			 SprAnim[20] = 0 ;
			 SprAnim[21] = 0 ;
			 SprAnim[22] = 0 ;
			 SprAnim[23] = 0 ;
			 SprAnim[24] = 0 ;
			 SprAnim[25] = 0 ;
			 SprAnim[26] = 0 ;
			 SprAnim[27] = 0 ;
			 SprAnim[28] = 0 ;
			 SprAnim[29] = 0 ;
			 SprAnim[30] = 0 ;
			 SprAnim[31] = 0 ;
			 SprAnim[32] = 0 ;
			 SprAnim[33] = 0 ;
			 SprAnim[34] = 0 ;
			 SprAnim[35] = 0 ;
			 SprAnim[36] = 0 ;
			 SprAnim[37] = 0 ;
			 SprAnim[38] = 0 ;
			 SprAnim[39] = 0 ;
			 SprAnim[40] = 0 ;
			 SprAnim[41] = 0 ;
			 SprAnim[42] = 0 ;
			 SprAnim[43] = 0 ;
			 SprAnim[44] = 0 ;
			 SprAnim[45] = 0 ;
			 SprAnim[46] = 0 ;
			 SprAnim[47] = 0 ;
			 SprAnim[48] = 0 ;
			 SprAnim[49] = 0 ;
			 SprAnim[50] = 0 ;
			 SprAnim[51] = 0 ;
			 SprAnim[52] = 0 ;
			 SprAnim[53] = 0 ;
			 SprAnim[54] = 0 ;
			 SprAnim[55] = 0 ;
			 SprAnim[56] = 0 ;
			 SprAnim[57] = 0 ;
			 SprAnim[58] = 0 ;
			
			
			return SprAnim;
		}
	

		// World : battleLevel_06
		if(Name.indexOf("battleLevel_06")>=0){
			int[] SprAnim = new int[64];
			// sprite count : 64
			 SprAnim[0] = 0 ;
			 SprAnim[1] = 0 ;
			 SprAnim[2] = 0 ;
			 SprAnim[3] = 0 ;
			 SprAnim[4] = 0 ;
			 SprAnim[5] = 0 ;
			 SprAnim[6] = 0 ;
			 SprAnim[7] = 0 ;
			 SprAnim[8] = 0 ;
			 SprAnim[9] = 0 ;
			 SprAnim[10] = 0 ;
			 SprAnim[11] = 0 ;
			 SprAnim[12] = 0 ;
			 SprAnim[13] = 0 ;
			 SprAnim[14] = 0 ;
			 SprAnim[15] = 0 ;
			 SprAnim[16] = 0 ;
			 SprAnim[17] = 0 ;
			 SprAnim[18] = 0 ;
			 SprAnim[19] = 0 ;
			 SprAnim[20] = 0 ;
			 SprAnim[21] = 0 ;
			 SprAnim[22] = 0 ;
			 SprAnim[23] = 0 ;
			 SprAnim[24] = 0 ;
			 SprAnim[25] = 0 ;
			 SprAnim[26] = 0 ;
			 SprAnim[27] = 0 ;
			 SprAnim[28] = 0 ;
			 SprAnim[29] = 0 ;
			 SprAnim[30] = 0 ;
			 SprAnim[31] = 0 ;
			 SprAnim[32] = 0 ;
			 SprAnim[33] = 0 ;
			 SprAnim[34] = 0 ;
			 SprAnim[35] = 0 ;
			 SprAnim[36] = 0 ;
			 SprAnim[37] = 0 ;
			 SprAnim[38] = 0 ;
			 SprAnim[39] = 0 ;
			 SprAnim[40] = 0 ;
			 SprAnim[41] = 0 ;
			 SprAnim[42] = 0 ;
			 SprAnim[43] = 0 ;
			 SprAnim[44] = 0 ;
			 SprAnim[45] = 0 ;
			 SprAnim[46] = 0 ;
			 SprAnim[47] = 0 ;
			 SprAnim[48] = 0 ;
			 SprAnim[49] = 0 ;
			 SprAnim[50] = 0 ;
			 SprAnim[51] = 0 ;
			 SprAnim[52] = 0 ;
			 SprAnim[53] = 0 ;
			 SprAnim[54] = 0 ;
			 SprAnim[55] = 0 ;
			 SprAnim[56] = 0 ;
			 SprAnim[57] = 0 ;
			 SprAnim[58] = 0 ;
			 SprAnim[59] = 0 ;
			 SprAnim[60] = 0 ;
			 SprAnim[61] = 0 ;
			 SprAnim[62] = 0 ;
			 SprAnim[63] = 0 ;
			
			
			return SprAnim;
		}
	

		// World : bossLevel_01
		if(Name.indexOf("bossLevel_01")>=0){
			int[] SprAnim = new int[22];
			// sprite count : 22
			 SprAnim[0] = 0 ;
			 SprAnim[1] = 0 ;
			 SprAnim[2] = 0 ;
			 SprAnim[3] = 0 ;
			 SprAnim[4] = 0 ;
			 SprAnim[5] = 0 ;
			 SprAnim[6] = 0 ;
			 SprAnim[7] = 0 ;
			 SprAnim[8] = 0 ;
			 SprAnim[9] = 0 ;
			 SprAnim[10] = 0 ;
			 SprAnim[11] = 0 ;
			 SprAnim[12] = 0 ;
			 SprAnim[13] = 0 ;
			 SprAnim[14] = 0 ;
			 SprAnim[15] = 0 ;
			 SprAnim[16] = 0 ;
			 SprAnim[17] = 0 ;
			 SprAnim[18] = 0 ;
			 SprAnim[19] = 0 ;
			 SprAnim[20] = 0 ;
			 SprAnim[21] = 0 ;
			
			
			return SprAnim;
		}
	

		// World : bossLevel_02
		if(Name.indexOf("bossLevel_02")>=0){
			int[] SprAnim = new int[48];
			// sprite count : 48
			 SprAnim[0] = 0 ;
			 SprAnim[1] = 0 ;
			 SprAnim[2] = 0 ;
			 SprAnim[3] = 0 ;
			 SprAnim[4] = 0 ;
			 SprAnim[5] = 0 ;
			 SprAnim[6] = 0 ;
			 SprAnim[7] = 0 ;
			 SprAnim[8] = 0 ;
			 SprAnim[9] = 0 ;
			 SprAnim[10] = 0 ;
			 SprAnim[11] = 0 ;
			 SprAnim[12] = 0 ;
			 SprAnim[13] = 0 ;
			 SprAnim[14] = 0 ;
			 SprAnim[15] = 0 ;
			 SprAnim[16] = 0 ;
			 SprAnim[17] = 0 ;
			 SprAnim[18] = 0 ;
			 SprAnim[19] = 0 ;
			 SprAnim[20] = 0 ;
			 SprAnim[21] = 0 ;
			 SprAnim[22] = 0 ;
			 SprAnim[23] = 0 ;
			 SprAnim[24] = 0 ;
			 SprAnim[25] = 0 ;
			 SprAnim[26] = 0 ;
			 SprAnim[27] = 0 ;
			 SprAnim[28] = 0 ;
			 SprAnim[29] = 0 ;
			 SprAnim[30] = 0 ;
			 SprAnim[31] = 0 ;
			 SprAnim[32] = 0 ;
			 SprAnim[33] = 0 ;
			 SprAnim[34] = 0 ;
			 SprAnim[35] = 0 ;
			 SprAnim[36] = 0 ;
			 SprAnim[37] = 0 ;
			 SprAnim[38] = 0 ;
			 SprAnim[39] = 0 ;
			 SprAnim[40] = 0 ;
			 SprAnim[41] = 0 ;
			 SprAnim[42] = 0 ;
			 SprAnim[43] = 0 ;
			 SprAnim[44] = 0 ;
			 SprAnim[45] = 0 ;
			 SprAnim[46] = 0 ;
			 SprAnim[47] = 0 ;
			
			
			return SprAnim;
		}
	

		// World : bossLevel_03
		if(Name.indexOf("bossLevel_03")>=0){
			int[] SprAnim = new int[55];
			// sprite count : 55
			 SprAnim[0] = 0 ;
			 SprAnim[1] = 0 ;
			 SprAnim[2] = 0 ;
			 SprAnim[3] = 0 ;
			 SprAnim[4] = 0 ;
			 SprAnim[5] = 0 ;
			 SprAnim[6] = 0 ;
			 SprAnim[7] = 0 ;
			 SprAnim[8] = 0 ;
			 SprAnim[9] = 0 ;
			 SprAnim[10] = 0 ;
			 SprAnim[11] = 0 ;
			 SprAnim[12] = 0 ;
			 SprAnim[13] = 0 ;
			 SprAnim[14] = 0 ;
			 SprAnim[15] = 0 ;
			 SprAnim[16] = 0 ;
			 SprAnim[17] = 0 ;
			 SprAnim[18] = 0 ;
			 SprAnim[19] = 0 ;
			 SprAnim[20] = 0 ;
			 SprAnim[21] = 0 ;
			 SprAnim[22] = 0 ;
			 SprAnim[23] = 0 ;
			 SprAnim[24] = 0 ;
			 SprAnim[25] = 0 ;
			 SprAnim[26] = 0 ;
			 SprAnim[27] = 0 ;
			 SprAnim[28] = 0 ;
			 SprAnim[29] = 0 ;
			 SprAnim[30] = 0 ;
			 SprAnim[31] = 0 ;
			 SprAnim[32] = 0 ;
			 SprAnim[33] = 0 ;
			 SprAnim[34] = 0 ;
			 SprAnim[35] = 0 ;
			 SprAnim[36] = 0 ;
			 SprAnim[37] = 0 ;
			 SprAnim[38] = 0 ;
			 SprAnim[39] = 0 ;
			 SprAnim[40] = 0 ;
			 SprAnim[41] = 0 ;
			 SprAnim[42] = 0 ;
			 SprAnim[43] = 0 ;
			 SprAnim[44] = 0 ;
			 SprAnim[45] = 0 ;
			 SprAnim[46] = 0 ;
			 SprAnim[47] = 0 ;
			 SprAnim[48] = 0 ;
			 SprAnim[49] = 0 ;
			 SprAnim[50] = 0 ;
			 SprAnim[51] = 0 ;
			 SprAnim[52] = 0 ;
			 SprAnim[53] = 0 ;
			 SprAnim[54] = 0 ;
			
			
			return SprAnim;
		}
	

		// World : bossLevel_04
		if(Name.indexOf("bossLevel_04")>=0){
			int[] SprAnim = new int[48];
			// sprite count : 48
			 SprAnim[0] = 0 ;
			 SprAnim[1] = 0 ;
			 SprAnim[2] = 0 ;
			 SprAnim[3] = 0 ;
			 SprAnim[4] = 0 ;
			 SprAnim[5] = 0 ;
			 SprAnim[6] = 0 ;
			 SprAnim[7] = 0 ;
			 SprAnim[8] = 0 ;
			 SprAnim[9] = 0 ;
			 SprAnim[10] = 0 ;
			 SprAnim[11] = 0 ;
			 SprAnim[12] = 0 ;
			 SprAnim[13] = 0 ;
			 SprAnim[14] = 0 ;
			 SprAnim[15] = 0 ;
			 SprAnim[16] = 0 ;
			 SprAnim[17] = 0 ;
			 SprAnim[18] = 0 ;
			 SprAnim[19] = 0 ;
			 SprAnim[20] = 0 ;
			 SprAnim[21] = 0 ;
			 SprAnim[22] = 0 ;
			 SprAnim[23] = 0 ;
			 SprAnim[24] = 0 ;
			 SprAnim[25] = 0 ;
			 SprAnim[26] = 0 ;
			 SprAnim[27] = 0 ;
			 SprAnim[28] = 0 ;
			 SprAnim[29] = 0 ;
			 SprAnim[30] = 0 ;
			 SprAnim[31] = 0 ;
			 SprAnim[32] = 0 ;
			 SprAnim[33] = 0 ;
			 SprAnim[34] = 0 ;
			 SprAnim[35] = 0 ;
			 SprAnim[36] = 0 ;
			 SprAnim[37] = 0 ;
			 SprAnim[38] = 0 ;
			 SprAnim[39] = 0 ;
			 SprAnim[40] = 0 ;
			 SprAnim[41] = 0 ;
			 SprAnim[42] = 0 ;
			 SprAnim[43] = 0 ;
			 SprAnim[44] = 0 ;
			 SprAnim[45] = 0 ;
			 SprAnim[46] = 0 ;
			 SprAnim[47] = 0 ;
			
			
			return SprAnim;
		}
	

		// World : bossLevel_05
		if(Name.indexOf("bossLevel_05")>=0){
			int[] SprAnim = new int[32];
			// sprite count : 32
			 SprAnim[0] = 0 ;
			 SprAnim[1] = 0 ;
			 SprAnim[2] = 0 ;
			 SprAnim[3] = 0 ;
			 SprAnim[4] = 0 ;
			 SprAnim[5] = 0 ;
			 SprAnim[6] = 0 ;
			 SprAnim[7] = 0 ;
			 SprAnim[8] = 0 ;
			 SprAnim[9] = 0 ;
			 SprAnim[10] = 0 ;
			 SprAnim[11] = 0 ;
			 SprAnim[12] = 0 ;
			 SprAnim[13] = 0 ;
			 SprAnim[14] = 0 ;
			 SprAnim[15] = 0 ;
			 SprAnim[16] = 0 ;
			 SprAnim[17] = 0 ;
			 SprAnim[18] = 0 ;
			 SprAnim[19] = 0 ;
			 SprAnim[20] = 0 ;
			 SprAnim[21] = 0 ;
			 SprAnim[22] = 0 ;
			 SprAnim[23] = 0 ;
			 SprAnim[24] = 0 ;
			 SprAnim[25] = 0 ;
			 SprAnim[26] = 0 ;
			 SprAnim[27] = 0 ;
			 SprAnim[28] = 0 ;
			 SprAnim[29] = 0 ;
			 SprAnim[30] = 0 ;
			 SprAnim[31] = 0 ;
			
			
			return SprAnim;
		}
	

		return null;
	}
	
	final static public int[] getWorldSprX(String Name){
	
		// World : battleLevel_00
		if(Name.indexOf("battleLevel_00")>=0){
			int[] SprX = new int[51];
			// sprite count : 51
			 SprX[0] = 320 ;
			 SprX[1] = 320 ;
			 SprX[2] = 336 ;
			 SprX[3] = 336 ;
			 SprX[4] = 352 ;
			 SprX[5] = 352 ;
			 SprX[6] = 368 ;
			 SprX[7] = 608 ;
			 SprX[8] = 565 ;
			 SprX[9] = 514 ;
			 SprX[10] = 416 ;
			 SprX[11] = 464 ;
			 SprX[12] = 368 ;
			 SprX[13] = 368 ;
			 SprX[14] = 384 ;
			 SprX[15] = 384 ;
			 SprX[16] = 400 ;
			 SprX[17] = 400 ;
			 SprX[18] = 656 ;
			 SprX[19] = 656 ;
			 SprX[20] = 784 ;
			 SprX[21] = 800 ;
			 SprX[22] = 816 ;
			 SprX[23] = 832 ;
			 SprX[24] = 816 ;
			 SprX[25] = 832 ;
			 SprX[26] = 848 ;
			 SprX[27] = 864 ;
			 SprX[28] = 1024 ;
			 SprX[29] = 1072 ;
			 SprX[30] = 1120 ;
			 SprX[31] = 1120 ;
			 SprX[32] = 1072 ;
			 SprX[33] = 1167 ;
			 SprX[34] = 1328 ;
			 SprX[35] = 1376 ;
			 SprX[36] = 1376 ;
			 SprX[37] = 1376 ;
			 SprX[38] = 1440 ;
			 SprX[39] = 1488 ;
			 SprX[40] = 1504 ;
			 SprX[41] = 1504 ;
			 SprX[42] = 1440 ;
			 SprX[43] = 1440 ;
			 SprX[44] = 1536 ;
			 SprX[45] = 1536 ;
			 SprX[46] = 1568 ;
			 SprX[47] = 1567 ;
			 SprX[48] = 1632 ;
			 SprX[49] = 1632 ;
			 SprX[50] = 16 ;
			
			
			return SprX;
		}
	

		// World : battleLevel_01
		if(Name.indexOf("battleLevel_01")>=0){
			int[] SprX = new int[73];
			// sprite count : 73
			 SprX[0] = 176 ;
			 SprX[1] = 192 ;
			 SprX[2] = 208 ;
			 SprX[3] = 224 ;
			 SprX[4] = 240 ;
			 SprX[5] = 256 ;
			 SprX[6] = 192 ;
			 SprX[7] = 192 ;
			 SprX[8] = 240 ;
			 SprX[9] = 240 ;
			 SprX[10] = 480 ;
			 SprX[11] = 464 ;
			 SprX[12] = 448 ;
			 SprX[13] = 480 ;
			 SprX[14] = 464 ;
			 SprX[15] = 448 ;
			 SprX[16] = 384 ;
			 SprX[17] = 384 ;
			 SprX[18] = 448 ;
			 SprX[19] = 480 ;
			 SprX[20] = 561 ;
			 SprX[21] = 560 ;
			 SprX[22] = 560 ;
			 SprX[23] = 576 ;
			 SprX[24] = 576 ;
			 SprX[25] = 576 ;
			 SprX[26] = 688 ;
			 SprX[27] = 736 ;
			 SprX[28] = 768 ;
			 SprX[29] = 736 ;
			 SprX[30] = 688 ;
			 SprX[31] = 864 ;
			 SprX[32] = 879 ;
			 SprX[33] = 896 ;
			 SprX[34] = 880 ;
			 SprX[35] = 864 ;
			 SprX[36] = 880 ;
			 SprX[37] = 898 ;
			 SprX[38] = 928 ;
			 SprX[39] = 992 ;
			 SprX[40] = 1024 ;
			 SprX[41] = 992 ;
			 SprX[42] = 1104 ;
			 SprX[43] = 1104 ;
			 SprX[44] = 1136 ;
			 SprX[45] = 1136 ;
			 SprX[46] = 1184 ;
			 SprX[47] = 1184 ;
			 SprX[48] = 1152 ;
			 SprX[49] = 1152 ;
			 SprX[50] = 1280 ;
			 SprX[51] = 1312 ;
			 SprX[52] = 1328 ;
			 SprX[53] = 1344 ;
			 SprX[54] = 1376 ;
			 SprX[55] = 1280 ;
			 SprX[56] = 1312 ;
			 SprX[57] = 1328 ;
			 SprX[58] = 1344 ;
			 SprX[59] = 1376 ;
			 SprX[60] = 1472 ;
			 SprX[61] = 1488 ;
			 SprX[62] = 1504 ;
			 SprX[63] = 1456 ;
			 SprX[64] = 1440 ;
			 SprX[65] = 1424 ;
			 SprX[66] = 1632 ;
			 SprX[67] = 1632 ;
			 SprX[68] = 1632 ;
			 SprX[69] = 1632 ;
			 SprX[70] = 1632 ;
			 SprX[71] = 1632 ;
			 SprX[72] = 16 ;
			
			
			return SprX;
		}
	

		// World : battleLevel_02
		if(Name.indexOf("battleLevel_02")>=0){
			int[] SprX = new int[83];
			// sprite count : 83
			 SprX[0] = 192 ;
			 SprX[1] = 192 ;
			 SprX[2] = 192 ;
			 SprX[3] = 192 ;
			 SprX[4] = 272 ;
			 SprX[5] = 304 ;
			 SprX[6] = 288 ;
			 SprX[7] = 320 ;
			 SprX[8] = 320 ;
			 SprX[9] = 320 ;
			 SprX[10] = 320 ;
			 SprX[11] = 352 ;
			 SprX[12] = 349 ;
			 SprX[13] = 368 ;
			 SprX[14] = 388 ;
			 SprX[15] = 352 ;
			 SprX[16] = 368 ;
			 SprX[17] = 384 ;
			 SprX[18] = 416 ;
			 SprX[19] = 416 ;
			 SprX[20] = 512 ;
			 SprX[21] = 512 ;
			 SprX[22] = 512 ;
			 SprX[23] = 640 ;
			 SprX[24] = 640 ;
			 SprX[25] = 656 ;
			 SprX[26] = 656 ;
			 SprX[27] = 656 ;
			 SprX[28] = 656 ;
			 SprX[29] = 672 ;
			 SprX[30] = 672 ;
			 SprX[31] = 688 ;
			 SprX[32] = 688 ;
			 SprX[33] = 752 ;
			 SprX[34] = 752 ;
			 SprX[35] = 800 ;
			 SprX[36] = 800 ;
			 SprX[37] = 944 ;
			 SprX[38] = 960 ;
			 SprX[39] = 976 ;
			 SprX[40] = 992 ;
			 SprX[41] = 1008 ;
			 SprX[42] = 1024 ;
			 SprX[43] = 1008 ;
			 SprX[44] = 992 ;
			 SprX[45] = 977 ;
			 SprX[46] = 960 ;
			 SprX[47] = 944 ;
			 SprX[48] = 1041 ;
			 SprX[49] = 1040 ;
			 SprX[50] = 1072 ;
			 SprX[51] = 1072 ;
			 SprX[52] = 1072 ;
			 SprX[53] = 1072 ;
			 SprX[54] = 1072 ;
			 SprX[55] = 1072 ;
			 SprX[56] = 1168 ;
			 SprX[57] = 1168 ;
			 SprX[58] = 1232 ;
			 SprX[59] = 1232 ;
			 SprX[60] = 1296 ;
			 SprX[61] = 1296 ;
			 SprX[62] = 1184 ;
			 SprX[63] = 1184 ;
			 SprX[64] = 1200 ;
			 SprX[65] = 1200 ;
			 SprX[66] = 1248 ;
			 SprX[67] = 1248 ;
			 SprX[68] = 1264 ;
			 SprX[69] = 1264 ;
			 SprX[70] = 1312 ;
			 SprX[71] = 1312 ;
			 SprX[72] = 1312 ;
			 SprX[73] = 1472 ;
			 SprX[74] = 1472 ;
			 SprX[75] = 1536 ;
			 SprX[76] = 1536 ;
			 SprX[77] = 1584 ;
			 SprX[78] = 1488 ;
			 SprX[79] = 1520 ;
			 SprX[80] = 1632 ;
			 SprX[81] = 1632 ;
			 SprX[82] = 22 ;
			
			
			return SprX;
		}
	

		// World : battleLevel_03
		if(Name.indexOf("battleLevel_03")>=0){
			int[] SprX = new int[75];
			// sprite count : 75
			 SprX[0] = 159 ;
			 SprX[1] = 160 ;
			 SprX[2] = 128 ;
			 SprX[3] = 128 ;
			 SprX[4] = 128 ;
			 SprX[5] = 128 ;
			 SprX[6] = 272 ;
			 SprX[7] = 288 ;
			 SprX[8] = 304 ;
			 SprX[9] = 320 ;
			 SprX[10] = 336 ;
			 SprX[11] = 272 ;
			 SprX[12] = 288 ;
			 SprX[13] = 304 ;
			 SprX[14] = 320 ;
			 SprX[15] = 336 ;
			 SprX[16] = 352 ;
			 SprX[17] = 352 ;
			 SprX[18] = 352 ;
			 SprX[19] = 320 ;
			 SprX[20] = 320 ;
			 SprX[21] = 320 ;
			 SprX[22] = 304 ;
			 SprX[23] = 304 ;
			 SprX[24] = 416 ;
			 SprX[25] = 464 ;
			 SprX[26] = 416 ;
			 SprX[27] = 512 ;
			 SprX[28] = 512 ;
			 SprX[29] = 576 ;
			 SprX[30] = 576 ;
			 SprX[31] = 464 ;
			 SprX[32] = 512 ;
			 SprX[33] = 512 ;
			 SprX[34] = 576 ;
			 SprX[35] = 576 ;
			 SprX[36] = 816 ;
			 SprX[37] = 864 ;
			 SprX[38] = 912 ;
			 SprX[39] = 960 ;
			 SprX[40] = 992 ;
			 SprX[41] = 1024 ;
			 SprX[42] = 1056 ;
			 SprX[43] = 960 ;
			 SprX[44] = 960 ;
			 SprX[45] = 832 ;
			 SprX[46] = 1072 ;
			 SprX[47] = 1120 ;
			 SprX[48] = 976 ;
			 SprX[49] = 1008 ;
			 SprX[50] = 1040 ;
			 SprX[51] = 976 ;
			 SprX[52] = 1008 ;
			 SprX[53] = 1040 ;
			 SprX[54] = 1168 ;
			 SprX[55] = 1169 ;
			 SprX[56] = 1183 ;
			 SprX[57] = 1184 ;
			 SprX[58] = 1202 ;
			 SprX[59] = 1219 ;
			 SprX[60] = 1232 ;
			 SprX[61] = 1168 ;
			 SprX[62] = 1168 ;
			 SprX[63] = 1184 ;
			 SprX[64] = 1184 ;
			 SprX[65] = 1200 ;
			 SprX[66] = 1200 ;
			 SprX[67] = 1232 ;
			 SprX[68] = 1392 ;
			 SprX[69] = 1616 ;
			 SprX[70] = 1616 ;
			 SprX[71] = 1568 ;
			 SprX[72] = 1616 ;
			 SprX[73] = 1616 ;
			 SprX[74] = 20 ;
			
			
			return SprX;
		}
	

		// World : battleLevel_04
		if(Name.indexOf("battleLevel_04")>=0){
			int[] SprX = new int[74];
			// sprite count : 74
			 SprX[0] = 128 ;
			 SprX[1] = 160 ;
			 SprX[2] = 208 ;
			 SprX[3] = 128 ;
			 SprX[4] = 160 ;
			 SprX[5] = 208 ;
			 SprX[6] = 144 ;
			 SprX[7] = 208 ;
			 SprX[8] = 144 ;
			 SprX[9] = 272 ;
			 SprX[10] = 320 ;
			 SprX[11] = 256 ;
			 SprX[12] = 304 ;
			 SprX[13] = 368 ;
			 SprX[14] = 352 ;
			 SprX[15] = 368 ;
			 SprX[16] = 352 ;
			 SprX[17] = 320 ;
			 SprX[18] = 256 ;
			 SprX[19] = 416 ;
			 SprX[20] = 448 ;
			 SprX[21] = 608 ;
			 SprX[22] = 608 ;
			 SprX[23] = 688 ;
			 SprX[24] = 784 ;
			 SprX[25] = 784 ;
			 SprX[26] = 544 ;
			 SprX[27] = 544 ;
			 SprX[28] = 544 ;
			 SprX[29] = 544 ;
			 SprX[30] = 544 ;
			 SprX[31] = 544 ;
			 SprX[32] = 640 ;
			 SprX[33] = 640 ;
			 SprX[34] = 640 ;
			 SprX[35] = 736 ;
			 SprX[36] = 736 ;
			 SprX[37] = 736 ;
			 SprX[38] = 736 ;
			 SprX[39] = 928 ;
			 SprX[40] = 960 ;
			 SprX[41] = 992 ;
			 SprX[42] = 1024 ;
			 SprX[43] = 1056 ;
			 SprX[44] = 1088 ;
			 SprX[45] = 928 ;
			 SprX[46] = 960 ;
			 SprX[47] = 992 ;
			 SprX[48] = 1024 ;
			 SprX[49] = 1056 ;
			 SprX[50] = 1088 ;
			 SprX[51] = 976 ;
			 SprX[52] = 1008 ;
			 SprX[53] = 1040 ;
			 SprX[54] = 1072 ;
			 SprX[55] = 1344 ;
			 SprX[56] = 1344 ;
			 SprX[57] = 1344 ;
			 SprX[58] = 1408 ;
			 SprX[59] = 1408 ;
			 SprX[60] = 1408 ;
			 SprX[61] = 1408 ;
			 SprX[62] = 1408 ;
			 SprX[63] = 1408 ;
			 SprX[64] = 1552 ;
			 SprX[65] = 1552 ;
			 SprX[66] = 1552 ;
			 SprX[67] = 1552 ;
			 SprX[68] = 1552 ;
			 SprX[69] = 1552 ;
			 SprX[70] = 992 ;
			 SprX[71] = 1024 ;
			 SprX[72] = 1056 ;
			 SprX[73] = 9 ;
			
			
			return SprX;
		}
	

		// World : battleLevel_05
		if(Name.indexOf("battleLevel_05")>=0){
			int[] SprX = new int[59];
			// sprite count : 59
			 SprX[0] = 176 ;
			 SprX[1] = 176 ;
			 SprX[2] = 176 ;
			 SprX[3] = 176 ;
			 SprX[4] = 240 ;
			 SprX[5] = 256 ;
			 SprX[6] = 272 ;
			 SprX[7] = 256 ;
			 SprX[8] = 240 ;
			 SprX[9] = 288 ;
			 SprX[10] = 288 ;
			 SprX[11] = 288 ;
			 SprX[12] = 288 ;
			 SprX[13] = 352 ;
			 SprX[14] = 400 ;
			 SprX[15] = 448 ;
			 SprX[16] = 496 ;
			 SprX[17] = 544 ;
			 SprX[18] = 592 ;
			 SprX[19] = 608 ;
			 SprX[20] = 624 ;
			 SprX[21] = 640 ;
			 SprX[22] = 656 ;
			 SprX[23] = 672 ;
			 SprX[24] = 640 ;
			 SprX[25] = 656 ;
			 SprX[26] = 672 ;
			 SprX[27] = 688 ;
			 SprX[28] = 656 ;
			 SprX[29] = 752 ;
			 SprX[30] = 816 ;
			 SprX[31] = 896 ;
			 SprX[32] = 976 ;
			 SprX[33] = 1056 ;
			 SprX[34] = 1072 ;
			 SprX[35] = 1088 ;
			 SprX[36] = 1104 ;
			 SprX[37] = 1120 ;
			 SprX[38] = 1072 ;
			 SprX[39] = 1088 ;
			 SprX[40] = 1104 ;
			 SprX[41] = 1120 ;
			 SprX[42] = 1104 ;
			 SprX[43] = 1441 ;
			 SprX[44] = 1440 ;
			 SprX[45] = 1440 ;
			 SprX[46] = 1440 ;
			 SprX[47] = 1472 ;
			 SprX[48] = 1472 ;
			 SprX[49] = 1472 ;
			 SprX[50] = 1472 ;
			 SprX[51] = 1504 ;
			 SprX[52] = 1504 ;
			 SprX[53] = 1504 ;
			 SprX[54] = 1504 ;
			 SprX[55] = 1504 ;
			 SprX[56] = 1472 ;
			 SprX[57] = 1440 ;
			 SprX[58] = 6 ;
			
			
			return SprX;
		}
	

		// World : battleLevel_06
		if(Name.indexOf("battleLevel_06")>=0){
			int[] SprX = new int[64];
			// sprite count : 64
			 SprX[0] = 112 ;
			 SprX[1] = 112 ;
			 SprX[2] = 162 ;
			 SprX[3] = 160 ;
			 SprX[4] = 224 ;
			 SprX[5] = 224 ;
			 SprX[6] = 272 ;
			 SprX[7] = 272 ;
			 SprX[8] = 336 ;
			 SprX[9] = 336 ;
			 SprX[10] = 384 ;
			 SprX[11] = 384 ;
			 SprX[12] = 432 ;
			 SprX[13] = 432 ;
			 SprX[14] = 480 ;
			 SprX[15] = 480 ;
			 SprX[16] = 528 ;
			 SprX[17] = 528 ;
			 SprX[18] = 576 ;
			 SprX[19] = 576 ;
			 SprX[20] = 624 ;
			 SprX[21] = 624 ;
			 SprX[22] = 944 ;
			 SprX[23] = 928 ;
			 SprX[24] = 912 ;
			 SprX[25] = 896 ;
			 SprX[26] = 880 ;
			 SprX[27] = 864 ;
			 SprX[28] = 848 ;
			 SprX[29] = 864 ;
			 SprX[30] = 880 ;
			 SprX[31] = 896 ;
			 SprX[32] = 912 ;
			 SprX[33] = 944 ;
			 SprX[34] = 928 ;
			 SprX[35] = 1360 ;
			 SprX[36] = 1360 ;
			 SprX[37] = 1360 ;
			 SprX[38] = 1344 ;
			 SprX[39] = 1392 ;
			 SprX[40] = 1392 ;
			 SprX[41] = 1392 ;
			 SprX[42] = 1376 ;
			 SprX[43] = 1360 ;
			 SprX[44] = 1360 ;
			 SprX[45] = 1360 ;
			 SprX[46] = 1344 ;
			 SprX[47] = 192 ;
			 SprX[48] = 192 ;
			 SprX[49] = 288 ;
			 SprX[50] = 288 ;
			 SprX[51] = 384 ;
			 SprX[52] = 384 ;
			 SprX[53] = 480 ;
			 SprX[54] = 480 ;
			 SprX[55] = 576 ;
			 SprX[56] = 576 ;
			 SprX[57] = 1072 ;
			 SprX[58] = 992 ;
			 SprX[59] = 992 ;
			 SprX[60] = 1072 ;
			 SprX[61] = 1456 ;
			 SprX[62] = 1456 ;
			 SprX[63] = 8 ;
			
			
			return SprX;
		}
	

		// World : bossLevel_01
		if(Name.indexOf("bossLevel_01")>=0){
			int[] SprX = new int[22];
			// sprite count : 22
			 SprX[0] = 736 ;
			 SprX[1] = 352 ;
			 SprX[2] = 400 ;
			 SprX[3] = 400 ;
			 SprX[4] = 352 ;
			 SprX[5] = 448 ;
			 SprX[6] = 304 ;
			 SprX[7] = 288 ;
			 SprX[8] = 288 ;
			 SprX[9] = 256 ;
			 SprX[10] = 256 ;
			 SprX[11] = 208 ;
			 SprX[12] = 208 ;
			 SprX[13] = 560 ;
			 SprX[14] = 544 ;
			 SprX[15] = 544 ;
			 SprX[16] = 544 ;
			 SprX[17] = 560 ;
			 SprX[18] = 576 ;
			 SprX[19] = 576 ;
			 SprX[20] = 592 ;
			 SprX[21] = 10 ;
			
			
			return SprX;
		}
	

		// World : bossLevel_02
		if(Name.indexOf("bossLevel_02")>=0){
			int[] SprX = new int[48];
			// sprite count : 48
			 SprX[0] = 209 ;
			 SprX[1] = 256 ;
			 SprX[2] = 272 ;
			 SprX[3] = 256 ;
			 SprX[4] = 432 ;
			 SprX[5] = 432 ;
			 SprX[6] = 448 ;
			 SprX[7] = 448 ;
			 SprX[8] = 560 ;
			 SprX[9] = 560 ;
			 SprX[10] = 576 ;
			 SprX[11] = 576 ;
			 SprX[12] = 576 ;
			 SprX[13] = 560 ;
			 SprX[14] = 720 ;
			 SprX[15] = 736 ;
			 SprX[16] = 736 ;
			 SprX[17] = 736 ;
			 SprX[18] = 720 ;
			 SprX[19] = 720 ;
			 SprX[20] = 720 ;
			 SprX[21] = 752 ;
			 SprX[22] = 752 ;
			 SprX[23] = 752 ;
			 SprX[24] = 752 ;
			 SprX[25] = 752 ;
			 SprX[26] = 912 ;
			 SprX[27] = 944 ;
			 SprX[28] = 976 ;
			 SprX[29] = 1008 ;
			 SprX[30] = 1008 ;
			 SprX[31] = 976 ;
			 SprX[32] = 1088 ;
			 SprX[33] = 1120 ;
			 SprX[34] = 1152 ;
			 SprX[35] = 1040 ;
			 SprX[36] = 1264 ;
			 SprX[37] = 1280 ;
			 SprX[38] = 1296 ;
			 SprX[39] = 1440 ;
			 SprX[40] = 1424 ;
			 SprX[41] = 1456 ;
			 SprX[42] = 1600 ;
			 SprX[43] = 1584 ;
			 SprX[44] = 1616 ;
			 SprX[45] = 1600 ;
			 SprX[46] = 1440 ;
			 SprX[47] = 9 ;
			
			
			return SprX;
		}
	

		// World : bossLevel_03
		if(Name.indexOf("bossLevel_03")>=0){
			int[] SprX = new int[55];
			// sprite count : 55
			 SprX[0] = 656 ;
			 SprX[1] = 752 ;
			 SprX[2] = 848 ;
			 SprX[3] = 176 ;
			 SprX[4] = 192 ;
			 SprX[5] = 208 ;
			 SprX[6] = 224 ;
			 SprX[7] = 240 ;
			 SprX[8] = 256 ;
			 SprX[9] = 272 ;
			 SprX[10] = 288 ;
			 SprX[11] = 304 ;
			 SprX[12] = 160 ;
			 SprX[13] = 144 ;
			 SprX[14] = 320 ;
			 SprX[15] = 336 ;
			 SprX[16] = 128 ;
			 SprX[17] = 432 ;
			 SprX[18] = 464 ;
			 SprX[19] = 496 ;
			 SprX[20] = 528 ;
			 SprX[21] = 528 ;
			 SprX[22] = 576 ;
			 SprX[23] = 560 ;
			 SprX[24] = 608 ;
			 SprX[25] = 704 ;
			 SprX[26] = 800 ;
			 SprX[27] = 896 ;
			 SprX[28] = 736 ;
			 SprX[29] = 832 ;
			 SprX[30] = 928 ;
			 SprX[31] = 768 ;
			 SprX[32] = 864 ;
			 SprX[33] = 960 ;
			 SprX[34] = 800 ;
			 SprX[35] = 896 ;
			 SprX[36] = 992 ;
			 SprX[37] = 832 ;
			 SprX[38] = 928 ;
			 SprX[39] = 1024 ;
			 SprX[40] = 864 ;
			 SprX[41] = 960 ;
			 SprX[42] = 1056 ;
			 SprX[43] = 1264 ;
			 SprX[44] = 1264 ;
			 SprX[45] = 1264 ;
			 SprX[46] = 1408 ;
			 SprX[47] = 1408 ;
			 SprX[48] = 1408 ;
			 SprX[49] = 1664 ;
			 SprX[50] = 1664 ;
			 SprX[51] = 1664 ;
			 SprX[52] = 1664 ;
			 SprX[53] = 1664 ;
			 SprX[54] = 8 ;
			
			
			return SprX;
		}
	

		// World : bossLevel_04
		if(Name.indexOf("bossLevel_04")>=0){
			int[] SprX = new int[48];
			// sprite count : 48
			 SprX[0] = 1440 ;
			 SprX[1] = 1472 ;
			 SprX[2] = 1504 ;
			 SprX[3] = 1536 ;
			 SprX[4] = 1568 ;
			 SprX[5] = 1600 ;
			 SprX[6] = 1632 ;
			 SprX[7] = 1664 ;
			 SprX[8] = 1696 ;
			 SprX[9] = 208 ;
			 SprX[10] = 208 ;
			 SprX[11] = 336 ;
			 SprX[12] = 336 ;
			 SprX[13] = 448 ;
			 SprX[14] = 448 ;
			 SprX[15] = 560 ;
			 SprX[16] = 560 ;
			 SprX[17] = 672 ;
			 SprX[18] = 672 ;
			 SprX[19] = 784 ;
			 SprX[20] = 784 ;
			 SprX[21] = 176 ;
			 SprX[22] = 176 ;
			 SprX[23] = 176 ;
			 SprX[24] = 304 ;
			 SprX[25] = 272 ;
			 SprX[26] = 272 ;
			 SprX[27] = 304 ;
			 SprX[28] = 368 ;
			 SprX[29] = 384 ;
			 SprX[30] = 384 ;
			 SprX[31] = 368 ;
			 SprX[32] = 416 ;
			 SprX[33] = 416 ;
			 SprX[34] = 416 ;
			 SprX[35] = 864 ;
			 SprX[36] = 864 ;
			 SprX[37] = 928 ;
			 SprX[38] = 928 ;
			 SprX[39] = 992 ;
			 SprX[40] = 992 ;
			 SprX[41] = 1056 ;
			 SprX[42] = 1056 ;
			 SprX[43] = 1136 ;
			 SprX[44] = 1168 ;
			 SprX[45] = 1200 ;
			 SprX[46] = 1152 ;
			 SprX[47] = 13 ;
			
			
			return SprX;
		}
	

		// World : bossLevel_05
		if(Name.indexOf("bossLevel_05")>=0){
			int[] SprX = new int[32];
			// sprite count : 32
			 SprX[0] = 176 ;
			 SprX[1] = 176 ;
			 SprX[2] = 240 ;
			 SprX[3] = 240 ;
			 SprX[4] = 304 ;
			 SprX[5] = 352 ;
			 SprX[6] = 384 ;
			 SprX[7] = 384 ;
			 SprX[8] = 384 ;
			 SprX[9] = 512 ;
			 SprX[10] = 480 ;
			 SprX[11] = 528 ;
			 SprX[12] = 208 ;
			 SprX[13] = 576 ;
			 SprX[14] = 608 ;
			 SprX[15] = 672 ;
			 SprX[16] = 640 ;
			 SprX[17] = 704 ;
			 SprX[18] = 896 ;
			 SprX[19] = 912 ;
			 SprX[20] = 928 ;
			 SprX[21] = 928 ;
			 SprX[22] = 816 ;
			 SprX[23] = 1040 ;
			 SprX[24] = 1136 ;
			 SprX[25] = 1152 ;
			 SprX[26] = 1232 ;
			 SprX[27] = 1312 ;
			 SprX[28] = 1408 ;
			 SprX[29] = 1488 ;
			 SprX[30] = 1408 ;
			 SprX[31] = 14 ;
			
			
			return SprX;
		}
	

		return null;
	}
	
	final static public int[] getWorldSprY(String Name){
	
		// World : battleLevel_00
		if(Name.indexOf("battleLevel_00")>=0){
			int[] SprY = new int[51];
			// sprite count : 51
			 SprY[0] = 64 ;
			 SprY[1] = 96 ;
			 SprY[2] = 64 ;
			 SprY[3] = 96 ;
			 SprY[4] = 64 ;
			 SprY[5] = 96 ;
			 SprY[6] = 144 ;
			 SprY[7] = 144 ;
			 SprY[8] = 146 ;
			 SprY[9] = 145 ;
			 SprY[10] = 144 ;
			 SprY[11] = 144 ;
			 SprY[12] = 64 ;
			 SprY[13] = 96 ;
			 SprY[14] = 64 ;
			 SprY[15] = 96 ;
			 SprY[16] = 65 ;
			 SprY[17] = 96 ;
			 SprY[18] = 192 ;
			 SprY[19] = 114 ;
			 SprY[20] = 176 ;
			 SprY[21] = 176 ;
			 SprY[22] = 176 ;
			 SprY[23] = 176 ;
			 SprY[24] = 128 ;
			 SprY[25] = 128 ;
			 SprY[26] = 128 ;
			 SprY[27] = 128 ;
			 SprY[28] = 208 ;
			 SprY[29] = 192 ;
			 SprY[30] = 176 ;
			 SprY[31] = 128 ;
			 SprY[32] = 112 ;
			 SprY[33] = 115 ;
			 SprY[34] = 160 ;
			 SprY[35] = 112 ;
			 SprY[36] = 160 ;
			 SprY[37] = 208 ;
			 SprY[38] = 160 ;
			 SprY[39] = 160 ;
			 SprY[40] = 112 ;
			 SprY[41] = 208 ;
			 SprY[42] = 208 ;
			 SprY[43] = 112 ;
			 SprY[44] = 80 ;
			 SprY[45] = 240 ;
			 SprY[46] = 128 ;
			 SprY[47] = 177 ;
			 SprY[48] = 112 ;
			 SprY[49] = 192 ;
			 SprY[50] = 144 ;
			
			
			return SprY;
		}
	

		// World : battleLevel_01
		if(Name.indexOf("battleLevel_01")>=0){
			int[] SprY = new int[73];
			// sprite count : 73
			 SprY[0] = 144 ;
			 SprY[1] = 144 ;
			 SprY[2] = 144 ;
			 SprY[3] = 144 ;
			 SprY[4] = 144 ;
			 SprY[5] = 144 ;
			 SprY[6] = 112 ;
			 SprY[7] = 176 ;
			 SprY[8] = 96 ;
			 SprY[9] = 192 ;
			 SprY[10] = 176 ;
			 SprY[11] = 176 ;
			 SprY[12] = 176 ;
			 SprY[13] = 112 ;
			 SprY[14] = 112 ;
			 SprY[15] = 112 ;
			 SprY[16] = 112 ;
			 SprY[17] = 208 ;
			 SprY[18] = 144 ;
			 SprY[19] = 144 ;
			 SprY[20] = 127 ;
			 SprY[21] = 112 ;
			 SprY[22] = 97 ;
			 SprY[23] = 160 ;
			 SprY[24] = 176 ;
			 SprY[25] = 192 ;
			 SprY[26] = 96 ;
			 SprY[27] = 128 ;
			 SprY[28] = 160 ;
			 SprY[29] = 192 ;
			 SprY[30] = 208 ;
			 SprY[31] = 192 ;
			 SprY[32] = 207 ;
			 SprY[33] = 224 ;
			 SprY[34] = 160 ;
			 SprY[35] = 128 ;
			 SprY[36] = 112 ;
			 SprY[37] = 95 ;
			 SprY[38] = 160 ;
			 SprY[39] = 128 ;
			 SprY[40] = 160 ;
			 SprY[41] = 192 ;
			 SprY[42] = 112 ;
			 SprY[43] = 208 ;
			 SprY[44] = 96 ;
			 SprY[45] = 224 ;
			 SprY[46] = 128 ;
			 SprY[47] = 208 ;
			 SprY[48] = 144 ;
			 SprY[49] = 192 ;
			 SprY[50] = 128 ;
			 SprY[51] = 128 ;
			 SprY[52] = 128 ;
			 SprY[53] = 128 ;
			 SprY[54] = 128 ;
			 SprY[55] = 192 ;
			 SprY[56] = 192 ;
			 SprY[57] = 192 ;
			 SprY[58] = 192 ;
			 SprY[59] = 192 ;
			 SprY[60] = 160 ;
			 SprY[61] = 128 ;
			 SprY[62] = 96 ;
			 SprY[63] = 192 ;
			 SprY[64] = 224 ;
			 SprY[65] = 256 ;
			 SprY[66] = 64 ;
			 SprY[67] = 96 ;
			 SprY[68] = 128 ;
			 SprY[69] = 160 ;
			 SprY[70] = 192 ;
			 SprY[71] = 224 ;
			 SprY[72] = 160 ;
			
			
			return SprY;
		}
	

		// World : battleLevel_02
		if(Name.indexOf("battleLevel_02")>=0){
			int[] SprY = new int[83];
			// sprite count : 83
			 SprY[0] = 112 ;
			 SprY[1] = 144 ;
			 SprY[2] = 176 ;
			 SprY[3] = 208 ;
			 SprY[4] = 144 ;
			 SprY[5] = 144 ;
			 SprY[6] = 176 ;
			 SprY[7] = 176 ;
			 SprY[8] = 128 ;
			 SprY[9] = 160 ;
			 SprY[10] = 192 ;
			 SprY[11] = 160 ;
			 SprY[12] = 97 ;
			 SprY[13] = 128 ;
			 SprY[14] = 142 ;
			 SprY[15] = 208 ;
			 SprY[16] = 192 ;
			 SprY[17] = 176 ;
			 SprY[18] = 160 ;
			 SprY[19] = 160 ;
			 SprY[20] = 144 ;
			 SprY[21] = 160 ;
			 SprY[22] = 176 ;
			 SprY[23] = 144 ;
			 SprY[24] = 160 ;
			 SprY[25] = 144 ;
			 SprY[26] = 160 ;
			 SprY[27] = 128 ;
			 SprY[28] = 176 ;
			 SprY[29] = 144 ;
			 SprY[30] = 160 ;
			 SprY[31] = 128 ;
			 SprY[32] = 176 ;
			 SprY[33] = 128 ;
			 SprY[34] = 160 ;
			 SprY[35] = 112 ;
			 SprY[36] = 176 ;
			 SprY[37] = 80 ;
			 SprY[38] = 96 ;
			 SprY[39] = 112 ;
			 SprY[40] = 128 ;
			 SprY[41] = 144 ;
			 SprY[42] = 160 ;
			 SprY[43] = 176 ;
			 SprY[44] = 192 ;
			 SprY[45] = 207 ;
			 SprY[46] = 224 ;
			 SprY[47] = 240 ;
			 SprY[48] = 128 ;
			 SprY[49] = 192 ;
			 SprY[50] = 80 ;
			 SprY[51] = 112 ;
			 SprY[52] = 144 ;
			 SprY[53] = 176 ;
			 SprY[54] = 208 ;
			 SprY[55] = 240 ;
			 SprY[56] = 128 ;
			 SprY[57] = 192 ;
			 SprY[58] = 128 ;
			 SprY[59] = 192 ;
			 SprY[60] = 128 ;
			 SprY[61] = 192 ;
			 SprY[62] = 112 ;
			 SprY[63] = 208 ;
			 SprY[64] = 144 ;
			 SprY[65] = 176 ;
			 SprY[66] = 144 ;
			 SprY[67] = 176 ;
			 SprY[68] = 112 ;
			 SprY[69] = 208 ;
			 SprY[70] = 112 ;
			 SprY[71] = 208 ;
			 SprY[72] = 160 ;
			 SprY[73] = 128 ;
			 SprY[74] = 160 ;
			 SprY[75] = 112 ;
			 SprY[76] = 176 ;
			 SprY[77] = 144 ;
			 SprY[78] = 144 ;
			 SprY[79] = 144 ;
			 SprY[80] = 128 ;
			 SprY[81] = 160 ;
			 SprY[82] = 151 ;
			
			
			return SprY;
		}
	

		// World : battleLevel_03
		if(Name.indexOf("battleLevel_03")>=0){
			int[] SprY = new int[75];
			// sprite count : 75
			 SprY[0] = 177 ;
			 SprY[1] = 144 ;
			 SprY[2] = 192 ;
			 SprY[3] = 160 ;
			 SprY[4] = 128 ;
			 SprY[5] = 96 ;
			 SprY[6] = 80 ;
			 SprY[7] = 80 ;
			 SprY[8] = 80 ;
			 SprY[9] = 80 ;
			 SprY[10] = 80 ;
			 SprY[11] = 224 ;
			 SprY[12] = 224 ;
			 SprY[13] = 224 ;
			 SprY[14] = 224 ;
			 SprY[15] = 224 ;
			 SprY[16] = 144 ;
			 SprY[17] = 160 ;
			 SprY[18] = 128 ;
			 SprY[19] = 128 ;
			 SprY[20] = 160 ;
			 SprY[21] = 144 ;
			 SprY[22] = 160 ;
			 SprY[23] = 128 ;
			 SprY[24] = 96 ;
			 SprY[25] = 112 ;
			 SprY[26] = 224 ;
			 SprY[27] = 128 ;
			 SprY[28] = 176 ;
			 SprY[29] = 112 ;
			 SprY[30] = 192 ;
			 SprY[31] = 192 ;
			 SprY[32] = 96 ;
			 SprY[33] = 208 ;
			 SprY[34] = 128 ;
			 SprY[35] = 176 ;
			 SprY[36] = 112 ;
			 SprY[37] = 144 ;
			 SprY[38] = 176 ;
			 SprY[39] = 208 ;
			 SprY[40] = 176 ;
			 SprY[41] = 144 ;
			 SprY[42] = 112 ;
			 SprY[43] = 144 ;
			 SprY[44] = 96 ;
			 SprY[45] = 192 ;
			 SprY[46] = 192 ;
			 SprY[47] = 160 ;
			 SprY[48] = 224 ;
			 SprY[49] = 224 ;
			 SprY[50] = 224 ;
			 SprY[51] = 112 ;
			 SprY[52] = 112 ;
			 SprY[53] = 112 ;
			 SprY[54] = 80 ;
			 SprY[55] = 114 ;
			 SprY[56] = 143 ;
			 SprY[57] = 176 ;
			 SprY[58] = 206 ;
			 SprY[59] = 226 ;
			 SprY[60] = 256 ;
			 SprY[61] = 240 ;
			 SprY[62] = 208 ;
			 SprY[63] = 176 ;
			 SprY[64] = 144 ;
			 SprY[65] = 112 ;
			 SprY[66] = 80 ;
			 SprY[67] = 48 ;
			 SprY[68] = 144 ;
			 SprY[69] = 64 ;
			 SprY[70] = 128 ;
			 SprY[71] = 160 ;
			 SprY[72] = 192 ;
			 SprY[73] = 256 ;
			 SprY[74] = 173 ;
			
			
			return SprY;
		}
	

		// World : battleLevel_04
		if(Name.indexOf("battleLevel_04")>=0){
			int[] SprY = new int[74];
			// sprite count : 74
			 SprY[0] = 112 ;
			 SprY[1] = 112 ;
			 SprY[2] = 112 ;
			 SprY[3] = 208 ;
			 SprY[4] = 208 ;
			 SprY[5] = 208 ;
			 SprY[6] = 80 ;
			 SprY[7] = 160 ;
			 SprY[8] = 240 ;
			 SprY[9] = 96 ;
			 SprY[10] = 144 ;
			 SprY[11] = 176 ;
			 SprY[12] = 224 ;
			 SprY[13] = 128 ;
			 SprY[14] = 48 ;
			 SprY[15] = 224 ;
			 SprY[16] = 192 ;
			 SprY[17] = 80 ;
			 SprY[18] = 240 ;
			 SprY[19] = 96 ;
			 SprY[20] = 176 ;
			 SprY[21] = 80 ;
			 SprY[22] = 224 ;
			 SprY[23] = 144 ;
			 SprY[24] = 128 ;
			 SprY[25] = 176 ;
			 SprY[26] = 64 ;
			 SprY[27] = 80 ;
			 SprY[28] = 96 ;
			 SprY[29] = 208 ;
			 SprY[30] = 224 ;
			 SprY[31] = 240 ;
			 SprY[32] = 128 ;
			 SprY[33] = 144 ;
			 SprY[34] = 160 ;
			 SprY[35] = 112 ;
			 SprY[36] = 144 ;
			 SprY[37] = 176 ;
			 SprY[38] = 208 ;
			 SprY[39] = 64 ;
			 SprY[40] = 64 ;
			 SprY[41] = 64 ;
			 SprY[42] = 64 ;
			 SprY[43] = 64 ;
			 SprY[44] = 64 ;
			 SprY[45] = 256 ;
			 SprY[46] = 256 ;
			 SprY[47] = 256 ;
			 SprY[48] = 256 ;
			 SprY[49] = 256 ;
			 SprY[50] = 256 ;
			 SprY[51] = 176 ;
			 SprY[52] = 176 ;
			 SprY[53] = 176 ;
			 SprY[54] = 176 ;
			 SprY[55] = 128 ;
			 SprY[56] = 160 ;
			 SprY[57] = 192 ;
			 SprY[58] = 80 ;
			 SprY[59] = 112 ;
			 SprY[60] = 144 ;
			 SprY[61] = 240 ;
			 SprY[62] = 208 ;
			 SprY[63] = 176 ;
			 SprY[64] = 128 ;
			 SprY[65] = 144 ;
			 SprY[66] = 160 ;
			 SprY[67] = 176 ;
			 SprY[68] = 192 ;
			 SprY[69] = 112 ;
			 SprY[70] = 208 ;
			 SprY[71] = 208 ;
			 SprY[72] = 208 ;
			 SprY[73] = 154 ;
			
			
			return SprY;
		}
	

		// World : battleLevel_05
		if(Name.indexOf("battleLevel_05")>=0){
			int[] SprY = new int[59];
			// sprite count : 59
			 SprY[0] = 208 ;
			 SprY[1] = 176 ;
			 SprY[2] = 96 ;
			 SprY[3] = 128 ;
			 SprY[4] = 112 ;
			 SprY[5] = 128 ;
			 SprY[6] = 144 ;
			 SprY[7] = 160 ;
			 SprY[8] = 176 ;
			 SprY[9] = 208 ;
			 SprY[10] = 176 ;
			 SprY[11] = 96 ;
			 SprY[12] = 128 ;
			 SprY[13] = 192 ;
			 SprY[14] = 128 ;
			 SprY[15] = 192 ;
			 SprY[16] = 128 ;
			 SprY[17] = 192 ;
			 SprY[18] = 128 ;
			 SprY[19] = 208 ;
			 SprY[20] = 192 ;
			 SprY[21] = 176 ;
			 SprY[22] = 160 ;
			 SprY[23] = 144 ;
			 SprY[24] = 208 ;
			 SprY[25] = 192 ;
			 SprY[26] = 176 ;
			 SprY[27] = 160 ;
			 SprY[28] = 224 ;
			 SprY[29] = 80 ;
			 SprY[30] = 224 ;
			 SprY[31] = 80 ;
			 SprY[32] = 224 ;
			 SprY[33] = 144 ;
			 SprY[34] = 128 ;
			 SprY[35] = 112 ;
			 SprY[36] = 96 ;
			 SprY[37] = 80 ;
			 SprY[38] = 160 ;
			 SprY[39] = 176 ;
			 SprY[40] = 192 ;
			 SprY[41] = 208 ;
			 SprY[42] = 144 ;
			 SprY[43] = 128 ;
			 SprY[44] = 128 ;
			 SprY[45] = 160 ;
			 SprY[46] = 160 ;
			 SprY[47] = 128 ;
			 SprY[48] = 128 ;
			 SprY[49] = 160 ;
			 SprY[50] = 160 ;
			 SprY[51] = 128 ;
			 SprY[52] = 160 ;
			 SprY[53] = 128 ;
			 SprY[54] = 160 ;
			 SprY[55] = 144 ;
			 SprY[56] = 144 ;
			 SprY[57] = 144 ;
			 SprY[58] = 169 ;
			
			
			return SprY;
		}
	

		// World : battleLevel_06
		if(Name.indexOf("battleLevel_06")>=0){
			int[] SprY = new int[64];
			// sprite count : 64
			 SprY[0] = 96 ;
			 SprY[1] = 208 ;
			 SprY[2] = 177 ;
			 SprY[3] = 128 ;
			 SprY[4] = 96 ;
			 SprY[5] = 208 ;
			 SprY[6] = 176 ;
			 SprY[7] = 128 ;
			 SprY[8] = 96 ;
			 SprY[9] = 208 ;
			 SprY[10] = 176 ;
			 SprY[11] = 128 ;
			 SprY[12] = 96 ;
			 SprY[13] = 208 ;
			 SprY[14] = 176 ;
			 SprY[15] = 128 ;
			 SprY[16] = 96 ;
			 SprY[17] = 208 ;
			 SprY[18] = 176 ;
			 SprY[19] = 128 ;
			 SprY[20] = 96 ;
			 SprY[21] = 208 ;
			 SprY[22] = 64 ;
			 SprY[23] = 80 ;
			 SprY[24] = 96 ;
			 SprY[25] = 112 ;
			 SprY[26] = 128 ;
			 SprY[27] = 144 ;
			 SprY[28] = 160 ;
			 SprY[29] = 176 ;
			 SprY[30] = 192 ;
			 SprY[31] = 208 ;
			 SprY[32] = 224 ;
			 SprY[33] = 256 ;
			 SprY[34] = 240 ;
			 SprY[35] = 80 ;
			 SprY[36] = 96 ;
			 SprY[37] = 112 ;
			 SprY[38] = 96 ;
			 SprY[39] = 160 ;
			 SprY[40] = 144 ;
			 SprY[41] = 176 ;
			 SprY[42] = 160 ;
			 SprY[43] = 224 ;
			 SprY[44] = 208 ;
			 SprY[45] = 240 ;
			 SprY[46] = 224 ;
			 SprY[47] = 80 ;
			 SprY[48] = 240 ;
			 SprY[49] = 80 ;
			 SprY[50] = 240 ;
			 SprY[51] = 80 ;
			 SprY[52] = 240 ;
			 SprY[53] = 80 ;
			 SprY[54] = 240 ;
			 SprY[55] = 80 ;
			 SprY[56] = 240 ;
			 SprY[57] = 96 ;
			 SprY[58] = 144 ;
			 SprY[59] = 176 ;
			 SprY[60] = 208 ;
			 SprY[61] = 128 ;
			 SprY[62] = 192 ;
			 SprY[63] = 172 ;
			
			
			return SprY;
		}
	

		// World : bossLevel_01
		if(Name.indexOf("bossLevel_01")>=0){
			int[] SprY = new int[22];
			// sprite count : 22
			 SprY[0] = 160 ;
			 SprY[1] = 96 ;
			 SprY[2] = 128 ;
			 SprY[3] = 160 ;
			 SprY[4] = 192 ;
			 SprY[5] = 144 ;
			 SprY[6] = 144 ;
			 SprY[7] = 192 ;
			 SprY[8] = 112 ;
			 SprY[9] = 176 ;
			 SprY[10] = 128 ;
			 SprY[11] = 208 ;
			 SprY[12] = 96 ;
			 SprY[13] = 128 ;
			 SprY[14] = 144 ;
			 SprY[15] = 160 ;
			 SprY[16] = 176 ;
			 SprY[17] = 192 ;
			 SprY[18] = 208 ;
			 SprY[19] = 112 ;
			 SprY[20] = 160 ;
			 SprY[21] = 153 ;
			
			
			return SprY;
		}
	

		// World : bossLevel_02
		if(Name.indexOf("bossLevel_02")>=0){
			int[] SprY = new int[48];
			// sprite count : 48
			 SprY[0] = 144 ;
			 SprY[1] = 272 ;
			 SprY[2] = 272 ;
			 SprY[3] = 256 ;
			 SprY[4] = 128 ;
			 SprY[5] = 144 ;
			 SprY[6] = 128 ;
			 SprY[7] = 144 ;
			 SprY[8] = 64 ;
			 SprY[9] = 80 ;
			 SprY[10] = 64 ;
			 SprY[11] = 80 ;
			 SprY[12] = 96 ;
			 SprY[13] = 96 ;
			 SprY[14] = 128 ;
			 SprY[15] = 144 ;
			 SprY[16] = 160 ;
			 SprY[17] = 176 ;
			 SprY[18] = 192 ;
			 SprY[19] = 112 ;
			 SprY[20] = 208 ;
			 SprY[21] = 144 ;
			 SprY[22] = 160 ;
			 SprY[23] = 176 ;
			 SprY[24] = 192 ;
			 SprY[25] = 128 ;
			 SprY[26] = 128 ;
			 SprY[27] = 144 ;
			 SprY[28] = 160 ;
			 SprY[29] = 176 ;
			 SprY[30] = 208 ;
			 SprY[31] = 224 ;
			 SprY[32] = 160 ;
			 SprY[33] = 144 ;
			 SprY[34] = 128 ;
			 SprY[35] = 192 ;
			 SprY[36] = 48 ;
			 SprY[37] = 32 ;
			 SprY[38] = 48 ;
			 SprY[39] = 288 ;
			 SprY[40] = 272 ;
			 SprY[41] = 272 ;
			 SprY[42] = 32 ;
			 SprY[43] = 48 ;
			 SprY[44] = 48 ;
			 SprY[45] = 64 ;
			 SprY[46] = 256 ;
			 SprY[47] = 157 ;
			
			
			return SprY;
		}
	

		// World : bossLevel_03
		if(Name.indexOf("bossLevel_03")>=0){
			int[] SprY = new int[55];
			// sprite count : 55
			 SprY[0] = 16 ;
			 SprY[1] = 16 ;
			 SprY[2] = 16 ;
			 SprY[3] = 96 ;
			 SprY[4] = 112 ;
			 SprY[5] = 128 ;
			 SprY[6] = 144 ;
			 SprY[7] = 160 ;
			 SprY[8] = 176 ;
			 SprY[9] = 192 ;
			 SprY[10] = 208 ;
			 SprY[11] = 224 ;
			 SprY[12] = 80 ;
			 SprY[13] = 64 ;
			 SprY[14] = 240 ;
			 SprY[15] = 256 ;
			 SprY[16] = 48 ;
			 SprY[17] = 96 ;
			 SprY[18] = 144 ;
			 SprY[19] = 192 ;
			 SprY[20] = 240 ;
			 SprY[21] = 144 ;
			 SprY[22] = 96 ;
			 SprY[23] = 192 ;
			 SprY[24] = 144 ;
			 SprY[25] = 80 ;
			 SprY[26] = 80 ;
			 SprY[27] = 80 ;
			 SprY[28] = 112 ;
			 SprY[29] = 112 ;
			 SprY[30] = 112 ;
			 SprY[31] = 144 ;
			 SprY[32] = 144 ;
			 SprY[33] = 144 ;
			 SprY[34] = 176 ;
			 SprY[35] = 176 ;
			 SprY[36] = 176 ;
			 SprY[37] = 208 ;
			 SprY[38] = 208 ;
			 SprY[39] = 208 ;
			 SprY[40] = 240 ;
			 SprY[41] = 240 ;
			 SprY[42] = 240 ;
			 SprY[43] = 272 ;
			 SprY[44] = 288 ;
			 SprY[45] = 304 ;
			 SprY[46] = 128 ;
			 SprY[47] = 144 ;
			 SprY[48] = 160 ;
			 SprY[49] = 112 ;
			 SprY[50] = 128 ;
			 SprY[51] = 144 ;
			 SprY[52] = 160 ;
			 SprY[53] = 176 ;
			 SprY[54] = 158 ;
			
			
			return SprY;
		}
	

		// World : bossLevel_04
		if(Name.indexOf("bossLevel_04")>=0){
			int[] SprY = new int[48];
			// sprite count : 48
			 SprY[0] = 256 ;
			 SprY[1] = 256 ;
			 SprY[2] = 256 ;
			 SprY[3] = 256 ;
			 SprY[4] = 256 ;
			 SprY[5] = 256 ;
			 SprY[6] = 256 ;
			 SprY[7] = 256 ;
			 SprY[8] = 256 ;
			 SprY[9] = 96 ;
			 SprY[10] = 176 ;
			 SprY[11] = 96 ;
			 SprY[12] = 176 ;
			 SprY[13] = 96 ;
			 SprY[14] = 176 ;
			 SprY[15] = 96 ;
			 SprY[16] = 176 ;
			 SprY[17] = 96 ;
			 SprY[18] = 176 ;
			 SprY[19] = 96 ;
			 SprY[20] = 176 ;
			 SprY[21] = 112 ;
			 SprY[22] = 144 ;
			 SprY[23] = 176 ;
			 SprY[24] = 112 ;
			 SprY[25] = 112 ;
			 SprY[26] = 160 ;
			 SprY[27] = 160 ;
			 SprY[28] = 112 ;
			 SprY[29] = 128 ;
			 SprY[30] = 144 ;
			 SprY[31] = 160 ;
			 SprY[32] = 128 ;
			 SprY[33] = 144 ;
			 SprY[34] = 176 ;
			 SprY[35] = 80 ;
			 SprY[36] = 192 ;
			 SprY[37] = 112 ;
			 SprY[38] = 160 ;
			 SprY[39] = 96 ;
			 SprY[40] = 176 ;
			 SprY[41] = 112 ;
			 SprY[42] = 160 ;
			 SprY[43] = 144 ;
			 SprY[44] = 144 ;
			 SprY[45] = 144 ;
			 SprY[46] = 0 ;
			 SprY[47] = 154 ;
			
			
			return SprY;
		}
	

		// World : bossLevel_05
		if(Name.indexOf("bossLevel_05")>=0){
			int[] SprY = new int[32];
			// sprite count : 32
			 SprY[0] = 160 ;
			 SprY[1] = 80 ;
			 SprY[2] = 224 ;
			 SprY[3] = 144 ;
			 SprY[4] = 176 ;
			 SprY[5] = 144 ;
			 SprY[6] = 224 ;
			 SprY[7] = 288 ;
			 SprY[8] = 304 ;
			 SprY[9] = 288 ;
			 SprY[10] = 208 ;
			 SprY[11] = 160 ;
			 SprY[12] = 160 ;
			 SprY[13] = 224 ;
			 SprY[14] = 112 ;
			 SprY[15] = 96 ;
			 SprY[16] = 224 ;
			 SprY[17] = 224 ;
			 SprY[18] = 128 ;
			 SprY[19] = 176 ;
			 SprY[20] = 224 ;
			 SprY[21] = 272 ;
			 SprY[22] = 272 ;
			 SprY[23] = 272 ;
			 SprY[24] = 272 ;
			 SprY[25] = 224 ;
			 SprY[26] = 192 ;
			 SprY[27] = 160 ;
			 SprY[28] = 112 ;
			 SprY[29] = 80 ;
			 SprY[30] = 192 ;
			 SprY[31] = 153 ;
			
			
			return SprY;
		}
	

		return null;
	}
	



	
}




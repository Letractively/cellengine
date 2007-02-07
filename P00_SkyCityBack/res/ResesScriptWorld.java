/* Encoding : 简体中文(GB2312) */
/* Cell Game Editor by WAZA Zhang */
/* Email : wazazhang@gmail.com */

//
// SkyCity Script v0.0.0
// 
// 指定文件输出
// <OUTPUT>     ..\[out]\ResesScriptWorld.java
// 

import com.morefuntek.cell.*;
import com.morefuntek.cell.Game.*;

public class ResesScriptWorld {

//--------------------------------------------------------------------------------------------------------------
// resource trunk
//--------------------------------------------------------------------------------------------------------------


	//--------------------------------------------------------------------------------------------------------------
	 
	// Images : worldMapTile 
	final static public IImages createClipImages_worldMapTile(){
		IImages stuff = new CImages20();
		stuff.buildImages(CIO.loadImage("/worldMapTile.png"),60);
		
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
		 stuff.addTile(0,128,16,16);//48 
		 stuff.addTile(16,128,16,16);//49 
		 stuff.addTile(32,128,16,16);//50 
		 stuff.addTile(48,128,16,16);//51 
		 stuff.addTile(64,128,16,16);//52 
		 stuff.addTile(80,128,16,16);//53 
		 stuff.addTile(0,144,16,16);//54 
		 stuff.addTile(16,144,16,16);//55 
		 stuff.addTile(32,144,16,16);//56 
		 stuff.addTile(48,144,16,16);//57 
		 stuff.addTile(64,144,16,16);//58 
		 stuff.addTile(80,144,16,16);//59 
		
		stuff.gc();
		
		return stuff;
	}
	
 
	// Images : worldEvtTile 
	final static public IImages createClipImages_worldEvtTile(){
		IImages stuff = new CImages20();
		stuff.buildImages(CIO.loadImage("/worldEvtTile.png"),13);
		
		 stuff.addTile(91,97,11,11);//0 
		 stuff.addTile(0,0,58,45);//1 
		 stuff.addTile(0,88,53,32);//2 
		 stuff.addTile(60,97,30,23);//3 
		 stuff.addTile(58,0,48,44);//4 
		 stuff.addTile(0,45,44,43);//5 
		 stuff.addTile(53,45,49,52);//6 
		 stuff.addTile(102,44,46,41);//7 
		 stuff.addTile(106,0,47,42);//8 
		 stuff.addTile(102,86,43,45);//9 
		 stuff.addTile(1,120,9,16);//10 
		 stuff.addTile(10,120,9,16);//11 
		 stuff.addTile(19,120,9,16);//12 
		
		stuff.gc();
		
		return stuff;
	}
	
 
	// Images : worldSprTile 
	final static public IImages createClipImages_worldSprTile(){
		IImages stuff = new CImages20();
		stuff.buildImages(CIO.loadImage("/worldSprTile.png"),40);
		
		 stuff.addTile(0,0,19,23);//0 
		 stuff.addTile(19,0,18,22);//1 
		 stuff.addTile(37,0,19,23);//2 
		 stuff.addTile(0,23,21,26);//3 
		 stuff.addTile(39,23,21,26);//4 
		 stuff.addTile(21,23,18,25);//5 
		 stuff.addTile(0,49,27,25);//6 
		 stuff.addTile(27,49,27,25);//7 
		 stuff.addTile(0,74,10,7);//8 
		 stuff.addTile(10,74,8,5);//9 
		 stuff.addTile(18,74,5,5);//10 
		 stuff.addTile(23,74,10,7);//11 
		 stuff.addTile(33,74,8,5);//12 
		 stuff.addTile(41,74,5,5);//13 
		 stuff.addTile(46,74,7,7);//14 
		 stuff.addTile(54,49,5,4);//15 
		 stuff.addTile(54,53,4,4);//16 
		 stuff.addTile(54,57,7,7);//17 
		 stuff.addTile(54,64,5,4);//18 
		 stuff.addTile(54,68,4,4);//19 
		 stuff.addTile(53,74,7,7);//20 
		 stuff.addTile(75,10,5,4);//21 
		 stuff.addTile(77,32,4,4);//22 
		 stuff.addTile(60,76,4,4);//23 
		 stuff.addTile(64,76,5,4);//24 
		 stuff.addTile(72,40,7,7);//25 
		 stuff.addTile(75,0,8,10);//26 
		 stuff.addTile(56,0,6,8);//27 
		 stuff.addTile(56,8,6,5);//28 
		 stuff.addTile(56,13,8,10);//29 
		 stuff.addTile(60,40,6,8);//30 
		 stuff.addTile(66,40,6,5);//31 
		 stuff.addTile(61,59,17,17);//32 
		 stuff.addTile(60,23,17,17);//33 
		 stuff.addTile(64,0,11,23);//34 
		 stuff.addTile(61,48,22,11);//35 
		 stuff.addTile(77,28,4,4);//36 
		 stuff.addTile(75,14,2,2);//37 
		 stuff.addTile(75,16,8,7);//38 
		 stuff.addTile(77,23,5,5);//39 
		
		stuff.gc();
		
		return stuff;
	}
	
 
	// Images : worldUITile 
	final static public IImages createClipImages_worldUITile(){
		IImages stuff = new CImages20();
		stuff.buildImages(CIO.loadImage("/worldUITile.png"),31);
		
		 stuff.addTile(92,32,1,1);//0 
		 stuff.addTile(93,32,1,1);//1 
		 stuff.addTile(0,0,176,32);//2 
		 stuff.addTile(94,32,1,1);//3 
		 stuff.addTile(93,33,1,1);//4 
		 stuff.addTile(101,32,1,1);//5 
		 stuff.addTile(98,32,1,1);//6 
		 stuff.addTile(99,32,1,1);//7 
		 stuff.addTile(96,32,1,1);//8 
		 stuff.addTile(100,32,1,1);//9 
		 stuff.addTile(97,32,1,1);//10 
		 stuff.addTile(95,32,1,1);//11 
		 stuff.addTile(0,32,6,10);//12 
		 stuff.addTile(6,32,6,10);//13 
		 stuff.addTile(12,32,6,10);//14 
		 stuff.addTile(18,32,6,10);//15 
		 stuff.addTile(24,32,6,10);//16 
		 stuff.addTile(30,32,6,10);//17 
		 stuff.addTile(36,32,6,10);//18 
		 stuff.addTile(42,32,6,10);//19 
		 stuff.addTile(48,32,6,10);//20 
		 stuff.addTile(54,32,6,10);//21 
		 stuff.addTile(60,32,7,10);//22 
		 stuff.addTile(67,32,5,10);//23 
		 stuff.addTile(80,32,10,10);//24 
		 stuff.addTile(72,32,8,10);//25 
		 stuff.addTile(90,32,2,2);//26 
		 stuff.addTile(92,33,1,1);//27 
		 stuff.addTile(94,33,1,1);//28 
		 stuff.addTile(102,32,4,10);//29 
		 stuff.addTile(106,32,4,10);//30 
		
		stuff.gc();
		
		return stuff;
	}
	


	//--------------------------------------------------------------------------------------------------------------
	
	// Map : wdMap
	final static public CMap createMap_wdMap(IImages tiles,boolean isAnimate,boolean isCyc){
		
		//36 x 36
		
		// tiles
	    CAnimates animates = new CAnimates(46,tiles);
	     animates.addPart(0,0,35,0);//0
		 animates.addPart(0,0,14,0);//1
		 animates.addPart(0,0,15,0);//2
		 animates.addPart(0,0,0,0);//3
		 animates.addPart(0,0,1,0);//4
		 animates.addPart(0,0,4,0);//5
		 animates.addPart(0,0,5,0);//6
		 animates.addPart(0,0,9,0);//7
		 animates.addPart(0,0,20,0);//8
		 animates.addPart(0,0,21,0);//9
		 animates.addPart(0,0,22,0);//10
		 animates.addPart(0,0,6,0);//11
		 animates.addPart(0,0,7,0);//12
		 animates.addPart(0,0,10,0);//13
		 animates.addPart(0,0,11,0);//14
		 animates.addPart(0,0,2,0);//15
		 animates.addPart(0,0,3,0);//16
		 animates.addPart(0,0,50,0);//17
		 animates.addPart(0,0,25,0);//18
		 animates.addPart(0,0,49,0);//19
		 animates.addPart(0,0,8,0);//20
		 animates.addPart(0,0,24,0);//21
		 animates.addPart(0,0,28,0);//22
		 animates.addPart(0,0,29,0);//23
		 animates.addPart(0,0,12,0);//24
		 animates.addPart(0,0,13,0);//25
		 animates.addPart(0,0,43,0);//26
		 animates.addPart(0,0,44,0);//27
		 animates.addPart(0,0,16,0);//28
		 animates.addPart(0,0,17,0);//29
		 animates.addPart(0,0,30,0);//30
		 animates.addPart(0,0,31,0);//31
		 animates.addPart(0,0,34,0);//32
		 animates.addPart(0,0,18,0);//33
		 animates.addPart(0,0,19,0);//34
		 animates.addPart(0,0,23,0);//35
		 animates.addPart(0,0,26,0);//36
		 animates.addPart(0,0,27,0);//37
		 animates.addPart(0,0,32,0);//38
		 animates.addPart(0,0,33,0);//39
		 animates.addPart(0,0,51,0);//40
		 animates.addPart(0,0,41,0);//41
		 animates.addPart(0,0,47,0);//42
		 animates.addPart(0,0,58,0);//43
		 animates.addPart(0,0,59,0);//44
		 animates.addPart(0,0,52,0);//45
		
		
	    animates.setFrame(new int[47][]);
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
		 animates.setComboFrame(new int[]{45,45,45,0,0,0,0,0,0,0,0,},45);//45
		 animates.setComboFrame(new int[]{45,45,45,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},46);//46
		
		
		short[][] tileMatrix = new short[][]{
			{0,0,0,0,0,0,0,1,2,0,0,0,0,0,0,0,0,0,0,3,4,5,6,0,0,0,0,0,0,0,0,0,7,0,7,0,},
{0,0,7,0,0,0,0,8,9,0,0,0,10,0,0,0,0,0,0,11,12,13,14,0,7,0,0,3,4,5,6,0,0,0,0,0,},
{0,0,3,4,15,16,5,6,0,0,0,0,0,0,0,-45,0,3,4,17,18,18,19,5,6,0,0,11,12,13,14,0,0,0,0,0,},
{0,0,11,12,20,18,13,14,0,0,-46,0,0,0,0,0,0,11,12,18,18,18,18,13,14,0,0,21,18,22,23,0,0,10,0,0,},
{0,0,24,25,26,27,28,29,0,0,0,0,0,3,4,15,16,17,18,26,27,18,18,18,19,5,6,30,31,32,0,0,0,0,0,0,},
{0,0,33,34,19,17,18,35,0,0,0,0,0,11,12,20,18,18,18,19,17,18,18,18,18,13,4,15,15,16,5,6,0,0,0,0,},
{0,0,21,18,36,37,22,23,0,7,0,0,0,24,25,18,18,18,18,18,18,18,18,18,18,18,18,20,20,18,13,14,0,0,0,0,},
{0,7,30,31,38,39,32,0,0,0,0,0,0,33,25,18,40,40,40,40,40,40,40,40,40,40,40,40,40,18,18,41,10,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,21,18,18,18,40,40,40,40,40,40,40,40,40,26,27,40,40,28,42,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,7,0,0,0,30,31,27,40,40,40,40,40,40,40,40,40,40,19,17,40,40,28,29,0,0,0,0,},
{0,0,0,0,0,7,0,0,0,0,0,0,0,0,0,21,18,40,40,40,40,40,40,40,40,40,40,40,40,40,18,42,0,0,7,0,},
{0,1,2,0,0,0,0,0,0,0,0,0,-45,0,0,30,31,27,18,40,40,40,40,40,40,40,40,40,40,40,28,29,0,0,0,0,},
{0,8,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,21,18,18,40,40,40,26,27,40,40,40,40,18,18,35,0,0,0,0,},
{0,0,0,0,0,0,0,3,4,5,6,0,0,0,0,0,0,30,31,27,18,18,18,19,17,40,40,40,40,40,18,35,0,0,0,-46,},
{0,0,0,0,0,0,0,11,12,13,14,0,0,0,0,0,7,0,0,21,18,36,37,18,18,18,18,18,36,37,22,23,0,0,0,0,},
{0,0,0,-45,0,0,0,21,18,22,23,0,0,0,0,0,0,10,0,30,31,38,39,43,44,43,44,31,38,39,32,0,0,0,0,0,},
{0,0,0,0,0,0,0,30,31,32,0,0,0,3,4,15,16,5,6,0,0,0,0,0,0,0,0,0,0,0,0,0,0,7,0,0,},
{7,0,10,0,0,0,0,0,0,0,0,0,0,11,12,20,18,13,14,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,1,2,0,0,0,0,0,0,0,24,25,18,26,27,29,0,0,0,0,0,0,0,0,0,0,0,-45,0,0,0,0,0,},
{0,0,0,0,8,9,0,0,7,0,0,0,7,33,34,18,19,17,35,0,0,0,3,4,15,16,5,6,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,21,18,36,37,22,23,0,0,0,11,12,20,18,13,14,0,0,3,4,5,6,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,30,31,38,39,32,0,0,0,0,24,25,18,18,28,29,0,0,11,12,13,14,0,0,},
{0,0,0,0,7,0,0,3,4,15,16,5,6,0,0,0,0,0,0,0,0,7,33,34,18,18,18,35,0,0,21,18,22,23,0,0,},
{0,-46,0,0,0,0,10,11,12,20,18,18,14,0,0,3,4,5,6,-46,0,0,21,18,36,37,22,23,0,7,30,31,32,0,0,0,},
{0,0,0,3,4,15,16,17,18,26,27,18,13,14,0,11,12,13,14,0,0,0,30,31,38,39,32,0,0,0,0,0,0,0,0,0,},
{0,0,0,11,12,20,18,18,18,19,17,18,28,29,0,21,18,22,23,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,24,25,18,18,18,18,18,18,18,18,35,0,30,31,32,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,0,},
{0,0,0,33,25,18,40,40,40,40,40,40,22,23,0,0,0,0,0,0,0,0,0,0,7,0,0,0,1,2,0,0,0,8,9,0,},
{0,0,0,21,18,18,18,40,40,40,40,40,42,0,7,0,0,3,4,16,5,6,0,0,0,0,0,0,8,9,0,0,0,0,0,0,},
{0,0,0,30,31,27,40,40,40,40,40,40,19,5,16,16,5,18,18,18,13,14,0,-45,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,7,0,0,0,21,18,40,40,40,40,40,40,40,40,20,40,40,26,27,18,42,0,0,0,1,2,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,30,31,27,18,40,40,40,40,40,40,40,40,40,19,17,28,29,0,0,0,8,9,0,0,0,3,4,5,6,0,0,},
{0,3,4,5,6,0,0,21,18,18,40,40,40,18,18,18,40,40,40,18,18,35,0,0,0,0,0,0,0,0,11,12,13,14,0,0,},
{0,11,12,13,14,0,0,30,31,27,18,18,18,18,18,40,40,40,40,40,18,35,0,0,0,0,0,0,0,0,21,18,22,23,0,0,},
{0,21,18,22,23,0,1,2,0,21,18,36,37,22,43,44,43,44,31,38,39,32,0,0,7,0,0,0,-46,0,30,31,32,0,7,0,},
{0,30,31,32,0,0,8,9,0,30,31,38,39,32,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},

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
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},

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
	
	// Sprite : wdEvents
	final static public CSprite createSprite_wdEvents(IImages tiles){

	    // tiles
	    CAnimates animates = new CAnimates(17,tiles);
	     animates.addPart(-28,-12,1,0);//0
		 animates.addPart(-26,-11,2,0);//1
		 animates.addPart(-14,-7,3,0);//2
		 animates.addPart(-24,-30,4,0);//3
		 animates.addPart(-29,-11,1,0);//4
		 animates.addPart(-23,-30,8,0);//5
		 animates.addPart(-29,-10,1,0);//6
		 animates.addPart(-22,-30,5,0);//7
		 animates.addPart(-28,-11,1,0);//8
		 animates.addPart(-27,-37,6,0);//9
		 animates.addPart(-31,-11,1,0);//10
		 animates.addPart(-24,-28,7,0);//11
		 animates.addPart(-29,-12,1,0);//12
		 animates.addPart(-20,-31,9,0);//13
		 animates.addPart(-4,-49,10,0);//14
		 animates.addPart(-4,-49,11,0);//15
		 animates.addPart(-4,-49,12,0);//16
		
		
	    animates.setFrame(new int[12][]);
	     animates.setComboFrame(new int[]{0,},0);//0
		 animates.setComboFrame(new int[]{1,},1);//1
		 animates.setComboFrame(new int[]{2,},2);//2
		 animates.setComboFrame(new int[]{3,4,},3);//3
		 animates.setComboFrame(new int[]{5,6,},4);//4
		 animates.setComboFrame(new int[]{7,8,},5);//5
		 animates.setComboFrame(new int[]{9,10,},6);//6
		 animates.setComboFrame(new int[]{11,12,},7);//7
		 animates.setComboFrame(new int[]{13,8,},8);//8
		 animates.setComboFrame(new int[]{14,},9);//9
		 animates.setComboFrame(new int[]{15,},10);//10
		 animates.setComboFrame(new int[]{16,},11);//11
		
		
		// cds
	    CCollides collides = new CCollides(14);
		 collides.addCDRect(65535, -23, -9, 45 , 21 );//rect//0
	     collides.addCDRect(65535, -20, -7, 41 , 16 );//rect//1
	     collides.addCDRect(65535, -24, -14, 49 , 28 );//rect//2
	     collides.addCDRect(65535, -11, -6, 22 , 12 );//rect//3
	     collides.addCDRect(65535, -14, -10, 30 , 20 );//rect//4
	     collides.addCDRect(65535, -27, -5, 54 , 25 );//rect//5
	     collides.addCDRect(65535, -33, -9, 66 , 35 );//rect//6
	     collides.addCDRect(65535, -32, -10, 64 , 36 );//rect//7
	     collides.addCDRect(65535, -27, -6, 54 , 25 );//rect//8
	     collides.addCDRect(65535, -28, -5, 52 , 25 );//rect//9
	     collides.addCDRect(65535, -27, -8, 54 , 25 );//rect//10
	     collides.addCDRect(65535, -31, -13, 64 , 36 );//rect//11
	     collides.addCDRect(65535, -26, -8, 54 , 25 );//rect//12
	     collides.addCDRect(65535, -30, -13, 64 , 36 );//rect//13
	    
	    
	    collides.setFrame(new int[15][]);
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
	    
	    
	    
		// sprite frame
/*
		String[] frameName = new String[]{
			"0000",
"0001",
"0002",
"0004",
"0005",
"0006",
"0007",
"0008",
"0009",
"0010",

		};
		
		for(int i=0;i<frameName.length;i++){
			System.out.println(frameName[i]);
		}
*/
	    int[][] frameAnimate = new int[][]{
	        {0,},
{1,},
{2,},
{3,},
{4,},
{5,},
{6,},
{7,},
{8,},
{9,10,11,},

	    };
	    int[][] frameCDMap = new int[][]{
	        {0,},
{2,},
{4,},
{6,},
{6,},
{9,},
{10,},
{11,},
{13,},
{1,1,1,},

	    };
	    int[][] frameCDAtk = new int[][]{
	        {1,},
{1,},
{1,},
{1,},
{1,},
{1,},
{1,},
{1,},
{1,},
{1,1,1,},

	    };
	    int[][] frameCDDef = new int[][]{
	        {1,},
{1,},
{1,},
{1,},
{1,},
{1,},
{1,},
{1,},
{1,},
{1,1,1,},

	    };
	    int[][] frameCDExt = new int[][]{
	        {1,},
{3,},
{5,},
{7,},
{8,},
{8,},
{8,},
{12,},
{14,},
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
	

	// Sprite : wdSprite
	final static public CSprite createSprite_wdSprite(IImages tiles){

	    // tiles
	    CAnimates animates = new CAnimates(45,tiles);
	     animates.addPart(-19,0,11,0);//0
		 animates.addPart(-13,-19,7,0);//1
		 animates.addPart(-3,-4,12,0);//2
		 animates.addPart(-17,1,12,0);//3
		 animates.addPart(-14,1,13,0);//4
		 animates.addPart(-14,-11,20,0);//5
		 animates.addPart(-11,-15,4,0);//6
		 animates.addPart(-12,-8,21,0);//7
		 animates.addPart(-11,-8,22,0);//8
		 animates.addPart(-9,-11,5,0);//9
		 animates.addPart(-4,-17,29,0);//10
		 animates.addPart(-3,-15,30,0);//11
		 animates.addPart(-3,-13,31,0);//12
		 animates.addPart(8,-11,25,0);//13
		 animates.addPart(-9,-15,3,0);//14
		 animates.addPart(8,-8,24,0);//15
		 animates.addPart(8,-8,23,0);//16
		 animates.addPart(10,0,8,0);//17
		 animates.addPart(-13,-19,6,0);//18
		 animates.addPart(10,1,9,0);//19
		 animates.addPart(10,1,10,0);//20
		 animates.addPart(5,7,14,0);//21
		 animates.addPart(-10,-13,0,0);//22
		 animates.addPart(5,7,15,0);//23
		 animates.addPart(5,7,16,0);//24
		 animates.addPart(-4,10,26,0);//25
		 animates.addPart(-9,-11,1,0);//26
		 animates.addPart(-3,10,27,0);//27
		 animates.addPart(-3,10,28,0);//28
		 animates.addPart(-11,6,17,0);//29
		 animates.addPart(-8,-14,2,0);//30
		 animates.addPart(-9,6,18,0);//31
		 animates.addPart(-8,6,19,0);//32
		 animates.addPart(-11,-5,35,0);//33
		 animates.addPart(-8,-8,33,0);//34
		 animates.addPart(-5,-11,34,0);//35
		 animates.addPart(-8,-8,32,0);//36
		 animates.addPart(-11,-5,35,2);//37
		 animates.addPart(-8,-8,32,2);//38
		 animates.addPart(-5,-11,34,1);//39
		 animates.addPart(-8,-8,33,2);//40
		 animates.addPart(-1,-1,37,0);//41
		 animates.addPart(-2,-2,36,0);//42
		 animates.addPart(-2,-2,39,0);//43
		 animates.addPart(-4,-3,38,0);//44
		
		
	    animates.setFrame(new int[37][]);
	     animates.setComboFrame(new int[]{0,1,2,},0);//0
		 animates.setComboFrame(new int[]{3,1,},1);//1
		 animates.setComboFrame(new int[]{4,1,},2);//2
		 animates.setComboFrame(new int[]{5,6,},3);//3
		 animates.setComboFrame(new int[]{7,6,},4);//4
		 animates.setComboFrame(new int[]{8,6,},5);//5
		 animates.setComboFrame(new int[]{9,10,},6);//6
		 animates.setComboFrame(new int[]{9,11,},7);//7
		 animates.setComboFrame(new int[]{9,12,},8);//8
		 animates.setComboFrame(new int[]{13,14,},9);//9
		 animates.setComboFrame(new int[]{15,14,},10);//10
		 animates.setComboFrame(new int[]{16,14,},11);//11
		 animates.setComboFrame(new int[]{17,18,},12);//12
		 animates.setComboFrame(new int[]{19,18,},13);//13
		 animates.setComboFrame(new int[]{20,18,},14);//14
		 animates.setComboFrame(new int[]{21,22,},15);//15
		 animates.setComboFrame(new int[]{23,22,},16);//16
		 animates.setComboFrame(new int[]{24,22,},17);//17
		 animates.setComboFrame(new int[]{25,26,},18);//18
		 animates.setComboFrame(new int[]{27,26,},19);//19
		 animates.setComboFrame(new int[]{28,26,},20);//20
		 animates.setComboFrame(new int[]{29,30,},21);//21
		 animates.setComboFrame(new int[]{31,30,},22);//22
		 animates.setComboFrame(new int[]{32,30,},23);//23
		 animates.setComboFrame(new int[]{33,},24);//24
		 animates.setComboFrame(new int[]{},25);//25
		 animates.setComboFrame(new int[]{34,},26);//26
		 animates.setComboFrame(new int[]{35,},27);//27
		 animates.setComboFrame(new int[]{36,},28);//28
		 animates.setComboFrame(new int[]{37,},29);//29
		 animates.setComboFrame(new int[]{38,},30);//30
		 animates.setComboFrame(new int[]{39,},31);//31
		 animates.setComboFrame(new int[]{40,},32);//32
		 animates.setComboFrame(new int[]{41,},33);//33
		 animates.setComboFrame(new int[]{42,},34);//34
		 animates.setComboFrame(new int[]{43,},35);//35
		 animates.setComboFrame(new int[]{44,},36);//36
		
		
		// cds
	    CCollides collides = new CCollides(9);
		 collides.addCDRect(65535, -4, -4, 8 , 8 );//rect//0
	     collides.addCDRect(65535, -6, -7, 12 , 14 );//rect//1
	     collides.addCDRect(65535, -3, -4, 8 , 8 );//rect//2
	     collides.addCDRect(65535, -7, -7, 14 , 16 );//rect//3
	     collides.addCDRect(65535, -5, -5, 8 , 8 );//rect//4
	     collides.addCDRect(65535, -8, -8, 14 , 14 );//rect//5
	     collides.addCDRect(65535, -4, -5, 8 , 8 );//rect//6
	     collides.addCDRect(65535, -7, -8, 14 , 14 );//rect//7
	     collides.addCDRect(65535, -7, -9, 14 , 14 );//rect//8
	    
	    
	    collides.setFrame(new int[10][]);
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
	    
	    
	    
		// sprite frame
/*
		String[] frameName = new String[]{
			"0",
"45",
"90",
"135",
"180",
"225",
"270",
"315",
"s0",
"s45",
"s90",
"s135",
"s180",
"s225",
"s270",
"s315",
"smokeU",
"smokeD",

		};
		
		for(int i=0;i<frameName.length;i++){
			System.out.println(frameName[i]);
		}
*/
	    int[][] frameAnimate = new int[][]{
	        {0,0,1,1,2,2,},
{3,3,4,4,5,5,},
{6,6,7,7,8,8,},
{9,9,10,10,11,11,},
{12,12,13,13,14,14,},
{15,15,16,16,17,17,},
{18,18,19,19,20,20,},
{21,21,22,22,23,23,},
{24,25,},
{26,25,},
{27,25,},
{28,25,},
{29,25,},
{30,25,},
{31,25,},
{32,25,},
{33,33,33,34,34,34,35,35,35,36,36,36,},
{36,36,36,35,35,35,34,34,34,33,33,33,},

	    };
	    int[][] frameCDMap = new int[][]{
	        {0,1,1,1,1,1,},
{3,1,1,1,1,1,},
{0,1,1,1,1,1,},
{5,1,1,1,1,1,},
{5,1,1,1,1,1,},
{7,1,1,1,1,1,},
{5,1,1,1,1,1,},
{7,1,1,1,1,1,},
{1,1,},
{1,1,},
{1,1,},
{1,1,},
{1,1,},
{1,1,},
{1,1,},
{1,1,},
{1,1,1,1,1,1,1,1,1,1,1,1,},
{1,1,1,1,1,1,1,1,1,1,1,1,},

	    };
	    int[][] frameCDAtk = new int[][]{
	        {1,1,1,1,1,1,},
{1,1,1,1,1,1,},
{1,1,1,1,1,1,},
{1,1,1,1,1,1,},
{1,1,1,1,1,1,},
{1,1,1,1,1,1,},
{1,1,1,1,1,1,},
{1,1,1,1,1,1,},
{1,1,},
{1,1,},
{1,1,},
{1,1,},
{1,1,},
{1,1,},
{1,1,},
{1,1,},
{1,1,1,1,1,1,1,1,1,1,1,1,},
{1,1,1,1,1,1,1,1,1,1,1,1,},

	    };
	    int[][] frameCDDef = new int[][]{
	        {1,1,1,1,1,1,},
{1,1,1,1,1,1,},
{1,1,1,1,1,1,},
{1,1,1,1,1,1,},
{1,1,1,1,1,1,},
{1,1,1,1,1,1,},
{1,1,1,1,1,1,},
{1,1,1,1,1,1,},
{1,1,},
{1,1,},
{1,1,},
{1,1,},
{1,1,},
{1,1,},
{1,1,},
{1,1,},
{1,1,1,1,1,1,1,1,1,1,1,1,},
{1,1,1,1,1,1,1,1,1,1,1,1,},

	    };
	    int[][] frameCDExt = new int[][]{
	        {2,2,2,2,2,2,},
{2,2,2,2,2,2,},
{4,4,4,4,4,4,},
{6,6,6,6,6,6,},
{6,6,6,6,6,6,},
{8,8,8,8,8,8,},
{6,6,6,6,6,6,},
{9,9,9,9,9,9,},
{1,1,},
{1,1,},
{1,1,},
{1,1,},
{1,1,},
{1,1,},
{1,1,},
{1,1,},
{1,1,1,1,1,1,1,1,1,1,1,1,},
{1,1,1,1,1,1,1,1,1,1,1,1,},

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
	

	// Sprite : wdSmoke
	final static public CSprite createSprite_wdSmoke(IImages tiles){

	    // tiles
	    CAnimates animates = new CAnimates(4,tiles);
	     animates.addPart(-4,-3,38,0);//0
		 animates.addPart(-2,-2,39,0);//1
		 animates.addPart(-2,-2,36,0);//2
		 animates.addPart(-1,-1,37,0);//3
		
		
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

		};
		
		for(int i=0;i<frameName.length;i++){
			System.out.println(frameName[i]);
		}
*/
	    int[][] frameAnimate = new int[][]{
	        {0,1,2,3,},

	    };
	    int[][] frameCDMap = new int[][]{
	        {0,0,0,0,},

	    };
	    int[][] frameCDAtk = new int[][]{
	        {0,0,0,0,},

	    };
	    int[][] frameCDDef = new int[][]{
	        {0,0,0,0,},

	    };
	    int[][] frameCDExt = new int[][]{
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
	

	// Sprite : munberSprite
	final static public CSprite createSprite_munberSprite(IImages tiles){

	    // tiles
	    CAnimates animates = new CAnimates(15,tiles);
	     animates.addPart(0,0,12,0);//0
		 animates.addPart(0,0,13,0);//1
		 animates.addPart(0,0,14,0);//2
		 animates.addPart(0,0,15,0);//3
		 animates.addPart(0,0,16,0);//4
		 animates.addPart(0,0,17,0);//5
		 animates.addPart(0,0,18,0);//6
		 animates.addPart(0,0,19,0);//7
		 animates.addPart(0,0,20,0);//8
		 animates.addPart(0,0,21,0);//9
		 animates.addPart(0,0,26,0);//10
		 animates.addPart(0,0,22,0);//11
		 animates.addPart(0,0,23,0);//12
		 animates.addPart(0,0,25,0);//13
		 animates.addPart(0,0,24,0);//14
		
		
	    animates.setFrame(new int[15][]);
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
	        {0,1,2,3,4,5,6,7,8,9,},
{10,},
{11,},
{12,},
{13,},
{14,},

	    };
	    int[][] frameCDMap = new int[][]{
	        {0,0,0,0,0,0,0,0,0,0,},
{0,},
{0,},
{0,},
{0,},
{0,},

	    };
	    int[][] frameCDAtk = new int[][]{
	        {0,0,0,0,0,0,0,0,0,0,},
{0,},
{0,},
{0,},
{0,},
{0,},

	    };
	    int[][] frameCDDef = new int[][]{
	        {0,0,0,0,0,0,0,0,0,0,},
{0,},
{0,},
{0,},
{0,},
{0,},

	    };
	    int[][] frameCDExt = new int[][]{
	        {0,0,0,0,0,0,0,0,0,0,},
{0,},
{0,},
{0,},
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
	

	// Sprite : titleSprite
	final static public CSprite createSprite_titleSprite(IImages tiles){

	    // tiles
	    CAnimates animates = new CAnimates(1,tiles);
	     animates.addPart(0,0,2,0);//0
		
		
	    animates.setFrame(new int[1][]);
	     animates.setComboFrame(new int[]{0,},0);//0
		
		
		// cds
	    CCollides collides = new CCollides(6);
		 collides.addCDRect(65535, 112, 11, 4 , 10 );//rect//0
	     collides.addCDRect(65535, 77, 4, 24 , 24 );//rect//1
	     collides.addCDRect(65535, 9, 12, 6 , 10 );//rect//2
	     collides.addCDRect(65535, 40, 12, 6 , 10 );//rect//3
	     collides.addCDRect(65535, 58, 12, 10 , 10 );//rect//4
	     collides.addCDRect(65535, 28, 12, 10 , 10 );//rect//5
	    
	    
	    collides.setFrame(new int[2][]);
	     collides.setComboFrame(new int[]{0,1,2,3,4,5,},0);//0
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
	



	//--------------------------------------------------------------------------------------------------------------
	
	 
	final public static String images_worldMapTile = "worldMapTile";
	
 
	final public static String images_worldEvtTile = "worldEvtTile";
	
 
	final public static String images_worldSprTile = "worldSprTile";
	
 
	final public static String images_worldUITile = "worldUITile";
	


	
	final public static String map_wdMap = "wdMap";
	

	
	
	final public static String spr_wdEvents = "wdEvents";
	

	final public static String spr_wdSprite = "wdSprite";
	

	final public static String spr_wdSmoke = "wdSmoke";
	

	final public static String spr_munberSprite = "munberSprite";
	

	final public static String spr_titleSprite = "titleSprite";
	



	//--------------------------------------------------------------------------------------------------------------
	final public static IImages createImages(String key){
	 
		if(key.indexOf("worldMapTile")>=0){
			return createClipImages_worldMapTile();
		}
	
 
		if(key.indexOf("worldEvtTile")>=0){
			return createClipImages_worldEvtTile();
		}
	
 
		if(key.indexOf("worldSprTile")>=0){
			return createClipImages_worldSprTile();
		}
	
 
		if(key.indexOf("worldUITile")>=0){
			return createClipImages_worldUITile();
		}
	

		return null;
	}
	
	final public static CMap createMap(String key, IImages tiles, boolean isAnimate, boolean isCyc){
	
		if(key.indexOf("wdMap")>=0){
			return createMap_wdMap(tiles,isAnimate,isCyc);
		}
	

		return null;
	}
	
	final public static CSprite createSprite(String key, IImages tiles){
	
		if(key.indexOf("wdEvents")>=0){
			return createSprite_wdEvents(tiles);
		}
	

		if(key.indexOf("wdSprite")>=0){
			return createSprite_wdSprite(tiles);
		}
	

		if(key.indexOf("wdSmoke")>=0){
			return createSprite_wdSmoke(tiles);
		}
	

		if(key.indexOf("munberSprite")>=0){
			return createSprite_munberSprite(tiles);
		}
	

		if(key.indexOf("titleSprite")>=0){
			return createSprite_titleSprite(tiles);
		}
	

		return null;
	}




//--------------------------------------------------------------------------------------------------------------
// level trunk
//--------------------------------------------------------------------------------------------------------------

	

	 
	final public static String world_worldMap = "worldMap";
	




	final static public String[] WorldNames = new String[]{
	 "worldMap",
	

	};


	final static public int getWorldWidth(String Name){
	
		// World : worldMap
		if(Name.indexOf("worldMap")>=0){
			return 2880;
		}
	

		return -1;
	}

	final static public int getWorldHeight(String Name){
	
		// World : worldMap
		if(Name.indexOf("worldMap")>=0){
			return 2880;
		}
	

		return -1;
	}

	
	final static public CWayPoint[] getWorldWayPoints(String Name){
	
		// World : worldMap
		if(Name.indexOf("worldMap")>=0){
			// waypoint count : 1
			CWayPoint[] WayPoints = new CWayPoint[1];
			 WayPoints[0] = new CWayPoint(2880,2880);
			
			
			// waypoint link 
			
			
			return WayPoints;
		}
	

		return null;
	}


	final static public String getWorldMapTile(String Name){
	
		// World : worldMap
		if(Name.indexOf("worldMap")>=0){
			 return "worldMapTile";
			
		}
	

		return null;
	}

	final static public String getWorldMapType(String Name){
	
		// World : worldMap
		if(Name.indexOf("worldMap")>=0){
			 return "wdMap";
			
		}
	

		return null;
	}

	final static public String getWorldMapName(String Name){
	
		// World : worldMap
		if(Name.indexOf("worldMap")>=0){
			 return "Map0000_world_Map";
			
		}
	

		return null;
	}
	
	final static public String[] getWorldSprTile(String Name){
	
		// World : worldMap
		if(Name.indexOf("worldMap")>=0){
			String[] SprTile = new String[40];
			// sprite count : 40
			 SprTile[0] = "worldEvtTile";
			 SprTile[1] = "worldEvtTile";
			 SprTile[2] = "worldEvtTile";
			 SprTile[3] = "worldEvtTile";
			 SprTile[4] = "worldEvtTile";
			 SprTile[5] = "worldEvtTile";
			 SprTile[6] = "worldEvtTile";
			 SprTile[7] = "worldEvtTile";
			 SprTile[8] = "worldEvtTile";
			 SprTile[9] = "worldEvtTile";
			 SprTile[10] = "worldEvtTile";
			 SprTile[11] = "worldEvtTile";
			 SprTile[12] = "worldEvtTile";
			 SprTile[13] = "worldEvtTile";
			 SprTile[14] = "worldEvtTile";
			 SprTile[15] = "worldEvtTile";
			 SprTile[16] = "worldEvtTile";
			 SprTile[17] = "worldEvtTile";
			 SprTile[18] = "worldEvtTile";
			 SprTile[19] = "worldEvtTile";
			 SprTile[20] = "worldEvtTile";
			 SprTile[21] = "worldEvtTile";
			 SprTile[22] = "worldEvtTile";
			 SprTile[23] = "worldEvtTile";
			 SprTile[24] = "worldEvtTile";
			 SprTile[25] = "worldEvtTile";
			 SprTile[26] = "worldEvtTile";
			 SprTile[27] = "worldEvtTile";
			 SprTile[28] = "worldEvtTile";
			 SprTile[29] = "worldEvtTile";
			 SprTile[30] = "worldEvtTile";
			 SprTile[31] = "worldEvtTile";
			 SprTile[32] = "worldEvtTile";
			 SprTile[33] = "worldEvtTile";
			 SprTile[34] = "worldEvtTile";
			 SprTile[35] = "worldEvtTile";
			 SprTile[36] = "worldEvtTile";
			 SprTile[37] = "worldEvtTile";
			 SprTile[38] = "worldEvtTile";
			 SprTile[39] = "worldEvtTile";
			
			
			return SprTile;
		}
	

		return null;
	}

	final static public String[] getWorldSprName(String Name){
	
		// World : worldMap
		if(Name.indexOf("worldMap")>=0){
			String[] SprName = new String[40];
			// sprite count : 40
			 SprName[0] = "s1_lv:battleLevel_00";
			 SprName[1] = "s2_lv:battleLevel_00";
			 SprName[2] = "feixu1_lv:battleLevel_03";
			 SprName[3] = "feixu2_lv:battleLevel_04";
			 SprName[4] = "feixu3_lv:battleLevel_05";
			 SprName[5] = "feixu4_lv:battleLevel_03";
			 SprName[6] = "feixu5_lv:battleLevel_04";
			 SprName[7] = "s3_lv:battleLevel_00";
			 SprName[8] = "s4_lv:battleLevel_00";
			 SprName[9] = "s5_lv:battleLevel_00";
			 SprName[10] = "s6_lv:battleLevel_01";
			 SprName[11] = "s7_lv:battleLevel_01";
			 SprName[12] = "s8_lv:battleLevel_01";
			 SprName[13] = "s9_lv:battleLevel_01";
			 SprName[14] = "s10_lv:battleLevel_01";
			 SprName[15] = "s11_lv:battleLevel_01";
			 SprName[16] = "s12_lv:battleLevel_02";
			 SprName[17] = "s13_lv:battleLevel_02";
			 SprName[18] = "s14_lv:battleLevel_02";
			 SprName[19] = "s15_lv:battleLevel_02";
			 SprName[20] = "s16_lv:battleLevel_02";
			 SprName[21] = "s17_lv:battleLevel_02";
			 SprName[22] = "feixu6_lv:battleLevel_05";
			 SprName[23] = "feixu7_lv:battleLevel_03";
			 SprName[24] = "feixu8_lv:battleLevel_04";
			 SprName[25] = "feixu9_lv:battleLevel_05";
			 SprName[26] = "s18_lv:battleLevel_00";
			 SprName[27] = "s19_lv:battleLevel_00";
			 SprName[28] = "s20_lv:battleLevel_01";
			 SprName[29] = "s21_lv:battleLevel_01";
			 SprName[30] = "s22_lv:battleLevel_01";
			 SprName[31] = "s23_lv:battleLevel_02";
			 SprName[32] = "s24_lv:battleLevel_00";
			 SprName[33] = "build01_lv:bossLevel_03";
			 SprName[34] = "build02_lv:bossLevel_04";
			 SprName[35] = "build03_lv:bossLevel_05";
			 SprName[36] = "build04_lv:bossLevel_02";
			 SprName[37] = "build05_lv:bossLevel_05";
			 SprName[38] = "build07_lv:bossLevel_01";
			 SprName[39] = "build06_lv:bossLevel_02";
			
			
			return SprName;
		}
	

		return null;
	}
	
	final static public String[] getWorldSprType(String Name){
	
		// World : worldMap
		if(Name.indexOf("worldMap")>=0){
			String[] SprID = new String[40];
			// sprite count : 40
			 SprID[0] = "wdEvents";
			 SprID[1] = "wdEvents";
			 SprID[2] = "wdEvents";
			 SprID[3] = "wdEvents";
			 SprID[4] = "wdEvents";
			 SprID[5] = "wdEvents";
			 SprID[6] = "wdEvents";
			 SprID[7] = "wdEvents";
			 SprID[8] = "wdEvents";
			 SprID[9] = "wdEvents";
			 SprID[10] = "wdEvents";
			 SprID[11] = "wdEvents";
			 SprID[12] = "wdEvents";
			 SprID[13] = "wdEvents";
			 SprID[14] = "wdEvents";
			 SprID[15] = "wdEvents";
			 SprID[16] = "wdEvents";
			 SprID[17] = "wdEvents";
			 SprID[18] = "wdEvents";
			 SprID[19] = "wdEvents";
			 SprID[20] = "wdEvents";
			 SprID[21] = "wdEvents";
			 SprID[22] = "wdEvents";
			 SprID[23] = "wdEvents";
			 SprID[24] = "wdEvents";
			 SprID[25] = "wdEvents";
			 SprID[26] = "wdEvents";
			 SprID[27] = "wdEvents";
			 SprID[28] = "wdEvents";
			 SprID[29] = "wdEvents";
			 SprID[30] = "wdEvents";
			 SprID[31] = "wdEvents";
			 SprID[32] = "wdEvents";
			 SprID[33] = "wdEvents";
			 SprID[34] = "wdEvents";
			 SprID[35] = "wdEvents";
			 SprID[36] = "wdEvents";
			 SprID[37] = "wdEvents";
			 SprID[38] = "wdEvents";
			 SprID[39] = "wdEvents";
			
			
			return SprID;
		}
	

		return null;
	}
	
	final static public int[] getWorldSprAnim(String Name){
	
		// World : worldMap
		if(Name.indexOf("worldMap")>=0){
			int[] SprAnim = new int[40];
			// sprite count : 40
			 SprAnim[0] = 2 ;
			 SprAnim[1] = 2 ;
			 SprAnim[2] = 1 ;
			 SprAnim[3] = 1 ;
			 SprAnim[4] = 1 ;
			 SprAnim[5] = 1 ;
			 SprAnim[6] = 1 ;
			 SprAnim[7] = 2 ;
			 SprAnim[8] = 2 ;
			 SprAnim[9] = 2 ;
			 SprAnim[10] = 2 ;
			 SprAnim[11] = 2 ;
			 SprAnim[12] = 2 ;
			 SprAnim[13] = 2 ;
			 SprAnim[14] = 2 ;
			 SprAnim[15] = 2 ;
			 SprAnim[16] = 2 ;
			 SprAnim[17] = 2 ;
			 SprAnim[18] = 2 ;
			 SprAnim[19] = 2 ;
			 SprAnim[20] = 2 ;
			 SprAnim[21] = 2 ;
			 SprAnim[22] = 1 ;
			 SprAnim[23] = 1 ;
			 SprAnim[24] = 1 ;
			 SprAnim[25] = 1 ;
			 SprAnim[26] = 2 ;
			 SprAnim[27] = 2 ;
			 SprAnim[28] = 2 ;
			 SprAnim[29] = 2 ;
			 SprAnim[30] = 2 ;
			 SprAnim[31] = 2 ;
			 SprAnim[32] = 2 ;
			 SprAnim[33] = 3 ;
			 SprAnim[34] = 4 ;
			 SprAnim[35] = 8 ;
			 SprAnim[36] = 7 ;
			 SprAnim[37] = 5 ;
			 SprAnim[38] = 5 ;
			 SprAnim[39] = 6 ;
			
			
			return SprAnim;
		}
	

		return null;
	}
	
	final static public int[] getWorldSprX(String Name){
	
		// World : worldMap
		if(Name.indexOf("worldMap")>=0){
			int[] SprX = new int[40];
			// sprite count : 40
			 SprX[0] = 1537 ;
			 SprX[1] = 1359 ;
			 SprX[2] = 2303 ;
			 SprX[3] = 2288 ;
			 SprX[4] = 785 ;
			 SprX[5] = 816 ;
			 SprX[6] = 2223 ;
			 SprX[7] = 384 ;
			 SprX[8] = 576 ;
			 SprX[9] = 816 ;
			 SprX[10] = 848 ;
			 SprX[11] = 1264 ;
			 SprX[12] = 1311 ;
			 SprX[13] = 1264 ;
			 SprX[14] = 1312 ;
			 SprX[15] = 2352 ;
			 SprX[16] = 2431 ;
			 SprX[17] = 2352 ;
			 SprX[18] = 2368 ;
			 SprX[19] = 2143 ;
			 SprX[20] = 2144 ;
			 SprX[21] = 2288 ;
			 SprX[22] = 288 ;
			 SprX[23] = 206 ;
			 SprX[24] = 1681 ;
			 SprX[25] = 1985 ;
			 SprX[26] = 576 ;
			 SprX[27] = 639 ;
			 SprX[28] = 721 ;
			 SprX[29] = 560 ;
			 SprX[30] = 256 ;
			 SprX[31] = 208 ;
			 SprX[32] = 111 ;
			 SprX[33] = 482 ;
			 SprX[34] = 1203 ;
			 SprX[35] = 2143 ;
			 SprX[36] = 1202 ;
			 SprX[37] = 1448 ;
			 SprX[38] = 2496 ;
			 SprX[39] = 675 ;
			
			
			return SprX;
		}
	

		return null;
	}
	
	final static public int[] getWorldSprY(String Name){
	
		// World : worldMap
		if(Name.indexOf("worldMap")>=0){
			int[] SprY = new int[40];
			// sprite count : 40
			 SprY[0] = 1408 ;
			 SprY[1] = 1487 ;
			 SprY[2] = 1760 ;
			 SprY[3] = 2721 ;
			 SprY[4] = 1536 ;
			 SprY[5] = 926 ;
			 SprY[6] = 671 ;
			 SprY[7] = 400 ;
			 SprY[8] = 304 ;
			 SprY[9] = 976 ;
			 SprY[10] = 959 ;
			 SprY[11] = 1248 ;
			 SprY[12] = 1296 ;
			 SprY[13] = 1727 ;
			 SprY[14] = 1664 ;
			 SprY[15] = 2672 ;
			 SprY[16] = 2624 ;
			 SprY[17] = 1744 ;
			 SprY[18] = 1733 ;
			 SprY[19] = 128 ;
			 SprY[20] = 288 ;
			 SprY[21] = 672 ;
			 SprY[22] = 1504 ;
			 SprY[23] = 1583 ;
			 SprY[24] = 799 ;
			 SprY[25] = 2193 ;
			 SprY[26] = 2416 ;
			 SprY[27] = 2399 ;
			 SprY[28] = 2304 ;
			 SprY[29] = 1536 ;
			 SprY[30] = 1552 ;
			 SprY[31] = 1471 ;
			 SprY[32] = 1583 ;
			 SprY[33] = 351 ;
			 SprY[34] = 1808 ;
			 SprY[35] = 207 ;
			 SprY[36] = 1183 ;
			 SprY[37] = 1447 ;
			 SprY[38] = 2574 ;
			 SprY[39] = 2353 ;
			
			
			return SprY;
		}
	

		return null;
	}
	



	
}




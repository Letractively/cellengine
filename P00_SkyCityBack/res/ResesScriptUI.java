/* Encoding : 简体中文(GB2312) */
/* Cell Game Editor by WAZA Zhang */
/* Email : wazazhang@gmail.com */

//
// SkyCity Script v0.0.0
// 
// 指定文件输出
// <OUTPUT>     ..\[out]\ResesScriptUI.java
// 

import com.cell.CIO;
import com.cell.CImagesJPhone;
import com.cell.IImages;
import com.cell.game.CAnimates;
import com.cell.game.CCollides;
import com.cell.game.CMap;
import com.cell.game.CSprite;
import com.cell.game.CWayPoint;

public class ResesScriptUI {

//--------------------------------------------------------------------------------------------------------------
// resource trunk
//--------------------------------------------------------------------------------------------------------------


	//--------------------------------------------------------------------------------------------------------------
	 
	// Images : menuTile 
	final static public IImages createClipImages_menuTile(){
		IImages stuff = new CImagesJPhone();
		stuff.buildImages(CIO.loadImage("/menuTile.png"),12);
		
		 stuff.addTile(0,0,155,129);//0 
		 stuff.addTile(49,129,49,13);//1 
		 stuff.addTile(36,155,49,13);//2 
		 stuff.addTile(0,129,49,13);//3 
		 stuff.addTile(49,142,49,13);//4 
		 stuff.addTile(98,129,49,13);//5 
		 stuff.addTile(0,142,49,13);//6 
		 stuff.addTile(38,175,1,1);//7 
		 stuff.addTile(0,155,18,25);//8 
		 stuff.addTile(18,155,18,25);//9 
		 stuff.addTile(98,142,49,13);//10 
		 stuff.addTile(85,155,49,13);//11 
		
		
		return stuff;
	}
	
 
	// Images : menuUITile 
	final static public IImages createClipImages_menuUITile(){
		IImages stuff = new CImagesJPhone();
		stuff.buildImages(CIO.loadImage("/menuUITile.png"),13);
		
		 stuff.addTile(0,0,125,19);//0 
		 stuff.addTile(91,179,21,11);//1 
		 stuff.addTile(0,19,125,155);//2 
		 stuff.addTile(73,179,18,25);//3 
		 stuff.addTile(91,190,13,13);//4 
		 stuff.addTile(55,179,18,25);//5 
		 stuff.addTile(0,174,119,5);//6 
		 stuff.addTile(0,179,55,19);//7 
		 stuff.addTile(119,174,1,1);//8 
		 stuff.addTile(112,179,7,5);//9 
		 stuff.addTile(104,190,5,7);//10 
		 stuff.addTile(109,190,5,7);//11 
		 stuff.addTile(112,184,8,5);//12 
		
		
		return stuff;
	}
	
 
	// Images : opMap_Tile 
	final static public IImages createClipImages_opMap_Tile(){
		IImages stuff = new CImagesJPhone();
		stuff.buildImages(CIO.loadImage("/opMap_Tile.png"),16);
		
		 stuff.addTile(0,0,44,44);//0 
		 stuff.addTile(44,0,44,44);//1 
		 stuff.addTile(88,0,44,44);//2 
		 stuff.addTile(132,0,44,44);//3 
		 stuff.addTile(0,44,44,44);//4 
		 stuff.addTile(44,44,44,44);//5 
		 stuff.addTile(88,44,44,44);//6 
		 stuff.addTile(132,44,44,44);//7 
		 stuff.addTile(0,88,44,44);//8 
		 stuff.addTile(44,88,44,44);//9 
		 stuff.addTile(88,88,44,44);//10 
		 stuff.addTile(132,88,44,44);//11 
		 stuff.addTile(0,132,44,44);//12 
		 stuff.addTile(44,132,44,44);//13 
		 stuff.addTile(88,132,44,44);//14 
		 stuff.addTile(132,132,44,44);//15 
		
		
		return stuff;
	}
	


	//--------------------------------------------------------------------------------------------------------------
	
	// Map : unamed_Map
	final static public CMap createMap_unamed_Map(IImages tiles,boolean isAnimate,boolean isCyc){
		
		//4 x 5
		
		// tiles
	    CAnimates animates = new CAnimates(14,tiles);
	     animates.addPart(0,0,2,0);//0
		 animates.addPart(0,0,6,0);//1
		 animates.addPart(0,0,7,0);//2
		 animates.addPart(0,0,0,0);//3
		 animates.addPart(0,0,1,0);//4
		 animates.addPart(0,0,4,0);//5
		 animates.addPart(0,0,8,0);//6
		 animates.addPart(0,0,9,0);//7
		 animates.addPart(0,0,10,0);//8
		 animates.addPart(0,0,11,0);//9
		 animates.addPart(0,0,12,0);//10
		 animates.addPart(0,0,13,0);//11
		 animates.addPart(0,0,14,0);//12
		 animates.addPart(0,0,15,0);//13
		
		
	    animates.setFrames(new int[14][]);
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
		
		
		short[][] tileMatrix = new short[][]{
			{0,1,2,0,},
{3,4,0,0,},
{5,5,1,2,},
{6,7,8,9,},
{10,11,12,13,},

		};
		
		// cds
		CCollides collides = new CCollides(8);
	    
	    if("rect"=="rect") collides.addCDRect(0, 0, 0, 44 , 44 );//rect//0
		if("rect"=="line") collides.addCDLine(0, 0, 0, 44, 44);//rect//0
		
	    if("rect"=="rect") collides.addCDRect(1, 0, 0, 44 , 44 );//rect//1
		if("rect"=="line") collides.addCDLine(1, 0, 0, 44, 44);//rect//1
		
	    if("rect"=="rect") collides.addCDRect(2, 0, 0, 44 , 1 );//rect//2
		if("rect"=="line") collides.addCDLine(2, 0, 0, 44, 44);//rect//2
		
	    if("rect"=="rect") collides.addCDRect(4, 0, 43, 44 , 1 );//rect//3
		if("rect"=="line") collides.addCDLine(4, 0, 43, 44, 44);//rect//3
		
	    if("rect"=="rect") collides.addCDRect(8, 0, 0, 1 , 44 );//rect//4
		if("rect"=="line") collides.addCDLine(8, 0, 0, 44, 44);//rect//4
		
	    if("rect"=="rect") collides.addCDRect(16, 43, 0, 1 , 44 );//rect//5
		if("rect"=="line") collides.addCDLine(16, 43, 0, 44, 44);//rect//5
		
	    if("line"=="rect") collides.addCDRect(32, 1, 1, 44 , 44 );//line//6
		if("line"=="line") collides.addCDLine(32, 1, 1, 43, 43);//line//6
		
	    if("line"=="rect") collides.addCDRect(64, 43, 1, 44 , 44 );//line//7
		if("line"=="line") collides.addCDLine(64, 43, 1, 1, 43);//line//7
		

		short[][] flagMatrix = new short[][]{
			{0,0,0,0,},
{0,0,0,0,},
{0,0,0,0,},
{0,0,0,0,},
{0,0,0,0,},

		};
		
	    CMap ret = new CMap(
	            animates, 
	            collides, 
	            44, 44, 
	            tileMatrix, 
	            flagMatrix, 
	            isAnimate,isCyc 
	            );
	
	    return ret;
	}
	

	
	//--------------------------------------------------------------------------------------------------------------
	
	// Sprite : openSprite
	final static public CSprite createSprite_openSprite(IImages tiles){

	    // tiles
	    CAnimates animates = new CAnimates(13,tiles);
	     animates.addPart(-75,-108,0,0);//0
		 animates.addPart(-24,57,1,0);//1
		 animates.addPart(-24,57,11,0);//2
		 animates.addPart(-24,57,3,0);//3
		 animates.addPart(-24,57,4,0);//4
		 animates.addPart(-24,57,5,0);//5
		 animates.addPart(-24,57,6,0);//6
		 animates.addPart(-49,52,8,0);//7
		 animates.addPart(33,52,8,2);//8
		 animates.addPart(-48,52,8,0);//9
		 animates.addPart(32,52,8,2);//10
		 animates.addPart(-45,52,8,0);//11
		 animates.addPart(29,52,8,2);//12
		
		
	    animates.setFrames(new int[10][]);
	     animates.setComboFrame(new int[]{0,},0);//0
		 animates.setComboFrame(new int[]{1,},1);//1
		 animates.setComboFrame(new int[]{2,},2);//2
		 animates.setComboFrame(new int[]{3,},3);//3
		 animates.setComboFrame(new int[]{4,},4);//4
		 animates.setComboFrame(new int[]{5,},5);//5
		 animates.setComboFrame(new int[]{6,},6);//6
		 animates.setComboFrame(new int[]{7,8,},7);//7
		 animates.setComboFrame(new int[]{9,10,},8);//8
		 animates.setComboFrame(new int[]{11,12,},9);//9
		
		
		// cds
	    CCollides collides = new CCollides(3);
		 collides.addCDRect(65535, 29, 51, 18 , 25 );//rect//0
	     collides.addCDRect(65535, -46, 51, 18 , 25 );//rect//1
	     collides.addCDRect(65535, -24, 57, 49 , 13 );//rect//2
	    
	    
	    collides.setFrames(new int[2][]);
	     collides.setComboFrame(new int[]{0,1,2,},0);//0
	     collides.setComboFrame(new int[]{},1);//1
	    
	    
	    
		// sprite frame
/*
		String[] frameName = new String[]{
			"0000",
"0001",
"0004",

		};
		
		for(int i=0;i<frameName.length;i++){
			System.out.println(frameName[i]);
		}
*/
	    int[][] frameAnimate = new int[][]{
	        {0,},
{1,2,3,4,5,6,},
{7,7,8,8,9,9,8,},

	    };
	    int[][] frameCDMap = new int[][]{
	        {0,},
{1,1,1,1,1,1,},
{1,1,1,1,1,1,1,},

	    };
	    int[][] frameCDAtk = new int[][]{
	        {1,},
{1,1,1,1,1,1,},
{1,1,1,1,1,1,1,},

	    };
	    int[][] frameCDDef = new int[][]{
	        {1,},
{1,1,1,1,1,1,},
{1,1,1,1,1,1,1,},

	    };
	    int[][] frameCDExt = new int[][]{
	        {1,},
{1,1,1,1,1,1,},
{1,1,1,1,1,1,1,},

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
	

	// Sprite : uiSprite
	final static public CSprite createSprite_uiSprite(IImages tiles){

	    // tiles
	    CAnimates animates = new CAnimates(0,tiles);
	    
		
	    animates.setFrames(new int[0][]);
	    
		
		// cds
	    CCollides collides = new CCollides(0);
		
	    
	    collides.setFrames(new int[0][]);
	    
	    
	    
		// sprite frame
/*
		String[] frameName = new String[]{
			
		};
		
		for(int i=0;i<frameName.length;i++){
			System.out.println(frameName[i]);
		}
*/
	    int[][] frameAnimate = new int[][]{
	        
	    };
	    int[][] frameCDMap = new int[][]{
	        
	    };
	    int[][] frameCDAtk = new int[][]{
	        
	    };
	    int[][] frameCDDef = new int[][]{
	        
	    };
	    int[][] frameCDExt = new int[][]{
	        
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
	
	 
	final public static String images_menuTile = "menuTile";
	
 
	final public static String images_menuUITile = "menuUITile";
	
 
	final public static String images_opMap_Tile = "opMap_Tile";
	


	
	final public static String map_unamed_Map = "unamed_Map";
	

	
	
	final public static String spr_openSprite = "openSprite";
	

	final public static String spr_uiSprite = "uiSprite";
	



	//--------------------------------------------------------------------------------------------------------------
	final public static IImages createImages(String key){
	 
		if(key.indexOf("menuTile")>=0){
			return createClipImages_menuTile();
		}
	
 
		if(key.indexOf("menuUITile")>=0){
			return createClipImages_menuUITile();
		}
	
 
		if(key.indexOf("opMap_Tile")>=0){
			return createClipImages_opMap_Tile();
		}
	

		return null;
	}
	
	final public static CMap createMap(String key, IImages tiles, boolean isAnimate, boolean isCyc){
	
		if(key.indexOf("unamed_Map")>=0){
			return createMap_unamed_Map(tiles,isAnimate,isCyc);
		}
	

		return null;
	}
	
	final public static CSprite createSprite(String key, IImages tiles){
	
		if(key.indexOf("openSprite")>=0){
			return createSprite_openSprite(tiles);
		}
	

		if(key.indexOf("uiSprite")>=0){
			return createSprite_uiSprite(tiles);
		}
	

		return null;
	}




//--------------------------------------------------------------------------------------------------------------
// level trunk
//--------------------------------------------------------------------------------------------------------------

	

	



	final static public String[] WorldNames = new String[]{
	
	};


	final static public int getWorldWidth(String Name){
	
		return -1;
	}

	final static public int getWorldHeight(String Name){
	
		return -1;
	}

	
	final static public CWayPoint[] getWorldWayPoints(String Name){
	
		return null;
	}


	final static public String getWorldMapTile(String Name){
	
		return null;
	}

	final static public String getWorldMapType(String Name){
	
		return null;
	}

	final static public String getWorldMapName(String Name){
	
		return null;
	}
	
	final static public String[] getWorldSprTile(String Name){
	
		return null;
	}

	final static public String[] getWorldSprName(String Name){
	
		return null;
	}
	
	final static public String[] getWorldSprType(String Name){
	
		return null;
	}
	
	final static public int[] getWorldSprAnim(String Name){
	
		return null;
	}
	
	final static public int[] getWorldSprX(String Name){
	
		return null;
	}
	
	final static public int[] getWorldSprY(String Name){
	
		return null;
	}
	



	
}




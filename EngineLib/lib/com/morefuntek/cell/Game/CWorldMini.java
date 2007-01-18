package com.morefuntek.cell.Game;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

import com.morefuntek.cell.CMath;
import com.morefuntek.cell.CObject;
import com.morefuntek.cell.IImages;

public class CWorldMini extends CObject {

	public int[] MapColor;
	
	public boolean ShowSpr = true;
	public boolean ShowMap = true;
	public boolean ShowCam = true;
	
	public int X = 0;
	public int Y = 0;
	
	public int SprPriority = 0;
	
	public Image Buffer;
	
	CWorld World;
	
	int W;
	int H;
	int CW;
	int CH;

	int WW;
	int WH;
	
	int WTW;
	int WTH;
	
	
	Graphics bg;
	
	public CWorldMini(
			CWorld world,
			int width,int height,
			int cellW,int cellH,
			int colorKeyMapPos,
			int colorKeySprPos){
		
		for(int i=0;i<world.getSpriteCount();i++){
       		try {
				world.getSprite(i).BackColor = world.getSprite(i).getAnimates().images.getRGBFormPixcel(
						world.getSprite(i).getAnimates().STileID[world.getSprite(i).getAnimates().Frames[world.getSprite(i).CurAnimate][world.getSprite(i).CurFrame]], 
						colorKeySprPos);
			} catch (RuntimeException e){
				world.getSprite(i).BackColor = 0xffffffff;
			}
       	}
		int[] mapColor = new int[world.getMap().getAnimates().getCount()];
    	for(int i=0;i<mapColor.length;i++){
    		try {
    			mapColor[i] = world.getMap().getAnimates().images.getRGBFormPixcel(
    					world.getMap().getAnimates().STileID[world.getMap().getAnimates().Frames[i][0]], 
						colorKeyMapPos);
			} catch (RuntimeException e){
				mapColor[i] = 0xff00ff00;
			}
       	}
    	MapColor = mapColor;
    	
		World = world;
		W = width;
		H = height;
		CW = cellW;
		CH = cellH;
		WW = W*World.getMap().getCellW()/CW;
		WH = H*World.getMap().getCellH()/CH;
		WTW = World.getMap().getWCount() * CW;
		WTH = World.getMap().getHCount() * CH;
		
		Buffer = Image.createImage(WTW ,WTH);
		bg = Buffer.getGraphics();
		
		for (int by = 0; by < world.getMap().getHCount(); by++) {
			for (int bx = 0; bx < world.getMap().getWCount(); bx++) {
				bg.setColor(MapColor[World.Map.getTile(bx, by)]);
				bg.fillRect(bx*CW, by*CH, CW, CH);
			}
		}
		
	}

	public int getWidth(){
		return W;
	}
	public int getHeight(){
		return H;
	}
	public int getWorldWidth(){
		return WW;
	}
	public int getWorldHeight(){
		return WH;
	}
	
	public void render(Graphics g,int x,int y){
		try{
			int cx = g.getClipX();
			int cy = g.getClipY();
			int cw = g.getClipWidth();
			int ch = g.getClipHeight();
	    	g.setClip(x,y,W,H);
	    	
	    	if(!World.getMap().IsCyc){
	    	
		    	if(X<0)X=0;
		    	if(X+WW>World.getMap().getWidth())X=World.getMap().getWidth()-WW;
		    	if(Y<0)Y=0;
		    	if(Y+WH>World.getMap().getHeight())Y=World.getMap().getHeight()-WH;

				if(ShowMap){
					AScreen.drawRegion(g, Buffer, 
							(X)*CW/World.getMap().CellW, 
							(Y)*CH/World.getMap().CellH,
							W, H, 
							x, y);
				}
				if(ShowSpr){
					for(int i=0;i<World.getSpriteCount();i++){
						if( World.getSprite(i).Visible &&
							World.getSprite(i).Priority == SprPriority
							){
							g.setColor(World.getSprite(i).BackColor);
							g.fillRect(
									x -CW/2 + (World.getSprite(i).X-X)*CW/World.getMap().CellW, 
									y -CH/2 + (World.getSprite(i).Y-Y)*CH/World.getMap().CellH, 
									CW, CH);
						}
					}
				}
				if(ShowCam){
					g.setColor(World.getCamera().BackColor);
					g.drawRect(
							x -CW/2 + (World.getCamera().getX()-X)*CW/World.getMap().CellW, 
							y -CH/2 + (World.getCamera().getY()-Y)*CH/World.getMap().CellH, 
							World.getCamera().getWidth() *CW/World.getMap().CellW, 
							World.getCamera().getHeight()*CH/World.getMap().CellH);
				}
				
				
	    	}else{
	    		int TX = CMath.cycNum(X, 0, World.getMap().getWidth());
	    		int TY = CMath.cycNum(Y, 0, World.getMap().getHeight());
	    		
				if(ShowMap){
					int sx = (TX)*CW/World.getMap().CellW;
					int sy = (TY)*CH/World.getMap().CellH;
					int dx = sx + W;
					int dy = sy + H;
					int sbx = sx / WTW ;
					int sby = sy / WTH ;
					int dbx = dx / WTW ;
					int dby = dy / WTH ;
					
					for(int bx=0;bx<=dbx-sbx;bx++){
						for(int by=0;by<=dby-sby;by++){
							g.drawImage(Buffer, x + bx*WTW-sx, y + by*WTH-sy, 0);
						}
					}
				}
				if(ShowSpr){
					for(int i=0;i<World.getSpriteCount();i++){
						if( World.getSprite(i).Visible &&
							World.getSprite(i).Priority == SprPriority
							){
							g.setColor(World.getSprite(i).BackColor);
							g.fillRect(
									x -CW/2 + (World.getSprite(i).X-X)*CW/World.getMap().CellW, 
									y -CH/2 + (World.getSprite(i).Y-Y)*CH/World.getMap().CellH, 
									CW, CH);
						}
					}
				}
				if(ShowCam){
					g.setColor(World.getCamera().BackColor);
					g.drawRect(
							x -CW/2 + (World.getCamera().getX()-X)*CW/World.getMap().CellW, 
							y -CH/2 + (World.getCamera().getY()-Y)*CH/World.getMap().CellH, 
							World.getCamera().getWidth() *CW/World.getMap().CellW, 
							World.getCamera().getHeight()*CH/World.getMap().CellH);
				}
	    	}
	    	
	    	g.setClip(cx,cy,cw,ch);
	    	
		}catch(RuntimeException e){
		}
		
	}
	
	
}

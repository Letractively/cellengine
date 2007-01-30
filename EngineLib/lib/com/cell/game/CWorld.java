package com.cell.game;

import java.util.Vector;

import javax.microedition.lcdui.Graphics;

import com.cell.CObject;



/**
 * 游戏场景管理器。包含一个主地图，一个摄象机，N个精灵，一系列路点。
 * @author yifeizhang
 * @since 2006-11-30 
 * @version 1.0
 */
public class CWorld extends CObject {

	public int Width;
	public int Height;
	
	public Vector 		Sprs = new Vector(0);
	public CMap 		Map;
	public CCamera 		Camera;
	public CWayPoint[] 	WayPoints ;
	public boolean 		isRPGView = false;
	
	
//	public Vector Maps = new Vector(0);
//	public Vector Cams = new Vector(0);
	
	/**
	 * 构造函数 
	 */
	public CWorld(){
	}
	
	/**
	 * 构造函数
	 * @param map 主地图
	 * @param camera 主摄象机
	 * @param sprs 精灵
	 */
	public CWorld(CMap map,CCamera camera,CSprite[] sprs) {
		Map = map;
		Camera = camera;
		for(int i=0;i<sprs.length;i++){
			addSprite(sprs[i]);
		}
	}
	
//	------------------------------------------------------------------------------------------------------
//	sprite
	public void insertSprite(CSprite spr,int index){
		this.Sprs.insertElementAt(spr, index);
	}
	public void addSprite(CSprite spr){
		if(isRPGView){
			int index = Sprs.size() ;
			for(int i=0;i<Sprs.size();i++){
				if(getSprite(i).Y + getSprite(i).Priority >= spr.Y + spr.Priority){
					index = i;
					break;
				}
			}
			this.Sprs.insertElementAt(spr, index);
		}else{
			this.Sprs.addElement(spr);
		}
		spr.world = this;
	}
	public void addSprites(CSprite[] sprs){
		for(int i=0;i<sprs.length;i++){
			addSprite(sprs[i]);
		}
	}
	public void addSprites(Vector sprs){
		for(int i=0;i<sprs.size();i++){
			addSprite((CSprite)(sprs.elementAt(i)));
		}
	}
	public boolean removeSprite(CSprite spr){
		return this.Sprs.removeElement(spr);
	}
	public CSprite getSprite(int index){
		return (CSprite)Sprs.elementAt(index);
	}
	public int getSpriteCount(){
		return Sprs.size();
	}
	public int getSpriteIndex(CSprite spr){
		return Sprs.indexOf(spr);
	}
	
//	------------------------------------------------------------------------------------------------------
//	map

	public void addMap(CMap map){
		setMap(map);
	}
	public void setMap(CMap map){
		Map = map;
		Map.world = this;
	}
	public CMap getMap(){
		return Map;
	}
	
//	------------------------------------------------------------------------------------------------------
//	camera
	
	public void addCamera(CCamera camera){
		setCamera(camera);
	}
	public void setCamera(CCamera camera){
		Camera = camera;
		Camera.world = this;
	}
	public CCamera getCamera(){
		return Camera;
	}
	
//	------------------------------------------------------------------------------------------------------


	public int toWorldPosX(int screenX){
		return screenX + Camera.X - Camera.WindowX ;
	}
	public int toWorldPosY(int screenY){
		return screenY + Camera.Y - Camera.WindowY ;
	}

	public int toScreenPosX(int worldX){
		return worldX - Camera.X + Camera.WindowX;
	}
	public int toScreenPosY(int worldY){
		return worldY - Camera.Y + Camera.WindowY;
	}
	
//	------------------------------------------------------------------------------------------------------

	
	/**
	 * 更新场景里所有的游戏单位的逻辑。
	 */
	public void update(){
		for(int i=0;i<Sprs.size();i++){
			((CSprite)Sprs.elementAt(i)).updateState();
		}
		Camera.updateState();
		Map.updateState();
	}
	
	/**
	 * 渲染游戏单位。
	 * @param g 
	 */
	public void render(Graphics g){
		
			int cx = g.getClipX();
			int cy = g.getClipY();
			int cw = g.getClipWidth();
			int ch = g.getClipHeight();
	    	g.setClip(Camera.WindowX,Camera.WindowY,Camera.getWidth(),Camera.getHeight());
	    	
			Camera.render(g);
			
//			#ifdef _DEBUG
			for(int i=0;IsDebug && WayPoints!=null && i<WayPoints.length;i++){
				if(CCD.cdRect(
						WayPoints[i].X-1, 
						WayPoints[i].Y-1, 
						WayPoints[i].X+1, 
						WayPoints[i].Y+1, 
						Camera.X, 
						Camera.Y, 
						Camera.X + Camera.getWidth(), 
						Camera.Y + Camera.getHeight()
						)){
					WayPoints[i].render(g, 
							-Camera.X+Camera.WindowX, 
							-Camera.Y+Camera.WindowY);
				}
			}
//#endif

			for(int i=0;i<Sprs.size();i++){
				if(CCD.cdRect(
					((CSprite)Sprs.elementAt(i)).X + ((CSprite)Sprs.elementAt(i)).animates.w_left, 
					((CSprite)Sprs.elementAt(i)).Y + ((CSprite)Sprs.elementAt(i)).animates.w_top, 
					((CSprite)Sprs.elementAt(i)).X + ((CSprite)Sprs.elementAt(i)).animates.w_right, 
					((CSprite)Sprs.elementAt(i)).Y + ((CSprite)Sprs.elementAt(i)).animates.w_bottom, 
					Camera.X, 
					Camera.Y, 
					Camera.X + Camera.getWidth(), 
					Camera.Y + Camera.getHeight()
					)){
					((CSprite)Sprs.elementAt(i)).OnScreen = true;
				}else{
					((CSprite)Sprs.elementAt(i)).OnScreen = false;
				}
				((CSprite)Sprs.elementAt(i)).render(g,
						((CSprite)Sprs.elementAt(i)).X-Camera.X+Camera.WindowX,
						((CSprite)Sprs.elementAt(i)).Y-Camera.Y+Camera.WindowY);
			}
			
			g.setClip(cx,cy,cw,ch);
		
	}
	
	
	
	

}

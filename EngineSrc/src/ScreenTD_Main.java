import game.unit.UnitEnemy;
import game.unit.UnitShoot;
import game.unit.UnitTower;
import game.unit.sprite.SpriteDrift;
import game.unit.sprite.SpritePatrol;


import javax.microedition.lcdui.Graphics;

import com.morefuntek.cell.CImages20;
import com.morefuntek.cell.IImages;
import com.morefuntek.cell.Game.CCamera;
import com.morefuntek.cell.Game.CMap;
import com.morefuntek.cell.Game.AScreen;
import com.morefuntek.cell.Game.CSprite;
import com.morefuntek.cell.Game.CWorld;
import com.morefuntek.cell.Game.CWayPoint;;

//继承抽象类CScreen并实现其中的方法
public class ScreenTD_Main extends AScreen {

	// game world
	CWorld 		world;
	CMap 		map;
	CCamera 	cam;
	
	UnitEnemy 	enemys[]	= new UnitEnemy[32];
	UnitTower	towers[]	= new UnitTower[32];
	UnitShoot	shoots[]	= new UnitShoot[32];
	CSprite		point;
	
	public ScreenTD_Main(){

		
       	IsDebug = false;
    
       	FrameDelay = 25;
       	
       	// res
       	IImages mapTile = new CImages20();
       	IImages sprTile = new CImages20();
       	IImages guiTile = new CImages20();
       	IImages towerTile = new CImages20();
       	IImages shootTile = new CImages20();
       	ResesScript.buildClipImages_MapTile(mapTile);
       	ResesScript.buildClipImages_SprTile(sprTile);
       	ResesScript.buildClipImages_GUITile(guiTile);
       	ResesScript.buildClipImages_TowerTile(towerTile);
       	ResesScript.buildClipImages_ShootTile(shootTile);
       	
       	// map type
       	map = ResesScript.createMap_Map00(mapTile, false, false);
       	
       	// spr type
        CSprite enemy = ResesScript.createSprite_Enemy00(sprTile);
        CSprite tower = ResesScript.createSprite_Tower(towerTile);
        CSprite point = ResesScript.createSprite_Point(guiTile);
        CSprite shoot = ResesScript.createSprite_Shoot(shootTile);
       	// camera 
       	cam = new CCamera(0,0,SCREEN_WIDTH,SCREEN_HEIGHT,map,true,0);
       	
       	// world
       	world = new world_Level00();
    	((world_Level00)world).Map0000_Map00 = map;// setmap
    	((world_Level00)world).setCamera(cam);//set camera
       	((world_Level00)world).initPath();// init path
       	((world_Level00)world).initUnit();
       	world.isRPGView = true;
       	
       	
       	for(int i=0;i<enemys.length;i++){
       		enemys[i] = new UnitEnemy(enemy);
       		enemys[i].Active = false;
       		enemys[i].Visible = false;
       		enemys[i].Y = -32 - i*32;
       	}
       	for(int i=0;i<towers.length;i++){
       		towers[i] = new UnitTower(tower);
       		towers[i].Active = false;
       		towers[i].Visible = false;
       	}
       	for(int i=0;i<shoots.length;i++){
       		shoots[i] = new UnitShoot(shoot);
       		shoots[i].Active = false;
       		shoots[i].Visible = false;
       		shoots[i].Priority = 1024;
       	}
       	
       	this.point = point;
    	
       	world.addSprites(shoots);
    	world.addSprites(enemys);
    	world.addSprites(towers);
    	world.addSprite(point);

       	resetTimer();
	}
	
	public void notifyLogic() {
    	if(isKeyDown(KEY_STAR)) {FrameDelay --;}
        if(isKeyDown(KEY_SHARP)){FrameDelay ++;}
    	if(isKeyDown(KEY_A)){ChangeSubScreen("ScreenLogo");}
    	if(isKeyDown(KEY_B)){AScreen.ExitGame = true;}
    	
    	if(isKeyDown(KEY_0)){
    		println("");
    		for(int i=0;i<world.Sprs.size();i++){
    			println(i + " : " + world.Sprs.elementAt(i).getClass().toString() 
    					+ " : Y=" + world.getSprite(i).Y
    					+ " : PRI=" + world.getSprite(i).Priority
    					);
    		}
    	}
    	
    	processPoint();
    	processEnemys();
    	processTowers();
    	processShoots();
		
    	int cdx = point.X - (cam.getX() + cam.getWidth() /2);
    	int cdy = point.Y - (cam.getY() + cam.getHeight()/2);
    	cam.mov(cdx/4,cdy/4);
		world.update();
  
        tickTimer();
        
    }
	
	public void notifyRender(Graphics g) {
        //clearScreenAndClip(g,0xff000000);

        world.render(g);

        showFPS(g, 1, 1, 0xffffffff);

       
    }

	
	public void notifyPause() {}


	public void notifyResume() {}

//	-------------------------------------------------------------------------------------------------------------------------------
	
	int holdTime = 10; 
	
	public void processPoint(){
		
		if(isPointerDown()){
			
		}
		
    	if(isKeyDown(KEY_C)){
    		for(int i=0;i<towers.length;i++){
    			if(!towers[i].Active){
    				int bx = point.X/map.getCellW();
    				int by = point.Y/map.getCellH();
    				if(map.getFlag(bx, by)==0){
    					map.putFlag(bx, by, 1);
    					int dx = (bx * map.getCellW()) + map.getCellW()/2;
    					int dy = (by * map.getCellH()) + map.getCellH()/2;
        				towers[i].startBuild(dx, dy-1);
    				}
    				break;
    			}
    		}
    	}
    	
    	
		
		
    	holdTime--;
    	
    	
    	
    	if(isKeyDown(KEY_UP)){
    		holdTime=10;
    	} 
    	if(isKeyDown(KEY_DOWN)){
    		holdTime=10;
    	}
    	if(isKeyDown(KEY_LEFT)){
    		holdTime=10;
    	}
		if(isKeyDown(KEY_RIGHT)){
			holdTime=10;
		}
		
    	if(holdTime<0 || holdTime==10){
	    	if(isKeyHold(KEY_UP)){
	    		if(point.Y>0)
	    			point.tryMove(0, -map.getCellH());
	    	} 
	    	if(isKeyHold(KEY_DOWN)){
	    		if(point.Y<map.getHeight()-map.getCellH())
	    			point.tryMove(0,  map.getCellH());
	    	}
	    	if(isKeyHold(KEY_LEFT)){
	    		if(point.X>0)
	    			point.tryMove(-map.getCellW(), 0);
	    	}
			if(isKeyHold(KEY_RIGHT)){
				if(point.X<map.getWidth()-map.getCellW())
					point.tryMove( map.getCellW(), 0);
			}
		}
    	
    	if(point.X%map.getCellW()!=map.getCellW()/2){
    		int dx = point.X/map.getCellW() + map.getCellW()/2;
    		point.tryMove(dx - point.X ,0);
    	}
		if(point.Y%map.getCellH()!=map.getCellH()/2){
    		int dy = point.Y/map.getCellH() + map.getCellH()/2;
    		point.tryMove(0, dy - point.Y);
    	}
		
    	point.nextCycFrame();
	}
	
	public void processEnemys(){
		if(getTimer()==1)
		for(int i=0;i<enemys.length;i++){
			if(!enemys[i].Active){
				enemys[i].startMove(world.WayPoints[0]);
			}else{
				
			}
       	}
       
	}
	
	public void processTowers(){
		for(int i=0;i<towers.length;i++){
			if(!towers[i].Active){
				
			}else{
				towers[i].startAttack(enemys,shoots);
			}
			
       	}
       	
	}

	public void processShoots(){
//		for(int i=0;i<shoots.length;i++){
//       	}
	}
}




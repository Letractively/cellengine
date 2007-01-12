import game.unit.world.UnitWorldActor;
import game.unit.world.UnitWorldEvent;

import javax.microedition.lcdui.Graphics;

import com.morefuntek.cell.*;
import com.morefuntek.cell.Game.*;


public class ScreenP00_World extends AScreen {

	// game world
	CWorld 		world;
	CMap 		map;
	CCamera 	cam;
	
	UnitWorldActor		actor;
	UnitWorldEvent[]	events ;
	
	CWorldMini worldMini;
	
	public ScreenP00_World(){

       	IsDebug = false;

       	FrameDelay = 25;
       	
       	// res
       	IImages mapTile = new CImages20();
       	IImages sprTile = new CImages20();
       	ResesScript.buildClipImages_WorldSprTile(sprTile);
       	ResesScript.buildClipImages_WorldMapTile(mapTile);
       	
       	// map type
       	map = ResesScript.createMap_WorldMap(mapTile, false, false);
       	
       	// spr type
        CSprite actorStuff = ResesScript.createSprite_WorldActor(sprTile);
        CSprite eventStuff = ResesScript.createSprite_WorldCity(sprTile);
        CSprite enemyStuff = ResesScript.createSprite_WorldEnemy00(sprTile);
        
       	// camera 
       	cam = new CCamera(0,0,
       			SCREEN_WIDTH,
       			SCREEN_WIDTH,
       			map,true,0);
       	
       	// world
       	world = new world_WorldLevel00();
       	world.addCamera(cam);//set camera
       	((world_WorldLevel00)world).initPath();// init path

       	actor = new UnitWorldActor(actorStuff);
       	actor.haveMapBlock = false;
       	actor.haveSprBlock = false;
       	
       	events = new UnitWorldEvent[8];
       	for(int i=0;i<events.length;i++){
       		if(i<5) {
       			events[i] = new UnitWorldEvent(eventStuff);
       			events[i].Type = 0;
       		} else {
       			events[i] = new UnitWorldEvent(enemyStuff);
       			events[i].Type = 1;
       		}
       	}
       	
       	((world_WorldLevel00)world).WorldMap = map;// setmap
       	((world_WorldLevel00)world).WorldActor = actor;
       	((world_WorldLevel00)world).WorldCity00 = events[0];
       	((world_WorldLevel00)world).WorldCity01 = events[1];
       	((world_WorldLevel00)world).WorldCity02 = events[2];
       	((world_WorldLevel00)world).WorldCity03 = events[3];
       	((world_WorldLevel00)world).WorldCity04 = events[4];
       	((world_WorldLevel00)world).Spr0007_WorldEnemy00 = events[5];
       	((world_WorldLevel00)world).Spr0008_WorldEnemy00 = events[6];
       	((world_WorldLevel00)world).Spr0009_WorldEnemy00 = events[7];
       	((world_WorldLevel00)world).initUnit();
       	
    	actor.HPos256 = actor.X*256;
    	actor.VPos256 = actor.Y*256;
       	actor.haveMapBlock = true;
    	
       	
       	//Ð¡µØÍ¼
//       	int[] sprColor = new int[world.getSpriteCount()];
//       	for(int i=0;i<sprColor.length;i++){
//       		sprColor[i] = 0xffff0000;
//       	}
//       	int[] mapColor = new int[world.getMap().getAnimates().getCount()];
//    	for(int i=0;i<mapColor.length;i++){
//    		int[] c = new int[1];
//    		world.getMap().getAnimates().getFrameImage(i, 0).getRGB(
//    				c, 0, 1, 
//    				world.getMap().getCellW()/2, 
//    				world.getMap().getCellH()/2, 
//    				1, 1);
//       		mapColor[i] = c[0];
//       	}
       	worldMini = new CWorldMini(
       			world,
       			world.getCamera().getWidth()/2,
       			world.getCamera().getHeight()/2,
       			2,
       			2,
       			8+8*16,
       			0);
       	
       	
       	resetTimer();
	}
	
	public void notifyLogic() {
    	if(isKeyDown(KEY_STAR)) {FrameDelay --;}
        if(isKeyDown(KEY_SHARP)){FrameDelay ++;}
    	if(isKeyDown(KEY_A)){ChangeSubScreen("ScreenP00_Logo");}
    	if(isKeyDown(KEY_B)){AScreen.ExitGame = true;}
    	
    	if(isKeyDown(KEY_0)){IsDebug = !IsDebug;}
 
    	processActor();
    	
    	processMiniMap();
    	
    	int cdx = actor.X - (cam.getX() + cam.getWidth() /2);
    	int cdy = actor.Y - (cam.getY() + cam.getHeight()/2);
    	cam.mov(cdx/4,cdy/4);
    	
		world.update();
  
        tickTimer();
        
    }
	
	public void notifyRender(Graphics g) {
        //clearScreenAndClip(g,0xff000000);
        world.render(g);
        worldMini.render(g, 1, -1 + SCREEN_HEIGHT - worldMini.getHeight());
    
//        cam.renderDebugBackBuffer(g, 
//        		SCREEN_WIDTH -cam.getWidth() -map.getCellW(), 
//        		SCREEN_HEIGHT-cam.getHeight()-map.getCellH(), 
//        		0xffffffff);
        
        showFPS(g, 1, 1, 0xffffffff);

    }

	
	public void notifyPause() {}


	public void notifyResume() {}

//	-------------------------------------------------------------------------------------------------------------------------------

	int DColor = 0;
	public void processMiniMap(){
		
		worldMini.X = actor.X - worldMini.getWorldWidth()/2;
		worldMini.Y = actor.Y - worldMini.getWorldHeight()/2;
		
		for(int i=0;i<world.getSpriteCount();i++){
			world.getSprite(i).BackColor = 
				0x7f000000
				+(DColor<<16) 
				+(DColor<<8) 
				+(DColor<<0) 
				;
		}
		
		actor.BackColor = 
			0x7f000000
			+(DColor<<16) 
			+(DColor<<8) 
			+(DColor<<0) 
			;
		
		cam.BackColor = 
			0x7f000000
//			+(DColor<<16) 
			+(DColor<<8) 
//			+(DColor<<0) 
			;
		
		DColor = CMath.sinTimes256(getTimer()*10%180);
		if(DColor>0xff)DColor=0xff;
		
	}
	
	public void processActor(){
		if(isKeyHold(KEY_UP)){
			actor.accelerate();
		}
		if(isKeyHold(KEY_DOWN)){
			actor.breakDown();
		}
		
		if(isKeyHold(KEY_LEFT)){
			actor.turnL();
		}
		if(isKeyHold(KEY_RIGHT)){
			actor.turnR();
		}

	}

	
	public void processEvents(){
//       	for(int i=0;i<events.length;i++){
//       		if(events[i].OnScreen){
//       			if(CSprite.touch_SprSub_SprSub(
//       					actor,     0, 0, 
//       					events[i], 0, 0))
//       			{
//       				
//       			}
//       			switch(events[i].Type){
//       			case 0:
//       				break;
//       			case 1:
//       			}
//       			
//       		}
//       		
//       		
//       	}
		
	}
	
	
	
	
	
	
	
	
	
	
}

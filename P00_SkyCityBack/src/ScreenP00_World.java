import java.util.Hashtable;

import game.unit.world.UnitWorldActor;
import game.unit.world.UnitWorldEvent;

import javax.microedition.lcdui.Graphics;

import com.morefuntek.cell.*;
import com.morefuntek.cell.Game.*;


public class ScreenP00_World extends AScreen {

	IImages GUITile;
	CSprite NUMSpr;
	
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
       	
       	GUITile = ResesScript.createClipImages_worldUITile();
       	NUMSpr = ResesScript.createSprite_munberSprite(GUITile);
       	
       	// res
       	IImages mapTile = ResesScript.createClipImages_worldMapTile();
       	IImages sprTile = ResesScript.createClipImages_worldSprTile();
       	IImages evtTile = ResesScript.createClipImages_worldEvtTile();
       	
       	String worldName = ResesScript.world_worldMap;
       	
       	// spr typeVisible
        CSprite actorStuff = ResesScript.createSprite_wdSprite(sprTile);
        CSprite eventStuff = ResesScript.createSprite_wdEvents(evtTile);
    	
       	actor = new UnitWorldActor(actorStuff);
       	actor.haveMapBlock = false;
       	actor.haveSprBlock = true;
       	actor.X = UnitWorldActor.ActorX ;
		actor.Y = UnitWorldActor.ActorY ;
		actor.Direct = UnitWorldActor.ActorDirect;
       	actor.HPos256 = actor.X*256;
    	actor.VPos256 = actor.Y*256;
       	
    	String[] eventList = ResesScript.getWorldSprName(worldName);
    	int[] eventX = ResesScript.getWorldSprX(worldName);
    	int[] eventY = ResesScript.getWorldSprY(worldName);
    	int[] eventA = ResesScript.getWorldSprAnim(worldName);
       	events = new UnitWorldEvent[eventList.length];
       	for(int i=0;i<events.length;i++){
       		events[i] = new UnitWorldEvent(eventStuff);
       		events[i].haveMapBlock = false;
       		events[i].haveSprBlock = true;
       		events[i].setCurrentFrame(eventA[i], 0);
       		events[i].X = eventX[i];
       		events[i].Y = eventY[i];
       		events[i].HPos256 = events[i].X*256;
       		events[i].VPos256 = events[i].Y*256;
       		events[i].setLevel(eventList[i]);
       		if(events[i].Level!=null){
       			println(events[i].Info + " : " + events[i].Level);
       		}
       	}

    	// map type
       	map = ResesScript.createMap_wdMap(mapTile, false, true);
       	// camera 
       	cam = new CCamera(
       			0,0,
       			SCREEN_WIDTH,
       			SCREEN_WIDTH,
       			map,true,0);
       	cam.setPos(UnitWorldActor.ActorX, UnitWorldActor.ActorY);
       	
    	// world
       	world = new CWorld();
       	world.isRPGView = true;
       	world.addCamera(cam);//set camera
       	world.addMap(map);
       	world.addSprites(events);
       	world.addSprite(actor);
		world.Width = ResesScript.getWorldWidth(worldName);
		world.Height = ResesScript.getWorldHeight(worldName);
       	
       	
       	//Ð¡µØÍ¼
       	worldMini = new CWorldMini(
       			world,
       			cam.getWidth()/2,
       			cam.getHeight()/4,
       			2, 2, 
       			8+8*16, 0);
       	
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
    	processCamera();
    	processEvents();
    	
		world.update();
  
        tickTimer();
        
    }
	
	public void notifyRender(Graphics g) {
        //clearScreenAndClip(g,0xff000000);
        world.render(g);
        
        renderGUI(g);
        
//        cam.renderDebugBackBuffer(g, 
//        		SCREEN_WIDTH -cam.getWidth() -map.getCellW(), 
//        		SCREEN_HEIGHT-cam.getHeight()-map.getCellH(), 
//        		0xffffffff);
        
        showFPS(g, 1, SCREEN_HEIGHT - getStringHeight(), 0xffffffff);

    }

	
	public void notifyPause() {}


	public void notifyResume() {}

//	-------------------------------------------------------------------------------------------------------------------------------

	public void processCamera(){
		int cdx = actor.X - (cam.getX() + cam.getWidth() /2);
    	int cdy = actor.Y - (cam.getY() + cam.getHeight()/2);

    	int px = cdx/4;
    	int py = cdy/4;
    	
    	if(cam.getX() + px > world.Width - cam.getWidth()){
    		px = world.Width - cam.getWidth() - cam.getX();
    	}else if(cam.getX() + px < 0){
    		px = 0 - cam.getX();
    	}
    	
    	if(cam.getY() + py > world.Height - cam.getHeight()){
    		py = world.Height - cam.getHeight() - cam.getY();
    	}else if(cam.getY() + py < 0){
    		py = 0 - cam.getY();
    	}
    	
    	cam.mov(px, py);
	}
	
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

		UnitWorldActor.ActorX = actor.X ;
		UnitWorldActor.ActorY = actor.Y;
		UnitWorldActor.ActorDirect = actor.Direct;
		
       	for(int i=0;i<events.length;i++){
       		if(events[i].OnScreen){
       			if(CSprite.touch_SprSub_SprSub(
       					actor,     CSprite.CD_TYPE_MAP, 0, 
       					events[i], CSprite.CD_TYPE_EXT, 0))
       			{
       				if(events[i].Level!=null){
       					println("Enter Level : " + events[i].Info + " : " + events[i].Level);
       					ScreenP00_Battle.WorldName = events[i].Level;
	       				ChangeSubScreen("ScreenP00_BattleConfig");
	       				UnitWorldActor.ActorX = events[i].X ;
	       				UnitWorldActor.ActorY = events[i].Y + events[i].getCDHeight();
	       				UnitWorldActor.ActorDirect = 270;
	       				break;
       				}
       				
//       				switch(events[i].Type){
//           			case 0:
//           				break;
//           			case 1:
//           			}
       			}
       		}
       	}
		
	}
	
	public void renderGUI(Graphics g){
		  worldMini.render(g, 
	        		1, -1 + SCREEN_HEIGHT - worldMini.getHeight());

	        g.setColor(0xff00ff00);
	        g.drawRect(
	        		1, -1 + SCREEN_HEIGHT - worldMini.getHeight(),
	        		worldMini.getWidth(), worldMini.getHeight());	
	
	        GUITile.render(g, 2, 0, 0);
	        
	        int X = Math.abs(world.Width/2  - actor.X);
	        int Y = Math.abs(world.Height/2 - actor.Y);
	        String H = actor.X < world.Width/2  ? "W" : "E";
	        String V = actor.Y < world.Height/2 ? "N" : "S";
	        renderText(g, 2,  8, H+X/map.getCellW()+"\'" + X%map.getCellW());
	        renderText(g, 2, 16, V+Y/map.getCellH()+"\'" + Y%map.getCellH());
	}
	
	
	public void renderText(Graphics g,int x,int y,String num){
		for(int i=0;i<num.length();i++){
			int a = 0;
			int n = 0;
			switch(num.charAt(i)){
			case '0':n = 0; break;
			case '1':n = 1; break;
			case '2':n = 2; break;
			case '3':n = 3; break;
			case '4':n = 4; break;
			case '5':n = 5; break;
			case '6':n = 6; break;
			case '7':n = 7; break;
			case '8':n = 8; break;
			case '9':n = 9; break;
			case '\'':a = 1;break;
			case 'E':a = 2;break;
			case 'S':a = 3;break;
			case 'N':a = 4;break;
			case 'W':a = 5;break;
			}
			NUMSpr.setCurrentFrame(a, n);
			NUMSpr.render(g, 
					x + NUMSpr.getVisibleWidth()*i, 
					y);
		}
		
	}
	
	
	
	
	
	
	
}

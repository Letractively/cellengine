

import javax.microedition.lcdui.Graphics;
import javax.microedition.m3g.World;

import com.morefuntek.cell.CImages20;
import com.morefuntek.cell.CMath;
import com.morefuntek.cell.IImages;
import com.morefuntek.cell.Game.AScreen;
import com.morefuntek.cell.Game.CCamera;
import com.morefuntek.cell.Game.CMap;
import com.morefuntek.cell.Game.CSprite;
import com.morefuntek.cell.Game.CWorld;
import com.morefuntek.cell.Game.CWorldMini;

import cv.unit.UnitActor;


public class ScreenLevel extends AScreen {

	// game world
	CWorld 		world;
	CMap 		map;
	CCamera 	cam;
	
	UnitActor 	actor	;
	
	CWorldMini	worldMini;
	
	public ScreenLevel(){

		
       	IsDebug = false;
    
       	FrameDelay = 25;
       	
       	// res
       	IImages mapTile = new CImages20();
       	IImages actTile = new CImages20();
       
       	ResesScript.buildClipImages_MapTile00(mapTile);
       	ResesScript.buildClipImages_Actor00(actTile);
       	
       	// spr type
       	CSprite act = ResesScript.createSprite_Actor00(actTile);
 
       	actor = new UnitActor(act);
       	actor.X = 32;
    	actor.Y = 64;
    	
    	// map type
       	map = ResesScript.createMap_Level_00(mapTile, false, false);
       	
       	// camera 
       	cam = new CCamera(0,0,
       			SCREEN_WIDTH,
       			SCREEN_WIDTH,
       			map,true,0);
       	
       	// world
       	world = new CWorld();
       	world.setMap(map);// setmap
    	world.setCamera(cam);//set camera

    	world.addSprite(actor);

    	worldMini = new CWorldMini(
       			world,
       			cam.getWidth()/2,
       			cam.getHeight()/4,
       			2,2,
       			8+8*16,
       			0);
    	
    	
    	
    	
    	
       	resetTimer();
	}
	
	public void notifyLogic() {
    	if(isKeyDown(KEY_STAR)) {FrameDelay --;}
        if(isKeyDown(KEY_SHARP)){FrameDelay ++;}
    	if(isKeyDown(KEY_A)){ChangeSubScreen("ScreenLogo");}
    	if(isKeyDown(KEY_B)){AScreen.ExitGame = true;}

    	if(isKeyDown(KEY_0)){IsDebug = !IsDebug;}
    	
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
        
        showFPS(g, 1, 1, 0xffffffff);

       
    }

	
	public void notifyPause() {}


	public void notifyResume() {}

//	-------------------------------------------------------------------------------------------------------------------------------

}



import java.util.Hashtable;

import javax.microedition.lcdui.Graphics;
import javax.microedition.m3g.World;

import com.cell.AScreen;
import com.cell.CImages20;
import com.cell.CImagesJPhone;
import com.cell.CMath;
import com.cell.CTilesJPhone;
import com.cell.IImages;
import com.cell.game.CCamera;
import com.cell.game.CMap;
import com.cell.game.CSprite;
import com.cell.game.CWorld;
import com.cell.game.CWorldMini;

import cv.LevelManager;
import cv.unit.UnitActor;


public class ScreenLevel extends AScreen {

	// game world
	LevelManager 		world;
	
//	CWorldMini			worldMini;
	
	public ScreenLevel(){

		
       	IsDebug = false;
    
       	FrameDelay = 40;

       	// world
       	world = ResesScript.createWorld("Level_01");
       	
       	Hashtable AITable = new Hashtable();
       	AITable.put(ResesScript.spr_Actor00, "cv.unit.UnitActor");
       	AITable.put(ResesScript.spr_e00_zombi, "cv.unit.UnitZombi");
       	world.UnitTable = AITable;
       	
       	world.init();
       	
       	
//    	worldMini = new CWorldMini(
//       			world,
//       			world.Camera.getWidth()/2,
//       			world.Camera.getHeight()/4,
//       			2,2,
//       			8+8*16,
//       			20+20*40,
//       			false,
//       			true,
//       			true);
    	
    	
       	resetTimer();
	}
	
	public void notifyLogic() {
    	if(isKeyDown(KEY_STAR)) {FrameDelay -= 10;}
        if(isKeyDown(KEY_SHARP)){FrameDelay += 10;}
    	if(isKeyDown(KEY_A)){ChangeSubScreen("ScreenLogo");}
    	if(isKeyDown(KEY_B)){AScreen.ExitGame = true;}

    	if(isKeyDown(KEY_0)){IsDebug = !IsDebug;}
    	
    	

    	
		world.update();
  
        tickTimer();
        
    }
	
	public void notifyRender(Graphics g) {
        //clearScreenAndClip(g,0xff000000);

        world.render(g);
//        worldMini.render(g, 1, -1 + SCREEN_HEIGHT - worldMini.getHeight());
        
        showFPS(g, 1, 1, 0xffffffff);

       
    }

	
	public void notifyPause() {}


	public void notifyResume() {}

//	-------------------------------------------------------------------------------------------------------------------------------

}

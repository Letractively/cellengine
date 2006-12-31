import game.unit.UnitPatrol;
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
	
	CSprite 	enemys[];
	CSprite		towners[];
	CSprite		volatiles[];
	CSprite		point;
	
	public ScreenTD_Main(){

		
       	IsDebug = false;
    
       	FrameDelay = 25;
       	
       	// res
       	IImages mapTile = new CImages20();
       	IImages sprTile = new CImages20();
       	
       	ResesScript.buildClipImages_MapTile(mapTile);
       	ResesScript.buildClipImages_SprTile(sprTile);
       	
       	// map type
       	map = ResesScript.createMap_Map00(mapTile, false, false);
       	
       	// spr type
        CSprite enemy = ResesScript.createSprite_Enemy00(sprTile);

       	// camera 
       	cam = new CCamera(0,0,176,208,map,true,0);
       	
       	// world
       	world = new world_Level00();
    	((world_Level00)world).Map0000_Map00 = map;// setmap
    	((world_Level00)world).addCamera(cam);//set camera
       	((world_Level00)world).initPath();// init path
       	((world_Level00)world).initUnit();
       	
       	enemys = new CSprite[32];
       	for(int i=0;i<enemys.length;i++){
       		enemys[i] = new CSprite(enemy);
       		new UnitPatrol(enemys[i],world.WayPoints[0]);
       		enemys[i].Y = -32 - i*32;
       	}

    	
    	world.addSprites(enemys);
    	

       	resetTimer();
	}
	
	public void notifyLogic() {
    	if(isKeyDown(KEY_STAR)) {FrameDelay --;}
        if(isKeyDown(KEY_SHARP)){FrameDelay ++;}
    	if(isKeyDown(KEY_A)){ChangeSubScreen(this.getClass().getName());}
    	if(isKeyDown(KEY_B)){ChangeSubScreen("ScreenLogo");}
    	if(isKeyHold(KEY_0)){AScreen.ExitGame = true;}
    	
    	if(isPointerDown()){}
    	if(isKeyDown(KEY_C)){}
    	
    	
    	if(isKeyHold(KEY_UP)){
    		cam.mov(0,-4);
    	} 
    	if(isKeyHold(KEY_DOWN)){
    		cam.mov(0, 4);
    	}
    	if(isKeyHold(KEY_LEFT)){
    		cam.mov(-4, 0);
    	}
		if(isKeyHold(KEY_RIGHT)){
			cam.mov( 4,0);
		}

		world.update();
    	
//		int cdx = sprs[0].X - (cam.getX() + cam.getWidth() /2);
//    	int cdy = sprs[0].Y - (cam.getY() + cam.getHeight()/2);
//    	cam.mov(cdx,cdy);
    	
        tickTimer();
        
    }
	
	public void notifyRender(Graphics g) {
        //clearScreenAndClip(g,0xff000000);

		
		
        world.render(g);

        showFPS(g, 1, 1, 0xffffffff);

       
    }

	
	public void notifyPause() {}


	public void notifyResume() {}

}




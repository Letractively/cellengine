import game.unit.sprite.SpriteDrift;
import game.unit.sprite.SpritePatrol;


import javax.microedition.lcdui.Graphics;

import com.morefuntek.cell.CImages20;
import com.morefuntek.cell.Game.CCamera;
import com.morefuntek.cell.Game.CMap;
import com.morefuntek.cell.Game.CScreen;
import com.morefuntek.cell.Game.CSprite;
import com.morefuntek.cell.Game.CWorld;
import com.morefuntek.cell.Game.CWayPoint;;

//继承抽象类CScreen并实现其中的方法
public class ScreenTD_Main extends CScreen {

	// game world
	CWorld 		world;
	CMap 		map;
	CCamera 	cam;
	
	CSprite 	sprs[];
	
	public ScreenTD_Main(){

		
       	IsDebug = true;
    
       	
       	// res
       	CImages20 mapTile = new CImages20();
       	CImages20 sprTile = new CImages20();
       	
       	Reses.buildClipImages_unamed_Tile(mapTile);
       	Reses.buildClipImages_unamed_Tile2(sprTile);
       	
       	// map type
       	map = Reses.createMap_unamed_Tile_unamed_Map(mapTile, false, false);
       	
       	// spr type
       	CSprite ut2_u_Spr01 = Reses.createSprite_unamed_Tile2_unamed_Sprite(sprTile);
       	CSprite ut2_u_Spr02 = Reses.createSprite_unamed_Tile2_unamed_Sprite2(sprTile);
    	CSprite ut2_u_Spr03 = Reses.createSprite_unamed_Tile2_unamed_Sprite3(sprTile);
    	
       	// camera 
       	cam = new CCamera(0,0,176,208,map,true,0);
       	
       	// world
       	world = new TD_Level();
    	((TD_Level)world).Map0000_unamed_Map = map;// setmap
    	((TD_Level)world).addCamera(cam);//set camera
       	((TD_Level)world).initPath();// init path
       	((TD_Level)world).initUnit();
       	
       	sprs = new CSprite[4];
       	sprs[0] = new SpritePatrol(ut2_u_Spr01,world.WayPoints[0]);
    	sprs[1] = new SpritePatrol(ut2_u_Spr02,world.WayPoints[1]);
    	sprs[2] = new SpritePatrol(ut2_u_Spr02,world.WayPoints[2]);
    	sprs[3] = new SpritePatrol(ut2_u_Spr03,world.WayPoints[3]);

    	world.addSprites(sprs);
    	
       	world.addCamera(cam);


 
       	resetTimer();
	}
	
	public void notifyLogic() {
    	if(isKeyDown(KEY_A)){ChangeSubSreen(GameMIDlet.SCREEN_KEY_TD_MAIN);}
    	if(isKeyDown(KEY_B)){ChangeSubSreen(GameMIDlet.SCREEN_KEY_LOGO);}
    	if(isKeyHold(KEY_0)){GameMIDlet.ExitGame = true;}
    	
    	if(isPointerDown()){}
    	if(isKeyDown(KEY_C)){}
    	
    	
    	if(isKeyHold(KEY_UP|KEY_3)){
    		//sprs[1].mov(0,-4);
    	} 
    	if(isKeyHold(KEY_DOWN|KEY_6)){
    		//sprs[1].mov(0,4);
    	}
    	if(isKeyHold(KEY_LEFT|KEY_1)){
    		//sprs[1].mov(-4,0);
    	}
		if(isKeyHold(KEY_RIGHT|KEY_2)){
			//sprs[1].mov(4,0);
		}

		world.update();
    	
		int cdx = sprs[0].X - (cam.getX() + cam.getWidth() /2);
    	int cdy = sprs[0].Y - (cam.getY() + cam.getHeight()/2);
    	cam.mov(cdx,cdy);
    	
        tickTimer();
        
    }
	
	public void notifyRender(Graphics g) {
        //clearScreenAndClip(g,0xff000000);

		
		
        world.render(g);

        showFPS(g, 1, 1);

       
    }

	
	public void notifyPause() {}


	public void notifyResume() {}

}




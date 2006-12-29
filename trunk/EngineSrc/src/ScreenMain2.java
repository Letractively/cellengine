import game.unit.sprite.SpritePatrol;

import java.util.Random;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

import com.morefuntek.cell.CIO;
import com.morefuntek.cell.CImages20;
import com.morefuntek.cell.Game.CAnimates;
import com.morefuntek.cell.Game.CCD;
import com.morefuntek.cell.Game.CCamera;
import com.morefuntek.cell.Game.CCollides;
import com.morefuntek.cell.Game.CMap;
import com.morefuntek.cell.Game.AScreen;
import com.morefuntek.cell.Game.CSprite;
import com.morefuntek.cell.Game.CWayPoint;
import com.morefuntek.cell.Game.CWorld;
import com.morefuntek.cell.Game.AI.CAStar;


//继承抽象类CScreen并实现其中的方法
public class ScreenMain2 extends AScreen {
	Random random = new Random();

	// game world
	CWorld world ;
	CSprite spr;
	CMap map;
	CCamera cam;
	
	// a star test
	Image point = CIO.loadImage("/point.png");;
	int px = 0;
	int py = 0;
	
	CAStar astar;
	int sx ;
	int sy ;
	int dx ;
	int dy ;
	
	public ScreenMain2(){

       	resetTimer();

       	// res
       	IsDebug = false;
       	
       	int w = 8;
       	int h = 8;
       	
       	Image tile = CIO.loadImage("/tile.png");
       	CImages20  images = new CImages20(); 
       	images.buildImages(tile,tile.getWidth()/w*tile.getHeight()/h);
       	images.addTile(0,0,tile.getWidth(),tile.getHeight(),w,h);
       	
       	CAnimates anim = new CAnimates(images.getCount(),images);
       	anim.addPart(false);
       	anim.setFrame(new int[][]{{0},{1},{2},{3}});
       	
       	CCD cd1 = CCD.createCDRect(0     , 0, 0, w, h);
       	CCD cd2 = CCD.createCDRect(0xffff, 0, 0, w, h);
       	
       	CCollides collides = new CCollides(2);
       	collides.addCD(cd1);
       	collides.addCD(cd2);
       	collides.setFrame(new int[][]{{0},{1},{1},{1}});
       	
       	// map
       	short[][] tile_matrix = new short[64][64];
       	for(int y=0;y<tile_matrix.length;y++){
       		for(int x=0;x<tile_matrix[y].length;x++){
       			tile_matrix[y][x] = 0;
       			if(random.nextInt()%8==0){
       				tile_matrix[y][x] = 1;
       			}
       		}
       	}
       	tile_matrix[0][0] = 0 ;
       	               
       	map = new CMap(anim,collides,w,h,tile_matrix,tile_matrix,false,false);
       	// spr 
       	int[][] frame = new int[][]{{2,3}};
       	CWayPoint next = new CWayPoint(0,0);
       	spr = new SpritePatrol(
       			new CSprite(anim,collides,frame,frame,frame,frame,frame),
       			next
       			);
       	// camera 
       	cam = new CCamera(0,0,SCREEN_WIDTH,SCREEN_HEIGHT,map,true,0);
       	// world
       	world = new CWorld(map,cam,new CSprite[]{spr});
       	
      
       	// astar
       	astar = new CAStar(map);
    
	}
	
	public void notifyLogic() {
		if(isKeyDown(KEY_STAR)) {FrameDelay --;}
	    if(isKeyDown(KEY_SHARP)){FrameDelay ++;}
    	if(isKeyDown(KEY_A)){ChangeSubSreen(this.getClass().getName());}
    	if(isKeyDown(KEY_B)){ChangeSubSreen("ScreenLogo");}
    	if(isKeyHold(KEY_0)){GameMIDlet.ExitGame = true;}
    	
//    	if(isPointerDown()){
//    		int bx = world.toWorldPosX(getPointerX()) / map.getCellW();
//    		int by = world.toWorldPosY(getPointerY()) / map.getCellH();
//    		
//    		try {
//				if(map.getFlag(bx, by)==0){
//					map.putFlag(bx, by, 1);
//					map.putTile(bx, by, 1);
//				}else{
//					map.putFlag(bx, by, 0);
//					map.putTile(bx, by, 0);
//				}
//			
//			} catch (RuntimeException e) {
//			}
//    		
//			cam.resetBufferMapBlock(bx, by);
//    	}
    	
    	
    	if(isKeyHold(KEY_UP)){
    		py -= 2;
    		if(py<0)py = 0;
    	} 
    	if(isKeyHold(KEY_DOWN)){
    		py += 2;
    		if(py>=SCREEN_WIDTH)py = SCREEN_HEIGHT - 1;
    	}
    	if(isKeyHold(KEY_LEFT)){
    		px -= 2;
    		if(px<0)px = 0;
    	}
		if(isKeyHold(KEY_RIGHT)){
			px += 2;
			if(px>=SCREEN_WIDTH)px = SCREEN_WIDTH - 1;
		}
		
    	if(isKeyDown(KEY_C)){

    		sx = spr.X / map.getCellW();
    		sy = spr.Y / map.getCellH();
    		dx = world.toWorldPosX(px) / map.getCellW();
			dy = world.toWorldPosY(py) / map.getCellH();
			
			((SpritePatrol)spr).NextWayPoint.X = spr.X;
			((SpritePatrol)spr).NextWayPoint.Y = spr.Y;
			((SpritePatrol)spr).NextWayPoint.unlinkAll();
			
			((SpritePatrol)spr).NextWayPoint.linkTo(astar.findPath(sx, sy, dx, dy));
			
    	}
    	if(isPointerDown()){

    		sx = spr.X / map.getCellW();
    		sy = spr.Y / map.getCellH();
    		dx = world.toWorldPosX(getPointerX()) / map.getCellW();
			dy = world.toWorldPosY(getPointerY()) / map.getCellH();
			
			((SpritePatrol)spr).NextWayPoint.X = spr.X;
			((SpritePatrol)spr).NextWayPoint.Y = spr.Y;
			((SpritePatrol)spr).NextWayPoint.unlinkAll();
			
			((SpritePatrol)spr).NextWayPoint.linkTo(astar.findPath(sx, sy, dx, dy));
			
    	}
    	spr.nextCycFrame();
    	
    	int cdx = spr.X - (cam.getX() + cam.getWidth() /2);
    	int cdy = spr.Y - (cam.getY() + cam.getHeight()/2);
    	cam.mov(cdx/8,cdy/8);

    	world.update();
    	
        tickTimer();
        
    }
	
	public void notifyRender(Graphics g) {
        clearScreenAndClip(g,0xff000000);
        
        world.render(g);
        
        if(getTimer()%2==0){
	        g.setColor(0xffffffff);		
	        g.drawArc(
	        		world.toScreenPosX(dx*map.getCellW()), 
	        		world.toScreenPosY(dy*map.getCellH()), 
	        		map.getCellW(), 
	        		map.getCellH(),
	        		0,360);
        }

        g.drawImage(point, px, py, 0);
//		debug
		drawString(
		        g, ""
				+ " TPF=" + FrameDelay
				+ " FPS="
				+ (1000 / ((System.currentTimeMillis() - CurTime) == 0 ? 1 : (System.currentTimeMillis() - CurTime))),
				1,1, 
				0xffffffff);
		CurTime = System.currentTimeMillis();
    }
	long CurTime = 0 ;
	
	public void notifyPause() {
		// TODO Auto-generated method stub

	}


	public void notifyResume() {
		// TODO Auto-generated method stub

	}

}

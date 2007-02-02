
import java.util.Hashtable;
import java.util.Vector;

import game.unit.battle.UnitBattleActor;
import game.unit.battle.UnitBattleBullet;
import game.unit.battle.UnitBattleSub;
import game.unit.battle.UnitBattleEnemy;

import javax.microedition.lcdui.Graphics;

import com.morefuntek.cell.CImages20;
import com.morefuntek.cell.CImagesNokia;
import com.morefuntek.cell.CMath;
import com.morefuntek.cell.IImages;
import com.morefuntek.cell.Game.AScreen;
import com.morefuntek.cell.Game.CCamera;
import com.morefuntek.cell.Game.CMap;
import com.morefuntek.cell.Game.CSprite;
import com.morefuntek.cell.Game.CWayPoint;
import com.morefuntek.cell.Game.CWorld;



/**继承抽象类CScreen并实现其中的方法*/
public class ScreenP00_Battle extends AScreen {
	
	public static String WorldName;
	
	//首先需要图片包资源
   	IImages mapTile ;
   	IImages anyTile ;
   	IImages eftTile ;
   	IImages uiTile ;
   	
   	
	/**游戏世界*/
	CWorld 		world;
	
	String 		worldName;
	int			worldW;
	int			worldH;
	
	UnitBattleActor actor;
	UnitBattleSub[] actorSub ;
	
	Vector 	openEnemys  = new Vector();
	Vector 	closeEnemys = new Vector();
	
	Vector 	enemyBullet = new Vector(128);
	Vector 	actorBullet = new Vector(128);
	
	Vector  Ammor = new Vector();
	
	CCamera		cam;
	CMap		map;
	
	CSprite 	mapLayer;
	CSprite 	ui;
	
	
	int OverMaxTime = -1;
	boolean isBossLevel = false;
	
	boolean AutoFire    = false;
	
	//该例子演示如何使用编辑器生成的数据构造一个游戏世界，
	//编辑器生成的数据是由一个文本脚本文件定义，参考编辑器安装目录下的ResesScript.txt。
	//脚本文件可以被定义生成任何格式的文本。
	//本例中该脚本被定义成一个对象工厂
	public ScreenP00_Battle(){
		
		System.out.println("Start Free Memory = "+(Runtime.getRuntime().freeMemory()/1024)+"(K byte)");
	    
		try{
			FrameDelay = 20;
       	
//      世界信息
	       	if(WorldName!=null){
	       		worldName = WorldName;
	       	}else{
	       		worldName = ResesScript.WorldNames[1 + Math.abs(Random.nextInt()%(ResesScript.WorldNames.length-1))];
	       	}
		
			println("Entry : " + worldName);
			
			worldW = ResesScript.getWorldWidth(worldName);
			worldH = ResesScript.getWorldHeight(worldName);
	       	world = new CWorld();
	       	world.Width = worldW;
	       	world.Height = worldH;
	    	world.WayPoints = ResesScript.getWorldWayPoints(worldName);

	    	initSprite();
	    	initMap();
	    	initCamera();
	    	initUI();
	    	
	       	//帧记录器清零
	       	resetTimer();
       	
	       	println("Init Complete : " + worldName );
	       	
//      -->到此，一个基本游戏世界构造完了，
		}catch(Exception err){
			ChangeSubScreen("ScreenP00_Logo");
		}
		
		System.out.println("End Free Memory = "+(Runtime.getRuntime().freeMemory()/1024)+"(K byte)");
	    
	}
	
	public void notifyLogic() {
//    	if(isKeyDown(KEY_B)){ChangeSubScreen("ScreenP00_World");}
//    	if(isKeyDown(KEY_A)){ChangeSubScreen("ScreenP00_World");}
    	
    	if(isKeyDown(KEY_0)){IsDebug = !IsDebug;}
    	
    	
    	
    	
		processActor();
		processEnemy();
		processCamera();
		
		OverMaxTime--;
		
    	//每帧更新一次游戏世界，游戏单位的状态机也将被更新
		world.update();
    	//帧记录器增加
        tickTimer();
        
    }
	
	public void notifyRender(Graphics g) {
        //clearScreenAndClip(g,0xff000000);
		
		//每帧渲染一次世界
        world.render(g);
        renderLayer(g);
        //显示FPS
        showFPS(g, 1, 1, 0xffffffff);
        
        drawString(g, "" + actor.HP, 1, 64, 0xffffffff);
    }

	public void notifyPause() {}
	public void notifyResume() {}

//	------------------------------------------------------------------------------------------------

	void initSprite(){
		try{
		
//		create bullet
		IImages bltTile = ResesScript.createClipImages_battleWeaopnTile();
		CSprite bullet  = ResesScript.createSprite_weaopnSprite(bltTile);
//		CSprite sub     = ResesScript.createSprite_btSub(tiles);
		
//		create world level
		String[] SprsTile = ResesScript.getWorldSprTile(worldName);
		String[] SprsType = ResesScript.getWorldSprType(worldName);
		String[] SprsInfo = ResesScript.getWorldSprName(worldName);
		int[] SprsX = ResesScript.getWorldSprX(worldName);
		int[] SprsY = ResesScript.getWorldSprY(worldName);
			
//		 create tile bank
		Hashtable tileTable = new Hashtable();
		for(int i=0;i<SprsTile.length;i++){
			if(!tileTable.containsKey(SprsTile[i])){
				IImages tile = ResesScript.createImages(SprsTile[i]);
				tileTable.put(SprsTile[i], tile);
//				println(" create tile : " + SprsTile[i]);
			}
		}
//		create sprs 	
		Hashtable sprTable = new Hashtable();
		for(int i=0;i<SprsType.length;i++){
			if(!sprTable.containsKey(SprsType[i])){
				CSprite spr = ResesScript.createSprite(SprsType[i],(IImages)tileTable.get(SprsTile[i]));
				sprTable.put(SprsType[i], spr);
//				println(" create sprite : " + SprsType[i]);
			}
			
			println(SprsType[i]+" : "+SprsInfo[i]);
			
			// stuff
			CSprite obj = (CSprite)sprTable.get(SprsType[i]);

	       	// way point
	       	int wp = UnitBattleEnemy.getKeyValue(SprsInfo[i], "wp");
	       	CWayPoint point = null;
	       	if(wp>=0&&wp<world.WayPoints.length){
	       		point = world.WayPoints[wp];
	    	}
	       	
	       	// ai
	       	int ai = UnitBattleEnemy.getKeyValue(SprsInfo[i], "ai");
	       	if(ai>=50)isBossLevel = true;
	       	
	       	// instance
       		if(SprsType[i] == ResesScript.spr_btSpr){
       	       	actor = new UnitBattleActor(obj);
       	       	for(int b=0;b<UnitBattleActor.WeaopnCount[UnitBattleActor.WeaopnType];b+=1){
    		   		Ammor.addElement(new UnitBattleBullet(bullet));
    			}
       			actor.X = SprsX[i];
       			actor.Y = SprsY[i];
       			actor.HPos256 = actor.X * 256;
       			actor.VPos256 = actor.Y * 256;
       			actor.Ammor = Ammor;
       			actor.Bullets = actorBullet;
       			for(int t=0;t<actor.FollowTrackX.length;t++){
       				actor.FollowTrackX[t] = actor.HPos256;
       				actor.FollowTrackY[t] = actor.VPos256;
       			}
       			world.addSprite(actor);
       			
       		}else {
       			UnitBattleEnemy enemy = new UnitBattleEnemy(obj,point,ai);
       			for(int b=0;b<enemy.getBulletCount();b++){
		    		Ammor.addElement(new UnitBattleBullet(bullet));
		    	}
       			enemy.actor = actor;
       			enemy.Ammor = Ammor;
	       		enemy.Bullets = enemyBullet;
	       		enemy.X = SprsX[i];
	       		enemy.Y = SprsY[i];
	       		world.addSprite(enemy);
	       		closeEnemys.addElement(enemy);
       		}	
		}
//		
//		for(int i=0;i<closeEnemys.size();i++){
//			
//		}
		CSprite sub = ResesScript.createSprite_btSub(actor.getAnimates().getImages());
		actorSub = new UnitBattleSub[UnitBattleSub.SubCount];
		for(int s=0;s<actorSub.length;s++){
	    	for(int b=0;b<UnitBattleSub.WeaopnCount[UnitBattleSub.WeaopnType[s]];b++){
	    		Ammor.addElement(new UnitBattleBullet(bullet));
	    	}
	       	actorSub[s] = new UnitBattleSub(sub);
	       	actorSub[s].Father = actor;
	       	actorSub[s].SubIndex = s;
	       	
	       	actorSub[s].Ammor = Ammor;
	       	actorSub[s].Bullets = actorBullet;
	       	
	       	actorSub[s].setCurrentFrame(UnitBattleSub.WeaopnType[s]%4, 0);
	       	
	       	world.addSprite(actorSub[s]);
	    }
		world.addSprites(Ammor);
		
		}catch(Exception err){
			println(err.getMessage());
			err.printStackTrace();
		}
	}

	void initMap(){
//		地图
//      从编辑器的生成代码中创建 mapTile图片组，false是否显示动态地表，true是否循环地图
		//从编辑器得到敌人信息
       	String worldMapType = ResesScript.getWorldMapType(worldName);
       	String worldMapInfo = ResesScript.getWorldMapName(worldName);

		if(worldMapType == ResesScript.map_01_Map){
			mapTile = ResesScript.createClipImages_battleMapTile1();
			anyTile = null;
			mapLayer = null;
			map = ResesScript.createMap_01_Map(mapTile, false, true);
   		}else if(worldMapType == ResesScript.map_02_Map){
   			mapTile = ResesScript.createClipImages_battleMapTile2();
   			anyTile = ResesScript.createClipImages_anyThing_Tile();
   			mapLayer = ResesScript.createSprite_layer(anyTile);
   			map = ResesScript.createMap_02_Map(mapTile, false, true);
   		}else if(worldMapType == ResesScript.map_03_Map){
   			mapTile = ResesScript.createClipImages_battleMapTile3();
			anyTile = null;
			mapLayer = null;
			map = ResesScript.createMap_03_Map(mapTile, true, true);
   		}else{
   			mapTile = ResesScript.createClipImages_battleMapTile1();
			anyTile = null;
			mapLayer = null;
			map = ResesScript.createMap_01_Map(mapTile, false, true);
		}
		world.Height = map.getHeight() - 32;
		world.addMap(map);
	}
	
	void initCamera(){
//      手工创建一个 camera
       	cam = new CCamera(
       			0,0,
       			AScreen.SCREEN_WIDTH,
       			AScreen.SCREEN_WIDTH,
       			map,true,0
       			);
       	
       	world.addCamera(cam);
	}
	
	void initUI(){
		uiTile = ResesScript.createClipImages_fightUITile();
		ui = ResesScript.createSprite_fightUISprite(uiTile);
	}
	
//	------------------------------------------------------------------------------------------------------------------      	
	
	void over(){
		actor.Active = false;
		actor.SpeedX256 = 0;
		OverMaxTime = 100;
	}
	
	public void processActor(){
		if(OverMaxTime<0){
			
			if(isKeyDown(KEY_7)){
				for(int i=0;i<actorSub.length;i++){
					actorSub[i].SubType++;
					actorSub[i].SubType%=5;
				}
				startTimeText("辅助攻击改变!", 32, SCREEN_HEIGHT/2);
			}
			
			if(isKeyDown(KEY_5|KEY_C)){
				AutoFire = !AutoFire;
				startTimeText("火力开启!", 32, SCREEN_HEIGHT/2);
			}
			
			if(isKeyDown(KEY_1)){
				actor.WeaopnOn = !actor.WeaopnOn;
				if(actor.WeaopnOn){
					startTimeText("主武器开启!", 32, SCREEN_HEIGHT/2);
				}else{
					startTimeText("主武器关闭!", 32, SCREEN_HEIGHT/2);
				}
			}
			
			if(isKeyDown(KEY_3)){
				for(int i=actorSub.length-1;i>=0;i--){
					actorSub[i].WeaopnOn = !actorSub[i].WeaopnOn;
					if(actorSub[i].WeaopnOn){
						startTimeText("辅助武器开启!", 32, SCREEN_HEIGHT/2);
					}else{
						startTimeText("辅助武器关闭!", 32, SCREEN_HEIGHT/2);
					}
				}
			}
			
			actor.startMove(
					isKeyHold(KEY_RIGHT) ? 1 : (isKeyHold(AScreen.KEY_LEFT)?-1:0),//
					isKeyHold(KEY_DOWN ) ? 1 : (isKeyHold(AScreen.KEY_UP  )?-1:0) //
							) ;
	
			if(isPointerHold()){
				int dx = world.toWorldPosX(getPointerX()) - actor.X ;
				int dy = world.toWorldPosY(getPointerY()) - actor.Y ;
				actor.startMove(dx/16,dy/16) ;
			}
			
			if(actor.HPos256<world.getCamera().getX()*256)
				actor.HPos256 = world.getCamera().getX()*256;
			if(actor.HPos256>world.getCamera().getX()*256 + world.getCamera().getWidth()*256)
				actor.HPos256 = world.getCamera().getX()*256 + world.getCamera().getWidth()*256;
			
			if(actor.VPos256<0)
				actor.VPos256 = 0;
			if(actor.VPos256>world.Height*256)
				actor.VPos256 = world.Height*256;
			
			
			if(AutoFire){
				if( actor.startFire()){
					
				}
				for(int i=actorSub.length-1;i>=0;i--){
					CSprite target = null;
					if(actorSub[i].getBulletType()==UnitBattleBullet.TYPE_MISSILE1){
						if( openEnemys.size()>0){
							int start = Math.abs(Random.nextInt()%openEnemys.size());
							for(int j=openEnemys.size()-1;j>=0;j--){
								int id = (j + start) % openEnemys.size();  
								if(((CSprite)openEnemys.elementAt(id)).Active==true){
									target = ((CSprite)openEnemys.elementAt(id));
									break;
								}
							}
						}
					}	
					if(actorSub[i].startFire(target)){
					}
				}
			}
			
			
	//		println("actorBullet.size() = " + actorBullet.size());
			for(int i=actorBullet.size()-1;i>=0;i--){
				UnitBattleBullet bullet = (UnitBattleBullet)actorBullet.elementAt(i);
				if(bullet.Active){
					// targets
					for(int j=openEnemys.size()-1;j>=0;j--){
						UnitBattleEnemy enemy = (UnitBattleEnemy)openEnemys.elementAt(j);
						if(enemy.Active){
							if(CSprite.touch_SprSub_SprSub(
									bullet, 0, 0, 
									enemy, 0, 0)){
								enemy.HP -= bullet.getHP();
								bullet.startTerminate(enemy);
								if(enemy.HP>0){
									enemy.startDamage();
								}else{
									actor.SCORE += enemy.getHP();
									enemy.startDestory();
									if(enemy.getAI()>=50){
										over();
									}
								}
							}
						}
					}// end targets
				}else{
					actorBullet.removeElement(bullet);
					Ammor.addElement(bullet);
				}
			}
		
		
		}
	}

	
	public void processEnemy(){
		for(int i=closeEnemys.size()-1;i>=0;i--){
			UnitBattleEnemy enemy = (UnitBattleEnemy)closeEnemys.elementAt(i);
			if( enemy.X < cam.getX()+cam.getWidth()+32){
				closeEnemys.removeElement(enemy);
				openEnemys.addElement(enemy);
				enemy.spawn();
				enemy.actor = actor;
			}
		}
		
		for(int i=openEnemys.size()-1;i>=0;i--){
			UnitBattleEnemy enemy = (UnitBattleEnemy)openEnemys.elementAt(i);
			if( enemy.X < cam.getX()-32 ){
				if( !enemy.Active ){
					enemy.terminate();
					openEnemys.removeElement(enemy);
					world.removeSprite(enemy);
				}
			}
		}
		
//		println("enemyBullet.size() = " + enemyBullet.size());
		for(int i=enemyBullet.size()-1;i>=0;i--){
			UnitBattleBullet bullet = (UnitBattleBullet)enemyBullet.elementAt(i);
			if(bullet.Active){
				if(actor.Active){
					if(CSprite.touch_SprSub_SprSub(
							bullet, 0, 0, 
							actor, 0, 0)){
						actor.HP -= bullet.getHP();
						bullet.startTerminate(actor);
						if(actor.HP>0){
							actor.startDamage();
						}else{
							actor.startDestory();
							over();
						}
					}
				}
			}else{
				enemyBullet.removeElement(bullet);
				Ammor.addElement(bullet);
			}
		}
	}

	

	int CameraPos = 0;
	
	public void processCamera(){
		
		if(OverMaxTime>0){
			if(actor.HP>0){
				actor.HPos256 += 8*256;
				actor.X = actor.HPos256/256;
				actor.startSmoke();
			}else{
				actor.HPos256 -= 256;
				actor.X = actor.HPos256/256;
			}
		}else if(OverMaxTime==0){
			ChangeSubScreen("ScreenP00_World");
		}else{
//			自动卷轴
			if(cam.getX()+cam.getWidth()<world.Width){
				CameraPos += 128;
				actor.scrollMove(128);
				cam.setPos(CameraPos/256, cam.getY());
			}else{
				if(!isBossLevel){
					over();
				}
			}
		}
		
		
		
		// 摄象机琐定主角
//		int cdx = actor.X - (cam.getX() + cam.getWidth() /2);
    	int cdy = actor.Y - (cam.getY() + cam.getHeight()/2);

//    	int px = cdx/2;
    	int py = cdy/2;
    	
//    	if(cam.getX() + px > world.Width - cam.getWidth()){
//    		px = world.Width - cam.getWidth() - cam.getX();
//    	}else if(cam.getX() + px < 0){
//    		px = 0 - cam.getX();
//    	}
    	
    	if(cam.getY() + py > map.getHeight() - cam.getHeight()){
    		py = map.getHeight() - cam.getHeight() - cam.getY();
    	}else if(cam.getY() + py < 0){
    		py = 0 - cam.getY();
    	}
    	
    	cam.mov(0, py);
	}
	
	
	public void renderLayer(Graphics g){
		if(mapLayer!=null){
			g.setClip(cam.WindowX, cam.WindowY, cam.getWidth(), cam.getHeight());
			int width = mapLayer.getVisibleWidth();
			int count = (SCREEN_WIDTH-1)/width + 2;
			
			if(cam.getY()+cam.getHeight()>map.getHeight() - 16 - 22)
			for(int i=0;i<count;i++){
				mapLayer.setCurrentFrame(0, 0);
				mapLayer.Y = world.toScreenPosY(map.getHeight() - 16);
				mapLayer.X = cam.WindowX-getTimer()*1 % width + i*width;
				mapLayer.render(g, mapLayer.X, mapLayer.Y);
			}
			if(cam.getY()+cam.getHeight()>map.getHeight() - 8 - 22)
			for(int i=0;i<count;i++){
				mapLayer.setCurrentFrame(1, 0);
				mapLayer.Y = world.toScreenPosY(map.getHeight() - 8);
				mapLayer.X = cam.WindowX-getTimer()*2 % width + i*width;
				mapLayer.render(g, mapLayer.X, mapLayer.Y);
			}
			if(cam.getY()+cam.getHeight()>map.getHeight() - 0 - 22)
			for(int i=0;i<count;i++){
				mapLayer.setCurrentFrame(0, 0);
				mapLayer.Y = world.toScreenPosY(map.getHeight());
				mapLayer.X = cam.WindowX-getTimer()*3 % width + i*width;
				mapLayer.render(g, mapLayer.X, mapLayer.Y);
			}
		}
		
		ui.setCurrentFrame(0, 0);
		ui.render(g, 0, 0);
		
		renderHP(g, 51, 9, 68, 5, actor.HP, 100);
		renderText(g, 68, 28, 1, 11, ""+actor.SCORE);
		renderText(g,143, 19, 2,  7, ""+actor.AMMOR);
		
		if(textTime>0){
			textTime--;
			timeTextC += 10 ;
			timeTextC %= 256;
			drawString(g, timeText, timeTextX, timeTextY, 
					(timeTextC<<16)|
					(timeTextC<< 8)|
					(timeTextC<< 0)|
					0xff000000 
					);
		}
	}
	
	public void renderText(Graphics g,int x,int y,int anim,int w,String num){
		for(int i=0;i<num.length();i++){
			int a = anim;
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
			}
			ui.setCurrentFrame(a, n);
			ui.render(g, x + w*i, y);
		}
	}
	
	public void renderHP(Graphics g,int x,int y,int w,int h,int value,int max){
		g.setColor(0xffffff00);
		int ww = w * value/max;
		if(ww>0){
			g.fillRect(x, y, ww, h);
		}
	}
	

	int timeTextC = 0;
	int textTime = -1;
	String timeText = "";
	int timeTextX = 0;
	int timeTextY = 0;
	
	public void startTimeText(String text,int x,int y){
		textTime = 30;
		timeText = text;
		timeTextX = x;
		timeTextY = y;
		timeTextC = 0;
	}
	
}


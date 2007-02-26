
import game.unit.battle.BattleManager;
import game.unit.battle.UnitBattleActor;
import game.unit.battle.UnitBattleBullet;
import game.unit.battle.UnitBattleEnemy;
import game.unit.battle.UnitBattleSub;
import game.unit.world.UnitWorldActor;

import java.util.Hashtable;

import javax.microedition.lcdui.Graphics;

import com.cell.AScreen;
import com.cell.CMath;
import com.cell.IImages;
import com.cell.game.CCamera;
import com.cell.game.CMap;
import com.cell.game.CSprite;
import com.cell.game.CWayPoint;

/**继承抽象类CScreen并实现其中的方法*/
public class ScreenP00_Battle extends AScreen {
	
	public static String WorldName;
	
	//首先需要图片包资源
   	IImages mapTile ;
   	IImages anyTile ;
   	IImages eftTile ;
   	IImages uiTile ;
   	
   	
	/**游戏世界*/
   	BattleManager  world;
	
	String 		worldName;
	int			worldW;
	int			worldH;
	
	UnitBattleActor actor;
	UnitBattleSub[] actorSub ;
	

	
	CCamera		cam;
	CMap		map;
	
	CSprite 	mapLayer;
	CSprite 	ui;
	
	
	int OverMaxTime = -1;
	boolean isBossLevel = false;
	
	boolean AutoFire    = true;
	
	
	int CheatCount1 = 0;
	int CheatCount2 = 0;
	//该例子演示如何使用编辑器生成的数据构造一个游戏世界，
	//编辑器生成的数据是由一个文本脚本文件定义，参考编辑器安装目录下的ResesScript.txt。
	//脚本文件可以被定义生成任何格式的文本。
	//本例中该脚本被定义成一个对象工厂
	public ScreenP00_Battle(){
		
//		if(GameMIDlet.soundman!=null){
//			GameMIDlet.soundman.destroy();
//		}
		
		System.out.println("Start Free Memory = "+(Runtime.getRuntime().freeMemory()/1024)+"(K byte)");
	    
		try{
			FrameDelay = 40;
       	
//      世界信息
	       	if(WorldName!=null){
	       		worldName = WorldName;
	       	}else{
	       		worldName = ResesScriptBattle.WorldNames[Math.abs(Random.nextInt()%ResesScriptBattle.WorldNames.length)];
	       	}
		
			println("Entry : " + worldName);
			
			worldW = ResesScriptBattle.getWorldWidth(worldName);
			worldH = ResesScriptBattle.getWorldHeight(worldName);
	       	world = new BattleManager();
	       	world.Width = worldW;
	       	world.Height = worldH;
	    	world.WayPoints = ResesScriptBattle.getWorldWayPoints(worldName);

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
    	
		if(isKeyDown(KEY_STAR)) {
    		CheatCount1 ++;
    		if(CheatCount1%10==0){
    			ScreenP00_World.Destory(UnitWorldActor.CityIndex);
    			ChangeSubScreen("ScreenP00_World", "得到"+actor.SCORE+"金!");
    		}
    	}
		if(isKeyDown(KEY_SHARP)) {
    		CheatCount2 ++;
    		if(CheatCount2%10==0){
    			ScreenP00_World.Destory(UnitWorldActor.CityIndex);
    			ChangeSubScreen("ScreenP00_Over", "通关!");
    		}
    	}

//    	if(isKeyDown(KEY_0)){IsDebug = !IsDebug;}
    	
    	if(!Pause){
    		
    		if(isKeyDown(KEY_B)){notifyPause();}
        	if(isKeyDown(KEY_A)){notifyPause();}
        	
			processActor();
			processEnemy();
			processCamera();
			
			OverMaxTime--;
			
	    	//每帧更新一次游戏世界，游戏单位的状态机也将被更新
			world.update();
			
	    	//帧记录器增加
	        tickTimer();
	        
    	}else{

        	if(isKeyDown(KEY_UP)){
        		menuIndex = CMath.cycNum(menuIndex, -1, menu.length);
        	}
        	if(isKeyDown(KEY_DOWN)){
        		menuIndex = CMath.cycNum(menuIndex,  1, menu.length);
        	}
        	
        	if(isKeyDown(KEY_B)){Pause = false;}
        	if(isKeyDown(KEY_A|KEY_C)){
//        		TODO
        		switch(menuIndex){
        		case 0: Pause = false; break;
        		case 1: ChangeSubScreen("ScreenP00_World", "Loading..."); world.Dispose(); break;
        		case 2: ChangeSubScreen("ScreenP00_Menu" , "Loading..."); world.Dispose(); break;
        		}
        		
        		ScreenP00_World.Save();
        	}
    	}
    }
	
	public void notifyRender(Graphics g) {
        //clearScreenAndClip(g,0xff000000);
		
		//每帧渲染一次世界
        world.render(g);
        renderLayer(g);
        
        if(!Pause){
        	
        }else{
        	int h = (getStringHeight() + 1) * menu.length;
        	int y = SCREEN_HEIGHT/2 - h/2;
        	
        	g.setColor(0xff8080ff);
        	g.fillRect(0, y, SCREEN_WIDTH, h);
        	g.setColor(0xffffffff);
        	g.drawRect(0, y, SCREEN_WIDTH-1, h-1);
        	
        	for(int i=0;i<menu.length;i++){
        		if(i==menuIndex){
        			g.setColor(0xff0000ff);
                	g.fillRect(0, y + (getStringHeight() + 1) * i, SCREEN_WIDTH, (getStringHeight() + 1));
                	g.setColor(0xffffffff);
                	g.drawRect(0, y + (getStringHeight() + 1) * i, SCREEN_WIDTH-1, (getStringHeight() - 1));
                	
                	drawString(g, menu[i], 
            				SCREEN_WIDTH/2 - getStringWidth(menu[i])/2, 
            				y + (getStringHeight() + 1) * i , 
            				0xffffffff);
        		}else{
        			drawString(g, menu[i], 
            				SCREEN_WIDTH/2 - getStringWidth(menu[i])/2, 
            				y + (getStringHeight() + 1) * i , 
            				0xff000000);
        		}
        	}
        	
	    	int aw = getStringWidth("确定") +4;
	    	int ah = getStringHeight() +4;
	    	int ax = 1;
	    	int ay = SCREEN_HEIGHT - ah - 1;
	    	g.setColor(0xffff8080);
	    	g.fillRect(ax, ay, aw, ah);
	    	g.setColor(0xffffffff);
	    	g.drawRect(ax, ay, aw, ah);
	    	drawString(g, "确定", ax+2, ay+2, 0xffffffff);
	    	
	    	int bw = getStringWidth("取消")+4;
	    	int bh = getStringHeight()+4;
	    	int bx = SCREEN_WIDTH  - bw - 1;
	    	int by = SCREEN_HEIGHT - bh - 1;
	    	g.setColor(0xffff8080);
	    	g.fillRect(bx, by, bw, bh);
	    	g.setColor(0xffffffff);
	    	g.drawRect(bx, by, bw, bh);
	    	drawString(g, "取消", bx+2, by+2, 0xffffffff);
        }
        //显示FPS
//        showFPS(g, 1, 1, 0xffffffff);
        
//        drawString(g, "" + actor.HP, 1, 64, 0xffffffff);
    }

	String[] menu = new String[]{
			"继续游戏",
			"退出战场",
			"返回主菜单"
		};
	int menuIndex = 0;
	boolean Pause = false;
		
	public void notifyPause() {
		Pause = true;
		menuIndex = 0;
		
//		try{
//			GameMIDlet.soundman.pause();
//		}catch(Exception err){
//		}
	}
	public void notifyResume() {
//		try{
//			GameMIDlet.soundman.resume();
//		}catch(Exception err){
//		}
	}

//	------------------------------------------------------------------------------------------------

	void initSprite(){
//		try{
		
//		create bullet
		IImages bltTile = ResesScriptBattle.createClipImages_battleWeaopnTile();
		CSprite bullet  = ResesScriptBattle.createSprite_weaopnSprite(bltTile);
//		CSprite sub     = ResesScriptBattle.createSprite_btSub(tiles);
		
//		create world level
		String[] SprsTile = ResesScriptBattle.getWorldSprTile(worldName);
		String[] SprsType = ResesScriptBattle.getWorldSprType(worldName);
		String[] SprsInfo = ResesScriptBattle.getWorldSprName(worldName);
		int[] SprsX = ResesScriptBattle.getWorldSprX(worldName);
		int[] SprsY = ResesScriptBattle.getWorldSprY(worldName);
			
//		 create tile bank
		Hashtable tileTable = new Hashtable();
		for(int i=0;i<SprsTile.length;i++){
			if(!tileTable.containsKey(SprsTile[i])){
				IImages tile = ResesScriptBattle.createImages(SprsTile[i]);
				tileTable.put(SprsTile[i], tile);
//				println(" create tile : " + SprsTile[i]);
			}
		}
//		create sprs 	
		Hashtable sprTable = new Hashtable();
		for(int i=0;i<SprsType.length;i++){
			if(!sprTable.containsKey(SprsType[i])){
				CSprite spr = ResesScriptBattle.createSprite(SprsType[i],(IImages)tileTable.get(SprsTile[i]));
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
       		if(SprsType[i] == ResesScriptBattle.spr_btSpr){
       	       	actor = new UnitBattleActor(obj);
       	       	for(int b=0;b<UnitBattleActor.WeaopnCount[UnitBattleActor.WeaopnType];b+=1){
    		   		world.Ammor.addElement(new UnitBattleBullet(bullet));
    			}
       			actor.X = SprsX[i];
       			actor.Y = SprsY[i];
       			actor.HPos256 = actor.X * 256;
       			actor.VPos256 = actor.Y * 256;
       			actor.Ammor = world.Ammor;
       			actor.Bullets = world.actorBullet;
       			for(int t=0;t<actor.FollowTrackX.length;t++){
       				actor.FollowTrackX[t] = actor.HPos256;
       				actor.FollowTrackY[t] = actor.VPos256;
       			}
       			world.addSprite(actor);
       			
       		}else {
       			UnitBattleEnemy enemy = new UnitBattleEnemy(obj,point,ai);
       			for(int b=0;b<enemy.getBulletCount();b++){
       				world.Ammor.addElement(new UnitBattleBullet(bullet));
		    	}
       			enemy.actor = actor;
       			enemy.Ammor = world.Ammor;
	       		enemy.Bullets = world.enemyBullet;
	       		enemy.X = SprsX[i];
	       		enemy.Y = SprsY[i];
//	       		world.addSprite(enemy);
	       		world.closeEnemys.addElement(enemy);
       		}	
		}
//		
//		for(int i=0;i<closeEnemys.size();i++){
//			
//		}
		CSprite sub = ResesScriptBattle.createSprite_btSub(actor.getAnimates().getImages());
		actorSub = new UnitBattleSub[UnitBattleSub.SubCount];
		for(int s=0;s<actorSub.length;s++){
	    	for(int b=0;b<UnitBattleSub.WeaopnCount[UnitBattleSub.WeaopnType[s]];b++){
	    		world.Ammor.addElement(new UnitBattleBullet(bullet));
	    	}
	       	actorSub[s] = new UnitBattleSub(sub);
	       	actorSub[s].Father = actor;
	       	actorSub[s].SubIndex = s;
	       	
	       	actorSub[s].Ammor = world.Ammor;
	       	actorSub[s].Bullets = world.actorBullet;
	       	
	       	actorSub[s].AMMOR *= UnitBattleSub.WeaopnCount[UnitBattleSub.WeaopnType[s]];
	       	
	       	actorSub[s].setCurrentFrame(UnitBattleSub.WeaopnType[s]%4, 0);
	       	
	       	world.addSprite(actorSub[s]);
	    }
//		world.addSprites(world.Ammor);
		
//		}catch(Exception err){
//			println(err.getMessage());
//			err.printStackTrace();
//		}
	}

	void initMap(){
//		地图
//      从编辑器的生成代码中创建 mapTile图片组，false是否显示动态地表，true是否循环地图
		//从编辑器得到敌人信息
       	String worldMapType = ResesScriptBattle.getWorldMapType(worldName);
       	String worldMapInfo = ResesScriptBattle.getWorldMapName(worldName);

		if(worldMapType == ResesScriptBattle.map_01_Map){
			mapTile = ResesScriptBattle.createClipImages_battleMapTile1();
			anyTile = null;
			mapLayer = null;
			map = ResesScriptBattle.createMap_01_Map(mapTile, false, true);
//			try{
//				GameMIDlet.soundman = new CSoundPlayer("/BGM01.mid",CSoundPlayer.TYPE_MIDI,-1);
//				GameMIDlet.soundman.play();
//			}catch(Exception err){
//			}
   		}else if(worldMapType == ResesScriptBattle.map_02_Map){
   			mapTile = ResesScriptBattle.createClipImages_battleMapTile2();
   			anyTile = ResesScriptBattle.createClipImages_battleBGTile();
   			mapLayer = ResesScriptBattle.createSprite_layer(anyTile);
   			map = ResesScriptBattle.createMap_02_Map(mapTile, false, true);
//   			try{
//				GameMIDlet.soundman = new CSoundPlayer("/BGM02.mid",CSoundPlayer.TYPE_MIDI,-1);
//				GameMIDlet.soundman.play();
//			}catch(Exception err){
//			}
   		}else if(worldMapType == ResesScriptBattle.map_03_Map){
   			mapTile = ResesScriptBattle.createClipImages_battleMapTile3();
			anyTile = null;
			mapLayer = null;
			map = ResesScriptBattle.createMap_03_Map(mapTile, true, true);
//			try{
//				GameMIDlet.soundman = new CSoundPlayer("/BGM03.mid",CSoundPlayer.TYPE_MIDI,-1);
//				GameMIDlet.soundman.play();
//			}catch(Exception err){
//			}
   		}else{
   			mapTile = ResesScriptBattle.createClipImages_battleMapTile1();
			anyTile = null;
			mapLayer = null;
			map = ResesScriptBattle.createMap_01_Map(mapTile, false, true);
//			try{
//				GameMIDlet.soundman = new CSoundPlayer("/BGM01.mid",CSoundPlayer.TYPE_MIDI,-1);
//				GameMIDlet.soundman.play();
//			}catch(Exception err){
//			}
		}
		world.Height = map.getHeight() - 32;
		world.addMap(map);
	}
	
	void initCamera(){
//      手工创建一个 camera
       	cam = new CCamera(
       			0,0,
       			SCREEN_WIDTH,
       			SCREEN_HEIGHT+map.getCellH(),
       			map,true,0
       			);
       	
       	world.addCamera(cam);
	}
	
	void initUI(){
		uiTile = ResesScriptBattle.createClipImages_battleUITile();
		ui = ResesScriptBattle.createSprite_fightUISprite(uiTile);
	}
	
//	------------------------------------------------------------------------------------------------------------------      	
	
	void over(){
		actor.Active = false;
		actor.SpeedX256 = 0;
		OverMaxTime = 100;
		
		if(actor.HP>0){
			UnitBattleActor.Money += actor.SCORE;
		}else{
			UnitBattleActor.Money -= UnitBattleActor.Money/2;
		}
		
		
	}
	
	public void processActor(){
		if(OverMaxTime<0){
			
			if(isKeyDown(KEY_7)){
				for(int i=0;i<actorSub.length;i++){
					actorSub[i].SubType++;
					actorSub[i].SubType%=5;
				}
				startTimeText("辅助攻击改变!");
			}
			
//			if(isKeyDown(KEY_5)){
//				AutoFire = !AutoFire;
//				if(AutoFire){
//					startTimeText("火力开启!");
//				}else{
//					startTimeText("火力关闭!");
//				}
//				
//			}
			if(AutoFire){
				if(isKeyDown(KEY_1)){
					actor.WeaopnOn = !actor.WeaopnOn;
					if(actor.WeaopnOn){
						startTimeText("主武器开启!");
					}else{
						startTimeText("主武器关闭!");
					}
				}
				if(isKeyDown(KEY_3)){
					for(int i=actorSub.length-1;i>=0;i--){
						actorSub[i].WeaopnOn = !actorSub[i].WeaopnOn;
						if(actorSub[i].WeaopnOn){
							startTimeText("辅助武器开启!");
						}else{
							startTimeText("辅助武器关闭!");
						}
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
						if( world.openEnemys.size()>0){
							int start = Math.abs(Random.nextInt()%world.openEnemys.size());
							for(int j=world.openEnemys.size()-1;j>=0;j--){
								int id = (j + start) % world.openEnemys.size();  
								if(((CSprite)world.openEnemys.elementAt(id)).Active==true){
									target = ((CSprite)world.openEnemys.elementAt(id));
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
			for(int i=world.actorBullet.size()-1;i>=0;i--){
				UnitBattleBullet bullet = (UnitBattleBullet)world.actorBullet.elementAt(i);
				if(bullet.Active){
					// targets
					for(int j=world.openEnemys.size()-1;j>=0;j--){
						UnitBattleEnemy enemy = (UnitBattleEnemy)world.openEnemys.elementAt(j);
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
					world.actorBullet.removeElement(bullet);
					world.Ammor.addElement(bullet);
				}
			}
		
		
		}
	}

	
	public void processEnemy(){
		for(int i=world.closeEnemys.size()-1;i>=0;i--){
			UnitBattleEnemy enemy = (UnitBattleEnemy)world.closeEnemys.elementAt(i);
			if( enemy.X < cam.getX()+cam.getWidth()+32){
				world.closeEnemys.removeElement(enemy);
				world.openEnemys.addElement(enemy);
				enemy.spawn();
				enemy.actor = actor;
				enemy.world = world;
			}
		}
		
		for(int i=world.openEnemys.size()-1;i>=0;i--){
			UnitBattleEnemy enemy = (UnitBattleEnemy)world.openEnemys.elementAt(i);
			if( enemy.X < cam.getX()-32 ){
				if( !enemy.Active ){
					enemy.terminate();
					world.openEnemys.removeElement(enemy);
				}
			}
		}
		
//		println("enemyBullet.size() = " + enemyBullet.size());
		for(int i=world.enemyBullet.size()-1;i>=0;i--){
			UnitBattleBullet bullet = (UnitBattleBullet)world.enemyBullet.elementAt(i);
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
				world.enemyBullet.removeElement(bullet);
				world.Ammor.addElement(bullet);
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
			//TODO
//			ChangeSubScreen("ScreenP00_World");
			if(actor.HP>0){
				ScreenP00_World.Destory(UnitWorldActor.CityIndex);
				if(ScreenP00_World.GetUnDestoryedCityCount(ScreenP00_World.SavePos)<=0){
					ChangeSubScreen("ScreenP00_Over", "通关!");
				}else{
					ChangeSubScreen("ScreenP00_World", "得到"+actor.SCORE+"金!");
				}
			}else{
				ChangeSubScreen("ScreenP00_World", "丢失了一半金钱!");
			}
			world.Dispose();
			ScreenP00_World.Save();
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
		
		int subAmmor = 0;
		for(int i=0;i<actorSub.length;i++){
			subAmmor += actorSub[i].AMMOR;
		}
		renderText(g,36, 16, 2,  7, ""+subAmmor);
		
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
			g.fillRect(x+1, y+1, ww-1, h-1);
		}
	}
	

	int timeTextC = 0;
	int textTime = -1;
	String timeText = "";
	int timeTextX = 0;
	int timeTextY = 0;
	
	public void startTimeText(String text){
		textTime = 30;
		timeText = text;
		timeTextX = 8;
		timeTextY = ui.getVisibleHeight()+4;
		timeTextC = 0;
	}
	
	
	
//	-----------------------------------------------------------------------------------------------

	
	
	
	
	
	
	
}


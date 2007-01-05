
import game.unit.battle.UnitActor;
import game.unit.battle.UnitBullet;
import game.unit.battle.UnitEnemy;

import javax.microedition.lcdui.Graphics;


import com.morefuntek.cell.CImages20;
import com.morefuntek.cell.CImagesNokia;
import com.morefuntek.cell.CMath;
import com.morefuntek.cell.IImages;
import com.morefuntek.cell.Game.AScreen;
import com.morefuntek.cell.Game.CCamera;
import com.morefuntek.cell.Game.CMap;
import com.morefuntek.cell.Game.CSprite;
import com.morefuntek.cell.Game.CWorld;

/**继承抽象类CScreen并实现其中的方法*/
public class ScreenP00_Battle extends AScreen {
	/**游戏世界*/
	CWorld 		world;
	
	UnitActor actor;
	CSprite[] actorSub			= new CSprite[4];
	
	UnitEnemy[] enemys			= new UnitEnemy[32];
	UnitBullet[] enemyBullets	= new UnitBullet[32];
	UnitBullet[] actorBullets	= new UnitBullet[32];
	
	
	
	//该例子演示如何使用编辑器生成的数据构造一个游戏世界，
	//编辑器生成的数据是由一个文本脚本文件定义，参考编辑器安装目录下的ResesScript.txt。
	//脚本文件可以被定义生成任何格式的文本。
	//本例中该脚本被定义成一个对象工厂
	public ScreenP00_Battle(){
		
		FrameDelay = 20;
		
		//首先需要图片包资源
       	IImages mapTile ;
       	IImages sprTile ;
       	IImages bltTile ;
       	//判断是否为NOKIA平台
       	if(IsNokia){
       		mapTile = new CImagesNokia();
           	sprTile = new CImagesNokia();
           	bltTile = new CImagesNokia();
       	}else{
       		mapTile = new CImages20();
           	sprTile = new CImages20();
           	bltTile = new CImages20();
       	}
       	//从编辑器的生成代码中创建图片组
       	ResesScript.buildClipImages_BattleMapTile(mapTile);
       	ResesScript.buildClipImages_BattleSprTile(sprTile);
       	ResesScript.buildClipImages_BattleBulletTile(bltTile);
       	
       	
       	//从编辑器的生成代码中创建 mapTile图片组，false是否显示动态地表，true是否循环地图
       	CMap map = ResesScript.createMap_BattleMap(mapTile, false, false);
       	
       	//手工创建一个 camera
       	CCamera cam = new CCamera(
       			0,0,
       			AScreen.SCREEN_WIDTH,
       			AScreen.SCREEN_HEIGHT,
       			map,true,0);
       	
       	//从编辑器生成的代码中构造 world
       	world = new world_BattleLevel00();
       	//初始化路点
       	((world_BattleLevel00)world).initPath();
       	//设置地图
       	((world_BattleLevel00)world).Map0000_BattleMap = map;
       	//设置世界中的精灵
       	//null spr
       	//所有的精灵被设置后，初始化精灵单位
       	((world_BattleLevel00)world).initUnit();
       	//为世界添加摄象机
       	world.addCamera(cam);
       	
       	//-->到此，一个基本游戏世界构造完了，但该世界是一个没有生命的世界，以下代码为世界添加活力。
     
       	actor = new UnitActor(ResesScript.createSprite_BattleAct(sprTile));
       
       	for(int i=0;i<actorSub.length;i++){
       		actorSub[i] = actor.clone();
       	}
       	actor.Sub = actorSub;
       	
       	for(int i=0;i<enemys.length;i++){
       		if(i==0){
       			enemys[0] = new UnitEnemy(ResesScript.createSprite_BattleEnemy00(sprTile));
       		}else{
       			enemys[i] = new UnitEnemy(enemys[0]);
       		}
       		enemys[i].NextWayPoint = world.WayPoints[i%world.WayPoints.length];
       	}
       	for(int i=0;i<actorBullets.length;i++){
       		if(i==0){
       			actorBullets[0] = new UnitBullet(ResesScript.createSprite_BattleBullet(bltTile));
       		}else{
       			actorBullets[i] = new UnitBullet(actorBullets[0]);
       		}
       		
       		actorBullets[i].Active = false;
       		actorBullets[i].Visible = false;
       	}
       	for(int i=0;i<enemyBullets.length;i++){
       		if(i==0){
       			enemyBullets[0] = new UnitBullet(ResesScript.createSprite_BattleBullet(bltTile));
       		}else{
       			enemyBullets[i] = new UnitBullet(enemyBullets[0]);
       		}
       		
       		enemyBullets[i].Active = false;
       		enemyBullets[i].Visible = false;
       	}
       	
       	world.isRPGView = false;
       	

       	//priority
       	world.addSprites(enemys);
       	
       	world.addSprites(actor.Sub);
       	world.addSprite(actor);
       	
       	world.addSprites(enemyBullets);
       	world.addSprites(actorBullets);
       	
       	//帧记录器清零
       	resetTimer();
	}
	
	public void notifyLogic() {
		//按0键退出
    	if(isKeyDown(KEY_0)){IsDebug = !IsDebug;}
    	if(isKeyDown(KEY_B)){ExitGame = true;}
    	
		processActor();
		processEnemy();
		processActorBullets();
		processEnemyBullets();
		
		processCamera();
		
    	//每帧更新一次游戏世界，游戏单位的状态机也将被更新
		world.update();
    	//帧记录器增加
        tickTimer();
        
    }
	
	public void notifyRender(Graphics g) {
        //clearScreenAndClip(g,0xff000000);
		
		//每帧渲染一次世界
        world.render(g);
        
        drawString(g, "weaopn > "+
        		actor.MainWeaopn+"|"+
        		actor.SubWeaopn[0]+":"+
        		actor.SubWeaopn[1]+":"+
        		actor.SubWeaopn[2]+":"+
        		actor.SubWeaopn[3]+":"
        		, 1, 16, 0xffffffff);
        
        //显示FPS
        showFPS(g, 1, 1, 0xffffffff);
        
    }

	
	public void notifyPause() {}
	public void notifyResume() {}

	
	public void processActor(){
		actor.startMove(
				isKeyHold(KEY_RIGHT) ? 1 : (isKeyHold(AScreen.KEY_LEFT)?-1:0),//
				isKeyHold(KEY_DOWN ) ? 1 : (isKeyHold(AScreen.KEY_UP  )?-1:0) //
						) ;

		if(isPointerHold()){
			int dx = world.toWorldPosX(getPointerX()) - actor.X ;
			int dy = world.toWorldPosY(getPointerY()) - actor.Y ;
			actor.startMove(dx/16,dy/16) ;
		}
		
		if(isKeyHold(KEY_C)){
			actor.startFire(actorBullets,enemys);
		}

    	if(isKeyDown(KEY_1)){
    		actor.SubType ++ ;
    		actor.SubType%=actor.SubCount;
    	}
		
    	if(isKeyDown(KEY_5)){
    		actor.MainWeaopn++;
    		actor.MainWeaopn%=actor.WeaopnCount;
    	}
		if(isKeyDown(KEY_6)){
			actor.SubWeaopn[0]++;
    		actor.SubWeaopn[0]%=actor.WeaopnCount;
		}
		if(isKeyDown(KEY_7)){
			actor.SubWeaopn[1]++;
    		actor.SubWeaopn[1]%=actor.WeaopnCount;
		}
		if(isKeyDown(KEY_8)){
			actor.SubWeaopn[2]++;
    		actor.SubWeaopn[2]%=actor.WeaopnCount;
		}
		if(isKeyDown(KEY_9)){
			actor.SubWeaopn[3]++;
    		actor.SubWeaopn[3]%=actor.WeaopnCount;
		}
	}
	
	public void processEnemy(){
		for(int j=enemys.length-1;j>=0;j--){
			if(Random.nextInt()%32==1){
				if(enemys[j].Active){
					enemys[j].startFire(enemyBullets,actor);
				}
			}
		}
	}
	
	public void processActorBullets(){
		// bullets
		for(int i=actorBullets.length-1;i>=0;i--){
			if(actorBullets[i].Active){
				// targets
				for(int j=enemys.length-1;j>=0;j--){
					if(enemys[j].Active){
						if(CSprite.touch_SprSub_SprSub(
								actorBullets[i], 0, 0, 
								enemys[j], 0, 0)){
							if(!actorBullets[i].Penetrable){//是否穿透
								actorBullets[i].startTerminate(actorBullets[i].X, actorBullets[i].Y);
								enemys[j].startSwing();
								break;
							}else{
								enemys[j].startSwing();
							}
						}
					}
				}// end targets
			}
		}// end bullets
	}
	
	public void processEnemyBullets(){
		// bullets
		for(int i=enemyBullets.length-1;i>=0;i--){
			if(enemyBullets[i].Active){
				// targets
				if(CSprite.touch_SprSub_SprSub(
						enemyBullets[i], 0, 0, 
						actor, 0, 0)){
					if(!enemyBullets[i].Penetrable){//是否穿透
						enemyBullets[i].startTerminate(
								enemyBullets[i].X, 
								enemyBullets[i].Y);
					}else{
					}
					actor.startDamage();
					CameraShakeTime = CameraShakeMaxTime;
				}
				
				for(int j=actor.Sub.length-1;j>=0;j--){
					if(actor.Sub[j].Active){
						if(CSprite.touch_SprSub_SprSub(
								enemyBullets[i], 0, 0, 
								actor.Sub[j], 0, 0)){
							if(!enemyBullets[i].Penetrable){//是否穿透
								enemyBullets[i].startTerminate(enemyBullets[i].X, enemyBullets[i].Y);
								break;
							}else{
							}
						}
					}
				}// end targets
				
			}
		}// end bullets
	}
	
	int CameraShakeMaxTime = 100;
	int CameraShakeTime = -1;
	
	public void processCamera(){
		
//		//自动卷轴
//		world.getCamera().mov(1, 0);
//		if(world.getCamera().getX()+world.getCamera().getWidth()<world.getMap().getWidth()){
//			actor.scrollMove(1);
//		}
		
		// 摄象机琐定主角
		int cdx = actor.X - (world.getCamera().getX() + world.getCamera().getWidth() /2);
    	int cdy = actor.Y - (world.getCamera().getY() + world.getCamera().getHeight()/2);
    	world.getCamera().mov(cdx/2,cdy/2);
    	
//    	if(CameraShakeTime>0){
//    		CameraShakeTime--;
//    		world.getCamera().mov(0,CMath.sinTimes256(getTimer()*180)/128);
//    	}
    	
    	
	}
	
	
}


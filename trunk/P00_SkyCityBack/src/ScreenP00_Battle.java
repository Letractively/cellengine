
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

/**�̳г�����CScreen��ʵ�����еķ���*/
public class ScreenP00_Battle extends AScreen {
	/**��Ϸ����*/
	CWorld 		world;
	
	UnitActor actor;
	CSprite[] actorSub			= new CSprite[4];
	
	UnitEnemy[] enemys			= new UnitEnemy[32];
	UnitBullet[] enemyBullets	= new UnitBullet[32];
	UnitBullet[] actorBullets	= new UnitBullet[32];
	
	
	
	//��������ʾ���ʹ�ñ༭�����ɵ����ݹ���һ����Ϸ���磬
	//�༭�����ɵ���������һ���ı��ű��ļ����壬�ο��༭����װĿ¼�µ�ResesScript.txt��
	//�ű��ļ����Ա����������κθ�ʽ���ı���
	//�����иýű��������һ�����󹤳�
	public ScreenP00_Battle(){
		
		FrameDelay = 20;
		
		//������ҪͼƬ����Դ
       	IImages mapTile ;
       	IImages sprTile ;
       	IImages bltTile ;
       	//�ж��Ƿ�ΪNOKIAƽ̨
       	if(IsNokia){
       		mapTile = new CImagesNokia();
           	sprTile = new CImagesNokia();
           	bltTile = new CImagesNokia();
       	}else{
       		mapTile = new CImages20();
           	sprTile = new CImages20();
           	bltTile = new CImages20();
       	}
       	//�ӱ༭�������ɴ����д���ͼƬ��
       	ResesScript.buildClipImages_BattleMapTile(mapTile);
       	ResesScript.buildClipImages_BattleSprTile(sprTile);
       	ResesScript.buildClipImages_BattleBulletTile(bltTile);
       	
       	
       	//�ӱ༭�������ɴ����д��� mapTileͼƬ�飬false�Ƿ���ʾ��̬�ر�true�Ƿ�ѭ����ͼ
       	CMap map = ResesScript.createMap_BattleMap(mapTile, false, false);
       	
       	//�ֹ�����һ�� camera
       	CCamera cam = new CCamera(
       			0,0,
       			AScreen.SCREEN_WIDTH,
       			AScreen.SCREEN_HEIGHT,
       			map,true,0);
       	
       	//�ӱ༭�����ɵĴ����й��� world
       	world = new world_BattleLevel00();
       	//��ʼ��·��
       	((world_BattleLevel00)world).initPath();
       	//���õ�ͼ
       	((world_BattleLevel00)world).Map0000_BattleMap = map;
       	//���������еľ���
       	//null spr
       	//���еľ��鱻���ú󣬳�ʼ�����鵥λ
       	((world_BattleLevel00)world).initUnit();
       	//Ϊ������������
       	world.addCamera(cam);
       	
       	//-->���ˣ�һ��������Ϸ���繹�����ˣ�����������һ��û�����������磬���´���Ϊ������ӻ�����
     
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
       	
       	//֡��¼������
       	resetTimer();
	}
	
	public void notifyLogic() {
		//��0���˳�
    	if(isKeyDown(KEY_0)){IsDebug = !IsDebug;}
    	if(isKeyDown(KEY_B)){ExitGame = true;}
    	
		processActor();
		processEnemy();
		processActorBullets();
		processEnemyBullets();
		
		processCamera();
		
    	//ÿ֡����һ����Ϸ���磬��Ϸ��λ��״̬��Ҳ��������
		world.update();
    	//֡��¼������
        tickTimer();
        
    }
	
	public void notifyRender(Graphics g) {
        //clearScreenAndClip(g,0xff000000);
		
		//ÿ֡��Ⱦһ������
        world.render(g);
        
        drawString(g, "weaopn > "+
        		actor.MainWeaopn+"|"+
        		actor.SubWeaopn[0]+":"+
        		actor.SubWeaopn[1]+":"+
        		actor.SubWeaopn[2]+":"+
        		actor.SubWeaopn[3]+":"
        		, 1, 16, 0xffffffff);
        
        //��ʾFPS
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
							if(!actorBullets[i].Penetrable){//�Ƿ�͸
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
					if(!enemyBullets[i].Penetrable){//�Ƿ�͸
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
							if(!enemyBullets[i].Penetrable){//�Ƿ�͸
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
		
//		//�Զ�����
//		world.getCamera().mov(1, 0);
//		if(world.getCamera().getX()+world.getCamera().getWidth()<world.getMap().getWidth()){
//			actor.scrollMove(1);
//		}
		
		// �������������
		int cdx = actor.X - (world.getCamera().getX() + world.getCamera().getWidth() /2);
    	int cdy = actor.Y - (world.getCamera().getY() + world.getCamera().getHeight()/2);
    	world.getCamera().mov(cdx/2,cdy/2);
    	
//    	if(CameraShakeTime>0){
//    		CameraShakeTime--;
//    		world.getCamera().mov(0,CMath.sinTimes256(getTimer()*180)/128);
//    	}
    	
    	
	}
	
	
}


package game.unit.battle;

import java.util.Vector;

import javax.microedition.lcdui.Graphics;
import com.morefuntek.cell.CMath;
import com.morefuntek.cell.Game.AScreen;
import com.morefuntek.cell.Game.CCD;
import com.morefuntek.cell.Game.CSprite;
import com.morefuntek.cell.Game.CWayPoint;
import com.morefuntek.cell.Game.IState;
import com.morefuntek.cell.ParticleSystem.CParticle;
import com.morefuntek.cell.ParticleSystem.CParticleSystem;
import com.morefuntek.cell.ParticleSystem.IParticleLauncher;

public class UnitBattleEnemy extends CSprite /*implements IParticleLauncher*/{

	static public int Level = 10;

	static public int getKeyValue(String src,String key){
		try{
			int pos = src.indexOf(key) + key.length();
			return Integer.parseInt(src.substring(pos, pos+2), 10);
		}catch(Exception err){
			return -1;
		}
	}
	
	boolean isTrack  = false;
	boolean isScroll = false;
	boolean isAttack = false;
	boolean isHold	 = true;
	
	
//	int type = -1;
	int ai = -1;
	
	public Vector Ammor;
	public Vector Bullets;
	
	public int HP = 100;
	public CSprite actor = null;
	
	//-------------------------------------------------------------------------------------------------
	
	public UnitBattleEnemy(CSprite stuff,CWayPoint point,int ai){
		super(stuff);
		Active  = false;
		
//		CParticle[] particles = new CParticle[8];
//       	for(int i=0;i<particles.length;i++){
//       		particles[i] = new CParticle();
//       	}
//       	Effect = new CParticleSystem(particles,this);
       	
//		this.type = type;
		this.ai = ai;
		
		NextWayPoint = point;
		
		if(NextWayPoint!=null){
			isTrack = true;
		}
		
		switch(ai){
		case 1:
		case 2:
		case 3:
			
		case 10:
		case 11:
		case 12:
			
		case 13:
		case 14:
		case 15:
			
		case 16:
		case 17:
		case 18:
			
			isScroll = true;
			break;
			
		case 4:
		case 5:
		case 6:
			isHold = true;
			break;
			
		case 7:
		case 8:
		case 9:
			isAttack = true;
			break;
		case 50:
		case 51:
		case 52:
		case 53:
		case 54:
			TrackMaxSpeed = 1;
			break;
		}
		
		HP = getHP();
	}
	
	
	public void update() {

		try{
		if(Active){
			if(isTrack){
				onTrack();
			}else if(isScroll){
				onScroll();
			}else if(isAttack){
				onAttack();
			}else if(isHold){
				onHold();
			}else {
				terminate();
			}
			
			onDamage();
			onDestory();
			onFire();
			
			nextCycFrame();
		}
		}catch(Exception err){
			
		}
//		Effect.update();
	}

	
	public void render(Graphics g, int x, int y) {
		super.render(g, x, y);
//		Effect.render(g);
	}


	public void spawn(){
		Active = true;
		Visible = true;
		HPos256 = X*256;
		VPos256 = Y*256;
	}
	
	public void terminate(){
		Active = false;
		Visible = false;
	}
	
	
	public int getAI(){
		return ai;
	}
	
	//敌人初始HP
	public int getHP(){
		switch(ai){
		case 1:return 4*3;
		case 2:return 4*4;
		case 3:return 4*5;
		
		case 4:return 4*3;
		case 5:return 4*4;
		case 6:return 4*5;
		
		case 7:return 4*6;
		case 8:return 4*7;
		case 9:return 4*8;
		
		case 10:return 60;
		case 11:return 80;
		case 12:return 100;
		
		case 13:return 2;
		case 14:return 4;
		case 15:return 8;
		case 16:return 4;
		case 17:return 8;
		case 18:return 16;
		
		case 50:return 4000;//海盗
		case 51:return 20000;//太阳
		case 52:return 4000;//触手
		case 53:return 3000;//潜水艇
		case 54:return 3000;//UFO
		
		default:return 10;
		}
	}
	
//	敌人初始子弹数量
	public int getBulletCount(){
		switch(ai){
		case 1:return 2;
		case 2:return 2;
		case 3:return 2;
		
		case 4:return 3;
		case 5:return 3;
		case 6:return 3;
		
		case 7:return 4;
		case 8:return 4;
		case 9:return 4;
		
		case 10:return 5;
		case 11:return 5;
		case 12:return 5;
		
		case 13:return 8;
		case 14:return 8;
		case 15:return 8;
		case 16:return 8;
		case 17:return 8;
		case 18:return 8;
		
		case 50:return 32;
		case 51:return 32;
		case 52:return 32;
		case 53:return 32;
		case 54:return 32;
		
		default:return 1;
		}
	}
//---------------------------------------------------------------------------------------
//	开火
	

	int ForzenTimeMax = 2 ;
	int ForzenTime	= 0;
	public void startFire(CSprite target){
		if(ForzenTime>0)return;
		if(ForzenTime<0)ForzenTime = 0;
		int cdframe;
		switch(ai){
		case 1:fireSingle(target);break;
		case 2:fireSingleAngle(target);break;
		case 3:fireMultiAngle(target);break;
		
		case 4:fireMissile(target);break;
		case 5:fireMissile(target);break;
		case 6:fireMissile(target);break;
			
		case 7:fireSingle(target);break;
		case 8:fireSingle(target);break;
		case 9:fireSingle(target);break;

		case 10:fireLight(target);break;
		case 11:fireSingleAngle(target);break;
		case 12:fireMultiAngle(target);break;
		
		case 13:fireExpSingleAngle(target);break;
		case 14:fireExp(target);break;
		case 15:fireExpAngle(target);break;
			
		case 16:fireExpSingleAngle(target);break;
		case 17:fireExp(target);break;
		case 18:fireExpAngle(target);break;
			
		case 50:
			switch(Math.abs(Random.nextInt()%3)){
			case 0:fireBossSingleAngle(target,0,0);break;
			case 1:fireBossMultiAngle(target,0,0);break;
			case 2:fireMissile(target);break;
			}
			ForzenTimeMax = 4;;
			break;
		case 51:
			cdframe = FrameCDExt[CurAnimate][CurFrame];
			for(int i=0;i<collides.getFrames()[cdframe].length;i++){
				UnitBattleBullet bullet;
				switch(Math.abs(Random.nextInt()%2)){
				case 0:
					bullet = getAmmor();
					if(bullet!=null){
						bullet.fire(UnitBattleBullet.TYPE_SLUG2, this, target, 
								X + collides.getCD(collides.getFrames()[cdframe][i]).X1, 
								Y + collides.getCD(collides.getFrames()[cdframe][i]).Y1, 
								target.X, 
								target.Y, 4, 0);
					}
					break;
				case 1:
					bullet = getAmmor();
					if(bullet!=null){
						bullet.fire(UnitBattleBullet.TYPE_LIGHT2, this, target, 
								X + collides.getCD(collides.getFrames()[cdframe][i]).X1, 
								Y + collides.getCD(collides.getFrames()[cdframe][i]).Y1, 
								X + collides.getCD(collides.getFrames()[cdframe][i]).X1 - 1, 
								Y + collides.getCD(collides.getFrames()[cdframe][i]).Y1 , 
								4, 0);
					}
					break;
				}
			}
			ForzenTimeMax = 4;;
			break;
		case 52:
			cdframe = FrameCDExt[CurAnimate][CurFrame];
			for(int i=0;i<collides.getFrames()[cdframe].length;i++){
				fireBossSingleAngle(target,
						collides.getCD(collides.getFrames()[cdframe][i]).X1,
						collides.getCD(collides.getFrames()[cdframe][i]).Y1);
			}
			ForzenTimeMax = 4;;
			break;
		case 53:
			switch(Math.abs(Random.nextInt()%2)){
			case 0:fireBossMultiAngle(target,0,0);break;
			case 1:fireMissile(target);break;
			}
			ForzenTimeMax = 4;;
			break;
		case 54:
			switch(Math.abs(Random.nextInt()%2)){
			case 0:fireMultiAngle(target);break;
			case 1:fireMissile(target);break;
			}
			ForzenTimeMax = 4;
			break;
		default:break;
		}
			
		ForzenTime = ForzenTimeMax;
	}

	private void fireBossSingleAngle(CSprite target,int px,int py){
		UnitBattleBullet bullet = getAmmor();
		if(bullet!=null){
			bullet.fire(UnitBattleBullet.TYPE_SLUG2, this, target, X+px, Y+py, target.X, target.Y, 8, 0);
			ForzenTimeMax += bullet.getForzenTime();
		}
	}
	
	private void fireBossMultiAngle(CSprite target,int px,int py){
		int angle = CMath.atan2(actor.Y - Y+py, actor.X - X+px);
		for(int i=0;i<3;i++){
			int dx = CMath.cosTimes256(angle -30 + i*30);
			int dy = CMath.sinTimes256(angle -30 + i*30);
			UnitBattleBullet bullet = getAmmor();
			if(bullet!=null){
				bullet.fire(UnitBattleBullet.TYPE_SLUG2, this, target, X+px, Y+py, X + dx , Y + dy, 8, 0);
				ForzenTimeMax += bullet.getForzenTime();
			}
		}
	}
	
	
	private void fireSingle(CSprite target){
//		 single
		UnitBattleBullet bullet = getAmmor();
		if(bullet!=null){
			bullet.fire(UnitBattleBullet.TYPE_SLUG2, this, target, X, Y, -1, Y, 4, 0);
			ForzenTimeMax += bullet.getForzenTime();
		}
	}
	private void fireSingleAngle(CSprite target){
		UnitBattleBullet bullet = getAmmor();
		if(bullet!=null){
			bullet.fire(UnitBattleBullet.TYPE_SLUG2, this, target, X, Y, target.X, target.Y, 4, 0);
			ForzenTimeMax += bullet.getForzenTime();
		}
	}
	
	private void fireMulti(CSprite target){
//		 multi 
		for(int i=0;i<3;i++){
			int dx = CMath.cosTimes256(180 -45 + i*45);
			int dy = CMath.sinTimes256(180 -45 + i*45);
			UnitBattleBullet bullet = getAmmor();
			if(bullet!=null){
				bullet.fire(UnitBattleBullet.TYPE_SLUG2, this, target, X, Y, X + dx, Y + dy, 4, 0);
				ForzenTimeMax += bullet.getForzenTime();
			}
		}
	}
	

	
	private void fireMultiAngle(CSprite target){
		int angle = CMath.atan2(actor.Y - Y, actor.X - X);
		for(int i=0;i<3;i++){
			int dx = CMath.cosTimes256(angle -30 + i*30);
			int dy = CMath.sinTimes256(angle -30 + i*30);
			UnitBattleBullet bullet = getAmmor();
			if(bullet!=null){
				bullet.fire(UnitBattleBullet.TYPE_SLUG2, this, target, X, Y, X + dx, Y + dy, 4, 0);
				ForzenTimeMax += bullet.getForzenTime();
			}
		}
	}
	
	private void fireLight(CSprite target){
		UnitBattleBullet bullet = getAmmor();
		if(bullet!=null){
			bullet.fire(UnitBattleBullet.TYPE_LIGHT2, this, target, X, Y, -1, Y, 4, 0);
			ForzenTimeMax += bullet.getForzenTime();
		}
	}
	
	private void fireMissile(CSprite target){
		UnitBattleBullet bullet = getAmmor();
		if(bullet!=null){
			bullet.fire(UnitBattleBullet.TYPE_MISSILE2, this, target, X, Y, 0, 0, 0, 20);
			ForzenTimeMax += bullet.getForzenTime();
		}
	}
	
	private void fireExp(CSprite target){
		for(int i=0;i<8;i++){
			int dx = CMath.cosTimes256(i*45);
			int dy = CMath.sinTimes256(i*45);
			UnitBattleBullet bullet = getAmmor();
			if(bullet!=null){
				bullet.fire(UnitBattleBullet.TYPE_SLUG2, this, target, X, Y, X + dx, Y + dy, 8, 0);
				ForzenTimeMax += bullet.getForzenTime();
			}
		}
	}
	
	private void fireExpAngle(CSprite target){
		int angle = CMath.atan2(actor.Y - Y, actor.X - X);
		for(int i=0;i<3;i++){
			int dx = CMath.cosTimes256(angle -30 + i*30);
			int dy = CMath.sinTimes256(angle -30 + i*30);
			UnitBattleBullet bullet = getAmmor();
			if(bullet!=null){
				bullet.fire(UnitBattleBullet.TYPE_SLUG2, this, target, X, Y, X + dx, Y + dy, 8, 0);
				ForzenTimeMax += bullet.getForzenTime();
			}
		}
	}
	
	private void fireExpSingleAngle(CSprite target){
		UnitBattleBullet bullet = getAmmor();
		if(bullet!=null){
			bullet.fire(UnitBattleBullet.TYPE_SLUG2, this, target, X, Y, target.X, target.Y, 8, 0);
			ForzenTimeMax += bullet.getForzenTime();
		}
	}
	
	void onFire(){
		ForzenTime--;
		
		if(Random.nextInt()%Level==0){
			switch(ai){
			case 13:
			case 14:
			case 15:
			case 16:
			case 17:
			case 18:
				break;
			default:
				startFire(actor);
			}
			
		}
	}
	
	UnitBattleBullet getAmmor(){
		if(!Ammor.isEmpty()){
			UnitBattleBullet bullet = (UnitBattleBullet)Ammor.firstElement();
			
			Bullets.addElement(bullet);
			Ammor.removeElement(bullet);
			
			return bullet;
		}else{
			return null;
		}
	}
	
//---------------------------------------------------------------------------------------
	private boolean isEndHold(){
		return X<world.getCamera().getX() - 32 ;
	}
	private void onHold(){
		if(isEndHold()){
			isHold = false;
			return;
		}
		X = HPos256 / 256 ;
	}
//	---------------------------------------------------------------------------------------
	private boolean isEndScroll(){
		return X<world.getCamera().getX() - 32  ;
	}
	private void onScroll(){
		if(isEndScroll()){
			isScroll = false;
			return;
		}
		HPos256 -= 128;
		X = HPos256 / 256 ;
	}	
	
//------------------------------------------------------------------------------------

	//patrol
	CWayPoint NextWayPoint;
	int TrackMaxSpeed = 2/*+Math.abs(Random.nextInt()%4)*/;
	private boolean isEndTrack(){
		if(NextWayPoint==null)return true;
		if(NextWayPoint.X < world.getCamera().getX() - world.getCamera().getWidth())return true;
		return false;
	}
	private void onTrack(){
		if(isEndTrack()){
			isTrack = false;
			return;
		}
		
		DirectX = NextWayPoint.X - X;
		DirectY = NextWayPoint.Y - Y;
		
		int dx = (DirectX==0 ? 0 : (DirectX>0 ? TrackMaxSpeed : -TrackMaxSpeed));
		int dy = (DirectY==0 ? 0 : (DirectY>0 ? TrackMaxSpeed : -TrackMaxSpeed));
		
		if(Math.abs(dx)>Math.abs(DirectX))dx = DirectX;
		if(Math.abs(dy)>Math.abs(DirectY))dy = DirectY;
		
		HPos256 += dx*256;
		VPos256 += dy*256;

		X = HPos256/256;
		Y = VPos256/256;
		
		if(X==NextWayPoint.X && Y==NextWayPoint.Y){
			if(NextWayPoint.getNextCount()>0){
				int id = Math.abs(Random.nextInt()%NextWayPoint.getNextCount());
				NextWayPoint = NextWayPoint.getNextPoint(id);
			}else{
				NextWayPoint = null;
			}
		}
	}


	
	

//	----------------------------------------------------------------------------------------------------
	int AttackTime 				= 500;
	int AttackMaxSpeed			= 2;
	private boolean isEndAttack(){
		return !actor.Active || AttackTime<0 || X<world.getCamera().getX()-32;
		
	}
	private void onAttack(){
		
		if(isEndAttack()){
			isAttack = false;
			return;
		}
		
		AttackTime--;
		
		if( X > actor.X ){
			int dx = actor.X - X;
			int dy = actor.Y - Y;
				
			int bx = Math.abs(dx)*256/AttackMaxSpeed;
			int by = Math.abs(dy)*256/AttackMaxSpeed;
			int d = Math.max(bx,by);
			
			if(d!=0){
				SpeedX256 = (dx) * 256 * 256 / d ;
				SpeedY256 = (dy) * 256 * 256 / d ;
			}

			HPos256 += SpeedX256 ; 
			VPos256 += SpeedY256 ; 
			
		}else{
//			HPos256 -= AttackMaxSpeed * 256 ;
			
			HPos256 += SpeedX256 * 2 - 256 ; 
			VPos256 += SpeedY256 * 2 ; 
		}
		
			
		X = HPos256/256;
		Y = VPos256/256;
		
		
		
		nextCycFrame();
		
//		println("run Missile 1 : " + Type + " : "+ X + " : " + Y);
	}
//	------------------------------------------------------------------------------------

	//patrol
	int DamageTime = 0;
	public void startDamage(){
		if(DamageTime<0){
			switch(ai){
			case 50:
			case 51:
			case 52:
			case 53:
			case 54:
			case 55:	
				DamageTime = 2;
				HPos256 = X * 256 ; 
				VPos256 = Y * 256 ; 
				break;
			default:
				DamageTime = 10;
				HPos256 = X * 256 ; 
				VPos256 = Y * 256 ; 
			}
		}
	}

	void onDamage(){
		DamageTime--;
		if(DamageTime>0){
			switch(ai){
			case 50:
			case 51:
			case 52:
			case 53:
			case 54:
			case 55:	
				setCurrentFrame(1, 0);
				break;
			default:
				HPos256 -= CMath.sinTimes256(DamageTime*90)*4;
				VPos256 -= CMath.cosTimes256(DamageTime*90)*4;
				X = HPos256 / 256 ;
				Y = VPos256 / 256 ;
			}
		}
		if( DamageTime == 0 ){
			setCurrentFrame(0, 0);
		}
	}
	
//	----------------------------------------------------------------------------------------------------
	
	
	
	public void startDestory(){
		this.Active = false;
		this.Visible = false;
		
		HPos256 = X * 256 ; 
		VPos256 = Y * 256 ; 
		
//		Effect.spawn(1, PARTICLE_LIGHT, X, Y);
		
		getAmmor().SpawnExtParticle(UnitBattleBullet.PARTICLE_LIGHT, 1, X, Y);
		
		switch(ai){
		case 13:
		case 14:
		case 15:
		case 16:
		case 17:
		case 18:
			startFire(actor);
			break;
		case 50:
		case 51:
		case 52:
		case 53:
		case 54:
		case 55:	
//			Effect.spawn(1, PARTICLE_BIG, X, Y);
			getAmmor().SpawnExtParticle(UnitBattleBullet.PARTICLE_BIG, 1, X, Y);
			default:
		}
		
		terminate();
		
//		Effect.spawn(16, PARTICLE_EXP, X, Y);
	}
	boolean isEndDestory(){
		return true;
	}
	void onDestory(){
//		if(isEndDestory()){
//			return;
//		}
//		
//		terminate();
//		
//		X = HPos256/256;
//		Y = VPos256/256;
//
//		nextCycFrame();
	}
//	----------------------------------------------------------------------------------------------------
////	粒子系统
////	final static public int PARTICLE_SMOKE 		= 0;
////	final static public int PARTICLE_BIGEXP		= 1;
//	final static public int PARTICLE_LIGHT		= 2;
//	final static public int PARTICLE_BIG		= 3;
//	final static public int PARTICLE_BIG_L		= 4;
//
//	final static public int Div = 256 ;
//
//	CParticleSystem Effect;
//
//	public void particleEmitted(CParticle particle, int id) {
//		
//		particle.X *= 256 ;
//		particle.Y *= 256 ;
//		particle.SpeedX = 0;
//		particle.SpeedY = 0;
//		particle.AccX = 0;
//		particle.AccY = 0;
//		particle.Timer = 0;
//		
//		int angle = Random.nextInt();
//		int d = 4+Math.abs(Random.nextInt()%8);
//		
//		switch(particle.Category){
////		case PARTICLE_BIGEXP:
////			particle.TerminateTime = 12;
////			particle.Color = 0xffffffff;
////			particle.SpeedX = CMath.sinTimes256(id*10 + angle)*d;
////			particle.SpeedY = CMath.cosTimes256(id*10 + angle)*d;
////			particle.AccX = -CMath.sinTimes256(id*10 + angle)/12;
////			particle.AccY = -CMath.cosTimes256(id*10 + angle)/12;
////			break;
//
//		case PARTICLE_BIG:
//			particle.TerminateTime = 100;
//			particle.Color = 0xffffffff;
//			break;
//		case PARTICLE_BIG_L:
//			particle.TerminateTime = 4;
//			particle.Color = 0xffffffff;
//			break;
//		case PARTICLE_LIGHT:
//			particle.TerminateTime = 12;
//			particle.Color = 0xffffffff;
//			break;
////		case PARTICLE_CONTRACT:
////			particle.TerminateTime = 64;
////			particle.Color = Random.nextInt();
////			particle.X += CMath.sinTimes256(id*10 + angle)*64;
////			particle.Y += CMath.cosTimes256(id*10 + angle)*64;
////			particle.SpeedX = -CMath.sinTimes256(id*10 + angle);
////			particle.SpeedY = -CMath.cosTimes256(id*10 + angle);
////			break;
//		}
//	}
//	public void particleAffected(CParticle particle, int id) {
//		particle.SpeedX += particle.AccX;
//		particle.SpeedY += particle.AccY;
//		particle.Y += particle.SpeedY;
//		particle.X += particle.SpeedX;
//		
//		switch(particle.Category){
//		case PARTICLE_BIG:
//			if(particle.Timer%3==0){
//				Effect.spawn(1, PARTICLE_BIG_L, 
//						particle.X/256 + Random.nextInt()%16, 
//						particle.Y/256 + Random.nextInt()%16);
//			}
//			break;
//
//		}
//	}
//	public void particleRender(Graphics g, CParticle particle, int id) {
//		int size = 8;
//		switch(particle.Category){
////		case PARTICLE_EXP:
////			size = particle.Timer / 2;
////			g.setColor(particle.Color);
////			g.fillArc(
////					world.toScreenPosX(particle.X/Div) - size/2, 
////					world.toScreenPosY(particle.Y/Div) - size/2,
////					size, 
////					size, 
////					0, 360);
////			break;
////		case PARTICLE_SMOKE:
////			size = particle.Timer / 2;
////			g.setColor(particle.Color);
////			g.drawArc(
////					world.toScreenPosX(particle.X/Div) - size/2, 
////					world.toScreenPosY(particle.Y/Div) - size/2,
////					size, 
////					size, 
////					0, 360);
////			break;
//		case PARTICLE_LIGHT:
//			size = (particle.TerminateTime - particle.Timer) * 10 ;
//			g.setColor(particle.Color);
//			g.fillArc(
//					world.toScreenPosX(particle.X/Div) - size/2, 
//					world.toScreenPosY(particle.Y/Div) - size/2,
//					size, 
//					size, 
//					0, 360);
//			size = particle.Timer * 8 ;
//			g.drawArc(
//					world.toScreenPosX(particle.X/Div) - size/2, 
//					world.toScreenPosY(particle.Y/Div) - size/2,
//					size, 
//					size, 
//					0, 360);
//			break;
//		case PARTICLE_BIG_L:
//			size = (particle.TerminateTime - particle.Timer) * 16 ;
//			g.setColor(particle.Color);
//			g.fillArc(
//					world.toScreenPosX(particle.X/Div) - size/2, 
//					world.toScreenPosY(particle.Y/Div) - size/2,
//					size, 
//					size, 
//					0, 360);
//			size = particle.Timer * 8 ;
//			g.drawArc(
//					world.toScreenPosX(particle.X/Div) - size/2, 
//					world.toScreenPosY(particle.Y/Div) - size/2,
//					size, 
//					size, 
//					0, 360);
//			break;
////		case PARTICLE_CONTRACT:
////			if(particle.Timer<64){
////				size = (particle.Timer) / 4;
////			}else{
////				size = (64-particle.Timer) / 4;
////			}
////			g.setColor(particle.Color);
////			g.fillArc(
////					world.toScreenPosX(particle.X/Div) - size/2, 
////					world.toScreenPosY(particle.Y/Div) - size/2,
////					size, 
////					size, 
////					0, 360);
////			break;
//		}
//		
//
//	}
//	public void particleTerminated(CParticle particle, int id) {
//		
//	}

}

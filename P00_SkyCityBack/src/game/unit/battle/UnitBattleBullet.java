/**
 * 
 */
package game.unit.battle;

import javax.microedition.lcdui.Graphics;

import com.morefuntek.cell.CMath;
import com.morefuntek.cell.Game.CAnimates;
import com.morefuntek.cell.Game.CCollides;
import com.morefuntek.cell.Game.CSprite;
import com.morefuntek.cell.Game.IState;
import com.morefuntek.cell.ParticleSystem.CParticle;
import com.morefuntek.cell.ParticleSystem.CParticleSystem;
import com.morefuntek.cell.ParticleSystem.IParticleLauncher;

/**
 * @author yifeizhang
 *
 */
public class UnitBattleBullet extends CSprite implements IParticleLauncher{

//	----------------------------------------------------------------------------------------	
	
	final static public int TYPE_NONE		= -1;
	final static public int TYPE_MISSILE1	= 0 ;
	final static public int TYPE_MISSILE2	= 8 ;
	final static public int TYPE_LASER		= 16;
	final static public int TYPE_BOMB		= 17;
	final static public int TYPE_SLUG1		= 18;
	final static public int TYPE_SLUG2		= 22;
	final static public int TYPE_LIGHT1		= 19;
	final static public int TYPE_LIGHT2		= 23;
	final static public int TYPE_BOMBEXP	= 20;
	final static public int TYPE_ROCKET		= 24;
	
	final static public int TYPE_BASE		= 18;
	
	private int Type = 0;
	private int HP = 10;
	
	public boolean Penetrable 	= false;
	
	
	public UnitBattleBullet(CSprite spr) {
		super(spr);
		startNone();
		
		CParticle[] particles = new CParticle[16];
	    for(int i=0;i<particles.length;i++){
	       	particles[i] = new CParticle();
	    }
	    Effect = new CParticleSystem(particles,this);
	    
	    HP = getHP();
	}


	public void update() {
		// main state machine
		if(Active){
			switch (Type) {
			case TYPE_MISSILE1:
			case TYPE_MISSILE2:
				if (!isEndMissile()) {
					onMissile();
				} else {
					startNone();
				}
				break;
			case TYPE_LASER:
				if (!isEndLight()) {
					onLight();
				} else {
					startNone();
				}
				break;
			case TYPE_BOMB:
				if (!isEndBomb()) {
					onBomb();
				} else {
					startNone();
				}
				break;
//			case TYPE_BASE:
			case TYPE_SLUG1:
			case TYPE_SLUG2:
			case TYPE_LIGHT1:
			case TYPE_LIGHT2:
				if (!isEndSlug()) {
					onSlug();
				} else {
					startNone();
				}
				break;
			case TYPE_ROCKET:
			case TYPE_BOMBEXP:
				if (!isEndRocket()) {
					onRocket();
				} else {
					startNone();
				}
				break;
			
			default:
				startNone();
			}	
		}
		Effect.update();
	}
	
	public void render(Graphics g, int x, int y) {
		super.render(g, x, y);
		Effect.render(g);
	}
	
	public int getType(){
		return Type;
	}
	
	public int getForzenTime(){
		switch (Type) {
		case TYPE_MISSILE1:
		case TYPE_MISSILE2:
			return 40;
		case TYPE_LASER:
			return getFrameCount(TYPE_LASER) * 2;
		case TYPE_BOMB:
		case TYPE_BOMBEXP:
			return 20;
		case TYPE_SLUG1:
		case TYPE_SLUG2:
			return 8;
		case TYPE_LIGHT1:
		case TYPE_LIGHT2:
			return 4;
		case TYPE_ROCKET:
			return 20;
		default:
			return 30;
		}
	}
	
	public int getPrice(){
		switch (Type) {
		case TYPE_MISSILE1:
		case TYPE_MISSILE2:
		case TYPE_LASER:
		case TYPE_BOMB:
		case TYPE_BOMBEXP:
		case TYPE_SLUG1:
		case TYPE_SLUG2:
		case TYPE_LIGHT1:
		case TYPE_LIGHT2:
		case TYPE_ROCKET:
			
		}
		return 100;
	}
	
	public int getHP(){
		switch (Type) {
		case TYPE_MISSILE1:
		case TYPE_MISSILE2:
			return 20;
		case TYPE_LASER:
			return 4;
		case TYPE_BOMB:
			return 100;
		case TYPE_BOMBEXP:
			return 100;
		case TYPE_SLUG1:
		case TYPE_SLUG2:
			return 2;
		case TYPE_LIGHT1:
		case TYPE_LIGHT2:
			return 8;
		case TYPE_ROCKET:
			return 40;
		default:
			return 10;
		}
	}
	
	
	public void fire(
			int type,
			CSprite handle,
			CSprite target,
			int sx,int sy,
			int dx,int dy,
			int speed,
			int time
			){
		
		Type = type;
		
		switch (getType()) {
		case UnitBattleBullet.TYPE_MISSILE1:
		case UnitBattleBullet.TYPE_MISSILE2:
			startMissile(sx,sy,target,time);
			break;
		case UnitBattleBullet.TYPE_LASER:
			startLight(handle);
			break;
		case UnitBattleBullet.TYPE_BOMB:
			startBomb(sx,sy, 0, 0);
			break;
		case UnitBattleBullet.TYPE_SLUG1:
		case UnitBattleBullet.TYPE_SLUG2:
			startSlug(sx,sy, dx, dy,speed);
			break;
		case UnitBattleBullet.TYPE_LIGHT1:
		case UnitBattleBullet.TYPE_LIGHT2:
			startSlug(sx,sy, dx, dy,speed);
			break;
		case UnitBattleBullet.TYPE_ROCKET:
		case UnitBattleBullet.TYPE_BOMBEXP:
			startRocket(sx,sy, dx);
			break;
		}	
	}
	
//	public void fire(
//			int type,
//			CSprite   handle,
//			CSprite[] targets,
//			int sx,int sy,
//			int dx,int dy,
//			int speed,
//			int time
//			){
//		
//		Type = type;
//		
//		switch (getType()) {
//		
//		case UnitBattleBullet.TYPE_MISSILE1:
//		case UnitBattleBullet.TYPE_MISSILE2:
//			CSprite target = null;
//			int start = Math.abs(Random.nextInt()%targets.length);
//			for(int j=0;j<targets.length;j++){
//				int id = (j + start) % targets.length;  
//				if( targets[id].Active==true && 
//					targets[id].OnScreen==true){
//					target = targets[id];
//					break;
//				}
//			}
//			startMissile(sx,sy,target,time);
//			break;
//		case UnitBattleBullet.TYPE_LASER:
//			startLight(handle);
//			break;
//		case UnitBattleBullet.TYPE_BOMB:
//			startBomb(sx,sy, 0, 0);
//			break;
//		case UnitBattleBullet.TYPE_SLUG1:
//		case UnitBattleBullet.TYPE_SLUG2:
//			startSlug(sx,sy, dx, dy,speed);
//			break;
//		case UnitBattleBullet.TYPE_LIGHT1:
//		case UnitBattleBullet.TYPE_LIGHT2:
//			startSlug(sx,sy, dx, dy,speed);
//			break;
//		case UnitBattleBullet.TYPE_ROCKET:
//		case UnitBattleBullet.TYPE_BOMBEXP:
//			startRocket(sx,sy, dx);
//			break;
//		}	
//	}
	
	
	
//	----------------------------------------------------------------------------------------------------
//	空状态
	public void startNone(){
		Active = false;
		Visible = false;
		Penetrable = false;
	}
//	完结状态
	public void startTerminate(CSprite target){
		switch (Type) {
		case TYPE_MISSILE1:
		case TYPE_MISSILE2:
			Effect.spawn(1,EFFECT_MISSILE,X, Y);
			break;
		case TYPE_LASER:
			Effect.spawn(1,EFFECT_LASER,
					target.X + Random.nextInt()%4, 
					target.Y + (Y-target.Y)/2 );
			break;
		case TYPE_BOMB:
		case TYPE_BOMBEXP:
			Effect.spawn(1,EFFECT_EXP,X, Y);
			break;
		case TYPE_SLUG1:
		case TYPE_SLUG2:
			Effect.spawn(1,EFFECT_SLUG,X, Y);
			break;
		case TYPE_LIGHT1:
		case TYPE_LIGHT2:
			Effect.spawn(1,EFFECT_LIGHT,X, Y);
			break;
		case TYPE_ROCKET:
			Effect.spawn(1,EFFECT_ALL,X, Y);
			break;
		}
		
		if(!Penetrable){
			Active = false;
			Visible = false;
		}
	}
	
//	----------------------------------------------------------------------------------------------------
//	Missile 1
	CSprite MissileHandle		= null;
	int MissileMaxSpeed			= 4;
	int MissileAngle	=	0;
	int MissileTime		= 30;
	private void startMissile(int sx,int sy,CSprite handle, int time){
		Active = true;
		Visible = true;
		OnScreen = true;
		
		if(handle!=null){
			MissileHandle = handle;
			MissileTime   = time;
			SpeedX256 = 0; 
			SpeedY256 = 0;
		}else{
			MissileHandle = null;
			MissileTime   = -1;
			SpeedX256 = 4 * 256; 
			SpeedY256 = 0;
		}
		
		X = sx;
		Y = sy;
		HPos256 = X * 256 ; 
		VPos256 = Y * 256 ; 
		
		setCurrentFrame(Type, 0);
		
//		println("start Missile : " + Type);
	}
	boolean isEndMissile(){
		return !OnScreen ;
		
	}
	void onMissile(){
		MissileTime--;
		
		if(	SpeedX256 == 0 && SpeedY256 == 0 ){
			SpeedX256 = 4 * 256; 
			SpeedY256 = 0;
		}
		
		if(MissileHandle!=null && MissileHandle.Active && MissileTime>0){
			int dx = MissileHandle.X - X;
			int dy = MissileHandle.Y - Y;
				
			int bx = Math.abs(dx)*256/MissileMaxSpeed;
			int by = Math.abs(dy)*256/MissileMaxSpeed;
			int d = Math.max(bx,by);
			
			if(d!=0){
				SpeedX256 = (dx) * 256 * 256 / d ;
				SpeedY256 = (dy) * 256 * 256 / d ;
			}
		}

		HPos256 += SpeedX256 ; 
		VPos256 += SpeedY256 ; 
		X = HPos256/256;
		Y = VPos256/256;
		
		MissileAngle = CMath.cycNum(360,-CMath.atan2(-SpeedY256, SpeedX256)+22,360);
		int direct = CMath.cycNum(MissileAngle/45, 0, 8);
		setCurrentFrame(direct, CurFrame);

		smokeSpeed = 8;
		switch(direct){
		case 0:Effect.spawn(1,EFFECT_SMOKE_L,X, Y);break;
		case 1:Effect.spawn(1,EFFECT_SMOKE_TL,X, Y);break;
		case 2:Effect.spawn(1,EFFECT_SMOKE_T,X, Y);break;
		case 3:Effect.spawn(1,EFFECT_SMOKE_TR,X, Y);break;
		case 4:Effect.spawn(1,EFFECT_SMOKE_R,X, Y);break;
		case 5:Effect.spawn(1,EFFECT_SMOKE_BR,X, Y);break;
		case 6:Effect.spawn(1,EFFECT_SMOKE_B,X, Y);break;
		case 7:Effect.spawn(1,EFFECT_SMOKE_BL,X, Y);break;
		}	

		nextCycFrame();
		
//		println("run Missile 1 : " + Type + " : "+ X + " : " + Y);
	}

//	----------------------------------------------------------------------------------------------------
//	向目标点发射的飞行物
	int SlugMaxSpeed		= 	8;
	private void startSlug(int sx,int sy,int dx,int dy,int speed){
		Active = true;
		Visible = true;
		OnScreen = true;
		SlugMaxSpeed = speed;
		X = sx;
		Y = sy;
		HPos256 = X * 256 ; 
		VPos256 = Y * 256 ; 
		int bx = Math.abs(dx - X)*256/SlugMaxSpeed;
		int by = Math.abs(dy - Y)*256/SlugMaxSpeed;
		int d = Math.max(bx,by);
		if(d!=0){
			SpeedX256 = (dx - X) * 256 * 256 / d ;
			SpeedY256 = (dy - Y) * 256 * 256 / d ;
		}
		setCurrentFrame(Type, 0);
		
//		println("start Slug : " + Type);
	}
	boolean isEndSlug(){
		return !OnScreen;
	}
	void onSlug(){
		HPos256 += SpeedX256 ; 
		VPos256 += SpeedY256 ; 
		X = HPos256/256;
		Y = VPos256/256;
//		Visible = !Visible;
		nextCycFrame();
	}
//	---------------------------------------------------------------------------------------------------------
//	光线攻击	
	public CSprite LightHandle			= 	null;
	private void startLight(CSprite handle){
		Penetrable = true;
		Active = true;
		Visible = true;
		OnScreen = true;
		LightHandle = handle;
	
		setCurrentFrame(Type, 0);
		
//		println("start Light : " + Type);
	}
	boolean isEndLight(){
		return nextFrame() || !LightHandle.Active;
	}
	void onLight(){
		X = LightHandle.X;
		Y = LightHandle.Y;
	}
//	---------------------------------------------------------------------------------------------------------
//	受重力影响的炸弹	
	public int BombGravity				= 100;
	private void startBomb(int sx,int sy,int speedX,int speedY){
		Active = true;
		Visible = true;
		OnScreen = true;
		X = sx;
		Y = sy;
		HPos256 = X * 256 ; 
		VPos256 = Y * 256 ; 
		
		SpeedX256 = speedX; 
		SpeedY256 = speedY;
			
		setCurrentFrame(Type, 0);
		
//		println("start Bomb : " + Type);
	}
	boolean isEndBomb(){
		return !OnScreen;
	}
	void onBomb(){
		SpeedY256 += BombGravity;
		
		HPos256 += SpeedX256 ; 
		VPos256 += SpeedY256 ; 
		X = HPos256/256;
		Y = VPos256/256;
		
		nextCycFrame();
	}
//	---------------------------------------------------------------------------------------------------------
//	有加速度的导弹
	public int RocketAcc				= 256;
	public int RocketDirect				= 1;
	
	public int RocketGravity			= 128;
	public int RocketFlySpeed			= 256 * 2 ;
	
	private void startRocket(int sx,int sy,int direct){
		Active = true;
		Visible = true;
		OnScreen = true;
		RocketDirect = direct;
		
		SpeedX256 = 0; 
		SpeedY256 = 0;
		
		X = sx;
		Y = sy;
		HPos256 = X * 256 ; 
		VPos256 = Y * 256 ; 
		
		setCurrentFrame(Type, 0);
		
//		println("start Rocket : " + Type);
	}
	boolean isEndRocket(){
		return !OnScreen;
	}
	void onRocket(){
		if(Math.abs(SpeedY256)>RocketFlySpeed){
			smokeSpeed = 128;
			Effect.spawn(1,EFFECT_SMOKE_L,X, Y);
			SpeedX256 += RocketDirect * RocketAcc;
			HPos256 += SpeedX256 ; 
		}else{
			SpeedY256 += RocketGravity;
			VPos256 += SpeedY256 ; 
		}

		X = HPos256/256;
		Y = VPos256/256;
		
		nextCycFrame();
	}

//	---------------------------------------------------------------------------------------------------------
//	黑洞
	public int CollapsarMaxTime			= 200;
	public int CollapsarTime			= 100;
	private void startCollapsar(int sx,int sy){
		Penetrable = true;
		Active = true;
		Visible = true;
		OnScreen = true;
		CollapsarTime = CollapsarMaxTime;
		
		X = sx;
		Y = sy;
		HPos256 = X * 256 ; 
		VPos256 = Y * 256 ; 

		setCurrentFrame(0, 0);
		
//		println("start Collapsar : " + Type);
	}
	boolean isEndCollapsar(){
		return CollapsarTime<0;
	}
	void onCollapsar(){
		CollapsarTime--;
		
//		Effect.spawn(1,PARTICLE_CONTRACT,X, Y);
		
		nextCycFrame();
	}
	
//	---------------------------------------------------------------------------------------------------------


//	----------------------------------------------------------------------------------------------------
//	粒子系统
//	final static public int PARTICLE_SMOKE 		= 0;
//	final static public int PARTICLE_EXP		= 1;
//	final static public int PARTICLE_CONTRACT	= 3;
//	
//	
	final static public int PARTICLE_LIGHT		= 102;
	final static public int PARTICLE_BIG		= 103;
	final static public int PARTICLE_BIG_L		= 104;
	
	final static public int Div = 256 ;

	final static public int EFFECT_LASER		= 0;
	final static public int EFFECT_LIGHT		= 1;
	final static public int EFFECT_SLUG			= 2;
	final static public int EFFECT_MISSILE		= 3;
	final static public int EFFECT_EXP			= 4;
	final static public int EFFECT_ALL			= 5;
	
	final static public int EFFECT_SMOKE		= 6;
	
	final static public int EFFECT_SMOKE_R		= 7;
	final static public int EFFECT_SMOKE_TR		= 8;
	final static public int EFFECT_SMOKE_T		= 9;
	final static public int EFFECT_SMOKE_TL		= 10;
	final static public int EFFECT_SMOKE_L		= 11;
	final static public int EFFECT_SMOKE_BL		= 12;
	final static public int EFFECT_SMOKE_B		= 13;
	final static public int EFFECT_SMOKE_BR		= 14;
	
	
	
	public void SpawnExtParticle(int type,int count,int x,int y){
		Effect.spawn(count, type, x, y);
	}
	
	
	static public CSprite effect ;
	static public int smokeSpeed = 512;
	
	CParticleSystem Effect;

	public void particleEmitted(CParticle particle, int id) {
		
		particle.X *= 256 ;
		particle.Y *= 256 ;
		particle.SpeedX = 0;
		particle.SpeedY = 0;
		particle.AccX = 0;
		particle.AccY = 0;
		particle.Timer = 0 ;
		particle.Color = 0xffffffff;

		int angle = Random.nextInt()%30;
		switch(particle.Category){
		case EFFECT_SMOKE_R: angle  += 0 * 45 ; break;
		case EFFECT_SMOKE_TR: angle += 1 * 45; break;
		case EFFECT_SMOKE_T: angle  += 2 * 45; break;
		case EFFECT_SMOKE_TL: angle += 3 * 45; break;
		case EFFECT_SMOKE_L: angle  += 4 * 45; break;
		case EFFECT_SMOKE_BL: angle += 5 * 45; break;
		case EFFECT_SMOKE_B: angle  += 6 * 45; break;
		case EFFECT_SMOKE_BR: angle += 7 * 45; break;
		default:
			angle = Random.nextInt();
		
		}
//		int d = 4+Math.abs(Random.nextInt()%8);
		
		switch(particle.Category){
		case EFFECT_LASER:
		case EFFECT_LIGHT:
		case EFFECT_SLUG:
		case EFFECT_MISSILE:
		case EFFECT_EXP:
		case EFFECT_ALL:
			if(effect!=null){
				particle.TerminateTime = effect.getFrameCount(particle.Category);
			}else{
				particle.TerminateTime = 4;
			}
			break;
		case EFFECT_SMOKE:
			particle.TerminateTime = 8;
			break;
		case EFFECT_SMOKE_R: 
		case EFFECT_SMOKE_TR:
		case EFFECT_SMOKE_T:
		case EFFECT_SMOKE_TL:
		case EFFECT_SMOKE_L:
		case EFFECT_SMOKE_BL:
		case EFFECT_SMOKE_B:
		case EFFECT_SMOKE_BR:
			particle.TerminateTime = 8;
			particle.Color = 0xff0000ff;
			particle.SpeedX += CMath.cosTimes256(angle)*smokeSpeed/256;
			particle.SpeedY -= CMath.sinTimes256(angle)*smokeSpeed/256;
			particle.AccX = particle.SpeedX*256/8/smokeSpeed;
			particle.AccY = particle.SpeedY*256/8/smokeSpeed;
			break;
		// ext particle
		case PARTICLE_BIG:
			particle.TerminateTime = 100;
			particle.Color = 0xffffffff;
			break;
		case PARTICLE_BIG_L:
			particle.TerminateTime = 4;
			particle.Color = 0xffffffff;
			break;
		case PARTICLE_LIGHT:
			particle.TerminateTime = 12;
			particle.Color = 0xffffffff;
			break;
		}

	}
	public void particleAffected(CParticle particle, int id) {
		particle.SpeedX += particle.AccX;
		particle.SpeedY += particle.AccY;
		particle.Y += particle.SpeedY;
		particle.X += particle.SpeedX;
		
		switch(particle.Category){
		case PARTICLE_BIG:
			if(particle.Timer%3==0){
				Effect.spawn(1, PARTICLE_BIG_L, 
						particle.X/256 + Random.nextInt()%16, 
						particle.Y/256 + Random.nextInt()%16);
			}
			break;

		}
		
	}
	public void particleRender(Graphics g, CParticle particle, int id) {
		int size = 8;
		
		switch(particle.Category){
		case EFFECT_LASER:
		case EFFECT_LIGHT:
		case EFFECT_SLUG:
		case EFFECT_MISSILE:
		case EFFECT_EXP:
		case EFFECT_ALL:
			size = (particle.TerminateTime - particle.Timer) * 4  ;
			g.setColor(particle.Color);
			g.fillArc(
					world.toScreenPosX(particle.X/Div) - size/2, 
					world.toScreenPosY(particle.Y/Div) - size/2,
					size, 
					size, 
					0, 360);
			size = particle.Timer * 8;
			g.drawArc(
					world.toScreenPosX(particle.X/Div) - size/2, 
					world.toScreenPosY(particle.Y/Div) - size/2,
					size, 
					size, 
					0, 360);
			if(effect!=null){
				effect.X = world.toScreenPosX(particle.X/Div);
				effect.Y = world.toScreenPosY(particle.Y/Div);
				effect.setCurrentFrame(particle.Category, particle.Timer - 1);
				effect.render(g, effect.X, effect.Y);
			}
			break;
		case EFFECT_SMOKE:
		case EFFECT_SMOKE_R: 
		case EFFECT_SMOKE_TR:
		case EFFECT_SMOKE_T:
		case EFFECT_SMOKE_TL:
		case EFFECT_SMOKE_L:
		case EFFECT_SMOKE_BL:
		case EFFECT_SMOKE_B:
		case EFFECT_SMOKE_BR:
			size = particle.Timer / 2;
			int c = 0xff - 0x80 * particle.Timer / particle.TerminateTime ;
			particle.Color = 0xff0000ff | 
				(c<<8 ) |
				(c<<16)
				;
			
			g.setColor(particle.Color);
			g.drawArc(
					world.toScreenPosX(particle.X/Div) - size/2, 
					world.toScreenPosY(particle.Y/Div) - size/2,
					size, 
					size, 
					0, 360);
			break;
		// ext particle	
//			case PARTICLE_EXP:
//			size = particle.Timer / 2;
//			g.setColor(particle.Color);
//			g.fillArc(
//					world.toScreenPosX(particle.X/Div) - size/2, 
//					world.toScreenPosY(particle.Y/Div) - size/2,
//					size, 
//					size, 
//					0, 360);
//			break;
//		case PARTICLE_SMOKE:
//			size = particle.Timer / 2;
//			g.setColor(particle.Color);
//			g.drawArc(
//					world.toScreenPosX(particle.X/Div) - size/2, 
//					world.toScreenPosY(particle.Y/Div) - size/2,
//					size, 
//					size, 
//					0, 360);
//			break;
		case PARTICLE_LIGHT:
			size = (particle.TerminateTime - particle.Timer) * 10 ;
			g.setColor(particle.Color);
			g.fillArc(
					world.toScreenPosX(particle.X/Div) - size/2, 
					world.toScreenPosY(particle.Y/Div) - size/2,
					size, 
					size, 
					0, 360);
			size = particle.Timer * 8 ;
			g.drawArc(
					world.toScreenPosX(particle.X/Div) - size/2, 
					world.toScreenPosY(particle.Y/Div) - size/2,
					size, 
					size, 
					0, 360);
			break;
		case PARTICLE_BIG_L:
			size = (particle.TerminateTime - particle.Timer) * 16 ;
			g.setColor(particle.Color);
			g.fillArc(
					world.toScreenPosX(particle.X/Div) - size/2, 
					world.toScreenPosY(particle.Y/Div) - size/2,
					size, 
					size, 
					0, 360);
			size = particle.Timer * 8 ;
			g.drawArc(
					world.toScreenPosX(particle.X/Div) - size/2, 
					world.toScreenPosY(particle.Y/Div) - size/2,
					size, 
					size, 
					0, 360);
			break;
		}
		
		
		
		
		
		
		
		
//		switch(particle.Category){
//		case PARTICLE_EXP:
//			size = particle.Timer / 2;
//			g.setColor(particle.Color);
//			g.drawArc(
//					world.toScreenPosX(particle.X/Div) - size/2, 
//					world.toScreenPosY(particle.Y/Div) - size/2,
//					size, 
//					size, 
//					0, 360);
//			break;
//		case PARTICLE_SMOKE:
//			size = particle.Timer / 2;
//			g.setColor(particle.Color);
//			g.drawArc(
//					world.toScreenPosX(particle.X/Div) - size/2, 
//					world.toScreenPosY(particle.Y/Div) - size/2,
//					size, 
//					size, 
//					0, 360);
//			break;
//		case PARTICLE_CONTRACT:
//			if(particle.Timer<64){
//				size = (particle.Timer) / 4;
//			}else{
//				size = (64-particle.Timer) / 4;
//			}
//			g.setColor(particle.Color);
//			g.fillArc(
//					world.toScreenPosX(particle.X/Div) - size/2, 
//					world.toScreenPosY(particle.Y/Div) - size/2,
//					size, 
//					size, 
//					0, 360);
//			break;
//		}
		

	}
	public void particleTerminated(CParticle particle, int id) {
	}
	
	

}

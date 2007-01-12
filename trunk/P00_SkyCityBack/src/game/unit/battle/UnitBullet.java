package game.unit.battle;

import javax.microedition.lcdui.Graphics;

import com.morefuntek.cell.CMath;
import com.morefuntek.cell.Game.AScreen;
import com.morefuntek.cell.Game.CSprite;
import com.morefuntek.cell.Game.IState;
import com.morefuntek.cell.ParticleSystem.CParticle;
import com.morefuntek.cell.ParticleSystem.CParticleSystem;
import com.morefuntek.cell.ParticleSystem.IParticleLauncher;

//	所有子弹的效果
public class UnitBullet extends CSprite implements IState,IParticleLauncher {
//	----------------------------------------------------------------------------------------------------
//	基本
	public boolean Penetrable = false;

	public UnitBullet(CSprite stuff){
		super(stuff);
		setState(this);
	
		CParticle[] particles = new CParticle[128];
       	for(int i=0;i<particles.length;i++){
       		particles[i] = new CParticle();
       	}
       	Effect = new CParticleSystem(particles,this);
	}
	
	public void render(Graphics g, int x, int y) {
		super.render(g, x, y);
		Effect.render(g);
	}
	
	public void update(){
		// main state machine
		switch (state) {
		case STATE_SLUG:
			if (!isEndSlug()) {
				onSlug();
			} else {
				startNone();
			}
			break;
		case STATE_LIGHT:
			if (!isEndLight()) {
				onLight();
			} else {
				startNone();
			}
			break;
		case STATE_BOMB:
			if (!isEndBomb()) {
				onBomb();
			} else {
				startNone();
			}
			break;
		case STATE_ROCKET:
			if (!isEndRocket()) {
				onRocket();
			} else {
				startNone();
			}
			break;
		case STATE_MISSILE:
			if (!isEndMissile()) {
				onMissile();
			} else {
				startNone();
			}
			break;
		case STATE_COLLAPSAR:
			if (!isEndCollapsar()) {
				onCollapsar();
			} else {
				startNone();
			}
			break;
		case STATE_TERMINATE:
			if (!isEndTerminate()) {
				onTerminate();
			} else {
				startNone();
			}
			break;

		default:
			startNone();
		}	
			
		Effect.update();
	}

//	----------------------------------------------------------------------------------------------------
//	粒子系统
	CParticleSystem Effect;
	
	final static public int Div = 256 ;
	final static public int PARTICLE_SMOKE 		= 0;
	final static public int PARTICLE_EXP		= 1;
	final static public int PARTICLE_CONTRACT	= 3;

	
	public void particleEmitted(CParticle particle, int id) {
		
		particle.X *= 256 ;
		particle.Y *= 256 ;
		particle.SpeedX = 0;
		particle.SpeedY = 0;
		particle.AccX = 0;
		particle.AccY = 0;
		
		int angle = Random.nextInt();

		switch(particle.Category){
		case PARTICLE_EXP:
			particle.Timer = 10;
			particle.Color = 0xffff0000;
			particle.SpeedX = CMath.sinTimes256(id*10 + angle)*4;
			particle.SpeedY = CMath.cosTimes256(id*10 + angle)*4;
			particle.AccX = -CMath.sinTimes256(id*10 + angle)/8;
			particle.AccY = -CMath.cosTimes256(id*10 + angle)/8;
			break;
		case PARTICLE_SMOKE:
			particle.Timer = 10;
			particle.Color = 0xffffffff;
			break;
		case PARTICLE_CONTRACT:
			particle.Timer = 64;
			particle.Color = Random.nextInt();
			particle.X += CMath.sinTimes256(id*10 + angle)*64;
			particle.Y += CMath.cosTimes256(id*10 + angle)*64;
			particle.SpeedX = -CMath.sinTimes256(id*10 + angle);
			particle.SpeedY = -CMath.cosTimes256(id*10 + angle);
			break;
		}
	}
	public void particleAffected(CParticle particle, int id) {
		particle.SpeedX += particle.AccX;
		particle.SpeedY += particle.AccY;
		particle.Y += particle.SpeedY;
		particle.X += particle.SpeedX;
		
		switch(particle.Category){
		case PARTICLE_EXP:
			
			break;
		case PARTICLE_SMOKE:
		
			break;
		case PARTICLE_CONTRACT:
			
			break;
		}
	}
	public void particleRender(Graphics g, CParticle particle, int id) {
		int size = 8;
		switch(particle.Category){
		case PARTICLE_EXP:
			size = particle.Timer / 2;
			g.setColor(particle.Color);
			g.drawArc(
					world.toScreenPosX(particle.X/Div) - size/2, 
					world.toScreenPosY(particle.Y/Div) - size/2,
					size, 
					size, 
					0, 360);
			break;
		case PARTICLE_SMOKE:
			size = particle.Timer / 2;
			g.setColor(particle.Color);
			g.drawArc(
					world.toScreenPosX(particle.X/Div) - size/2, 
					world.toScreenPosY(particle.Y/Div) - size/2,
					size, 
					size, 
					0, 360);
			break;
		case PARTICLE_CONTRACT:
			if(particle.Timer<64){
				size = (particle.Timer) / 4;
			}else{
				size = (64-particle.Timer) / 4;
			}
			g.setColor(particle.Color);
			g.fillArc(
					world.toScreenPosX(particle.X/Div) - size/2, 
					world.toScreenPosY(particle.Y/Div) - size/2,
					size, 
					size, 
					0, 360);
			break;
		}
		

	}
	public void particleTerminated(CParticle particle, int id) {
	}

//	----------------------------------------------------------------------------------------------------
//	状态
	int state = -1;
	final public int STATE_NONE			= 	-1;
	public void startNone(){
		this.Active = false;
		this.Visible = false;
		state = STATE_NONE;
		Penetrable = false;
	}
	public boolean isEndNone(){
		return !Active;
	}
	public void onNone(){
	}
//	----------------------------------------------------------------------------------------------------
//	向目标点发射的飞行物
	final public int STATE_SLUG			=	6;
	final public int SlugMaxSpeed		= 	4;
	public void startSlug(int sx,int sy,int dx,int dy){
		state = STATE_SLUG;
		Active = true;
		Visible = true;
		
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
		setCurrentFrame(STATE_SLUG, 0);
	}
	public boolean isEndSlug(){
		return !OnScreen;
	}
	public void onSlug(){
		
		HPos256 += SpeedX256 ; 
		VPos256 += SpeedY256 ; 
		X = HPos256/256;
		Y = VPos256/256;
		
		nextCycFrame();
	}
//	---------------------------------------------------------------------------------------------------------
//	光线攻击	
	final public int STATE_LIGHT		=	3;
	public CSprite LightHandle			= 	null;
	public int LightTimeMax 			=	8;
	public int LightTime				=	0;
	public void startLight(CSprite handle){
		state = STATE_LIGHT;
		Penetrable = true;
		Active = true;
		Visible = true;
		
		LightHandle = handle;
		LightTime = LightTimeMax;
	
		setCurrentFrame(STATE_LIGHT, 0);
	}
	public boolean isEndLight(){
		return LightTime<0 || !LightHandle.Active;
	}
	public void onLight(){
		LightTime--;
		X = LightHandle.X;
		Y = LightHandle.Y;
		
		nextCycFrame();
	}
//	---------------------------------------------------------------------------------------------------------
//	受重力影响的炸弹	
	final public int STATE_BOMB			= 4;
	public int BombGravity				= 100;
	public void startBomb(int sx,int sy,int speedX,int speedY){
		state = STATE_BOMB;
		Active = true;
		Visible = true;
		
		X = sx;
		Y = sy;
		HPos256 = X * 256 ; 
		VPos256 = Y * 256 ; 
		
		SpeedX256 = speedX; 
		SpeedY256 = speedY;
			
		setCurrentFrame(STATE_BOMB, 0);
	}
	public boolean isEndBomb(){
		return !OnScreen;
	}
	public void onBomb(){
		
		SpeedY256 += BombGravity;
		
		HPos256 += SpeedX256 ; 
		VPos256 += SpeedY256 ; 
		X = HPos256/256;
		Y = VPos256/256;
		
		nextCycFrame();
	}
//	---------------------------------------------------------------------------------------------------------
//	有加速度的导弹
	final public int STATE_ROCKET		= 2;
	public int RocketAcc				= 256;
	public int RocketGravity			= 128;
	public int RocketFlySpeed			= 256 * 4 ;
	public int RocketDirect				= 1;
	public void startRocket(int sx,int sy,int direct){
		state = STATE_ROCKET;
		Active = true;
		Visible = true;
		
		RocketDirect = direct;
		
		SpeedX256 = 0; 
		SpeedY256 = 0;
		
		X = sx;
		Y = sy;
		HPos256 = X * 256 ; 
		VPos256 = Y * 256 ; 
		
		setCurrentFrame(STATE_ROCKET, 0);
	}
	public boolean isEndRocket(){
		return !OnScreen;
	}
	public void onRocket(){
		if(Math.abs(SpeedY256)>RocketFlySpeed){
			Effect.spawn(1,PARTICLE_SMOKE,X, Y);
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
//	跟踪导弹
	final public int STATE_MISSILE		= 0;
	public CSprite MissileHandle		= null;
	public int MissileMaxSpeed			= 4;
	public void startMissile(int sx,int sy,CSprite handle){
		state = STATE_MISSILE;
		Active = true;
		Visible = true;
		
		MissileHandle = handle;
		
		SpeedX256 = 0; 
		SpeedY256 = 0;
		
		X = sx;
		Y = sy;
		HPos256 = X * 256 ; 
		VPos256 = Y * 256 ; 
		
		setCurrentFrame(STATE_MISSILE, 0);
	}
	public boolean isEndMissile(){
		return !OnScreen || 
		!MissileHandle.Active ||
		X == MissileHandle.X && Y == MissileHandle.Y
		;
	}
	public void onMissile(){

		if(getTimer()%2==0){
			Effect.spawn(1,PARTICLE_SMOKE,X, Y);
		}
		
		int bx = Math.abs(MissileHandle.X - X)*256/MissileMaxSpeed;
		int by = Math.abs(MissileHandle.Y - Y)*256/MissileMaxSpeed;
		int d = Math.max(bx,by);
		
		if(d!=0){
			SpeedX256 = (MissileHandle.X - X) * 256 * 256 / d ;
			SpeedY256 = (MissileHandle.Y - Y) * 256 * 256 / d ;
		}
		
		HPos256 += SpeedX256 ; 
		VPos256 += SpeedY256 ; 
		X = HPos256/256;
		Y = VPos256/256;
		
		
		
		nextCycFrame();
	}
//	---------------------------------------------------------------------------------------------------------
//	黑洞
	final public int STATE_COLLAPSAR 	= 7;
	public int CollapsarMaxTime			= 200;
	public int CollapsarTime			= 100;
	public void startCollapsar(int sx,int sy){
		state = STATE_COLLAPSAR;
		Penetrable = true;
		Active = true;
		Visible = true;
		
		CollapsarTime = CollapsarMaxTime;
		
		X = sx;
		Y = sy;
		HPos256 = X * 256 ; 
		VPos256 = Y * 256 ; 

		setCurrentFrame(STATE_COLLAPSAR, 0);
	}
	public boolean isEndCollapsar(){
		return CollapsarTime<0;
	}
	public void onCollapsar(){
		CollapsarTime--;
		
		Effect.spawn(1,PARTICLE_CONTRACT,X, Y);

		nextCycFrame(6);
	}
	
//	---------------------------------------------------------------------------------------------------------
//	完结状态
	final public int STATE_TERMINATE	= 1;
	public void startTerminate(int sx,int sy){
		state = STATE_TERMINATE;
		Active = true;
		Visible = true;
		
		X = sx;
		Y = sy;
		
		Effect.spawn(8,PARTICLE_EXP,X,Y);
		
		setCurrentFrame(STATE_TERMINATE, 0);
	}
	public void onTerminate(){
		
	}
	public boolean isEndTerminate(){
		return nextFrame() || !OnScreen;
	}
	
	

	
	
}

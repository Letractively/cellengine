package game.unit.world;

import javax.microedition.lcdui.Graphics;

import com.cell.CMath;
import com.cell.game.CSprite;
import com.cell.game.IState;
import com.cell.particle.CParticle;
import com.cell.particle.CParticleSystem;
import com.cell.particle.IParticleLauncher;

public class UnitWorldActor extends CSprite implements IState , IParticleLauncher {


	static public int ActorX = 128;
	static public int ActorY = 128;
	static public int ActorDirect = 0;
	static public int CityIndex = -1;
	
	
	public int Direct 	= 0;
	
	int MaxSpeed 	= 4*256;
	public int Speed  	= 0;
	int Turn	= 8;
	int Acc		= 16;
	int DColor 	= 0;
	
	public UnitWorldActor(CSprite stuff){
		super(stuff);
		setState(this);
		setCurrentFrame(0, 0);
		
		CParticle[] particles = new CParticle[32];
       	for(int i=0;i<particles.length;i++){
       		particles[i] = new CParticle();
       	}
       	Effect = new CParticleSystem(particles,this);
       	
	}
	

//	--------------------------------------------------------------------------------------------------------	
	public void update() {
		HPos256 += CMath.cosTimes256(Direct)*Speed/256;
		VPos256 -= CMath.sinTimes256(Direct)*Speed/256;

		if(HPos256<0)
			HPos256 = 0;
		if(VPos256<0)
			VPos256 = 0;
		if(HPos256>world.Width*256)
			HPos256 = world.Width*256;
		if(VPos256>world.Height*256)
			VPos256 = world.Height*256;
		
		int dx = (HPos256+128)/256;
		int dy = (VPos256+128)/256;
		
		int curAnimate = CurAnimate;
		int curFrame = CurFrame;
		CurAnimate = 0;
		CurFrame   = 0;
		if(tryMove(dx-X, 0)){
			HPos256 = X*256 + 128;
			if(Speed>0)Speed-=Speed/16;
		}
		if(tryMove(0, dy-Y)){
			VPos256 = Y*256 + 128;
			if(Speed>0)Speed-=Speed/16;
		}
		CurAnimate = curAnimate;
		CurFrame   = curFrame;
		
		setCurrentFrame(CMath.cycNum((-Direct-25)%360/45, 0, 8), CurFrame);
		nextCycFrame();
		
		if(Speed>MaxSpeed/8){
			Effect.spawn(1,PARTICLE_SMOKE,X, Y);
		}
		Effect.update();
		
	}
	
	
	
	public void render(Graphics g, int x, int y) {

//		g.setColor(0xff00ff00);
//		g.drawArc(x - 10, y - 5, 20, 10, 0, 360);
//		g.drawLine(x, y, x, y - 32 );
		
		// shandom
		int curAnimate = CurAnimate;
		int curFrame = CurFrame;
		super.setCurrentFrame(CurAnimate + 8, 0);
		super.render(g, x, y+10);
		CurAnimate = curAnimate;
		CurFrame   = curFrame;
		
		
		// substance
		Effect.render(g);
		super.render(g, x, y);
		
		// point
		DColor = CMath.sinTimes256(getTimer()*10%180);
		if(DColor>0xff)DColor=0xff;
		
		int color = 
			0x7f000000
			+(DColor/2<<16) 
			+(DColor<<8) 
			+(DColor/2<<0) 
			;
		
//		int dxh = x+CMath.cosTimes256(Direct)*16/256;
//		int dyh = y-CMath.sinTimes256(Direct)*16/256-32;
//		int dx1 = x-CMath.cosTimes256(Direct-15)*8/256;
//		int dy1 = y+CMath.sinTimes256(Direct-15)*8/256-32;
//		int dx2 = x-CMath.cosTimes256(Direct+15)*8/256;
//		int dy2 = y+CMath.sinTimes256(Direct+15)*8/256-32;
//		g.setColor(color);
//		
//		g.fillTriangle(dxh, dyh, dx1, dy1, dx2, dy2);
		
		g.setColor(color);
		g.fillArc(x-16, y-16, 32, 32, Direct-15, 30);
	}

//	转向
	public void turnL(){
		Direct = CMath.cycNum(Direct, Turn * Speed * 100 / MaxSpeed / 100, 360);
//		Direct = CMath.cycNum(Direct, Turn  , 360);
	}
	public void turnR(){
		Direct = CMath.cycNum(Direct,-Turn * Speed * 100 / MaxSpeed / 100, 360);
//		Direct = CMath.cycNum(Direct,-Turn  , 360);
	}
//	加速
	public void accelerate(){
		Speed+=Acc;
		if(Speed>MaxSpeed)Speed=MaxSpeed;
	}
//	刹车
	public void breakDown(){
		Speed-=Acc;
		if(Speed<-MaxSpeed/4)Speed=-MaxSpeed/4;
	}
	
	public boolean isMaxSpeed(){
		return Speed==MaxSpeed;
	}
	
	
//	----------------------------------------------------------------------------------------------------
//	粒子系统
	CParticleSystem Effect;
	
	final static public int Div = 256 ;
	final static public int PARTICLE_SMOKE 		= 0;
	
	public void particleEmitted(CParticle particle, int id) {
		
		particle.Timer = 0;
		particle.X *= 256 ;
		particle.Y *= 256 ;
		particle.SpeedX = 0;
		particle.SpeedY = 0;
		particle.AccX = 0;
		particle.AccY = 0;
		
		int angle = Random.nextInt();
		switch(particle.Category){
		case PARTICLE_SMOKE:
			particle.TerminateTime = 12;
			particle.Color = 0xffffffff;
			particle.X -= CMath.cosTimes256(Direct)*12;
			particle.Y += CMath.sinTimes256(Direct)*12;
			particle.SpeedX += -CMath.cosTimes256(Direct+angle%(Speed/32))*(Math.abs(angle)%Speed)/512;
			particle.SpeedY += +CMath.sinTimes256(Direct+angle%(Speed/32))*(Math.abs(angle)%Speed)/512;
			particle.AccX = particle.SpeedX/16;
			particle.AccY = particle.SpeedY/16;
			break;
		}
	}
	public void particleAffected(CParticle particle, int id) {
		particle.SpeedX += particle.AccX;
		particle.SpeedY += particle.AccY;
		particle.X += particle.SpeedX;
		particle.Y += particle.SpeedY;
		
		
	
	}
	public void particleRender(Graphics g, CParticle particle, int id) {
//		g.setColor(particle.Color);
//		g.drawArc(
//				world.toScreenPosX(particle.X/Div) - size/2, 
//				world.toScreenPosY(particle.Y/Div) - size/2,
//				size, 
//				size, 
//				0, 360);
		int curAnimate = CurAnimate;
		int curFrame = CurFrame;
		super.setCurrentFrame(16, particle.Timer-1);
		super.render(g, 
				world.toScreenPosX(particle.X/Div), 
				world.toScreenPosY(particle.Y/Div)
				);
		CurAnimate = curAnimate;
		CurFrame   = curFrame;
		
		

	}
	public void particleTerminated(CParticle particle, int id) {
	}

}

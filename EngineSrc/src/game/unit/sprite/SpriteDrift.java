package game.unit.sprite;

import javax.microedition.lcdui.Graphics;

import com.morefuntek.cell.Game.CCD;
import com.morefuntek.cell.Game.CCollides;
import com.morefuntek.cell.Game.CScreen;
import com.morefuntek.cell.Game.CSprite;
import com.morefuntek.cell.Game.IState;
import com.morefuntek.cell.ParticleSystem.CParticle;
import com.morefuntek.cell.ParticleSystem.CParticleSystem;
import com.morefuntek.cell.ParticleSystem.IParticleLauncher;

public class SpriteDrift extends CSprite implements IState , IParticleLauncher {

	final float MAX_MOBILITY	= 1f; 	//最大机动性 = 8度
	final float MAX_SPEED		= 4f;	//最大速度
	
	
	float MX = 0;
	float MY = 0;
	
	boolean IsAcc 	= false;
	boolean IsTurn 	= false;
	
	float AccDirect  		= 0 ;//头方向
	float AccSpeed  		= 0 ;//头方向
	float AccFriction 		= 1.5f ;//惯性阻力
	
	float InertiaDirect 	= 0 ;//惯性方向
	float InertiaFriction 	= 1.02f ;//惯性阻力
	float InertiaSpeed		= 0 ;//速度

	CParticleSystem smoke ;
	
	CCD blocks[] = new CCD[4];
	
	public SpriteDrift(CSprite father){
		super(father);
		this.addState(this);
		haveMapBlock = false;
    	haveSprBlock = false;
    	SpeedX256 = 0;
		SpeedY256 = 0;
		super.Active  = true;
		super.Visible = false;
		// my define particle
       	CParticle[] particles = new CParticle[32];
       	for(int i=0;i<particles.length;i++){
       		particles[i] = new CParticle();
       	}
       	smoke = new CParticleSystem(particles,this);
  
       	blocks[0] = CCD.createCDRect(0xffffffff, -1,-1, 1, 1);
    	blocks[1] = CCD.createCDRect(0xffffffff, -1, 0, 1, 1);
    	blocks[2] = CCD.createCDRect(0xffffffff,  0,-1, 1, 1);
    	blocks[3] = CCD.createCDRect(0xffffffff,  0, 0, 1, 1);
    	
    	super.collides = new CCollides(4);
    	super.collides.addCD(blocks[0]);
    	super.collides.addCD(blocks[1]);
    	super.collides.addCD(blocks[2]);
    	super.collides.addCD(blocks[3]);
 
  
    	super.collides.setComboFrame(new int[]{0,1,2,3}, 0);
	}

	public void render(Graphics g, int x, int y) {
		super.render(g, x, y);
		
		g.setColor(0xff000000);
		g.drawArc(x - 8, y - 8, 16, 16, 0, 360);
		g.drawLine(x, y, 
				x + (int)(Math.cos(Math.toRadians(InertiaDirect))*InertiaSpeed*16),
				y - (int)(Math.sin(Math.toRadians(InertiaDirect))*InertiaSpeed*16)
				);
		g.drawLine(x, y, 
				x + (int)(Math.cos(Math.toRadians(AccDirect))*(AccSpeed*32+16)),
				y - (int)(Math.sin(Math.toRadians(AccDirect))*(AccSpeed*32+16))
				);


		smoke.render(g);
	}
	
	public void update(){

		// physical
		InertiaSpeed /= InertiaFriction;
		AccSpeed /= AccFriction;

		float dd = (AccDirect - InertiaDirect) / 15 ;
		
		InertiaSpeed  += AccSpeed ;
		InertiaDirect += dd ;
		
		if(InertiaSpeed>+MAX_SPEED)InertiaSpeed = +MAX_SPEED;
		if(InertiaSpeed<-MAX_SPEED)InertiaSpeed = -MAX_SPEED;
		
		IsTurn = false;
		IsAcc  = false;
		
		// try mov
		float dx = (float)(+Math.cos(Math.toRadians(InertiaDirect))*(InertiaSpeed));
		float dy = (float)(-Math.sin(Math.toRadians(InertiaDirect))*(InertiaSpeed));
		
		MX += dx ;
		MY += dy ;
		
		X = (int)MX;
		Y = (int)MY;
		
		if(touch_Spr_Map(this, CD_TYPE_MAP, world.getMap())){
			println("touch back" + CScreen.getTimer());
			
			InertiaSpeed *= -1;
			
			MX -= dx ;
			MY -= dy ;
			
			X = (int)MX;
			Y = (int)MY;
		}
		
		
		// direct
		float d = AccDirect + (InertiaDirect - AccDirect)/4  ;

		blocks[0].X1 = (short)(+Math.cos(Math.toRadians(d+30))*16);
		blocks[0].Y1 = (short)(-Math.sin(Math.toRadians(d+30))*16);
		blocks[0].X2 = (short)(blocks[0].X1 + 1);
		blocks[0].Y2 = (short)(blocks[0].Y1 + 1);

		blocks[1].X1 = (short)(+Math.cos(Math.toRadians(d-30))*16);
		blocks[1].Y1 = (short)(-Math.sin(Math.toRadians(d-30))*16);
		blocks[1].X2 = (short)(blocks[1].X1 + 1);
		blocks[1].Y2 = (short)(blocks[1].Y1 + 1);

		blocks[2].X1 = (short)(-Math.cos(Math.toRadians(d+30))*16);
		blocks[2].Y1 = (short)(+Math.sin(Math.toRadians(d+30))*16);
		blocks[2].X2 = (short)(blocks[2].X1 + 1);
		blocks[2].Y2 = (short)(blocks[2].Y1 + 1);

		blocks[3].X1 = (short)(-Math.cos(Math.toRadians(d-30))*16);
		blocks[3].Y1 = (short)(+Math.sin(Math.toRadians(d-30))*16);
		blocks[3].X2 = (short)(blocks[3].X1 + 1);
		blocks[3].Y2 = (short)(blocks[3].Y1 + 1);
		

		if(touch_Spr_Map(this, CD_TYPE_MAP, world.getMap())){
			println("turn cut " + CScreen.getTimer());
			InertiaDirect -= dd ;
			AccDirect *= -1;
		}
		
		
		
		if( Math.abs(InertiaDirect - AccDirect) > 15 &&
			Math.abs(InertiaSpeed) > MAX_SPEED-MAX_SPEED/4  ){

//			smoke.spawn(1, 
//					X - (int)(Math.cos(Math.toRadians(d+30))*16),
//					Y + (int)(Math.sin(Math.toRadians(d+30))*16)
//					);
//			smoke.spawn(1, 
//					X - (int)(Math.cos(Math.toRadians(d-30))*16),
//					Y + (int)(Math.sin(Math.toRadians(d-30))*16)
//					);
		}
		
		
		smoke.update();
		
	}

	
//	转向
	public void turn(float direct){
		IsTurn = true;
		
		if(IsAcc)AccDirect += direct / 2 * InertiaSpeed  ;
		else AccDirect += direct * 2 * InertiaSpeed  ;

	}
	
//	加速
	public void accelerate(float rate){
		IsAcc = true;
		AccSpeed = rate;
	}
	
//	刹车
	public void breakDown(){
		AccSpeed /= 1.1;
		InertiaSpeed /= 1.1;
	}
	
//------------------------------------------------------------------------------------------------
//	particle

	public void particleTerminated(CParticle particle, int id) {
		
	}
	
	public void particleEmitted(CParticle particle, int id) {
		particle.TerminateTime = 16;
		particle.Timer = 0;
		
		particle.Color = 0;
	}

	public void particleAffected(CParticle particle, int id) {
	}
	
	public void particleRender(Graphics g, CParticle particle, int id) {
		// color
		g.setColor(particle.Color);
		// draw
		g.drawArc(
				world.toScreenPosX(particle.X) - 2, 
				world.toScreenPosY(particle.Y) - 2,
				4, 
				4, 
				0, 360);

	}
}

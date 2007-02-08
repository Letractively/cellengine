package game.unit.battle;

import java.util.Vector;

import javax.microedition.lcdui.Graphics;

import com.cell.*;
import com.cell.game.*;
import com.cell.particle.*;

public class BattleManager extends CWorld  implements IParticleLauncher{

	
	public Vector 	openEnemys  = new Vector();
	public Vector 	closeEnemys = new Vector();
	
	public Vector 	enemyBullet = new Vector();
	public Vector 	actorBullet = new Vector();
	
	public Vector  Ammor = new Vector();
	
	public BattleManager(){
		
		if(Effect==null){
			CParticle[] particles = new CParticle[128];
		    for(int i=0;i<particles.length;i++){
		       	particles[i] = new CParticle();
		    }
		    Effect = new CParticleSystem(particles,this);
		}
		
	}
	
	public void render(Graphics g) {
		super.render(g);
		
		renderSprites(g, openEnemys);
		renderSprites(g, enemyBullet);
		renderSprites(g, actorBullet);
		
		if(Effect!=null)Effect.render(g);
	}
	
	public void update() {
		super.update();
		
		updateSprites(openEnemys);
		updateSprites(enemyBullet);
		updateSprites(actorBullet);
		
		if(Effect!=null)Effect.update();
	}


	public void Dispose(){
		BattleManager.Effect = null;
	}



	//	----------------------------------------------------------------------------------------------------
//	Á£×ÓÏµÍ³
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
	
	static public void spawn(int count,int type,int x,int y){
		if(Effect!=null)Effect.spawn(count, type, x, y);
	}
	
	static public void SpawnExtParticle(int type,int count,int x,int y){
		if(Effect!=null)Effect.spawn(count, type, x, y);
	}
	
	static public int smokeSpeed = 512;
	
	static public CParticleSystem Effect;

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
			particle.TerminateTime = 4;
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
					toScreenPosX(particle.X/Div) - size/2, 
					toScreenPosY(particle.Y/Div) - size/2,
					size, 
					size, 
					0, 360);
			size = particle.Timer * 8;
			g.drawArc(
					toScreenPosX(particle.X/Div) - size/2, 
					toScreenPosY(particle.Y/Div) - size/2,
					size, 
					size, 
					0, 360);
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
					toScreenPosX(particle.X/Div) - size/2, 
					toScreenPosY(particle.Y/Div) - size/2,
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
					toScreenPosX(particle.X/Div) - size/2, 
					toScreenPosY(particle.Y/Div) - size/2,
					size, 
					size, 
					0, 360);
			size = particle.Timer * 8 ;
			g.drawArc(
					toScreenPosX(particle.X/Div) - size/2, 
					toScreenPosY(particle.Y/Div) - size/2,
					size, 
					size, 
					0, 360);
			break;
		case PARTICLE_BIG_L:
			size = (particle.TerminateTime - particle.Timer) * 16 ;
			g.setColor(particle.Color);
			g.fillArc(
					toScreenPosX(particle.X/Div) - size/2, 
					toScreenPosY(particle.Y/Div) - size/2,
					size, 
					size, 
					0, 360);
			size = particle.Timer * 8 ;
			g.drawArc(
					toScreenPosX(particle.X/Div) - size/2, 
					toScreenPosY(particle.Y/Div) - size/2,
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

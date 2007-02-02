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
abstract public class UnitBattle extends CSprite implements IParticleLauncher {

//	----------------------------------------------------------------------------------------------------
//	基本
	public int HP = 100;
	
	public UnitBattle(CSprite stuff){
		super(stuff);
		if(Effect==null){
			CParticle[] particles = new CParticle[16];
		    for(int i=0;i<particles.length;i++){
		       	particles[i] = new CParticle();
		    }
		    Effect = new CParticleSystem(particles,this);
		}
		
		
	}

//	----------------------------------------------------------------------------------------------------
//	逻辑
	
	abstract public void hasTouch(UnitBattle target);
	
	
//	----------------------------------------------------------------------------------------------------
//	粒子系统
//	final static public int PARTICLE_SMOKE 		= 0;
//	final static public int PARTICLE_EXP		= 1;
//	final static public int PARTICLE_CONTRACT	= 3;
//	
//	
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
	
	final static public int PARTICLE_LIGHT		= 1000;

	static public CSprite effect ;
	static public int smokeSpeed = 512;
	
	static CParticleSystem Effect;

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
		}
		
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
		case PARTICLE_LIGHT:
			particle.TerminateTime = 12;
			particle.Color = 0xffffffff;
			break;
//			case PARTICLE_EXP:
//			particle.TerminateTime = 12;
//			particle.Color = 0xffffffff;
//			particle.SpeedX = CMath.sinTimes256(id*10 + angle)*d;
//			particle.SpeedY = CMath.cosTimes256(id*10 + angle)*d;
//			particle.AccX = -CMath.sinTimes256(id*10 + angle)/12;
//			particle.AccY = -CMath.cosTimes256(id*10 + angle)/12;
//			break;
//		case PARTICLE_SMOKE:
//			particle.TerminateTime = 10;
//			particle.Color = 0xffffffff;
//			break;
//		case PARTICLE_CONTRACT:
//			particle.TerminateTime = 64;
//			particle.Color = Random.nextInt();
//			particle.X += CMath.sinTimes256(id*10 + angle)*64;
//			particle.Y += CMath.cosTimes256(id*10 + angle)*64;
//			particle.SpeedX = -CMath.sinTimes256(id*10 + angle);
//			particle.SpeedY = -CMath.cosTimes256(id*10 + angle);
//			break;
		}
		
		
		
		
//		particle.Timer = effect.getFrameCount(particle.Category);
		
//		switch(particle.Category){
//		case PARTICLE_EXP:
//			particle.Timer = 10;
//			particle.Color = 0xffff0000;
//			particle.SpeedX = CMath.sinTimes256(id*10 + angle)*4;
//			particle.SpeedY = CMath.cosTimes256(id*10 + angle)*4;
//			particle.AccX = -CMath.sinTimes256(id*10 + angle)/8;
//			particle.AccY = -CMath.cosTimes256(id*10 + angle)/8;
//			break;
//		case PARTICLE_CONTRACT:
//			particle.Timer = 64;
//			particle.Color = Random.nextInt();
//			particle.X += CMath.sinTimes256(id*10 + angle)*64;
//			particle.Y += CMath.cosTimes256(id*10 + angle)*64;
//			particle.SpeedX = -CMath.sinTimes256(id*10 + angle);
//			particle.SpeedY = -CMath.cosTimes256(id*10 + angle);
//			break;
//		}

		
	}
	public void particleAffected(CParticle particle, int id) {
		particle.SpeedX += particle.AccX;
		particle.SpeedY += particle.AccY;
		particle.Y += particle.SpeedY;
		particle.X += particle.SpeedX;
	}
	public void particleRender(Graphics g, CParticle particle, int id) {
		int size;
		
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
			size = (particle.TerminateTime - particle.Timer) * 8 ;
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

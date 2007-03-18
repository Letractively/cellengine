/**
 * 
 */
package game.unit;

import javax.microedition.lcdui.Graphics;

import com.cell.CMath;
import com.cell.CObject;
import com.cell.game.CAnimates;
import com.cell.game.CCollides;
import com.cell.game.CSprite;
import com.cell.game.IState;
import com.cell.particle.CParticle;
import com.cell.particle.CParticleSystem;
import com.cell.particle.IParticleLauncher;


/**
 * @author 张翼飞
 *
 */
abstract public class Unit extends CSprite  implements IState, IParticleLauncher{
	
	public int HP = 100;

	public Unit(CSprite stuff) {
		super(stuff);
		Active = false;
   		Visible = false;
   		
		CParticle[] particles = new CParticle[16];
		for (int i = 0; i < particles.length; i++) {
			particles[i] = new CParticle();
		}
		ParticleSystem = new CParticleSystem(particles, this);
		
	}

	abstract public void unitUpdate();
	
	public void update(){
		unitUpdate();
		ParticleSystem.update();
	}
	
	public void render(Graphics g, int x, int y) {
		super.render(g, x, y);
		ParticleSystem.render(g);
	}
	
	//abstract public void attack(Unit unit);
	//abstract public void damage(Unit unit);
//	----------------------------------------------------------------------------------------------------
//	粒子系统
	
	// particle system
	static public CSprite Effects;
	static private int ParticleType;
	final static public int EFFECT_DAMAGE_SWORD = 0;
	final static public int EFFECT_DAMAGE_ICD	= 1;
	final static public int EFFECT_DAMAGE_FIRE	= 2;
	final static public int EFFECT_TAIL_SWORD 	= 3;
	final static public int EFFECT_TAIL_ICD		= 4;
	final static public int EFFECT_TAIL_FIRE	= 5;
	
	public void EffectSpawn(int type,int x,int y){
		ParticleType = type;
		switch(type){
		case EFFECT_DAMAGE_SWORD:
		case EFFECT_DAMAGE_ICD:
		case EFFECT_DAMAGE_FIRE:
			ParticleSystem.spawn(1, TYPE_HOLD, x, y);
			break;
		case EFFECT_TAIL_SWORD:
		case EFFECT_TAIL_ICD:
		case EFFECT_TAIL_FIRE:
			ParticleSystem.spawn(1, TYPE_HOLD, x, y);
			break;
		default:
			ParticleSystem.spawn(8, TYPE_GFORCE, x, y);
		}
		
		
	}
	
	
	CParticleSystem ParticleSystem;
	
	// particle stuff
	
	
	final static private int Div 			= 256 ;
	final static private int Gravity 		= 32 ;
	
	final static private int TYPE_HOLD 			= 0;
	final static private int TYPE_DIFFUSE 		= 1;
	final static private int TYPE_CONTRACT		= 2;
	final static private int TYPE_GFORCE		= 3;
	final static private int TYPE_EXP			= 4;
	final static private int TYPE_RAISE		= 5;
	final static private int TYPE_RANDOM		= 6;
	final static private int TYPE_GRAVITY		= 7;

	public void particleEmitted(CParticle particle, int id) {
		particle.Color 	= 255;
		particle.Data 	= ParticleType;
		particle.Timer	 = 0;
		particle.TerminateTime = Effects.getFrameCount(particle.Data);
		
		particle.SpeedX = 0;
		particle.SpeedY = 0;
		particle.AccX = 0;
		particle.AccY = 0;
		
		int angle = Random.nextInt();

		switch(particle.Category){
		case TYPE_CONTRACT:
			particle.X += CMath.sinTimes256(id*10 + angle)*32;
			particle.Y += CMath.cosTimes256(id*10 + angle)*32;
			particle.SpeedX = -CMath.sinTimes256(id*10 + angle);
			particle.SpeedY = -CMath.cosTimes256(id*10 + angle);
			break;
		case TYPE_DIFFUSE:
			particle.SpeedX = CMath.sinTimes256(id*10 + angle);
			particle.SpeedY = CMath.cosTimes256(id*10 + angle);
			break;
		case TYPE_EXP:
			particle.SpeedX = CMath.sinTimes256(id*10 + angle)*4;
			particle.SpeedY = CMath.cosTimes256(id*10 + angle)*4;
			particle.AccX = -CMath.sinTimes256(id*10 + angle)/8;
			particle.AccY = -CMath.cosTimes256(id*10 + angle)/8;
			break;
		case TYPE_GRAVITY:
			particle.SpeedX = CMath.sinTimes256(id*10 + angle)*2;
			particle.SpeedY = CMath.cosTimes256(id*10 + angle)*2;
			particle.AccX = -CMath.sinTimes256(id*10 + angle)/8;
			particle.AccY = -CMath.cosTimes256(id*10 + angle)/8;
			break;
		case TYPE_GFORCE:
			particle.SpeedX = CMath.sinTimes256(id*10 + angle);
			particle.SpeedY = CMath.cosTimes256(id*10 + angle);
			particle.AccY = Gravity;
			break;
		case TYPE_HOLD:
			break;
		case TYPE_RAISE:
			particle.X += CMath.sinTimes256(id*10 + angle)*16;
			particle.Y += CMath.cosTimes256(id*10 + angle)*16;
			particle.AccY = -Gravity;
			break;
		case TYPE_RANDOM:
			particle.X += CMath.sinTimes256(id*10 + angle)*16;
			particle.Y += CMath.cosTimes256(id*10 + angle)*16;
			break;
		}
	
	}
	public void particleAffected(CParticle particle, int id) {
		particle.SpeedX += particle.AccX;
		particle.SpeedY += particle.AccY;
		particle.Y += particle.SpeedY;
		particle.X += particle.SpeedX;
	
	}
	public void particleRender(Graphics g, CParticle particle, int id) {
		int X = world.toScreenPosX(particle.X/Div);
		int Y = world.toScreenPosY(particle.Y/Div);
		try{
			Effects.setCurrentFrame(particle.Data, particle.Timer);
			Effects.render(g, X, Y);
		}catch(Exception err){
			err.printStackTrace();
		}
//		// color
//		g.setColor(0xff000000 
//				| (color<<16) 
//				//| (color<<8 )
//				//| (color<<0 ) 
//				);
//		// draw
//		g.drawArc(
//				X - size/2, 
//				Y - size/2,
//				size, 
//				size, 
//				0, 360);
	}
	public void particleTerminated(CParticle particle, int id) {}

}



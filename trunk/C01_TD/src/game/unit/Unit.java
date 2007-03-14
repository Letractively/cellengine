/**
 * 
 */
package game.unit;

import javax.microedition.lcdui.Graphics;

import com.cell.CMath;
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
		// TODO Auto-generated constructor stub
		CParticle[] particles = new CParticle[8];
       	for(int i=0;i<particles.length;i++){
       		particles[i] = new CParticle();
       	}
       	Effect = new CParticleSystem(particles,this);
	}

	abstract public void update();
	
//	----------------------------------------------------------------------------------------------------
//	粒子系统
	CParticleSystem Effect;
	
	final static public int Div = 256 ;
	final static public int PARTICLE_SMOKE 		= 0;
	final static public int PARTICLE_EXP		= 1;
	final static public int PARTICLE_CONTRACT	= 3;

	
	public void particleEmitted(CParticle particle, int id) {
		
		particle.Timer = 10;
		particle.X *= 256 ;
		particle.Y *= 256 ;
		particle.SpeedX = 0;
		particle.SpeedY = 0;
		particle.AccX = 0;
		particle.AccY = 0;
		
		int angle = Random.nextInt();

		switch(particle.Category){
		case PARTICLE_EXP:
//			particle.TerminateTime = 10;
			particle.Color = 0xffff0000;
			particle.SpeedX = CMath.sinTimes256(id*10 + angle)*4;
			particle.SpeedY = CMath.cosTimes256(id*10 + angle)*4;
			particle.AccX = -CMath.sinTimes256(id*10 + angle)/8;
			particle.AccY = -CMath.cosTimes256(id*10 + angle)/8;
			break;
		case PARTICLE_SMOKE:
//			particle.TerminateTime = 10;
			particle.Color = 0xffffffff;
			break;
		case PARTICLE_CONTRACT:
//			particle.TerminateTime = 64;
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
			if(particle.Timer<10/2){
				size = (particle.Timer) / 4;
			}else{
				size = (10-particle.Timer) / 4;
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

}

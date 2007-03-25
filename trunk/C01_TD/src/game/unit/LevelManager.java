package game.unit;

import javax.microedition.lcdui.Graphics;

import com.cell.CMath;
import com.cell.game.CSprite;
import com.cell.game.CWorld;
import com.cell.game.IState;
import com.cell.particle.CParticle;
import com.cell.particle.CParticleSystem;
import com.cell.particle.IParticleLauncher;

public class LevelManager extends CWorld implements IParticleLauncher{

	
	public LevelManager(){
		CParticle[] particles = new CParticle[1024];
		for (int i = 0; i < particles.length; i++) {
			particles[i] = new CParticle();
		}
		ParticleSystem = new CParticleSystem(particles, this);
		
	}
	
	public void render(Graphics g) {
		super.render(g);
		ParticleSystem.render(g);
	}
	public void update() {
		super.update();
		ParticleSystem.update();
	}
	
//	----------------------------------------------------------------------------------------------------
//	����ϵͳ
	
	// particle system
	public CSprite 	Effects;
	
	int 	EffectType;
	String 	EffectText;
	CParticleSystem ParticleSystem;
	
	
	final private int Div 			= 256 ;
	final private int Gravity 		= 32 ;
	
	final protected int TYPE_HOLD 			= 0;
	final protected int TYPE_EXP			= 4;
	final protected int TYPE_RAISE			= 5;
	final protected int TYPE_SINGLE_UP		= 100;
	final protected int TYPE_TEXT			= 101;

	public void particleEmitted(CParticle particle, int id) {
		particle.Data 			= EffectType;
		particle.TerminateTime 	= 32;
		particle.X				*= 256;
		particle.Y				*= 256;
		particle.SpeedX 		= 0;
		particle.SpeedY 		= 0;
		particle.AccX 			= 0;
		particle.AccY 			= 0;
		particle.Element		= null;
		
		
		int angle = Random.nextInt();

		switch(particle.Category){
		case TYPE_HOLD:
			particle.TerminateTime 	= Effects.getFrameCount(particle.Data);
			break;
			
		case TYPE_EXP:
			particle.TerminateTime 	= Effects.getFrameCount(particle.Data);
			particle.SpeedX = CMath.sinTimes256(id*10 + angle)*4;
			particle.SpeedY = CMath.cosTimes256(id*10 + angle)*4;
			particle.AccX = -CMath.sinTimes256(id*10 + angle)/8;
			particle.AccY = -CMath.cosTimes256(id*10 + angle)/8;
			break;
		case TYPE_RAISE:
			particle.TerminateTime 	= Effects.getFrameCount(particle.Data);
			particle.X += CMath.sinTimes256(id*10 + angle)*16;
			particle.Y += CMath.cosTimes256(id*10 + angle)*16;
			particle.AccY = -Gravity;
			break;
			
		case TYPE_SINGLE_UP:
			particle.Data 			= EffectType;
			particle.TerminateTime 	= 16;
			particle.SpeedY			= -256;
			break;
		case TYPE_TEXT:
			particle.Element		= EffectText;
			particle.TerminateTime 	= 16;
			particle.SpeedY			= -256;
			particle.Color 			= 0xffffff00;
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
		int X = toScreenPosX(particle.X/Div);
		int Y = toScreenPosY(particle.Y/Div);
		try{
			if(particle.Element!=null){
				g.setColor(particle.Color);
				g.drawString((String)particle.Element, X, Y, 0);
			}else{
				Effects.setCurrentFrame(particle.Data, (particle.Timer - 1)%Effects.getFrameCount(particle.Data));
				Effects.render(g, X, Y);
			}
		}catch(Exception err){
			err.printStackTrace();
		}
	}
	public void particleTerminated(CParticle particle, int id) {}

}

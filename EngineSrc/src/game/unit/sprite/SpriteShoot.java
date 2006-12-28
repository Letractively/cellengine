package game.unit.sprite;

import javax.microedition.lcdui.Graphics;

import com.morefuntek.cell.Game.CSprite;
import com.morefuntek.cell.Game.IState;
import com.morefuntek.cell.ParticleSystem.CParticle;
import com.morefuntek.cell.ParticleSystem.IParticleLauncher;

public class SpriteShoot extends CSprite implements IState , IParticleLauncher {

	CSprite Target;
	
	public SpriteShoot(CSprite spr) {
		super(spr);
		super.setState(this);
		
		
	}

	public void update() {

	}


	public void particleAffected(CParticle particle, int id) {}

	public void particleEmitted(CParticle particle, int id) {}

	public void particleRender(Graphics g, CParticle particle, int id) {}

	public void particleTerminated(CParticle particle, int id) {}

	/**
	 * override 方法
	 * @see com.morefuntek.cell.Game.IState#tryChangeState()
	 */
	public void tryChangeState() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * override 方法
	 * @see com.morefuntek.cell.Game.IState#onState()
	 */
	public void onState() {
		// TODO Auto-generated method stub
		
	}

	
	
}

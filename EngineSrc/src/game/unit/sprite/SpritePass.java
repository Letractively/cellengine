package game.unit.sprite;

import com.morefuntek.cell.Game.CSprite;
import com.morefuntek.cell.Game.IState;

/**
 * ¹¦ÄÜÃèÊö
 * @author yifeizhang
 * @since 2006-12-21 
 * @version 1.0
 */
public class SpritePass extends CSprite implements IState {

	public SpritePass(CSprite father) {
		super(father);
		super.addState(this);
		
	}
	
	public void update() {

	}


}

package game.unit.sprite;

import com.morefuntek.cell.Game.CSprite;
import com.morefuntek.cell.Game.IState;

/**
 * ��������
 * @author yifeizhang
 * @since 2006-12-21 
 * @version 1.0
 */
public class SpritePass extends CSprite implements IState {

	public SpritePass(CSprite father) {
		super(father);
		super.setState(this);
		
	}
	
	public void update() {

	}

	/**
	 * override ����
	 * @see com.morefuntek.cell.Game.IState#tryChangeState()
	 */
	public void tryChangeState() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * override ����
	 * @see com.morefuntek.cell.Game.IState#onState()
	 */
	public void onState() {
		// TODO Auto-generated method stub
		
	}


}

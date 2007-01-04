package game.unit;

import com.morefuntek.cell.Game.CAnimates;
import com.morefuntek.cell.Game.CCollides;
import com.morefuntek.cell.Game.CSprite;
import com.morefuntek.cell.Game.IState;

public class UnitShoot extends CSprite implements IState {

	int state = -1;
	public UnitShoot(CSprite spr) {
		super(spr);
		super.setState(this);
		
	}

	public void update() {

	}

//	------------------------------------------------------------------------------------------------------
//	missile
	final int STATE_MISSILE		= 0;
	CSprite MissileTarget		= null;
	public void startMissile(CSprite target){
		
	}
	public boolean isEndMissile(){
		
		return false;
	}
	public void onMissile(){
		
	}
	
}

package cv.unit;

import com.morefuntek.cell.Game.CAnimates;
import com.morefuntek.cell.Game.CCollides;
import com.morefuntek.cell.Game.CSprite;
import com.morefuntek.cell.Game.IState;

public class UnitActor extends CSprite implements IState {


	public UnitActor(CSprite spr) {
		super(spr);
		super.setState(this);
		// TODO Auto-generated constructor stub
	}

	public void update() {
		// TODO Auto-generated method stub

	}

}

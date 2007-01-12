package game.unit.world;

import com.morefuntek.cell.Game.CSprite;
import com.morefuntek.cell.Game.IState;

public class UnitWorldEvent extends CSprite implements IState {

	public int Type = 0;
	
	public UnitWorldEvent(CSprite stuff){
		super(stuff);
		super.setState(this);
	}
	
	public void update() {
		// TODO Auto-generated method stub
		
		nextCycFrame();
	}

}

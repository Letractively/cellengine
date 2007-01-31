package cv.unit;

import com.cell.CObject;
import com.cell.game.IState;

abstract public class Unit extends CObject implements IState{
	
	public SprStuff Spr;
	public String Type;
	public String Info;
	
	abstract public void update();

	public void init(SprStuff spr,String type,String info){
		Spr = spr;
		Type = type;
		Info = info;
		Spr.setState(this);
	}
}

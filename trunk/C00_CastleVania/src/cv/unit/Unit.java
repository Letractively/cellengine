package cv.unit;

import com.cell.CObject;
import com.cell.game.IState;

abstract public class Unit extends CObject implements IState{
	
	public SprStuff Spr;
	public String Type;
	public String Info;
	
	public int Team ;
	
	abstract public void update();

	abstract public void attack(Unit unit);
	
	abstract public void damage(Unit unit);

	public void init(SprStuff spr,String type,String info){
		Spr = spr;
		Type = type;
		Info = info;
		Spr.setState(this);
	}
	
	
	
	
}

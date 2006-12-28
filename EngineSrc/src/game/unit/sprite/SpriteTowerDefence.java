package game.unit.sprite;

import com.morefuntek.cell.Game.CSprite;
import com.morefuntek.cell.Game.IState;

public class SpriteTowerDefence extends CSprite implements IState {

	public int Hp 		= 100;//血
	public int Def 		= 100;//
	
	public int Atk 		= 100;//攻击力
	public int AtkRate	= 100;
	public int AtkScope	= 100;
	
	public int FreezeTime	= 32 ; 
	
	public SpriteTowerDefence(CSprite father){
		super(father);
		super.setState(this);
		
	}
	
	public void update(){
		FreezeTime--;
	}
	
	public CSprite findTarget(CSprite[] enemys){
		if(FreezeTime>0)return null;
		return null;
	}
	
	public void fire(CSprite shoot){
		if(FreezeTime>0)return;
	}

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

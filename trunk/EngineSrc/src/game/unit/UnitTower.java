package game.unit;

import com.morefuntek.cell.Game.CAnimates;
import com.morefuntek.cell.Game.CCollides;
import com.morefuntek.cell.Game.CSprite;
import com.morefuntek.cell.Game.IState;

public class UnitTower extends CSprite implements IState {

	
	int state		= -1;
	
	public UnitTower(CSprite spr) {
		super(spr);
		super.setState(this);
	}

	public void update() {
		switch(state){
		case STATE_BUILD:
			if(!isEndBuild()){
				onBuild();
			}else{
				startDefence();
			}
			break;
		case STATE_ATTACK:
			if(!isEndAttack()){
				onAttack();
			}else{
				onDefence();
			}
			break;
		case STATE_DEFENCE:
			if(!isEndDefence()){
				onDefence();
			}else{
				onDefence();//end
			}
			break;
		}
	}
	
//	-----------------------------------------------------------------------------------------------
	
	
	
	
//	-----------------------------------------------------------------------------------------------
//	building
	final int STATE_BUILD	= 0;
	
	public void startBuild(int sx,int sy){
		state = STATE_BUILD;
		Active = true;
		Visible = true;
		
		int dx = sx - X;
		int dy = sy - Y;
		
		tryMove(dx, dy);
		
	
	}
	public boolean isEndBuild(){
		return true;
	}
	public void onBuild(){
	}

//	----------------------------------------------------------------------------------------------------
//	attack
	final int STATE_ATTACK		= 1;
	int AttackScope				= 128;
	int AttackForzenTime 		= 100;
	int AttackTime				= 100;
	CSprite AttackTarget		= null;
	public void startAttack(CSprite[] targets){
		state = STATE_ATTACK;
		Active = true;
		Visible = true;
		
		
	}
	public boolean isEndAttack(){
		return true;
	}
	public void onAttack(){
	}
//	----------------------------------------------------------------------------------------------------
//	defence
	final int STATE_DEFENCE		= 2;
	int DefenceMaxTime 			= 100;
	int DefenceTime				= 100;
	public void startDefence(){
		state = STATE_DEFENCE;
		Active = true;
		Visible = true;
		
		DefenceTime = DefenceMaxTime;
	}
	public boolean isEndDefence(){
		return DefenceTime<0;
	}
	public void onDefence(){
		DefenceTime--;
	}
}

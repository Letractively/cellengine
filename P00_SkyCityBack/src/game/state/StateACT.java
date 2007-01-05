package game.state;

import com.morefuntek.cell.CObject;
import com.morefuntek.cell.Game.CCD;
import com.morefuntek.cell.Game.AScreen;
import com.morefuntek.cell.Game.CSprite;
import com.morefuntek.cell.Game.CWayPoint;
import com.morefuntek.cell.Game.IState;

public class StateACT extends CObject implements IState {

	//主角的设计模式请参考 StateNPC
	
	final public int STATE_HOLD = 0;
	final public int STATE_MOVE_U = 1;
	final public int STATE_MOVE_D = 2;
	final public int STATE_MOVE_L = 3;
	final public int STATE_MOVE_R = 4;
	
	public int state = 0;
	
	public CSprite spr;
	
	public int MaxSpeed = 2;
	
	public StateACT(CSprite stuff){
		spr = stuff;
		spr.setState(this);
	}

	public void update() {
		onEvent();
		changeEvent();
	}
	
	public void onEvent(){
		switch(state){
		case STATE_MOVE_U:
			spr.tryMove( 0,-MaxSpeed);
			spr.setCurrentFrame(3, spr.getCurrentFrame());
			spr.nextCycFrame();
			break;
		case STATE_MOVE_D:
			spr.tryMove( 0, MaxSpeed);
			spr.setCurrentFrame(0, spr.getCurrentFrame());
			spr.nextCycFrame();
			break;
		case STATE_MOVE_L:
			spr.tryMove(-MaxSpeed, 0);
			spr.setCurrentFrame(1, spr.getCurrentFrame());
			spr.nextCycFrame();
			break;
		case STATE_MOVE_R:
			spr.tryMove( MaxSpeed, 0);
			spr.setCurrentFrame(2, spr.getCurrentFrame());
			spr.nextCycFrame();
			break;
		}
		
		state = 0;
	}	
	
	public void changeEvent(){
    	if(AScreen.isKeyHold(AScreen.KEY_UP)){
    		state = STATE_MOVE_U;
    	} 
    	if(AScreen.isKeyHold(AScreen.KEY_DOWN)){
    		state = STATE_MOVE_D;
    	}
    	if(AScreen.isKeyHold(AScreen.KEY_LEFT)){
    		state = STATE_MOVE_L;
    	}
		if(AScreen.isKeyHold(AScreen.KEY_RIGHT)){
			state = STATE_MOVE_R;
		}
	}
	
//------------------------------------------------------------------------------------	
//	触发条件	
	
	
//------------------------------------------------------------------------------------
//	状态


	
}

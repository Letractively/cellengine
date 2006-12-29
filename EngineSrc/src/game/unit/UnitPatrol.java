package game.unit;

import com.morefuntek.cell.CObject;
import com.morefuntek.cell.Game.AScreen;
import com.morefuntek.cell.Game.CCD;
import com.morefuntek.cell.Game.CSprite;
import com.morefuntek.cell.Game.CWayPoint;
import com.morefuntek.cell.Game.IState;

public class UnitPatrol extends CObject implements IState  {

	final public int STATE_MOVE 	= 0;
	final public int STATE_HOLD 	= 1;
	final public int STATE_SWING	= 2;

	public int state = 0;
	
	//-------------------------------------------------------------------------------------------------
	
	public CSprite spr;
	
	public UnitPatrol(CSprite stuff, CWayPoint next){
		spr = stuff;
		NextWayPoint = next;
		spr.setState(this);
	}
	
	
	public void update() {
//		switch(state){
//		case STATE_MOVE : 
//			if(isEndMove()){
//				startHold();
//			}else{
//				onMove();
//			}
//			break;
//		case STATE_HOLD : 
//			if(isEndHold()){
//				startSwing();
//			}else{
//				onHold();
//			}
//			break;
//		case STATE_SWING : 
//			if(isEndSwing()){
//				startMove();
//			}else{
//				onSwing();
//			}
//			break;
//		}
		if(isEndMove()){
			startMove();
		}else{
			onMove();
		}
	}
	
//---------------------------------------------------------------------------------------
	//hold
	public int HoldTime = 100;
	public void onHold(){
		HoldTime--;
		spr.setCurrentFrame(0, 0);
	}
	public void startHold(){
		HoldTime = Math.abs(Random.nextInt()%200);
		state = STATE_HOLD;
	}
	public boolean isEndHold(){
		return HoldTime<0;
	}
	
//------------------------------------------------------------------------------------

	//patrol
	public CWayPoint NextWayPoint;
	private CWayPoint PrewWayPoint;
	public int MaxSpeed = 1/*+Math.abs(Random.nextInt()%4)*/;
	public void onMove(){
		spr.DirectX = NextWayPoint.X - spr.X;
		spr.DirectY = NextWayPoint.Y - spr.Y;
	
		if(spr.DirectX == 0 && spr.DirectY == 0){
			spr.setCurrentFrame(2, spr.getCurrentFrame());
		}else if(spr.DirectY < 0 ){
			spr.setCurrentFrame(0, spr.getCurrentFrame());
		}else if(spr.DirectY > 0){
			spr.setCurrentFrame(2, spr.getCurrentFrame());
		}else if(spr.DirectX < 0){
			spr.setCurrentFrame(3, spr.getCurrentFrame());
		}else if(spr.DirectX > 0){
			spr.setCurrentFrame(1, spr.getCurrentFrame());
		}
		
		spr.nextCycFrame();
		
		int dx = (spr.DirectX==0 ? 0 : (spr.DirectX>0 ? MaxSpeed : -MaxSpeed));
		int dy = (spr.DirectY==0 ? 0 : (spr.DirectY>0 ? MaxSpeed : -MaxSpeed));
		
		if(Math.abs(dx)>Math.abs(spr.DirectX))dx = spr.DirectX;
		if(Math.abs(dy)>Math.abs(spr.DirectY))dy = spr.DirectY;
		
		spr.tryMove(dx, dy);

	}
	public void startMove(){
		if(NextWayPoint.getNextCount()>0){
			int id = Math.abs(Random.nextInt()%NextWayPoint.getNextCount());
			if(PrewWayPoint != NextWayPoint.getNextPoint(id)){
				PrewWayPoint = NextWayPoint;
				NextWayPoint = NextWayPoint.getNextPoint(id);
			}else{
				PrewWayPoint = NextWayPoint;
				NextWayPoint = NextWayPoint.getNextPoint((id+1)%NextWayPoint.getNextCount());
			}
			
		}
		state = STATE_MOVE;
	}
	public boolean isEndMove(){
		return CCD.cdRect(
				spr.X - MaxSpeed, spr.Y - MaxSpeed, 
				spr.X + MaxSpeed, spr.Y + MaxSpeed, 
				NextWayPoint.X , NextWayPoint.Y , 
				NextWayPoint.X , NextWayPoint.Y );
	}
	
//	------------------------------------------------------------------------------------

	//patrol
	public int SwingTime = 100;

	public void onSwing(){
		SwingTime--;
		spr.setCurrentFrame(AScreen.getTimer()%4, 0);
		
		
	}
	public void startSwing(){
		SwingTime = Math.abs(Random.nextInt()%200);
		state = STATE_SWING;
	}
	public boolean isEndSwing(){
		return SwingTime<0;
	}
}

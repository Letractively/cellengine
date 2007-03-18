package game.unit;

import com.cell.*;
import com.cell.game.*;
import com.cell.game.ai.*;
import com.cell.particle.*;

public class UnitEnemy extends Unit {

	private int state = -1;
	
	public UnitEnemy(CSprite stuff){
		super(stuff);
		super.setState(this);
	}
	
	
	public void unitUpdate() {
		switch(state){
		case STATE_HOLD:
			if(!isEndHold()){
				onHold();
			}else{
				startMove(NextWayPoint);
			}
			break;
		case STATE_MOVE:
			if(!isEndMove()){
				onMove();
			}else{
				startMove(NextWayPoint);
			}
			break;
		}
		
	}
	
//	---------------------------------------------------------------------------------------
//	hold
	final public int STATE_HOLD 	= 1;
	public int HoldTime = 100;
	public void startHold(){
		state = STATE_HOLD;
		Active = true;
		Visible = true;
		HoldTime = Math.abs(Random.nextInt()%200);
	}
	boolean isEndHold(){
		return HoldTime<0;
	}
	void onHold(){
		HoldTime--;
		setCurrentFrame(0, 0);
	}

	
//	------------------------------------------------------------------------------------
//	patrol
	final public int STATE_MOVE 	= 0;
	public CWayPoint NextWayPoint;
	private CWayPoint PrewWayPoint;
	public int MaxSpeed = 1 ;
	
	public void startMove(CWayPoint next){
		state = STATE_MOVE;
		Active = true;
		Visible = true;
		
		NextWayPoint = next ;
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
	}
	boolean isEndMove(){
		return CCD.cdRectPoint(
				X - MaxSpeed, Y - MaxSpeed, 
				X + MaxSpeed, Y + MaxSpeed, 
				NextWayPoint.X , NextWayPoint.Y );
	}
	
	void onMove(){
		DirectX = NextWayPoint.X - X;
		DirectY = NextWayPoint.Y - Y;
	
		if(DirectX == 0 && DirectY == 0){
			setCurrentFrame(0, getCurrentFrame());
		}else if(DirectY < 0 ){
			setCurrentFrame(0, getCurrentFrame());
		}else if(DirectY > 0){
			setCurrentFrame(2, getCurrentFrame());
		}else if(DirectX < 0){
			setCurrentFrame(3, getCurrentFrame());
		}else if(DirectX > 0){
			setCurrentFrame(1, getCurrentFrame());
		}
		
		nextCycFrame();
		
		int dx = (DirectX==0 ? 0 : (DirectX>0 ? MaxSpeed : -MaxSpeed));
		int dy = (DirectY==0 ? 0 : (DirectY>0 ? MaxSpeed : -MaxSpeed));
		
		if(Math.abs(dx)>Math.abs(DirectX))dx = DirectX;
		if(Math.abs(dy)>Math.abs(DirectY))dy = DirectY;
		
		tryMove(dx, dy);

	}
	
	
//	------------------------------------------------------------------------------------
//	swing

}

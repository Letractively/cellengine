package game.unit;

import com.morefuntek.cell.CObject;
import com.morefuntek.cell.Game.AScreen;
import com.morefuntek.cell.Game.CCD;
import com.morefuntek.cell.Game.CSprite;
import com.morefuntek.cell.Game.CWayPoint;
import com.morefuntek.cell.Game.IState;

public class UnitEnemy extends CSprite implements IState  {

	final public int STATE_MOVE 	= 0;
	final public int STATE_HOLD 	= 1;
	final public int STATE_SWING	= 2;

	public int state = 0;
	
	//-------------------------------------------------------------------------------------------------
	
	
	public UnitEnemy(CSprite stuff, CWayPoint next){
		super(stuff);
		super.setState(this);
		NextWayPoint = next;
		setState(this);
	}
	
	
	public void update() {
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
		setCurrentFrame(0, 0);
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
		DirectX = NextWayPoint.X - X;
		DirectY = NextWayPoint.Y - Y;
	
		if(DirectX == 0 && DirectY == 0){
			setCurrentFrame(2, getCurrentFrame());
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
				X - MaxSpeed, Y - MaxSpeed, 
				X + MaxSpeed, Y + MaxSpeed, 
				NextWayPoint.X , NextWayPoint.Y , 
				NextWayPoint.X , NextWayPoint.Y );
	}
	
//	------------------------------------------------------------------------------------

	//patrol
	public int SwingTime = 100;

	public void onSwing(){
		SwingTime--;
		setCurrentFrame(AScreen.getTimer()%4, 0);
		
		
	}
	public void startSwing(){
		SwingTime = Math.abs(Random.nextInt()%200);
		state = STATE_SWING;
	}
	public boolean isEndSwing(){
		return SwingTime<0;
	}
}

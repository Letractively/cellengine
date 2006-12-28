package game.unit;

import com.morefuntek.cell.CObject;
import com.morefuntek.cell.Game.CCD;
import com.morefuntek.cell.Game.CSprite;
import com.morefuntek.cell.Game.CWayPoint;
import com.morefuntek.cell.Game.IEvent;
import com.morefuntek.cell.Game.IState;

public class UnitPatrol extends CObject implements IState , IEvent {

	final int STATE_PATROL	= 0;
	final int STATE_HOLD	= 0;
	
	int state = 0;
	
	CSprite spr ;
	CWayPoint next ;
	
	int MaxSpeed = 1 + Math.abs(Random.nextInt() % 4);

	public UnitPatrol(CSprite stuff, CWayPoint start){
		spr = stuff;
		spr.setState(this);
		
		next = start;
	}
	
	public void update() {
		onEvent();
		changeEvent();
	}

	public void changeEvent() {
		changePatrol();
	}

	public void onEvent() {
		onPatrol();
	}

//	----------------------------------------------------------------------------------------------------------------
	
	public void changePatrol(){
		if(CCD.cdRect(
				spr.X - MaxSpeed, spr.Y - MaxSpeed, 
				spr.X + MaxSpeed, spr.Y + MaxSpeed, 
				next.X , next.Y , 
				next.X , next.Y ) ){
			if(next.getNextCount()>0){
				int id = Math.abs(Random.nextInt()%next.getNextCount());
				
				if (next == next.getNextPoint(id) &&
					next.getNextCount()>1){
					next = next.getNextPoint((id+1)%next.getNextCount());
				}else{
					next = next.getNextPoint(id);
				}
				
				
			}
		}
	}
	public void onPatrol(){
		spr.DirectX = (next.X - spr.X);
		spr.DirectY = (next.Y - spr.Y);
		
		spr.DirectX = spr.DirectX == 0 ? 0 : spr.DirectX/Math.abs(spr.DirectX);
		spr.DirectY = spr.DirectY == 0 ? 0 : spr.DirectY/Math.abs(spr.DirectY);
		
		spr.X += spr.DirectX*MaxSpeed;
		spr.Y += spr.DirectY*MaxSpeed;
	
		if(spr.DirectY==0 && spr.DirectX==0){
			spr.setCurrentFrame(2, 0);
		}else if(spr.DirectY<0){
			spr.setCurrentFrame(0, spr.getCurrentFrame());
		}else if(spr.DirectY>0){
			spr.setCurrentFrame(2, spr.getCurrentFrame());
		}else if(spr.DirectX<0){
			spr.setCurrentFrame(3, spr.getCurrentFrame());
		}else if(spr.DirectX>0){
			spr.setCurrentFrame(1, spr.getCurrentFrame());
		}
		spr.nextCycFrame();
	}
	
	
	
}

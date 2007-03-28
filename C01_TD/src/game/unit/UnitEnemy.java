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
		
		Visible = true;
		Active  = false;
		
	}
	
	
	public void update() {
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
		case STATE_DEAD:
			if (!isEndDead()) {
				onDead();
			} else {
				state = -1;
			}
			break;
		}
		
	}
	
//	---------------------------------------------------------------------------------------
//	hold
	final public int STATE_HOLD 	= 0;
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
	final public int STATE_MOVE 	= 1;
	public CWayPoint NextWayPoint;
	private CWayPoint PrewWayPoint;
	public int MaxSpeed = 100 ;
	
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
		
		HPos256 = (X<<8);
		VPos256 = (Y<<8);
	}
	boolean isEndMove(){
		return X==NextWayPoint.X && Y==NextWayPoint.Y ;
	}
	
	void onMove(){
		DirectX = (NextWayPoint.X<<8) - HPos256;
		DirectY = (NextWayPoint.Y<<8) - VPos256;
	
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
		
		int dx = (DirectX==0 ? 0 : (DirectX>0 ? MaxSpeed : -MaxSpeed));
		int dy = (DirectY==0 ? 0 : (DirectY>0 ? MaxSpeed : -MaxSpeed));
		if(MaxSpeed>Math.abs(DirectX))dx = DirectX;
		if(MaxSpeed>Math.abs(DirectY))dy = DirectY;
		
		HPos256+=dx;
		VPos256+=dy;
		
		tryMove((HPos256>>8)-X, (VPos256>>8)-Y);
		
		nextCycFrame();
	}
	
	
//	------------------------------------------------------------------------------------
//	dead

//	---------------------------------------------------------------------------------------------------------
//	Íê½á×´Ì¬
	final public int STATE_DEAD	= 2;
	
	public void startDead(){
		state = STATE_DEAD;
//		EffectSpawn(EFFECT_ATTACK_ICE,X,Y,null);
		EffectSpawn(EFFECT_MONEY, X, Y, "+" + 100);
		println("Dead");
	}
	void onDead(){
	}
	boolean isEndDead(){
		Active = false;
		Visible = false;
		return true;
	}
	
	

}

package game.unit.battle;

import javax.microedition.lcdui.Graphics;

import com.morefuntek.cell.CMath;
import com.morefuntek.cell.Game.AScreen;
import com.morefuntek.cell.Game.CCD;
import com.morefuntek.cell.Game.CSprite;
import com.morefuntek.cell.Game.CWayPoint;
import com.morefuntek.cell.Game.IState;

public class UnitEnemy extends CSprite implements IState {

	final public int STATE_NONE			= -1;
	final public int STATE_MOVE 		= 0;
	final public int STATE_HOLD 		= 1;
	final public int STATE_SWING		= 2;

	
	final public int STATE_TERMINATE	= 4;
	
	public int state = 0;
	
	//-------------------------------------------------------------------------------------------------
	
	public UnitEnemy(CSprite stuff){
		super(stuff);
		setState(this);
	}
	
	
	public void update() {
		switch(state){
		case STATE_MOVE : 
			if(!isEndMove()){
				onMove();
				onFire();
			}else{
				startMove();
			}
			break;
		case STATE_HOLD : 
			if(!isEndHold()){
				onHold();
				onFire();
			}else{
				startMove();
			}
			break;
		case STATE_SWING : 
			if(!isEndSwing()){
				onSwing();
			}else{
				startMove();
			}
			break;
		default:
			startMove();
		}

		
	}
	
	
//---------------------------------------------------------------------------------------
//	¿ª»ð
	int ForzenTimeMax = 8 ;
	int ForzenTime	= 0;
	public void startFire(UnitBullet[] shots,CSprite target){
		if(ForzenTime>0)return;
		for(int i=0;i<shots.length;i++){
			if(shots[i].Active==false){
				shots[i].startSlug(X, Y, target.X+Random.nextInt()%32, target.Y+Random.nextInt()%32);
				break;
			}
		}
		
		for(int i=0;i<shots.length;i++){
			if(shots[i].Active==false){
				if( target.Active==true && 
					target.OnScreen==true){
					shots[i].startMissile(X,Y,target);
					break;
				}
			}
		}
		ForzenTime = ForzenTimeMax;
	}
	public void onFire(){
		ForzenTime--;
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
	public int MaxSpeed = 2/*+Math.abs(Random.nextInt()%4)*/;
	public void onMove(){
		DirectX = NextWayPoint.X - X;
		DirectY = NextWayPoint.Y - Y;
		
		int dx = (DirectX==0 ? 0 : (DirectX>0 ? MaxSpeed : -MaxSpeed));
		int dy = (DirectY==0 ? 0 : (DirectY>0 ? MaxSpeed : -MaxSpeed));
		
		if(Math.abs(dx)>Math.abs(DirectX))dx = DirectX;
		if(Math.abs(dy)>Math.abs(DirectY))dy = DirectY;
		
		X += dx ;
		Y += dy ;
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
		return X== NextWayPoint.X && Y==NextWayPoint.Y ;
	}
	
//	------------------------------------------------------------------------------------

	//patrol
	public int SwingTime = 20;

	public void onSwing(){
		SwingTime--;
	
		HPos256 -= CMath.sinTimes256(SwingTime*90)*4;
		VPos256 -= CMath.cosTimes256(SwingTime*90)*4;
		X = HPos256 / 256 ;
		Y = VPos256 / 256 ;
	}
	public void startSwing(){
		if(state!=STATE_SWING){
			SwingTime = 20;
			HPos256 = X * 256 ; 
			VPos256 = Y * 256 ; 
			state = STATE_SWING;
		}
	}
	public boolean isEndSwing(){
		return SwingTime<0;
	}
//	----------------------------------------------------------------------------------------------------

	
	
}

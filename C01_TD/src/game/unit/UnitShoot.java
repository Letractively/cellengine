package game.unit;

import javax.microedition.lcdui.Graphics;

import com.cell.*;
import com.cell.game.*;
import com.cell.game.ai.*;
import com.cell.particle.*;

public class UnitShoot extends Unit {
//	----------------------------------------------------------------------------------------------------
//	基本
	public boolean Penetrable = false;

	public UnitShoot(CSprite stuff){
		super(stuff);
		setState(this);
	
		
	}
	
	public void render(Graphics g, int x, int y) {
		super.render(g, x, y);
	}
	
	public void update(){
		// main state machine
		switch (state) {
		case STATE_MISSILE:
			if (!isEndMissile()) {
				onMissile();
			} else {
				startTerminate(X, Y);
			}
			break;
		case STATE_TERMINATE:
			if (!isEndTerminate()) {
				onTerminate();
			} else {
				startNone();
			}
			break;

		default:
			startNone();
		}	
			
	}


//	----------------------------------------------------------------------------------------------------
//	状态
	int state = -1;
	final public int STATE_NONE			= 	-1;
	public void startNone(){
		this.Active = false;
		this.Visible = false;
		state = STATE_NONE;
		Penetrable = false;
	}
	public boolean isEndNone(){
		return !Active;
	}
	public void onNone(){
	}
//	----------------------------------------------------------------------------------------------------

//	---------------------------------------------------------------------------------------------------------

//	---------------------------------------------------------------------------------------------------------

//	---------------------------------------------------------------------------------------------------------

//	---------------------------------------------------------------------------------------------------------
//	跟踪导弹
	final public int STATE_MISSILE		= 0;
	public CSprite MissileHandle		= null;
	public int MissileMaxSpeed			= 8;
	public void startMissile(int sx,int sy,CSprite handle){
		state = STATE_MISSILE;
		Active = true;
		Visible = true;
		
		MissileHandle = handle;
		
		SpeedX256 = 0; 
		SpeedY256 = 0;
		
		HPos256 = sx * 256 ; 
		VPos256 = sy * 256 ; 
		
		X = sx;
		Y = sy;
//		tryMove(sx-X, sy-Y);
		
		setCurrentFrame(STATE_MISSILE, 0);
	}
	public boolean isEndMissile(){
		return !MissileHandle.Active ||
		CSprite.touch_SprSub_SprSub(
				this, 
				0, 0, 
				MissileHandle,
				0, 0);
		;
	}
	public void onMissile(){

		int bx = Math.abs(MissileHandle.X - X)*256/MissileMaxSpeed;
		int by = Math.abs(MissileHandle.Y - Y)*256/MissileMaxSpeed;
		int d = Math.max(bx,by);
		
		if(d!=0){
			SpeedX256 = (MissileHandle.X - X) * 256 * 256 / d ;
			SpeedY256 = (MissileHandle.Y - Y) * 256 * 256 / d ;
		}
		
		HPos256 += SpeedX256 ; 
		VPos256 += SpeedY256 ; 
		
		int dx = HPos256/256;
		int dy = VPos256/256;
		
		X = dx;
		Y = dy;
		
//		tryMove(dx-X, dy-Y);
		
		nextCycFrame();
	}
//	---------------------------------------------------------------------------------------------------------

//	---------------------------------------------------------------------------------------------------------
//	完结状态
	final public int STATE_TERMINATE	= 1;
	public void startTerminate(int sx,int sy){
		state = STATE_TERMINATE;
		Active = true;
		Visible = true;
		
		X = sx;
		Y = sy;
//		tryMove(sx-X, sy-Y);
		
		setCurrentFrame(STATE_TERMINATE, 0);
	}
	public void onTerminate(){
		
	}
	public boolean isEndTerminate(){
		return nextFrame() || !OnScreen;
	}
	
	

	
	
}

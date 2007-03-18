package game.unit;

import javax.microedition.lcdui.Graphics;

import com.cell.*;
import com.cell.game.*;
import com.cell.game.ai.*;
import com.cell.particle.*;

public class UnitShoot extends Unit {
//	----------------------------------------------------------------------------------------------------
//	基本
	static final public int TYPE_NONE			= -1;
	
	static final public int TYPE00_ARROW		= 0;//
	static final public int TYPE01_ARROW		= 1;
	static final public int TYPE02_ARROW		= 2;
	static final public int TYPE03_ARROW		= 3;
	
	static final public int TYPE11_ICE			= 4;
	static final public int TYPE12_ICE			= 5;
	static final public int TYPE13_ICE			= 6;
	
	static final public int TYPE21_FIRE		= 7;
	static final public int TYPE22_FIRE		= 8;
	static final public int TYPE23_FIRE		= 9;
	
	static final public int TYPE30_ARROW		= 10;//
	static final public int TYPE31_ARROW		= 11;
	static final public int TYPE32_ARROW		= 12;
	static final public int TYPE33_ARROW		= 13;
	
	static final public int TYPE41_ICE			= 14;
	static final public int TYPE42_ICE			= 15;
	static final public int TYPE43_ICE			= 16;
	
	static final public int TYPE51_FIRE		= 17;
	static final public int TYPE52_FIRE		= 18;
	static final public int TYPE53_FIRE		= 19;
	
	/**类型*/
	private int TYPE = 0;
	
	
	public boolean Penetrable = false;
	
	
	public UnitShoot(CSprite stuff){
		super(stuff);
		setState(this);
		Priority = 1024;
	}
	public void render(Graphics g, int x, int y) {
		super.render(g, x, y);
	}
	public void unitUpdate(){
		// main state machine
		switch (state) {
		case STATE_MISSILE:
			if (!isEndMissile()) {
				EffectSpawn(EFFECT_TAIL_FIRE,X,Y);
				onMissile();
			} else {
				startTerminate(X, Y);
			}
			break;
		case STATE_SLUG:
			if (!isEndSlug()) {
				EffectSpawn(EFFECT_TAIL_FIRE,X,Y);
				onSlug();
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
	boolean isEndNone(){
		return !Active;
	}
	void onNone(){
	}
//	----------------------------------------------------------------------------------------------------
//	---------------------------------------------------------------------------------------------------------
//	---------------------------------------------------------------------------------------------------------
//	---------------------------------------------------------------------------------------------------------
//	----------------------------------------------------------------------------------------------------
//	多重攻击
	final public int STATE_SLUG			= 1;
	int SlugX;
	int SlugY;
	int SlugMaxSpeed = 2;
	public void startDst(int sx,int sy,int dx,int dy,int type){
		state = STATE_MISSILE;
		Active = true;
		Visible = true;
		
		SlugX = dx;
		SlugY = dy;
		
		SpeedX256 = 0; 
		SpeedY256 = 0;
		
		HPos256 = sx * 256 ; 
		VPos256 = sy * 256 ; 
		
		X = sx;
		Y = sy;
		
		setCurrentFrame(type, 0);
	}
	boolean isEndSlug(){
		return CCD.cdRectPoint(
				SlugX-SlugMaxSpeed, 
				SlugY-SlugMaxSpeed,
				SlugX+SlugMaxSpeed, 
				SlugY+SlugMaxSpeed,
				X, Y);
	}
	void onSlug(){
		int dx = SlugX - X;
		int dy = SlugY - Y;
		int bx = Math.abs(dx)*256/SlugMaxSpeed;
		int by = Math.abs(dy)*256/SlugMaxSpeed;
		int d = Math.max(bx,by);
		
		if(d!=0){
			SpeedX256 =  dx * 256 * 256 / d ;
			SpeedY256 =  dy * 256 * 256 / d ;
		}
		
		if(Math.abs(dx)>SlugMaxSpeed){
			HPos256 += SpeedX256 ; 
			X = HPos256/256;
		}else{
			X = SlugX;
		}
		if(Math.abs(dy)>SlugMaxSpeed){
			VPos256 += SpeedY256 ; 
			Y = VPos256/256;
		}else{
			Y = SlugY;
		}
		
//		tryMove(dx-X, dy-Y);
		
		nextCycFrame();
		
	}
//	---------------------------------------------------------------------------------------------------------
//	单体攻击
	final public int STATE_MISSILE		= 2;
	CSprite MissileHandle				= null;
	int MissileMaxSpeed					= 2;
	public void startMissile(int sx,int sy,CSprite handle,int type){
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
		
		setCurrentFrame(type, 0);
	}
	boolean isEndMissile(){
		return !MissileHandle.Active || 
			CCD.cdRectPoint(
					MissileHandle.X-MissileMaxSpeed, 
					MissileHandle.Y-MissileMaxSpeed,
					MissileHandle.X+MissileMaxSpeed, 
					MissileHandle.Y+MissileMaxSpeed,
					X, Y);
	}
	void onMissile(){
		int dx = MissileHandle.X - X;
		int dy = MissileHandle.Y - Y;
		int bx = Math.abs(dx)*256/MissileMaxSpeed;
		int by = Math.abs(dy)*256/MissileMaxSpeed;
		int d = Math.max(bx,by);
		
		if(d!=0){
			SpeedX256 = dx * 256 * 256 / d ;
			SpeedY256 = dy * 256 * 256 / d ;
		}
		
		if(Math.abs(dx)>MissileMaxSpeed){
			HPos256 += SpeedX256 ; 
			X = HPos256/256;
		}else{
			X = MissileHandle.X;
		}
		
		if(Math.abs(dy)>MissileMaxSpeed){
			VPos256 += SpeedY256 ; 
			Y = VPos256/256;
		}else{
			Y = MissileHandle.Y;
		}
		
//		tryMove(dx-X, dy-Y);
		
		nextCycFrame();
	}
//	---------------------------------------------------------------------------------------------------------

//	---------------------------------------------------------------------------------------------------------
//	完结状态
	final public int STATE_TERMINATE	= 3;
	public void startTerminate(int sx,int sy){
		state = STATE_TERMINATE;
		Active = true;
		Visible = true;
		
		X = sx;
		Y = sy;
//		tryMove(sx-X, sy-Y);
		
		setCurrentFrame(STATE_TERMINATE, 0);
	}
	void onTerminate(){
		
	}
	boolean isEndTerminate(){
		return nextFrame() || !OnScreen;
	}
	
	

	
	
}

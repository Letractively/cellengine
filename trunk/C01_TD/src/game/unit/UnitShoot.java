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
	
	/*TODO 子弹列表，对应编辑器Shoots*/
	static final public int TYPE00_ARROW		= 0;//
	static final public int TYPE01_ARROW		= 1;
	static final public int TYPE02_ARROW		= 2;
	static final public int TYPE03_ARROW		= 3;
	
	static final public int TYPE11_ICE			= 4;
	static final public int TYPE12_ICE			= 5;
	static final public int TYPE13_ICE			= 6;
	
	static final public int TYPE21_FIRE			= 7;
	static final public int TYPE22_FIRE			= 8;
	static final public int TYPE23_FIRE			= 9;
	
	static final public int TYPE30_ARROW		= 10;//
	static final public int TYPE31_ARROW		= 11;
	static final public int TYPE32_ARROW		= 12;
	static final public int TYPE33_ARROW		= 13;
	
	static final public int TYPE41_ICE			= 14;
	static final public int TYPE42_ICE			= 15;
	static final public int TYPE43_ICE			= 16;
	
	static final public int TYPE51_FIRE			= 17;
	static final public int TYPE52_FIRE			= 18;
	static final public int TYPE53_FIRE			= 19;
	
	/**类型*/
	private int TYPE = 0;
	private int state = -1;
	
	public boolean Penetrable = false;
	

	

	public UnitShoot(CSprite stuff){
		super(stuff);
		setState(this);
		Priority = 1024;
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
		case STATE_SLUG:
			if (!isEndSlug()) {
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
	
	public void startFire(int type,int sx,int sy,Unit target){
		switch(type){
		case TYPE00_ARROW:
		case TYPE01_ARROW:
		case TYPE02_ARROW:
		case TYPE03_ARROW:
		
		case TYPE11_ICE:
		case TYPE12_ICE:
		case TYPE13_ICE:
		
		case TYPE21_FIRE:
		case TYPE22_FIRE:
		case TYPE23_FIRE:
			startMissile(sx,sy,target,type);
			break;
			
		case TYPE30_ARROW:
		case TYPE31_ARROW:
		case TYPE32_ARROW:
		case TYPE33_ARROW:
		
		case TYPE41_ICE:
		case TYPE42_ICE:
		case TYPE43_ICE:
		
		case TYPE51_FIRE:
		case TYPE52_FIRE:
		case TYPE53_FIRE:
			startDst(sx, sy, target.X, target.Y, type);
			break;
		}
		
	}
	


//	----------------------------------------------------------------------------------------------------
//	状态
	
	
	final public int STATE_NONE			= 	-1;
	void startNone(){
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
	int SlugMaxSpeed = 4;
	void startDst(int sx,int sy,int dx,int dy,int type){
		state = STATE_SLUG;
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
		if( CCD.cdRectPoint(
				SlugX-SlugMaxSpeed, 
				SlugY-SlugMaxSpeed,
				SlugX+SlugMaxSpeed, 
				SlugY+SlugMaxSpeed,
				X, Y))
		{
			return true;
		}
		return false;
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
		EffectSpawn(EFFECT_TAIL_SWORD,X,Y,null);
		nextCycFrame();
		
	}
//	---------------------------------------------------------------------------------------------------------
//	单体攻击
	final public int STATE_MISSILE		= 2;
	Unit MissileTarget					= null;
	int MissileMaxSpeed					= 4;
	void startMissile(int sx,int sy,Unit target,int type){
		state = STATE_MISSILE;
		Active = true;
		Visible = true;
		
		MissileTarget = target;
		
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
		if( MissileTarget==null || !MissileTarget.Active )
			return true;
		if(CCD.cdRectPoint(
					MissileTarget.X-MissileMaxSpeed, 
					MissileTarget.Y-MissileMaxSpeed,
					MissileTarget.X+MissileMaxSpeed, 
					MissileTarget.Y+MissileMaxSpeed,
					X, Y))
		{
			MissileTarget.HP -= HP;
			return true;
		}
		return false;
	}
	void onMissile(){
		int dx = MissileTarget.X - X;
		int dy = MissileTarget.Y - Y;
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
			X = MissileTarget.X;
		}
		
		if(Math.abs(dy)>MissileMaxSpeed){
			VPos256 += SpeedY256 ; 
			Y = VPos256/256;
		}else{
			Y = MissileTarget.Y;
		}
		
//		tryMove(dx-X, dy-Y);
		EffectSpawn(EFFECT_TAIL_FIRE,X,Y,null);
		nextCycFrame();
	}
//	---------------------------------------------------------------------------------------------------------

//	---------------------------------------------------------------------------------------------------------
//	完结状态
	final public int STATE_TERMINATE	= 3;
	void startTerminate(int sx,int sy){
		state = STATE_TERMINATE;
		Active = true;
		Visible = true;
		
		X = sx;
		Y = sy;
//		tryMove(sx-X, sy-Y);
		EffectSpawn(EFFECT_ATTACK_FIRE,X,Y,null);
		setCurrentFrame(STATE_TERMINATE, 0);
	}
	void onTerminate(){
		
	}
	boolean isEndTerminate(){
		return nextFrame() || !OnScreen;
	}
	
	

	
	
}

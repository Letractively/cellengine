/**
 * 
 */
package game.unit.battle;

import javax.microedition.lcdui.Graphics;

import com.cell.*;
import com.cell.game.*;

/**
 * @author yifeizhang
 *
 */
public class UnitBattleBullet extends CSprite implements IState{

//	----------------------------------------------------------------------------------------	
	
	final static public int TYPE_NONE		= -1;
	final static public int TYPE_MISSILE1	= 0 ;
	final static public int TYPE_MISSILE2	= 8 ;
	final static public int TYPE_LASER		= 16;
	final static public int TYPE_BOMB		= 17;
	final static public int TYPE_SLUG1		= 18;
	final static public int TYPE_SLUG2		= 22;
	final static public int TYPE_LIGHT1		= 19;
	final static public int TYPE_LIGHT2		= 23;
	final static public int TYPE_BOMBEXP	= 20;
	final static public int TYPE_ROCKET		= 24;
	
	final static public int TYPE_BASE		= 18;
	
	private int Type = 0;
	private int HP = 10;
	
	public boolean Penetrable 	= false;
	
	
	public UnitBattleBullet(CSprite spr) {
		super(spr);setState(this);
		startNone();
		
	    HP = getHP();
	}


	public void update() {
		// main state machine
		if(Active){
			switch (Type) {
			case TYPE_MISSILE1:
			case TYPE_MISSILE2:
				if (!isEndMissile()) {
					onMissile();
				} else {
					startNone();
				}
				break;
			case TYPE_LASER:
				if (!isEndLight()) {
					onLight();
				} else {
					startNone();
				}
				break;
			case TYPE_BOMB:
				if (!isEndBomb()) {
					onBomb();
				} else {
					startNone();
				}
				break;
//			case TYPE_BASE:
			case TYPE_SLUG1:
			case TYPE_SLUG2:
			case TYPE_LIGHT1:
			case TYPE_LIGHT2:
				if (!isEndSlug()) {
					onSlug();
				} else {
					startNone();
				}
				break;
			case TYPE_ROCKET:
			case TYPE_BOMBEXP:
				if (!isEndRocket()) {
					onRocket();
				} else {
					startNone();
				}
				break;
			
			default:
				startNone();
			}	
		}
		
	}
	
	public void render(Graphics g, int x, int y) {
		super.render(g, x, y);
	}
	
	public int getType(){
		return Type;
	}
	
	public int getForzenTime(){
		switch (Type) {
		case TYPE_MISSILE1:
		case TYPE_MISSILE2:
			return 40;
		case TYPE_LASER:
			return getFrameCount(TYPE_LASER) * 2;
		case TYPE_BOMB:
		case TYPE_BOMBEXP:
			return 20;
		case TYPE_SLUG1:
		case TYPE_SLUG2:
			return 8;
		case TYPE_LIGHT1:
		case TYPE_LIGHT2:
			return 4;
		case TYPE_ROCKET:
			return 20;
		default:
			return 30;
		}
	}
	
	public int getPrice(){
		switch (Type) {
		case TYPE_MISSILE1:
		case TYPE_MISSILE2:
		case TYPE_LASER:
		case TYPE_BOMB:
		case TYPE_BOMBEXP:
		case TYPE_SLUG1:
		case TYPE_SLUG2:
		case TYPE_LIGHT1:
		case TYPE_LIGHT2:
		case TYPE_ROCKET:
			
		}
		return 100;
	}
	
	public int getHP(){
		switch (Type) {
		case TYPE_MISSILE1:
			return 20;
		case TYPE_MISSILE2:
			return 10;
		case TYPE_LASER:
			return 8;
		case TYPE_BOMB:
			return 100;
		case TYPE_BOMBEXP:
			return 100;
		case TYPE_SLUG1:
			return 4;
		case TYPE_SLUG2:
			return 2;
		case TYPE_LIGHT1:
		case TYPE_LIGHT2:
			return 8;
		case TYPE_ROCKET:
			return 50;
		default:
			return 10;
		}
	}
	
	
	public void fire(
			int type,
			CSprite handle,
			CSprite target,
			int sx,int sy,
			int dx,int dy,
			int speed,
			int time
			){
		
		Type = type;
		
		switch (getType()) {
		case UnitBattleBullet.TYPE_MISSILE1:
		case UnitBattleBullet.TYPE_MISSILE2:
			startMissile(sx,sy,target,time);
			break;
		case UnitBattleBullet.TYPE_LASER:
			startLight(handle);
			break;
		case UnitBattleBullet.TYPE_BOMB:
			startBomb(sx,sy, 0, 0);
			break;
		case UnitBattleBullet.TYPE_SLUG1:
		case UnitBattleBullet.TYPE_SLUG2:
			startSlug(sx,sy, dx, dy,speed);
			break;
		case UnitBattleBullet.TYPE_LIGHT1:
		case UnitBattleBullet.TYPE_LIGHT2:
			startSlug(sx,sy, dx, dy,speed);
			break;
		case UnitBattleBullet.TYPE_ROCKET:
		case UnitBattleBullet.TYPE_BOMBEXP:
			startRocket(sx,sy, dx);
			break;
		}	
	}
	
//	public void fire(
//			int type,
//			CSprite   handle,
//			CSprite[] targets,
//			int sx,int sy,
//			int dx,int dy,
//			int speed,
//			int time
//			){
//		
//		Type = type;
//		
//		switch (getType()) {
//		
//		case UnitBattleBullet.TYPE_MISSILE1:
//		case UnitBattleBullet.TYPE_MISSILE2:
//			CSprite target = null;
//			int start = Math.abs(Random.nextInt()%targets.length);
//			for(int j=0;j<targets.length;j++){
//				int id = (j + start) % targets.length;  
//				if( targets[id].Active==true && 
//					targets[id].OnScreen==true){
//					target = targets[id];
//					break;
//				}
//			}
//			startMissile(sx,sy,target,time);
//			break;
//		case UnitBattleBullet.TYPE_LASER:
//			startLight(handle);
//			break;
//		case UnitBattleBullet.TYPE_BOMB:
//			startBomb(sx,sy, 0, 0);
//			break;
//		case UnitBattleBullet.TYPE_SLUG1:
//		case UnitBattleBullet.TYPE_SLUG2:
//			startSlug(sx,sy, dx, dy,speed);
//			break;
//		case UnitBattleBullet.TYPE_LIGHT1:
//		case UnitBattleBullet.TYPE_LIGHT2:
//			startSlug(sx,sy, dx, dy,speed);
//			break;
//		case UnitBattleBullet.TYPE_ROCKET:
//		case UnitBattleBullet.TYPE_BOMBEXP:
//			startRocket(sx,sy, dx);
//			break;
//		}	
//	}
	
	
	
//	----------------------------------------------------------------------------------------------------
//	空状态
	public void startNone(){
		Active = false;
		Visible = false;
		Penetrable = false;
	}
//	完结状态
	public void startTerminate(CSprite target){
		switch (Type) {
		case TYPE_MISSILE1:
		case TYPE_MISSILE2:
			BattleManager.spawn(1,BattleManager.EFFECT_MISSILE,X, Y);
			break;
		case TYPE_LASER:
			BattleManager.spawn(1,BattleManager.EFFECT_LASER,
					target.X + Random.nextInt()%4, 
					target.Y + (Y-target.Y)/2 );
			break;
		case TYPE_BOMB:
		case TYPE_BOMBEXP:
			BattleManager.spawn(1,BattleManager.EFFECT_EXP,X, Y);
			break;
		case TYPE_SLUG1:
		case TYPE_SLUG2:
			BattleManager.spawn(1,BattleManager.EFFECT_SLUG,X, Y);
			break;
		case TYPE_LIGHT1:
		case TYPE_LIGHT2:
			BattleManager.spawn(1,BattleManager.EFFECT_LIGHT,X, Y);
			break;
		case TYPE_ROCKET:
			BattleManager.spawn(1,BattleManager.EFFECT_ALL,X, Y);
			break;
		}
		
		if(!Penetrable){
			Active = false;
			Visible = false;
		}
	}
	
//	----------------------------------------------------------------------------------------------------
//	Missile 1
	CSprite MissileHandle		= null;
	int MissileMaxSpeed			= 4;
	int MissileAngle	=	0;
	int MissileTime		= 30;
	private void startMissile(int sx,int sy,CSprite handle, int time){
		Active = true;
		Visible = true;
		OnScreen = true;
		
		if(handle!=null){
			MissileHandle = handle;
			MissileTime   = time;
			SpeedX256 = 0; 
			SpeedY256 = 0;
		}else{
			MissileHandle = null;
			MissileTime   = -1;
			SpeedX256 = 4 * 256; 
			SpeedY256 = 0;
		}
		
		X = sx;
		Y = sy;
		HPos256 = X * 256 ; 
		VPos256 = Y * 256 ; 
		
		setCurrentFrame(Type, 0);
		
//		println("start Missile : " + Type);
	}
	boolean isEndMissile(){
		return !OnScreen ;
		
	}
	void onMissile(){
		MissileTime--;
		
		if(	SpeedX256 == 0 && SpeedY256 == 0 ){
			SpeedX256 = 4 * 256; 
			SpeedY256 = 0;
		}
		
		if(MissileHandle!=null && MissileHandle.Active && MissileTime>0){
			int dx = MissileHandle.X - X;
			int dy = MissileHandle.Y - Y;
				
			int bx = Math.abs(dx)*256/MissileMaxSpeed;
			int by = Math.abs(dy)*256/MissileMaxSpeed;
			int d = Math.max(bx,by);
			
			if(d!=0){
				SpeedX256 = (dx) * 256 * 256 / d ;
				SpeedY256 = (dy) * 256 * 256 / d ;
			}
		}

		HPos256 += SpeedX256 ; 
		VPos256 += SpeedY256 ; 
		X = HPos256/256;
		Y = VPos256/256;
		
		MissileAngle = CMath.cycNum(360,-CMath.atan2(-SpeedY256, SpeedX256)+22,360);
		int direct = CMath.cycNum(MissileAngle/45, 0, 8);
		setCurrentFrame(Type + direct, CurFrame);

		BattleManager.smokeSpeed = 8;
		switch(direct){
		case 0:BattleManager.spawn(1,BattleManager.EFFECT_SMOKE_L,X, Y);break;
		case 1:BattleManager.spawn(1,BattleManager.EFFECT_SMOKE_TL,X, Y);break;
		case 2:BattleManager.spawn(1,BattleManager.EFFECT_SMOKE_T,X, Y);break;
		case 3:BattleManager.spawn(1,BattleManager.EFFECT_SMOKE_TR,X, Y);break;
		case 4:BattleManager.spawn(1,BattleManager.EFFECT_SMOKE_R,X, Y);break;
		case 5:BattleManager.spawn(1,BattleManager.EFFECT_SMOKE_BR,X, Y);break;
		case 6:BattleManager.spawn(1,BattleManager.EFFECT_SMOKE_B,X, Y);break;
		case 7:BattleManager.spawn(1,BattleManager.EFFECT_SMOKE_BL,X, Y);break;
		}	

		nextCycFrame();
		
//		println("run Missile 1 : " + Type + " : "+ X + " : " + Y);
	}

//	----------------------------------------------------------------------------------------------------
//	向目标点发射的飞行物
	int SlugMaxSpeed		= 	8;
	private void startSlug(int sx,int sy,int dx,int dy,int speed){
		Active = true;
		Visible = true;
		OnScreen = true;
		SlugMaxSpeed = speed;
		X = sx;
		Y = sy;
		HPos256 = X * 256 ; 
		VPos256 = Y * 256 ; 
		int bx = Math.abs(dx - X)*256/SlugMaxSpeed;
		int by = Math.abs(dy - Y)*256/SlugMaxSpeed;
		int d = Math.max(bx,by);
		if(d!=0){
			SpeedX256 = (dx - X) * 256 * 256 / d ;
			SpeedY256 = (dy - Y) * 256 * 256 / d ;
		}
		setCurrentFrame(Type, 0);
		
//		println("start Slug : " + Type);
	}
	boolean isEndSlug(){
		return !OnScreen;
	}
	void onSlug(){
		HPos256 += SpeedX256 ; 
		VPos256 += SpeedY256 ; 
		X = HPos256/256;
		Y = VPos256/256;
//		Visible = !Visible;
		nextCycFrame();
	}
//	---------------------------------------------------------------------------------------------------------
//	光线攻击	
	public CSprite LightHandle			= 	null;
	private void startLight(CSprite handle){
		Penetrable = true;
		Active = true;
		Visible = true;
		OnScreen = true;
		LightHandle = handle;
	
		setCurrentFrame(Type, 0);
		
//		println("start Light : " + Type);
	}
	boolean isEndLight(){
		return nextFrame() || !LightHandle.Active;
	}
	void onLight(){
		X = LightHandle.X;
		Y = LightHandle.Y;
	}
//	---------------------------------------------------------------------------------------------------------
//	受重力影响的炸弹	
	public int BombGravity				= 100;
	private void startBomb(int sx,int sy,int speedX,int speedY){
		Active = true;
		Visible = true;
		OnScreen = true;
		X = sx;
		Y = sy;
		HPos256 = X * 256 ; 
		VPos256 = Y * 256 ; 
		
		SpeedX256 = speedX; 
		SpeedY256 = speedY;
			
		setCurrentFrame(Type, 0);
		
//		println("start Bomb : " + Type);
	}
	boolean isEndBomb(){
		return !OnScreen;
	}
	void onBomb(){
		SpeedY256 += BombGravity;
		
		HPos256 += SpeedX256 ; 
		VPos256 += SpeedY256 ; 
		X = HPos256/256;
		Y = VPos256/256;
		
		nextCycFrame();
	}
//	---------------------------------------------------------------------------------------------------------
//	有加速度的导弹
	public int RocketAcc				= 256;
	public int RocketDirect				= 1;
	
	
	private void startRocket(int sx,int sy,int direct){
		Active = true;
		Visible = true;
		OnScreen = true;
		RocketDirect = direct;
		
		SpeedX256 = -RocketAcc*6; 
		SpeedY256 = 0;
		
		X = sx;
		Y = sy;
		HPos256 = X * 256 ; 
		VPos256 = Y * 256 ; 
		
		setCurrentFrame(Type, 0);
		
//		println("start Rocket : " + Type);
	}
	boolean isEndRocket(){
		return !OnScreen;
	}
	void onRocket(){
		BattleManager.smokeSpeed = 128;
		BattleManager.spawn(1,BattleManager.EFFECT_SMOKE_L,X, Y);
		SpeedX256 += RocketDirect * RocketAcc;
		HPos256 += SpeedX256 ; 
		

		X = HPos256/256;
		Y = VPos256/256;
		
		nextCycFrame();
	}

//	---------------------------------------------------------------------------------------------------------
//	黑洞
	public int CollapsarMaxTime			= 200;
	public int CollapsarTime			= 100;
	private void startCollapsar(int sx,int sy){
		Penetrable = true;
		Active = true;
		Visible = true;
		OnScreen = true;
		CollapsarTime = CollapsarMaxTime;
		
		X = sx;
		Y = sy;
		HPos256 = X * 256 ; 
		VPos256 = Y * 256 ; 

		setCurrentFrame(0, 0);
		
//		println("start Collapsar : " + Type);
	}
	boolean isEndCollapsar(){
		return CollapsarTime<0;
	}
	void onCollapsar(){
		CollapsarTime--;
		
//		BattleManager.spawn(1,PARTICLE_CONTRACT,X, Y);
		
		nextCycFrame();
	}
	
//	---------------------------------------------------------------------------------------------------------

}

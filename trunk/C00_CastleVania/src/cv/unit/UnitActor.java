package cv.unit;

import com.morefuntek.cell.Game.AScreen;
import com.morefuntek.cell.Game.CAnimates;
import com.morefuntek.cell.Game.CCollides;
import com.morefuntek.cell.Game.CSprite;
import com.morefuntek.cell.Game.IState;

public class UnitActor extends CSprite implements IState {

	final public static int STATE_STAND		= 0;
	final public static int STATE_WALK		= 2;
	final public static int STATE_JUMP		= 2;
	
	int state = 0;
	
	public UnitActor(CSprite spr) {
		super(spr);
		setState(this);
		haveSprBlock = false;
		haveMapBlock = true;
		
		
	}

	public void update() {
		switch(state){
		case STATE_STAND:
			if(!isEndStand()){
				onStand();
			}else{
				startStand();
			}
			break;
		default:
			startStand();
		}
		
		
		onControl();
	}

//	-----------------------------------------------------------------------------------------
	
	public static int Gravity = 200;
	
	public static int WalkV 			=  3*256;
	public static int JumpV 			= -12*256;
	public static int JumpHoldTime 		= 0;
	public static int JumpHoldTimeMAX 	= 10;
	
	public void onControl(){
		
		SpeedX256 = 0;
		SpeedY256 += Gravity;
		
		if(AScreen.isKeyHold(AScreen.KEY_LEFT)){
			SpeedX256 = -WalkV;
			move(SpeedX256/256,0);
		}
		if(AScreen.isKeyHold(AScreen.KEY_RIGHT)){
			SpeedX256 =  WalkV;
			move(SpeedX256/256,0);
		}
		if(AScreen.isKeyDown(AScreen.KEY_UP)){
			if(isLand()){
				SpeedY256 = JumpV;
			}
		}
		
		if(move(0,SpeedY256/256)){
			SpeedY256 = 0;
		}
		
		
	}

	
	public boolean move(int x,int y){
		
		if(x==0 && y==0)return false;
		
		X+=x;
		Y+=y;
		
		boolean ret = false;
		
		if(this.haveMapBlock){
			int prewAnimate = CurAnimate;
			int prewFrame   = CurFrame;
			setCurrentFrame(0, 0);
			boolean adjustMap = false;
			
			int dstX = X + x;
			int dstY = Y + y;
			int dx = (x!=0?(x<0?-1:1):0);
			int dy = (y!=0?(y<0?-1:1):0);
			
			if(SpeedY256<0){
				collides.getCD(1).Mask = 0x0000;
//				collides.getCD(2).Mask = 0x0000;
			}else {
				collides.getCD(1).Mask = 0x0002;
//				collides.getCD(2).Mask = 0xffff;
			}
			
			collides.getCD(0).Mask = 0xffff;
			adjustMap = touch_SprSub_Map(this, 
					CD_TYPE_MAP,0,
					this.world.Map);
			collides.getCD(0).Mask = 0xffff - 0x02;

			if(adjustMap){
				X-=x;
				Y-=y;
				while(X!=dstX){
					X+=dx;
					if(touch_Spr_Map(
							this,
							CD_TYPE_MAP,
							this.world.Map)){
						X-=dx;
						ret = true;
						break;
					}
				}
				while(Y!=dstY){
					Y+=dy;
					if(touch_Spr_Map(
							this,
							CD_TYPE_MAP,
							this.world.Map)){
						Y-=dy;
						ret = true;
						break;
					}
				}
			}
			setCurrentFrame(prewAnimate, prewFrame);
		}
		
		return ret;
	}
	
	public boolean isLand(){
		int prewAnimate = CurAnimate;
		int prewFrame   = CurFrame;
		setCurrentFrame(0, 0);

		boolean flag = CSprite.touch_SprSub_Map(
				this, 
				CD_TYPE_EXT, 0, 
				world.getMap()
				);
		
		setCurrentFrame(prewAnimate, prewFrame);
		return flag;
	}
	
	
	
//	-------------------------------------------------------------------------------------------
	public void startStand(){
		
	}
	
	public void onStand(){
		nextCycFrame();
	}
	
	public boolean isEndStand(){
		return false;
	}
//	-------------------------------------------------------------------------------------------

	
}

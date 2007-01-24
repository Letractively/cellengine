package cv.unit;

import javax.microedition.lcdui.Graphics;

import com.morefuntek.cell.IImages;
import com.morefuntek.cell.Game.AScreen;
import com.morefuntek.cell.Game.CAnimates;
import com.morefuntek.cell.Game.CCollides;
import com.morefuntek.cell.Game.CSprite;
import com.morefuntek.cell.Game.IState;

public class UnitActor extends CSprite  {

	public UnitActor(CSprite spr) {
		super(spr);
		haveSprBlock = false;
		haveMapBlock = true;
		
		
	}

	public void update() {
		onControl();
		onAction();
	}

	
	
	public void render(Graphics g, int x, int y) {
		super.render(g, x, y);
		if(IsDebug)
		super.collides.render(g, 0, x, y, 0xffff0000);
	}



	//	-----------------------------------------------------------------------------------------
	final static int STATE_STANDING			= 0;
	final static int STATE_JUMP_UP			= 1;
	final static int STATE_JUMP_UPR			= 2;
	final static int STATE_JUMP_DOWN	  	= 3;
	final static int STATE_JUMP_STAND  		= 4;
	final static int STATE_WALKING			= 5;
	final static int STATE_STAND_WALK		= 6;
	final static int STATE_WALK_STAND		= 7;
	
	int state = 0;
	
	void onAction(){
		
		switch(state){
		case STATE_STANDING:
			nextCycFrame();
			break;
		case STATE_JUMP_UP:
			nextCycFrame();
			break;
		case STATE_JUMP_UPR:
			nextCycFrame();
			break;
		case STATE_JUMP_DOWN:
			nextCycFrame(getFrameCount(CurAnimate)-2);
			break;
		case STATE_JUMP_STAND:
			if(nextFrame()){
				state = STATE_STANDING;
				setCurrentFrame(state, 0);
			}
			break;
		case STATE_WALKING:
			nextCycFrame();
			break;
		case STATE_STAND_WALK:
			if(nextFrame()){
				state = STATE_WALKING;
				setCurrentFrame(state, 0);
			}
			break;
		case STATE_WALK_STAND:
			if(nextFrame()){
				state = STATE_STANDING;
				setCurrentFrame(state, 0);
			}
			break;
		}
		
		
		
		
	}
	
//	-----------------------------------------------------------------------------------------

	public static int Gravity 			= 200;
	public static int WalkV 			=  3*256;
	public static int JumpV 			= -12*256;
	public static int JumpHoldTime 		= 0;
	public static int JumpHoldTimeMAX 	= 10;
	
	
	void onControl(){
		
		// init data
		boolean isLand = isLand();
		SpeedX256 = 0;
		if(!isLand){
			SpeedY256 += Gravity;
		}else{
			if(SpeedY256>0){
				state = STATE_JUMP_STAND;
				setCurrentFrame(state, 0);
			}
			SpeedY256 = 0;
		}
		
		
		// user input
		if(AScreen.isKeyUp(AScreen.KEY_LEFT)){
			state = STATE_WALK_STAND;
			setCurrentFrame(state, 0);
		}
		if(AScreen.isKeyUp(AScreen.KEY_RIGHT)){
			state = STATE_WALK_STAND;
			setCurrentFrame(state, 0);
		}
		if(AScreen.isKeyDown(AScreen.KEY_LEFT)){
			if(Transform!=IImages.TRANS_H){
				transform(IImages.TRANS_H);
			}
			state = STATE_STAND_WALK;
			setCurrentFrame(state, 0);
		}
		if(AScreen.isKeyDown(AScreen.KEY_RIGHT)){
			if(Transform!=IImages.TRANS_NONE){
				transform(IImages.TRANS_H);
			}
			state = STATE_STAND_WALK;
			setCurrentFrame(state, 0);
		}
		if(AScreen.isKeyHold(AScreen.KEY_LEFT)){
			SpeedX256 = -WalkV;
		}
		if(AScreen.isKeyHold(AScreen.KEY_RIGHT)){
			SpeedX256 =  WalkV;
		}
		if(AScreen.isKeyDown(AScreen.KEY_UP)){
			if(isLand){
				SpeedY256 = JumpV;
			}
		}
		
		// physices
		if(SpeedY256<0){
			collides.getCD(1).Mask = 0x0000;
			collides.getCD(2).Mask = 0x0000;
		}else {
			collides.getCD(1).Mask = 0x0002;
			collides.getCD(2).Mask = 0xffff;
		}
		
		if(actMoveX(SpeedX256/256)){
		}
		if(actMoveY(SpeedY256/256)){
//			if(SpeedY256>0){
				if(SpeedX256==0){
					state = STATE_JUMP_STAND;
					setCurrentFrame(state, 0);
				}else{
					state = STATE_WALKING;
					setCurrentFrame(state, 0);
				}
//			}
			SpeedY256 = 0;
		}
		
		if(!isLand ){
			// jump up
			if(SpeedY256<0){
				if(SpeedX256!=0){
					state = STATE_JUMP_UPR;
					setCurrentFrame(state, CurFrame);
				}else{
					state = STATE_JUMP_UP;
					setCurrentFrame(state, CurFrame);
				}
			}
			// jump down
			if(SpeedY256>0){
				state = STATE_JUMP_DOWN;
				setCurrentFrame(state, CurFrame);
			}
		}
		
	}
	
	boolean actMoveY(int y){
		if(y==0)return false;
		int dstY = Y + y;
		int dy = (y!=0?(y<0?-1:1):0);
		Y+=y;
		boolean ret = false;
		
		if(this.haveMapBlock){
			int prewAnimate = CurAnimate;
			int prewFrame   = CurFrame;
			setCurrentFrame(0, 0);
			boolean adjustMap = false;
			
			collides.getCD(0).Mask = 0xffff;
			adjustMap = touch_SprSub_Map(this,CD_TYPE_MAP,0,this.world.Map);
			collides.getCD(0).Mask = 0xffff - 0x02;
			
			if(adjustMap){
				Y-=y;
				while(Y!=dstY){
					Y+=dy;
					if(touch_Spr_Map(this,CD_TYPE_MAP,this.world.Map)){
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
	
	boolean actMoveX(int x){
		if(x==0)return false;
		int dstX = X + x;
		int dx = (x!=0?(x<0?-1:1):0);
		X+=x;
		boolean ret = false;
		
		if(this.haveMapBlock){
			int prewAnimate = CurAnimate;
			int prewFrame   = CurFrame;
			setCurrentFrame(0, 0);
			boolean adjustMap = false;
			adjustMap = touch_SprSub_Map(this,CD_TYPE_MAP,0,this.world.Map);

			if(adjustMap){
				X-=x;
				while(X!=dstX){
					X+=dx;
					if(touch_SprSub_Map(this,CD_TYPE_MAP,0,this.world.Map)){
						X-=dx;
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

//	-------------------------------------------------------------------------------------------

	
}

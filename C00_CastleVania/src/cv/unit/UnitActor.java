package cv.unit;

import javax.microedition.lcdui.Graphics;

import com.cell.IImages;
import com.cell.game.AScreen;
import com.cell.game.CSprite;

public class UnitActor extends CSprite  {

	public UnitActor(CSprite spr) {
		super(spr);
		haveSprBlock = false;
		haveMapBlock = true;
		
		
	}

	public void update() {
		input();
		onAction();
		onState();
		onControl();
	}

	
	
	public void render(Graphics g, int x, int y) {
		super.render(g, x, y);
		if(IsDebug)
		super.collides.render(g, 0, x, y, 0xff00ff00);
	}
//	-----------------------------------------------------------------------------------------
	
	
	
	boolean turnR = false;
	boolean turnL = false;
	boolean turnU = false;
	boolean turnD = false;
	boolean turnAction = false;
	
	boolean onR = false;
	boolean onL = false;
	boolean onU = false;
	boolean onD = false;
	boolean onAction = false;
	
	boolean releaseR = false;
	boolean releaseL = false;
	boolean releaseU = false;
	boolean releaseD = false;
	boolean releaseAction = false;
	
	public void input(){
		turnL = AScreen.isKeyDown(AScreen.KEY_LEFT);
		turnR = AScreen.isKeyDown(AScreen.KEY_RIGHT);
		turnU = AScreen.isKeyDown(AScreen.KEY_UP);
		turnD = AScreen.isKeyDown(AScreen.KEY_DOWN);
		turnAction = AScreen.isKeyDown(AScreen.KEY_C);
		
		onL = AScreen.isKeyHold(AScreen.KEY_LEFT);
		onR = AScreen.isKeyHold(AScreen.KEY_RIGHT);
		onU = AScreen.isKeyHold(AScreen.KEY_UP);
		onD = AScreen.isKeyHold(AScreen.KEY_DOWN);
		onAction = AScreen.isKeyHold(AScreen.KEY_C);
		
		releaseL = AScreen.isKeyUp(AScreen.KEY_LEFT);
		releaseR = AScreen.isKeyUp(AScreen.KEY_RIGHT);
		releaseU = AScreen.isKeyUp(AScreen.KEY_UP);
		releaseD = AScreen.isKeyUp(AScreen.KEY_DOWN);
		releaseAction = AScreen.isKeyUp(AScreen.KEY_C);
	}
	
	public void onControl(){
		turnR = false;
		turnL = false;
		turnU = false;
		turnD = false;
		turnAction = false;
		
		onR = false;
		onL = false;
		onU = false;
		onD = false;
		onAction = false;
		
		releaseR = false;
		releaseL = false;
		releaseU = false;
		releaseD = false;
		releaseAction = false;
		
	}
	
	
//	-----------------------------------------------------------------------------------------
	final int STATE_STANDING		= 0;
	
	final int STATE_JUMP_UP			= 1;
	final int STATE_JUMP_UPR		= 2;
	final int STATE_JUMP_DOWN	  	= 3;
	final int STATE_JUMP_STAND  	= 4;
	
	final int STATE_WALKING			= 5;
	final int STATE_STAND_WALK		= 6;
	final int STATE_WALK_STAND		= 7;
	final int STATE_WALK_CHANGE		= 8;
	
	final int STATE_STAND_UPON		= 9;
	final int STATE_UPONING			= 10;
	final int STATE_UPON_STAND		= 11;
	
	final int STATE_STAND_DUCK		= 12;
	final int STATE_DUCKING			= 13;
	final int STATE_DUCK_STAND		= 14;
	
	final int STATE_ATTACK_LAND		= 15;
	final int STATE_ATTACK_JUMP		= 16;
	final int STATE_ATTACK_DUCK		= 17;
	
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
		case STATE_WALK_CHANGE:
			if(nextFrame()){
				state = STATE_WALKING;
				setCurrentFrame(state, 0);
			}
			break;
			
			
		case STATE_STAND_UPON:
			if(nextFrame()){
				state = STATE_UPONING;
				setCurrentFrame(state, 0);
			}
			break;
		case STATE_UPONING:
			nextCycFrame();
			break;
		case STATE_UPON_STAND:
			if(nextFrame()){
				state = STATE_STANDING;
				setCurrentFrame(state, 0);
			}
			break;
			
		case STATE_STAND_DUCK:
			if(nextFrame()){
				state = STATE_DUCKING;
				setCurrentFrame(state, 0);
			}
			break;
		case STATE_DUCKING:
			nextCycFrame();
			break;
		case STATE_DUCK_STAND:
			if(nextFrame()){
				state = STATE_STANDING;
				setCurrentFrame(state, 0);
			}
			break;
			
			
		case STATE_ATTACK_LAND:
			if(nextFrame()){
				state = STATE_STANDING;
				setCurrentFrame(state, 0);
			}
			break;
		case STATE_ATTACK_JUMP:
			if(nextFrame()){
				state = STATE_JUMP_DOWN;
				setCurrentFrame(state, 0);
			}
			break;
		case STATE_ATTACK_DUCK:
			if(nextFrame()){
				state = STATE_DUCKING;
				setCurrentFrame(state, 0);
			}
			break;
		}

		
	}
	
//	-----------------------------------------------------------------------------------------

	public static int Gravity 			= 200;
	public static int WalkV 			=  3*256;
	public static int JumpV 			= -11*256;
	public static int JumpHoldTime 		= 0;
	public static int JumpHoldTimeMAX 	= 10;
	
	
	void onState(){
		
		// init data
		boolean isLand = isLand();
		SpeedX256 = 0;
		if(!isLand){
			
			if(turnAction){
				//如果不是在攻击状态中,才能继续下次攻击
				if( state != STATE_ATTACK_JUMP ){
					state = STATE_ATTACK_JUMP;
					setCurrentFrame(state, 0);
				}
			}
			
			//在攻击状态中不接受其他改变指令
			if(state != STATE_ATTACK_JUMP){
				// jump up
				if(SpeedY256<0){
					if(onL|onR){
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
				// jump que
				if(SpeedY256==0){
					state = STATE_JUMP_DOWN;
					setCurrentFrame(state, 0);
				}	
			}
			if(onL){
				SpeedX256 = -WalkV;
				//只有攻击完结之后才可转身
				if(state != STATE_ATTACK_JUMP){
					if(Transform!=IImages.TRANS_H){
						transform(IImages.TRANS_H);
					}
				}
			}
			if(onR){
				SpeedX256 =  WalkV;
				if(Transform!=IImages.TRANS_NONE){
					transform(IImages.TRANS_H);
				}
			}
			
			SpeedY256 += Gravity;
		}else{
			
			if(turnAction){
				//如果不是在攻击状态中,才能继续下次攻击
				if( state != STATE_ATTACK_LAND &&
					state != STATE_ATTACK_DUCK ){
					//判断攻击状态是蹲还是站
					if( state==STATE_STAND_DUCK ||
						state==STATE_DUCKING ){
						state = STATE_ATTACK_DUCK;
					}else{
						state = STATE_ATTACK_LAND;
					}
					setCurrentFrame(state, 0);
				}
			}
			
			//如果不在攻击状态中才可以更换状态
			if( state != STATE_ATTACK_LAND &&
				state != STATE_ATTACK_DUCK ){
				//判断是否一直蹲着,屏蔽站立的状态变化
				if(onD){
					if( state!=STATE_STAND_DUCK &&
						state!=STATE_DUCKING){
						state = STATE_STAND_DUCK;
						setCurrentFrame(state, 0);
					}
				}else{
					//方向键松开,改变到(走->停)的状态
					if(releaseL|releaseR){
						state = STATE_WALK_STAND;
						setCurrentFrame(state, 0);
					}
					//方向键按下,改变到(停->走)的状态
					if(turnL|turnR){
						state = STATE_STAND_WALK;
						setCurrentFrame(state, 0);
					}
					//一直按着方向改变X位置
					if(onL){
						SpeedX256 = -WalkV;
						//如果此次之前不是和走有关的状态
						if( state!=STATE_WALKING &&
							state!=STATE_STAND_WALK &&
							state!=STATE_WALK_CHANGE){
							state = STATE_STAND_WALK;
							setCurrentFrame(state, 0);
						}
						//判断方向是否同向,否则转身
						if(Transform!=IImages.TRANS_H){
							transform(IImages.TRANS_H);
							state = STATE_WALK_CHANGE;
							setCurrentFrame(state, 0);
						}
					}
					if(onR){
						SpeedX256 =  WalkV;
						if( state!=STATE_WALKING &&
							state!=STATE_STAND_WALK &&
							state!=STATE_WALK_CHANGE){
							state = STATE_STAND_WALK;
							setCurrentFrame(state, 0);
						}
						if(Transform!=IImages.TRANS_NONE){
							transform(IImages.TRANS_H);
							state = STATE_WALK_CHANGE;
							setCurrentFrame(state, 0);
						}
					}
					//最后判断之前是否在空中
					if(SpeedY256>0){
						//如果当前按着方向键,继续播放走路动画
						if(onL|onR){
							state = STATE_WALKING;
							setCurrentFrame(state, 0);
						}else{//否则播放落地动画
							state = STATE_JUMP_STAND;
							setCurrentFrame(state, 0);
						}
					}
					
				}

			}

			if(turnU){
				if(state==STATE_DUCKING){
					state = STATE_DUCK_STAND;
					setCurrentFrame(state, 0);
				}else{
					if(SpeedX256==0){
						state = STATE_JUMP_UP;
					}else{
						state = STATE_JUMP_UPR;
					}
					setCurrentFrame(state, 0);
					
					SpeedY256 = JumpV;
				}
				
			}else{
				SpeedY256 = 0;
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

package cv.unit;


import com.cell.AScreen;
import com.cell.IImages;
import com.cell.game.IState;

public class UnitActor extends Unit {


	public void update() {
		input();
		onAction();
		onState();
		onControl();
	}

	
	
//	public void render(Graphics g, int x, int y) {
//		spr.render(g, x, y);
//		if(IsDebug)
//		super.collides.render(g, 0, x, y, 0xff00ff00);
//	}
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
	
	void input(){
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
	
	void onControl(){
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
			Spr.nextCycFrame();
			break;
			
		case STATE_JUMP_UP:
			Spr.nextCycFrame();
			break;
		case STATE_JUMP_UPR:
			Spr.nextCycFrame();
			break;
		case STATE_JUMP_DOWN:
			Spr.nextCycFrame(Spr.getFrameCount(Spr.getCurrentAnimate())-2);
			break;
		case STATE_JUMP_STAND:
			if(Spr.nextFrame()){
				state = STATE_STANDING;
				Spr.setCurrentFrame(state, 0);
			}
			break;
			
		case STATE_WALKING:
			Spr.nextCycFrame();
			break;
		case STATE_STAND_WALK:
			if(Spr.nextFrame()){
				state = STATE_WALKING;
				Spr.setCurrentFrame(state, 0);
			}
			break;
		case STATE_WALK_STAND:
			if(Spr.nextFrame()){
				state = STATE_STANDING;
				Spr.setCurrentFrame(state, 0);
			}
			break;
		case STATE_WALK_CHANGE:
			if(Spr.nextFrame()){
				state = STATE_WALKING;
				Spr.setCurrentFrame(state, 0);
			}
			break;
			
			
		case STATE_STAND_UPON:
			if(Spr.nextFrame()){
				state = STATE_UPONING;
				Spr.setCurrentFrame(state, 0);
			}
			break;
		case STATE_UPONING:
			Spr.nextCycFrame();
			break;
		case STATE_UPON_STAND:
			if(Spr.nextFrame()){
				state = STATE_STANDING;
				Spr.setCurrentFrame(state, 0);
			}
			break;
			
		case STATE_STAND_DUCK:
			if(Spr.nextFrame()){
				state = STATE_DUCKING;
				Spr.setCurrentFrame(state, 0);
			}
			break;
		case STATE_DUCKING:
			Spr.nextCycFrame();
			break;
		case STATE_DUCK_STAND:
			if(Spr.nextFrame()){
				state = STATE_STANDING;
				Spr.setCurrentFrame(state, 0);
			}
			break;
			
			
		case STATE_ATTACK_LAND:
			if(Spr.nextFrame()){
				state = STATE_STANDING;
				Spr.setCurrentFrame(state, 0);
			}
			break;
		case STATE_ATTACK_JUMP:
			if(Spr.nextFrame()){
				state = STATE_JUMP_DOWN;
				Spr.setCurrentFrame(state, 0);
			}
			break;
		case STATE_ATTACK_DUCK:
			if(Spr.nextFrame()){
				state = STATE_DUCKING;
				Spr.setCurrentFrame(state, 0);
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
		boolean isLand = Spr.isLand();
		Spr.SpeedX256 = 0;
		if(!isLand){
			
			if(turnAction){
				//如果不是在攻击状态中,才能继续下次攻击
				if( state != STATE_ATTACK_JUMP ){
					state = STATE_ATTACK_JUMP;
					Spr.setCurrentFrame(state, 0);
				}
			}
			
			//在攻击状态中不接受其他改变指令
			if(state != STATE_ATTACK_JUMP){
				// jump up
				if(Spr.SpeedY256<0){
					if(onL|onR){
						state = STATE_JUMP_UPR;
						Spr.setCurrentFrame(state, Spr.getCurrentFrame());
					}else{
						state = STATE_JUMP_UP;
						Spr.setCurrentFrame(state, Spr.getCurrentFrame());
					}
				}
				// jump down
				if(Spr.SpeedY256>0){
					state = STATE_JUMP_DOWN;
					Spr.setCurrentFrame(state, Spr.getCurrentFrame());
				}
				// jump que
				if(Spr.SpeedY256==0){
					state = STATE_JUMP_DOWN;
					Spr.setCurrentFrame(state, 0);
				}	
			}
			if(onL){
				Spr.SpeedX256 = -WalkV;
				//只有攻击完结之后才可转身
				if(state != STATE_ATTACK_JUMP){
					if(Spr.getCurTransform()!=IImages.TRANS_H){
						Spr.transform(IImages.TRANS_H);
					}
				}
			}
			if(onR){
				Spr.SpeedX256 =  WalkV;
				if(Spr.getCurTransform()!=IImages.TRANS_NONE){
					Spr.transform(IImages.TRANS_H);
				}
			}
			
			Spr.SpeedY256 += Gravity;
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
					Spr.setCurrentFrame(state, 0);
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
						Spr.setCurrentFrame(state, 0);
					}
				}else{
					//方向键松开,改变到(走->停)的状态
					if(releaseL|releaseR){
						state = STATE_WALK_STAND;
						Spr.setCurrentFrame(state, 0);
					}
					//方向键按下,改变到(停->走)的状态
					if(turnL|turnR){
						state = STATE_STAND_WALK;
						Spr.setCurrentFrame(state, 0);
					}
					//一直按着方向改变X位置
					if(onL){
						Spr.SpeedX256 = -WalkV;
						//如果此次之前不是和走有关的状态
						if( state!=STATE_WALKING &&
							state!=STATE_STAND_WALK &&
							state!=STATE_WALK_CHANGE){
							state = STATE_STAND_WALK;
							Spr.setCurrentFrame(state, 0);
						}
						//判断方向是否同向,否则转身
						if(Spr.getCurTransform()!=IImages.TRANS_H){
							Spr.transform(IImages.TRANS_H);
							state = STATE_WALK_CHANGE;
							Spr.setCurrentFrame(state, 0);
						}
					}
					if(onR){
						Spr.SpeedX256 =  WalkV;
						if( state!=STATE_WALKING &&
							state!=STATE_STAND_WALK &&
							state!=STATE_WALK_CHANGE){
							state = STATE_STAND_WALK;
							Spr.setCurrentFrame(state, 0);
						}
						if(Spr.getCurTransform()!=IImages.TRANS_NONE){
							Spr.transform(IImages.TRANS_H);
							state = STATE_WALK_CHANGE;
							Spr.setCurrentFrame(state, 0);
						}
					}
					//最后判断之前是否在空中
					if(Spr.SpeedY256>0){
						//如果当前按着方向键,继续播放走路动画
						if(onL|onR){
							state = STATE_WALKING;
							Spr.setCurrentFrame(state, 0);
						}else{//否则播放落地动画
							state = STATE_JUMP_STAND;
							Spr.setCurrentFrame(state, 0);
						}
					}
					
				}

			}

			if(turnU){
				if(state==STATE_DUCKING){
					state = STATE_DUCK_STAND;
					Spr.setCurrentFrame(state, 0);
				}else{
					if(Spr.SpeedX256==0){
						state = STATE_JUMP_UP;
					}else{
						state = STATE_JUMP_UPR;
					}
					Spr.setCurrentFrame(state, 0);
					
					Spr.SpeedY256 = JumpV;
				}
				
			}else{
				Spr.SpeedY256 = 0;
			}
			
		}
		
		
		
		
		// physices
		if(Spr.SpeedY256<0){
			Spr.getCollides().getCD(1).Mask = 0x0000;
			Spr.getCollides().getCD(2).Mask = 0x0000;
		}else {
			Spr.getCollides().getCD(1).Mask = 0x0002;
			Spr.getCollides().getCD(2).Mask = 0xffff;
		}
		
		if(Spr.actMoveX(Spr.SpeedX256/256)){
		}
		if(Spr.actMoveY(Spr.SpeedY256/256)){
//			if(SpeedY256>0){
				if(Spr.SpeedX256==0){
					state = STATE_JUMP_STAND;
					Spr.setCurrentFrame(state, 0);
				}else{
					state = STATE_WALKING;
					Spr.setCurrentFrame(state, 0);
				}
//			}
			Spr.SpeedY256 = 0;
		}
		
		
		
	}

	
//	-------------------------------------------------------------------------------------------

//	-------------------------------------------------------------------------------------------

	
}

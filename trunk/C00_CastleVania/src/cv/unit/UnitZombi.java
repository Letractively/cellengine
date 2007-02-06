package cv.unit;

import com.cell.IImages;
import com.mascotcapsule.micro3d.v3.ActionTable;

public class UnitZombi extends Unit {

	
	public UnitZombi(){
		Team = 1;
	}
	

	public void update() {
		
		if(damageTime>0){
			damageTime--;
		}else{
			if(Random.nextInt()%100==0){
				startWalk();
			}
			if(Active){
				onAction();
			}
		}
	}
	boolean onDamage;
	boolean onAttack;
	int damageTime = 0;
	
	public void attack(Unit unit){
		
	}
	
	public void damage(Unit unit){
		damageTime = 5;
		onDamage = true;
		
		SpawnNumber(unit.Attack, X, Y - getVisibleHeight());
	}

//	-----------------------------------------------------------------------------------------

	
	
	final int STATE_START		= 0;
	final int STATE_WALKING		= 1;
	final int STATE_END 		= 2;
	
	int state = -1;
	
	void onAction(){
		switch(state){
		case STATE_START:
			if(nextFrame()){
				state = STATE_WALKING;
				setCurrentFrame(state, 0);
			}
			break;
		case STATE_WALKING:
			nextCycFrame();
			WalkTimer--;
			if(WalkTimer<0 || actMoveX(WalkSpeed)){
				state = STATE_END;
				setCurrentFrame(state, 0);
				WalkTimer = -1;
			}
			break;
		case STATE_END:
			if(nextFrame()){
				startHold();
			}
			break;
		}
	}
	
//	-----------------------------------------------------------------------------------------
	public void startHold(){
		state = -1;
		Active = false;
		Visible = false;
	}
	
//	-----------------------------------------------------------------------------------------
	int WalkTimer = -1;
	int WalkSpeed = 2;
	public void startWalk(){
		if(WalkTimer<0){
			Active = true;
			Visible = true;
			state = STATE_START;
			setCurrentFrame(state, 0);
			WalkTimer = 100 + Random.nextInt()%50;
			WalkSpeed *= Math.abs(Random.nextInt()%2)==0?-1:1;
			
			if(WalkSpeed>0){
				if(getCurTransform()!=IImages.TRANS_H){
					transform(IImages.TRANS_H);
				}
			}
			if(WalkSpeed<0){
				if(getCurTransform()!=IImages.TRANS_NONE){
					transform(IImages.TRANS_H);
				}
			}
		
		}
	}
	
//	-------------------------------------------------------------------------------------------

//	-------------------------------------------------------------------------------------------

	
}

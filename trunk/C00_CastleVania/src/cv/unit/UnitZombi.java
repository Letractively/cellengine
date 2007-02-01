package cv.unit;

import com.cell.IImages;
import com.mascotcapsule.micro3d.v3.ActionTable;

public class UnitZombi extends Unit {


	public void update() {
		
		if(Random.nextInt()%100==0){
			startWalk();
		}
		
		if(Spr.Active){
			onAction();
		}
	}

//	public void render(Graphics g, int x, int y) {
//		spr.render(g, x, y);
//		if(IsDebug)
//		super.collides.render(g, 0, x, y, 0xff00ff00);
//	}
	
//	-----------------------------------------------------------------------------------------
	
	final int STATE_START		= 0;
	final int STATE_WALKING		= 1;
	final int STATE_END 		= 2;
	
	int state = -1;
	
	void onAction(){
		switch(state){
		case STATE_START:
			if(Spr.nextFrame()){
				state = STATE_WALKING;
				Spr.setCurrentFrame(state, 0);
			}
			break;
		case STATE_WALKING:
			Spr.nextCycFrame();
			WalkTimer--;
			if(WalkTimer<0 || Spr.actMoveX(WalkSpeed)){
				state = STATE_END;
				Spr.setCurrentFrame(state, 0);
				WalkTimer = -1;
			}
			break;
		case STATE_END:
			if(Spr.nextFrame()){
				startHold();
			}
			break;
		}
	}
	
//	-----------------------------------------------------------------------------------------
	public void startHold(){
		state = -1;
		Spr.Active = false;
		Spr.Visible = false;
	}
	
//	-----------------------------------------------------------------------------------------
	int WalkTimer = -1;
	int WalkSpeed = 2;
	public void startWalk(){
		if(WalkTimer<0){
			Spr.Active = true;
			Spr.Visible = true;
			state = STATE_START;
			Spr.setCurrentFrame(state, 0);
			WalkTimer = 100 + Random.nextInt()%50;
			WalkSpeed *= Math.abs(Random.nextInt()%2)==0?-1:1;
			
			if(WalkSpeed>0){
				if(Spr.getCurTransform()!=IImages.TRANS_H){
					Spr.transform(IImages.TRANS_H);
				}
			}
			if(WalkSpeed<0){
				if(Spr.getCurTransform()!=IImages.TRANS_NONE){
					Spr.transform(IImages.TRANS_H);
				}
			}
		
		}
	}
	
//	-------------------------------------------------------------------------------------------

//	-------------------------------------------------------------------------------------------

	
}

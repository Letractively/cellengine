package game.unit.battle;

import com.morefuntek.cell.CMath;
import com.morefuntek.cell.Game.AScreen;
import com.morefuntek.cell.Game.CCD;
import com.morefuntek.cell.Game.CSprite;
import com.morefuntek.cell.Game.IState;

public class UnitActor extends CSprite implements IState {

	
	final public int WEAOPN_SLUG	= 0;
	final public int WEAOPN_LIGHT	= 1;
	final public int WEAOPN_ROCKET	= 2;
	final public int WEAOPN_MISSILE	= 3;
	final public int WEAOPN_BOMB	= 4;
	final public int WEAOPN_EXTREM	= 5;
	
	public int WeaopnCount = 6;
	
	public int MainWeaopn	= 0;
	public int SubWeaopn[]	= new int[]{0,0,0,0};
	
	
	public UnitActor(CSprite stuff){
		super(stuff);
		setState(this);
	}
	
	public void update() {
		onMove();
		onFire();
		onSub();
		onDamage();
	}
//	-----------------------------------------------------------------------------------------------------

//	----------------------------------------------------------------------------------------------------
//	开火

	int ForzenTimeMax = 10 ;
	int ForzenTime	= 0;
	public void startFire(UnitBullet[] shots,CSprite[] targets){
		if(ForzenTime>0)return;
		
		
		for(int i=0;i<shots.length;i++){
			if(shots[i].Active==false){
				switch(MainWeaopn){
				case WEAOPN_SLUG:
					shots[i].startSlug(X, Y, X+1, Y);
					break;
				case WEAOPN_LIGHT:
					shots[i].startLight(this);
					break;
				case WEAOPN_BOMB:
					shots[i].startBomb(X,Y,MaxSpeed,SpeedY256);
					break;
				case WEAOPN_ROCKET:
					shots[i].startRocket(X-16,Y,1);
					break;
				case WEAOPN_MISSILE:
					int start = Math.abs(Random.nextInt()%targets.length);
					for(int j=0;j<targets.length;j++){
						int id = (j + start) % targets.length;  
						if( targets[id].Active==true && 
							targets[id].OnScreen==true){
							shots[i].startMissile(X,Y,targets[id]);
							break;
						}
					}
					break;
				case WEAOPN_EXTREM:
					shots[i].startCollapsar(X+128,Y);
					break;
				}
				break;
			}
		}

		for(int j=Sub.length-1;j>=0;j--){
			for(int i=0;i<shots.length;i++){
				if(shots[i].Active==false){
					switch(SubWeaopn[j]){
					case WEAOPN_SLUG:
						shots[i].startSlug(Sub[j].X, Sub[j].Y, Sub[j].X+1, Sub[j].Y);
						break;
					case WEAOPN_LIGHT:
						shots[i].startLight(Sub[j]);
						break;
					case WEAOPN_BOMB:
						shots[i].startBomb(Sub[j].X,Sub[j].Y,MaxSpeed,SpeedY256);
						break;
					case WEAOPN_ROCKET:
						shots[i].startRocket(Sub[j].X-16,Sub[j].Y,1);
						break;
					case WEAOPN_MISSILE:
						int start = Math.abs(Random.nextInt()%targets.length);
						for(int k=0;k<targets.length;k++){
							int id = (k + start) % targets.length;  
							if( targets[id].Active==true && 
								targets[id].OnScreen==true){
								shots[i].startMissile(Sub[j].X,Sub[j].Y,targets[id]);
								break;
							}
						}
						break;
					case WEAOPN_EXTREM:
						shots[i].startCollapsar(Sub[j].X+128,Sub[j].Y);
						break;
					}
					break;
				}
			}
		}
		
		
		ForzenTime = ForzenTimeMax;
	}
	
	public void onFire(){
		ForzenTime--;
	}
	
//	-------------------------------------------------------------------------------------------------------
//	移动
	public void scrollMove(int x){
		HPos256 += x*256;
		for(int i=FollowTrackX.length-1;i>=0;i--){
			FollowTrackX[i]+=x*256;
		}
		X = HPos256 / 256 ;
	}
	
	/**最大速度*/
	public int MaxSpeed = 256 * 4;
	/**机动性*/
	public int Accelerate = MaxSpeed / 1 ;
	
	public void startMove(int dx,int dy){
		DirectX = dx == 0 ? 0 : dx/Math.abs(dx);
		DirectY = dy == 0 ? 0 : dy/Math.abs(dy);
	}

	public void onMove(){
		if(DirectX!=0){
			SpeedX256 += Accelerate * DirectX;
			if(Math.abs(SpeedX256)>MaxSpeed){
				SpeedX256 = MaxSpeed * DirectX;
			}
		}else{
			int d = SpeedX256 == 0 ? 0 : (SpeedX256>0?1:-1); 
			SpeedX256 -= Accelerate * d;
		}
		
		if(DirectY!=0){
			SpeedY256 += Accelerate * DirectY;
			if(Math.abs(SpeedY256)>MaxSpeed){
				SpeedY256 = MaxSpeed * DirectY;
			}
		}else{
			int d = SpeedY256 == 0 ? 0 : (SpeedY256>0?1:-1); 
			SpeedY256 -= Accelerate * d;
		}
		
		if(SpeedX256!=0 || SpeedY256!=0){
			FollowTrackIndex = CMath.cycNum(FollowTrackIndex, 1, FollowTrackX.length);
			FollowTrackX[FollowTrackIndex] = HPos256;
			FollowTrackY[FollowTrackIndex] = VPos256;
			
		}
		
		HPos256 += SpeedX256;
		VPos256 += SpeedY256;
		
		if(HPos256<world.getCamera().getX()*256)
			HPos256 = world.getCamera().getX()*256;
		if(HPos256>world.getCamera().getX()*256 + world.getCamera().getWidth()*256)
			HPos256 = world.getCamera().getX()*256 + world.getCamera().getWidth()*256;
		
		if(VPos256<0)
			VPos256 = 0;
		if(VPos256>world.getMap().getHeight()*256)
			VPos256 = world.getMap().getHeight()*256;
		
		X = HPos256 / 256 ;
		Y = VPos256 / 256 ;
		
		DirectX = 0;
		DirectY = 0;
	}

//	---------------------------------------------------------------------------------------------------------------
//	被打到
	public int DamageTime = 100;
	
	public void startDamage(){
		if(DamageTime<0)DamageTime = 100;
	}
	
	public void onDamage(){
		DamageTime--;
		if(DamageTime>0){
			nextCycFrame();
			
			HPos256 -= CMath.sinTimes256(DamageTime*90)*4;
			VPos256 -= CMath.cosTimes256(DamageTime*90)*4;
			X = HPos256 / 256 ;
			Y = VPos256 / 256 ;
			
		}else{
			setCurrentFrame(0, 0);
		}
	}
	
//	-------------------------------------------------------------------------------------------------------
//	辅助武器	
	
	final public int SUB_CYCLE		= 0;
	final public int SUB_FOLLOW		= 1;
	final public int SUB_HOLD_TB	= 2;
	final public int SUB_CYCLE_H	= 3;
	final public int SUB_CYCLE_X	= 4;
	
	public int SubCount	= 5;
	public int SubType = 1;
	
	public CSprite[] Sub;
	
	
	int[] FollowTrackX = new int[32];
	int[] FollowTrackY = new int[32];
	int FollowTrackIndex = 0;
	
	public void onSub(){
		if(Sub!=null){
			for(int i=Sub.length-1;i>=0;i--){
				int dx = 0;
				int dy = 0;
				switch(SubType){
				case SUB_CYCLE:
					dx = X + CMath.sinTimes256(getTimer()*8+i*360/Sub.length)/8;
					dy = Y + CMath.cosTimes256(getTimer()*8+i*360/Sub.length)/8;
					break;
				case SUB_FOLLOW:
					dx = FollowTrackX[CMath.cycNum(FollowTrackIndex, -7-i*8, FollowTrackX.length)]/256;
					dy = FollowTrackY[CMath.cycNum(FollowTrackIndex, -7-i*8, FollowTrackY.length)]/256;
					break;
				case SUB_HOLD_TB:
					dx = X ;
					dy = Y - (i%2==0?-1:1)*(i/2==0?16:32);
					break;
				case SUB_CYCLE_H:
					dx = X + 32 + CMath.sinTimes256(getTimer()*10+i*360/Sub.length)/20;
					dy = Y + 0  + CMath.cosTimes256(getTimer()*10+i*360/Sub.length)/10;
					break;
				case SUB_CYCLE_X:
					dx = X + CMath.sinTimes256((getTimer()*2+(i/2==0?0:1)*180)*(i%2==0?-1:1))/8;
					dy = Y + CMath.cosTimes256((getTimer()*2+(i/2==0?0:1)*180)*(i%2==0?-1:1))/8;
					break;
				}
				dx -= Sub[i].X;
				dy -= Sub[i].Y;
				Sub[i].X += dx/4;
				Sub[i].Y += dy/4;
				Sub[i].setCurrentFrame(1, 0);
			}
		}
	}
	
	
	
	
}

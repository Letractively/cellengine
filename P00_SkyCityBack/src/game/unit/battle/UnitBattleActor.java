package game.unit.battle;

import java.util.Vector;

import com.morefuntek.cell.CMath;
import com.morefuntek.cell.Game.AScreen;
import com.morefuntek.cell.Game.CCD;
import com.morefuntek.cell.Game.CSprite;
import com.morefuntek.cell.Game.IState;

public class UnitBattleActor extends CSprite {

	static public int WeaopnType = 2;
	
	
	final static String[] WeaopnList = new String[]{
		"激光炮",
		"巨型鱼雷",
		"爆式霰弹",
		"爆弹",
		"飞弹",
//		"黑洞炮"
	};
	final static public int[] WeaopnCount = new int[]{
		1,
		2,
		32,
		2,
		2,
//		1
	};
	final static public int[] WeaopnBullet = new int[]{
		UnitBattleBullet.TYPE_LASER,
		UnitBattleBullet.TYPE_BOMB,
		UnitBattleBullet.TYPE_SLUG1,
		UnitBattleBullet.TYPE_BOMBEXP,
		UnitBattleBullet.TYPE_ROCKET,
//		UnitBattleBullet.TYPE_MISSILE1,
	};
	
	final static public int  WEAOPN_LASER	= 0;
	final static public int  WEAOPN_BOMB	= 1;
	final static public int  WEAOPN_SHORT	= 2;
	final static public int  WEAOPN_EXP		= 3;
	final static public int  WEAOPN_ROCKET	= 4;
//	final static public int  WEAOPN_ALL		= 5;
	
//	-----------------------------------------------------------------------------------------------------
	
	
//	private int MainWeaopn	= 0;
	public Vector Ammor;
	public Vector Bullets;
	
	public int HP = 100;
	public int AMMOR = 100;
	public int SCORE = 0;
	
	public boolean WeaopnOn = false;
	
	public UnitBattleActor(CSprite stuff){
		super(stuff);
		
//		if(!Bullets.isEmpty())MainWeaopn = ((UnitBattleBullet)Bullets.firstElement()).getType();
//	
//		for(int i=0;i<Bullets.size();i++){
//			UnitBattleBullet bullet = (UnitBattleBullet)Bullets.elementAt(i);
//		}
	
	}
	
	public void update() {
		if(Active){
			nextCycFrame();
			onMove();
			onFire();
			onDamage();
			onDestory();
		}
	}
//	-----------------------------------------------------------------------------------------------------
	

	
//	----------------------------------------------------------------------------------------------------
//	开火

	int ForzenTimeMax = 2 ;
	int ForzenTime	= 0;
	public boolean startFire(){
		if(ForzenTime>0)return false;
		
		UnitBattleBullet bullet;
		
		if(AMMOR<1 || !WeaopnOn){
			for(int i=0;i<3;i++){
				int dx = CMath.cosTimes256(-8 + i*8);
				int dy = CMath.sinTimes256(-8 + i*8);
				bullet = getAmmor();
				if(bullet!=null){
					bullet.fire(UnitBattleBullet.TYPE_SLUG1, this, null, X, Y, X + dx, Y + dy, 8, 0);
					ForzenTimeMax = bullet.getForzenTime();
				}
			}
		}else{
			AMMOR--;
			if(AMMOR<0)AMMOR=0;
			
			switch (WeaopnType) {
			case WEAOPN_LASER:
				bullet = getAmmor();
				if(bullet!=null){
					bullet.fire(WeaopnBullet[WeaopnType], this, null, X, Y, 0, 0, 0, 0);
					ForzenTimeMax = bullet.getForzenTime();
				}
				break;
			case WEAOPN_BOMB:
				bullet = getAmmor();
				if(bullet!=null){
					bullet.fire(WeaopnBullet[WeaopnType], this, null, X, Y, 0, 0, 0, 0);
					ForzenTimeMax = bullet.getForzenTime();
				}
				break;
			case WEAOPN_SHORT:
				for(int i=0;i<5;i++){
					int dx = CMath.cosTimes256(-16 + i*8);
					int dy = CMath.sinTimes256(-16 + i*8);
					bullet = getAmmor();
					if(bullet!=null){
						bullet.fire(WeaopnBullet[WeaopnType], this, null, X, Y, X + dx, Y + dy, 8, 0);
						ForzenTimeMax = bullet.getForzenTime();
					}
				}
				break;
			case WEAOPN_ROCKET:
			case WEAOPN_EXP:
				bullet = getAmmor();
				if(bullet!=null){
					bullet.fire(WeaopnBullet[WeaopnType], this, null, X, Y, 1, 0, 8, 0);
					ForzenTimeMax = bullet.getForzenTime();
//					bullet.startRocket(X, Y, 1);
				}
				break;
			}	
		}
		
		
			
		ForzenTime = ForzenTimeMax;
		return true;
	}
	
	void onFire(){
		ForzenTime--;
	}
	
	UnitBattleBullet getAmmor(){
		if(!Ammor.isEmpty()){
			UnitBattleBullet bullet = (UnitBattleBullet)Ammor.firstElement();

			Bullets.addElement(bullet);
			Ammor.removeElement(bullet);
			
			return bullet;
		}else{
			return null;
		}
	}
	
//	-------------------------------------------------------------------------------------------------------
//	移动
	public int ScrollSpeedX = 0;
	
	public void scrollMove(int x){
		
		ScrollSpeedX = x;
		
		HPos256 += x;
		X = HPos256 / 256 ;
		for(int i=FollowTrackX.length-1;i>=0;i--){
			FollowTrackX[i]+=x;
		}
	}
	
	/**最大速度*/
	public int MaxSpeed = 256 * 4;
	/**机动性*/
	public int Accelerate = MaxSpeed / 1 ;
	
	public void startMove(int dx,int dy){
		DirectX = dx == 0 ? 0 : dx/Math.abs(dx);
		DirectY = dy == 0 ? 0 : dy/Math.abs(dy);
	}

	void onMove(){
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
		
		if(HPos256<0)
			HPos256 = 0;
		if(HPos256>world.Width*256)
			HPos256 = world.Width*256;
		
		if(VPos256<0)
			VPos256 = 0;
		if(VPos256>world.Height*256)
			VPos256 = world.Height*256;
		
		X = HPos256 / 256 ;
		Y = VPos256 / 256 ;
		
		DirectX = 0;
		DirectY = 0;
	}

//	---------------------------------------------------------------------------------------------------------------
//	被打到
	public int DamageTime = 0;
	
	public void startDamage(){
		if(DamageTime<0)DamageTime = 2;
	}
	
	void onDamage(){
		DamageTime--;
		if(DamageTime>0){
			setCurrentFrame(1, 0);
		}
		if( DamageTime == 0 ){
			setCurrentFrame(0, 0);
		}
	}
	
//	-------------------------------------------------------------------------------------------------------
//	辅助武器	
	public int[] FollowTrackX = new int[16];
	public int[] FollowTrackY = new int[16];
	public int FollowTrackIndex = 0;
	
	
	
//	----------------------------------------------------------------------------------------------------
	
	public void startDestory(){
		this.Active = false;
		this.Visible = false;
		getAmmor().SpawnExtParticle(UnitBattleBullet.PARTICLE_BIG, 1, 
				X, 
				Y);
		getAmmor().SpawnExtParticle(UnitBattleBullet.PARTICLE_BIG, 1, 
				X + Random.nextInt()%16, 
				Y + Random.nextInt()%16);
		getAmmor().SpawnExtParticle(UnitBattleBullet.PARTICLE_BIG, 1, 
				X + Random.nextInt()%16, 
				Y + Random.nextInt()%16);
		getAmmor().SpawnExtParticle(UnitBattleBullet.PARTICLE_BIG, 1, 
				X + Random.nextInt()%16, 
				Y + Random.nextInt()%16);
		getAmmor().SpawnExtParticle(UnitBattleBullet.PARTICLE_BIG, 1, 
				X + Random.nextInt()%16, 
				Y + Random.nextInt()%16);
	}
	boolean isEndDestory(){
		return true;
	}
	void onDestory(){

	}
	
	public void startSmoke(){
		UnitBattleBullet ammor = getAmmor();
		if(ammor!=null){
			UnitBattleBullet.smokeSpeed = 128;
			ammor.SpawnExtParticle(1,UnitBattleBullet.EFFECT_SMOKE_L, X-16, Y);
		}
	}
	
}

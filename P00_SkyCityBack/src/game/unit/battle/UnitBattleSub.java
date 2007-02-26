package game.unit.battle;

import java.util.Vector;

import com.cell.CMath;
import com.cell.game.CSprite;
import com.cell.game.IState;

public class UnitBattleSub extends CSprite implements IState{
	
	static public int SubCount = 4;
	
	static public int[] WeaopnType = new int[]{
		2,2,2,2
	};
	
	final static String[] WeaopnList = new String[]{
		"¹âÏßÇ¹",
		"ö±µ¯Ç¹",
		"×·×Ùµ¯",
		"¼¯Êøµ¯"
	};
	//ÎäÆ÷ÊýÁ¿
	final static public int[] WeaopnCount = new int[]{
			8,
			16,
			2,
			8,
	};
	//ÎäÆ÷¼Û¸ñ
	final static public int[] WeaopnPrice = new int[]{
		3000,
		400,
		800,
		3000,
	};

	final static public int[] WeaopnBullet = new int[]{
		UnitBattleBullet.TYPE_LIGHT1,
		UnitBattleBullet.TYPE_SLUG1,
		UnitBattleBullet.TYPE_MISSILE1,
		UnitBattleBullet.TYPE_LIGHT1,
	};
	
	final static public int  SUB_WEAOPN_LIGHT	= 0;
	final static public int  SUB_WEAOPN_SHORT	= 1;
	final static public int  SUB_WEAOPN_MISSILE = 2;
	final static public int  SUB_WEAOPN_LIGHT_F	= 3;
	
//	-----------------------------------------------------------------------------------------------------
	
	final public int SUB_CYCLE		= 0;
	final public int SUB_FOLLOW		= 1;
	final public int SUB_HOLD_TB	= 2;
	final public int SUB_CYCLE_H	= 3;
	final public int SUB_CYCLE_X	= 4;
	
	public int SubIndex		= 0;
	public int SubType 		= 0;
	public int Angle		= 90;
	
	public Vector Ammor;
	public Vector Bullets;
	
	public UnitBattleActor Father;
	
	public int AMMOR = 50;
	
	public boolean WeaopnOn = false;
	
	public UnitBattleSub(CSprite stuff){
		super(stuff);setState(this);
	}
	
	public void update() {
		onFollow(Father);
		onFire();
		nextCycFrame();
	}
//	-----------------------------------------------------------------------------------------------------

	final int pos[] = new int[]{0,2,1,3};
	public void onFollow(UnitBattleActor actor){
		int dx = 0;
		int dy = 0;
		int d = actor.FollowTrackX.length / 4 ;
		switch(SubType){
		case SUB_CYCLE:
			dx = actor.X + CMath.sinTimes256(getTimer()*4+pos[SubIndex]*Angle)/8;
			dy = actor.Y + CMath.cosTimes256(getTimer()*4+pos[SubIndex]*Angle)/8;
			break;
		case SUB_FOLLOW:
			dx = actor.FollowTrackX[CMath.cycNum(actor.FollowTrackIndex, -(d-1)-pos[SubIndex]*d, actor.FollowTrackX.length)]/256;
			dy = actor.FollowTrackY[CMath.cycNum(actor.FollowTrackIndex, -(d-1)-pos[SubIndex]*d, actor.FollowTrackY.length)]/256;
			break;
		case SUB_HOLD_TB:
			dx = actor.X ;
			dy = actor.Y - (SubIndex%2==0?-1:1)*(SubIndex/2==0?16:32);
			break;
		case SUB_CYCLE_H:
			dx = actor.X + 32 + CMath.sinTimes256(getTimer()*10+pos[SubIndex]*Angle)/20;
			dy = actor.Y + 0  + CMath.cosTimes256(getTimer()*10+pos[SubIndex]*Angle)/10;
			break;
		case SUB_CYCLE_X:
			dx = actor.X + CMath.sinTimes256((getTimer()*2+(pos[SubIndex]/2==0?0:1)*180)*(pos[SubIndex]%2==0?-1:1))/8;
			dy = actor.Y + CMath.cosTimes256((getTimer()*2+(pos[SubIndex]/2==0?0:1)*180)*(pos[SubIndex]%2==0?-1:1))/8;
			break;
		}
		dx -= X;
		dy -= Y;
		X += dx/4;
		Y += dy/4;
		nextCycFrame();
	}
	
//	-----------------------------------------------------------------------------------------------------

//	----------------------------------------------------------------------------------------------------
//	¿ª»ð

	public int getBulletType(){
		return WeaopnBullet[WeaopnType[SubIndex]];
	}
	
	int ForzenTimeMax = 8 ;
	int ForzenTime	= 0;
	public boolean startFire(CSprite target){
		if(ForzenTime>0)return false;
		
		UnitBattleBullet bullet;
		
		if(AMMOR<1 || !WeaopnOn){
			bullet = getAmmor();
			if(bullet!=null){
				bullet.fire(UnitBattleBullet.TYPE_SLUG1, this, null, X, Y, X+1, Y , 8, 0);
				ForzenTimeMax = bullet.getForzenTime()*2;
			}		
		}else{
			AMMOR--;
			if(AMMOR<0)AMMOR=0;
			
			switch (WeaopnType[SubIndex]) {
			case SUB_WEAOPN_LIGHT:
				for(int i=0;i<4;i++){
					bullet = getAmmor();
					if(bullet!=null){
						bullet.fire(WeaopnBullet[WeaopnType[SubIndex]], this, target, X, Y, X + 1, Y + 0, 8, 0);
						ForzenTimeMax = bullet.getForzenTime();
					}
				}
				break;
			case SUB_WEAOPN_LIGHT_F:
				bullet = getAmmor();
				if(bullet!=null){
					bullet.fire(WeaopnBullet[WeaopnType[SubIndex]], this, target, X, Y, X + 1, Y + 0, 16, 0);
					ForzenTimeMax = bullet.getForzenTime();
				}
				break;
			case SUB_WEAOPN_SHORT:
				for(int i=0;i<3;i++){
					int dx = CMath.cosTimes256(-5 + i*5);
					int dy = CMath.sinTimes256(-5 + i*5);
					bullet = getAmmor();
					if(bullet!=null){
						bullet.fire(WeaopnBullet[WeaopnType[SubIndex]], this, target, X, Y, X + dx, Y + dy, 8, 0);
						ForzenTimeMax = bullet.getForzenTime();
					}
				}
				break;
			case SUB_WEAOPN_MISSILE:
				bullet = getAmmor();
				if(bullet!=null){
					bullet.fire(WeaopnBullet[WeaopnType[SubIndex]], this, target, X, Y, 0, 0, 8, 100);
					ForzenTimeMax = bullet.getForzenTime();
				}
				break;
			}	
		}
		
		
		ForzenTime = ForzenTimeMax;
		return true;
	}
	
	public void onFire(){
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
	
}

package game.state;


import java.util.Hashtable;

import com.morefuntek.cell.CObject;
import com.morefuntek.cell.Game.AScreen;
import com.morefuntek.cell.Game.CCD;
import com.morefuntek.cell.Game.CSprite;
import com.morefuntek.cell.Game.CWayPoint;
import com.morefuntek.cell.Game.IState;

/**
 * 实现NPC的状态，该NPC有三种行为
 * 移动，站立，转圈，
 * 状态的实现可根据不同游戏有不同的实现方法
 * @author yifeizhang
 * @since 2006-12-30 
 * @version 1.0
 */
public class StateNPC extends CObject implements IState  {

	final public int STATE_MOVE 	= 0;//状态标志移动
	final public int STATE_HOLD 	= 1;//状态标志站立
	final public int STATE_SWING	= 2;//状态标志转圈

	/**当前状态标志*/
	public int state = 0;
	
	//-------------------------------------------------------------------------------------------------
	
	/**引用的精灵*/
	public CSprite spr;
	

	/**
	 * 构造函数
	 * @param stuff 精灵的引用
	 * @param next 开始走向的路点
	 */
	public StateNPC(CSprite stuff, CWayPoint next){
		spr = stuff;
		NextWayPoint = next;
		spr.setState(this);
	}
	
	
	/**
	 * 更新当前状态，该方法将由world.update更新。
	 * @see com.morefuntek.cell.Game.IState#update()
	 */
	public void update() {
		
		//以下是一个标准状态机
		//每个状态的实现有三个方法
		// if( 状态结束 )
		//		转到下一状态 （转到下一状态可以由状态转换表控制，然后脚本实现转换表即可，脚本可自行定制）
		// else
		//      更新当前状态
		
		switch(state){
		case STATE_MOVE : //移动状态
			if(isEndMove()){//移动结束?
				startHold();//开始站立状态
			}else{//否则
				onMove();//继续当前状态
			}
			break;
			//以下同上
		case STATE_HOLD : 
			if(isEndHold()){
				startSwing();
			}else{
				onHold();
			}
			break;
		case STATE_SWING : 
			if(isEndSwing()){
				startMove();
			}else{
				onSwing();
			}
			break;
		}
		
		
	}
	
//---------------------------------------------------------------------------------------
	//站力的状态相关
	public int HoldTime = 100;
	public void onHold(){
		HoldTime--;
		//设置精灵动画
		//第一个参数表示是哪个动画序列
		//第二个参数表示是哪一帧
		//这2个参数根据精灵编辑器定义
		spr.setCurrentFrame(0, 0);
	}
	public void startHold(){
		HoldTime = Math.abs(Random.nextInt()%200);
		state = STATE_HOLD;
	}
	public boolean isEndHold(){
		return HoldTime<0;
	}
	
//------------------------------------------------------------------------------------
//	移动的状态相关
	//patrol
	public CWayPoint NextWayPoint;//移动的目标
	public int MaxSpeed = 2;//移动速度
	public void onMove(){
		//移动到目标路点
		spr.DirectX = NextWayPoint.X - spr.X;
		spr.DirectY = NextWayPoint.Y - spr.Y;
	
		//根据方向确定播放哪个动画
		if(spr.DirectX == 0 && spr.DirectY == 0){
			spr.setCurrentFrame(0, spr.getCurrentFrame());
		}else if(spr.DirectY < 0 ){
			spr.setCurrentFrame(3, spr.getCurrentFrame());
		}else if(spr.DirectY > 0){
			spr.setCurrentFrame(0, spr.getCurrentFrame());
		}else if(spr.DirectX < 0){
			spr.setCurrentFrame(1, spr.getCurrentFrame());
		}else if(spr.DirectX > 0){
			spr.setCurrentFrame(2, spr.getCurrentFrame());
		}
		
		//循环播放动画
		spr.nextCycFrame();
		
		//确定这一帧移动的距离
		int dx = (spr.DirectX==0 ? 0 : (spr.DirectX>0 ? MaxSpeed : -MaxSpeed));
		int dy = (spr.DirectY==0 ? 0 : (spr.DirectY>0 ? MaxSpeed : -MaxSpeed));
		
		if(Math.abs(dx)>Math.abs(spr.DirectX))dx = spr.DirectX;
		if(Math.abs(dy)>Math.abs(spr.DirectY))dy = spr.DirectY;
		
		spr.tryMove(dx, dy);

	}
	public void startMove(){
		//开始移动时，得到下一个路点
		if(NextWayPoint.getNextCount()>0){
			int id = Math.abs(Random.nextInt()%NextWayPoint.getNextCount());
			NextWayPoint = NextWayPoint.getNextPoint(id);
		}
		state = STATE_MOVE;
	}
	public boolean isEndMove(){
		//是否达到目的地
		return CCD.cdRect(
				spr.X - MaxSpeed, spr.Y - MaxSpeed, 
				spr.X + MaxSpeed, spr.Y + MaxSpeed, 
				NextWayPoint.X , NextWayPoint.Y , 
				NextWayPoint.X , NextWayPoint.Y 
				);
	}
	
//	------------------------------------------------------------------------------------
//	转圈的状态相关
	//swing
	public int SwingTime = 100;

	public void onSwing(){
		SwingTime--;
		//只需要更换精灵的动画，精灵动画列表是精灵编辑器定义的
		spr.setCurrentFrame(AScreen.getTimer()%4, 0);
		
		
	}
	public void startSwing(){
		//开始的时候确定持续多长时间，单位（帧）
		SwingTime = Math.abs(Random.nextInt()%200);
		state = STATE_SWING;
	}
	public boolean isEndSwing(){
		//判断是否结束
		return SwingTime<0;
	}
}

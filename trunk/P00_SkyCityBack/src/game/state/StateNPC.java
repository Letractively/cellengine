package game.state;


import java.util.Hashtable;

import com.morefuntek.cell.CObject;
import com.morefuntek.cell.Game.AScreen;
import com.morefuntek.cell.Game.CCD;
import com.morefuntek.cell.Game.CSprite;
import com.morefuntek.cell.Game.CWayPoint;
import com.morefuntek.cell.Game.IState;

/**
 * ʵ��NPC��״̬����NPC��������Ϊ
 * �ƶ���վ����תȦ��
 * ״̬��ʵ�ֿɸ��ݲ�ͬ��Ϸ�в�ͬ��ʵ�ַ���
 * @author yifeizhang
 * @since 2006-12-30 
 * @version 1.0
 */
public class StateNPC extends CObject implements IState  {

	final public int STATE_MOVE 	= 0;//״̬��־�ƶ�
	final public int STATE_HOLD 	= 1;//״̬��־վ��
	final public int STATE_SWING	= 2;//״̬��־תȦ

	/**��ǰ״̬��־*/
	public int state = 0;
	
	//-------------------------------------------------------------------------------------------------
	
	/**���õľ���*/
	public CSprite spr;
	

	/**
	 * ���캯��
	 * @param stuff ���������
	 * @param next ��ʼ�����·��
	 */
	public StateNPC(CSprite stuff, CWayPoint next){
		spr = stuff;
		NextWayPoint = next;
		spr.setState(this);
	}
	
	
	/**
	 * ���µ�ǰ״̬���÷�������world.update���¡�
	 * @see com.morefuntek.cell.Game.IState#update()
	 */
	public void update() {
		
		//������һ����׼״̬��
		//ÿ��״̬��ʵ������������
		// if( ״̬���� )
		//		ת����һ״̬ ��ת����һ״̬������״̬ת������ƣ�Ȼ��ű�ʵ��ת�����ɣ��ű������ж��ƣ�
		// else
		//      ���µ�ǰ״̬
		
		switch(state){
		case STATE_MOVE : //�ƶ�״̬
			if(isEndMove()){//�ƶ�����?
				startHold();//��ʼվ��״̬
			}else{//����
				onMove();//������ǰ״̬
			}
			break;
			//����ͬ��
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
	//վ����״̬���
	public int HoldTime = 100;
	public void onHold(){
		HoldTime--;
		//���þ��鶯��
		//��һ��������ʾ���ĸ���������
		//�ڶ���������ʾ����һ֡
		//��2���������ݾ���༭������
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
//	�ƶ���״̬���
	//patrol
	public CWayPoint NextWayPoint;//�ƶ���Ŀ��
	public int MaxSpeed = 2;//�ƶ��ٶ�
	public void onMove(){
		//�ƶ���Ŀ��·��
		spr.DirectX = NextWayPoint.X - spr.X;
		spr.DirectY = NextWayPoint.Y - spr.Y;
	
		//���ݷ���ȷ�������ĸ�����
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
		
		//ѭ�����Ŷ���
		spr.nextCycFrame();
		
		//ȷ����һ֡�ƶ��ľ���
		int dx = (spr.DirectX==0 ? 0 : (spr.DirectX>0 ? MaxSpeed : -MaxSpeed));
		int dy = (spr.DirectY==0 ? 0 : (spr.DirectY>0 ? MaxSpeed : -MaxSpeed));
		
		if(Math.abs(dx)>Math.abs(spr.DirectX))dx = spr.DirectX;
		if(Math.abs(dy)>Math.abs(spr.DirectY))dy = spr.DirectY;
		
		spr.tryMove(dx, dy);

	}
	public void startMove(){
		//��ʼ�ƶ�ʱ���õ���һ��·��
		if(NextWayPoint.getNextCount()>0){
			int id = Math.abs(Random.nextInt()%NextWayPoint.getNextCount());
			NextWayPoint = NextWayPoint.getNextPoint(id);
		}
		state = STATE_MOVE;
	}
	public boolean isEndMove(){
		//�Ƿ�ﵽĿ�ĵ�
		return CCD.cdRect(
				spr.X - MaxSpeed, spr.Y - MaxSpeed, 
				spr.X + MaxSpeed, spr.Y + MaxSpeed, 
				NextWayPoint.X , NextWayPoint.Y , 
				NextWayPoint.X , NextWayPoint.Y 
				);
	}
	
//	------------------------------------------------------------------------------------
//	תȦ��״̬���
	//swing
	public int SwingTime = 100;

	public void onSwing(){
		SwingTime--;
		//ֻ��Ҫ��������Ķ��������鶯���б��Ǿ���༭�������
		spr.setCurrentFrame(AScreen.getTimer()%4, 0);
		
		
	}
	public void startSwing(){
		//��ʼ��ʱ��ȷ�������೤ʱ�䣬��λ��֡��
		SwingTime = Math.abs(Random.nextInt()%200);
		state = STATE_SWING;
	}
	public boolean isEndSwing(){
		//�ж��Ƿ����
		return SwingTime<0;
	}
}

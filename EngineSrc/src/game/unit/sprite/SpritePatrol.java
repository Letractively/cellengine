package game.unit.sprite;


import javax.microedition.lcdui.Graphics;

import com.morefuntek.cell.Game.CCD;
import com.morefuntek.cell.Game.CSprite;
import com.morefuntek.cell.Game.CWayPoint;
import com.morefuntek.cell.Game.IState;

public class SpritePatrol extends CSprite implements IState {

	public int MaxSpeed = 2;
	
	public CWayPoint NextWayPoint;

	
	public void render(Graphics g, int x, int y) {
		super.render(g, x, y);
		NextWayPoint.render(g, world.toScreenPosX(0), world.toScreenPosY(0));
	}

	public SpritePatrol(CSprite father,CWayPoint next){
		super(father);
		super.setState(this);
		
		NextWayPoint = next;
		
	}
	
	public void update(){
		
		if( SpeedX256==0 && SpeedY256==0 ||
			NextWayPoint.getNextCount()<=0 ||
			CCD.cdRect(
				X - MaxSpeed, Y - MaxSpeed, 
				X + MaxSpeed, Y + MaxSpeed, 
				NextWayPoint.X , NextWayPoint.Y , 
				NextWayPoint.X , NextWayPoint.Y ) ){
			
			HPos256 = NextWayPoint.X * 256 ; 
			VPos256 = NextWayPoint.Y * 256 ; 
			
			SpeedX256 = 0;
			SpeedY256 = 0;
			
			if(NextWayPoint.getNextCount()>0){
				int id = Math.abs(Random.nextInt()%NextWayPoint.getNextCount());
				NextWayPoint = NextWayPoint.getNextPoint(id);
				int bx = Math.abs(NextWayPoint.X - X)/MaxSpeed;
				int by = Math.abs(NextWayPoint.Y - Y)/MaxSpeed;
				int d = Math.max(bx,by);
				if(d!=0){
					SpeedX256 = (NextWayPoint.X - X) * 256 / d ;
					SpeedY256 = (NextWayPoint.Y - Y) * 256 / d ;
					
				}
			}
		}
		
		HPos256 += SpeedX256 ; 
		VPos256 += SpeedY256 ; 
		X = HPos256/256;
		Y = VPos256/256;
	}

	/**
	 * override 方法
	 * @see com.morefuntek.cell.Game.IState#tryChangeState()
	 */
	public void tryChangeState() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * override 方法
	 * @see com.morefuntek.cell.Game.IState#onState()
	 */
	public void onState() {
		// TODO Auto-generated method stub
		
	}
}

package game.unit.world;

import javax.microedition.lcdui.Graphics;

import com.morefuntek.cell.CMath;
import com.morefuntek.cell.Game.CSprite;
import com.morefuntek.cell.Game.IState;

public class UnitWorldEvent extends CSprite {

	
	static public int OutX = 0;
	static public int OutY = 32;
	
	public int Type = 0;
	
	public String Info  = null;
	public String Level = null;
	
	int FloatSpeed = 4 + Math.abs(Random.nextInt()%4);
	int FloatTime = Random.nextInt() % 360;
	int Float = 0;
	
	public boolean Destoryed =false;
	
	
	public UnitWorldEvent(CSprite stuff){
		super(stuff);
	}
	
	public void setLevel(String info){
		try{
			Info = info;
			int start = info.indexOf("lv:");
			if(start<0){
				Level = null;
			}else{
				Level = info.substring(start + "lv:".length());
			}
		}catch(Exception err){
			Level = null;
		}
	}
	
	
	public void update() {
		Float = CMath.sinTimes256(getTimer()*FloatSpeed + FloatTime)*4/256;
		nextCycFrame();
		
	}

	public void render(Graphics g, int x, int y) {
		if(OnScreen){
		//super.render(g, x, y);
		if (Visible) {
			animates.render(g,FrameAnimate[CurAnimate][CurFrame],x,y+Float);
			if(!Destoryed){
				animates.render(g,FrameAnimate[9][getTimer()%3],x,y);
			}
		}
//#ifdef _DEBUG
		if (Active && IsDebug){
			collides.render(g,FrameCDMap[CurAnimate][CurFrame],x,y,0xff00ff00);
			collides.render(g,FrameCDAtk[CurAnimate][CurFrame],x,y,0xffff0000);
			collides.render(g,FrameCDDef[CurAnimate][CurFrame],x,y,0xff0000ff);
			collides.render(g,FrameCDExt[CurAnimate][CurFrame],x,y,0xffffffff);
		}
//#endif
		}
	}

	
	
}

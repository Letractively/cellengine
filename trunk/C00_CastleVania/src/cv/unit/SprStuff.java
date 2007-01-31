package cv.unit;

import javax.microedition.lcdui.Graphics;

import com.cell.game.CSprite;

public class SprStuff extends CSprite  {

	
	
	
	public SprStuff(CSprite spr) {
		super(spr);
		haveSprBlock = false;
		haveMapBlock = true;
	}

	public void render(Graphics g, int x, int y) {
		super.render(g, x, y);
		if(IsDebug)
		super.collides.render(g, 0, x, y, 0xff00ff00);
	}
	
	
	public boolean actMoveY(int y){
		if(y==0)return false;
		int dstY = Y + y;
		int dy = (y!=0?(y<0?-1:1):0);
		Y+=y;
		boolean ret = false;
		
		if(this.haveMapBlock){
			int prewAnimate = CurAnimate;
			int prewFrame   = CurFrame;
			setCurrentFrame(0, 0);
			boolean adjustMap = false;
			
			collides.getCD(0).Mask = 0xffff;
			adjustMap = touch_SprSub_Map(this,CD_TYPE_MAP,0,this.world.Map);
			collides.getCD(0).Mask = 0xffff - 0x02;
			
			if(adjustMap){
				Y-=y;
				while(Y!=dstY){
					Y+=dy;
					if(touch_Spr_Map(this,CD_TYPE_MAP,this.world.Map)){
						Y-=dy;
						ret = true;
						break;
					}
				}
			}
			setCurrentFrame(prewAnimate, prewFrame);
		}
		
		return ret;
	}
	
	public boolean actMoveX(int x){
		if(x==0)return false;
		int dstX = X + x;
		int dx = (x!=0?(x<0?-1:1):0);
		X+=x;
		boolean ret = false;
		
		if(this.haveMapBlock){
			int prewAnimate = CurAnimate;
			int prewFrame   = CurFrame;
			setCurrentFrame(0, 0);
			boolean adjustMap = false;
			adjustMap = touch_SprSub_Map(this,CD_TYPE_MAP,0,this.world.Map);

			if(adjustMap){
				X-=x;
				while(X!=dstX){
					X+=dx;
					if(touch_SprSub_Map(this,CD_TYPE_MAP,0,this.world.Map)){
						X-=dx;
						ret = true;
						break;
					}
				}
			}
			setCurrentFrame(prewAnimate, prewFrame);
		}
		
		return ret;
	}
	
	

	public boolean isLand(){
		int prewAnimate = CurAnimate;
		int prewFrame   = CurFrame;
		setCurrentFrame(0, 0);

		boolean flag = CSprite.touch_SprSub_Map(
				this, 
				CD_TYPE_EXT, 0, 
				world.getMap()
				);

		setCurrentFrame(prewAnimate, prewFrame);
		return flag;
	}
//	-------------------------------------------------------------------------------------------

//	-------------------------------------------------------------------------------------------

	
}

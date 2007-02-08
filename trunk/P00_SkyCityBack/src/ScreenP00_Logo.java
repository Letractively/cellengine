import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

import com.cell.*;
import com.cell.game.*;
import com.cell.particle.*;


/**
 * LOGO界面
 * 每个界面必须实现4个抽象方法，
 * @author yifeizhang
 * @since 2006-12-30 
 * @version 1.0
 */
public class ScreenP00_Logo extends AScreen {

    private Image splogo;
    
    int index = 0 ;
    
    private String[] list = new String[]{
    		"ScreenP00_Menu",
    };
    
	public ScreenP00_Logo() {
		FrameDelay = 25;
		KeyEnable = true;
		LogicEnable = true;
		RenderEnable = true;
		

		
//		for(int i=0;i<360;i++){
//			int x = CMath.cosTimes256(i);
//			int y = CMath.sinTimes256(i);
//			
//			int angle = CMath.cycNum(CMath.atan2(y, x), 0, 360);
//			
//			println(i + " : " + angle );
//		}
		
	}

	public void notifyLogic() {
		if(isKeyHold(KEY_B)){AScreen.ExitGame = true;}
		
		if(isKeyDown(KEY_DOWN)){
			index ++;
			if(index>=list.length-1)index = list.length - 1;
		}
		if(isKeyDown(KEY_UP)){
			index --;
			if(index<0)index = 0;
		}
		if(isKeyDown(KEY_C|KEY_A)){
			if(!isTransition()){
				ChangeSubScreen(list[index]);
			}
		}
		
	}

	public void notifyRender(Graphics g) {
		clearScreenAndClip(g,0xffffffff);
		for(int i=0;i<list.length;i++){
			drawString(g, 
					list[i], 
					1, 
					1 + (AScreen.getStringHeight()+1) * i, 
					i==index /*&& getTimer()%2==0*/ ? 0xff808080 : 0xff000000 );
		}
		
    }

	  
	public void notifyPause(){ 
	}
	    
	public void notifyResume(){
	}
	
	
}

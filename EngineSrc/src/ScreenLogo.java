
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

import com.morefuntek.cell.Game.CScreen;



//import CSLib20.CSTileGroup;

//import CSLib40.*;



final public class ScreenLogo extends CScreen {

    private Image splogo;
    
    int index = 0 ;
    
    private String[] list = new String[]{
    		"ScreenMain",
    		"ScreenMain2",
    		"ScreenTD_Main",
    };
    
	public ScreenLogo() {
		FrameDelay = 20;
		KeyEnable = true;
		LogicEnable = true;
		RenderEnable = true;
	}

	public void notifyLogic() {
		if(isKeyHold(KEY_0)){GameMIDlet.ExitGame = true;}
		
		if(isKeyDown(KEY_DOWN)){
			index ++;
			if(index>=list.length-1)index = list.length - 1;
		}
		if(isKeyDown(KEY_UP)){
			index --;
			if(index<0)index = 0;
		}
		if(isKeyDown(KEY_C)){
			if(!isTransition()){
				ChangeSubSreen(list[index]);
			}
		}
		
	}

	public void notifyRender(Graphics g) {
		clearScreenAndClip(g,0xffffffff);
		for(int i=0;i<list.length;i++){
			drawString(g, 
					list[i], 
					1, 
					1 + (CScreen.getStringHeight()+1) * i, 
					i==index /*&& getTimer()%2==0*/ ? 0xff808080 : 0xff000000 );
		}
		
    }

	  
	public void notifyPause(){ 
	}
	    
	public void notifyResume(){
	}
	
	
}
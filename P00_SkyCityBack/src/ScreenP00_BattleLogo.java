import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

import com.morefuntek.cell.CMath;
import com.morefuntek.cell.Game.AScreen;

public class ScreenP00_BattleLogo extends AScreen {

    int index = 0 ;
    
    private String[] list ;
    
	public ScreenP00_BattleLogo() {
		FrameDelay = 20;
		KeyEnable = true;
		LogicEnable = true;
		RenderEnable = true;
		
		list = new String[ResesScript.WorldNames.length-1];
		for(int i=0;i<list.length;i++){
			list[i] = ResesScript.WorldNames[1 + i];
			println( list[i] );
		}
		
	}

	public void notifyLogic() {
		if(isKeyHold(KEY_B)){ChangeSubScreen("ScreenP00_Logo");}
//		if(isKeyHold(KEY_A)){}
		
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
				ScreenP00_Battle.WorldName = list[index];
				ChangeSubScreen("ScreenP00_BattleConfig");
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

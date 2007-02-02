import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

import com.morefuntek.cell.CImages20;
import com.morefuntek.cell.IImages;
import com.morefuntek.cell.Game.AScreen;
import com.morefuntek.cell.Game.CSprite;


public class ScreenP00_Menu extends AScreen {


	IImages tiles ;
    CSprite menu  ;
    
    int index = 0 ;
    
    private String[] list = new String[]{
    		"ScreenP00_World",
    		"",
    		"",
    		"",
    		"",
    		"Exit",
    };
    
    
	public ScreenP00_Menu() {
		FrameDelay = 20;
		KeyEnable = true;
		LogicEnable = true;
		RenderEnable = true;
		
		tiles = ResesScript.createClipImages_menuTile();
		menu = ResesScript.createSprite_openSprite(tiles);

	}

	public void notifyLogic() {
		if(isKeyHold(KEY_B)){AScreen.ExitGame = true;}
		
		if(isKeyDown(KEY_LEFT)){
			index ++;
			if(index>list.length-1){
				index = 0;
			}
		}
		if(isKeyDown(KEY_RIGHT)){
			index --;
			if(index<0){
				index = list.length-1;
			}
		}
		
		if(isKeyDown(KEY_C|KEY_A)){
			if(!isTransition()){
				if(list[index].length()>0){
					ChangeSubScreen(list[index]);
				}
			}
		}
		
		tickTimer();
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
		
		menu.setCurrentFrame(0, 0);
		menu.render(g, SCREEN_WIDTH/2, SCREEN_HEIGHT/2);
		
		menu.setCurrentFrame(1, index);
		menu.render(g, SCREEN_WIDTH/2, SCREEN_HEIGHT/2);
		
		menu.setCurrentFrame(2, getTimer()%menu.getFrameCount(2));
		menu.render(g, SCREEN_WIDTH/2, SCREEN_HEIGHT/2);
    }

	  
	public void notifyPause(){ 
	}
	    
	public void notifyResume(){
	}
	
	

}

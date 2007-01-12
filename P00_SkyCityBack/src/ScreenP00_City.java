import game.unit.battle.UnitActor;
import game.unit.battle.UnitBullet;
import game.unit.battle.UnitEnemy;

import javax.microedition.lcdui.Graphics;

import com.morefuntek.cell.CImages20;
import com.morefuntek.cell.CImagesNokia;
import com.morefuntek.cell.IImages;
import com.morefuntek.cell.Game.AScreen;
import com.morefuntek.cell.Game.CCamera;
import com.morefuntek.cell.Game.CMap;
import com.morefuntek.cell.Game.CSprite;
import com.morefuntek.cell.Game.CWorld;


public class ScreenP00_City extends AScreen {

	int index = 0;
	String[] list = new String[]{
			"GiveUp",
			"Trade",
			"Config",
			"Exit"
	};
	
	public ScreenP00_City(){}
	
	public void notifyLogic() {
		if(isKeyDown(KEY_B)){ExitGame = true;}
    	
		if(isKeyDown(KEY_DOWN)){
			index ++;
			if(index>=list.length-1)index = list.length - 1;
		}
		if(isKeyDown(KEY_UP)){
			index --;
			if(index<0)index = 0;
		}
		if(isKeyDown(KEY_C|KEY_A)){
			if(index == 3 && !isTransition()){
				ChangeSubScreen("ScreenP00_Logo");
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

	
	public void notifyPause() {}
	public void notifyResume() {}

	
}

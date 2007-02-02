import game.unit.battle.UnitBattleActor;
import game.unit.battle.UnitBattleSub;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

import com.morefuntek.cell.CMath;
import com.morefuntek.cell.Game.AScreen;

public class ScreenP00_BattleConfig extends AScreen {

    int index = 0 ;
    int[] subIndex ;
    
    private String[][] list = new String[][]{
    	{
    		"Ö÷ÎäÆ÷",//
    		"¼¤¹âÅÚ",
    		"¾ŞĞÍÓãÀ×",
    		"±¬Ê½ö±µ¯",
    		"±¬µ¯",
    		"·Éµ¯",
    	},{
    		"¸¨ÖúÎäÆ÷ÊıÁ¿"	,//
    			"0",
    			"1",
    			"2",
    			"3",
    			"4"
    	},{
        	"¸¨ÖúÎäÆ÷1",//
				"¹âÏßÇ¹",
				"ö±µ¯Ç¹",
				"×·×Ùµ¯",
				"¼¯Êøµ¯"
    	},{
        	"¸¨ÖúÎäÆ÷2",//
				"¹âÏßÇ¹",
				"ö±µ¯Ç¹",
				"×·×Ùµ¯",
				"¼¯Êøµ¯"
    	}
    };
    
	public ScreenP00_BattleConfig() {
		subIndex = new int[list.length];
		for(int i=0;i<subIndex.length;i++){
			subIndex[i] = 1;
		}
	}

	public void notifyLogic() {
		if(isKeyHold(KEY_B)){ChangeSubScreen("ScreenP00_Logo");}
		
		// lable
		if(isKeyDown(KEY_DOWN)){
			index ++;
			if(index>list.length-1)index = 0;
		}
		if(isKeyDown(KEY_UP)){
			index --;
			if(index<0)index = list.length-1;
		}
		// sub
		if(list[index].length>=1){
			if(isKeyDown(KEY_LEFT)){
				subIndex[index] ++;
				if(subIndex[index]>list[index].length-1)subIndex[index] = 1;
			}
			if(isKeyDown(KEY_RIGHT)){
				subIndex[index] --;
				if(subIndex[index]<1)subIndex[index] = list[index].length-1;
			}
		}
		
		if(isKeyDown(KEY_C|KEY_A|KEY_5)){
			if(!isTransition()){
				
				UnitBattleActor.WeaopnType = subIndex[0]-1;
				UnitBattleSub.SubCount = subIndex[1]-1;
				
				UnitBattleSub.WeaopnType[0] = subIndex[2]-1;
				UnitBattleSub.WeaopnType[1] = subIndex[2]-1;
				
				UnitBattleSub.WeaopnType[2] = subIndex[3]-1;
				UnitBattleSub.WeaopnType[3] = subIndex[3]-1;
				
				ChangeSubScreen("ScreenP00_Battle");
				
			}
		}
		
		tickTimer();
	}

	public void notifyRender(Graphics g) {
		clearScreenAndClip(g,0xffffffff);
		for(int i=0;i<list.length;i++){
			drawString(g, 
					list[i][0] 
					+ ( getTimer()/8%2==0 ? "--" : "<-" )
					+ list[i][subIndex[i]]
					+ ( getTimer()/8%2==0 ? "--" : "->" )
					, 
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

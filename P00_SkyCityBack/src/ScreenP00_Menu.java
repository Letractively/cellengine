import game.unit.battle.UnitBattleActor;
import game.unit.battle.UnitBattleSub;
import game.unit.world.UnitWorldActor;

import java.util.Date;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.TextBox;
import javax.microedition.rms.RecordStore;

import com.morefuntek.cell.CIO;
import com.morefuntek.cell.CImages20;
import com.morefuntek.cell.CMath;
import com.morefuntek.cell.CSoundPlayer;
import com.morefuntek.cell.IImages;
import com.morefuntek.cell.GUI.CTextBox;
import com.morefuntek.cell.Game.AScreen;
import com.morefuntek.cell.Game.CCamera;
import com.morefuntek.cell.Game.CMap;
import com.morefuntek.cell.Game.CSprite;
import com.morefuntek.cell.Game.CWorld;


public class ScreenP00_Menu extends AScreen {

	static public CSoundPlayer player ;
	
	
	static public int SaveID = 0;
	
	
	final int SUB_START   = 0;
	final int SUB_DEL     = 1;
	final int SUB_HELP    = 2;
	final int SUB_ABOUT   = 3;
	final int SUB_CONFIG  = 4;
	final int SUB_EXIT    = 5;
	
	int state = -1;
	
	CWorld bg;

	IImages sprTiles ;
	IImages mapTiles ;
    
	CSprite menu  ;
    
    
    
    int index = 0 ;
    
    private String[] list = new String[]{
    		"ScreenP00_World",//new 
    		"",//load
    		"",//help
    		"",//about
    		"",//option
    		"Exit",
    };
    
    
	public ScreenP00_Menu() {
		if(ScreenP00_Menu.player!=null){
			ScreenP00_Menu.player.destroy();
		}
		
		try{
			ScreenP00_Menu.player = new CSoundPlayer("/BGMUI.mid",CSoundPlayer.TYPE_MIDI,-1);
			ScreenP00_Menu.player.play();
		}catch(Exception err){
		}
		
		FrameDelay = 20;
		KeyEnable = true;
		LogicEnable = true;
		RenderEnable = true;
		
		sprTiles = ResesScriptUI.createClipImages_menuTile();
		mapTiles = ResesScriptUI.createClipImages_opMap_Tile();
			
		menu = ResesScriptUI.createSprite_openSprite(sprTiles);

		CMap map = ResesScriptUI.createMap_unamed_Map(mapTiles, false, true);
		CCamera cam = new CCamera(
       			0,0,
       			AScreen.SCREEN_WIDTH,
       			AScreen.SCREEN_HEIGHT,
       			map,false,0
       			);
		
		bg = new CWorld();
		bg.addMap(map);
		bg.addCamera(cam);
	}

	public void notifyLogic() {
		
		switch(state){
		case SUB_START:
			startLogic();
			break;
		case SUB_DEL:
			delLogic();
			break;
		case SUB_HELP:
			helpLogic();
			break;
		case SUB_ABOUT:
			aboutLogic();
			break;
		case SUB_CONFIG:
			configLogic();
			break;
		default:
			if(isKeyDown(KEY_LEFT)){
				index = CMath.cycNum(index, -1, list.length);
			}
			if(isKeyDown(KEY_RIGHT)){
				index = CMath.cycNum(index,  1, list.length);
			}
			if(isKeyDown(KEY_C|KEY_A)){
				switch(index){
				case SUB_START:
					startInit();
					break;
				case SUB_DEL:
					delInit();
					break;
				case SUB_HELP:
					helpInit();
					break;
				case SUB_ABOUT:
					aboutInit();
					break;
				case SUB_CONFIG:
					configInit();
					break;
				case SUB_EXIT:
					ExitGame = true;
					break;
				}
			}
			
			
		}
	}

	public void notifyRender(Graphics g) {
//		clearScreenAndClip(g,0xffffffff);
		bg.render(g);
		bg.getCamera().mov(-1, 0);
		
		
		switch(state){
		case SUB_START:
			startRender(g);
			break;
		case SUB_DEL:
			delRender(g);
			break;
		case SUB_HELP:
			helpRender(g);
			break;
		case SUB_ABOUT:
			aboutRender(g);
			break;
		case SUB_CONFIG:
			configRender(g);
			break;
		default:
			menu.setCurrentFrame(0, 0);
			menu.render(g, SCREEN_WIDTH/2, SCREEN_HEIGHT/2 + CMath.sinTimes256(getTimer()*4)/32);
			menu.setCurrentFrame(1, index);
			menu.render(g, SCREEN_WIDTH/2, SCREEN_HEIGHT/2);
			menu.setCurrentFrame(2, getTimer()%menu.getFrameCount(2));
			menu.render(g, SCREEN_WIDTH/2, SCREEN_HEIGHT/2);
			break;
		}
		
		CTextBox.showTextBox(g);
		
		tickTimer();
    }

	  
	public void notifyPause(){ 
		try{
			ScreenP00_Menu.player.pause();
		}catch(Exception err){
		}
	}
	public void notifyResume() {
		try{
			ScreenP00_Menu.player.resume();
		}catch(Exception err){
		}
	}

	
//	-----------------------------------------------------------------------------------------

	String startList[] ; 
	int startIndex = 0 ;
	
	public void startInit(){
		
		state = SUB_START;
		
		startList = new String[4];
//		startIndex = 0;
		
		ScreenP00_World.Load();
		
		for(int i=0;i<startList.length;i++){
			String info = ScreenP00_World.getSaveInfo(i);
			if(info.length()!=0){
				startList[i] = info;
			}else{
				startList[i] = "(新游戏)";
			}
		}
		
	}
	
	void startLogic(){
		if(isKeyDown(KEY_UP)){
			startIndex = CMath.cycNum(startIndex, -1, startList.length);
		}
		if(isKeyDown(KEY_DOWN)){
			startIndex = CMath.cycNum(startIndex,  1, startList.length);
		}
		
		if(isKeyDown(KEY_C|KEY_A)){
			ScreenP00_World.SavePos = startIndex ;
			ScreenP00_World.Load();
			if(!isTransition()){
				if(startList[startIndex].indexOf("(新游戏)")>=0){
					UnitWorldActor.ActorX = 1440;
					UnitWorldActor.ActorY = 1312;
					UnitWorldActor.ActorDirect = 90;
					
					ScreenP00_World.HelpState = 0;
				}else{
					ScreenP00_World.HelpState = -1;
				}
				ChangeSubScreen("ScreenP00_World");
			}
		}
		if(isKeyDown(KEY_B)){
			state = -1;
		}
	}
	
	void startRender(Graphics g){

    	int h = (getStringHeight() + 1) * startList.length;
    	int y = SCREEN_HEIGHT/2 - h/2;
    	
    	g.setColor(0xff8080ff);
    	g.fillRect(0, y, SCREEN_WIDTH, h);
    	g.setColor(0xffffffff);
    	g.drawRect(0, y, SCREEN_WIDTH-1, h-1);
    	
    	for(int i=0;i<startList.length;i++){
    		if(i==startIndex){
    			g.setColor(0xff0000ff);
            	g.fillRect(0, y + (getStringHeight() + 1) * i, SCREEN_WIDTH, (getStringHeight() + 1));
            	g.setColor(0xffffffff);
            	g.drawRect(0, y + (getStringHeight() + 1) * i, SCREEN_WIDTH-1, (getStringHeight() - 1));
            	
            	drawString(g, startList[i], 
        				SCREEN_WIDTH/2 - getStringWidth(startList[i])/2, 
        				y + (getStringHeight() + 1) * i , 
        				0xffffffff);
    		}else{
    			drawString(g, startList[i], 
        				SCREEN_WIDTH/2 - getStringWidth(startList[i])/2, 
        				y + (getStringHeight() + 1) * i , 
        				0xff000000);
    		}
    	}
    	
    	int aw = getStringWidth("确定") +4;
    	int ah = getStringHeight() +4;
    	int ax = 1;
    	int ay = SCREEN_HEIGHT - ah - 1;
    	g.setColor(0xffff8080);
    	g.fillRect(ax, ay, aw, ah);
    	g.setColor(0xffffffff);
    	g.drawRect(ax, ay, aw, ah);
    	drawString(g, "确定", ax+2, ay+2, 0xffffffff);
    	
    	int bw = getStringWidth("取消")+4;
    	int bh = getStringHeight()+4;
    	int bx = SCREEN_WIDTH  - bw - 1;
    	int by = SCREEN_HEIGHT - bh - 1;
    	g.setColor(0xffff8080);
    	g.fillRect(bx, by, bw, bh);
    	g.setColor(0xffffffff);
    	g.drawRect(bx, by, bw, bh);
    	drawString(g, "取消", bx+2, by+2, 0xffffffff);
	}
	
	
//	-----------------------------------------------------------------------------------------

	String delList[] ; 
	int delIndex = 0;
	
	public void delInit(){
		
		state = SUB_DEL;
		
		delList = new String[4];
//		delIndex = 0;
		
		ScreenP00_World.Load();
		
		for(int i=0;i<delList.length;i++){
			String info = ScreenP00_World.getSaveInfo(i);
			if(info.length()!=0){
				delList[i] = info;
			}else{
				delList[i] = "(空)";
			}
		}
		
	}
	
	void delLogic(){
		if(isKeyDown(KEY_UP)){
			delIndex = CMath.cycNum(delIndex, -1, delList.length);
		}
		if(isKeyDown(KEY_DOWN)){
			delIndex = CMath.cycNum(delIndex,  1, delList.length);
		}
		
		if(isKeyDown(KEY_C|KEY_A)){
			ScreenP00_World.SavePos = delIndex ;
			ScreenP00_World.Clean();
			delInit();
		}
		if(isKeyDown(KEY_B)){
			state = -1;
		}
	}
	
	void delRender(Graphics g){

    	int h = (getStringHeight() + 1) * delList.length;
    	int y = SCREEN_HEIGHT/2 - h/2;
    	
    	g.setColor(0xff8080ff);
    	g.fillRect(0, y, SCREEN_WIDTH, h);
    	g.setColor(0xffffffff);
    	g.drawRect(0, y, SCREEN_WIDTH-1, h-1);
    	
    	for(int i=0;i<delList.length;i++){
    		if(i==delIndex){
    			g.setColor(0xff0000ff);
            	g.fillRect(0, y + (getStringHeight() + 1) * i, SCREEN_WIDTH, (getStringHeight() + 1));
            	g.setColor(0xffffffff);
            	g.drawRect(0, y + (getStringHeight() + 1) * i, SCREEN_WIDTH-1, (getStringHeight() - 1));
            	
            	drawString(g, delList[i], 
        				SCREEN_WIDTH/2 - getStringWidth(delList[i])/2, 
        				y + (getStringHeight() + 1) * i , 
        				0xffffffff);
    		}else{
    			drawString(g, delList[i], 
        				SCREEN_WIDTH/2 - getStringWidth(delList[i])/2, 
        				y + (getStringHeight() + 1) * i , 
        				0xff000000);
    		}
    	}
    	int aw = getStringWidth("删除") +4;
    	int ah = getStringHeight() +4;
    	int ax = 1;
    	int ay = SCREEN_HEIGHT - ah - 1;
    	g.setColor(0xffff8080);
    	g.fillRect(ax, ay, aw, ah);
    	g.setColor(0xffffffff);
    	g.drawRect(ax, ay, aw, ah);
    	drawString(g, "删除", ax+2, ay+2, 0xffffffff);
    	
    	int bw = getStringWidth("取消")+4;
    	int bh = getStringHeight()+4;
    	int bx = SCREEN_WIDTH  - bw - 1;
    	int by = SCREEN_HEIGHT - bh - 1;
    	g.setColor(0xffff8080);
    	g.fillRect(bx, by, bw, bh);
    	g.setColor(0xffffffff);
    	g.drawRect(bx, by, bw, bh);
    	drawString(g, "取消", bx+2, by+2, 0xffffffff);
	}
	
//	-----------------------------------------------------------------------------------------
	String helpText = 
		
		"游戏简介\n" +
		"这是一款风格独特的飞行射击游戏。" +
		"玩家扮演一名浮空战舰舰长，立志" +
		"要驱逐盘踞在浮空大陆的海盗，为" +
		"此驾驶着父亲遗留下来的传奇战舰" +
		"-战神号，书写一段新的传奇。\n"+
		"\n"+
		
		"游戏玩法\n"+
		"玩家通过方向键操控战舰在云海翱翔，" +
		"地图上的建筑和岛屿都盘踞着海盗，" +
		"接触这些岛屿就会触发战斗，战斗是" +
		"横版射击，通过反向键控制战舰移动。" +
		"在战斗之前，可以通过界面提示购买" +
		"武器，在战斗中使用1＃、3＃、5＃激" +
		"活武器，然后消灭战斗场景内的所有敌" +
		"人就可过关，当玩家把地图内7座城堡" +
		"内的海盗头目都打败，海盗们就认输退" +
		"出大陆了。注意，武器子弹有限制，战" +
		"斗中一定要控制好子弹的发射频率。\n"+
		"\n"+
		
		"游戏按键\n"+
		"大地图内\n"+
		"方向键上   前进/加速\n"+
		"方向键下   减速/倒退\n"+
		"方向键左右 转向\n"+
		"\n"+
		
		"战斗场景内\n"+
		"1＃ 主武器开关\n"+
		"3＃ 副武器开关\n"+
		"5＃ 射击开关\n"+
		"7＃ 攻击阵形调整\n"+
		"\n"+
		
		"左软键 确定/菜单\n" +
		"右软键 返回/菜单\n" +
		"\n"+
		""
		;
	
	
	public void helpInit(){
		state = SUB_HELP;
		CTextBox.setTextBox(helpText,null,1,1,SCREEN_WIDTH-2,SCREEN_HEIGHT-2);
	}
	
	void helpLogic(){
		if(isKeyDown(KEY_LEFT)){
			CTextBox.vScroll(-(SCREEN_HEIGHT-32));
		}
		if(isKeyDown(KEY_RIGHT)){
			CTextBox.vScroll( (SCREEN_HEIGHT-32));
		}
		if(isKeyHold(KEY_UP)){
			CTextBox.vScroll(-getStringHeight()/2);
		}
		if(isKeyHold(KEY_DOWN)){
			CTextBox.vScroll( getStringHeight()/2);
		}
		if(isKeyDown(KEY_A|KEY_B|KEY_C)){
			CTextBox.closeTextBox();
			state = -1;
		}
	}
	
	void helpRender(Graphics g){
		
	}
	
//	-----------------------------------------------------------------------------------------
	
	String aboutText = "关于";
	
	public void aboutInit(){
		state = SUB_ABOUT;

		CTextBox.setTextBox(aboutText,null,1,1,SCREEN_WIDTH-2,SCREEN_HEIGHT-2);
	}
	
	void aboutLogic(){
		if(isKeyDown(KEY_LEFT)){
			CTextBox.vScroll(-(SCREEN_HEIGHT-32));
		}
		if(isKeyDown(KEY_RIGHT)){
			CTextBox.vScroll( (SCREEN_HEIGHT-32));
		}
		if(isKeyHold(KEY_UP)){
			CTextBox.vScroll(-getStringHeight()/2);
		}
		if(isKeyHold(KEY_DOWN)){
			CTextBox.vScroll( getStringHeight()/2);
		}
		if(isKeyDown(KEY_A|KEY_B|KEY_C)){
			CTextBox.closeTextBox();
			state = -1;
		}
	}
	
	void aboutRender(Graphics g){
		
	}
	
//	-----------------------------------------------------------------------------------------
	
	
	
//	------------------------------------------------------------------------------------------------------------

 	int ConfigIndex = 0 ;
    int[] ConfigSubIndex ;

    final private String[][] configlist = new String[][]{
    	{
    		"声音",//
	    		"开",
	    		"关",
    	}
    };
    
	public void configInit() {

		state = SUB_CONFIG;
		
		ConfigSubIndex = new int[configlist.length];

		ConfigSubIndex[0] = CSoundPlayer.SoundEnable?1:2;
//		ConfigSubIndex[1] = 1;
//		ConfigSubIndex[2] = 1;
	}

	void configLogic() {
		if(isKeyHold(KEY_B)){
		}
		
		// lable
		if(isKeyDown(KEY_DOWN)){
			ConfigIndex = CMath.cycNum(ConfigIndex,  1, configlist.length);
		}
		if(isKeyDown(KEY_UP)){
			ConfigIndex = CMath.cycNum(ConfigIndex, -1, configlist.length);
		}
		// sub
		if(configlist[ConfigIndex].length>=1){
			if(isKeyDown(KEY_LEFT)){
				ConfigSubIndex[ConfigIndex] = 1 + CMath.cycNum(ConfigSubIndex[ConfigIndex]-1, -1, configlist[ConfigIndex].length - 1);
			}
			if(isKeyDown(KEY_RIGHT)){
				ConfigSubIndex[ConfigIndex] = 1 + CMath.cycNum(ConfigSubIndex[ConfigIndex]-1,  1, configlist[ConfigIndex].length - 1);
			}
		}
		
		if(isKeyDown(KEY_C|KEY_A|KEY_B)){
			state = -1;
			switch(ConfigIndex){
			case 0:
				switch(ConfigSubIndex[ConfigIndex]){
				case 1:
					CSoundPlayer.SoundEnable = true;
					if(ScreenP00_Menu.player!=null){
						ScreenP00_Menu.player.destroy();
					}
					try{
						ScreenP00_Menu.player = new CSoundPlayer("/BGMUI.mid",CSoundPlayer.TYPE_MIDI,-1);
						ScreenP00_Menu.player.play();
					}catch(Exception err){
					}
					break;
				case 2:
					CSoundPlayer.SoundEnable = false;
					try{
						ScreenP00_Menu.player.destroy();
					}catch(Exception err){
					}
					break;
				}
			}
			
			
		}
	
	}

	void configRender(Graphics g) {

		int[] menu_c = new int[]{
				0xff000000,
//				0xff000000,
//				0xff000000,
		};
		
		String[] menu_h = new String[]{
				configlist[0][0],
//				configlist[1][0],
//				configlist[2][0],
		};
		String[] menu_t = new String[]{
				configlist[0][ConfigSubIndex[0]],
//				configlist[1][ConfigSubIndex[1]],
//				configlist[2][ConfigSubIndex[2]],
		};

		int h = (getStringHeight() + 1) * menu_h.length;
    	int y = SCREEN_HEIGHT/2 - h/2;
    	
    	g.setColor(0xff8080ff);
    	g.fillRect(0, y, SCREEN_WIDTH, h);
    	g.setColor(0xffffffff);
    	g.drawRect(0, y, SCREEN_WIDTH-1, h-1);
    	
    	for(int i=0;i<menu_h.length;i++){
    		if(i==ConfigIndex){
    			g.setColor(0xff0000ff);
            	g.fillRect(0, y + (getStringHeight() + 1) * i, SCREEN_WIDTH  , (getStringHeight() + 1));
            	g.setColor(0xffffffff);
            	g.drawRect(0, y + (getStringHeight() + 1) * i, SCREEN_WIDTH-1, (getStringHeight() - 1));
            	
            	drawString(g, menu_h[i] + " : ", 
        				SCREEN_WIDTH/2 - getStringWidth(menu_h[i]+" : ") , 
        				y + (getStringHeight() + 1) * i , 
        				0xffffffff);
            	drawString(g, menu_t[i], 
        				SCREEN_WIDTH/2 + SCREEN_WIDTH/4 - getStringWidth(menu_t[i])/2, 
        				y + (getStringHeight() + 1) * i , 
        				0xffffffff);
            	
            	drawString(g, "<", 
            			SCREEN_WIDTH/2 + 8 - getStringWidth("<")/2
        				+ CMath.sinTimes256(getTimer()*16)/64, 
        				y + (getStringHeight() + 1) * i , 
        				0xffffffff);
            	
            	drawString(g, ">", 
        				SCREEN_WIDTH - 8 - getStringWidth("<")/2
        				- CMath.sinTimes256(getTimer()*16)/64, 
        				y + (getStringHeight() + 1) * i , 
        				0xffffffff);
            	
    		}else{
    			
    			drawString(g, menu_h[i] + " : ", 
        				SCREEN_WIDTH/2 - getStringWidth(menu_h[i]+" : "), 
        				y + (getStringHeight() + 1) * i , 
        				menu_c[i]);
    			drawString(g, menu_t[i], 
        				SCREEN_WIDTH/2 + SCREEN_WIDTH/4 - getStringWidth(menu_t[i])/2, 
        				y + (getStringHeight() + 1) * i , 
        				menu_c[i]);
    		}
    	}
    	
    	int aw = getStringWidth("确定") +4;
    	int ah = getStringHeight() +4;
    	int ax = 1;
    	int ay = SCREEN_HEIGHT - ah - 1;
    	g.setColor(0xffff8080);
    	g.fillRect(ax, ay, aw, ah);
    	g.setColor(0xffffffff);
    	g.drawRect(ax, ay, aw, ah);
    	drawString(g, "确定", ax+2, ay+2, 0xffffffff);
    	
    	int bw = getStringWidth("取消")+4;
    	int bh = getStringHeight()+4;
    	int bx = SCREEN_WIDTH  - bw - 1;
    	int by = SCREEN_HEIGHT - bh - 1;
    	g.setColor(0xffff8080);
    	g.fillRect(bx, by, bw, bh);
    	g.setColor(0xffffffff);
    	g.drawRect(bx, by, bw, bh);
    	drawString(g, "取消", bx+2, by+2, 0xffffffff);
    	
    }

	  
}

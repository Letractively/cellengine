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
				startList[i] = "(����Ϸ)";
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
				if(startList[startIndex].indexOf("(����Ϸ)")>=0){
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
    	
    	int aw = getStringWidth("ȷ��") +4;
    	int ah = getStringHeight() +4;
    	int ax = 1;
    	int ay = SCREEN_HEIGHT - ah - 1;
    	g.setColor(0xffff8080);
    	g.fillRect(ax, ay, aw, ah);
    	g.setColor(0xffffffff);
    	g.drawRect(ax, ay, aw, ah);
    	drawString(g, "ȷ��", ax+2, ay+2, 0xffffffff);
    	
    	int bw = getStringWidth("ȡ��")+4;
    	int bh = getStringHeight()+4;
    	int bx = SCREEN_WIDTH  - bw - 1;
    	int by = SCREEN_HEIGHT - bh - 1;
    	g.setColor(0xffff8080);
    	g.fillRect(bx, by, bw, bh);
    	g.setColor(0xffffffff);
    	g.drawRect(bx, by, bw, bh);
    	drawString(g, "ȡ��", bx+2, by+2, 0xffffffff);
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
				delList[i] = "(��)";
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
    	int aw = getStringWidth("ɾ��") +4;
    	int ah = getStringHeight() +4;
    	int ax = 1;
    	int ay = SCREEN_HEIGHT - ah - 1;
    	g.setColor(0xffff8080);
    	g.fillRect(ax, ay, aw, ah);
    	g.setColor(0xffffffff);
    	g.drawRect(ax, ay, aw, ah);
    	drawString(g, "ɾ��", ax+2, ay+2, 0xffffffff);
    	
    	int bw = getStringWidth("ȡ��")+4;
    	int bh = getStringHeight()+4;
    	int bx = SCREEN_WIDTH  - bw - 1;
    	int by = SCREEN_HEIGHT - bh - 1;
    	g.setColor(0xffff8080);
    	g.fillRect(bx, by, bw, bh);
    	g.setColor(0xffffffff);
    	g.drawRect(bx, by, bw, bh);
    	drawString(g, "ȡ��", bx+2, by+2, 0xffffffff);
	}
	
//	-----------------------------------------------------------------------------------------
	String helpText = 
		
		"��Ϸ���\n" +
		"����һ������صķ��������Ϸ��" +
		"��Ұ���һ������ս����������־" +
		"Ҫ�����̾��ڸ��մ�½�ĺ�����Ϊ" +
		"�˼�ʻ�Ÿ������������Ĵ���ս��" +
		"-ս��ţ���дһ���µĴ��档\n"+
		"\n"+
		
		"��Ϸ�淨\n"+
		"���ͨ��������ٿ�ս�����ƺ����裬" +
		"��ͼ�ϵĽ����͵��춼�̾��ź�����" +
		"�Ӵ���Щ����ͻᴥ��ս����ս����" +
		"��������ͨ�����������ս���ƶ���" +
		"��ս��֮ǰ������ͨ��������ʾ����" +
		"��������ս����ʹ��1����3����5����" +
		"��������Ȼ������ս�������ڵ����е�" +
		"�˾Ϳɹ��أ�����Ұѵ�ͼ��7���Ǳ�" +
		"�ڵĺ���ͷĿ����ܣ������Ǿ�������" +
		"����½�ˡ�ע�⣬�����ӵ������ƣ�ս" +
		"����һ��Ҫ���ƺ��ӵ��ķ���Ƶ�ʡ�\n"+
		"\n"+
		
		"��Ϸ����\n"+
		"���ͼ��\n"+
		"�������   ǰ��/����\n"+
		"�������   ����/����\n"+
		"��������� ת��\n"+
		"\n"+
		
		"ս��������\n"+
		"1�� ����������\n"+
		"3�� ����������\n"+
		"5�� �������\n"+
		"7�� �������ε���\n"+
		"\n"+
		
		"����� ȷ��/�˵�\n" +
		"����� ����/�˵�\n" +
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
	
	String aboutText = "����";
	
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
    		"����",//
	    		"��",
	    		"��",
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
    	
    	int aw = getStringWidth("ȷ��") +4;
    	int ah = getStringHeight() +4;
    	int ax = 1;
    	int ay = SCREEN_HEIGHT - ah - 1;
    	g.setColor(0xffff8080);
    	g.fillRect(ax, ay, aw, ah);
    	g.setColor(0xffffffff);
    	g.drawRect(ax, ay, aw, ah);
    	drawString(g, "ȷ��", ax+2, ay+2, 0xffffffff);
    	
    	int bw = getStringWidth("ȡ��")+4;
    	int bh = getStringHeight()+4;
    	int bx = SCREEN_WIDTH  - bw - 1;
    	int by = SCREEN_HEIGHT - bh - 1;
    	g.setColor(0xffff8080);
    	g.fillRect(bx, by, bw, bh);
    	g.setColor(0xffffffff);
    	g.drawRect(bx, by, bw, bh);
    	drawString(g, "ȡ��", bx+2, by+2, 0xffffffff);
    	
    }

	  
}

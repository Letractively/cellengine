import java.util.Date;
import java.util.Hashtable;

import game.unit.battle.UnitBattleActor;
import game.unit.battle.UnitBattleSub;
import game.unit.world.UnitWorldActor;
import game.unit.world.UnitWorldEvent;

import javax.microedition.lcdui.Graphics;

import com.morefuntek.cell.*;
import com.morefuntek.cell.GUI.CTextBox;
import com.morefuntek.cell.Game.*;


public class ScreenP00_World extends AScreen {
	
	static byte[] CityDestoryed = new byte[40];
	
	
	static public int HelpState = -1;
	
	String[] HelpText = {
			
			"请按住方向上键开船",
			
			"按住方向左键或右键调转船头",
			
			"按住方向下键减速",
			
			"找到陆地并停靠进入战斗,如有不明请看\"帮助\"\n" +
			"(关闭此窗口请按左或右软键)",
	};
	
	
	
	
	
	
	
	IImages GUITile;
	CSprite NUMSpr;
	
	// game world
	CWorld 		world;
	CMap 		map;
	CCamera 	cam;
	
	UnitWorldActor		actor;
	UnitWorldEvent[]	events ;
	
	CWorldMini worldMini;

	
	
	int CheatCount;
	
	
	public ScreenP00_World(){

		try{
			if(ScreenP00_Menu.player!=null){
				ScreenP00_Menu.player.destroy();
			}
			ScreenP00_Menu.player = new CSoundPlayer("/BGMmap.mid",CSoundPlayer.TYPE_MIDI,-1);
			ScreenP00_Menu.player.play();
		}catch(Exception err){
		}
		
       	IsDebug = false;

       	FrameDelay = 25;
       	
       	GUITile = ResesScriptWorld.createClipImages_worldUITile();
       	NUMSpr = ResesScriptWorld.createSprite_munberSprite(GUITile);
       	
       	// res
       	IImages mapTile = ResesScriptWorld.createClipImages_worldMapTile();
       	IImages sprTile = ResesScriptWorld.createClipImages_worldSprTile();
       	IImages evtTile = ResesScriptWorld.createClipImages_worldEvtTile();
       	
       	String worldName = ResesScriptWorld.world_worldMap;
       	
       	// spr typeVisible
        CSprite actorStuff = ResesScriptWorld.createSprite_wdSprite(sprTile);
        CSprite eventStuff = ResesScriptWorld.createSprite_wdEvents(evtTile);
    	
       	actor = new UnitWorldActor(actorStuff);
       	actor.haveMapBlock = false;
       	actor.haveSprBlock = true;
       	actor.X = UnitWorldActor.ActorX ;
		actor.Y = UnitWorldActor.ActorY ;
		actor.Direct = UnitWorldActor.ActorDirect;
       	actor.HPos256 = actor.X*256;
    	actor.VPos256 = actor.Y*256;
       	
    	String[] eventList = ResesScriptWorld.getWorldSprName(worldName);
    	int[] eventX = ResesScriptWorld.getWorldSprX(worldName);
    	int[] eventY = ResesScriptWorld.getWorldSprY(worldName);
    	int[] eventA = ResesScriptWorld.getWorldSprAnim(worldName);
       	events = new UnitWorldEvent[eventList.length];
       	for(int i=0;i<events.length;i++){
       		events[i] = new UnitWorldEvent(eventStuff);
       		events[i].haveMapBlock = false;
       		events[i].haveSprBlock = true;
       		events[i].setCurrentFrame(eventA[i], 0);
       		events[i].X = eventX[i];
       		events[i].Y = eventY[i];
       		events[i].HPos256 = events[i].X*256;
       		events[i].VPos256 = events[i].Y*256;
       		events[i].setLevel(eventList[i]);
       		if(events[i].Level!=null){
       			println(events[i].Info + " : " + events[i].Level);
       		}
       		events[i].Destoryed = CityDestoryed[i]==1;
       	}

       	UnitWorldActor.CityIndex = -1;
       	
    	// map type
       	map = ResesScriptWorld.createMap_wdMap(mapTile, false, true);
       	// camera 
       	cam = new CCamera(
       			0,0,
       			SCREEN_WIDTH,
       			SCREEN_HEIGHT+map.getCellH(),
       			map,true,0);
       
    	// world
       	world = new CWorld();
       	world.isRPGView = true;
       	world.addCamera(cam);//set camera
       	world.addMap(map);
       	world.addSprites(events);
       	world.addSprite(actor);
		world.Width = ResesScriptWorld.getWorldWidth(worldName);
		world.Height = ResesScriptWorld.getWorldHeight(worldName);
       	
       	
       	//小地图
       	worldMini = new CWorldMini(
       			world,
       			cam.getWidth()/4,
       			cam.getHeight()/4,
       			2, 2, 
       			8+8*16, 0);
       	
       	int px = actor.X - (cam.getX() + cam.getWidth() /2);
    	int py = actor.Y - (cam.getY() + cam.getHeight()/2);
    	cam.mov(px, py);
       	
       	resetTimer();
	}
	
	public void notifyLogic() {
    	if(isKeyDown(KEY_STAR)) {
    		CheatCount ++;
    		if(CheatCount%10==0)UnitBattleActor.Money += 10000;
    	}
//        if(isKeyDown(KEY_SHARP)){FrameDelay ++;}
//    	if(isKeyDown(KEY_A)){ChangeSubScreen("ScreenP00_Logo");}
//    	if(isKeyDown(KEY_B)){AScreen.ExitGame = true;}
//    	if(isKeyDown(KEY_0)){IsDebug = !IsDebug;}
 
    	if(!Pause){
    		
    		if(!CTextBox.isShown()){
    			if(!Config){
        			if(isKeyDown(KEY_B)){notifyPause();}
                	if(isKeyDown(KEY_A)){notifyPause();}
                	
                	//检测状态进入动态帮助
                	switch(HelpState){
                	case 0:
                		CTextBox.setTextBox(
            				HelpText[HelpState], 
            				null, 
            				0, 
            				SCREEN_HEIGHT - SCREEN_HEIGHT/4, 
            				SCREEN_WIDTH, 
            				SCREEN_HEIGHT/4);
                		break;
                	case 1:
                		if(actor.isMaxSpeed()){
                    		CTextBox.setTextBox(
                				HelpText[HelpState], 
                				null, 
                				0, 
                				SCREEN_HEIGHT - SCREEN_HEIGHT/4, 
                				SCREEN_WIDTH, 
                				SCREEN_HEIGHT/4);
                    	}
                		break;
                	case 2:
                		if(CMath.cycNum(actor.Direct,0,360)>180){
                    		CTextBox.setTextBox(
                				HelpText[HelpState], 
                				null, 
                				0, 
                				SCREEN_HEIGHT - SCREEN_HEIGHT/4, 
                				SCREEN_WIDTH, 
                				SCREEN_HEIGHT/4);
                    	}
                		break;
                	case 3:
                		if( actor.Speed<0 ){
                    		CTextBox.setTextBox(
                				HelpText[HelpState], 
                				null, 
                				0, 
                				SCREEN_HEIGHT - SCREEN_HEIGHT/4, 
                				SCREEN_WIDTH, 
                				SCREEN_HEIGHT/4);
                    	}
                		break;
                	}

                	
                	
        	    	processActor();
        	    	processMiniMap();
        	    	processCamera();
        	    	processEvents();
        	    	world.update();
        	    	
        		}else{    			
        			configLogic();	
        		}
    		}else{
    			//动态帮助的逻辑
//    			if(isKeyHold(KEY_LEFT)){
//    			}
//    			if(isKeyHold(KEY_RIGHT)){
//    			}
//    			
//    			if(isKeyHold(KEY_DOWN)){
//    			}
//    			if(isKeyDown(KEY_A|KEY_B|KEY_C)){
//    				if(CTextBox.vScroll(getStringHeight()/2)){
//    					
//    				}
//        		}
    			
    			switch(HelpState){
            	case 0:
            		if(isKeyHold(KEY_UP)){
            			HelpState++;
        				CTextBox.closeTextBox();
        			}
            		break;
            	case 1:
            		if(isKeyHold(KEY_LEFT|KEY_RIGHT)){
            			HelpState++;
        				CTextBox.closeTextBox();
        			}
            		break;
            	case 2:
            		if(isKeyHold(KEY_DOWN)){
            			HelpState++;
        				CTextBox.closeTextBox();
        			}
            		break;
            	case 3:
            		if(isKeyHold(KEY_A|KEY_B|KEY_C)){
        				if(CTextBox.vScroll(16)){
        					HelpState++;
            				CTextBox.closeTextBox();
        				}
        			}
            		break;
            	}
    		}
    	}else{
    		
    		if(isKeyDown(KEY_UP)){
        		menuIndex = CMath.cycNum(menuIndex, -1, menu.length);
        	}
        	if(isKeyDown(KEY_DOWN)){
        		menuIndex = CMath.cycNum(menuIndex,  1, menu.length);
        	}
        	
        	if(isKeyDown(KEY_B)){Pause = false;}
        	if(isKeyDown(KEY_A|KEY_C)){
        		switch(menuIndex){
        		case 0: 
        			Pause = false; 
        			break;
        		case 1: 
        			Save();
        			TransitionEnable = true;
        			ChangeSubScreen("ScreenP00_Menu"); 
        			break;
        		}
        	}
    	}
    	
    	tickTimer();
    }
	
	public void notifyRender(Graphics g) {
		
        world.render(g);
        worldMini.render(g, 
        		1, -1 + cam.getHeight() - worldMini.getHeight());
        g.setColor(0xff00ff00);
        g.drawRect(
        		1, -1 + cam.getHeight() - worldMini.getHeight(),
        		worldMini.getWidth(), worldMini.getHeight());	
        
        renderGUI(g);
        
        
        
        if(!Pause){
        	if(!Config){
    		}else{
    			configRender(g);
    		}
        	CTextBox.showTextBox(g);
        }else{
        	int h = (getStringHeight() + 1) * menu.length;
        	int y = SCREEN_HEIGHT/2 - h/2;
        	
        	g.setColor(0xff8080ff);
        	g.fillRect(0, y, SCREEN_WIDTH, h);
        	g.setColor(0xffffffff);
        	g.drawRect(0, y, SCREEN_WIDTH-1, h-1);
        	
        	for(int i=0;i<menu.length;i++){
        		if(i==menuIndex){
        			g.setColor(0xff0000ff);
                	g.fillRect(0, y + (getStringHeight() + 1) * i, SCREEN_WIDTH, (getStringHeight() + 1));
                	g.setColor(0xffffffff);
                	g.drawRect(0, y + (getStringHeight() + 1) * i, SCREEN_WIDTH-1, (getStringHeight() - 1));
                	
                	drawString(g, menu[i], 
            				SCREEN_WIDTH/2 - getStringWidth(menu[i])/2, 
            				y + (getStringHeight() + 1) * i , 
            				0xffffffff);
        		}else{
        			drawString(g, menu[i], 
            				SCREEN_WIDTH/2 - getStringWidth(menu[i])/2, 
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

    }

	String[] menu = new String[]{
			"继续游戏",
			"保存并退出"
		};
	int menuIndex = 0;
	boolean Pause = false;
		
	public void notifyPause() {
		Pause = true;
		menuIndex = 0;
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
	
	static public void Destory(int cityIndex){
		CityDestoryed[cityIndex] = 1;
	}
	
//	----------------------------------------------------------------------------------------------------------	
	
	static final int RecordSize = 512;
	
	static public int SavePos = 0;
	
	static private byte SaveData[];
	
	
	static public String getSaveInfo(int pos){
		long date = getLong(SaveData, pos*RecordSize);
		if(date!=0){
			return pos + ":剩下"+GetUnDestoryedCityCount(pos)+"座城市";
		}else{
			return "";
		}
	}
	
	static public int GetUnDestoryedCityCount(int pos){
		int p=pos*RecordSize;
		p+=8;
		p+=4;
		p+=4;
		p+=4;
		p+=4;
		
		boolean[] cd = new boolean[CityDestoryed.length];
		for(int i=0;i<cd.length;i++){
			cd[i] = SaveData[p]==0 ? false : true;
			p++;
		}

		int count = cd.length;
		for(int i=0;i<cd.length;i++){
			if(cd[i])count--;
		}
		return count;
		
	}
	
	static public void Save(){
		
		try {
			int p=SavePos*RecordSize;
			long time = System.currentTimeMillis();
			
			putLong(SaveData,p,time);p+=8;
			putInt(SaveData,p,UnitWorldActor.ActorX);p+=4;
			putInt(SaveData,p,UnitWorldActor.ActorY);p+=4;
			putInt(SaveData,p,UnitWorldActor.ActorDirect);p+=4;
			putInt(SaveData,p,UnitBattleActor.Money);p+=4;

			for(int i=0;i<CityDestoryed.length;i++){
				SaveData[p] = CityDestoryed[i] ;
				p++;
			}
			

			CIO.putRMSSave(SaveData, "SkyCityRMS");
			
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}
	
	static public void Load(){
		
		try {
			SaveData = CIO.getRMSSave("SkyCityRMS");
			if(SaveData==null || SaveData.length<RecordSize*4)SaveData = new byte[RecordSize*4];
				
			int p=SavePos*RecordSize;
			
			long time = getLong(SaveData, p); p+=8;
			UnitWorldActor.ActorX = getInt(SaveData,p);p+=4;
			UnitWorldActor.ActorY = getInt(SaveData,p);p+=4;
			UnitWorldActor.ActorDirect = getInt(SaveData,p);p+=4;
			UnitBattleActor.Money = getInt(SaveData,p);p+=4;
			
			for(int i=0;i<CityDestoryed.length;i++){
				CityDestoryed[i] = SaveData[p];
				p++;
			}
			
		} catch (RuntimeException e) {
			e.printStackTrace();
		}

	}
	
	static public void Clean(){
		try{
			int p=SavePos*RecordSize;
//			putLong(SaveData,p,0);p+=8;
//			putInt(SaveData,p,0);p+=4;
//			putInt(SaveData,p,0);p+=4;
//			putInt(SaveData,p,0);p+=4;
//			putInt(SaveData,p,0);p+=4;
			
			for(int i=0;i<RecordSize;i++){
				SaveData[i+p] = 0;
			}
			
			CIO.putRMSSave(SaveData, "SkyCityRMS");
		}catch(Exception err){
			err.printStackTrace();
		}
	}
	
	static public void putInt(byte[] data,int pos,int value){
		data[pos+0] = (byte)((value>>> 0)&0xff);
		data[pos+1] = (byte)((value>>> 8)&0xff);
		data[pos+2] = (byte)((value>>>16)&0xff);
		data[pos+3] = (byte)((value>>>24)&0xff);
		
	}
	
	static public int getInt(byte[] data,int pos){
		int ret = 0;
		ret |= ((((int)0xff)&data[pos+0])<< 0);
		ret |= ((((int)0xff)&data[pos+1])<< 8);
		ret |= ((((int)0xff)&data[pos+2])<<16);
		ret |= ((((int)0xff)&data[pos+3])<<24);
		return ret;
	}
	
	static public void putLong(byte[] data,int pos,long value){
		data[pos+0] = (byte)((value>>> 0)&0xff);
		data[pos+1] = (byte)((value>>> 8)&0xff);
		data[pos+2] = (byte)((value>>>16)&0xff);
		data[pos+3] = (byte)((value>>>24)&0xff);
		data[pos+4] = (byte)((value>>>32)&0xff);
		data[pos+5] = (byte)((value>>>40)&0xff);
		data[pos+6] = (byte)((value>>>48)&0xff);
		data[pos+7] = (byte)((value>>>56)&0xff);
	}
	
	static public long getLong(byte[] data,int pos){
		long ret = 0;
		ret |= ((((long)0xff)&data[pos+0])<< 0);
		ret |= ((((long)0xff)&data[pos+1])<< 8);
		ret |= ((((long)0xff)&data[pos+2])<<16);
		ret |= ((((long)0xff)&data[pos+3])<<24);
		ret |= ((((long)0xff)&data[pos+4])<<32);
		ret |= ((((long)0xff)&data[pos+5])<<40);
		ret |= ((((long)0xff)&data[pos+6])<<48);
		ret |= ((((long)0xff)&data[pos+7])<<56);
		return ret;
	}
	
//	-------------------------------------------------------------------------------------------------------------------------------

	public void processCamera(){
		int cdx = actor.X - (cam.getX() + cam.getWidth() /2);
    	int cdy = actor.Y - (cam.getY() + cam.getHeight()/2);

    	int px = cdx/4;
    	int py = cdy/4;
    	
    	if(cam.getX() + px > world.Width - cam.getWidth()){
    		px = world.Width - cam.getWidth() - cam.getX();
    	}else if(cam.getX() + px < 0){
    		px = 0 - cam.getX();
    	}
    	
    	if(cam.getY() + py > world.Height - cam.getHeight()){
    		py = world.Height - cam.getHeight() - cam.getY();
    	}else if(cam.getY() + py < 32){
    		py = 32 - cam.getY();
    	}
    	
    	cam.mov(px, py);
	}
	
	int DColor = 0;
	public void processMiniMap(){
		
		worldMini.X = actor.X - worldMini.getWorldWidth()/2;
		worldMini.Y = actor.Y - worldMini.getWorldHeight()/2;
		
		for(int i=0;i<world.getSpriteCount();i++){
			world.getSprite(i).BackColor = 
				0x7f000000
				+(DColor<<16) 
				+(DColor<<8) 
				+(DColor<<0) 
				;
		}
		
		actor.BackColor = 
			0x7f000000
			+(DColor<<16) 
			+(DColor<<8) 
			+(DColor<<0) 
			;
		
		cam.BackColor = 
			0x7f000000
//			+(DColor<<16) 
			+(DColor<<8) 
//			+(DColor<<0) 
			;
		
		DColor = CMath.sinTimes256(getTimer()*10%180);
		if(DColor>0xff)DColor=0xff;
		
	}
	
	public void processActor(){
		if(isKeyHold(KEY_UP)){
			actor.accelerate();
		}
		if(isKeyHold(KEY_DOWN)){
			actor.breakDown();
		}
		
		if(isKeyHold(KEY_LEFT)){
			actor.turnL();
		}
		if(isKeyHold(KEY_RIGHT)){
			actor.turnR();
		}

	}

	
	public void processEvents(){

		UnitWorldActor.ActorX = actor.X ;
		UnitWorldActor.ActorY = actor.Y;
		UnitWorldActor.ActorDirect = actor.Direct;
		
       	for(int i=0;i<events.length;i++){
       		if(events[i].OnScreen && !(HelpState>=0 && HelpState<HelpText.length) ){
       			if(CSprite.touch_SprSub_SprSub(
       					actor,     CSprite.CD_TYPE_MAP, 0, 
       					events[i], CSprite.CD_TYPE_EXT, 0))
       			{
       				if(events[i].Level!=null){
       					println("Enter Level : " + events[i].Info + " : " + events[i].Level);
       					ScreenP00_Battle.WorldName = events[i].Level;
       					TransitionEnable = false;
	       				
	       				UnitWorldActor.ActorX = events[i].X ;
	       				UnitWorldActor.ActorY = events[i].Y + events[i].getCDHeight();
	       				UnitWorldActor.ActorDirect = 270;
	       				UnitWorldActor.CityIndex = i;
	       				
	       			 	actor.X = UnitWorldActor.ActorX ;
	       				actor.Y = UnitWorldActor.ActorY ;
	       		       	actor.HPos256 = actor.X*256;
	       		    	actor.VPos256 = actor.Y*256;
	       		    	
	       		    	actor.Direct = UnitWorldActor.ActorDirect;
	       		    	actor.Speed  = 0 ;
	       				//ChangeSubScreen("ScreenP00_BattleConfig");
	       				
	       				configInit();
	       				
	       				break;
       				}
//       				switch(events[i].Type){
//           			case 0:
//           				break;
//           			case 1:
//           			}
       			}
       		}
       	}
		
	}
	
	public void renderGUI(Graphics g){
	
	        GUITile.render(g, 2, 0, 0);
	        
	        int X = Math.abs(world.Width/2  - actor.X);
	        int Y = Math.abs(world.Height/2 - actor.Y);
	        String H = actor.X < world.Width/2  ? "W" : "E";
	        String V = actor.Y < world.Height/2 ? "N" : "S";
	        renderText(g,  12, 12, H+X/map.getCellW()+"\'" + X%map.getCellW());
	        renderText(g, 112, 12, V+Y/map.getCellH()+"\'" + Y%map.getCellH());
	
	}
	
	
	public void renderText(Graphics g,int x,int y,String num){
		int sx = 0;
		for(int i=0;i<num.length();i++){
			int a = 0;
			int n = 0;
			switch(num.charAt(i)){
			case '0':n = 0; break;
			case '1':n = 1; break;
			case '2':n = 2; break;
			case '3':n = 3; break;
			case '4':n = 4; break;
			case '5':n = 5; break;
			case '6':n = 6; break;
			case '7':n = 7; break;
			case '8':n = 8; break;
			case '9':n = 9; break;
			case '\'':a = 1;break;
			case 'E':a = 2;break;
			case 'S':a = 3;break;
			case 'N':a = 4;break;
			case 'W':a = 5;break;
			}
			NUMSpr.setCurrentFrame(a, n);
			NUMSpr.render(g, 
					x + sx, 
					y);
			sx += (NUMSpr.getCurrentImage(0).getWidth()+1);
		}
		
	}
	
//  	------------------------------------------------------------------------------------------------------------
	
		boolean Config = false;
	
	 	int ConfigIndex = 0 ;
	    int[] ConfigSubIndex ;
	    
	    int cost = 0;
	    
	    final private String[] help = new String[]{
	    	"按5键开/关发射",
	    	"按1键开/关主炮",
	    	"按3键开/关副炮",
	    	"按7键改变辅助攻击"
	    };
	    
	    final private String[][] list = new String[][]{
	    	{
	    		"主武器",//
		    		"激光炮",
		    		"巨型鱼雷",
		    		"爆式霰弹",
		    		"爆弹",
		    		"飞弹",
		    		"(无)"
	    	},{
	        	"辅助武器1",//
					"光线枪",
					"霰弹枪",
					"追踪弹",
					"集束弹",
					"(无)"
	    	},{
	        	"辅助武器2",//
					"光线枪",
					"霰弹枪",
					"追踪弹",
					"集束弹",
					"(无)"
	    	}
	    };
	    
		public void configInit() {
			Config = true;
			
			ConfigSubIndex = new int[list.length];
			
//			switch(UnitBattleActor.WeaopnType){
//			case UnitBattleActor.WEAOPN_LASER : subIndex[0]=1; break;
//			case UnitBattleActor.WEAOPN_BOMB  : subIndex[0]=2; break;
//			case UnitBattleActor.WEAOPN_SHORT : subIndex[0]=3; break;
//			case UnitBattleActor.WEAOPN_EXP   : subIndex[0]=4; break;
//			case UnitBattleActor.WEAOPN_ROCKET: subIndex[0]=5; break;
//			default: subIndex[0]=6; break;
//			}
			ConfigSubIndex[0] = 6;
			ConfigSubIndex[1] = 5;
			ConfigSubIndex[2] = 5;
		}

		public void configLogic() {
			if(isKeyHold(KEY_B)){
				Config = false;
			}
			
			// lable
			if(isKeyDown(KEY_DOWN)){
				ConfigIndex = CMath.cycNum(ConfigIndex,  1, list.length);
			}
			if(isKeyDown(KEY_UP)){
				ConfigIndex = CMath.cycNum(ConfigIndex, -1, list.length);
			}
			// sub
			if(list[ConfigIndex].length>=1){
				if(isKeyDown(KEY_LEFT)){
					ConfigSubIndex[ConfigIndex] = 1 + CMath.cycNum(ConfigSubIndex[ConfigIndex]-1, -1, list[ConfigIndex].length - 1);
				}
				if(isKeyDown(KEY_RIGHT)){
					ConfigSubIndex[ConfigIndex] = 1 + CMath.cycNum(ConfigSubIndex[ConfigIndex]-1,  1, list[ConfigIndex].length - 1);
				}
			}
			
			if(isKeyDown(KEY_C|KEY_A|KEY_5)){
				if(!isTransition() && UnitBattleActor.Money >= cost){
					
					UnitBattleActor.WeaopnType = ConfigSubIndex[0]-1;
					
					UnitBattleSub.SubCount = 0;
					
					if(ConfigSubIndex[1]>0&&ConfigSubIndex[1]<list[1].length-1){
						UnitBattleSub.SubCount+=2;
						UnitBattleSub.WeaopnType[0] = ConfigSubIndex[1]-1;
						UnitBattleSub.WeaopnType[1] = ConfigSubIndex[1]-1;
					}
					
					if(ConfigSubIndex[2]>0&&ConfigSubIndex[2]<list[2].length-1){
						UnitBattleSub.SubCount+=2;
						UnitBattleSub.WeaopnType[2] = ConfigSubIndex[2]-1;
						UnitBattleSub.WeaopnType[3] = ConfigSubIndex[2]-1;
					}
					
					UnitBattleActor.Money -= cost;
					
					TransitionEnable = true;
					ChangeSubScreen("ScreenP00_Battle",help);
					
				}
			}
			
			
			cost = 0;
			cost += UnitBattleActor.WeaopnPrice[ConfigSubIndex[0]-1];
			if(ConfigSubIndex[1]>0&&ConfigSubIndex[1]<list[1].length-1){
				cost += UnitBattleSub.WeaopnPrice[ConfigSubIndex[1]-1];
			}
			if(ConfigSubIndex[2]>0&&ConfigSubIndex[2]<list[2].length-1){
				cost += UnitBattleSub.WeaopnPrice[ConfigSubIndex[2]-1];
			}
			
		}

		public void configRender(Graphics g) {

			int[] menu_c = new int[]{
					0xff000000,
					0xff000000,
					0xff000000,
					0xffffff00,
					UnitBattleActor.Money >= cost ? 0xff00ff00 : 0xffff0000 ,
			};
			
			String[] menu_h = new String[]{
					list[0][0],
					list[1][0],
					list[2][0],
					"当前金",
					"战斗开销"
			};
			String[] menu_t = new String[]{
					list[0][ConfigSubIndex[0]],
					list[1][ConfigSubIndex[1]],
					list[2][ConfigSubIndex[2]],
					UnitBattleActor.Money + "",
					UnitBattleActor.Money >= cost ? cost + "" : "钱不够!",
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

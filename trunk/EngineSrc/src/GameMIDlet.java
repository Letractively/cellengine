
import javax.microedition.lcdui.Display;
import javax.microedition.midlet.MIDlet;

import com.morefuntek.cell.CCanvas20;
import com.morefuntek.cell.Game.CScreen;

final public class GameMIDlet extends MIDlet  implements Runnable{

//------------------------------------------------------------------------------------------
	CCanvas20 canvas ;
	
	//屏幕类型，根据不同的游戏，实现不同的SCREEN
//	final static String SCREEN_KEY_NONE 		= "0";
	final static String SCREEN_KEY_LOGO 		= "ScreenLogo";
	final static String SCREEN_KEY_MAIN			= "ScreenMain";
	final static String SCREEN_KEY_MAIN2		= "ScreenMain2";
	final static String SCREEN_KEY_BT_S			= "ScreenBTServer";
	final static String SCREEN_KEY_BT_C			= "ScreenBTClient";
	final static String SCREEN_KEY_TD_MAIN		= "ScreenTD_Main";
	
	static public boolean ExitGame = false;
	
	public GameMIDlet() {
//#ifdef _DEBUG
		System.out.println("_DEBUG");
//#endif		
		System.out.println("Total Memory = "+(Runtime.getRuntime().totalMemory()/1024)+"(K byte)");

		canvas = new CCanvas20();
		canvas.setFullScreenMode(true);
		CScreen.SCREEN_WIDTH = canvas.getWidth();
		CScreen.SCREEN_HEIGHT = canvas.getHeight();
		CScreen.SCREEN_HCENTER = canvas.getWidth()/2;
		CScreen.SCREEN_VCENTER = canvas.getHeight()/2;
		System.out.println("Screen W = " + CScreen.SCREEN_WIDTH);
		System.out.println("Screen H = " + CScreen.SCREEN_HEIGHT);
		
		Display.getDisplay(this).setCurrent(canvas);

		//切换当前屏幕到ScreenSCWorld
		CScreen.ChangeSubSreen(SCREEN_KEY_MAIN2);

		(new Thread(this)).start();

	}
	final public void startApp() {
		System.out.println("Free Memory = "+(Runtime.getRuntime().freeMemory()/1024)+"(K byte)");
    }
	final public void pauseApp() {
	}
	final public void destroyApp(boolean unconditional) {
		System.out.println("Free Memory = "+(Runtime.getRuntime().freeMemory()/1024)+"(K byte)");
		notifyDestroyed();
	}
	
//---------------------------------------------------------------------------------------------------------------
	
	final public void run() {
		long UsedTime;
		try{
			while (!GameMIDlet.ExitGame) {
				UsedTime = System.currentTimeMillis();

				canvas.repaint();
				canvas.serviceRepaints();
				
				UsedTime = System.currentTimeMillis() - UsedTime;
				
				if (UsedTime < CScreen.FrameDelay) {
					Thread.sleep(CScreen.FrameDelay - UsedTime);
				}else{
				    //Thread.sleep(1);
				}
			}
		}catch(Exception err){
			err.printStackTrace();
		}
		destroyApp(true);
	}
	
}
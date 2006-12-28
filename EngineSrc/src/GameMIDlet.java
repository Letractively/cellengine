
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Display;
import javax.microedition.midlet.MIDlet;

import com.morefuntek.cell.CCanvas20;
import com.morefuntek.cell.CCanvasNokia;
import com.morefuntek.cell.CObject;
import com.morefuntek.cell.Game.CScreen;

final public class GameMIDlet extends MIDlet  implements Runnable{
	
	static public boolean ExitGame = false;
	
	Canvas canvas ;

//------------------------------------------------------------------------------------------
	
	
	public GameMIDlet() {
//#ifndef _DEBUG
		CObject.IsDebug = false;
//#else
		CObject.IsDebug = true;
//#endif	
		
//#ifdef _NOKIA_UI
		CObject.IsNokia = true;
//#else
		CObject.IsNokia = false;
//#endif		
		
		System.out.println("Total Memory = "+(Runtime.getRuntime().totalMemory()/1024)+"(K byte)");

		if(CObject.IsNokia){
			canvas = new CCanvasNokia();
		}else{
			canvas = new CCanvas20();
			canvas.setFullScreenMode(true);
		}

		
		CScreen.SCREEN_WIDTH = canvas.getWidth();
		CScreen.SCREEN_HEIGHT = canvas.getHeight();
		CScreen.SCREEN_HCENTER = canvas.getWidth()/2;
		CScreen.SCREEN_VCENTER = canvas.getHeight()/2;
		System.out.println("Screen W = " + CScreen.SCREEN_WIDTH);
		System.out.println("Screen H = " + CScreen.SCREEN_HEIGHT);
		
		Display.getDisplay(this).setCurrent(canvas);

		//ÇÐ»»µ±Ç°ÆÁÄ»µ½ScreenSCWorld
		CScreen.ChangeSubSreen("ScreenLogo");

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

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

import com.morefuntek.cell.CCanvas20;
import com.morefuntek.cell.CCanvasNokia;
import com.morefuntek.cell.CObject;
import com.morefuntek.cell.Game.AScreen;

/**
 * 主MIDlet
 * @author yifeizhang
 * @since 2006-12-30 
 * @version 1.0
 */
final public class GameMIDlet extends MIDlet  implements Runnable{
	
	Canvas canvas ;
	
//------------------------------------------------------------------------------------------

	public GameMIDlet() {

		System.out.println("Total Memory = "+(Runtime.getRuntime().totalMemory()/1024)+"(K byte)");
		
		//判断是否为NOKIA平台
//		if(CObject.IsNokia){
////			canvas = new CCanvasNokia();
//		}else{
		canvas = new CCanvas20();
		canvas.setFullScreenMode(true);
//		}
		//得到虚拟屏幕大小
		AScreen.SCREEN_WIDTH = canvas.getWidth();
		AScreen.SCREEN_HEIGHT = canvas.getHeight();
		AScreen.SCREEN_HCENTER = canvas.getWidth()/2;
		AScreen.SCREEN_VCENTER = canvas.getHeight()/2;
		System.out.println("Screen W = " + AScreen.SCREEN_WIDTH);
		System.out.println("Screen H = " + AScreen.SCREEN_HEIGHT);
		
		Display.getDisplay(this).setCurrent(canvas);

		//切换当前屏幕到 ScreenP00_Logo
		//整个游戏的结构是每个游戏界面继承一个AScreen,比如菜单，帮助，主模块，等，
		//通过调用ChangeSubScreen在不同的界面切换。
		//设计游戏逻辑的时候不需要考虑机器相关的Canvas,而只需要根据AScreen虚拟屏幕的静态方法来控制游戏逻辑。
		//每个界面需要实现4个抽象方法。
		//详细请参考ScreenP00_Logo
		//
		//AScreen.TransitionEnable开关控制切换屏幕是否有特效，特效的实现参考AScreen的静态方法
		//
		//
		AScreen.ChangeSubScreen("ScreenP00_Menu");

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
			while (!AScreen.ExitGame) {
				UsedTime = System.currentTimeMillis();

				//执行主逻辑
				canvas.repaint();
				canvas.serviceRepaints();
				
				//保持帧数维持在 1000/FrameDelay FPS
				UsedTime = System.currentTimeMillis() - UsedTime;
				if (UsedTime < AScreen.FrameDelay) {
					Thread.sleep(AScreen.FrameDelay - UsedTime);
				}else{
				    Thread.sleep(1);
				}
			}
		}catch(Exception err){
			err.printStackTrace();
		}
		destroyApp(true);
	}
	
}
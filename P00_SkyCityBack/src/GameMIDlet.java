
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

import com.morefuntek.cell.CCanvas20;
import com.morefuntek.cell.CCanvasNokia;
import com.morefuntek.cell.CObject;
import com.morefuntek.cell.Game.AScreen;

/**
 * ��MIDlet
 * @author yifeizhang
 * @since 2006-12-30 
 * @version 1.0
 */
final public class GameMIDlet extends MIDlet  implements Runnable{
	
	Canvas canvas ;
	
//------------------------------------------------------------------------------------------

	public GameMIDlet() {

		System.out.println("Total Memory = "+(Runtime.getRuntime().totalMemory()/1024)+"(K byte)");
		
		//�ж��Ƿ�ΪNOKIAƽ̨
//		if(CObject.IsNokia){
////			canvas = new CCanvasNokia();
//		}else{
		canvas = new CCanvas20();
		canvas.setFullScreenMode(true);
//		}
		//�õ�������Ļ��С
		AScreen.SCREEN_WIDTH = canvas.getWidth();
		AScreen.SCREEN_HEIGHT = canvas.getHeight();
		AScreen.SCREEN_HCENTER = canvas.getWidth()/2;
		AScreen.SCREEN_VCENTER = canvas.getHeight()/2;
		System.out.println("Screen W = " + AScreen.SCREEN_WIDTH);
		System.out.println("Screen H = " + AScreen.SCREEN_HEIGHT);
		
		Display.getDisplay(this).setCurrent(canvas);

		//�л���ǰ��Ļ�� ScreenP00_Logo
		//������Ϸ�Ľṹ��ÿ����Ϸ����̳�һ��AScreen,����˵�����������ģ�飬�ȣ�
		//ͨ������ChangeSubScreen�ڲ�ͬ�Ľ����л���
		//�����Ϸ�߼���ʱ����Ҫ���ǻ�����ص�Canvas,��ֻ��Ҫ����AScreen������Ļ�ľ�̬������������Ϸ�߼���
		//ÿ��������Ҫʵ��4�����󷽷���
		//��ϸ��ο�ScreenP00_Logo
		//
		//AScreen.TransitionEnable���ؿ����л���Ļ�Ƿ�����Ч����Ч��ʵ�ֲο�AScreen�ľ�̬����
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

				//ִ�����߼�
				canvas.repaint();
				canvas.serviceRepaints();
				
				//����֡��ά���� 1000/FrameDelay FPS
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
import javax.microedition.lcdui.Graphics;

import com.morefuntek.cell.Game.AScreen;


/**
 * LOGO����
 * ÿ���������ʵ��4�����󷽷���
 * @author yifeizhang
 * @since 2006-12-30 
 * @version 1.0
 */
public class ScreenP00_Logo extends AScreen {

	//
	public ScreenP00_Logo(){
		
	}
	
//	/
	
	/**
	 * override ����
	 * ִ���߼��Ļص�������ÿִ֡��һ��
	 * @see com.morefuntek.cell.Game.AScreen#notifyLogic()
	 */
	public void notifyLogic() {
		//��Logo����ֱ����ת����һ��
		ChangeSubScreen("ScreenP00_Battle");
	}
	/**
	 * override ����
	 * ִ����Ⱦ�Ļص�������ÿִ֡��һ��
	 * @see com.morefuntek.cell.Game.AScreen#notifyRender()
	 */
	public void notifyRender(Graphics g) {
		
	}
	
	//ϵͳ֪ͨ
	public void notifyPause() {}
	public void notifyResume() {}

}

import javax.microedition.lcdui.Graphics;

import com.morefuntek.cell.Game.AScreen;


/**
 * LOGO界面
 * 每个界面必须实现4个抽象方法，
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
	 * override 方法
	 * 执行逻辑的回掉方法，每帧执行一次
	 * @see com.morefuntek.cell.Game.AScreen#notifyLogic()
	 */
	public void notifyLogic() {
		//在Logo界面直接跳转到下一屏
		ChangeSubScreen("ScreenP00_Battle");
	}
	/**
	 * override 方法
	 * 执行渲染的回掉方法，每帧执行一次
	 * @see com.morefuntek.cell.Game.AScreen#notifyRender()
	 */
	public void notifyRender(Graphics g) {
		
	}
	
	//系统通知
	public void notifyPause() {}
	public void notifyResume() {}

}

package com.morefuntek.cell;


import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Graphics;

import com.morefuntek.cell.Game.CScreen;
import com.nokia.mid.ui.FullCanvas;




//import javax.microedition.lcdui.game.GameCanvas;
//import javax.microedition.lcdui.game.*;

/**
 * 主Canvas，整个MIDLET只存在这一个Canvas
 * @author yifeizhang
 * @since 2006-11-30 
 * @version 1.0
 */
public class CCanvasNokia extends FullCanvas{
	/**
	 * 构造函数 
	 */
	public CCanvasNokia() {

		System.out.println("profiles      : " + System.getProperty("microedition.profiles"));
		System.out.println("configuration : " + System.getProperty("microedition.configuration"));
		System.out.println("locale        : " + System.getProperty("microedition.locale"));
		System.out.println("platform      : " + System.getProperty("microedition.platform"));
		System.out.println("encoding      : " + System.getProperty("microedition.encoding"));
		if (this.hasRepeatEvents()) System.out.println("support Hold Key !");
		if (this.isDoubleBuffered()) System.out.println("support Double Buffered !");
		if (this.hasPointerEvents()) System.out.println("support Pointer Events !");
		if (this.hasPointerMotionEvents()) System.out.println("support Pointer Dragged !");

		CScreen.SCREEN_WIDTH = getWidth();
		CScreen.SCREEN_HEIGHT = getHeight();
		CScreen.SCREEN_HCENTER = getWidth()/2;
		CScreen.SCREEN_VCENTER = getHeight()/2;
		CScreen.println("Screen W = " + CScreen.SCREEN_WIDTH);
		CScreen.println("Screen H = " + CScreen.SCREEN_HEIGHT);
	}
	
	protected void sizeChanged(int w, int h) {
		CScreen.SCREEN_WIDTH = w;
		CScreen.SCREEN_HEIGHT = h;
		CScreen.SCREEN_HCENTER = w/2;
		CScreen.SCREEN_VCENTER = h/2;
		CScreen.println("Change Screen W = " + w);
		CScreen.println("Change Screen H = " + h);
	}
	
	//-------------------------------------------------------------------------------------
	static final public int getKeyValue(int keyCode) {
		switch (keyCode) {
			case Canvas.KEY_NUM0 :
				return CScreen.KEY_0;
			case Canvas.KEY_NUM1 :
				return CScreen.KEY_1;
			case Canvas.KEY_NUM2 :
				return CScreen.KEY_2;
			case Canvas.KEY_NUM3 :
				return CScreen.KEY_3;
			case Canvas.KEY_NUM4 :
				return CScreen.KEY_4;
			case Canvas.KEY_NUM5 :
				return CScreen.KEY_5;
			case Canvas.KEY_NUM6 :
				return CScreen.KEY_6;
			case Canvas.KEY_NUM7 :
				return CScreen.KEY_7;
			case Canvas.KEY_NUM8 :
				return CScreen.KEY_8;
			case Canvas.KEY_NUM9 :
				return CScreen.KEY_9;
			case Canvas.KEY_POUND :
				return CScreen.KEY_POUND;
			case Canvas.KEY_STAR :
				return CScreen.KEY_STAR;
			case -1 :
			case 1 :
				return CScreen.KEY_UP;
			case -2 :
			case 6 :
				return CScreen.KEY_DOWN;
			case -3 :
			case 2 :
				return CScreen.KEY_LEFT;
			case -4 :
			case 5 :
				return CScreen.KEY_RIGHT;
			case -6 :
			case 21 :
				return CScreen.KEY_A;
			case -7 :
			case 22 :
				return CScreen.KEY_B;
			case -5 :
			case 20 :
				return CScreen.KEY_C;
			default :
				return 0;
		}
	}
	
	final protected void keyPressed(int keyCode) {
		int Code = getKeyValue(keyCode);
		CScreen.KeyDownState |= Code;
		CScreen.KeyState |= Code;
	}

	final protected void keyReleased(int keyCode) {
		int Code = getKeyValue(keyCode);
		CScreen.KeyUpState |= Code;
		CScreen.KeyState &= (~Code);
	}

	final protected void pointerPressed(int x, int y) {
		CScreen.PointerState = true;
		CScreen.PointerDownState = true;
		CScreen.PointerDragState = false;
		CScreen.PointerX = x;
		CScreen.PointerY = y;
	}

	final protected void pointerReleased(int x, int y) {
		CScreen.PointerState = false;
		CScreen.PointerUpState = true;
		CScreen.PointerDragState = false;
		CScreen.PointerX = x;
		CScreen.PointerY = y;
	}

	final protected void pointerDragged(int x, int y) {
		CScreen.PointerDragState = true;
		CScreen.PointerX = x;
		CScreen.PointerY = y;
	}



	//-------------------------------------------------------------------------------------------------

	final protected void paint(Graphics g) {
		CScreen.queryKey();
		
		CScreen.TryChangeSubSreen();
		
		if(CScreen.CurSubScreen!=null){
			if(CScreen.LogicEnable){
				CScreen.CurSubScreen.notifyLogic();
			}
			if(CScreen.RenderEnable){
				CScreen.CurSubScreen.notifyRender(g);
			}
			if(CScreen.TransitionEnable==false){
				CScreen.Transition = false;
			}
		}
		
		CScreen.Transition(g,getWidth(),getHeight());
		
//#ifdef _DEBUG		
		final String d = new String(new byte[]{73,116,32,105,115,32,97,32,68,101,109,111});
		CScreen.drawString(g,d, 
				-CScreen.getStringWidth(d) + 
				(Math.abs((int)System.currentTimeMillis()/20) % (CScreen.SCREEN_WIDTH+CScreen.getStringWidth(d)) ) , 
				8, ((int)System.currentTimeMillis()&0xffffffff));
//#endif
	}

	//-----------------------------------------------------------------------------------------------


	protected void hideNotify() {
		if(CScreen.CurSubScreen!=null){
			if(CScreen.LogicEnable){
				CScreen.CurSubScreen.notifyPause();
			}
		}
	}
	
	protected void showNotify() {
		if(CScreen.CurSubScreen!=null){
			if(CScreen.LogicEnable){
				CScreen.CurSubScreen.notifyResume();
			}
		}
	
	}

//	--------------------------------------------------------------------------------------------------

	
}





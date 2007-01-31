package com.cell;

import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Graphics;


public class CCanvasJPhone extends Canvas {
	/**
	 * ���캯�� 
	 */
	public CCanvasJPhone() {

		System.out.println("profiles      : " + System.getProperty("microedition.profiles"));
		System.out.println("configuration : " + System.getProperty("microedition.configuration"));
		System.out.println("locale        : " + System.getProperty("microedition.locale"));
		System.out.println("platform      : " + System.getProperty("microedition.platform"));
		System.out.println("encoding      : " + System.getProperty("microedition.encoding"));
		if (this.hasRepeatEvents()) System.out.println("support Hold Key !");
		if (this.isDoubleBuffered()) System.out.println("support Double Buffered !");
		if (this.hasPointerEvents()) System.out.println("support Pointer Events !");
		if (this.hasPointerMotionEvents()) System.out.println("support Pointer Dragged !");

//		CScreen.SCREEN_WIDTH = getWidth();
//		CScreen.SCREEN_HEIGHT = getHeight();
//		CScreen.SCREEN_HCENTER = getWidth()/2;
//		CScreen.SCREEN_VCENTER = getHeight()/2;
//		CScreen.println("Screen W = " + CScreen.SCREEN_WIDTH);
//		CScreen.println("Screen H = " + CScreen.SCREEN_HEIGHT);
	}
	
//	protected void sizeChanged(int w, int h) {
//		AScreen.SCREEN_WIDTH = w;
//		AScreen.SCREEN_HEIGHT = h;
//		AScreen.SCREEN_HCENTER = w/2;
//		AScreen.SCREEN_VCENTER = h/2;
//		AScreen.println("Change Screen W = " + w);
//		AScreen.println("Change Screen H = " + h);
//	}
	private int Width 	= 176;
	private int Height 	= 208;
	final public void setWidth(int width){
		Width = width;
	}
	final public void setHeight(int height){
		Height = height;
	}
	final public int getWidth(){
		return Width;
	}
	final public int getHeight(){
		return Height;
	}
	//-------------------------------------------------------------------------------------
	/**��ӳ�䷽������ͬ���豸ӳ�䵽��ͬ����ֵ*/
	static final public int getKeyValue(int keyCode) {
		switch (keyCode) {
			case Canvas.KEY_NUM0 :
				return AScreen.KEY_0;
			case Canvas.KEY_NUM1 :
				return AScreen.KEY_1;
			case Canvas.KEY_NUM2 :
				return AScreen.KEY_2;
			case Canvas.KEY_NUM3 :
				return AScreen.KEY_3;
			case Canvas.KEY_NUM4 :
				return AScreen.KEY_4;
			case Canvas.KEY_NUM5 :
				return AScreen.KEY_5;
			case Canvas.KEY_NUM6 :
				return AScreen.KEY_6;
			case Canvas.KEY_NUM7 :
				return AScreen.KEY_7;
			case Canvas.KEY_NUM8 :
				return AScreen.KEY_8;
			case Canvas.KEY_NUM9 :
				return AScreen.KEY_9;
			case Canvas.KEY_POUND :
				return AScreen.KEY_POUND;
			case Canvas.KEY_STAR :
				return AScreen.KEY_STAR;
			case -1 :
			case 1 :
				return AScreen.KEY_UP;
			case -2 :
			case 6 :
				return AScreen.KEY_DOWN;
			case -3 :
			case 2 :
				return AScreen.KEY_LEFT;
			case -4 :
			case 5 :
				return AScreen.KEY_RIGHT;
			case -6 :
			case 21 :
				return AScreen.KEY_A;
			case -7 :
			case 22 :
				return AScreen.KEY_B;
			case -5 :
			case 20 :
				return AScreen.KEY_C;
			default :
				return 0;
		}
	}
	
	final protected void keyPressed(int keyCode) {
		int Code = getKeyValue(keyCode);
		AScreen.KeyDownState |= Code;
		AScreen.KeyState |= Code;
	}

	final protected void keyReleased(int keyCode) {
		int Code = getKeyValue(keyCode);
		AScreen.KeyUpState |= Code;
		AScreen.KeyState &= (~Code);
	}

	final protected void pointerPressed(int x, int y) {
		AScreen.PointerState = true;
		AScreen.PointerDownState = true;
		AScreen.PointerDragState = false;
		AScreen.PointerX = x;
		AScreen.PointerY = y;
	}

	final protected void pointerReleased(int x, int y) {
		AScreen.PointerState = false;
		AScreen.PointerUpState = true;
		AScreen.PointerDragState = false;
		AScreen.PointerX = x;
		AScreen.PointerY = y;
	}

	final protected void pointerDragged(int x, int y) {
		AScreen.PointerDragState = true;
		AScreen.PointerX = x;
		AScreen.PointerY = y;
	}



	//-------------------------------------------------------------------------------------------------

	final protected void paint(Graphics g) {
		AScreen.queryKey();
		
		AScreen.TryChangeSubSreen();
		
		if(AScreen.CurSubScreen!=null){
			if(AScreen.LogicEnable){
				AScreen.CurSubScreen.notifyLogic();
			}
			if(AScreen.RenderEnable){
				AScreen.CurSubScreen.notifyRender(g);
			}
			if(AScreen.TransitionEnable==false){
				AScreen.Transition = false;
			}
		}
		
		AScreen.Transition(g,getWidth(),getHeight());
		

	}

	//-----------------------------------------------------------------------------------------------


	protected void hideNotify() {
		if(AScreen.CurSubScreen!=null){
			if(AScreen.LogicEnable){
				AScreen.CurSubScreen.notifyPause();
			}
		}
	}
	
	protected void showNotify() {
		if(AScreen.CurSubScreen!=null){
			if(AScreen.LogicEnable){
				AScreen.CurSubScreen.notifyResume();
			}
		}
	
	}

//	--------------------------------------------------------------------------------------------------

	
}

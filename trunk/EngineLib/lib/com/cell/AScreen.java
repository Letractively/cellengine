package com.cell;

import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;



/**
 * ����Ļ��</br>
 * ����ͬ����Ϸ��Ļ״̬�����磺�˵����桢��Ϸ���桢�������桢�ȵȡ�ÿ�ֽ���ֻ��Ҫʵ�ָ��࣬������Ҫȥ�����豸�йص�Canvas��
 * @author yifeizhang
 * @since 2006-11-30 
 * @version 1.0
 */
abstract public class AScreen extends CObject {
//	-------------------------------------------------------------------------------------------------------
//	game refer
	
	/**��Ϸ������־*/
	static public boolean ExitGame = false;
	
	/**��ǰ��AScreenʵ��*/
	static public AScreen CurSubScreen = null;
	
	/**��Ļ��*/
	static public int SCREEN_WIDTH = 176;
	/**��Ļ��*/
	static public int SCREEN_HEIGHT = 208;
	/**��Ļˮƽ���ĵ�*/
	static public int SCREEN_HCENTER = 176/2;
	/**��Ļ��ֱ���ĵ�*/
	static public int SCREEN_VCENTER = 208/2;

	/**��Ϸ�е�֡�ӳ٣���λms������Ԥ����ϷFPS=30��FrameDelay = 1000/30 = 33*/
	static public int FrameDelay = 25;//default fps = 50
	/**�Ƿ�������*/
	static public boolean KeyEnable = true;
	/**�Ƿ������߼�*/
	static public boolean LogicEnable = true;
	/**�Ƿ�������Ⱦ*/
	static public boolean RenderEnable = true;
	/**�Ƿ�����������Ч*/
	static public boolean TransitionEnable = true;

	//	------------------------------------------------------------------------------------------------------	

	/**
	 * canvas notifyHide call back </br>
	 * ��Ϸ����ϵͳ��ͣ�¼�ʱ�ص�
	 */
	abstract public void notifyPause();
	/**
	 * canvas notifyShow call back</br>
	 * ��Ϸ����ϵͳ�ָ��¼�ʱ�ص�
	 */
	abstract public void notifyResume();
	/**
	 * main game logic call back</br>
	 * ��Ϸ�߼�,ִ���߼��Ļص�������ÿ֡����Ⱦǰ��ִ��һ��
	 */
	abstract public void notifyLogic();
	/**
	 * main render call back : canvas paint call back</br>
	 * ��Ϸ��Ⱦ,ִ����Ⱦ�Ļص�������ÿ֡��ִ��һ��
	 * @param g 
	 */
	abstract public void notifyRender(Graphics g);

	//--------------------------------------------------------------------------------------------------------------------
	
	/**��ǰ�Ƿ��ڽ�����Ļ�л�*/
	static public boolean 	Transition 			= false;
	
	static private int 		TransitionMaxTime 	= 0 ;
	static private int 		TransitionTime 		= 0 ;
	static private boolean 	TransitionIn 		= false;
	static private boolean 	TransitionOut 		= false;
	
	static private String 	TransitionText[] 	= new String[]{"Loading..."};
	static private int 		TransitionCellW 	= 16;
	static private int		TransitionDelta 	= 2;

	/**
	 * ��⵱ǰ��Ļ״̬�Ƿ��ڽ�����Ļ�л���
	 * @return 
	 */
	static public boolean isTransition(){
		return Transition;
	}
	
	
	/**
	 * ���õ�ǰ��Ļ�л�״̬Ϊ����״̬ 
	 */
	static public void setTransitionIn(){
		Transition = true;
		TransitionMaxTime = SCREEN_WIDTH / TransitionCellW + TransitionCellW/TransitionDelta;
		TransitionTime = 0;
		TransitionIn = true;
		TransitionOut = false;
	}
	/**
	 * ���õ�ǰ��Ļ�л�״̬Ϊ�ر�״̬
	 */
	static public void setTransitionOut(){
		Transition = true;
		TransitionMaxTime = SCREEN_WIDTH / TransitionCellW + TransitionCellW/TransitionDelta;
		TransitionTime = 0;
		TransitionIn = false;
		TransitionOut = true;
	}
	
	/**
	 * ��ǰ��Ļ�л�״̬�Ƿ��ڽ��йر�
	 * @return 
	 */
	static public boolean isTransitionOut(){
		if(!TransitionOut || TransitionTime>TransitionMaxTime)return true;
		return false;
	}
	/**
	 * ��ǰ��Ļ�л�״̬�Ƿ��ڽ��н���
	 * @return 
	 */
	static public boolean isTransitionIn(){
		if(!TransitionIn || TransitionTime>TransitionMaxTime)return true;
		return false;
	}
	
	/**
	 * ��Ⱦ�л���Ļ����Ч
	 * @param g
	 * @param w �����
	 * @param h ���߶�
	 */
	static public void Transition(Graphics g,int w,int h){
		TransitionTime++;
		
		if(TransitionIn && TransitionTime>TransitionMaxTime){
			Transition = false;
		}
		if(Transition==false){
			return;
		}
		
		//System.out.println("Transition Screen : " + TransitionTime);
		
		g.setClip(0, 0, w, h);
		g.setColor(0);

		int count = w/TransitionCellW+1;
		if(TransitionIn){// black -> clean
			for(int i=0;i<count;i++){
				g.fillRect(
						i*TransitionCellW , 0, 
						TransitionCellW-(TransitionTime-i)*TransitionDelta, h);
			}
		}
		if(TransitionOut){//clean -> black
			for(int i=0;i<count;i++){
				g.fillRect(
						i*TransitionCellW - (TransitionTime-i)*TransitionDelta, 0, 
						(TransitionTime-i)*TransitionDelta, h);
			}
		}
		

		// draw string
		if (TransitionText != null && (
				(TransitionIn && TransitionTime<=1) || 
				(TransitionOut && TransitionTime>=TransitionMaxTime-1)
			))
		{
//			g.setColor(0xffffffff);
//		    g.drawString(
//		    		TransitionText, 
//		    		w/2-AScreen.CurFont.stringWidth(TransitionText)/2, 
//		    		h/2-AScreen.CurFont.getHeight()/2, 
//		    		0
//		    		);
			
			int th = (getStringHeight() + 1) * TransitionText.length;
	    	int ty = SCREEN_HEIGHT/2 - th/2;
	    	
	    	for(int i=0;i<TransitionText.length;i++){
	            	drawString(g, TransitionText[i], 
	        				SCREEN_WIDTH/2 - getStringWidth(TransitionText[i])/2 , 
	        				ty + (getStringHeight() + 1) * i , 
	        				0xffffffff);
	            	
	    	}
		}

		
	}
	
//	---------------------------------------------------------------------------------
	
	static private String NextScreenClassName = null;

	/**
	 * �л�����һ��
	 * @param screenClassName ��̳е�CScreen������
	 */
	static public void ChangeSubScreen(String screenClassName) 
	{
		TransitionText = new String[]{"Loading..."};
		NextScreenClassName = screenClassName;
		KeyEnable = false;
		LogicEnable = false;
		setTransitionOut();
	}
	
	/**
	 * �л�����һ��
	 * @param screenClassName ��̳е�CScreen������
	 * @param transitionText ��Ҫ������ʱ��ʾ������
	 */
	static public void ChangeSubScreen(String screenClassName,String transitionText) 
	{
		TransitionText = new String[]{transitionText};
		NextScreenClassName = screenClassName;
		KeyEnable = false;
		LogicEnable = false;
		setTransitionOut();
	}
	
	/**
	 * �л�����һ��
	 * @param screenClassName ��̳е�CScreen������
	 * @param transitionText ��Ҫ������ʱ��ʾ������
	 */
	static public void ChangeSubScreen(String screenClassName,String[] transitionText) 
	{
		TransitionText = transitionText;
		NextScreenClassName = screenClassName;
		KeyEnable = false;
		LogicEnable = false;
		setTransitionOut();
	}
	
	/**
	 * ����Ƿ�����Ļ�л��¼�������еĻ����л���Ļ��������ݼ��ء�
	 */
	static public void TryChangeSubSreen() {
	    if (NextScreenClassName!=null && isTransitionOut()){
	    	try {
		    	CurSubScreen = null;
		    	
		    	System.gc();
				Thread.sleep(1);
			
				CurSubScreen = (AScreen)((Class.forName(NextScreenClassName)).newInstance());
			
		    	KeyEnable = true;
				LogicEnable = true;
		    	setTransitionIn();
		    	NextScreenClassName = null;
	    	} catch (Exception e) {
	    		System.out.println(e.getMessage());
				ExitGame = true;
			}
		}
	}


	

	//	-------------------------------------------------------------------------------------------------------
//	key refer
	//����
	static final public int KEY_ANY 	= 0xffffffff;
	static final public int KEY_0 		= 1;
	static final public int KEY_1 		= 2;
	static final public int KEY_2 		= 4;
	static final public int KEY_3 		= 8;
	static final public int KEY_4 		= 16;
	static final public int KEY_5 		= 32;
	static final public int KEY_6 		= 64;
	static final public int KEY_7 		= 128;
	static final public int KEY_8 		= 256;
	static final public int KEY_9 		= 512;
	static final public int KEY_POUND 	= 1024;
	static final public int KEY_SHARP 	= 1024;
	static final public int KEY_STAR 	= 2048;
	static final public int KEY_UP 		= 4096;
	static final public int KEY_DOWN 	= 8192;
	static final public int KEY_LEFT 	= 16384;
	static final public int KEY_RIGHT 	= 32768;
	static final public int KEY_A 		= 65536;
	static final public int KEY_B 		= 131072;
	static final public int KEY_C 		= 262144;
	static final public int KEY_SEND 	= 524288;
	
	// key
	static public int KeyState = 0;//������ʱ״̬
	static public int KeyDownState = 0;//��������״̬
	static public int KeyUpState = 0;//��������״̬

	static public boolean PointerState = false;//������״̬
	static public boolean PointerDragState = false;
	static public boolean PointerDownState = false;
	static public boolean PointerUpState = false;

	static public int CurKeyState = 0;//������ʱ״̬����
	static public int CurKeyDownState = 0;//��������״̬����
	static public int CurKeyUpState = 0;//��������״̬����
	
	static public boolean CurPointerState = false;//������״̬����
	static public boolean CurPointerDragState = false;
	static public boolean CurPointerDownState = false;
	static public boolean CurPointerUpState = false;
	static public int PointerX;
	static public int PointerY;

	
	/**
	 * ��ռ�״̬ 
	 */
	static final public void clearKey(){
		KeyState = 0;
		KeyDownState = 0;
		KeyUpState = 0;
		
		PointerState = false;
		PointerDragState = false;
		PointerDownState = false;
		PointerUpState = false;

		CurKeyState = 0;
		CurKeyDownState = 0;
		CurKeyUpState = 0;
		
		CurPointerState = false;
		CurPointerDragState = false;
		CurPointerDownState = false;
		CurPointerUpState = false;
		
		PointerX = 0;
		PointerY = 0;
	}

	
	/**
	 * ��ѯ���������¼�״̬ 
	 */
	static final public void queryKey(){
		CurKeyState = KeyState;
		CurKeyDownState = KeyDownState;
		CurKeyUpState = KeyUpState;

		CurPointerState = PointerState;
		CurPointerDragState = PointerDragState;
		CurPointerDownState = PointerDownState;
		CurPointerUpState = PointerUpState;
		
		KeyDownState = 0;
		KeyUpState = 0;

		PointerDownState = false;
		PointerUpState = false;
		PointerDragState = false;
	}
	
	//����
	/**
	 * ���ָ���ļ��Ƿ񱻰���
	 * @param TheKey ������
	 * @return 
	 */
	static public boolean isKeyDown(int TheKey) {
		if(!KeyEnable)return false;
		return (CurKeyDownState & TheKey) != 0;
	}

	/**
	 * ���ָ���ļ��Ƿ��ɿ�
	 * @param TheKey
	 * @return 
	 */
	static public boolean isKeyUp(int TheKey) {
		if(!KeyEnable)return false;
		return (CurKeyUpState & TheKey) != 0;
	}
	/**
	 * ���ָ���ļ��Ƿ񱻰�ס
	 * @param TheKey
	 * @return 
	 */
	static public boolean isKeyHold(int TheKey) {
		if(!KeyEnable)return false;
		return (CurKeyState & TheKey) != 0;
	}
	/**
	 * ��ⴥ�����Ƿ��ס
	 * @return 
	 */
	static public boolean isPointerHold() {
		if(!KeyEnable)return false;
		return (CurPointerState);
	}
	/**
	 * ��ⴥ�����Ƿ񱻵���
	 * @return 
	 */
	static public boolean isPointerDown() {
		if(!KeyEnable)return false;
		return (CurPointerDownState);
	}
	/**
	 * ��ⴥ�����Ƿ��ɿ�
	 * @return 
	 */
	static public boolean isPointerUp() {
		if(!KeyEnable)return false;
		return (CurPointerUpState);
	}
	/**
	 * ��ⴥ�����Ƿ��϶�
	 * @return 
	 */
	static public boolean isPointerDrag() {
		if(!KeyEnable)return false;
		return (CurPointerDragState);
	}
	/**
	 * �õ�������λ��
	 * @return 
	 */
	static public int getPointerX(){
		return PointerX;
	}
	/**
	 * �õ�������λ��
	 * @return 
	 */
	static public int getPointerY(){
		return PointerY;
	}

//	------------------------------------------------------------------------------------------------------
//	paint refer
	/**current font*/
	static public Font CurFont = Font.getDefaultFont();
	
	/**
	 * �����Ļ�� clip
	 * @param g 
	 */
	static public void clearClip(Graphics g) {
		g.setClip(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
	}

	/**
	 * �����Ļ
	 * @param g
	 * @param Color 
	 */
	static public void clearScreen(Graphics g,int Color) {
		g.setColor(Color);
		g.fillRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
	}
	/**
	 * ����������Ļ
	 * @param g
	 * @param Color 
	 */
	static public void clearScreenAndClip(Graphics g,int Color) {
		clearClip(g);
		clearScreen(g,Color);
	}
	
	/**
	 * get current width with string
	 * �õ���ǰ������ַ������
	 * @param str
	 * @return 
	 */
	static public int getStringWidth(String str) {
		return CurFont.stringWidth(str);
	}
	/**
	 * get current font height
	 * �õ���ǰ�ַ��߶�
	 * @return 
	 */
	static public int getStringHeight() {
		return CurFont.getHeight();
	}
	/**
	 * draw string at Graphics object with current font
	 * ���ַ���
	 * @param g
	 * @param str
	 * @param x
	 * @param y
	 * @param Color 
	 */
	static public void drawString(Graphics g, String str, int x, int y,
			int Color) {
		g.setFont(CurFont);
		g.setColor(Color);
		g.drawString(str, x, y, 0);
	}
	/**
	 * take midp 1.0 support midp 2.0 drawRegion (None Flip Rotated) method 
	 * �޷�ת�� drawRegion 
	 * @param g
	 * @param src
	 * @param src_x
	 * @param src_y
	 * @param w
	 * @param h
	 * @param dst_x
	 * @param dst_y 
	 */
	static public void drawRegion(Graphics g, Image src, int src_x, int src_y,
			int w, int h, int dst_x, int dst_y) {
		int cx = g.getClipX();
		int cy = g.getClipY();
		int cw = g.getClipWidth();
		int ch = g.getClipHeight();
		g.setClip(dst_x, dst_y, w, h);
		g.drawImage(src, dst_x - src_x, dst_y - src_y, Graphics.TOP
				| Graphics.LEFT);
		g.setClip(cx, cy, cw, ch);
	}
	
	
	/**
	 * ��ʾFPS
	 * @param g
	 * @param x
	 * @param y 
	 * @param color TODO
	 */
	static public void showFPS(Graphics g,int x,int y, int color){
		drawString(
		        g, "" 
				+ " FPS="
				+ (1000 / ((System.currentTimeMillis() - CurRealTime) == 0 ? 1 : (System.currentTimeMillis() - CurRealTime)))
				+ "/" + FrameDelay
				,
				x,y, 
				color);
		CurRealTime = System.currentTimeMillis();
	}
	static private long CurRealTime = 0 ;
}
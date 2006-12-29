package com.morefuntek.cell.Game;

import com.morefuntek.cell.CObject;

/**
 * ֡������͵ĸ���
 * @author yifeizhang
 * @since 2006-11-30 
 * @version 1.0
 */
public class CGroup extends CObject {

	protected int Frames[][];
	
	protected int SubIndex; //��ǰ�Ӿ�����
	protected int SubCount; //��Ͼ�����Ӿ�����
	
	protected short w_left = 0;
	protected short w_top = 0;
	protected short w_botton = 1;
	protected short w_right = 1;
	
	
	/**
	 * ��������
	 * @param left
	 * @param top
	 * @param right
	 * @param botton 
	 */
	protected void fixArea(int left, int top, int right, int botton) {
		if (left < w_left)
			w_left = (short) left;
		if (top < w_top)
			w_top = (short) top;
		if (right > w_right)
			w_right = (short) right;
		if (botton > w_botton)
			w_botton = (short) botton;
	}
	
	/**
	 * fast detect 2 collides's area specify frame, 
	 * area is every part within a frame's max scope. 
	 * </br>
	 * ������ײ������Χ����һ����ײ���Ƿ��ཻ�������ڿ����ų�
	 * @param c1
	 * @param index1
	 * @param x1 ������ײ��x����
	 * @param y1 ������ײ��y����
	 * @param c2
	 * @param index2
	 * @param x2
	 * @param y2
	 * @return 
	 */
	static public boolean touchArea(
			CGroup c1,int x1,int y1,
			CGroup c2,int x2,int y2){
		if(CCD.cdRect(
				x1 + c1.w_left,  
				y1 + c1.w_top, 
				x1 + c1.w_right,  
				y1 + c1.w_botton, 
				x2 + c2.w_left, 
				y2 + c2.w_top, 
				x2 + c2.w_right, 
				y2 + c2.w_botton)){
			return true;
		}
		return false;
	}
	
	/**
	 * set frame sequence, frames[frame id][part id] = groupted object. </br> 
	 * e.g. : animates's image id ; collides's CCD object ;</br>
	 * 
	 * ����֡���У� frame[֡��][������] = ��Դ������ͼƬ����ײ�飩
	 * @param frames frames[frame id][part id]
	 */
	public void setFrame(int[][] frames){
		Frames = frames;
	}
	
	/**
	 * set part sequence specify frame index</br>
	 * �������֡��һ֡��N��������ɵģ�
	 * @param frame frames[frame id][part id]
	 * @param index frame id
	 */
	public void setComboFrame(int[] frame,int index){
		Frames[index] = frame;
	}
	
	/**
	 * get frames count</br>
	 * �õ�֡����
	 * @return count
	 */
	public int getCount(){
		return Frames.length;
	}
	
}

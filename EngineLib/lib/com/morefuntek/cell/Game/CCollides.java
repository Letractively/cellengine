package com.morefuntek.cell.Game;


import javax.microedition.lcdui.Graphics;

/**
 * Collides contian some frame, it have a coordinate system with all part. </br>
 * every frame contian some part </br> 
 * every part is a collision block (CCD object) </br>
 * ��ײ�飨��CAnimates�ṹ���ƣ�</br>
 * һ����ײ�����N֡��һ֡����N��������ÿ����������һ����ײ�飬ÿ����ײ�����ڸ���ײ������ϵ������
 * @author yifeizhang
 * @since 2006-11-29 
 * @version 1.0
 */
public class CCollides extends CGroup{
	protected CCD cds[];

	/**
	 * Construct CCD group 
	 * @param cdCount part count </br> ����ײ��������ٿ���ײ��
	 */
	public CCollides(int cdCount){
		
		SubIndex = 0;
		SubCount = (short)cdCount;
		cds = new CCD[cdCount];
		
		Frames = new int[cdCount][];
	}

	/**
	 * add a rectangle collision block part </br>
	 * ���һ��������ײ��
	 * @param mask collision block mask
	 * @param x left
	 * @param y top
	 * @param w width
	 * @param h hight
	 */
	public void addCDRect(int mask, int x, int y, int w, int h) {
		addCD(CCD.createCDRect(mask, x, y, w, h));
	}
	
	/**
	 * add a line collision block part</br>
	 * ���һ������ײ��
	 * @param mask collision block mask
	 * @param px point 1 x
	 * @param py point 1 y
	 * @param qx point 2 x
	 * @param qy point 2 y
	 */
	public void addCDLine(int mask, int px, int py, int qx, int qy) {
		addCD(CCD.createCDLine(
				mask, 
				px,py,qx,qy
				)
		);

	}
	
	/**
	 * add a collision block part</br>
	 * ֱ�����һ��������ײ��
	 * @param cd collision block part
	 */
	public void addCD(CCD cd) {
		if (SubIndex >= SubCount) {
			println("Out of Max CD Count !");
			return;
		}
		cds[SubIndex] = cd;
		if(cd!=null){
			fixArea(cd.X1, cd.Y1, cd.X2, cd.Y2);
		}
		
		Frames[SubIndex] = new int[]{SubIndex};
		SubIndex++;
	}

	//---------------------------------------------------------------------------------
	/**
	 * Get a collision block form group, return ccd[index];
	 * </br>
	 * ����ײ����õ���ײ��
	 * @param index ccd[index]
	 * @return collision block
	 */
	public CCD getCD(int index){
		return cds[index];
	}
	
	/**
	 * Get collision block form specify frame id and part id </br>
	 * ����֡�źͲ����ŵõ���ײ��
	 * @param frame frame id within collides
	 * @param sub part id within frame
	 * @return image
	 */
	public CCD getFrameCD(int frame,int sub){
		return cds[Frames[frame][sub]];
	}
	
	/**
	 * collision test with a collides specify frame and a collision block (CCD object)</br>
	 * ָ��һ֡��һ����ײ�������ײ���
	 * @param c1 src collides 
	 * @param index1 src frame id
	 * @param x1 src x offset ������ײ��x����
	 * @param y1 src y offset ������ײ��y����
	 * @param c2 dst CCD object
	 * @param x2 dst x offset
	 * @param y2 dst y offset
	 * @return 
	 */
	static public boolean touchCD(
			CCollides c1,int index1,int x1,int y1,
			CCD c2,int x2,int y2){
		for(int i=c1.Frames[index1].length-1;i>=0;i--){
			if( CCD.touch(
					c1.cds[c1.Frames[index1][i]], x1, y1, // 
					c2, x2, y2, //
					true)){
				return true;
			}
		}
		return false;
	}

	
	/**
	 * collision test with a collides specify frame part and a collision block (CCD object)</br>
	 * ָ��һ֡�е�һ��������һ����ײ�������ײ���
	 * @param c1 src collides
	 * @param index1 src frame id
	 * @param part1 src part id
	 * @param x1 src x offset 
	 * @param y1 src y offset
	 * @param c2 dst CCD object
	 * @param x2 dst x offset
	 * @param y2 dst y offset
	 * @return 
	 */
	static public boolean touchSubCD(
			CCollides c1,int index1,int part1,int x1,int y1,
			CCD c2,int x2,int y2){
		if( CCD.touch(
				c1.cds[c1.Frames[index1][part1]], x1, y1, // 
				c2, x2, y2, //
				true)){
			return true;
		}
		return false;
	}
	
	/**
	 * collision test with 2 collides specify frame</br>
	 * ָ��֡��2����ײ�������ײ���
	 * @param c1 collides 1
	 * @param index1 frame id 1
	 * @param x1  x offset 1
	 * @param y1  y offset 1
	 * @param c2 collides 2
	 * @param index2 frame id 2
	 * @param x2  x offset 2
	 * @param y2  y offset 2
	 * @return is intersect
	 */
	static public boolean touch(
			CCollides c1,int index1,int x1,int y1,
			CCollides c2,int index2,int x2,int y2){

		if(touchArea(c1, x1, y1, c2, x2, y2)){
			for(int i=c1.Frames[index1].length-1;i>=0;i--){
				for(int j=c2.Frames[index2].length-1;j>=0;j--){
					if( CCD.touch(
							c1.cds[c1.Frames[index1][i]], x1, y1, // 
							c2.cds[c2.Frames[index2][j]], x2, y2, //
							true)){
						return true;
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * collision test with 2 collides specify frame part</br>
	 * ָ��֡�źͲ�����2����ײ�������ײ���
	 * @param c1 collides 1
	 * @param index1 frame id 1
	 * @param part1 part id 1
	 * @param x1  x offset 1
	 * @param y1  y offset 1
	 * @param c2 collides 2
	 * @param index2 frame id 2
	 * @param part2 part id 2
	 * @param x2  x offset 2
	 * @param y2  y offset 2
	 * @return is intersect
	 */
	static public boolean touchSub(
			CCollides c1,int index1,int part1,int x1,int y1,
			CCollides c2,int index2,int part2,int x2,int y2){
		if( CCD.touch(
				c1.cds[c1.Frames[index1][part1]], x1, y1, // 
				c2.cds[c2.Frames[index2][part2]], x2, y2, //
				true)){
			return true;
		}
		return false;
	}
	
	
	/**
	 * draw a collides block
	 * @param g
	 * @param index frame id
	 * @param x
	 * @param y
	 * @param color 
	 */
	public void render(Graphics g,int index,int x,int y,int color){
//#ifdef _DEBUG
		for(int i=Frames[index].length-1;i>=0;i--){
			cds[Frames[index][i]].render(g, x, y, color);
		}
//#endif
	}
}

/*
 * �����
 * Created on 2005-7-25
 *
 */
package com.cell.game;

import javax.microedition.lcdui.Graphics;

import com.cell.CMath;
import com.cell.CObject;


/**
 * ��ײ��</br> ���е����͵���ײ���������ڿ����ų�����ڣ�����һ���߶ε���ײ�飬 
 * ����2�㲻�ܳ��������ų���η�Χ֮�ڡ�</br>
 * �����Ż�������ײ��ֻ�вſ����ų������ײ��Χ�ڲŽ�һ����⸴����ײ�顣</br>
 * 
 * ע�⣺��ײ������
 */
public class CCD extends CObject{

	/** ������ײ�� */
	final static public short CD_TYPE_RECT = 1;
	/** �߶���ײ�� */
	final static public short CD_TYPE_LINE = 2;
	/** ����ײ�� */
	final static public short CD_TYPE_POINT = 3;
//	/** Բ��ײ�飨�ݲ�֧�֣� */
//	final static public short CD_TYPE_ROUND = 4;

	/** ��ײ���� */
	public short Type;

	//public boolean Active = true;

	/**
	 * ��ײ����</br> 
	 * �ڽ�����ײ����ʱ�򣬵�һ����ײ�����Ժ͵ڶ�����ײ�����Խ��а�λ�������
	 * ���������㣬�������Ӧ����ײ������㣬����ֱ�ӷ���false��
	 */
	public int Mask;

	/**Left */
	public short X1;
	/**Top */
	public short Y1;
	/**Right*/
	public short X2;
	/**Bottom*/
	public short Y2;

	/**
	 * ���캯�� 
	 */
	public CCD() {
	}

	/**
	 * ���캯�� form other
	 * @param theobj 
	 */
	public CCD(CCD theobj) {
		this.Type = theobj.Type;
		this.Mask = theobj.Mask;

		this.X1 = theobj.X1;
		this.Y1 = theobj.Y1;
		this.X2 = theobj.X2;
		this.Y2 = theobj.Y2;
	}

	/**
	 * 
	 * @param g
	 *            ��ͼ�豸
	 * @param px
	 *            ˮƽ����
	 * @param py
	 *            ��ֱ����
	 * @param color
	 *            ��ɫ
	 */
	public void render(Graphics g, int px, int py, int color) {
		//TODO
		if ( Mask == 0) return;
		g.setColor(color);
		switch (Type) {
		case CD_TYPE_LINE:
			g.drawLine(px + X1, py + Y1, px + X2, py + Y2 );
			break;
		case CD_TYPE_RECT:
			g.drawRect(px + X1, py + Y1, X2 - X1 , Y2 - Y1 );
			break;
		}
	}

	/**
	 * ����һ��������ײ��
	 * 
	 * @param mask
	 *            ״̬����
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 * @return ��ײ���ʵ��
	 */
	static public CCD createCDRect(int mask, int x, int y, int w, int h) {
		CCD ret = new CCD();
		ret.Type = CD_TYPE_RECT;
		ret.Mask = mask;

		ret.X1 = (short) x;
		ret.Y1 = (short) y;
		ret.X2 = (short)(x + w-1);
		ret.Y2 = (short)(y + h-1);
		return ret;
	}

	/**
	 * ����һ���߶���ײ��
	 * 
	 * @param mask
	 *            ״̬����
	 * @param x
	 *            �����ų����
	 * @param y
	 * @param w
	 * @param h
	 * @param px
	 *            �߶εĵ�һ��
	 * @param py
	 * @param qx
	 *            �߶εĵڶ���
	 * @param qy
	 * @return ��ײ���ʵ��
	 */
	static public CCD createCDLine(
			int mask, 
			int px, int py, int qx, int qy) {
		CCD ret = new CCD();
		ret.Type = CD_TYPE_LINE;
		ret.Mask =  mask;

		ret.X1 = (short)px;
		ret.Y1 = (short)py;
		
		ret.X2 = (short)qx;
		ret.Y2 = (short)qy;
		
		return ret;
	}

	/**
	 * ����2��ײ���Ƿ���ײ
	 * 
	 * @param b1
	 *            ��һ��
	 * @param x1
	 *            ��һ��ˮƽ����
	 * @param y1
	 *            ��һ�鴹ֱ����
	 * @param b2
	 *            �ڶ���
	 * @param x2
	 *            �ڶ���ˮƽ����
	 * @param y2
	 *            �ڶ��鴹ֱ����
	 * @param processStatus
	 *            �Ƿ���MASK
	 * @return false:true
	 */
	static public boolean touch(
			CCD b1, int x1, int y1, 
			CCD b2, int x2, int y2, 
			boolean processStatus) {
		//TODO
		if ((processStatus && (b1.Mask & b2.Mask) != 0) || !processStatus) {
			if (b1.Type == CD_TYPE_RECT && b2.Type == CD_TYPE_RECT) {
				return touchRect(b1, x1, y1, b2, x2, y2);
			} else if (b1.Type == CD_TYPE_LINE && b2.Type == CD_TYPE_LINE) {
				return touchLine(b1, x1, y1, b2, x2, y2);
			} else if (b1.Type == CD_TYPE_RECT) {
				return touchRectLine(b1, x1, y1, b2, x2, y2);
			} else if (b2.Type == CD_TYPE_RECT) {
				return touchRectLine(b2, x2, y2, b1, x1, y1);
			}
		}
		return false;
	}

	/**
	 * ���2�������ų���Ƿ��ཻ
	 * @param rect1
	 * @param x1
	 * @param y1
	 * @param rect2
	 * @param x2
	 * @param y2
	 * @return false:true
	 */
	static public boolean touchRect(
			CCD src, int sx, int sy, 
			CCD dst, int dx, int dy) {
		return cdRect(
				src.X1 + sx, src.Y1 + sy, 
				src.X2 + sx, src.Y2 + sy, 
				dst.X1 + dx, dst.Y1 + dy, 
				dst.X2 + dx, dst.Y2 + dy);
	}

	
	/**
	 * ���2�߶���ײ���Ƿ��ཻ
	 * @param line1
	 * @param x1
	 * @param y1
	 * @param line2
	 * @param x2
	 * @param y2
	 * @return false:true
	 */
	static public boolean touchLine(
			CCD src, int sx, int sy, 
			CCD dst, int dx, int dy) {
		if (touchRect(src, sx, sy, dst, dx, dy)) {
			return cdLine(
					src.X1 + sx, src.Y1 + sy, 
					src.X2 + sx, src.Y2 + sy, 
					dst.X1 + dx, dst.Y1 + dy, 
					dst.X2 + dx, dst.Y2 + dy);
		}
		return false;
	}

	/**
	 * ��������ײ�������ײ���Ƿ��ཻ
	 * @param rect
	 * @param rx
	 * @param ry
	 * @param line
	 * @param lx
	 * @param ly
	 * @return false:true
	 */
	static public boolean touchRectLine(
			CCD rect, int rx, int ry, 
			CCD line, int lx, int ly) {
		if (cdRect(
				rx + rect.X1, ry + rect.Y1,//
				rx + rect.X2, ry + rect.Y2,//
				lx + Math.min(line.X1,line.X2), ly + Math.min(line.Y1,line.Y2),//
				lx + Math.max(line.X1,line.X2), ly + Math.max(line.Y1,line.Y2))//
		) {
			if (cdLine(//TOP
					(rx + rect.X1) , (ry + rect.Y1) ,//
					(rx + rect.X2) , (ry + rect.Y1) ,//
					(lx + line.X1) , (ly + line.Y1) ,//
					(lx + line.X2) , (ly + line.Y2)))//
				return true;
			if (cdLine(//LEFT
					(rx + rect.X1) , (ry + rect.Y1) ,//
					(rx + rect.X1) , (ry + rect.Y2) ,//
					(lx + line.X1) , (ly + line.Y1) ,//
					(lx + line.X2) , (ly + line.Y2)))//
				return true;
			if (cdLine(//RIGHT
					(rx + rect.X2) , (ry + rect.Y1) ,//
					(rx + rect.X2) , (ry + rect.Y2) ,//
					(lx + line.X1) , (ly + line.Y1) ,//
					(lx + line.X2) , (ly + line.Y2)))//
				return true;
			if (cdLine(//BUTTON
					(rx + rect.X1) , (ry + rect.Y2) ,//
					(rx + rect.X2) , (ry + rect.Y2) ,//
					(lx + line.X1) , (ly + line.Y1) ,//
					(lx + line.X2) , (ly + line.Y2)))//
				return true;
		}
		return false;
	}

	//----------------------------------------------------------------------------------------------------------------------

	/* croe */
	static int v1[] = new int[2];
	static int v2[] = new int[2];
	static int v3[] = new int[2];
	static int v4[] = new int[2];
	
	static int v5[] = new int[2];
	static int v6[] = new int[2];
	static int v7[] = new int[2];
	static int v8[] = new int[2];
	
	
	/**
	 * �ж�2��ֱ�߶��Ƿ���ײ ��Ļ����ϵ: �ж�P1P2����Q1Q2�������ǣ� 
	 * ((Q2-Q1)��(P1-Q1))*((P2-Q1)��(Q2-Q1)) >= 0 
	 * ͬ���ж�Q1Q2����P1P2�������ǣ� 
	 * ((P2-P1)��(Q1-P1))*((Q2-P1)��(P2-P1)) >= 0
	 * 
	 * @param p1x line 1
	 * @param p1y
	 * @param p2x
	 * @param p2y
	 * @param q1x line 2
	 * @param q1y
	 * @param q2x
	 * @param q2y
	 * @return false:true
	 */
	final static public boolean cdLine(
			int p1x, int p1y, int p2x, int p2y,
			int q1x, int q1y, int q2x, int q2y) {
		
		CMath.vectorSub(v1, q2x, q2y, q1x, q1y);//1
		CMath.vectorSub(v2, p1x, p1y, q1x, q1y);//2
		CMath.vectorSub(v3, p2x, p2y, q1x, q1y);//3
//		CMath.vectorSub(v4, q2x, q2y, q1x, q1y);//4=1
		
		CMath.vectorSub(v5, p2x, p2y, p1x, p1y);//5
		CMath.vectorSub(v6, q1x, q1y, p1x, p1y);//6
		CMath.vectorSub(v7, q2x, q2y, p1x, p1y);//7
//		CMath.vectorSub(v8, p2x, p2y, p1x, p1y);//8=5
		
		if (CMath.vectorCrossProduct(v1, v2) * CMath.vectorCrossProduct(v3, v1) >= 0 && 
			CMath.vectorCrossProduct(v5, v6) * CMath.vectorCrossProduct(v7, v5) >= 0) {
			return true;
		}
		return false;
	}

	/**
	 * �ж�2�������Ƿ���ײ</br>
	 * ��һ������</br>
	 * @param sx1 
	 * @param sy1
	 * @param sx2
	 * @param sy2
	 * �ڶ�������</br>
	 * @param dx1 
	 * @param dy1
	 * @param dx2
	 * @param dy2
	 * @return false:true �Ƿ���ײ
	 */
	final static public boolean cdRect(
			int sx1, int sy1, int sx2, int sy2, 
			int dx1, int dy1, int dx2, int dy2) {
		if (sx2 < dx1)		return false;
		if (sx1 > dx2)		return false;
		if (sy2 < dy1)		return false;
		if (sy1 > dy2)		return false;
		return true;
	}

	/**
	 * �ж�2�������Ƿ���ײ</br>
	 * ��һ������</br>
	 * @param sx1 
	 * @param sy1
	 * @param sx2
	 * @param sy2
	 * �ڶ�������</br>
	 * @param dx1 
	 * @param dy1
	 * @param dx2
	 * @param dy2
	 * @return false:true �Ƿ���ײ
	 */
	final static public boolean cdRectPoint(
			int sx1, int sy1, int sx2, int sy2, 
			int dx, int dy) {
		if (sx2 < dx)		return false;
		if (sx1 > dx)		return false;
		if (sy2 < dy)		return false;
		if (sy1 > dy)		return false;
		return true;
	}
}
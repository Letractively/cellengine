/**
 * ��Ȩ����[2006][�����]
 *
 * ����2.0�汾Apache���֤("���֤")��Ȩ��
 * ���ݱ����֤���û����Բ�ʹ�ô��ļ���
 * �û��ɴ�������ַ������֤������
 * http://www.apache.org/licenses/LICENSE-2.0
 * ���������÷�����Ҫ������ͬ�⣬
 * �������֤�ַ�������ǻ���"��ԭ��"�����ṩ��
 * ���κ���ʾ�Ļ�ʾ�ı�֤��������
 * ����������֤����£��ض����ԵĹ�ϽȨ�޺����ơ�
 */
package com.cell;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;


/**
 * @author yifeizhang
 * IImages��MIDP2.0ʵ��
 */
public class CImages20 extends CObject implements IImages {
	/** TILE��ĸ��� */
	protected int Count = 0;
	/**��ǰ�����˶�����ͼƬ*/
	protected int CurIndex = 0;

	//ԭͼ
	protected Image srcImage = null;
	
	//ͼƬ������
//	protected int ImageCount = 0;
//	protected int ImageIndex = 0;
//	protected Image[] Tiles = null;

	protected short[] TileX;
	protected short[] TileY;
	protected short[] TileW;
	protected short[] TileH;
	
	static final private short[] TRANS_TABLE = {
		0,//TRANS_NONE
		1,//TRANS_V
		2,//TRANS_H
		3,//TRANS_HV
		4,//TRANS_H90
		5,//TRANS_270
		6,//TRANS_90
		7 //TRANS_V90
	};

	//--------------------------------------------------------------------------------------------------------

	/**
	 * override ����
	 * @see com.cell.IImages#buildImages(javax.microedition.lcdui.Image, int)
	 */
	public void buildImages(Image srcImage, int count) {
		Count = count;
		CurIndex = 0;
		
		this.srcImage = srcImage;
		
		TileX = new short[Count];
		TileY = new short[Count];
		TileW = new short[Count];
		TileH = new short[Count];
	}

	/**
	 * override ����
	 * @see com.cell.IImages#getImage(int)
	 */
	public Image getSrcImage(){
		return srcImage;
	}
	
	public Image getImage(int index){
		return srcImage;
	}
	
	/**
	 * override ����
	 * @see com.cell.IImages#getKeyColor(int, int)
	 */
	public int getPixel(int index, int x,int y){
		int[] c = new int[1];
		srcImage.getRGB(c, 0, 1, TileX[index]+x, TileY[index]+y, 1, 1);
		return c[0];
	}
	
	/**
	 * override ����
	 * @see com.cell.IImages#getWidth(int)
	 */
	public int getWidth(int Index) {
		return TileW[Index];
	}

	/**
	 * override ����
	 * @see com.cell.IImages#getHeight(int)
	 */
	public int getHeight(int Index) {
		return TileH[Index];
	}


	/**
	 * override ����
	 * @see com.cell.IImages#getCount()
	 */
	public int getCount(){
		return CurIndex;
	}

	/**
	 * ��ԭͼ���ŵ���ӵ����
	 * 
	 * @return �Ƿ�δװ��
	 */
	public boolean addTile() {
		return addTile(0,0,srcImage.getWidth(),srcImage.getHeight());
	}

	/**
	 * ��ԭͼ��һ�������г�Сͼ���Ž����
	 * 
	 * @param TileX
	 *            ��ԭͼ��x���
	 * @param TileY
	 *            ��ԭͼ��y���
	 * @param TileWidth
	 *            ��ԭͼ�Ŀ�
	 * @param TileHeight
	 *            ��ԭͼ�ĸ�
	 * @return false �Ƿ�δװ��
	 */
	public boolean addTile(int TileX, int TileY, int TileWidth,int TileHeight) {
		if (CurIndex < Count) {
			if (TileWidth <= 0 || TileHeight <= 0) {
				this.TileX[CurIndex] = (short)0;
				this.TileY[CurIndex] = (short)0;
				this.TileW[CurIndex] = (short)1;
				this.TileH[CurIndex] = (short)1;
			} else {
				this.TileX[CurIndex] = (short)TileX;
				this.TileY[CurIndex] = (short)TileY;
				this.TileW[CurIndex] = (short)TileWidth;
				this.TileH[CurIndex] = (short)TileHeight;
			}
			CurIndex++;
		}
		if (CurIndex >= Count) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * ��ԭͼ���������г�����Сͼ���Ž����
	 * 
	 * @param ClipX
	 *            ��ԭͼ��x���
	 * @param ClipY
	 *            ��ԭͼ��y���
	 * @param ClipWidth
	 *            ��ԭͼ��������
	 * @param ClipHeight
	 *            ��ԭͼ��������
	 * @param TileWidth
	 *            ÿ��Ŀ�
	 * @param TileHeight
	 *            ÿ��ĸ�
	 */
	public void addTile(
			int ClipX, int ClipY, 
			int ClipWidth, int ClipHeight, 
			int TileWidth, int TileHeight) {
		if (CurIndex < Count) {
			for (int j = 0; j < ClipHeight / TileHeight; j++) {
				for (int i = 0; i < ClipWidth / TileWidth; i++) {
					if (!addTile(
							ClipX + TileWidth * i, 
							ClipY + TileHeight * j,
							TileWidth, 
							TileHeight)) {
						return;
					}
				}
			}
		}
	}
//
//	/**
//	 * override ����
//	 * @see com.morefuntek.cell.IImages#render(javax.microedition.lcdui.Graphics, int, int, int)
//	 */
//	public void render(Graphics g, int Index, int PosX, int PosY) {//	����ѡ����뷽ʽ,������ת
//		try {
//			render(g,Index,PosX,PosY,0);
//		} catch (RuntimeException e) {
//			println("Null Tile at " + Index);
//		}
//	}
//
//	/**
//	 * override ����
//	 * @see com.morefuntek.cell.IImages#render(javax.microedition.lcdui.Graphics, int, int, int, int)
//	 */
//	public void render(Graphics g, int Index, int PosX, int PosY, int Style) {
//		try {
//			GraphicsUtil.drawRegion(
//					g,
//					srcImage,
//					TileX[Index], //
//					TileY[Index], //
//					TileW[Index], //
//					TileH[Index], //
//					TRANS_TABLE[Style], //
//					PosX,//
//					PosY,//
//					Graphics.TOP | Graphics.LEFT//
//					);
//			
//		} catch (RuntimeException e) {
//			println("Null Tile at " + Index);
//		}
//	}




	/**
	 * override ����
	 * @see com.cell.IImages#render(javax.microedition.lcdui.Graphics, int, int, int)
	 */
	public void render(Graphics g, int Index, int PosX, int PosY) {//	����ѡ����뷽ʽ,������ת
		render(g,Index,PosX,PosY,0);
	}

	/**
	 * override ����
	 * @see com.cell.IImages#render(javax.microedition.lcdui.Graphics, int, int, int, int)
	 */
	public void render(Graphics g, int Index, int PosX, int PosY, int Style) {
		try {
			g.drawRegion(
					srcImage,
					TileX[Index], //
					TileY[Index], //
					TileW[Index], //
					TileH[Index], //
					TRANS_TABLE[Style], //
					PosX,//
					PosY,//
					Graphics.TOP | Graphics.LEFT//
					);
			
		} catch (RuntimeException e) {
			println("Null Tile at " + Index);
		}
	}

}

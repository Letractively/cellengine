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

import com.nokia.mid.ui.DirectGraphics;
import com.nokia.mid.ui.DirectUtils;

/**
 * @author yifeizhang
 * IImages��Nokiaʵ��
 */
public class CImagesNokia extends CObject implements IImages {
	
	/** TILE��ĸ��� */
	protected int Count = 0;
	protected int CurIndex = 0;

	protected Image TileImage = null;
	protected Image[] Tiles = null;
	//��midp2.0ת���ķ�ת��
	static final private short[] TRANS_TABLE = {
		0,//TRANS_NONE
		0x4000, //TRANS_V
		0x2000,//TRANS_H
		0x2000 | 0x4000,//TRANS_HV
		0x4000 | 90,//TRANS_H90
		270,//TRANS_270
		90,//TRANS_90
		0x2000 | 90 //TRANS_V90
	};
	//--------------------------------------------------------------------------------------------------------

	/**
	 * ����һ��TileGroup
	 * 
	 * @param NewTileImage ԭͼƬ
	 * @param NewTileCount �г���ͼ�ĸ���
	 */
	public void buildImages(Image srcImage, int count) {
		gc();
		Count = count;
		Tiles = new Image[Count];
		CurIndex = 0;
		setTileImage(srcImage);
		//println("Images Count = " + NewTileCount);
	}


	/**
	 * ��������ڴ档 ��ʼ����TILE������������顣
	 *  
	 */
	final public void gc() {
		TileImage = null;
		System.gc();
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * ������ŵõ�ͼƬ����
	 * @param index
	 * @return 
	 */
	final public Image getSrcImage(){
		return Tiles[0];
	}
	
	public Image getImage(int index){
		return Tiles[0];
	}
	
	/**
	 * override ����
	 * @see com.cell.IImages#getRGBFormPixcel(int, int)
	 */
	public int getPixel(int index, int x,int y){
		int[] c = new int[1];
//		Image k = getImage(index);
//		k.getRGB(c, 
//				0, 1, 
//				offset%k.getWidth(), 
//				offset/k.getWidth(), 
//				1, 1);
		return c[0];
	}
	
	/**
	 * �õ���ͼ�Ŀ��
	 * 
	 * @param Index
	 *            ��ͼ���
	 * @return ���
	 */
	final public int getWidth(int Index) {
		return Tiles[Index].getWidth();
	}

	/**
	 * �õ���ͼ�ĸ߶�
	 * 
	 * @param Index
	 *            ��ͼ���
	 * @return �߶�
	 */
	final public int getHeight(int Index) {
		return Tiles[Index].getHeight();
	}

	/**
	 * override ����
	 * @see com.cell.IImages#getCount()
	 */
	final public int getCount(){
		return CurIndex;
	}
	/**
	 * ������һ��ͼƬ��Ϊԭͼ��
	 * 
	 * @param NewTileImage
	 */
	final public void setTileImage(Image NewTileImage) {
		TileImage = NewTileImage;
		System.gc();
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * ��ԭͼ���ŵ���ӵ����
	 * 
	 * @return �Ƿ�δװ��
	 */
	final public boolean addTile() {
		if (CurIndex < Count) {
			if (TileImage == null) {
				Tiles[CurIndex] = Image.createImage(1, 1);
			} else {
				Tiles[CurIndex] = TileImage;
			}
			CurIndex++;
		}
		if (CurIndex >= Count) {
			gc();
			return false;
		} else {
			return true;
		}
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
	final public boolean addTile(int TileX, int TileY, int TileWidth,
			int TileHeight) {
		if (CurIndex < Count) {
			if (TileWidth <= 0 || TileHeight <= 0) {
				Tiles[CurIndex] = Image.createImage(1, 1);
			} else {
				
				Image img = DirectUtils.createImage(TileWidth,TileHeight,0x00ff00ff);
			    DirectGraphics dg = DirectUtils.getDirectGraphics(img.getGraphics());
			    dg.drawImage(TileImage,-TileX,-TileY,0,0);
			    Tiles[CurIndex] = img;
				
			}
			CurIndex++;
		}
		if (CurIndex >= Count) {
			gc();
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
	final public void addTile(int ClipX, int ClipY, int ClipWidth,
			int ClipHeight, int TileWidth, int TileHeight) {
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

	/**
	 * override ����
	 * @see com.cell.IImages#render(javax.microedition.lcdui.Graphics, int, int, int)
	 */
	final public void render(Graphics g, int Index, int PosX, int PosY) {//	����ѡ����뷽ʽ,������ת
		
			g.drawImage(//
					Tiles[Index], //
					PosX,//
					PosY,//
					Graphics.TOP | Graphics.LEFT//
			);
		
	}


	/**
	 * override ����
	 * @see com.cell.IImages#render(javax.microedition.lcdui.Graphics, int, int, int, int)
	 */
	final public void render(Graphics g, int Index, int PosX, int PosY, int Style) {
		
		    DirectUtils.getDirectGraphics(g).drawImage(
		    		Tiles[Index],
		    		PosX,
		    		PosY,
		    		0,
		    		TRANS_TABLE[Style]);
		
	}

}

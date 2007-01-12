package com.morefuntek.cell;

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
	protected Image TileImage = null;
	//ͼƬ������
	protected Image[] Tiles = null;

	
	//--------------------------------------------------------------------------------------------------------

	/**
	 * override ����
	 * @see com.morefuntek.cell.IImages#buildImages(javax.microedition.lcdui.Image, int)
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
	 * override ����
	 * @see com.morefuntek.cell.IImages#gc()
	 */
	public void gc() {
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
	 * override ����
	 * @see com.morefuntek.cell.IImages#getImage(int)
	 */
	public Image getImage(int index){
		return Tiles[index];
	}
	
	/**
	 * override ����
	 * @see com.morefuntek.cell.IImages#getKeyColor(int, int)
	 */
	public int getRGBFormPixcel(int index, int offset){
		int[] c = new int[1];
		Image k = getImage(index);
		k.getRGB(c, 
				0, 1, 
				offset%k.getWidth(), 
				offset/k.getWidth(), 
				1, 1);
		return c[0];
	}
	
	/**
	 * override ����
	 * @see com.morefuntek.cell.IImages#getWidth(int)
	 */
	public int getWidth(int Index) {
		return Tiles[Index].getWidth();
	}

	/**
	 * override ����
	 * @see com.morefuntek.cell.IImages#getHeight(int)
	 */
	public int getHeight(int Index) {
		return Tiles[Index].getHeight();
	}


	/**
	 * override ����
	 * @see com.morefuntek.cell.IImages#getCount()
	 */
	public int getCount(){
		return CurIndex;
	}
	/**
	 * ������һ��ͼƬ��Ϊԭͼ��
	 * 
	 * @param NewTileImage
	 */
	public void setTileImage(Image NewTileImage) {
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
	public boolean addTile() {
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
	public boolean addTile(int TileX, int TileY, int TileWidth,
			int TileHeight) {
		if (CurIndex < Count) {
			if (TileWidth <= 0 || TileHeight <= 0) {
				Tiles[CurIndex] = Image.createImage(1, 1);
			} else {
				Tiles[CurIndex] = Image.createImage(
						TileImage, 
						TileX, TileY,
						TileWidth, TileHeight, 
						0);
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
	public void addTile(int ClipX, int ClipY, int ClipWidth,
			int ClipHeight, int TileWidth, int TileHeight) {
		if (CurIndex < Count) {
			for (int j = 0; j < ClipHeight / TileHeight; j++) {
				for (int i = 0; i < ClipWidth / TileWidth; i++) {
					if (!addTile(ClipX + TileWidth * i, ClipY + TileHeight * j,
							TileWidth, TileHeight)) {
						return;
					}
				}
			}
		}
	}

	/**
	 * 
	 * @param pakfile
	 */
	public void addTile(String pakfile) {
		if (CurIndex < Count) {
			String[] imglist = CIO.getPakFileNameList(pakfile);
			for (int i = 0; i < imglist.length; i++) {
				setTileImage(CIO.loadImage(pakfile, imglist[i]));
				if (!addTile()) {
					return;
				}
			}
		}
	}
	
	/**
	 * 
	 * @param images
	 */
	public void addTile(Image[] images) {
		if (CurIndex < Count) {
			for (int i = 0; i < images.length; i++) {
				setTileImage(images[i]);
				if (!addTile()) {
					return;
				}
			}
		}
	}


	/**
	 * override ����
	 * @see com.morefuntek.cell.IImages#render(javax.microedition.lcdui.Graphics, int, int, int)
	 */
	public void render(Graphics g, int Index, int PosX, int PosY) {//	����ѡ����뷽ʽ,������ת
		try {
			g.drawImage(//
					Tiles[Index], //
					PosX,//
					PosY,//
					Graphics.TOP | Graphics.LEFT//
			);
		} catch (RuntimeException e) {
			println("Null Tile at " + Index);
		}
	}

	/**
	 * override ����
	 * @see com.morefuntek.cell.IImages#render(javax.microedition.lcdui.Graphics, int, int, int, int)
	 */
	public void render(Graphics g, int Index, int PosX, int PosY, int Style) {
		try {
			g.drawRegion(
					Tiles[Index], //
					0, 0, //
					Tiles[Index].getWidth(), //
					Tiles[Index].getHeight(), //
					Style, //
					PosX, PosY,//
					Graphics.TOP | Graphics.LEFT//
			);
		} catch (RuntimeException e) {
			println("Null Tile at " + Index);
		}
	}

}

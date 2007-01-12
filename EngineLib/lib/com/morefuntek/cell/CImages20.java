package com.morefuntek.cell;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

/**
 * @author yifeizhang
 * IImages的MIDP2.0实现
 */
public class CImages20 extends CObject implements IImages {
	
	/** TILE块的个数 */
	protected int Count = 0;
	/**当前加入了多少张图片*/
	protected int CurIndex = 0;

	//原图
	protected Image TileImage = null;
	//图片组内容
	protected Image[] Tiles = null;

	
	//--------------------------------------------------------------------------------------------------------

	/**
	 * override 方法
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
	 * override 方法
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
	 * override 方法
	 * @see com.morefuntek.cell.IImages#getImage(int)
	 */
	public Image getImage(int index){
		return Tiles[index];
	}
	
	/**
	 * override 方法
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
	 * override 方法
	 * @see com.morefuntek.cell.IImages#getWidth(int)
	 */
	public int getWidth(int Index) {
		return Tiles[Index].getWidth();
	}

	/**
	 * override 方法
	 * @see com.morefuntek.cell.IImages#getHeight(int)
	 */
	public int getHeight(int Index) {
		return Tiles[Index].getHeight();
	}


	/**
	 * override 方法
	 * @see com.morefuntek.cell.IImages#getCount()
	 */
	public int getCount(){
		return CurIndex;
	}
	/**
	 * 设置另一张图片做为原图。
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
	 * 把原图整张的添加到组里。
	 * 
	 * @return 是否未装满
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
	 * 把原图的一个区域切成小图，放进组里。
	 * 
	 * @param TileX
	 *            切原图的x起点
	 * @param TileY
	 *            切原图的y起点
	 * @param TileWidth
	 *            切原图的宽
	 * @param TileHeight
	 *            切原图的高
	 * @return false 是否未装满
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
	 * 把原图按照网格切成若干小图，放进组里。
	 * 
	 * @param ClipX
	 *            切原图的x起点
	 * @param ClipY
	 *            切原图的y起点
	 * @param ClipWidth
	 *            切原图的整个宽
	 * @param ClipHeight
	 *            切原图的整个高
	 * @param TileWidth
	 *            每块的宽
	 * @param TileHeight
	 *            每块的高
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
	 * override 方法
	 * @see com.morefuntek.cell.IImages#render(javax.microedition.lcdui.Graphics, int, int, int)
	 */
	public void render(Graphics g, int Index, int PosX, int PosY) {//	不可选择对齐方式,不可旋转
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
	 * override 方法
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

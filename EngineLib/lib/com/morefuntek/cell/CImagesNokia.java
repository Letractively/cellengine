package com.morefuntek.cell;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

import com.nokia.mid.ui.DirectGraphics;
import com.nokia.mid.ui.DirectUtils;

public class CImagesNokia extends CObject implements IImages {
	
	/** TILE块的个数 */
	protected int Count = 0;
	protected int CurIndex = 0;

	protected Image TileImage = null;
	protected Image[] Tiles = null;

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
	 * 生成一个TileGroup
	 * 
	 * @param NewTileImage 原图片
	 * @param NewTileCount 切出的图的个数
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
	 * 清除垃圾内存。 初始化完TILE后必须做的事情。
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
	 * 按照序号得到图片对象
	 * @param index
	 * @return 
	 */
	final public Image getImage(int index){
		return Tiles[index];
	}
	
	/**
	 * 得到子图的宽度
	 * 
	 * @param Index
	 *            子图序号
	 * @return 宽度
	 */
	final public int getWidth(int Index) {
		return Tiles[Index].getWidth();
	}

	/**
	 * 得到子图的高度
	 * 
	 * @param Index
	 *            子图序号
	 * @return 高度
	 */
	final public int getHeight(int Index) {
		return Tiles[Index].getHeight();
	}

	/**
	 * override 方法
	 * @see com.morefuntek.cell.IImages#getCount()
	 */
	final public int getCount(){
		return CurIndex;
	}
	/**
	 * 设置另一张图片做为原图。
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
	 * 把原图整张的添加到组里。
	 * 
	 * @return 是否未装满
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
	 * 
	 * @param pakfile
	 */
	final public void addTile(String pakfile) {
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
	final public void addTile(Image[] images) {
		if (CurIndex < Count) {
			for (int i = 0; i < images.length; i++) {
				setTileImage(images[i]);
				if (!addTile()) {
					return;
				}
			}
		}
	}

	final public void render(Graphics g, int Index, int PosX, int PosY) {//	不可选择对齐方式,不可旋转
		
			g.drawImage(//
					Tiles[Index], //
					PosX,//
					PosY,//
					Graphics.TOP | Graphics.LEFT//
			);
		
	}

	/**
	 * 绘制到指定的Graphics上。
	 * 
	 * @param g 指定的graphics
	 * @param Index 序号
	 * @param PosX X坐标
	 * @param PosY Y坐标
	 * @param Style 翻转方式，参考 CSSprite 里的翻转参数。
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

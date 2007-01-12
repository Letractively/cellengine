package com.morefuntek.cell;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

/**
 * 最底层的对图片的处理。 里面包含了一组图片的集合。 
 * 可以把一个大Image作为原图切成若干块小Image，也可以使用若干Image.
 * @author yifeizhang
 * @since 2006-11-30 
 * @version 1.0
 */
public interface IImages {
	/** 不翻转 */
	final public static byte TRANS_NONE = 0;
	/** 水平翻转 */
	final public static byte TRANS_H = 2;
	/** 垂直翻转 */
	final public static byte TRANS_V = 1;
	/** 180度翻转 */
	final public static byte TRANS_HV = 3;
	/** 逆时针90度翻转 */
	final public static byte TRANS_90 = 6;
	/** 逆时针270度翻转 */
	final public static byte TRANS_270 = 5;
	/** 先逆时针90度翻转，然后在水平翻转 */
	final public static byte TRANS_H90 = 4;
	/** 先逆时针90度翻转，然后在垂直翻转 */
	final public static byte TRANS_V90 = 7;
	/** 180度翻转 */
	final public static byte TRANS_180 = 3; // 180 = HV

	//--------------------------------------------------------------------------------------------------------

	
	/**
	 * 重新创建图片组
	 * @param srcImage 原图片
	 * @param count 数量
	 * @return 
	 */
	public void buildImages(Image srcImage,int count);
	
	
	
	/**
	 * 清除垃圾内存。 初始化完TILE后必须做的事情。
	 *  
	 */
	public void gc() ;

	/**
	 * 按照序号得到图片对象
	 * @param index
	 * @return 
	 */
	public Image getImage(int index);
	
	public int getRGBFormPixcel(int index, int offset);
	
	/**
	 * 得到子图的宽度
	 * @param Index 子图序号
	 * @return 宽度
	 */
	public int getWidth(int Index);

	/**
	 * 得到子图的高度
	 * @param Index 子图序号
	 * @return 高度
	 */
	public int getHeight(int Index);

	/**
	 * 得到图片组图片数量
	 * @return 
	 */
	public int getCount();
	
	/**
	 * 设置另一张图片做为原图。
	 * @param NewTileImage
	 */
	public void setTileImage(Image NewTileImage);

	/**
	 * 把原图整张的添加到组里。
	 * @return 是否未装满
	 */
	public boolean addTile();

	/**
	 * 把原图的一个区域切成小图，放进组里。
	 * @param TileX 切原图的x起点
	 * @param TileY 切原图的y起点
	 * @param TileWidth 切原图的宽
	 * @param TileHeight  切原图的高
	 * @return false 是否未装满
	 */
	public boolean addTile(int TileX, int TileY, int TileWidth, int TileHeight);

	/**
	 * 把原图按照网格切成若干小图，放进组里。
	 * @param ClipX 切原图的x起点
	 * @param ClipY 切原图的y起点
	 * @param ClipWidth 切原图的整个宽
	 * @param ClipHeight 切原图的整个高
	 * @param TileWidth 每块的宽
	 * @param TileHeight 每块的高
	 */
	public void addTile(int ClipX, int ClipY, int ClipWidth, int ClipHeight, int TileWidth, int TileHeight) ;

	/**
	 * 读入一个图片资源包，把包内图片添加到图片组。
	 * 图片包由指定的图片打包器生成。
	 * @param pakfile
	 */
	public void addTile(String pakfile) ;
	
	/**
	 * 把图片数组添加到图片组。
	 * @param images
	 */
	public void addTile(Image[] images) ;

	/**
	 * 绘制到指定的Graphics上。
	 * @param g 指定的graphics
	 * @param Index 序号
	 * @param PosX X坐标
	 * @param PosY Y坐标
	 */
	public void render(Graphics g, int Index, int PosX, int PosY);

	/**
	 * 绘制到指定的Graphics上。
	 * @param g 指定的graphics
	 * @param Index 序号
	 * @param PosX X坐标
	 * @param PosY Y坐标
	 * @param Style 翻转方式 
	 */
	public void render(Graphics g, int Index, int PosX, int PosY, int Style) ;

}

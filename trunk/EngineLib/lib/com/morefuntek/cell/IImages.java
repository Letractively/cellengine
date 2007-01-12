package com.morefuntek.cell;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

/**
 * ��ײ�Ķ�ͼƬ�Ĵ��� ���������һ��ͼƬ�ļ��ϡ� 
 * ���԰�һ����Image��Ϊԭͼ�г����ɿ�СImage��Ҳ����ʹ������Image.
 * @author yifeizhang
 * @since 2006-11-30 
 * @version 1.0
 */
public interface IImages {
	/** ����ת */
	final public static byte TRANS_NONE = 0;
	/** ˮƽ��ת */
	final public static byte TRANS_H = 2;
	/** ��ֱ��ת */
	final public static byte TRANS_V = 1;
	/** 180�ȷ�ת */
	final public static byte TRANS_HV = 3;
	/** ��ʱ��90�ȷ�ת */
	final public static byte TRANS_90 = 6;
	/** ��ʱ��270�ȷ�ת */
	final public static byte TRANS_270 = 5;
	/** ����ʱ��90�ȷ�ת��Ȼ����ˮƽ��ת */
	final public static byte TRANS_H90 = 4;
	/** ����ʱ��90�ȷ�ת��Ȼ���ڴ�ֱ��ת */
	final public static byte TRANS_V90 = 7;
	/** 180�ȷ�ת */
	final public static byte TRANS_180 = 3; // 180 = HV

	//--------------------------------------------------------------------------------------------------------

	
	/**
	 * ���´���ͼƬ��
	 * @param srcImage ԭͼƬ
	 * @param count ����
	 * @return 
	 */
	public void buildImages(Image srcImage,int count);
	
	
	
	/**
	 * ��������ڴ档 ��ʼ����TILE������������顣
	 *  
	 */
	public void gc() ;

	/**
	 * ������ŵõ�ͼƬ����
	 * @param index
	 * @return 
	 */
	public Image getImage(int index);
	
	public int getRGBFormPixcel(int index, int offset);
	
	/**
	 * �õ���ͼ�Ŀ��
	 * @param Index ��ͼ���
	 * @return ���
	 */
	public int getWidth(int Index);

	/**
	 * �õ���ͼ�ĸ߶�
	 * @param Index ��ͼ���
	 * @return �߶�
	 */
	public int getHeight(int Index);

	/**
	 * �õ�ͼƬ��ͼƬ����
	 * @return 
	 */
	public int getCount();
	
	/**
	 * ������һ��ͼƬ��Ϊԭͼ��
	 * @param NewTileImage
	 */
	public void setTileImage(Image NewTileImage);

	/**
	 * ��ԭͼ���ŵ���ӵ����
	 * @return �Ƿ�δװ��
	 */
	public boolean addTile();

	/**
	 * ��ԭͼ��һ�������г�Сͼ���Ž����
	 * @param TileX ��ԭͼ��x���
	 * @param TileY ��ԭͼ��y���
	 * @param TileWidth ��ԭͼ�Ŀ�
	 * @param TileHeight  ��ԭͼ�ĸ�
	 * @return false �Ƿ�δװ��
	 */
	public boolean addTile(int TileX, int TileY, int TileWidth, int TileHeight);

	/**
	 * ��ԭͼ���������г�����Сͼ���Ž����
	 * @param ClipX ��ԭͼ��x���
	 * @param ClipY ��ԭͼ��y���
	 * @param ClipWidth ��ԭͼ��������
	 * @param ClipHeight ��ԭͼ��������
	 * @param TileWidth ÿ��Ŀ�
	 * @param TileHeight ÿ��ĸ�
	 */
	public void addTile(int ClipX, int ClipY, int ClipWidth, int ClipHeight, int TileWidth, int TileHeight) ;

	/**
	 * ����һ��ͼƬ��Դ�����Ѱ���ͼƬ��ӵ�ͼƬ�顣
	 * ͼƬ����ָ����ͼƬ��������ɡ�
	 * @param pakfile
	 */
	public void addTile(String pakfile) ;
	
	/**
	 * ��ͼƬ������ӵ�ͼƬ�顣
	 * @param images
	 */
	public void addTile(Image[] images) ;

	/**
	 * ���Ƶ�ָ����Graphics�ϡ�
	 * @param g ָ����graphics
	 * @param Index ���
	 * @param PosX X����
	 * @param PosY Y����
	 */
	public void render(Graphics g, int Index, int PosX, int PosY);

	/**
	 * ���Ƶ�ָ����Graphics�ϡ�
	 * @param g ָ����graphics
	 * @param Index ���
	 * @param PosX X����
	 * @param PosY Y����
	 * @param Style ��ת��ʽ 
	 */
	public void render(Graphics g, int Index, int PosX, int PosY, int Style) ;

}

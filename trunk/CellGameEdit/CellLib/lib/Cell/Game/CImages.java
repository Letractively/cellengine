package Cell.Game;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

import Cell.CObject;
import Cell.CIO;

/**
 * ��ײ�Ķ�ͼƬ�Ĵ��� ���������һ��ͼƬ�ļ��ϡ� 
 * ���԰�һ����Image��Ϊԭͼ�г����ɿ�СImage��Ҳ����ʹ������Image.
 * 
 *  
 */
public class CImages extends CObject{
	/*
	 * ��ת����
	 */
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
	//    public static Graphics g;

	/** TILE��ĸ��� */
	private int Count;
	private int CurIndex;

	private Image TileImage;
	private Image[] Tiles;

	
	//--------------------------------------------------------------------------------------------------------

	/**
	 * ����һ��TileGroup
	 * 
	 * @param NewTileImage
	 *            ԭͼƬ
	 * @param NewTileCount
	 *            �г���ͼ�ĸ���
	 */
	public CImages(Image NewTileImage, int NewTileCount) {
		Count = NewTileCount;
		Tiles = new Image[NewTileCount];
		CurIndex = 0;
		setTileImage(NewTileImage);
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

	final public Image getImage(int index){
		return Tiles[index];
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

	public int getCount(){
		return CurIndex;
	}
	/**
	 * ������һ��ͼƬ��Ϊԭͼ��
	 * 
	 * @param NewTileImage
	 */
	final public void setTileImage(Image NewTileImage) {
		TileImage = NewTileImage;
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
				//				Tiles[CurIndex] = Image.createImage(TileWidth, TileHeight);
				//				Graphics g = Tiles[CurIndex].getGraphics();
				//				g.setClip(0,0,TileWidth,TileHeight);
				//				g.drawImage(TileImage,-TileX,-TileY,0);
				Tiles[CurIndex] = Image.createImage(TileImage, TileX, TileY,TileWidth, TileHeight, 0);
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

	final public boolean addTile(Image img, int Alpha) {
		if (CurIndex < Tiles.length) {
			if (img == null) {
				System.out
						.println("CSImageGprup : load image Error ! null img arg -_-!");
				Tiles[CurIndex] = Image.createImage(1, 1);
			} else {
				if (Alpha >= 0xff) {
					Tiles[CurIndex] = img;
				} else {
					int[] argb = new int[img.getWidth() * img.getHeight()];
					img.getRGB(argb, 0, img.getWidth(), 0, 0, img.getWidth(),
							img.getHeight());
					//			        int transparent = argb[0];
					for (int i = argb.length - 1; i >= 0; i--) {
						//			            argb[i] = argb[i]|(Alpha<<24);
						if ((argb[i] & 0x00ffffff) == 0x00ff00ff) {
							//			            if(argb[i]==transparent){
							argb[i] = 0;
						} else {
							argb[i] = argb[i]
									- (0xff000000 - Alpha * 0x01000000);
						}

					}
					Tiles[CurIndex] = Image.createRGBImage(argb,img.getWidth(), img.getHeight(), true);
				}
			}
			CurIndex++;
		}
		if (CurIndex >= Tiles.length) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * ���Ƶ�ָ����Graphics�ϡ�
	 * 
	 * @param g
	 *            ָ����graphics
	 * @param Index
	 *            ���
	 * @param PosX
	 *            X����
	 * @param PosY
	 *            Y����
	 */
	final public void render(Graphics g, int Index, int PosX, int PosY) {//	����ѡ����뷽ʽ,������ת
		try {
			g.drawRegion(//
					Tiles[Index], //
					0, //
					0, //
					Tiles[Index].getWidth(), //
					Tiles[Index].getHeight(), //
					0, //
					PosX,//
					PosY,//
					Graphics.TOP | Graphics.LEFT//
			);
		} catch (RuntimeException e) {
		}
	}

	/**
	 * ���Ƶ�ָ����Graphics�ϡ�
	 * 
	 * @param g
	 *            ָ����graphics
	 * @param Index
	 *            ���
	 * @param PosX
	 *            X����
	 * @param PosY
	 *            Y����
	 * @param Style
	 *            ��ת��ʽ���ο� CSSprite ��ķ�ת������
	 */
	final public void render(Graphics g, int Index, int PosX, int PosY, int Style) {
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
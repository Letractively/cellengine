package com.morefuntek.cell.Game;


import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

import com.morefuntek.cell.IImages;


/**
 * ��ͼ�� ���ڰѵ�שƴ�������ĵ�ͼ��</br>
 * ��ϵͳ֧�ֶ�̬�ر����ͼƬ������ĵ��Σ��߶Σ����Σ���ѭ����ͼ��</br>
 * ֻ��ͨ����������ܰѵ�ͼ���Ƶ���Ļ��
 * @author yifeizhang
 * @since 2006-11-30 
 * @version 1.0
 */
public class CMap extends CUnit {

	protected int CellW; //ͼ���
	protected int CellH; //ͼ���
	
	protected CAnimates		Tiles;
	protected CCollides 	Collides;
	
	protected short[][] MatrixTile; //ͼ��TILE�ű�
	protected short[][] MatrixFlag; //ͼ����ײ��������

	protected boolean IsCyc ;
	protected boolean IsAnimate ;
	
	protected int Width;
	protected int Height;
	//	----------------------------------------------------------------------------------------------

	/**
	 * ���캯��
	 * @param tiles �õ�ͼ�õ���ͼƬ��
	 * @param collides �õ�ͼ�õ�����ײ����
	 * @param cellw ��Ԫ���
	 * @param cellh ��Ԫ���
	 * @param tile_matrix ͼƬ�ر�
	 * @param flag_matrix ���α� 
	 * @param isAnimate �Ƿ���ʾ��̬�ر�
	 * @param isCyc �Ƿ���ѭ����ͼ
	 */
	public CMap(
			CAnimates tiles, 
			CCollides collides,
			int cellw, 
			int cellh,
			short[][] tile_matrix, 
			short[][] flag_matrix,
			boolean isAnimate,
			boolean isCyc
			) {
		IsCyc = isCyc;
		IsAnimate = isAnimate;
		
		Tiles = tiles;
		Collides = collides;
		MatrixTile = tile_matrix;
		MatrixFlag = flag_matrix;
		CellW = cellw;
		CellH = cellh;
		
		Width = MatrixTile[0].length * CellW;
		Height = MatrixTile.length * CellH;
	}
	
	/**
	 * ���� �������캯��
	 * @param map
	 * @param isCyc 
	 */
	public CMap(CMap map,boolean isCyc){
		IsCyc = isCyc;
		IsAnimate = map.IsAnimate;
		
		Tiles = map.Tiles;
		Collides = map.Collides;
		MatrixTile = map.MatrixTile;
		MatrixFlag = map.MatrixFlag;
		CellW = map.CellW;
		CellH = map.CellH;
		
		Width = MatrixTile[0].length * CellW;
		Height = MatrixTile.length * CellH;
	}

	

//	public CMap createMiniMap(int cellW,int cellH,int colorKeyMapPos){
//		CMap ret = new CMap(
//				this.Tiles,
//				this.Collides,
//				cellW,
//				cellH,
//				this.MatrixTile,
//				this.MatrixFlag,
//				this.IsAnimate,
//				this.IsCyc
//		);
//		
//		int[] mapColor = new int[Tiles.getCount()];
//    	for(int i=0;i<mapColor.length;i++){
//    		try {
//    			mapColor[i] = Tiles.images.getRGBFormPixcel(
//    					Tiles.STileID[Tiles.Frames[i][0]], 
//    					colorKeyMapPos
//    					);
//			} catch (RuntimeException e){
//				mapColor[i] = 0xff00ff00;
//			}
//       	}
//    	ret.TilesColor = mapColor;
//		
//		return ret;
//	}
	
	
//	----------------------------------------------------------------------------------------------------------------
	
//	final public boolean isMiniMap(){
//		return TilesColor!=null;
//	}
	
	/**
	 * �õ�������ͼ�Ŀ�
	 * @return 
	 */
	final public int getWidth() {
		return Width;
	}
	/**
	 * �õ�������ͼ�ĸ�
	 * @return 
	 */
	final public int getHeight() {
		return Height;
	}
	/**
	 * �õ������������
	 * @return 
	 */
	final public int getWCount() {
		return MatrixTile[0].length;
	}
	/**
	 * �õ������������
	 * @return 
	 */
	final public int getHCount() {
		return MatrixTile.length;
	}
	/**
	 * �õ���Ԫ���
	 * @return 
	 */
	final public int getCellW() {
		return CellW;
	}
	/**
	 * �õ���Ԫ���
	 * @return 
	 */
	final public int getCellH() {
		return CellH;
	}

	/**
	 * ���ݵ�ͼ��õ���ײ��
	 * @param bx
	 * @param by
	 * @return 
	 */
	final public CCD getCD(int bx,int by){
		return Collides.getCD(MatrixFlag[by][bx]); 
	}
	
	public int getFlag(int bx,int by){
		return MatrixFlag[by][bx];
	}
	public int getTile(int bx,int by){
		return Math.abs(MatrixTile[by][bx]);
	}
	public void putFlag(int bx,int by,int data){
		MatrixFlag[by][bx] = (short)data;
	}
	public void putTile(int bx,int by,int data){
		MatrixTile[by][bx] = (short)data;
	}
	
	public CAnimates getAnimates(){
		return Tiles;
	}
	
	public CCollides getCollides(){
		return Collides;
	}
	
	/**
	 * 
	 * @param time1
	 * @param time2
	 * @param bx
	 * @param by
	 * @return 
	 */
	protected boolean testSameAnimateTile(int time1,int time2,int bx,int by){
		if( MatrixTile[by][bx] >= 0 )return true;
		if( Tiles.Frames[-MatrixTile[by][bx]].length>1 &&
			Tiles.Frames[-MatrixTile[by][bx]][time1%Tiles.Frames[-MatrixTile[by][bx]].length]==
		    Tiles.Frames[-MatrixTile[by][bx]][time2%Tiles.Frames[-MatrixTile[by][bx]].length]){
			//println("same at : " + Tiles.Frames[-MatrixTile[by][bx]][time1%Tiles.Frames[-MatrixTile[by][bx]].length]);
			return true;
		}
		return false;
	}
	//	-------------------------------------------------------------------------------

	/**
	 * ��������
	 * @param g
	 * @param x
	 * @param y
	 * @param cellX
	 * @param cellY 
	 */
	protected void renderCell(Graphics g, int x, int y, int cellX, int cellY) {
		if(MatrixTile[cellY][cellX]>=0){
			Tiles.renderSingle(g, MatrixTile[cellY][cellX], x, y);
		}else if(!IsAnimate){
			Tiles.renderSingleSub(g, MatrixTile[cellY][cellX], 0, x, y);
		}
//#ifdef _DEBUG
		if(IsDebug && MatrixFlag[cellY][cellX]>0){
			Collides.render(g, MatrixFlag[cellY][cellX], x, y, 0xff00ff00);
		}
//#endif
	}
	
	/**
	 * ��������
	 * @param g
	 * @param index
	 * @param x
	 * @param y
	 * @param cellX
	 * @param cellY 
	 */
	protected void renderAnimateCell(Graphics g, int index, int x, int y, int cellX, int cellY){
		
			if(MatrixTile[cellY][cellX]<0){
				Tiles.renderSingleSub(g, 
						-MatrixTile[cellY][cellX],
						index%Tiles.Frames[-MatrixTile[cellY][cellX]].length,
						x, y);
			}
//	#ifdef _DEBUG
			if(IsDebug && MatrixFlag[cellY][cellX]>0){
				Collides.getCD(MatrixFlag[cellY][cellX]).render(g, x, y, 0xff00ff00);
			}
//	#endif
		
	}

}
package com.cell.game;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

import com.cell.IImages;


/**
 * Animates contain some frame, it have a coordinate system with all part. </br>
 * every frame contian some part </br> 
 * every part is Images's index value </br>
 * every part has itself 2d coordinate x y </br>>
 * every part has itself Flip attribute </br>
 * ��϶���������</br>
 * һ����������N֡��һ֡����N��������
 * ÿ�����������Լ�������������������������ϵͳ�У�
 * ÿ��������ͼƬ����CImagesͼƬ�����һ��������
 * ÿ�����������Լ��ķ�ת����</br>
 * 
 * @author yifeizhang
 * @since 2006-11-29 
 * @version 1.0
 */
public class CAnimates extends CGroup{
	protected IImages images ;
	
	protected short[] SX; //�Ӿ���������Xƫ��
	protected short[] SY; //�Ӿ���������Yƫ��
	protected short[] SW; //�Ӿ����
	protected short[] SH; //�Ӿ����
	protected short[] STileID; //�Ӿ���TILE��
	protected byte[] SFlip; //�Ӿ���ķ�ת����

	/**
	 * Construct Animates
	 * @param partCount size of part </br> �����Ĳ�������
	 * @param images reference </br> ʹ�õ�CImagesͼƬ��
	 */
	public CAnimates(int partCount,IImages images){
		this.images = images;
		//�Ӿ���
		SubCount = (short) partCount;
		SubIndex = 0;
		
		STileID = new short[partCount];
		SFlip = new byte[partCount];
		
		SW = new short[partCount];
		SH = new short[partCount];
		SX = new short[partCount];
		SY = new short[partCount];
		
		Frames = new int[partCount][];
	}
	
	/**
	 * Add all image part form construct images reference</br>
	 * ��ӵ�ǰimages�������ͼƬ�������ÿ��ͼƬ����һ֡
	 * @param center image is center </br> �Ƿ����
	 */
	public void addPart(boolean center) {
		for (int i = 0; i < images.getCount(); i++) {
			if (SubIndex >= SubCount) {
				println("Out Of Animate Max Count !");
				return;
			}
			if (center){
				addPart(-images.getWidth(i) / 2, 
						-images.getHeight(i) / 2,
						i, IImages.TRANS_NONE);
			}else{
				addPart(0, 0,
						i, IImages.TRANS_NONE);	
			}
		}
	}

	/**
	 * Add an image part form construct images reference</br>
	 * ��ӵ�ǰimages���һ��ͼƬ��һ��������ָ������
	 * @param px part's x coordinate </br>��ǰ������x������
	 * @param py part's y coordinate </br>��ǰ������y������
	 * @param tileid part's images index value </br>��ǰ������ͼƬ���
	 * @param trans part's flip rotate paramenter </br>��ǰ�����ķ�ת����
	 */
	public void addPart(int px, int py, int tileid, int trans) {
		if (SubIndex >= SubCount) {
			println("Out Of Animate Max Count !");
			return;
		}
		if (SubIndex < SubCount) {
			STileID[SubIndex] = (short) tileid;
			SW[SubIndex] = (short) images.getWidth(tileid);
			SH[SubIndex] = (short) images.getHeight(tileid);
			SX[SubIndex] = (short) px;
			SY[SubIndex] = (short) py;
			SFlip[SubIndex] = (byte) trans;
			switch(trans){
			case IImages.TRANS_NONE:
			case IImages.TRANS_H:
			case IImages.TRANS_V:
			case IImages.TRANS_HV:
				SW[SubIndex] = (short) images.getWidth(tileid);
				SH[SubIndex] = (short) images.getHeight(tileid);
				break;
			case IImages.TRANS_90:
			case IImages.TRANS_270:
			case IImages.TRANS_H90:
			case IImages.TRANS_V90:
				SW[SubIndex] = (short) images.getHeight(tileid);
				SH[SubIndex] = (short) images.getWidth(tileid);
				break;
			}
			
			fixArea(SX[SubIndex], SY[SubIndex], 
					SX[SubIndex] + SW[SubIndex],
					SY[SubIndex] + SH[SubIndex]);
			
			Frames[SubIndex] = new int[]{SubIndex};
			
			SubIndex++;
		}
	}

	//---------------------------------------------------------------------------------------------------
	public IImages getImages(){
		return images;
	}
	/**
	 * Get image form construct images reference</br>
	 * �ӵ�ǰ��images��õ�image
	 * @param index index of construct images 
	 * @return image
	 */
	public Image getImage(int index){
		return images.getImage(index);
	}
	
	/**
	 * Get image form specify frame id and part id</br>
	 * ָ��֡�ź͸�֡�еĲ����ŵõ�ͼƬ
	 * @param frame frame id within animates</br> ֡��
	 * @param sub part id within frame</br>������
	 * @return image
	 */
	public Image getFrameImage(int frame,int sub){
		return images.getImage(STileID[Frames[frame][sub]]);
	}
	
	/**
	 * Draw one frame with specify frame id</br>
	 * ��Ⱦһ֡
	 * @param g	graphics surface 
	 * @param index frame id </br>֡��
	 * @param x x on graphics surface</br>x����
	 * @param y y on graphics surface</br>y����
	 */
	public void render(Graphics g,int index,int x,int y){
		for(int i=Frames[index].length-1;i>=0;i--){
			images.render(g,
					STileID[Frames[index][i]], 
					x + SX[Frames[index][i]], //
					y + SY[Frames[index][i]], //
					SFlip[Frames[index][i]]);
		}
	}
	
	/**
	 * Draw one part with specify frame id and part id</br>
	 * ��Ⱦһ֡�е�һ������
	 * @param g graphics surface 
	 * @param index frame id </br> ֡��
	 * @param part part id </br> ������
	 * @param x x on graphics surface </br> x����
	 * @param y y on graphics surface </br> y����
	 */
	public void renderSub(Graphics g,int index,int part,int x,int y){
		images.render(g,
				STileID[Frames[index][part]], 
				x + SX[Frames[index][part]], //
				y + SY[Frames[index][part]], //
				SFlip[Frames[index][part]]);

	}
	
	/**
	 * Draw one frame with specify frame id ignore part's coordinate, 
	 * all part based zero point.</br>
	 * ��Ⱦһ֡�����Ը�֡ͼƬ������
	 * 
	 * @param g graphics surface
	 * @param index frame id
	 * @param x x on graphics surface
	 * @param y y on graphics surface
	 */
	public void renderSingle(Graphics g,int index,int x,int y){
		for(int i=Frames[index].length-1;i>=0;i--){
			images.render(g,
					STileID[Frames[index][i]], 
					x , //
					y , //
					SFlip[Frames[index][i]]);
		}
	}
	
	/**
	 * Draw one part with specify frame id and part id ignore part's coordinate, 
	 * part based zero point.</br>
	 * ��Ⱦһ֡�е�һ�����������Ը�֡��ͼƬ����
	 * 
	 * @param g graphics surface
	 * @param index frame id
	 * @param part part id
	 * @param x x on graphics surface
	 * @param y y on graphics surface
	 */
	public void renderSingleSub(Graphics g,int index,int part,int x,int y){
		images.render(g,
				STileID[Frames[index][part]], 
				x , //
				y , //
				SFlip[Frames[index][part]]);

	}
}

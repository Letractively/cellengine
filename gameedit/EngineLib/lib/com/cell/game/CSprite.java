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
package com.cell.game;


import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

import com.cell.CMath;
import com.cell.IImages;

/*
 * Created on 2004-11-8
 *
 *  
 * 
 */


/**
 * ��Ͼ���</br>
 * ��Ͼ������һ���������У�һ����ײ���顣
 * ͨ�����鵱ǰ��״̬��ʾ�ʹ�������AI��
 * @author yifeizhang
 * @since 2006-11-30 
 * @version 1.0
 */
public class CSprite extends CUnit {
	
//	----------------------------------------------------------------------------------------------
//	�߼����

	/** �Ƿ�;������赲 */
	public boolean haveSprBlock 	= false;
	/** �Ƿ�͵�ͼ���赲 */
	public boolean haveMapBlock 	= false;
	/**�þ��鵱ǰ�Ƿ���������ڣ�ֻ��*/
	public boolean OnScreen 		= true;
	/**��Ⱦ���ȼ�*/
	public int Priority				= 0;
//	----------------------------------------------------------------------------------------------
//	�������
	
	//	����
	protected CAnimates animates;
	//	��ײ��
	protected CCollides collides;
	
	//	֡���
	protected int FrameAnimate[][];
	protected int FrameCDMap[][];
	protected int FrameCDAtk[][];
	protected int FrameCDDef[][];
	protected int FrameCDExt[][];
	
	/**��ײ�����ͣ��͵�ͼ���*/
	final static public int CD_TYPE_MAP 	= 0; 
	/**��ײ�����ͣ��͹�������*/
	final static public int CD_TYPE_ATK 	= 1;
	/**��ײ�����ͣ��ͱ���������*/
	final static public int CD_TYPE_DEF 	= 2;
	/**��ײ�����ͣ�����չ����*/
	final static public int CD_TYPE_EXT 	= 3;

	protected int CurAnimate = 0;
	protected int CurFrame = 0;
	
	protected byte Transform = IImages.TRANS_NONE;
	
//	----------------------------------------------------------------------------------------------
//	������� no method
	
	/**�������е�X����*/
	public int X = 0;
	/**�������е�Y����*/
	public int Y = 0;
	
	/** X�����ٶȣ�256�������� */
	public int SpeedX256 = 0; //8λ������
	/** Y�����ٶȣ�256�������� */
	public int SpeedY256 = 0; //8λ������
	
	/** X������ٶȣ�256�������� */
	public int AccX256 = 0; //8λ������
	/** Y������ٶȣ�256�������� */
	public int AccY256 = 0; //8λ������
	
	/** X���� */
	public int DirectX = 0; //����
	/** Y���� */
	public int DirectY = 0; //����

	/** ˮƽ�����256����Ӱ */
	public int HPos256 = 0;
	/** ��ֱ�����256����Ӱ */
	public int VPos256 = 0;
	
//	-------------------------------------------------------------------------------------------------


	/**
	 * ���캯��
	 * @param canimates �þ����õ���ͼƬ��
	 * @param ccollides �þ����õ�����ײ����
	 * @param frameAnimate �������� </br>
	 * 			frameAnimate[animate id][frame id] = canimate frame index.
	 * @param frameCDMap ��ͼ�ж����У��赲�ж����У�</br>
	 * 			frameAnimate[animate id][frame id] = ccollide frame index.
	 * @param frameCDAtk �����ж����� </br>
	 * 			frameAnimate[animate id][frame id] = ccollide frame index.
	 * @param frameCDDef �������ж����� </br>
	 * 			frameAnimate[animate id][frame id] = ccollide frame index.
	 * @param frameCDExt ��չ���� </br>
	 * 			frameAnimate[animate id][frame id] = ccollide frame index.
	 */
	public CSprite(
			CAnimates canimates, 
			CCollides ccollides,
			int[][] frameAnimate,
			int[][] frameCDMap,
			int[][] frameCDAtk,
			int[][] frameCDDef,
			int[][] frameCDExt
			) {

		animates = canimates;
		collides = ccollides;

		FrameAnimate = frameAnimate;
		FrameCDMap = frameCDMap;
		FrameCDAtk = frameCDAtk;
		FrameCDDef = frameCDDef;
		FrameCDExt = frameCDExt;

	}

	/**
	 * ���� �������캯��,ǳ��
	 * @param spr 
	 */
	public CSprite(CSprite spr){
		animates = spr.animates;
		collides = spr.collides;

		FrameAnimate = spr.FrameAnimate;
		FrameCDMap = spr.FrameCDMap;
		FrameCDAtk = spr.FrameCDAtk;
		FrameCDDef = spr.FrameCDDef;
		FrameCDExt = spr.FrameCDExt;
		
		Transform = spr.Transform;
	}

	/**
	 * ���Ʊ���,ǳ��
	 * @return 
	 */
	public CSprite clone(){
		 CSprite spr = new CSprite(this);
		 spr.world = this.world;
		 return spr;
	}
//	------------------------------------------------------------------------------------------
	

	/**
	 * �ĵ���ǰ֡����ײ��
	 * @param type ��ײ������
	 * @param sub ��ײ��������ж���
	 * @return 
	 */
	public CCD getCurrentCD(int type,int sub){
		switch(type){
		case CD_TYPE_MAP:
			return collides.getFrameCD(FrameCDMap[CurAnimate][CurFrame], sub);
		case CD_TYPE_ATK:
			return collides.getFrameCD(FrameCDAtk[CurAnimate][CurFrame], sub);
		case CD_TYPE_DEF:
			return collides.getFrameCD(FrameCDDef[CurAnimate][CurFrame], sub);
		case CD_TYPE_EXT:
			return collides.getFrameCD(FrameCDExt[CurAnimate][CurFrame], sub);
		}
		return null;
	}
	
//	/**
//	 * �ĵ���ǰ֡��ͼƬ
//	 * @param sub���֡�����ͼ
//	 * @return 
//	 */
//	public Image getCurrentImage(int sub){
//		return animates.getFrameImage(FrameAnimate[CurAnimate][CurFrame], sub);
//	}
	
	/**
	 * �ж�һ������ĵ�ǰ֡��һ����ײ���Ƿ��ཻ��
	 * @param spr1 ����
	 * @param type1 �������ײ������
	 * @param cd ��ײ��
	 * @param x ��ײ��xλ��
	 * @param y ��ײ��yλ��
	 * @return 
	 */
	static public boolean touch_Spr_CD(
			CSprite spr1,int type1,
			CCD cd,int x,int y){
		
		int index1 = 0;
		
		switch(type1){
		case CD_TYPE_MAP:
			index1=spr1.FrameCDMap[spr1.CurAnimate][spr1.CurFrame];break;
		case CD_TYPE_ATK:
			index1=spr1.FrameCDAtk[spr1.CurAnimate][spr1.CurFrame];break;
		case CD_TYPE_DEF:
			index1=spr1.FrameCDDef[spr1.CurAnimate][spr1.CurFrame];break;
		case CD_TYPE_EXT:
			index1=spr1.FrameCDExt[spr1.CurAnimate][spr1.CurFrame];break;
		}
		
		if(CCollides.touchCD(
				spr1.collides, index1, spr1.X, spr1.Y, 
				cd, x, y
				)){
			return true;
		}
		return false;
	}
	
	/**
	 * �ж�һ������ĵ�ǰ֡������ײ���һ����ײ���Ƿ��ཻ��
	 * @param spr1 ����
	 * @param type1 �������ײ������
	 * @param sub1 ���������ײ��
	 * @param cd ��ײ��
	 * @param x ��ײ��xλ��
	 * @param y ��ײ��yλ��
	 * @return 
	 */
	static public boolean touch_SprSub_CD(
			CSprite spr1,int type1,int sub1,
			CCD cd,int x,int y){
		
		int index1 = 0;
		switch(type1){
		case CD_TYPE_MAP:
			index1=spr1.FrameCDMap[spr1.CurAnimate][spr1.CurFrame];break;
		case CD_TYPE_ATK:
			index1=spr1.FrameCDAtk[spr1.CurAnimate][spr1.CurFrame];break;
		case CD_TYPE_DEF:
			index1=spr1.FrameCDDef[spr1.CurAnimate][spr1.CurFrame];break;
		case CD_TYPE_EXT:
			index1=spr1.FrameCDExt[spr1.CurAnimate][spr1.CurFrame];break;
		}
		
		try{
			if(CCollides.touchSubCD(
					spr1.collides, index1, sub1, spr1.X, spr1.Y, 
					cd, x, y
					)){
				return true;
			}
		}catch(Exception err){
			return false;	
		}
		
		
		return false;
	}
	
	/**
	 * �ж�2������ĵ�ǰ֡�Ƿ��ཻ
	 * @param spr1 ����1
	 * @param type1 ����1����ײ����
	 * @param spr2 ����2
	 * @param type2 ����2����ײ����
	 * @return 
	 */
	static public boolean touch_Spr_Spr(
			CSprite spr1,int type1,
			CSprite spr2,int type2){
		
		int index1 = 0;
		int index2 = 0;
		
		switch(type1){
		case CD_TYPE_MAP:
			index1=spr1.FrameCDMap[spr1.CurAnimate][spr1.CurFrame];break;
		case CD_TYPE_ATK:
			index1=spr1.FrameCDAtk[spr1.CurAnimate][spr1.CurFrame];break;
		case CD_TYPE_DEF:
			index1=spr1.FrameCDDef[spr1.CurAnimate][spr1.CurFrame];break;
		case CD_TYPE_EXT:
			index1=spr1.FrameCDExt[spr1.CurAnimate][spr1.CurFrame];break;
		}
		switch(type2){
		case CD_TYPE_MAP:
			index2=spr2.FrameCDMap[spr2.CurAnimate][spr2.CurFrame];break;
		case CD_TYPE_ATK:
			index2=spr2.FrameCDAtk[spr2.CurAnimate][spr2.CurFrame];break;
		case CD_TYPE_DEF:
			index2=spr2.FrameCDDef[spr2.CurAnimate][spr2.CurFrame];break;
		case CD_TYPE_EXT:
			index2=spr2.FrameCDExt[spr2.CurAnimate][spr2.CurFrame];break;
		}
		if(CCollides.touch(
				spr1.collides, index1, spr1.X, spr1.Y, 
				spr2.collides, index2, spr2.X, spr2.Y
				)){
			return true;
		}
		return false;
	}
	/**
	 * �ж�2������ĵ�ǰ֡������ײ���Ƿ��ཻ
	 * @param spr1 ����1 
	 * @param type1 ����1����ײ����
	 * @param sub1 ����1������ײ��
	 * @param spr2 ����2
	 * @param type2 ����2����ײ����
	 * @param sub2 ����2������ײ��
	 * @return 
	 */
	static public boolean touch_SprSub_SprSub(
			CSprite spr1,int type1,int sub1,
			CSprite spr2,int type2,int sub2){
		
		int index1 = 0;
		int index2 = 0;

		switch(type1){
		case CD_TYPE_MAP:
			index1=spr1.FrameCDMap[spr1.CurAnimate][spr1.CurFrame];break;
		case CD_TYPE_ATK:
			index1=spr1.FrameCDAtk[spr1.CurAnimate][spr1.CurFrame];break;
		case CD_TYPE_DEF:
			index1=spr1.FrameCDDef[spr1.CurAnimate][spr1.CurFrame];break;
		case CD_TYPE_EXT:
			index1=spr1.FrameCDExt[spr1.CurAnimate][spr1.CurFrame];break;
		}
		switch(type2){
		case CD_TYPE_MAP:
			index2=spr2.FrameCDMap[spr2.CurAnimate][spr2.CurFrame];break;
		case CD_TYPE_ATK:
			index2=spr2.FrameCDAtk[spr2.CurAnimate][spr2.CurFrame];break;
		case CD_TYPE_DEF:
			index2=spr2.FrameCDDef[spr2.CurAnimate][spr2.CurFrame];break;
		case CD_TYPE_EXT:
			index2=spr2.FrameCDExt[spr2.CurAnimate][spr2.CurFrame];break;
		}
		
		try{
			if(CCollides.touchSub(
					spr1.collides, index1, sub1, spr1.X, spr1.Y, 
					spr2.collides, index2, sub2, spr2.X, spr2.Y
					)){
				return true;
			}
		}catch(Exception err){
			return false;	
		}

		return false;
	}

	/**
	 * ��⾫��ĵ�ǰ֡�͵�ͼ�Ƿ��ཻ
	 * @param spr ����
	 * @param type �������ײ����
	 * @param map ��ͼ
	 * @return 
	 */
	static public boolean touch_Spr_Map(CSprite spr,int type,CMap map){
		
			switch(type){
			case CD_TYPE_MAP:
				for(int sub=0;sub<spr.collides.Frames[spr.FrameCDMap[spr.CurAnimate][spr.CurFrame]].length;sub++){
					if(touch_SprSub_Map(spr,type,sub,map))return true;
				}
			case CD_TYPE_ATK:
				for(int sub=0;sub<spr.collides.Frames[spr.FrameCDAtk[spr.CurAnimate][spr.CurFrame]].length;sub++){
					if(touch_SprSub_Map(spr,type,sub,map))return true;
				}
			case CD_TYPE_DEF:
				for(int sub=0;sub<spr.collides.Frames[spr.FrameCDDef[spr.CurAnimate][spr.CurFrame]].length;sub++){
					if(touch_SprSub_Map(spr,type,sub,map))return true;
				}
			case CD_TYPE_EXT:
				for(int sub=0;sub<spr.collides.Frames[spr.FrameCDExt[spr.CurAnimate][spr.CurFrame]].length;sub++){
					if(touch_SprSub_Map(spr,type,sub,map))return true;
				}
			}
		
		return false;
	}
	/**
	 * ��⾫��ĵ�ǰ֡�����ж���͵�ͼ�Ƿ��ཻ
	 * @param spr ����
	 * @param type ������ײ����
	 * @param sub �������ж���
	 * @param map ��ͼ
	 * @return 
	 */
	static public boolean touch_SprSub_Map(CSprite spr,int type,int sub,CMap map){
		
			int mbx = (spr.X+spr.getCurrentCD(type,sub).X1)/map.CellW-((spr.X+spr.getCurrentCD(type,sub).X1)<0?1:0);//
			int mby = (spr.Y+spr.getCurrentCD(type,sub).Y1)/map.CellH-((spr.Y+spr.getCurrentCD(type,sub).Y1)<0?1:0);//
			int mbw = (spr.X+spr.getCurrentCD(type,sub).X2)/map.CellW-((spr.X+spr.getCurrentCD(type,sub).X2)<0?1:0);//
			int mbh = (spr.Y+spr.getCurrentCD(type,sub).Y2)/map.CellH-((spr.Y+spr.getCurrentCD(type,sub).Y2)<0?1:0);//
			if(map.IsCyc==false){
				for (int y=mby<0?0:mby; y<=mbh && y<map.getHCount(); y++) {
					for (int x=mbx<0?0:mbx; x<=mbw && x<map.getWCount(); x++) {
						if (map.MatrixFlag[y][x] > 0) //
						{	
							if(CSprite.touch_SprSub_CD(
									spr, type, sub,
									map.getCD(x, y), 
									x*map.CellW, 
									y*map.CellH) 
							){
								return true;
							}
						}
					}
				}
			}else{
				for (int y = mby; y <= mbh; y++) {
					for (int x = mbx; x <= mbw; x++) {
						if (map.MatrixFlag[CMath.cycNum(y,0,map.getHCount())][CMath.cycNum(x, 0, map.getWCount())] > 0) //
						{
							if(CSprite.touch_SprSub_CD(
									spr, type, sub,
									map.getCD(CMath.cycNum(x, 0, map.getWCount()), CMath.cycNum(y,0,map.getHCount())), 
									x*map.CellW, 
									y*map.CellH)
							){
								return true;
							}
						}	
					}
				}
			}
		
		return false;
	}
	
	
//	------------------------------------------------------------------------------------------

	private static int adjustSprID[] = null;
	/**
	 * �赲���ƶ���������赲������ͣ���赲�����Ե��
	 * @param x
	 * @param y
	 * @return �Ƿ��赲
	 */
	public boolean tryMove(int x,int y){
		
		if(x==0 && y==0)return false;
		
		int dstX = X + x;
		int dstY = Y + y;
		int dx = (x!=0?(x<0?-1:1):0);
		int dy = (y!=0?(y<0?-1:1):0);

		X+=x;
		Y+=y;
		
		boolean adjustSpr = false;
		boolean adjustMap = false;
		
		if(this.haveSprBlock){
			
			if(adjustSprID==null || adjustSprID.length < world.Sprs.size()){
				adjustSprID = new int[world.Sprs.size()];
			}
			int p = 0;
			
			for(int i=world.Sprs.size()-1;i>=0;i--){
				adjustSprID[world.Sprs.size()-1 - i] = -1 ;
				if(!this.equals(((CSprite)world.Sprs.elementAt(i))) && 
						((CSprite)world.Sprs.elementAt(i)).Active && 
						((CSprite)world.Sprs.elementAt(i)).haveSprBlock){
					if(touch_Spr_Spr(
							this, 
							CD_TYPE_MAP, //0,
							((CSprite)world.Sprs.elementAt(i)), 
							CD_TYPE_MAP//, 0
							)){
						adjustSprID[p] = i ;
						p++;
						adjustSpr = true;
					}
				}
			}
		}
		
		if(this.haveMapBlock){
			adjustMap = touch_Spr_Map(this, CD_TYPE_MAP,this.world.Map);
		}
		
		if(adjustMap||adjustSpr){
			X-=x;
			Y-=y;
			while(X!=dstX){
				X+=dx;
				if(adjustMap && touch_Spr_Map(this,CD_TYPE_MAP,this.world.Map)){
					X-=dx;
					break;
				}
				if(adjustSpr){
					boolean over = false;
					for(int i=0;i<adjustSprID.length;i++){
						if(adjustSprID[i]<0)break;
						if(touch_Spr_Spr(
								this, 
								CD_TYPE_MAP, //0,
								((CSprite)world.Sprs.elementAt(adjustSprID[i])), 
								CD_TYPE_MAP//, 0
								)){
							over = true;
							break;
						}
					}
					if(over){
						X-=dx;
						break;
					}
				}
			}
			while(Y!=dstY){
				Y+=dy;
				if(adjustMap && touch_Spr_Map(this,CD_TYPE_MAP,this.world.Map)){
					Y-=dy;
					break;
				}
				if(adjustSpr){
					boolean over = false;
					for(int i=0;i<adjustSprID.length;i++){
						if(adjustSprID[i]<0)break;
						if(touch_Spr_Spr(
								this, 
								CD_TYPE_MAP, //0,
								((CSprite)world.Sprs.elementAt(adjustSprID[i])), 
								CD_TYPE_MAP//, 0
								)){
							over = true;
							break;
						}
					}
					if(over){
						Y-=dy;
						break;
					}
				}
			}
		}
			
		// �����������ȼ���
		if(world.isRPGView && dy!=0){
			int s = world.Sprs.indexOf(this);
			int d = s + dy;
			while( 	s<world.Sprs.size() && s>=0 &&
					d<world.Sprs.size() && d>=0 ){
				
				CSprite that = (CSprite)world.Sprs.elementAt(d);
//				println(that.Y+" : "+this.Y);
				
				if(dy<0 && (that.Y + that.Priority) <= (this.Y + this.Priority)){
//					println("dy<0 "+that.Y+"<="+this.Y+" break");
					break;
				} 
				if(dy>0 && (that.Y + that.Priority) >= (this.Y + this.Priority)){
//					println("dy>0 "+that.Y+">="+this.Y+" break");
					break;
				}
				
				world.Sprs.setElementAt(that, s);
				world.Sprs.setElementAt(this, d);
				
//				print( s + ">" + d + " : ");
				
				s = d ;
				d = s + dy;
			}
//			println("");
		}
		
		return adjustMap||adjustSpr;

	}
	
	

	
//	------------------------------------------------------------------------------------------

	public byte getCurTransform(){
		return Transform;
	}
	
	/**
	 * �ӵ�ǰ״̬��ת����һ״̬
	 * @param next 8�ַ�ת״̬��һ��
	 */
	public void transform(byte next){
		int[] point1 = new int[4];
		Transform = transFlipNext(Transform, next);
		
//		 transform image
		animates.w_left 	= 0;
		animates.w_top 		= 0;
		animates.w_right 	= 0;
		animates.w_bottom 	= 0;
		for (int i = animates.SFlip.length-1; i >= 0 ; i-- ) {
			animates.SFlip[i] = transFlipNext(animates.SFlip[i], next);
			point1[0] = animates.SX[i];
			point1[1] = animates.SY[i];
			point1[2] = animates.SX[i]+animates.SW[i];
			point1[3] = animates.SY[i]+animates.SH[i];
			CSprite.TransformPoint(point1, next);
			animates.SX[i] = (short)Math.min(point1[0],point1[2]);
			animates.SY[i] = (short)Math.min(point1[1],point1[3]);
			animates.SW[i] = (short)Math.abs(point1[0]-point1[2]);
			animates.SH[i] = (short)Math.abs(point1[1]-point1[3]);
			animates.fixArea(
					animates.SX[i], 
					animates.SY[i], 
					animates.SX[i]+animates.SW[i], 
					animates.SY[i]+animates.SH[i]);
		}
		
//		transform collide
		collides.w_left 	= 0;
		collides.w_top 		= 0;
		collides.w_right 	= 0;
		collides.w_bottom 	= 0;
		for (int i = collides.cds.length-1; i >= 0 ; i-- ) {
			point1[0] = collides.cds[i].X1;
			point1[1] = collides.cds[i].Y1;
			point1[2] = collides.cds[i].X2;
			point1[3] = collides.cds[i].Y2;
			CSprite.TransformPoint(point1, next);
			collides.cds[i].X1 = (short)Math.min(point1[0],point1[2]);
			collides.cds[i].Y1 = (short)Math.min(point1[1],point1[3]);
			collides.cds[i].X2 = (short)Math.max(point1[0],point1[2]);
			collides.cds[i].Y2 = (short)Math.max(point1[1],point1[3]);
			collides.fixArea(
					collides.cds[i].X1, 
					collides.cds[i].Y1, 
					collides.cds[i].X2, 
					collides.cds[i].Y2);
		}
	}
	
	
	/**
	 * �Ӿ��鷭ת����һ��״̬����һ״̬��ת����
	 */
	static protected byte SubSprFlipTable[][] = {
			{	//ScreenFlip = NONE
				IImages.TRANS_NONE ,
				IImages.TRANS_H ,
				IImages.TRANS_V ,
				IImages.TRANS_HV ,
				IImages.TRANS_90 ,
				IImages.TRANS_270 , 
				IImages.TRANS_H90 ,
				IImages.TRANS_V90 
			},{	
				//ScreenFlip = H
				IImages.TRANS_H ,
				IImages.TRANS_NONE ,
				IImages.TRANS_HV ,
				IImages.TRANS_V ,
				IImages.TRANS_H90 ,
				IImages.TRANS_V90 ,
				IImages.TRANS_90 , 
				IImages.TRANS_270 
			},{	
				//ScreenFlip = V
				IImages.TRANS_V ,
				IImages.TRANS_HV ,
				IImages.TRANS_NONE ,
				IImages.TRANS_H ,
				IImages.TRANS_V90 ,
				IImages.TRANS_H90 ,
				IImages.TRANS_270,
				IImages.TRANS_90 
			},{	
//				ScreenFlip = HV
				IImages.TRANS_HV,
				IImages.TRANS_V,
				IImages.TRANS_H ,
				IImages.TRANS_NONE ,
				IImages.TRANS_270 ,
				IImages.TRANS_90 ,
				IImages.TRANS_V90 ,
				IImages.TRANS_H90 
			},{
//				ScreenFlip = 90
				IImages.TRANS_90 ,
				IImages.TRANS_V90 ,
				IImages.TRANS_H90,
				IImages.TRANS_270 ,
				IImages.TRANS_HV ,
				IImages.TRANS_NONE ,
				IImages.TRANS_H ,
				IImages.TRANS_V ,		
			},{
//				ScreenFlip = 270
				IImages.TRANS_270 ,
				IImages.TRANS_H90 ,
				IImages.TRANS_V90 ,
				IImages.TRANS_90,
				IImages.TRANS_NONE ,
				IImages.TRANS_HV ,
				IImages.TRANS_V ,
				IImages.TRANS_H ,
			},{
//				ScreenFlip = H 90
				IImages.TRANS_H90 ,
				IImages.TRANS_270 ,	
				IImages.TRANS_90 ,
				IImages.TRANS_V90 ,
				IImages.TRANS_V ,
				IImages.TRANS_H ,
				IImages.TRANS_NONE ,
				IImages.TRANS_HV ,
			},{
//				ScreenFlip = V 90
				IImages.TRANS_V90 ,
				IImages.TRANS_90 ,
				IImages.TRANS_270 ,
				IImages.TRANS_H90 ,				
				IImages.TRANS_H ,
				IImages.TRANS_V ,
				IImages.TRANS_HV ,
				IImages.TRANS_NONE ,
			}
			
	};

	/**
	 * �õ���ת��
	 * @param trans
	 * @return
	 */
	static protected int getFlipIndex(byte trans){
		switch(trans){
		case IImages.TRANS_NONE:
			return 0;
		case IImages.TRANS_H :
			return 1;
		case IImages.TRANS_V :
			return 2;
		case IImages.TRANS_HV :
			return 3;
		case IImages.TRANS_90 :
			return 4;
		case IImages.TRANS_270 : 
			return 5;
		case IImages.TRANS_H90 :
			return 6;
		case IImages.TRANS_V90 :
			return 7;
		}
		return -1;
	}

	/**
	 * �ӵ�ǰ״̬��ת����һ״̬
	 * @param currentTrans	�ϸ�״̬
	 * @param nextTrans	Ҫ��ת��״̬
	 * @return ��һ��״̬
	 */
	static protected byte transFlipNext(byte currentTrans,byte nextTrans){
		return SubSprFlipTable[getFlipIndex(currentTrans)][getFlipIndex(nextTrans)];
	}
	
	/**
	 * ��ת��
	 * @param point
	 * @param transform 
	 */
	static protected void TransformPoint(int[] point,int transform){
		int temp = 0;
		for(int i=0;i<point.length;i+=2){
			switch(transform){
			case IImages.TRANS_NONE:
				break;
			case IImages.TRANS_H: 
				point[i+0] = -point[i+0];
				//point[i+1] = +point[i+1];
				break;
			case IImages.TRANS_V: 
				//point[i+0] = +point[i+0];
				point[i+1] = -point[i+1];
				break;
			case IImages.TRANS_HV: 
				point[i+0] = -point[i+0];
				point[i+1] = -point[i+1];
				break;
			case IImages.TRANS_90: 
				temp = point[i+0];
				point[i+0] = +point[i+1];
				point[i+1] = -temp;
				break;
			case IImages.TRANS_270: 
				temp = point[i+0];
				point[i+0] = -point[i+1];
				point[i+1] = +temp;
				break;
			case IImages.TRANS_H90: 
				point[i+0] = -point[i+0];
				//point[i+1] = +point[i+1];
				temp = point[i+0];
				point[i+0] = +point[i+1];
				point[i+1] = -temp;
				break;
			case IImages.TRANS_V90: 
				//point[i+0] = +point[i+0];
				point[i+1] = -point[i+1];
				temp = point[i+0];
				point[i+0] = +point[i+1];
				point[i+1] = -temp;
				break;
			}
		}
		
	}
//	------------------------------------------------------------------------------------------

	public int getVisibleHeight(){
		return animates.w_bottom - animates.w_top;
	}
	public int getVisibleWidth(){
		return animates.w_right - animates.w_left;
	}
	public int getCDHeight(){
		return collides.w_bottom - collides.w_top;
	}
	public int getCDWidth(){
		return collides.w_right - collides.w_left;
	}
	
	public CAnimates getAnimates(){
		return animates;
	}
	
	public CCollides getCollides(){
		return collides;
	}
	
	/**
	 * �õ�����������������
	 * @return 
	 */
	public int getAnimateCount() {
		return FrameAnimate.length;
	}

	/**
	 * ���ݶ���ID ���õ�֡������
	 * @param id ����ID��
	 * @return 
	 */
	public int getFrameCount(int id) {
		return FrameAnimate[id].length;
	}
	
	/**
	 * �õ���ǰ֡��
	 * @return 
	 */
	public int getCurrentFrame() {
		return CurFrame;
	}

	/**
	 * �õ���ǰ������
	 * @return 
	 */
	public int getCurrentAnimate() {
		return CurAnimate;
	}

	/**
	 * ���õ�ǰ֡
	 * @param id ����ID
	 * @param index ֡��
	 */
	public void setCurrentFrame(int id, int index) {
		CurAnimate = (short) id;
		CurFrame = (short) index;
	}

	/**
	 * ���ŵ���һ֡
	 * @return �Ƿ񳬳����һ֡
	 */
	public boolean nextFrame() {
		CurFrame++;
		if (CurFrame >= FrameAnimate[CurAnimate].length ) {
			CurFrame = FrameAnimate[CurAnimate].length - 1;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * ѭ�����ŵ���һ֡
	 */
	public void nextCycFrame() {
		CurFrame++;
		CurFrame%=FrameAnimate[CurAnimate].length;
	}

	/**
	 * ѭ�����ŵ���һ֡����������һ֡��������ָ��λ�á�
	 * @param restart ������ָ��λ��
	 */
	public void nextCycFrame(int restart) {
		CurFrame++;
		if (CurFrame < FrameAnimate[CurAnimate].length) {
		} else {
			CurFrame = (byte) (restart % FrameAnimate[CurAnimate].length);
		}
	}
	
	

	
	//--------------------------------------------------------------------------------------------------------

	/**
	 * ��Ⱦ����
	 * @param g
	 * @param x
	 * @param y 
	 */
	public void render(Graphics g,int x,int y) {
		if (OnScreen){
				animates.render(g,FrameAnimate[CurAnimate][CurFrame],x,y);
//#ifdef _DEBUG
			if (Active && IsDebug){
				collides.render(g,FrameCDMap[CurAnimate][CurFrame],x,y,0xff00ff00);
				collides.render(g,FrameCDAtk[CurAnimate][CurFrame],x,y,0xffff0000);
				collides.render(g,FrameCDDef[CurAnimate][CurFrame],x,y,0xff0000ff);
				collides.render(g,FrameCDExt[CurAnimate][CurFrame],x,y,0xffffffff);
			}
//#endif
		}
	}

	//	----------------------------------------------------------------------------------------------------

}




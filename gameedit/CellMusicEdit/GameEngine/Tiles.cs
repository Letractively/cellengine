using System;
using System.Drawing;

namespace GameLib
{
	/// <summary>
	/// 
	/// </summary>
	public class CSTileGroup
	{

		/*
		 * ��ת����
		 */
		/**����ת*/
		public static byte TRANS_NONE	= 0 ; 
		/**ˮƽ��ת*/
		public static byte TRANS_H 	= 2 ; 
		/**��ֱ��ת*/
		public static byte TRANS_V	= 1 ; 
		/**180�ȷ�ת*/
		public static byte TRANS_HV	= 3 ;
		/**��ʱ��90�ȷ�ת*/
		public static byte TRANS_90	= 6 ; 
		/**��ʱ��270�ȷ�ת*/
		public static byte TRANS_270 	= 5 ; 
		/**����ʱ��90�ȷ�ת��Ȼ����ˮƽ��ת*/
		public static byte TRANS_H90	= 4 ; 
		/**����ʱ��90�ȷ�ת��Ȼ���ڴ�ֱ��ת*/
		public static byte TRANS_V90	= 7 ; 
		/**180�ȷ�ת*/
		public static byte TRANS_180	= 3 ; // 180 = HV

		private int count;
		private int index;
		/**TILE��ĸ���*/
		private Image[] Tiles;
	
		private RotateFlipType[] TransTable = 
		{
			RotateFlipType.RotateNoneFlipNone,
			RotateFlipType.RotateNoneFlipY,
			RotateFlipType.RotateNoneFlipX,
			RotateFlipType.RotateNoneFlipXY,
			RotateFlipType.Rotate90FlipX,
			RotateFlipType.Rotate270FlipNone,
			RotateFlipType.Rotate90FlipNone,
			RotateFlipType.Rotate90FlipY,
		};
	

		//--------------------------------------------------------------------------------------------------------

		/**
		 * ����һ��TileGroup
		 * @param NewTileImage ԭͼƬ
		 * @param NewTilecount �г���ͼ�ĸ���
		 */
		public CSTileGroup(int NewTilecount) 
		{
			count = NewTilecount ;
			index = 0 ;
			Tiles = new Image[count];




		}


		/**
		 * �õ���ͼ�Ŀ��
		 * @param Index ��ͼ���
		 * @return ���
		 */
		public int getWidth(int i) 
		{
			return Tiles[i].Width;
		}
		/**
		 * �õ���ͼ�ĸ߶�
		 * @param Index ��ͼ���
		 * @return �߶�
		 */
		public int getHeight(int i) 
		{
			return Tiles[i].Height;
		}
		/**
		 * �õ�����
		 * @return ����
		 */
		public int getCount()
		{
			return count;
		}

		/**
		 * ��ԭͼ���ŵ���ӵ����
		 * @return �Ƿ�δװ��
		 */
		public bool addTile(string str) 
		{
			if (index < count) 
			{
				try
				{
					//װ��ͼƬ
					Image image = System.Drawing.Image.FromFile(str);
					Tiles[index] = image ;
				}
				catch(System.Exception e)
				{
					System.Windows.Forms.MessageBox.Show(e.Message.ToString());	
				}
				index++;
			}
			if (index >= count) 
			{
				return false;
			} 
			else 
			{
				return true;
			}
		}

		/**
		 * ��ԭͼ���ŵ���ӵ����
		 * @return �Ƿ�δװ��
		 */
		public bool addTile(Image image) 
		{
			if (index < count) 
			{
				Tiles[index] = image ;
				index++;
			}
			if (index >= count) 
			{
				return false;
			} 
			else 
			{
				return true;
			}
		}

	
	
		/**
		 * ��ԭͼ��һ�������г�Сͼ���Ž����
		 * @param TileX		��ԭͼ��x���
		 * @param TileY		��ԭͼ��y���
		 * @param TileWidth		��ԭͼ�Ŀ�
		 * @param TileHeight	��ԭͼ�ĸ�
		 * @return false �Ƿ�δװ��
		 */
		public bool addTile(
			Image image,
			int TileX, int TileY, 
			int TileWidth, int TileHeight) 
		{
			if (index < count) 
			{
				if (TileWidth <= 0 || TileHeight <= 0) 
				{
					System.Windows.Forms.MessageBox.Show("ͼ���С����");	
				} 
				else 
				{
					Tiles[index] =  new System.Drawing.Bitmap(TileWidth, TileHeight);
					Graphics g = Graphics.FromImage(Tiles[index]);
					g.Clip = new Region(new System.Drawing.Rectangle(TileX,TileY,TileWidth,TileHeight));
					g.DrawImage(image,-TileX,-TileY,TileWidth,TileHeight);
				}
				index++;
			}
			if (index >= count) 
			{
				return false;
			} 
			else 
			{
				return true;
			}
		}

	
	
		/**
		 * ��ԭͼ���������г�����Сͼ���Ž����
		 * @param ClipX		��ԭͼ��x���
		 * @param ClipY		��ԭͼ��y���
		 * @param ClipWidth		��ԭͼ��������
		 * @param ClipHeight	��ԭͼ��������
		 * @param TileWidth		ÿ��Ŀ�
		 * @param TileHeight	ÿ��ĸ�
		 */
		public void addTile(
			Image image,
			int ClipX, int ClipY, 
			int ClipWidth, int ClipHeight,
			int TileWidth, int TileHeight) 
		{
			if (index < count) 
			{
				for (int j = 0; j < ClipHeight / TileHeight; j++) 
				{
					for (int i = 0; i < ClipWidth / TileWidth; i++) 
					{
						if (!addTile(image,ClipX + TileWidth * i, ClipY + TileHeight * j,
							TileWidth, TileHeight)) 
						{
							return;
						}
					}
				}
			}
		}
	
		/**
		 * ���Ƶ�ָ����Graphics�ϡ�
		 * @param g		ָ����graphics
		 * @param Index	���
		 * @param PosX	X����
		 * @param PosY	Y����
		 */
		public void render(System.Drawing.Graphics g,int i, int PosX, int PosY) 
		{//	����ѡ����뷽ʽ,������ת
			g.DrawImage(Tiles[i],PosX,PosY,getWidth(i),getHeight(i));
		}

		/**
		 * ���Ƶ�ָ����Graphics�ϡ�
		 * @param g		ָ����graphics
		 * @param Index	���
		 * @param PosX	X����
		 * @param PosY	Y����
		 * @param Style ��ת��ʽ���ο� CSSprite ��ķ�ת������
		 */
		public void render(System.Drawing.Graphics g,int i, int PosX, int PosY, int Style) 
		{
			Image buf = (Image)Tiles[i].Clone();
			buf.RotateFlip(TransTable[Style]);
			g.DrawImage(buf,PosX,PosY,getWidth(i),getHeight(i));
		}


	

	}
}

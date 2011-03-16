using System;
using System.Collections;

namespace MidiLibrary
{

	/*------------------------------------------------------------------*/
	/*                         Header Chunk                             */
	/*------------------------------------------------------------------*/
	/* Header Chunk */
	public class HeaderChunk 
	{
		public static byte[]	CHUNK_TYPE_HEADER = {0x4D,0x54,0x68,0x64} ;
		public static Int16	MIDI_TYPE_0			= 0 ;
		public static Int16	MIDI_TYPE_1			= 1 ;
		public static Int16	MIDI_TYPE_2			= 2 ;

		//		public static Int16	SMPTE_ON						= 0x8000;
		public static Int16	SMPTE_FPS_24					= -24<<8;
		public static Int16	SMPTE_FPS_25					= -25<<8;
		public static Int16	SMPTE_FPS_30_DROP_FRAME			= -29<<8;
		public static Int16	SMPTE_FPS_30_NONE_DROP_FRAME	= -30<<8;


		public byte[]	ChunkType;
		public Int32	DataSize;

		public Int16	MidiType;
		public Int16	Tracks;
		public Int16	Division;

		//		public Int16	DTPT;//delta-time per ticks
		//		public Int16	smpte_on  : 1;
		public Int16	Smpte_fps;
		public Int16	Smpte_tpf;

		public HeaderChunk(Int32 dataSize)
		{
			ChunkType = new byte[4];
			System.Array.Copy(CHUNK_TYPE_HEADER,ChunkType,4);
			DataSize = dataSize;

			Console.Write("HeaderSize  : ");
			Console.WriteLine(this.DataSize);

			MidiType = 0;
			Tracks = 0;
			Division = 0;

			Smpte_fps = 0;
			Smpte_tpf = 0;
		}

		public Int32 LoadChunkData(byte[] data,Int32 p)
		{
			int P = p ;
			MidiType = Midi.readMSB16(data,P);P+=2;
			Tracks   = Midi.readMSB16(data,P);P+=2;
			Division = Midi.readMSB16(data,P);P+=2;

			Console.Write("Midi Format : ");
			Console.WriteLine(this.MidiType);

			Console.Write("Traks       : ");
			Console.WriteLine(this.Tracks);

			if((Division&0x8000)==0)
			{
				Console.Write("Division    : ");
				Console.WriteLine(this.Division);
			}
			else
			{
				Smpte_fps = (Int16)(Division>>8);
				Smpte_tpf = (Int16)(Division&0x00ff);

				Console.Write("SMPTE FPS   : ");
				Console.WriteLine(this.Smpte_fps);

				Console.Write("SMPTE TPF   : ");
				Console.WriteLine(this.Smpte_tpf);
			}
			return P - p ;
		}
	};


	/*------------------------------------------------------------------*/
	/*                         Track Chunk                              */
	/*------------------------------------------------------------------*/

	/* Track Chunk */
	public class TrackChunk 
	{
	
		public static byte[] CHUNK_TYPE_TRACK = {0x4D,0x54,0x72,0x6B};

		public static string TextMeta	= "Meta";
		public static string TextSYSEX	= "SYSEX";

		public byte[]	ChunkType;
		public Int32	DataSize;

		public ArrayList DeltaTime;
		public ArrayList Event;
		public ArrayList Discription;
		public ArrayList EData;


		public TrackChunk(Int32 dataSize)
		{
			ChunkType = new byte[4];
			System.Array.Copy(CHUNK_TYPE_TRACK,ChunkType,4);
			DataSize = dataSize;
			
			DeltaTime = new ArrayList();
			Event = new ArrayList();
			Discription = new ArrayList();
			EData = new ArrayList();

			Console.Write("TrackSize   : ");
			Console.WriteLine(this.DataSize);
		}

		public Int32 LoadChunkData(byte[] data,Int32 p)
		{
			
			Int32 P = p ;
			byte MidiStatus = 0;



			while((P-p)<DataSize)
			{
				int EStart = P;

				/* delta time */
				Int32 val = 0;

				Int32[] vlq = Midi.readVLQ(data,P);
				P+=vlq[0];
				val = vlq[1];

				String dt = val.ToString();
				DeltaTime.Add(dt);
				//DeltaTime.
				//	Console.Write("DeltaTime   : ");
				//	Console.WriteLine(value);

				/* events */
				byte CurByte = Midi.readMSB8(data,P);

				//midi status changed
				if( CurByte>=0x80 )
				{
					MidiStatus = CurByte ;
					P++;
				}

			

				//8x      1000xxxx    nn vv        �����ر� (�ͷż���) nn=������ vv=�ٶ�
				if(MidiStatus>=0x80 && MidiStatus<=0x8f)
				{
						
					Event.Add("Note Off");
					Discription.Add(
						"Channel="+(MidiStatus&0x0f)+","+
						"Note="+Midi.readMSB8(data,P++)+","+
						"Velocity="+Midi.readMSB8(data,P++)
						);

					//P+=2;

				}
				//9x      1001xxxx    nn vv        ������ (���¼���) nn=������ vv=�ٶ�
				if(MidiStatus>=0x90 && MidiStatus<=0x9f)
				{
					Event.Add("Note On");
					Discription.Add(
						"Channel="+(MidiStatus&0x0f)+","+
						"Note="+Midi.readMSB8(data,P++)+","+
						"Velocity="+Midi.readMSB8(data,P++)
						);
					//P+=2;
				}
				//Ax      1010xxxx    nn vv        ���������Ժ� nn=������ vv=�ٶ�
				if(MidiStatus>=0xa0 && MidiStatus<=0xaf)
				{
					Event.Add("Polyphone Key Pressure(Aftertouch)");
					Discription.Add(
						"Channel="+(MidiStatus&0x0f)+","+
						"Note="+Midi.readMSB8(data,P++)+","+
						"Velocity="+Midi.readMSB8(data,P++)
						);
					//P+=2;
				}
				//Bx      1011xxxx    cc vv        �������� cc=���ƺ� vv=��ֵ
				if(MidiStatus>=0xb0 && MidiStatus<=0xbf)
				{
					Event.Add("Control Change");
					Discription.Add(
						"Channel="+(MidiStatus&0x0f)+","+
						"Controller Number="+Midi.readMSB8(data,P++)+","+
						"New Value="+Midi.readMSB8(data,P++)
						);
					//P+=2;
				}
				//Cx      1100xxxx    pp            �ı����Ƭ�ϣ� pp=�µĳ����
				if(MidiStatus>=0xc0 && MidiStatus<=0xcf)
				{
					Event.Add("Program Change");
					Discription.Add(
						"Channel="+(MidiStatus&0x0f)+","+
						"New Program Number="+Midi.readMSB8(data,P++)
						);
					//P+=1;
				}
				//Dx      1101xxxx    cc            ��ͨ����Ӵ� cc=�ܵ���
				if(MidiStatus>=0xd0 && MidiStatus<=0xdf)
				{
					Event.Add("Channel Pressure(Aftertouch)");
					Discription.Add(
						"Channel="+(MidiStatus&0x0f)+","+
						"cc="+Midi.readMSB8(data,P++)
						);
					P+=1;
				}
				//Ex      1110xxxx    bb tt        �ı以��ҧ�͵ĳ��� (2000H ����ȱʡ��û�иı�)(ʲô��˼�㲻��:)
				//        bb=ֵ�ĵ�7λ(least sig) 
				//        tt=ֵ�ĸ�7λ (most sig) 
				if(MidiStatus>=0xe0 && MidiStatus<=0xef)
				{
					Event.Add("Pitch Wheel Change");
					Discription.Add(
						"Channel="+(MidiStatus&0x0f)+","+
						"Bottom="+Midi.readMSB8(data,P++)+","+
						"Top="+Midi.readMSB8(data,P++)
						);
					//P+=2;
				}



				//F0      ϵͳר����Ϣ
				//f0 SYSEX events
				if(MidiStatus==0xf0)
				{
					int len = 0 ;
					vlq = Midi.readVLQ(data,P);
					P+=vlq[0];

					Event.Add("SYSEX : (0xf0)");
					Discription.Add("...");

					len = vlq[1];
					P+=len;
				}
				//F1      MIDIʱ�����ת����Ϣ
				if(MidiStatus==0xf1)
				{
					Event.Add("SYSEX : MIDI Time Code");
					Discription.Add("");
				}
				//F2      ����λ��ָ����Ϣ
				if(MidiStatus==0xf2)
				{
					Event.Add("SYSEX : Song Position Pointer");
					Discription.Add("...");
					P+=2;
				}
				//F3      ����ѡ����Ϣ
				if(MidiStatus==0xf3)
				{
					Event.Add("SYSEX : Song Select");
					Discription.Add("Song="+Midi.readMSB8(data,P++));
				}
				//F4      (δ����)
				if(MidiStatus==0xf4)
				{
					Event.Add("(Undefined) (0xf4)");
					Discription.Add("...");
				}
				//F5      (δ����)
				if(MidiStatus==0xf5)
				{
					Event.Add("(Undefined) (0xf5)");
					Discription.Add("...");
				}
				//F6      ��������Ҫ����Ϣ
				if(MidiStatus==0xf6)
				{
					Event.Add("SYSEX : Tune Request");
					Discription.Add("");
				}
				//F7      ����ϵͳר����Ϣ
				if(MidiStatus==0xf7)
				{
					Event.Add("SYSEX : End of Exclusive");
					Discription.Add("");
				}
				//F8      ͬ��������ļ�ʱ��
				if(MidiStatus==0xf8)
				{
					Event.Add("SYSEX : Synchronise Timer");
					Discription.Add("");
				}
				//F9      (δ����)
				if(MidiStatus==0xf9)
				{
					Event.Add("(Undefined) (0xf9)");
					Discription.Add("...");
				}
				//FA      ��ʼ��ǰ�Ķ���
				if(MidiStatus==0xfa)
				{
					Event.Add("SYSEX : Start");
					Discription.Add("");
				}
				//FB      ��ֹͣ�ĵط�����һ������
				if(MidiStatus==0xfb)
				{
					Event.Add("SYSEX : Continue");
					Discription.Add("");
				}
				//FC      ֹͣһ������
				if(MidiStatus==0xfc)
				{
					Event.Add("SYSEX : Stop");
					Discription.Add("");
				}
				//FD      (δ����)
				if(MidiStatus==0xfd)
				{
					Event.Add("(Undefined) (0xfd)");
					Discription.Add("...");
				}
				//FE      ��ϵ������Ϣ
				if(MidiStatus==0xfe)
				{
					Event.Add("SYSEX : Active Sending");
					Discription.Add("");
				}
				//FF       ��λ��Ϣ
				//if(MidiStatus==0xff){}
				//ff Meta-Events
				if(MidiStatus==0xff)
				{
					byte MetaType = Midi.readMSB8(data,P++);
					byte[] MetaData;

					int len = 0 ;
					vlq = Midi.readVLQ(data,P);
					P+=vlq[0];
					len = vlq[1];

					MetaData = new byte[len];
					System.Array.Copy(data,P,MetaData,0,len);

					P+=len;

					//int mp = 0;
					String text = "";
					switch(MetaType)
					{
					//00 nn ssss      �趨�������� nn=02 (���ֽڳ��ȵ����) ssss=���
					case 0x00:
						Event.Add("Meta : Set Track Number");
						Discription.Add("");
						break;
					//01 nn tt ..      ����Ҫ�������ı��¼� �� nn=���ֽ�Ϊ��λ���ı����� tt=�ı��ַ�
					case 0x01:
						Event.Add("Meta : Text");
						for(int i=0;i<MetaData.Length;i++)
						{
							text+=((char)MetaData[i]).ToString();
						}
						Discription.Add(text);
						break;
					//02 nn tt ..      ͬ�ı����¼�, �������ڰ�Ȩ��Ϣ nn tt=ͬ�ı��¼�
					case 0x02:
						Event.Add("Meta : Copyright");
						for(int i=0;i<MetaData.Length;i++)
						{
							text+=((char)MetaData[i]).ToString();
						}
						Discription.Add(text);
						break;
					//03 nn tt ..      ���л��߹���� nn tt=ͬ�ı��¼�
					case 0x03:
						Event.Add("Meta : Track Name");
						for(int i=0;i<MetaData.Length;i++)
						{
							text+=((char)MetaData[i]).ToString();
						}
						Discription.Add(text);
						break;
					//04 nn tt ..      ��������� nn tt=ͬ�ı��¼�
					case 0x04:
						Event.Add("Meta : Instrument Name");
						for(int i=0;i<MetaData.Length;i++)
						{
							text+=((char)MetaData[i]).ToString();
						}
						Discription.Add(text);
						break;
					//05 nn tt ..      ��� nn tt=ͬ�ı��¼�
					case 0x05:
						Event.Add("Meta : Lyric");
						for(int i=0;i<MetaData.Length;i++)
						{
							text+=((char)MetaData[i]).ToString();
						}
						Discription.Add(text);
						break;
					//06 nn tt ..      ��ǩ nn tt=ͬ�ı��¼�
					case 0x06:
						Event.Add("Meta : Label");
						for(int i=0;i<MetaData.Length;i++)
						{
							text+=((char)MetaData[i]).ToString();
						}
						Discription.Add(text);
						break;
					//07 nn tt ..      �������� nn tt=ͬ�ı��¼�
					case 0x07:
						Event.Add("Meta : Float Note");
						for(int i=0;i<MetaData.Length;i++)
						{
							text+=((char)MetaData[i]).ToString();
						}
						Discription.Add(text);
						break;
					//20 01 cc         MIDI Channel ǰ׺
					case 0x20:
						Event.Add("Meta : MIDI Channel Prefixal");
						Discription.Add(MetaData[0].ToString());
						break;
					//2F 00            ����¼�һ����ÿ������Ľ�β����
					case 0x2f:
						Event.Add("Meta : Track End");
						Discription.Add("");
						break;
					//51 03 tttttt    �趨���� tttttt=΢��/�ķ�����
					case 0x51:
						Event.Add("Meta : Set Tempo");
						int tempo = Midi.readMSB24(MetaData,0);
						Discription.Add("Microseconds/Quarter Note="+tempo+"");
						break;
					//54 05 hh mm ss fr ff  SMTPE ƫ���� 
					case 0x54:
						Event.Add("Meta : SMTPE Offset");
						Discription.Add(
							"HH="+MetaData[0]+","+
							"MM="+MetaData[1]+","+
							"SS="+MetaData[2]+","+
							"FR="+MetaData[3]+","+
							"FF="+MetaData[4]
							);
						break;
					//58 04 nn dd cc bb ���ӼǺ� nn=���ӼǺŷ��� dd=���ӼǺŷ�ĸ2=�ķ�֮һ 3=8����, �ȵ�. cc=�������Ľ��� bb=���ķ�֮һ������ע�ĵ�32������
					case 0x58:
						Event.Add("Meta : Time Signature");
						Discription.Add(
							"Numerator="+MetaData[0]+","+
							"Denominator="+MetaData[1]+","+
							"Number of Ticks in Metronome Click="+MetaData[2]+","+
							"Number of 32nd Notes to the Quarternote="+MetaData[3]
							);
						break;
					//59 02 sf mi      �������� sf=����/����(-7=7 ����, 0=��׼C��,7=7 ����) mi=���/С��(0=���, 1=С��)
					case 0x59:
						Event.Add("Meta : Key Signature");
						Discription.Add(
							"Sharps or Flats="+MetaData[0]+","+
							"Major or Minor="+MetaData[1]
							);
						break;
					//7F xx dd ..      ����������ϸ��Ϣ xx=�����͵��ֽ��� dd=����
					case 0x7f:
						Event.Add("Meta : Synthesizer Info");
						for(int i=0;i<MetaData.Length;i++)
						{
							text+=((char)MetaData[i]).ToString();
						}
						Discription.Add(text);
						break;
					default:
						Event.Add("Meta : "+MetaType.ToString("X2"));
						Discription.Add("");
						break;
					}
	
				}

				String st = "";
				for(int i=0;i<P-EStart;i++)
				{
					st+=(data[EStart+i]).ToString("X2");
					st+=" ";
				}
				EData.Add(st);
			}
				
			
			
			//P += DataSize;
			return P - p ;
		}

	};

 

	/*------------------------------------------------------------------*/
	/*                         Midi                                     */
	/*------------------------------------------------------------------*/

	/* Midi */
	public class Midi
	{



		/*------------------------------------------------------------------*/
		/*                         Function                                 */
		/*------------------------------------------------------------------*/

		/// <summary> ��һ��data������дһ��Byte
		/// <param>	  data[]
		/// <param>   value
		public static void writeMSB(byte[] data,Int32 p,byte  val)
		{
			data[p++] = val;
		}
		/// <summary> ��һ��data������дһ��Int16
		/// <param>	  data[]
		/// <param>   value
		public static void writeMSB(byte[] data,Int32 p,Int16 val)
		{
			data[p++] = (byte)(val>>8);
			data[p++] = (byte)(val>>0);
		}

		/// <summary> ��һ��data������дһ��Int24
		/// <param>	  data[]
		/// <param>   value
		public static void writeMSB24(byte[] data,Int32 p,Int32 val)
		{
			data[p++] = (byte)(val>>16);
			data[p++] = (byte)(val>>8) ;
			data[p++] = (byte)(val>>0) ;
		}

		/// <summary> ��һ��data������дһ��Int32
		/// <param>	  data[]
		/// <param>   value
		public static void writeMSB(byte[] data,Int32 p,Int32 val)
		{
			data[p++] = (byte)(val>>24);
			data[p++] = (byte)(val>>16);
			data[p++] = (byte)(val>>8) ;
			data[p++] = (byte)(val>>0) ;
		}

		/// <summary> ��һ��data�������һ��Byte
		/// <param>	  data[]    Դ����
		/// <param>   p         λ��
		/// <return>  
		public static byte  readMSB8(byte[] data,Int32 p)
		{
			return data[p++] ;
		}

		/// <summary> ��һ��data�������һ��Int16
		/// <param>	  data[]    Դ����
		/// <param>   p         λ��
		/// <return>  
		public static Int16 readMSB16(byte[] data,Int32 p)
		{
			Int16 val = 0;
			val += (Int16)(data[p++]<<8);
			val += (Int16)(data[p++]<<0);
			return val ;
		}

		/// <summary> ��һ��data�������һ��Int24
		/// <param>	  data[]    Դ����
		/// <param>   p         λ��
		/// <return>  
		public static Int32 readMSB24(byte[] data,Int32 p)
		{
			Int32 value = 0;
			value += data[p++]<<16;
			value += data[p++]<<8;
			value += data[p++]<<0;
			return value ;
		}

		/// <summary> ��һ��data�������һ��Int32
		/// <param>	  data[]    Դ����
		/// <param>   p         λ��
		/// <return>  
		public static Int32 readMSB32(byte[] data,Int32 p)
		{
			Int32 value = 0;
			value += data[p++]<<24;
			value += data[p++]<<16;
			value += data[p++]<<8;
			value += data[p++]<<0;
			return value ;
		}



		/// <summary> ��һ��data������дһ���ɱ䳤������ variable length quantity
		/// <param>	  data[]    Դ����
		/// <param>   p         λ��
		/// <param>   vaule     ����
		/// <return>            д�˶����ֽ�
		public static Int32 writeVLQ(byte[] data,Int32 p,Int32 vaule)
		{
			byte[] temp = new Byte[4];
			Int32 length = 0;
			for(int i=0;i<4;i++)
			{
				temp[i] = (byte)(vaule>>(7*i));
				length++;

				if((vaule>>(7*(i+1)))<=0)
				{
					temp[i] = (byte)(temp[i]&0x7f);
					break;
				}
				else
				{
					temp[i] = (byte)(temp[i]|0x80);
				}
			}
				
			for(int i=0;i<length;i++)
			{
				data[p++] = temp[(length-1)-i];
			}

			return length;
		}

		/// <summary> ��һ��data�������һ���ɱ䳤������ variable length quantity
		/// <param>	  data[]    Դ����
		/// <param>   p         λ��
		/// <return>            [0]���˶����ֽ�[1]ֵ
		public static Int32[] readVLQ(byte[] data,Int32 p)
		{
			Int32 Vaule = 0;
			Int32 length = 0;
			for(int i=0;i<4;i++)
			{
				byte temp = data[p++];
				Vaule = (Vaule<<7)|(temp&0x7f);
				length++;

				if((temp&0x80)==0)
				{
					break;
				}
			}	
			Int32[] ret = new Int32[2];
			ret[0] = length;
			ret[1] = Vaule;
			return ret;
		}	
		/*------------------------------------------------------------------*/
		/*                         Function                                 */
		/*------------------------------------------------------------------*/




		public HeaderChunk header;
		public TrackChunk[] track;
		public byte[] Data;

		public Midi()
		{
		}


		public Int32 LoadData(byte[] data)
		{
			Console.WriteLine();
			Console.Write("Load data ");
			Console.Write(data.Length);
			Console.WriteLine("(Bytes)");
			
			int  P = 0;
//*
			//header
			for(int i=0;i<4;i++)
			{
				if(data[P++]!=HeaderChunk.CHUNK_TYPE_HEADER[i])
				{
					Console.WriteLine("    Error ! Bad Header Chunk .");
					System.Exception err = new System.Exception("Bad Header Chunk !");
					throw(err);
				}
			}
			header = new HeaderChunk(Midi.readMSB32(data,P));P+=4;
			P+=header.LoadChunkData(data,P);

			if(header.MidiType!=HeaderChunk.MIDI_TYPE_0 && header.MidiType!=HeaderChunk.MIDI_TYPE_1)
			{
				Console.WriteLine("    Error ! Only support Midi Format 0 or 1 .");
				System.Exception err = new System.Exception("Only support Midi Format 0 or 1 !");
				throw(err);
			}
//*			
			//track
			track = new TrackChunk[header.Tracks];
			for(int t=0;t<header.Tracks;t++)
			{
				for(int i=0;i<4;i++)
				{
					if(data[P++]!=TrackChunk.CHUNK_TYPE_TRACK[i])
					{
						Console.Write("    Error ! Bad Track Chunk.("+t+") .");
						System.Exception err = new System.Exception("Bad Track Chunk.("+t+") !");
						throw(err);
					}
				}
				track[t] = new TrackChunk(Midi.readMSB32(data,P));P+=4;
				P+=track[t].LoadChunkData(data,P);
			}
//*/

			Data = data ;

			Console.Write("Midi Created ! Process ");
			Console.Write(P);
			Console.WriteLine("(Bytes)");

			return P;
		}

	}	


}

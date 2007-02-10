using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Text;
using System.Windows.Forms;
using System.Collections;
using System.Runtime.Serialization;
using System.Runtime.Serialization.Formatters;
using System.Security.Permissions;

using javax.microedition.lcdui;

namespace CellGameEdit.PM
{

    [Serializable]
    public partial class MapForm : Form , ISerializable 
    {

        public String id;

        public ImagesForm super;

        public int CellW;
        public int CellH;
        

        int[][] MatrixTile;
        int[][] MatrixAnim;

        int[][] MatrixFlip;
        int[][] MatrixTag;

        

        //Hashtable AnimTable;
        Hashtable AnimIndexTable;
        Hashtable AnimFlipTable;
        //Hashtable AnimTypeTable;

        //[NoneSerializable]
        ArrayList Tiles;

        int XCount;
        int YCount;

        static public System.Drawing.RotateFlipType[] flipTable = new System.Drawing.RotateFlipType[]
        {
            System.Drawing.RotateFlipType.RotateNoneFlipNone,
            System.Drawing.RotateFlipType.Rotate90FlipNone,//
            System.Drawing.RotateFlipType.Rotate180FlipNone,
            System.Drawing.RotateFlipType.Rotate270FlipNone,//

            System.Drawing.RotateFlipType.RotateNoneFlipX,
            System.Drawing.RotateFlipType.Rotate270FlipX,//
            System.Drawing.RotateFlipType.Rotate180FlipX,
            System.Drawing.RotateFlipType.Rotate90FlipX,//
        };

        static public int[] flipTableJ2me = new int[]{
           Cell.Game.CImages.TRANS_NONE,
            Cell.Game.CImages.TRANS_270,
            Cell.Game.CImages.TRANS_180,
            Cell.Game.CImages.TRANS_90,

            Cell.Game.CImages.TRANS_H,
            Cell.Game.CImages.TRANS_V90,
            Cell.Game.CImages.TRANS_V,
            Cell.Game.CImages.TRANS_H90,

        };

        int flipIndex = 0;

        int tagIndex = 0;

        int srcIndex = 0;
        Image srcImage;
        System.Drawing.Rectangle srcRect;

        Boolean dstIsDown = false;
        int dstPX = 0;
        int dstPY = 0;
        int dstQX = 0;
        int dstQY = 0;
        System.Drawing.Rectangle dstRect;
        int[][] dstClipTile;
        int[][] dstClipTag;
        int[][] dstClipAnim;
        int[][] dstClipFlip;

        int animCount = 0;
        int curAnimate = -1;
        int curTime =0;
        int curFrame = -1;


        public MapForm(String name,int cellw,int cellh,ImagesForm images)
        {
            InitializeComponent();

            id = name;
            super = images;
            CellW = cellw;
            CellH = cellh;
            srcRect = new System.Drawing.Rectangle(0, 0, 0, 0);
            dstRect = new System.Drawing.Rectangle(0, 0, 0, 0);

            Tiles = super.dstImages;
            for (int i = 0; i < getTileCount(); i++)
            {
                if (getTileImage(i)!=null)
                {
                    srcIndex = i;
                    srcImage = getTileImage(i);
                    srcRect.X = getTileImage(i).x;
                    srcRect.Y = getTileImage(i).y;
                    srcRect.Width = getTileImage(i).getWidth();
                    srcRect.Height = getTileImage(i).getHeight();
                    break;
                }
            }

            XCount = 20;
            YCount = 20;
            MatrixTile = new int[YCount][];
            MatrixTag = new int[YCount][];
            MatrixAnim = new int[YCount][];
            MatrixFlip = new int[YCount][];
            for (int i = 0; i < YCount;i++ )
            {
                MatrixTile[i] = new int[XCount];
                MatrixTag[i] = new int[XCount];
                MatrixAnim[i] = new int[XCount];
                MatrixFlip[i] = new int[XCount];
                //for (int j = 0; j < XCount; j++)
                //{
                //    MatrixAnim[i][j] = 0;
                //}
            }
            pictureBox2.Width = CellW * XCount;
            pictureBox2.Height = CellH * YCount;
            toolStripTextBox1.Text = XCount.ToString();
            toolStripTextBox2.Text = YCount.ToString();


            dstClipTile = new int[1][];
            dstClipTag = new int[1][];
            dstClipAnim = new int[1][];
            dstClipFlip = new int[1][];

            dstClipTile[0] = new int[1];
            dstClipTag[0] = new int[1];
            dstClipAnim[0] = new int[1];
            dstClipFlip[0] = new int[1];

            //AnimTable = new Hashtable();
            //Animates = new ArrayList();
            AnimIndexTable = new Hashtable();
            AnimFlipTable = new Hashtable();
           
            ArrayList frames = new ArrayList();
            frames.Add(0);
            ArrayList flips = new ArrayList();
            flips.Add(0);
            ListViewItem item = new ListViewItem(new String[] { animCount.ToString("(空)"), "1"});
            listView1.Items.Add(item);
            AnimIndexTable.Add(item, frames);
            AnimFlipTable.Add(item, flips);
           
            animCount++;

            pictureBox3.Width = CellW;
            pictureBox3.Height = CellH;

            pictureBox4.Left = pictureBox3.Location.X + 3 + CellW;
            pictureBox4.Width = CellW;
            pictureBox4.Height = CellH;

            trackBar1.Maximum = 0;

           
        }
        [SecurityPermissionAttribute(SecurityAction.Demand, SerializationFormatter = true)]
        protected MapForm(SerializationInfo info, StreamingContext context)
        {
            try
            {
                InitializeComponent();
                id = (String)info.GetValue("id", typeof(String));
                super = (ImagesForm)info.GetValue("super", typeof(ImagesForm));
                CellW = (int)info.GetValue("CellW", typeof(int));
                CellH = (int)info.GetValue("CellH", typeof(int));
                srcRect = new System.Drawing.Rectangle(0, 0, 0, 0);
                dstRect = new System.Drawing.Rectangle(0, 0, 0, 0);


                Tiles = super.dstImages;
                for (int i = 0; i < getTileCount(); i++)
                {
                    if (getTileImage(i) != null)
                    {
                        srcIndex = i;
                        srcImage = getTileImage(i);
                        srcRect.X = getTileImage(i).x;
                        srcRect.Y = getTileImage(i).y;
                        srcRect.Width = getTileImage(i).getWidth();
                        srcRect.Height = getTileImage(i).getHeight();
                        break;
                    }
                }


                MatrixTile = (int[][])info.GetValue("MatrixTile", typeof(int[][]));
                MatrixTag = (int[][])info.GetValue("MatrixTag", typeof(int[][]));
                MatrixAnim = (int[][])info.GetValue("MatrixAnim", typeof(int[][]));
                MatrixFlip = (int[][])info.GetValue("MatrixFlip", typeof(int[][]));
                XCount = MatrixTile[0].Length;
                YCount = MatrixTile.Length;

                pictureBox2.Width = CellW * XCount;
                pictureBox2.Height = CellH * YCount;
                toolStripTextBox1.Text = XCount.ToString();
                toolStripTextBox2.Text = YCount.ToString();


                dstClipTile = new int[1][];
                dstClipTag = new int[1][];
                dstClipAnim = new int[1][];
                dstClipFlip = new int[1][];

                dstClipTile[0] = new int[1];
                dstClipTag[0] = new int[1];
                dstClipAnim[0] = new int[1];
                dstClipFlip[0] = new int[1];

                

                AnimIndexTable = new Hashtable();
                AnimFlipTable = new Hashtable();
          
                ArrayList animK = (ArrayList)info.GetValue("animK", typeof(ArrayList));
                ArrayList animV = (ArrayList)info.GetValue("animV", typeof(ArrayList));
                ArrayList animF = (ArrayList)info.GetValue("animF", typeof(ArrayList));
               
                //Console.WriteLine("KCount=" + animK.Count);

                for (int i = 0; i < animK.Count; i++)
                {
                    ArrayList v = (ArrayList)animV[i];
                    ArrayList f = (ArrayList)animF[i];
                    ListViewItem k = new ListViewItem(new String[] { animK[i].ToString(), v.Count.ToString()});
                    listView1.Items.Add(k);
                    AnimIndexTable.Add(k, v);
                    AnimFlipTable.Add(k, f);
                   
                }

                animCount = (int)info.GetValue("animCount", typeof(int));

                pictureBox3.Width = CellW;
                pictureBox3.Height = CellH;

                pictureBox4.Left = pictureBox3.Location.X + 3 + CellW;

                pictureBox4.Width = CellW;
                pictureBox4.Height = CellH;

                trackBar1.Maximum = 0;
            }
            catch (Exception err)
            {
                MessageBox.Show(err.Message);
            }
        }

        [SecurityPermissionAttribute(SecurityAction.Demand, SerializationFormatter = true)]
        public virtual void GetObjectData(SerializationInfo info, StreamingContext context)
        {
            try{
                info.AddValue("id",id);
                info.AddValue("super", super);
                info.AddValue("CellW",CellW);
                info.AddValue("CellH",CellH);
                

                info.AddValue("MatrixTile",MatrixTile);
                info.AddValue("MatrixTag", MatrixTag);
                info.AddValue("MatrixAnim", MatrixAnim);
                info.AddValue("MatrixFlip", MatrixFlip);

                //info.AddValue("AnimTable", AnimTable);
                ArrayList animK = new ArrayList();
                ArrayList animV = new ArrayList();
                ArrayList animF = new ArrayList();
                
                for (int i = 0; i < listView1.Items.Count; i++)
                {
                    animK.Add(listView1.Items[i].Text);
                    animV.Add(getFrame(i));
                    animF.Add(getFrameFlip(i));
                }
                info.AddValue("animK", animK);
                info.AddValue("animV", animV);
                info.AddValue("animF", animF);
                //Console.WriteLine("NCount=" + AnimTable.Count);

                info.AddValue("animCount", animCount);
            }
            catch (Exception err)
            {
                MessageBox.Show(err.Message);
            }
        }

        int[][] tileMatrix;
        int[][] flagMatrix;
        Animates animates;

        public void initOutput(){
            //init
            tileMatrix = new int[YCount][];
            flagMatrix = new int[YCount][];
            for (int y = 0; y < YCount; y++)
            {
                tileMatrix[y] = new int[XCount];
                flagMatrix[y] = new int[XCount];
                for (int x = 0; x < XCount; x++)
                {
                    tileMatrix[y][x] = 0;
                    flagMatrix[y][x] = (int)MatrixTag[y][x];
                }

            }

            // subs
            animates = new Animates();

            for (int y = 0; y < YCount; y++)
            {
                for (int x = 0; x < XCount; x++)
                {
                    int indexSub = animates.subIndexOf(MatrixTile[y][x], MatrixFlip[y][x]);
                    if (indexSub < 0)
                    {
                        animates.subAdd(MatrixTile[y][x], MatrixFlip[y][x]);
                        indexSub = animates.subGetCount() - 1;
                    }

                    ArrayList frame = new ArrayList();
                    frame.Add(indexSub);

                    int indexFrame = animates.frameIndexOf(frame);
                    if (indexFrame < 0)
                    {
                        animates.frameAdd(frame);
                        indexFrame = animates.frameGetCount() - 1;
                    }

                    tileMatrix[y][x] = (int)indexFrame;

                }
            }
            for (int y = 0; y < YCount; y++)
            {
                for (int x = 0; x < XCount; x++)
                {
                    int anim = Math.Abs(MatrixAnim[y][x]);

                    if (anim > 0 && getFrame(anim) != null && getFrame(anim).Count > 0)
                    {
                        ArrayList frame = new ArrayList();

                        for (int i = 0; i < getFrame(anim).Count; i++)
                        {
                            int indexSub = animates.subIndexOf((int)(getFrame(anim)[i]), (int)(getFrameFlip(anim)[i]));
                            if (indexSub < 0)
                            {
                                animates.subAdd((int)(getFrame(anim)[i]), (int)(getFrameFlip(anim)[i]));
                                indexSub = animates.subGetCount() - 1;
                            }
                            frame.Add(indexSub);
                        }

                        int indexFrame = animates.frameIndexOf(frame);
                        if (indexFrame < 0)
                        {
                            animates.frameAdd(frame);
                            indexFrame = animates.frameGetCount() - 1;
                        }


                        // 和JAVA端相反
                        if (MatrixAnim[y][x] < 0)
                        {
                            tileMatrix[y][x] = indexFrame;
                        }
                        else
                        {
                            tileMatrix[y][x] = -indexFrame;
                        }

                        //Console.WriteLine(" tileMatrix = " + tileMatrix[y][x].ToString("d"));

                    }
                }
            }

        }

        public void Output(System.IO.StringWriter sw)
        {

            initOutput();

            sw.WriteLine();
            sw.WriteLine("final static public CMap createMap_" + super.id + "_" + this.id + "(IImages tiles,boolean isAnimate,boolean isCyc)");
            sw.WriteLine("{");
            // animates
            sw.WriteLine("    CAnimates animates = new CAnimates("+animates.subGetCount()+",tiles);");
        for (int i = 0; i < animates.subGetCount(); i++)  
            sw.WriteLine("    animates.addPart(0,0," + animates.SubPart[i] + "," + flipTableJ2me[(int)(animates.SubFlip[i])] + ");");
            sw.WriteLine("    animates.setFrame(new int[" + animates.frameGetCount() + "][]);");
        for (int i = 0; i < animates.frameGetCount(); i++)
            sw.WriteLine("    animates.setComboFrame(new int[]{"+Util.toTextArray((int[])(animates.frameGetFrame(i).ToArray(typeof(int))))+"},"+i+");");
            sw.WriteLine();
            // collides
            sw.WriteLine("    CCollides collides = new CCollides(8);");
            sw.WriteLine("    collides.addCDRect(0x00000000, 0, 0, " + CellW + "," + CellH + ");");
            sw.WriteLine("    collides.addCDRect(0x00000001, " + 0 + ", " + 0 + ", " + CellW + "," + CellH + ");");
            sw.WriteLine("    collides.addCDRect(0x00000002, " + 0 + ", " + 0 + ", " + CellW + "," + 1 + ");");
            sw.WriteLine("    collides.addCDRect(0x00000004, " + 0 + ", " + (CellH - 1) + ", " + CellW + "," + 1 + ");");
            sw.WriteLine("    collides.addCDRect(0x00000008, " + 0 + ", " + 0 + ", " + 1 + "," + CellH + ");");
            sw.WriteLine("    collides.addCDRect(0x00000010, " + (CellW - 1) + ", " + 0 + ", " + 1 + "," + CellH + ");");
            sw.WriteLine("    collides.addCDLine(0x00000020, " + 0 + ", " + 0 + ", " + (CellW-1) + "," + (CellH-1) + ");");
            sw.WriteLine("    collides.addCDLine(0x00000040, " + (CellW-1) + ", " + 0 + ", " + 0 + "," + (CellH-1) + ");");
            sw.WriteLine();
            // map matrix
            sw.WriteLine("    short[][] tileMatrix = new short[][]{");
        for (int i = 0; i < YCount; i++)
            sw.WriteLine("        {"+ Util.toTextArray(tileMatrix[i]) +"},");
            sw.WriteLine("    };");
            sw.WriteLine("    short[][] flagMatrix = new short[][]{");
        for (int i = 0; i < YCount; i++)
            sw.WriteLine("        {" + Util.toTextArray(flagMatrix[i]) + "},");
            sw.WriteLine("    };");
            sw.WriteLine();
            // map new
            sw.WriteLine("    CMap ret = new CMap(");
            sw.WriteLine("            animates, ");
            sw.WriteLine("            collides, ");
            sw.WriteLine("            " + CellW + ", " + CellH + ", ");
            sw.WriteLine("            tileMatrix, ");
            sw.WriteLine("            flagMatrix, ");
            sw.WriteLine("            isAnimate,isCyc ");
            sw.WriteLine("            );");
            sw.WriteLine();
            sw.WriteLine("    return ret;");
            sw.WriteLine();
            sw.WriteLine("}");

        }

        public void OutputCustom(String script , System.IO.StringWriter output)
        {
            try
            {
                initOutput();

                String map = Util.getFullTrunkScript(script, "#<MAP>", "#<END MAP>");

                bool fix = false;

                // animates part
                do
                {
                    String[] senceParts = new string[animates.subGetCount()];
                    for (int i = 0; i < animates.subGetCount(); i++)
                    {
                        string TILE = animates.SubPart[i].ToString();
                        string TRANS = flipTableJ2me[(int)(animates.SubFlip[i])].ToString();

                        senceParts[i] = Util.replaceKeywordsScript(map, "#<SCENE PART>", "#<END SCENE PART>",
                            new string[] { "<INDEX>", "<TILE>", "<TRANS>" },
                            new string[] { i.ToString(), TILE, TRANS }
                            );
                    }
                    string temp = Util.replaceSubTrunksScript(map, "#<SCENE PART>", "#<END SCENE PART>", senceParts);
                    if (temp == null)
                    {
                        fix = false;
                    }
                    else
                    {
                        fix = true;
                        map = temp;
                    }
                } while (fix);


                // animates frame
                do
                {
                    String[] senceFrames = new string[animates.frameGetCount()];
                    for (int i = 0; i < animates.frameGetCount(); i++)
                    {
                        string DATA = Util.toTextArray((int[])(animates.frameGetFrame(i).ToArray(typeof(int))));

                        senceFrames[i] = Util.replaceKeywordsScript(map, "#<SCENE FRAME>", "#<END SCENE FRAME>",
                            new string[] { "<INDEX>", "<DATA>" },
                            new string[] { i.ToString(), DATA }
                            );
                    }
                    string temp = Util.replaceSubTrunksScript(map, "#<SCENE FRAME>", "#<END SCENE FRAME>", senceFrames);
                    if (temp == null)
                    {
                        fix = false;
                    }
                    else
                    {
                        fix = true;
                        map = temp;
                    }
                } while (fix);


               

                // cd parts
                int[][] cds = new int[][]{
                     new int[]{1,0x00000000, 0, 0, CellW, CellH, CellW, CellH},//null
                     new int[]{1,0x00000001, 0, 0, CellW, CellH, CellW, CellH},//full

                     new int[]{1,0x00000002, 0,       0,       CellW,   1,       CellW ,   CellH},//
                     new int[]{1,0x00000004, 0,       CellH-1, CellW,   1,       CellW ,   CellH},//
                     new int[]{1,0x00000008, 0,       0,       1,       CellH,   CellW ,   CellH},//
                     new int[]{1,0x00000010, CellW-1, 0,       1,       CellH,   CellW ,   CellH},//

                     new int[]{2,0x00000020, 0,       0,       CellW,   CellH,   CellW-1 , CellH-1},//
                     new int[]{2,0x00000040, CellW-1, 0,       CellW,   CellH,   0 ,       CellH-1},//
                };

                do
                {
                    String[] cdParts = new string[8];
                    for (int i = 0; i < 8; i++)
                    {
                        string TYPE = cds[i][0] == 1 ? "rect" : "line";
                        string MASK = cds[i][1].ToString();
                        string X1 = cds[i][2].ToString();
                        string Y1 = cds[i][3].ToString();
                        string W = cds[i][4].ToString();
                        string H = cds[i][5].ToString();
                        string X2 = cds[i][6].ToString();
                        string Y2 = cds[i][7].ToString();
                        cdParts[i] = Util.replaceKeywordsScript(map, "#<CD PART>", "#<END CD PART>",
                            new string[] { "<INDEX>", "<TYPE>", "<MASK>", "<X1>", "<Y1>", "<W>", "<H>", "<X2>", "<Y2>" },
                            new string[] { i.ToString(), TYPE, MASK, X1, Y1, W, H, X2, Y2 }
                            );
                    }
                    string temp = Util.replaceSubTrunksScript(map, "#<CD PART>", "#<END CD PART>", cdParts);
                    if (temp == null)
                    {
                        fix = false;
                    }
                    else
                    {
                        fix = true;
                        map = temp;
                    }
                } while (fix);

                
                // tile matrix
                String senceMatrix = "";
                for (int i = 0; i < YCount; i++)
                    senceMatrix += "{" + Util.toTextArray(tileMatrix[i]) + "},\r\n";


                // cd matrix
                String cdMatrix = "";
                for (int i = 0; i < YCount; i++)
                    cdMatrix += "{" + Util.toTextArray(flagMatrix[i]) + "},\r\n";


                map = Util.replaceKeywordsScript(map, "#<MAP>", "#<END MAP>",
                    new string[] { 
                    "<NAME>", 
                    "<IMAGES NAME>",
                    "<CELL W>",
                    "<CELL H>" , 
                    "<X COUNT>",
                    "<Y COUNT>" , 
                    "<TILE MATRIX>" , 
                    "<FLAG MATRIX>" , 
                    "<SCENE PART COUNT>" ,
                    "<SCENE FRAME COUNT>" ,
                    "<CD PART COUNT>"
                },
                    new string[] { 
                    this.id, 
                    super.id,
                    CellW.ToString(),
                    CellH.ToString(),
                    XCount.ToString(),
                    YCount.ToString(),
                    senceMatrix,
                    cdMatrix,
                    animates.subGetCount().ToString(),
                    animates.frameGetCount().ToString(),
                    "8"}
                    );

                output.WriteLine(map);

            }
            catch (Exception err) { Console.WriteLine(this.id + " : " + err.Message); }

        }

        private void MapForm_Load(object sender, EventArgs e)
        {
            timer1.Start();
        }
        private void MapForm_FormClosing(object sender, FormClosingEventArgs e)
        {
            if (e.CloseReason == CloseReason.UserClosing)
            {
                e.Cancel = true;
                this.Hide();
            }
        }
        private void MapForm_FormClosed(object sender, FormClosedEventArgs e)
        {

        }




        private Image getTileImage(int index)
        {
            return (((Image)(Tiles[index])));
        }
        private int getTileCount()
        {
            return Tiles.Count;
        }


        public int getWidth()
        {
            return this.XCount * this.CellW;
        }

        public int getHeight()
        {
            return this.YCount * this.CellH;
        }

        private void addAnimate()
        {
            int pos = listView1.Items.Count;
            if (listView1.SelectedItems != null && listView1.SelectedItems.Count > 0 )
            {
                pos = listView1.Items.IndexOf(listView1.SelectedItems[0]);
            }
            if (pos == 0 && listView1.Items.Count>1)
            {
                pos = 1;
            }

            ArrayList frames = new ArrayList();
            frames.Add(srcIndex);
            ArrayList flips = new ArrayList();
            flips.Add(flipIndex);
          
            ListViewItem item = new ListViewItem(new String[] { animCount.ToString("d4"), "1" });
            
            //Animates.Add(frames);
            listView1.Items.Insert(pos,item);
            AnimIndexTable.Add(item, frames);
            AnimFlipTable.Add(item,flips);
        

            exchangeAnimate(pos,pos+1);

            item.Selected = true;

            animCount++;
            //curAnimate = listView1.Items.IndexOf(item);
           
        }
        private void delAnimate()
        {
            if (listView1.Items.Count > 1 &&
                listView1.SelectedItems != null &&
                listView1.SelectedItems.Count > 0 && 
                listView1.Items.IndexOf(listView1.SelectedItems[0])>0)
            {
                //Animates.Remove(AnimTable[listView1.SelectedItems[0]]);

                AnimIndexTable.Remove(listView1.SelectedItems[0]);
                AnimFlipTable.Remove(listView1.SelectedItems[0]);
                listView1.Items.Remove(listView1.SelectedItems[0]);


            }
          
        }
        private void exchangeAnimate(int src, int dst)
        {
            if (listView1.SelectedItems != null && listView1.SelectedItems.Count > 0)
            {
                if (listView1.Items.Count > 1 )
                {
                    ListViewItem tempsrc = listView1.Items[src];
                    ListViewItem tempdst = listView1.Items[dst];
                    listView1.Items.Remove(tempdst);
                    listView1.Items.Remove(tempsrc);
                    if (src < dst)
                    {
                        listView1.Items.Insert(src, tempdst);
                        listView1.Items.Insert(dst, tempsrc);
                    }
                    else
                    {
                        listView1.Items.Insert(dst, tempsrc);
                        listView1.Items.Insert(src, tempdst);
                    }
                    tempsrc.Focused = true;
                    
                }
            }
        }


        private void addFrame(int pos, int index, int flip)
        {
            if (listView1.SelectedItems != null && listView1.SelectedItems.Count > 0)
            {
                ((ArrayList)AnimIndexTable[listView1.SelectedItems[0]]).Insert(pos,index);
                ((ArrayList)AnimFlipTable[listView1.SelectedItems[0]]).Insert(pos, flip);
                listView1.SelectedItems[0].SubItems[1].Text = (((ArrayList)AnimIndexTable[listView1.SelectedItems[0]])).Count.ToString();
                exchangeFrame(pos,pos+1);
            }

        }
        private void delFrame(int pos)
        {
            if (listView1.SelectedItems != null && listView1.SelectedItems.Count > 0)
            {
                if (((ArrayList)AnimIndexTable[listView1.SelectedItems[0]]).Count > 1)
                {
                    ((ArrayList)AnimIndexTable[listView1.SelectedItems[0]]).RemoveAt(pos);
                    ((ArrayList)AnimFlipTable[listView1.SelectedItems[0]]).RemoveAt(pos);
                    listView1.SelectedItems[0].SubItems[1].Text = (((ArrayList)AnimIndexTable[listView1.SelectedItems[0]])).Count.ToString();
                }
            }
        }
        private void exchangeFrame(int src, int dst)
        {
            if (listView1.SelectedItems != null && listView1.SelectedItems.Count > 0)
            {
                if (((ArrayList)AnimIndexTable[listView1.SelectedItems[0]]).Count > 1)
                {
                    Object obj1 = ((ArrayList)AnimIndexTable[listView1.SelectedItems[0]])[src];
                    ((ArrayList)AnimIndexTable[listView1.SelectedItems[0]])[src] = ((ArrayList)AnimIndexTable[listView1.SelectedItems[0]])[dst];
                    ((ArrayList)AnimIndexTable[listView1.SelectedItems[0]])[dst] = obj1;

                    Object obj2 = ((ArrayList)AnimFlipTable[listView1.SelectedItems[0]])[src];
                    ((ArrayList)AnimFlipTable[listView1.SelectedItems[0]])[src] = ((ArrayList)AnimFlipTable[listView1.SelectedItems[0]])[dst];
                    ((ArrayList)AnimFlipTable[listView1.SelectedItems[0]])[dst] = obj2;
                }
            }
        }

        private ArrayList getFrame(int animate)
        {
            if (animate>=0 && animate < listView1.Items.Count)
            {
                return ((ArrayList)AnimIndexTable[listView1.Items[animate]]);
            }
            return null;
        }
        private ArrayList getFrameFlip(int animate)
        {
            if (animate >= 0 && animate < listView1.Items.Count)
            {
                return ((ArrayList)AnimFlipTable[listView1.Items[animate]]);
            }
            return null;
        }

        private void fillAnimate(int index)
        {
            for (int y = dstRect.Y; y < dstRect.Y + dstRect.Height;y+=CellH )
            {
                for (int x = dstRect.X; x < dstRect.X + dstRect.Width; x+=CellW)
                {
                    putAnimate(index,x/CellW,y/CellH);
                }
            }
        }
        private void fillTile(int index, int flip)
        {
            for (int y = dstRect.Y; y < dstRect.Y + dstRect.Height;y+=CellH )
            {
                for (int x = dstRect.X; x < dstRect.X + dstRect.Width; x+=CellW)
                {
                    putTile(index,x/CellW,y/CellH);
                    putFlip(flip, x / CellW, y / CellH);
                }
            }
        }
        private void fillTag(int index)
        {
            for (int y = dstRect.Y; y < dstRect.Y + dstRect.Height; y += CellH)
            {
                for (int x = dstRect.X; x < dstRect.X + dstRect.Width; x += CellW)
                {
                    putTag(index, x / CellW, y / CellH);
                }
            }
        }
        private void copyDst()
        {
            int sbx = dstRect.X / CellW;
            int sby = dstRect.Y / CellH;
            int xcount = dstRect.Width / CellW;
            int ycount = dstRect.Height / CellH;

            if (xcount <= 0 || ycount <= 0) return;

            dstClipTile = new int[ycount][];
            dstClipTag = new int[ycount][];
            dstClipAnim = new int[ycount][];
            dstClipFlip = new int[ycount][];
            for (int by = 0; by < ycount; by++)
            {
                dstClipTile[by] = new int[xcount];
                dstClipTag[by] = new int[xcount];
                dstClipAnim[by] = new int[xcount];
                dstClipFlip[by] = new int[xcount];
                for (int bx = 0; bx < xcount; bx++)
                {
                    if (sby + by < MatrixTile.Length && sbx + bx < MatrixTile[by].Length)
                    {
                        dstClipTile[by][bx] = MatrixTile[sby + by][sbx + bx];
                        dstClipTag[by][bx] = MatrixTag[sby + by][sbx + bx];
                        dstClipAnim[by][bx] = MatrixAnim[sby + by][sbx + bx];
                        dstClipFlip[by][bx] = MatrixFlip[sby + by][sbx + bx];
                    }
                }
            }
            
        }
        private void paseDst()
        {
           
            int sbx = dstRect.X / CellW;
            int sby = dstRect.Y / CellH;
            int xcount = dstRect.Width / CellW;
            int ycount = dstRect.Height / CellH;

            if (xcount <= 0 || ycount <= 0) return;

            for (int by = 0; by < ycount; by++)
            {
                for (int bx = 0; bx < xcount; bx++)
                {
                    putTile(
                        dstClipTile[by % dstClipTile.Length][bx % dstClipTile[by % dstClipTile.Length].Length], 
                        sbx + bx, sby + by);
                    putFlip(
                        dstClipFlip[by % dstClipFlip.Length][bx % dstClipFlip[by % dstClipFlip.Length].Length],
                        sbx + bx, sby + by);
                    putTag(
                        dstClipTag[by % dstClipTag.Length][bx % dstClipTag[by % dstClipTag.Length].Length], 
                        sbx + bx, sby + by);
                    putAnimate(
                        dstClipAnim[by % dstClipAnim.Length][bx % dstClipAnim[by % dstClipAnim.Length].Length], 
                        sbx + bx, sby + by);
                }
            }
        }


        private void putTile(int index, int bx, int by)
        {
            if (index < getTileCount() && by < MatrixTile.Length && bx < MatrixTile[by].Length)
            {
                MatrixTile[by][bx] = index;
            }
        }
        private void putTag(int tag, int bx, int by)
        {
            if (by < MatrixTag.Length && bx < MatrixTag[by].Length)
            {
                MatrixTag[by][bx] = tag;
            }
        }
        private void putAnimate(int index, int bx, int by)
        {
            if (by < MatrixAnim.Length && bx < MatrixAnim[by].Length)
            {
                if (toolStripButton22.Checked)
                {
                    MatrixAnim[by][bx] = -index;
                }
                else
                {
                    MatrixAnim[by][bx] = index;
                }
                
            }
        }
        private void putFlip(int flip, int bx, int by)
        {
            if (flip < 8 && by < MatrixFlip.Length && bx < MatrixFlip[by].Length)
            {
                MatrixFlip[by][bx] = flip;
            }
        }



        private void renderTile(Graphics g, int index, int flip, int x, int y)
        {
            if (getTileImage(index) != null && flip<flipTable.Length)
            {
                g.drawImage(getTileImage(index), x, y, flipTable[flip],0);
            }
            
        }
        private void renderTag(Graphics g, int type, int x, int y)
        {
            g.setColor(0xff, 0, 0, 0);
            switch (type)
            {
                case 0:
                    break;
                case 1:
                    g.drawRect(1 + x, 1 + y, CellW - 3, CellH - 3);
                    break;
                case 2:
                    g.drawLine(x, 1 + y, x + CellW - 1, 1 + y);
                    break;
                case 3:
                    g.drawLine(x, y + CellH - 1 - 1, x + CellW - 1, y + CellH - 1 - 1);
                    break;
                case 4:
                    g.drawLine(x + 1, y, x + 1, y + CellH - 1);
                    break;
                case 5:
                    g.drawLine(x + CellW - 1 - 1, y, x + CellW - 1 - 1, y + CellH - 1);
                    break;
                case 6:
                    g.drawLine(x, 1 + y, x + CellW - 1, 1 + y + CellH - 1);
                    break;
                case 7:
                    g.drawLine(x + CellW - 1, 1 + y, x, 1 + y + CellH - 1);
                    break;
            }
            g.setColor(0xff, 0xff, 0, 0);
            switch (type)
            {
                case 0:
                    break;
                case 1:
                    g.drawRect(x, y, CellW - 1, CellH - 1);
                    break;
                case 2:
                    g.drawLine(x, y, x + CellW - 1, y);
                    break;
                case 3:
                    g.drawLine(x, y + CellH - 1, x + CellW - 1, y + CellH - 1);
                    break;
                case 4:
                    g.drawLine(x, y, x, y + CellH - 1);
                    break;
                case 5:
                    g.drawLine(x + CellW - 1, y, x + CellW - 1, y + CellH - 1);
                    break;
                case 6:
                    g.drawLine(x, y, x + CellW - 1, y + CellH - 1);
                    break;
                case 7:
                    g.drawLine(x + CellW - 1, y, x, y + CellH - 1);
                    break;
            }

        }
        private void renderAnimate(Graphics g, int anim, int frame, int x, int y)
        {
            try
            {
                if (listView1.Items.Count <= 0) return;

                if (anim >= 0 && anim < listView1.Items.Count)
                {
                    ArrayList animate = (ArrayList)(AnimIndexTable[listView1.Items[anim]]);
                    ArrayList flips = (ArrayList)(AnimFlipTable[listView1.Items[anim]]);
                    if (animate.Count <= 0) return;
                    if (flips.Count <= 0) return;
                    renderTile(g,
                        (int)(animate[frame % animate.Count]),
                        (int)(flips[frame % flips.Count]),
                        x, y);
                }
            }
            catch (Exception err)
            {

            }
               
        }
        private void renderCombo(Graphics g, int anim, int x, int y)
        {
            if (listView1.Items.Count <= 0) return;

            ArrayList animate = (ArrayList)(AnimIndexTable[listView1.Items[anim]]);
            ArrayList flips = (ArrayList)(AnimFlipTable[listView1.Items[anim]]);
            if (animate.Count <= 0) return;
            if (flips.Count <= 0) return;
            for (int frame =  animate.Count - 1; frame >= 0; frame--)
            {
                renderTile(g,
                  (int)(animate[frame % animate.Count]),
                  (int)(flips[frame % flips.Count]),
                  x, y);
            }
           
        }

        private void renderSrc(Graphics g, int x, int y, System.Drawing.Rectangle screen)
        {
            for (int i = 0; i < getTileCount(); i++)
            {
                if (getTileImage(i) != null &&
                    screen.IntersectsWith(new System.Drawing.Rectangle(
                        x + getTileImage(i).x, 
                        y + getTileImage(i).y,
                        getTileImage(i).getWidth()+1,
                        getTileImage(i).getHeight()+1)
                    ))
                {
                    renderTile(g,i,0, x + getTileImage(i).x, y + getTileImage(i).y);
                }
            }
            if (srcIndex < getTileCount())
            {
                if (getTileImage(srcIndex) != null)
                {
                    renderTile(g, srcIndex, flipIndex, x + getTileImage(srcIndex).x, y + getTileImage(srcIndex).y);
                }
            }
        }
        private void renderDst(Graphics g, int x, int y, System.Drawing.Rectangle screen, Boolean grid, Boolean tag, Boolean anim,int timer)
        {
            int sx = (screen.X >= 0) ? (screen.X / CellW) : 0;
            int sy = (screen.Y >= 0) ? (screen.Y / CellH) : 0;
            int sw = (screen.Width / CellW + 2 );
            int sh = (screen.Height / CellH + 2 );

            //Console.WriteLine(" sx="+sx+" sy"+sy+" sw"+sw+" sh"+sh);

            for (int by = sy ; by < sy + sh && by < YCount; by++)
            {
                for (int bx = sx; bx < sx + sw && bx < XCount; bx++)
                {
                    
                    if (MatrixAnim[by][bx] > 0 && MatrixAnim[by][bx] < listView1.Items.Count)
                    {
                        renderAnimate(g, MatrixAnim[by][bx], anim ? timer : 0, x + bx * CellW, y + by * CellH);
                    }
                    else if (MatrixAnim[by][bx] < 0 && Math.Abs(MatrixAnim[by][bx]) < listView1.Items.Count)
                    {
                        renderCombo(g, Math.Abs(MatrixAnim[by][bx]), x + bx * CellW, y + by * CellH);
                    }
                    else if (MatrixTile[by][bx] >= 0 && MatrixTile[by][bx] < getTileCount())
                    {
                        renderTile(g,MatrixTile[by][bx],MatrixFlip[by][bx],x + bx * CellW,y + by * CellH);
                        
                    }
                    if (tag && MatrixTag[by][bx] != 0)
                    {
                        renderTag(g, MatrixTag[by][bx], x + bx * CellW, y + by * CellH);
                    }
                }
            }
       
            if (grid)
            {
                g.setColor(0x80, 0xff, 0xff, 0xff);
               
                for (int bx = sx; bx < sx + sw; bx++)
                {
                    g.drawLine(
                        x + bx * CellW, 
                        y + sy * CellH, 
                        x + bx * CellW, 
                        y + sy * CellH + sh * CellH);
                }
                for (int by = sy; by < sy + sh; by++)
                {
                    g.drawLine(
                        x + sx * CellW, 
                        y + by * CellH, 
                        x + sx * CellW + sw * CellW, 
                        y + by * CellH);
                }
            }
        }

        public void Render(Graphics g, int x, int y, System.Drawing.Rectangle screen, Boolean grid, Boolean tag, Boolean anim,int timer)
        {
            renderDst(g, x, y, screen, grid, tag, anim,timer);
        }

        // src
        private void pictureBox1_Paint(object sender, PaintEventArgs e)
        {
            for (int i = getTileCount() - 1; i >= 0; i--)
            {
                if (getTileImage(i)!=null)
                {
                    pictureBox1.Width = Math.Max(
                        pictureBox1.Width,
                        getTileImage(i).x + getTileImage(i).getWidth()
                        );
                    pictureBox1.Height = Math.Max(
                        pictureBox1.Height,
                        getTileImage(i).y + getTileImage(i).getHeight()
                        );
                    //break;
                }
            }
                

            Graphics g = new Graphics(e.Graphics);


            renderSrc(g, 0, 0 ,
                new System.Drawing.Rectangle(
                    - pictureBox1.Location.X,
                    - pictureBox1.Location.Y,
                    panel3.Width,
                    panel3.Height
                )
            );

            System.Drawing.Pen pen = new System.Drawing.Pen(System.Drawing.Color.FromArgb(0xFF, 0xFF, 0xFF, 0xFF));
            System.Drawing.Brush brush = new System.Drawing.Pen(System.Drawing.Color.FromArgb(0x80, 0xff, 0xff, 0xff)).Brush;

            e.Graphics.FillRectangle(brush, srcRect);
            e.Graphics.DrawRectangle(pen, srcRect.X, srcRect.Y, srcRect.Width - 1, srcRect.Height - 1);
        }
        private void pictureBox1_MouseDown(object sender, MouseEventArgs e)
        {
            if (e.Button == MouseButtons.Left)
            {
                System.Drawing.Rectangle dst = new System.Drawing.Rectangle(0, 0, 1, 1);
                for (int i = 0; i < getTileCount(); i++)
                {
                    if (getTileImage(i) != null)
                    {
                        dst.X = getTileImage(i).x;
                        dst.Y = getTileImage(i).y;
                        dst.Width = getTileImage(i).getWidth();
                        dst.Height = getTileImage(i).getHeight();

                        if (dst.Contains(e.X, e.Y))
                        {

                            srcRect = dst;
                            srcIndex = i;
                            srcImage = getTileImage(i);

                            toolStripLabel1.Text =
                                "第" + i + "号" +
                                " 宽：" + getTileImage(i).getWidth() +
                                " 高：" + getTileImage(i).getHeight();

                            pictureBox1.Refresh();
                            break;
                        }
                    }
                }
            }
        }
        private void toolStripMenuItem10_Click(object sender, EventArgs e)
        {
            try
            {
                if (!sender.Equals(toolStripMenuItem10)) toolStripMenuItem10.Checked = false;
                if (!sender.Equals(toolStripMenuItem11)) toolStripMenuItem11.Checked = false;
                if (!sender.Equals(toolStripMenuItem12)) toolStripMenuItem12.Checked = false;
                if (!sender.Equals(toolStripMenuItem13)) toolStripMenuItem13.Checked = false;
                if (!sender.Equals(toolStripMenuItem14)) toolStripMenuItem14.Checked = false;
                if (!sender.Equals(toolStripMenuItem15)) toolStripMenuItem15.Checked = false;
                if (!sender.Equals(toolStripMenuItem16)) toolStripMenuItem16.Checked = false;
                if (!sender.Equals(toolStripMenuItem17)) toolStripMenuItem17.Checked = false;

                ((ToolStripMenuItem)sender).Checked = true;
                toolStripDropDownButton3.Image = ((ToolStripMenuItem)sender).Image;

                //
                if (sender.Equals(toolStripMenuItem10)) flipIndex = 0;
                if (sender.Equals(toolStripMenuItem11)) flipIndex = 1;
                if (sender.Equals(toolStripMenuItem12)) flipIndex = 2;
                if (sender.Equals(toolStripMenuItem13)) flipIndex = 3;
                if (sender.Equals(toolStripMenuItem14)) flipIndex = 4;
                if (sender.Equals(toolStripMenuItem15)) flipIndex = 5;
                if (sender.Equals(toolStripMenuItem16)) flipIndex = 6;
                if (sender.Equals(toolStripMenuItem17)) flipIndex = 7;

                pictureBox1.Refresh();
            }
            catch (Exception err)
            {
            }
        }
        
        // dst
        private void toolStriptoolStripButton_Clicked(object sender, EventArgs e)
        {
            try
            {
                dstRect.X = dstPX / CellW * CellW;
                dstRect.Y = dstPY / CellH * CellH;
                dstRect.Width = 0;
                dstRect.Height = 0;

                    if (!sender.Equals(toolStripButton8)) toolStripButton8.Checked = false;
                    if (!sender.Equals(toolStripButton9)) toolStripButton9.Checked = false;
                    if (!sender.Equals(toolStripButton10)) toolStripButton10.Checked = false;
                    if (!sender.Equals(toolStripButton17)) toolStripButton17.Checked = false;

                    ((ToolStripButton)sender).Checked = true;

                //
                    if (sender.Equals(toolStripButton8))
                    {
                        toolStripDropDownButton2.Enabled = true;
                    }
                    else
                    {
                        toolStripDropDownButton2.Enabled = false;
                    }
                    //if (sender.Equals(toolStripButton10))
                    //{
                    //    toolStripDropDownButton1.Enabled = true;
                    //}
                    //else
                    //{
                    //    toolStripDropDownButton1.Enabled = false;
                    //}

                pictureBox2.Refresh();
            }
            catch (Exception err)
            {
            }

        }
        private void toolStripMenuItem2_Click(object sender, EventArgs e)
        {
            try
            {
                if (!sender.Equals(toolStripMenuItem2)) toolStripMenuItem2.Checked = false;
                if (!sender.Equals(toolStripMenuItem3)) toolStripMenuItem3.Checked = false;
                if (!sender.Equals(toolStripMenuItem4)) toolStripMenuItem4.Checked = false;
                if (!sender.Equals(toolStripMenuItem5)) toolStripMenuItem5.Checked = false;
                if (!sender.Equals(toolStripMenuItem6)) toolStripMenuItem6.Checked = false;
                if (!sender.Equals(toolStripMenuItem7)) toolStripMenuItem7.Checked = false;
                if (!sender.Equals(toolStripMenuItem8)) toolStripMenuItem8.Checked = false;
                if (!sender.Equals(toolStripMenuItem9)) toolStripMenuItem9.Checked = false;

                ((ToolStripMenuItem)sender).Checked = true;
                toolStripDropDownButton1.Image = ((ToolStripMenuItem)sender).Image;

                //
                if (sender.Equals(toolStripMenuItem2)) tagIndex = 0;
                if (sender.Equals(toolStripMenuItem3)) tagIndex = 1;
                if (sender.Equals(toolStripMenuItem4)) tagIndex = 2;
                if (sender.Equals(toolStripMenuItem5)) tagIndex = 3;
                if (sender.Equals(toolStripMenuItem6)) tagIndex = 4;
                if (sender.Equals(toolStripMenuItem7)) tagIndex = 5;
                if (sender.Equals(toolStripMenuItem8)) tagIndex = 6;
                if (sender.Equals(toolStripMenuItem9)) tagIndex = 7;
            }
            catch (Exception err)
            {
            }

            
        }
        private void toolStripButton13_Click(object sender, EventArgs e)
        {
            if (Cell.Util.stringIsDigit(toolStripTextBox1.Text, 0, toolStripTextBox1.Text.Length) >= toolStripTextBox1.Text.Length &&
                Cell.Util.stringDigitToInt(toolStripTextBox1.Text, 0, toolStripTextBox1.Text.Length) >= 1)
            {
                XCount = Cell.Util.stringDigitToInt(toolStripTextBox1.Text, 0, toolStripTextBox1.Text.Length);
            }
            else
            {
                MessageBox.Show("只能输入大于0的数字！");
                toolStripTextBox1.Focus();
                return;
            }
    
            if (Cell.Util.stringIsDigit(toolStripTextBox2.Text, 0, toolStripTextBox2.Text.Length) >= toolStripTextBox2.Text.Length &&
                Cell.Util.stringDigitToInt(toolStripTextBox2.Text, 0, toolStripTextBox2.Text.Length) >= 1)
            {
                YCount = Cell.Util.stringDigitToInt(toolStripTextBox2.Text, 0, toolStripTextBox2.Text.Length);
            }
            else
            {
                MessageBox.Show("只能输入大于0的数字！");
                toolStripTextBox2.Focus();
                return;
            }


            if(YCount!=MatrixTile.Length || XCount!=MatrixTile[0].Length)
            {
                int[][] matrixTile = new int[YCount][];
                int[][] matrixTag = new int[YCount][];
                int[][] matrixAnim = new int[YCount][];
                int[][] matrixFlip = new int[YCount][];
                for (int y = 0; y < YCount; y++)
                {
                    matrixTile[y] = new int[XCount];
                    matrixTag[y] = new int[XCount];
                    matrixAnim[y] = new int[XCount];
                    matrixFlip[y] = new int[XCount];
                    for (int x = 0; x < XCount; x++)
                    {
                        if(y<MatrixTile.Length && x<MatrixTile[y].Length)
                        {
                            matrixTile[y][x] = MatrixTile[y][x];
                            matrixTag[y][x] = MatrixTag[y][x];
                            matrixAnim[y][x] = MatrixAnim[y][x];
                            matrixFlip[y][x] = MatrixFlip[y][x];
                        }
                    }
                }

                MatrixTile = matrixTile;
                MatrixTag = matrixTag;
                MatrixAnim = matrixAnim;
                MatrixFlip = matrixFlip;

                pictureBox2.Width = CellW * XCount;
                pictureBox2.Height = CellH * YCount;
            }
        }
        private void toolStripButton11_Click(object sender, EventArgs e)
        {
            pictureBox2.Refresh();
        }

        private void 填充ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            fillTile(srcIndex,flipIndex);
            
        }
        private void 填充当前动画ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            fillAnimate(curAnimate);
        }
        private void 填充当前地形ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            fillTag(tagIndex);
        }
        private void 复制ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            copyDst();
        }
        private void 粘贴ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            paseDst();
        }

        private void pictureBox2_Paint(object sender, PaintEventArgs e)
        {
            Graphics g = new Graphics(e.Graphics);



            renderDst(g, 0, 0, 
                new System.Drawing.Rectangle(
                    - pictureBox2.Location.X,
                    - pictureBox2.Location.Y,
                    panel2.Width,
                    panel2.Height
                ),
                toolStripButton11.Checked, 
                toolStripButton12.Checked || toolStripButton10.Checked,
                toolStripButton14.Checked,
                curTime
                );



            System.Drawing.Pen pen = new System.Drawing.Pen(System.Drawing.Color.FromArgb(0x80, 0xff, 0xff, 0xff));
            System.Drawing.Brush brush = new System.Drawing.Pen(System.Drawing.Color.FromArgb(0x40, 0xff, 0xff, 0xff)).Brush;


            if (toolStripButton8.Checked)
            {
                e.Graphics.FillRectangle(brush, dstRect);
                e.Graphics.DrawRectangle(pen, dstRect.X, dstRect.Y, dstRect.Width - 1, dstRect.Height - 1);
            }


            
            if (toolStripButton9.Checked)
            {
                //renderTile(g, srcIndex, flipIndex, dstQX / CellW * CellW, dstQY / CellH * CellH);

                System.Drawing.Pen lpen = new System.Drawing.Pen(System.Drawing.Color.FromArgb(0xff, 0, 0, 0));
                //e.Graphics.FillRectangle(brush, dstQX / CellW * CellW, dstQY / CellH * CellH, CellW, CellH);
                e.Graphics.DrawRectangle(lpen, dstQX / CellW * CellW, dstQY / CellH * CellH, CellW - 1, CellH - 1);
            }
            if (toolStripButton10.Checked)
            {
                //renderTag(g,tagIndex,dstQX / CellW * CellW, dstQY / CellH * CellH);

                System.Drawing.Pen lpen = new System.Drawing.Pen(System.Drawing.Color.FromArgb(0xff, 0xff, 0, 0));
                //e.Graphics.FillRectangle(brush, dstQX / CellW * CellW, dstQY / CellH * CellH, CellW, CellH);
                e.Graphics.DrawRectangle(lpen, dstQX / CellW * CellW, dstQY / CellH * CellH, CellW - 1, CellH - 1);
            }
            if (toolStripButton17.Checked)
            {

                //if (curAnimate >= 0)
                //{
                //    if (toolStripButton22.Checked)
                //    {
                //        renderCombo(g, curAnimate, dstQX / CellW * CellW, dstQY / CellH * CellH);
                //    }
                //    else
                //    {
                //        renderAnimate(g, curAnimate, 0, dstQX / CellW * CellW, dstQY / CellH * CellH);
                //    }
                //}
                System.Drawing.Pen lpen = new System.Drawing.Pen(System.Drawing.Color.FromArgb(0xff, 0, 0, 0xff));
                //e.Graphics.FillRectangle(brush, dstQX / CellW * CellW, dstQY / CellH * CellH, CellW, CellH);
                e.Graphics.DrawRectangle(lpen, dstQX / CellW * CellW, dstQY / CellH * CellH, CellW - 1, CellH - 1);
            }

           // Console.WriteLine(""+pictureBox2.Location.Y);
        }

        private void pictureBox2_MouseLeave(object sender, EventArgs e)
        {
            toolStripStatusLabel1.Text = "地图";
        }
        private void pictureBox2_MouseMove(object sender, MouseEventArgs e)
        {
            dstQX = e.X < 0 ? 0 : (e.X > pictureBox2.Width - 1 ? pictureBox2.Width - 1 : e.X);
            dstQY = e.Y < 0 ? 0 : (e.Y > pictureBox2.Height - 1 ? pictureBox2.Height - 1 : e.Y);

            toolStripStatusLabel1.Text =
                           "格:" + dstQX / CellW + "," + dstQY / CellH
                       ;
            if (toolStripButton8.Checked)
            {
                if (dstIsDown)
                {
                    int l = Math.Min(dstPX, dstQX) / CellW;
                    int r = Math.Max(dstPX, dstQX) / CellW;
                    int t = Math.Min(dstPY, dstQY) / CellH;
                    int b = Math.Max(dstPY, dstQY) / CellH;

                    dstRect.X = l * CellW;
                    dstRect.Y = t * CellH;
                    dstRect.Width = (r - l + 1) * CellW;
                    dstRect.Height = (b - t + 1) * CellH;

                    toolStripStatusLabel1.Text += " 选择:" + (r - l + 1) + "x" + (b - t + 1) + "格";
                }
            }

            if (e.Button == MouseButtons.Left)
            {
               
                if (toolStripButton9.Checked)
                {
                    putTile(srcIndex, dstQX / CellW, dstQY / CellH);
                    putFlip(flipIndex, dstQX / CellW, dstQY / CellH);
                }
                if (toolStripButton10.Checked)
                {
                    putTag(tagIndex, dstQX / CellW, dstQY / CellH);
                }
                if (toolStripButton17.Checked)
                {
                    putAnimate(curAnimate, dstQX / CellW, dstQY / CellH);
                }
            }
            if (e.Button == MouseButtons.Right)
            {
                if (toolStripButton9.Checked)
                {

                }
                if (toolStripButton10.Checked)
                {
                    putTag(0, e.X / CellW, e.Y / CellH);
                }
                if (toolStripButton17.Checked)
                {
                    putAnimate(0, e.X / CellW, e.Y / CellH);
                }
            }
            pictureBox2.Refresh();
        }
        private void pictureBox2_MouseDown(object sender, MouseEventArgs e)
        {
            if (e.Button == MouseButtons.Left)
            {
                dstPX = e.X;
                dstPY = e.Y;
                dstQX = e.X;
                dstQY = e.Y;

                if (toolStripButton8.Checked)
                {
                    dstRect.X = dstPX / CellW * CellW;
                    dstRect.Y = dstPY / CellH * CellH;
                    dstRect.Width = 0;
                    dstRect.Height = 0;
                }

                dstIsDown = true;
            }
            if (e.Button == MouseButtons.Left)
            {
                if (toolStripButton8.Checked)
                {
                    if (dstIsDown)
                    {
                        //toolStripDropDownButton2.
                       
                    }
                }
            }

            if (e.Button == MouseButtons.Left)
            {

                if (toolStripButton9.Checked)
                {
                    putTile(srcIndex, dstPX / CellW, dstPY / CellH);
                    putFlip(flipIndex, dstPX / CellW, dstPY / CellH);
                }
                if (toolStripButton10.Checked)
                {
                    putTag(tagIndex, dstPX / CellW, dstPY / CellH);
                }
                if (toolStripButton17.Checked)
                {
                    putAnimate(curAnimate, dstPX / CellW, dstPY / CellH);
                }

                
            }
            if (e.Button == MouseButtons.Right)
            {
                if (toolStripButton9.Checked)
                {
                    
                }
                if (toolStripButton10.Checked)
                {
                    putTag(0, e.X / CellW, e.Y / CellH);
                }
                if (toolStripButton17.Checked)
                {
                    putAnimate(0, e.X / CellW, e.Y / CellH);
                }

            }
            
            pictureBox2.Refresh();
        }
        private void pictureBox2_MouseUp(object sender, MouseEventArgs e)
        {
            if (dstIsDown)
            {
                dstQX = e.X;
                dstQY = e.Y;
                dstIsDown = false;
            }
            pictureBox2.Refresh();
        }
        //minimap
        private void toolStripButton23_Click(object sender, EventArgs e)
        {
            System.Drawing.Image image = new System.Drawing.Bitmap(getWidth(),getHeight());
            System.Drawing.Graphics dg = System.Drawing.Graphics.FromImage(image);
            Render(new Graphics(dg), 0, 0, new System.Drawing.Rectangle(0, 0, getWidth(), getHeight()), false, false, false, 0);

            MapMini mini = new MapMini(image);
            mini.Show();
        }

        //animate
        private void toolStripButton15_Click(object sender, EventArgs e)
        {
            addAnimate();
        }
        private void toolStripButton16_Click(object sender, EventArgs e)
        {
            delAnimate();
        }

        private void timer1_Tick(object sender, EventArgs e)
        {
            if (!this.Visible) return;

            if (toolStripButton5.Checked)
            {
                if (trackBar1.Value < trackBar1.Maximum)
                {
                    trackBar1.Value++;
                }
                else
                {
                    trackBar1.Value = trackBar1.Minimum;
                }
            }
            if (getFrame(curAnimate) != null)
            {
                curFrame = trackBar1.Value;
            }
            
            if (toolStripButton14.Checked)
            {
                pictureBox2.Refresh();
            }
            pictureBox3.Refresh();

            pictureBox4.Width = trackBar1.Maximum * CellW + CellW;
            //pictureBox4.Width = trackBar1.Maximum * CellW + CellW;

            timer1.Interval = (int)numericUpDown1.Value;

            toolStripStatusLabel2.Text = 
                " 帧：" + (trackBar1.Value + 1) + "/" + (trackBar1.Maximum + 1) +
                " FPS="+(((float)1000)/((float)timer1.Interval));

            curTime++;
        }

        private void listView1_ItemActivate(object sender, EventArgs e)
        {

        }
        private void listView1_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (listView1.SelectedItems != null && listView1.SelectedItems.Count > 0)
            {
                curAnimate = listView1.Items.IndexOf(listView1.SelectedItems[0]);
                toolStripStatusLabel3.Text = "动画："+curAnimate.ToString();
                curFrame = 0;

                trackBar1.Maximum = getFrame(curAnimate).Count - 1;
                trackBar1.Value = 0;
            }
            pictureBox4.Refresh();
            
        }
        private void toolStripButton1_Click(object sender, EventArgs e)
        {
            if (getFrame(curAnimate) != null)
            {
                addFrame(curFrame,srcIndex,flipIndex);
                curFrame = getFrame(curAnimate).Count - 1;

                trackBar1.Maximum = getFrame(curAnimate).Count - 1;
                trackBar1.Value = trackBar1.Maximum;
            }
           
        }
        private void toolStripButton2_Click(object sender, EventArgs e)
        {
            if (getFrame(curAnimate) != null)
            {
                delFrame(curFrame);
                curFrame = Math.Min(curFrame, getFrame(curAnimate).Count - 1);
                trackBar1.Maximum = getFrame(curAnimate).Count - 1;
                trackBar1.Value = trackBar1.Maximum;
            }
        }
        
        private void pictureBox3_Paint(object sender, PaintEventArgs e)
        {
            Graphics g = new Graphics(e.Graphics);
            if (toolStripButton22.Checked)
            {
                if (curAnimate >= 0)
                {
                    renderCombo(g, curAnimate, 0, 0);
                }
            }
            else
            {
                if (curAnimate >= 0 && curFrame >= 0)
                {
                    renderAnimate(g, curAnimate, curFrame, 0, 0);
                }
            }

        }


        private void toolStripButton3_Click(object sender, EventArgs e)
        {
            if (getFrame(curAnimate) != null)
            {
                trackBar1.Value = trackBar1.Minimum;
            }
            
        }
        private void toolStripButton4_Click(object sender, EventArgs e)
        {
            if (getFrame(curAnimate) != null)
            {
                if (trackBar1.Value > trackBar1.Minimum)
                {
                    trackBar1.Value -= 1;
                }
                else
                {
                    trackBar1.Value = trackBar1.Maximum;
                }
                
            }
        }
        private void toolStripButton5_Click(object sender, EventArgs e)
        {

        }
        private void toolStripButton6_Click(object sender, EventArgs e)
        {
            if (getFrame(curAnimate) != null)
            {
                if (trackBar1.Value < trackBar1.Maximum)
                {
                    trackBar1.Value += 1;
                }
                else
                {
                    trackBar1.Value = trackBar1.Minimum;
                }
            }
        }
        private void toolStripButton7_Click(object sender, EventArgs e)
        {
            if (getFrame(curAnimate) != null)
            {
                trackBar1.Value = trackBar1.Maximum;
            }
            
        }

        private void toolStripButton19_Click(object sender, EventArgs e)
        {
            if(trackBar1.Value>trackBar1.Minimum){
                exchangeFrame(trackBar1.Value, trackBar1.Value-1);
                trackBar1.Value = trackBar1.Value - 1;
            }
        }
        private void toolStripButton18_Click(object sender, EventArgs e)
        {
            if (trackBar1.Value < trackBar1.Maximum)
            {
                exchangeFrame(trackBar1.Value, trackBar1.Value + 1);
                trackBar1.Value = trackBar1.Value + 1;
            }
        }

        private void toolStripButton20_Click(object sender, EventArgs e)
        {
            if (curAnimate > 1)
            {
                exchangeAnimate(curAnimate, curAnimate-1);
            }
        }
        private void toolStripButton21_Click(object sender, EventArgs e)
        {
            if (curAnimate < listView1.Items.Count - 1 && curAnimate > 0)
            {
                exchangeAnimate(curAnimate, curAnimate + 1);
            }
        }

        private void trackBar1_Scroll(object sender, EventArgs e)
        {
            
        }
        private void trackBar1_ValueChanged(object sender, EventArgs e)
        {
            pictureBox4.Refresh();
        }

        private void pictureBox4_Paint(object sender, PaintEventArgs e)
        {
            Graphics g = new Graphics(e.Graphics);

            for (int i = trackBar1.Minimum; i <= trackBar1.Maximum; i++)
            {
                renderAnimate(g, curAnimate, i, CellW * i, 0);

                if (trackBar1.Value == i)
                {
                    g.setColor(0x20, 0xff, 0xff, 0xff);
                    g.fillRect(CellW * i, 0, CellW - 1, CellW - 1);
                    g.setColor(0xff, 0, 0, 0);
                    g.drawRect(CellH * i, 0, CellH - 1, CellH - 1);
                }
            }
            
        }
        private void pictureBox4_MouseDown(object sender, MouseEventArgs e)
        {
            if (e.Button == MouseButtons.Left)
            {
                if (getFrame(curAnimate) != null)
                {
                    trackBar1.Value = e.X / CellW;
                }
            }
        }

  



   
   


     

    }

    class Animates 
    {

        ArrayList Frames = new ArrayList();

        public ArrayList SubPart = new ArrayList();
        public ArrayList SubFlip = new ArrayList();

        public Animates()
        {
           
        }

        public void frameAdd(ArrayList frame)
        {
            Frames.Add(frame);
        }

        public int frameGetCount()
        {
            return Frames.Count;
        }

        public int frameIndexOf(ArrayList frame)
        {
            for (int i = 0; i < Frames.Count;i++ )
            {
                if (Frames[i].Equals(frame))return i;

                if (((ArrayList)Frames[i]).Count != frame.Count) continue;

                Boolean ok = true;

                for (int j = 0; j < frame.Count;j++ )   
                {
                    if (((int)((ArrayList)Frames[i])[j]) != ((int)frame[j]))
                    {
                        ok = false;
                        break;
                    }
                }

                if (ok) return i;
            }

            return -1;
        }

        public ArrayList frameGetFrame(int index)
        {
            return (ArrayList)(Frames[index]);
        }

        public void subAdd(int part, int flip)
        {
            SubPart.Add(part);
            SubFlip.Add(flip);
        }

        public int subGetCount()
        {
            return SubPart.Count;
        }

        public int subIndexOf(int part, int flip)
        {
            if (!SubPart.Contains(part)) return -1;
            if (!SubFlip.Contains(flip)) return -1;

            for(int i=0;i<subGetCount();i++)
            {
                int p1 = SubPart.IndexOf(part, i, 1);
                int p2 = SubFlip.IndexOf(flip, i, 1);
                if (p1>=0 && p2>=0 && p1==p2)
                {
                    return i;
                }
            }
            return -1;
        }

    }
}
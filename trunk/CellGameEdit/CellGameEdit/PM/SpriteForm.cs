using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;

using System.Text;
using System.Windows.Forms;
using System.Runtime.Serialization;
using System.Runtime.Serialization.Formatters;
using System.Security.Permissions;
using System.Collections;

using javax.microedition.lcdui;

namespace CellGameEdit.PM
{



    [Serializable]
    public partial class SpriteForm : Form, ISerializable 
    {
        public String id;

        public ImagesForm super;

        //Hashtable Frames;
        Hashtable AnimTable;
        int animCount;

        //[NoneSerializable]
        ArrayList srcTiles;
        int srcIndex = 0;
        Image srcImage;
        System.Drawing.Rectangle srcRect;

        static public int[] flipTableJ2me = new int[]{
            Cell.Game.CImages.TRANS_NONE,
            Cell.Game.CImages.TRANS_90,
            Cell.Game.CImages.TRANS_180,
            Cell.Game.CImages.TRANS_270,

            Cell.Game.CImages.TRANS_H,
            Cell.Game.CImages.TRANS_H90,
            Cell.Game.CImages.TRANS_V,
            Cell.Game.CImages.TRANS_V90,

        };


        //ArrayList curFrames;
        //Frame curFrame;

        public SpriteForm(String name,ImagesForm images)
        {
            InitializeComponent();
            pictureBox2.Image = new System.Drawing.Bitmap(pictureBox2.Width, pictureBox2.Height);

            id = name;
            super = images;

            srcRect = new System.Drawing.Rectangle(0, 0, 0, 0);
            //dstRect = new System.Drawing.Rectangle(0, 0, 0, 0);

            srcTiles = super.dstImages;
            for (int i = 0; i < srcGetCount(); i++)
            {
                if (srcGetImage(i) != null)
                {
                    srcIndex = i;
                    srcImage = srcGetImage(i);
                    srcRect.X = srcGetImage(i).x;
                    srcRect.Y = srcGetImage(i).y;
                    srcRect.Width = srcGetImage(i).getWidth();
                    srcRect.Height = srcGetImage(i).getHeight();
                    break;
                }
            }

            

            AnimTable = new Hashtable();
            animCount = 0;

            
        }
        [SecurityPermissionAttribute(SecurityAction.Demand, SerializationFormatter = true)]
        protected SpriteForm(SerializationInfo info, StreamingContext context)
        {
            InitializeComponent();
            pictureBox2.Image = new System.Drawing.Bitmap(pictureBox2.Width, pictureBox2.Height);

            try
            {
                id = (String)info.GetValue("id", typeof(String));
                super = (ImagesForm)info.GetValue("super", typeof(ImagesForm));

                srcRect = new System.Drawing.Rectangle(0, 0, 0, 0);
                //dstRect = new System.Drawing.Rectangle(0, 0, 0, 0);

                srcTiles = super.dstImages;
                for (int i = 0; i < srcGetCount(); i++)
                {
                    if (srcGetImage(i) != null)
                    {
                        srcIndex = i;
                        srcImage = srcGetImage(i);
                        srcRect.X = srcGetImage(i).x;
                        srcRect.Y = srcGetImage(i).y;
                        srcRect.Width = srcGetImage(i).getWidth();
                        srcRect.Height = srcGetImage(i).getHeight();
                        break;
                    }
                }
                animCount = (int)info.GetValue("animCount", typeof(int));
                ArrayList Animates = (ArrayList)info.GetValue("Animates", typeof(ArrayList));
                ArrayList AniNames = (ArrayList)info.GetValue("AniNames", typeof(ArrayList));

                AnimTable = new Hashtable();
               
                for (int i = 0; i < Animates.Count; i++)
                {
                    try
                    {
                        ArrayList frames = (ArrayList)Animates[i];
                        String name = (String)AniNames[i];
                        ListViewItem item = new ListViewItem(new String[] { name, frames.Count.ToString("d") });
                        listView2.Items.Add(item);
                        AnimTable.Add(item, frames);
                       
                    }
                    catch (Exception err)
                    {
                        Console.WriteLine(this.id + " : " + err.Message);
                    }
                   
                }
               
            }
            catch (Exception err)
            {
                MessageBox.Show(err.Message);
            }
           

        }
        [SecurityPermissionAttribute(SecurityAction.Demand, SerializationFormatter = true)]
        public virtual void GetObjectData(SerializationInfo info, StreamingContext context)
        {
            try
            {
                info.AddValue("id",id);
                info.AddValue("super", super);
                info.AddValue("animCount", animCount);

                ArrayList Animates = new ArrayList();
                ArrayList AniNames = new ArrayList();
                foreach (ListViewItem item in listView2.Items)
                {
                    if (item != null)
                    {
                        try
                        {
                            Animates.Add((ArrayList)AnimTable[item]);
                            AniNames.Add(item.Text);
                        }
                        catch (Exception err)
                        {
                            Console.WriteLine(this.id + " : " + err.Message);
                        }
                    }
                }
                info.AddValue("Animates", Animates);
                info.AddValue("AniNames", AniNames);
            }
            catch (Exception err)
            {
                MessageBox.Show(err.Message);
            }
        }


        Frame AllFrame ;
        Group animates ;
        Group collides ;
        int[][] frameAnimate ;
        int[][] frameCDMap ;
        int[][] frameCDAtk ;
        int[][] frameCDDef ;
        int[][] frameCDExt ;

        public void initOutput()
        {

            AllFrame = new Frame();
            animates = new Group();
            collides = new Group();
            frameAnimate = new int[listView2.Items.Count][];
            frameCDMap = new int[listView2.Items.Count][];
            frameCDAtk = new int[listView2.Items.Count][];
            frameCDDef = new int[listView2.Items.Count][];
            frameCDExt = new int[listView2.Items.Count][];

            for (int animID = 0; animID < listView2.Items.Count; animID++)//anim
            {
                int FrameCount = ((ArrayList)AnimTable[listView2.Items[animID]]).Count;
                frameAnimate[animID] = new int[FrameCount];
                frameCDMap[animID] = new int[FrameCount];
                frameCDAtk[animID] = new int[FrameCount];
                frameCDDef[animID] = new int[FrameCount];
                frameCDExt[animID] = new int[FrameCount];

                for (int frameID = 0; frameID < FrameCount; frameID++)// frame
                {
                    Frame frame = (Frame)(((ArrayList)AnimTable[listView2.Items[animID]])[frameID]);

                    // sub
                    ArrayList fAnimate = new ArrayList();

                    for (int subID = 0; subID < frame.getSubCount(); subID++)
                    {
                        int indexSub = AllFrame.indexOfSub(
                            (int)frame.SubIndex[subID],
                            (int)frame.SubX[subID],
                            (int)frame.SubY[subID],
                            (int)frame.SubW[subID],
                            (int)frame.SubH[subID],
                            (int)frame.SubFlip[subID]);
                        if (indexSub < 0)
                        {
                            AllFrame.addSub(null,
                                (int)frame.SubIndex[subID],
                                (int)frame.SubX[subID],
                                (int)frame.SubY[subID],
                                (int)frame.SubW[subID],
                                (int)frame.SubH[subID],
                                (int)frame.SubFlip[subID]);
                            indexSub = AllFrame.getSubCount() - 1;
                        }
                        fAnimate.Add(indexSub);
                    }

                    int indexAnimate = animates.frameIndexOf(fAnimate);
                    if (indexAnimate < 0)
                    {
                        animates.frameAdd(fAnimate);
                        indexAnimate = animates.frameGetCount() - 1;
                    }

                    frameAnimate[animID][frameID] = indexAnimate;

                    // cd
                    ArrayList fCDMap = new ArrayList();
                    ArrayList fCDAtk = new ArrayList();
                    ArrayList fCDDef = new ArrayList();
                    ArrayList fCDExt = new ArrayList();

                    for (int cdID = 0; cdID < frame.getCDCount(); cdID++)
                    {
                        int indexCD = AllFrame.indexOfCD(
                            (int)frame.CDMask[cdID],
                            (int)frame.CDX[cdID],
                            (int)frame.CDY[cdID],
                            (int)frame.CDW[cdID],
                            (int)frame.CDH[cdID]);
                        if (indexCD < 0)
                        {
                            AllFrame.addCD(null,
                                (int)frame.CDMask[cdID],
                                (int)frame.CDX[cdID],
                                (int)frame.CDY[cdID],
                                (int)frame.CDW[cdID],
                                (int)frame.CDH[cdID],
                                (int)frame.CDType[cdID]);
                            indexCD = AllFrame.getCDCount() - 1;
                        }
                        switch ((int)frame.CDType[cdID])
                        {
                            case Frame.CD_TYPE_MAP: fCDMap.Add(indexCD);
                                break;
                            case Frame.CD_TYPE_ATK: fCDAtk.Add(indexCD);
                                break;
                            case Frame.CD_TYPE_DEF: fCDDef.Add(indexCD);
                                break;
                            case Frame.CD_TYPE_EXT: fCDExt.Add(indexCD);
                                break;
                        }
                    }
                    // map
                    int indexCDMap = collides.frameIndexOf(fCDMap);
                    if (indexCDMap < 0)
                    {
                        collides.frameAdd(fCDMap);
                        indexCDMap = collides.frameGetCount() - 1;
                    }
                    // atk
                    int indexCDAtk = collides.frameIndexOf(fCDAtk);
                    if (indexCDAtk < 0)
                    {
                        collides.frameAdd(fCDAtk);
                        indexCDAtk = collides.frameGetCount() - 1;
                    }
                    // def
                    int indexCDDef = collides.frameIndexOf(fCDDef);
                    if (indexCDDef < 0)
                    {
                        collides.frameAdd(fCDDef);
                        indexCDDef = collides.frameGetCount() - 1;
                    }
                    // ext
                    int indexCDExt = collides.frameIndexOf(fCDExt);
                    if (indexCDExt < 0)
                    {
                        collides.frameAdd(fCDExt);
                        indexCDExt = collides.frameGetCount() - 1;
                    }

                    frameCDMap[animID][frameID] = indexCDMap;
                    frameCDAtk[animID][frameID] = indexCDAtk;
                    frameCDDef[animID][frameID] = indexCDDef;
                    frameCDExt[animID][frameID] = indexCDExt;
                }
            }
        }

        public void Output(System.IO.StringWriter sw)
        {

            initOutput();



            //sw.WriteLine("class " + super.id + "_" + this.id + " extends CSprite {");// class


            sw.WriteLine("final static public CSprite createSprite_" + super.id + "_" + this.id + "(IImages tiles)");
            sw.WriteLine("{");
            // animates
            sw.WriteLine("    CAnimates animates = new CAnimates(" + AllFrame.getSubCount() + ",tiles);");
        for (int i = 0; i < AllFrame.getSubCount(); i++)
            sw.WriteLine("    animates.addPart(" + (int)AllFrame.SubX[i] + "," + (int)AllFrame.SubY[i] + "," + (int)AllFrame.SubIndex[i] + "," + flipTableJ2me[(int)(AllFrame.SubFlip[i])] + ");");
            sw.WriteLine("    animates.setFrame(new int[" + animates.frameGetCount() + "][]);");
        for (int i = 0; i < animates.frameGetCount(); i++)
            sw.WriteLine("    animates.setComboFrame(new int[]{" + Util.toTextArray((int[])(animates.frameGetFrame(i).ToArray(typeof(int)))) + "}," + i + ");");
            sw.WriteLine();
            // collides
            sw.WriteLine("    CCollides collides = new CCollides(" + AllFrame.getCDCount() + ");");
        for (int i = 0; i < AllFrame.getCDCount(); i++)
            sw.WriteLine("    collides.addCDRect(" + (int)AllFrame.CDMask[i] + "," + (int)AllFrame.CDX[i] + "," + (int)AllFrame.CDY[i] + "," + (int)AllFrame.CDW[i] + "," + (int)AllFrame.CDH[i] + ");");
            sw.WriteLine("    collides.setFrame(new int[" + collides.frameGetCount() + "][]);");
        for (int i = 0; i < collides.frameGetCount(); i++)
            sw.WriteLine("    collides.setComboFrame(new int[]{" + Util.toTextArray((int[])(collides.frameGetFrame(i).ToArray(typeof(int)))) + "}," + i + ");");
            sw.WriteLine();
            // sprframes
            sw.WriteLine("    int[][] frameAnimate = new int[][]{");
        for (int i = 0; i < frameAnimate.Length; i++)
            sw.WriteLine("        {" + Util.toTextArray(frameAnimate[i]) + "},");
            sw.WriteLine("    };");
            sw.WriteLine("    int[][] frameCDMap = new int[][]{");
        for (int i = 0; i < frameCDMap.Length; i++)
            sw.WriteLine("        {" + Util.toTextArray(frameCDMap[i]) + "},");
            sw.WriteLine("    };");
            sw.WriteLine("    int[][] frameCDAtk = new int[][]{");
        for (int i = 0; i < frameCDAtk.Length; i++)
            sw.WriteLine("        {" + Util.toTextArray(frameCDAtk[i]) + "},");
            sw.WriteLine("    };");
            sw.WriteLine("    int[][] frameCDDef = new int[][]{");
        for (int i = 0; i < frameCDDef.Length; i++)
            sw.WriteLine("        {" + Util.toTextArray(frameCDDef[i]) + "},");
            sw.WriteLine("    };");
            sw.WriteLine("    int[][] frameCDExt = new int[][]{");
        for (int i = 0; i < frameCDExt.Length; i++)
            sw.WriteLine("        {" + Util.toTextArray(frameCDExt[i]) + "},");
            sw.WriteLine("    };");
            sw.WriteLine();
            // spr new
            sw.WriteLine("    CSprite ret = new CSprite(");
            sw.WriteLine("            animates, ");
            sw.WriteLine("            collides, ");
            sw.WriteLine("            frameAnimate, ");
            sw.WriteLine("            frameCDMap, ");
            sw.WriteLine("            frameCDAtk, ");
            sw.WriteLine("            frameCDDef, ");
            sw.WriteLine("            frameCDExt ");
            sw.WriteLine("            );");
            sw.WriteLine();
            sw.WriteLine("    return ret;");
            sw.WriteLine();

            sw.WriteLine("}");

            //sw.WriteLine("}");// class end
        }

        public void OutputCustom(String script, System.IO.StringWriter output)
        {
            try
            {
                initOutput();

                String sprite = Util.getFullTrunkScript(script, "#<SPRITE>", "#<END SPRITE>");

                bool fix = false;

                // animates part
                do
                {
                    String[] senceParts = new string[AllFrame.getSubCount()];
                    for (int i = 0; i < senceParts.Length; i++)
                    {
                        string X = ((int)AllFrame.SubX[i]).ToString();
                        string Y = ((int)AllFrame.SubY[i]).ToString();
                        string TILE = ((int)AllFrame.SubIndex[i]).ToString();
                        string TRANS = (flipTableJ2me[(int)(AllFrame.SubFlip[i])]).ToString();

                        senceParts[i] = Util.replaceKeywordsScript(sprite, "#<SCENE PART>", "#<END SCENE PART>",
                            new string[] { "<INDEX>", "<X>", "<Y>", "<TILE>", "<TRANS>" },
                            new string[] { i.ToString(), X, Y, TILE, TRANS }
                            );
                    }
                    string temp = Util.replaceSubTrunksScript(sprite, "#<SCENE PART>", "#<END SCENE PART>", senceParts);
                    if (temp == null)
                    {
                        fix = false;
                    }
                    else
                    {
                        fix = true;
                        sprite = temp;
                    }
                } while (fix);


                // animates frame
                do
                {
                    String[] senceFrames = new string[animates.frameGetCount()];
                    for (int i = 0; i < senceFrames.Length; i++)
                    {
                        string DATA = Util.toTextArray((int[])(animates.frameGetFrame(i).ToArray(typeof(int))));

                        senceFrames[i] = Util.replaceKeywordsScript(sprite, "#<SCENE FRAME>", "#<END SCENE FRAME>",
                            new string[] { "<INDEX>", "<DATA>" },
                            new string[] { i.ToString(), DATA }
                            );
                    }
                    string temp = Util.replaceSubTrunksScript(sprite, "#<SCENE FRAME>", "#<END SCENE FRAME>", senceFrames);
                    if (temp == null)
                    {
                        fix = false;
                    }
                    else
                    {
                        fix = true;
                        sprite = temp;
                    }
                } while (fix);

                // cd part
                do
                {
                    String[] cdParts = new string[AllFrame.getCDCount()];
                    for (int i = 0; i < cdParts.Length; i++)
                    {
                        string TYPE = "rect";
                        string MASK = ((int)AllFrame.CDMask[i]).ToString();
                        string X1 = ((int)AllFrame.CDX[i]).ToString();
                        string Y1 = ((int)AllFrame.CDY[i]).ToString();
                        string W = ((int)AllFrame.CDW[i]).ToString();
                        string H = ((int)AllFrame.CDH[i]).ToString();
                        string X2 = ((int)(((int)AllFrame.CDX[i]) + ((int)AllFrame.CDW[i]))).ToString();
                        string Y2 = ((int)(((int)AllFrame.CDY[i]) + ((int)AllFrame.CDH[i]))).ToString();

                        cdParts[i] = Util.replaceKeywordsScript(sprite, "#<CD PART>", "#<END CD PART>",
                            new string[] { "<INDEX>", "<TYPE>", "<MASK>", "<X1>", "<Y1>", "<W>", "<H>", "<X2>", "<Y2>" },
                            new string[] { i.ToString(), TYPE, MASK, X1, Y1, W, H, X2, Y2 }
                            );
                    }
                    string temp = Util.replaceSubTrunksScript(sprite, "#<CD PART>", "#<END CD PART>", cdParts);
                    if (temp == null)
                    {
                        fix = false;
                    }
                    else
                    {
                        fix = true;
                        sprite = temp;
                    }
                } while (fix);


                // cd frame
                do
                {
                    String[] cdFrames = new string[collides.frameGetCount()];
                    for (int i = 0; i < cdFrames.Length; i++)
                    {
                        string DATA = Util.toTextArray((int[])(collides.frameGetFrame(i).ToArray(typeof(int))));

                        cdFrames[i] = Util.replaceKeywordsScript(sprite, "#<CD FRAME>", "#<END CD FRAME>",
                            new string[] { "<INDEX>", "<DATA>" },
                            new string[] { i.ToString(), DATA }
                            );
                    }
                    string temp = Util.replaceSubTrunksScript(sprite, "#<CD FRAME>", "#<END CD FRAME>", cdFrames);
                    if (temp == null)
                    {
                        fix = false;
                    }
                    else
                    {
                        fix = true;
                        sprite = temp;
                    }
                } while (fix);


                // sprframes
                String outFrameAnimate = "";
                String outFrameCDMap = "";
                String outFrameCDAtk = "";
                String outFrameCDDef = "";
                String outFrameCDExt = "";


                for (int i = 0; i < frameAnimate.Length; i++)
                    outFrameAnimate += "{" + Util.toTextArray(frameAnimate[i]) + "},";
                for (int i = 0; i < frameCDMap.Length; i++)
                    outFrameCDMap += "{" + Util.toTextArray(frameCDMap[i]) + "},";
                for (int i = 0; i < frameCDAtk.Length; i++)
                    outFrameCDAtk += "{" + Util.toTextArray(frameCDAtk[i]) + "},";
                for (int i = 0; i < frameCDDef.Length; i++)
                    outFrameCDDef += "{" + Util.toTextArray(frameCDDef[i]) + "},";
                for (int i = 0; i < frameCDExt.Length; i++)
                    outFrameCDExt += "{" + Util.toTextArray(frameCDExt[i]) + "},";
               
                sprite = Util.replaceKeywordsScript(sprite, "#<SPRITE>", "#<END SPRITE>",
                    new string[] { 
                    "<NAME>", 
                    "<SCENE PART COUNT>" ,
                    "<SCENE FRAME COUNT>" ,
                    "<CD PART COUNT>",
                    "<CD FRAME COUNT>",
                    "<FRAME ANIMATE>",
                    "<FRAME CD MAP>",
                    "<FRAME CD ATK>",
                    "<FRAME CD DEF>",
                    "<FRAME CD EXT>"
                },
                    new string[] { 
                    this.id, 
                    AllFrame.getSubCount().ToString(),
                    animates.frameGetCount().ToString(),
                    AllFrame.getCDCount().ToString(),
                    collides.frameGetCount().ToString(),
                    outFrameAnimate,
                    outFrameCDMap,
                    outFrameCDAtk,
                    outFrameCDDef,
                    outFrameCDExt}
                    );

                output.WriteLine(sprite);

            }
            catch (Exception err) { Console.WriteLine(this.id + " : " + err.Message); }
            
        }

        private void SpriteForm_Load(object sender, EventArgs e)
        {
            pictureBox1.Width = 1;
            pictureBox1.Height = 1;
            pictureBox2.Width = 1024;
            pictureBox2.Height = 1024;
            panel2.HorizontalScroll.Value = panel2.HorizontalScroll.Maximum / 2 - panel2.Width/2;
            panel2.VerticalScroll.Value = panel2.VerticalScroll.Maximum / 2 - panel2.Height/2;
            dstRefersh();
            timer1.Start();

        }
        private void SpriteForm_FormClosing(object sender, FormClosingEventArgs e)
        {
            if (e.CloseReason == CloseReason.UserClosing)
            {
                e.Cancel = true;
                this.Hide();
            }
        }
        private void SpriteForm_FormClosed(object sender, FormClosedEventArgs e)
        {

        }


        public void Render(javax.microedition.lcdui.Graphics g,int x,int y,Boolean tag,int anim,int frame)
        {

            try
            {
                Frame curFrame = (Frame)((ArrayList)AnimTable[listView2.Items[anim]])[frame];

                if (curFrame != null)
                {
                    curFrame.render(
                      g,
                      srcTiles,
                      x,
                      y);

                    if (tag)
                    {
                        curFrame.renderCD(
                            g,
                            x,
                            y);
                    }
                }

            }catch(Exception err){
            }
            
           

        }

// src tile
        private Image srcGetImage(int index)
        {
            return (((Image)(srcTiles[index])));
        }
        private int srcGetCount()
        {
            return srcTiles.Count;
        }
        private void srcRender(Graphics g, int index, int flip, int x, int y)
        {
            if (srcGetImage(index) != null && flip < Frame.flipTable.Length)
            {
                g.drawImage(srcGetImage(index), x, y, Frame.flipTable[flip], 0);
            }

        }
        private void srcRenderAll(Graphics g, int x, int y, System.Drawing.Rectangle screen)
        {
            for (int i = 0; i < srcGetCount(); i++)
            {
                if (srcGetImage(i) != null &&
                    screen.IntersectsWith(new System.Drawing.Rectangle(
                        x + srcGetImage(i).x,
                        y + srcGetImage(i).y,
                        srcGetImage(i).getWidth() + 1,
                        srcGetImage(i).getHeight() + 1)
                    ))
                {
                    srcRender(g, i, 0, x + srcGetImage(i).x, y + srcGetImage(i).y);
                }
            }
            
        }

        private void pictureBox1_MouseDown(object sender, MouseEventArgs e)
        {
            if (e.Button == MouseButtons.Left)
            {
                System.Drawing.Rectangle dst = new System.Drawing.Rectangle(0, 0, 1, 1);
                for (int i = 0; i < srcGetCount(); i++)
                {
                    if (srcGetImage(i) != null)
                    {
                        dst.X = srcGetImage(i).x;
                        dst.Y = srcGetImage(i).y;
                        dst.Width = srcGetImage(i).getWidth();
                        dst.Height = srcGetImage(i).getHeight();

                        if (dst.Contains(e.X, e.Y))
                        {

                            srcRect = dst;
                            srcIndex = i;
                            srcImage = srcGetImage(i);

                            toolStripLabel1.Text =
                                "第" + i + "号" +
                                " 宽：" + srcGetImage(i).getWidth() +
                                " 高：" + srcGetImage(i).getHeight();

                           
                            pictureBox1.Refresh();
                            break;
                        }
                    }
                }
            }
        }
        private void pictureBox1_Paint(object sender, PaintEventArgs e)
        {
            for (int i = srcGetCount() - 1; i >= 0; i--)
            {
                if (srcGetImage(i) != null)
                {
                    pictureBox1.Width = Math.Max(
                        pictureBox1.Width,
                        srcGetImage(i).x + srcGetImage(i).getWidth()
                        );
                    pictureBox1.Height = Math.Max(
                        pictureBox1.Height,
                        srcGetImage(i).y + srcGetImage(i).getHeight()
                        );
                    //break;
                }
            }


            Graphics g = new Graphics(e.Graphics);


            srcRenderAll(g, 0, 0,
                new System.Drawing.Rectangle(
                    -pictureBox1.Location.X,
                    -pictureBox1.Location.Y,
                    panel1.Width,
                    panel1.Height
                )
            );

            System.Drawing.Pen pen = new System.Drawing.Pen(System.Drawing.Color.FromArgb(0xFF, 0xFF, 0xFF, 0xFF));
            System.Drawing.Brush brush = new System.Drawing.Pen(System.Drawing.Color.FromArgb(0x80, 0xff, 0xff, 0xff)).Brush;

            e.Graphics.FillRectangle(brush, srcRect);
            e.Graphics.DrawRectangle(pen, srcRect.X, srcRect.Y, srcRect.Width - 1, srcRect.Height - 1);
        }
// dst part

        Boolean dstRefreshEnable = true;
        private void dstRefersh()
        {
            if (!dstRefreshEnable) return ;

            dstSelectSub();
            dstSelectCD();

            try
            {
                foreach (ListViewItem item in listView3.Items)
                {
                    int index = (int)framesGetCurFrame().SubTable.IndexOf(item);
                    item.SubItems[0].Text = ((int)framesGetCurFrame().SubIndex[index]).ToString("d");
                    item.SubItems[1].Text = ((int)framesGetCurFrame().SubX[index]).ToString("d");
                    item.SubItems[2].Text = ((int)framesGetCurFrame().SubY[index]).ToString("d");
                    item.SubItems[3].Text = Frame.flipTextTable[(int)framesGetCurFrame().SubFlip[index]];
                }
                foreach (ListViewItem item in listView4.Items)
                {
                    int index = (int)framesGetCurFrame().CDTable.IndexOf(item);
                    item.SubItems[0].Text = ((int)framesGetCurFrame().CDMask[index]).ToString("x");
                    item.SubItems[1].Text = ((int)framesGetCurFrame().CDX[index]).ToString("d");
                    item.SubItems[2].Text = ((int)framesGetCurFrame().CDY[index]).ToString("d");
                    item.SubItems[3].Text = ((int)framesGetCurFrame().CDW[index]).ToString("d");
                    item.SubItems[4].Text = ((int)framesGetCurFrame().CDH[index]).ToString("d");
                    item.SubItems[5].Text = Frame.CDtypeTextTable[(int)framesGetCurFrame().CDType[index]];
                }

                pictureBox2.Refresh();
                pictureBox3.Refresh();
            }
            catch (Exception err)
            {
            }
        }

        private void dstSelectSub()
        {
            for (int i = 0;framesGetCurFrame()!=null &&  i < framesGetCurFrame().SubSelected.Count; i++)
            {
                framesGetCurFrame().SubSelected[i] = false;
            }

            dstSubSelected.Clear();

            if (listView3.SelectedItems != null &&
                listView3.SelectedItems.Count > 0 &&
                framesGetCurFrame() != null 
                )
            {
                

                foreach(ListViewItem item in listView3.SelectedItems)
                {
                    if (framesGetCurFrame().SubTable.Contains(item))
                    {
                        framesGetCurFrame().SubSelected[framesGetCurFrame().SubTable.IndexOf(item)] = true;
                        dstSubSelected.Add(framesGetCurFrame().SubTable.IndexOf(item));
                    }
                }
            }
           
        }
        private void dstSelectCD()
        {
            for (int i = 0;framesGetCurFrame()!=null && i < framesGetCurFrame().CDSelected.Count; i++)
            {
                framesGetCurFrame().CDSelected[i] = false;
            }

            dstCDSelected.Clear();

            if (listView4.SelectedItems != null &&
                listView4.SelectedItems.Count > 0 &&
                framesGetCurFrame() != null )
            {
                foreach (ListViewItem item in listView4.SelectedItems)
                {
                    if (framesGetCurFrame().CDTable.Contains(item))
                    {
                        framesGetCurFrame().CDSelected[framesGetCurFrame().CDTable.IndexOf(item)] = true;
                        dstCDSelected.Add(framesGetCurFrame().CDTable.IndexOf(item));
                    }
                }
            }
           
        }

        ArrayList dstSubSelected = new ArrayList();
        ArrayList dstCDSelected = new ArrayList();
        private int[] dstGetCurSubIndexes()
        {
            return (int[])dstSubSelected.ToArray(typeof(int));
        }
        private int[] dstGetCurCDIndexes()
        {
            return (int[])dstCDSelected.ToArray(typeof(int));
        }


        private void dstDelSelectSub()
        {
            if (listView3.SelectedItems != null &&
                listView3.SelectedItems.Count > 0 &&
                framesGetCurFrame() != null)
            {
                foreach (ListViewItem item in listView3.SelectedItems)
                {
                    if (framesGetCurFrame().SubTable.Contains(item))
                    {
                        framesGetCurFrame().delSub(framesGetCurFrame().SubTable.IndexOf(item));
                        listView3.Items.Remove(item);
                    }
                }
            }
        }
        private void dstDelSelectCD()
        {
            if (listView4.SelectedItems != null &&
                listView4.SelectedItems.Count > 0 &&
                framesGetCurFrame() != null)
            {
                foreach (ListViewItem item in listView4.SelectedItems)
                {
                    if (framesGetCurFrame().CDTable.Contains(item))
                    {
                        framesGetCurFrame().delCD(framesGetCurFrame().CDTable.IndexOf(item));
                        listView4.Items.Remove(item);
                    }
                }
            }
        }

        Frame clipFrame = null ;

        private void dstCopySelectSub()
        {
            if (listView3.SelectedItems != null &&
                listView3.SelectedItems.Count > 0 &&
                framesGetCurFrame() != null)
            {
                clipFrame = new Frame();

                foreach (ListViewItem item in listView3.SelectedItems)
                {
                    int index = framesGetCurFrame().SubTable.IndexOf(item);
                    if (index>=0)
                    {
                       clipFrame.addSub(
                           null,
                           (int)framesGetCurFrame().SubIndex[index],
                           (int)framesGetCurFrame().SubX[index],
                           (int)framesGetCurFrame().SubY[index],
                           (int)framesGetCurFrame().SubW[index],
                           (int)framesGetCurFrame().SubH[index],
                           (int)framesGetCurFrame().SubFlip[index]
                           );
                    }
                }
            }
        }
        private void dstCopySelectCD()
        {
            if (listView4.SelectedItems != null &&
                listView4.SelectedItems.Count > 0 &&
                framesGetCurFrame() != null)
            {
                clipFrame = new Frame();

                foreach (ListViewItem item in listView4.SelectedItems)
                {
                    int index = framesGetCurFrame().CDTable.IndexOf(item);
                    if (index >= 0)
                    {
                        clipFrame.addCD(
                            null,
                            (int)framesGetCurFrame().CDMask[index],
                            (int)framesGetCurFrame().CDX[index],
                            (int)framesGetCurFrame().CDY[index],
                            (int)framesGetCurFrame().CDW[index],
                            (int)framesGetCurFrame().CDH[index],
                            (int)framesGetCurFrame().CDType[index]
                            );
                    }
                }
            }
        }
        private void dstPasteSelectSub()
        {
            if (listView3.SelectedItems != null &&
                listView3.SelectedItems.Count > 0 &&
                framesGetCurFrame() != null)
            {
                foreach (ListViewItem item in listView3.SelectedItems)
                {
                    item.Selected = false;
                    item.Focused = false;
                }
            }

            if (framesGetCurFrame() != null && clipFrame != null)
            {
                for (int i = 0; i < clipFrame.getSubCount();i++ )
                {
                    ListViewItem item = new ListViewItem(
                        new string[] {
                            ((int)clipFrame.SubIndex[i]).ToString("d"),
                            ((int)clipFrame.SubX[i]).ToString("d"),
                            ((int)clipFrame.SubY[i]).ToString("d"),
                            Frame.flipTextTable[(int)clipFrame.SubFlip[i]]}
                   );
                    listView3.Items.Add(item);

                    framesGetCurFrame().addSub(
                        item,
                        (int)clipFrame.SubIndex[i],
                        (int)clipFrame.SubX[i],
                        (int)clipFrame.SubY[i],
                        (int)clipFrame.SubW[i],
                        (int)clipFrame.SubH[i],
                        (int)clipFrame.SubFlip[i]
                        );
                    item.Focused = true;
                    item.Selected = true;
                }
            }
        }
        private void dstPasteSelectCD()
        {
            if (listView4.SelectedItems != null &&
                listView4.SelectedItems.Count > 0 &&
                framesGetCurFrame() != null)
            {
                foreach (ListViewItem item in listView4.SelectedItems)
                {
                    item.Selected = false;
                    item.Focused = false;
                }
            }

            if (framesGetCurFrame() != null && clipFrame != null)
            {
                for (int i = 0; i < clipFrame.getCDCount(); i++)
                {
                    ListViewItem item = new ListViewItem(
                        new string[] {
                            ((int)clipFrame.CDMask[i]).ToString("x"),
                            ((int)clipFrame.CDX[i]).ToString("d"),
                            ((int)clipFrame.CDY[i]).ToString("d"),
                            ((int)clipFrame.CDW[i]).ToString("d"),
                            ((int)clipFrame.CDH[i]).ToString("d"),
                            Frame.CDtypeTextTable[((int)clipFrame.CDType[i])]}
                    );
                    listView4.Items.Add(item);

                    framesGetCurFrame().addCD(
                        item,
                        (int)clipFrame.CDMask[i],
                        (int)clipFrame.CDX[i],
                        (int)clipFrame.CDY[i],
                        (int)clipFrame.CDW[i],
                        (int)clipFrame.CDH[i],
                        (int)clipFrame.CDType[i]
                        );
                    item.Focused = true;
                    item.Selected = true;
                }
            }
        }
        private void dstPasteSelectSubAll()
        {
            if (listView3.SelectedItems != null &&
                listView3.SelectedItems.Count > 0 &&
                framesGetCurFrame() != null)
            {
                foreach (ListViewItem item in listView3.SelectedItems)
                {
                    item.Selected = false;
                    item.Focused = false;
                }
            }

            for (int f = 0; f < animGetCurFrames().Count; f++)
            {
                Frame curFrame = (Frame)animGetCurFrames()[f];

                if (curFrame != null && clipFrame != null)
                {
                    for (int i = 0; i < clipFrame.getSubCount(); i++)
                    {
                        ListViewItem item = new ListViewItem(
                            new string[] {
                            ((int)clipFrame.SubIndex[i]).ToString("d"),
                            ((int)clipFrame.SubX[i]).ToString("d"),
                            ((int)clipFrame.SubY[i]).ToString("d"),
                            Frame.flipTextTable[(int)clipFrame.SubFlip[i]]}
                       );

                        curFrame.addSub(
                            item,
                            (int)clipFrame.SubIndex[i],
                            (int)clipFrame.SubX[i],
                            (int)clipFrame.SubY[i],
                            (int)clipFrame.SubW[i],
                            (int)clipFrame.SubH[i],
                            (int)clipFrame.SubFlip[i]
                            );
                        item.Focused = true;
                        item.Selected = true;
                    }
                }
            }

        }
        private void dstPasteSelectCDAll()
        {
            if (listView4.SelectedItems != null &&
                 listView4.SelectedItems.Count > 0 &&
                 framesGetCurFrame() != null)
            {
                foreach (ListViewItem item in listView4.SelectedItems)
                {
                    item.Selected = false;
                    item.Focused = false;
                }
            }

            for (int f = 0; f < animGetCurFrames().Count; f++)
            {
                Frame curFrame = (Frame)animGetCurFrames()[f];

                if (curFrame != null && clipFrame != null)
                {
                    for (int i = 0; i < clipFrame.getCDCount(); i++)
                    {
                        ListViewItem item = new ListViewItem(
                            new string[] {
                            ((int)clipFrame.CDMask[i]).ToString("x"),
                            ((int)clipFrame.CDX[i]).ToString("d"),
                            ((int)clipFrame.CDY[i]).ToString("d"),
                            ((int)clipFrame.CDW[i]).ToString("d"),
                            ((int)clipFrame.CDH[i]).ToString("d"),
                            Frame.CDtypeTextTable[((int)clipFrame.CDType[i])]}
                        );

                        curFrame.addCD(
                            item,
                            (int)clipFrame.CDMask[i],
                            (int)clipFrame.CDX[i],
                            (int)clipFrame.CDY[i],
                            (int)clipFrame.CDW[i],
                            (int)clipFrame.CDH[i],
                            (int)clipFrame.CDType[i]
                            );
                        item.Focused = true;
                        item.Selected = true;
                    }
                }
            }
        }


        private void dstAddPart()
        {
            if (framesGetCurFrame() != null)
            {
                ListViewItem item = new ListViewItem(new string[] {
                    srcIndex.ToString("d"),
                   ((int)(-srcImage.getWidth()/2)).ToString("d"),
                    ((int)(-srcImage.getHeight()/2)).ToString("d"),
                    Frame.flipTextTable[0] }
                    );
                listView3.Items.Add(item);

                framesGetCurFrame().addSub(
                    item,
                    srcIndex,
                    -srcImage.getWidth() / 2,
                    -srcImage.getHeight() / 2,
                    srcImage.getWidth(),
                    srcImage.getHeight(),
                    0
                    );
                item.Focused = true;
                item.Selected = true;
            }
        }
        private void dstAddCD()
        {
            if (framesGetCurFrame() != null)
            {
                ListViewItem item = new ListViewItem(new string[] {
                    (0xffffffff).ToString("x"),
                    ((int)(-srcImage.getWidth()/2)).ToString("d"),
                    ((int)(-srcImage.getHeight()/2)).ToString("d"),
                    srcImage.getWidth().ToString("d"),
                    srcImage.getHeight().ToString("d"),
                    Frame.CDtypeTextTable[Frame.CD_TYPE_MAP]}
                    );
                listView4.Items.Add(item);

                framesGetCurFrame().addCD(
                    item,
                    (int)(0x0000ffff),
                    -srcImage.getWidth() / 2,
                    -srcImage.getHeight() / 2,
                    srcImage.getWidth(),
                    srcImage.getHeight(),
                    Frame.CD_TYPE_MAP
                    );
                item.Focused = true;
                item.Selected = true;
            }
        }
        
        // main editor
        private void toolStripButton10_Click(object sender, EventArgs e)
        {
            dstAddPart();
            dstRefersh();
        }
        private void toolStripButton11_Click(object sender, EventArgs e)
        {
            dstAddCD();
            dstRefersh();
        }
        private void toolStripButton20_Click(object sender, EventArgs e)
        {
            try
            {
                if (dstGetCurSubIndexes().Length == 1)
                {
                    framesGetCurFrame().SubIndex[dstGetCurSubIndexes()[0]] = srcIndex;
                    framesGetCurFrame().SubW[dstGetCurSubIndexes()[0]] = srcRect.Width;
                    framesGetCurFrame().SubH[dstGetCurSubIndexes()[0]] = srcRect.Height;
                    dstRefersh();
                }
            }
            catch (Exception err) { }
            dstRefersh();
        }

        private void toolStripButton15_Click(object sender, EventArgs e)
        {
            if (tabControl1.SelectedIndex == 0)
            {
                dstCopySelectSub();
                //Console.WriteLine("Copy Sub !");
            }
            if (tabControl1.SelectedIndex == 1)
            {
                dstCopySelectCD();
            }
            //framesRefersh();
            dstRefersh();
        }
        private void toolStripButton19_Click(object sender, EventArgs e)
        {
            if (tabControl1.SelectedIndex == 0)
            {
                dstPasteSelectSub();
                //Console.WriteLine("Paste Sub !");
            }
            if (tabControl1.SelectedIndex == 1)
            {
                dstPasteSelectCD();
            }
            //framesRefersh();
            dstRefersh();
        }
        private void toolStripButton21_Click(object sender, EventArgs e)
        {
            //all
            if (tabControl1.SelectedIndex == 0)
            {
                dstPasteSelectSubAll();
                //Console.WriteLine("Paste Sub !");
            }
            if (tabControl1.SelectedIndex == 1)
            {
                dstPasteSelectCDAll();
            }
            framesRefersh();
            dstRefersh();
        }
        private void toolStripButton16_Click(object sender, EventArgs e)
        {
            if (tabControl1.SelectedIndex == 0)
            {
                dstDelSelectSub();
                //Console.WriteLine("Del Sub !");
            }
            if (tabControl1.SelectedIndex == 1)
            {
                dstDelSelectCD();
            }
            //framesRefersh();
            dstRefersh();
        }

        private void tabControl1_SelectedIndexChanged(object sender, EventArgs e)
        {
            framesRefersh();
        }
        //sub
        private void button1_Click(object sender, EventArgs e)
        {
            if (dstGetCurSubIndexes().Length == 1 &&
               dstGetCurSubIndexes()[0] - 1 < framesGetCurFrame().getSubCount() &&
               dstGetCurSubIndexes()[0] - 1 >= 0)
            {
                framesGetCurFrame().exchangeSub(dstGetCurSubIndexes()[0], dstGetCurSubIndexes()[0] - 1);
            }
            dstRefersh();

           
        }
        private void button2_Click(object sender, EventArgs e)
        {
            if (dstGetCurSubIndexes().Length == 1 &&
                dstGetCurSubIndexes()[0] + 1 < framesGetCurFrame().getSubCount() &&
                dstGetCurSubIndexes()[0] + 1 >= 0)
            {
                framesGetCurFrame().exchangeSub(dstGetCurSubIndexes()[0], dstGetCurSubIndexes()[0] + 1);

            }
            dstRefersh();
        }
        private void numericUpDown1_ValueChanged(object sender, EventArgs e)
        {
            if (dstGetCurSubIndexes().Length == 1)
            {
                framesGetCurFrame().SubX[dstGetCurSubIndexes()[0]] = (int)numericUpDown1.Value;
            } 
            dstRefersh();
            
        }
        private void numericUpDown3_ValueChanged(object sender, EventArgs e)
        {
            if (dstGetCurSubIndexes().Length == 1)
            {
                framesGetCurFrame().SubY[dstGetCurSubIndexes()[0]] = (int)numericUpDown3.Value;
            }
            dstRefersh();
        }
        private void toolStripMenuItem10_Click(object sender, EventArgs e)
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

            if (dstGetCurSubIndexes().Length == 1)
            {
                int flip = 0;
                if (sender.Equals(toolStripMenuItem10)) flip = 0;
                if (sender.Equals(toolStripMenuItem11)) flip = 1;
                if (sender.Equals(toolStripMenuItem12)) flip = 2;
                if (sender.Equals(toolStripMenuItem13)) flip = 3;
                if (sender.Equals(toolStripMenuItem14)) flip = 4;
                if (sender.Equals(toolStripMenuItem15)) flip = 5;
                if (sender.Equals(toolStripMenuItem16)) flip = 6;
                if (sender.Equals(toolStripMenuItem17)) flip = 7;

                framesGetCurFrame().flipSub(dstGetCurSubIndexes()[0], flip);
            }
            
            dstRefersh();
        }
        private void listView3_ItemSelectionChanged(object sender, ListViewItemSelectionChangedEventArgs e)
        {
            dstRefreshEnable = false;
            dstSelectSub();

            if (dstGetCurSubIndexes().Length == 1)
            {
                numericUpDown1.Value = (Decimal)((int)framesGetCurFrame().SubX[dstGetCurSubIndexes()[0]]);
                numericUpDown3.Value = (Decimal)((int)framesGetCurFrame().SubY[dstGetCurSubIndexes()[0]]);
                switch ((int)framesGetCurFrame().SubFlip[dstGetCurSubIndexes()[0]])
                {
                    case 0: toolStripMenuItem10_Click(toolStripMenuItem10, null); break;
                    case 1: toolStripMenuItem10_Click(toolStripMenuItem11, null); break;
                    case 2: toolStripMenuItem10_Click(toolStripMenuItem12, null); break;
                    case 3: toolStripMenuItem10_Click(toolStripMenuItem13, null); break;
                    case 4: toolStripMenuItem10_Click(toolStripMenuItem14, null); break;
                    case 5: toolStripMenuItem10_Click(toolStripMenuItem15, null); break;
                    case 6: toolStripMenuItem10_Click(toolStripMenuItem16, null); break;
                    case 7: toolStripMenuItem10_Click(toolStripMenuItem17, null); break;
                }
            }
       
            pictureBox2.Refresh();
            dstRefreshEnable = true;
            
        }
        //cd
        private void numericUpDown4_ValueChanged(object sender, EventArgs e)
        {
            if (dstGetCurCDIndexes().Length == 1)
            {
                framesGetCurFrame().CDX[dstGetCurCDIndexes()[0]] = (int)numericUpDown4.Value;
            }
            dstRefersh();
        }
        private void numericUpDown5_ValueChanged(object sender, EventArgs e)
        {
            if (dstGetCurCDIndexes().Length == 1)
            {
                framesGetCurFrame().CDY[dstGetCurCDIndexes()[0]] = (int)numericUpDown5.Value;
            }
            dstRefersh();
        }
        private void numericUpDown6_ValueChanged(object sender, EventArgs e)
        {
            if (dstGetCurCDIndexes().Length == 1)
            {
                framesGetCurFrame().CDW[dstGetCurCDIndexes()[0]] = (int)numericUpDown6.Value;
            }
            dstRefersh();
        }
        private void numericUpDown7_ValueChanged(object sender, EventArgs e)
        {
            if (dstGetCurCDIndexes().Length == 1)
            {
                framesGetCurFrame().CDH[dstGetCurCDIndexes()[0]] = (int)numericUpDown7.Value;
            }
            dstRefersh();
        }
        private void numericUpDown8_ValueChanged(object sender, EventArgs e)
        {
            if (dstGetCurCDIndexes().Length == 1)
            {
                framesGetCurFrame().CDMask[dstGetCurCDIndexes()[0]] = (int)numericUpDown8.Value;
            }
            dstRefersh();
        }
        private void ToolStripMenuItemSprCD_Click(object sender, EventArgs e)
        {

            if (!sender.Equals(地图ToolStripMenuItem)) 地图ToolStripMenuItem.Checked = false;
            if (!sender.Equals(攻击ToolStripMenuItem)) 攻击ToolStripMenuItem.Checked = false;
            if (!sender.Equals(防御ToolStripMenuItem)) 防御ToolStripMenuItem.Checked = false;
            if (!sender.Equals(其他ToolStripMenuItem)) 其他ToolStripMenuItem.Checked = false;

            ((ToolStripMenuItem)sender).Checked = true;
            toolStripDropDownButton1.Image = ((ToolStripMenuItem)sender).Image;

            if (dstGetCurCDIndexes().Length == 1)
            {
                int type = 0;
                if (sender.Equals(地图ToolStripMenuItem)) type = Frame.CD_TYPE_MAP;
                if (sender.Equals(攻击ToolStripMenuItem)) type = Frame.CD_TYPE_ATK;
                if (sender.Equals(防御ToolStripMenuItem)) type = Frame.CD_TYPE_DEF;
                if (sender.Equals(其他ToolStripMenuItem)) type = Frame.CD_TYPE_EXT;

                framesGetCurFrame().CDType[dstGetCurCDIndexes()[0]] = type;
            }

            dstRefersh();
           
        }
        private void listView4_ItemSelectionChanged(object sender, ListViewItemSelectionChangedEventArgs e)
        {
            dstRefreshEnable = false;
            dstSelectCD();

            if (dstGetCurCDIndexes().Length == 1)
            {
                numericUpDown4.Value = (Decimal)((int)framesGetCurFrame().CDX[dstGetCurCDIndexes()[0]]);
                numericUpDown5.Value = (Decimal)((int)framesGetCurFrame().CDY[dstGetCurCDIndexes()[0]]);
                numericUpDown6.Value = (Decimal)((int)framesGetCurFrame().CDW[dstGetCurCDIndexes()[0]]);
                numericUpDown7.Value = (Decimal)((int)framesGetCurFrame().CDH[dstGetCurCDIndexes()[0]]);
                numericUpDown8.Value = (Decimal)((int)framesGetCurFrame().CDMask[dstGetCurCDIndexes()[0]]);
                switch ((int)framesGetCurFrame().CDType[dstGetCurCDIndexes()[0]])
                {
                    case Frame.CD_TYPE_MAP: ToolStripMenuItemSprCD_Click(地图ToolStripMenuItem, null); break;
                    case Frame.CD_TYPE_ATK: ToolStripMenuItemSprCD_Click(攻击ToolStripMenuItem, null); break;
                    case Frame.CD_TYPE_DEF: ToolStripMenuItemSprCD_Click(防御ToolStripMenuItem, null); break;
                    case Frame.CD_TYPE_EXT: ToolStripMenuItemSprCD_Click(其他ToolStripMenuItem, null); break;
                }
            }

            pictureBox2.Refresh();
            dstRefreshEnable = true;

        }


        // dst box
        private void pictureBox2_Paint(object sender, PaintEventArgs e)
        {
           // pictureBox2.SizeMode = PictureBoxSizeMode.

            Graphics g = new Graphics(e.Graphics);

            //Graphics g = new Graphics(System.Drawing.Graphics.FromImage(pictureBox2.Image));


            System.Drawing.Pen pen = new System.Drawing.Pen(System.Drawing.Color.FromArgb(0x80, 0, 0, 0));
            System.Drawing.Brush brush = new System.Drawing.Pen(System.Drawing.Color.FromArgb(0x80, 0xff, 0xff, 0xff)).Brush;

            e.Graphics.DrawLine(pen, pictureBox2.Width / 2, 0, pictureBox2.Width / 2, pictureBox2.Height);
            e.Graphics.DrawLine(pen, 0, pictureBox2.Height / 2, pictureBox2.Width, pictureBox2.Height / 2);


            if (framesGetCurFrame() != null)
            {
                framesGetCurFrame().render(
                  g,
                  srcTiles,
                  pictureBox2.Width / 2,
                  pictureBox2.Height / 2);

                if (toolStripButton26.Checked)
                {
                    framesGetCurFrame().renderCD(
                        g,
                        pictureBox2.Width / 2,
                        pictureBox2.Height / 2);
                }
            }

            //e.Graphics.DrawImage(pictureBox2.Image,0,0);

           
        }

        private void toolStripButton12_Click(object sender, EventArgs e)
        {
            ColorDialog MyDialog = new ColorDialog();
            MyDialog.AllowFullOpen = false;
            MyDialog.ShowHelp = true;
            MyDialog.Color = pictureBox2.BackColor;
            if (MyDialog.ShowDialog() == DialogResult.OK)
            {
                pictureBox2.BackColor = MyDialog.Color;
            }
        }
        private void toolStripButton26_Click(object sender, EventArgs e)
        {
            dstRefersh();
        }

// frames
        int ViewW = 64;
        int ViewH = 64;

        private void framesRefersh()
        {
            listView3.Items.Clear();
            listView4.Items.Clear();
            if (framesGetCurFrame() != null)
            {
                for (int i = 0; i < framesGetCurFrame().getSubCount();i++ )
                {
                    ((ListViewItem)framesGetCurFrame().SubTable[i]).Selected = false;
                    listView3.Items.Add((ListViewItem)framesGetCurFrame().SubTable[i]);
                }
                for (int i = 0; i < framesGetCurFrame().getCDCount(); i++)
                {
                    ((ListViewItem)framesGetCurFrame().CDTable[i]).Selected = false;
                    listView4.Items.Add((ListViewItem)framesGetCurFrame().CDTable[i]);
                }
                
            }
            dstRefersh();

            if (animGetCurFrames() != null)
            {
                pictureBox3.Width = ViewW * animGetCurFrames().Count;
                pictureBox3.Height = ViewH;
            }

            pictureBox3.Refresh();
        }

        private void framesAdd()
        {
            if (animGetCurFrames() != null)
            {

                Frame frame = new Frame();
                
                if (animGetCurFrames().Count > 0)
                {
                    trackBar1.Maximum++;
                    animGetCurFrames().Insert(trackBar1.Value + 1, frame);
                    trackBar1.Value ++;
                }
                else
                {
                    trackBar1.Maximum=0;
                    animGetCurFrames().Add(frame);
                    trackBar1.Value=0;
                }

                //PictureBox pictureBox = new PictureBox();
                //pictureBox.Location = new System.Drawing.Point(3, 3);
                //pictureBox.Name = "framePicture";
                //pictureBox.Size = new System.Drawing.Size(100, 100);
                //pictureBox.TabIndex = 0;
                //pictureBox.TabStop = false;
                //pictureBox.BackColor = 0xffff00ff;
                //panel3.Controls.Add(pictureBox);

                
                listView2.SelectedItems[0].SubItems[1].Text = animGetCurFrames().Count.ToString();

               
            }
        }
        private void framesDel()
        {
            if (framesGetCurFrame() != null)
            {
                animGetCurFrames().Remove(framesGetCurFrame());
                trackBar1.Maximum = Math.Max(animGetCurFrames().Count - 1, 0);

                listView2.SelectedItems[0].SubItems[1].Text = animGetCurFrames().Count.ToString();
            }
        }
        private void framesCopy()
        {
            if (framesGetCurFrame()!=null)
            {
                Frame frame = new Frame(framesGetCurFrame());

                trackBar1.Maximum++;
                animGetCurFrames().Insert(trackBar1.Value + 1, frame);
                trackBar1.Value++;
          
                listView2.SelectedItems[0].SubItems[1].Text = animGetCurFrames().Count.ToString();


            }
        }

        private Frame framesGetCurFrame()
        {
            if (animGetCurFrames() != null && trackBar1.Value < animGetCurFrames().Count)
            {
                return (Frame)(animGetCurFrames()[trackBar1.Value]);
            }
            else
            {
                return null;
            }
        }

        private void pictureBox3_Paint(object sender, PaintEventArgs e)
        {
            if (toolStripButton6.Checked == false)
            {
                Graphics g = new Graphics(e.Graphics);

                if (animGetCurFrames() != null)
                {
                    for (int i = 0; i < animGetCurFrames().Count; i++)
                    {

                        Frame frame = (Frame)(animGetCurFrames()[i]);

                        g.setClip(ViewW * i, 0, ViewW , ViewH );

                        frame.render(
                              g,
                              srcTiles,
                              ViewW * i + ViewW / 2,
                              ViewH / 2);

                        frame.renderCD(
                              g,
                              ViewW * i + ViewW / 2,
                              ViewH / 2);

                        if (trackBar1.Value == i)
                        {
                            g.setColor(0x20, 0, 0, 0);
                            g.fillRect(ViewW * i, 0, ViewW - 1, ViewH - 1);
                            g.setColor(0xff, 0, 0, 0);
                            g.drawRect(ViewW * i, 0, ViewW - 1, ViewH - 1);
                        }
                    }
                }
            }
            
        }
        private void pictureBox3_MouseDown(object sender, MouseEventArgs e)
        {
            if(e.Button == MouseButtons.Left)
            {
                if (animGetCurFrames() != null)
                {
                    trackBar1.Value = e.X/ViewW;
                }
            }
            framesRefersh();
        }

        private void toolStripButton1_Click(object sender, EventArgs e)
        {
            framesAdd();
            framesRefersh();
        }
        private void toolStripButton2_Click(object sender, EventArgs e)
        {
            framesDel();
            framesRefersh();
        }
        private void toolStripButton3_Click(object sender, EventArgs e)
        {
            framesCopy();
            framesRefersh();
        }
        private void toolStripButton18_Click(object sender, EventArgs e)
        {
            if (trackBar1.Value >= trackBar1.Minimum + 1)
            {
                animGetCurFrames().Reverse(trackBar1.Value - 1, 2);
                trackBar1.Value = trackBar1.Value - 1;
            }
            framesRefersh();

          
        }
        private void toolStripButton17_Click(object sender, EventArgs e)
        {
            if (trackBar1.Value <= trackBar1.Maximum - 1)
            {
                animGetCurFrames().Reverse(trackBar1.Value, 2);
                trackBar1.Value = trackBar1.Value + 1;
            }
            framesRefersh();
          
        }

        private void trackBar1_Scroll(object sender, EventArgs e)
        {
            framesRefersh();
        }
        private void trackBar1_ValueChanged(object sender, EventArgs e)
        {
           
        }
        private void toolStripButton4_Click(object sender, EventArgs e)
        {
            trackBar1.Value = trackBar1.Minimum;
            framesRefersh();
        }
        private void toolStripButton5_Click(object sender, EventArgs e)
        {
            if (trackBar1.Value > trackBar1.Minimum)
            {
                trackBar1.Value -= trackBar1.SmallChange;
            }
            else
            {
                trackBar1.Value = trackBar1.Maximum;
            }
            framesRefersh();
        }
        private void toolStripButton6_Click(object sender, EventArgs e)
        {
            if (toolStripButton6.Checked == true)
            {
                foreach (Control control in splitContainer5.Panel2.Controls)
                {
                    control.Enabled = false;
                }
            }
            else
            {
                foreach (Control control in splitContainer5.Panel2.Controls)
                {
                    control.Enabled = true;
                }
            }
            framesRefersh();
            
        }
        private void toolStripButton7_Click(object sender, EventArgs e)
        {
            if (trackBar1.Value < trackBar1.Maximum)
            {
                trackBar1.Value += trackBar1.SmallChange;
            }
            else
            {
                trackBar1.Value = trackBar1.Minimum;
            } 
            framesRefersh();
        }
        private void toolStripButton14_Click(object sender, EventArgs e)
        {
            trackBar1.Value = trackBar1.Maximum;
            framesRefersh();
        }



        // all
        private void framesMoveAll(int px,int py)
        {
            foreach (Frame frame in animGetCurFrames())
            {
                for (int i = 0; i < frame.getSubCount(); i++)
                {
                    frame.SubX[i] = ((int)(frame.SubX[i])) + px;
                    frame.SubY[i] = ((int)(frame.SubY[i])) + py;
                }

                for (int i = 0; i < frame.getCDCount(); i++)
                {
                    frame.CDX[i] = ((int)(frame.CDX[i])) + px;
                    frame.CDY[i] = ((int)(frame.CDY[i])) + py;
                }
            }
        }
        //left
        private void toolStripButton22_Click(object sender, EventArgs e)
        {
            framesMoveAll(-1, 0);
            framesRefersh();
        }
        //right
        private void toolStripButton23_Click(object sender, EventArgs e)
        {
            framesMoveAll( 1, 0);
            framesRefersh();
        }
        //up
        private void toolStripButton24_Click(object sender, EventArgs e)
        {
            framesMoveAll(0, -1);
            framesRefersh();
        }
        //down
        private void toolStripButton25_Click(object sender, EventArgs e)
        {
            framesMoveAll(0,  1);
            framesRefersh();
        }
 // animate
        private void animAdd()
        {
            ArrayList frames = new ArrayList();

            ListViewItem item = new ListViewItem(new String[] { animCount.ToString("d4"), "0" });

            //Animates.Add(frames);
            listView2.Items.Add(item);
            AnimTable.Add(item, frames);

            item.Focused = true;
            item.Selected = true;

            animCount++;

        }
        private void animDel()
        {
            if (animGetCurFrames() != null)
            {
                AnimTable.Remove(listView2.SelectedItems[0]);
                listView2.Items.Remove(listView2.SelectedItems[0]);
            }
        }
        private void animCopy()
        {
            if (animGetCurFrames() != null)
            {
                ArrayList frames = new ArrayList();

                ListViewItem item = new ListViewItem(new String[] { animCount.ToString("d4"), animGetCurFrames().Count.ToString() });

                foreach(Object obj in animGetCurFrames())
                {
                    Frame frame = new Frame((Frame)obj);
                    frames.Add(frame);
                }

                //Animates.Add(frames);
                listView2.Items.Add(item);
                AnimTable.Add(item, frames);

                item.Focused = true;
                item.Selected = true;

                animCount++;
            }
        }

        private ArrayList animGetCurFrames()
        {
            if (listView2.Items.Count > 0 &&
                listView2.SelectedItems != null &&
                listView2.SelectedItems.Count > 0)
            {
                return (ArrayList)AnimTable[listView2.SelectedItems[0]];
            }
            else
            {
                return null;
            }
        }

        private void toolStripButton8_Click(object sender, EventArgs e)
        {
            animAdd();
            framesRefersh();
        }
        private void toolStripButton9_Click(object sender, EventArgs e)
        {
            animDel();
            framesRefersh();
        }
        private void toolStripButton13_Click(object sender, EventArgs e)
        {
            animCopy();
            framesRefersh();
        }
        private void listView2_ItemSelectionChanged(object sender, ListViewItemSelectionChangedEventArgs e)
        {
            if (listView2.SelectedItems != null && listView2.SelectedItems.Count > 0)
            {
                if (animGetCurFrames() != null)
                {
                    trackBar1.Maximum = Math.Max(animGetCurFrames().Count - 1, 0);
                    trackBar1.Value = 0;
                }
            }
            framesRefersh();
        }


// timer
        private void timer1_Tick(object sender, EventArgs e)
        {
            timer1.Interval = (int)numericUpDown2.Value;
            toolStripStatusLabel1.Text = "";

            if (animGetCurFrames() != null && framesGetCurFrame() != null)
            {
                toolStripStatusLabel1.Text += " 帧：" + (trackBar1.Value + 1) + "/" + (trackBar1.Maximum + 1);
            }
            toolStripStatusLabel1.Text += " FPS=" + (((float)1000) / ((float)timer1.Interval));

            if (toolStripButton6.Checked)
            {
                if (trackBar1.Value < trackBar1.Maximum)
                {
                    trackBar1.Value += trackBar1.SmallChange;
                }
                else
                {
                    trackBar1.Value = trackBar1.Minimum;
                }
                pictureBox2.Refresh();
            }

        
        
        }







       

       










    }

    [Serializable]
    public partial class Frame : ISerializable
    {
        #region const
        public const int CD_TYPE_MAP = 0;
        public const int CD_TYPE_ATK = 1;
        public const int CD_TYPE_DEF = 2;
        public const int CD_TYPE_EXT = 3;

        
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
        static public String[] flipTextTable = new String[]
        {
            "无",
            "90",
            "180",
            "270",
            "水平",
            "H 90",
            "H 180",
            "H 270",
        };
        static public String[] CDtypeTextTable = new String[]
        {
            "地图",
            "攻击",
            "防御",
            "其他",
        };
        #endregion
        //ArrayList Animates;
        public ArrayList SubTable = new ArrayList();
        

        public ArrayList SubIndex = new ArrayList();
        public ArrayList SubX = new ArrayList();
        public ArrayList SubY = new ArrayList();
        public ArrayList SubW = new ArrayList();
        public ArrayList SubH = new ArrayList();
        public ArrayList SubFlip = new ArrayList();

        public ArrayList SubSelected = new ArrayList();

        //ArrayList Collides;
        public ArrayList CDTable = new ArrayList();

        public ArrayList CDMask = new ArrayList();
        public ArrayList CDX = new ArrayList();
        public ArrayList CDY = new ArrayList();
        public ArrayList CDW = new ArrayList();
        public ArrayList CDH = new ArrayList();
        public ArrayList CDType = new ArrayList();

        public ArrayList CDSelected = new ArrayList();

        public Frame()
        {
            
        }
        public Frame(Frame obj)
        {                    
            //ArrayList Animates;
            SubTable = (ArrayList)obj.SubTable.Clone();

            SubIndex = (ArrayList)obj.SubIndex.Clone();
            SubX = (ArrayList)obj.SubX.Clone();
            SubY = (ArrayList)obj.SubY.Clone();
            SubW = (ArrayList)obj.SubW.Clone();
            SubH = (ArrayList)obj.SubH.Clone();
            SubFlip = (ArrayList)obj.SubFlip.Clone();

            SubSelected = (ArrayList)obj.SubSelected.Clone();

            //ArrayList Collides;
            CDTable = (ArrayList)obj.CDTable.Clone();

            CDMask = (ArrayList)obj.CDMask.Clone();
            CDX = (ArrayList)obj.CDX.Clone();
            CDY = (ArrayList)obj.CDY.Clone();
            CDW = (ArrayList)obj.CDW.Clone();
            CDH = (ArrayList)obj.CDH.Clone();
            CDType = (ArrayList)obj.CDType.Clone();

            CDSelected = (ArrayList)obj.CDSelected.Clone();
        }
        [SecurityPermissionAttribute(SecurityAction.Demand, SerializationFormatter = true)]
        protected Frame(SerializationInfo info, StreamingContext context)
        {
            SubIndex = (ArrayList)info.GetValue("SubIndex", typeof(ArrayList));
            SubX = (ArrayList)info.GetValue("SubX", typeof(ArrayList));
            SubY = (ArrayList)info.GetValue("SubY", typeof(ArrayList));
            SubW = (ArrayList)info.GetValue("SubW", typeof(ArrayList));
            SubH = (ArrayList)info.GetValue("SubH", typeof(ArrayList));
            SubFlip = (ArrayList)info.GetValue("SubFlip", typeof(ArrayList));

            CDMask = (ArrayList)info.GetValue("CDMask", typeof(ArrayList));
            CDX = (ArrayList)info.GetValue("CDX", typeof(ArrayList));
            CDY = (ArrayList)info.GetValue("CDY", typeof(ArrayList));
            CDW = (ArrayList)info.GetValue("CDW", typeof(ArrayList));
            CDH = (ArrayList)info.GetValue("CDH", typeof(ArrayList));
            CDType = (ArrayList)info.GetValue("CDType", typeof(ArrayList));

            SubTable = new ArrayList();
            for (int i = 0; i < SubIndex.Count; i++)
            {
                ListViewItem item = new ListViewItem(new string[] {
                    ((int)SubIndex[i]).ToString("d"),
                    ((int)SubX[i]).ToString("d"),
                    ((int)SubY[i]).ToString("d"),
                    Frame.flipTextTable[(int)SubFlip[i]] }
                    );
                SubTable.Add(item);
                SubSelected.Add(false);
            }

            CDTable = new ArrayList();
            for (int i = 0; i < CDMask.Count; i++)
            {
                ListViewItem item = new ListViewItem(new string[] {
                    ((int)CDMask[i]).ToString("x"),
                    ((int)CDX[i]).ToString("d"),
                    ((int)CDY[i]).ToString("d"),
                    ((int)CDW[i]).ToString("d"),
                    ((int)CDH[i]).ToString("d"),
                     Frame.CDtypeTextTable[(int)CDType[i]]}
                    );
                CDTable.Add(item);
                CDSelected.Add(false);
            }
        }
        [SecurityPermissionAttribute(SecurityAction.Demand, SerializationFormatter = true)]
        public virtual void GetObjectData(SerializationInfo info, StreamingContext context)
        {
            info.AddValue("SubIndex", SubIndex);
            info.AddValue("SubX", SubX);
            info.AddValue("SubY", SubY);
            info.AddValue("SubW", SubW);
            info.AddValue("SubH", SubH);
            info.AddValue("SubFlip", SubFlip);

            info.AddValue("CDMask", CDMask);
            info.AddValue("CDX", CDX);
            info.AddValue("CDY", CDY);
            info.AddValue("CDW", CDW);
            info.AddValue("CDH", CDH);
            info.AddValue("CDType", CDType);
        }

       
        public int indexOfSub(int index,int x,int y,int w,int h,int flip )
        {
            for (int i = 0; i < SubIndex.Count;i++ )
            {
                if (((int)SubIndex[i]) == index &&
                    ((int)SubX[i]) == x &&
                    ((int)SubY[i]) == y &&
                    ((int)SubW[i]) == w &&
                    ((int)SubH[i]) == h &&
                    ((int)SubFlip[i]) == flip)
                {
                    return i;
                }
            }
            return -1;
        }

        public int indexOfCD(int mask,int x,int y,int w,int h)
        {
            for (int i = 0; i < CDMask.Count; i++)
            {
                if (((int)CDMask[i]) == mask &&
                    ((int)CDX[i]) == x &&
                    ((int)CDY[i]) == y &&
                    ((int)CDW[i]) == w &&
                    ((int)CDH[i]) == h  )
                {
                    return i;
                }
            }
            return -1;
        }

        public int getSubCount()
        {
            return SubIndex.Count;
        }
        public void addSub(ListViewItem key,int part, int x, int y, int w,int h,int flip)
        {
            SubTable.Add(key);
            SubIndex.Add(part);
            SubX.Add(x);
            SubY.Add(y);
            SubW.Add(w);
            SubH.Add(h);
            SubFlip.Add(flip);

            SubSelected.Add(true);
        }
        public void delSub(int index)
        {
            SubIndex.RemoveAt(index);
            SubX.RemoveAt(index);
            SubY.RemoveAt(index);
            SubW.RemoveAt(index);
            SubH.RemoveAt(index);
            SubFlip.RemoveAt(index);
            SubTable.RemoveAt(index);

            SubSelected.RemoveAt(index);
        }
        public void exchangeSub(int src, int dst)
        {
            int index = (int)SubIndex[src];
            int x = (int)SubX[src];
            int y = (int)SubY[src];
            int w = (int)SubW[src];
            int h = (int)SubH[src];
            int flip = (int)SubFlip[src];

            Boolean selected = (Boolean)SubSelected[src];
            //ListViewItem item = (ListViewItem)SubTable[src];

            SubIndex[src] = SubIndex[dst];
            SubX[src] = SubX[dst];
            SubY[src] = SubY[dst];
            SubW[src] = SubW[dst];
            SubH[src] = SubH[dst];
            SubFlip[src] = SubFlip[dst];
            //SubTable[src] = SubTable[dst];
            SubSelected[src] = (Boolean)SubSelected[dst];

            SubIndex[dst] = index;
            SubX[dst] = x;
            SubY[dst] = y;
            SubW[dst] = w;
            SubH[dst] = h;
            SubFlip[dst] = flip;
            //SubTable[dst] = item;
            SubSelected[dst] = selected;

            ((ListViewItem)SubTable[src]).Selected = false;
            ((ListViewItem)SubTable[src]).Focused = false;
            ((ListViewItem)SubTable[dst]).Selected = true;
            ((ListViewItem)SubTable[dst]).Focused = true;

        }
        public void flipSub(int index,int flip)
        {
            if (flip % 2 != ((int)SubFlip[index]) % 2)
            {
                int w = (int)SubW[index];
                int h = (int)SubH[index];
                SubW[index] = h;
                SubH[index] = w;
            }
            SubFlip[index] = flip;
        }

       


        public int getCDCount()
        {
            return CDMask.Count;
        }
        public void addCD(ListViewItem key, int mask, int x, int y, int w, int h, int type)
        {
            CDTable.Add(key);

            CDMask.Add(mask);
            CDX.Add(x);
            CDY.Add(y);
            CDW.Add(w);
            CDH.Add(h);
            CDType.Add(type);

            CDSelected.Add(true);
        }
        public void delCD(int index)
        {

            CDMask.RemoveAt(index);
            CDX.RemoveAt(index);
            CDY.RemoveAt(index);
            CDW.RemoveAt(index);
            CDH.RemoveAt(index);
            CDType.RemoveAt(index);
            CDTable.RemoveAt(index);

            CDSelected.RemoveAt(index);
        }




        public void render(Graphics g,ArrayList tile,int x,int y)
        {
            for (int i = SubIndex.Count - 1; i >=0 ;i-- )
            {
                if (((Image)tile[(int)SubIndex[i]]) != null)
                {
                    g.drawImage(
                       ((Image)tile[(int)SubIndex[i]]),
                       ((int)SubX[i]) + x,
                       ((int)SubY[i]) + y,
                       flipTable[(int)SubFlip[i]],
                       0
                       );
                }
                if ( (Boolean)(SubSelected[i]) )
                { 
                    g.setColor(0xff, 0xff, 0xff, 0xff);
                    g.drawRect(
                        ((int)SubX[i]) + x,
                        ((int)SubY[i]) + y,
                        ((int)SubW[i]) - 1,
                        ((int)SubH[i]) - 1
                        );
                    g.setColor(0x80, 0xff, 0xff, 0xff);
                    g.fillRect(
                        ((int)SubX[i]) + x,
                        ((int)SubY[i]) + y,
                        ((int)SubW[i]) ,
                        ((int)SubH[i]) 
                        );
                }
            }
            
        }
        public void renderCD(Graphics g,int x,int y)
        {
            for (int i = 0; i < CDMask.Count; i++)
            {
                switch ((int)CDType[i])
                {
                    case CD_TYPE_MAP:
                        g.setColor(0xff, 0x00, 0xff, 0x00);
                        break;
                    case CD_TYPE_ATK:
                        g.setColor(0xff, 0xff, 0x00, 0x00);
                        break;
                    case CD_TYPE_DEF:
                        g.setColor(0xff, 0x00, 0x00, 0xff);
                        break;
                    case CD_TYPE_EXT:
                        g.setColor(0xff, 0xff, 0xff, 0x00);
                        break;
                }
                g.drawRect(
                    ((int)CDX[i]) + x,
                    ((int)CDY[i]) + y,
                    ((int)CDW[i]) - 1,
                    ((int)CDH[i]) - 1);

                if ((Boolean)(CDSelected[i]))
                {
                    g.setColor(0x80, 0xff, 0xff, 0xff);
                    g.fillRect(
                        ((int)CDX[i]) + x,
                        ((int)CDY[i]) + y,
                        ((int)CDW[i]),
                        ((int)CDH[i])
                        );
                }

            }
        }

    }

    class Group
    {
        ArrayList Frames = new ArrayList();

        public Group()
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
            for (int i = 0; i < Frames.Count; i++)
            {
                if (Frames[i].Equals(frame)) return i;

                if (((ArrayList)Frames[i]).Count != frame.Count) continue;

                Boolean ok = true;

                for (int j = 0; j < frame.Count; j++)
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
    }
}
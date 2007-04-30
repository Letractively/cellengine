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
    public partial class ImagesForm : Form , ISerializable 
    {
        public String id;

        int CellW = 16;
        int CellH = 16;
        public ArrayList dstImages;


        //[NoneSerializable]
        javax.microedition.lcdui.Image srcImage;
        System.Drawing.Rectangle srcRect;
        Boolean srcRectIsDown = false;
        int srcPX;
        int srcPY;
        int srcQX;
        int srcQY;
        int srcSize = 1;

        


        
        

        public ImagesForm(String name)
        {
           
            InitializeComponent();

            id = name;
            CellW = 16;
            CellH = 16;
            dstImages = new ArrayList();
            toolStripTextBox1.Text = CellW.ToString();
            toolStripTextBox2.Text = CellH.ToString();

            // src
            pictureBox1.Width = 1;
            pictureBox1.Height = 1;
            pictureBox1.Image = new System.Drawing.Bitmap(1,1);
            srcImage = Image.createImage(pictureBox1.Width, pictureBox1.Height);
            

            srcRectIsDown = false;
            srcRect = new System.Drawing.Rectangle(0, 0, 1, 1);

           
            //
            pictureBox2.Width = 1;
            pictureBox2.Height = 1;
            
            dstSelected = null;
            
            dstRect = new System.Drawing.Rectangle(0, 0, 1, 1);

        }
        [SecurityPermissionAttribute(SecurityAction.Demand, SerializationFormatter = true)]
        protected ImagesForm(SerializationInfo info, StreamingContext context)
        {
            try
            {
                InitializeComponent();
                pictureBox2.Width = 1;
                pictureBox2.Height = 1;
                // load start
                id = (String)info.GetValue("id", typeof(String));
                CellW = (int)info.GetValue("CellW", typeof(int));
                CellH = (int)info.GetValue("CellH", typeof(int));
                ArrayList output = (ArrayList)info.GetValue("output", typeof(ArrayList));
                ArrayList outX = (ArrayList)info.GetValue("outX", typeof(ArrayList));
                ArrayList outY = (ArrayList)info.GetValue("outY", typeof(ArrayList));
                ArrayList outK;
                try
                {
                    outK = (ArrayList)info.GetValue("outK", typeof(ArrayList));
                }
                catch (Exception err) 
                { 
                    outK = new ArrayList();
                    for (int i = 0; i < output.Count; i++)
                    {
                        outK.Add(false);
                    }
                }
                dstImages = new ArrayList();

                for (int i = 0; i < output.Count; i++)
                {
                    try
                    {
                        String name = (String)output[i];
                        int x = (int)outX[i];
                        int y = (int)outY[i];
                        Boolean kill = (Boolean)outK[i];

                        Image img;

                        System.IO.MemoryStream ms = new System.IO.MemoryStream(System.IO.File.ReadAllBytes(ProjectForm.workSpace+name));
                        System.Drawing.Image dimg = System.Drawing.Image.FromStream(ms);

                        img = new Image(dimg);
                        img.x = x;
                        img.y = y;
                        img.killed = kill;

                        if (!img.killed)
                        {
                            pictureBox2.Width = Math.Max(pictureBox2.Width, img.x + img.getWidth());
                            pictureBox2.Height = Math.Max(pictureBox2.Height, img.y + img.getHeight() + 1);
                        }

                        dstImages.Add(img);
                    }
                    catch (Exception err)
                    {
                        dstImages.Add(null);
                        Console.WriteLine(this.id + " : Tile["+i+"] : " + err.StackTrace);
                    }

                    
                 
                }
                // load end

                toolStripTextBox1.Text = CellW.ToString();
                toolStripTextBox2.Text = CellH.ToString();

                // src
                pictureBox1.Width = 1;
                pictureBox1.Height = 1;
                pictureBox1.Image = new System.Drawing.Bitmap(1, 1);
                srcImage = Image.createImage(pictureBox1.Width, pictureBox1.Height);

                srcRectIsDown = false;
                srcRect = new System.Drawing.Rectangle(0, 0, 1, 1);


                //
                //pictureBox2.Width = 1;
                //pictureBox2.Height = 1;

                dstSelected = null;

                dstRect = new System.Drawing.Rectangle(0, 0, 1, 1);
            }
            catch (Exception err)
            {
                MessageBox.Show(err.StackTrace);
            }
        }
        [SecurityPermissionAttribute(SecurityAction.Demand, SerializationFormatter = true)]
        public virtual void GetObjectData(SerializationInfo info, StreamingContext context)
        {
            try{
                info.AddValue("id",id);
                info.AddValue("CellW", CellW);
                info.AddValue("CellH", CellH);

                ArrayList output = new ArrayList();
                ArrayList outX = new ArrayList();
                ArrayList outY = new ArrayList();
                ArrayList outK = new ArrayList();

                String dir =  "\\tiles\\" + this.id;
                //if (System.IO.Directory.Exists(ProjectForm.workSpace + dir))
                //{
                //    System.IO.Directory.Delete(ProjectForm.workSpace + dir, true);
                //}
                System.IO.Directory.CreateDirectory(ProjectForm.workSpace + dir);
                //System.IO.File.SetAttributes(
                //    ProjectForm.workSpace + dir,
                //    System.IO.FileAttributes.Hidden
                //    );

                for (int i = 0; i < dstImages.Count;i++ )
                {
                    try
                    {
                        String name = dir + "\\" + i.ToString() + ".tile";

                        Image img = getDstImage(i);
                        if (img != null)
                        {
                            if (!System.IO.File.Exists(ProjectForm.workSpace + name))
                            {
                                img.getDImage().Save(ProjectForm.workSpace + name, System.Drawing.Imaging.ImageFormat.Png);
                            }
                            output.Add(name);
                            outX.Add(img.x);
                            outY.Add(img.y);
                            outK.Add(img.killed);
                        }
                        else
                        {
                            output.Add("");
                            outX.Add(0);
                            outY.Add(0);
                            outK.Add(false);
                        }
                    }
                    catch (Exception err)
                    {
                        output.Add("");
                        outX.Add(0);
                        outY.Add(0);
                        outK.Add(false);
                        Console.WriteLine(this.id + " : "+i+" : " + err.StackTrace);
                    }
                }
                info.AddValue("output", output);
                info.AddValue("outX", outX);
                info.AddValue("outY", outY);
                info.AddValue("outK",outK);
            }
            catch (Exception err)
            {
                MessageBox.Show(err.StackTrace);
            }
        }

        public void DelAllImages()
        {
           
        }

       

        public void SaveAllImages(String dir,String type,Boolean tile,Boolean group)
        {
            try
            {
                System.Drawing.Imaging.EncoderParameters param = null;
                System.Drawing.Imaging.ImageCodecInfo info = null;
                System.Drawing.Imaging.ImageFormat format = null;
                //
                if (type.Equals("png", StringComparison.CurrentCultureIgnoreCase))
                    format = System.Drawing.Imaging.ImageFormat.Png;
                if (type.Equals("bmp", StringComparison.CurrentCultureIgnoreCase))
                    format = System.Drawing.Imaging.ImageFormat.Bmp;
                if (type.Equals("jpg", StringComparison.CurrentCultureIgnoreCase))
                    format = System.Drawing.Imaging.ImageFormat.Jpeg;
                if (type.Equals("gif", StringComparison.CurrentCultureIgnoreCase))
                    format = System.Drawing.Imaging.ImageFormat.Gif;

                //info.
                
                if (format == null)return;
                        
                try
                {
                    if (group)
                    {
                        int outW = 0;
                        int outH = 0;
                        for (int i = 0; i < getDstImageCount(); i++)
                        {
                            if (getDstImage(i) != null && !getDstImage(i).killed)
                            {
                                outW = Math.Max(outW, getDstImage(i).x + getDstImage(i).getWidth());
                                outH = Math.Max(outH, getDstImage(i).y + getDstImage(i).getHeight());
                            }
                        }

                        Image outputImage = Image.createImage(outW, outH);
                        Graphics g = outputImage.getGraphics();
                        for (int i = 0; i < getDstImageCount(); i++)
                        {
                            if (getDstImage(i) == null || getDstImage(i).killed) continue;
                            g.drawImage(getDstImage(i), getDstImage(i).x, getDstImage(i).y, 0);
                            
                        }
                        //
                        outputImage.getDImage().Save(dir + "\\" + this.id + "." + type, format);
                    }
                }
                catch (Exception err) { Console.WriteLine(this.id + " : save group : " + err.StackTrace); }
                if (tile)
                {
                    String tileDir = dir + "\\" + this.id + "\\" ;
                    if (!System.IO.Directory.Exists(tileDir))
                    {
                        System.IO.Directory.CreateDirectory(tileDir);
                    }
                    for (int i = 0; i < getDstImageCount(); i++)
                    {
                        if (getDstImage(i) == null || getDstImage(i).killed) continue;
                        try
                        {
                            getDstImage(i).getDImage().Save(tileDir + i + "." + type, format);

                        }
                        catch (Exception err) { Console.WriteLine(this.id + " : save tile : " + err.StackTrace); }
                    }
                }
            }
            catch (Exception err){Console.WriteLine(this.id + " : " + err.StackTrace);}
            
        }

        public void Output(System.IO.StringWriter sw)
        {
            String head = "/" + this.id+"/tile_";

            sw.WriteLine("final static public void buildImages_" + this.id + "(IImages stuff)");
            sw.WriteLine("{");
            sw.WriteLine("    stuff.buildImages(null, " + this.getDstImageCount() + ");");
            sw.WriteLine("    for(int i=0;i<" + this.getDstImageCount() + ";i++){");
            sw.WriteLine("        stuff.setTileImage(CIO.loadImage(\"" + head + "\"+i+\".png" + "\"));");
            sw.WriteLine("        stuff.addTile();");
            sw.WriteLine("    }");
            sw.WriteLine("    stuff.gc();");
            sw.WriteLine("}");

            sw.WriteLine("final static public void buildClipImages_" + this.id + "(IImages stuff)");
            sw.WriteLine("{");
            sw.WriteLine("    stuff.buildImages(CIO.loadImage(\"/" + this.id + ".png\"), " + this.getDstImageCount() + ");");
for (int i = 0; i < getDstImageCount(); i++){if (getDstImage(i) != null){//
            sw.WriteLine("    stuff.addTile(" + getDstImage(i).x + "," + getDstImage(i).y + "," + getDstImage(i).getWidth() + "," + getDstImage(i).getHeight() + ");");
}}//
            sw.WriteLine("    stuff.gc();");
            sw.WriteLine("}");

            SaveAllImages(ProjectForm.workSpace,"png",false,true);

        }


        public void OutputCustom(int index, String script, System.IO.StringWriter output, String outDir,
            String imageType,bool imageTile,bool imageTileData,bool imageGroup,bool imageGroupData)
        {
            try
            {
                String images = Util.getFullTrunkScript(script, "#<IMAGES>", "#<END IMAGES>");

                bool fix = false;
                do
                {
                    String[] clips = new string[getDstImageCount()];
                    for (int i = 0; i < getDstImageCount(); i++)
                    {
                        if (getDstImage(i) != null )
                        {
                            string X = getDstImage(i).killed ? "0" : getDstImage(i).x.ToString();
                            string Y = getDstImage(i).killed ? "0" : getDstImage(i).y.ToString();
                            string W = getDstImage(i).killed ? "0" : getDstImage(i).getWidth().ToString();
                            string H = getDstImage(i).killed ? "0" : getDstImage(i).getHeight().ToString();

                            clips[i] = Util.replaceKeywordsScript(images, "#<CLIP>", "#<END CLIP>",
                                new string[] { "<INDEX>", "<X>", "<Y>", "<W>", "<H>" },
                                new string[] { i.ToString(), X, Y, W, H }
                                );
                        }
                        else
                        {
                            clips[i] = Util.replaceKeywordsScript(images, "#<CLIP>", "#<END CLIP>",
                                   new string[] { "<INDEX>", "<X>", "<Y>", "<W>", "<H>" },
                                   new string[] { i.ToString(), "0", "0", "0", "0" }
                                   );
                        }
                    }
                    string temp = Util.replaceSubTrunksScript(images, "#<CLIP>", "#<END CLIP>", clips);

                    if (temp == null)
                    {
                        fix = false;
                    }
                    else
                    {
                        fix = true;
                        images = temp;
                    }

                } while (fix);
                

                images = Util.replaceKeywordsScript(images, "#<IMAGES>", "#<END IMAGES>",
                    new string[] { "<NAME>", "<IMAGES INDEX>", "<COUNT>" },
                    new string[] { this.id, index.ToString(), this.getDstImageCount().ToString() }
                    );

                output.WriteLine(images);
                //Console.WriteLine(images);

                SaveAllImages(outDir,imageType,imageTile,imageGroup);
               
            }
            catch (Exception err) { Console.WriteLine(this.id + " : " + err.StackTrace); }
        }





        private void ImagesForm_FormClosing(object sender, FormClosingEventArgs e)
        {
            if(e.CloseReason == CloseReason.UserClosing)
	        {
                e.Cancel = true;
                this.Hide();
	        }
        }
        private void ImagesForm_FormClosed(object sender, FormClosedEventArgs e)
        {

        }

        

        public void setSrcImage()
        {
            OpenFileDialog openFileDialog1 = new OpenFileDialog();
            openFileDialog1.Filter = "PNG files (*.png)|*.png|All files (*.*)|*.*";
            if (openFileDialog1.ShowDialog() == DialogResult.OK)
            {

                srcImage = Image.createImage(openFileDialog1.FileName);

                pictureBox1.Width = srcImage.getWidth() * srcSize;
                pictureBox1.Height = srcImage.getHeight() * srcSize;

                toolStripButton2.Checked = false;
                toolStripButton3.Checked = false;

                toolStripStatusLabel3.Text =
                  " : 图片宽=" + srcImage.getWidth() +
                  " : 图片高=" + srcImage.getHeight()
                ;
            }
         
        }


        public void addDst(Image img)
        {
            for (int i = 0; i < dstImages.Count; i++)
            {
                if (dstImages[i] == null || getDstImage(i).killed)
                {
                    dstImages[i] = img;
                    try
                    {
                        // save to src pic
                        String name = "\\tiles\\" + this.id + "\\" + i.ToString() + ".tile";
                        if (System.IO.File.Exists(ProjectForm.workSpace + name))
                        {
                            System.IO.File.Delete(ProjectForm.workSpace + name);
                        }
                        getDstImage(i).dimg.Save(ProjectForm.workSpace + name, System.Drawing.Imaging.ImageFormat.Png);
                    }
                    catch (Exception err) { }
                    return;
                }
            }
            dstImages.Add(img);
        }

        public void addDirImages()
        {
            OpenFileDialog openFileDialog1 = new OpenFileDialog();
            openFileDialog1.Multiselect = true;
            openFileDialog1.Filter = "PNG files (*.png)|*.png|All files (*.*)|*.*";
            if (openFileDialog1.ShowDialog() == DialogResult.OK)
            {

                for (int i = 0; i < openFileDialog1.FileNames.Length;i++ )
                {
                    try
                    {
                        Image img = Image.createImage(openFileDialog1.FileNames[i]);
                        img.x = 0;
                        img.y = pictureBox2.Height / dstSize - 1;
                        addDst(img);

                        pictureBox2.Width = Math.Max(pictureBox2.Width, img.getWidth() * dstSize);
                        pictureBox2.Height += (img.getHeight() * dstSize);
                    }catch(Exception err){
                        Console.WriteLine(err.StackTrace);
                    }
                }
            }
        }

        public void addDstImage()
        {
            if (srcImage == null)
            {
                System.Windows.Forms.MessageBox.Show("设置原始图片先");
            }
            else
            {
                if (srcRect.Width != 0 && srcRect.Height != 0)
                {
                    Image img = Image.createImage(
                        srcImage,
                        srcRect.X,
                        srcRect.Y,
                        srcRect.Width,
                        srcRect.Height,
                        0);
                    img.x = 0;
                    img.y = pictureBox2.Height/dstSize - 1;
                    addDst(img);

                    pictureBox2.Width = Math.Max(pictureBox2.Width, img.getWidth() * dstSize);
                    pictureBox2.Height += (img.getHeight() * dstSize);
                }
            }
        }
        
        public void addDstImages()
        {
            if (srcImage == null)
            {
                System.Windows.Forms.MessageBox.Show("设置原始图片先");
            }
            else
            {
                if (srcRect.Width != 0 && srcRect.Height != 0)
                {
                    for (int y = 0; y < srcRect.Height / CellH; y++)
                    {
                        for (int x = 0; x < srcRect.Width / CellW; x++)
                        {

                            if (CellW != 0 && CellH != 0)
                            {
                                Image img = Image.createImage(
                                    srcImage,
                                    srcRect.X + x * CellW,
                                    srcRect.Y + y * CellH,
                                    CellW,
                                    CellH,
                                    0);
                                img.x = x * (CellW);
                                img.y = y * (CellH) + pictureBox2.Height/dstSize - 1;
                                addDst(img);
                            }

                        }
                    }
                    pictureBox2.Width = Math.Max(pictureBox2.Width, (srcRect.Width / CellW * CellW) ) * dstSize;
                    pictureBox2.Height += ((srcRect.Height / CellH * CellH)) * dstSize;

                }
            }

        }
       
        public Image getSrcImage()
        {
            return srcImage;
        }
       
        public Image getDstImage(int index)
        {
            if (index >= dstImages.Count || index < 0) return null;
            return (((Image)(dstImages[index])));
        }

        public int getDstImageCount()
        {
            return dstImages.Count;
        }

      
        public bool moveDstImage(int index,int dx,int dy)
        {
            if (getDstImage(index)==null) return false;
           
            getDstImage(index).x += dx;
            getDstImage(index).y += dy;

            if (pictureBox2.Width < getDstImage(index).x * dstSize + getDstImage(index).getWidth() * dstSize) pictureBox2.Width += dx * dstSize;
            if (pictureBox2.Height < getDstImage(index).y * dstSize + getDstImage(index).getHeight() * dstSize) pictureBox2.Height += dy * dstSize;

            System.Drawing.Rectangle src = new System.Drawing.Rectangle(
                getDstImage(index).x,
                getDstImage(index).y,
                getDstImage(index).getWidth(),
                getDstImage(index).getHeight()
                );

            System.Drawing.Rectangle scope = new System.Drawing.Rectangle(
                0, 0,
                pictureBox2.Width,
                pictureBox2.Height
                );

            if (scope.Contains(src) == false)
            {
                getDstImage(index).x -= dx;
                getDstImage(index).y -= dy;
                return false;
            }
         

            for (int i = 0; i < getDstImageCount(); i++)
            {
                if (getDstImage(i) != null && getDstImage(i).killed==false && i!=index )
                {
                    System.Drawing.Rectangle dst = new System.Drawing.Rectangle(
                       getDstImage(i).x,
                       getDstImage(i).y,
                       getDstImage(i).getWidth(),
                       getDstImage(i).getHeight()
                       );

                    if (src.IntersectsWith(dst))
                    {
                        getDstImage(index).x -= dx;
                        getDstImage(index).y -= dy;
                        return false;
                    }
                    
                }
            }

            return true;
        }

        public void changeDstImage(int index){
            
            if (getDstImage(index) == null) return ;

            try
            {
                OpenFileDialog openFileDialog1 = new OpenFileDialog();
                openFileDialog1.Filter = "PNG files (*.png)|*.png|All files (*.*)|*.*";
                if (openFileDialog1.ShowDialog() == DialogResult.OK)
                {
                    int oy = getDstImage(index).y;
                    int ox = getDstImage(index).x;

                    Image changed = Image.createImage(openFileDialog1.FileName);

                    dstImages[index] = changed;

                    // test size
                    bool isSameSize = true;
                    System.Drawing.Rectangle src = new System.Drawing.Rectangle(
                        getDstImage(index).x,
                        getDstImage(index).y,
                        getDstImage(index).getWidth(),
                        getDstImage(index).getHeight()
                        );
                    for (int i = 0; i < getDstImageCount(); i++)
                    {
                        if (getDstImage(i) != null && i != index)
                        {
                            System.Drawing.Rectangle dst = new System.Drawing.Rectangle(
                               getDstImage(i).x,
                               getDstImage(i).y,
                               getDstImage(i).getWidth(),
                               getDstImage(i).getHeight()
                               );

                            if (src.IntersectsWith(dst))
                            {
                                isSameSize = false;
                                break;
                            }

                        }
                    }
                    if (isSameSize)
                    {
                        changed.x = ox;
                        changed.y = oy;
                    }
                    else
                    {
                        changed.x = pictureBox2.Width / dstSize;
                        changed.y = oy;
                    }


                    pictureBox2.Width += changed.getWidth() * dstSize;
                    pictureBox2.Height = Math.Max(pictureBox2.Height, changed.getHeight() * dstSize);

                    // save to src pic
                    String name = "\\tiles\\" + this.id + "\\" + index.ToString() + ".tile";
                    if (System.IO.File.Exists(ProjectForm.workSpace + name))
                    {
                        System.IO.File.Delete(ProjectForm.workSpace + name);
                    }
                    changed.dimg.Save(ProjectForm.workSpace + name, System.Drawing.Imaging.ImageFormat.Png);
                }
            }
            catch (Exception err) {
                Console.WriteLine(this.id + " : " + err.StackTrace);
            }
       

        }

        public void delDstImage(int index)
        {
            getDstImage(index).killed = true;
        }

        public void renderSrcImage(Graphics g, int x, int y)
        {
            if (srcImage == null) return;
            g.drawImage(srcImage, x, y, 0, 0, srcSize);
        }

        public void renderDstImage(Graphics g, int x, int y)
        {

            for (int i = 0; i < getDstImageCount(); i++)
            {
                if (getDstImage(i) != null && getDstImage(i).killed == false)
                {
                    g.drawImage(getDstImage(i), x + getDstImage(i).x * dstSize, y + getDstImage(i).y * dstSize, 0, 0, dstSize);
                    if (toolStripButton13.Checked)
                    {
                        g.setColor(0x7fffffff);
                        g.drawRect(x + getDstImage(i).x * dstSize, y + getDstImage(i).y * dstSize, getDstImage(i).getWidth() * dstSize, getDstImage(i).getHeight() * dstSize);
                    }
                
                }
            }
        }


        // src edit
        private void toolStripTextBox1_Leave(object sender, EventArgs e)
        {
            if (Cell.Util.stringIsDigit(toolStripTextBox1.Text, 0, toolStripTextBox1.Text.Length) >= toolStripTextBox1.Text.Length &&
                Cell.Util.stringDigitToInt(toolStripTextBox1.Text, 0, toolStripTextBox1.Text.Length) >= 1)
            {
                CellW = Cell.Util.stringDigitToInt(toolStripTextBox1.Text, 0, toolStripTextBox1.Text.Length);
            }
            else
            {
                MessageBox.Show("只能输入大于0的数字！");
                toolStripTextBox1.Focus();
            }
        }
        private void toolStripTextBox2_Leave(object sender, EventArgs e)
        {
            if (Cell.Util.stringIsDigit(toolStripTextBox2.Text, 0, toolStripTextBox2.Text.Length) >= toolStripTextBox2.Text.Length &&
              Cell.Util.stringDigitToInt(toolStripTextBox2.Text, 0, toolStripTextBox2.Text.Length) >= 1)
            {
                CellH = Cell.Util.stringDigitToInt(toolStripTextBox2.Text, 0, toolStripTextBox2.Text.Length);
            }
            else
            {
                MessageBox.Show("只能输入大于0的数字！");
                toolStripTextBox2.Focus();
            }

        }
        
        private void toolStripButton1_Click(object sender, EventArgs e)
        {
           setSrcImage();
        }
        private void toolStripButton6_Click(object sender, EventArgs e)
        {
            addDirImages();
        }
        private void toolStripButton2_CheckedChanged(object sender, EventArgs e)
        {
            if (toolStripButton2.Checked)
            {
                toolStripButton3.Checked = false;
            }

            srcRect.X = 0;
            srcRect.Width = 0;
            srcRect.Y = 0;
            srcRect.Height = 0;

            srcRectIsDown = false;
            pictureBox1.Refresh();
        }
        private void toolStripButton3_CheckedChanged(object sender, EventArgs e)
        {
            if (toolStripButton3.Checked)
            {
                toolStripButton2.Checked = false;
            }
            srcRect.X = 0;
            srcRect.Width = 0;
            srcRect.Y = 0;
            srcRect.Height = 0;

            srcRectIsDown = false;
            pictureBox1.Refresh();
        }

        private void toolStripButton4_Click(object sender, EventArgs e)
        {
            if (toolStripButton2.Checked)
            {
                addDstImage();
            }
            if (toolStripButton3.Checked)
            {
                addDstImages();
            }
            //pictureBox2.Refresh();
        }
       
        private void pictureBox1_Paint(object sender, PaintEventArgs e)
        {
            //pictureBox1.Image = new System.Drawing.Bitmap(pictureBox1.Width, pictureBox1.Height);
            //System.Drawing.Graphics dg = System.Drawing.Graphics.FromImage(pictureBox1.Image);
            System.Drawing.Graphics dg = e.Graphics;
            Graphics g = new Graphics(dg);
            renderSrcImage(g, 0, 0);


            System.Drawing.Pen pen = new System.Drawing.Pen(System.Drawing.Color.FromArgb(0x80, 0xff, 0xff, 0xff));
            System.Drawing.Brush brush = new System.Drawing.Pen(System.Drawing.Color.FromArgb(0x80, 0x80, 0x80, 0x80)).Brush;


            dg.DrawLine(pen, srcQX * srcSize, 0, srcQX * srcSize, pictureBox1.Height);
            dg.DrawLine(pen, 0, srcQY * srcSize, pictureBox1.Width, srcQY * srcSize);

            pen = new System.Drawing.Pen(System.Drawing.Color.FromArgb(0xFF, 0, 0, 0));

            if (toolStripButton2.Checked)
            {
                dg.FillRectangle(brush, srcRect.X * srcSize, srcRect.Y * srcSize, (srcRect.Width ) * srcSize, (srcRect.Height ) * srcSize);
                dg.DrawRectangle(pen, srcRect.X * srcSize, srcRect.Y * srcSize, (srcRect.Width ) * srcSize, (srcRect.Height ) * srcSize);
            }
            else if (toolStripButton3.Checked)
            {
                dg.FillRectangle(brush, srcRect.X * srcSize, srcRect.Y * srcSize, (srcRect.Width ) * srcSize, (srcRect.Height ) * srcSize);
                for (int x = srcRect.X; x < srcRect.X + srcRect.Width; x += CellW)
                {
                    dg.DrawLine(System.Drawing.Pens.White, x * srcSize, srcRect.Y * srcSize, x * srcSize, srcRect.Y * srcSize + (srcRect.Height) * srcSize );
                }
                for (int y = srcRect.Y; y < srcRect.Y + srcRect.Height; y += CellH)
                {
                    dg.DrawLine(System.Drawing.Pens.White, srcRect.X * srcSize, y * srcSize, srcRect.X * srcSize + (srcRect.Width ) * srcSize, y * srcSize);
                }
                dg.DrawRectangle(pen, srcRect.X * srcSize, srcRect.Y * srcSize, (srcRect.Width ) * srcSize, (srcRect.Height ) * srcSize);
            }
        }

        
        private void pictureBox1_MouseLeave(object sender, EventArgs e)
        {
            toolStripStatusLabel3.Text = "";
        }
        private void pictureBox1_MouseMove(object sender, MouseEventArgs e)
        {
            toolStripStatusLabel3.Text =
                        " : X=" + e.X / srcSize +
                        " : Y=" + e.Y / srcSize +
                        " : 图片宽=" + pictureBox1.Width / srcSize +
                        " : 图片高=" + pictureBox1.Height / srcSize 
                    ;
            srcQX = (e.X < 0 ? 0 : (e.X > pictureBox1.Width ? pictureBox1.Width : e.X)) / srcSize;
            srcQY = (e.Y < 0 ? 0 : (e.Y > pictureBox1.Height ? pictureBox1.Height : e.Y)) / srcSize;

            if (toolStripButton2.Checked || toolStripButton3.Checked)
            {
                if (srcRectIsDown)
                {
                    srcRect.X = Math.Min(srcPX, srcQX);
                    srcRect.Width = Math.Abs(srcPX - srcQX);
                    srcRect.Y = Math.Min(srcPY, srcQY);
                    srcRect.Height = Math.Abs(srcPY - srcQY);

                    toolStripStatusLabel3.Text +=
                        " : 选择宽=" + srcRect.Width +
                        " : 选择高=" + srcRect.Height;

                    if (toolStripButton3.Checked)
                    {
                        toolStripStatusLabel3.Text +=
                        " : 横向数量=" + srcRect.Width / CellW +
                        " : 纵向数量=" + srcRect.Height / CellH
                        ;
                    }

                   
                }
            }

            pictureBox1.Refresh();
        }
        private void pictureBox1_MouseDown(object sender, MouseEventArgs e)
        {
            srcPX = e.X / srcSize;
            srcPY = e.Y / srcSize;
            srcQX = e.X / srcSize;
            srcQY = e.Y / srcSize;

            if (toolStripButton2.Checked || toolStripButton3.Checked)
            {
                srcRect.X = srcPX;
                srcRect.Width = 0;
                srcRect.Y = srcPY;
                srcRect.Height = 0;
            }


            srcRectIsDown = true;
            pictureBox1.Refresh();


        }
        private void pictureBox1_MouseUp(object sender, MouseEventArgs e)
        {

            srcQX = e.X / srcSize;
            srcQY = e.Y / srcSize;

            srcRectIsDown = false;
            pictureBox1.Refresh();
        }

        private void toolStripButton7_Click(object sender, EventArgs e)
        {
            srcSize += 1;
            if (srcSize > 8) srcSize = 8;

            try
            {
                if (getSrcImage() != null)
                {
                    pictureBox1.Width = getSrcImage().getWidth() * srcSize;
                    pictureBox1.Height = getSrcImage().getHeight() * srcSize;
                    pictureBox1.Refresh();
                }
            }catch(Exception err){}

        }
        private void toolStripButton8_Click(object sender, EventArgs e)
        {

            srcSize -= 1;
            if (srcSize < 1) srcSize = 1;

            try
            {
                if (getSrcImage() != null)
                {
                    pictureBox1.Width = getSrcImage().getWidth() * srcSize;
                    pictureBox1.Height = getSrcImage().getHeight() * srcSize;
                    pictureBox1.Refresh();
                }
            }
            catch (Exception err) { }
        }
        // dst edit

        Image dstSelected = null;
        int dstSelectIndex = -1;
        System.Drawing.Rectangle dstRect;

        bool dstDown = false;
        int dstPX;
        int dstPY;

        int dstSize = 1;

        private void toolStripButton5_Click(object sender, EventArgs e)
        {
            dstSize += 1;
            if (dstSize > 8) dstSize = 8;

            try
            {
                int outW = 0;
                int outH = 0;
                for (int i = 0; i < getDstImageCount(); i++)
                {
                    if (getDstImage(i) != null && !getDstImage(i).killed)
                    {
                        outW = Math.Max(outW, getDstImage(i).x + getDstImage(i).getWidth());
                        outH = Math.Max(outH, getDstImage(i).y + getDstImage(i).getHeight());
                    }
                }

                pictureBox2.Width = outW * dstSize;
                pictureBox2.Height = outH * dstSize;
                pictureBox2.Refresh();
            }
            catch (Exception err)
            {
            }

        }
        private void toolStripButton11_Click(object sender, EventArgs e)
        {

            dstSize -= 1;
            if (dstSize < 1) dstSize = 1;

            try
            {
                int outW = 0;
                int outH = 0;
                for (int i = 0; i < getDstImageCount(); i++)
                {
                    if (getDstImage(i) != null && !getDstImage(i).killed)
                    {
                        outW = Math.Max(outW, getDstImage(i).x + getDstImage(i).getWidth());
                        outH = Math.Max(outH, getDstImage(i).y + getDstImage(i).getHeight());
                    }
                }

                pictureBox2.Width = outW * dstSize;
                pictureBox2.Height = outH * dstSize;
                pictureBox2.Refresh();
            }
            catch (Exception err)
            {
            }
        }

        private void pictureBox2_Paint(object sender, PaintEventArgs e)
        {
            Graphics g = new Graphics(e.Graphics);
            renderDstImage(g, 0, 0);

            System.Drawing.Pen pen = new System.Drawing.Pen(System.Drawing.Color.FromArgb(0xFF, 0xFF, 0xFF, 0xFF));
            System.Drawing.Brush brush = new System.Drawing.Pen(System.Drawing.Color.FromArgb(0x80, 0xff, 0xff, 0xff)).Brush;

            e.Graphics.FillRectangle(brush, dstRect.X * dstSize, dstRect.Y * dstSize, (dstRect.Width ) * dstSize, (dstRect.Height ) * dstSize);
            e.Graphics.DrawRectangle(pen, dstRect.X * dstSize, dstRect.Y * dstSize, (dstRect.Width ) * dstSize, (dstRect.Height ) * dstSize);
        }
        // change image
        private void toolStripButton9_Click(object sender, EventArgs e)
        {
            changeDstImage(dstSelectIndex);
            dstRect.X = getDstImage(dstSelectIndex).x;
            dstRect.Y = getDstImage(dstSelectIndex).y;
            dstRect.Width = getDstImage(dstSelectIndex).getWidth();
            dstRect.Height = getDstImage(dstSelectIndex).getHeight();
            pictureBox2.Refresh();
        }
        // del image
        private void toolStripButton12_Click(object sender, EventArgs e)
        {
            delDstImage(dstSelectIndex);
            dstRect.X = 0;
            dstRect.Y = 0;
            dstRect.Width = 1;
            dstRect.Height = 1;
            pictureBox2.Refresh();
        }
        private void pictureBox2_MouseDown(object sender, MouseEventArgs e)
        {
           
            if (e.Button == MouseButtons.Left)
            {
                System.Drawing.Rectangle dst = new System.Drawing.Rectangle(0, 0, 1, 1);
                for (int i = 0; i < getDstImageCount(); i++)
                {
                    if (getDstImage(i) != null && getDstImage(i).killed==false)
                    {
                        dst.X = getDstImage(i).x;
                        dst.Y = getDstImage(i).y;
                        dst.Width = getDstImage(i).getWidth();
                        dst.Height = getDstImage(i).getHeight();

                        if (dst.Contains(e.X / dstSize, e.Y / dstSize))
                        {
                            dstDown = true;
                            dstPX = e.X / dstSize;
                            dstPY = e.Y / dstSize;

                            dstSelected = getDstImage(i);
                            dstSelectIndex = i;
                            dstRect = dst;

                            toolStripStatusLabel1.Text =
                                "目标Tile：[" + dstSelectIndex + "]" + 
                                " X=" + dstSelected.x +
                                " Y=" + dstSelected.y +
                                " W=" + dstSelected.getWidth() +
                                " H=" + dstSelected.getHeight() 
                                
                                ;

                            pictureBox2.Refresh();
                            break;
                        }
                    }
                }
            }
            
            
        }
        private void pictureBox2_MouseUp(object sender, MouseEventArgs e)
        {
            dstDown = false;
            dstPX = e.X / dstSize;
            dstPY = e.Y / dstSize;
            pictureBox2.Refresh();
        }

        private void pictureBox2_MouseMove(object sender, MouseEventArgs e)
        {
            if (dstDown)
            {
                int px = (e.X / dstSize - dstPX);
                int py = (e.Y / dstSize - dstPY);
                dstPX = e.X / dstSize;
                dstPY = e.Y / dstSize;

                if (moveDstImage(dstSelectIndex, px, py))
                {
                    dstRect.X += px;
                    dstRect.Y += py;
                }

                toolStripStatusLabel1.Text =
                               "目标Tile：[" + dstSelectIndex + "]" +
                               " X=" + dstSelected.x +
                               " Y=" + dstSelected.y +
                               " W=" + dstSelected.getWidth() +
                               " H=" + dstSelected.getHeight()

                               ;

                pictureBox2.Refresh();
              
            }
            
        }

        //-------------------------------------------------------------------------------------------------------------------------------------
        
        public MapForm createMapForm(String name)
        {
            if (dstImages.Count < 1)
            {
                MessageBox.Show("Tile容量不能为0！");
                return null;
            }
           
            for (int i = 0; i < dstImages.Count; i++)
            {
                if (((Image)dstImages[i]) == null || ((Image)dstImages[i]).killed) continue;
                if (((Image)dstImages[i]).getWidth() != CellW ||
                    ((Image)dstImages[i]).getHeight() != CellH)
                {
                    MessageBox.Show("地图的Tile大小必须相等！");
                    return null;
                }
            }

            MapForm ret = new MapForm(name,CellW, CellH, this);
            return ret;
        }

        public SpriteForm createSpriteForm(String name)
        {
            if (dstImages.Count < 1)
            {
                MessageBox.Show("Tile容量不能为0！");
                return null;
            }
            for (int i = 0; i < dstImages.Count; i++)
            {
                if (((Image)dstImages[i]) == null) continue;
                //if (((Image)dstImages[i]).getWidth() != CellW ||
                //    ((Image)dstImages[i]).getHeight() != CellH)
                //{
                //    MessageBox.Show("地图的Tile大小必须相等！");
                //    return null;
                //}
            }

            SpriteForm ret = new SpriteForm(name,this);
            return ret;
        }

        //change color
        private void toolStripButton10_Click(object sender, EventArgs e)
        {
            ColorDialog MyDialog = new ColorDialog();
            MyDialog.AllowFullOpen = false;
            MyDialog.ShowHelp = true;
            MyDialog.Color = pictureBox1.BackColor;
            if (MyDialog.ShowDialog() == DialogResult.OK)
            {
                pictureBox2.BackColor = MyDialog.Color;
            }
        }

        private void toolStripButton13_Click(object sender, EventArgs e)
        {
            pictureBox2.Refresh();
        }

  





       

       





      
    }
}
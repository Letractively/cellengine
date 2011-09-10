﻿using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using System.Collections;



namespace CellGameEdit.PM
{
    public partial class ImageProcessDialog : Form
    {

        ArrayList selected_images = new ArrayList();

        public ImageProcessDialog(ImagesForm src, ArrayList dstImages)
        {
            InitializeComponent();

            foreach (Object io in dstImages) 
            {
                javax.microedition.lcdui.Image img = (javax.microedition.lcdui.Image)io;
                if (img != null && img.selected) 
                {
                    selected_images.Add(img);
                }
            }

            this.labelSelectedCount.Text = "已选择(" + selected_images.Count+")个图片";
            long color = src.getCurrentClickColor().ToArgb() & 0x00ffffffff;
            this.textColor.Text = color.ToString("x");
        }

        private void ImageProcessDialog_Load(object sender, EventArgs e)
        {

        }

        private void processImage()
        {
            try
            {
                long scc = int.Parse(textColor.Text, System.Globalization.NumberStyles.AllowHexSpecifier);
                long dcc = int.Parse(textDstColor.Text, System.Globalization.NumberStyles.AllowHexSpecifier);

                int scv = (int)(0xffffffff & scc);
                int dcv = (int)(0xffffffff & dcc);
                int trans = imageFlipToolStripButton1.getFlipIndex();

                foreach (javax.microedition.lcdui.Image img in selected_images)
                {
                    if (checkSetKeyColor.Checked)
                    {
                        img.swapColor(scv, dcv);
                    }
                    if (checkFlip.Checked)
                    {
                        img.flipSelf(trans);
                    }
                }
            }
            catch (Exception err)
            {
                MessageBox.Show(err.StackTrace + "\n  at  " + err.Message);
            }
        }

        private void ImageProcessDialog_FormClosing(object sender, FormClosingEventArgs e)
        {

        }

        private void buttonOK_Click(object sender, EventArgs e)
        {
            processImage();
            this.DialogResult = DialogResult.OK;
            this.Close();
        }

        private void textColor_TextChanged(object sender, EventArgs e)
        {
            try
            {
                long scv = long.Parse(textColor.Text, System.Globalization.NumberStyles.AllowHexSpecifier);
                long dcv = long.Parse(textDstColor.Text, System.Globalization.NumberStyles.AllowHexSpecifier);
            }
            catch (Exception err) {
                MessageBox.Show(err.Message);
            }
        }

    }
}

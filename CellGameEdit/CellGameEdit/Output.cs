using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;

namespace CellGameEdit
{
    public partial class Output : Form
    {
        System.IO.StringWriter sw;
        public Output()
        {
            InitializeComponent();

            sw = new System.IO.StringWriter();
            System.Console.SetOut(sw);
            timer1.Start();

        }

  

        private void timer1_Tick_1(object sender, EventArgs e)
        {
            this.textBox1.Text = sw.ToString();
        }

        private void toolStripButton1_Click(object sender, EventArgs e)
        {
            sw = new System.IO.StringWriter();
            System.Console.SetOut(sw);
        }
    }


}
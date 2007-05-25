using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;

namespace CellGameEdit
{
    public partial class OutputForm : Form
    {
        System.IO.StringWriter sw;
        
        public OutputForm()
        {
            InitializeComponent();

            sw = new System.IO.StringWriter();
            System.Console.SetOut(sw);
            timer1.Start();

        }

        private void Output_FormClosing(object sender, FormClosingEventArgs e)
        {
        }

        private void Output_Load(object sender, EventArgs e)
        {

        }

        

        private void timer1_Tick_1(object sender, EventArgs e)
        {
            if (this.textBox1.Text.Length != sw.ToString().Length) 
            {
                this.textBox1.Clear();
                this.textBox1.AppendText(sw.ToString());
                this.textBox1.ScrollToCaret();
            }

            //this.textBox1.Select(this.textBox1.Text.Length , 0);
        }

        private void toolStripButton1_Click(object sender, EventArgs e)
        {
            sw = new System.IO.StringWriter();
            System.Console.SetOut(sw);
        }

        private void toolStripButton2_Click(object sender, EventArgs e)
        {
            
        }

        
    }


}
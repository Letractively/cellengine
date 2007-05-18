using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;

namespace CellGameEdit.PM
{
    public partial class TextDialog : Form
    {
        public TextDialog(string name)
        {
            InitializeComponent();
            this.StartPosition = FormStartPosition.CenterParent;
            this.textBox1.Text = name;
            this.textBox1.SelectAll();
            this.textBox1.Focus();
        }

        public string getText()
        {
            return textBox1.Text;
        }

        public DialogResult showDialog()
        {
            base.ShowDialog();
            return this.DialogResult;
        }
    }
}
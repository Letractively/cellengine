using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using System.IO;
using System.Runtime.Serialization;
using System.Runtime.Serialization.Formatters.Binary;
using System.Runtime.Serialization.Formatters.Soap;

using CellGameEdit.PM;

namespace CellGameEdit
{
    public partial class Form1 : Form 
    {
        

        private ProjectForm prjForm;

        public Form1()
        {
            InitializeComponent();
        }

        public Form1(string file)
        {
            string name = System.IO.Path.GetFileName(file);
            string dir = System.IO.Path.GetDirectoryName(file);

            ProjectForm.workSpace = dir;

            SoapFormatter formatter = new SoapFormatter();
            Stream stream = new FileStream(file, FileMode.Open, FileAccess.Read, FileShare.Read);
            prjForm = (ProjectForm)formatter.Deserialize(stream);
            stream.Close();

            InitializeComponent();

        }

        private void Form1_Load(object sender, EventArgs e)
        {
            timer1.Start();
        }

        private void Form1_Shown(object sender, EventArgs e)
        {
            if (prjForm != null)
            {
                prjForm.MdiParent = this;
                prjForm.Show();
            }
        }


        private void 文件ToolStripMenuItem_DropDownOpening(object sender, EventArgs e)
        {
            
        }

        private void 新建ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (prjForm == null || prjForm.Visible == false)
            {
                FolderBrowserDialog dir = new FolderBrowserDialog();
                dir.ShowNewFolderButton = true;
                dir.Description = "新建工程文件夹";

                if (dir.ShowDialog() == DialogResult.OK)
                {
                    if (System.IO.File.Exists(dir.SelectedPath + "\\Project.xml"))
                    {
                        MessageBox.Show("已经存在一个工程文件 Project.xml");
                    }
                    else
                    {


                        //System.IO.Directory.CreateDirectory(dir.SelectedPath);
                        //System.IO.Directory.CreateDirectory(dir.SelectedPath + "\\script");
                        
                        ProjectForm.workSpace = dir.SelectedPath;

                        prjForm = new ProjectForm();
                        prjForm.MdiParent = this;
                        prjForm.Show();
                    }
                   
                }
            }
            else
            {
            }
        }

        private void 打开ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (prjForm == null || prjForm.Visible == false)
            {
                FolderBrowserDialog dir = new FolderBrowserDialog();
                dir.ShowNewFolderButton = false;
                dir.Description = "打开包含(Project.cpj)的工程文件夹";

                if (dir.ShowDialog() == DialogResult.OK)
                {
                    try
                    {
                        ProjectForm.workSpace = dir.SelectedPath;

                        SoapFormatter formatter = new SoapFormatter();
                        Stream stream = new FileStream(dir.SelectedPath + "\\Project.cpj", FileMode.Open, FileAccess.Read, FileShare.Read);
                        prjForm = (ProjectForm)formatter.Deserialize(stream);
                        stream.Close();
                        prjForm.MdiParent = this;
                        prjForm.Show();
                    }
                    catch (Exception err)
                    {
                        MessageBox.Show("找不到工程文件 Project.cpj " + err.Message);
                    }
                   
                }

              
            }
            else
            {
            }
           
        }

        private void 保存ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (prjForm != null && prjForm.Visible == true)
            {
                try {
                    SoapFormatter formatter = new SoapFormatter();
                    Stream stream = new FileStream(ProjectForm.workSpace + "\\Project.cpj", FileMode.Create, FileAccess.Write, FileShare.None);
                    formatter.Serialize(stream, prjForm);
                    stream.Close(); 

                }
                catch(Exception err){
                    MessageBox.Show("目录错误 "+err.Message);
                }
            }
            else
            {
            }

        }

        private void 关闭ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (prjForm != null)
            {
                prjForm.Close();
                prjForm = null;
            }
        }




        private void javaToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (prjForm != null)
            {
                prjForm.Output();
            }
        }

        private void 自定义脚本ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            try
            {
                if (prjForm != null && toolStripComboBox1.SelectedItem != null)
                {
                    String dir = Application.StartupPath + "\\script\\";
                    prjForm.OutputCustom(dir + toolStripComboBox1.Text);
                }
            }
            catch (Exception err) { Console.WriteLine(err.Message); }
        }

        private void toolStripComboBox1_DropDown(object sender, EventArgs e)
        {
            toolStripComboBox1.Items.Clear();

            try
            {

                String dir = Application.StartupPath + "\\script\\";

                if (System.IO.Directory.Exists(dir))
                {
                    String[] scriptFiles = System.IO.Directory.GetFiles(dir);

                    for (int i = 0; i < scriptFiles.Length; i++)
                    {
                        scriptFiles[i] = System.IO.Path.GetFileName(scriptFiles[i]);
                    }

                    toolStripComboBox1.Items.AddRange(scriptFiles);
                }
            }
            catch (Exception err)
            {
            }
           
            
        }

        private void 退出ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void timer1_Tick(object sender, EventArgs e)
        {
            if (prjForm != null && prjForm.Visible == false)
            {
                prjForm.Dispose();
                prjForm = null;
            }
        }

        private void 显示输出ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Output output = new Output();
            output.MdiParent = this;
            output.Show();
        }

        private void 文件ToolStripMenuItem_Click(object sender, EventArgs e)
        {

        }

        //input script
        private void 脚本ToolStripMenuItem_Click(object sender, EventArgs e)
        {

            try
            {
                OpenFileDialog openFileDialog1 = new OpenFileDialog();
                openFileDialog1.Title = "选择脚本文件";
                openFileDialog1.Filter = "Txt files (*.txt)|*.txt|All files (*.*)|*.*";
                openFileDialog1.RestoreDirectory = true;
                openFileDialog1.Multiselect = false;

                if (openFileDialog1.ShowDialog() == DialogResult.OK)
                {
                    String name = System.IO.Path.GetFileName(openFileDialog1.FileName);
                    String src = System.IO.Path.GetDirectoryName(openFileDialog1.FileName)+"\\";
                    String dst = Application.StartupPath + "\\script\\";
                    
                    System.IO.File.Copy(src+name,dst+name,true);
                }
            }
            catch (Exception err)
            {
                MessageBox.Show("脚本导入错误："+err.Message);
            }
        }
        // del script
        private void 删除ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            try
            {
                String name = Application.StartupPath + "\\script\\" + toolStripComboBox1.Text;

                if (File.Exists(name))
                {
                    if (MessageBox.Show(
                        "确认删除\""+toolStripComboBox1.Text+"\"？", 
                        "Wanning", 
                        MessageBoxButtons.OKCancel, 
                        MessageBoxIcon.Warning, 
                        MessageBoxDefaultButton.Button2
                        ) == DialogResult.OK)
                    {
                        System.IO.File.Delete(name);
                        toolStripComboBox1.Text = "";
                        toolStripComboBox1.Items.Clear();
                    }
                }

               
            }
            catch (Exception err) {
                MessageBox.Show("脚本删除错误：" + err.Message);
            }
        }

      

     





    }
}
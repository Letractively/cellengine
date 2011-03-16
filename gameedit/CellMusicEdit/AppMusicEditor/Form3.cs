using System;
using System.Drawing;
using System.Collections;
using System.ComponentModel;
using System.Windows.Forms;

namespace Cell.AppMusicEditor
{
	/// <summary>
	/// Form3 ��ժҪ˵����
	/// </summary>
	public class Form3 : System.Windows.Forms.Form
	{
		private RichTextBox[]	rtext;
		private TabPage[]		tp;
		private System.Windows.Forms.TabControl tabControl1;
		/// <summary>
		/// ����������������
		/// </summary>
		private System.ComponentModel.Container components = null;


		public Form3(string[][] data)
		{
			//
			// Windows ���������֧���������
			//
			InitializeComponent();

			//
			// TODO: �� InitializeComponent ���ú�����κι��캯������
			//

			if(data.Length<1)return ;
			
			this.rtext = new RichTextBox[data.Length];
			this.tp = new TabPage[data.Length];

			for(int i=0;i<data.Length;i++)
			{
				if(data[i].Length<2)return ;

				this.rtext[i] = new RichTextBox();
				this.rtext[i].Dock = System.Windows.Forms.DockStyle.Fill;
				this.rtext[i].Location = new System.Drawing.Point(0, 0);
				this.rtext[i].Name = "richTextBox1";
				this.rtext[i].Size = new System.Drawing.Size(488, 241);
				this.rtext[i].TabIndex = 0;
				this.rtext[i].ReadOnly = true;
				this.rtext[i].Text = data[i][1];

				this.tp[i] = new TabPage();
				this.tp[i].Controls.Add(this.rtext[i]);
				this.tp[i].Location = new System.Drawing.Point(4, 21);
				this.tp[i].Name = "tabPage1";
				this.tp[i].Size = new System.Drawing.Size(488, 241);
				this.tp[i].TabIndex = 0;
				this.tp[i].Text = data[i][0];

				
				tabControl1.Controls.Add(tp[i]);
			}
			

		}

		/// <summary>
		/// ������������ʹ�õ���Դ��
		/// </summary>
		/// 
		
		protected override void Dispose( bool disposing )
		{
			if( disposing )
			{
				if(components != null)
				{
					components.Dispose();
				}
			}
			base.Dispose( disposing );
		}

		#region Windows ������������ɵĴ���
		/// <summary>
		/// �����֧������ķ��� - ��Ҫʹ�ô���༭���޸�
		/// �˷��������ݡ�
		/// </summary>
		private void InitializeComponent()
		{
			this.tabControl1 = new System.Windows.Forms.TabControl();
			this.SuspendLayout();
			// 
			// tabControl1
			// 
			this.tabControl1.Dock = System.Windows.Forms.DockStyle.Fill;
			this.tabControl1.ItemSize = new System.Drawing.Size(60, 17);
			this.tabControl1.Location = new System.Drawing.Point(0, 0);
			this.tabControl1.Name = "tabControl1";
			this.tabControl1.SelectedIndex = 0;
			this.tabControl1.Size = new System.Drawing.Size(496, 266);
			this.tabControl1.TabIndex = 0;
			this.tabControl1.SelectedIndexChanged += new System.EventHandler(this.tabControl1_SelectedIndexChanged);
			// 
			// Form3
			// 
			this.AutoScaleBaseSize = new System.Drawing.Size(6, 14);
			this.AutoScroll = true;
			this.ClientSize = new System.Drawing.Size(496, 266);
			this.Controls.Add(this.tabControl1);
			this.Name = "Form3";
			this.ShowInTaskbar = false;
			this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
			this.Text = "Info";
			this.TopMost = true;
			this.Load += new System.EventHandler(this.Form3_Load);
			this.ResumeLayout(false);

		}
		#endregion

		private void richTextBox1_TextChanged(object sender, System.EventArgs e)
		{
		
		}

		private void Form3_Load(object sender, System.EventArgs e)
		{
			
		}

		private void tabControl1_SelectedIndexChanged(object sender, System.EventArgs e)
		{
		
		}
	}
}

namespace CellGameEdit.PM
{
    partial class ObjectForm
    {
        /// <summary>
        /// 必需的设计器变量。
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// 清理所有正在使用的资源。
        /// </summary>
        /// <param name="disposing">如果应释放托管资源，为 true；否则为 false。</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows 窗体设计器生成的代码

        /// <summary>
        /// 设计器支持所需的方法 - 不要
        /// 使用代码编辑器修改此方法的内容。
        /// </summary>
        private void InitializeComponent()
        {
            this.SuspendLayout();
            // 
            // ObjectForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(703, 434);
            this.Location = new System.Drawing.Point(180, 3);
            this.Name = "ObjectForm";
            this.StartPosition = System.Windows.Forms.FormStartPosition.Manual;
            this.Text = "ObjectForm";
            this.FormClosing += new System.Windows.Forms.FormClosingEventHandler(this.ObjectForm_FormClosing);
            this.Load += new System.EventHandler(this.ObjectForm_Load);
            this.ResumeLayout(false);

        }

        #endregion

    }
}

namespace CellGameEdit.PM
{
    partial class ProjectForm
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
            this.components = new System.ComponentModel.Container();
            this.resMenu = new System.Windows.Forms.ContextMenuStrip(this.components);
            this.添加图片组ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.levelMenu = new System.Windows.Forms.ContextMenuStrip(this.components);
            this.添加场景ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.tileMenu = new System.Windows.Forms.ContextMenuStrip(this.components);
            this.打开ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.添加ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.精灵ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.地图ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.删除ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.subMenu = new System.Windows.Forms.ContextMenuStrip(this.components);
            this.打开ToolStripMenuItem1 = new System.Windows.Forms.ToolStripMenuItem();
            this.删除ToolStripMenuItem1 = new System.Windows.Forms.ToolStripMenuItem();
            this.treeView1 = new System.Windows.Forms.TreeView();
            this.resMenu.SuspendLayout();
            this.levelMenu.SuspendLayout();
            this.tileMenu.SuspendLayout();
            this.subMenu.SuspendLayout();
            this.SuspendLayout();
            // 
            // resMenu
            // 
            this.resMenu.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.添加图片组ToolStripMenuItem});
            this.resMenu.Name = "resMenu";
            this.resMenu.Size = new System.Drawing.Size(131, 26);
            // 
            // 添加图片组ToolStripMenuItem
            // 
            this.添加图片组ToolStripMenuItem.Name = "添加图片组ToolStripMenuItem";
            this.添加图片组ToolStripMenuItem.Size = new System.Drawing.Size(130, 22);
            this.添加图片组ToolStripMenuItem.Text = "添加图片组";
            this.添加图片组ToolStripMenuItem.Click += new System.EventHandler(this.添加图片组ToolStripMenuItem_Click);
            // 
            // levelMenu
            // 
            this.levelMenu.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.添加场景ToolStripMenuItem});
            this.levelMenu.Name = "levelMenu";
            this.levelMenu.Size = new System.Drawing.Size(119, 26);
            // 
            // 添加场景ToolStripMenuItem
            // 
            this.添加场景ToolStripMenuItem.Name = "添加场景ToolStripMenuItem";
            this.添加场景ToolStripMenuItem.Size = new System.Drawing.Size(118, 22);
            this.添加场景ToolStripMenuItem.Text = "添加场景";
            this.添加场景ToolStripMenuItem.Click += new System.EventHandler(this.添加场景ToolStripMenuItem_Click);
            // 
            // tileMenu
            // 
            this.tileMenu.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.打开ToolStripMenuItem,
            this.添加ToolStripMenuItem,
            this.删除ToolStripMenuItem});
            this.tileMenu.Name = "tileMenu";
            this.tileMenu.Size = new System.Drawing.Size(95, 70);
            // 
            // 打开ToolStripMenuItem
            // 
            this.打开ToolStripMenuItem.Name = "打开ToolStripMenuItem";
            this.打开ToolStripMenuItem.Size = new System.Drawing.Size(94, 22);
            this.打开ToolStripMenuItem.Text = "打开";
            this.打开ToolStripMenuItem.Click += new System.EventHandler(this.打开ToolStripMenuItem_Click);
            // 
            // 添加ToolStripMenuItem
            // 
            this.添加ToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.精灵ToolStripMenuItem,
            this.地图ToolStripMenuItem});
            this.添加ToolStripMenuItem.Name = "添加ToolStripMenuItem";
            this.添加ToolStripMenuItem.Size = new System.Drawing.Size(94, 22);
            this.添加ToolStripMenuItem.Text = "添加";
            // 
            // 精灵ToolStripMenuItem
            // 
            this.精灵ToolStripMenuItem.Name = "精灵ToolStripMenuItem";
            this.精灵ToolStripMenuItem.Size = new System.Drawing.Size(94, 22);
            this.精灵ToolStripMenuItem.Text = "精灵";
            this.精灵ToolStripMenuItem.Click += new System.EventHandler(this.精灵ToolStripMenuItem_Click);
            // 
            // 地图ToolStripMenuItem
            // 
            this.地图ToolStripMenuItem.Name = "地图ToolStripMenuItem";
            this.地图ToolStripMenuItem.Size = new System.Drawing.Size(94, 22);
            this.地图ToolStripMenuItem.Text = "地图";
            this.地图ToolStripMenuItem.Click += new System.EventHandler(this.地图ToolStripMenuItem_Click);
            // 
            // 删除ToolStripMenuItem
            // 
            this.删除ToolStripMenuItem.Name = "删除ToolStripMenuItem";
            this.删除ToolStripMenuItem.Size = new System.Drawing.Size(94, 22);
            this.删除ToolStripMenuItem.Text = "删除";
            this.删除ToolStripMenuItem.Click += new System.EventHandler(this.删除ToolStripMenuItem_Click);
            // 
            // subMenu
            // 
            this.subMenu.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.打开ToolStripMenuItem1,
            this.删除ToolStripMenuItem1});
            this.subMenu.Name = "mapMenu";
            this.subMenu.Size = new System.Drawing.Size(95, 48);
            // 
            // 打开ToolStripMenuItem1
            // 
            this.打开ToolStripMenuItem1.Name = "打开ToolStripMenuItem1";
            this.打开ToolStripMenuItem1.Size = new System.Drawing.Size(94, 22);
            this.打开ToolStripMenuItem1.Text = "打开";
            this.打开ToolStripMenuItem1.Click += new System.EventHandler(this.打开ToolStripMenuItem1_Click);
            // 
            // 删除ToolStripMenuItem1
            // 
            this.删除ToolStripMenuItem1.Name = "删除ToolStripMenuItem1";
            this.删除ToolStripMenuItem1.Size = new System.Drawing.Size(94, 22);
            this.删除ToolStripMenuItem1.Text = "删除";
            this.删除ToolStripMenuItem1.Click += new System.EventHandler(this.删除ToolStripMenuItem1_Click);
            // 
            // treeView1
            // 
            this.treeView1.AllowDrop = true;
            this.treeView1.Dock = System.Windows.Forms.DockStyle.Fill;
            this.treeView1.LabelEdit = true;
            this.treeView1.Location = new System.Drawing.Point(0, 0);
            this.treeView1.Name = "treeView1";
            this.treeView1.Size = new System.Drawing.Size(150, 480);
            this.treeView1.TabIndex = 9;
            this.treeView1.NodeMouseDoubleClick += new System.Windows.Forms.TreeNodeMouseClickEventHandler(this.treeView1_NodeMouseDoubleClick);
            this.treeView1.AfterLabelEdit += new System.Windows.Forms.NodeLabelEditEventHandler(this.treeView1_AfterLabelEdit);
            this.treeView1.NodeMouseClick += new System.Windows.Forms.TreeNodeMouseClickEventHandler(this.treeView1_NodeMouseClick);
            this.treeView1.BeforeLabelEdit += new System.Windows.Forms.NodeLabelEditEventHandler(this.treeView1_BeforeLabelEdit);
            this.treeView1.ItemDrag += new System.Windows.Forms.ItemDragEventHandler(this.treeView1_ItemDrag);
            // 
            // ProjectForm
            // 
            this.AllowDrop = true;
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.AutoScroll = true;
            this.ClientSize = new System.Drawing.Size(150, 480);
            this.Controls.Add(this.treeView1);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.Fixed3D;
            this.Location = new System.Drawing.Point(3, 3);
            this.Name = "ProjectForm";
            this.StartPosition = System.Windows.Forms.FormStartPosition.Manual;
            this.Text = "ProjectForm";
            this.FormClosed += new System.Windows.Forms.FormClosedEventHandler(this.ProjectForm_FormClosed);
            this.Shown += new System.EventHandler(this.ProjectForm_Shown);
            this.resMenu.ResumeLayout(false);
            this.levelMenu.ResumeLayout(false);
            this.tileMenu.ResumeLayout(false);
            this.subMenu.ResumeLayout(false);
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.TreeView treeView1;
        private System.Windows.Forms.ContextMenuStrip resMenu;
        private System.Windows.Forms.ToolStripMenuItem 添加图片组ToolStripMenuItem;
        private System.Windows.Forms.ContextMenuStrip levelMenu;
        private System.Windows.Forms.ToolStripMenuItem 添加场景ToolStripMenuItem;
        private System.Windows.Forms.ContextMenuStrip tileMenu;
        private System.Windows.Forms.ToolStripMenuItem 打开ToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem 添加ToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem 精灵ToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem 地图ToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem 删除ToolStripMenuItem;
        private System.Windows.Forms.ContextMenuStrip subMenu;
        private System.Windows.Forms.ToolStripMenuItem 打开ToolStripMenuItem1;
        private System.Windows.Forms.ToolStripMenuItem 删除ToolStripMenuItem1;
    }
}
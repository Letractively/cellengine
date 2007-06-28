using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using System.Collections;
using System.Runtime.Serialization;
using System.Security.Permissions;
using System.Runtime.Serialization.Formatters;
using System.IO;

namespace CellGameEdit.PM
{
    [Serializable]
    public partial class CommandForm : Form, ISerializable ,IEditForm
    {
        public string id;
        
        ArrayList Tables = new ArrayList();
        ArrayList Pages = new ArrayList();

        Hashtable tablemap = new Hashtable();
   


//-----------------------------------------------------------------------------------------------------------------------------------

        public CommandForm(String name)
        {
            InitializeComponent();

            id = name;
            this.Text = id;
            
        }

        [SecurityPermissionAttribute(SecurityAction.Demand, SerializationFormatter = true)]
        protected CommandForm(SerializationInfo info, StreamingContext context)
        {
            InitializeComponent();
           
            
            try
            {
                id = (String)info.GetValue("id", typeof(String));
                this.Text = id;

                int TableCount = (int)info.GetValue("TableCount", typeof(int));
                ArrayList TableNames = (ArrayList)info.GetValue("TableNames", typeof(ArrayList));

                for (int i = 0; i < TableCount; i++)
                {
                    String name = (String)TableNames[i];

                    appendTable(name);

                    ArrayList heads = (ArrayList)info.GetValue("heads" + i, typeof(ArrayList));
                    ArrayList cells = (ArrayList)info.GetValue("cells" + i, typeof(ArrayList));
                    int ColumnsCount = (int)info.GetValue("ColumnsCount" + i, typeof(int));
                    int RowsCount = (int)info.GetValue("RowsCount" + i, typeof(int));

                    for (int c = 0; c < ColumnsCount; c++)
                    {
                        string head = (String)heads[c];
                        getTable(i).Columns.Add(c.ToString(), head);
                    }

                    for (int r = 0; r < RowsCount; r++)
                    {
                        string[] row = new string[ColumnsCount];

                        for (int c = 0; c < ColumnsCount; c++)
                        {
                            int ci = r * ColumnsCount + c;
                            row[c] = (String)cells[ci];
                        }

                       getTable(i).Rows.Add(row);
                    }
                


                }
              
                

            }catch(Exception err){
                Console.WriteLine(this.id + " : " + err.StackTrace + "  at  " + err.Message);
            }
        }

        [SecurityPermissionAttribute(SecurityAction.Demand, SerializationFormatter = true)]
        public virtual void GetObjectData(SerializationInfo info, StreamingContext context)
        {
           
           info.AddValue("id", id);

           info.AddValue("TableCount",getTableCount());

           ArrayList TableNames = new ArrayList();

           for (int i = 0; i < getTableCount(); i++)
           {
               TableNames.Add(getTableName(i));

               ArrayList heads = new ArrayList();
               ArrayList cells = new ArrayList();
               int ColumnsCount = getTable(i).Columns.Count;
               int RowsCount = getTable(i).Rows.Count - 1;

               for (int c = 0; c < ColumnsCount; c++)
               {
                   string head = getHeadText(i,c);
                   heads.Add(head);
               }

               for (int r = 0; r < RowsCount; r++)
               {
                   for (int c = 0; c < getTable(i).Columns.Count; c++)
                   {
                       int ci = r * getTable(i).Columns.Count + c;
                       string cell = getCellText(i, r, c);
                       if (cell == null) cell = "";
                       cells.Add(cell);
                   }
               }

               info.AddValue("heads" + i, heads);
               info.AddValue("cells" + i, cells);
               info.AddValue("ColumnsCount" + i, ColumnsCount);
               info.AddValue("RowsCount" + i, RowsCount);
           }

           info.AddValue("TableNames", TableNames);
           
        }

        public void OutputCustom(int index, String src, System.IO.StringWriter output)
        {
            lock (this)
            {
                String tableGroup = src.Substring(0, src.Length);
                try
                {
                    string command = Util.getTopTrunk(tableGroup, "#<TABLE GROUP>", "#<END TABLE GROUP>");
                    if (command != null)
                    {
                        bool fix = false;
                        do
                        {
                            fix = false;
                            string table = fillScriptSub(command, "#<TABLE>", "#<END TABLE>");
                            if (table != null) { command = table; fix = true; }

                        } while (fix);

                        command = Util.replaceKeywordsScript(command, "#<TABLE GROUP>", "#<END TABLE GROUP>",
                             new string[] { 
                            "<TABLE GROUP NAME>", 
                            "<TABLE GROUP INDEX>",
                            "<TABLE COUNT>",
                            },
                            new string[] { 
                                this.id, 
                                index.ToString(),
                                getTableCount().ToString(),
                            }
                            );
                        tableGroup = Util.replaceSubTrunksScript(tableGroup, "#<TABLE GROUP>", "#<END TABLE GROUP>", new string[] { command });

                        output.WriteLine(tableGroup);
                    }
                }
                catch (Exception err) { Console.WriteLine(this.id + " : " + err.StackTrace + "  at  " + err.Message); }

            }
        }

        private string fillScriptSub(string src, string start, string end)
        {
            string script = src.Substring(0, src.Length);
            string sub = Util.getTopTrunk(script, start, end);
            if (sub == null) return null;

            ArrayList scripts = new ArrayList();
            try
            {
                for (int i = 0; i < getTableCount(); i++)
                {
                    String node = outputSubTable(i,sub);
                    scripts.Add(node);
                }
            }
            catch (Exception err) { MessageBox.Show(err.StackTrace + "  at  " + err.Message); }

            script = Util.replaceSubTrunksScript(script, start, end, (string[])scripts.ToArray(typeof(string)));

            return script;
        }

        private String outputSubTable(int index, String script)
        {
          
            int ColumnsCount = getTable(index).Columns.Count;
            int RowsCount = getTable(index).Rows.Count - 1;

            String[][] cell_matrix_c_r = new string[ColumnsCount][];
            for (int c = 0; c < ColumnsCount; c++)
            {
                cell_matrix_c_r[c] = new string[RowsCount];
                for (int r = 0; r < RowsCount; r++)
                {
                    cell_matrix_c_r[c][r] = getCellText(index, r, c);
                }
            }

            String[][] cell_matrix_r_c = new string[RowsCount][];
            for (int r = 0; r < RowsCount; r++)
            {
                cell_matrix_r_c[r] = new string[ColumnsCount];
                for (int c = 0; c < ColumnsCount; c++)
                {
                    cell_matrix_r_c[r][c] = getCellText(index, r, c);
                }
            }


            try
            {
                String table = Util.getFullTrunkScript(script, "#<TABLE>", "#<END TABLE>");

                bool fix = false;

                // column heads
                do
                {

                    String[] heads = new string[ColumnsCount];

                    for (int c = 0; c < heads.Length; c++)
                    {
                        string TEXT = getHeadText(index, c);

                        heads[c] = Util.replaceKeywordsScript(table, "#<COLUMN HEAD>", "#<END COLUMN HEAD>",
                            new string[] { "<INDEX>", "<TEXT>" },
                            new string[] { c.ToString(), TEXT }
                            );
                    }
                    string temp = Util.replaceSubTrunksScript(table, "#<COLUMN HEAD>", "#<END COLUMN HEAD>", heads);
                    if (temp == null)
                    {
                        fix = false;
                    }
                    else
                    {
                        fix = true;
                        table = temp;
                    }
                } while (fix);

                // cells
                do
                {
                    String[] cells = new string[ColumnsCount * RowsCount];
                    for (int r = 0; r < RowsCount; r++)
                    {
                        for (int c = 0; c < ColumnsCount; c++)
                        {
                            int i = r * ColumnsCount + c;

                            string TEXT = getCellText(index, r, c);
                            if (TEXT == null) TEXT = "";
                            cells[i] = Util.replaceKeywordsScript(table, "#<CELL>", "#<END CELL>",
                                new string[] { "<COLUMN INDEX>", "<ROW INDEX>", "<TEXT>" },
                                new string[] { c.ToString(), r.ToString(), TEXT }
                                );
                        }

                    }
                    string temp = Util.replaceSubTrunksScript(table, "#<CELL>", "#<END CELL>", cells);
                    if (temp == null)
                    {
                        fix = false;
                    }
                    else
                    {
                        fix = true;
                        table = temp;
                    }
                } while (fix);

                // rows
                //#<ROWS>                /* 表行数据 开始 横向输出 */
                //    <INDEX>                /* (int)行 号码 */
                //    <ARRAY>                /* (obj)[]行 数据*/
                //    <ARRAY STR>            /* (str)[]行 数据*/
                //    <ARRAY NUM>            /* (int)[]行 数据*/
                //    <ARRAY SMART>          /* (ato)[]行 数据*/
                //#<END ROWS>            /* 表行数据 结束*/
                do
                {
                    String[] rows = new string[RowsCount];
                    for (int r = 0; r < RowsCount; r++)
                    {
                        string ARRAY = Util.toArray1D(ref cell_matrix_r_c[r]);
                        string ARRAY_NUM = Util.toNumberArray1D(ref cell_matrix_r_c[r]);
                        string ARRAY_STR = Util.toStringArray1D(ref cell_matrix_r_c[r]);
                        string ARRAY_SMART = Util.toSmartArray1D(ref cell_matrix_r_c[r]);

                        rows[r] = Util.replaceKeywordsScript(table, "#<ROWS>", "#<END ROWS>",
                            new string[] { "<INDEX>", "<ARRAY>", "<ARRAY STR>", "<ARRAY NUM>", "<ARRAY SMART>" },
                            new string[] { r.ToString(), ARRAY, ARRAY_STR, ARRAY_NUM, ARRAY_SMART }
                            );
                    }
                    string temp = Util.replaceSubTrunksScript(table, "#<ROWS>", "#<END ROWS>", rows);
                    if (temp == null)
                    {
                        fix = false;
                    }
                    else
                    {
                        fix = true;
                        table = temp;
                    }
                } while (fix);


                // columns
                //#<COLUMNS>             /* 表列数据 开始 纵向输出 */
                //    <INDEX>                /* (int)列 号码 */
                //    <ARRAY>                /* (obj)[]列 数据*/
                //    <ARRAY STR>            /* (str)[]列 数据*/
                //    <ARRAY NUM>            /* (int)[]列 数据*/
                //    <ARRAY SMART>          /* (ato)[]列 数据*/
                //#<END COLUMNS>         /* 表列数据 结束*/
                do
                {
                    String[] columns = new string[ColumnsCount];
                    for (int c = 0; c < ColumnsCount; c++)
                    {
                        string ARRAY = Util.toArray1D(ref cell_matrix_c_r[c]);
                        string ARRAY_NUM = Util.toNumberArray1D(ref cell_matrix_c_r[c]);
                        string ARRAY_STR = Util.toStringArray1D(ref cell_matrix_c_r[c]);
                        string ARRAY_SMART = Util.toSmartArray1D(ref cell_matrix_c_r[c]);

                        columns[c] = Util.replaceKeywordsScript(table, "#<COLUMNS>", "#<END COLUMNS>",
                            new string[] { "<INDEX>", "<ARRAY>", "<ARRAY STR>", "<ARRAY NUM>", "<ARRAY SMART>" },
                            new string[] { c.ToString(), ARRAY, ARRAY_STR, ARRAY_NUM, ARRAY_SMART }
                            );
                    }
                    string temp = Util.replaceSubTrunksScript(table, "#<COLUMNS>", "#<END COLUMNS>", columns);
                    if (temp == null)
                    {
                        fix = false;
                    }
                    else
                    {
                        fix = true;
                        table = temp;
                    }
                } while (fix);




                //matrix
                string matrix = Util.toArray2D(ref cell_matrix_r_c);
                string strMatrix = Util.toStringArray2D(ref cell_matrix_r_c);
                string numMatrix = Util.toNumberArray2D(ref cell_matrix_r_c);
                string smartMatrix = Util.toSmartArray2D(ref cell_matrix_r_c);

                table = Util.replaceKeywordsScript(table, "#<TABLE>", "#<END TABLE>",
                    new string[] { 
                            "<TABLE NAME>", 
                            "<TABLE INDEX>",
                            "<COLUMN COUNT>",
                            "<ROW COUNT>",
                            "<TABLE MATRIX> ",
                            "<TABLE MATRIX STR>",         /*(str)[][] 表文字二维数组 */
                            "<TABLE MATRIX NUM>",         /*(str)[][] 表数字二维数组 */
                            "<TABLE MATRIX SMART>",       /*(str)[][] 表自动二维数组 */
                        },
                    new string[] { 
                            getTableName(index), 
                            index.ToString(),
                            ColumnsCount.ToString(),
                            RowsCount.ToString(),
                            matrix,
                            strMatrix,
                            numMatrix,
                            smartMatrix,
                        }
                 );

                return table;

            }
            catch (Exception err) { Console.WriteLine(this.id + " : " + err.StackTrace + "  at  " + err.Message); }

            return "";

        }

        private void CommandForm_FormClosing(object sender, FormClosingEventArgs e)
        {
            if (e.CloseReason == CloseReason.UserClosing)
            {
                e.Cancel = true;
                this.Hide();
            }
        }

        public String getID()
        {
            return id;
        }

        public Form getForm()
        {
            return this;
        }

//-----------------------------------------------------------------------------------------------------------------------------------
        private int getTableCount()
        {
            try
            {
                return Pages.Count;
            }
            catch (Exception err)
            {
                Console.WriteLine(this.id + " : " + err.StackTrace + "  at  " + err.Message);
                return -1;
            }
        }

        private DataGridView getTable(TabPage head)
        {
            try
            {
                DataGridView table = (DataGridView)tablemap[head];
                return table;
            }
            catch (Exception err)
            {
                Console.WriteLine(this.id + " : " + err.StackTrace + "  at  " + err.Message);
                return null;
            }
        }

        private DataGridView getTable(int index)
        {
            try
            {
                DataGridView table = (DataGridView)tablemap[tabControl1.TabPages[index]];
                return table;
            }
            catch (Exception err)
            {
                Console.WriteLine(this.id + " : " + err.StackTrace + "  at  " + err.Message);
                return null;
            }
        }


        private String getTableName(int index)
        {
            try
            {
                return tabControl1.TabPages[index].Text;
            }
            catch (Exception err)
            {
                Console.WriteLine(this.id + " : " + err.StackTrace + "  at  " + err.Message);
                return null;
            }
        }

        private DataGridView getCurTable()
        {
            return getTable(tabControl1.SelectedTab);
        }

        private TabPage getCurPage()
        {
            return tabControl1.SelectedTab;
        }

        private void addTable(String name)
        {
            if (getTableCount() > 0)
            {
                appendTable(name);

                for (int c = 0; c < getTable(getTableCount() - 2).Columns.Count; c++)
                {
                    string chead = getTable(getTableCount() - 2).Columns[c].HeaderText;
                    string cname = getTable(getTableCount() - 2).Columns[c].Name;
                    getTable(getTableCount() - 1).Columns.Add(cname, chead);
                }
                getTable(getTableCount() - 1).AutoSizeColumnsMode = getTable(getTableCount() - 2).AutoSizeColumnsMode;

                //for (int r = 0; r < getTable(getTableCount() - 2).Rows.Count-1; r++)
                //{
                //    string[] row = new string[getTable(getTableCount() - 2).Columns.Count];

                //    for (int c = 0; c < getTable(getTableCount() - 2).Columns.Count; c++)
                //    {
                //        int ci = r * getTable(getTableCount() - 2).Columns.Count + c;
                //        row[c] = getCellText(getTableCount() - 2, r, c);
                //    }

                //    getTable(getTableCount() - 1).Rows.Add(row);
                //}
                

            }
            else
            {
                appendTable(name);
            }
        }


        private void appendTable(String name)
        {
            //datagridview
            DataGridView table = new System.Windows.Forms.DataGridView();
            table.AllowUserToOrderColumns = true;
            table.AutoSizeColumnsMode = System.Windows.Forms.DataGridViewAutoSizeColumnsMode.None;
            table.ClipboardCopyMode = System.Windows.Forms.DataGridViewClipboardCopyMode.EnableAlwaysIncludeHeaderText;
            table.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            table.Dock = System.Windows.Forms.DockStyle.Fill;
            table.EditMode = System.Windows.Forms.DataGridViewEditMode.EditOnEnter;
            table.Location = new System.Drawing.Point(3, 3);
            table.Name = name;
            table.RowTemplate.Height = 23;
            table.Size = new System.Drawing.Size(632, 350);
            table.CellClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.dataGridView1_CellClick);
            table.ColumnHeaderMouseClick += new System.Windows.Forms.DataGridViewCellMouseEventHandler(this.dataGridView1_ColumnHeaderMouseClick);
            table.RowHeaderMouseClick += new System.Windows.Forms.DataGridViewCellMouseEventHandler(this.dataGridView1_RowHeaderMouseClick);
            //table.ColumnDisplayIndexChanged += new System.Windows.Forms.DataGridViewColumnEventHandler(this.dataGridView1_ColumnDisplayIndexChanged);
            table.CellContentClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.dataGridView1_CellContentClick);


            // tabpage
            TabPage tabPage = new System.Windows.Forms.TabPage();
            tabPage.Location = new System.Drawing.Point(4, 22);
            tabPage.Name = name;
            tabPage.Padding = new System.Windows.Forms.Padding(3);
            tabPage.Size = new System.Drawing.Size(638, 356);
            //tabPage.TabIndex = 0;
            tabPage.Text = tabPage.Name;
            //tabPage.UseVisualStyleBackColor = true;
            //tabPage.ContextMenuStrip = this.tableMenu;

            // data set
            Tables.Add(table);
            Pages.Add(tabPage);
            tablemap.Add(tabPage, table);

            tabPage.Controls.Add(table);
            tabControl1.Controls.Add(tabPage);
        }

//-----------------------------------------------------------------------------------------------------------------------------------


        private string getCellText(int index,int r,int c)
        {   
            string text = "";
            try
            {
                int dc = c;
                if (getTable(index).Columns[c].DisplayIndex != c)
                {
                    foreach (DataGridViewColumn column in getTable(index).Columns)
                    {
                        if (column.DisplayIndex == c)
                        {
                            dc = getTable(index).Columns.IndexOf(column);
                            break;
                        }
                    }
                }
                text = getTable(index).Rows[r].Cells[dc].Value.ToString();
            }
            catch (Exception err)
            {
                text = "";
            }
            return text;
        }

        private string getHeadText(int index, int c)
        {
            string text = "";
            try
            {
                int dc = c;
                if (getTable(index).Columns[c].DisplayIndex != c)
                {
                    foreach (DataGridViewColumn column in getTable(index).Columns)
                    {
                        if (column.DisplayIndex == c)
                        {
                            dc = getTable(index).Columns.IndexOf(column);
                            break;
                        }
                    }
                }
                text = getTable(index).Columns[dc].HeaderText;
            }
            catch (Exception err)
            {
                text = "";
            }
            return text;
        }

        private DataGridViewColumn getColumn(int index, int c)
        {
            try
            {
                int dc = c;
                if (getTable(index).Columns[c].DisplayIndex != c)
                {
                    foreach (DataGridViewColumn column in getTable(index).Columns)
                    {
                        if (column.DisplayIndex == c)
                        {
                            return column;
                        }
                    }
                }
                else
                {
                    return getTable(index).Columns[c];
                }
            }
            catch (Exception err)
            {
            }
            return null;
        }

//----------------------------------------------------------------------------------------------------------------------------------------------------------


        // add column
        private void 文本ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            String name = "ColumnName";
            TextDialog nameDialog = new TextDialog(name);
            if (nameDialog.ShowDialog() == DialogResult.OK)
            {
                for (int i = 0; i < getTableCount(); i++)
                {
                    getTable(i).Columns.Add(getTable(i).ColumnCount.ToString(), nameDialog.getText());
                }
            }
        }

        // delete column
        int PopedColumnIndex = -1;
        private void dataGridView1_ColumnHeaderMouseClick(object sender, DataGridViewCellMouseEventArgs e)
        {
            if (e.Button == MouseButtons.Right)
            {
                PopedColumnIndex = e.ColumnIndex;
                columnMenu.Show(
                    getCurTable(),
                    e.Location.X + getCurTable().GetColumnDisplayRectangle(e.ColumnIndex, false).Location.X,
                    e.Location.Y + getCurTable().GetColumnDisplayRectangle(e.ColumnIndex, false).Location.Y
                    );
            }

        }
        private void dataGridView1_ColumnDisplayIndexChanged(object sender, DataGridViewColumnEventArgs e)
        {
            try
            {

                //int dst = e.Column.DisplayIndex;
                //int src = Int32.Parse(e.Column.Name);
                //e.Column.Name = dst.ToString();

                //Console.WriteLine(" column=" + dst);

                //for (int i = 0; i < getTableCount(); i++)
                //{
                //    if (i != Tables.IndexOf(e.Column.DataGridView))
                //    {
                //        getColumn(i, src).DisplayIndex = dst;
                //    }
                //}

            }
            catch (Exception err)
            {
            }


        }


        private void 删除ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            try
            {
                for (int i = 0; i < getTableCount(); i++)
                {
                    getTable(i).Columns.RemoveAt(PopedColumnIndex);
                }
                
            }
            catch (Exception err) { }
        }

        private void 重命名列ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            try
            {
                String name = getCurTable().Columns[PopedColumnIndex].HeaderText;
                TextDialog nameDialog = new TextDialog(name);
                if (nameDialog.ShowDialog() == DialogResult.OK)
                {
                    for (int i = 0; i < getTableCount(); i++)
                    {
                        getTable(i).Columns[PopedColumnIndex].HeaderText = nameDialog.getText();
                    }
                }
                
            }
            catch (Exception err) { }
        }


        // delete row
        int PopedRowIndex = -1;
        private void dataGridView1_RowHeaderMouseClick(object sender, DataGridViewCellMouseEventArgs e)
        {
            if (e.Button == MouseButtons.Right)
            {
                PopedRowIndex = e.RowIndex;
                rowMenu.Show(
                    getCurTable(),
                    e.Location.X + getCurTable().GetRowDisplayRectangle(e.RowIndex, false).Location.X,
                    e.Location.Y + getCurTable().GetRowDisplayRectangle(e.RowIndex, false).Location.Y
                    );
            }
        }

        private void 删除行ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            try
            {
                //for (int i = 0; i < getTableCount(); i++)
                //{
                    getCurTable().Rows.RemoveAt(PopedRowIndex);
                //}
                
                
            }
            catch (Exception err) { }
        }

        private void dataGridView1_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }
        private void dataGridView1_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            dataLable.Text = "表=" + tabControl1.TabPages.IndexOf(getCurPage());
            dataLable.Text += " 行=" + e.RowIndex;
            try
            {
                dataLable.Text += " 列=" + getCurTable().Columns[e.ColumnIndex].DisplayIndex;
            }
            catch (Exception err)
            {
            }
        }

//----------------------------------------------------------------------------------------------------------------------------------------------------------



       
        private void 表头样式_DropDownOpening(object sender, EventArgs e)
        {
            try
            {
                 DataGridViewAutoSizeColumnMode[] ColumnModes = new DataGridViewAutoSizeColumnMode[]
                {
                    DataGridViewAutoSizeColumnMode.None,
                    DataGridViewAutoSizeColumnMode.AllCells,
                    DataGridViewAutoSizeColumnMode.AllCellsExceptHeader,
                    DataGridViewAutoSizeColumnMode.ColumnHeader,
                    DataGridViewAutoSizeColumnMode.DisplayedCells,
                    DataGridViewAutoSizeColumnMode.DisplayedCellsExceptHeader,
                    DataGridViewAutoSizeColumnMode.Fill,
                };

                表头样式.DropDownItems.Clear();

                for (int i = 0; i < ColumnModes.Length; i++)
                {
                    ToolStripMenuItem item = new ToolStripMenuItem();
                    item.Text = ColumnModes[i].ToString();
                    item.AutoSize = true;
                    item.Click += new EventHandler(表头样式Item_Click);
                    表头样式.DropDownItems.Add(item);
                    item.Tag = ColumnModes[i];
                }
             
                
            }
            catch (Exception err)
            {
            }

        }
        private void 表头样式Item_Click(object sender, EventArgs e)
        {
            try{
                ToolStripMenuItem item = (ToolStripMenuItem)sender;
                for (int i = 0; i < getTableCount(); i++)
                {
                    getTable(i).AutoSizeColumnsMode = (DataGridViewAutoSizeColumnsMode)item.Tag;
                }

            }catch(Exception err){
            }
        }

       
        private void 添加表ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            
            String name = "TableName";
            TextDialog nameDialog = new TextDialog(name);
            if (nameDialog.ShowDialog() == DialogResult.OK)
            {
                addTable(nameDialog.getText());
            }
           
        }

        private void 重命名当前表ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            try
            {
                TabPage page = getCurPage();
                String name = page.Text;
                TextDialog nameDialog = new TextDialog(name);
                if (nameDialog.ShowDialog() == DialogResult.OK)
                {
                    page.Text = nameDialog.getText();
                }
            }
            catch (Exception err) { }
        }

        private void 删除当前表ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            try
            {
                TabPage page = getCurPage();
                DataGridView table = getTable(page);

                Pages.Remove(page);
                tablemap.Remove(page);
                Tables.Remove(table);

                try
                {
                    tabControl1.SelectedIndex = tabControl1.TabPages.IndexOf(page) - 1;
                }
                catch (Exception err) { }

                tabControl1.TabPages.Remove(page);

                
                
            }
            catch (Exception err) { }
        }

        private void exchageTable(int src,int dst)
        {
            tabControl1.SuspendLayout();

            TabPage page1 = tabControl1.TabPages[src];
            TabPage page2 = tabControl1.TabPages[dst];

            tabControl1.TabPages[src] = page2;
            tabControl1.TabPages[dst] = page1;

            tabControl1.ResumeLayout();
        }

        //tablle move left
        private void toolStripButton1_Click(object sender, EventArgs e)
        {
            int src = tabControl1.TabPages.IndexOf(tabControl1.SelectedTab);
            int dst = src - 1;
            if (src > 0)
            {
                exchageTable(src, dst);

                tabControl1.SelectedTab = tabControl1.TabPages[dst];
            }

            //tabControl1.SelectedTab.
        }

        //table move right
        private void toolStripButton2_Click(object sender, EventArgs e)
        {
            int src = tabControl1.TabPages.IndexOf(tabControl1.SelectedTab);
            int dst = src + 1;
            if (dst < tabControl1.TabCount)
            {
                exchageTable(src, dst);

                tabControl1.SelectedTab = tabControl1.TabPages[dst];
            }
        }

        private void exchageColumn(int src, int dst)
        {

            for (int i = 0; i < getTableCount(); i++)
            {
                getTable(i).SuspendLayout();

                DataGridViewColumn column1 = getColumn(i, src);
                DataGridViewColumn column2 = getColumn(i, dst);

                column1.DisplayIndex = dst;
                column2.DisplayIndex = src;

                getTable(i).ResumeLayout();
            }
            
        }

        //column move left
        private void toolStripButton3_Click(object sender, EventArgs e)
        {
            int src = getCurTable().Columns[getCurTable().SelectedCells[0].ColumnIndex].DisplayIndex;
            int dst = src - 1;
            if (src > 0)
            {
                exchageColumn(src, dst);
            }
        }

        //column move right
        private void toolStripButton4_Click(object sender, EventArgs e)
        {
            int src = getCurTable().Columns[getCurTable().SelectedCells[0].ColumnIndex].DisplayIndex;
            int dst = src + 1;
            if (dst < getCurTable().ColumnCount)
            {
                exchageColumn(src, dst);
            }
        }









        /* 
         * this.tabPage1 = new System.Windows.Forms.TabPage();
            this.dataGridView1 = new System.Windows.Forms.DataGridView();
   // 
            // tabPage1
            // 
            this.tabPage1.Controls.Add(this.dataGridView1);
            this.tabPage1.Location = new System.Drawing.Point(4, 22);
            this.tabPage1.Name = "tabPage1";
            this.tabPage1.Padding = new System.Windows.Forms.Padding(3);
            this.tabPage1.Size = new System.Drawing.Size(638, 356);
            this.tabPage1.TabIndex = 0;
            this.tabPage1.Text = "表1";
            this.tabPage1.UseVisualStyleBackColor = true;

             this.dataGridView1.AllowUserToOrderColumns = true;
            this.dataGridView1.AutoSizeColumnsMode = System.Windows.Forms.DataGridViewAutoSizeColumnsMode.AllCellsExceptHeader;
            this.dataGridView1.ClipboardCopyMode = System.Windows.Forms.DataGridViewClipboardCopyMode.EnableAlwaysIncludeHeaderText;
            this.dataGridView1.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridView1.Dock = System.Windows.Forms.DockStyle.Fill;
            this.dataGridView1.EditMode = System.Windows.Forms.DataGridViewEditMode.EditOnEnter;
            this.dataGridView1.Location = new System.Drawing.Point(3, 3);
            this.dataGridView1.Name = "dataGridView1";
            this.dataGridView1.RowTemplate.Height = 23;
            this.dataGridView1.Size = new System.Drawing.Size(632, 350);
            this.dataGridView1.TabIndex = 0;
            this.dataGridView1.CellClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.dataGridView1_CellClick);
            this.dataGridView1.ColumnHeaderMouseClick += new System.Windows.Forms.DataGridViewCellMouseEventHandler(this.dataGridView1_ColumnHeaderMouseClick);
            this.dataGridView1.RowHeaderMouseClick += new System.Windows.Forms.DataGridViewCellMouseEventHandler(this.dataGridView1_RowHeaderMouseClick);
            this.dataGridView1.ColumnDisplayIndexChanged += new System.Windows.Forms.DataGridViewColumnEventHandler(this.dataGridView1_ColumnDisplayIndexChanged);
            this.dataGridView1.ColumnAdded += new System.Windows.Forms.DataGridViewColumnEventHandler(this.dataGridView1_ColumnAdded);
            this.dataGridView1.CellContentClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.dataGridView1_CellContentClick);
            // 

         * 
         * 
         * 
         * 
         * 
         * 
         * 
         * 
         * 
         * 
        */
    }
}
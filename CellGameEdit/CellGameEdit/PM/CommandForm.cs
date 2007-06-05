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
    public partial class CommandForm : Form, ISerializable
    {
        public string id;

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

                ArrayList heads = (ArrayList)info.GetValue("heads", typeof(ArrayList));
                ArrayList cells = (ArrayList)info.GetValue("cells", typeof(ArrayList));
                int ColumnsCount = (int)info.GetValue("ColumnsCount", typeof(int));
                int RowsCount = (int)info.GetValue("RowsCount", typeof(int));

                for (int c = 0; c < ColumnsCount; c++)
                {
                    string head = (String)heads[c];
                    dataGridView1.Columns.Add(head, head);
                }

                for (int r = 0; r < RowsCount; r++)
                {
                    string[] row = new string[ColumnsCount];
                    
                    for (int c = 0; c < ColumnsCount; c++)
                    {
                        int i = r * ColumnsCount + c;
                        row[c] = (String)cells[i];
                    }

                    dataGridView1.Rows.Add(row);
                }
                

            }catch(Exception err){
          
            }
        }

        [SecurityPermissionAttribute(SecurityAction.Demand, SerializationFormatter = true)]
        public virtual void GetObjectData(SerializationInfo info, StreamingContext context)
        {
            info.AddValue("id", id);

            ArrayList heads = new ArrayList();
            ArrayList cells = new ArrayList();
            int ColumnsCount = this.dataGridView1.Columns.Count;
            int RowsCount = this.dataGridView1.Rows.Count - 1;

            for (int c = 0; c < ColumnsCount; c++)
            {
                string head = this.dataGridView1.Columns[c].HeaderText;
                heads.Add(head);
            }

            for (int r = 0; r < RowsCount; r++)
            {
                for (int c = 0; c < this.dataGridView1.Columns.Count; c++)
                {
                    int i = r * this.dataGridView1.Columns.Count + c;
                    string cell = getCellText(r,c);
                    if (cell == null) cell = "";
                    cells.Add(cell);
                }
            }

            info.AddValue("heads",heads);
            info.AddValue("cells",cells);
            info.AddValue("ColumnsCount", ColumnsCount);
            info.AddValue("RowsCount", RowsCount);

        }

        public void OutputCustom(int index, String script, System.IO.StringWriter output)
        {
            lock (this)
            {
                int ColumnsCount = this.dataGridView1.Columns.Count;
                int RowsCount = this.dataGridView1.Rows.Count - 1;

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
                            string TEXT = this.dataGridView1.Columns[c].HeaderText;

                            heads[c] = Util.replaceKeywordsScript(table, "#<COLUMN HEAD>", "#<END COLUMN HEAD>",
                                new string[] { "<INDEX>", "<TEXT>"},
                                new string[] { c.ToString(), TEXT}
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

                                string TEXT = getCellText(r, c);
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


                    table = Util.replaceKeywordsScript(table, "#<TABLE>", "#<END TABLE>",
                        new string[] { 
                            "<NAME>", 
                            "<TABLE INDEX>",
                            "<COLUMN COUNT>",
                            "<ROW COUNT>",
                        },
                        new string[] { 
                            this.id, 
                            index.ToString(),
                            ColumnsCount.ToString(),
                            RowsCount.ToString(),
                        }
                     );

                    output.WriteLine(table);
                    //Console.WriteLine(map);
                }
                catch (Exception err) { Console.WriteLine(this.id + " : " + err.StackTrace + "  at  " + err.Message); }

            }
        }

        private void CommandForm_FormClosing(object sender, FormClosingEventArgs e)
        {
            if (e.CloseReason == CloseReason.UserClosing)
            {
                e.Cancel = true;
                this.Hide();
            }
        }

        private string getCellText(int r,int c)
        {   
            string text;
            try
            {
               text  = dataGridView1.Rows[r].Cells[c].Value.ToString();
            }
            catch (Exception err) { 
                text = ""; 
            }
            return text;
        }

//----------------------------------------------------------------------------------------------------------------------------------------------------------


        private void 属性ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            PropertyEdit edit = new PropertyEdit(this.dataGridView1);
            edit.MdiParent = this.MdiParent;
            edit.Show();
        }

        // add column
        private void 文本ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            String name = "ColumnName";
            TextDialog nameDialog = new TextDialog(name);
            if (nameDialog.ShowDialog() == DialogResult.OK)
            {
                this.dataGridView1.Columns.Add(nameDialog.getText(), nameDialog.getText());
            }
        }

        private void dataGridView1_ColumnAdded(object sender, DataGridViewColumnEventArgs e)
        {

        }

        // delete column
        int PopedColumnIndex = -1;
        private void dataGridView1_ColumnHeaderMouseClick(object sender, DataGridViewCellMouseEventArgs e)
        {
            if (e.Button == MouseButtons.Right)
            {
                PopedColumnIndex = e.ColumnIndex;
                columnMenu.Show(
                    dataGridView1,
                    e.Location.X + dataGridView1.GetColumnDisplayRectangle(e.ColumnIndex, false).Location.X,
                    e.Location.Y + dataGridView1.GetColumnDisplayRectangle(e.ColumnIndex, false).Location.Y
                    );
            }
        }

        private void 删除ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            try
            {
                dataGridView1.Columns.RemoveAt(PopedColumnIndex);
            }
            catch (Exception err) { }
        }

        private void 重命名列ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            try
            {
                String name = dataGridView1.Columns[PopedColumnIndex].HeaderText;
                TextDialog nameDialog = new TextDialog(name);
                if (nameDialog.ShowDialog() == DialogResult.OK)
                {
                    dataGridView1.Columns[PopedColumnIndex].HeaderText = nameDialog.getText();
                    dataGridView1.Columns[PopedColumnIndex].Name = nameDialog.getText();
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
                    dataGridView1,
                    e.Location.X + dataGridView1.GetRowDisplayRectangle(e.RowIndex, false).Location.X,
                    e.Location.Y + dataGridView1.GetRowDisplayRectangle(e.RowIndex, false).Location.Y
                    );
            }
        }

        private void 删除行ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            try
            {
                dataGridView1.Rows.RemoveAt(PopedRowIndex);
            }
            catch (Exception err) { }
        }

        private void dataGridView1_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }

        //----------------------------------------------------------------------------------------------------------------------------------------------------------

        private void dataGridView1_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            dataLable.Text = "行=" + e.RowIndex + " 列=" + e.ColumnIndex;
        }

        private void 表属性ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            PropertyEdit edit = new PropertyEdit(this.dataGridView1);
            edit.MdiParent = this.MdiParent;
            edit.Show();
        }


     



 


    }
}
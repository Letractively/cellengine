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

using javax.microedition.lcdui;

namespace CellGameEdit.PM
{
    [Serializable]
    public partial class WorldForm : Form, ISerializable
    {
        public String id;
        public StringBuilder Data = new StringBuilder();

        Hashtable UnitList;
        //ArrayList WayPoints;
        //ArrayList Regions;
        Hashtable WayPointsList;
        Hashtable RegionsList;

        int CellW = 16;
        int CellH = 16;

        public WorldForm(String name)
        {
            InitializeComponent();
            numericUpDown1.Value = CellW;
            numericUpDown2.Value = CellH;

            id = name;

            UnitList = new Hashtable();
            WayPointsList = new Hashtable();
            RegionsList = new Hashtable();
            //WayPoints = new ArrayList();
            //Regions = new ArrayList();
        }

        [SecurityPermissionAttribute(SecurityAction.Demand, SerializationFormatter = true)]
        protected WorldForm(SerializationInfo info, StreamingContext context)
        {
            InitializeComponent();
            numericUpDown1.Value = CellW;
            numericUpDown2.Value = CellH;

            UnitList = new Hashtable();
            WayPointsList = new Hashtable();
            RegionsList = new Hashtable();

            try
            {
                id = (String)info.GetValue("id", typeof(String));


                // unit
                #region Units 
                ArrayList Units = (ArrayList)info.GetValue("Units", typeof(ArrayList));
                for (int i = 0; i < Units.Count; i++)
                {
                    try
                    {
                        Unit unit = ((Unit)Units[i]);
                        ListViewItem item = new ListViewItem(new String[] { 
                            unit.id, 
                            unit.animID.ToString(),
                            unit.x.ToString(),
                            unit.y.ToString()
                        });
                        listView1.Items.Add(item);
                        UnitList.Add(item, unit);
                        //item.Selected = true;
                        //Console.WriteLine("Level: Load " + unit.id);
                    }
                    catch (Exception err)
                    {
                        Console.WriteLine(this.id + " : " + err.StackTrace);
                    }
                }
                //listView1.Refresh();
                #endregion

                // WayPoint
                #region WayPoints
                try
                {
                    ArrayList WayPoints = (ArrayList)info.GetValue("WayPoints", typeof(ArrayList));
                    for (int i = 0; i < WayPoints.Count; i++)
                    {
                        try
                        {
                            WayPoint wp = ((WayPoint)WayPoints[i]);
                            ListViewItem item = new ListViewItem(new String[] { 
                                wp.getWX().ToString(),
                                wp.getWY().ToString()
                            });
                            listView2.Items.Add(item);
                            WayPointsList.Add(item, wp);
                            //item.Selected = true;
                            //Console.WriteLine("Level: Load " + unit.id);
                        }
                        catch (Exception err)
                        {
                            Console.WriteLine(this.id + " : " + err.StackTrace);
                        }
                    }
                }
                catch (Exception err) { }
                //listView2.Refresh();
                #endregion

                // region
                #region Regions
                try
                {
                    ArrayList Regions = (ArrayList)info.GetValue("Regions", typeof(ArrayList));
                    for (int i = 0; i < Regions.Count; i++)
                    {
                        try
                        {
                            Region region = ((Region)Regions[i]);
                            ListViewItem item = new ListViewItem(new String[] { 
                                region.rect.X.ToString(), 
                                region.rect.Y.ToString(),
                                region.rect.Width.ToString(),
                                region.rect.Height.ToString(),
                            });
                            listView3.Items.Add(item);
                            RegionsList.Add(item, region);
                            //item.Selected = true;
                            //Console.WriteLine("Level: Load " + unit.id);
                        }
                        catch (Exception err)
                        {
                            Console.WriteLine(this.id + " : " + err.StackTrace);
                        }
                    }
                }
                catch (Exception err) { }
                //listView3.Refresh();
                #endregion


                pictureBox1.Width = (int)info.GetValue("Width", typeof(int));
                pictureBox1.Height = (int)info.GetValue("Height", typeof(int));

                try
                {
                    CellW = (int)info.GetValue("CellW", typeof(int));
                    CellH = (int)info.GetValue("CellH", typeof(int));
                }
                catch (Exception err) { }

                numericUpDown1.Value = CellW;
                numericUpDown2.Value = CellH;
                numericUpDown3.Value = pictureBox1.Width;
                numericUpDown4.Value = pictureBox1.Height;
                try
                {
                    Data.Append((String)info.GetValue("Data", typeof(String)));
                }
                catch (Exception err)
                {
                }
            }
            catch (Exception err)
            {
                Console.WriteLine(this.id + " : " + err.StackTrace);
            }
        }
        [SecurityPermissionAttribute(SecurityAction.Demand, SerializationFormatter = true)]
        public virtual void GetObjectData(SerializationInfo info, StreamingContext context)
        {
            testDelUnit();
            try
            {
                info.AddValue("id", id);

                #region Units
                ArrayList Units = new ArrayList();
                for (int i = 0; i < listView1.Items.Count; i++)
                {
                    try
                    {
                        Unit unit = (Unit)UnitList[listView1.Items[i]];
                        unit.id = listView1.Items[i].Text;

                        Units.Add(unit);

                        //Console.WriteLine("Level: Add " + ((Unit)UnitList[listView1.Items[i]]).id);
                    }
                    catch (Exception err)
                    {
                        Console.WriteLine(this.id + " : " + err.StackTrace);
                    }
                }
                info.AddValue("Units", Units);
                info.AddValue("UnitList", UnitList);
                #endregion

                #region WayPoints
                ArrayList WayPoints = new ArrayList();
                for (int i = 0; i < listView2.Items.Count; i++)
                {
                    try
                    {
                        WayPoint wp = (WayPoint)WayPointsList[listView2.Items[i]];
                        WayPoints.Add(wp);
                        //Console.WriteLine("Level: Add " + ((Unit)UnitList[listView1.Items[i]]).id);
                    }
                    catch (Exception err)
                    {
                        Console.WriteLine(this.id + " : " + err.StackTrace);
                    }
                }
                info.AddValue("WayPoints", WayPoints);
                info.AddValue("WayPointsList", WayPointsList);
                #endregion

                #region Regions
                ArrayList Regions = new ArrayList();
                for (int i = 0; i < listView3.Items.Count; i++)
                {
                    try
                    {
                        Region region = (Region)RegionsList[listView3.Items[i]];
                        Regions.Add(region);
                        //Console.WriteLine("Level: Add " + ((Unit)UnitList[listView1.Items[i]]).id);
                    }
                    catch (Exception err)
                    {
                        Console.WriteLine(this.id + " : " + err.StackTrace);
                    }
                }
                info.AddValue("Regions", Regions);
                info.AddValue("RegionsList", RegionsList);
                #endregion


                info.AddValue("Width", pictureBox1.Width);
                info.AddValue("Height", pictureBox1.Height);

                info.AddValue("CellW", CellW);
                info.AddValue("CellH", CellH);

                info.AddValue("Data", this.Data.ToString());
            }
            catch (Exception err)
            {
                Console.WriteLine(this.id + " : " + err.StackTrace);
            }
        }

        public void OutputCustom(String script, System.IO.StringWriter output)
        {
            try
            {
                String world = Util.getFullTrunkScript(script, "#<WORLD>", "#<END WORLD>");

                ArrayList maps = new ArrayList();
                ArrayList sprs = new ArrayList();
                foreach (ListViewItem item in listView1.Items)
                {
                    try
                    {
                        Unit unit = ((Unit)UnitList[item]);
                        if (unit.type == "Map") maps.Add(unit);
                        if (unit.type == "Sprite") sprs.Add(unit);
                        unit.id = item.Text;

                    }
                    catch (Exception err) { }
                }

                ArrayList WayPoints = new ArrayList();
                for (int i = 0; i < listView2.Items.Count; i++)
                {
                    try
                    {
                        WayPoint wp = (WayPoint)WayPointsList[listView2.Items[i]];
                        WayPoints.Add(wp);
                        //Console.WriteLine("Level: Add " + ((Unit)UnitList[listView1.Items[i]]).id);
                    }
                    catch (Exception err)
                    {
                        Console.WriteLine(this.id + " : " + err.StackTrace);
                    }
                }

                ArrayList Regions = new ArrayList();
                for (int i = 0; i < listView3.Items.Count; i++)
                {
                    try
                    {
                        Region region = (Region)RegionsList[listView3.Items[i]];
                        Regions.Add(region);
                        //Console.WriteLine("Level: Add " + ((Unit)UnitList[listView1.Items[i]]).id);
                    }
                    catch (Exception err)
                    {
                        Console.WriteLine(this.id + " : " + err.StackTrace);
                    }
                }

                bool fix = false;

                // maps
                do
                {
                    String[] map = new string[maps.Count];
                    for (int i = 0; i < map.Length; i++)
                    {
                        string X = ((Unit)maps[i]).x.ToString();
                        string Y = ((Unit)maps[i]).y.ToString();
                        string ID = ((Unit)maps[i]).map.id;
                        string NAME = ((Unit)maps[i]).id;
                        string SUPER = ((Unit)maps[i]).map.super.id;
                        string MAP_DATA = ((Unit)maps[i]).Data.ToString();
                        map[i] = Util.replaceKeywordsScript(world, "#<UNIT MAP>", "#<END UNIT MAP>",
                               new string[] { "<MAP NAME>", "<IDENTIFY>", "<INDEX>", "<X>", "<Y>", "<SUPER>", "<MAP DATA>" },
                               new string[] { NAME, ID, i.ToString(), X, Y, SUPER, MAP_DATA });
                    }
                    string temp = Util.replaceSubTrunksScript(world, "#<UNIT MAP>", "#<END UNIT MAP>", map);
                    if (temp == null)
                    {
                        fix = false;
                    }
                    else
                    {
                        fix = true;
                        world = temp;
                    }
                } while (fix);

                // sprs
                do
                {
                    String[] spr = new string[sprs.Count];
                    for (int i = 0; i < spr.Length; i++)
                    {
                        string X = ((Unit)sprs[i]).x.ToString();
                        string Y = ((Unit)sprs[i]).y.ToString();
                        string ID = ((Unit)sprs[i]).spr.id;
                        string NAME = ((Unit)sprs[i]).id;
                        string SUPER = ((Unit)sprs[i]).spr.super.id;
                        string ANIM_ID = ((Unit)sprs[i]).animID.ToString();
                        string SPR_DATA = ((Unit)sprs[i]).Data.ToString();
                        spr[i] = Util.replaceKeywordsScript(world, "#<UNIT SPRITE>", "#<END UNIT SPRITE>",
                               new string[] { "<SPR NAME>", "<IDENTIFY>", "<INDEX>", "<X>", "<Y>", "<ANIMATE ID>", "<SUPER>","<SPR DATA>" },
                               new string[] { NAME, ID, i.ToString(), X, Y, ANIM_ID, SUPER ,SPR_DATA});
                    }
                    string temp = Util.replaceSubTrunksScript(world, "#<UNIT SPRITE>", "#<END UNIT SPRITE>", spr);
                    if (temp == null)
                    {
                        fix = false;
                    }
                    else
                    {
                        fix = true;
                        world = temp;
                    }
                } while (fix);

                //way points
                do
                {
                    String[] wp = new string[WayPoints.Count];
                    for (int i = 0; i < wp.Length; i++)
                    {
                        WayPoint p = ((WayPoint)WayPoints[i]);
                        string X = (p.rect.X + p.rect.Width / 2) + "";
                        string Y = (p.rect.Y + p.rect.Height / 2) + "";
                        wp[i] = Util.replaceKeywordsScript(world, "#<WAYPOINT>", "#<END WAYPOINT>",
                               new string[] { "<INDEX>", "<X>", "<Y>", "<PATH DATA>" },
                               new string[] { i.ToString(), X, Y, p.Data.ToString()});
                    }
                    string temp = Util.replaceSubTrunksScript(world, "#<WAYPOINT>", "#<END WAYPOINT>", wp);
                    if (temp == null)
                    {
                        fix = false;
                    }
                    else
                    {
                        fix = true;
                        world = temp;
                    }
                } while (fix);

                do
                {
                    ArrayList link = new ArrayList();
                    foreach (WayPoint p in WayPoints)
                    {
                        try
                        {
                            if (p != null)
                            {//
                                foreach (WayPoint l in p.link)
                                {
                                    try
                                    {
                                        if (l != null)
                                        {//
                                            string START = WayPoints.IndexOf(p).ToString();
                                            string END = WayPoints.IndexOf(l).ToString();
                                            link.Add(
                                                Util.replaceKeywordsScript(world, "#<WAYPOINT LINK>", "#<END WAYPOINT LINK>",
                                                   new string[] { "<INDEX>", "<START>", "<END>", },
                                                   new string[] { link.Count.ToString(), START, END, })
                                            );
                                        }
                                    }
                                    catch (Exception err) { Console.WriteLine(this.id + " : " + err.StackTrace); }
                                }//
                            }
                        }
                        catch (Exception err) { Console.WriteLine(this.id + " : " + err.StackTrace); }
                    }//
                    String[] slink = new string[link.Count];
                    slink = (String[])link.ToArray(typeof(String));
                    string temp = Util.replaceSubTrunksScript(world, "#<WAYPOINT LINK>", "#<END WAYPOINT LINK>", slink);
                    if (temp == null)
                    {
                        fix = false;
                    }
                    else
                    {
                        fix = true;
                        world = temp;
                    }
                } while (fix);

                // regions 
                do
                {
                    String[] region = new string[Regions.Count];
                    for (int i = 0; i < region.Length; i++)
                    {
                        Region r = ((Region)Regions[i]);
                        string X = (r.rect.X) + "";
                        string Y = (r.rect.Y) + "";
                        string W = (r.rect.Width) + "";
                        string H = (r.rect.Height) + "";
                        region[i] = Util.replaceKeywordsScript(world, "#<REGION>", "#<END REGION>",
                               new string[] { "<INDEX>", "<X>", "<Y>", "<W>","<H>", "<REGION DATA>"},
                               new string[] { i.ToString(), X, Y, W, H, r.Data.ToString() });
                    }
                    string temp = Util.replaceSubTrunksScript(world, "#<REGION>", "#<END REGION>", region);
                    if (temp == null)
                    {
                        fix = false;
                    }
                    else
                    {
                        fix = true;
                        world = temp;
                    }
                } while (fix);

                // world key words
                world = Util.replaceKeywordsScript(world, "#<WORLD>", "#<END WORLD>",
                    new string[] { 
                        "<NAME>", 
                        "<DATA>",
                        "<WIDTH>",
                        "<HEIGHT>",
                        "<GRID W>",
                        "<GRID H>",
                        "<UNIT MAP COUNT>" ,
                        "<UNIT SPRITE COUNT>",
                        "<WAYPOINT COUNT>"
                    },
                    new string[] { 
                        this.id, 
                        this.Data.ToString(),
                        pictureBox1.Width.ToString(),
                        pictureBox1.Height.ToString(),
                        CellW.ToString(),
                        CellH.ToString(),
                        maps.Count.ToString(),
                        sprs.Count.ToString(),
                        WayPoints.Count.ToString()
                    }
                    );

                output.WriteLine(world);

            }
            catch (Exception err) { Console.WriteLine(this.id + " : " + err.StackTrace); }
        }

        private void WorldForm_FormClosing(object sender, FormClosingEventArgs e)
        {
            if (e.CloseReason == CloseReason.UserClosing)
            {
                e.Cancel = true;
                this.Hide();
            }
        }
        private void WorldForm_FormClosed(object sender, FormClosedEventArgs e)
        {

        }

        private void WorldForm_Shown(object sender, EventArgs e)
        {
            numericUpDown1.Value = CellW;
            numericUpDown2.Value = CellH;
            numericUpDown3.Value = pictureBox1.Width;
            numericUpDown4.Value = pictureBox1.Height;

            tabControl1.Refresh();
        }

        // list view1 map list
        private void listView1_DragDrop(object sender, DragEventArgs e)
        {
            if ((MapForm)e.Data.GetData(typeof(MapForm)) != null)
            {
                MapForm map = ((MapForm)e.Data.GetData(typeof(MapForm)));

                Unit unit = new Unit(map, "M" + (listView1.Items.Count).ToString("d3") + "_");
                ListViewItem item = new ListViewItem(new String[] { unit.id, unit.animID.ToString() });

                listView1.Items.Add(item);
                UnitList.Add(item, unit);

                pictureBox1.Width = Math.Max(unit.x + unit.getWidth(), pictureBox1.Width);
                pictureBox1.Height = Math.Max(unit.y + unit.getHeight(), pictureBox1.Height);

                CellW = map.CellW;
                CellH = map.CellH;

                numericUpDown1.Value = CellW;
                numericUpDown2.Value = CellH;
                numericUpDown3.Value = pictureBox1.Width;
                numericUpDown4.Value = pictureBox1.Height;
            }
            if ((SpriteForm)e.Data.GetData(typeof(SpriteForm)) != null)
            {
                SpriteForm spr = ((SpriteForm)e.Data.GetData(typeof(SpriteForm)));

                Unit unit = new Unit(spr, "S" + (listView1.Items.Count).ToString("d3") + "_");
                unit.x = -pictureBox1.Location.X /*+ panel1.Width / 2*/;
                unit.y = -pictureBox1.Location.Y /*+ panel1.Height / 2*/;

                ListViewItem item = new ListViewItem(new String[] { 
                    unit.id, 
                    unit.animID.ToString() ,
                    unit.x.ToString(),
                    unit.y.ToString()
                });

                listView1.Items.Add(item);
                UnitList.Add(item, unit);

                
            }

            pictureBox1.Refresh();
            //Console.WriteLine("drag");
        }
        private void listView1_DragEnter(object sender, DragEventArgs e)
        {
            e.Effect = e.AllowedEffect;
            //Console.WriteLine("enter");
        }
        private void listView1_SelectedIndexChanged(object sender, EventArgs e)
        {
            pictureBox1.Refresh();
        }
        private void listView1_ItemSelectionChanged(object sender, ListViewItemSelectionChangedEventArgs e)
        {
            //e.
            //if (e.IsSelected)
            //{
            //    Console.WriteLine("e.Iss");
            //}
        }
        private void listView1_MouseClick(object sender, MouseEventArgs e)
        {
            if (e.Button ==MouseButtons.Right && listView1.SelectedItems.Count > 0)
            {
                menuUnit.Show(listView1, e.Location);
            }
        }
        
        // way point list
        private void listView2_SelectedIndexChanged(object sender, EventArgs e)
        {
            popedWayPoint = null;
            pictureBox1.Refresh();
        }
        private void listView2_MouseClick(object sender, MouseEventArgs e)
        {
            if (e.Button == MouseButtons.Right && listView2.SelectedItems.Count > 0)
            {
                popedWayPoint = null;

                menuPath.Items[0].Visible = false;
                menuPath.Items[1].Visible = false;
                menuPath.Items[2].Visible = false;
                menuPath.Items[3].Visible = true;
                menuPath.Items[4].Visible = true;
                menuPath.Show(listView2, e.Location);     
                
            }
        }

        // region list
        private void listView3_SelectedIndexChanged(object sender, EventArgs e)
        {
            pictureBox1.Refresh();
        }
        private void listView3_MouseClick(object sender, MouseEventArgs e)
        {
            if (e.Button == MouseButtons.Right && listView3.SelectedItems.Count > 0)
            {
                menuRegion.Show(listView3, e.Location);
            }
        }
        
        
        // picturebox1 dst level

        int dx = 0;
        int dy = 0;
        ListViewItem popedWayPoint;
        int selectedRegionPX;
        int selectedRegionPY;

        
        private void pictureBox1_Paint(object sender, PaintEventArgs e)
        {
            javax.microedition.lcdui.Graphics g = new javax.microedition.lcdui.Graphics(e.Graphics);

            toolStripStatusLabel1.Text = "";
            /*
                "Mouse:"+
                "X=" + (3 - pictureBox1.Location.X) + ","+
                "Y=" + (3 - pictureBox1.Location.Y) + " ";
             */


            drawUnits(g);
            drawWayPoints(g);
            drawRegions(g);

            // draw net grid
            if (toolStripButton12.Checked)
            {
                g.setColor(0x80, 0xff, 0xff, 0xff);

                int sx = -pictureBox1.Location.X / CellW;
                int sy = -pictureBox1.Location.Y / CellH;
                int sw = panel1.Width / CellW + 1;
                int sh = panel1.Height / CellH + 1;

                for (int bx = sx; bx < sx + sw; bx++)
                {
                    g.drawLine(
                       bx * CellW,
                       sy * CellH,
                       bx * CellW,
                       sy * CellH + sh * CellH);
                }
                for (int by = sy; by < sy + sh; by++)
                {
                    g.drawLine(
                        sx * CellW,
                        by * CellH,
                        sx * CellW + sw * CellW,
                        by * CellH);
                }
            }

        }

        private void drawUnits(javax.microedition.lcdui.Graphics g)
        { // draw units
            if (toolStripButton7.Checked || toolStripButton8.Checked)
            {
                foreach (ListViewItem item in listView1.Items)
                {
                    try
                    {
                        Unit unit = ((Unit)UnitList[item]);

                        if (unit.type == "Map" && toolStripButton7.Checked)
                        {
                            if (toolStripButton10.Checked)
                            {
                                for (int x = 0; x < pictureBox1.Width; x += unit.getWidth())
                                {
                                    for (int y = 0; y < pictureBox1.Height; y += unit.getHeight())
                                    {
                                        Rectangle rect = new Rectangle(
                                            -pictureBox1.Location.X,
                                            -pictureBox1.Location.Y,
                                            panel1.Width,
                                            panel1.Height
                                            );
                                        if (rect.IntersectsWith(
                                             new System.Drawing.Rectangle(
                                                x, y,
                                                unit.getWidth(),
                                                unit.getHeight())
                                                )
                                            )
                                        {
                                        }
                                        {
                                            int tx = unit.x;
                                            int ty = unit.y;
                                            unit.x = x;
                                            unit.y = y;
                                            unit.render(
                                               g,
                                               new System.Drawing.Rectangle(
                                                    -pictureBox1.Location.X - x,
                                                    -pictureBox1.Location.Y - y,
                                                    panel1.Width,
                                                    panel1.Height
                                               ),
                                               listView1.SelectedItems.Contains(item),
                                               toolStripButton1.Checked,
                                               toolStripButton2.Checked
                                            );
                                            unit.x = tx;
                                            unit.y = ty;
                                        }
                                    }
                                }
                            }
                            else
                            {
                                unit.render(
                                   g,
                                   new System.Drawing.Rectangle(
                                        -pictureBox1.Location.X,
                                        -pictureBox1.Location.Y,
                                        panel1.Width,
                                        panel1.Height
                                   ),
                                   listView1.SelectedItems.Contains(item),
                                   toolStripButton1.Checked,
                                   toolStripButton2.Checked
                                );
                            }
                        }

                        if (unit.type == "Sprite" && toolStripButton8.Checked)
                        {
                            unit.render(
                                   g,
                                    new System.Drawing.Rectangle(
                                        -pictureBox1.Location.X,
                                        -pictureBox1.Location.Y,
                                        splitContainer1.Panel2.Width,
                                        splitContainer1.Panel2.Height
                                   ),
                                   listView1.SelectedItems.Contains(item),
                                   toolStripButton1.Checked,
                                   toolStripButton2.Checked
                                );
                        }

                        if (item.Selected)
                        {
                            toolStripStatusLabel1.Text +=
                                "Unit["+unit.type+"]:" +
                                "X=" + unit.x + "," +
                                "Y=" + unit.y + " | "
                            ;
                        }
                    }
                    catch (Exception err)
                    {
                    }
                }
            }
        }
        private void drawWayPoints(javax.microedition.lcdui.Graphics g)
        { // draw way points
            if (toolStripButton9.Checked)
            {
                foreach (ListViewItem item in listView2.Items)
                {
                    WayPoint p = (WayPoint)WayPointsList[item];

                    if (p != null)
                    {
                        p.Render(g,item.Selected);
                        g.setColor(0xff, 0, 0, 0);
                        g.dg.DrawString(
                            "p" + listView2.Items.IndexOf(item).ToString(),
                            this.Font,
                            System.Drawing.Brushes.Black,
                            p.rect.X + p.rect.Width + 1,
                            p.rect.Y - p.rect.Height / 2);

                        if (item.Selected)
                        {
                            toolStripStatusLabel1.Text +=
                                "Point[" + listView2.Items.IndexOf(item) + "]:" +
                                "X=" + p.getWX() + "," + 
                                "Y=" + p.getWY() + " | "
                            ;
                        }
                        //g.drawString(WayPoints.IndexOf(p).ToString(), p.rect.X + p.rect.Width + 1, p.rect.Y - p.rect.Height / 2, 0);
                    }
                }

                if (popedWayPoint != null)
                {
                    ((WayPoint)WayPointsList[popedWayPoint]).Render(g,true);
                    g.setColor(0xff, 0xff, 0xff, 0);
                    g.drawLine(
                        ((WayPoint)WayPointsList[popedWayPoint]).rect.X + ((WayPoint)WayPointsList[popedWayPoint]).rect.Width / 2,
                        ((WayPoint)WayPointsList[popedWayPoint]).rect.Y + ((WayPoint)WayPointsList[popedWayPoint]).rect.Height / 2 - ((WayPoint)WayPointsList[popedWayPoint]).rect.Height,
                        ((WayPoint)WayPointsList[popedWayPoint]).rect.X + ((WayPoint)WayPointsList[popedWayPoint]).rect.Width / 2,
                        ((WayPoint)WayPointsList[popedWayPoint]).rect.Y + ((WayPoint)WayPointsList[popedWayPoint]).rect.Height / 2 + ((WayPoint)WayPointsList[popedWayPoint]).rect.Height
                        );
                    g.drawLine(
                        ((WayPoint)WayPointsList[popedWayPoint]).rect.X + ((WayPoint)WayPointsList[popedWayPoint]).rect.Width / 2 - ((WayPoint)WayPointsList[popedWayPoint]).rect.Width,
                        ((WayPoint)WayPointsList[popedWayPoint]).rect.Y + ((WayPoint)WayPointsList[popedWayPoint]).rect.Height / 2,
                        ((WayPoint)WayPointsList[popedWayPoint]).rect.X + ((WayPoint)WayPointsList[popedWayPoint]).rect.Width / 2 + ((WayPoint)WayPointsList[popedWayPoint]).rect.Width,
                        ((WayPoint)WayPointsList[popedWayPoint]).rect.Y + ((WayPoint)WayPointsList[popedWayPoint]).rect.Height / 2
                        );
                }
                if (listView2.SelectedItems.Count>0 && popedWayPoint != null)
                {
                    g.setColor(0x80, 0xff, 0, 0);
                    g.drawLine(
                         ((WayPoint)WayPointsList[popedWayPoint]).rect.X + ((WayPoint)WayPointsList[popedWayPoint]).rect.Width / 2,
                         ((WayPoint)WayPointsList[popedWayPoint]).rect.Y + ((WayPoint)WayPointsList[popedWayPoint]).rect.Height / 2,
                         ((WayPoint)WayPointsList[listView2.SelectedItems[0]]).rect.X + ((WayPoint)WayPointsList[listView2.SelectedItems[0]]).rect.Width / 2,
                         ((WayPoint)WayPointsList[listView2.SelectedItems[0]]).rect.Y + ((WayPoint)WayPointsList[listView2.SelectedItems[0]]).rect.Height / 2
                         );
                }
            }
        }
        private void drawRegions(javax.microedition.lcdui.Graphics g)
        {
            if (toolStripButton17.Checked)
            {
                foreach (ListViewItem item in listView3.Items)
                {
                    Region r = (Region)RegionsList[item];
                    if (r != null)
                    {
                        r.Render(g,item.Selected);
                        g.setColor(0xff, 0, 0, 0);
                        g.dg.DrawString(
                            "r" + listView3.Items.IndexOf(item).ToString(),
                            this.Font,
                            System.Drawing.Brushes.Black,
                            r.rect.X,
                            r.rect.Y - this.Font.Height - 1);

                        if (item.Selected)
                        {
                            toolStripStatusLabel1.Text +=
                                "Region[" + listView3.Items.IndexOf(item) + "]:" +
                                "X=" + (r.rect.X) + "," +
                                "Y=" + (r.rect.Y) + "," +
                                "W=" + (r.rect.Width) + "," +
                                "H=" + (r.rect.Height) + " | "
                            ;
                        }

                    }
                }
            }

        }

        private void pictureBox1_MouseMove(object sender, MouseEventArgs e)
        {
            if (e.Button == MouseButtons.Left)
            {
                #region unit
                if (listView1.SelectedItems.Count>0)
                {
                    if (listView1.SelectedItems[0].Checked == true)
                    {
                        Unit unit = ((Unit)UnitList[listView1.SelectedItems[0]]);

                        //if (unit.type == "Sprite")
                        {
                            if (!toolStripButton11.Checked)
                            {
                                unit.x = e.X;
                                unit.y = e.Y;
                            }
                            else
                            {
                                unit.x = e.X - e.X % CellW;
                                unit.y = e.Y - e.Y % CellH;
                            }

                            if (unit.x < 0) unit.x = 0;
                            if (unit.y < 0) unit.y = 0;
                            listView1.SelectedItems[0].SubItems[2].Text = unit.x.ToString();
                            listView1.SelectedItems[0].SubItems[3].Text = unit.y.ToString();

                            pictureBox1.Width = Math.Max(unit.x + unit.getWidth(), pictureBox1.Width);
                            pictureBox1.Height = Math.Max(unit.y + unit.getHeight(), pictureBox1.Height);
                            numericUpDown1.Value = CellW;
                            numericUpDown2.Value = CellH;
                            numericUpDown3.Value = pictureBox1.Width;
                            numericUpDown4.Value = pictureBox1.Height;
                        }
                    }

                }
                #endregion

                #region waypoint
                if (listView2.SelectedItems.Count>0)
                {
                    WayPoint p = (WayPoint)WayPointsList[listView2.SelectedItems[0]];

                    if (p != null )
                    {

                        if (!toolStripButton11.Checked)
                        {
                            p.rect.X = e.X;
                            p.rect.Y = e.Y;

                            if (p.rect.X < 0) p.rect.X = 0;
                            if (p.rect.Y < 0) p.rect.Y = 0;
                        }
                        else
                        {
                            p.rect.X = e.X - e.X % CellW;
                            p.rect.Y = e.Y - e.Y % CellH;

                            if (p.rect.X < 0) p.rect.X = 0;
                            if (p.rect.Y < 0) p.rect.Y = 0;
                        }

                        p.rect.X -= p.rect.Width / 2;
                        p.rect.Y -= p.rect.Height / 2;

                        listView2.SelectedItems[0].SubItems[0].Text = p.getWX().ToString();
                        listView2.SelectedItems[0].SubItems[1].Text = p.getWY().ToString();

                        pictureBox1.Width = Math.Max(p.rect.X + p.rect.Width, pictureBox1.Width);
                        pictureBox1.Height = Math.Max(p.rect.Y + p.rect.Height, pictureBox1.Height);
                        numericUpDown1.Value = CellW;
                        numericUpDown2.Value = CellH;
                        numericUpDown3.Value = pictureBox1.Width;
                        numericUpDown4.Value = pictureBox1.Height;
                    }

                }
                #endregion

                #region region
                if (listView3.SelectedItems.Count>0)
                {
                    Region r = (Region)RegionsList[listView3.SelectedItems[0]];
                    if (r != null && !r.isSub)
                    {
                        if (!toolStripButton11.Checked)
                        {
                            r.rect.X = e.X - selectedRegionPX;
                            r.rect.Y = e.Y - selectedRegionPY;

                            if (r.rect.X < 0) r.rect.X = 0;
                            if (r.rect.Y < 0) r.rect.Y = 0;
                        }
                        else
                        {
                            r.rect.X = e.X - e.X % CellW;
                            r.rect.Y = e.Y - e.Y % CellH;

                            if (r.rect.X < 0) r.rect.X = 0;
                            if (r.rect.Y < 0) r.rect.Y = 0;
                        }
                    }

                    if (r != null && r.isSub )
                    {
                        if (!toolStripButton11.Checked)
                        {
                            if (e.X - r.rect.X > 0) r.rect.Width = e.X - r.rect.X;
                            else r.rect.Width = 1;
                            if (e.Y - r.rect.Y > 0) r.rect.Height = e.Y - r.rect.Y;
                            else r.rect.Height = 1;
                        }
                        else
                        {
                            if ((e.X - e.X % CellW) - r.rect.X > 0) r.rect.Width = (e.X - e.X % CellW) - r.rect.X;
                            else r.rect.Width = 1;
                            if ((e.Y - e.Y % CellH) - r.rect.Y > 0) r.rect.Height = (e.Y - e.Y % CellH) - r.rect.Y;
                            else r.rect.Height = 1;
                        }
                        
                    }

                    listView3.SelectedItems[0].SubItems[0].Text = r.rect.X.ToString();
                    listView3.SelectedItems[0].SubItems[1].Text = r.rect.Y.ToString();
                    listView3.SelectedItems[0].SubItems[2].Text = r.rect.Width.ToString();
                    listView3.SelectedItems[0].SubItems[3].Text = r.rect.Height.ToString();

                    pictureBox1.Width = Math.Max(r.rect.X + r.rect.Width, pictureBox1.Width);
                    pictureBox1.Height = Math.Max(r.rect.Y + r.rect.Height, pictureBox1.Height);
                    numericUpDown1.Value = CellW;
                    numericUpDown2.Value = CellH;
                    numericUpDown3.Value = pictureBox1.Width;
                    numericUpDown4.Value = pictureBox1.Height;
                }
                #endregion


                pictureBox1.Refresh();
            }

        }

        private void pictureBox1_MouseDown(object sender, MouseEventArgs e)
        {
            dx = e.X;
            dy = e.Y;

            try
            {
                #region pointUnit
                // 是定位指令
                if (e.Button == MouseButtons.Left && toolStripButton14.Checked == true)
                {
                    // map
                    if (toolStripButton7.Checked)
                    {
                        if (listView1.SelectedItems.Count > 0  )
                        {
                            Unit unit = ((Unit)UnitList[listView1.SelectedItems[0]]);
                            if (unit.map != null)
                            {
                                if (listView1.SelectedItems[0].Checked)
                                {
                                    unit.x = e.X;
                                    unit.y = e.Y;
                                }
                            }
                        }
                    }
                    //select unit
                    if (toolStripButton8.Checked)
                    {
                        if (listView1.SelectedItems.Count > 0)
                        {
                            Unit unit = ((Unit)UnitList[listView1.SelectedItems[0]]);
                            if (unit.spr != null)
                            {
                                if (listView1.SelectedItems[0].Checked)
                                {
                                    unit.x = e.X;
                                    unit.y = e.Y;
                                }
                            }
                        }
                    }
                    //select way point
                    if (toolStripButton9.Checked)
                    {
                        if (listView2.SelectedItems.Count>0)
                        {
                            ((WayPoint)WayPointsList[listView2.SelectedItems[0]]).rect.X = e.X - ((WayPoint)WayPointsList[listView2.SelectedItems[0]]).rect.Width / 2;
                            ((WayPoint)WayPointsList[listView2.SelectedItems[0]]).rect.Y = e.Y - ((WayPoint)WayPointsList[listView2.SelectedItems[0]]).rect.Height / 2;
                        }
                    }
                    //select region
                    if (toolStripButton17.Checked)
                    {
                        if (listView3.SelectedItems.Count>0)
                        {
                            ((Region)RegionsList[listView3.SelectedItems[0]]).rect.X = e.X;
                            ((Region)RegionsList[listView3.SelectedItems[0]]).rect.Y = e.Y;
                        }
                    }
                }
                #endregion

                #region selectUnit
                //不是定位指令
                if (e.Button == MouseButtons.Left && toolStripButton14.Checked == false)
                {
                    foreach (ListViewItem item in listView1.Items)
                    {
                        if (toolStripButton15.Checked)
                        {
                            item.Checked = false;
                        }
                        item.Selected = false;
                    }

                    popedWayPoint = null;
                    foreach (ListViewItem item in listView2.Items)
                    {
                        item.Selected = false;
                    }

                    foreach (ListViewItem item in listView3.Items)
                    {
                        item.Selected = false;
                        Region r = (Region)RegionsList[item];
                        if (r != null)
                        {
                            r.isSub = false;
                        }
                    }

                    bool isChecked = false;
                    //select unit
                    if (isChecked == false && (toolStripButton7.Checked || toolStripButton8.Checked))
                    {
                        for (int i = listView1.Items.Count - 1; i >= 0; i--)
                        {
                            Unit unit = ((Unit)UnitList[listView1.Items[i]]);
                            if (unit.map != null && toolStripButton7.Checked ||
                                unit.spr != null && toolStripButton8.Checked)
                            {
                                if (new Rectangle(unit.x - unit.w / 2, unit.y - unit.h / 2, unit.w, unit.h).Contains(e.X, e.Y))
                                {
                                    isChecked = true;
                                    listView1.Items[i].Selected = true;
                                    if (toolStripButton15.Checked)
                                    {
                                        listView1.Items[i].Checked = true;
                                    }
                                    //listView1.SelectedItems[0] = listView1.Items[i];
                                    break;
                                }
                            }
                        }
                    }
                    //select way point
                    if (isChecked == false && toolStripButton9.Checked)
                    {
                        foreach (ListViewItem item in listView2.Items)
                        {
                            WayPoint p = (WayPoint)WayPointsList[item];
                            if (p != null)
                            {
                                if (p.rect.Contains(e.X, e.Y))
                                {
                                    isChecked = true;
                                    item.Selected = true;
                                    break;
                                }
                            }
                        }
                    }
                    // select regions
                    if (isChecked == false && toolStripButton17.Checked)
                    {
                        foreach (ListViewItem item in listView3.Items)
                        {
                            Region r = (Region)RegionsList[item];
                            if (r != null)
                            {
                                if (r.select(e.X, e.Y))
                                {
                                    r.isSub = false;
                                    selectedRegionPX = e.X - r.rect.X;
                                    selectedRegionPY = e.Y - r.rect.Y;
                                    isChecked = true;
                                    item.Selected = true;
                                }
                                if (r.selectSub(e.X, e.Y))
                                {
                                    r.isSub = true;
                                    isChecked = true;
                                    item.Selected = true;
                                }
                                if (isChecked) break;
                            }
                        }
                    }
                }
                #endregion

                #region popUnit
                if (e.Button == MouseButtons.Right)
                {
                    listView1.SelectedItems.Clear();

                    popedWayPoint = null;
                    //foreach (ListViewItem item in listView2.Items)
                    //{
                    //    item.Selected = false;
                    //}

                    //if (listView2.SelectedItems.Count > 0)
                    //{
                    //    popedWayPoint = listView2.SelectedItems[0];
                    //    listView2.SelectedItems.Clear();
                    //}
                    //else
                    //{
                    //    popedWayPoint.Selected = false;
                    //    popedWayPoint = null;
                    //}
                  
                    foreach (ListViewItem item in listView3.Items)
                    {
                        item.Selected = false;
                        Region r = (Region)RegionsList[item];
                        if (r != null)
                        {
                            r.isSub = false;
                        }
                    }

                    bool isChecked = false;
                    //select unit
                    if (isChecked == false && (toolStripButton7.Checked || toolStripButton8.Checked))
                    {
                        for (int i = listView1.Items.Count - 1; i >= 0; i--)
                        {
                            Unit unit = ((Unit)UnitList[listView1.Items[i]]);
                            if (unit.map != null && toolStripButton7.Checked ||
                                unit.spr != null && toolStripButton8.Checked)
                            {
                                if (new Rectangle(unit.x - unit.w / 2, unit.y - unit.h / 2, unit.w, unit.h).Contains(e.X, e.Y))
                                {
                                    isChecked = true;
                                    listView1.Items[i].Selected = true;
                                    break;
                                }
                            }
                        }
                    }
                    //select way point
                    if (isChecked == false && toolStripButton9.Checked)
                    {
                        foreach (ListViewItem item in listView2.Items)
                        {
                            WayPoint p = (WayPoint)WayPointsList[item];
                            if (p != null)
                            {
                                if (p.rect.Contains(e.X, e.Y))
                                {
                                    isChecked = true;
                                    popedWayPoint = item;
                                    break;
                                }
                            }
                        }
                    }
                    // select regions
                    if (isChecked == false && toolStripButton17.Checked)
                    {
                        foreach (ListViewItem item in listView3.Items)
                        {
                            Region r = (Region)RegionsList[item];
                            if (r != null)
                            {
                                if (r.select(e.X, e.Y))
                                {
                                    isChecked = true;
                                    item.Selected = true;
                                    break;
                                }
                            }
                        }
                    }

                    //弹出菜单
                    if (listView1.SelectedItems.Count>0 && toolStripButton8.Checked)
                    {
                        menuUnit.Opacity = 0.8;
                        menuUnit.Show(pictureBox1, e.Location);
                    }
                    else if (listView2.SelectedItems.Count > 0 && popedWayPoint != null && popedWayPoint != listView2.SelectedItems[0] && toolStripButton9.Checked)
                    {
                        menuPath.Opacity = 0.8;
                        menuPath.Items[0].Visible = true;
                        menuPath.Items[1].Visible = true;
                        menuPath.Items[2].Visible = true;
                        menuPath.Items[3].Visible = false;
                        menuPath.Items[4].Visible = false;
                        menuPath.Show(pictureBox1, e.Location);
                    }
                    else if (popedWayPoint != null && listView2.SelectedItems.Count <= 0 || listView2.SelectedItems.Count > 0 && popedWayPoint == listView2.SelectedItems[0])
                    {
                        popedWayPoint.Selected = true;
                        menuPath.Opacity = 0.8;
                        menuPath.Items[0].Visible = false;
                        menuPath.Items[1].Visible = false;
                        menuPath.Items[2].Visible = false;
                        menuPath.Items[3].Visible = true;
                        menuPath.Items[4].Visible = true;
                        menuPath.Show(pictureBox1, e.Location);
                    }
                    else if (listView3.SelectedItems.Count>0 && toolStripButton17.Checked)
                    {
                        menuRegion.Opacity = 0.8;
                        menuRegion.Show(pictureBox1, e.Location);
                    }
                    else
                    {
                        menuWorld.Opacity = 0.8;
                        menuWorld.Show(pictureBox1, e.Location);
                    }
                }




                #endregion
            }
            catch (Exception err) { }
            pictureBox1.Refresh();

        }
        private void pictureBox1_MouseUp(object sender, MouseEventArgs e)
        {
            pictureBox1.Refresh();
        }

        //show select
        private void toolStripButton1_Click(object sender, EventArgs e)
        {
            pictureBox1.Refresh();
        }
        //show cd
        private void toolStripButton2_Click(object sender, EventArgs e)
        {
            pictureBox1.Refresh();
        }

        //test del disposed
        private void testDelUnit()
        {
            foreach (ListViewItem item in listView1.Items)
            {
                try
                {
                    Unit unit = ((Unit)UnitList[item]);
                    if (unit.isKilled())
                    {
                        listView1.Items.Remove(item);
                        UnitList.Remove(item);

                        pictureBox1.Refresh();
                    }
                }
                catch (Exception err)
                {
                }
            }
        }
        //del
        private void toolStripButton6_Click(object sender, EventArgs e)
        {
            foreach (ListViewItem item in listView1.SelectedItems)
            {
                if (listView1.Items.Contains(item))
                {
                    listView1.Items.Remove(item);
                    UnitList.Remove(item);

                    pictureBox1.Refresh();
                    break;
                }
            }
        }
        //up-back
        private void toolStripButton3_Click(object sender, EventArgs e)
        {
            if (listView1.SelectedItems.Count > 0)
            {
                if (listView1.Items.IndexOf(listView1.SelectedItems[0]) > 0)
                {
                    ListViewItem item = listView1.Items[listView1.Items.IndexOf(listView1.SelectedItems[0]) - 1];

                    listView1.Items.Remove(item);

                    listView1.Items.Insert(listView1.Items.IndexOf(listView1.SelectedItems[listView1.SelectedItems.Count - 1]) + 1, item);

                    pictureBox1.Refresh();
                }
            }
        }
        //down-upon
        private void toolStripButton4_Click(object sender, EventArgs e)
        {
            if (listView1.SelectedItems.Count > 0)
            {
                if (listView1.Items.IndexOf(listView1.SelectedItems[listView1.SelectedItems.Count - 1]) < listView1.Items.Count - 1)
                {
                    ListViewItem item = listView1.Items[listView1.Items.IndexOf(listView1.SelectedItems[listView1.SelectedItems.Count - 1]) + 1];

                    listView1.Items.Remove(item);

                    listView1.Items.Insert(listView1.Items.IndexOf(listView1.SelectedItems[0]), item);

                    pictureBox1.Refresh();
                }
            }
        }

        private void toolStripButton5_Click(object sender, EventArgs e)
        {

        }


#region menuWorld
        // add way point command
        private void 路点ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            // menuPath.SourceControl
            WayPoint p = new WayPoint(dx, dy);
            //WayPoints.Add(p);
            ListViewItem item = new ListViewItem(new String[] { 
                                p.getWX().ToString(),
                                p.getWY().ToString()
                            });
            listView2.Items.Add(item);
            WayPointsList.Add(item, p);
            //Console.WriteLine("Level: Load " + unit.id);

            pictureBox1.Refresh();
        }
        // add region command
        private void 区域ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            // menuPath.SourceControl
            Region region = new Region(dx, dy);
            //Regions.Add(p);
            ListViewItem item = new ListViewItem(new String[] { 
                                region.rect.X.ToString(), 
                                region.rect.Y.ToString(),
                                region.rect.Width.ToString(),
                                region.rect.Height.ToString(),
                            });
            listView3.Items.Add(item);
            RegionsList.Add(item, region);

            pictureBox1.Refresh();
        }
        // open world data editor
        private void 场景数据ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            DataEdit dataEdit = new DataEdit(Data);
            dataEdit.MdiParent = this.MdiParent;
            dataEdit.Text = "DataEdit(" + this.id + ")";
            dataEdit.Show();
        }
#endregion

#region menuPath
        // del way point
        private void toolStripMenuItem2_Click(object sender, EventArgs e)
        {
            try
            {
                foreach (ListViewItem item in listView2.SelectedItems)
                {
                    WayPoint p = (WayPoint)WayPointsList[item];
                    foreach (ListViewItem link in listView2.Items)
                    {
                        WayPoint l = (WayPoint)WayPointsList[link];
                        l.DisLink(p);
                        p.DisLink(l);
                    }
                    ((WayPoint)WayPointsList[item]).DisLinkAll();
                    listView2.Items.Remove(item);
                    WayPointsList.Remove(item);
                }
            }
            catch (Exception err) { }
            pictureBox1.Refresh();
        }
        // link way point
        private void toolStripMenuItem3_Click(object sender, EventArgs e)
        {
            if (listView2.SelectedItems[0] == null) return;
            if (popedWayPoint == null) return;

            ((WayPoint)WayPointsList[listView2.SelectedItems[0]]).Link(((WayPoint)WayPointsList[popedWayPoint]));

            pictureBox1.Refresh();
        }
        private void 双向连接ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (listView2.SelectedItems[0] == null) return;
            if (popedWayPoint == null) return;

            ((WayPoint)WayPointsList[listView2.SelectedItems[0]]).Link2(((WayPoint)WayPointsList[popedWayPoint]));

            pictureBox1.Refresh();
        }
        // dislink way point
        private void toolStripMenuItem4_Click(object sender, EventArgs e)
        {
            if (listView2.SelectedItems[0] == null) return;
            if (popedWayPoint == null) return;

            ((WayPoint)WayPointsList[listView2.SelectedItems[0]]).DisLink(((WayPoint)WayPointsList[popedWayPoint]));

            pictureBox1.Refresh();
        }

        private void 路点数据ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (listView2.SelectedItems[0] == null) return;

            DataEdit dataEdit = new DataEdit(((WayPoint)WayPointsList[listView2.SelectedItems[0]]).Data);
            dataEdit.MdiParent = this.MdiParent;
            dataEdit.Text = "DataEdit(" + this.id + ".WayPoint[" + listView2.Items.IndexOf(listView2.SelectedItems[0]) + "])";
            dataEdit.Show();
        }
#endregion

#region menuUnit
        private void 删除ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            try
            {
                foreach (ListViewItem item in listView1.SelectedItems)
                {
                    if (listView1.Items.Contains(item))
                    {
                        listView1.Items.Remove(item);
                        UnitList.Remove(item);

                        pictureBox1.Refresh();
                        break;
                    }
                }
            }
            catch (Exception err) { }
        }
        private void 单位数据ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            try
            {
                DataEdit dataEdit = new DataEdit(((Unit)UnitList[listView1.SelectedItems[0]]).Data);
                dataEdit.MdiParent = this.MdiParent;
                dataEdit.Text = "DataEdit(" + this.id + ".Unit[" + ((Unit)UnitList[listView1.SelectedItems[0]]).id + "])";
                dataEdit.Show();
            }
            catch (Exception err) { }
        }
#endregion

#region menuRegion
        //del
        private void toolStripMenuItem1_Click(object sender, EventArgs e)
        {
            try
            {
                foreach (ListViewItem item in listView3.SelectedItems)
                {
                    if (listView3.Items.Contains(item))
                    {
                        listView3.Items.Remove(item);
                        RegionsList.Remove(item);

                        pictureBox1.Refresh();
                        break;
                    }
                }
            }
            catch (Exception err) { }
        }
        //data
        private void toolStripMenuItem5_Click(object sender, EventArgs e)
        {
            try
            {
                DataEdit dataEdit = new DataEdit(((Region)RegionsList[listView3.SelectedItems[0]]).Data);
                dataEdit.MdiParent = this.MdiParent;
                dataEdit.Text = "DataEdit(" + this.id + ".Region[" + listView3.Items.IndexOf(listView3.SelectedItems[0]) + "])";
                dataEdit.Show();
            }
            catch (Exception err) { }
        }

#endregion






        private void toolStripButton7_Click(object sender, EventArgs e)
        {
            pictureBox1.Refresh();
        }
        private void toolStripButton8_Click(object sender, EventArgs e)
        {
            pictureBox1.Refresh();
        }
        private void toolStripButton9_Click(object sender, EventArgs e)
        {
            pictureBox1.Refresh();
        }
        private void toolStripButton17_Click(object sender, EventArgs e)
        {
            pictureBox1.Refresh();
        }
        // back color
        private void toolStripButton5_Click_1(object sender, EventArgs e)
        {
            ColorDialog MyDialog = new ColorDialog();
            MyDialog.AllowFullOpen = false;
            MyDialog.ShowHelp = true;
            MyDialog.Color = pictureBox1.BackColor;
            if (MyDialog.ShowDialog() == DialogResult.OK)
            {
                pictureBox1.BackColor = MyDialog.Color;
            }
        }

        private void listView1_BeforeLabelEdit(object sender, LabelEditEventArgs e)
        {
            try
            {

                if (!e.CancelEdit)
                {
                    Unit unit = ((Unit)UnitList[listView1.Items[e.Item]]);
                    unit.id = e.Label;

                    //listView1.Items[e.Item].SubItems[1].
                }

            }
            catch (Exception err)
            {
                Console.WriteLine(this.id + " Unit Lable Error : " + err.StackTrace);
            }
        }

        private void listView1_AfterLabelEdit(object sender, LabelEditEventArgs e)
        {
            try
            {

                if (!e.CancelEdit)
                {
                    Unit unit = ((Unit)UnitList[listView1.Items[e.Item]]);
                    unit.id = e.Label;

                    //listView1.Items[e.Item].SubItems[1].
                }

            }
            catch (Exception err)
            {
                Console.WriteLine(this.id + " Unit Lable Error : " + err.StackTrace);
            }
        }
       


        // change sprite id
        private void toolStripDropDownButton1_DropDownOpening(object sender, EventArgs e)
        {
            try
            {
                toolStripDropDownButton1.DropDownItems.Clear();

                foreach (ListViewItem item in listView1.SelectedItems)
                {
                    Unit unit = ((Unit)UnitList[item]);

                    if (unit.type == "Sprite")
                    {
                        for (int i = 0; i < unit.spr.GetAnimateCount(); i++)
                        {
                            System.Drawing.Image icon = new System.Drawing.Bitmap(64, 64);
                            System.Drawing.Graphics g = System.Drawing.Graphics.FromImage(icon);
                            unit.spr.Render(
                                new javax.microedition.lcdui.Graphics(g),
                                32, 32, false, i, 0);

                            ToolStripMenuItem pop = new ToolStripMenuItem();
                            //pop.Text = "Anim " + i.ToString();
                            pop.Text = unit.spr.getAnimateName(i);
                            pop.Image = icon;
                            pop.ImageScaling = ToolStripItemImageScaling.None;

                            toolStripDropDownButton1.DropDownItems.Add(pop);
                        }
                        break;
                    }
                }
            }
            catch (Exception err) { }

        }

        private void toolStripDropDownButton1_DropDownItemClicked(object sender, ToolStripItemClickedEventArgs e)
        {
            try
            {
                int index = toolStripDropDownButton1.DropDownItems.IndexOf(e.ClickedItem);
                foreach (ListViewItem item in listView1.SelectedItems)
                {
                    Unit unit = ((Unit)UnitList[item]);

                    if (unit.type == "Sprite")
                    {
                        item.SubItems[1].Text = index.ToString();
                        unit.animID = index;
                        break;
                    }
                }
                pictureBox1.Refresh();
            }
            catch (Exception err) { }
        }

        // center map block
        private void toolStripButton11_Click(object sender, EventArgs e)
        {
            pictureBox1.Refresh();
        }
        // square show
        private void toolStripButton10_Click(object sender, EventArgs e)
        {
            pictureBox1.Refresh();
        }
        //show block line
        private void toolStripButton12_Click(object sender, EventArgs e)
        {
            pictureBox1.Refresh();
        }
        private void panel1_Scroll(object sender, ScrollEventArgs e)
        {
            //pictureBox1.Refresh();
        }

        //minimap
        private void toolStripButton13_Click(object sender, EventArgs e)
        {
            System.Drawing.Image image = new System.Drawing.Bitmap(pictureBox1.Width, pictureBox1.Height);
            System.Drawing.Graphics dg = System.Drawing.Graphics.FromImage(image);
            dg.Clear(pictureBox1.BackColor);
            javax.microedition.lcdui.Graphics g = new javax.microedition.lcdui.Graphics(dg);

            // draw units

            // draw units
            if (toolStripButton7.Checked || toolStripButton8.Checked)
            {
                foreach (ListViewItem item in listView1.Items)
                {
                    try
                    {
                        Unit unit = ((Unit)UnitList[item]);

                        if (unit.type == "Map" && toolStripButton7.Checked)
                        {
                            if (toolStripButton10.Checked)
                            {
                                for (int x = 0; x < pictureBox1.Width; x += unit.getWidth())
                                {
                                    for (int y = 0; y < pictureBox1.Height; y += unit.getHeight())
                                    {
                                        Rectangle rect = new Rectangle(
                                            0,
                                            0,
                                            image.Width,
                                            image.Height
                                            );
                                        if (rect.IntersectsWith(
                                             new System.Drawing.Rectangle(
                                                x, y,
                                                unit.getWidth(),
                                                unit.getHeight())
                                                )
                                            )
                                        {
                                        }
                                        {
                                            int tx = unit.x;
                                            int ty = unit.y;
                                            unit.x = x;
                                            unit.y = y;
                                            unit.render(
                                               g,
                                               new System.Drawing.Rectangle(
                                                    0,
                                                    0,
                                                    image.Width,
                                                    image.Height
                                               ),
                                               listView1.SelectedItems.Contains(item),
                                               toolStripButton1.Checked,
                                               toolStripButton2.Checked
                                            );
                                            unit.x = tx;
                                            unit.y = ty;
                                        }
                                    }
                                }
                            }
                            else
                            {
                                unit.render(
                                   g,
                                   new System.Drawing.Rectangle(
                                        0,
                                            0,
                                            image.Width,
                                            image.Height
                                   ),
                                   listView1.SelectedItems.Contains(item),
                                   toolStripButton1.Checked,
                                   toolStripButton2.Checked
                                );
                            }
                        }

                        if (unit.type == "Sprite" && toolStripButton8.Checked)
                        {
                            unit.render(
                                   g,
                                    new System.Drawing.Rectangle(
                                         0,
                                            0,
                                            image.Width,
                                            image.Height
                                   ),
                                   listView1.SelectedItems.Contains(item),
                                   toolStripButton1.Checked,
                                   toolStripButton2.Checked
                                );
                        }

                    }
                    catch (Exception err)
                    {
                    }
                }
            }
            // draw way points
            if (toolStripButton9.Checked)
            {
                foreach (ListViewItem item in listView2.Items)
                {
                    WayPoint p = (WayPoint)WayPointsList[item];
                    if (p != null)
                    {
                        p.Render(g,item.Selected || item==popedWayPoint);
                        g.setColor(0xff, 0, 0, 0);
                        dg.DrawString(
                            listView2.Items.IndexOf(item).ToString(),
                            this.Font,
                            System.Drawing.Brushes.Black,
                            p.rect.X + p.rect.Width + 1,
                            p.rect.Y - p.rect.Height / 2);

                        //g.drawString(WayPoints.IndexOf(p).ToString(), p.rect.X + p.rect.Width + 1, p.rect.Y - p.rect.Height / 2, 0);
                    }
                }

            }


            MapMini mini = new MapMini(image);
            mini.Show();
        }

        // main update
        private void timer1_Tick(object sender, EventArgs e)
        {
            if (!this.Visible) return;

            if (toolStripButton16.Checked)
            {
                pictureBox1.Refresh();
                Unit.frameID++;
            }
        }

        // fix cell and world size
        private void numericUpDown1_ValueChanged(object sender, EventArgs e)
        {
            CellW = (int)numericUpDown1.Value;
            pictureBox1.Refresh();
        }
        private void numericUpDown2_ValueChanged(object sender, EventArgs e)
        {
            CellH = (int)numericUpDown2.Value;
            pictureBox1.Refresh();
        }
        private void numericUpDown3_ValueChanged(object sender, EventArgs e)
        {
            pictureBox1.Width = (int)numericUpDown3.Value;
            pictureBox1.Refresh();
        }
        private void numericUpDown4_ValueChanged(object sender, EventArgs e)
        {
            pictureBox1.Height = (int)numericUpDown4.Value;
            pictureBox1.Refresh();
        }

        // tab changed
        private void tabControl1_SelectedIndexChanged(object sender, EventArgs e)
        {
            //tabControl1.SelectedTab.Focus();
        }

  







    }

    [Serializable]
    public partial class Region : ISerializable
    {
        // serial
        public StringBuilder Data = new StringBuilder();
        public bool isSub = false;

        public System.Drawing.Rectangle rect;

        public Region(int x, int y)
        {
            rect = new Rectangle(x - 8, y - 8, 16, 16);
        }

        [SecurityPermissionAttribute(SecurityAction.Demand, SerializationFormatter = true)]
        protected Region(SerializationInfo info, StreamingContext context)
        {
            try
            {
                rect = new Rectangle(
                    (int)info.GetValue("X", typeof(int)),
                    (int)info.GetValue("Y", typeof(int)),
                    (int)info.GetValue("W", typeof(int)),
                    (int)info.GetValue("H", typeof(int))
                    );
                Data.Append((String)info.GetValue("Data", typeof(String)));
            }
            catch (Exception err)
            {
                Console.WriteLine("Region : " + err.StackTrace);
            }
        }
        [SecurityPermissionAttribute(SecurityAction.Demand, SerializationFormatter = true)]
        public virtual void GetObjectData(SerializationInfo info, StreamingContext context)
        {
            try
            {
                info.AddValue("X", rect.X);
                info.AddValue("Y", rect.Y);
                info.AddValue("W", rect.Width);
                info.AddValue("H", rect.Height);
                info.AddValue("Data", Data.ToString());
            }
            catch (Exception err)
            {
                Console.WriteLine("Region : " + err.StackTrace);
            }
        }

        public bool select(int x, int y)
        {
            if (rect.Contains(x, y))
            {
                return true;
            }
            return false;
        }

        public bool selectSub(int x, int y)
        {
            System.Drawing.Rectangle s_rect = new System.Drawing.Rectangle(rect.Right - 4, rect.Bottom - 4, 4, 4);
            if (s_rect.Contains(x, y))
            {
                return true;
            }
            return false;
        }

        public void Render(javax.microedition.lcdui.Graphics g,bool isCheck)
        {
            try
            {
                if (isCheck)
                {
                    g.setColor(0xff, 0xff, 0xff, 0xff);
                    g.drawRect(rect.X, rect.Y, rect.Width, rect.Height);
                    g.setColor(0x20, 0, 0xff, 0);
                    g.fillRect(rect.X, rect.Y, rect.Width, rect.Height);
                }
                else
                {
                    g.setColor(0xff, 0, 0xff, 0);
                    g.drawRect(rect.X, rect.Y, rect.Width, rect.Height);
                }

                //System.Drawing.Rectangle[] s_rect = new Rectangle[4];
                //s_rect[0] = new System.Drawing.Rectangle(rect.Left - 2, rect.Top - 2, 5, 5);
                //s_rect[1] = new System.Drawing.Rectangle(rect.Left - 2, rect.Bottom - 2, 5, 5);
                //s_rect[2] = new System.Drawing.Rectangle(rect.Right - 2, rect.Top - 2, 5, 5);
                //s_rect[3] = new System.Drawing.Rectangle(rect.Right - 2, rect.Bottom - 2, 5, 5);



                if (isCheck)
                {
                    System.Drawing.Rectangle s_rect = new System.Drawing.Rectangle(rect.Right - 4, rect.Bottom - 4, 4, 4);
                    g.setColor(0x80, 0xff, 0xff, 0xff);
                    g.drawRect(s_rect.X, s_rect.Y, s_rect.Width, s_rect.Height);
                }
                if (isSub)
                {
                    System.Drawing.Rectangle s_rect = new System.Drawing.Rectangle(rect.Right - 4, rect.Bottom - 4, 4, 4);
                    g.setColor(0xff, 0xff, 0xff, 0xff);
                    g.drawRect(s_rect.X, s_rect.Y, s_rect.Width, s_rect.Height);
                }



            }
            catch (Exception err)
            {
                Console.WriteLine("Region : " + err.StackTrace);
            }

        }

    }


    [Serializable]
    public partial class WayPoint : ISerializable
    {
        // serial
        public StringBuilder Data = new StringBuilder();
        //public bool isCheck = false;
        public System.Drawing.Rectangle rect;

        public ArrayList link = new ArrayList();

        public WayPoint(int x, int y)
        {
            rect = new Rectangle(x, y, 5, 5);
        }

        [SecurityPermissionAttribute(SecurityAction.Demand, SerializationFormatter = true)]
        protected WayPoint(SerializationInfo info, StreamingContext context)
        {
            try
            {
                rect = new Rectangle(
                    (int)info.GetValue("X", typeof(int)),
                    (int)info.GetValue("Y", typeof(int)),
                    5, 5
                    );
                link = (ArrayList)info.GetValue("link", typeof(ArrayList));

                try
                {
                    Data.Append((String)info.GetValue("Data", typeof(String)));
                }
                catch (Exception err) { }
            }
            catch (Exception err)
            {
                Console.WriteLine("Path : " + err.StackTrace);
            }
        }
        [SecurityPermissionAttribute(SecurityAction.Demand, SerializationFormatter = true)]
        public virtual void GetObjectData(SerializationInfo info, StreamingContext context)
        {
            try
            {
                info.AddValue("X", rect.X);
                info.AddValue("Y", rect.Y);
                info.AddValue("link", link);
                info.AddValue("Data", Data.ToString());
            }
            catch (Exception err)
            {
                Console.WriteLine("Path : " + err.StackTrace);
            }
        }

        public int getWX()
        {
            return rect.X - rect.Width / 2;
        }
        public int getWY()
        {
            return rect.Y - rect.Height / 2;
        }
        public bool Link2(WayPoint point)
        {
            if (point == null) return false;
            if (point == this) return false;

            if (!this.link.Contains(point))
            {
                this.link.Add(point);
            }
            if (!point.link.Contains(this))
            {
                point.link.Add(this);
            }

            return true;
        }

        public bool Link(WayPoint point)
        {
            if (point == null) return false;
            if (point == this) return false;

            if (!this.link.Contains(point))
            {
                this.link.Add(point);
            }

            return true;
        }

        public bool DisLink(WayPoint point)
        {
            if (point == null) return false;

            if (this.link.Contains(point))
            {
                this.link.Remove(point);
            }

            return true;
        }

        public bool DisLinkAll()
        {
            if (link.Count == 0) return false;

            foreach (WayPoint p in link)
            {
                if (p != null)
                {
                    if (p.link.Contains(this))
                    {
                        p.link.Remove(this);
                    }
                }
            }

            this.link.Clear();

            return true;
        }

        public void Render(javax.microedition.lcdui.Graphics g, bool isCheck)
        {
            try
            {
                int sx = rect.X + rect.Width / 2;
                int sy = rect.Y + rect.Height / 2;

                if (isCheck)
                {
                    g.setColor(0xff, 0xff, 0xff, 0xff);
                    g.drawRect(rect.X, rect.Y, rect.Width, rect.Height);
                }
                else
                {
                    g.setColor(0xff, 0, 0, 0xff);
                    g.drawRect(rect.X, rect.Y, rect.Width, rect.Height);
                }

                foreach (WayPoint p in link)
                {
                    if (p != null)
                    {
                        int dx = p.rect.X + p.rect.Width / 2;
                        int dy = p.rect.Y + p.rect.Height / 2;

                        float[] px = new float[3];
                        float[] py = new float[3];

                        float angle = (float)Math.Atan2(dy - sy, dx - sx);

                        px[0] = dx;
                        py[0] = dy;

                        px[1] = dx - (float)Math.Cos(angle - Math.PI / 12) * 10;
                        py[1] = dy - (float)Math.Sin(angle - Math.PI / 12) * 10;

                        px[2] = dx - (float)Math.Cos(angle + Math.PI / 12) * 10;
                        py[2] = dy - (float)Math.Sin(angle + Math.PI / 12) * 10;



                        if (isCheck)
                        {
                            g.setColor(0xff, 0xff, 0xff, 0xff);
                            g.drawLine(sx, sy, dx, dy);
                            g.dg.FillPolygon(g.brush,
                                new PointF[] { 
                                new PointF(px[0],py[0]),
                                new PointF(px[1],py[1]),
                                new PointF(px[2],py[2]),
                            }
                            );
                        }
                        else
                        {
                            g.setColor(0x80, 0x00, 0x00, 0xff);
                            g.drawLine(sx, sy, dx, dy);
                            g.dg.FillPolygon(g.brush,
                                new PointF[] { 
                                new PointF(px[0],py[0]),
                                new PointF(px[1],py[1]),
                                new PointF(px[2],py[2]),
                            }
                            );
                        }

                        //float degree = Math.Atan();

                    }
                }





            }
            catch (Exception err)
            {
                Console.WriteLine("Path : " + err.StackTrace);
            }

        }

    }


    [Serializable]
    public partial class Unit : ISerializable
    {

        static public int frameID = 0;

        public StringBuilder Data = new StringBuilder();
        public String id = "null";
        public String type = "null";

        public SpriteForm spr = null;
        public MapForm map = null;

        public int animID = 0;

        public int x = 0;
        public int y = 0;
        public int w = 8;
        public int h = 8;
        //public 


        public Unit(SpriteForm spr, String no)
        {
            this.id = no + spr.id;
            this.spr = spr;
            this.animID = 0;

            this.w = 10;
            this.h = 10;

            this.type = "Sprite";


        }
        public Unit(MapForm map, String no)
        {
            this.id = no + map.id;
            this.map = map;
            this.w = 10;
            this.h = 10;
            this.type = "Map";
        }

        [SecurityPermissionAttribute(SecurityAction.Demand, SerializationFormatter = true)]
        protected Unit(SerializationInfo info, StreamingContext context)
        {
            try
            {
                id = (String)info.GetValue("id", typeof(String));
                x = (int)info.GetValue("x", typeof(int));
                y = (int)info.GetValue("y", typeof(int));
                try
                {
                    animID = (int)info.GetValue("animID", typeof(int));
                }
                catch (Exception err)
                {
                    animID = 0;
                }
                if ((MapForm)info.GetValue("map", typeof(MapForm)) != null)
                {
                    map = (MapForm)info.GetValue("map", typeof(MapForm));
                    this.type = "Map";
                }
                if ((SpriteForm)info.GetValue("spr", typeof(SpriteForm)) != null)
                {
                    spr = (SpriteForm)info.GetValue("spr", typeof(SpriteForm));
                    this.type = "Sprite";
                }

                try
                {
                    Data.Append((String)info.GetValue("Data", typeof(String)));
                }
                catch (Exception err) { }
            }
            catch (Exception err)
            {
                Console.WriteLine("Unit:" + err.StackTrace);
            }


        }
        [SecurityPermissionAttribute(SecurityAction.Demand, SerializationFormatter = true)]
        public virtual void GetObjectData(SerializationInfo info, StreamingContext context)
        {
            try
            {
                info.AddValue("id", id);
                info.AddValue("x", x);
                info.AddValue("y", y);
                info.AddValue("animID", animID);
                try
                {
                    info.AddValue("map", map);
                }
                catch (Exception err) { }
                try
                {
                    info.AddValue("spr", spr);
                }
                catch (Exception err) { }

                info.AddValue("Data", Data.ToString());
            }
            catch (Exception err)
            {
                Console.WriteLine("Unit:" + err.StackTrace);
            }
        }

        public bool isKilled()
        {
            if (spr == null && map == null ||
                (spr != null && spr.IsDisposed) ||
                (map != null && map.IsDisposed) /*||
                (spr != null && spr.Enabled) || 
                (map != null && map.Enabled)*/
                                                )
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        public int getWidth()
        {
            if (map != null)
                return map.getWidth();
            else
                return w;
        }

        public int getHeight()
        {
            if (map != null)
                return map.getHeight();
            else
                return h;
        }

        public void render(
            javax.microedition.lcdui.Graphics g,
            System.Drawing.Rectangle scope,
            Boolean selected,
            Boolean select,
            Boolean debug)
        {

            if (spr != null)
            {
                spr.Render(g, x, y, debug, animID, frameID);
            }
            else if (map != null)
            {
                map.Render(g, x, y, scope, false, debug, true, frameID);
            }


            if (selected)
            {
                g.setColor(0xff, 0xff, 0xff, 0xff);
                g.drawRect(x - w / 2, y - h / 2, w, h);
                g.drawLine(x, y - h, x, y + h);
                g.drawLine(x + w, y, x - w, y);

                if (select)
                {
                    g.setColor(0xff, 0xff, 0xff, 0xff);
                    g.drawRect(x - w / 2, y - h / 2, w, h);
                    g.drawLine(x, y - h, x, y + h);
                    g.drawLine(x + w, y, x - w, y);
                }
            }
            else
            {
                if (select)
                {
                    g.setColor(0xff, 0xff, 0xff, 0xff);
                    g.drawRect(x - w / 2, y - h / 2, w, h);
                }
            }



        }


    }


    [Serializable]
    public partial class Event : ISerializable
    {
        [SecurityPermissionAttribute(SecurityAction.Demand, SerializationFormatter = true)]
        protected Event(SerializationInfo info, StreamingContext context)
        {
            try
            {
            }
            catch (Exception err)
            {
                Console.WriteLine("Unit:" + err.StackTrace);
            }
        }
        [SecurityPermissionAttribute(SecurityAction.Demand, SerializationFormatter = true)]
        public virtual void GetObjectData(SerializationInfo info, StreamingContext context)
        {
            try
            {

            }
            catch (Exception err)
            {
                Console.WriteLine("Event:" + err.StackTrace);
            }
        }

    }

}
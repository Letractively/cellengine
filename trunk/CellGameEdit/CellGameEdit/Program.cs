using System;
using System.Collections.Generic;
using System.Windows.Forms;

namespace CellGameEdit
{
    static class Program
    {
        /// <summary>
        /// 应用程序的主入口点。
        /// </summary>
        [STAThread]
        static void Main(string[] args)
        {
            try{
                if((args!= null) && (args.Length > 0))
                {                
                    string filePath = args[0] ;

                    Application.EnableVisualStyles();
                    Application.SetCompatibleTextRenderingDefault(false);
                    Application.Run(new Form1(filePath));
                }else{
                    Application.EnableVisualStyles();
                    Application.SetCompatibleTextRenderingDefault(false);
                    Application.Run(new Form1());
                }

            }catch(Exception err){
                MessageBox.Show(err.Message);
            }
            
           
        }
    }


}
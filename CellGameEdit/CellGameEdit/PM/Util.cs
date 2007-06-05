using System;
using System.Collections.Generic;
using System.Collections;
using System.Text;
using System.IO;

namespace CellGameEdit.PM
{
    class Util
    {
        public static string FormatArray1D_h = "";
        public static string FormatArray1D_t = ",";

        public static string FormatArray2D_h = "{";
        public static string FormatArray2D_t = "},";

        public static string FormatStringArray1D_h = "\"";
        public static string FormatStringArray1D_t = "\",";

        public static string FormatStringArray2D_h = "{\"";
        public static string FormatStringArray2D_t = "\"},";

        public static string fixControlText(string str)
        {
            string ret = str;
            ret = ret.Replace("\\n", "\n");
            ret = ret.Replace("\\t", "\t");
            //Console.WriteLine("replace ");
            return ret;
        }

        public static void setFormatArray1D(String format, String elementKey)
        {
            try
            {
                string[] ht = format.Split(new string[] { elementKey },StringSplitOptions.None);
                FormatArray1D_h = ht[0];
                FormatArray1D_t = ht[1];
            }
            catch (Exception err)
            {
                FormatArray1D_h = "";
                FormatArray1D_t = ",";
                Console.WriteLine("Set Array Format Error ! Set Default. ");
            }

            FormatArray1D_h = fixControlText(FormatArray1D_h);
            FormatArray1D_t = fixControlText(FormatArray1D_t);
            Console.WriteLine("FormatArray1D : " + FormatArray1D_h + elementKey + FormatArray1D_t);
        }
        public static void setFormatArray2D(String format, String elementKey)
        {
            try
            {
                string[] ht = format.Split(new string[] { elementKey }, StringSplitOptions.None);
                FormatArray2D_h = ht[0];
                FormatArray2D_t = ht[1];
            }
            catch (Exception err)
            {
                FormatArray2D_h = "{";
                FormatArray2D_t = "},";
                Console.WriteLine("Set Array Format Error ! Set Default. ");
            }

            FormatArray2D_h = fixControlText(FormatArray2D_h);
            FormatArray2D_t = fixControlText(FormatArray2D_t);
            Console.WriteLine("FormatArray2D : " + FormatArray2D_h + elementKey + FormatArray2D_t);
        }

        public static void setFormatStringArray1D(String format, String elementKey)
        {
            try
            {
                string[] ht = format.Split(new string[] { elementKey }, StringSplitOptions.None);
                FormatStringArray1D_h = ht[0];
                FormatStringArray1D_t = ht[1];
            }
            catch (Exception err)
            {
                FormatStringArray1D_h = "\"";
                FormatStringArray1D_t = "\",";
                Console.WriteLine("Set Array Format Error ! Set Default. ");
            }

            FormatStringArray1D_h = fixControlText(FormatStringArray1D_h);
            FormatStringArray1D_t = fixControlText(FormatStringArray1D_t);
            Console.WriteLine("FormatStringArray1D : " + FormatStringArray1D_h + elementKey + FormatStringArray1D_t);
        }
        public static void setFormatStringArray2D(String format, String elementKey)
        {
            try
            {
                string[] ht = format.Split(new string[] { elementKey }, StringSplitOptions.None);
                FormatStringArray2D_h = ht[0];
                FormatStringArray2D_t = ht[1];
            }
            catch (Exception err)
            {
                FormatStringArray2D_h = "{\"";
                FormatStringArray2D_t = "\"},";
                Console.WriteLine("Set Array Format Error ! Set Default. ");
            }

            FormatStringArray2D_h = fixControlText(FormatStringArray2D_h);
            FormatStringArray2D_t = fixControlText(FormatStringArray2D_t);
            Console.WriteLine("FormatStringArray2D : " + FormatStringArray2D_h + elementKey + FormatStringArray2D_t);
        }


        //public static String toTextArray(short[] array)
        //{
        //    String ret = "";
        //    for (int i = 0; i < array.Length; i++)
        //    {
        //        ret += FormatArray1D_h + array[i].ToString() + FormatArray1D_t;
        //    }
        //    return ret;
        //}

        //public static String toTextArray(byte[] array)
        //{
        //    String ret = "";
        //    for (int i = 0; i < array.Length; i++)
        //    {
        //        ret += FormatArray1D_h + array[i].ToString() + FormatArray1D_t;
        //    }
        //    return ret;
        //}

        public static String toTextArray1D<T>(ref T[] array)
        {
            String ret = "";
            for (int i = 0; i < array.Length; i++)
            {
                ret += FormatArray1D_h + array[i].ToString() + FormatArray1D_t;
            }
            return ret;
        }
        public static String toTextArray2D<T>(ref T[][] array)
        {
            String ret = "";
            for (int i = 0; i < array.Length; i++)
            {
                ret += FormatArray2D_h + toTextArray1D<T>(ref array[i]) + FormatArray2D_t;
            }
            return ret;
        }

        public static String toStringArray1D(string[] array)
        {
            String ret = "";
            for (int i = 0; i < array.Length; i++)
            {
                ret += FormatStringArray1D_h + array[i] + FormatStringArray1D_t;
            }
            return ret;
        }
        public static String toStringArray2D(string[][] array)
        {
            String ret = "";
            for (int i = 0; i < array.Length; i++)
            {
                ret += FormatStringArray2D_h + toStringArray1D(array[i]) + FormatStringArray2D_t;
            }
            return ret;
        }

        public static String[] toStringMultiLine(string src)
        {
            return src.Split(new char[] {'\n'});
        }

        /// 
        /// 取得一个文本文件的编码方式。如果无法在文件头部找到有效的前导符，Encoding.Default将被返回。
        /// 
        /// 文件名。
        /// 
        public static Encoding GetEncoding(string fileName)
        {
            return GetEncoding(fileName, Encoding.Default);

        }

        /// 
        /// 取得一个文本文件流的编码方式。
        /// 
        /// 文本文件流。
        /// 
        public static Encoding GetEncoding(FileStream stream)
        {

            return GetEncoding(stream, Encoding.Default);

        }

        /// 
        /// 取得一个文本文件的编码方式。
        /// 
        /// 文件名。
        /// 默认编码方式。当该方法无法从文件的头部取得有效的前导符时，将返回该编码方式。
        /// 
        public static Encoding GetEncoding(string fileName, Encoding defaultEncoding)
        {

            FileStream fs = new FileStream(fileName, FileMode.Open);

            Encoding targetEncoding = GetEncoding(fs, defaultEncoding);

            fs.Close();

            return targetEncoding;

        }

        /// 
        /// 取得一个文本文件流的编码方式。
        /// 
        /// 文本文件流。
        /// 默认编码方式。当该方法无法从文件的头部取得有效的前导符时，将返回该编码方式。
        /// 
        public static Encoding GetEncoding(FileStream stream, Encoding defaultEncoding)
        {

            Encoding targetEncoding = defaultEncoding;

            if (stream != null && stream.Length >= 2)
            {

                //保存文件流的前4个字节

                byte byte1 = 0;

                byte byte2 = 0;

                byte byte3 = 0;

                byte byte4 = 0;

                //保存当前Seek位置

                long origPos = stream.Seek(0, SeekOrigin.Begin);

                stream.Seek(0, SeekOrigin.Begin);



                int nByte = stream.ReadByte();

                byte1 = Convert.ToByte(nByte);

                byte2 = Convert.ToByte(stream.ReadByte());

                if (stream.Length >= 3)
                {

                    byte3 = Convert.ToByte(stream.ReadByte());

                }

                if (stream.Length >= 4)
                {

                    byte4 = Convert.ToByte(stream.ReadByte());

                }

                //根据文件流的前4个字节判断Encoding

                //Unicode {0xFF, 0xFE};

                //BE-Unicode {0xFE, 0xFF};

                //UTF8 = {0xEF, 0xBB, 0xBF};

                if (byte1 == 0xFE && byte2 == 0xFF)//UnicodeBe
                {

                    targetEncoding = Encoding.BigEndianUnicode;

                }

                if (byte1 == 0xFF && byte2 == 0xFE && byte3 != 0xFF)//Unicode
                {

                    targetEncoding = Encoding.Unicode;

                }

                if (byte1 == 0xEF && byte2 == 0xBB && byte3 == 0xBF)//UTF8
                {

                    targetEncoding = Encoding.UTF8;

                }

                //恢复Seek位置       

                stream.Seek(origPos, SeekOrigin.Begin);

            }

            return targetEncoding;

        }


//---------------------------------------------------------------------------------------------------------------------------------------------
        
        public static string getCommandScript(string script , string command)
        {
            try
            {
                if (script.Contains(command))
                {
                    int start = script.IndexOf(command) + command.Length;
                    int end = start;
                    for (int i = start; i < script.Length;i++ )
                    {
                        if (script[i] == '\n') 
                        { 
                            end = i; 
                            break; 
                        }
                    }
                    string ret = script.Substring(start,end-start);

                    return ret.Trim();
                }
            }
            catch (Exception err) {}
            return "";
        }

        public static string removeTrunkScript(string script, string start, string end)
        {
            try
            {
                int first = script.IndexOf(start);
                int last = script.IndexOf(end) + end.Length;
                string ret = script.Remove(first, last - first);
                
                return ret;
            }
            catch (Exception err)
            {
                return script.Insert(0, "/* remove trunk ERROR " + start + "->" + end + ": " + err.StackTrace + "  at  " +err.Message + " */ ");
            }
        }

        public static string getFullTrunkScript(string script, string start, string end)
        {
            try
            {
                int first = script.IndexOf(start) ;
                int last = script.IndexOf(end) + end.Length ;
                string ret = script.Substring(first, last - first);
                return ret;
            }
            catch (Exception err)
            {
                return script.Insert(0, "/* get full trunk ERROR " + start + "->" + end + ": " + err.StackTrace + "  at  " +err.Message + " */ ");
            }
        }
      
        public static string replaceKeywordsScript(string script, string start, string end, string[] src,string[] dst)
        {
            try
            {
                int first = script.IndexOf(start) + start.Length;
                int last = script.IndexOf(end);
                string ret = script.Substring(first, last - first);
                
                if (src != null && dst != null)
                {
                    for (int i = 0; i < src.Length ; i++)
                    {
                        ret = ret.Replace(src[i], dst[i]);
                    }
                }
                
                return ret;
            }
            catch (Exception err) 
            {
                return script.Insert(0, "/* replace keywords ERROR " + start + "->" + end + ": " + err.StackTrace + "  at  " +err.Message + " */ ");
            }
        }

        public static string replaceSubTrunksScript(string script, string start, string end, string[] dst)
        {
            try
            {
                int first = script.IndexOf(start);
                int last = script.IndexOf(end) + end.Length;
                string ret = script.Substring(0, script.Length);
                if (first < 0 || last-end.Length < 0) return null;

                if (dst != null)
                {
                    for (int i = dst.Length - 1; i>=0; i--)
                    {
                        ret = ret.Insert(first, dst[i]);
                    }
                }

                ret = removeTrunkScript(ret, start, end);

                return ret;
            }
            catch (Exception err)
            {
                Console.WriteLine( "/* replace sub trunks ERROR " + start + "->" + end + " : "+err.StackTrace + "  at  " +err.Message+" */ ");
                return null; 
            }
        }

        public static string getTrunk(string script, string start, string end)
        {
            try
            {
                int first = script.IndexOf(start);
                int last = script.IndexOf(end) + end.Length;
                if (first < 0 || last - end.Length < 0) return null;
                string ret = script.Substring(first, last - first);

                return ret;
            }
            catch (Exception err)
            {
                return null;
            }
        }

    }
}

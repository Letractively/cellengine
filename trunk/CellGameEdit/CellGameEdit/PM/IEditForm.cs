using System;
using System.Collections.Generic;
using System.Text;
using System.Windows.Forms;

namespace CellGameEdit.PM
{
    interface IEditForm
    {
        
        string getID();

        void setID(string id);

        Form getForm();

        void OutputCustom(int index, String script, System.IO.StringWriter output);
    }
}

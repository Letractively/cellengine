
package com.cell.ui.edit.comp
{
	import com.cell.ui.component.UIComponent;
	import com.cell.ui.edit.UIEdit;
	import com.cell.ui.layout.UIRect;
	
	import flash.xml.XMLNode;
	
	
	public class UELabel extends UIComponent implements SavedComponent
	{
		public function UELabel() 
		{	
			super(new UIRect(UIRect.IMAGE_STYLE_NULL, 0));
		}
		
		public function onRead(edit:UIEdit, e:XMLNode) : void
		{
		}
		
	}
}
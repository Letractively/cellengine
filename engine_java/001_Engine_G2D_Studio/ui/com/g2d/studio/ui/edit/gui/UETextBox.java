package com.g2d.studio.ui.edit.gui;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.g2d.annotation.Property;
import com.g2d.display.ui.TextPan;
import com.g2d.studio.ui.edit.UIEdit;
import com.g2d.text.MultiTextLayout;

public class UETextBox extends TextPan implements SavedComponent
{
	@Property("文本")
	public String Text = "";
	
	public UETextBox() {}
	
	@Override
	public void onRead(UIEdit edit, Element e, Document doc) throws Exception {}

	@Override
	public void onWrite(UIEdit edit, Element e, Document doc) throws Exception{}	
	
	@Override
	public void readComplete(UIEdit edit) {}
	@Override
	public void writeBefore(UIEdit edit) {}
	
	@Override
	public void update() {
		if (super.getText().equals(Text) == false) {
			super.setText(Text);
		}
		super.update();
	}
}

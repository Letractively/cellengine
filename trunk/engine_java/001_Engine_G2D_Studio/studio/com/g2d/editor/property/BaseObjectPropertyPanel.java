package com.g2d.editor.property;

import java.awt.Color;
import java.awt.Component;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.EventObject;
import java.util.Hashtable;
import java.util.Map;

import javax.swing.AbstractCellEditor;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellEditor;

import com.cell.reflect.Parser;
import com.g2d.display.ui.layout.UILayout;
import com.g2d.editor.Util;

@SuppressWarnings("serial")
public abstract class BaseObjectPropertyPanel extends JPanel implements ObjectPropertyEdit
{
	final protected Map<Class<?>, CellEditAdapter<?>>	
							edit_adapters 	= new Hashtable<Class<?>, CellEditAdapter<?>>();
	

	public BaseObjectPropertyPanel(CellEditAdapter<?> ... adapters)
	{
		for (CellEditAdapter<?> ad : adapters) {
			edit_adapters.put(ad.getClass(), ad);
		}
	}
	
	final public Collection<CellEditAdapter<?>> getAdapters() {
		return edit_adapters.values();
	}
	
	@Override
	final public Component getComponent() {
		return this;
	}
	
	/**
	 * 用户自定义该字段显示的内容
	 * @param object		被编辑的对象
	 * @param field			被编辑的对象类的字段
	 * @param field_value	被编辑的对象类的字段当前值
	 * @return
	 */
	final protected Component getPropertyCellRender(DefaultTableCellRenderer src, Object object, Field field, Object field_value) {
		try {
			for (CellEditAdapter<?> ad : edit_adapters.values()) {
				if (ad.getType().isInstance(object)) {
					Component ret = ad.getCellRender(this, object, field_value, field, src);
					if (ret != null) {
						return ret;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return src;
	}
	
	/**
	 * 用户自定义该字段显示的内容(下面的信息栏里)
	 * @param object		被编辑的对象
	 * @param field			被编辑的对象类的字段
	 * @param field_value	被编辑的对象类的字段当前值
	 * @return
	 */
	final protected String getPropertyCellText(Object object, Field field, Object field_value) {
		try {
			for (CellEditAdapter<?> ad : edit_adapters.values()) {
				if (ad.getType().isInstance(object)) {
					String ret = ad.getCellText(object, field, field_value);
					if (ret != null) {
						return ret;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return field_value + "";
	}
	
	/**
	 * 创建一个单元格的编辑器，该编辑器必须实现 PropertyCellEdit<br>
	 * 用于用户自自定义子类的编辑器
	 * @param object		被编辑的对象
	 * @param field			被编辑的对象类的字段
	 * @param field_value	被编辑的对象类的字段当前值
	 * @return
	 */
	final protected PropertyCellEdit<?> getPropertyCellEdit(Object object, Field field, Object field_value)
	{
		// 从适配器里选取
		try {
			for (CellEditAdapter<?> ad : edit_adapters.values()) {
				if (ad.getType().isInstance(object)) {
					PropertyCellEdit<?> edit = ad.getCellEdit(this, object, field_value, field);
					if (edit != null) {
						return edit;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (field.getType().isEnum()) 
		{
			@SuppressWarnings("unchecked")
			ListEnumEdit edit = new ListEnumEdit(field.getType());
			return edit;
		}
		else if (field.getType().equals(Boolean.class) || field.getType().equals(boolean.class)) {
			ComboBooleanEdit edit = new ComboBooleanEdit((Boolean)field_value);
			return edit;
		}
		else if (field.getType().equals(Color.class))
		{
			PopupCellEditColor edit_color 		= new PopupCellEditColor();
			edit_color.setValue(field_value!=null ? (Color)field_value : null, this);
			return edit_color;
		}
//		else if (field.getType().equals(UILayout.class))
//		{
//			PopupCellEditUILayout edit_ui_layout	= new PopupCellEditUILayout();
//			edit_ui_layout.setValue(field_value!=null ? (UILayout)field_value : null, this);
//			return edit_ui_layout;
//		}
		else if (Parser.isNumber(field.getType())) 
		{
			NumberCellEdit numedit = new NumberCellEdit(field.getType(), field_value);
			return numedit;
		}
		else {
			TextCellEdit text_edit = new TextCellEdit();
			text_edit.setText(Util.fromObject(field_value));
			return text_edit;
		}
	}
	
	/**
	 * 当字段属性编辑器完成编辑后，得到单元格的值<br>
	 * 用于用户自自定义子类的编辑器
	 * @param object		被编辑的对象
	 * @param field			被编辑的对象类的字段
	 * @param edit			字段属性编辑器
	 * @param src_value		被编辑的对象类的字段原值
	 * @return
	 */
	final protected Object getPropertyCellEditValue(Object object, Field field, PropertyCellEdit<?> edit, Object src_value)
	{
		try{
			for (CellEditAdapter<?> ad : edit_adapters.values()) {
				if (ad.getType().isInstance(object)) {
					Object ret = ad.getCellValue(object, edit, field, src_value);
					if (ret!=null){
						return ret;
					}
				}
			}
		}catch(Exception err){
			err.printStackTrace();
		}
		
		Object obj = null;
		if (edit instanceof NumberCellEdit) {
			obj = ((NumberCellEdit)edit).getValue();
		}
		else if (edit instanceof TextCellEdit) {
			obj = Util.parseObject(((TextCellEdit) edit).getValue(), src_value == null ? field.getType() : src_value.getClass());
		}
		else {
			obj = edit.getValue();
		}
		return obj;
	}

	/**
	 * 当单月格的值被改变时回调
	 * @param object 当前被改变的对象
	 * @param field 该对象在其所有者中的字段
	 */
	final protected void onFieldChanged(Object object, Field field){
		try{
			for (CellEditAdapter<?> ad : edit_adapters.values()) {
				if (ad.getType().isInstance(object)) {
					if (ad.fieldChanged(
							object, field.get(object), field)){
						return;
					}
				}
			}
		}catch(Exception err){
			err.printStackTrace();
		}finally{
//			try{
//				rows_table.valueChanged(null);
//			}catch(Exception err){}
		}
	}

//	--------------------------------------------------------------------------------------------------------------------------------------
	
	/**
	 * 空编辑器
	 * @author WAZA
	 *
	 */
	public static class NullEditor extends AbstractCellEditor implements TableCellEditor
	{
		private static final long serialVersionUID = 1L;
		@Override
		public boolean isCellEditable(EventObject e) {return false;}
		public Object getCellEditorValue() {return null;}
		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column){return null;}
	}
	
//	--------------------------------------------------------------------------------------------------------------------------------------
	
}
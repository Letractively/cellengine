package com.g2d.studio.ui.edit;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.KeyEvent;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.tree.TreeNode;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import com.cell.reflect.Parser;
import com.g2d.BufferedImage;
import com.g2d.Color;
import com.g2d.Engine;
import com.g2d.Graphics2D;
import com.g2d.annotation.Property;
import com.g2d.awt.util.AbstractDialog;
import com.g2d.display.DragResizeObject;
import com.g2d.display.InteractiveObject;
import com.g2d.display.event.MouseMoveEvent;
import com.g2d.display.ui.UIComponent;
import com.g2d.display.ui.layout.ImageUILayout;
import com.g2d.display.ui.layout.UILayout;
import com.g2d.display.ui.layout.UILayout.ImageStyle;
import com.g2d.display.ui.layout.UILayoutManager;
import com.g2d.editor.property.ObjectPropertyListener;
import com.g2d.editor.property.ObjectPropertyPanel;
import com.g2d.java2d.impl.AwtEngine;
import com.g2d.studio.gameedit.ObjectViewer;
import com.g2d.studio.swing.G2DTreeNode;
import com.g2d.studio.swing.G2DTreeNodeGroup.NodeMenu;
import com.g2d.studio.ui.edit.gui.SavedComponent;
import com.g2d.studio.ui.edit.gui.UECanvas;
import com.g2d.studio.ui.edit.gui.UERoot;


public class UITreeNode extends G2DTreeNode<UITreeNode> 
implements ObjectPropertyListener
{
	final public UIComponent display;
	final public ObjectPropertyPanel opp;
	
	private BufferedImage icon;
	private UIEdit edit;
	
	public UITreeNode(UIEdit edit, Class<?> type, String name) 
	{
		this.edit = edit;
		
		DisplayAdapter adapter = new DisplayAdapter();
		this.display = createDisplay(type);
		this.display.name = name;
		this.display.debugDraw = adapter;
		this.display.enable = true;
		this.display.enable_drag = true;
		this.display.enable_drag_resize = true;
		this.display.enable_key_input = true;
		this.display.enable_focus = true;
		this.display.addEventListener(adapter);
		this.opp = new ObjectPropertyPanel(display, 100, 200, false); 
		this.opp.addObjectPropertyListener(this);
		
		this.setAllowsChildren(display instanceof com.g2d.display.ui.Container);
	}
	
	protected UIComponent createDisplay(Class<?> type) {
		try {
			UIComponent uie = (UIComponent) type.newInstance();
			return uie;
		} catch (Exception e) {
			return new UECanvas();
		}
	}
	
	@Override
	public void onFieldChanged(Object object, Field field) {
		getIcon(true);
		edit.getTree().repaint();
	}
	
	@Override
	protected ImageIcon createIcon() {
		UILayout uc = display.getCustomLayout();
		if (uc == null) {
			uc = display.getLayout();
		}
		if (uc != null) {
			icon = Engine.getEngine().createImage(40, 30);
			Graphics2D g = icon.createGraphics();
			g.setClip(0, 0, 40, 30);
			uc.render(g, 0, 0, 40, 30);
			g.dispose();
			return new ImageIcon(AwtEngine.unwrap(icon));
		}
		return null;
	}
	
	@Override
	public String getName() {
		return this.display.name + "";
	}
	public void setName(String name) {
		this.display.name = name;
	}
	@Override
	public void onClicked(JTree tree, MouseEvent e) {
		edit.onSelectTreeNode(this);
	}
	@Override
	public void onRightClicked(JTree tree, MouseEvent e) {
		new UIMenu(tree, this).show(tree, e.getX(), e.getY());
	}
	public boolean isSelected() {
		return edit.getTree().getSelectedNode() == this;
	}
	
	class DisplayAdapter implements 
	com.g2d.display.event.MouseListener, 
	com.g2d.display.event.MouseMoveListener,
	com.g2d.display.event.KeyListener,
	com.g2d.display.event.MouseDragResizeListener,
	com.g2d.display.ui.UIComponent.DebugModeDraw
	{		
		@Override
		public void mouseClick(com.g2d.display.event.MouseEvent e) {
			
		}
		@Override
		public void mouseDown(com.g2d.display.event.MouseEvent e) {
			edit.onSelectTreeNode(UITreeNode.this);
		}
		@Override
		public void mouseUp(com.g2d.display.event.MouseEvent e) {
			opp.refresh();
		}
		
		@Override
		public void mouseDragged(MouseMoveEvent e)
		{
			if (edit.isGridEnable()) 
			{
				edit.getLayoutManager().gridPos(display);
			}
		}
		
		@Override
		public void onDragResizeEnd(InteractiveObject object) {}

		@Override
		public void onDragResizeRunning(InteractiveObject object, DragResizeObject dr) 
		{
			if (edit.isGridEnable()) 
			{
				edit.getLayoutManager().gridSize(dr.start_drag_bounds);
			}
		}

		@Override
		public void onDragResizeStart(InteractiveObject object, int drag_type) {}
		
		
		@Override
		public void keyDown(com.g2d.display.event.KeyEvent e) {
		
		}
		@Override
		public void keyTyped(com.g2d.display.event.KeyEvent e) {

		}
		@Override
		public void keyUp(com.g2d.display.event.KeyEvent e) {}
		
		
		
		@Override
		public void render(com.g2d.Graphics2D g, UIComponent ui) 
		{
			if (edit.getTree().getSelectedNode() == UITreeNode.this) 
			{
				float alpha = 0.5f + (float)Math.sin(ui.timer / 5.0f)/2;
				int s1 = 3;
				int s2 = 6;
				int s4 = 12;
				int w = ui.getWidth();
				int h = ui.getHeight();
				
				g.pushClip();
				g.setClip(-s2, -s2, w+s4, h+s4);
				
				g.setColor(new Color(alpha, alpha, alpha, 1));
				g.drawRect(0, 0, w-1, h-1);
				
				g.fillRect( -s1,  -s1, s2, s2);
				g.fillRect(w-s1,  -s1, s2, s2);
				g.fillRect( -s1, h-s1, s2, s2);
				g.fillRect(w-s1, h-s1, s2, s2);
				
				g.fillRect(w/2-s1,  -s1, s2, s2);
				g.fillRect(w/2-s1, h-s1, s2, s2);
				g.fillRect( -s1, h/2-s1, s2, s2);
				g.fillRect(w-s1, h/2-s1, s2, s2);
				
				
				g.popClip();
			}
		}
	}

	
//	---------------------------------------------------------------------------------------------------------------

	class UIMenu extends NodeMenu<UITreeNode>
	{
		protected JMenuItem add = new JMenuItem("添加");
		
		public UIMenu(JTree tree, UITreeNode node) {
			super(node);
			super.remove(open);
			super.remove(rename);
			if (display instanceof com.g2d.display.ui.Container) {
				super.insert(add, 1);
				add.addActionListener(this);
			}
		}
		
		@Override
		public void actionPerformed(ActionEvent e)
		{
			if (e.getSource() == add) 
			{
				Class<?> type = edit.getSelectedTemplate().uiType;
				if (type != null) {
					String name = JOptionPane.showInputDialog(
							AbstractDialog.getTopWindow(getInvoker()), "输入名字！",
							"");
					if (name != null && name.length() > 0) {
						UITreeNode tn = createChild(type, name);
						if (tn == null) {
							JOptionPane.showMessageDialog(this,
									display.getClass().getSimpleName()+"不能添加子节点！");
						}
					}
				}
			}
			else if (e.getSource() == delete) 
			{
				TreeNode parent = node.getParent();
				this.node.removeFromParent();
				this.node.display.removeFromParent();
				if (tree!=null) {
					tree.reload(parent);
				}
			}
		}
	}
	
	public UITreeNode removeChild(UITreeNode tr) {
		try {
			super.remove(tr);
			this.display.removeChild(tr.display);
			return tr;
		} catch (Exception e) {}
		return null;
	}
	
	public void clearChilds() {
		while (getChildCount()>0) {
			removeChild((UITreeNode)getFirstChild());
		}
	}
	
	public UITreeNode createChild(Class<?> type, String name) 
	{
		try {
			if (display instanceof com.g2d.display.ui.Container) {
				UITreeNode node = new UITreeNode(edit, type, name);
				com.g2d.display.ui.Container pc = (com.g2d.display.ui.Container) display;
				if (pc.addComponent(node.display)) {
					this.add(node);
				}
				edit.getTree().reload(this);
				return node;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	

	public void fromXMLStream(UIEdit edit, InputStream is) throws Exception
	{
		try {
			clearChilds();
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(is);
			Element e = doc.getDocumentElement();
			if (e != null) {
				readInternal(edit, doc, e, this);
			} else {
				throw new Exception("格式错误!");
			}
		} catch (SAXParseException err) {
			throw new Exception("** Parsing error" + ", line "
					+ err.getLineNumber() + ", uri " + err.getSystemId(), err);
		} catch (SAXException e) {
			throw e;
		}
	}
	
	public void toXMLStream(UIEdit edit, OutputStream os) throws Exception
	{
		try {
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
			Document doc = docBuilder.newDocument();
			Element e = doc.createElement(this.getClass().getCanonicalName());
			doc.appendChild(e);
			writeInternal(edit, doc, e, this);
			doc.normalizeDocument();
			Transformer transformer = TransformerFactory.newInstance()
					.newTransformer();
			transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.transform(
					new DOMSource(doc), 
					new StreamResult(os));
		} catch (SAXException e) {
			Exception x = e.getException();
			((x == null) ? e : x).printStackTrace();
			throw e;
		}
	}

	private static void readInternal(UIEdit edit, Document doc, Element e, UITreeNode ui) throws Exception
	{
		readFields(edit, e, ui.display);
		if (ui.display instanceof SavedComponent) {
			((SavedComponent)ui.display).onRead(edit, e);
		}
		
		NodeList list = e.getChildNodes();
		for (int i=0; i<list.getLength(); i++)
		{
			if (list.item(i) instanceof Element) 
			{
				Element ev = (Element)list.item(i);
				
				if (ev.getNodeName().equals("layout")) 
				{
					UILayout layout = readLayout(edit, ev);
					ui.display.setCustomLayout(layout);
				}
				else if (ev.getNodeName().equals("childs"))
				{
					NodeList childs = ev.getChildNodes();
					for (int c=0; c<childs.getLength(); c++) {
						if (childs.item(c) instanceof Element) {
							Element child = (Element)childs.item(c);
							Class<?> type = Class.forName(child.getNodeName());
							UITreeNode tn = ui.createChild(type, "");
							readInternal(edit, doc, child, tn);
						}
					}
				}
			}
		}
		
	}

	private static void writeInternal(UIEdit edit, Document doc, Element e, UITreeNode ui) throws Exception
	{
		writeFields(edit, e, ui.display);
		if (ui instanceof SavedComponent) {
			((SavedComponent)ui.display).onWrite(edit, e);
		}
		
		UILayout layout = ui.display.getCustomLayout();
		if (layout != null) {
			Element rect = doc.createElement("layout");
			writeLayout(edit, layout, rect);
			e.appendChild(rect);
		}
		if (ui.getChildCount() > 0)
		{
			Element childs = doc.createElement("childs");
			for (int i=0; i<ui.getChildCount(); i++) {
				UITreeNode cn = (UITreeNode)ui.getChildAt(i);
				Element child = doc.createElement(
						cn.display.getClass().getCanonicalName());
				writeInternal(edit, doc, child, cn);
				childs.appendChild(child);
			}
			e.appendChild(childs);
			
		}
		
	}

	private static void readFields(UIEdit edit, Element e, UIComponent ui) 
	{
		ui.name 				= e.getAttribute("name");
		ui.clip_local_bounds 	= Boolean.parseBoolean(e.getAttribute("clipbounds"));
		ui.local_bounds.width	= Integer.parseInt(e.getAttribute("width"));
		ui.local_bounds.height	= Integer.parseInt(e.getAttribute("height"));

		Field[] fields = ui.getClass().getFields();
		for (Field f : fields) {
			try {
				if (f.getName().equals("clip_local_bounds")) {
					continue;
				}
				if (f.getName().equals("custom_layout")) {
					continue;
				}
				if (f.getAnnotation(Property.class) != null) {
					Object attr = Parser.stringToObject(
							e.getAttribute(f.getName()),
							f.getType());
					if (attr != null) {
						f.set(ui, attr);
					}
				}
			} catch (Exception err) {
				err.printStackTrace();
			}
		}
	}
	
	private static void writeFields(UIEdit edit, Element e, UIComponent ui) 
	{
		e.setAttribute("name", ui.name);
		e.setAttribute("clipbounds", ui.clip_local_bounds+"");
		e.setAttribute("width", ui.getWidth()+"");
		e.setAttribute("height", ui.getHeight()+"");
		
		Field[] fields = ui.getClass().getFields();
		for (Field f : fields) {
			try {
				if (f.getName().equals("clip_local_bounds")) {
					continue;
				}
				if (f.getName().equals("custom_layout")) {
					continue;
				}
				if (f.getAnnotation(Property.class) != null) {
					Object attr = f.get(ui);
					String satr = Parser.objectToString(attr);
					e.setAttribute(f.getName(), satr);
				}
			} catch (Exception err) {
				err.printStackTrace();
			}
		}
	}

	public static UILayout readLayout(UIEdit edit, Element rect)
	{
		UILayout layout;
		ImageStyle style = Enum.valueOf(
				ImageStyle.class,
				rect.getAttribute("style"));
		if (rect.hasAttribute("img")) {
			layout = edit.getLayoutManager().createLayout(
					rect.getAttribute("img"), 
					style,
					Integer.parseInt(rect.getAttribute("clip")));
		} else {
			layout = new UILayout(style);
		}
		layout.setBackColor(new Color(rect.getAttribute("bgc")));
		layout.setBorderColor(new Color(rect.getAttribute("bdc")));
		return layout;
	}

	public static void writeLayout(UIEdit edit, UILayout layout, Element rect) {
		rect.setAttribute("style", layout.getStyle().toString());
		rect.setAttribute("bgc", layout.getBackColor().toHexString());
		rect.setAttribute("bdc", layout.getBorderColor().toHexString());
		if (layout instanceof ImageUILayout) {
			ImageUILayout imgrect = (ImageUILayout) layout;
			rect.setAttribute("img", imgrect.srcImageName().getName() + "");
			rect.setAttribute("clip", imgrect.clip_border + "");
			edit.getLayoutManager().putLayout(imgrect);
		}
	}
}

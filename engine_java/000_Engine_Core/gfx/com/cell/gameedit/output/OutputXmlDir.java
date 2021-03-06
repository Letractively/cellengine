package com.cell.gameedit.output;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicReference;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import com.cell.CIO;
import com.cell.CObject;
import com.cell.CUtil;
import com.cell.gameedit.OutputLoader;
import com.cell.gameedit.object.ImagesSet;
import com.cell.gameedit.object.MapSet;
import com.cell.gameedit.object.SpriteSet;
import com.cell.gameedit.object.TableSet;
import com.cell.gameedit.object.WorldSet;
import com.cell.gameedit.object.WorldSet.RegionObject;
import com.cell.gameedit.object.WorldSet.WaypointObject;
import com.cell.gfx.IImage;
import com.cell.gfx.IImages;
import com.cell.gfx.game.CAnimates;
import com.cell.gfx.game.CCD;
import com.cell.gfx.game.CCollides;
import com.cell.gfx.game.CMap;
import com.cell.gfx.game.CSprite;
import com.cell.gfx.game.CWayPoint;
import com.cell.io.TextDeserialize;
import com.cell.j2se.CAppBridge;
import com.cell.util.PropertyGroup;


/**
 * 如何将编辑器资源解析成单位
 * @author WAZA
 */
public class OutputXmlDir extends OutputXml
{
	final public String root;
	final public String file_name;
	final public String path;
	
	public OutputXmlDir(String file) throws Exception {
		this.path 		= file.replace('\\', '/');
		this.root		= path.substring(0, path.lastIndexOf("/")+1);
		this.file_name	= path.substring(root.length());
		init(CIO.getInputStream(file));
	}
	
	@Override
	public String getResRoot() {
		return root;
	}
	
	@Override
	public String getPath() {
		return path;
	}
	
	public byte[] loadRes(String path, AtomicReference<Float> percent)
	{
		byte[] data = CIO.loadData(root + path);
		if (data == null) {
			System.err.println("SetResource : read error : " + root + path);
		} 
		return data;
	}

	
	public static void main(String argv[]) {
		try {
			CAppBridge.init();
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
			InputStream is = CIO.getInputStream(
					"/com/cell/gameedit/output/ccc.xml");
			Document doc = docBuilder.parse(is);
			new OutputXml() {
				@Override
				public byte[] loadRes(String name, AtomicReference<Float> percent) {
					return null;
				}
				@Override
				public String getResRoot() {
					return null;
				}
				@Override
				public String getPath() {
					return null;
				}
			}.init(doc);
		} catch (SAXParseException err) {
			System.out.println("** Parsing error" + ", line "
					+ err.getLineNumber() + ", uri " + err.getSystemId());
			System.out.println(" " + err.getMessage());
		} catch (SAXException e) {
			Exception x = e.getException();
			((x == null) ? e : x).printStackTrace();
		} catch (Throwable t) {
			t.printStackTrace();
		}
		// System.exit (0);
	}// end of main

}




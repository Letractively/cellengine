package com.morefuntek.cell.GUI;

import java.util.Vector;

import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

import com.morefuntek.cell.CObject;


public class CTextBox extends CObject {
	
	//text
	static public Font TextFont = Font.getFont(
			Font.FACE_MONOSPACE, 
			Font.STYLE_PLAIN, 
			Font.SIZE_SMALL
			);
	static protected Vector Texts = new Vector();
	static public int TextColor = 0xff000000;
	
	static protected int TextX ;
	static protected int TextY ;
	static protected int TextW ;
	static protected int TextH ;
	
	//icon
	static protected Image Icon ;
	static public Image IconPush ;
	
	//boy
	static protected int X ;
	static protected int Y ;
	static protected int W ;
	static protected int H ;
	
	static public int BorderColor = 0xff808080;
	static public int BodyColor = 0x80ffffff;
	static public int BorderSize = 6;
	static public int[] BodyAlphaColor ;
	//score
	
	static public boolean HaveScroolBar = true;
	static public int ScrollBodyColor = 0xffc0c0c0;
	static public int ScrollBarColor = 0xffe0e0e0;
	
	static protected int VScrollSize = 8;
	
	static protected int VLineCount ;
	static protected int VScrollMax;
	static protected int VScrollMin;
	static protected int VScrollValue;
	
	
	static protected boolean TransitionOpen ;
	static protected boolean TransitionClose ;
	static protected int TransitionTime = 0 ;
	static public int TransitionSpeed = 4;
	
	
	static public void setTextBox(
			String msg,
			Image icon,
			int x,int y,int w,int h
			){

		Texts.removeAllElements();
		
		Icon = icon;
		
		X = x;
		Y = y;
		W = w;
		H = h;
		
		TextX = X + BorderSize;
		TextY = Y + BorderSize;
		TextW = W - BorderSize - BorderSize - VScrollSize;
		TextH = H - BorderSize - BorderSize ;

		if(Icon!=null){
			TextX += (Icon.getWidth() + BorderSize);
			TextW -= (Icon.getWidth() + BorderSize);
		}
		
		VScrollMax = 0;
		VScrollMin = 0;
		VScrollValue = 0;
		VLineCount = 0;
		
		StringBuffer sub = new StringBuffer();
		for(int i=0;i<msg.length();i++){
			if(msg.substring(i,i+1).equals("\n")){
				Texts.addElement(sub.toString());
				sub = new StringBuffer();
				continue;
			}
//			if(msg.substring(i,i+1).equals("\r")){
//				Texts.addElement(sub.toString());
//				sub = new StringBuffer();
//				continue;
//			}
			if (TextFont.stringWidth(sub.toString()+msg.substring(i,i+1)) >= TextW){
				Texts.addElement(sub.toString());
				sub = new StringBuffer();
				i--;
				continue;
			}
			sub.append(msg.substring(i,i+1));
			
		}
		Texts.addElement(sub.toString());
		
		VScrollMax = Math.max(TextFont.getHeight()*Texts.size()-TextH,0);
		VLineCount = TextH/TextFont.getHeight() + 2;
	
		
		
		if(BodyAlphaColor==null || BodyAlphaColor.length!=W){
			BodyAlphaColor = new int[W];
			for(int i=0;i<W;i++){
				BodyAlphaColor[i] = (BodyColor&0x00ffffff)|0x80000000;
			}
		}
		
		
		TransitionSpeed = H / 4 ;
		TransitionOpen = true;
		TransitionTime = 0;
	}
	
	static public void closeTextBox(){
		Texts.removeAllElements();
		Icon = null;
		IconPush = null;
		TransitionSpeed = H / 4 ;
		TransitionClose = true;
		TransitionTime = 0;
	}
	
	static public boolean vScroll(int d){
		VScrollValue += d;
		if(VScrollValue>VScrollMax ){
			VScrollValue = VScrollMax;
			return true;
		}
		if(VScrollValue<VScrollMin ){
			VScrollValue = VScrollMin;
			return true;
		}
		return false;
	}
	
	
	static public void showTextBox(Graphics g){


		if(TransitionOpen){
			TransitionTime+=TransitionSpeed;
			if(TransitionTime>=H){
				TransitionTime = H ;
				TransitionOpen = false;
			}
			
			g.setColor(BodyColor);
			g.drawRGB(
					BodyAlphaColor, 
					0, 
					0, 
					X, 
					Y+H/2-TransitionTime/2, 
					W, 
					TransitionTime,
					true);
			g.setColor(BorderColor);
			g.drawRect(
					X, 
					Y+H/2-TransitionTime/2 -1, 
					W, 
					TransitionTime -1);
			
			
			return;
		}
		if(TransitionClose){
			TransitionTime+=TransitionSpeed;
			if(TransitionTime>=H){
				TransitionTime = H ;
				TransitionClose = false;
			}
			g.setColor(BodyColor);
			g.drawRGB(
					BodyAlphaColor, 
					0, 
					0, 
					X, 
					Y+H/2- (H-TransitionTime)/2, 
					W, 
					(H-TransitionTime),
					true);
			g.setColor(BorderColor);
			g.drawRect(
					X, 
					Y+H/2-(H-TransitionTime)/2 -1, 
					W, 
					(H-TransitionTime) -1);
			return;
		}
		
		
		
		if(!Texts.isEmpty()){

			// body
//			g.setColor(BodyColor);
//			g.fillRect(X, Y, W, H);
			g.drawRGB(
					BodyAlphaColor, 
					0, 
					0, 
					X, Y, W, H,
					true);
			g.setColor(BorderColor);
			g.drawRect(X, Y, W-1, H-1);
			
			// icon
			if(Icon!=null){
				g.drawImage(Icon, X+BorderSize, Y+BorderSize, 0);
			}
			// text
			g.setFont(TextFont);
			g.setColor(TextColor);
	
			int line = VScrollValue / TextFont.getHeight();
			
			
			int cx = g.getClipX();
			int cy = g.getClipY();
			int cw = g.getClipWidth();
			int ch = g.getClipHeight();
			g.setClip(TextX,TextY,TextW,TextH);
			for(int i=0; i<VLineCount && line+i<Texts.size(); i++){
				g.drawString(
						(String)Texts.elementAt(line + i), 
						TextX, 
						TextY+i*TextFont.getHeight()-VScrollValue%TextFont.getHeight(),
						0);
			}
			g.setClip(cx,cy,cw,ch);
			// scroll
			if(HaveScroolBar && VScrollMax!=VScrollMin){
				int scrollsize = TextH * TextH * (1000) / (VScrollMax+TextH) / (1000);
				int scrollpos  = TextH * VScrollValue * (1000) / (VScrollMax+TextH) / (1000);
				
				g.setColor(ScrollBodyColor);
				g.fillRect(
						X+W-BorderSize-VScrollSize, 
						Y+BorderSize, 
						VScrollSize, 
						TextH);
				g.setColor(ScrollBarColor);
				g.fillRect(
						X+W-BorderSize-VScrollSize, 
						Y+BorderSize + scrollpos, 
						VScrollSize, 
						scrollsize);
			}
		}
		
	}
	
	
	static public boolean isShown(){
		return TransitionOpen || TransitionClose|| !Texts.isEmpty();
	}
	
	
	
	
	
	
	
	
	
	
	
}

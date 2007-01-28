package com.cell.game;

import java.util.Vector;

import javax.microedition.lcdui.Graphics;

import com.cell.CObject;

/**
 * ·��
 * @author yifeizhang
 * @since 2006-12-19 
 * @version 1.0
 */
public class CWayPoint extends CObject {

	public int X = 0;
	public int Y = 0;
	
	protected Vector Link = new Vector();
	
	
	public CWayPoint(int x,int y){
		X = x;
		Y = y;
	}
	
	public int getNextCount(){
		return Link.size();
	}
	
	/**
	 * ���������õ����ӵ�·��
	 * @param linkIndex
	 * @return 
	 */
	public CWayPoint getNextPoint(int linkIndex){
		try{
			return (CWayPoint)Link.elementAt(linkIndex);
		}catch(Exception err){
			err.printStackTrace();
		}
		return null;
	}
	
	/**
	 * �������ӵ���һ��·��
	 * @param point
	 * @return 
	 */
	public void linkTo(CWayPoint point){
		if(point==null)return ;
		
		if(!this.Link.contains(point)){
			this.Link.addElement(point);
		}

	}
	/**
	 * ����һ��·�㵥�����ӵ���ǰ��
	 * @param point
	 * @return 
	 */
	public void linkForm(CWayPoint point){
		if(point==null)return ;

		if(!point.Link.contains(this)){
			point.Link.addElement(this);
		}

	}
	
	/**
	 * ����2��·��
	 * @param point
	 * @return 
	 */
	public void link(CWayPoint point){
		if(point==null)return;
		
		if(!this.Link.contains(point)){
			this.Link.addElement(point);
		}

		
	}
	
	/**
	 * �⿪2��·��
	 * @param point
	 * @return 
	 */
	public void unlink(CWayPoint point){
		if(point==null)return ;
		
		if( this.Link.contains(point)){
			this.Link.removeElement(point);
		}
		if( point.Link.contains(this)){
			point.Link.removeElement(this);
		}
		
	}
	
	/**
	 * �⿪����·��
	 * @return 
	 */
	public void unlinkAll(){
		
		if(Link.size()==0)return ;

        for (int i=0;i<Link.size();i++){
        	try{
        		CWayPoint p = (CWayPoint)Link.elementAt(i);
        		p.unlink(this);
        	}catch(Exception err){}
        }

        this.Link.removeAllElements();
        
	}

	/**
	 * ����·��
	 * @param g
	 * @param offsetX
	 * @param offsetY 
	 */
	public void render(Graphics g,int offsetX,int offsetY){
//#ifdef _DEBUG
		g.setColor(0xff808080);
		
		for (int i=0;i<Link.size();i++){
			try{
				CWayPoint p = (CWayPoint)Link.elementAt(i);
				g.drawLine(X+offsetX, Y+offsetY, p.X+offsetX, p.Y+offsetY);
			}catch(Exception err){}
		}

		g.fillRect(X-2+offsetX, Y-2+offsetY, 4, 4);
//#endif
	}

}

package com.morefuntek.cell.math;

/**
 * œÚ¡ø
 * @author yifeizhang
 * @since 2006-12-18 
 * @version 1.0
 * @param <T>
 */
public class CVector2 {
	int X;
	int Y;
	
	public CVector2(int x,int y){
		X = x;
		Y = y;
	}
	public CVector2(CVector2 v){
		X = v.X;
		Y = v.Y;
	}
	
	public void add(CVector2 v){
		X += v.X ;
		Y += v.Y ;
	}
	
	public void sub(CVector2 v){
		X -= v.X ;
		Y -= v.Y ;
	}
	
	public int dotProduct(CVector2 v){
		return (X*v.X + Y*v.Y);
	}
	
	public int crossProduct(CVector2 v){
		return (X*v.Y - v.X*Y); 
	}
	
	
}

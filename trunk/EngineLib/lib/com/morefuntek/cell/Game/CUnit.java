/*
 * 张翼飞
 * Created on 2005-7-29
 *
 */
package com.morefuntek.cell.Game;

import java.util.Vector;

import com.morefuntek.cell.CObject;


/**
 * 基本游戏单元，每个单元包含独立的状态机。
 * @author yifeizhang
 * @since 2006-11-30 
 * @version 1.0
 */
public class CUnit extends CObject
{
	/** Unique ID */
	public int ID = this.hashCode();// unique id
	
	/**精灵属于哪个世界*/
	public CWorld world = null;

//	---------------------------------------------------------------------------------------------

	protected Vector onState = null;

	/**
	 * 添加一个状态
	 * @param state 
	 */
	public void addState(IState state){
		if(onState==null)onState = new Vector();
		onState.addElement(state);
	}
	
	/**
	 * 删除一个状态
	 * @param state 
	 */
	public void delState(IState state){
		if(onState==null)return;
		onState.removeElement(state);
	}

	/**
	 * 更新所有状态 
	 */
	public void updateStates(){
		if(onState==null)return;
		for(int i=0;i<onState.size();i++){
			((IState)onState.elementAt(i)).update();
		}
	}
	
	
//	---------------------------------------------------------------------------------------------
	
	
	
	
	
}


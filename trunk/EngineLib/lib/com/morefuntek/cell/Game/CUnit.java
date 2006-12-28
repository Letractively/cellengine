/*
 * �����
 * Created on 2005-7-29
 *
 */
package com.morefuntek.cell.Game;

import java.util.Vector;

import com.morefuntek.cell.CObject;


/**
 * ������Ϸ��Ԫ��ÿ����Ԫ����������״̬����
 * @author yifeizhang
 * @since 2006-11-30 
 * @version 1.0
 */
public class CUnit extends CObject
{
	/** Unique ID */
	public int ID = this.hashCode();// unique id
	
	/**���������ĸ�����*/
	public CWorld world = null;

//	---------------------------------------------------------------------------------------------

	protected IState onState = null;

	/**
	 * ����״̬
	 * @param state 
	 */
	public void setState(IState state){
		onState = state;
	}
	
	public IState getState(){
		return onState;
	}
	
	/**
	 * ��������״̬ 
	 */
	public void updateStates(){
		if(onState==null)return;
		onState.update();
	}
	
	
//	---------------------------------------------------------------------------------------------
	
	
	
	
	
}


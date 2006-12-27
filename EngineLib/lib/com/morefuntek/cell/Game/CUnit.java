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

	protected Vector onState = new Vector(1);

	/**
	 * ���һ��״̬
	 * @param state 
	 */
	public void addState(IState state){
		onState.addElement(state);
	}
	
	/**
	 * ɾ��һ��״̬
	 * @param state 
	 */
	public void delState(IState state){
		onState.removeElement(state);
	}

	/**
	 * ��������״̬ 
	 */
	public void updateStates(){
		for(int i=0;i<onState.size();i++){
			((IState)onState.elementAt(i)).update();
		}
	}

	//protected Vector onMessage = new Vector(1);
	
	
	
//	---------------------------------------------------------------------------------------------
	
	
	
	
	
}


/*
 * �����
 * Created on 2005-7-29
 *
 */
package com.cell.game;

import com.cell.CObject;


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

	/** �Ƿ���ʾ */
	public boolean Visible 			= true;
	
	/** �Ƿ� */
	public boolean Active 			= true; 
	
	/**ɫ��*/
	public int BackColor = 0xff00ff00;
	
//	---------------------------------------------------------------------------------------------


	
	
//	---------------------------------------------------------------------------------------------
	
	
	
	
	
}


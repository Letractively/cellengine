/*
 * �����
 * Created on 2005-8-4
 *
 */
package com.morefuntek.cell.Game;

import com.morefuntek.cell.CObject;


/**
 * �ڲ��߼���Ϣ��
 * @author yifeizhang
 * @since 2006-11-30 
 * @version 1.0
 */
public class CMessage extends CObject{
	/** ��Ϣ���� */
	public String name;
	/** ������ID */
	public CUnit sender;
	/** ������ID */
	public CUnit receiver;
	/** ��ʱʱ�� */
	public int deliveryTime;
	/** ��Ϣ�ķ�Χ */
	public int state;

}


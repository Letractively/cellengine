/*
 * �����
 * Created on 2005-8-4
 *
 */
package Cell.Game;

import Cell.CObject;

/**
 * @author �����
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public class CMsg extends CObject{
	
	/** ��Ϣ���� */
	public int name;
	/** ������ID */
	public CUnit sender;
	/** ������ID */
	public CUnit receiver;
	/** ��ʱʱ�� */
	public int deliveryTime;
	/** ��Ϣ�ķ�Χ */
	public int state;

}


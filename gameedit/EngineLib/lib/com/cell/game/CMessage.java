/**
 * ��Ȩ����[2006][�����]
 *
 * ����2.0�汾Apache���֤("���֤")��Ȩ��
 * ���ݱ����֤���û����Բ�ʹ�ô��ļ���
 * �û��ɴ�������ַ������֤������
 * http://www.apache.org/licenses/LICENSE-2.0
 * ���������÷�����Ҫ������ͬ�⣬
 * �������֤�ַ�������ǻ���"��ԭ��"�����ṩ��
 * ���κ���ʾ�Ļ�ʾ�ı�֤��������
 * ����������֤����£��ض����ԵĹ�ϽȨ�޺����ơ�
 */
/*
 * �����
 * Created on 2005-8-4
 *
 */
package com.cell.game;

import com.cell.CObject;


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


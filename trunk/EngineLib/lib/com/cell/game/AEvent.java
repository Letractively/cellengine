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
package com.cell.game;

public abstract class AEvent {

	abstract public void start();
	
	abstract public void onEvent();
	
	abstract public boolean isEnd();
}

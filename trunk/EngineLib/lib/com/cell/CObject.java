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
package com.cell;

import java.util.Random;


/**
 * base class object, all other class entends this </br>
 * �����࣬��������������Ӹ���̳�
 * @author WAZA
 * @since 2006-11-28
 * @version 1.0
 */
public class CObject {

	// ------------------------------------------------------
	/**DEBUG dip ����*/
	static public boolean IsDebug = false;
	
	// ------------------------------------------------------

	/**���������*/
	static public Random Random = new Random();
	
	//-------------------------------------------------------------------------------------------------------------------------
	static private int Timer = 1;
	
	/**
	 * tick frame timer
	 * ���ӵ�ǰ֡������
	 */
	static public void tickTimer() {
		Timer++;
	}
	/**
	 * reset frame timer
	 * ֡��������0
	 */
	static public void resetTimer() {
		Timer = 1;
	}
	/**
	 * get current frame timer
	 * �õ���ǰ֡������ֵ 
	 * @return 
	 */
	static public int getTimer() {
		return Timer;
	}
	
//	 ------------------------------------------------------

	/**
	 * debug console print, System.out.print();</br>
	 * ��ͬ��System.print
	 * @param str 
	 */
	static public void print(String str) {
//#ifdef _DEBUG
			System.out.print(str);
//#endif
	}

	/**
	 * debug console println, System.out.println();</br>
	 * ��ͬ��System.out.println
	 * @param str 
	 */
	static public void println(String str) {
//#ifdef _DEBUG
			System.out.println(str);
//#endif
	}

}

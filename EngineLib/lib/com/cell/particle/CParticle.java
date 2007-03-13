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
package com.cell.particle;


/**
 * Single Particle Node.
 * @author yifeizhang
 * @since 2006-12-5 
 * @version 1.0
 */
public class CParticle {

	// time
	public int Category = 0;
	
	/**Terminate time*/
	public int TerminateTime = -1;
	/**timer*/
	public int Timer = 0;
	
	// physical
	public int X = 0;
	public int Y = 0;
	public int SpeedX = 0;
	public int SpeedY = 0;
	public int AccX = 0;
	public int AccY = 0;
	
	// surface
	public int Color = 0;
	
	public int Data = 0;
	
	
	public boolean isTerminate(){
		return Timer > TerminateTime;
	}
	
}

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

import javax.microedition.lcdui.Graphics;

/**
 * Particle Launcher.</br>
 * do something what particle movement. 
 * @author yifeizhang
 * @since 2006-12-5 
 * @version 1.0
 */
public interface IParticleLauncher {
	/**
	 * Initial Emitted Particle.
	 * @param particle
	 * @param id 
	 */
	public void particleEmitted(CParticle particle, int id);

	/**
	 * when the Particle Terminated.
	 * @param particle
	 * @param id 
	 */
	public void particleTerminated(CParticle particle, int id);

	/**
	 * Affected the Particle. 
	 * @param particle
	 * @param id 
	 */
	public void particleAffected(CParticle particle, int id);

	/**
	 * Render the Particle.
	 * @param g
	 * @param particle
	 * @param id 
	 * @param x 
	 * @param y 
	 */
	public void particleRender(Graphics g, CParticle particle, int id);

}

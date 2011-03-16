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
 * WAZA
 * Created on 2006-7-8
 *
 */
package com.cell.musicgame;

/**
 * @author WAZA
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * <summary> MGPlayer�����ߡ�
 */
public interface MGPlayerListener{
    /**
     * <summary> (call back)ÿ�ķ�֮һ�ĵ���һ�Ρ�
     * @param �������ӵ�ǰ�ܹ����ж��ٴ�beat��
     */
    public void beatBPM(int beatCount);
    
    /**
     * <summary> (call back)������ʧ��ʱ����á�
     * @param ��һ����Ϸ�����
     */
    public void lostNote(int line);
    
    /**
     * <summary> (call back)ָ������İ�ť���¡�
     * @param line ��Ϸ����ţ�С��LineCount��
     * @param acc  ���% , 100% = perfect
     */
    public void hitNote(int line,int acc);
    
    /**
     * <summary> (call back)��ʾ����λ�á�
     * @param 	
     * pos[��Ϸ�����][ͬʱ��ʾ������]������Ŀ���ľ��룬��λ���ء�
     * ��������δ����
     * �������Ѿ�������
     * �㣺�����պô���ԭ�㡣
     * ����ڰ���ָ����ť��ʱ�򣬸�ֵ�ľ���ֵС�ڻ����MGPlayer.BeatScope����ô�������ͱ�HIT��
     * �����ֵ����MGPlayer.LostScope����ô�������ͱ���ʧ��
     */
    public void showNote(int[][] pos);
}

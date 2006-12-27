package com.morefuntek.cell;

/**
 * util math function none float
 * 常用数学方法
 * @author yifeizhang
 * @since 2006-12-1 
 * @version 1.0
 */
public class CMath extends CObject{
	/**
	 * 求平方根
	 * 
	 * @param i 定义域
	 * @return 值域
	 */
	final public static int sqrt(int i) {
		int l = 0;
		for (int k = 0x100000; k != 0; k >>= 2) {
			int j = l + k;
			l >>= 1;
			if (j <= i) {
				i -= j;
				l += k;
			}
		}
		return l;
	}
	
	/** 圆周率的256倍定点数。 */
	final static public int PI256 = 804;


	/**
	 * sine*256 angle table 0~90
	 */
	private static final short[] SINES = { 0, 4, 9, 13, 18, 22, 27, 31, 36, 40,
			44, 49, 53, 58, 62, 66, 71, 75, 79, 83, 88, 92, 96, 100, 104, 108,
			112, 116, 120, 124, 129, 132, 136, 139, 143, 147, 150, 154, 158,
			161, 165, 168, 171, 175, 178, 181, 184, 187, 190, 193, 196, 199,
			202, 204, 207, 210, 212, 215, 217, 219, 222, 224, 226, 228, 230,
			232, 234, 236, 237, 239, 241, 242, 243, 245, 246, 247, 248, 249,
			250, 251, 252, 253, 254, 254, 255, 255, 255, 256, 256, 256, 256, };

	/**
	 * 正旋
	 * 
	 * @param angle 范围0~360
	 * @return 256倍数
	 */
	final public static int sinTimes256(int angle) {
		int d = angle < 0 ? -1 : 1;
		angle = Math.abs(angle % 360); // 360 degrees
		if (angle <= 90) {
			return SINES[angle] * d;
		} else if (angle <= 180) {
			return SINES[180 - angle] * d;
		} else if (angle <= 270) {
			return -SINES[angle - 180] * d;
		} else {
			return -SINES[360 - angle] * d;
		}
	}

	/**
	 * 余旋
	 * 
	 * @param angle 范围0~360
	 * @return 256倍数
	 */
	final public static int cosTimes256(int angle) {
		return sinTimes256(angle + 90); // i.e. add 90 degrees
	}

	/**
	 * 正切
	 * 
	 * @param angle 范围0~360
	 * @return 256倍数
	 */
	final public static int tangentTimes256(int angle) {
		return sinTimes256(angle) * 256 / cosTimes256(angle);
	}

	/**
	 * 余切
	 * 
	 * @param angle 范围0~360
	 * @return 256倍数
	 */
	final public static int cotangentTimes256(int angle) {
		return cosTimes256(angle) * 256 / sinTimes256(angle);
	}
	
// 	--------------------------------------------------------------------------------------------------------
	
	/**
	 * comput cyc number: (value+d) within 0~max scope
	 * @param value
	 * @param d
	 * @param max
	 * @return 
	 */
	static public int cycNum(int value, int d, int max) {
		value += d;
		if (value >= 0) {
			return value % max;
		} else {
			return (max + value % max) % max;
		}
	}
	
	
//	-------------------------------------------------------------------------------------------------------------------

	/**
	 * 矢量相加
	 * 
	 * @param px
	 * @param py
	 * @param qx
	 * @param qy
	 * @return v[]
	 */
	final public static void vectorAdd(int[] out, int px, int py, int qx, int qy) {
		out[0] = px + qx;
		out[1] = py + qy;
		
	}
	
	/**
	 * 矢量相减
	 * 
	 * @param px
	 * @param py
	 * @param qx
	 * @param qy
	 * @return v[]
	 */
	final public static void vectorSub(int[] out, int px, int py, int qx, int qy) {
		out[0] = px - qx;
		out[1] = py - qy;
	}

	/**
	 * 矢量相乘 在三角坐标系中: 若 P × Q > 0 , 则P在Q的顺时针方向。 若 P × Q < 0 , 则P在Q的逆时针方向。 若 P × Q =
	 * 0 , 则P与Q共线，但可能同向也可能反向。 在屏幕坐标系中: 若 P × Q > 0 , 则P在Q的逆时针方向。 若 P × Q < 0 ,
	 * 则P在Q的顺时针方向。 若 P × Q = 0 , 则P与Q共线，但可能同向也可能反向。
	 * 
	 * @param p
	 * @param q
	 * @return +-
	 */
	final public static int vectorCrossProduct(int[] p, int[] q) {
		return (p[0] * q[1] - p[1] * q[0]);
	}



}
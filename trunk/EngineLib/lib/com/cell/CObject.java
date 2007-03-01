package com.cell;

import java.util.Random;


/**
 * base class object, all other class entends this </br>
 * 基础类，库中所有其他类从该类继承
 * @author WAZA
 * @since 2006-11-28
 * @version 1.0
 */
public class CObject {

	// ------------------------------------------------------
	/**DEBUG dip 开关*/
	static public boolean IsDebug = false;
	
	// ------------------------------------------------------

	/**公共随机数*/
	static public Random Random = new Random();
	
	//-------------------------------------------------------------------------------------------------------------------------
	static private int Timer = 1;
	
	/**
	 * tick frame timer
	 * 增加当前帧计数器
	 */
	static public void tickTimer() {
		Timer++;
	}
	/**
	 * reset frame timer
	 * 帧计数器清0
	 */
	static public void resetTimer() {
		Timer = 1;
	}
	/**
	 * get current frame timer
	 * 得到当前帧计数器值 
	 * @return 
	 */
	static public int getTimer() {
		return Timer;
	}
	
//	 ------------------------------------------------------

	/**
	 * debug console print, System.out.print();</br>
	 * 等同于System.print
	 * @param str 
	 */
	static public void print(String str) {
//#ifdef _DEBUG
			System.out.print(str);
//#endif
	}

	/**
	 * debug console println, System.out.println();</br>
	 * 等同于System.out.println
	 * @param str 
	 */
	static public void println(String str) {
//#ifdef _DEBUG
			System.out.println(str);
//#endif
	}

}

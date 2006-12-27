package com.morefuntek.cell.Game;

/**
 * 单位状态接口，可以理解为单位的AI。
 * @author yifeizhang
 * @since 2006-11-30 
 * @version 1.0
 */
public interface IState {
	/**
	 * 游戏单位的回调函数。 
	 */
	public void update();
}

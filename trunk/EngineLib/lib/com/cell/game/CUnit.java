/*
 * 张翼飞
 * Created on 2005-7-29
 *
 */
package com.cell.game;

import com.cell.CObject;


/**
 * 基本游戏单元，每个单元包含独立的状态机。
 * @author yifeizhang
 * @since 2006-11-30 
 * @version 1.0
 */
public class CUnit extends CObject
{
	/** Unique ID */
	public int ID = this.hashCode();// unique id
	
	/**精灵属于哪个世界*/
	public CWorld world = null;

	/** 是否显示 */
	public boolean Visible 			= true;
	
	/** 是否活动 */
	public boolean Active 			= true; 
	
	/**色块*/
	public int BackColor = 0xff00ff00;
	
//	---------------------------------------------------------------------------------------------


	
	
//	---------------------------------------------------------------------------------------------
	
	
	
	
	
}


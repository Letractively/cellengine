/*
 * 张翼飞
 * Created on 2005-8-4
 *
 */
package com.morefuntek.cell.Game;

import com.morefuntek.cell.CObject;


/**
 * 内部逻辑消息包
 * @author yifeizhang
 * @since 2006-11-30 
 * @version 1.0
 */
public class CMessage extends CObject{
	/** 消息名字 */
	public String name;
	/** 发送者ID */
	public CUnit sender;
	/** 接收者ID */
	public CUnit receiver;
	/** 延时时间 */
	public int deliveryTime;
	/** 消息的范围 */
	public int state;

}


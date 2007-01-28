package com.cell.game;

public abstract class AEvent {

	abstract public void start();
	
	abstract public void onEvent();
	
	abstract public boolean isEnd();
}

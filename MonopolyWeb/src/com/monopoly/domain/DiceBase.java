package com.monopoly.domain;

public abstract class DiceBase {
	
	protected int d1;
	protected int d2;
	
	public int getD1(){
		return d1;
	}
	
	public int getD2(){
		return d2;
	}
	
	public int getTotal(){
		return getD1() + getD2();
	}
	
	public abstract void roll();
	
}

package com.monopoly.domain;

public class LoadedDie implements Die{

	private int value = 0;
	public LoadedDie(int num){
		value = num;
	}
	@Override
	public int roll() {
		return value;
	}
	
	
}

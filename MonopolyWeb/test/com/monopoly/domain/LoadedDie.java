package com.monopoly.domain;

public class LoadedDie implements IDie {
    int value;
    
    public void fakedRoll(int value) {
    	this.value=value;
    }

    @Override
	public int getValue() {
		return value;
	}

}

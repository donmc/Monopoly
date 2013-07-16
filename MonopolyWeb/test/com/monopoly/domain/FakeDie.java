package com.monopoly.domain;

public class FakeDie extends Die {

	static int MIN = 1;
	static int MAX = 6;
	private int value = 1;
	
	public FakeDie(int value) {
		super();
		this.value = value;
	}

	public int roll() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
}

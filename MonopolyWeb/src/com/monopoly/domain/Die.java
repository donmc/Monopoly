package com.monopoly.domain;

public class Die {

	static int MIN = 1;
	static int MAX = 6;
	
	public int roll() {
		return MIN + (int)(Math.random() * ((MAX - MIN) + 1 ) );
	}
}

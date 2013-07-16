package com.monopoly.domain;

import java.util.Random;

public class Die implements IDie {

	private Random random;

	public Die() {
		this.random = new Random(); 
	}
	
	public int getValue() {
		return random.nextInt(6) + 1; 
	}

}

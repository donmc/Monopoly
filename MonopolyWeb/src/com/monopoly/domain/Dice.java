package com.monopoly.domain;

import java.util.Random;

public class Dice {

	public static int roll() {
		Random r = new Random();
		int randomIndex = r.nextInt( 6 ) + 1;
		return randomIndex + (r.nextInt(6) + 1);
		
	}

}

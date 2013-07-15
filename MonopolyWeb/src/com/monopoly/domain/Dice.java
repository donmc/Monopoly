package com.monopoly.domain;

import java.util.Random;

public class Dice extends DiceBase {

	private Random random = new Random();

	@Override
	public void roll() {
		d1 = random.nextInt(6) + 1;
		d2 = random.nextInt(6) + 1;
	}
	
}

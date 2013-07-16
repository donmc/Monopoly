package com.monopoly.domain;

import java.util.Random;

public class Die {
	private static Random randomGenerator;

	public Die()
	{
		randomGenerator = new Random();		
	}
	
	public int rollDice()
	{
		return (int) (randomGenerator.nextInt(6) + 1);
	}
}

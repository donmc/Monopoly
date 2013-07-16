package com.monopoly.domain;

public class MockDie extends Die {

	public int diceRollValue;
	
	@Override
	public int rollDice() {
		return this.diceRollValue;
	}
	
	
}

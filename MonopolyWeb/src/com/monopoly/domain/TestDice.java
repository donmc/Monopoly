package com.monopoly.domain;

public class TestDice extends Dice {
	private int roll;
	public TestDice(int roll){
		this.roll = roll;
	}
	@Override
	public int roll() {
		return roll;
	}
	
	

}

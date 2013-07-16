package com.monopoly.domain;

public class MockPlayer extends Player {

	int turnsTaken = 0;
	public MockPlayer(String token, Square startSquare) {
		super(token, startSquare);
	}

	public void takeTurn(Die d1, Die d2) {
		turnsTaken++;
	}
	
	public int getTurnsTaken() {
		return turnsTaken;
	}
}

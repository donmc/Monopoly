package com.monopoly.domain;

import java.util.List;

public class Player {

	private String token;
	private Square location;
	private int money;
	private int lastRoll;
	private boolean rolledDoubles;
	
	public Player(String token, Square startSquare) {
		this.location = startSquare;
		this.token = token;
		this.money = 1500;
		lastRoll = 0;
		this.rolledDoubles=false;
	}
	
	public Square getLocation() {
		return location;
	}
	
	public String getToken() {
		return token;
	}
	
	public int getMoney() {
		return money;
	}

	public void takeTurn(Board b, Dice d1, Dice d2) {
		lastRoll = 0;
		rolledDoubles = false;
		takeTurn(b,d1,d2,1);
	}
	
	public void takeTurn(Board b, Dice d1, Dice d2, int times) {
		int firstRoll = d1.roll();
		int secondRoll = d2.roll();
		int roll = firstRoll + secondRoll;
		lastRoll = roll;
		
		
		List<Square> squares = b.getSquares();
		location = squares.get((location.getPosition() + roll) % 40);
		
		if (times<3 && firstRoll == secondRoll) {
			rolledDoubles = true;
			takeTurn(b,d1,d2, times++);
		}
		
	}

	public int getLastRoll() {
		
		return lastRoll;
	}

	public boolean getRolledDoubles() {
		return rolledDoubles;
	}
}

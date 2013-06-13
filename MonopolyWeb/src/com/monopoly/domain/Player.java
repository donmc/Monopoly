package com.monopoly.domain;

public class Player {

	private String token;
	private Square location;
	private int money;
	
	public Player(String token, Square startSquare) {
		this.location = startSquare;
		this.token = token;
		this.money = 1500;
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

	public void takeTurn(Die die1, Die die2) {
		int value = die1.roll() + die2.roll();
		for (int i = 0; i < value; i++) {
			location = location.getNextSquare();
		}
		
	}

}

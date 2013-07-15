package com.monopoly.domain;

public class Player {

	private String token;
	private Square location;
	private int money;
	
	public Player(String token, Square startSquare) {
		this.location = startSquare;
		this.token = token;
		money = 1500;
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

	public void takeTurn(Die d1, Die d2) {
		int i = d1.roll() + d2.roll();
		for (int j = 0; j < i; j++) {
			location = location.getNextSquare();
		}
	}
}

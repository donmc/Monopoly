package com.monopoly.domain;

import java.util.List;

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

	public void takeTurn(Board b) {
		int roll = Dice.roll();
		
		List<Square> squares = b.getSquares();
		location = squares.get((location.getPosition() + roll) % 40);
		
	}
}

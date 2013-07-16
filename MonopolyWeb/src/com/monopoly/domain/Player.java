package com.monopoly.domain;

public class Player {

	private String token;
	private Square location;
	private int money;
	private int lastRoll;
	
	public Player(String token, Square startSquare) {
		this.location = startSquare;
		this.token = token;
		this.money = 1500;
	}
	
	
	public void takeTurn(Board board) {
		//TODO move dice to game?
		lastRoll = board.roll();
		int position = board.getSquares().indexOf(location) + lastRoll;
		position = position % 40;
		location = board.getSquares().get(position);
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
	
	public int getLastRoll() {
		return lastRoll;
	}
	
	public void setLastRoll(int lastRoll) {
		this.lastRoll = lastRoll;
	}
}

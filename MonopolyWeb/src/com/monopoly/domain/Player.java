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
	
	public void setLocation(int move) {
		
		Board board = new Board();
		
		int place = board.getSquareIndex(location);
		
		int nplace = place + move;
		if (nplace >= 40)
			place = nplace - 40;
		else
			place = nplace;
		
		location = board.getSquareByIndex(place);
		
		
	}
	
	public String getToken() {
		return token;
	}
	
	public int getMoney() {
		return money;
	}

	public void takeTurn() {
		
		setLocation(5);
		
	}
}

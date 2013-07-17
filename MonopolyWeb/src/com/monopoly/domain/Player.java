package com.monopoly.domain;

public class Player {

	private String token;
	private Square location;
	private int money;
	public void setMoney(int money) {
		this.money = money;
	}

	private int lastRoll;
	
	public int getLastRoll() {
		return lastRoll;
	}

	public Player(String token, Square startSquare) {
		this.location = startSquare;
		this.token = token;
		this.money = 1500;
	}
	
	public Square getLocation() {
		
		return location;
	}
	
	public void setLocation(Square location) {
		this.location = location;
	}

	public void moveLocation(int move) {
		
		Board board = new Board();
		
		int place = board.getSquareIndex(location);
		
		int nplace = place + move;
		if (nplace >= 40) {
			place = nplace - 40;
			if (place != 0)
				board.getSquareByIndex(0).passesOver(this);
		}
		else
			place = nplace;
		
		location = board.getSquareByIndex(place);
		location.landOn(this);
	
		
	}
	
	
	public String getToken() {
		return token;
	}
	
	public int getMoney() {
		return money;
	}

	public void takeTurn(IDie die, IDie die2) {
		
		int roll = die.getValue() + die2.getValue();
		lastRoll = roll;
		moveLocation(die.getValue() + die2.getValue());
		
	}
	


	public void credit(int amount) {
		// TODO Auto-generated method stub
		money += amount;
		
	}

	public void debit(int amount) {
		money -= amount;
		// TODO Auto-generated method stub
		
	}
}

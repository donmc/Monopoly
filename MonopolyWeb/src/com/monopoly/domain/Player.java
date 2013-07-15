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
		
		int totalDice = this.rollBothDice(die1, die2);
		int currentPosition = Board.getPositionForSquare(this.location);
		int newLocationInt = (currentPosition + totalDice) % Board.getNumberOfSquares();
		this.location = Board.getSquareForPosition(newLocationInt);
	}
	
	protected int rollBothDice(Die die1, Die die2)
	{
		int diceValue1 = die1.rollDice();
		int diceValue2 = die2.rollDice();
		
		return diceValue1 + diceValue2;
	}
	
}

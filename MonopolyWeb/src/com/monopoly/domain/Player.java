package com.monopoly.domain;


public class Player {

	private String token;
	private Square location;
	private int money;
	private boolean isFirstRoll;
	private int lastRoll;
	
	
	public Player(String token, Square startSquare) {
		this.location = startSquare;
		this.token = token;
		this.money = 1500;
		this.lastRoll = 0;
		this.isFirstRoll = true;
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
	
	public void decrementMoney(int decrementMoney) {
		this.money = this.money - decrementMoney;
	}
	
	public int getLastRoll() {
		return this.lastRoll;
	}
	
	public boolean getIsFirstRoll() {
		return this.isFirstRoll;
	}

	public void takeTurn(Die die1, Die die2) {
		
		this.lastRoll  = this.rollBothDice(die1, die2);
		int currentPosition = Board.getPositionForSquare(this.location);
		int newLocationInt = (currentPosition + this.lastRoll) % Board.getNumberOfSquares();
		this.handleDidPassGo(currentPosition, newLocationInt);
		this.location = Board.getSquareForPosition(newLocationInt);
		this.location.landedOn(this);
	}
	protected void  handleDidPassGo(int oldPosition, int newPosition)
	{
		if (newPosition < oldPosition)
		{
			this.money = this.money + 200;
		}
	}

	protected int rollBothDice(Die die1, Die die2)
	{
		this.isFirstRoll = false;
		int diceValue1 = die1.rollDice();
		int diceValue2 = die2.rollDice();
		
		return diceValue1 + diceValue2;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
}

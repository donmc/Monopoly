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
	
	public int getLastRoll() {
		return lastRoll;
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
 
	public void takeTurn(Die die, Die die2) {
		 
		lastRoll = die.roll() + die2.roll();
		
		for (int i = 0; i < lastRoll-1; i++) {
			step();
			location.passOver(this);
		}
		step();
		location.landOn(this); 
		
	}

	private void step() {
		location = location.getNextSquare();
	}

	public void credit(int amount) {
		money += amount;
	}

	public void debit(int amount) {
		money -= amount;
	}

}

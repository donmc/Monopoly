package com.monopoly.domain;

public class Player {

	private String token;
	private Square location;

	private int money;
	private int lastRoll;
	
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
	public void setMoney(int money) {
		this.money = money;
	}

	public void takeTurn(Die d1, Die d2) {
		int i = d1.roll() + d2.roll();
		for (int j = 0; j < i; j++) {
			location = location.getNextSquare();
			location.passThrough( this );
		}
		lastRoll = i;
		location.landOn(this);
	}
	public int getLastRoll() {
		return lastRoll;
	}

	public void credit(int amount) {
		money += amount;
	}

	public void debit(int amount) {
		money -= amount;
	}
}

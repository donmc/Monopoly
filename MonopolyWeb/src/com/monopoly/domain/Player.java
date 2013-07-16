package com.monopoly.domain;

import java.util.List;

public class Player {

	private String token;
	private Square location;
	private int money;
	private int lastRoll;
	private boolean rolledDoubles;
	
	public Player(String token, Square startSquare) {
		this.location = startSquare;
		this.token = token;
		this.money = 1500;
		lastRoll = 0;
		this.rolledDoubles=false;
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

	public void takeTurn(Board b, Dice d1, Dice d2) {
		lastRoll = 0;
		rolledDoubles = false;
		takeTurn(b,d1,d2,1);
	}
	
	public void takeTurn(Board b, Dice d1, Dice d2, int times) {
		int firstRoll = d1.roll();
		int secondRoll = d2.roll();
		int roll = firstRoll + secondRoll;
		lastRoll = roll;
		
		
		List<Square> squares = b.getSquares();
		int newPos = location.getPosition() + roll;
		havePassedGo(newPos);
		location = squares.get(newPos % 40);
		
		handleLandingOnSpecialSquares(b);
		
		if (times<3 && firstRoll == secondRoll) {
			rolledDoubles = true;
			takeTurn(b,d1,d2, times++);
		}
		
	}

	private void havePassedGo(int newPos) {
		if (newPos >= 40){
			money +=200;
		}
	}

	private void handleLandingOnSpecialSquares(Board b) {
		
		if (location==b.getSquares().get(38)){
			money-=75;
		}
		
		if (location==b.getSquares().get(4)){
			if (money < 2000) {
				money =  (money/10) * 9;
			}
			else {
				money-=200;
			}
				
		}
	}

	public int getLastRoll() {
		
		return lastRoll;
	}

	public boolean getRolledDoubles() {
		return rolledDoubles;
	}

	void setMoney(int money) {
		this.money = money;
	}
}

package com.monopoly.domain;

public class Player {

	private String token;
	private Square location;
	private int money;
	private DiceBase dice;
	private Board board;
	private int doubleCount;
	private boolean inJail = false;
	private int jailRollCounter;
	private int lastRoll;

	public Player(String token, Square startSquare, DiceBase dice, Board board) {
		this.location = startSquare;
		this.token = token;
		this.dice = dice;
		this.board = board;
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

	public boolean getIsInJail() {
		return inJail;
	}

	public void setIsInJail(boolean inJail) {
		this.inJail = inJail;
		jailRollCounter = 0;
	}
	
	
	public void takeTurn() {
		boolean leftJail = false;
		dice.roll();
		lastRoll = dice.getTotal();
		
		if (getIsInJail()) {
			jailRollCounter++;
			if (dice.rolledDoubles()) {
				setIsInJail(false);
				leftJail = true;
			} else {
				if(jailRollCounter==3){
					money-=50;
					setIsInJail(false);
				} else {
					return;
				}
				
			}
		}
		RollResult result = board.getSquareFromRoll(location, dice);
		location = result.getLocation();
		
		

		if(location.getName().equals("Go Square")) {
			money+=200;
		} else if(result.passedGo()){
			money+=200;
		}
		
		if(location.getName().equals("Luxury Tax")) {
			money-=75;
		}
		
		if(location.getName().equals("Income Tax")) {
			int tax=(int) (money*0.10);
			if (tax > 200) {
				money-=200;
			}
			else {
				money-=150;
			}
		}
		
		if (location.equals(board.getSquares().get(30))) {
			setIsInJail(true);
			location = board.getSquares().get(10);
			return;
		}

		if (doubleCount == 2) {
			location = board.getSquares().get(10);
			doubleCount = 0;
			return;
		}

		if (!leftJail) {
			if (dice.rolledDoubles()) {
				doubleCount++;
				takeTurn();
			} else {
				doubleCount = 0;
			}
		}
	}

	public int getLastRoll() {
		return lastRoll;
	}

}

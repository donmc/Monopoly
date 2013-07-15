package com.monopoly.domain;

public class Player {

	private String token;
	private Square location;
	private int money;
	private DiceBase dice;
	private Board board;
	
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

	public void takeTurn() {
		dice.roll();
		location = board.getSquareFromRoll(location, dice);
	}
}

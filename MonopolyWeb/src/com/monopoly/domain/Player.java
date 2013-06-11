package com.monopoly.domain;

public class Player {

	private String token;
	private Square location;
	private int money;
	
	public Player(String token, Square startSquare) {
		this.location = startSquare;
		this.token = token;
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
}

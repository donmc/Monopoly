package com.monopoly.domain;

public class Square {

	private String name;
	private Square nextSquare;
	
	public Square(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public Square getNextSquare() {
		return nextSquare;
	}
	
	public void setNextSquare(Square nextSquare) {
		this.nextSquare = nextSquare;
	}

	public void landOn(Player player) {
		
	}

	public void passOver(Player player) {
		
	}
}

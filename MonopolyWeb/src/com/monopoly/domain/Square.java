package com.monopoly.domain;

public class Square {

	private String name;
	
	public Square(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void process(Player player) {
		if (name.equals("Go Square")) {
			player.addMoney(200);
		}
		
	}
}

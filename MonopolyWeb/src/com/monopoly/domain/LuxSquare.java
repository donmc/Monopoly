package com.monopoly.domain;

public class LuxSquare extends Square {

	public LuxSquare(String name) {
		super(name);
	}

	public void process(Player player) {
		player.addMoney(-75);
	}

}

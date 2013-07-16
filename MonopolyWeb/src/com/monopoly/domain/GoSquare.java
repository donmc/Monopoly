package com.monopoly.domain;

public class GoSquare extends Square {
	
	public GoSquare(String name) {
		super(name);
	}

	public void process(Player player) {
		player.addMoney(200);
	}
	
	//TODO: implement a pass method

}

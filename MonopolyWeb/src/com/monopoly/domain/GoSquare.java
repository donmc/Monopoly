package com.monopoly.domain;

public class GoSquare extends Square {

	public GoSquare(String name) {
		super(name);
	}
	
	@Override
	public void landOn(Player player){
		player.credit(200);
		
	}
	@Override
	public void passesOver(Player player){
		player.credit(200);
		
	}

}

package com.monopoly.domain;

public class LuxTaxSquare extends Square {

	public LuxTaxSquare(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void landOn(Player player){
		player.debit(75);
		
	}


}

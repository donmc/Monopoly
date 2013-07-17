package com.monopoly.domain;

public class IncomeTaxSquare extends Square {

	public IncomeTaxSquare(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void landOn(Player player){
		int amount = Math.min(200, player.getMoney()/10);
		player.debit(amount);
		
	}


}

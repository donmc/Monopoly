package com.monopoly.domain;

public class LuxuryTaxSquare extends Square {

	public LuxuryTaxSquare(String name) {
		super(name);
	}

	@Override
	public void landOn(Player p) {
		p.debit(75);
	}
	

}

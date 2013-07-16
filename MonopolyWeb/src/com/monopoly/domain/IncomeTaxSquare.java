package com.monopoly.domain;

public class IncomeTaxSquare extends Square {

	public IncomeTaxSquare(String name) {
		super(name);
	}

	@Override
	public void landOn(Player p) {
		int tax;
		tax = Math.min( 200, p.getMoney()/10 );
		p.debit( tax );
	}
	

}
package com.monopoly.domain;

public class GoSquare extends Square {

	public GoSquare(String name) {
		super(name);
	}
	
	@Override
	public void passThrough( Player p ) {
		p.credit(200);
	}
	

}

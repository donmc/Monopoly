package com.monolopy.domain;

import com.monopoly.domain.DiceBase;

public class RiggedDice extends DiceBase {

	public RiggedDice(int d1, int d2){
		this.d1 = d1;
		this.d2 = d2;
	}
	
	@Override
	public void roll() {
		
	}
	
	public void setD1(int d1){
		this.d1 = d1;
	}
	
	public void setD2(int d2){
		this.d2 = d2;
	}
	public void setDice(int d1, int d2){
		this.d1 = d1;
		this.d2 = d2;
	}
	
}

package com.monolopy.domain;

import com.monopoly.domain.DiceBase;

public class MultiTurnRiggedDice extends DiceBase {

	private int[][] turns;
	private int currentTurn = 0;
	
	public MultiTurnRiggedDice(int[][] turns){
		this.turns = turns;
	}
	
	@Override
	public void roll() {
		setD1(turns[currentTurn][0]);
		setD2(turns[currentTurn][1]);
		currentTurn++;
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

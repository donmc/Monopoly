package com.monopoly.domain;

public class IncomeSquare extends Square {
	public IncomeSquare(String name) {
		super(name);
	}

	public void process(Player player) {
		int amount = (int)Math.max(-200, (-0.1 * player.getMoney()));
		player.addMoney(amount);
	}

}

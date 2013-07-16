package com.monopoly.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class WhenLandingOnASquare {

	@Test
	public void shouldCollect200WhenLandingOnGo() {
		Board board =new Board();
		Player player = new Player("Cat", board.getSquares().get(35));
		
		int moneyBefore = player.getMoney();
		
		LoadedDie die1 = new LoadedDie();
		die1.fakedRoll(1);
		LoadedDie die2 = new LoadedDie();
		die2.fakedRoll(4);
		
		player.takeTurn(die1, die2);

		int moneyAfter = player.getMoney();

		assertEquals(200, moneyAfter - moneyBefore);
	}

	@Test
	public void shouldCollect200WhenPassingGo() {
		Board board =new Board();
		Player player = new Player("Cat", board.getSquares().get(35));
		
		int moneyBefore = player.getMoney();
		
		LoadedDie die1 = new LoadedDie();
		die1.fakedRoll(5);
		LoadedDie die2 = new LoadedDie();
		die2.fakedRoll(3);
		
		player.takeTurn(die1, die2);

		int moneyAfter = player.getMoney();

		assertEquals(200, moneyAfter - moneyBefore);
	}


	@Test
	public void shopuldPay75OnLuxTax() {
		Board board = new Board();
		Player player = new Player("Cat", board.getSquares().get(35));
		
		LoadedDie die1 = new LoadedDie();
		die1.fakedRoll(1);
		LoadedDie die2 = new LoadedDie();
		die2.fakedRoll(2);

		int moneyBefore = player.getMoney();
		
		player.takeTurn(die1, die2);

		int moneyAfter = player.getMoney();

		assertEquals(75, moneyBefore - moneyAfter);
		
	}
	
	@Test
	public void shopuldPayIncomeTaxOnIncomeTax1500() {
		Board board = new Board();
		Player player = new Player("Cat", board.getSquares().get(1));
		
		LoadedDie die1 = new LoadedDie();
		die1.fakedRoll(1);
		LoadedDie die2 = new LoadedDie();
		die2.fakedRoll(2);

		int moneyBefore = 1500;
		player.setMoney(moneyBefore);
		
		player.takeTurn(die1, die2);

		int moneyAfter = player.getMoney();

		assertEquals(150, moneyBefore - moneyAfter);
		
	}
	
	@Test
	public void shopuldPayIncomeTaxOnIncomeTax3000() {
		Board board = new Board();
		Player player = new Player("Cat", board.getSquares().get(1));
		
		LoadedDie die1 = new LoadedDie();
		die1.fakedRoll(1);
		LoadedDie die2 = new LoadedDie();
		die2.fakedRoll(2);

		int moneyBefore = 3000;
		player.setMoney(moneyBefore);
		
		player.takeTurn(die1, die2);

		int moneyAfter = player.getMoney();

		assertEquals(200, moneyBefore - moneyAfter);
		
	}
}

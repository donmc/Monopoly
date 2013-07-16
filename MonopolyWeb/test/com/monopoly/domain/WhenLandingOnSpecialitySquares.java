package com.monopoly.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class WhenLandingOnSpecialitySquares {

	 @Test
	 public void shouldLandOnGoSquare()
	 {
		Board board = new Board();
		Player player = new Player("Cat", Board.getSquareForPosition(38));
		MockDie die = new MockDie();
		die.diceRollValue = 1;
		int priorMoney = player.getMoney();
		
		player.takeTurn(die, die);
		assertEquals(priorMoney + 200, player.getMoney());
	 }
	 @Test
	 public void shouldPay75WhenLandOnLuxuryTax()
	 {
		Board board = new Board();
		Player player = new Player("Cat", Board.getSquareForPosition(36));
		MockDie die = new MockDie();
		die.diceRollValue = 1;
		int priorMoney = player.getMoney();
		
		player.takeTurn(die, die);
		assertEquals(priorMoney - 75, player.getMoney());
	 }
	 
	 @Test
	 public void shouldPay150WhenLandOnIncomeTax()
	 {
			Board board = new Board();
			Player player = new Player("Cat", Board.getSquareForPosition(2));
			MockDie die = new MockDie();
			die.diceRollValue = 1;
			int priorMoney = player.getMoney();
			
			player.takeTurn(die, die);
			assertEquals(priorMoney - 150, player.getMoney());		 
	 }
	 @Test
	 public void shouldPay200WhenLandOnIncomeTax()
	 {
			Board board = new Board();
			Player player = new Player("Cat", Board.getSquareForPosition(2));
			MockDie die = new MockDie();
			die.diceRollValue = 1;
			player.setMoney(3000);

			player.takeTurn(die, die);
			assertEquals(2800, player.getMoney());		 
	 }
}

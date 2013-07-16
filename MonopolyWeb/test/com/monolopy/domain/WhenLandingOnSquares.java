package com.monolopy.domain;

import static org.junit.Assert.*;

import org.junit.Test;

import com.monopoly.domain.Board;
import com.monopoly.domain.DiceBase;
import com.monopoly.domain.Player;
import com.monopoly.domain.Square;

public class WhenLandingOnSquares {

	@Test
	public void shouldCollect200DollarsOnGo() {
		Board board = new Board();
		DiceBase dice = new RiggedDice(2, 1);
		Player player = new Player("Cat", board.getSquares().get(37), dice, board);
		player.setMoney(1500);
		
		player.takeTurn();
		assertEquals(player.getMoney(), 1700);
	}
	
	@Test
	public void shouldPay75WhenLandingOnLuxuryTax() {
		Board board = new Board();
		DiceBase dice = new RiggedDice(2, 1);
		Player player = new Player("Cat", board.getSquares().get(35), dice, board);
		player.setMoney(1500);
		
		player.takeTurn();
		assertEquals(player.getMoney(), 1425);
	}
	
	@Test
	public void shouldPay150WhenLandingOnIncomeTaxWith1500Dollars() {
		Board board = new Board();
		DiceBase dice = new RiggedDice(3, 1);
		Player player = new Player("Cat", board.getSquares().get(0), dice, board);
		player.setMoney(1500);
		
		player.takeTurn();
		assertEquals(player.getMoney(), 1350);
	}
	
	@Test
	public void shouldPay200WhenLandingOnIncomeTaxWith3000Dollars() {
		Board board = new Board();
		DiceBase dice = new RiggedDice(3, 1);
		Player player = new Player("Cat", board.getSquares().get(0), dice, board);
		player.setMoney(3000);
		
		player.takeTurn();
		assertEquals(player.getMoney(), 2800);
	}

	@Test
	public void shouldCollect200DollarsPassingGo() {
	}
}

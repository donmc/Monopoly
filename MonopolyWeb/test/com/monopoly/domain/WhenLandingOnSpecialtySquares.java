package com.monopoly.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
public class WhenLandingOnSpecialtySquares {

	@Test
	public void shouldCollect200WhenLandingOnGo () {

		Board board = new Board();
		Board.setDie1(new LoadedDie(2));
		Board.setDie2(new LoadedDie(1));
		
		Player player = new Player("Hat", board.getSquares().get(37));
		player.takeTurn(board);
		
		assertTrue ("Must be on go square", player.getLocation().getName().equals("Go Square"));

		assertEquals(1700, player.getMoney());
	}

@Test
	public void shouldPay75WhenLandingOnLux () {
	
		Board board = new Board();
		Board.setDie1(new LoadedDie(2));
		Board.setDie2(new LoadedDie(1));
		
		Player player = new Player("Hat", board.getSquares().get(35));
		player.takeTurn(board);
		
		assertTrue ("Must be on LUX square", player.getLocation().getName().equals("Luxury Tax"));
	
		assertEquals(1575, player.getMoney());
	}
}







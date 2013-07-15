package com.monopoly.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class GameTest {

	@Test
	public void testGame_CorrectNumberOfPlayers() {
		// Setup
		int numberOfPlayers = 6;
		// Execute
		Game game = new Game(numberOfPlayers);
		
		// Verify
		assertEquals(numberOfPlayers, game.getPlayers().size());
		
	}

	@Test
	public void testGame_TooFewPlayers() {
		try {
        new Game(1);
        fail("Should throw IllegalArgumentException exception");
		} catch (IllegalArgumentException e) {
			assertEquals("Too few players!", e.getMessage());
		}
	}

	@Test(expected=IllegalArgumentException.class)
	public void testGame_TooManyPlayers() {
        new Game(9);
	}

}

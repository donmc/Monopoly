package com.monopoly.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class GameTest {

	@Test
	public void testGame_PlayerCreated() {
		// Setup 
		int numberOfPlayers = 4;
		
		// Exercise
		Game game = new Game(numberOfPlayers);
		
		// Verify
		assertEquals(numberOfPlayers, game.getPlayers().size());
	}

	@Test
	public void testGame_TooManyPlayersInvalid() {
		// Setup
		int numberOfPlayers = 9;
		
		try {
			// Exercise
			new Game(numberOfPlayers);
			fail("Must throw Illegal");
		} catch (IllegalArgumentException e) {
			assertEquals("Too many players!", e.getMessage());
		}catch(Exception e) {
			fail("Wrong Exception Thrown");
		}
		
	}

	@Test(expected=IllegalArgumentException.class)
	public void testGame_NotEnoughPlayersInvalid() {
		new Game(1);
	}
}

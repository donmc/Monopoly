package com.monopoly.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class WhenStartingTheGame {

	@Test
	public void shouldNotCreateGamesWithTooFewPlayers() {
		try{
			Game g = new Game(0);
			fail("Should fail with 0");
		}catch(IllegalArgumentException e) {
			assertEquals("Too few players!", e.getMessage());
		}
	}
	
	@Test
	public void shouldNotCreateGamesWithTooManyPlayers() {
		try{
			Game g = new Game(10);
			fail("Should fail with 0");
		}catch(IllegalArgumentException e) {
			assertEquals("Too many players!", e.getMessage());
		}
	}
	@Test
	public void shouldCreateGames() {

		Game g = new Game(4);
		assertEquals(4, g.getPlayers().size());

	}

}

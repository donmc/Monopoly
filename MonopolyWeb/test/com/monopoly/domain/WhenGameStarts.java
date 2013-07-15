package com.monopoly.domain;
import static org.junit.Assert.*;

import org.junit.Test;

import com.monopoly.domain.Game;


public class WhenGameStarts {

	@Test
	public void shouldRejectTooFewPlayers() {
		try {
			new Game(1);
			fail("Should have thrown an exception");
		} catch (IllegalArgumentException e) {
			assertEquals("Too few players!", e.getMessage());
		}
	}
	
	@Test
	public void shouldRejectTooManyPlayers() {
		try {
			new Game(10);
			fail("Should have thrown an exception");
		} catch (IllegalArgumentException e) {
			assertEquals("Too many players!", e.getMessage());
		}
	}
	
	@Test
	public void shouldAllowFivePlayers() {
		int numberOfPlayers=5;
		Game game = new Game(numberOfPlayers);
		assertEquals(numberOfPlayers, game.getPlayers().size());
	}

}

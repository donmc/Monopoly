package com.monopoly.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class GameTest {

	@Test
	public void testGame_CorrectNumberOfPlayers() {
		for ( int num = 2; num< 8; num++) {
			Game game = new Game(num);
			assertEquals(num,game.getPlayers().size());
		}
	}

	@Test
	public void testGame_ToManyPlayers() {
		try {
			new Game(10);
			fail("should throw exception");
		}
		catch (IllegalArgumentException e)
		{
			assertEquals("Too many players!",e.getMessage());
		}
	}
	
	@Test
	public void tooFewPlayers() {
		try {
			new Game(0);
			new Game(1);
			fail("should throw exception");
		}
		catch (IllegalArgumentException e)
		{
			assertEquals("Too few players!",e.getMessage());
		}
	}
	
}

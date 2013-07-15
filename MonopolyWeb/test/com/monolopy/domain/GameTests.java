package com.monolopy.domain;

import static org.junit.Assert.*;

import org.junit.Test;

import com.monopoly.domain.Game;

public class GameTests {

	@Test
	public void testCorrectNumberOfPlayers(){
		int numberOfPlayers = 6;
		Game game = new Game(numberOfPlayers);
		assertEquals(numberOfPlayers, game.getPlayers().size());
	}
	
	@Test
	public void testTooFewPlayers() {
		try{
			new Game(-1);
			fail("Expected IllegalArgumentException");
		} catch(IllegalArgumentException ex){
			assertEquals("Too few players!", ex.getMessage());
		}
	}
	
	@Test
	public void testTooManyPlayers(){
		try{
			new Game(9);
			fail("Expected IllegalArgumentException");
		} catch(IllegalArgumentException ex){
			assertEquals("Too many players!", ex.getMessage());
		}
	}

}

package com.monopoly.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class GameTest {

	@Test
	public void shouldNotCreateGamesWithTooFewPlayers() {
		try{
			Game g = new Game(0);
			fail("Should fail with 0");
		}catch(IllegalArgumentException e) {
			
		}
	}

}

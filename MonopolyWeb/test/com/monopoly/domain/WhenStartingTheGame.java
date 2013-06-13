package com.monopoly.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WhenStartingTheGame {
	
	private Game game;

	@Before
	public void setup() {
		game = new Game(4);
	}

	@Test
	public void shouldHaveATokenForEachPlayer() {
		//fail("Not yet implemented");
	}
	
	@Test
	public void shouldStartPlayersOnGoSquare() {
		for (Player player : game.getPlayers()) {
			assertEquals("Go Square", player.getLocation().getName());
		}
	} 
	
	@Test
	public void shouldGivePlayers1500() {

		for (Player player : game.getPlayers()) {
			assertEquals(1500, player.getMoney());
		}
	}

}

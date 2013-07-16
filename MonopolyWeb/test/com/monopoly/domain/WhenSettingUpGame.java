package com.monopoly.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class WhenSettingUpGame {

	@Test
	public void shouldAssignTokensToPlayers() {
//		fail("Not yet implemented");
	}
	@Test
	public void shouldPlacePlayersOnGoSquare() {
		Game game = new Game(8);
		assertEquals ("Go Square", game.getPlayers().get(0).getLocation().getName());
		assertEquals ("Go Square", game.getPlayers().get(1).getLocation().getName());
		
	
//		fail("Not yet implemented");
	}

	@Test
	public void shouldStartPlayersWith1500Dollars() {
		Game game = new Game(8);
		for (Player player : game.getPlayers())
		{
			assertEquals(1500, player.getMoney());
		}
//		fail("Not yet implemented");
	}
	@Test
	public void shouldHave40Squares() {
		Game game = new Game(4);
		assertEquals(40, game.getSquares().size());
		//fail("Not yet implemented");
	}
}

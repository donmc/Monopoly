package com.monopoly.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class WhenSettingUpGame {

	@Test
	public void shouldAssignTokensToPlayers() {
		Game game = new Game(6);
		for (Player player : game.getPlayers()) {
			assertNotNull(player.getToken());
		}
	}

	@Test
	public void shouldHave40Squares() {
		Game game = new Game(4);
		assertEquals(40, game.getSquares().size());
	}

	@Test
	public void shouldPlacePlayersOnGoSquare() {
		Game game = new Game(4);
		for (Player player : game.getPlayers()) {
			assertTrue(player.getLocation().getName().equals("Go Square"));
		}
	}
	
	@Test
	public void shouldStartPlayersWith1500Dollars() {
		Game game = new Game(4);
		for (Player player : game.getPlayers()) {
			assertEquals(1500, player.getMoney());
		}
	}
	
}

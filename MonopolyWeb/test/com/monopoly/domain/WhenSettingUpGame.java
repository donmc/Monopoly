package com.monopoly.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class WhenSettingUpGame {
	
	@Test
	public void shouldAssignTokensToPlayers() {
		Game g = new Game(2);
		for( Player p : g.getPlayers() ) {
			assertNotNull( p.getToken() );
		}
	}
	
	@Test
	public void shouldPlacePlayersOnGoSquare() {
		Game game = new Game(5);
		Square startSquare = game.getSquares().get(0);
		for( Player p : game.getPlayers() ) {
			assertEquals( startSquare, p.getLocation() );
		}
	}
	
	@Test
	public void shouldStartPlayersWith1500Dollars() {
		Game game = new Game(2);
		for (Player player : game.getPlayers()) {
			assertEquals(1500, player.getMoney());
		}
	}
	
	@Test
	public void shouldHave40Squares() {
		Game game = new Game(2);
		assertEquals(40, game.getSquares().size());
	}

}

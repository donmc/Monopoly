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
	
	@Test
	public void shouldAssignTokensToPlayers() {
		Game g = new Game(2);
		for (int i=0; i<2; i++){
			assertNotNull(g.getPlayers().get(i).getToken());
		}
	}
	
	@Test
	public void shouldHaveFortySquares() {
		Game g = new Game(2);
		assertEquals(40, g.getSquares().size());
	}

	@Test
	public void shouldPlacePlayersOnGo() {
		Game g = new Game (4);
		for (int i = 0; i < 4; i++) {
			assertEquals("Go Square", g.getPlayers().get(i).getLocation()
					.getName());
		}
	}
	
	
	@Test
	public void shouldStartPlayersWith1500Buckerooneys() {
		Game g = new Game (4);
		for (int i = 0; i < 4; i++) {
			assertEquals(1500, g.getPlayers().get(i).getMoney());
		}
	}
	
	

}

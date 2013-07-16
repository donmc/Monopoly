package com.monopoly.domain;

import static org.junit.Assert.*;
import java.util.List;

import org.junit.Test;

public class WhenSettingUpGame {

	@Test
	public void shouldAssignTokensToPlayers() {
		Game game = new Game(8);
		List<Player> players = game.getPlayers();
		assertEquals("Horse", players.get(0).getToken());	
		assertEquals("Iron", players.get(1).getToken());
		assertEquals("Racecar", players.get(2).getToken());
		assertEquals("Dog", players.get(3).getToken());
		assertEquals("Top Hat", players.get(4).getToken());
		assertEquals("Shoe", players.get(5).getToken());
		assertEquals("Wheelbarrow", players.get(6).getToken());
		assertEquals("Thimble", players.get(7).getToken());
	}

	@Test
	public void shouldPlacePlayersOnGoSquare() {
		Game game = new Game(8);
		Square startSquare = game.getSquares().get(0);
		for (Player player : game.getPlayers())
		{
			assertEquals(startSquare, player.getLocation());	
			assertTrue(player.getIsFirstRoll());
		}
		
	}
	
	@Test
	public void shouldStartPlayersWith1500Dollars() {
		Game game = new Game(4);
		List<Player> players = game.getPlayers();
		assertEquals(players.get(0).getMoney(), 1500);
	}
	
	@Test
	public void shouldHave40Squares(){
		Game game = new Game(4);
		assertEquals(40, game.getSquares().size());
	}
	

}

package com.monolopy.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.monopoly.domain.Game;
import com.monopoly.domain.Player;
import com.monopoly.domain.Square;

public class WhenSettingUpGame {

	
	@Test
	public void shouldAssignTokensToPlayers() {
		Game game = new Game(8);
		for(Player player: game.getPlayers()){
			assertFalse(player.getToken().equals(""));
		}
	}
	
	@Test
	public void shouldHave40Squares(){
		Game game = new Game(4);
		assertEquals(40, game.getSquares().size());
	}
	
	@Test
	public void shouldPlacePlayersOnGoSquare() {
		Game game = new Game(8);
		Square startSquare = game.getSquares().get(0);
		for(Player player: game.getPlayers()){
			Square square = player.getLocation();
			assertEquals(startSquare.getName(), square.getName());
		}
	}
	
	@Test
	public void shouldStartPlayersWith1500Dollars(){
		Game game = new Game(8);
		for(Player player: game.getPlayers()){
			assertEquals(1500, player.getMoney());
		}
	}
	
	@Test
	public void shouldNotAllowFewerThan2Players(){
		try{
			new Game(-1);
			fail("Expected IllegalArgumentException");
		} catch(IllegalArgumentException ex){
			assertEquals("Too few players!", ex.getMessage());
		}
	}
	
	@Test
	public void shouldNotMoreThan8Players(){
		try{
			new Game(9);
			fail("Expected IllegalArgumentException");
		} catch(IllegalArgumentException ex){
			assertEquals("Too many players!", ex.getMessage());
		}
	}
	
	@Test
	public void shouldAllowBetween2And8Players(){
		int numberOfPlayers = 6;
		Game game = new Game(numberOfPlayers);
		assertEquals(numberOfPlayers, game.getPlayers().size());
	}
}

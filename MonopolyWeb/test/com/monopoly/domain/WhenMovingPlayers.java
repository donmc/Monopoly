package com.monopoly.domain;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class WhenMovingPlayers {

	@Test
	public void shouldChangeLocation() {
		Board board = new Board();
		Player player = new Player("Cat",board.getStartSquare());
		
		player.takeTurn(new Die(), new Die());
		
		assertFalse(player.getLocation().equals(board.getStartSquare()));
	}
	
	@Test
	public void shouldNotMoveLessThanTwoPositions()
	{
		Board board = new Board();
		Player player = new Player("Cat", board.getStartSquare());

		for (int i = 0; i < 200; i++)
		{
			assertTrue(player.rollBothDice(new Die(), new Die()) > 1);
		}
	}

	@Test
	public void shouldNotMoveMoreThanTwelvePositions()
	{
		Board board = new Board();
		Player player = new Player("Cat", board.getStartSquare());

		for (int i = 0; i < 200; i++)
		{
			assertTrue(player.rollBothDice(new Die(), new Die()) < 13);
		}
	}

	
	@Test
	public void shouldEachPlayerMoveOncePerRound()
	{
		Game game = new Game(4);
		game.playRound();
		List <Player> players = game.getPlayers();

		for (Player player : players) {
			assertFalse(player.getLocation().getName().equals(Board.getSquareForPosition(0).getName()));
			
		}
	}
	
}

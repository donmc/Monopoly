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
	public void shouldMoveEachPlayer()
	{
		Game game = new Game(4);
		MockDie die = new MockDie();
		die.diceRollValue = 6;
		game.setDie1(die);
		game.setDie2(die);
		game.playRound();
		List <Player> players = game.getPlayers();

		for (Player player : players) {
			assertTrue(player.getLocation().getName().equals("Electric Company"));
			assertEquals(12, player.getLastRoll());
		}
	}
	
	@Test
	public void shouldLoopAroundBoard()
	{
		Board board = new Board();
		Player player = new Player("Cat", board.getStartSquare());
		
		MockDie die = new MockDie();
		die.diceRollValue = 6;
		int currentMoney = player.getMoney();
		
		player.takeTurn(die, die);
		assertEquals(12, Board.getPositionForSquare(player.getLocation()));
		assertEquals(currentMoney, player.getMoney());
		
		player.takeTurn(die, die);
		assertEquals(24, Board.getPositionForSquare(player.getLocation()));
		assertEquals(currentMoney, player.getMoney());
		
		player.takeTurn(die, die);
		assertEquals(36, Board.getPositionForSquare(player.getLocation()));
		assertEquals(currentMoney, player.getMoney());
		
		player.takeTurn(die, die);
		assertEquals(8, Board.getPositionForSquare(player.getLocation()));
		assertEquals((currentMoney + 200), player.getMoney());
		
	}
}

package com.monopoly.domain;


import static org.junit.Assert.*;

import org.junit.Test;

import com.monopoly.domain.Board;
import com.monopoly.domain.Die;
import com.monopoly.domain.Player;
import com.monopoly.domain.Square;

public class WhenMovingPlayers {
	
	@Test
	public void shouldChangeLocation() {
		Board board =new Board();
		Player player = new Player("Cat", board.getStartSquare());
		
		
		player.takeTurn(new Die(), new Die());		assertFalse(player.getLocation().equals(board.getStartSquare()));
	}
	
	@Test
	public void shouldNotMoveLessThan2Positions() {
		
		Board board =new Board();
		Player player = new Player("Cat", board.getStartSquare());
		
		int currentPosition = board.getSquareIndex(player.getLocation());
		
		player.takeTurn(new Die(), new Die());
		
		int newPosition = board.getSquareIndex(player.getLocation());
		
		int distance = ( (newPosition - currentPosition) + 40 ) % 40;
		
		assertTrue(distance >= 2);
	}
	
	@Test
	public void shouldNotMoveMoreThan12Positions() {
		
		Board board =new Board();
		Player player = new Player("Cat", board.getStartSquare());
		
		player.takeTurn(new Die(), new Die());
		int currentPosition = board.getSquareIndex(player.getLocation());
		
		player.takeTurn(new Die(), new Die());
		int newPosition = board.getSquareIndex(player.getLocation());
		
		int distance = ( (newPosition - currentPosition) + 40 ) % 40;
		
		assertTrue(distance <= 12);
	}
	
	// shouldLoopAroundBoard
	@Test
	public void shouldLoopAroundBoard() {
		Board board = new Board();
		Player player = new Player("Cat", board.getStartSquare());
		
		Square location = new Square("Boardwalk");
		player.setLocation(location);
		
		LoadedDie die1 = new LoadedDie();
		die1.fakedRoll(1);
		LoadedDie die2 = new LoadedDie();
		die2.fakedRoll(2);
		
		player.takeTurn(die1, die2);

		Square square = player.getLocation();
		assertTrue(square.getName().equals("Community Chest"));
	}
	
	// shouldMoveEachPlayer
	

}

package com.monopoly.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class WhenMovingPlayers {
	
	@Test
	public void shouldChangeLocation() {
		Board board =new Board();
		Player player = new Player("Cat", board.getStartSquare());
		
		
		player.takeTurn();
		
		assertFalse(player.getLocation().equals(board.getStartSquare()));
	}
	
	@Test
	public void shouldNotMoveLessThan2Positions() {
		
		Board board =new Board();
		Player player = new Player("Cat", board.getStartSquare());
		
		int currentPosition = board.getSquareIndex(player.getLocation());
		
		player.takeTurn();
		
		int newPosition = board.getSquareIndex(player.getLocation());
		
		int distance = ( (newPosition - currentPosition) + 40 ) % 40;
		
		assertTrue(distance >= 2);
	}
	
	@Test
	public void shouldNotMoveMoreThan12Positions() {
		
		Board board =new Board();
		Player player = new Player("Cat", board.getStartSquare());
		
		player.takeTurn();
		int currentPosition = board.getSquareIndex(player.getLocation());
		
		player.takeTurn();
		int newPosition = board.getSquareIndex(player.getLocation());
		
		int distance = ( (newPosition - currentPosition) + 40 ) % 40;
		
		assertTrue(distance <= 12);
	}
	

	// Move Players
	// 0 // Able to take a turn (e.g. In Jail?)
	// // // Demonstrate the player is able to move
	// 1 // Roll Dice (pick 2 numbers 1 ~ 6 or 1 pick number 2 ~ 12)
	// // // Demonstrate the player has a roll value
	// 2 // Calculate new location based on current location
	// // // Demonstrate the player has a new location based on the roll
	// 3 // Determine action based on new location (Not in scope for this story)
	// 4 // (if using two dice and the numbers were the same) -> // 1 // (May not be in scope for this story)
	
	// Pass Go
	// Add $200 to player money
	
	// Lux - Inc Tax
	// // Pay LX%
	// // Pay Inc Tax IT%
	

}

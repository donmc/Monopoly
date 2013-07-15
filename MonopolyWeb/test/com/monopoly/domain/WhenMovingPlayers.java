package com.monopoly.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class WhenMovingPlayers {

	@Test
	public void shouldChangeLocation() {
		Board board = new Board();
		Player player = new Player("TrashCan", board.getStartSquare());
		player.takeTurn(new Die(), new Die());
		assertFalse(player.getLocation().equals(board.getStartSquare()));
	}
	
	@Test
	public void shouldNotMoveLessThanTwoPositions() {
		Board board = new Board();
		Player player = new Player( "Garbage", board.getStartSquare() );
		int location;
		int prevLocation;
		for( int i = 0; i < 500; i++ ) {
			prevLocation = board.getSquareIndex( player.getLocation() );
			player.takeTurn(new Die(), new Die());
			location = board.getSquareIndex( player.getLocation() );
			if( prevLocation > location ) {
				location += 40;
			}
			assertTrue( location > prevLocation + 1 );
		}		
	}
	
	@Test
	public void shouldNotMoveMoreThanTwelvePositions() {
		Board board = new Board();
		Player player = new Player( "Garbage", board.getStartSquare() );
		int location;
		int prevLocation;
		for( int i = 0; i < 500; i++ ) {
			prevLocation = board.getSquareIndex( player.getLocation() );
			player.takeTurn(new Die(), new Die());
			location = board.getSquareIndex( player.getLocation() );
			if( prevLocation > location ) {
				location += 40;
			}
			System.out.println("prevLocation: " + prevLocation + " location: " + location);
			assertTrue( location <= prevLocation + 12 );
		}		
	}

}

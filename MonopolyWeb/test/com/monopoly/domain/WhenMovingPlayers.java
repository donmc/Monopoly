package com.monopoly.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

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
	public void shouldLoopAroundBoard() {
		Board board = new Board();
		int prevLocation = 38;
		Player player = new Player( "Garbage", board.getSquareAtIndex(prevLocation) );
		player.takeTurn(new FakeDie(6), new FakeDie(6));
		int newLocation = board.getSquareIndex( player.getLocation() );
		assertTrue(newLocation < prevLocation && newLocation > 0);
	}
	
	@Test
	public void shouldLoopAroundBoard2() {
		Board board = new Board();
		int prevLocation = 38;
		Player player = new Player( "Garbage", board.getSquareAtIndex(prevLocation) );
		Die d1 = Mockito.mock(Die.class);
		Mockito.when(d1.roll()).thenReturn(6);
		Die d2 = Mockito.mock(Die.class);
		Mockito.when(d2.roll()).thenReturn(3);
		player.takeTurn(d1, d2);
		int newLocation = board.getSquareIndex( player.getLocation() );
		assertTrue(newLocation < prevLocation && newLocation > 0);
	}
	
	@Test
	public void shouldMoveEachPlayer() {
		
		List<Player> players = new ArrayList<Player>();
		for (int i = 0; i < 7; i++) {
			MockPlayer player = new MockPlayer("Junk", new Square( "foo" ) );
			players.add(player);
		}
		Game g = new Game(2);
		g.setPlayers( players );
		
		g.playRound();
		
		for( Player p : players ) {
			assertEquals( 1, ((MockPlayer)p).getTurnsTaken() );
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

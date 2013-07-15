package com.monopoly.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class WhenMovingPlayers {

	@Test
	public void shouldChangeLocation() {
		Board b = new Board();
		Player p = new Player("Whatever you want", b.getStartSquare());
		p.takeTurn(b);
		
		assertFalse(b.getStartSquare().getName().equals(p.getLocation().getName()) );
	}

	@Test
	public void shouldRollbetween2And12() {
		Dice d = new Dice();
		int roll = d.roll();
		for (int i =0; i<100; i++){
			assertTrue(2<= roll && roll <=12);
		}
		
	}
	
	@Test
	public void shouldNotMoveLessThanTwoPositions() {
		Board b = new Board();
		Player p = new Player("Whatever you want", b.getStartSquare());
		p.takeTurn(b);
		assertTrue(2<= p.getLocation().getPosition());
	}

	@Test
	public void shouldNotMoveMoreThanTwelvePositions() {
		Board b = new Board();
		Player p = new Player("Whatever you want", b.getStartSquare());
		p.takeTurn(b);
		assertTrue(12>= p.getLocation().getPosition());
	}
	
	@Test
	public void shouldWrapAroundEndOfBoard() {
		Board b = new Board();
		Player p = new Player("Whatever you want", b.getSquares().get(39));
		p.takeTurn(b);
		assertTrue(39 > p.getLocation().getPosition());
	}
	
	
	@Test
	public void shouldMoveEachPlayerInRound(){
		Game g = new Game(4);
		g.playRound();
		for (Player p :g.getPlayers()) {
			assertFalse(p.getLocation().equals(g.getSquares().get(0)));
		}
	}
	
	@Test
	public void shouldRollAgainWithDoubles(){
		
	}
	
}

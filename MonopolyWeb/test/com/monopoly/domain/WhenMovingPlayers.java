package com.monopoly.domain;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

public class WhenMovingPlayers {

	@Test
	public void shouldChangeLocation() {
		Board b = new Board();
		Player p = new Player("Whatever you want", b.getStartSquare());
		p.takeTurn(b, new Dice(), new Dice());
		
		assertFalse(b.getStartSquare().getName().equals(p.getLocation().getName()) );
	}

	@Test
	public void shouldRollbetween1And6() {
		Dice d = new Dice();
		int roll = d.roll();
		for (int i =0; i<100; i++){
			assertTrue(1<= roll && roll <=6);
		}
		
	}
	
	@Test
	public void shouldNotMoveLessThanTwoPositions() {
		Board b = new Board();
		Player p = new Player("Whatever you want", b.getStartSquare());
		p.takeTurn(b, new Dice(), new Dice());
		assertTrue(2<= p.getLocation().getPosition());
	}

	@Test
	public void shouldNotMoveMoreThanTwelvePositions() {
		Board b = new Board();
		Player p = new Player("Whatever you want", b.getStartSquare());
		p.takeTurn(b, new Dice(), new Dice()); 
		assertTrue(12>= p.getLocation().getPosition());
	}
	
	@Test
	public void shouldWrapAroundEndOfBoard() {
		Board b = new Board();
		Player p = new Player("Whatever you want", b.getSquares().get(39));
		p.takeTurn(b, new Dice(), new Dice());
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
		Dice dice = new Dice(){
			private int dieVal = 1;
			public int roll() {
				return dieVal++;
			}
		};
		
		Dice diceTwo = new Dice(){
			public int roll() {
				return 1;
			}
		};
		
		Board b = new Board();
		Player p = new Player("Whatever you want", b.getStartSquare());
		p.takeTurn(b, dice, diceTwo);
		
		assertEquals(5, b.getSquares().indexOf(p.getLocation()));
	}
	
	
	@Test
	public void shouldKeepLastRoll(){
		Dice dice = new Dice(){
			public int roll() {
				return 4;
			}
		};
		
		Dice diceTwo = new Dice(){
			public int roll() {
				return 1;
			}
		};
		Board b = new Board();
		Player p = new Player("Whatever you want", b.getStartSquare());
		p.takeTurn(b, dice, diceTwo);
		assertEquals(5,p.getLastRoll());
		
		
	}
	
	@Test
	public void shouldKeepLastRollOnlyAndKnowDoublesRolled(){
		Dice dice = new Dice(){
			private int dieVal = 1;
			public int roll() {
				return dieVal++;
			}
		};
		
		Dice diceTwo = new Dice(){
			public int roll() {
				return 1;
			}
		};
		Board b = new Board();
		Player p = new Player("Whatever you want", b.getStartSquare());
		p.takeTurn(b, dice, diceTwo);
		assertEquals(3,p.getLastRoll());
		assertTrue(p.getRolledDoubles());
	}
	
	
}

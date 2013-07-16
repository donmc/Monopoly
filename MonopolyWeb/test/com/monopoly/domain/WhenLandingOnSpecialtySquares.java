package com.monopoly.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class WhenLandingOnSpecialtySquares {

	@Test
	public void shouldGetMoneyWhenLandingOnGo() {
		Dice dice = new Dice(){
			public int roll() {
				return 2;
			}
		};
		
		Dice diceTwo = new Dice(){
			public int roll() {
				return 1;
			}
		};
		Board b = new Board();
		Player p = new Player("Whatever you want", b.getSquares().get(37));
		p.takeTurn(b, dice, diceTwo);
		assertEquals(1700, p.getMoney());
	}
	
	
	@Test
	public void shouldPayMoneyWhenLandingOnLuxuryTax() {
		Dice dice = new Dice(){
			public int roll() {
				return 2;
			}
		};
		
		Dice diceTwo = new Dice(){
			public int roll() {
				return 1;
			}
		};
		Board b = new Board();
		Player p = new Player("Whatever you want", b.getSquares().get(35));
		p.takeTurn(b, dice, diceTwo);
		assertEquals(1425, p.getMoney());
	}
	
	
	@Test
	public void shouldPayMoneyWhenLandingOnIncomeTax() {
		Dice dice = new Dice(){
			public int roll() {
				return 2;
			}
		};
		
		Dice diceTwo = new Dice(){
			public int roll() {
				return 1;
			}
		};
		Board b = new Board();
		Player p = new Player("Whatever you want", b.getSquares().get(1));
		p.takeTurn(b, dice, diceTwo);
		assertEquals(1350, p.getMoney());
	}
	
	@Test
	public void shouldPayMoneyWhenLandingOnIncomeTaxAndMoreThanTwoGrand() {
		Dice dice = new Dice(){
			public int roll() {
				return 2;
			}
		};
		
		Dice diceTwo = new Dice(){
			public int roll() {
				return 1;
			}
		};
		Board b = new Board();
		Player p = new Player("Whatever you want", b.getSquares().get(1));
		p.setMoney(3000);
		p.takeTurn(b, dice, diceTwo);
		assertEquals(2800, p.getMoney());
	}
	
	@Test
	public void shouldWrapAroundEndOfBoard() {
		Dice dice = new Dice(){
			public int roll() {
				return 2;
			}
		};
		
		Dice diceTwo = new Dice(){
			public int roll() {
				return 1;
			}
		};
		
		
		Board b = new Board();
		Player p = new Player("Whatever you want", b.getSquares().get(39));
		p.takeTurn(b, dice, diceTwo);
		assertEquals(1700, p.getMoney());
	}
	

}

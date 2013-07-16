package com.monopoly.domain;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;

public class WhenLandingOnSpecialtySquares {

	@Test
	public void shouldCollect200ForLandingOnGo() {
		Board board = new Board();
		int prevLocation = 37;
		Player player = new Player( "Garbage", board.getSquareAtIndex(prevLocation) );
		
		Die d1 = Mockito.mock(Die.class);
		Mockito.when(d1.roll()).thenReturn(1);
		Die d2 = Mockito.mock(Die.class);
		Mockito.when(d2.roll()).thenReturn(2);
		
		int prevMoney = player.getMoney();
		
		player.takeTurn(d1, d2);
		
		int newMoney = player.getMoney();
		
		assertEquals(prevMoney+200, newMoney);
	}

	@Test
	public void shouldPay75ForLandingOnLuxuryTax() {
		Board board = new Board();
		int prevLocation = 35;
		Player player = new Player( "Garbage", board.getSquareAtIndex(prevLocation) );
		
		Die d1 = Mockito.mock(Die.class);
		Mockito.when(d1.roll()).thenReturn(1);
		Die d2 = Mockito.mock(Die.class);
		Mockito.when(d2.roll()).thenReturn(2);
		
		int prevMoney = player.getMoney();
		
		player.takeTurn(d1, d2);
		
		int newMoney = player.getMoney();
		
		assertEquals(prevMoney-75, newMoney);
	}

	@Test
	public void shouldPay150OnIncomeTaxWhenHave1500() {
		Board board = new Board();
		int prevLocation = 1;
		Player player = new Player( "Garbage", board.getSquareAtIndex(prevLocation) );
		
		Die d1 = Mockito.mock(Die.class);
		Mockito.when(d1.roll()).thenReturn(1);
		Die d2 = Mockito.mock(Die.class);
		Mockito.when(d2.roll()).thenReturn(2);
		
		int prevMoney = player.getMoney();
		
		player.takeTurn(d1, d2);
		
		int newMoney = player.getMoney();
		
		assertEquals(prevMoney-150, newMoney);
	}
	
	@Test
	public void shouldPay200OnIncomeTaxWhenHave3000() {
		Board board = new Board();
		int prevLocation = 1;
		Player player = new Player( "Garbage", board.getSquareAtIndex(prevLocation) );
		
		Die d1 = Mockito.mock(Die.class);
		Mockito.when(d1.roll()).thenReturn(1);
		Die d2 = Mockito.mock(Die.class);
		Mockito.when(d2.roll()).thenReturn(2);
		
		player.setMoney( 3000 );
		
		int prevMoney = player.getMoney();
		
		player.takeTurn(d1, d2);
		
		int newMoney = player.getMoney();
		
		assertEquals(prevMoney-200, newMoney);
	}
	
	
	
}

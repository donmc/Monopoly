package com.monopoly.domain;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;

public class WhenPassingGo {

	@Test
	public void shouldCollect200WhenPassingGo() {
		Board board = new Board();
		int prevLocation = 37;
		Player player = new Player( "Garbage", board.getSquareAtIndex(prevLocation) );
		
		Die d1 = Mockito.mock(Die.class);
		Mockito.when(d1.roll()).thenReturn(6);
		Die d2 = Mockito.mock(Die.class);
		Mockito.when(d2.roll()).thenReturn(2);
		
		int prevMoney = player.getMoney();
		
		player.takeTurn(d1, d2);
		
		int newMoney = player.getMoney();
		
		assertEquals(prevMoney+200, newMoney);
	}
	
}

package com.monolopy.domain;

import static org.junit.Assert.*;

import org.junit.Test;

import com.monopoly.domain.Board;
import com.monopoly.domain.DiceBase;
import com.monopoly.domain.Player;
import com.monopoly.domain.Square;

public class WhenMovingPlayers {

	@Test
	public void shouldMoveSpacesAccordingToDiceRoll() {
		Board board = new Board();
		DiceBase dice = new RiggedDice(2, 2);
		Player player = new Player("Cat", board.getSquares().get(38), dice, board);
		
		Square expectedSquare = board.getSquares().get(2);
		
		player.takeTurn();
		assertEquals(player.getLocation(), expectedSquare);
	}
	
	@Test
	public void shouldLoopAroundTheBoard(){
		
	}
	
	@Test
	public void shouldRollDiceWithCorrectDistribution(){
		
	}
	
	@Test
	public void shouldRollAgainIfDoublesRolled(){
		
	}

	@Test
	public void shouldGoToJailWhenLandingOnJail(){
		
	}
	
	@Test
	public void shouldOnlyMoveWhenDoublesAreRolled(){
		
	}
	
	

}

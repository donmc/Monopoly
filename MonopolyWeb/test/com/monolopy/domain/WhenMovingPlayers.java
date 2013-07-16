package com.monolopy.domain;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.monopoly.domain.Board;
import com.monopoly.domain.Dice;
import com.monopoly.domain.DiceBase;
import com.monopoly.domain.Player;
import com.monopoly.domain.Square;

public class WhenMovingPlayers {

	@Test
	public void shouldMoveSpacesAccordingToDiceRoll() {
		Board board = new Board();
		DiceBase dice = new RiggedDice(2, 1);
		Player player = new Player("Cat", board.getStartSquare(), dice, board);
		
		Square expectedSquare = board.getSquares().get(3);
		
		player.takeTurn();
		assertEquals(player.getLocation(), expectedSquare);
	}

	@Test
	public void shouldLoopAroundTheBoard(){
		Board board = new Board();
		DiceBase dice = new RiggedDice(2, 3);
		Player player = new Player("Cat", board.getSquares().get(37), dice, board);
		
		Square expectedSquare = board.getSquares().get(2);
		
		player.takeTurn();
		assertEquals(player.getLocation(), expectedSquare);
	}
	
	/**
	 * The following test presumes that we should not deviate 100 rolls above or below 1000 per digit between 1 and 6.
	 */
	@Test
	public void shouldRollDiceWithCorrectDistribution(){
		int[] distributionCounts = new int[6];
		Dice dice = new Dice();
		for(int i=0;i<6000;i++){
			dice.roll();
			distributionCounts[dice.getD1()-1]++;
		}
		for(int i=0;i<6;i++){
			assertTrue(distributionCounts[0] > 900 && distributionCounts[0] < 1100);
		}
		
		/*
		System.out.println("1:" + distributionCounts[0]);
		System.out.println("2:" + distributionCounts[1]);
		System.out.println("3:" + distributionCounts[2]);
		System.out.println("4:" + distributionCounts[3]);
		System.out.println("5:" + distributionCounts[4]);
		System.out.println("6:" + distributionCounts[5]);
		*/
	}
	
	@Test
	public void shouldRollAgainIfDoublesRolled(){
		Board board = new Board();
		int[][] turns = new int[][]{
				{2, 2},
				{1, 2}
		};
		DiceBase dice = new MultiTurnRiggedDice(turns);
		
		Player player = new Player("Cat", board.getSquares().get(0), dice, board);
		
		Square expectedSquare = board.getSquares().get(7);
		
		player.takeTurn();
		assertEquals(player.getLocation(), expectedSquare);
	}

	@Test
	public void shouldGoToJailWhenLandingOnJail(){
		Board board = new Board();
		DiceBase dice = new RiggedDice(1, 1);
		Player player = new Player("Cat", board.getSquares().get(28), dice, board);
		
		Square expectedSquare = board.getSquares().get(10);
		
		player.takeTurn();
		assertEquals(player.getLocation(), expectedSquare);
	}
	
	@Test
	public void shouldGetOutOfJailWhenRollingDoubles(){
		Board board = new Board();
		int[][] turns = new int[][]{
				{1, 1},
				{2, 2}
		};
		DiceBase dice = new MultiTurnRiggedDice(turns);
		Player player = new Player("Cat", board.getSquares().get(28), dice, board);
		Square expectedSquare = board.getSquares().get(14);
		player.takeTurn();
		//Roll Doubles
		player.takeTurn();
		assertEquals(player.getLocation(), expectedSquare);
	}
	
	@Test
	public void shouldNotGetOutOfJailWhenNoDoublesRolled(){
		Board board = new Board();
		int[][] turns = new int[][]{
				{1, 1},
				{2, 1}
		};
		DiceBase dice = new MultiTurnRiggedDice(turns);
		Player player = new Player("Cat", board.getSquares().get(28), dice, board);
		Square expectedSquare = board.getSquares().get(10);
		player.takeTurn();
		//Roll non-double
		player.takeTurn();
		assertEquals(player.getLocation(), expectedSquare);
	}
	
	@Test
	public void shouldPay50DollarsToGetOutOfJailAfterThirdRoll(){
		Board board = new Board();
		int[][] turns = new int[][]{
				{1, 1},
				{2, 1},
				{4, 3},
				{5, 2}
		};
		DiceBase dice = new MultiTurnRiggedDice(turns);
		Player player = new Player("Cat", board.getSquares().get(28), dice, board);
		player.setMoney(1500);
		player.takeTurn();
		//Roll non-double
		player.takeTurn();
		//Roll non-double
		player.takeTurn();
		//Roll non-double
		player.takeTurn();
		assertEquals(player.getMoney(), 1450);
	}

}

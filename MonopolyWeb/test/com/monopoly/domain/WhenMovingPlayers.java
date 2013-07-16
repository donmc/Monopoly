package com.monopoly.domain;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class WhenMovingPlayers {

	@Test
	public void shouldChangeLocation() {
		Board board = new Board();
		Player player = new Player("Hat", board.getStartSquare());
		
		player.takeTurn(board);
		
		// player should not be in the same location.
		assertFalse(player.getLocation().equals(board.getStartSquare()));
	}
	
	@Test
	public void shouldMoveEachPlayer() {
		Game game = new Game(8);
		game.playRound();
		for (Player player : game.getPlayers())
		{
			assertFalse ("Must not be on go square", game.getPlayers().get(0).getLocation().getName().equals("Go Square"));
		}		
	}
	
	@Test
	// players should be able to traverse the board, passing 'Go' and continue.  we use 40 rolls of dice.
	// verify the loc is between n AND NN
	public void shouldMoveAroundTheBoard() {
		Game game = new Game(8);
		for (int i = 0; i < 41; i++)
		{
			game.playRound();
		}
		for (Player player : game.getPlayers())
		{
			assertNotNull ("Location should be changing around board", player.getLocation());
			assertFalse ("Location should be changing around board", game.getSquares().indexOf(player.getLocation())<0);
		}		
	}
	
	@Test
	public void shouldLoopAroundBoard(){
		Board board = new Board();
		Board.setDie1(new LoadedDie(6));
		Board.setDie2(new LoadedDie(5));
		
		Player player = new Player("Hat", board.getSquares().get(38));
		
		player.takeTurn(board);
		
		assertEquals("Connecticut Ave",player.getLocation().getName());
	}
	
	@Test
	public void shouldHaveProperRollDistribution()
	{
		Game game = new Game(5);
		int[] start = new int[5];
		int[] end = new int[5];
		int[] count = new int[12];
		
		for (int turn=0; turn<200; ++turn)
		{
			getPositions(game,start);
			game.playRound();
			getPositions(game,end);
			for (int player=0; player<5; player++)
			{
				int delta = (start[player]<end[player]) ? end[player]-start[player] : (40- start[player]) + end[player];
				assertTrue ("Location change should be greater than or equal to 2 ", delta>=2);
				assertTrue ("Location change should be less than or equal to 12", delta<=12);
				count[delta]++;
			}
		}
		
		int[] minResults = { 0, 0, 20, 50, 80, 110, 130, 160, 130, 110, 80, 50, 20 };
		int[] maxResults = { 0, 0, 30, 60, 90, 120, 140, 170, 140, 120, 90, 60, 30 };
		for ( int i=2; i<=12; ++i)
		{
			assertTrue ("Min percentage", count[i]>=minResults[i]);
			assertTrue ("Max percentage", count[i]<=maxResults[i]);
		}
	}

	private void getPositions(Game game, int[] list) {
		for (int i=0; i<game.getPlayers().size(); ++i)
		{
			list[i] = game.getSquares().indexOf(game.getPlayers().get(i).getLocation());
		}		
	}
	
}

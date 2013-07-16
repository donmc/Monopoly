package com.monopoly.domain;

import java.util.ArrayList;
import java.util.List;

public class Game {
	private Board board = new Board();
	private int currentPlayer;
	private Die die1, die2;
	private List<Player> players = new ArrayList<Player>();
	private static final String[] TOKENS = {"Horse", "Iron", "Racecar", "Dog", "Top Hat", "Shoe", "Wheelbarrow", "Thimble"};
	
	public Game(int numberOfPlayers) {
		if(numberOfPlayers > TOKENS.length){
			throw new IllegalArgumentException("Too many players!");
		}
		
		if(numberOfPlayers < 2){
			throw new IllegalArgumentException("Too few players!");
		}

		//initialize Die
		die1 = new Die();
		die2 = new Die();

		for (int i = 0; i < numberOfPlayers; i++) {
			Player player = new Player(TOKENS[i], board.getStartSquare());
			players.add(player);
		}
	}
	
	public List<Square> getSquares() {
		return board.getSquares();
	}
	
	public List<Player> getPlayers() {
		return players;
	}

	public void playRound() 
	{
		// TODO Have each players take a turn
		for ( Player player : this.players)
		{
			player.takeTurn(this.die1, this.die2);
		}
	}

	public void setDie1(Die die) {
		this.die1 = die;
	}

	public void setDie2(Die die) {
		this.die2 = die;
		
	}
}

package com.monopoly.domain;

import java.awt.font.NumericShaper;
import java.util.ArrayList;
import java.util.List;

public class Game {
	private Board board = new Board();
	private List<Player> players = new ArrayList<Player>();
	private static final String[] TOKENS = {"Don", "Iron", "Racecar", "Dog", "Top Hat", "Shoe", "Wheelbarrow", "Thimble"};
	private Die die1 = new Die();
	private Die die2 = new Die();
	
	public Game(int numberOfPlayers) {
		if(numberOfPlayers > TOKENS.length) {
			throw new IllegalArgumentException("Too many players!");
		}
		if (numberOfPlayers < 2) {
			throw new IllegalArgumentException("Not enough Players!");
		} 
		
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

	public void playRound() {
		for (Player player : players) {
			player.takeTurn(die1, die2);
		}
	}
	
	
}

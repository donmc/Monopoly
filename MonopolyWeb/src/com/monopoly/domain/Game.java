package com.monopoly.domain;

import java.util.ArrayList;
import java.util.List;

public class Game {
	private Board board = new Board();
	private List<Player> players = new ArrayList<Player>();
	private static final String[] TOKENS = {"Horse", "Iron", "Racecar", "Dog", "Top Hat", "Shoe", "Wheelbarrow", "Thimble"};
	
	public boolean numberValid;
	
	public Game(int numberOfPlayers) {
		if((numberOfPlayers > TOKENS.length) || (numberOfPlayers < 2)) {
			numberValid = false;
			throw new IllegalArgumentException("wrong number of players!");
		}
		
		numberValid = true;
		
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
		// TODO Have each players take a turn
	}
}

package com.monopoly.domain;

import java.util.ArrayList;
import java.util.List;
 
public class Game {
	private Board board = new Board();
	private List<Player> players = new ArrayList<Player>();
	private Die die1 = new Die();
	private Die die2 = new Die();
	private static final String[] TOKENS = {"Horse", "Iron", "Racecar", "Dog", "Top Hat", "Shoe", "Wheelbarrow", "Thimble"};
	
	public Game(int numberOfPlayers) {
		if(numberOfPlayers > TOKENS.length) {
			throw new IllegalArgumentException("Too many players!");
		}

		if(numberOfPlayers < 2) {
			throw new IllegalArgumentException("Too few players!");
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

	public void setDice(Die die1, Die die2) {
		this.die1 = die1;
		this.die2 = die2;
	}
}

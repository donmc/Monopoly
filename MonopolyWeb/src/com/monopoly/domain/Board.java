package com.monopoly.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {

	private List<Square> squares = new ArrayList<Square>();
	private static final String COMMUNITY_CHEST = "Community Chest";
	private static final String CHANCE = "Chance";
	
	private static final String[] SQUARE_NAMES = 
		   {"Go Square",
			"Mediterranean Ave",
			COMMUNITY_CHEST,
			"Baltic Ave",
			"Income Tax",
			"Reading Railroad",
			"Oriental Ave",
			CHANCE,
			"Vermont Ave",
			"Connecticut Ave",
			"Jail",
			"St. Charles Place",
			"Electric Company",
			"States Ave",
			"Virginia Ave",
			"Pennsylvania Railroad",
			"St. James Place",
			COMMUNITY_CHEST,
			"Tennessee Ave",
			"New York Ave",
			"Free Parking",
			"Kentucky Ave",
			CHANCE,
			"Indiana Ave",
			"Illinois Ave",
			"B. & O. Railroad",
			"Atlantic Ave",
			"Ventnor Ave",
			"Water Works",
			"Marvin Gardens",
			"Got to Jail",
			"Pacific Ave",
			"North Carolina Ave",
			COMMUNITY_CHEST,
			"Pennsylvania Ave",
			"Short Line Railroad",
			CHANCE,
			"Park Place",
			"Luxury Tax",
			"Boardwalk"};
	
	public Board() {
		buildSquares();
		linkSquares();
	}

	private void linkSquares() {
		for (int i = 0; i < 40; i++) {
			squares.get(i).setNextSquare(squares.get((i+1)%40));
		}
	}

	private void buildSquares() {
		for (int i = 0; i < 40; i++) {
			switch (i) {
			case 0:
				squares.add(new GoSquare(SQUARE_NAMES[i]));
				break;
				
			case 38:
				squares.add(new LuxuryTaxSquare(SQUARE_NAMES[i]));
				break;
				
			case 4:
				squares.add( new IncomeTaxSquare( SQUARE_NAMES[i] ) );
				break;

			default:
				squares.add(new Square(SQUARE_NAMES[i]));
				break;
			}
		}
	}
	
	public List<Square> getSquares() {
		return squares;
	}

	public Square getStartSquare() {
		return squares.get(0);
	}
	
	public int getSquareIndex( Square loc ) {
		return squares.indexOf(loc);
	}
	
	public Square getSquareAtIndex( int i ) {
		return squares.get(i);
	}
}

package com.monopoly.domain;

import java.util.ArrayList;
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
		for (int i = 0; i < 40; i++) {
			switch (i) {
			case 0:
				squares.add(new Square("Go Square"));
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

	public Square getSquareFromRoll(Square location, DiceBase dice) {

		for(int i=0;i<squares.size();i++){
			if(squares.get(i).equals(location)){
				if(i+dice.getTotal() > squares.size() - 1){
					return squares.get( -(squares.size() - i) + dice.getTotal());
				} else {
					return squares.get(i+dice.getTotal());
				}
			}
		}
		return null;
	}
}

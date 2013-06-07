package com.monopoly.domain;

import java.util.ArrayList;
import java.util.List;

public class Board {

	private List<Square> squares = new ArrayList<Square>();
	
	public Board() {
		for (int i = 0; i < 40; i++) {
			switch (i) {
			case 0:
				squares.add(new Square("Go Square"));
				break;

			default:
				squares.add(new Square("Square" + i));
				break;
			}
		}
	}
	
	public List<Square> getSquares() {
		return squares;
	}
}

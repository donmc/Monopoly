package com.monopoly.domain;

import java.util.ArrayList;
import java.util.List;

import com.monopoly.services.PropertiesDAO;

public class Board {

	private List<Square> squares = new ArrayList<Square>();
	
	private PropertiesDAO properties = new PropertiesDAO();
	
	public Board() {
		for (int i = 0; i < 40; i++) {
			squares.add(new Square(properties.selectPropertyNameFor(i+1)));
		}
		
		for (int i = 0; i < squares.size()-1; i++) {
			Square nextSquare = squares.get(i+1);
			squares.get(i).setNextSquare(nextSquare);
		}
		squares.get(39).setNextSquare(getStartSquare());
	}
	
	public List<Square> getSquares() {
		return squares;
	}

	public Square getStartSquare() {
		return squares.get(0);
	}
}

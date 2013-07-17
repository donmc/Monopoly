package com.monopoly.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.monopoly.persistence.FakeProperties;
import com.monopoly.persistence.Properties;

public class Board {

	private List<Square> squares = new ArrayList<Square>();
	private Properties properties;
	
	public Board() {
		
		try {
			ResourceBundle bundle = ResourceBundle.getBundle("monopoly");
			String className = bundle.getString("properties");
			properties = (Properties)Class.forName(className).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		buildSquares();
		linkSquares();
	}

	private void linkSquares() {
		for (int i = 0; i < squares.size(); i++) {
			squares.get(i).setNextSquare(squares.get((i+1)%40));
		}
	}

	private void buildSquares() {
		for (int i = 0; i < 40; i++) {
			switch (i) { 
			case 0:
				squares.add(new GoSquare(properties.getPropertyNameByPosition(i)));
				break;
			case 4:
				squares.add(new IncomeTaxSquare(properties.getPropertyNameByPosition(i)));
				break;
			case 38:
				squares.add(new LuxuryTaxSquare(properties.getPropertyNameByPosition(i)));
				break;
			default:
				squares.add(new Square(properties.getPropertyNameByPosition(i)));
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
}

package com.monopoly.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.monopoly.persistence.FakeProperties;
import com.monopoly.persistence.Properties;

public class Board {

	private List<Square> squares = new ArrayList<Square>();
	
	private static Die die1;
	private static Die die2;
	
	private Properties properties = new FakeProperties();
	
	public Board() {
		ResourceBundle bundle = ResourceBundle.getBundle("properties");
		String className = bundle.getString("properties");
		try {
			properties = (Properties)Class.forName(className).newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		die1 = new DieImpl();
		die2 = new DieImpl();
		for (int i = 0; i < 40; i++) {
			switch (i) {
			case 0:
				squares.add(new GoSquare("Go Square"));
				break;

			case 4:
				squares.add(new IncomeSquare(properties.getPropertyNameByPosition(i)));
				break;

			case 38:
				squares.add(new LuxSquare(properties.getPropertyNameByPosition(i)));
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
	
	public int roll(){
		int d1 = die1.roll();
		int d2 = die2.roll();
		return d1+d2;
	}
	
	public static void setDie1(Die die1) {
		Board.die1 = die1;
	}
	
	public static void setDie2(Die die2) {
		Board.die2 = die2;
	}
}

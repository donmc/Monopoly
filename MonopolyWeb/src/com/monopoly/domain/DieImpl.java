package com.monopoly.domain;

import java.util.Date;
import java.util.Random;

public class DieImpl implements Die {

	private static Random rand = new Random();
	
	public int roll() {
		return (int)(6.0 * Math.random())+1;
	}

}
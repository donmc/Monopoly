package com.monopoly.domain;

import java.util.Date;
import java.util.Random;

public class DieImpl implements Die {

	public int roll() {
		Random rand = new Random(new Date().getTime());
		return rand.nextInt(5)+1;
	}

}
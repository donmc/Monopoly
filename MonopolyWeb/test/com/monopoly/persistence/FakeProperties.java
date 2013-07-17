package com.monopoly.persistence;

import com.monopoly.domain.Die;

public class FakeProperties implements Properties {
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
	
	@Override
	public String getPropertyNameByPosition(int position) {
		return SQUARE_NAMES[position];
	}

	@Override
	public String selectAllPropertyNames(int position) {
		// TODO Auto-generated method stub
		return null;
	}

}

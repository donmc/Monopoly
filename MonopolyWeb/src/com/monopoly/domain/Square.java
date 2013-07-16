package com.monopoly.domain;

public class Square {

	private String name;
	
	public Square(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void landedOn(Player player)
	{
		if (name.equals("Luxury Tax"))
		{
			player.decrementMoney(75);
		} else if (name.equals("Income Tax"))
		{
			int taxPercent = (int) ((int) player.getMoney() * .10);
			if (taxPercent < 200)
			{
				player.decrementMoney(taxPercent);
			}
			else
			{
				player.decrementMoney(200);
			}
		}
	}
}

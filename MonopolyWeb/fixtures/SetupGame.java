import com.monopoly.domain.Game;

import fit.ColumnFixture;


public class SetupGame extends ColumnFixture {
	
	public int players;
	private Game game;

	public boolean success() {
		game = new Game(players);
		return true;
	}

	public int numberOfPlayers() {
		return game.getPlayers().size();
	}
	
	public String position() {
		return game.getPlayers().get(0).getLocation().getName();
	}
	
	public int money() {
		return game.getPlayers().get(0).getMoney();
	}

}

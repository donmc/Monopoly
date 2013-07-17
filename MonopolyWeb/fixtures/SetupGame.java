import com.monopoly.domain.Game;
import com.monopoly.domain.Player;

import fit.ColumnFixture;

public class SetupGame extends ColumnFixture {

	public int players;
	private Game game;
	
	
	
	public boolean success() {
		game = new Game(players);
		return true;
	}
	
	public int numberOfPlayers () {
		return game.getPlayers().size();
	}
	
	public String Position() {
		return game.getPlayers().get(0).getLocation().getName();
	}
	
	public int Money() {
		return game.getPlayers().get(0).getMoney();
	}
}

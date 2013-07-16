import com.monopoly.domain.FakeDie;
import com.monopoly.domain.Game;

import fit.ColumnFixture;


public class MovePlayer extends ColumnFixture {

	public int die1Roll;
	public int die2Roll;
	private Game game;

	public MovePlayer() {
		super();
		game = new Game(2);
	}
	
	

	public boolean success() {
		game.setDice(new FakeDie(die1Roll), new FakeDie(die2Roll));
		game.playRound();
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

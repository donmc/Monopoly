import com.monopoly.domain.Board;
import com.monopoly.domain.Game;
import com.monopoly.domain.LoadedDie;

import fit.ColumnFixture;


public class MovePlayer extends ColumnFixture {
	public int die1Roll;
	public int die2Roll;
	
	private Game game = new Game(2);
		
	public boolean success() {
		
		Board.setDie1(new LoadedDie(die1Roll));
		Board.setDie2(new LoadedDie(die2Roll));
		game.playRound();
		return false;	
	}
	public String position() {
		return game.getPlayers().get(0).getLocation().getName();
	}
	public int money() {
		return game.getPlayers().get(0).getMoney();
	}
}

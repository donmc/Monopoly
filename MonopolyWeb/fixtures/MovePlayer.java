
import com.monopoly.domain.Board;
import com.monopoly.domain.Die;
import com.monopoly.domain.Game;
import com.monopoly.domain.LoadedDie;
import com.monopoly.domain.Player;

import fit.ColumnFixture;

public class MovePlayer extends ColumnFixture {

	public int players = 2;
	private Game game;
	private Player player;

	
	public int Die1Roll;
	public int Die2Roll;

	public MovePlayer(){
		game = new Game (players);
	}	

	public boolean success() {
		return true;
	}
	
	public String position() {
		LoadedDie die1 = new LoadedDie();
		LoadedDie die2 = new LoadedDie();
		
		die1.fakedRoll(Die1Roll);
		die2.fakedRoll(Die2Roll);
		player = game.getPlayers().get(0);
		player.takeTurn(die1, die2);
		return player.getLocation().getName();
	}
	
	public int money() {
		return player.getMoney();
	}
}

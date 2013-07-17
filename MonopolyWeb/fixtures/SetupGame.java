import com.monopoly.domain.Game;

import fit.ColumnFixture;


public class SetupGame extends ColumnFixture {
	public int players = 0;
	private Game game;
	
	public boolean Success(){
		try {
			game = new Game(players);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public int number(){
		return game.getPlayers().size();
	}
	
	public String position(){
		return game.getPlayers().get(0).getLocation().getName();
	}
	
	public int money(){
		return  game.getPlayers().get(0).getMoney();
	}

}

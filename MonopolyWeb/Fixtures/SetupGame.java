import static org.junit.Assert.assertEquals;

import java.util.Hashtable;

import com.monopoly.domain.Game;
import com.monopoly.domain.Player;

import fit.ColumnFixture;


public class SetupGame extends ColumnFixture {

	public int players;
	private Game game;

	public boolean success()
	{
		try {
			game = new Game(players);
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
	}
	
	public int numberOfPlayers() 
	{
		return game.getPlayers().size();
	}
	
	public String position()
	{
		Hashtable<String,String> table = new Hashtable<String,String>();
		String key="unset";
		for (Player player : game.getPlayers())
		{
			key = player.getLocation().getName();
			table.put(key, player.toString());
		}
		
		return (table.size()==1) ? key : table.toString();
	}
	
	public String money()
	{
		Hashtable<Integer,String> table = new Hashtable<Integer,String>();
		int key=0;
		for (Player player : game.getPlayers())
		{
			key = player.getMoney();
			table.put(key, player.toString());
		}
		
		return (table.size()==1) ? ""+key : table.toString();
	}
}

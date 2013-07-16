import fit.ColumnFixture;

import com.monopoly.domain.*;

public class SetupGame extends ColumnFixture 
{
  public int players;
  private Game game;
  
  public int numberOfPlayers() {
	  return game.getPlayers().size();
  }
  
  public String position()
  {
	  return game.getPlayers().get(0).getLocation().getName();
  }

  public int money()
  {
	  return game.getPlayers().get(0).getMoney();
  }

  public boolean success()
  {
	  try 
	  {
		  game = new Game(players);
		  return true;		  
	  }
	  catch (Exception e)
	  {
		  return false;
	  }
  }
}
 
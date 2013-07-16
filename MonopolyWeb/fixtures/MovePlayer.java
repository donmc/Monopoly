import com.monopoly.domain.Game;
import com.monopoly.domain.MockDie;

import fit.ColumnFixture;


public class MovePlayer extends ColumnFixture {

	public Game game = new Game(2);
	public int die1;
	public int die2;
	public MockDie mockDie1 = new MockDie();
	public MockDie mockDie2 = new MockDie();
	
	public boolean success()
	{
	  try 
	  {
		  mockDie1.diceRollValue = die1;
		  mockDie2.diceRollValue = die2;
		  game.setDie1(mockDie1);
		  game.setDie2(mockDie2);
		  game.playRound();
		  return true;		  
	  }
	  catch (Exception e)
	  {
		  return false;
	  }
	}
	
	  public String position()
	  {
		  return game.getPlayers().get(0).getLocation().getName();
	  }

	  public int money()
	  {
		  return game.getPlayers().get(0).getMoney();
	  }

	
}

import com.monopoly.domain.Board;
import com.monopoly.domain.Player;
import com.monopoly.domain.TestDice;

import fit.ColumnFixture;


public class MovePlayer extends ColumnFixture {
	public int dieOne = 0;
	public int dieTwo = 0;
	private Board b;
	private Player p;
	
	public MovePlayer(){
		b = new Board();
		p = new Player("Token",b.getStartSquare());
	}
	
	public boolean success(){
		p.takeTurn(b, new TestDice(dieOne), new TestDice(dieTwo));
		return true;
	}
	
	public String position(){
		return p.getLocation().getName();
	}
	
	public int money() {
		return p.getMoney();
	}

}

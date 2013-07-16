import static org.junit.Assert.*;

import org.junit.Test;

import com.monopoly.domain.Game;


public class WhenStartingAGame {

	@Test
	public void correctNumberOfPlayers() {
		for ( int num = 2; num< 6; num++) {
			Game game = new Game(num);
			assertEquals(num,game.getPlayers().size());
		}
	}

	@Test(expected=IllegalArgumentException.class)
	public void tooManyPlayers() {
		new Game(10);
	}
	
	@Test
	public void tooFewPlayers() {
		try {
			new Game(0);
			new Game(1);
			fail("not enough players");
		}
		catch (Exception e) {
		}
	}
}

package com.monopoly.domain;
import static org.junit.Assert.*;

import org.junit.Test;

import com.monopoly.domain.Game;


public class GameTest {

	@Test
	public void testGameInitialization() {
		try {
			Game game = new Game(1);
			fail("this should not work");
		} catch (Exception ex) {
			ex.getMessage();

		}
		try {
			Game game = new Game(9);
			fail("this should not work");
		} catch (Exception ex) {
			ex.getMessage();

		}
	}

}

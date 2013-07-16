package com.monopoly.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class WhenRollingDie {

	@Test
	public void shouldBeLessThan7() {
		Die die = new Die();
		assertTrue(die.getValue() < 7);
	}

	@Test
	public void shouldBeMoreThan0() {
		Die die = new Die();
		assertTrue(die.getValue() > 0);
	}
}

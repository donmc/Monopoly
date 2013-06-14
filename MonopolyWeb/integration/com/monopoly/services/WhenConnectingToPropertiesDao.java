package com.monopoly.services;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WhenConnectingToPropertiesDao {

	private PropertiesDAO propDao;

	@Before
	public void setUp() throws Exception {
		propDao = new PropertiesDAO();
	}

	@Test
	public void shouldReadAPropertyNameByPosition() {
		String propName = propDao.selectPropertyNameFor(40);
		assertEquals("Boardwalk", propName);
;	}
}

package com.monopoly.persistence;
import static org.junit.Assert.*;
import org.junit.Test;


public class WhenConnectingToProperties {

	@Test
	public void shouldRetrieveAPropertyNameByPosition() {
		PropertiesDAO dao = new PropertiesDAO();
		String propertyName = dao.getPropertyNameByPosition(4);
		assertEquals ("Baltic Ave",propertyName); 

	}
	
}

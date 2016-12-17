package it.unifi.selfbar;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.unifi.selfbar.client.*;
import it.unifi.selfbar.order.*;

public class TableTest {

	private Table table;

	@Before
	public void init() {
		table = new SelfBarTable();
	}

	
	@Test
	public void addOrderTest() {
		table.addOrder(new Martini());
		table.addOrder(new Martini());
		int expected = 2;
		assertEquals(expected, table.getBill().getListOrders().size());
	}

 

	@Test
	public void removeOrderWithReferenceTest() {
		Order o = new Martini();
		table.addOrder(o);
		assertTrue(table.removeOrder(o));
		assertFalse(table.removeOrder(o));// già rimosso
	}

}

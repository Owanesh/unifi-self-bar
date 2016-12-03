package it.unifi.selfbar;

import static org.junit.Assert.*;
import static it.unifi.selfbar.constant.Constants.*;
import org.junit.Before;
import org.junit.Test;

import it.unifi.selfbar.client.Bill;
import it.unifi.selfbar.decorator.*;
import it.unifi.selfbar.product.*;

public class BillTest {
	Bill bill;

	@Before
	public void init() {
		bill = new Bill();
	}

	@Test
	public void getTotalTest() {
		bill.addOrder(new Milk(new Milk(new Arabic())));
		bill.addOrder(new Martini());
		bill.addOrder(new Soda(new Martini()));
		double expected = ARABIC_VALUE + MILK_VALUE * 2 + MARTINI_VALUE + SODA_VALUE + MARTINI_VALUE;
		assertEquals(expected, bill.getTotal(), 0.001);

	}

	@Test
	public void negativeTotalTest() {
		assertTrue(bill.getTotal() >= 0);
	}

}

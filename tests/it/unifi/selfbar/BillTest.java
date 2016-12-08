package it.unifi.selfbar;

import static org.junit.Assert.*;
import static it.unifi.selfbar.constant.Constants.*;
import org.junit.Before;
import org.junit.Test;

import it.unifi.selfbar.bill.Bill;
import it.unifi.selfbar.client.SelfBarBill;
import it.unifi.selfbar.order.*;
import it.unifi.selfbar.order.decorator.Milk;
import it.unifi.selfbar.order.decorator.Soda;

public class BillTest {
	Bill bill;

	@Before
	public void init() {
		bill = new SelfBarBill();
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
		bill.addOrder(new Milk(new Milk(new Arabic())));
		assertTrue(bill.getTotal() >= 0);
	}

	@Test
	public void addOrderTest() {
		bill.addOrder(new Arabic());
		assertEquals(1, bill.getListOrders().size());
		bill.addOrder(new Soda(new Martini()));
		assertEquals(2, bill.getListOrders().size());
	}

}

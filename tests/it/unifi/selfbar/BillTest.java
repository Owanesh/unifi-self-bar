package it.unifi.selfbar;

import static org.junit.Assert.*;

import org.junit.Test;

import it.unifi.selfbar.client.Bill;
import it.unifi.selfbar.client.Table;
import it.unifi.selfbar.decorator.Milk;
import it.unifi.selfbar.exception.OrderNotDecorableException;
import it.unifi.selfbar.product.Arabic;
import it.unifi.selfbar.product.Order;

public class BillTest {

	@Test
	public void negativeTotal() {
		Bill bill = new Bill();
		assertTrue(bill.getTotal() >= 0);
	}

}

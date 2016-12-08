package it.unifi.selfbar;

import static it.unifi.selfbar.constant.Constants.*;
import static org.junit.Assert.*;

import org.junit.Test;

import it.unifi.selfbar.bill.AbsoluteDiscount;
import it.unifi.selfbar.bill.Bill;
import it.unifi.selfbar.bill.NightDiscount;
import it.unifi.selfbar.client.SelfBarBill;
import it.unifi.selfbar.order.Arabic;
import it.unifi.selfbar.order.decorator.Milk;

public class DiscountTest {

	private Bill bill;
	private double percentage = 0.1;
	private double amount = 1;

	@Test
	public void getDiscountTest() {
		bill = new NightDiscount(new SelfBarBill(), percentage);
		bill.addOrder(new Milk(new Milk(new Arabic())));
		try {
			Bill b = bill.getDiscount();
			double expected = ARABIC_VALUE + MILK_VALUE * 2;
			assertEquals(expected, b.getTotal(), 0.001);
		} catch (Exception e) {
		}
	}

	@Test
	public void getTotalTest() {
		bill = new NightDiscount(new AbsoluteDiscount(new SelfBarBill(), amount), percentage);
		bill.addOrder(new Milk(new Milk(new Arabic())));
		double expected = ARABIC_VALUE + MILK_VALUE * 2;
		expected -= amount;
		expected -= expected * percentage;
		assertEquals(expected, bill.getTotal(), 0.001);
	}

	@Test
	public void negativeTotalTest() {
		bill = new NightDiscount(new SelfBarBill(), percentage);
		bill.addOrder(new Milk(new Milk(new Arabic())));
		double expected = ARABIC_VALUE + MILK_VALUE * 2;
		expected -= expected * percentage;
		assertTrue(bill.getTotal() >= 0);
	}

}

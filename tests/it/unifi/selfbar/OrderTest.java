package it.unifi.selfbar;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import it.unifi.selfbar.constant.Constants;
import it.unifi.selfbar.exception.OrderNotDecorableException;
import it.unifi.selfbar.order.*;
import it.unifi.selfbar.order.decorator.*;

public class OrderTest {
	@Rule
	public final ExpectedException exception = ExpectedException.none();

	@Test
	public void getPriceTest() {
		Order soda = new Soda(new Martini());
		double expected = Constants.MARTINI_VALUE + Constants.SODA_VALUE;
		assertEquals(expected, soda.getPrice(), 0.001);
	}

	@Test
	public void getOrderTest() {
		Order soda = new Soda(new Martini());
		try {
			Order martini = soda.getOrder();
			assertEquals(martini.getClass(), Martini.class);
		} catch (OrderNotDecorableException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void getOrderExceptionTest() throws OrderNotDecorableException {
		exception.expect(OrderNotDecorableException.class);
		Martini m = new Martini();
		m.getOrder();
	}

	@Test
	public void nullArgumentExceptionTest() throws IllegalArgumentException {
		exception.expect(IllegalArgumentException.class);
		Soda m = new Soda(null);
	}

	@Test
	public void equalsSimpleTest() {
		Order arabic = new Arabic();
		Order brasilian = new Brasilian();
		assertFalse(arabic.equals(brasilian));

		Order arabic1 = new Arabic();
		assertTrue(arabic.equals(arabic1));
	}

	@Test
	public void equalsDifferentDecorationTest() {
		Order martini = new Appetizer(new Martini());
		Order martini2 = new Soda(new Martini());
		assertFalse(martini.equals(martini2));
	}

	@Test
	public void equalsSameDecorationTest() {
		Order martini = new Soda(new Martini());
		Order martini2 = new Soda(new Martini());
		assertTrue(martini.equals(martini2));
	}

	@Test
	public void equalsCombinationDecorationTest() {
		Order martini = new Appetizer(new Soda(new Martini()));
		Order martini2 = new Soda(new Appetizer(new Martini()));
		assertFalse(martini.equals(martini2));
		
		Order arabic = new Cream(new Arabic());
		Order brasilian = new Cream(new Brasilian());
		assertFalse(arabic.equals(brasilian));
	}

}

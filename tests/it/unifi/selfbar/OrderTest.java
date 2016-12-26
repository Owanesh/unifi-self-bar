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
		double expected = 3.5;
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

 

 

	 
 

}

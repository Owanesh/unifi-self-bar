package it.unifi.selfbar;

import static org.junit.Assert.*;

import org.junit.Test;

import it.unifi.selfbar.constant.Constants;
import it.unifi.selfbar.decorator.*;
import it.unifi.selfbar.product.*;

public class OrderTest {

	@Test
	public void getPriceTest() {
		Order martini = new Martini();
		Order soda = new Soda((Martini) martini);
		double expected = Constants.MARTINI_VALUE + Constants.SODA_VALUE;
		assertEquals(expected, soda.getPrice(), 0.001);
	}

}

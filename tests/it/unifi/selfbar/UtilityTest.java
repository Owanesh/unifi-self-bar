package it.unifi.selfbar;

import static org.junit.Assert.*;

import org.junit.Test;

import it.unifi.selfbar.constant.Utility;

public class UtilityTest {

	@Test
	public void roundTest() {
		double expected1 = 1.50;
		double expected2 = 1.51;
		assertEquals(expected1, Utility.round(1.504, 2), 0.001);// difetto
		assertEquals(expected2, Utility.round(1.506, 2), 0.001);// eccesso
	}

}

package it.unifi.selfbar.constant;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Utility {
	public static <T> T checkNull(String message, T object) {
		if (object == null) {
			throw new IllegalArgumentException(message);
		}
		return object;
	}

	public static double round(double value, int places) {
		if (places < 0)
			throw new IllegalArgumentException();

		BigDecimal bd = new BigDecimal(value);
		bd = bd.setScale(places, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}
}

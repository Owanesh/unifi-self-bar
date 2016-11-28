package it.unifi.selfbar.constant;

public class Utility {
	public static <T> T checkNull(String message, T object) {
		if (object == null) {
			throw new NullPointerException(message);
		}
		return object;
	}

	public static double roundTwoDecimalDigits(double x) {
		x = Math.ceil(x * 100);
		x = x / 100;
		return x;
	}
}

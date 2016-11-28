package it.unifi.selfbar.constant;

public class Utility {
	public static <T> T checkNull(String message, T object) {
		if (object == null) {
			throw new NullPointerException(message);
		}
		return object;
	}
}

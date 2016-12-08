package it.unifi.selfbar.order;

import it.unifi.selfbar.exception.OrderNotDecorableException;

/**
 * @author Busiello & Mauro
 */
public abstract class Order {

	protected double price;

	public double getPrice() {
		return price;
	}
	
	public double getSimplePrice() {
		return price;
	}

	public abstract Order getOrder() throws OrderNotDecorableException;

	@Override
	public String toString() {
		try {
			return getOrder().toString() + "\n    SUPPLEMENT-> " + getClass().getSimpleName() + ": price="
					+ String.format("%.2f", getPrice());
		} catch (OrderNotDecorableException e) {
			return "\n" + getClass().getSimpleName() + ": price=" + String.format("%.2f", getPrice());
		}

	}

}
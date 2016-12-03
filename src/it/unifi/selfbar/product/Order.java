package it.unifi.selfbar.product;

import it.unifi.selfbar.exception.OrderNotDecorableException;

/**
 * @author Busiello & Mauro
 */
public abstract class Order {

	protected double price;

	public double getPrice() {
		return price;
	}

	public abstract Order getOrder() throws OrderNotDecorableException;

}
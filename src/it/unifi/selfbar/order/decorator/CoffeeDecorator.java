package it.unifi.selfbar.order.decorator;

import it.unifi.selfbar.order.*;

/**
 * @author Busiello & Mauro
 */
public abstract class CoffeeDecorator extends Coffee {

	private Order order;

	public CoffeeDecorator(Coffee coffee) throws IllegalArgumentException {
		if (coffee == null)
			throw new IllegalArgumentException("Argument must not be null.");
		order = coffee;
	}

	@Override
	public Order getOrder() {
		return order;
	}

	@Override
	public double getPrice() {
		return super.getPrice() + order.getPrice();
	}

}
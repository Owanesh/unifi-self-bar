package it.unifi.selfbar.decorator;

import it.unifi.selfbar.product.*;

/**
 * @author Busiello & Mauro
 */
public abstract class OrderDecorator extends Order {

	private Order order;

	public OrderDecorator(Order order) throws IllegalArgumentException {
		if (order == null)
			throw new IllegalArgumentException("Argument must not be null.");
		this.order = order;
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
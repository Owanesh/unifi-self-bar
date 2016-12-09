package it.unifi.selfbar.order.decorator;

import it.unifi.selfbar.order.*;

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
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		// verifico che siano esattamente lo stesso prodotto
		// delego ad ogni sottoclasse tale compito
		if (!checkSameType(obj)) {
			return false;
		}
		OrderDecorator other = (OrderDecorator) obj;
		return order.equals(other.getOrder());

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
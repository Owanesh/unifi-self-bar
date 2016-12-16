package it.unifi.selfbar.order.decorator;

import it.unifi.selfbar.exception.ErrorMessages;
import it.unifi.selfbar.order.*;

/**
 * @author Busiello & Mauro
 */
public abstract class CoffeeDecorator extends Coffee {

	private Order order;

	public CoffeeDecorator(Coffee coffee) throws IllegalArgumentException {
		if (coffee == null)
			throw new IllegalArgumentException(ErrorMessages.ARGUMENT_MUST_NOT_BE_NULL);
		order = coffee;
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
		CoffeeDecorator other = (CoffeeDecorator) obj;
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
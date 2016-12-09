package it.unifi.selfbar.order;

import it.unifi.selfbar.constant.Constants;
import it.unifi.selfbar.exception.OrderNotDecorableException;
import it.unifi.selfbar.order.decorator.OrderDecorator;

public class Brasilian extends Coffee {

	public Brasilian() {
		setPrice(Constants.BRASILIAN_VALUE);
	}

	@Override
	public Order getOrder() throws OrderNotDecorableException {
		throw new OrderNotDecorableException("This order is not a decorator.");
	}

	@Override
	protected boolean checkSameType(Object obj) {
		return obj instanceof Brasilian;
	}

}
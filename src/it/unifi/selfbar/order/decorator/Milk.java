package it.unifi.selfbar.order.decorator;

import it.unifi.selfbar.constant.Constants;
import it.unifi.selfbar.order.Coffee;

/**
 * @author Busiello & Mauro
 */
public class Milk extends CoffeeDecorator {

	public Milk(Coffee coffee) throws IllegalArgumentException {
		super(coffee);
		setPrice(Constants.MILK_VALUE);
	}

	@Override
	protected boolean checkSameType(Object obj) {
		return obj instanceof Milk;
	}
}
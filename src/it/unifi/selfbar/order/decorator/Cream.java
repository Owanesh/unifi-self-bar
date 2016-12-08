package it.unifi.selfbar.order.decorator;

import it.unifi.selfbar.constant.Constants;
import it.unifi.selfbar.order.Coffee;

/**
 * @author Busiello & Mauro
 */
public class Cream extends CoffeeDecorator {

	public Cream(Coffee coffee) throws IllegalArgumentException {
		super(coffee);
		price = Constants.CREAM_VALUE;
	}

}
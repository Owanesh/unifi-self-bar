package it.unifi.selfbar.decorator;

import it.unifi.selfbar.constant.Constants;
import it.unifi.selfbar.product.Coffee;

/**
 * @author Busiello & Mauro
 */
public class Milk extends CoffeeDecorator {

	public Milk(Coffee coffee) throws IllegalArgumentException {
		super(coffee);
		price = Constants.MILK_VALUE;
	}

}
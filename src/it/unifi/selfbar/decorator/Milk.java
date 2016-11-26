package it.unifi.selfbar.decorator;

import it.unifi.selfbar.constant.Constants;
import it.unifi.selfbar.product.Coffee;

public class Milk extends CoffeeDecorator {

	public Milk(Coffee coffee) {
		super(coffee);
		price = Constants.MILK_VALUE;
	}

}

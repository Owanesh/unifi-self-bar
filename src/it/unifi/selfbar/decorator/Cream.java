package it.unifi.selfbar.decorator;

import it.unifi.selfbar.constant.Constants;
import it.unifi.selfbar.product.Coffee;

public class Cream extends CoffeeDecorator {

	public Cream(Coffee coffee) {
		super(coffee);
		price = Constants.CREAM_VALUE;
	}

	
}

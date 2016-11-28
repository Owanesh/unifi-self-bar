package it.unifi.selfbar.decorator;

import it.unifi.selfbar.constant.Utility;
import it.unifi.selfbar.product.Coffee;

public abstract class CoffeeDecorator extends Coffee {
	private Coffee coffee;

	public CoffeeDecorator(Coffee coffee) {
		Utility.checkNull("Argument can't be null.", coffee);
		this.coffee = coffee;
	}

	@Override
	public double getTotalPrice() {
		// coffee price calculate recursively with getTotalPrice()
		return coffee.getTotalPrice() + this.price;
	}

	@Override
	public String toString() {
		return coffee.toString() + "\n   SUPPLEMENT->" + getClass().getSimpleName() + " [price=" + getSimplePrice()
				+ "]";
	}

}

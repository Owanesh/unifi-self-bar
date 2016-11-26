package it.unifi.selfbar.decorator;

import it.unifi.selfbar.product.Coffee;

public abstract class CoffeeDecorator extends Coffee {
	private Coffee coffee;

	public CoffeeDecorator(Coffee coffee) {
		this.coffee = coffee;
	}

	@Override
	public double getPrice() {
		return coffee.getPrice() + this.price;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [price=" + getPrice() + "]";
	}

}

package it.unifi.selfbar.decorator;

import it.unifi.selfbar.product.*;

/**
 * @author Busiello & Mauro
 */
public abstract class CocktailDecorator extends Cocktail {

	private Order order;

	public CocktailDecorator(Cocktail cocktail) throws IllegalArgumentException {
		if (cocktail == null)
			throw new IllegalArgumentException("Argument must not be null.");
		order = cocktail;
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
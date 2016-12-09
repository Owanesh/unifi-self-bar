package it.unifi.selfbar.order.decorator;

import it.unifi.selfbar.order.*;

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
		CocktailDecorator other = (CocktailDecorator) obj;
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
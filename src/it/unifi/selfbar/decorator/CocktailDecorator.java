package it.unifi.selfbar.decorator;

import it.unifi.selfbar.product.*;

public abstract class CocktailDecorator extends Cocktail {
	private Cocktail cocktail;

	public CocktailDecorator(Cocktail cocktail) {
		this.cocktail = cocktail;
	}

	@Override
	public double getPrice() {
		return cocktail.getPrice() + this.price;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [price=" + getPrice() + "]";
	}
}

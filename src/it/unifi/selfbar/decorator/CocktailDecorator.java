package it.unifi.selfbar.decorator;

import it.unifi.selfbar.constant.Utility;
import it.unifi.selfbar.product.*;

public abstract class CocktailDecorator extends Cocktail {
	private Cocktail cocktail;

	public CocktailDecorator(Cocktail cocktail) {
		Utility.checkNull("Argument can't be null.", cocktail);
		this.cocktail = cocktail;
	}

	@Override
	public double getTotalPrice() {
		// cocktail price calculate recursively with getTotalPrice()
		return cocktail.getTotalPrice() + this.price;
	}

	@Override
	public String toString() {
		return cocktail.toString() + "\n   SUPPLEMENT->" + getClass().getSimpleName() + " [price=" + getSimplePrice()
				+ "]";
	}
}

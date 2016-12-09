package it.unifi.selfbar.order.decorator;

import it.unifi.selfbar.constant.Constants;
import it.unifi.selfbar.order.Cocktail;

/**
 * @author Busiello & Mauro
 */
public class Soda extends CocktailDecorator {

	public Soda(Cocktail cocktail) throws IllegalArgumentException {
		super(cocktail);
		setPrice(Constants.SODA_VALUE);
	}

	@Override
	protected boolean checkSameType(Object obj) {
		return obj instanceof Soda;
	}
}
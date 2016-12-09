package it.unifi.selfbar.order.decorator;

import it.unifi.selfbar.constant.Constants;
import it.unifi.selfbar.order.Cocktail;

/**
 * @author Busiello & Mauro
 */
public class Appetizer extends CocktailDecorator {

	public Appetizer(Cocktail cocktail) throws IllegalArgumentException {
		super(cocktail);
		setPrice(Constants.APPETIZER_VALUE);
	}

	@Override
	protected boolean checkSameType(Object obj) {
		return obj instanceof Appetizer;
	}

}
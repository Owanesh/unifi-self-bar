package it.unifi.selfbar.decorator;

import it.unifi.selfbar.constant.Constants;
import it.unifi.selfbar.product.Cocktail;

/**
 * @author Busiello & Mauro
 */
public class Appetizer extends CocktailDecorator {

	public Appetizer(Cocktail cocktail) throws IllegalArgumentException {
		super(cocktail);
		price = Constants.APPETIZER_VALUE;
	}

}
package it.unifi.selfbar.decorator;

import it.unifi.selfbar.constant.Constants;
import it.unifi.selfbar.product.Cocktail;

/**
 * @author Busiello & Mauro
 */
public class Soda extends CocktailDecorator {

	public Soda(Cocktail cocktail) throws IllegalArgumentException {
		super(cocktail);
		price = Constants.SODA_VALUE;
	}

}
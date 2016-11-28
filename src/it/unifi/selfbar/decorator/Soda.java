package it.unifi.selfbar.decorator;

import it.unifi.selfbar.constant.Constants;
import it.unifi.selfbar.product.Cocktail;

public class Soda extends CocktailDecorator {

	public Soda(Cocktail cocktail) {
		super(cocktail);
		price = Constants.SODA_VALUE;
	}


}

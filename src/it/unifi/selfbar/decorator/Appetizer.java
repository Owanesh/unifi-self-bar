package it.unifi.selfbar.decorator;

import it.unifi.selfbar.constant.Constants;
import it.unifi.selfbar.product.Cocktail;

public class Appetizer extends CocktailDecorator {

	public Appetizer(Cocktail cocktail) {
		super(cocktail);
		price = Constants.APPETIZER_VALUE;
	}

	

}

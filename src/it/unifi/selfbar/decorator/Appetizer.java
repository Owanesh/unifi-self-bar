package it.unifi.selfbar.decorator;

import java.util.*;

import it.unifi.selfbar.exception.OrderNotDecoratedException;
import it.unifi.selfbar.product.Cocktail;

/**
 * @author Busiello & Mauro
 */
public class Appetizer extends CocktailDecorator {

	public Appetizer(Cocktail cocktail) throws IllegalArgumentException {
 		super(cocktail);
	}

}
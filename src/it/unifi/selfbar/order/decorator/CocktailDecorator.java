package it.unifi.selfbar.order.decorator;

import it.unifi.selfbar.exception.ErrorMessages;
import it.unifi.selfbar.order.*;

/**
 * @author Busiello & Mauro
 */
public abstract class CocktailDecorator extends AbstractDecorator implements Cocktail {

 
	private Order order;

	public CocktailDecorator(Cocktail cocktail) throws IllegalArgumentException {
		if (cocktail == null)
			throw new IllegalArgumentException(ErrorMessages.ARGUMENT_MUST_NOT_BE_NULL);
		order = cocktail;
 	}
	
}
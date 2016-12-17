package it.unifi.selfbar.order.decorator;

import it.unifi.selfbar.order.*;

/**
 * @author Busiello & Mauro
 */
public abstract class CocktailDecorator extends AbstractDecorator implements Cocktail {

	public CocktailDecorator(Cocktail cocktail){
		super(cocktail);
	}
	
}
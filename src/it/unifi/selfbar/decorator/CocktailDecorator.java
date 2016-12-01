package it.unifi.selfbar.decorator;

import java.util.*;
import it.unifi.selfbar.product.*;

/**
 * @author Busiello & Mauro
 */
public abstract class CocktailDecorator extends Cocktail {

	private Order order;

	public CocktailDecorator(Cocktail cocktail) throws IllegalArgumentException {
		// TODplement here
	}
 
	public Order getOrder() {
		return order;	
	}	
	
	@Override
	public double getPrice(){
		return this.getPrice()+order.getPrice();
	}

}
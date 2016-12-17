package it.unifi.selfbar.order.decorator;

import it.unifi.selfbar.order.*;

/**
 * @author Busiello & Mauro
 */
public abstract class CoffeeDecorator extends  AbstractDecorator implements Coffee {
	public CoffeeDecorator(Coffee coffee){
		super(coffee);
	}

}
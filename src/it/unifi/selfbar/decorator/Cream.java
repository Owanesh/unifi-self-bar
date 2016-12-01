package it.unifi.selfbar.decorator;

import java.util.*;

import it.unifi.selfbar.product.Coffee;

/**
 * @author Busiello & Mauro
 */
public class Cream extends CoffeeDecorator {

 
	public Cream(Coffee coffee) {
		super(coffee);
	}

}
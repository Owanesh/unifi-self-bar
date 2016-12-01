package it.unifi.selfbar.decorator;

import java.util.*;

import it.unifi.selfbar.product.Coffee;

/**
 * @author Busiello & Mauro
 */
public class Milk extends CoffeeDecorator {

 
	public  Milk(Coffee coffee) {
		super(coffee);
	}


	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return 0;
	}

}
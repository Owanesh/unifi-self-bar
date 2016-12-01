package it.unifi.selfbar.decorator;

import java.util.*;

import it.unifi.selfbar.product.*;

/**
 * @author Busiello & Mauro
 */
public abstract class CoffeeDecorator extends Coffee {


	private Order order;


	public  CoffeeDecorator(Coffee coffee) throws IllegalArgumentException {
	}


	public Order getOrder() {
		return order;
	}

	@Override
	public double getPrice(){
		return this.getPrice()+order.getPrice();
	}

}
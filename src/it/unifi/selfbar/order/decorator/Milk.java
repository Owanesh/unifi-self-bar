package it.unifi.selfbar.order.decorator;

import it.unifi.selfbar.constant.Constants;
import it.unifi.selfbar.order.Coffee;

/**
 * @author Busiello & Mauro
 */
public class Milk extends CoffeeDecorator {
	
	public Milk(Coffee milk) throws IllegalArgumentException {
		super(milk);
 	}
	
	@Override
	public double getPrice(){
		return super.getPrice()+getSimplePrice();
	}
	
	@Override
	public double getSimplePrice(){
		return Constants.MILK_VALUE;
	}
}
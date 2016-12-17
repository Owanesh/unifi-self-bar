package it.unifi.selfbar.order.decorator;

import it.unifi.selfbar.constant.Constants;
import it.unifi.selfbar.order.Coffee;
import it.unifi.selfbar.order.Order;

/**
 * @author Busiello & Mauro
 */
public class Ice extends AbstractDecorator implements Order {


	public Ice(Order order) throws IllegalArgumentException {
		super(order);
 	}
	
	@Override
	public double getPrice(){
		return super.getPrice()+getSimplePrice();
	}
	
	@Override
	public double getSimplePrice(){
		return Constants.ICE_VALUE;
	}

}
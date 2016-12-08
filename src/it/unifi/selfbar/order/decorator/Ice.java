package it.unifi.selfbar.order.decorator;

import it.unifi.selfbar.constant.Constants;
import it.unifi.selfbar.order.Order;

/**
 * @author Busiello & Mauro
 */
public class Ice extends OrderDecorator {

	public Ice(Order order) throws IllegalArgumentException {
		super(order);
		price = Constants.ICE_VALUE;
	}

}
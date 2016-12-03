package it.unifi.selfbar.decorator;

import it.unifi.selfbar.constant.Constants;
import it.unifi.selfbar.product.Order;

/**
 * @author Busiello & Mauro
 */
public class Ice extends OrderDecorator {

	public Ice(Order order) throws IllegalArgumentException {
		super(order);
		price = Constants.ICE_VALUE;
	}

}
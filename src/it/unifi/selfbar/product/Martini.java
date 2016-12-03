package it.unifi.selfbar.product;

import it.unifi.selfbar.constant.Constants;
import it.unifi.selfbar.exception.OrderNotDecorableException;

/**
 * @author Busiello & Mauro
 */
public class Martini extends Cocktail {

	public Martini() {
		price = Constants.MARTINI_VALUE;
	}

	@Override
	public Order getOrder() throws OrderNotDecorableException {
		throw new OrderNotDecorableException("This order is not a decorator.");
	}

}
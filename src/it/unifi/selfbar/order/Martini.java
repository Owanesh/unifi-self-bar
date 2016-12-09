package it.unifi.selfbar.order;

import it.unifi.selfbar.constant.Constants;
import it.unifi.selfbar.exception.OrderNotDecorableException;

/**
 * @author Busiello & Mauro
 */
public class Martini extends Cocktail {

	public Martini() {
		setPrice(Constants.MARTINI_VALUE);
	}

	@Override
	public Order getOrder() throws OrderNotDecorableException {
		throw new OrderNotDecorableException("This order is not a decorator.");
	}

	@Override
	protected boolean checkSameType(Object obj) {
		return obj instanceof Martini;
	}
}
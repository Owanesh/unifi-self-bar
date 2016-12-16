package it.unifi.selfbar.order;

import it.unifi.selfbar.constant.Constants;
import it.unifi.selfbar.exception.ErrorMessages;
import it.unifi.selfbar.exception.OrderNotDecorableException;

/**
 * @author Busiello & Mauro
 */
public class Arabic extends Coffee {

	public Arabic() {
		setPrice(Constants.ARABIC_VALUE);
	}

	@Override
	public Order getOrder() throws OrderNotDecorableException {
		throw new OrderNotDecorableException(ErrorMessages.THIS_ORDER_IS_NOT_DECORATOR);
	}

	@Override
	protected boolean checkSameType(Object obj) {
		return obj instanceof Arabic;
	}

}
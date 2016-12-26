package it.unifi.selfbar.order;

import it.unifi.selfbar.constant.Constants;
import it.unifi.selfbar.exception.OrderNotDecorableException;

/**
 * @author Busiello & Mauro
 */
public class Arabic implements Coffee {

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " : " + getSimplePrice();
	}

	@Override
	public double getPrice() {
		return getSimplePrice();
	}

	@Override
	public double getSimplePrice() {
		return 1.50;
	}

	@Override
	public Order getOrder() throws OrderNotDecorableException {
		throw new OrderNotDecorableException("Order non decorable exception");
	}

	/**
	 * necessario per il corretto funzionamento di BillLeastPopularOrderVisitor
	 */
	@Override
	public int hashCode() {
		int result = getClass().getName().hashCode();
		return result;
	}

	/**
	 * necessario per il corretto funzionamento di BillLeastPopularOrderVisitor
	 */
	@Override
	public boolean equals(Object obj) {
		return this == obj || obj instanceof Arabic;
	}

}
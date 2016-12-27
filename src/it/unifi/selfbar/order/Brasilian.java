package it.unifi.selfbar.order;

import it.unifi.selfbar.constant.Constants;
import it.unifi.selfbar.exception.ErrorMessages;
import it.unifi.selfbar.exception.OrderNotDecorableException;

public class Brasilian implements Coffee {

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

		return 1.00;
	}

 	public Order getOrder() throws OrderNotDecorableException {
		throw new OrderNotDecorableException(ErrorMessages.THIS_ORDER_IS_NOT_DECORATOR);
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
		return this == obj || obj instanceof Brasilian;
	}
 }

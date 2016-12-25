package it.unifi.selfbar.order;

import it.unifi.selfbar.constant.Constants;
import it.unifi.selfbar.exception.OrderNotDecorableException;

/**
 * @author Busiello & Mauro
 */
public class Arabic implements Coffee {

	@Override
	public String toString(){
		return this.getClass().getSimpleName()+" : "+getSimplePrice();
	}
	
	@Override
	public double getPrice() {
		return getSimplePrice();
	}

	@Override
	public double getSimplePrice() {
		return Constants.ARABIC_VALUE;
	}
	@Override
	public Order getOrder() throws OrderNotDecorableException {
		throw new OrderNotDecorableException("Order non decorable exception");
	}


}
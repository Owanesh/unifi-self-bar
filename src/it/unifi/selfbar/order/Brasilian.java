package it.unifi.selfbar.order;

import it.unifi.selfbar.constant.Constants;
import it.unifi.selfbar.exception.ErrorMessages;
import it.unifi.selfbar.exception.OrderNotDecorableException;

public class Brasilian implements Coffee {

	@Override
	public String toString(){
		return this.getClass().getSimpleName()+" : "+getSimplePrice();
	}
	
 
	@Override
	public double getPrice() {
		return getSimplePrice();
	}

	@Override
<<<<<<< HEAD
	public double getSimplePrice() {
		return Constants.BRASILIAN_VALUE;
=======
	public Order getOrder() throws OrderNotDecorableException {
		throw new OrderNotDecorableException(ErrorMessages.THIS_ORDER_IS_NOT_DECORATOR);
>>>>>>> Reduced Hardcode
	}

	@Override
	public Order getOrder() throws OrderNotDecorableException {
		throw new OrderNotDecorableException("Order non decorable exception");
	}


}

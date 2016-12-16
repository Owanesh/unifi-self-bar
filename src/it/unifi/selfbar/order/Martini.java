package it.unifi.selfbar.order;

import it.unifi.selfbar.constant.Constants;
import it.unifi.selfbar.exception.ErrorMessages;
import it.unifi.selfbar.exception.OrderNotDecorableException;

/**
 * @author Busiello & Mauro
 */
public class Martini implements Cocktail {

	@Override
	public String toString(){
		return this.getClass().getSimpleName()+" : "+getSimplePrice();
	}
	

	@Override
<<<<<<< HEAD
	public double getPrice() {
		return getSimplePrice();
=======
	public Order getOrder() throws OrderNotDecorableException {
		throw new OrderNotDecorableException(ErrorMessages.THIS_ORDER_IS_NOT_DECORATOR);
>>>>>>> Reduced Hardcode
	}

	@Override
	public double getSimplePrice() {
		return Constants.MARTINI_VALUE;
	}

	@Override
	public Order getOrder() throws OrderNotDecorableException {
		throw new OrderNotDecorableException("Order non decorable exception");
	}

}
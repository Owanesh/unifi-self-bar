package it.unifi.selfbar.order;

import it.unifi.selfbar.exception.OrderNotDecorableException;

/**
 * @author Busiello & Mauro
 */
public interface  Order {
	public double getPrice();
	public double getSimplePrice();
	public Order getOrder() throws OrderNotDecorableException;
}
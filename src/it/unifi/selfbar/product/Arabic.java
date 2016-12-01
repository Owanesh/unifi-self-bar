package it.unifi.selfbar.product;

import java.util.*;

import it.unifi.selfbar.exception.OrderNotDecoratedException;

/**
 * @author Busiello & Mauro
 */
public class Arabic extends Coffee {

	/**
	 * Default constructor
	 */
	public Arabic() {
	}
	@Override
	public Order getOrder() throws OrderNotDecoratedException{
		throw new OrderNotDecoratedException("This order isn't decorated");
	};
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Arabic)) {
			return false;
		}
		Arabic other = (Arabic) obj;
		if (!super.equals(other)) {
			return false;
		}
		return true;
	}




}
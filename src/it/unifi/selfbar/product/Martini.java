package it.unifi.selfbar.product;

import java.util.*;

import it.unifi.selfbar.exception.OrderNotDecoratedException;

/**
 * @author Busiello & Mauro
 */
public class Martini extends Cocktail {
	
	public Martini() {
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
		if (!(obj instanceof Martini)) {
			return false;
		}
		Martini other = (Martini) obj;
		if (!super.equals(other)) {
			return false;
		}
		return true;
	}
}
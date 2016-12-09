package it.unifi.selfbar.order;

import it.unifi.selfbar.exception.OrderNotDecorableException;
import it.unifi.selfbar.visitor.Visitor;

/**
 * @author Busiello & Mauro
 */
public abstract class Order {

	private double price;

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getSimplePrice() {
		return price;
	}

	public abstract Order getOrder() throws OrderNotDecorableException;

	@Override
	public String toString() {
		try {
			return getOrder().toString() + "\n    SUPPLEMENT-> " + getClass().getSimpleName() + ": price="
					+ String.format("%.2f", price);
		} catch (OrderNotDecorableException e) {
			return "\n" + getClass().getSimpleName() + ": price=" + String.format("%.2f", price);
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		// verifico che siano esattamente lo stesso prodotto
		// delego ad ogni sottoclasse tale compito
		if (!checkSameType(obj)) {
			return false;
		}
		Order other = (Order) obj;
		return Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price);
	}

	/**
	 * Return true if this and obj belong to the same type
	 * 
	 * @param obj
	 * @return
	 */
	protected abstract boolean checkSameType(Object obj);

}
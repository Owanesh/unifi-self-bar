package it.unifi.selfbar.product;

public abstract class Order {
	protected double price;

	/**
	 * Return the total price of this order, calculating it recursively if this
	 * is a decorated order
	 * 
	 * @return total price of this order
	 */
	public abstract double getTotalPrice();

	/**
	 * Return the price of this product, ignoring any other sub-order if this is
	 * a decorated order
	 * 
	 * @return simple price of this order
	 */
	public final double getSimplePrice() {
		return this.price;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [price=" + getSimplePrice() + "]";
	}

}

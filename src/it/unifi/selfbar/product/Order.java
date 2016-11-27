package it.unifi.selfbar.product;

public abstract class Order {
	protected double price;

	public double getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [price=" + price + "]";
	}

}

package it.unifi.selfbar.order.decorator;

import it.unifi.selfbar.order.Order;

public abstract class AbstractDecorator implements Order {

	private Order order;
	public AbstractDecorator(Order o) {
		order=o;
	}
	@Override
	public String toString(){
		return this.getClass().getSimpleName()+" : "+this.getSimplePrice()+"\n"+order.toString();
	}

	@Override
	public double getPrice() {
		return order.getPrice();
	}
	@Override
	public Order getOrder() {
		return order;
	}
	@Override
	public abstract double getSimplePrice();

}

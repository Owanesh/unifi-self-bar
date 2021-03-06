package it.unifi.selfbar.bill;

import java.util.List;

import it.unifi.selfbar.order.Order;

/**
 * @author Busiello & Mauro
 */
public abstract class DiscountDecorator extends Bill {

	private Bill bill;

	public DiscountDecorator(Bill bill) {
		this.bill = bill;
	}

	@Override
	public abstract double getTotal();

	@Override
	public void addOrder(Order order) {
		bill.addOrder(order);
	}

	@Override
	public List<Order> getListOrders() {
		return bill.getListOrders();
	}

	@Override
	public Bill getDiscount() {
		return bill;
	}

}
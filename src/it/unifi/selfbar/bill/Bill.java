package it.unifi.selfbar.bill;

import java.util.ArrayList;
import java.util.List;

import it.unifi.selfbar.order.Order;
import it.unifi.selfbar.visitor.Visitor;

/**
 * @author Busiello & Mauro
 */
public abstract class Bill {

	private List<Order> listOrders;
	private double total;

	public Bill() {
		listOrders = new ArrayList<Order>();
	}

	public double getTotal() {
		return total;
	}

	public void addOrder(Order order) {
		this.listOrders.add(order);
		updateTotal();
	}

	public List<Order> getListOrders() {
		return listOrders;
	}

	private void updateTotal() {
		total = 0;
		for (Order order : listOrders) {
			total += order.getPrice();
		}
	}

	public abstract Bill getDiscount() throws Exception;

	public void accept(Visitor v) {
		v.visitBill(this);
	}

	public boolean removeOrder(Order order) {
		return listOrders.remove(order);
	}
}
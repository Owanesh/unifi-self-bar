package it.unifi.selfbar.client;

import it.unifi.selfbar.visitor.Visitor;
import java.util.*;
import it.unifi.selfbar.product.*;

/**
 * @author Busiello & Mauro
 */
public class Bill {
	private List<Order> listOrders;
	private double total;

	public Bill() {
		listOrders = new ArrayList<Order>();
	}

	public double getTotal() {
		return this.total;
	}

	public void addOrder(List<Order> listOrders) {
		for (Order order : listOrders) {
			this.listOrders.add(order);
			updateTotal();
		}
	}

	public void addOrder(Order order) {
		this.listOrders.add(order);
		updateTotal();
	}

	private void updateTotal() {
		total = 0;
		for (Order order : listOrders) {
			total += order.getPrice();
		}
	}

	public List<Order> getListOrders() {
		return listOrders;
	}

	public void accept(Visitor v) {
		v.visitListOfOrders(this);
	}
}
package it.unifi.selfbar.client;

import java.util.*;

import it.unifi.selfbar.product.*;

public class Bill {
	private List<Order> listOrders;
	private double totalPrice;

	public Bill() {
		listOrders = new ArrayList<Order>();
		totalPrice = 0;
	}

	public double getTotal() {
		return totalPrice;
	}

	public void addOrder(Order order) {
		listOrders.add(order);
		totalPrice += order.getPrice();
	}

}

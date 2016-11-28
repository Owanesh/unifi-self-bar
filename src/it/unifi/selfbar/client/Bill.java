package it.unifi.selfbar.client;

import java.util.*;

import it.unifi.selfbar.product.*;
import it.unifi.selfbar.visitor.Visitor;

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

	public List<Order> getListOfOrders() {
		return listOrders;
	}

	public void addOrder(Order order) {
		listOrders.add(order);
		totalPrice += order.getTotalPrice();
	}

	public void accept(Visitor v) {
		v.visitListOfOrders(this);
	}

}

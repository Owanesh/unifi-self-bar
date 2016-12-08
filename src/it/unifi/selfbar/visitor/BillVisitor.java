package it.unifi.selfbar.visitor;

import java.util.*;

import it.unifi.selfbar.client.SelfBarBill;
import it.unifi.selfbar.constant.Utility;
import it.unifi.selfbar.order.Order;

public class BillVisitor implements Visitor {

	@Override
	public void visitListOfOrders(SelfBarBill selfBarBill) {
		List<Order> list = selfBarBill.getListOrders();
		double total = 0;
		for (Order order : list) {
			System.out.println(order.toString());
			System.out.println("Total: " + String.format("%.2f", order.getPrice()));
			total += order.getPrice();
			System.out.println("--------------------------------------");
		}
		System.out.println("TOTAL PRICE: " + String.format("%.2f", Utility.round(total, 2)));
	}

}

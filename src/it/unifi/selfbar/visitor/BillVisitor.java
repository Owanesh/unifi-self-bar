package it.unifi.selfbar.visitor;

import java.util.*;

import it.unifi.selfbar.client.Bill;
import it.unifi.selfbar.constant.Utility;
import it.unifi.selfbar.product.Order;

public class BillVisitor implements Visitor {

	@Override
	public void visitListOfOrders(Bill bill) {
		List<Order> list = bill.getListOrders();
		double total = 0;
		for (Order order : list) {
			System.out.println(order.toString());
			System.out.println("Total: " + order.getPrice());
			total += order.getPrice();
			System.out.println("--------------------------------------");
		}
		System.out.println("TOTAL PRICE: " + Utility.roundTwoDecimalDigits(total));
	}

}

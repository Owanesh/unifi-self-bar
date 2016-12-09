package it.unifi.selfbar.visitor;

import java.util.*;

import it.unifi.selfbar.bill.Bill;
import it.unifi.selfbar.order.Order;

public class BillPrintVisitor implements Visitor {

	@Override
	public void visitBill(Bill bill) {
		List<Order> list = bill.getListOrders();
		for (Order order : list) {
			System.out.println(order.toString());
			System.out.println("Total: " + String.format("%.2f", order.getPrice()));
			System.out.println("--------------------------------------");
		}
		System.out.println("TOTAL PRICE: " + String.format("%.2f", bill.getTotal()));
	}

}

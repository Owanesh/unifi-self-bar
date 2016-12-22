package it.unifi.selfbar.visitor;

import java.util.*;

import it.unifi.selfbar.bill.Bill;
import it.unifi.selfbar.order.Order;

public class BillPrintVisitor implements Visitor {

	private StringBuilder billSummary;

	@Override
	public void visitBill(Bill bill) {
		billSummary = new StringBuilder();
		List<Order> list = bill.getListOrders();
		createString(bill, list);
	}

	private void createString(Bill bill, List<Order> list) {
		for (Order order : list) {
			billSummary.append(order.toString());
			billSummary.append("Total: " + String.format("%.2f", order.getPrice()));
			billSummary.append("--------------------------------------");
		}
		billSummary.append("TOTAL PRICE: " + String.format("%.2f", bill.getTotal()));
	}

	public String getBillSummary() {
		return billSummary.toString();
	}

}

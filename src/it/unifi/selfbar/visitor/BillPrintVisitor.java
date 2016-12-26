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
			billSummary.append("\n"+order.toString());
			billSummary.append("\n\t\tTotal: " + String.format("%.2f", order.getPrice()));
			billSummary.append("\n--------------------------------------");
		}
		billSummary.append("\n\t\tTOTAL PRICE: " + String.format("%.2f", bill.getTotal()));
	}

	public String getBillSummary() {
		return billSummary.toString();
	}

}

package it.unifi.selfbar.visitor;

import java.util.*;

import it.unifi.selfbar.bill.Bill;
import it.unifi.selfbar.bill.DiscountDecorator;
import it.unifi.selfbar.bill.NightDiscount;
import it.unifi.selfbar.exception.BillNotDecorableException;
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
			billSummary.append("\n" + order.toString());
			billSummary.append("\n\t\tTotal: " + String.format("%.2f", order.getPrice()));
			billSummary.append("\n--------------------------------------");
		}
		billSummary.append(checkDiscount(bill) + "\n");
		billSummary.append("\n\t\tTOTAL PRICE: " + String.format("%.2f", bill.getTotal()));
	}

	private String checkDiscount(Bill bill) {
		StringBuilder msg = new StringBuilder("\n");
		try {
			while (bill instanceof DiscountDecorator) {
				msg.append(bill.getClass().getSimpleName() + ",");
				bill = bill.getDiscount();
			}
		} catch (BillNotDecorableException e) {
			// termina ricerca
		}
		return msg.toString();
	}

	public String getBillSummary() {
		return billSummary.toString();
	}

}

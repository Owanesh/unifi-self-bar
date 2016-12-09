package it.unifi.selfbar.visitor;

import it.unifi.selfbar.bill.Bill;
import it.unifi.selfbar.order.Order;

public interface Visitor {
	public void visitBill(Bill bill);
}

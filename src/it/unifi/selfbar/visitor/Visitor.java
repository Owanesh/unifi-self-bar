package it.unifi.selfbar.visitor;

import it.unifi.selfbar.bill.Bill;

public interface Visitor {
	public void visitBill(Bill bill);
}

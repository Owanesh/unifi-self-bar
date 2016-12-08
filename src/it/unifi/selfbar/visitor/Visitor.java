package it.unifi.selfbar.visitor;

import it.unifi.selfbar.client.SelfBarBill;

public interface Visitor {
	public void visitListOfOrders(SelfBarBill selfBarBill);
}

package it.unifi.selfbar.visitor;


import it.unifi.selfbar.client.Bill;

public interface Visitor {
	public void visitListOfOrders(Bill bill);
}

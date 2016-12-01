package it.unifi.selfbar.client;

import it.unifi.selfbar.paymentStrategy.*;
import it.unifi.selfbar.product.*;

public class Table {

	private Bill bill;

	public Table() {
		bill = new Bill();
	}

	public void requestPayment(PaymentStrategy strategy) {
		strategy.pay(bill);
	}

	public void requestOrder(Order order) {
		bill.addOrder(order);
	}

	public Bill getBill() {
		return bill;
	}
}
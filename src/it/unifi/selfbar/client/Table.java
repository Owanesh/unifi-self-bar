package it.unifi.selfbar.client;

import it.unifi.selfbar.paymentStrategy.PaymentStrategy;
import it.unifi.selfbar.product.*;

/**
 * @author Busiello & Mauro
 */
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
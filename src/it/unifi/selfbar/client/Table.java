package it.unifi.selfbar.client;

import it.unifi.selfbar.bill.Bill;
import it.unifi.selfbar.bill.NightDiscount;
import it.unifi.selfbar.order.*;
import it.unifi.selfbar.payment.PaymentStrategy;

/**
 * @author Busiello & Mauro
 */
public class Table {

	private Bill bill;

	public Table() {
		bill = new SelfBarBill();
	}

	public void requestPayment(PaymentStrategy strategy, Bill bill) {
		strategy.pay(bill.getTotal());
	}

	public void requestOrder(Order order) {
		bill.addOrder(order);
	}

	public Bill getBill() {
		return bill;
	}

}
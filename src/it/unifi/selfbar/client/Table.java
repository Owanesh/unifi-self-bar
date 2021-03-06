package it.unifi.selfbar.client;

import it.unifi.selfbar.bill.Bill;
import it.unifi.selfbar.order.*;
import it.unifi.selfbar.payment.PaymentStrategy;

/**
 * @author Busiello & Mauro
 */
public abstract class Table {

	private Bill bill;

	public Table() {
		reset();
	}

	/**
	 * factory method
	 * 
	 * @return the specific Bill for the concrete class that implements this
	 *         method
	 */
	protected abstract Bill createBill();

	public void requestPayment(PaymentStrategy strategy) {
		strategy.pay(bill.getTotal());

	}

	public void addOrder(Order order) {
		bill.addOrder(order);
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public void reset() {
		bill = null;
		bill = createBill();
	}

}
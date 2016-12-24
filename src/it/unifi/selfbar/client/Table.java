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
		// il conto è pagato, ripristino il tavolo per il prossimo cliente
		reset();
	}

	public void addOrder(Order order) {
		bill.addOrder(order);
	}

	public boolean removeOrder(Order order) {
		return bill.removeOrder(order);
	}

	public Bill getBill() {
		return bill;
	}

	public void reset() {
		bill = createBill();
	}

}
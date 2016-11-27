package it.unifi.selfbar.paymentStrategy;

import it.unifi.selfbar.client.Bill;

public interface PaymentStrategy {

	public void pay(Bill bill);

}

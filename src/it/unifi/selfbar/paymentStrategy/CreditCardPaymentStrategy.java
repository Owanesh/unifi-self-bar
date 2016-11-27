package it.unifi.selfbar.paymentStrategy;

import it.unifi.selfbar.client.Bill;

public class CreditCardPaymentStrategy implements PaymentStrategy {

	@Override
	public void pay(Bill bill) {
		System.out.println("Pagamento di " + bill.getTotal() + "€ effetuati con carta di credito.");
	}

}

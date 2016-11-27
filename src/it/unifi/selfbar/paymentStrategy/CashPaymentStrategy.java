package it.unifi.selfbar.paymentStrategy;

import it.unifi.selfbar.client.Bill;

public class CashPaymentStrategy implements PaymentStrategy {

	@Override
	public void pay(Bill bill) {
		System.out.println("Pagamento di " + bill.getTotal() + "€ effetuati con i cash (BIG MONEY).");
	}

}

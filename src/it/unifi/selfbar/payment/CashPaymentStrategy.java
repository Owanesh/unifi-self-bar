package it.unifi.selfbar.payment;

public class CashPaymentStrategy implements PaymentStrategy {

	@Override
	public void pay(double price) {
		System.out.println("Pagamento di " + String.format("%.2f", price) + "€ effetuati con i cash (BIG MONEY).");
	}

}

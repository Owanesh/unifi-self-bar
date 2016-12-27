package it.unifi.selfbar.payment;

public class CreditCardPaymentStrategy implements PaymentStrategy {

	@Override
	public void pay(double price) {
		System.out.println("Pagamento di " + String.format("%.2f", price) + "€ effetuati con carta di credito.");
	}

}

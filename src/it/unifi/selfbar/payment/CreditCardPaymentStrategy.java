package it.unifi.selfbar.payment;


public class CreditCardPaymentStrategy implements PaymentStrategy {

	@Override
	public void pay(double price) {
		System.out.println("Pagamento di " + price + "€ effetuati con carta di credito.");
	}

}

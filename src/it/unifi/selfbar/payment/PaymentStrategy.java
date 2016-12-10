package it.unifi.selfbar.payment;

@FunctionalInterface
public interface PaymentStrategy {

	public void pay(double price);

}

package it.unifi.selfbar;

import static org.junit.Assert.*;

import org.junit.Test;

import it.unifi.selfbar.bill.Bill;
import it.unifi.selfbar.bill.NightDiscount;
import it.unifi.selfbar.client.SelfBarBill;
import it.unifi.selfbar.order.Martini;
import it.unifi.selfbar.order.decorator.Soda;
import it.unifi.selfbar.payment.CashPaymentStrategy;
import it.unifi.selfbar.payment.CreditCardPaymentStrategy;
import it.unifi.selfbar.payment.PaymentStrategy;

public class PaymentTest {

	private double price = 20;

	@Test
	public void cashTest() {
		System.out.println("Cash Test");
		PaymentStrategy s = new CashPaymentStrategy();
		s.pay(price);
	}

	@Test
	public void creditCardTest() {
		System.out.println("Credit card Test");
		PaymentStrategy s = new CreditCardPaymentStrategy();
		s.pay(price);
	}

	@Test
	public void paymentBillTest() {
		System.out.println("Bill Payment Test");
		PaymentStrategy s = new CreditCardPaymentStrategy();
		Bill b = new SelfBarBill();
		b.addOrder(new Soda(new Martini()));
		s.pay(new NightDiscount(b, 0.1).getTotal());
	}

}

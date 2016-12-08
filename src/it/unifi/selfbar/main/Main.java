package it.unifi.selfbar.main;

import it.unifi.selfbar.visitor.BillVisitor;

import it.unifi.selfbar.client.*;
import it.unifi.selfbar.order.*;
import it.unifi.selfbar.order.decorator.Cream;
import it.unifi.selfbar.order.decorator.Ice;
import it.unifi.selfbar.order.decorator.Soda;
import it.unifi.selfbar.payment.CreditCardPaymentStrategy;

public class Main {
	public static void main(String[] args) {
		Coffee arabic = new Arabic();
		Order order1 = new Cream(arabic);
		Ice ice = new Ice(order1);

		Soda s = new Soda(new Martini());
		Table t = new Table();
		t.requestOrder(ice);
		t.requestOrder(s);
	}

}

package it.unifi.selfbar.main;

import it.unifi.selfbar.product.*;

import java.util.*;

import it.unifi.selfbar.client.*;
import it.unifi.selfbar.decorator.*;
import it.unifi.selfbar.paymentStrategy.*;

public class Main {
	public static void main(String[] args) {
		Table table = new Table();
		table.requestOrder(new Milk(new Arabic()));
		table.requestPayment(new CreditCardPaymentStrategy());
		table.requestPayment(new CashPaymentStrategy());
	}
}

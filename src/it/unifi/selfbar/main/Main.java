package it.unifi.selfbar.main;

import it.unifi.selfbar.product.*;
import it.unifi.selfbar.visitor.BillVisitor;

import it.unifi.selfbar.client.*;
import it.unifi.selfbar.decorator.*;
import it.unifi.selfbar.paymentStrategy.*;

public class Main {
	public static void main(String[] args) {
		Soda soda = new Soda(new Soda(new Martini()));
		Milk milk = new Milk(new Milk(new Arabic()));
		Arabic arabic = new Arabic();

		Table table = new Table();
		table.requestOrder(soda);
		table.requestOrder(milk);
		table.requestOrder(arabic);

		table.getBill().accept(new BillVisitor());

	}
}

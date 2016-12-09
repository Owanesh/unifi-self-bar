package it.unifi.selfbar.main;

import it.unifi.selfbar.visitor.BillPrintVisitor;
import it.unifi.selfbar.bill.NightDiscount;
import it.unifi.selfbar.client.*;
import it.unifi.selfbar.order.*;
import it.unifi.selfbar.order.decorator.Cream;
import it.unifi.selfbar.order.decorator.Ice;
import it.unifi.selfbar.order.decorator.Soda;

public class Main {
	public static void main(String[] args) {
		Table t = new Table();
		t.addOrder(new Martini());
		 
	}

}

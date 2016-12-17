package it.unifi.selfbar.main;

import it.unifi.selfbar.visitor.BillLeastPopularOrderVisitor;
import it.unifi.selfbar.visitor.BillPrintVisitor;
import it.unifi.selfbar.bill.AbsoluteDiscount;
import it.unifi.selfbar.bill.Bill;
import it.unifi.selfbar.bill.NightDiscount;
import it.unifi.selfbar.client.*;
import it.unifi.selfbar.order.*;
import it.unifi.selfbar.order.decorator.AbstractDecorator;
import it.unifi.selfbar.order.decorator.CocktailDecorator;
import it.unifi.selfbar.order.decorator.CoffeeDecorator;
import it.unifi.selfbar.order.decorator.Cream;
import it.unifi.selfbar.order.decorator.Ice;
import it.unifi.selfbar.order.decorator.Milk;
import it.unifi.selfbar.order.decorator.Soda;
import it.unifi.selfbar.payment.PaymentStrategy;

public class Main {
	public static void main(String[] args) {
	
		/* Flash test */
		Table t = new SelfBarTable();
		Coffee a = new Arabic();
		CoffeeDecorator a1 = new Milk(a);
		CoffeeDecorator a2 = new Cream(a1);
		AbstractDecorator b1 = new Ice(a2);	
		t.addOrder(b1);
		
 	
		t.addOrder(new Martini());
		
		t.addOrder(new Ice(new Soda(new Martini())));

		/* Flash Test visitor*/
		BillLeastPopularOrderVisitor blpov = new BillLeastPopularOrderVisitor();
		t.getBill().accept(blpov);
		System.out.println(blpov.getOrderResult().getClass().getSimpleName()); // Expected : Arabic
		System.out.println(blpov.getOrderResult().getSimplePrice()); // Expected : constant.ARABIC_VALUE
		System.out.println("");
		BillPrintVisitor bpv = new BillPrintVisitor();
		t.getBill().accept(bpv); // All bill
 
	}

}

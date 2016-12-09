package it.unifi.selfbar;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.unifi.selfbar.bill.Bill;
import it.unifi.selfbar.client.SelfBarBill;
import it.unifi.selfbar.order.*;
import it.unifi.selfbar.order.decorator.*;
import it.unifi.selfbar.visitor.BillLeastPopularOrderVisitor;
import it.unifi.selfbar.visitor.BillPrintVisitor;

public class BillVisitorTest {
	Bill b;

	@Before
	public void init() {
		b = new SelfBarBill();
		b.addOrder(new Martini());
		b.addOrder(new Soda(new Martini()));
		b.addOrder(new Soda(new Martini()));

		// 1 Martini
		// 2 Martini+Soda

	}

	@Test
	public void visitPrintTest() {
		//b.accept(new BillPrintVisitor());
	}

	@Test
	public void visitLeastPopularOrderTest() {
		b.accept(new BillLeastPopularOrderVisitor());

	}

}

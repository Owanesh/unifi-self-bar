package it.unifi.selfbar;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.unifi.selfbar.bill.Bill;
import it.unifi.selfbar.bill.SelfBarBill;
import it.unifi.selfbar.order.*;
import it.unifi.selfbar.order.decorator.*;
import it.unifi.selfbar.visitor.BillLeastPopularOrderVisitor;
import it.unifi.selfbar.visitor.BillPrintVisitor;

public class BillVisitorTest {
	Bill b;

	@Before
	public void init() {
		b = new SelfBarBill();
		// 3 Martini - 1 Brasilian
		b.addOrder(new Martini());
		b.addOrder(new Soda(new Martini()));
		b.addOrder(new Soda(new Martini()));
		b.addOrder(new Tequila());
		b.addOrder(new Brasilian());

	}

	@Test
	public void visitLeastPopularOrderTest() {
		BillLeastPopularOrderVisitor v = new BillLeastPopularOrderVisitor();
		b.accept(v);
		Order o = v.getOrderResult();
		assertTrue(o instanceof Brasilian);
	}

}

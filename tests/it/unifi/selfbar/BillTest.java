package it.unifi.selfbar;

import static org.junit.Assert.*;

import org.junit.Test;

import it.unifi.selfbar.client.Table;
import it.unifi.selfbar.decorator.Milk;
import it.unifi.selfbar.exception.OrderNotDecoratedException;
import it.unifi.selfbar.product.Arabic;
import it.unifi.selfbar.product.Order;

public class BillTest {

 
	@Test
	public void negativeTotal(){
		Table tbl=new Table();
 		if(tbl.getBill().getTotal()<0)
			fail("You have negative total");
 		tbl.requestOrder(new Milk(new Arabic()));
 		if(tbl.getBill().getTotal()<0)
			fail("You have negative total");
	}

 
}

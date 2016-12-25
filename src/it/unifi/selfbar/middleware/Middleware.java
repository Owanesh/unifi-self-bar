package it.unifi.selfbar.middleware;

import it.unifi.selfbar.bill.Bill;
import it.unifi.selfbar.client.Table;
import it.unifi.selfbar.order.Order;
import it.unifi.selfbar.payment.PaymentStrategy;

public class Middleware {

	private Bill bill;
	private Table table;
	private Order order;
 	
	
	public void prepareOrder(Order o){
		System.out.println("i'm preparing order with: "+o.toString());
		order=o;
	}
	
	public Order getPreparedOrder(){
		return order;
	}
	public void sendOrder(Order o){
		bill.addOrder(o);
	}
	
	public void confirmOrder(){
		bill.addOrder(order);
	}
	
	public void pay(PaymentStrategy p){
	  table.requestPayment(p);
  	}
	
	public boolean getPayResult(){
		return true;
	}
	
	public double getTotal(){
		return bill.getTotal();
	}
}

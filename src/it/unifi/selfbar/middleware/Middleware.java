package it.unifi.selfbar.middleware;

import it.unifi.selfbar.bill.Bill;
import it.unifi.selfbar.client.Table;
import it.unifi.selfbar.order.Order;
import it.unifi.selfbar.payment.PaymentStrategy;

public class Middleware {

	private Bill bill;
	private Table table;
	private Order order;
	private boolean payResult;
	
	
	public void prepareOrder(Order o){
		order=o;
	}
	
	public void sendOrder(Order o){
		bill.addOrder(o);
	}
	
	public void confirmOrder(){
		bill.addOrder(order);
	}
	
	public void pay(PaymentStrategy p){
		payResult = table.requestPayment(p);
	}
	
	public boolean getPayResult(){
		return payResult;
	}
	
}

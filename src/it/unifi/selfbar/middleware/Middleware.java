package it.unifi.selfbar.middleware;

import it.unifi.selfbar.bill.Bill;
import it.unifi.selfbar.client.SelfBarTable;
import it.unifi.selfbar.client.Table;
import it.unifi.selfbar.order.Order;
import it.unifi.selfbar.payment.PaymentStrategy;

public class Middleware {

 	private static Table table;
	private Order order=null;
 	
	public Middleware(){
		table = new SelfBarTable();
	}
	public void prepareOrder(Order o){
		order=o;
	}
	
	public Order getPreparedOrder(){
		return order;
	}
	public void sendOrder(Order o){
		table.addOrder(o);
	}
	
	public void confirmOrder(){
		table.addOrder(order);
	}
	
	public void pay(PaymentStrategy p){
	  table.requestPayment(p);
  	}
	
	public boolean getPayResult(){
		return true;
	}
	
	public static double getTotal(){
		return table.getBill().getTotal();
	}


}

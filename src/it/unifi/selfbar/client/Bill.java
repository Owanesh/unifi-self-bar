package it.unifi.selfbar.client;
import it.unifi.selfbar.visitor.Visitor;
import java.util.*;
import it.unifi.selfbar.product.*;
/**
 * @author Busiello & Mauro
 */
public class Bill {
	private List<Order> listOrders;
	private double total;
	
	public Bill() {
		listOrders=new ArrayList();
	}
	
	public double getTotal() {
		return this.total;
	}

	public void addOrder(List<Order> listOrders) {
		for(Order order : listOrders ){
			this.listOrders.add(order);
		}
	}
	
	public void addOrder(Order order) {
		this.listOrders.add(order);
	}

	public List<Order> getListOrders() {
		return listOrders;
	}	
	
	public void removeOrder(Order order){
		this.listOrders.remove(order);
	}
	public void accept(Visitor v) {
		v.visitListOfOrders(this);
	}
}
package it.unifi.selfbar.decorator;

import java.util.*;

import it.unifi.selfbar.product.Product;
import it.unifi.selfbar.product.Order;

/**
 * @author Busiello & Mauro
 */
public abstract class ProductDecorator extends Product {
 
	private Order order;
	
	public ProductDecorator(Product product) throws IllegalArgumentException {
	}
	
 	public Order getOrder() {
 		return order;
	}

}
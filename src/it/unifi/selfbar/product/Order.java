package it.unifi.selfbar.product;

import java.util.*;

import it.unifi.selfbar.exception.OrderNotDecoratedException;

/**
 * 
 */
public interface Order {

	public double getPrice();

	public Order getOrder() throws OrderNotDecoratedException;
}
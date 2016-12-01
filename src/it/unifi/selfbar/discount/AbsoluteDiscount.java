package it.unifi.selfbar.discount;

import java.util.*;

/**
 * @author Busiello & Mauro
 */
public class AbsoluteDiscount extends DiscountDecorator implements Discount {

	private double amount;

	public AbsoluteDiscount(double amount) {
		this.amount=amount;
	}

	public double doDiscuont(double total) {
		return total-amount;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	
}
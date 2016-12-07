package it.unifi.selfbar.discount;

import java.util.*;

/**
 * @author Busiello & Mauro
 */
public class AbsoluteDiscount extends DiscountDecorator {

	private double amount;

	public AbsoluteDiscount(Discount discount, double amount) {
		super(discount);
		this.amount = amount;
	}

	@Override
	public double getPrice() {
		return getDiscount().getPrice() - amount;
	}

}
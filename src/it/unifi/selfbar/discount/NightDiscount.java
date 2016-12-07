package it.unifi.selfbar.discount;

import java.util.*;

/**
 * @author Busiello & Mauro
 */
public class NightDiscount extends DiscountDecorator {

	private double percentage;

	public NightDiscount(Discount discount, double percentage) {
		super(discount);
		this.percentage = percentage;
	}

	@Override
	public double getPrice() {
		double actual = getDiscount().getPrice();
		return actual - (actual * percentage);
	}

}
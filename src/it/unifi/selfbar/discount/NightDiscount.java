package it.unifi.selfbar.discount;

import java.util.*;

/**
 * @author Busiello & Mauro
 */
public class NightDiscount extends DiscountDecorator implements Discount {


	private double percentage;


	public  NightDiscount(double percentage) {
		this.percentage=percentage;
	}


	public double doDiscuont(double total) {
		return total-((total*percentage)/100);
	}


	public double getPercentage() {
		return percentage;
	}


	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

}
package it.unifi.selfbar.discount;

import java.util.*;

/**
 * @author Busiello & Mauro
 */
public abstract class DiscountDecorator implements Discount {


	private Discount discount;


	public  DiscountDecorator(Discount discount) {}
	public DiscountDecorator(){}

	public Discount getDiscount() {
		return discount;
	}


	public abstract double doDiscuont(double total) ;


}
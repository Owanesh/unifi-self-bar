package it.unifi.selfbar.product;

import it.unifi.selfbar.constant.Constants;

public class Martini extends Cocktail {
	
	public Martini() {
		price = Constants.MARTINI_VALUE;
	}

	@Override
	public double getTotalPrice() {
		return getSimplePrice();
	}
}

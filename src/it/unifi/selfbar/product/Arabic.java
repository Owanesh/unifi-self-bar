package it.unifi.selfbar.product;

import it.unifi.selfbar.constant.Constants;

public class Arabic extends Coffee {

	public Arabic() {
		price = Constants.ARABIC_VALUE;
	}

	@Override
	public double getTotalPrice() {
		return getSimplePrice();
	}

}

package it.unifi.selfbar.client;

import it.unifi.selfbar.bill.Bill;

/**
 * @author Busiello & Mauro
 */
public class SelfBarBill extends Bill {

	public SelfBarBill() {
		super();
	}

	@Override
	public Bill getDiscount() throws Exception {
		throw new Exception("This bill does not have sub-discount.");
	}

}
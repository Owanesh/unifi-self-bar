package it.unifi.selfbar.bill;

import it.unifi.selfbar.exception.BillNotDecorableException;

/**
 * @author Busiello & Mauro
 */
public class SelfBarBill extends Bill {

	public SelfBarBill() {
		super();
	}

	@Override
	public Bill getDiscount() throws BillNotDecorableException {
		throw new BillNotDecorableException("This bill does not have sub-discount.");
	}

}
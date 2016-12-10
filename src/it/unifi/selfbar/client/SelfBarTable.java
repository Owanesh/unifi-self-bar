package it.unifi.selfbar.client;

import it.unifi.selfbar.bill.Bill;
import it.unifi.selfbar.bill.SelfBarBill;

public class SelfBarTable extends Table{

	@Override
	protected Bill createBill() {
		return new SelfBarBill();
	}

}

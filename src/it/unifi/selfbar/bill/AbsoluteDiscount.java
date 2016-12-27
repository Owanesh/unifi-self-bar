package it.unifi.selfbar.bill;

/**
 * @author Busiello & Mauro
 */
public class AbsoluteDiscount extends DiscountDecorator {

	private double amount;

	public AbsoluteDiscount(Bill bill, double amount) throws IllegalArgumentException {
		super(bill);
		if (amount < 0)
			throw new IllegalArgumentException("Amount not valid.");
		this.amount = amount;
	}

	@Override
	public double getTotal() {
		double total = getDiscount().getTotal();
		return total > amount ? total - amount : total;
	}

}
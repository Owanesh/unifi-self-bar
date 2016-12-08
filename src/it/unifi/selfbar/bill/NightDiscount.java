package it.unifi.selfbar.bill;

/**
 * @author Busiello & Mauro
 */
public class NightDiscount extends DiscountDecorator {

	private double percentage;

	/**
	 * 
	 * @param bill
	 * @param percentage
	 *            expected between 0 and 1
	 */
	public NightDiscount(Bill bill, double percentage) throws IllegalArgumentException {
		super(bill);
		if (percentage < 0 || percentage > 1)
			throw new IllegalArgumentException("Percentage not valid.");

		this.percentage = percentage;
	}

	@Override
	public double getTotal() {
		double actual = getDiscount().getTotal();
		return actual - (actual * percentage);
	}

}
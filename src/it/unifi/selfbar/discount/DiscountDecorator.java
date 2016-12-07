package it.unifi.selfbar.discount;

/**
 * @author Busiello & Mauro
 */
public abstract class DiscountDecorator extends Discount {

	private Discount discount;

	public DiscountDecorator(Discount discount) {
		this.discount = discount;
	}

	public Discount getDiscount() {
		return discount;
	}
	
	@Override
	public abstract double getPrice();

}
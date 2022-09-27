import shippings.*;

/**
 * Shopping
 */

public class Shopping {
	private Shipping shipping; // Strategy

	private Shipping[] enterprises = {
			new Fedex(), new Jadlog(),
			new PAC(), new Sedex() };


	void setShippingStrategy(int to) {
		try {
			this.shipping = enterprises[to];
		} catch (IndexOutOfBoundsException e) {
			this.shipping = new NullShipping();
		}
	}

	public Shipping getStrategy() {
		return this.shipping;
	}

	public Shipping[] getShippingOpts() {
		return this.enterprises;
	}

}

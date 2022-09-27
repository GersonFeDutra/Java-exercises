package shippings;

/**
 * Fedex
 */
public class Fedex implements Shipping {
	private final double SHIPPING_VALUE = 14_000;

	public double doShip() {
		return SHIPPING_VALUE;
	}

	@Override
	public String toString() {
		return "Fedex";
	}
}

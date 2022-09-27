package shippings;

/**
 * SEDEX
 */
public class Sedex implements Shipping {
	private final double SHIPPING_VALUE = 2_000;

	public double doShip() {
		return SHIPPING_VALUE;
	}

	@Override
	public String toString() {
		return "Sedex";
	}
}

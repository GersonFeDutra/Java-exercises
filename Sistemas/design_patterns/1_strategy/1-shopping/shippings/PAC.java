package shippings;

public class PAC implements Shipping {
	private final double SHIPPING_VALUE = 1_000;

	public double doShip() {
		return SHIPPING_VALUE;
	}

	@Override
	public String toString() {
		return "PAC";
	}
}

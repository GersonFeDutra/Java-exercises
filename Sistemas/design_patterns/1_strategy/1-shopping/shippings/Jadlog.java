package shippings;

public class Jadlog implements Shipping {
	private final double SHIPPING_VALUE = 12_000;

	public double doShip() {
		return SHIPPING_VALUE;
	}

	@Override
	public String toString() {
		return "Jadlog";
	}
}

package shippings;

public class NullShipping implements Shipping {

	// public BigInteger doShip() {
	// return BigInteger.ZERO;
	// }

	public double doShip() {
		return 0.0;
	}

	@Override
	public String toString() {
		return "Null";
	}
}

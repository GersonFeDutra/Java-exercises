package br.com.edu.ufca.cake;

public class CakeFlavor implements Cake {
	protected double basePrice;

	@Override
	public double getPrice() {
		return basePrice;
	}
}

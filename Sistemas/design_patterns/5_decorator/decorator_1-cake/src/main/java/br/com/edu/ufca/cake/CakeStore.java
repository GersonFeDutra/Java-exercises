package br.com.edu.ufca.cake;

public class CakeStore {
	private Cake cake;

	public void buildCake(CakeFlavor flavor, CakeDecoration[] decorations) {
		cake = flavor;

		for (CakeDecoration decoration : decorations)
			decoration.setCake(cake);
	}

	public double getTotalPrice() {
		return cake.getPrice();
	}
}

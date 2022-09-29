package br.com.edu.ufca.cake;

public class CakeDecoration implements Cake {
	private Cake cake = new NullCake();

	public CakeDecoration() {
	}

	public CakeDecoration(Cake cake) {
		this.cake = cake;
	}

	public double getPrice() {
		return cake.getPrice();
	}

	public Cake getCake() {
		return cake;
	}

	public void setCake(Cake cake) {
		this.cake = cake;
	}

}

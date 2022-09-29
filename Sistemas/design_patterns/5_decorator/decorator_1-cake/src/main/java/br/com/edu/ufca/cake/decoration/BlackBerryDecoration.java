package br.com.edu.ufca.cake.decoration;

import br.com.edu.ufca.cake.Cake;
import br.com.edu.ufca.cake.CakeDecoration;

public class BlackBerryDecoration extends CakeDecoration {

	public BlackBerryDecoration() {
		super();
	}

	public BlackBerryDecoration(Cake cake) {
		super(cake);
	}

	@Override
	public double getPrice() {
		return super.getPrice() + 4d;
	}
}

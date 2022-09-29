package br.com.edu.ufca.cake.decoration;

import br.com.edu.ufca.cake.Cake;
import br.com.edu.ufca.cake.CakeDecoration;

public class StrawberryDecoration extends CakeDecoration {

	public StrawberryDecoration() {
		super();
	}

	public StrawberryDecoration(Cake cake) {
		super(cake);
	}

	@Override
	public double getPrice() {
		return super.getPrice() + 6.5d;
	}
}

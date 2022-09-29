package br.com.edu.ufca.cake.decoration;

import br.com.edu.ufca.cake.Cake;
import br.com.edu.ufca.cake.CakeDecoration;

public class PeachDecoration extends CakeDecoration {

	public PeachDecoration() {
		super();
	}

	public PeachDecoration(Cake cake) {
		super(cake);
	}

	@Override
	public double getPrice() {
		return super.getPrice() + 3d;
	}
}

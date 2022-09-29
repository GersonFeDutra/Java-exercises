package br.com.edu.ufca.cake.decoration.coverage;

import br.com.edu.ufca.cake.Cake;
import br.com.edu.ufca.cake.CakeDecoration;

public class StrawberryCoverage extends CakeDecoration {

	public StrawberryCoverage() {
		super();
	}

	public StrawberryCoverage(Cake cake) {
		super(cake);
	}

	@Override
	public double getPrice() {
		return super.getPrice() + 8d;
	}
}

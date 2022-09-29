package br.com.edu.ufca.cake.decoration.coverage;

import br.com.edu.ufca.cake.Cake;
import br.com.edu.ufca.cake.CakeDecoration;

public class MilkCreamCoverage extends CakeDecoration {

	public MilkCreamCoverage() {
		super();
	}

	public MilkCreamCoverage(Cake cake) {
		super(cake);
	}

	@Override
	public double getPrice() {
		return super.getPrice() + 6.5d;
	}
}

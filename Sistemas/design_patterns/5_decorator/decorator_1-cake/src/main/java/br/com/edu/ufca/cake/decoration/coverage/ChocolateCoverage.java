package br.com.edu.ufca.cake.decoration.coverage;

import br.com.edu.ufca.cake.Cake;
import br.com.edu.ufca.cake.CakeDecoration;

public class ChocolateCoverage extends CakeDecoration {

	public ChocolateCoverage() {
		super();
	}

	public ChocolateCoverage(Cake cake) {
		super(cake);
	}

	@Override
	public double getPrice() {
		return super.getPrice() + 7d;
	}
}

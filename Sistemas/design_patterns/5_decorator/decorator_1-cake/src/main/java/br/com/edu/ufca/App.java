package br.com.edu.ufca;

import br.com.edu.ufca.cake.*;
import br.com.edu.ufca.cake.decoration.StrawberryDecoration;
import br.com.edu.ufca.cake.decoration.coverage.ChocolateCoverage;
import br.com.edu.ufca.cake.flavor.ChocolateCake;

public class App {
	public static void main(String[] args) {
		CakeDecoration[] decorations = {
				new ChocolateCoverage(),
				new StrawberryDecoration(),
		};
		CakeStore store = new CakeStore();

		store.buildCake(new ChocolateCake(), decorations);

		System.out.println(store.getTotalPrice());
	}
}

package ufca.edu.br.test;

import ufca.edu.br.utils.Pet;
import ufca.edu.br.utils.mamals.*;

public class Main {
	public static void main(String[] args) {
		// Pet pet = new Pet(10.5, 1);
		// Mamal mamal = new Mamal(10.5, 1, "orange", false);
		Pet pet = new Dog(10.5, 1, "orange", false);
		pet.move();
		pet.doNoise();

		if (pet instanceof Dog) { // Teste de segurança. Nesse caso não é estritamente necessário.
			Dog dog = (Dog) pet; // Caching temporário da coerção.
			dog.tailWag();
			dog.react(Dog.Reactions.BATH);
			dog.react();
		}

		pet = new Cat(8.5, 1, "black", true);
		pet.doNoise();

		((Cat)pet).purr();
	}
}

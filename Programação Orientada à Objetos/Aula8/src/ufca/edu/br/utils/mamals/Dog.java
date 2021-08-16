package ufca.edu.br.utils.mamals;

import java.time.LocalDateTime;
import ufca.edu.br.utils.Mamal;

public class Dog extends Mamal {
	public enum Reactions {
		BATH,
		STROLL,
	}

	public Dog(double weight, int age, String furColor, boolean hasPedigree) {
		super(weight, age, furColor, hasPedigree);
	}

	public void tailWag() {
		System.out.println("Abanar cauda");
	}

	public void react(Reactions reaction) {

		switch (reaction) {
			case BATH: System.out.println("Esconder-se"); break;
			case STROLL: System.out.println("Pular e abanar"); break;
			default:
		}
	}

	public void react() {

		if (LocalDateTime.now().getHour() > 18)
			System.out.println("Dormir");
		else
			System.out.println("Brincar");
	}

	@Override
	public void doNoise() {
		System.out.println("Latir");
	}
}

package ufca.edu.br.utils.mamals;

import ufca.edu.br.utils.Mamal;

public class Cat extends Mamal {

	public Cat(double weight, int age, String furColor, boolean hasPedigree) {
		super(weight, age, furColor, hasPedigree);
	}

	@Override
	public void doNoise() {
		System.out.println("Miar");
	}

	public void purr() {
		System.out.println("Purr,rrrrrr");
	}
}

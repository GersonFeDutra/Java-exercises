package ufca.edu.br.utils;

import java.time.Year;

public abstract class Pet {
	private double weight;
	private int birth_year;

	public Pet(double weight, int age) {
		this.weight = weight;
		setAge(age);
	}
	
	public abstract void move();
	public abstract void eat();
	public abstract void doNoise();

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getWeight() {
		return this.weight;
	}

	public void setAge(int age) {
		this.birth_year = Year.now().getValue() - age;
	}

	public int getAge() {
		return Year.now().getValue() - this.birth_year;
	}
}

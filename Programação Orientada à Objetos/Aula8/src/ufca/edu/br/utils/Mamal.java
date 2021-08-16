package ufca.edu.br.utils;

public abstract class Mamal extends Pet {
	public String furColor;
	public boolean hasPedigree;

	public Mamal(double weight, int age, String furColor, boolean hasPedigree) {
		super(weight, age);
		this.furColor = furColor;
		this.hasPedigree = hasPedigree;
	}

	@Override
	public void eat() {
		System.out.println("Omnívoro");
	}

	@Override
	public void move() {
		System.out.println("Corre");
	}

	public void setFurColor(String furColor) {
		this.furColor = furColor;
	}

	public String getFurColor() {
		return furColor;
	}

	public void setHasPedigree(boolean hasPedigree) {
		this.hasPedigree = hasPedigree;
	}

	public boolean hasPedigree() {
		return this.hasPedigree;
	}
}

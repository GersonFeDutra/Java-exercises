package br.edu.ufca.utils;

public class BonusAccount extends Account {
	private static double interestRate = 0.01;
	private double bonus;

	public BonusAccount(String number, double balance) {
		super(number, balance);
	}

	public void credit(double value) {
		this.bonus += value * interestRate;
		super.credit(value);
	}

	public void earnBonus() {
		super.credit(this.bonus);
		bonus = 0.0;
	}
}

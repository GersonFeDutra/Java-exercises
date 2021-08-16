package br.edu.ufca.utils;

public class Savings extends Account {
	private double interestRate = 0.01;

	public Savings(String number, double balance, double interestRate) {
		super(number, balance);
		this.interestRate = interestRate;
	}

	public void setInterestRate(double value) {
		this.interestRate = value;
	}

	public void earnInterest() {
		super.credit(this.balance * this.interestRate);
	}

	public double getInterestRate() {
		return this.interestRate;
	}
}

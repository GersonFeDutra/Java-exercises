package br.edu.ufca.utils;

public class Account {
	private String number;
	protected double balance;
	private Client client;


	public Account(String number, double balance) {
		this.number = number;
		this.balance = balance;
	}

	public double consultBalance() {
		return this.balance;
	}

	public void credit(double value) {
		this.balance += value;
	}

	public void debit(double value) {
		this.balance -= value;
	}

	public void transfer(Account target, double value) {
		this.debit(value);
		target.credit(value);
	}
	
	@Override
	public String toString() {
		String value = this.number + " [" + this.balance + "]";
		return value;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Client getCliente() {
		return client;
	}

	public void setCliente(Client client) {
		this.client = client;
	}
}

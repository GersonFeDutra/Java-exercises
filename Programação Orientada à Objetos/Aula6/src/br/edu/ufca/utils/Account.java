package br.edu.ufca.utils;

public class Account {
	private double balance;
	private String number;
	private Client client;

	public Account(String number, Client client) {
		this.number = number;
		this.client = client;
	}

	public void credit(double value) {

		if (value >= 0)
			this.balance += value;
	}

	public void debit(double value) {

		if (value >= 0 && value <= this.balance)
			this.balance -= value;
	}

	public void transfer(Account to, double value) {

		if (to == null)
			return;

		// Nota: numa "aplicação de mundo-real", deveríamos verificar primeiro, ou buscar um retorno
		// para a completude das tarefas.
		this.debit(value);
		to.credit(value);
	}

	public void setNumber(String value) {
		this.number = value;
	}

	public String getNumber() {
		return this.number;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client value) {
		this.client = value;
	}
}

package br.edu.ufca.utils;


public class Client {
	String cpf;
	public String name;
	private Account[] accounts;
	private boolean hasInsurance;

	public Account[] getAccounts() {
		return accounts;
	}

	public void setCpf(String value) {
		this.cpf = value;
	}

	public String getCpf() {
		return this.cpf;
	}

	public boolean hasInsurance() {
		return this.hasInsurance;
	}
}

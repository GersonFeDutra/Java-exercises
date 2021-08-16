package br.edu.ufca.utils;

public class Client {
	private String name;
	private String cpf;

	Client(String name, String cpf) {
		this.name = name;
		this.cpf = cpf;
	}

	public String getName() {
		return this.name;
	}

	public String getCpf() {
		return this.cpf;
	}
}

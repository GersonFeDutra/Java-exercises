package br.edu.ufca.utils;

public class Main {
	public static void main(String[] args)
	{
		Client client = new Client();
		client.cpf = "1234";
		client.name = "Paola";
		// client.accounts; // `accounts` é um atributo privado, logo, só pode ser acessado pela
		// própria classe, e modificado por métodos externos.
	}
}

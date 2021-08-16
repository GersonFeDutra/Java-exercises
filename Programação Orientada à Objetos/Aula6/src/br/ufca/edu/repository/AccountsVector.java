package br.ufca.edu.repository;
import br.edu.ufca.utils.Account;
import br.edu.ufca.utils.Client;

public class AccountsVector {
	private Account[] accounts;

	public AccountsVector(Account[] accounts) {
		this.accounts = accounts;
	}

	public Account consult(Client client) {
		Account account = null;

		for (int i = 0; i < this.accounts.length; ++i) {
			String cpf = this.accounts[i].getClient().getCpf();

			if (cpf.equals(client.getCpf()))
				account = this.accounts[i];
		}

		return account;
	}

	public static void main(String[] args) {
		Client client = new Client();
		// client.cpf = "1234";
		// Não pode ser acessado pois possui o modificador de acesso `default`, logo, está
		// disponível apenas em pacotes daquela mesma classe.
		client.name = "Paola"; // Como `name` é um atributo público, ele pode ser acessado.
		// client.accounts; // `accounts` é um atributo privado, logo, não pode ser acessado.
		client.setCpf("123456");

		Client client2 = new Client();
		client2.name = "Dumont";
		client2.setCpf("7890");
		Account[] accounts = {new Account("1", client), new Account("2", client)};
		AccountsVector repo = new AccountsVector(accounts);
		System.out.println(repo.consult(client).getNumber());

		Client client3 = new Client();
		client3.setCpf("22042098");
		System.out.println(repo.consult(client3));
	}
}

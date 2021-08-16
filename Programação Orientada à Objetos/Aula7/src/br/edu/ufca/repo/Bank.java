package br.edu.ufca.repo;

import br.edu.ufca.utils.Account;
import br.edu.ufca.utils.BonusAccount;
import br.edu.ufca.utils.Savings;

public class Bank {
	public Account[] accounts;

	Bank(Account[] accounts) {
		this.accounts = accounts;
	}

	void deposit(String accNumber, double value) {

		for (Account account : accounts)

			if (account.getNumber().equals(accNumber)) {
				account.credit(value);
				break;
			}
	}

	void withdraw(String accNumber, double value) {

		for (Account account : accounts)

			if (account.getNumber().equals(accNumber)) {
				account.debit(value);
				break;
			}
	}

	public static void main(String[] _args) {
		Account[] accounts = {
			new Account("504", 0.005),
			new Savings("69", 0.005, 0.01),
			new BonusAccount("420", 0.05),
		};

		for (Account account : accounts)
			account.credit(1000);

		Bank bank = new Bank(accounts);
		bank.deposit("504", 200);
		bank.withdraw("69", 200);
		bank.accounts[bank.accounts.length - 1].transfer(bank.accounts[0], 200);

		for (Account account : accounts)
			System.out.println(account.toString());
	}
}

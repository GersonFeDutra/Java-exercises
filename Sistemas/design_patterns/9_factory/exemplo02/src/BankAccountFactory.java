public class BankAccountFactory {

	public enum BankType {
		CHECKING,
		LEGAL,
		SAVINGS
	}

	public BankAccount createAccount(BankType type) {
		BankAccount account = null;

		switch (type) {
			case CHECKING:
				account = new CheckingAccount();
			case LEGAL:
				account = new LegalAccount();
			case SAVINGS:
				account = new SavingsAccount();
		}

		if (account != null)
			account.registerAccount();

		return account;
	}

}

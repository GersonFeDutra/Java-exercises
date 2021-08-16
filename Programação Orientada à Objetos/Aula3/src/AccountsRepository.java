
public class AccountsRepository {
	static final int DEFAULT_SIZE = 10;
	Account[] accounts;
	int size;

	public AccountsRepository() {
		size = DEFAULT_SIZE;
		accounts = new Account[size];
	}

	void add(Account account) {
		boolean added = false;

		for (int i = 0; i < accounts.length; ++i)

			if (accounts[i] == null) {
				accounts[i] = account;
				added = true;
				break;
			}

		if (!added)
			System.out.println("Erro: O repositório está cheio!");
	}

	void remove(Account account) {
		int i = searchId(account.number);

		if (i != -1)
			accounts[i] = null;
		else
			System.out.println("Erro: A conta a ser removida não existe.");
	}

	int searchId(String number) {
		int value = -1;

		for (int i = 0; i < accounts.length; ++i)

			if (accounts[i] != null && accounts[i].number.equals(number)) {
				value = i;
				break;
			}

		return value;
	}
}

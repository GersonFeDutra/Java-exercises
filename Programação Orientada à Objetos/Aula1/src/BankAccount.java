
public class BankAccount {
	String number;
	double balance;

	public void withdraw(double value) {

		if (value < 0.0) {
			System.out.println("Não é possível remover uma quantia negativa");
			return;
		}

		balance -= value;
	}

	public void deposit(double value) {

		if (value < 0.0) {
			System.out.println("Não é possível depositar uma quantia negativa");
			return;
		}

		balance += value;
	}
}

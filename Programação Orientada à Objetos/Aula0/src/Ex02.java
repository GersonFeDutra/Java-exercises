import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/* Faça um programa que apresente quatro opções:
 * (1) Consultar saldo;
 * (2) Saque;
 * (3) Depósito;
 * (4) Sair;
 * O saldo deve iniciar em R$ 0,00. A cada saque ou depósito, o valor do saldo
 * deve ser atualizado.
 */
public class Ex02 {

	public static void main(String[] args) {

		try (Scanner scan = new Scanner(System.in)) {
			start(scan);
		}
	}

	private static void start(Scanner scan) {
		int choice;
		double balance = 0.0;
		List<String> options = Arrays.asList("Consultar saldo", "Saque", "Depósito", "Sair");
		int optionsAmount = options.size();

		// Isso é equivalente à `while (true)` :P
		for (;;) {
			for (int i = 0; i < optionsAmount; ++i)
				System.out.printf("%d %s\n", i + 1, options.get(i));

			System.out.printf(">>> ");

			if ((choice = scan.nextInt()) == optionsAmount)
				break;

			switch (choice) {
			case 1:
				System.out.printf("Seu saldo é de R$%.2f\n\n", balance);
			break;
			case 2: {
				double value;
				System.out.printf("Digite a quantia que deseja sacar: ");

				while ((value = scan.nextDouble()) < 0.0)
					System.out.printf("O valor do saque deve ser positivo, tente novamente: ");

				balance -= value;
				System.out.println("Saque realizado com sucesso!\n");
			}
			break;
			case 3: {
				System.out.printf("Digite a quantia que deseja depositar: ");
				double value;

				while ((value = scan.nextDouble()) < 0.0)
					System.out.printf("O valor do depósito deve ser positivo, tente novamente: ");

				balance += value;
			}
			break;
			default:
				System.out.println("Opção inválida! Tente novamente.\n");
			}
		}
	}
}

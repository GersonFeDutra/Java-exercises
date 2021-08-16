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
		float balance = 0.0f;
		List<String> options = Arrays.asList("Consultar saldo", "Saque", "Depósito", "Sair");
		int optionsAmount = options.size();

		for (;;) {
			for (int i = 0; i < optionsAmount; ++i)
				System.out.printf("%d %s\n", i + 1, options.get(i));

			System.out.println(">>> ");

			if ((choice = scan.nextInt()) == optionsAmount)
				break;

			switch (choice) {
				case 1:
					System.out.printf("Seu saldo é de R$%.2f\n\n", balance);
				break;
				case 2: {
					float value;
					System.out.println("Digite a quantia que deseja sacar: ");

					while ((value = scan.nextFloat()) < 0.0f)
						System.out.println("O valor do saque deve ser postivo, tente novamente: ");

					balance -= value;
					System.out.println("Saque realizado com sucesso!\n");
				}
				break;
				case 3: {
					System.out.println("Digite a quantia que deseja depositar: ");
					float value;

					while ((value = scan.nextFloat()) < 0.0f)
						System.out
								.println("O valor do depósito deve ser postivo, tente novamente: ");

					balance += value;
				}
				break;
				default:
					System.out.println("Opção inválida! Tente novamente.\n");
			}
		}
	}
}

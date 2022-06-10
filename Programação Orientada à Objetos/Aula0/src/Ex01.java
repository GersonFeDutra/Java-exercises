import java.util.Scanner;

/* Faça um programa que leia um número inteiro do teclado,
 * verifica se é um número primo e imprime o resultado na tela.
 */

public class Ex01 {

	public static void main(String[] args) {

		try (Scanner scan = new Scanner(System.in)) {
			// Lê um número inteiro.
			System.out.print("Digite um número inteiro: ");
			int x = scan.nextInt();

			// Identifica se o número é primo.
			System.out.printf("%d %s primo.\n", x, isPrime(x) ? "é" : "não é");
			if (x != 0)
				System.out.println("%d é composto.");
		}
	}

	/*
	 * Verifica se o dado número inteiro é primo.
	 * Nota: Um número negativo é primo, se o seu oposto for primo.
	 * Um número não-primo é composto se for diferente de zero.
	 */
	private static boolean isPrime(int x) {
		boolean value = x != 0;
		x = Math.abs(x);

		// x = alvo (é primo ?), n = atual (é fator ?).
		for (int wall = x / 2 + 1, n = 2; n < wall; n++) {
			if ((x % n) == 0) {
				value = false;
				break;
			}
		}

		return value;
	}
}

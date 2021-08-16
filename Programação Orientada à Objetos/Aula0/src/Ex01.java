import java.util.Scanner;

/* Faça um programa que leia um número inteiro do teclado,
 * verifica se é um número primo e imprime o resultado na tela.
 */

public class Ex01 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.print("Digite um número inteiro: ");
		int x = scan.nextInt();
		System.out.printf("%d %s primo\n", x, isPrime(x) ? "é" : "não é");
		scan.close();
	}

	/* Verifica se o dado número é primo. */
	private static boolean isPrime(int x) {
		boolean value = true;

		for (int wall = x / 2 + 1, n = 2; n < wall; n++)

			if ((x % n) == 0) {
				value = false;
				break;
			}

		return value;
	}
}

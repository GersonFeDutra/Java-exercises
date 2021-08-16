import java.util.Scanner;


public class JogoDaVelha {
	char[][] tabuleiro;
	String jogador1, jogador2;

	public JogoDaVelha() {
		preencheTabuleiro();
	}

	void preencheTabuleiro() {
		tabuleiro = new char[3][3];

		for (int i = 0; i < 3; i++)

			for (int j = 0; j < 3; j++)
				tabuleiro[i][j] = '-';

	}

	void desenhaTabuleiro() {
		System.out.println("Tabuleiro");

		for (int i = 0; i < 3; i++) {

			for (int j = 0; j < 3; j++)
				System.out.print(tabuleiro[i][j] + " ");

			System.out.println("");
		}
	}

	void fazerJogada(boolean j1, Scanner scan) {

		// imprime de quem e a vez
		char jogada;

		if (j1) {
			jogada = 'x';
			System.out.println("� a vez de " + jogador1 + " (x): ");
		}
		else {
			jogada = 'o';
			System.out.println("� a vez de " + jogador2 + " (o): ");
		}

		boolean jogadaInvalida = true;

		while (jogadaInvalida) {
			System.out.println("Digite a linha da jogada (0 a 2): ");
			int linha = scan.nextInt();
			System.out.println("Digite a coluna da jogada: (0 a 2) ");
			int coluna = scan.nextInt();

			// verifica se coordenadas sao validas
			if (linha >= 0 && linha <= 2 && coluna >= 0 && coluna <= 2)

				// verifica se elemento ainda nao foi preenchido
				if (tabuleiro[linha][coluna] == '-') {
					tabuleiro[linha][coluna] = jogada;
					jogadaInvalida = false;
				}
				else {
					System.out.println("Jogada j� feita! Tente Novamente.");
				}

			else
				System.out.println("Coordenadas inv�lidas! Tente novamente.");

		}

	}

	// retorna se 'x' ou 'o' ganhou, e ' ' caso contrario
	char jogadorGanhou() {

		// checa linhas
		for (int i = 0; i < 3; i++)

			if (tabuleiro[i][0] != '-' && tabuleiro[i][0] == tabuleiro[i][1]
					&& tabuleiro[i][1] == tabuleiro[i][2])
				return tabuleiro[i][0];

		// checa colunas
		for (int j = 0; j < 3; j++)

			if (tabuleiro[0][j] != '-' && tabuleiro[0][j] == tabuleiro[1][j]
					&& tabuleiro[1][j] == tabuleiro[2][j])
				return tabuleiro[0][j];

		// checa diagonais
		if (tabuleiro[0][0] != '-' && tabuleiro[0][0] == tabuleiro[1][1]
				&& tabuleiro[1][1] == tabuleiro[2][2])
			return tabuleiro[0][0];

		if (tabuleiro[0][2] != '-' && tabuleiro[0][2] == tabuleiro[1][1]
				&& tabuleiro[1][1] == tabuleiro[2][0])
			return tabuleiro[0][2];

		// ninguem ganhou
		return ' ';
	}

	boolean tabuleiroCheio() {

		for (int i = 0; i < 3; i++)

			for (int j = 0; j < 3; j++)

				if (tabuleiro[i][j] == '-')
					return false;

		return true;
	}

	void pegaNomes(Scanner scan) {
		System.out.println("Sejam bem-vindos ao jogo da velha!");
		System.out.println("Jogador 1, qual seu nome? ");
		jogador1 = scan.nextLine();
		System.out.println("Jogador 2, qual o seu nome? ");
		jogador2 = scan.nextLine();
	}

	public static void main(String[] args) {
		JogoDaVelha jogo = new JogoDaVelha();

		Scanner scan = new Scanner(System.in);
		jogo.pegaNomes(scan);

		boolean jogador1 = true;

		boolean acabou = false;

		while (!acabou) {

			jogo.desenhaTabuleiro();

			jogo.fazerJogada(jogador1, scan);

			char ganhador = jogo.jogadorGanhou();

			if (ganhador == 'x') {
				System.out.println("Parab�ns " + jogo.jogador1 + "! Voc� venceu!");
				acabou = true;
			}
			else if (ganhador == 'o') {
				System.out.println("Parab�ns " + jogo.jogador2 + "! Voc� venceu!");
				acabou = true;
			}
			else {

				if (jogo.tabuleiroCheio()) {
					System.out.println("Deu empate!");
					acabou = true;
				}
				else {
					jogador1 = !jogador1;
				}
			}
		}

		jogo.desenhaTabuleiro();
		scan.close();
	}

}

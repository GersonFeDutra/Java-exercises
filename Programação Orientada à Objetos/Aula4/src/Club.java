
/* Classe que simula um clube de futebol, armazenando sua pontuação e saldo de gols. */
public class Club {
	public String name;
	public int points;
	public int goalsBalance; // diferença entre gols feitos - gols sofridos em todo o campeonato.

	public Club(String name) {
		this.name = name;
	}

	// Um vitória vale 3 pontos
	public void win(int goals) {
		this.goalsBalance += goals;
		this.points += 3;
	}

	// Um empate vale 1 ponto
	public void draw() {
		this.points++;
	}

	// Uma derrota não gera pontos.
	public void lose(int goals) {
		this.goalsBalance -= goals;
	}
}

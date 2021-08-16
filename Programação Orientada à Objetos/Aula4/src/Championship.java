import java.util.LinkedList;
import java.util.Random;

/*
 * Gerencia uma coleção de clubes de futebol, para simular partidas entre si.
 */
public class Championship {
	public Club[] clubs;

	Championship() {
	}

	Championship(int clubs) {
		this.clubs = new Club[clubs];
	}

	Championship(Club[] clubs) {
		this.clubs = clubs;
	}

	/*
	 * Inicia uma temporada do campeonato, modificando os dados dos clubes. As partidas são feitas
	 * em arranjos 2 a 2.
	 */
	public Club playChampionship() {

		for (Club clubM: this.clubs)
			for (Club clubV: this.clubs)
				if (clubM != clubV)
					playMatch(clubM, clubV);

		return getChampion();
	}

	/* Simula uma partida entre dois times dos clubes */
	public void playMatch(Club m, Club v) {
		// Sorteia um placar como sendo dois inteiros entre 0 e 5.
		Random random = new Random();
		int mGoals = random.nextInt() % 6;
		int vGoals = random.nextInt() % 6;

		if (mGoals > vGoals) {
			int goalsDiff = mGoals - vGoals;
			m.win(goalsDiff);
			v.lose(goalsDiff);
		}
		else if (mGoals == vGoals) {
			m.draw();
			v.draw();
		}
		else {
			int goalsDiff = vGoals - mGoals;
			v.win(goalsDiff);
			m.lose(goalsDiff);
		}
	}

	/*
	 * Retorna o campeão do campeonato com base nas classificações dos clubes. O time que tiver mais
	 * pontos vence; se houver empate, ganha aquele que tiver um maior saldo de gols.
	 */
	public Club getChampion() {
		/*
		 * Poderia ter usado o algorítmo de ordenação antes de gerar o campeão. Mas como implementei
		 * esse algoritmo antes (implementei primeiro apenas para imprimir a listagem), decidi
		 * deixar dessa forma mesmo, como uma alternativa "in-place". De qualquer forma, bastaria
		 * trocar pelo snippet comentado abaixo:
		 */
		// _sortClubs();
		// return clubs[clubs.length - 1];

		LinkedList<Club> winningClubs = new LinkedList<Club>();
		assert (this.clubs.length > 0);
		winningClubs.add(this.clubs[0]);

		for (int i = 1; i < this.clubs.length; ++i)

			if (this.clubs[i].points > winningClubs.getFirst().points) {
				winningClubs = new LinkedList<Club>();
				winningClubs.add(this.clubs[i]);
			}
			else if (this.clubs[i].points == winningClubs.getFirst().points) {
				winningClubs.add(this.clubs[i]);
			}

		Club championClub = winningClubs.pop();

		while (!winningClubs.isEmpty())

			if (championClub.goalsBalance < winningClubs.getFirst().goalsBalance)
				championClub = winningClubs.pop();
			else
				winningClubs.removeFirst();

		return championClub;
	}

	/* Ordena o vetor `clubs` com base na colocação de cada time na temporada. */
	private void _sortClubs() {
		_quickSort(0, this.clubs.length - 1);
	}

	/* Função auxiliar do `_quick_sort`. */
	int _partition(int low, int high) {
		Club highClub = this.clubs[high];
		int i;
		int left_wall = low;

		for (i = low; i < high; ++i) {
			Club currentClub = this.clubs[i];

			if (currentClub.points > highClub.points || (currentClub.points == highClub.points
					&& currentClub.goalsBalance > highClub.goalsBalance)) {
				this.clubs[i] = this.clubs[left_wall];
				this.clubs[left_wall] = currentClub;
				++left_wall;
			}
		}

		Club swap = this.clubs[i];
		this.clubs[i] = this.clubs[left_wall];
		this.clubs[left_wall] = swap;

		return left_wall;
	}

	/* Algoritmo de ordenação aplicado ao vetor de Clubes, com base nas regras do campeonato. */
	private void _quickSort(int low, int high) {

		if (low < high) {
			int pivot_location = _partition(low, high);
			_quickSort(low, pivot_location - 1);
			_quickSort(pivot_location + 1, high);
		}
	}

	// Método auxiliar para redimensionar uma string.
	private static String trimNameTo(String s, int size) {

		if (s.length() < size)
			return s;

		StringBuilder sb = new StringBuilder(s);
		sb.setLength(size);

		return sb.toString();
	}

	@Override
	// Imprime a tabela de times, de forma ordenada.
	public String toString() {
		String value = " ## | Clube | Pontuação | Saldo de gols\n";
		value += "---------------------------------------\n";
		_sortClubs();

		for (int i = 0; i < clubs.length; ++i) {
			value += String.format("%3d | %-5s | %9d | %13d\n", i + 1, trimNameTo(clubs[i].name, 5),
					clubs[i].points, clubs[i].goalsBalance);
		}

		return value;
	}
}

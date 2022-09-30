public class Test {

	public static void main(String[] args) {

		// Crie uma nova playlist vazia chamada "Foco no Estudo!"
		Playlist studying = new Playlist("Foco no Estudo!");

		// Crie uma nova playlist chamada "Coding Mode" e adicione 2 musicas
		Playlist programming = new Playlist("Coding Mode");
		Music[] programmingMusics = {
				new Music("Candles", "Jon Hopkins"),
				new Music("Day one", "Hans Zimmer"),
		};

		for (Music music : programmingMusics)
			programming.add(music);

		// Reproduzindo a playlist
		programming.play();

		System.out.println(" === O nome da playlist: " + programming.getName() + " ===");

		/*
		 * Crie uma nova playlist chamada "Sol e Churrasco" e adicione 3 musicas
		 * então configure a velocidade de reprodução para 0.5x
		 */
		Playlist resting = new Playlist("Sol e Churrasco");
		Music[] restingMusics = {
				new Music("Parada Louca", "Mari Fernandes"),
				new Music("Arranhão", "Henrique e Juliano"),
				new Music("Melhor eu ir", "Grupo menos é mais"),
		};

		for (Music music : restingMusics)
			resting.add(music);

		float slowSpeed = 0.5f;
		resting.setSpeed(slowSpeed);

		// Reproduzindo a playlist
		resting.play();

		System.out.println(" === O nome da playlist: " + resting.getName() + " ===");

		/*
		 * Crie uma nova música, configure a velocidade de reprodução em 1.25x
		 * e toque a música.
		 * O nome da música para concentração é "Makeshift Dream" e o artista
		 * desta música é "Aron Edwards"
		 */
		Music concentration = new Music("Makeshift Dream", "Aron Edwards");
		float fastSpeed = 1.25f;
		concentration.setSpeed(fastSpeed);
		concentration.play();

		// Imprima as informações sobre a música para concentração
		String name = concentration.getName();
		String artist = concentration.getArtist();
		System.out.println("O nome da música: " + name);
		System.out.println("O artista da música: " + artist);

		// Adicione a música para concentração na playlist "Foco no Estudo!"
		studying.add(concentration);

		// Toque a playlist "Foco no Estudo!"
		studying.play();

		// Exiba o nome da playlist que está sendo reproduzida "Foco no Estudo!"
		System.out.println(" === O nome da playlist: " + studying.getName() + " ===");

	}
}

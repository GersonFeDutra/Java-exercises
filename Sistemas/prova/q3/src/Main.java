public class Main {
	public static void main(String[] args) {
		Canal c = new Canal("GLR");
		Seguidor[] seguidores = {
				new Seguidor("Seguidor A"),
				new Seguidor("Seguidor B"),
				new Seguidor("Seguidor C"),
		};

		for (Seguidor seguidor : seguidores)
			c.registrarInteressado(seguidor);

		c.setStatus("Lançou vídeo!");
	}

}

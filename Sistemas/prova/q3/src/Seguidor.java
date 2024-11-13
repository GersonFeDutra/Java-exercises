public class Seguidor implements Interessado {
	private String nomeSeguidor;

	public String getNomeSeguidor() {
		return nomeSeguidor;
	}

	public void setNomeSeguidor(String nomeSeguidor) {
		this.nomeSeguidor = nomeSeguidor;
	}

	public Seguidor(String nome) {
		this.nomeSeguidor = nome;
	}

	@Override
	public void update(String status) {
		System.out.println("Status: " + status);
	}

	public void play() {
		System.out.printf("Seguidor %s rodando vídeo!\n", nomeSeguidor);
	}

}

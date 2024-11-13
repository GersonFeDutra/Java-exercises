import java.util.ArrayList;

public class Canal implements Subject {
	private ArrayList<Interessado> interessados;
	private String nomeCanal;

	private String status;

	public String getNomeCanal() {
		return nomeCanal;
	}

	public void setNomeCanal(String nomeCanal) {
		this.nomeCanal = nomeCanal;
	}

	public Canal(String nome) {
		this.nomeCanal = nome;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
		notificarInteressados();
	}

	public Canal() {
		interessados = new ArrayList<Interessado>();
	}

	@Override
	public void registrarInteressado(Interessado interessado) {
		interessados.add(interessado);
	}

	@Override
	public void removerInteressado(Interessado interessado) {
		interessados.remove(interessado);
	}

	@Override
	public void notificarInteressados() {
		for (Interessado interessado : interessados) {
			interessado.update(status);
		}
	}

}

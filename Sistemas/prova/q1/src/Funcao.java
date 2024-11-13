public class Funcao implements Funcionario {
	private double gratificacao;
	private Funcionario next;

	public Funcionario getNext() {
		return next;
	}

	public void setNext(Funcao next) {
		this.next = next;
	}

	public Funcao(double gratificacao) {
		this.gratificacao = gratificacao;
	}

	@Override
	public double getSalario() {
		if (next == null)
			return gratificacao;
		else
			return gratificacao + next.getSalario();
	}

}

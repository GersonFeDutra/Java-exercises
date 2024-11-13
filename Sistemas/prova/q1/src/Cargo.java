public class Cargo implements Funcionario {
	private String nome;
	private String setor;
	private double salario;

	public Cargo(String nome, String setor, double salario) {
		this.nome = nome;
		this.setor = setor;
		this.salario = salario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
}

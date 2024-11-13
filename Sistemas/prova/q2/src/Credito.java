import java.time.LocalDate;

public class Credito implements FormaDeCompra {
	private String nomeTitular;
	private String numeroCartao;
	private String Cvv;
	private LocalDate dataVencimento;

	public Credito(String nomeTitular, String numeroCartao, String cvv, LocalDate dataVencimento) {
		this.nomeTitular = nomeTitular;
		this.numeroCartao = numeroCartao;
		Cvv = cvv;
		this.dataVencimento = dataVencimento;
	}

	public String getNomeTitular() {
		return nomeTitular;
	}

	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}

	public String getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public String getCvv() {
		return Cvv;
	}

	public void setCvv(String cvv) {
		Cvv = cvv;
	}

	public LocalDate getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	@Override
	public boolean comprar() {
		if (dataVencimento.isBefore(LocalDate.now())) {
			System.out.println("Não é possível estabelecer compra!");
			return false;
		}
		System.out.printf("Comprando com crédito nome:%s n°:%s CVV:%s\n",
				nomeTitular, numeroCartao, Cvv);
		return true;
	}
}

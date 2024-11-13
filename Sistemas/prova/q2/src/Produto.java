public class Produto {
	private FormaDeCompra compra;
	private String codigoBarra;
	private String descricao;
	private double precoUnitario;

	public Produto(FormaDeCompra compra, String codigoBarra, String descricao, double precoUnitario) {
		this.compra = compra;
		this.codigoBarra = codigoBarra;
		this.descricao = descricao;
		this.precoUnitario = precoUnitario;
	}

	public FormaDeCompra getCompra() {
		return compra;
	}

	public void setCompra(FormaDeCompra compra) {
		this.compra = compra;
	}

	public double comprar() {
		if (compra.comprar()) {
			System.out.printf("Comprando produto %s[%s] de preço %.2f.\n",
					this.descricao, this.codigoBarra, this.precoUnitario);
			return this.precoUnitario;
		}
		return 0d;
	}

	public String getCodigoBarra() {
		return codigoBarra;
	}

	public void setCodigoBarra(String codigoBarra) {
		this.codigoBarra = codigoBarra;
	}

	public double getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}
}

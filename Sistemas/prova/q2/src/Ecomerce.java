import java.time.LocalDate;

public class Ecomerce {
	public static void main(String[] args) throws Exception {
		Credito credito = new Credito("Pedro", "1234", "$@#%", LocalDate.of(2010, 10, 3));
		PayPal debito = new PayPal("legal@gmail.com", "senhaBraba123");

		Produto[] produtos = {
				new Produto(credito, "| | ||| || |", "Maçã", 0.5d),
				new Produto(debito, "| || | ||  |", "Café", 3d),
		};

		Carrinho car = new Carrinho();
		for (Produto produto : produtos)
			car.addProduto(produto);

		car.exibir();
	}
}

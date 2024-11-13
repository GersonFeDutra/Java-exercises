import java.util.ArrayList;

public class Carrinho {
	private ArrayList<Produto> produtos;

	public Carrinho() {
		this.produtos = new ArrayList<Produto>();
	}

	public void addProduto(Produto produto) {
		produtos.add(produto);
	}

	public boolean removeProduto(Produto produto) {
		return produtos.remove(produto);
	}

	public void exibir() {
		double total = 0d;

		for (Produto produto : produtos)
			total += produto.comprar();

		System.out.printf("Total da compra: %.2d.\n", total);
	}
}

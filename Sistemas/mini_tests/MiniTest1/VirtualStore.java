import java.util.ArrayList;
import java.util.Hashtable;

public class VirtualStore {
	private Hashtable<String, Product> catalog;

	public Hashtable<String, Product> getCatalog() {
		return catalog;
	}

	/* Setter */
	// TODO: Remover Product
	public void addProduct(Product p) {
		this.catalog.put(p.getSKU(), p);
	}

	public VirtualStore(ArrayList<Product> products) {
		this.catalog = new Hashtable<String, Product>();

		for (Product product : products)
			this.catalog.put(product.getSKU(), product);
	}

	public double buy(String sku, boolean is_in_cash) {
		return catalog.get(sku).getPrice(is_in_cash);
	}

}

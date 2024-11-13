/**
 * Product
 */
public class Product {

	private String name;
	private String SKU;
	private String description;
	private double price;
	private Promotion promotionInCash;
	private Promotion promotion;

	public Product(String name, String sku, double price, Promotion inCache, Promotion p) {
		this.name = name;
		this.SKU = sku;
		this.price = price;
		this.promotionInCash = inCache;
		this.promotion = p;
	}

	/* Calcular o preço. */
	public double getPrice(boolean is_in_cash) {
		double value = this.promotion.calculate(price);

		if (is_in_cash)
			value += this.promotionInCash.calculate(price);

		return value;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSKU() {
		return this.SKU;
	}

	public void setSKU(String SKU) {
		this.SKU = SKU;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Promotion getPromotionInCash() {
		return this.promotionInCash;
	}

	public void setPromotionInCash(Promotion promotionInCash) {
		this.promotionInCash = promotionInCash;
	}

	public Promotion getPromotion() {
		return this.promotion;
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}
}

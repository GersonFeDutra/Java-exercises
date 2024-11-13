public class Product {
    private String name;

    public int stockQuantity = 0;
    public double price = 0d;

    public Product(String name, int stockQuantity, double price) {
        this.name = name;
        this.stockQuantity = stockQuantity;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }
}

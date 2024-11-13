public class Item {
    public int quantity;
    private Product product;

    public Item(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public void consume() throws InvalidQuantityException {

        if (quantity > product.stockQuantity)
            throw new InvalidQuantityException(this);
        else if (quantity < 0)
            this.quantity = 0;

        product.stockQuantity -= quantity;
        quantity = 0;
    }

    public Product getProduct() {
        return product;
    }

    public double getPrice() {
        return this.product.price * quantity;
    }

}

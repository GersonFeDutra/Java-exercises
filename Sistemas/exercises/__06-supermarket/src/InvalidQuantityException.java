public class InvalidQuantityException extends Exception {
    public Item item;

    public InvalidQuantityException(Item from) {
        super();
        this.item = from;
    }

    @Override
    public String getMessage() {
        return String.format(
                "Invalid quantity (%d) of items! Only %d in stock for this product.",
                item.quantity, item.getProduct().stockQuantity);
    }
}

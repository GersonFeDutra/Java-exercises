package library.items;


import library.items.discountables.*;

public class Book extends Item {

    private Readable type;
    private Discountable discount;

    public Book(int id, String title, double base_price, Readable type) {
        super(id, title, base_price);
        this.type = type;
        this.discount = new Off30();
    }

    @Override
    public double getPrice() {
        return this.discount.applyDiscount(basePrice);
    }

    public Readable getType() {
        return this.type;
    }

    @Override
    public Discountable getDiscount() {
        return this.discount;
    }

    @Override
    public String toString() {
        return "Book";
    }

}

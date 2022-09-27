package library.items;

import java.util.Hashtable;

import library.items.discountables.*;

public class Magazine extends Item {

    private Readable type;
    private Hashtable<Readable, Discountable> discount;

    public Magazine(int id, String title, double base_price, Readable type) {
        super(id, title, base_price);
        this.type = type;
        this.discount = new Hashtable<Readable, Discountable>();
        this.discount.put(Readable.PRINTED, new Off30());
        this.discount.put(Readable.DIGITAL, new Off15());
    }

    @Override
    public double getPrice() {
        return this.discount.get(type).applyDiscount(basePrice);
    }

    public Readable getType() {
        return this.type;
    }

    @Override
    public Discountable getDiscount() {
        return this.discount.get(type);
    }

    @Override
    public String toString() {
        return String.format("%s Magazine", this.type.toString().toLowerCase());
    }

}

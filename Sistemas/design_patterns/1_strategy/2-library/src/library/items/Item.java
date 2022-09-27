package library.items;

import library.items.discountables.Discountable;

public abstract class Item {
    protected double basePrice;
    private int id;
    private String title;

    public abstract double getPrice();

    public abstract Discountable getDiscount();

    public abstract String toString();

    public Item(int id, String title, double base_price) {
        this.id = id;
        this.title = title;
        this.basePrice = base_price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBasePrice(double to) {
        this.basePrice = to;
    }

    public double getBasePrice() {
        return this.basePrice;
    }

}

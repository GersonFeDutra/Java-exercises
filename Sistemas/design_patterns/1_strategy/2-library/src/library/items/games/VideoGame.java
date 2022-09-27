package library.items.games;

import library.items.discountables.*;

public class VideoGame extends Game {

    private static NullDiscount NO_DISCOUNT = new NullDiscount();
    private double TAX_REDUCTION = 0.01; // Applied as a percentage of the base price

    public VideoGame(int id, String title, double base_price) {
        super(id, title, base_price);
        this.tax *= TAX_REDUCTION;
    }

    @Override
    public double getPrice() {
        return this.basePrice + tax;
    }

    @Override
    public Discountable getDiscount() {
        return NO_DISCOUNT;
    }

    @Override
    public String toString() {
        return "VideoGame";
    }

}

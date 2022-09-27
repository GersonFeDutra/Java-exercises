package library.items.games;

import library.items.discountables.*;

public class BoardGame extends Game {

    private Discountable discount;

    public BoardGame(int id, String title, double base_price) {
        super(id, title, base_price);
        this.discount = new Off30();
    }

    @Override
    public double getPrice() {
        return this.discount.applyDiscount(basePrice) + tax;

    }

    @Override
    public Discountable getDiscount() {
        return this.discount;
    }

    @Override
    public String toString() {
        return "BoardGame";
    }

}

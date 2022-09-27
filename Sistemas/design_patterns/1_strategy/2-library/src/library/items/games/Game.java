package library.items.games;

import library.items.Item;

public abstract class Game extends Item {

    private static double DEFAULT_TAX = 0.015; // percentage over initial value
    protected double tax; // tax on Games

    public Game(int id, String title, double base_price) {
        super(id, title, base_price);
        this.tax = base_price * DEFAULT_TAX;
    }

    public void setTax(double value) {
        this.tax = value;
    }

    public double getTax() {
        return this.tax;
    }

    @Override
    public String toString() {
        return "Game";
    }
}

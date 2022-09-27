package library.items.discountables;

public interface Discountable {

    public double getDiscount();

    public default double applyDiscount(double at) {
        return at - at * this.getDiscount();
    }
}

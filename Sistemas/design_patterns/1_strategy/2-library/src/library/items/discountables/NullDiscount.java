package library.items.discountables;

public class NullDiscount implements Discountable {

    @Override
    public double getDiscount() {
        return 0.0;
    }
}

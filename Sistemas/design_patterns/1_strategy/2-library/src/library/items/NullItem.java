package library.items;

import library.items.discountables.*;

public class NullItem extends Item {

    public NullItem() {
        super(-1, "#", 0.0);
    }

    @Override
    public double getPrice() {
        return 0.0;
    }

    @Override
    public Discountable getDiscount() {
        return new NullDiscount();
    }

    @Override
    public String toString() {
        return "Null";
    }

}

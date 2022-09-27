public class Manager implements Role {

    @Override
    public boolean requestPurchase(double value, Role from) {

        if (value > this.budget * allowanceThreshold)
            return superior.requestPurchase(value, from);

        return true;
    }
}

public class President implements Role {

    @Override
    public boolean requestPurchase(double value, Role from) {

        return value < this.budget * allowanceThreshold;
    }
}

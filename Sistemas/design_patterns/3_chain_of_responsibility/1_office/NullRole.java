public class NullRole implements Role {

    @Override
    public boolean requestPurchase(double value, Role from) {
        return false;
    }

    @Override
    public void setBudget(double value) {
    }
}

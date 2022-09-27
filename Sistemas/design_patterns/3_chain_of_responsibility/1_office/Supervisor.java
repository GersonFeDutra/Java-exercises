public class Supervisor implements Role {
    private double allowanceThreshold; // %

    @Override
    public boolean requestPurchase(double value, Role from) {

        if (value > this.allowanceThreshold * this.budget)
            return this.next;
    }

}

public class NullBank extends Bank {

    @Override
    public boolean doPayment(double value, String to) {
        return false;
    }

}

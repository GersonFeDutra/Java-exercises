public class President extends Bank {

    @Override
    public boolean doPayment(double value, String to) {

        if (to == this.CODE)
            return true;

        return next.doPayment(value, to);
    }

}

/**
 * Bank - A Bank is responsible for dealing with purchase requests.
 */
public abstract class Bank {

    private Bank next = null;
    final String CODE;

    public Bank(String uniqueCode) {
        this.CODE = uniqueCode;
    }

    public abstract boolean doPayment(double value, String to);

    public void setNext(Bank next) {
		this.next = next;
	}

    public Bank getNext() {
		return this.next;
	}
}

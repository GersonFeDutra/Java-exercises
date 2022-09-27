/**
 * Role - A role is responsible for dealing with purchase requests.
 */
public interface Role {

    private Role superior = null;
    private double budget = 0.0;

    public abstract boolean requestPurchase(double value, Role from);

    public void setSuperior(Role next) {
		this.superior = next;
	}

    public Role getSuperior() {
		return this.superior;
	}

    public void setBudget(double value) {
        this.budget = value;
    }

    public void getBudget() {
        return this.budget;
    }
}

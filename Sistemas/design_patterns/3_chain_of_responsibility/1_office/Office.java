public class Office {
    private double capital;

    public Office() {
        Role lastRole = null;
        List<Role> orderedRoles = {
			new NullRole();
			new President();
			new Director();
            new Manager();
			new Supervisor();
        };

        double initialBudget = 100.0;
        double[] growFunction = {2.0, 1/4.0}; // (i0 * x^[0]  +  i0*[1](x - 1)), in terms of counter.
        int count = 1;

        for (Role role : orderedRoles) {
            role.setSuperior(lastRole);
            role.setBudget(Math.pow(initialBudget * count, growFunction[0]) + (
                    initialBudget * growFunction[1] * (this.count - 1));
        }
    }
}

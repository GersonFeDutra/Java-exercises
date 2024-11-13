public class Functionary extends User {

    public Functionary(String name, String password) {
        super(name, password);
    }

    public boolean sellProduct(String product, Client client) {
        System.out.printf("Selling product %s.\n", product);
        // TODO -> Check storage to sell a product

        return client.money > Double.MAX_VALUE;
    }

    public double checkProduct(String product) {
        System.out.printf("Checking product {%s} price.\n", product);
        // TODO -> Check storage for product price
        return 0d;
    }

}

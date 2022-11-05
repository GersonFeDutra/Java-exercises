public class Cafeteria {
    public static void main(String[] args) {
        SandwichFactory f = new SandwichFactory();

        Sandwich[] sandwiches = {
                f.makeSandwich(From.JUAZEIRO),
                f.makeSandwich(From.CRATO),
                f.makeSandwich(From.BARBALHA),
        };

        for (Sandwich sandwich : sandwiches)
            System.out.printf("%s.\n", sandwich.toString());
    }
}

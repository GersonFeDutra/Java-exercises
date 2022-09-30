package br.com.edu.ufca.travel;

public abstract class Travel {
    protected double basePrice;
    protected String description;

    public Travel(String description) {
        this.description = description;
    }

    public abstract double getPrice();

    public abstract String getDescription();

}

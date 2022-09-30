package br.com.edu.ufca.travel;

public abstract class TravelDestiny extends Travel {

    public TravelDestiny(String description) {
        super(description);
        description = String.format("%s: %s", this.toString(), this.description);
    }

    @Override
    public double getPrice() {
        return this.basePrice;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public abstract String toString();
}

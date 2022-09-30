package br.com.edu.ufca.travel;

public abstract class TravelPackage extends Travel {

    private Travel travel;

    public TravelPackage(String description) {
        super(description);
    }

    @Override
    public double getPrice() {
        return this.basePrice + travel.getPrice();
    }

    @Override
    public String getDescription() {
        return String.format("%s\n\t%s", travel.getDescription(), description);
    }

    public Travel getTravel() {
        return travel;
    }

    public void setTravel(Travel travel) {
        this.travel = travel;
    }
}

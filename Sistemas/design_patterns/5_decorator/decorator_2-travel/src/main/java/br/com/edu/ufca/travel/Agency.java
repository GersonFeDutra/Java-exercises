package br.com.edu.ufca.travel;

public class Agency {
    private Travel travel;

    public void defineTravel(TravelDestiny destiny, TravelPackage[] packs) {
        travel = destiny;

        for (TravelPackage pack : packs) {
            pack.setTravel(travel);
            travel = pack;
        }
    }

    public double getTotalPrice() {
        return travel.getPrice();
    }

    public String getTravelDescription() {
        return travel.getDescription();
    }
}

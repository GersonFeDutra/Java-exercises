package br.com.edu.ufca.travel.pack;

import br.com.edu.ufca.travel.TravelPackage;

public class TripPackage extends TravelPackage {

    public TripPackage(String description) {
        super(description);
        this.basePrice = 475d;
    }

}

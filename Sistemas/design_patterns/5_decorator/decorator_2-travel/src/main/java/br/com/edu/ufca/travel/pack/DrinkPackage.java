package br.com.edu.ufca.travel.pack;

import br.com.edu.ufca.travel.TravelPackage;

public class DrinkPackage extends TravelPackage {

    public DrinkPackage(String description) {
        super(description);
        this.basePrice = 350d;
    }

}

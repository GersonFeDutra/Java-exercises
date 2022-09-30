package br.com.edu.ufca.travel.pack;

import br.com.edu.ufca.travel.TravelPackage;

public class SpaPackage extends TravelPackage {

    public SpaPackage(String description) {
        super(description);
        this.basePrice = 500d;
    }

}

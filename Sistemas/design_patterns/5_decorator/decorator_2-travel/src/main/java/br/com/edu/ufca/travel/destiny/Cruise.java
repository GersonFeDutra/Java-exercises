package br.com.edu.ufca.travel.destiny;

import br.com.edu.ufca.travel.TravelDestiny;

public class Cruise extends TravelDestiny {

    public Cruise(String description) {
        super(description);
        this.basePrice = 1000d;
    }

    @Override
    public String toString() {
        return "Cruise";
    }
}

package br.com.edu.ufca.travel.destiny;

import br.com.edu.ufca.travel.TravelDestiny;

public class Beach extends TravelDestiny {

    public Beach(String description) {
        super(description);
        this.basePrice = 400d;
    }

    @Override
    public String toString() {
        return "Beach";
    }
}

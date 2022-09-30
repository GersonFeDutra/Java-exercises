package br.com.edu.ufca.travel.destiny;

import br.com.edu.ufca.travel.TravelDestiny;

public class Field extends TravelDestiny {

    public Field(String description) {
        super(description);
        this.basePrice = 200d;
    }

    @Override
    public String toString() {
        return "Field";
    }
}

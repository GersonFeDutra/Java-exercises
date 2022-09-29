package br.com.edu.ufca.label.concrete;

import br.com.edu.ufca.label.Label;

public class LabelC implements Label {

    @Override
    public void notify(String text) {
        System.out.printf("Texto atualizado: %s.\n", text.toUpperCase());
    }
}

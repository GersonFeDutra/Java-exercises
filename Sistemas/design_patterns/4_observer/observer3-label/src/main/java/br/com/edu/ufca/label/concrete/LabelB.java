package br.com.edu.ufca.label.concrete;

import br.com.edu.ufca.label.Label;

public class LabelB implements Label {

    @Override
    public void notify(String text) {
        System.out.printf("Texto atualizado: %d palavras.\n", text.split(" ").length);
    }
}

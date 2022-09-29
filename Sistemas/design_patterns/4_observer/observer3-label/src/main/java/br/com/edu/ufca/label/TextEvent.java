package br.com.edu.ufca.label;

import java.util.ArrayList;

public abstract class TextEvent {
    protected ArrayList<Label> displays;

    public TextEvent() {
        displays = new ArrayList<Label>();
    }

    public void connect(Label label) {
        displays.add(label);
    }

    public boolean disconnect(Label label) {
        return displays.remove(label);
    }

    public abstract void emmit();
}

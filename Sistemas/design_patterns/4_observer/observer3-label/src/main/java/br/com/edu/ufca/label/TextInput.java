package br.com.edu.ufca.label;

public class TextInput extends TextEvent {
    private String text;

    public TextInput() {
        super();
    }

    @Override
    public void emmit() {
        for (Label label : displays)
            label.notify(text);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
        emmit();
    }
}

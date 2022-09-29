package br.com.edu.ufca;

// import javafx.application.Application;
import br.com.edu.ufca.label.Label;
import br.com.edu.ufca.label.TextInput;
import br.com.edu.ufca.label.concrete.*;

public class Main {

    public static void main(final String[] args) {
        TextInput input = new TextInput();
        Label[] labels = {
                new LabelA(),
                new LabelB(),
                new LabelC(),
        };

        for (Label label : labels)
            input.connect(label);

        input.setText("Hello World!");
        // Application.launch(App.class, args);
    }
}

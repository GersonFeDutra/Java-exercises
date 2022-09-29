package br.com.edu.ufca;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

import br.com.edu.ufca.controllers.MainView;
import br.com.edu.ufca.label.Label;
import br.com.edu.ufca.label.TextInput;
import br.com.edu.ufca.label.concrete.*;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = getFXML("views/main");
        BorderPane root = loader.<BorderPane>load();
        MainView controller = loader.<MainView>getController();

        // Setup Main View

        TextInput input = new TextInput();
        Label[] labels = {
                new LabelA(),
                new LabelB(),
                new LabelC(),
        };

        for (Label label : labels)
            input.connect(label);

        controller.setInput(input);

        // Setup the scene
        scene = new Scene(root, 236, 400);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(getFXML(fxml).load());
    }

    private static FXMLLoader getFXML(String fxml) throws IOException {
        return new FXMLLoader(App.class.getResource(fxml + ".fxml"));
    }

    public static void main(String[] args) {
        launch();
    }

}

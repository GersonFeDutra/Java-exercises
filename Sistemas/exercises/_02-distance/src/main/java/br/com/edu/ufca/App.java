package br.com.edu.ufca;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 *
 * Exercício 02 - Dado que a distância entre dois pontos A(3,5) e B(6,1) é 5.
 * Crie um programa que calcula a distância entre dois pontos. Dados os pontos
 * A(xA, yA) e B (xB, * Yb), para calcular a distância entre esses dois pontos,
 * utilizamos a fórmula: dAB = √(xB – xA)² + (yB – yA)²
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        AnchorPane root = (AnchorPane) loadFXML("primary");
        scene = new Scene(root, root.getPrefWidth(), root.getPrefHeight());
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}

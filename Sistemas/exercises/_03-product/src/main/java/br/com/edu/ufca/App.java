package br.com.edu.ufca;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 *
 * Exercício 03 - Para cada produto informado (nome, preço e quantidade),
 * escreva o nome do produto comprado e o valor total a ser pago, considerando
 * que são oferecidos descontos pelo número de unidades compradas, segundo a
 * tabela abaixo:
 *
 * a. Até 10 unidades: valor total
 * b. de 11 a 20 unidades: 10% de desconto
 * c. de 21 a 50 unidades: 20% de desconto
 * d. acima de 50 unidades: 25% de desconto
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        VBox root = (VBox) loadFXML("primary");
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

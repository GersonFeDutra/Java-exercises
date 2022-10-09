package br.com.edu.ufca;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;

import java.io.IOException;

/*
 * JavaFX App
 *
 * Exercício 01 - Escrever um programa que leia o nome de um vendedor, o seu
 * salário fixo e o total de vendas efetuadas por ele no mês (em dinheiro).
 * Sabendo que este vendedor ganha 15% de comissão sobre suas vendas efetuadas,
 * informar o seu nome, o salário fixo e salário no final do mês.
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

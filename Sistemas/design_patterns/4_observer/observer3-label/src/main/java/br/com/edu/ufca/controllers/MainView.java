package br.com.edu.ufca.controllers;

import br.com.edu.ufca.label.TextInput;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;

public class MainView {
    private TextInput input = new NullInput();

    @FXML
    private Label charCountLabel;

    @FXML
    private Label upperCaseLabel;

    @FXML
    private Label wordCountLabel;

    @FXML
    void onKeyTyped(KeyEvent event) {
        String text = ((TextArea) event.getSource()).getText();
        input.setText(text);
        charCountLabel.setText(Integer.toString(text.length()));
        upperCaseLabel.setText(text.toUpperCase());
        wordCountLabel.setText(Integer.toString(text.split(" ").length));
    }

    @Override
    public String toString() {
        return "MainView";
    }

    public TextInput getInput() {
        return input;
    }

    public void setInput(TextInput input) {
        this.input = input;
    }
}

package br.com.edu.ufca;

import java.net.URL;
import java.util.ResourceBundle;

import org.apache.commons.lang3.StringUtils;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.SpinnerValueFactory.DoubleSpinnerValueFactory;
import javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;

public class PrimaryController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="primaryButton"
    private Button primaryButton; // Value injected by FXMLLoader

    @FXML // fx:id="qttSpinner"
    private Spinner<Integer> qttSpinner; // Value injected by FXMLLoader

    @FXML // fx:id="priceSpinner"
    private Spinner<Double> priceSpinner; // Value injected by FXMLLoader

    @FXML // fx:id="table"
    private TableView<ProductEntry> table; // Value injected by FXMLLoader

    @FXML // fx:id="nameCol"
    private TableColumn<ProductEntry, String> nameCol;

    @FXML // fx:id="priceCol"
    private TableColumn<ProductEntry, Double> priceCol;

    @FXML // fx:id="qttCol"
    private TableColumn<ProductEntry, Integer> qttCol;

    @FXML // fx:id="totalCol"
    private TableColumn<ProductEntry, Double> totalCol;

    @FXML // fx:id="totalLabel"
    private Label totalLabel; // Value injected by FXMLLoader

    private static final String NULL_NAME = "Unnamed";
    private double total = 0d;
    ProductEntry currentProduct;
    ObservableList<ProductEntry> list = FXCollections.observableArrayList();

    @FXML
    void onNameFieldTyped(KeyEvent event) {
        String text = ((TextField) event.getSource()).getText();
        currentProduct.name = text.isEmpty() ? NULL_NAME : StringUtils.capitalize(text);
    }

    /* Envia um registro de produto para a tabela. */
    @FXML
    void submit(ActionEvent event) {
        total += currentProduct.getTotal();
        list.add(currentProduct);
        currentProduct = new ProductEntry(
                currentProduct.name, currentProduct.getQuantity(), currentProduct.getPrice());
        totalLabel.setText(String.format("%.2f$", total));
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert primaryButton != null
                : "fx:id=\"primaryButton\" was not injected: check your FXML file 'primary.fxml'.";
        assert table != null
                : "fx:id=\"table\" was not injected: check your FXML file 'primary.fxml'.";
        assert totalLabel != null
                : "fx:id=\"totalLabel\" was not injected: check your FXML file 'primary.fxml'.";

        PrimaryController self = this; // Keep the reference to use on listeners
        currentProduct = new ProductEntry(NULL_NAME);

        // Quantity Input
        IntegerSpinnerValueFactory qttSVF = new IntegerSpinnerValueFactory(
                0, Integer.MAX_VALUE, currentProduct.getQuantity());
        qttSpinner.setValueFactory(qttSVF);
        qttSpinner.valueProperty().addListener(new ChangeListener<Integer>() {
            @Override
            public void changed(ObservableValue<? extends Integer> arg0, Integer oldVAlue, Integer newValue) {
                self.currentProduct.setQuantity(newValue);
            }
        });

        // Price Input
        DoubleSpinnerValueFactory priceSVF = new DoubleSpinnerValueFactory(
                0d, Double.MAX_VALUE, currentProduct.getPrice(), 0.01d);
        priceSpinner.setValueFactory(priceSVF);
        priceSpinner.valueProperty().addListener(new ChangeListener<Double>() {
            @Override
            public void changed(ObservableValue<? extends Double> arg0, Double oldVAlue, Double newValue) {
                self.currentProduct.setPrice(newValue);
            }
        });

        // Table
        nameCol.setCellValueFactory(new PropertyValueFactory<ProductEntry, String>("name"));
        priceCol.setCellValueFactory(new PropertyValueFactory<ProductEntry, Double>("price"));
        qttCol.setCellValueFactory(new PropertyValueFactory<ProductEntry, Integer>("quantity"));
        totalCol.setCellValueFactory(new PropertyValueFactory<ProductEntry, Double>("total"));
        table.setItems(list);
    }

}

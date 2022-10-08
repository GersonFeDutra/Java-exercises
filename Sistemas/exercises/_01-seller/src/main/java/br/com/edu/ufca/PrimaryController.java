package br.com.edu.ufca;

import java.net.URL;
import java.util.ResourceBundle;

import org.apache.commons.lang3.StringUtils;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.control.SpinnerValueFactory.DoubleSpinnerValueFactory;
import javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;

/**
 * Sample Skeleton for 'primary.fxml' Controller Class
 */
public class PrimaryController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="nameText"
    private Text nameText; // Value injected by FXMLLoader

    @FXML // fx:id="salaryText"
    private Text salaryText; // Value injected by FXMLLoader

    @FXML // fx:id="commissionText"
    private Text commissionText; // Value injected by FXMLLoader

    @FXML // fx:id="salesSpinner"
    private Spinner<Integer> salesSpinner; // Value injected by FXMLLoader
    @FXML // fx:id="salarySpinner"
    private Spinner<Double> salarySpinner; // Value injected by FXMLLoader

    private static final String NULL_NAME = "Unnamed";
    private Seller seller; // Seller data class

    public void updateSalary() {
        salaryText.setText(String.format("%.2f", seller.getSalary()));
    }

    @FXML
    void onNameKeyTyped(KeyEvent event) {
        String text = ((TextField) event.getSource()).getText();
        seller.name = text.isEmpty() ? NULL_NAME : StringUtils.capitalize(text);
        nameText.setText(seller.name);
    }

    @FXML
    void onSalesKeyTyped(KeyEvent event) {
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert commissionText != null
                : "fx:id=\"commissionText\" was not injected: check your FXML file 'primary.fxml'.";
        assert nameText != null : "fx:id=\"nameText\" was not injected: check your FXML file 'primary.fxml'.";
        assert salarySpinner != null : "fx:id=\"salarySpinner\" was not injected: check your FXML file 'primary.fxml'.";
        assert salaryText != null : "fx:id=\"salaryText\" was not injected: check your FXML file 'primary.fxml'.";
        assert salesSpinner != null : "fx:id=\"salesSpinner\" was not injected: check your FXML file 'primary.fxml'.";

        seller = new Seller(NULL_NAME);

        IntegerSpinnerValueFactory salesSVF = new IntegerSpinnerValueFactory(
                0, Integer.MAX_VALUE, seller.getSalesN());
        salesSpinner.setValueFactory(salesSVF);
        salesSpinner.valueProperty().addListener(new ChangeListener<Integer>() {
            @Override
            public void changed(ObservableValue<? extends Integer> arg0, Integer oldVAlue, Integer newValue) {
                seller.setSalesN(newValue);
                updateSalary();
            }
        });

        DoubleSpinnerValueFactory salarySVF = new DoubleSpinnerValueFactory(
                0d, Double.MAX_VALUE, seller.getSalary(), 0.01d);
        salarySpinner.setValueFactory(salarySVF);
        salarySpinner.valueProperty().addListener(new ChangeListener<Double>() {
            @Override
            public void changed(ObservableValue<? extends Double> arg0, Double oldVAlue, Double newValue) {
                seller.setSalary(newValue);
                updateSalary();
            }
        });
    }

}

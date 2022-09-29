module br.com.edu.ufca {
    requires javafx.controls;
    requires javafx.fxml;

    opens br.com.edu.ufca to javafx.fxml;
    exports br.com.edu.ufca;
    opens br.com.edu.ufca.controllers to javafx.fxml;
    exports br.com.edu.ufca.controllers;

    exports br.com.edu.ufca.label;
}

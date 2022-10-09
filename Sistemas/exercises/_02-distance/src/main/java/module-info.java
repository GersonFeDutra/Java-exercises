module br.com.edu.ufca {
    requires transitive javafx.controls;
    requires javafx.fxml;

    opens br.com.edu.ufca to javafx.fxml;
    exports br.com.edu.ufca;
}

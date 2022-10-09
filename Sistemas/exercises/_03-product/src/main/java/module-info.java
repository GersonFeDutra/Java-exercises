module br.com.edu.ufca {
    requires transitive javafx.controls;
    requires javafx.fxml;
    requires org.apache.commons.lang3;

    opens br.com.edu.ufca to javafx.fxml;
    exports br.com.edu.ufca;
}

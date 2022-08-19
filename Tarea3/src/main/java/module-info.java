module com.unah.calc {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.scripting;


    opens com.unah.calc to javafx.fxml;
    exports com.unah.calc;
}
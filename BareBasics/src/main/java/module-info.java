module com.example.barebasics {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires java.sql;
    requires de.jensd.fx.glyphs.fontawesome;

    opens com.barebasics to javafx.fxml;
    exports com.barebasics;
}
module com.example.alchemillafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.desktop;
    requires java.sql;
    requires javafx.graphics;
    requires javafx.base;

    opens com.example.alchemillafx to javafx.fxml;
    exports com.example.alchemillafx;
}


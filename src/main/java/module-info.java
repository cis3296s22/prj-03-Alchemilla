module com.example.alchemillafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;
    requires javafx.swing;
    requires org.testng;
    requires org.junit.jupiter.api;
    requires junit;

    opens com.example.alchemillafx to javafx.fxml;
    exports com.example.alchemillafx;
}
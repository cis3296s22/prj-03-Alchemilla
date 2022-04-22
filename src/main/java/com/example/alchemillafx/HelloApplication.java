package com.example.alchemillafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Replacement for main class in JavaFX
 * Loads scene and begins program
 */
public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("scene.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        // Get singleton obj and save controller

        HelloController helloC = fxmlLoader.getController();
        DataHolder datahold = DataHolder.getInstance();
        datahold.setController(helloC);

        stage.setTitle("Alchemilla");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}


package com.example.alchemillafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Plant test = new Plant(null,"Dat-Plant",2,2,"Dat-Calcium","Such","Strong Bones");

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("scene.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Alchemilla");
        HelloController c = new HelloController();

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}


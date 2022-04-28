package com.example.alchemillafx;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
// mport javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.text.*;

/**
 * Replacement for main class in JavaFX
 * Loads scene and begins program
 */
public class PlantApplication extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        // Sets Title, Loads the FXML File
        Parent root = FXMLLoader.load(getClass().getResource("plant-form.fxml"));
        primaryStage.setTitle("Enter Plant Information");
        primaryStage.setScene(new Scene(root, 800, 500));
        primaryStage.show();
    }

    public static void main (String[] args)
    {
        Application.launch(args);
    }

}

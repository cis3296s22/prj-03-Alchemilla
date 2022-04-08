package com.example.alchemillafx;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileInputStream;

public class PlantController extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        // Sets Title, Loads the FXML File
        primaryStage.setTitle("Enter Plant Info");
        FXMLLoader loader = new FXMLLoader();
        String path = "@prj-03-Alchemilla/src/resources/com.example.alchemilla/plant-form.fxml";
        FileInputStream stream = new FileInputStream(path);

        // we vboxed up; creates pane and details
        VBox box = new VBox(loader.load(stream));

        Scene scene = new Scene(box, 2000, 2000); // arbitrary numbers
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public static void main (String[] args)
    {
        Application.launch(args);
    }
}

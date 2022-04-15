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

// import java.awt.image.BufferedImage;
import java.io.*;
// import javax.imageio.ImageIO;
public class PlantApplication extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        // Sets Title, Loads the FXML File
        primaryStage.setTitle("Enter Plant Info");
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("scene.fxml"));
        String path = "@prj-03-Alchemilla/src/resources/com.example.alchemilla/plant-form.fxml";
        FileInputStream stream = new FileInputStream(path);

        // we vboxed up; creates pane and details
        VBox box = new VBox(loader.load(stream));

        Scene scene = new Scene(box, 2000, 2000); // arbitrary numbers
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main (String[] args)
    {
        Application.launch(args);
    }

}
